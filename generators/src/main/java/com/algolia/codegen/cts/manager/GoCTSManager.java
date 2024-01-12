package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class GoCTSManager implements CTSManager {

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/common.mustache", "tests/output/go/tests/requests", "common.go"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    Object clientPrefix = bundle.get("clientPrefix");

    if (clientPrefix.equals("query-suggestions")) {
      bundle.put("clientPrefix", "suggestions");
    }

    bundle.put("clientImport", clientPrefix);
  }
}
