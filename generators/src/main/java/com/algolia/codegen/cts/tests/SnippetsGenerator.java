package com.algolia.codegen.cts.tests;

import com.algolia.codegen.cts.manager.CTSManager;
import com.algolia.codegen.utils.*;
import java.io.File;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;

public class SnippetsGenerator extends TestsGenerator {

  public SnippetsGenerator(CTSManager ctsManager) {
    super(ctsManager);
  }

  @Override
  public boolean available() {
    File templates = new File("templates/" + language + "/snippets/method.mustache");
    return templates.exists();
  }

  @Override
  public void addSupportingFiles(List<SupportingFile> supportingFiles, String outputFolder, String extension) {
    if (!available()) {
      return;
    }

    extension = Helpers.getClientConfigField(language, "snippets", "extension");
    outputFolder = Helpers.getClientConfigField(language, "snippets", "outputFolder");

    if (!outputFolder.equals("")) {
      outputFolder = "/" + outputFolder + "/";
    } else {
      outputFolder = "/";
    }

    supportingFiles.add(
      new SupportingFile(
        "snippets/method.mustache",
        "docs/snippets/" + language + outputFolder + Helpers.createClientName(client, language) + extension
      )
    );
  }

  private Map<String, Snippet[]> loadSnippets(Map<String, CodegenOperation> operations) throws Exception {
    Map<String, Snippet[]> snippets = loadFullCTS(Snippet[].class);
    for (Map.Entry<String, Snippet[]> blockEntry : snippets.entrySet()) {
      for (Snippet test : blockEntry.getValue()) {
        test.method = blockEntry.getKey();
      }
    }

    String clientName = client;
    if (client.equals("algoliasearch")) {
      clientName = "search";
    }

    // also include helpers
    Map<String, ClientTestData[]> clientsTests = loadCTS("client", clientName, ClientTestData[].class);
    for (Map.Entry<String, ClientTestData[]> blockEntry : clientsTests.entrySet()) {
      for (ClientTestData test : blockEntry.getValue()) {
        for (var step : test.steps) {
          if (step.method != null && step.type.equals("method")) {
            CodegenOperation ope = operations.get(step.method);
            if (ope == null || !(boolean) ope.vendorExtensions.getOrDefault("x-helper", false)) {
              continue;
            }

            List<String> availableLanguages = (List<String>) ope.vendorExtensions.getOrDefault("x-available-languages", new ArrayList<>());

            if (availableLanguages.size() > 0 && !availableLanguages.contains(language)) {
              continue;
            }

            Snippet newSnippet = new Snippet(step.method, test.testName, step.parameters, step.requestOptions);
            Snippet[] existing = snippets.get(step.method);
            if (existing == null) {
              snippets.put(step.method, new Snippet[] { newSnippet });
            } else {
              snippets.put(step.method, ArrayUtils.add(existing, newSnippet));
            }
          }
        }
      }
    }

    return snippets;
  }

  @Override
  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    Map<String, Snippet[]> snippets = loadSnippets(operations);

    bundle.put("isSnippet", true);

    if (this.client.equals("search")) {
      bundle.put("isSearchClient", true);
    }

    List<Object> blocks = new ArrayList<>();
    ParametersWithDataType paramsType = new ParametersWithDataType(models, language, client, true);

    for (Map.Entry<String, CodegenOperation> entry : operations.entrySet()) {
      String operationId = entry.getKey();
      CodegenOperation ope = entry.getValue();

      if (!snippets.containsKey(operationId)) {
        continue;
      }

      List<Snippet> ops = Arrays.stream(snippets.get(operationId)).toList();
      List<Map<String, Object>> tests = new ArrayList<>();

      for (int i = 0; i < ops.size(); i++) {
        Map<String, Object> test = new HashMap<>();
        Snippet snippet = ops.get(i);
        String name = snippet.testName == null ? snippet.method : snippet.testName;
        if (snippet.skipLanguages != null && snippet.skipLanguages.contains(language)) {
          System.out.println("Skipping snippet " + snippet.method + " for language " + language + ", please fix this");
          continue;
        }
        test.put("testName", ops.size() > 1 ? name : "default");
        test.put("description", name);
        test.put("testIndex", i == 0 ? "" : i);
        snippet.addMethodCall(test, paramsType, ope);
        addRequestOptions(paramsType, snippet.requestOptions, test);
        tests.add(test);
      }
      Map<String, Object> testObj = new HashMap<>();
      testObj.put("snippets", tests);
      blocks.add(testObj);
    }
    bundle.put("blocksRequests", blocks);
  }
}
