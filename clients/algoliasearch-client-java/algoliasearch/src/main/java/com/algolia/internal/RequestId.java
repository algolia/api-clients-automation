package com.algolia.internal;

import com.algolia.config.RequestOptions;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Generates the `Request-ID` sent along with search cluster requests, so that Algolia can tie every
 * retry attempt of one logical operation together in its logs. It is a trace identifier only, it
 * never implies idempotency.
 */
public final class RequestId {

  /** Name of the header carrying the Request-ID. */
  public static final String HEADER = "request-id";

  /** Name of the query parameter carrying the Request-ID, used by browser runtimes. */
  public static final String QUERY_PARAMETER = "x-algolia-request-id";

  private static final String BASE62_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  private static final int LENGTH = 11;

  private RequestId() {}

  /** Returns a new 11 character base62 Request-ID. */
  public static String generate() {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    StringBuilder requestId = new StringBuilder(LENGTH);
    for (int i = 0; i < LENGTH; i++) {
      requestId.append(BASE62_CHARS.charAt(random.nextInt(BASE62_CHARS.length())));
    }
    return requestId.toString();
  }

  /**
   * Returns whether the given request options already carry a Request-ID, on either channel, using
   * a case-insensitive comparison.
   */
  public static boolean isPresent(@Nullable RequestOptions requestOptions) {
    if (requestOptions == null) {
      return false;
    }
    return (
      containsIgnoreCase(requestOptions.getHeaders(), HEADER) || containsIgnoreCase(requestOptions.getQueryParameters(), QUERY_PARAMETER)
    );
  }

  /**
   * Returns whether the given headers already carry a Request-ID, using a case-insensitive
   * comparison.
   */
  public static boolean isPresent(@Nonnull Map<String, String> headers) {
    return containsIgnoreCase(headers, HEADER);
  }

  private static boolean containsIgnoreCase(Map<String, String> values, String name) {
    for (String key : values.keySet()) {
      if (key.equalsIgnoreCase(name)) {
        return true;
      }
    }
    return false;
  }
}
