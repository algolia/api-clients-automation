package com.algolia.transport.interceptors;

import java.io.IOException;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public final class HeaderInterceptor implements Interceptor {

  private final Map<String, String> headers;

  public HeaderInterceptor(Map<String, String> headers) {
    this.headers = headers;
  }

  @NotNull
  @Override
  public Response intercept(Chain chain) throws IOException {
    okhttp3.Request originalRequest = chain.request();
    okhttp3.Request.Builder builder = originalRequest.newBuilder();

    for (Map.Entry<String, String> header : headers.entrySet()) {
      builder.header(header.getKey().toLowerCase(), header.getValue());
    }

    okhttp3.Request newRequest = builder.build();
    return chain.proceed(newRequest);
  }
}
