package com.algolia;

import com.algolia.config.*;
import com.algolia.exceptions.*;
import com.algolia.transport.HttpRequester;
import com.algolia.transport.StatefulHost;
import com.algolia.transport.interceptors.AuthInterceptor;
import com.algolia.transport.interceptors.RetryStrategy;
import com.algolia.transport.interceptors.UserAgentInterceptor;
import com.algolia.utils.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import okhttp3.*;
import okhttp3.internal.http.HttpMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ApiClient implements AutoCloseable {

  private final Requester requester;
  private final JsonSerializer serializer;

  protected ApiClient(String appId, String apiKey, String clientName, @Nullable ClientOptions options, List<Host> defaultHosts) {
    if (appId == null || appId.isEmpty()) {
      throw new AlgoliaRuntimeException("`appId` is missing.");
    }
    if (apiKey == null || apiKey.isEmpty()) {
      throw new AlgoliaRuntimeException("`apiKey` is missing.");
    }
    ClientOptions clientOptions = options != null ? options : new ClientOptions();
    ObjectMapper mapper = new JsonConfig().setCustomConfig(clientOptions.getMapperConfig()).build();
    this.serializer = new JsonSerializer(mapper);
    this.requester =
      clientOptions.getCustomRequester() != null
        ? clientOptions.getCustomRequester()
        : defaultRequester(appId, apiKey, clientName, clientOptions, defaultHosts);
  }

  private Requester defaultRequester(String appId, String apiKey, String clientName, ClientOptions options, List<Host> defaultHosts) {
    AlgoliaAgent algoliaAgent = new AlgoliaAgent(BuildConfig.VERSION)
      .addSegment(new AlgoliaAgent.Segment(clientName, BuildConfig.VERSION))
      .addSegments(options.getAlgoliaAgentSegments());

    List<Host> hosts = options.getHosts() != null && !options.getHosts().isEmpty() ? options.getHosts() : defaultHosts;
    List<StatefulHost> statefulHosts = hosts.stream().map(StatefulHost::new).collect(Collectors.toList());

    HttpRequester.Builder builder = new HttpRequester.Builder()
      .addInterceptor(new AuthInterceptor(appId, apiKey))
      .addInterceptor(new UserAgentInterceptor(algoliaAgent))
      .addInterceptor(new RetryStrategy(statefulHosts));
    if (options.getRequesterConfig() != null) {
      options.getRequesterConfig().accept(builder);
    }
    return builder.build(options);
  }

  /**
   * Format the given parameter object into string.
   *
   * @param param Parameter
   * @return String representation of the parameter
   */
  public String parameterToString(Object param) throws UnsupportedOperationException {
    if (param == null) {
      return "";
    } else if (param instanceof Date || param instanceof OffsetDateTime || param instanceof LocalDate) {
      // note: date comes as string for now, we should never have to serialize one
      // maybe we could accept them as Date object and in that case use jackson serialization
      throw new UnsupportedOperationException("Date must come as string (already serialized)");
    } else if (param instanceof Collection) {
      StringJoiner b = new StringJoiner(",");
      for (Object o : (Collection) param) {
        b.add(String.valueOf(o));
      }
      return b.toString();
    } else {
      return String.valueOf(param);
    }
  }

  /**
   * Escape the given string to be used as URL query value.
   *
   * @param str String to be escaped
   * @return Escaped string
   */
  public String escapeString(String str) {
    try {
      return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
    } catch (UnsupportedEncodingException e) {
      return str;
    }
  }

  /**
   * Execute HTTP call asynchronously.
   *
   * @param <T> Type
   * @param returnType Return type
   */
  public <T> CompletableFuture<T> executeAsync(Call call, final JavaType returnType) {
    final CompletableFuture<T> future = new CompletableFuture<>();
    call.enqueue(getCallback(returnType, future));
    return future;
  }

  @NotNull
  private <T> Callback getCallback(JavaType returnType, CompletableFuture<T> future) {
    return new Callback() {
      @Override
      public void onFailure(@NotNull Call call, @NotNull IOException e) {
        future.completeExceptionally(e);
      }

      @Override
      public void onResponse(@NotNull Call call, @NotNull Response response) {
        try {
          T result = serializer.deserialize(response, returnType);
          future.complete(result);
        } catch (AlgoliaRuntimeException e) {
          future.completeExceptionally(e);
        } catch (Exception e) {
          future.completeExceptionally(new AlgoliaRuntimeException(e));
        }
      }
    };
  }

  public <T> CompletableFuture<T> executeAsync(Call call, final Class<?> returnType, final Class<?> innerType) {
    return executeAsync(call, serializer.getJavaType(returnType, innerType));
  }

  public <T> CompletableFuture<T> executeAsync(Call call, final TypeReference<?> returnType) {
    return executeAsync(call, serializer.getJavaType(returnType));
  }

  /**
   * Build HTTP call with the given options.
   *
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "HEAD", "OPTIONS", "POST", "PUT", "PATCH" and
   *     "DELETE"
   * @param queryParameters The query parameters
   * @param body The request body object
   * @param headerParams The header parameters
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @param useReadTransporter Some POST methods in the Algolia REST API uses the `read`
   *     transporter. This information is defined at the spec level.
   * @return The HTTP call
   * @throws AlgoliaRuntimeException If fail to serialize the request body object
   */
  public Call buildCall(
    String path,
    String method,
    Map<String, Object> queryParameters,
    Object body,
    Map<String, String> headerParams,
    RequestOptions requestOptions,
    boolean useReadTransporter
  ) throws AlgoliaRuntimeException {
    Request request = buildRequest(path, method, queryParameters, body, headerParams, requestOptions, useReadTransporter);

    return requester.newCall(request);
  }

  /**
   * Build an HTTP request with the given options.
   *
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "HEAD", "OPTIONS", "POST", "PUT", "PATCH" and
   *     "DELETE"
   * @param queryParameters The query parameters
   * @param body The request body object
   * @param headerParams The header parameters
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @param useReadTransporter Some POST methods in the Algolia REST API uses the `read`
   *     transporter. This information is defined at the spec level.
   * @return The HTTP request
   * @throws AlgoliaRuntimeException If fail to serialize the request body object
   */
  public Request buildRequest(
    String path,
    String method,
    Map<String, Object> queryParameters,
    Object body,
    Map<String, String> headerParams,
    RequestOptions requestOptions,
    boolean useReadTransporter
  ) throws AlgoliaRuntimeException {
    boolean hasRequestOptions = requestOptions != null;
    final String url = buildUrl(path, queryParameters, hasRequestOptions ? requestOptions.getExtraQueryParameters() : null);
    final Request.Builder reqBuilder = new Request.Builder().url(url);
    processHeaderParams(headerParams, hasRequestOptions ? requestOptions.getExtraHeaders() : null, reqBuilder);

    RequestBody reqBody;
    // We rely on `permitsRequestBody` to tell us if we should provide a body
    // but also set it for DELETE methods
    if (!HttpMethod.permitsRequestBody(method) || (method.equals("DELETE") && body == null)) {
      reqBody = null;
    } else if (body != null) {
      reqBody = serializer.serialize(body);
    } else if (HttpMethod.requiresRequestBody(method)) {
      reqBody = serializer.serialize(Collections.emptyMap());
    } else {
      reqBody = serializer.serialize("");
    }

    if (useReadTransporter) {
      reqBuilder.tag(new UseReadTransporter());
    }

    return reqBuilder.method(method, reqBody).build();
  }

  /**
   * Build full URL by concatenating base path, the given sub path and query parameters.
   *
   * @param path The sub path
   * @param queryParameters The query parameters
   * @param extraQueryParameters The query parameters, coming from the requestOptions
   * @return The full URL
   */
  public String buildUrl(String path, Map<String, Object> queryParameters, Map<String, Object> extraQueryParameters) {
    if (extraQueryParameters != null) {
      for (Entry<String, Object> param : extraQueryParameters.entrySet()) {
        queryParameters.put(param.getKey(), param.getValue());
      }
    }

    final StringBuilder url = new StringBuilder();

    // The real host will be assigned by the retry strategy
    url.append("https://algolia.com").append(path);

    if (queryParameters != null && !queryParameters.isEmpty()) {
      // support (constant) query string in `path`, e.g. "/posts?draft=1"
      String prefix = path.contains("?") ? "&" : "?";
      for (Entry<String, Object> param : queryParameters.entrySet()) {
        if (param.getValue() != null) {
          if (prefix != null) {
            url.append(prefix);
            prefix = null;
          } else {
            url.append("&");
          }
          String value = parameterToString(param.getValue());
          url.append(escapeString(param.getKey())).append("=").append(escapeString(value));
        }
      }
    }

    return url.toString();
  }

  /**
   * Set header parameters to the request builder, including default headers.
   *
   * @param headerParams Header parameters in the form of Map
   * @param extraHeaderParams Header parameters in the form of Map, coming from RequestOptions
   * @param reqBuilder Request.Builder
   */
  public void processHeaderParams(Map<String, String> headerParams, Map<String, String> extraHeaderParams, Request.Builder reqBuilder) {
    for (Entry<String, String> param : headerParams.entrySet()) {
      reqBuilder.header(param.getKey().toLowerCase(), parameterToString(param.getValue()));
    }
    if (extraHeaderParams != null) {
      for (Entry<String, String> header : extraHeaderParams.entrySet()) {
        reqBuilder.header(header.getKey().toLowerCase(), parameterToString(header.getValue()));
      }
    }
  }

  @Override
  public void close() throws Exception {
    requester.close();
  }
}
