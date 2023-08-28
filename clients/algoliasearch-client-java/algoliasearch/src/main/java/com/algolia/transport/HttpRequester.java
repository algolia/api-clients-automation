package com.algolia.transport;

import com.algolia.config.*;
import com.algolia.transport.interceptors.GzipRequestInterceptor;
import com.algolia.transport.interceptors.HeaderInterceptor;
import com.algolia.transport.interceptors.LogInterceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import okhttp3.*;

public final class HttpRequester implements Requester {

  private final OkHttpClient httpClient;
  private boolean isClosed = false;

  private HttpRequester(Builder builder, ClientConfig config) {
    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
      .connectTimeout(config.getConnectTimeout())
      .readTimeout(config.getReadTimeout())
      .writeTimeout(config.getWriteTimeout())
      .addInterceptor(new HeaderInterceptor(config.getDefaultHeaders()))
      .addInterceptor(new LogInterceptor(config.getLogger(), config.getLogLevel()));

    if (!builder.interceptors.isEmpty()) {
      builder.interceptors.forEach(clientBuilder::addInterceptor);
    }
    if (config.getCompressionType() == CompressionType.GZIP) {
      GzipRequestInterceptor gzip = new GzipRequestInterceptor();
      clientBuilder.addInterceptor(gzip);
    }
    if (builder.clientConfig != null) {
      builder.clientConfig.accept(clientBuilder);
    }
    this.httpClient = clientBuilder.build();
  }

  @Override
  public Call newCall(Request request) {
    if (isClosed) throw new IllegalStateException("HttpRequester is closed");
    return httpClient.newCall(request);
  }

  @Override
  public void close() throws Exception {
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

    private Consumer<OkHttpClient.Builder> clientConfig;

    public Builder addInterceptor(Interceptor interceptor) {
      interceptors.add(interceptor);
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
