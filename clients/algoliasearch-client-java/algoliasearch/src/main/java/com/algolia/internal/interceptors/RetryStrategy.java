package com.algolia.internal.interceptors;

import com.algolia.config.CallType;
import com.algolia.config.ClientOptions;
import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaClientException;
import com.algolia.exceptions.AlgoliaRequestException;
import com.algolia.exceptions.AlgoliaRetryException;
import com.algolia.internal.StatefulHost;
import com.algolia.utils.DateTimeUtils;
import com.algolia.utils.UseReadTransporter;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A retry strategy that implements {@link Interceptor}, responsible for routing requests to hosts
 * based on their state and call type.
 */
public final class RetryStrategy implements Interceptor {

  /** Threshold duration after which a host is considered expired. */
  private static final long EXPIRATION_THRESHOLD_SECONDS = 5 * 60;

  private static final int RATE_LIMIT_STATUS_CODE = 429;

  private static final String RATE_LIMIT_REASON_PHRASE = "Too Many Requests";

  private static final long DEFAULT_RATE_LIMIT_WAIT_MILLIS = 1000L;

  private static final Pattern WHOLE_SECONDS = Pattern.compile("\\d+");

  /** The list of stateful hosts to route requests to. */
  private final List<StatefulHost> hosts;

  /** How many times to wait and retry on the same host after HTTP 429. */
  private final int maxRateLimitRetries;

  /**
   * @param hosts List of stateful hosts.
   */
  public RetryStrategy(List<StatefulHost> hosts) {
    this(hosts, ClientOptions.DEFAULT_MAX_RATE_LIMIT_RETRIES);
  }

  /**
   * @param hosts List of stateful hosts.
   * @param maxRateLimitRetries How many times to wait and retry on the same host after HTTP 429.
   */
  public RetryStrategy(List<StatefulHost> hosts, int maxRateLimitRetries) {
    this.hosts = Collections.unmodifiableList(hosts);
    this.maxRateLimitRetries = maxRateLimitRetries;
  }

  @Nonnull
  @Override
  public Response intercept(@Nonnull Chain chain) {
    Request request = chain.request();
    UseReadTransporter useReadTransporter = (UseReadTransporter) request.tag();
    CallType callType = useReadTransporter != null || request.method().equals("GET") ? CallType.READ : CallType.WRITE;
    List<Throwable> errors = new ArrayList<>();
    int rateLimitRetriesLeft = maxRateLimitRetries;
    for (StatefulHost currentHost : callableHosts(callType)) {
      try {
        Response response = processRequest(chain, request, currentHost);
        while (isRateLimited(response) && rateLimitRetriesLeft > 0) {
          rateLimitRetriesLeft--;
          long waitMillis = rateLimitWaitMillis(response.header("Retry-After"));
          errors.add(rateLimitError(response));
          response.close();
          sleep(waitMillis);
          response = processRequest(chain, request, currentHost);
        }
        return handleResponse(currentHost, response);
      } catch (Exception e) {
        errors.add(e);
        handleException(currentHost, e);
      }
    }
    throw new AlgoliaRetryException(errors);
  }

  /** Sends the request to a given host. */
  @Nonnull
  private Response processRequest(@Nonnull Chain chain, @Nonnull Request request, StatefulHost host) throws IOException {
    HttpUrl.Builder urlBuilder = request.url().newBuilder().scheme(host.getScheme()).host(host.getHost());
    if (host.getPort() != -1) {
      urlBuilder.port(host.getPort());
    }
    HttpUrl newUrl = urlBuilder.build();
    Request newRequest = request.newBuilder().url(newUrl).build();
    chain.withConnectTimeout(chain.connectTimeoutMillis() * (host.getRetryCount() + 1), TimeUnit.MILLISECONDS);
    return chain.proceed(newRequest);
  }

