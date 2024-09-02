package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class JavaCTSManager implements CTSManager {

  private final String client;

  public JavaCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "java";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/build.mustache", "tests/output/java", "build.gradle"));
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/build.mustache", "snippets/java", "build.gradle"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", getVersion());
    bundle.put("import", Helpers.camelize(this.client).toLowerCase());
  }
}
