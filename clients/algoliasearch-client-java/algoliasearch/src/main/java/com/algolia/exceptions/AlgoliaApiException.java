package com.algolia.exceptions;

import javax.annotation.Nullable;

/** Exception thrown in case of API failure such as 4XX, 5XX error. */
public class AlgoliaApiException extends AlgoliaRuntimeException {

  private static final long serialVersionUID = 1L;

  public int getStatusCode() {
    return statusCode;
  }

  /**
   * The `Correlation-ID` returned by the API, to be quoted when reaching out to Algolia support.
   */
  @Nullable
  public String getCorrelationId() {
    return correlationId;
  }

  private final int statusCode;

  @Nullable
  private final String correlationId;

  public AlgoliaApiException(String message, Throwable cause, int httpErrorCode) {
    super(message, cause);
    this.statusCode = httpErrorCode;
    this.correlationId = null;
  }

  public AlgoliaApiException(String message, int httpErrorCode) {
    this(message, httpErrorCode, null);
  }

  public AlgoliaApiException(String message, int httpErrorCode, @Nullable String correlationId) {
    super(message);
    this.statusCode = httpErrorCode;
    this.correlationId = correlationId;
  }

  public AlgoliaApiException(Throwable cause, int httpErrorCode) {
    super(cause);
    this.statusCode = httpErrorCode;
    this.correlationId = null;
  }

  @Override
  public String getMessage() {
    String message = super.getMessage();
    return (
      "Status Code: " +
      getStatusCode() +
      (message != null ? " - " + message : "") +
      (correlationId != null ? " (Correlation-ID: " + correlationId + ")" : "")
    );
  }
}
