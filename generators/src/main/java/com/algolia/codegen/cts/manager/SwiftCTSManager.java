package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.Helpers;
import java.util.List;
import java.util.Map;
import org.openapitools.codegen.SupportingFile;

public class SwiftCTSManager implements CTSManager {

  private final String client;

  public SwiftCTSManager(String client) {
    this.client = client;
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/build.mustache", "tests/output/swift", "build.gradle"));
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/build.mustache", "snippets/java", "build.gradle"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", Helpers.getClientConfigField("java", "packageVersion"));
    bundle.put("import", Helpers.camelize(this.client).toLowerCase());
  }
}
