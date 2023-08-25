package com.algolia.transport.interceptors;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public final class AuthInterceptor implements Interceptor {

  private final String applicationId;
  private final String apiKey;

  public AuthInterceptor(String applicationId, String apiKey) {
    this.applicationId = applicationId;
    this.apiKey = apiKey;
  }

  @NotNull
  @Override
  public Response intercept(Chain chain) throws IOException {
    okhttp3.Request originalRequest = chain.request();
    okhttp3.Request.Builder builder = originalRequest.newBuilder();
    builder.header("x-algolia-application-id", applicationId);
    builder.header("x-algolia-api-key", apiKey);
    okhttp3.Request newRequest = builder.build();
    return chain.proceed(newRequest);
  }
}
