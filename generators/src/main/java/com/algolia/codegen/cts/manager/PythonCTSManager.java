package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.Helpers;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class PythonCTSManager implements CTSManager {

  private final String client;

  public PythonCTSManager(String client) {
    this.client = client;
  }

  @Override
  public void addSupportingFiles(List<SupportingFile> supportingFiles) {}

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("import", Helpers.toSnakeCase(this.client).toLowerCase());
  }
}