  /** Handles the response from the host. */
  @Nonnull
  private Response handleResponse(StatefulHost host, @Nonnull Response response) throws IOException {
    if (response.isSuccessful()) {
      host.reset();
      return response;
    }

    try {
      String message = response.body() != null ? response.body().string() : response.message();
      if (response.header("Content-Type", "application/json").contains("text/html")) {
        message = response.message();
      }
      String correlationId = response.header("Correlation-ID");
      throw isRetryable(response)
        ? new AlgoliaRequestException(message, response.code(), correlationId)
        : new AlgoliaApiException(message, response.code(), correlationId);
    } finally {
      response.close();
    }
  }

  /** Determines if a response should be retried. */
  private boolean isRetryable(@Nonnull Response response) {
    int statusCode = response.code();
    return (statusCode < 200 || statusCode >= 300) && (statusCode < 400 || statusCode >= 500);
  }

  /** Determines if a response was rate limited. */
  private static boolean isRateLimited(@Nonnull Response response) {
    return response.code() == RATE_LIMIT_STATUS_CODE;
  }

  /** The waited-out 429 as recorded among the retry errors. */
  private static AlgoliaApiException rateLimitError(@Nonnull Response response) {
    String reason = response.message().isEmpty() ? RATE_LIMIT_REASON_PHRASE : response.message();
    return new AlgoliaApiException(reason, response.code(), response.header("Correlation-ID"));
  }

  /**
   * `Retry-After` as milliseconds. Only a positive whole number of seconds is honored, any other
   * value waits 1 second; a value too large to represent waits {@link Long#MAX_VALUE} milliseconds.
   */
  private static long rateLimitWaitMillis(@Nullable String retryAfter) {
    String seconds = retryAfter == null ? "" : retryAfter.trim();
    if (!WHOLE_SECONDS.matcher(seconds).matches()) {
      return DEFAULT_RATE_LIMIT_WAIT_MILLIS;
    }
    try {
      long value = Long.parseLong(seconds);
      return value > 0 ? Math.multiplyExact(value, 1000L) : DEFAULT_RATE_LIMIT_WAIT_MILLIS;
    } catch (NumberFormatException | ArithmeticException e) {
      return Long.MAX_VALUE;
    }
  }

  /** Blocks the calling thread, aborting the call when interrupted. */
  private static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new AlgoliaClientException(e);
    }
  }

  /** Handles exceptions that occurred during request processing. */
  private void handleException(StatefulHost host, Exception exception) {
    if (exception instanceof SocketTimeoutException) {
      host.hasTimedOut();
    } else if (exception instanceof AlgoliaRequestException || exception instanceof IOException) {
      host.hasFailed();
    } else if (exception instanceof AlgoliaApiException) {
      throw (AlgoliaApiException) exception;
    } else if (exception instanceof AlgoliaClientException) {
      throw (AlgoliaClientException) exception;
    } else {
      throw new AlgoliaClientException(exception);
    }
  }

  /** Fetches a list of hosts that can be used for a specific call type. */
  private synchronized List<StatefulHost> callableHosts(CallType callType) {
    resetExpiredHosts();
    List<StatefulHost> hostsCallType = hosts
      .stream()
      .filter(h -> h.getAccept().contains(callType))
      .collect(Collectors.toList());
    List<StatefulHost> hostsCallTypeAreUp = hostsCallType.stream().filter(StatefulHost::isUp).collect(Collectors.toList());
    if (hostsCallTypeAreUp.isEmpty()) {
      hostsCallType.forEach(StatefulHost::reset);
      return hostsCallType;
    }
    return hostsCallTypeAreUp;
  }

  /** Resets hosts that have been down for longer than the defined expiration threshold. */
  private void resetExpiredHosts() {
    OffsetDateTime now = DateTimeUtils.nowUTC();
    for (StatefulHost host : hosts) {
      long lastUse = Duration.between(host.getLastUse(), now).getSeconds();
      if (!host.isUp() && lastUse > EXPIRATION_THRESHOLD_SECONDS) {
        host.reset();
      }
    }
  }
}
