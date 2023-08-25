package com.algolia.transport.interceptors;

import com.algolia.config.CallType;
import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaClientException;
import com.algolia.exceptions.AlgoliaRequestException;
import com.algolia.exceptions.AlgoliaRetryException;
import com.algolia.transport.StatefulHost;
import com.algolia.utils.DateTimeUtils;
import com.algolia.utils.UseReadTransporter;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public final class RetryStrategy implements Interceptor {

  private final List<StatefulHost> hosts;

  public RetryStrategy(List<StatefulHost> hosts) {
    this.hosts = hosts;
  }

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) {
    Request request = chain.request();
    UseReadTransporter useReadTransporter = (UseReadTransporter) request.tag();
    CallType callType = (useReadTransporter != null || request.method().equals("GET")) ? CallType.READ : CallType.WRITE;
    List<Throwable> errors = new ArrayList<>();
    for (StatefulHost currentHost : getTriableHosts(callType)) {
      try {
        return processRequest(chain, request, currentHost);
      } catch (Exception e) {
        errors.add(e);
        handleException(currentHost, e);
      }
    }
    throw new AlgoliaRetryException(errors);
  }

  @NotNull
  private Response processRequest(@NotNull Chain chain, @NotNull Request request, StatefulHost host) throws IOException {
    // Building the request URL
    HttpUrl newUrl = request.url().newBuilder().scheme(host.getScheme()).host(host.getHost()).build();
    Request newRequest = request.newBuilder().url(newUrl).build();
    // Computing timeout with the retry count
    chain.withConnectTimeout(chain.connectTimeoutMillis() * (host.getRetryCount() + 1), TimeUnit.MILLISECONDS);
    Response response = chain.proceed(newRequest);
    host.setLastUse(DateTimeUtils.nowUTC());
    return handleResponse(host, response);
  }

  @NotNull
  private Response handleResponse(StatefulHost host, @NotNull Response response) throws IOException {
    if (response.isSuccessful()) {
      host.setUp(true);
      return response;
    } else if (isRetryable(response)) {
      host.setUp(false);
      response.close();
      String message = (response.body() != null) ? response.body().string() : response.message();
      throw new AlgoliaRequestException(message, response.code());
    } else {
      String message = (response.body() != null) ? response.body().string() : response.message();
      throw new AlgoliaApiException(message, response.code());
    }
  }

  private boolean isRetryable(@NotNull Response response) {
    int statusCode = response.code();
    return (statusCode < 200 || statusCode >= 300) && (statusCode < 400 || statusCode >= 500);
  }

  private void handleException(StatefulHost host, Exception exception) {
    if (exception instanceof SocketTimeoutException) {
      host.setUp(true);
      host.setLastUse(DateTimeUtils.nowUTC());
      host.incrementRetryCount();
    } else if (exception instanceof AlgoliaRequestException || exception instanceof IOException) {
      host.setUp(false);
      host.setLastUse(DateTimeUtils.nowUTC());
    } else if (exception instanceof AlgoliaApiException) {
      throw (AlgoliaApiException) exception;
    } else {
      throw new AlgoliaClientException(exception);
    }
  }

  private synchronized List<StatefulHost> getTriableHosts(CallType callType) {
    resetExpiredHosts();
    List<StatefulHost> triableHosts = hosts.stream().filter(h -> h.getAccept().contains(callType)).collect(Collectors.toList());
    if (triableHosts.stream().anyMatch(StatefulHost::isUp)) {
      return triableHosts.stream().filter(StatefulHost::isUp).collect(Collectors.toList());
    } else {
      triableHosts.forEach(this::reset);
      return hosts;
    }
  }

  private void resetExpiredHosts() {
    for (StatefulHost host : hosts) {
      long lastUse = Duration.between(DateTimeUtils.nowUTC(), host.getLastUse()).getSeconds();
      if (!host.isUp() && Math.abs(lastUse) > 5 * 60) {
        reset(host);
      }
    }
  }

  private void reset(@NotNull StatefulHost host) {
    host.setUp(true).resetCount().setLastUse(DateTimeUtils.nowUTC());
  }
}
