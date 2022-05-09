package com.algolia.utils;

import com.algolia.utils.retry.RetryStrategy;
import com.algolia.utils.retry.StatefulHost;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public class HttpRequester implements Requester {

  private RetryStrategy retryStrategy;
  private OkHttpClient httpClient;
  private HttpLoggingInterceptor loggingInterceptor;
  private boolean debugging;

  public HttpRequester(List<StatefulHost> hosts) {
    this.retryStrategy = new RetryStrategy(hosts);

    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.addInterceptor(retryStrategy.getRetryInterceptor());
    builder.retryOnConnectionFailure(false);

    httpClient = builder.build();
  }

  public Call newCall(Request request) {
    return httpClient.newCall(request);
  }

  public void setDebugging(boolean debugging) {
    if (debugging != this.debugging) {
      if (debugging) {
        loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(Level.BODY);
        httpClient =
          httpClient.newBuilder().addInterceptor(loggingInterceptor).build();
      } else {
        final OkHttpClient.Builder builder = httpClient.newBuilder();
        builder.interceptors().remove(loggingInterceptor);
        httpClient = builder.build();
        loggingInterceptor = null;
      }
    }
    this.debugging = debugging;
  }

  public int getConnectTimeout() {
    return httpClient.connectTimeoutMillis();
  }

  public void setConnectTimeout(int connectionTimeout) {
    httpClient =
      httpClient
        .newBuilder()
        .connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS)
        .build();
  }

  public int getReadTimeout() {
    return httpClient.readTimeoutMillis();
  }

  public void setReadTimeout(int readTimeout) {
    httpClient =
      httpClient
        .newBuilder()
        .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
        .build();
  }

  public int getWriteTimeout() {
    return httpClient.writeTimeoutMillis();
  }

  public void setWriteTimeout(int writeTimeout) {
    httpClient =
      httpClient
        .newBuilder()
        .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
        .build();
  }
}
