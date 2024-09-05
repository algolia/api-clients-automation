package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.Helpers;
import java.util.Map;

public class ScalaCTSManager implements CTSManager {

  private final String client;

  public ScalaCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "scala";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("import", Helpers.camelize(this.client).toLowerCase());
  }
}
