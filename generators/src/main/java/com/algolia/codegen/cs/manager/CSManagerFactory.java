package com.algolia.codegen.cs.manager;

public class CSManagerFactory {

  private CSManagerFactory() {
    // Empty.
  }

  public static CSManager create(String language, String client) {
    return switch (language) {
      case "java" -> new JavaCSManager(client);
      case "javascript" -> new JavascriptCSManager(client);
      default -> null;
    };
  }
}
