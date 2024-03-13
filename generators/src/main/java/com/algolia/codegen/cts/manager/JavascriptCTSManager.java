package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class JavascriptCTSManager implements CTSManager {

  private final String client;

  public JavascriptCTSManager(String client) {
    this.client = client;
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/package.mustache", "tests/output/javascript", "package.json"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("utilsPackageVersion", Helpers.getPackageJsonVersion("client-common"));

    List<Map<String, String>> clients = new ArrayList<>();
    String importName = "";

    Iterator<JsonNode> clientIterator = Helpers.getClientConfig("javascript").get("clients").elements();
    while (clientIterator.hasNext()) {
      JsonNode c = clientIterator.next();
      String output = c.get("output").asText();
      String packageName = output.substring(output.lastIndexOf("/") + 1);
      if (!packageName.equals("algoliasearch")) {
        packageName = "@algolia/" + packageName;
      }

      clients.add(Map.of("packageName", packageName, "packagePath", "link:../../../" + output.replace("#{cwd}/", "")));

      if (c.get("name").asText().equals(client)) {
        importName = packageName.replace("algoliasearch", "algoliasearch/lite");
      }
    }

    bundle.put("packageDependencies", clients);
    bundle.put("import", importName);
  }
}
