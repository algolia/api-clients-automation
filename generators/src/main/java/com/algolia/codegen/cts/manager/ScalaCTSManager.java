package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.Helpers;
import java.util.List;
import java.util.Map;
import org.openapitools.codegen.SupportingFile;

public class ScalaCTSManager implements CTSManager {

  private final String client;

  public ScalaCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "scala";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("import", Helpers.camelize(this.client).toLowerCase());
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("snippets/.gitignore.mustache", "snippets/scala", ".gitignore"));
    supportingFiles.add(new SupportingFile("snippets/.scalafmt.mustache", "snippets/scala", ".scalafmt.conf"));
    supportingFiles.add(new SupportingFile("snippets/build.mustache", "snippets/scala", "build.sbt"));
    supportingFiles.add(new SupportingFile("snippets/build.properties.mustache", "snippets/scala", "project/build.properties"));
    supportingFiles.add(new SupportingFile("snippets/plugins.mustache", "snippets/scala", "project/plugins.sbt"));
  }
}
