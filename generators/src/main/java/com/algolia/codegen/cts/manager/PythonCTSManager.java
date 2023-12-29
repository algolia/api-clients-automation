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
  public void addSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("__init__.mustache", "tests/", "__init__.py"));
    supportingFiles.add(new SupportingFile("__init__.mustache", "tests/requests", "__init__.py"));
    supportingFiles.add(new SupportingFile("__init__.mustache", "tests/client", "__init__.py"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("import", Helpers.toSnakeCase(this.client).toLowerCase());
  }
}
