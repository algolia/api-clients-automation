package com.algolia.utils;

import com.algolia.exceptions.*;
import com.algolia.utils.retry.RetryStrategy;
import com.algolia.utils.retry.StatefulHost;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpRequester implements Requester {

  private RetryStrategy retryStrategy;
  private OkHttpClient httpClient;
  private HttpLoggingInterceptor loggingInterceptor;
  private LogLevel level;
  private ObjectMapper json;

  public HttpRequester() {
    this.retryStrategy = new RetryStrategy();

    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.addInterceptor(retryStrategy.getRetryInterceptor());

    this.loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(LogLevel.NONE.value());
    builder.addInterceptor(this.loggingInterceptor);

    builder.retryOnConnectionFailure(false);

    httpClient = builder.build();

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
          return null;  // No need to deserialize, either no content or no type provided
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
  public void setLogLevel(LogLevel level) {
    if (level != this.level) {
      this.loggingInterceptor.setLevel(level.value());
    }
    this.level = level;
  }

  @Override
  public int getConnectTimeout() {
    return httpClient.connectTimeoutMillis();
  }

  @Override
  public void setConnectTimeout(int connectionTimeout) {
    httpClient = httpClient.newBuilder().connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS).build();
  }

  @Override
  public int getReadTimeout() {
    return httpClient.readTimeoutMillis();
  }

  public void setReadTimeout(int readTimeout) {
    httpClient = httpClient.newBuilder().readTimeout(readTimeout, TimeUnit.MILLISECONDS).build();
  }

  @Override
  public int getWriteTimeout() {
    return httpClient.writeTimeoutMillis();
  }

  @Override
  public void setWriteTimeout(int writeTimeout) {
    httpClient = httpClient.newBuilder().writeTimeout(writeTimeout, TimeUnit.MILLISECONDS).build();
  }

  @Override
  public void setHosts(List<StatefulHost> hosts) {
    this.retryStrategy.setHosts(hosts);
  }

  public void addInterceptor(Interceptor interceptor) {
    httpClient = httpClient.newBuilder().addInterceptor(interceptor).build();
  }

  @Override
  public void close() throws Exception {
    httpClient.dispatcher().executorService().shutdown();
    httpClient.connectionPool().evictAll();
    if (httpClient.cache() != null) {
      httpClient.cache().close();
    }
  }
}
