package com.algolia.codegen.cs.manager;

import java.util.Objects;

class JavascriptCSManager implements CSManager {

  private final String client;

  JavascriptCSManager(String client) {
    this.client = Objects.requireNonNull(client);
  }
}
