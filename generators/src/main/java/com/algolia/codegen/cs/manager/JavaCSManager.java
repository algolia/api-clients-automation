package com.algolia.codegen.cs.manager;

import com.algolia.codegen.Utils;
import java.util.Map;
import java.util.Objects;

class JavaCSManager implements CSManager {

  private final String client;

  JavaCSManager(String client) {
    this.client = Objects.requireNonNull(client);
  }

  @Override
  public Map<String, Object> getDataToBundle() {
    return Map.of("import", Utils.camelize(this.client).toLowerCase());
  }
}
