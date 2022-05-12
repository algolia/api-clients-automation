package com.algolia.codegen.cts.manager;

import com.algolia.codegen.Utils;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class JavaScriptCtsManager extends CtsManager {

  public void addSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(
      new SupportingFile("package.mustache", ".", "package.json")
    );
  }

  public Object[] getPackageDependencies() {
    return this.getFilteredPackageVersions(
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
      );
  }

  public void addExtraToBundle(Map<String, Object> bundle) {
    bundle.put("utilsPackageVersion", this.getUtilsPackageVersion());
  }

  private String getUtilsPackageVersion() {
    JsonNode openApiToolsConfig = Utils.readJsonFile(
      "config/openapitools.json"
    );

    String utilsPackageVersion = openApiToolsConfig
      .get("generator-cli")
      .get("generators")
      .get("javascript-search")
      .get("additionalProperties")
      .get("utilsPackageVersion")
      .asText();

    return utilsPackageVersion;
  }
}
