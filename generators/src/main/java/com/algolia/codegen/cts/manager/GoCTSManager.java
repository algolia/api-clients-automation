package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import java.util.*;

public class GoCTSManager implements CTSManager {

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    Object clientPrefix = bundle.get("clientPrefix");

    if (clientPrefix.equals("query-suggestions")) {
      bundle.put("clientPrefix", "suggestions");
    }

    bundle.put("clientImport", clientPrefix);
  }
}
