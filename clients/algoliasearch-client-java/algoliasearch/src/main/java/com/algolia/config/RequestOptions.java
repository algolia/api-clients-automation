package com.algolia.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/**
 * Request options are used to pass extra parameters, headers, timeout to the request. Parameters
 * set in the request option will override default parameter.
 */
public final class RequestOptions {

  private final Map<String, String> headers = new HashMap<>();
  private final Map<String, String> queryParameters = new HashMap<>();
  private Duration readTimeout;
  private Duration writeTimeout;

  public RequestOptions addExtraHeader(@Nonnull String key, @Nonnull String value) {
    headers.put(key, value);
    return this;
  }

  public RequestOptions addExtraQueryParameters(@Nonnull String key, @Nonnull String value) {
    queryParameters.put(key, value);
    return this;
  }

  public Map<String, String> getExtraHeaders() {
    return headers;
  }

  public Map<String, String> getExtraQueryParameters() {
    return queryParameters;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

  public Map<String, String> getQueryParameters() {
    return queryParameters;
  }

  public Duration getReadTimeout() {
    return readTimeout;
  }

  public RequestOptions setReadTimeout(Duration readTimeout) {
    this.readTimeout = readTimeout;
    return this;
  }

  public Duration getWriteTimeout() {
    return writeTimeout;
  }

  public RequestOptions setWriteTimeout(Duration writeTimeout) {
    this.writeTimeout = writeTimeout;
    return this;
  }

  @Override
  public String toString() {
    return (
      "RequestOptions{" +
      "headers=" +
      headers +
      ", queryParameters=" +
      queryParameters +
      ", readTimeout=" +
      readTimeout +
      ", writeTimeout=" +
      writeTimeout +
      '}'
    );
  }
}
