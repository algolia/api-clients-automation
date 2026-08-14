package com.algolia;

import com.algolia.config.*;
import com.algolia.exceptions.AlgoliaRuntimeException;
import com.algolia.internal.HttpRequester;
import com.algolia.internal.JsonSerializer;
import com.algolia.internal.RequestId;
import com.algolia.internal.StatefulHost;
import com.algolia.internal.interceptors.AuthInterceptor;
import com.algolia.internal.interceptors.HeaderInterceptor;
import com.algolia.internal.interceptors.RequestIdInterceptor;
import com.algolia.internal.interceptors.RetryStrategy;
import com.algolia.internal.interceptors.UserAgentInterceptor;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.Closeable;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a base client for making API requests. The client uses a {@link Requester} for
 * executing requests and an {@link ExecutorService} for asynchronous operations. It is designed to
 * be extended by concrete API client implementations.
 */
public abstract class ApiClient implements Closeable {

  private final Requester requester;
  private final ExecutorService executor;
  private final boolean requestIdSupport;
  public final ClientOptions clientOptions;
  public AuthInterceptor authInterceptor;

  /** Constructs a new instance of the {@link ApiClient}, without Request-ID support. */
  protected ApiClient(
    String appId,
    String apiKey,
    String clientName,
    @Nullable ClientOptions options,
    List<Host> defaultHosts,
    Duration connectTimeout,
    Duration readTimeout,
    Duration writeTimeout
  ) {
    this(appId, apiKey, clientName, options, defaultHosts, connectTimeout, readTimeout, writeTimeout, false);
  }

  /**
   * Constructs a new instance of the {@link ApiClient}.
   *
   * @param requestIdSupport Whether the API this client targets accepts a `Request-ID`.
   */
  protected ApiClient(
    String appId,
    String apiKey,
    String clientName,
    @Nullable ClientOptions options,
    List<Host> defaultHosts,
    Duration connectTimeout,
    Duration readTimeout,
    Duration writeTimeout,
    boolean requestIdSupport
  ) {
    this.requestIdSupport = requestIdSupport;
    if (appId == null || appId.isEmpty()) {
      throw new AlgoliaRuntimeException("`appId` is missing.");
    }
    if (apiKey == null || apiKey.isEmpty()) {
      throw new AlgoliaRuntimeException("`apiKey` is missing.");
    }
    clientOptions = options != null ? options : new ClientOptions();
    executor = clientOptions.getExecutor();
    requester =
      clientOptions.getCustomRequester() != null
        ? clientOptions.getCustomRequester()
        : defaultRequester(appId, apiKey, clientName, clientOptions, defaultHosts, connectTimeout, readTimeout, writeTimeout);
  }

  /** Creates a default {@link Requester} for executing API requests. */
  private Requester defaultRequester(
    String appId,
    String apiKey,
    String clientName,
    ClientOptions options,
    List<Host> defaultHosts,
    Duration connectTimeout,
    Duration readTimeout,
    Duration writeTimeout
  ) {
    AlgoliaAgent algoliaAgent = new AlgoliaAgent(BuildConfig.VERSION)
      .addSegment(new AlgoliaAgent.Segment(clientName, BuildConfig.VERSION))
      .addSegments(options.getAlgoliaAgentSegments());

    List<Host> hosts = options.getHosts() != null && !options.getHosts().isEmpty() ? options.getHosts() : defaultHosts;
    List<StatefulHost> statefulHosts = hosts.stream().map(StatefulHost::new).collect(Collectors.toList());

    JsonSerializer serializer = JsonSerializer.builder().setCustomConfig(options.getMapperConfig()).build();
    this.authInterceptor = new AuthInterceptor(appId, apiKey);
    HttpRequester.Builder builder = new HttpRequester.Builder(serializer)
      .addInterceptor(authInterceptor)
      .addInterceptor(new HeaderInterceptor(options.getDefaultHeaders()))
      .addInterceptor(new UserAgentInterceptor(algoliaAgent));
    if (requestIdSupport) {
      builder.addInterceptor(new RequestIdInterceptor());
    }
    builder
      .addInterceptor(new RetryStrategy(statefulHosts))
      .setConnectTimeout(connectTimeout)
      .setReadTimeout(readTimeout)
      .setWriteTimeout(writeTimeout);
    if (options.getRequesterConfig() != null) {
      options.getRequesterConfig().accept(builder);
    }
    return builder.build(options);
  }

  /**
   * Helper method to switch the API key used to authenticate the requests.
   *
   * @param apiKey The new API key to be used from now on.
   */
  public void setClientApiKey(@Nonnull String apiKey) {
    this.authInterceptor.setApiKey(apiKey);
  }

  /**
   * Returns request options carrying a `Request-ID`, so that every request a multi-request helper
   * performs shares the same one. Returns the given options unchanged when this client does not
   * support Request-ID or when the caller already supplied one, per request or through default
   * headers.
   */
  protected RequestOptions withRequestId(@Nullable RequestOptions requestOptions) {
    if (!requestIdSupport || RequestId.isPresent(requestOptions) || RequestId.isPresent(clientOptions.getDefaultHeaders())) {
      return requestOptions;
    }
    return new RequestOptions().addExtraHeader(RequestId.HEADER, RequestId.generate()).mergeRight(requestOptions);
  }

  /**
   * Executes an HTTP request asynchronously and returns a {@link CompletableFuture} of the response
   * deserialized into a specified type.
   */
  protected <T> CompletableFuture<T> executeAsync(HttpRequest httpRequest, RequestOptions requestOptions, TypeReference<T> returnType) {
    return CompletableFuture.supplyAsync(() -> requester.execute(httpRequest, requestOptions, returnType), executor);
  }

  /**
   * Executes an HTTP request asynchronously and returns a {@link CompletableFuture} of the response
   * deserialized into a specified type.
   */
  protected <T> CompletableFuture<T> executeAsync(
    HttpRequest httpRequest,
    RequestOptions requestOptions,
    Class<?> returnType,
    Class<?> innerType
  ) {
    return CompletableFuture.supplyAsync(() -> requester.execute(httpRequest, requestOptions, returnType, innerType), executor);
  }

  @Override
  public void close() throws IOException {
    executor.shutdown();
    requester.close();
  }
}
