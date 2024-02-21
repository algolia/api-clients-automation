package com.algolia.codegen.cts.tests;

import com.algolia.codegen.exceptions.CTSException;
import com.algolia.codegen.utils.*;
import java.io.File;
import java.util.*;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenResponse;
import org.openapitools.codegen.SupportingFile;

public class TestsRequest extends TestsGenerator {

  public TestsRequest(String language, String client) {
    super(language, client);
  }

  protected Map<String, Request[]> loadRequestCTS() throws Exception {
    String clientName = client;
    // This special case allow us to read the `search` CTS to generated the tests for the
    // `lite` client, which is only available in Javascript
    if ((language.equals("javascript") || language.equals("dart")) && client.equals("algoliasearch")) {
      clientName = "search";
    }
    return super.loadCTS("requests", clientName, Request[].class);
  }

  @Override
  public boolean available() {
    File templates = new File("templates/" + language + "/tests/requests/requests.mustache");
    return templates.exists();
  }

  @Override
  public void addSupportingFiles(List<SupportingFile> supportingFiles, String outputFolder, String extension) {
    if (!available()) {
      return;
    }
    supportingFiles.add(
      new SupportingFile(
        "tests/requests/requests.mustache",
        "tests/output/" + language + "/" + outputFolder + "/requests",
        Helpers.createClientName(client, language) + extension
      )
    );
  }

  @Override
  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    Map<String, Request[]> cts = loadRequestCTS();

    if (this.client.equals("search")) {
      bundle.put("isSearchClient", true);
    }

    List<Object> blocks = new ArrayList<>();
    ParametersWithDataType paramsType = new ParametersWithDataType(models, language);

    for (Map.Entry<String, CodegenOperation> entry : operations.entrySet()) {
      String operationId = entry.getKey();
      if (!cts.containsKey(operationId)) {
        throw new CTSException(
          "operationId '" +
          operationId +
          "' does not exist in the tests suite, please create the file:" +
          " 'tests/CTS/requests/" +
          client +
          "/" +
          operationId +
          ".json'.\n" +
          "You can read more on the documentation:" +
          " https://api-clients-automation.netlify.app/docs/contributing/testing/common-test-suite"
        );
      }
      Request[] op = cts.get(operationId);

      List<Object> tests = new ArrayList<>();
      for (int i = 0; i < op.length; i++) {
        Map<String, Object> test = new HashMap<>();
        Request req = op[i];
        test.put("method", operationId);
        test.put("testName", req.testName == null ? operationId + i : req.testName);
        test.put("testIndex", i);

        try {
          CodegenOperation ope = entry.getValue();
          test.put("isGeneric", (boolean) ope.vendorExtensions.getOrDefault("x-is-generic", false));
          if (Helpers.CUSTOM_METHODS.contains(ope.operationIdOriginal)) {
            test.put("isCustomRequest", true);
          }

          // We check on the spec if body parameters should be present in the CTS
          // If so, we change the `null` default to an empty object, so we know if
          // tests are properly written
          if (ope.bodyParams.size() != 0 && req.request.body == null) {
            req.request.body = "{}";
          }

          // For golang, jsonassert expect % to be formatted, we need to escape them
          if (language.equals("go") && req.request.body != null) {
            req.request.body = req.request.body.replace("%", "%%");
          }

          // For dart, same thing but for $
          if (language.equals("dart") && req.request.body != null) {
            req.request.body = req.request.body.replace("$", "\\$");
          }

          // In a case of a `GET` or `DELETE` request, we want to assert if the body
          // is correctly parsed (absent from the payload)
          if (req.request.method.equals("GET") || req.request.method.equals("DELETE")) {
            test.put("assertNullBody", true);
          }

          if (req.response != null) {
            bundle.put("hasE2E", true);
            test.put("response", req.response);

            if (req.response.statusCode == 0) {
              throw new CTSException(
                "operationId '" +
                operationId +
                "' has a 'response' field in order to generate e2e tests but is missing the" +
                " 'statusCode' parameter"
              );
            }
          }

          test.put("request", req.request);
          test.put("hasParameters", req.parameters.size() != 0);
          test.put("hasOperationParams", ope.hasParams);

          if (req.requestOptions != null) {
            test.put("hasRequestOptions", true);
            Map<String, Object> requestOptions = new HashMap<>();
            if (req.requestOptions.queryParameters != null) {
              Map<String, Object> queryParameters = new HashMap<>();
              paramsType.enhanceParameters(req.requestOptions.queryParameters, queryParameters);
              requestOptions.put("queryParameters", queryParameters);
            }
            if (req.requestOptions.headers != null) {
              Map<String, Object> headers = new HashMap<>();
              // convert the headers to an acceptable type
              paramsType.enhanceParameters(new HashMap<String, Object>(req.requestOptions.headers), headers);
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

          paramsType.enhanceParameters(req.parameters, test, ope);
          tests.add(test);
        } catch (CTSException e) {
          e.setTestName((String) test.get("testName"));
          throw e;
        }
      }
      Map<String, Object> testObj = new HashMap<>();
      testObj.put("tests", tests);
      testObj.put("operationId", operationId);

      Map<String, Object> snippet = (Map<String, Object>) tests.get(0);
      snippet.put("description", snippet.get("testName"));
      testObj.put("snippet", snippet);

      blocks.add(testObj);
    }
    bundle.put("blocksRequests", blocks);
  }
}
