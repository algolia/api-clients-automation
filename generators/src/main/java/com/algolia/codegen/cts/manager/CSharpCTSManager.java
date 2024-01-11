package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class CSharpCTSManager implements CTSManager {

  private final String client;

  public CSharpCTSManager(String client) {
    this.client = client;
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("globaljson.mustache", "tests/output/csharp", "global.json"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", Helpers.getClientConfigField("csharp", "packageVersion"));

    try {
      bundle.put("dotnetSdkMajorVersion", Files.readString(Paths.get("config/.csharp-version")).trim());
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
