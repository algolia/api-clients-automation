package com.algolia.codegen.cts.manager;

import com.algolia.codegen.Utils;
import com.algolia.codegen.exceptions.GeneratorException;
import java.util.Map;

public class ScalaCTSManager implements CTSManager {

  private final String client;

  public ScalaCTSManager(String client) {
    this.client = client;
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("import", Utils.camelize(this.client).toLowerCase());
  }
}
