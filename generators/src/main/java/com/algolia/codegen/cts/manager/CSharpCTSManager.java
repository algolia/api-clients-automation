package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.util.*;

public class CSharpCTSManager implements CTSManager {

  private final String client;

  public CSharpCTSManager(String client) {
    this.client = client;
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", Helpers.getClientConfigField("csharp", "packageVersion"));
  }
}
