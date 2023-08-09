package com.algolia.codegen.cs.snippets;

import com.algolia.codegen.Utils;
import com.algolia.codegen.cts.tests.ParametersWithDataType;
import com.algolia.codegen.cts.tests.Request;
import com.algolia.codegen.exceptions.CSException;
import com.algolia.codegen.exceptions.CTSException;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.core.util.Json;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;

public class SnippetsGenerator {

  final String language;
  final String client;

  public SnippetsGenerator(String language, String client) {
    this.language = language;
    this.client = client;
  }

  public List<SupportingFile> getSupportingFiles() {
    if (templateNotExist()) return Collections.emptyList();
    SupportingFile template = new SupportingFile("snippets.mustache", client + ".yml");
    return Collections.singletonList(template);
  }

  private boolean templateNotExist() {
    Path path = Path.of("templates", language, "snippets", "snippets.mustache");
    return !Files.exists(path);
  }

  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    if (templateNotExist()) throw new CSException("Snippets template not found for " + language, true);

    var cts = loadRequests();

    var blocks = new ArrayList<>();
    ParametersWithDataType paramsType = new ParametersWithDataType(models, language);

    for (Map.Entry<String, CodegenOperation> entry : operations.entrySet()) {
      var operationId = getOperationId(entry, cts);
      var op = cts.get(operationId);

      var tests = new ArrayList<Map<String, Object>>();
      for (Request request : op) {
        var test = new HashMap<String, Object>();
        test.put("method", operationId);
        if (request.testName != null) {
          test.put("hasDescription", true);
          test.put("description", request.testName);
        }
        try {
          var ope = entry.getValue();
          test.put("isGeneric", ope.vendorExtensions.getOrDefault("x-is-generic", false));

          // We check on the spec if body parameters should be present in the CTS
          // If so, we change the `null` default to an empty object, so we know if
          // tests are properly written
          if (!ope.bodyParams.isEmpty() && request.request.body == null) {
            request.request.body = "{}";
          }

          // In a case of a `GET` or `DELETE` request, we want to assert if the body
          // is correctly parsed (absent from the payload)
          if (request.request.method.equals("GET") || request.request.method.equals("DELETE")) {
            test.put("assertNullBody", true);
          }

          test.put("request", request.request);
          test.put("hasParameters", request.parameters.size() != 0);
          test.put("extras", request.extras);
          test.put("hasOperationParams", ope.hasParams);

          setRequestOptions(request, test, paramsType);
          paramsType.enhanceParameters(request.parameters, test, ope);

          tests.add(test);
        } catch (CTSException e) {
          e.setTestName((String) test.get("testName"));
          throw e;
        }
      }
      Map<String, Object> testObj = new HashMap<>();
      testObj.put("tests", tests);
      testObj.put("operationId", operationId);
      blocks.add(testObj);
    }
    bundle.put("blocksRequests", blocks);
  }

  private void setRequestOptions(Request req, Map<String, Object> test, ParametersWithDataType paramsType) throws JsonProcessingException {
    if (req.requestOptions == null) return;
    test.put("hasRequestOptions", true);
    var requestOptions = new HashMap<>();
    if (req.requestOptions.queryParameters != null) {
      var queryParameters = new HashMap<String, Object>();
      paramsType.enhanceParameters(req.requestOptions.queryParameters, queryParameters);
      requestOptions.put("queryParameters", queryParameters);
    }
    if (req.requestOptions.headers != null) {
      var headers = new HashMap<String, Object>();
      paramsType.enhanceParameters(new HashMap<>(req.requestOptions.headers), headers);
      requestOptions.put("headers", headers);
    }
    test.put("requestOptions", requestOptions);
  }

  private String getOperationId(Map.Entry<String, CodegenOperation> entry, Map<String, Request[]> cts) {
    String operationId = entry.getKey();
    if (!cts.containsKey(operationId)) {
      throw new CTSException(
        "operationId '" +
        operationId +
        "' does not exist in the tests suite, please create the file:" +
        " 'tests/CTS/methods/requests/" +
        client +
        "/" +
        operationId +
        ".json'.\n" +
        "You can read more on the documentation:" +
        " https://api-clients-automation.netlify.app/docs/contributing/testing/common-test-suite"
      );
    }
    return operationId;
  }

  protected Map<String, Request[]> loadRequests() throws IOException {
    var clientName = (language.equals("javascript") || language.equals("dart")) && client.equals("algoliasearch") ? "search" : client;
    var requestsDir = Path.of("tests", "CTS", "methods", "requests", clientName).toFile();
    validateDirectory(requestsDir);
    var commonDir = Path.of("tests", "CTS", "methods", "requests", "common").toFile();
    validateDirectory(commonDir);

    var specs = new ArrayList<File>();
    Collections.addAll(specs, Objects.requireNonNull(requestsDir.listFiles()));
    Collections.addAll(specs, Objects.requireNonNull(commonDir.listFiles()));

    Map<String, Request[]> cts = new LinkedHashMap<>();
    for (File file : specs) {
      var json = Files.readString(file.toPath());
      var requests = Json.mapper().readValue(injectVariables(json), Request[].class);
      cts.put(file.getName().replace(".json", ""), requests);
    }
    return cts;
  }

  private void validateDirectory(File dir) throws CTSException {
    if (!dir.exists()) throw new CTSException("CTS not found at " + dir.getAbsolutePath(), true);
  }

  private String injectVariables(String json) {
    return json.replace("${{languageCased}}", languageCased()).replace("${{clientPascalCase}}", Utils.capitalize(Utils.camelize(client)));
  }

  private String languageCased() {
    return switch (language) {
      case "java" -> "Java";
      case "javascript" -> "JavaScript";
      case "php" -> "PHP";
      case "kotlin" -> "Kotlin";
      default -> language;
    };
  }
}
