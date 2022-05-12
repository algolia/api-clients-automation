package com.algolia.codegen.cts;

import com.algolia.codegen.Utils;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class CtsManagerFactory {

  public static CtsManager getManager(String language) {
    if (language == null) {
      return null;
    }
    switch (language) {
      case "javascript":
        return new JavaScriptCtsManager();
      case "java":
        return new JavaCtsManager();
      case "php":
        return new PhpCtsManager();
    }
    return null;
  }

  public static class JavaScriptCtsManager extends CtsManager {

    public void addSupportingFiles(List<SupportingFile> supportingFiles) {
      supportingFiles.add(
        new SupportingFile("package.mustache", ".", "package.json")
      );
    }

    public String getPackageDependencies() {
      return String.join(
        ",\n",
        this.getFilteredPackageVersionMap(
            List.of(
              "@experimental-api-clients-automation/algoliasearch-lite",
              "@experimental-api-clients-automation/client-abtesting",
              "@experimental-api-clients-automation/client-analytics",
              "@experimental-api-clients-automation/client-common",
              "@experimental-api-clients-automation/client-insights",
              "@experimental-api-clients-automation/client-personalization",
              "@experimental-api-clients-automation/client-predict",
              "@experimental-api-clients-automation/client-query-suggestions",
              "@experimental-api-clients-automation/client-search",
              "@experimental-api-clients-automation/client-sources",
              "@experimental-api-clients-automation/recommend",
              "@experimental-api-clients-automation/requester-node-http"
            )
          )
          .entrySet()
          .stream()
          .map(entry -> {
            return (
              "    \"" + entry.getKey() + "\": \"" + entry.getValue() + "\""
            );
          })
          .toArray(String[]::new)
      );
    }

    public void addExtraToBundle(Map<String, Object> bundle) {
      bundle.put("utilsPackageVersion", this.getUtilsPackageVersion());
    }

    private String getUtilsPackageVersion() {
      JsonNode openApiToolsConfig = Utils.readJsonFile(
        "config/openapitools.json"
      );
      JsonNode clientsConfig = Utils.readJsonFile("config/clients.config.json");

      String mainPackage = clientsConfig
        .get("javascript")
        .get("mainPackage")
        .asText();

      String utilsPackageVersion = openApiToolsConfig
        .get("generator-cli")
        .get("generators")
        .get(mainPackage)
        .get("additionalProperties")
        .get("utilsPackageVersion")
        .asText();

      return utilsPackageVersion;
    }
  }

  public static class JavaCtsManager extends CtsManager {

    public void addSupportingFiles(List<SupportingFile> supportingFiles) {}

    public String getPackageDependencies() {
      return null;
    }
  }

  public static class PhpCtsManager extends CtsManager {

    public void addSupportingFiles(List<SupportingFile> supportingFiles) {}

    public String getPackageDependencies() {
      return null;
    }
  }
}
