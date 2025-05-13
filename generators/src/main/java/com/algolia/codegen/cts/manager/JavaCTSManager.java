package com.algolia.codegen.cts.manager;

import com.algolia.codegen.AlgoliaJavaGenerator;
import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.samskivert.mustache.Mustache.Lambda;
import java.io.IOException;
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
  public String getLanguageVersion(String override) throws IOException {
    if (override != null && !override.isEmpty()) {
      return override.split("\\.")[0];
    }

    return Helpers.getLanguageVersion(getLanguage()).split("\\.")[0];
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/build.mustache", "tests/output/java", "build.gradle"));
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/build.mustache", output + "/java", "build.gradle"));
    supportingFiles.add(new SupportingFile("snippets/settings.mustache", output + "/java", "settings.gradle"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", getVersion());
    bundle.put("import", Helpers.camelize(this.client).toLowerCase());
  }

  @Override
  public void addMustacheLambdas(Map<String, Lambda> lambdas) {
    lambdas.put("toEnum", (fragment, writer) -> writer.write(AlgoliaJavaGenerator.toEnum(fragment.execute())));
  }
}
