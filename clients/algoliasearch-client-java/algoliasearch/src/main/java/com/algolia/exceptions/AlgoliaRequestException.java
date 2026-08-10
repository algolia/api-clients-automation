package com.algolia.exceptions;

import javax.annotation.Nullable;

/** Represents a retryable exception (4XX). */
public final class AlgoliaRequestException extends AlgoliaApiException {

  public AlgoliaRequestException(String message, Throwable cause, int httpErrorCode) {
    super(message, cause, httpErrorCode);
  }

  public AlgoliaRequestException(String message, int httpErrorCode) {
    super(message, httpErrorCode);
  }

  public AlgoliaRequestException(String message, int httpErrorCode, @Nullable String correlationId) {
    super(message, httpErrorCode, correlationId);
  }

  public AlgoliaRequestException(Throwable cause, int httpErrorCode) {
    super(cause, httpErrorCode);
  }
}
