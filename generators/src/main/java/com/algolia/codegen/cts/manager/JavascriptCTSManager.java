package com.algolia.codegen.cts.manager;

import com.algolia.codegen.AlgoliaJavascriptGenerator;
import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.fasterxml.jackson.databind.*;
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

  public String getPackageVersion() {
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
    Optional<Map<String, Object>> clientPkg = Helpers.getClientConfigList("javascript", "clients")
      .stream()
      .filter(pkg -> ((String) pkg.get("name")).contains(client))
      .findFirst();
    if (!clientPkg.isPresent()) {
      throw new GeneratorException("Cannot find client " + client + " in config/clients.config.json for javascript");
    }

    boolean isStandaloneClient = (boolean) clientPkg.get().getOrDefault("isStandaloneClient", false);
    bundle.put("isStandaloneClient", isStandaloneClient || client.contains("search"));

    if (client.equals("algoliasearch")) {
      bundle.put("clientName", "liteClient");
      bundle.put("importPackage", "algoliasearch/lite");
    } else if (isStandaloneClient) {
      bundle.put("clientName", (String) clientPkg.get().getOrDefault("clientName", Helpers.camelize(client)) + Helpers.API_SUFFIX);

      JsonNode packageJson = Helpers.readJsonFile(clientPkg.get().get("output") + "/package.json");
      bundle.put("importPackage", packageJson.get("name").asText());
    } else {
      bundle.put("initMethod", "init" + Helpers.capitalize(Helpers.camelize(client)));
      bundle.put("clientName", "algoliasearch");
      bundle.put("importPackage", "algoliasearch");
    }

    bundle.put("utilsPackageVersion", Helpers.getPackageJsonVersion("client-common"));
    bundle.put("algoliasearchVersion", Helpers.getPackageJsonVersion("algoliasearch"));
  }
}
