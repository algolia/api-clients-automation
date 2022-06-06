package com.algolia.utils;

import com.algolia.exceptions.AlgoliaRuntimeException;
import com.algolia.utils.retry.StatefulHost;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public interface Requester {
  public Call newCall(Request request);

  public <T> T handleResponse(Response response, Type returnType) throws AlgoliaRuntimeException;

  /**
   * Enable/disable debugging for this API client.
   *
   * @param debugging To enable (true) or disable (false) debugging
   */
  public void setDebugging(boolean debugging);

  /**
   * Get connection timeout (in milliseconds).
   *
   * @return Timeout in milliseconds
   */
  public int getConnectTimeout();

  /**
   * Sets the connect timeout (in milliseconds). A value of 0 means no timeout, otherwise values
   * must be between 1 and {@link Integer#MAX_VALUE}.
   *
   * @param connectionTimeout connection timeout in milliseconds
   */
  public void setConnectTimeout(int connectionTimeout);

  /**
   * Get read timeout (in milliseconds).
   *
   * @return Timeout in milliseconds
   */
  public int getReadTimeout();

  /**
   * Sets the read timeout (in milliseconds). A value of 0 means no timeout, otherwise values must
   * be between 1 and {@link Integer#MAX_VALUE}.
   *
   * @param readTimeout read timeout in milliseconds
   */
  public void setReadTimeout(int readTimeout);

  /**
   * Get write timeout (in milliseconds).
   *
   * @return Timeout in milliseconds
   */
  public int getWriteTimeout();

  /**
   * Sets the write timeout (in milliseconds). A value of 0 means no timeout, otherwise values must
   * be between 1 and {@link Integer#MAX_VALUE}.
   *
   * @param writeTimeout connection timeout in milliseconds
   */
  public void setWriteTimeout(int writeTimeout);

  public void setHosts(List<StatefulHost> hosts);
}
