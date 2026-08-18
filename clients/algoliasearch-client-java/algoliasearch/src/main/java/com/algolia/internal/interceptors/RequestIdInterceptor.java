package com.algolia.internal.interceptors;

import com.algolia.internal.RequestId;
import java.io.IOException;
import javax.annotation.Nonnull;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Adds a {@code Request-ID} header to outgoing requests, unless the caller already supplied one on
 * either channel. Installed before {@link RetryStrategy}, so it runs once per call and every
 * host-fallback attempt reuses the same identifier.
 */
public final class RequestIdInterceptor implements Interceptor {

  @Nonnull
  @Override
  public Response intercept(@Nonnull Chain chain) throws IOException {
    Request request = chain.request();
    if (request.header(RequestId.HEADER) != null || hasQueryParameter(request)) {
      return chain.proceed(request);
    }
    return chain.proceed(request.newBuilder().header(RequestId.HEADER, RequestId.generate()).build());
  }

  private static boolean hasQueryParameter(@Nonnull Request request) {
    for (String name : request.url().queryParameterNames()) {
      if (name.equalsIgnoreCase(RequestId.QUERY_PARAMETER)) {
        return true;
      }
    }
    return false;
  }
}
