package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class CSharpCTSManager implements CTSManager {

  private final String client;

  public CSharpCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "csharp";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("globaljson.mustache", "tests/output/csharp", "global.json"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", getVersion());
  }
}
