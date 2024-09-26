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
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("snippets/build.gradle.mustache", "snippets/kotlin", "build.gradle.kts"));
    supportingFiles.add(new SupportingFile("snippets/gradle.mustache", "snippets/kotlin", "gradle.properties"));
    supportingFiles.add(new SupportingFile("snippets/libs.versions.mustache", "snippets/kotlin", "gradle/libs.versions.toml"));
    supportingFiles.add(new SupportingFile("snippets/settings.gradle.mustache", "snippets/kotlin", "settings.gradle.kts"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", getVersion());
    bundle.put("import", Helpers.camelize(this.client).toLowerCase());
  }
}
