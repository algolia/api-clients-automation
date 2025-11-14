package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.util.List;
import java.util.Map;
import org.openapitools.codegen.SupportingFile;

public class KotlinCTSManager implements CTSManager {

  private final String client;

  public KotlinCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "kotlin";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/build.gradle.mustache", output + "/kotlin", "build.gradle.kts"));
    supportingFiles.add(new SupportingFile("snippets/gradle.mustache", output + "/kotlin", "gradle.properties"));
    supportingFiles.add(new SupportingFile("snippets/libs.versions.mustache", output + "/kotlin", "gradle/libs.versions.toml"));
    supportingFiles.add(new SupportingFile("snippets/settings.gradle.mustache", output + "/kotlin", "settings.gradle.kts"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("import", Helpers.camelize(this.client).toLowerCase());
  }
}
