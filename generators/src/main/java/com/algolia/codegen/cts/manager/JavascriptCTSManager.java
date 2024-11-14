package com.algolia.codegen.cts.manager;

import com.algolia.codegen.AlgoliaJavascriptGenerator;
import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class JavascriptCTSManager implements CTSManager {

  private final String client;

  public JavascriptCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "javascript";
  }

  public String getLanguageCased() {
    return "JavaScript";
  }

  public String getClient() {
    return client;
  }

  public String getVersion() {
    return Helpers.getPackageJsonVersion(AlgoliaJavascriptGenerator.getPackageName(client));
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/package.mustache", "tests/output/javascript", "package.json"));
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/package.mustache", output + "/javascript", "package.json"));
    supportingFiles.add(new SupportingFile("snippets/tsconfig.mustache", output + "/javascript", "tsconfig.json"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("utilsPackageVersion", Helpers.getPackageJsonVersion("client-common"));
    bundle.put("algoliasearchVersion", Helpers.getPackageJsonVersion("algoliasearch"));
    bundle.put("initMethod", "init" + Helpers.capitalize(Helpers.camelize(client)));
    bundle.put(
      "clientName",
      client.equals("algoliasearch") ? "liteClient" : client.equals("composition") ? "compositionClient" : "algoliasearch"
    );
    bundle.put(
      "importPackage",
      client.equals("algoliasearch") ? "algoliasearch/lite" : client.equals("composition") ? "@algolia/client-composition" : "algoliasearch"
    );
  }
}
