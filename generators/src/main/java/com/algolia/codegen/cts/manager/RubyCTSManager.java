package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.util.*;

public class RubyCTSManager implements CTSManager {

  private final String client;

  public RubyCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "ruby";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", getVersion());
    bundle.put("modelModule", Helpers.capitalize(Helpers.camelize(client)));
  }
}
