package com.algolia.codegen.cts.tests;

import static org.openapitools.codegen.utils.StringUtils.camelize;

import com.algolia.codegen.exceptions.CTSException;
import com.algolia.codegen.utils.*;
import java.io.File;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenResponse;
import org.openapitools.codegen.SupportingFile;

public class SnippetsGenerator extends TestsGenerator {

  public SnippetsGenerator(String language, String client) {
    super(language, client);
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
        "snippets/" + language + outputFolder + Helpers.createClientName(client, language) + extension
      )
    );
  }

  private Map<String, Snippet[]> loadSnippets(Map<String, CodegenOperation> operations) throws Exception {
    Map<String, Snippet[]> snippets = loadFullCTS(Snippet[].class);

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
            Snippet newSnippet = new Snippet(test.testName, step.parameters);
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

    if (this.client.equals("search")) {
      bundle.put("isSearchClient", true);
    }

    List<Object> blocks = new ArrayList<>();
    ParametersWithDataType paramsType = new ParametersWithDataType(models, language, client);

    for (Map.Entry<String, CodegenOperation> entry : operations.entrySet()) {
      String operationId = entry.getKey();
      CodegenOperation ope = entry.getValue();
      boolean isHelper = (boolean) ope.vendorExtensions.getOrDefault("x-helper", false);

      if (!snippets.containsKey(operationId)) {
        continue;
      }

      List<Snippet> ops = Arrays.stream(snippets.get(operationId)).filter(r -> r.isSnippet).toList();
      if (ops.size() == 0) {
        // default to the first test
        ops = List.of(snippets.get(operationId)[0]);
      }

      List<Map<String, Object>> tests = new ArrayList<>();

      for (int i = 0; i < ops.size(); i++) {
        Map<String, Object> test = new HashMap<>();
        Snippet snippet = ops.get(i);
        test.put("method", operationId);
        String name = snippet.testName == null ? operationId : snippet.testName;
        test.put("testName", ops.size() > 1 ? name : "default");
        test.put("description", name);
        test.put("testIndex", i == 0 ? "" : i);
        if (ope.returnType != null && ope.returnType.length() > 0) {
          test.put("returnType", camelize(ope.returnType));
        }

        try {
          test.put("isGeneric", (boolean) ope.vendorExtensions.getOrDefault("x-is-generic", false));
          test.put("isCustomRequest", Helpers.CUSTOM_METHODS.contains(ope.operationIdOriginal));
          test.put("isAsync", (boolean) ope.vendorExtensions.getOrDefault("x-asynchronous-helper", true));
          test.put("hasParams", ope.hasParams);
          test.put("isHelper", isHelper);

          if (snippet.requestOptions != null) {
            test.put("hasRequestOptions", true);
            Map<String, Object> requestOptions = new HashMap<>();
            if (snippet.requestOptions.queryParameters != null) {
              Map<String, Object> queryParameters = new HashMap<>();
              paramsType.enhanceParameters(snippet.requestOptions.queryParameters, queryParameters);
              requestOptions.put("queryParameters", queryParameters);
            }
            if (snippet.requestOptions.headers != null) {
              Map<String, Object> headers = new HashMap<>();
              // convert the headers to an acceptable type
              paramsType.enhanceParameters(new HashMap<String, Object>(snippet.requestOptions.headers), headers);
              requestOptions.put("headers", headers);
            }
            test.put("requestOptions", requestOptions);
          }

          // Determines whether the endpoint is expected to return a response payload deserialized
          // and therefore a variable to store it into.
          test.put("hasResponsePayload", true);

          for (CodegenResponse response : ope.responses) {
            if (response.code.equals("204")) {
              test.put("hasResponsePayload", false);
            }
          }

          paramsType.enhanceParameters(snippet.parameters, test, ope);
          tests.add(test);
        } catch (CTSException e) {
          e.setTestName((String) test.get("testName"));
          throw e;
        }
      }
      Map<String, Object> testObj = new HashMap<>();
      testObj.put("snippets", tests);
      blocks.add(testObj);
    }
    bundle.put("blocksRequests", blocks);
  }
}
