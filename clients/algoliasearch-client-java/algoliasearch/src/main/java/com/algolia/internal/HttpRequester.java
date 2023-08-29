package com.algolia.internal;

import com.algolia.config.*;
import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaClientException;
import com.algolia.internal.interceptors.GzipRequestInterceptor;
import com.algolia.internal.interceptors.HeaderInterceptor;
import com.algolia.internal.interceptors.LogInterceptor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import okhttp3.*;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HttpRequester implements Requester {

  private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");
  private final OkHttpClient httpClient;

  private final JsonSerializer serializer;
  private boolean isClosed = false;

  private HttpRequester(Builder builder, ClientConfig config) {
    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
      .connectTimeout(config.getConnectTimeout())
      .readTimeout(config.getReadTimeout())
      .writeTimeout(config.getWriteTimeout())
      .addInterceptor(new HeaderInterceptor(config.getDefaultHeaders()))
      .addNetworkInterceptor(new LogInterceptor(config.getLogger(), config.getLogLevel()));
    builder.interceptors.forEach(clientBuilder::addInterceptor);
    builder.networkInterceptors.forEach(clientBuilder::addNetworkInterceptor);
    if (config.getCompressionType() == CompressionType.GZIP) {
      clientBuilder.addInterceptor(new GzipRequestInterceptor());
    }
    if (builder.clientConfig != null) {
      builder.clientConfig.accept(clientBuilder);
    }
    this.httpClient = clientBuilder.build();
    this.serializer = builder.serializer;
  }

  @Override
  public <T> T execute(HttpRequest httpRequest, RequestOptions requestOptions, Class<?> returnType, Class<?> innerType) {
    return execute(httpRequest, requestOptions, serializer.getJavaType(returnType, innerType));
  }

  @Override
  public <T> T execute(HttpRequest httpRequest, RequestOptions requestOptions, TypeReference<?> returnType) {
    return execute(httpRequest, requestOptions, serializer.getJavaType(returnType));
  }

  private <T> T execute(HttpRequest httpRequest, RequestOptions requestOptions, JavaType returnType) {
    if (isClosed) {
      throw new IllegalStateException("HttpRequester is closed");
    }

    HttpUrl url = buildHttpUrl(httpRequest, requestOptions);
    Headers headers = buildHeaders(httpRequest, requestOptions);
    RequestBody requestBody = buildRequestBody(httpRequest);
    Request request = new Request.Builder().url(url).headers(headers).method(httpRequest.getMethod(), requestBody).build();
    Call call = httpClient.newCall(request);
    try (Response response = call.execute()) {
      if (!response.isSuccessful()) {
        throw new AlgoliaApiException(response.message(), response.code());
      }
      if (returnType == null || response.body() == null || response.body().contentLength() == 0) {
        return null; // No need to deserialize, either no content or no type provided
      }
      return serializer.deserialize(response.body().byteStream(), returnType);
    } catch (IOException exception) {
      throw new AlgoliaClientException(exception);
    }
  }

  private RequestBody buildRequestBody(HttpRequest httpRequest) {
    String method = httpRequest.getMethod();
    Object body = httpRequest.getBody();
    if (!HttpMethod.permitsRequestBody(method) || (method.equals("DELETE") && body == null)) {
      return null;
    }
    if (body == null) {
      body = HttpMethod.requiresRequestBody(method) ? Collections.emptyMap() : "";
    }
    return createRequestBody(body);
  }

  @NotNull
  private RequestBody createRequestBody(Object requestBody) {
    return new RequestBody() {
      @Nullable
      @Override
      public MediaType contentType() {
        return JSON_MEDIA_TYPE;
      }

      @Override
      public void writeTo(@NotNull BufferedSink bufferedSink) {
        serializer.serialize(bufferedSink.outputStream(), requestBody);
      }
    };
  }

  @NotNull
  private Headers buildHeaders(HttpRequest request, RequestOptions requestOptions) {
    Headers.Builder builder = new Headers.Builder();
    request.getHeaders().forEach(builder::add);
    requestOptions.getHeaders().forEach(builder::add);
    return builder.build();
  }

  @NotNull
  private static HttpUrl buildHttpUrl(HttpRequest request, RequestOptions requestOptions) {
    HttpUrl.Builder urlBuilder = new HttpUrl.Builder().addPathSegments(request.getPath());
    request.getQueryParameters().forEach(urlBuilder::addQueryParameter);
    requestOptions.getQueryParameters().forEach(urlBuilder::addQueryParameter);
    return urlBuilder.build();
  }

  @Override
  public void close() throws IOException {
    if (isClosed) throw new IllegalStateException("HttpRequester is already closed");
    httpClient.dispatcher().executorService().shutdown();
    httpClient.connectionPool().evictAll();
    if (httpClient.cache() != null) {
      httpClient.cache().close();
    }
    isClosed = true;
  }

  public static class Builder {

    private final List<Interceptor> interceptors = new ArrayList<>();

    private final List<Interceptor> networkInterceptors = new ArrayList<>();

    private Consumer<OkHttpClient.Builder> clientConfig;

    private final JsonSerializer serializer;

    public Builder(JsonSerializer serializer) {
      this.serializer = serializer;
    }

    public Builder addInterceptor(Interceptor interceptor) {
      interceptors.add(interceptor);
      return this;
    }

    public Builder addNetworkInterceptor(Interceptor interceptor) {
      networkInterceptors.add(interceptor);
      return this;
    }

    public Builder setHttpClientConfig(Consumer<OkHttpClient.Builder> config) {
      this.clientConfig = config;
      return this;
    }

    public HttpRequester build(ClientConfig config) {
      return new HttpRequester(this, config);
    }
  }
}
