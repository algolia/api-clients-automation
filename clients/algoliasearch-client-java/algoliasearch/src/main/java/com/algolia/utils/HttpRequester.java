package com.algolia.utils;

import com.algolia.exceptions.*;
import com.algolia.utils.retry.RetryStrategy;
import com.algolia.utils.retry.StatefulHost;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpRequester implements Requester {

  private final OkHttpClient httpClient;
  private final RetryStrategy retryStrategy;
  private final ObjectMapper json;

  private HttpRequester(Builder builder) {
    this.retryStrategy = new RetryStrategy();
    if (builder.hosts != null) {
      retryStrategy.setHosts(builder.hosts);
    }

    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder().addInterceptor(retryStrategy.getRetryInterceptor());
    if (builder.logLevel != null) {
      HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
      logging.setLevel(builder.logLevel.value());
      clientBuilder.addInterceptor(logging);
    }
    if (builder.connectTimeout != null) {
      clientBuilder.connectTimeout(builder.connectTimeout);
    }
    if (builder.readTimeout != null) {
      clientBuilder.connectTimeout(builder.readTimeout);
    }
    if (builder.writeTimeout != null) {
      clientBuilder.writeTimeout(builder.writeTimeout);
    }
    if (!builder.interceptors.isEmpty()) {
      builder.interceptors.forEach(clientBuilder::addInterceptor);
    }
    this.httpClient = clientBuilder.build();

    this.json = new JSONBuilder().build();
  }

  @Override
  public Call newCall(Request request) {
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
  public void setHosts(List<StatefulHost> hosts) {
    this.retryStrategy.setHosts(hosts);
  }

  @Override
  public void close() throws Exception {
    httpClient.dispatcher().executorService().shutdown();
    httpClient.connectionPool().evictAll();
    if (httpClient.cache() != null) {
      httpClient.cache().close();
    }
  }

  public static class Builder {

    private LogLevel logLevel = LogLevel.NONE;
    private Duration connectTimeout = Duration.ofSeconds(2);

    private Duration writeTimeout = Duration.ofSeconds(30);

    private Duration readTimeout = Duration.ofSeconds(5);

    private final List<Interceptor> interceptors = new ArrayList<>();

    private List<StatefulHost> hosts;

    public Builder setLogLevel(LogLevel logLevel) {
      this.logLevel = logLevel;
      return this;
    }

    public Builder setConnectTimeout(Duration connectTimeout) {
      this.connectTimeout = connectTimeout;
      return this;
    }

    public Builder setReadTimeout(Duration readTimeout) {
      this.readTimeout = readTimeout;
      return this;
    }

    public Builder setWriteTimeout(Duration writeTimeout) {
      this.writeTimeout = writeTimeout;
      return this;
    }

    public Builder setHosts(List<StatefulHost> hosts) {
      this.hosts = hosts;
      return this;
    }

    public Builder addInterceptor(Interceptor interceptor) {
      interceptors.add(interceptor);
      return this;
    }

    public HttpRequester build() {
      return new HttpRequester(this);
    }
  }
}
