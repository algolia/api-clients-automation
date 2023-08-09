package com.algolia.codegen.exceptions;

public class CSException extends GeneratorException {

  private boolean skipable;
  private String testName;

  public CSException(String message) {
    super(message);
  }

  public CSException(String message, String testName) {
    super(message);
    this.testName = testName;
  }

  public CSException(String message, Throwable cause) {
    super(message, cause);
  }

  public CSException(String message, boolean skipable) {
    this(message);
    this.skipable = skipable;
  }

  public boolean isSkipable() {
    return skipable;
  }

  public void setTestName(String testName) {
    this.testName = testName;
  }

  @Override
  public String getMessage() {
    if (testName != null) {
      return "Error in " + testName + ": " + super.getMessage();
    }

    return super.getMessage();
  }
}
