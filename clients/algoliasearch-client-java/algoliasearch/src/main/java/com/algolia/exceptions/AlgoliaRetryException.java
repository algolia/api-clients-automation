package com.algolia.exceptions;

import java.util.List;

/**
 * Exception thrown when an error occurs during the retry strategy. For example: All hosts are
 * unreachable.
 */
public class AlgoliaRetryException extends AlgoliaRuntimeException {

  private static final long serialVersionUID = 1L;
  private final List<Throwable> errors;

  public AlgoliaRetryException(List<Throwable> errors) {
    super(
      "Error(s) while processing the retry strategy. If the error persists, please visit our help" +
      " center https://alg.li/support-unreachable-hosts or reach out to the Algolia Support" +
      " team: https://alg.li/support",
      errors.get(errors.size() - 1)
    );
    this.errors = errors;
  }

  public List<Throwable> getErrors() {
    return errors;
  }

  @Override
  public String getMessage() {
    if (errors == null || errors.isEmpty()) {
      return super.getMessage();
    }
    StringBuilder messageBuilder = new StringBuilder(super.getMessage());
    for (Throwable error : errors) {
      messageBuilder.append("\nCaused by: ").append(error);
    }
    return messageBuilder.toString();
  }

  @Override
  public String toString() {
    return getMessage();
  }
}
