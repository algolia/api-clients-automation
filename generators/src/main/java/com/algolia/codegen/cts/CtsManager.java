package com.algolia.codegen.cts;

import com.algolia.codegen.Utils;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

abstract class CtsManager {

  public abstract void addSupportingFiles(List<SupportingFile> supportingFiles);

  public abstract String getPackageDependencies();

  public void addExtraToBundle(Map<String, Object> bundle) {}

  protected Map<String, String> getFilteredPackageVersionMap(
    List<String> packages
  ) {
    HashMap<String, String> result = new HashMap<>();
    JsonNode openApiToolsConfig = Utils.readJsonFile(
      "config/openapitools.json"
    );

    Iterator<JsonNode> generatorIterator = openApiToolsConfig
      .get("generator-cli")
      .get("generators")
      .elements();
    while (generatorIterator.hasNext()) {
      JsonNode generator = generatorIterator.next();
      JsonNode additionalProperties = generator.get("additionalProperties");
      String packageName = additionalProperties.get("packageName").asText();
      String packageVersion = additionalProperties
        .get("packageVersion")
        .asText();
      if (packages.contains(packageName)) {
        result.put(packageName, packageVersion);
      }
    }

    return result;
  }
}
