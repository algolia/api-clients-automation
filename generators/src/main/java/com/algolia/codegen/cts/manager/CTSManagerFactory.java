package com.algolia.codegen.cts.manager;

public class CTSManagerFactory {

  private CTSManagerFactory() {
    // NO-OP
  }

  public static CTSManager getManager(String language, String client, String overrideLanguageVersion) {
    return switch (language) {
      case "javascript" -> new JavascriptCTSManager(client);
      case "java" -> new JavaCTSManager(client);
      case "php" -> new PhpCTSManager(client);
      case "kotlin" -> new KotlinCTSManager(client);
      case "go" -> new GoCTSManager(client);
      case "dart" -> new DartCTSManager(client);
      case "ruby" -> new RubyCTSManager(client);
      case "scala" -> new ScalaCTSManager(client);
      case "python" -> new PythonCTSManager(client);
      case "csharp" -> new CSharpCTSManager(client, overrideLanguageVersion);
      case "swift" -> new SwiftCTSManager(client);
      default -> null;
    };
  }
}
