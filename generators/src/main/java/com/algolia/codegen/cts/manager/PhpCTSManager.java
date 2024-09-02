package com.algolia.codegen.cts.manager;

import java.util.*;

public class PhpCTSManager implements CTSManager {

  private final String client;

  public PhpCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "php";
  }

  public String getLanguageCased() {
    return "PHP";
  }

  public String getClient() {
    return client;
  }
}
