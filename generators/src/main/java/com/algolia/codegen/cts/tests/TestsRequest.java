package com.algolia.codegen.cts.tests;

import com.algolia.codegen.Utils;
import com.algolia.codegen.exceptions.CTSException;
import io.swagger.v3.core.util.Json;
import java.io.File;
import java.util.*;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;

public class TestsRequest implements TestsGenerator {

  private final String language, client;

  public TestsRequest(String language, String client) {
    this.language = language;
    this.client = client;
  }

  private Map<String, Request[]> loadCTS() throws Exception {
    Map<String, Request[]> cts = new TreeMap<>();
    String clientName = client;
    // This special case allow us to read the `search` CTS to generated the tests for the
    // `algoliasearch-lite` client, which is only available in JavaScript
    if (language.equals("javascript") && client.equals("algoliasearch-lite")) {
      clientName = "search";
    }

    File dir = new File("tests/CTS/methods/requests/" + clientName);
    File commonTestDir = new File("tests/CTS/methods/requests/common");
    if (!dir.exists()) {
      throw new CTSException("CTS not found at " + dir.getAbsolutePath(), true);
    }
    if (!commonTestDir.exists()) {
      throw new CTSException("CTS not found at " + commonTestDir.getAbsolutePath(), true);
    }
    for (File f : dir.listFiles()) {
      cts.put(f.getName().replace(".json", ""), Json.mapper().readValue(f, Request[].class));
    }
    for (File f : commonTestDir.listFiles()) {
      cts.put(f.getName().replace(".json", ""), Json.mapper().readValue(f, Request[].class));
    }
    return cts;
  }

  @Override
  public void addSupportingFiles(List<SupportingFile> supportingFiles, String outputFolder, String extension) {
    String clientName = language.equals("php") ? Utils.createClientName(client, language) : client;
    supportingFiles.add(new SupportingFile("requests/requests.mustache", outputFolder + "/methods/requests", clientName + extension));
  }

  @Override
  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    Map<String, Request[]> cts = loadCTS();

    List<Object> blocks = new ArrayList<>();
    ParametersWithDataType paramsType = new ParametersWithDataType(models, language);

    for (Map.Entry<String, CodegenOperation> entry : operations.entrySet()) {
      String operationId = entry.getKey();
      if (!cts.containsKey(operationId)) {
        throw new CTSException("operationId " + operationId + " does not exist in the spec");
      }
      Request[] op = cts.get(operationId);

      List<Object> tests = new ArrayList<>();
      for (int i = 0; i < op.length; i++) {
        Map<String, Object> test = new HashMap<>();
        Request req = op[i];
        test.put("method", operationId);
        test.put("testName", req.testName == null ? operationId : req.testName);
        test.put("testIndex", i);
        test.put("request", req.request);
        test.put("hasParameters", req.parameters.size() != 0);

        if (req.requestOptions != null) {
          test.put("hasRequestOptions", true);
          Map<String, Object> requestOptions = new HashMap<>();
          paramsType.enhanceParameters(req.requestOptions, requestOptions, null);
          test.put("requestOptions", requestOptions);
        }

        CodegenOperation ope = entry.getValue();
        // special case if there is only bodyParam which is not an array
        if (ope.allParams.size() == 1 && ope.bodyParams.size() == 1 && !ope.bodyParam.isArray) {
          paramsType.enhanceRootParameters(req.parameters, ope.bodyParam.paramName, ope.bodyParam, test);
        } else {
          paramsType.enhanceParameters(req.parameters, test, ope);
        }
        tests.add(test);
      }
      Map<String, Object> testObj = new HashMap<>();
      testObj.put("tests", tests);
      testObj.put("operationId", operationId);
      blocks.add(testObj);
    }

    bundle.put("blocksRequests", blocks);
  }
}
