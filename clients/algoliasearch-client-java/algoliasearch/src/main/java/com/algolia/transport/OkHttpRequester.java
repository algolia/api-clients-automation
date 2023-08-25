package com.algolia.transport;

import com.algolia.config.*;
import com.algolia.exceptions.*;
import com.algolia.transport.interceptors.GzipRequestInterceptor;
import com.algolia.transport.interceptors.HeaderInterceptor;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

public final class OkHttpRequester implements Requester {
  private final OkHttpClient httpClient;
  private final ObjectMapper json;
  private boolean isClosed = false;

  private OkHttpRequester(Builder builder) {
    HttpLoggingInterceptor.Logger logger = builder.config.getLogger() != null
            ? okhttpLogger(builder.config.getLogger())
            : HttpLoggingInterceptor.Logger.DEFAULT;
    HttpLoggingInterceptor.Level level = okhttpLogLevel(builder.config.getLogLevel());

    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
      .connectTimeout(builder.config.getConnectTimeout())
      .readTimeout(builder.config.getReadTimeout())
      .writeTimeout(builder.config.getWriteTimeout())
      .addInterceptor(new HeaderInterceptor(builder.config.getDefaultHeaders()))
      .addInterceptor(new HttpLoggingInterceptor(logger).setLevel(level));

    if (!builder.interceptors.isEmpty()) {
      builder.interceptors.forEach(clientBuilder::addInterceptor);
    }
    if (builder.config.getCompressionType() == CompressionType.GZIP) {
      GzipRequestInterceptor gzip = new GzipRequestInterceptor();
      clientBuilder.addInterceptor(gzip);
    }
    if (builder.clientConfig != null) {
      builder.clientConfig.accept(clientBuilder);
    }
    this.httpClient = clientBuilder.build();
    this.json = new JSONBuilder().setConfig(builder.mapperConfig).build();
  }

  private HttpLoggingInterceptor.Logger okhttpLogger(@NotNull Logger logger) {
    return logger::log;
  }

  private HttpLoggingInterceptor.Level okhttpLogLevel(@NotNull LogLevel logLevel) {
    switch (logLevel) {
      case NONE:
          return HttpLoggingInterceptor.Level.NONE;
      case BODY:
        return HttpLoggingInterceptor.Level.BODY;
      case BASIC:
        return HttpLoggingInterceptor.Level.BASIC;
      case HEADERS:
        return HttpLoggingInterceptor.Level.HEADERS;
      default:
        throw new UnsupportedOperationException("Unsupported LogLevel " + logLevel);
    }
  }

  @Override
  public Call newCall(Request request) {
    if (isClosed) throw new IllegalStateException("HttpRequester is closed");
    return httpClient.newCall(request);
  }

  @Override
  public <T> T handleResponse(Response response, JavaType returnType) {
    try (ResponseBody responseBody = response.body()) {
      if (response.isSuccessful()) {
        if (returnType == null || responseBody == null) {
          return null; // No need to deserialize, either no content or no type provided
        }
        return deserialize(response, returnType);
      }
      throw new AlgoliaApiException(response.message(), response.code());
    } catch (Exception e) {
      throw new AlgoliaApiException(response.message(), e, response.code());
    }
  }

  private <T> T deserialize(Response response, JavaType returnType) throws AlgoliaRuntimeException {
    if (response == null || returnType == null || response.body() == null) {
      return null;
    }

    try (ResponseBody responseBody = response.body()) {
      if (byte[].class.equals(returnType.getRawClass())) {
        return (T) responseBody.bytes();
      }

      String respBody = responseBody.string();
      if (respBody.isEmpty()) {
        return null;
      }

      return json.readValue(respBody, returnType);
    } catch (IOException e) {
      throw new AlgoliaRuntimeException(e);
    }
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

    private final ClientConfig config;

    private final List<Interceptor> interceptors = new ArrayList<>();

    private Consumer<OkHttpClient.Builder> clientConfig;

    private Consumer<ObjectMapper> mapperConfig;

    public Builder(ClientConfig clientConfig) {
      this.config = clientConfig;
    }

    public Builder addInterceptor(Interceptor interceptor) {
      interceptors.add(interceptor);
      return this;
    }

    public Builder setClientConfig(Consumer<OkHttpClient.Builder> config) {
      this.clientConfig = config;
      return this;
    }

    public Builder setMapperConfig(Consumer<ObjectMapper> mapperConfig) {
      this.mapperConfig = mapperConfig;
      return this;
    }

    public OkHttpRequester build() {
      return new OkHttpRequester(this);
    }
  }
}
