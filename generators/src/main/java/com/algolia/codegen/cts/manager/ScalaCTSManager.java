package com.algolia.codegen.cts.manager;

import com.algolia.codegen.AlgoliaScalaGenerator;
import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.Helpers;
import com.samskivert.mustache.Mustache.Lambda;
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
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/.gitignore.mustache", output + "/scala", ".gitignore"));
    supportingFiles.add(new SupportingFile("snippets/.scalafmt.mustache", output + "/scala", ".scalafmt.conf"));
    supportingFiles.add(new SupportingFile("snippets/build.mustache", output + "/scala", "build.sbt"));
    supportingFiles.add(new SupportingFile("snippets/build.properties.mustache", output + "/scala", "project/build.properties"));
    supportingFiles.add(new SupportingFile("snippets/plugins.mustache", output + "/scala", "project/plugins.sbt"));
  }

  @Override
  public void addMustacheLambdas(Map<String, Lambda> lambdas) {
    lambdas.put("identifier", (fragment, writer) -> writer.write(AlgoliaScalaGenerator.formatIdentifier(fragment.execute())));
  }
}
