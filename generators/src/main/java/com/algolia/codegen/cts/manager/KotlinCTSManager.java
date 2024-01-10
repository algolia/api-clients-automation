package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.util.Map;

public class KotlinCTSManager implements CTSManager {

  private final String client;

  public KotlinCTSManager(String client) {
    this.client = client;
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", Helpers.getClientConfigField("kotlin", "packageVersion"));
    bundle.put("import", Helpers.camelize(this.client).toLowerCase());
  }
}
