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

public class TestsRequest extends TestsGenerator {

  private final boolean withSnippets;
  private List<SupportingFile> supportingFiles;

  public TestsRequest(String language, String client, boolean withSnippets) {
    super(language, client);
    this.withSnippets = withSnippets;
  }

  protected Map<String, Request[]> loadRequestCTS() throws Exception {
    String clientName = client;
    // This special case allow us to read the `search` CTS to generated the tests for the
    // `lite` client, which is only available in Javascript
    if (client.equals("algoliasearch")) {
      clientName = "search";
    }

    Map<String, Request[]> baseCTS = super.loadCTS("requests", clientName, Request[].class);

    // The algoliasearch client bundles many client and therefore should provide tests for all the
    // subsequent specs
    if (client.equals("algoliasearch")) {
      Map<String, Request[]> recommendCTS = super.loadCTS("requests", "recommend", Request[].class);
      for (Map.Entry<String, Request[]> entry : recommendCTS.entrySet()) {
        String operation = entry.getKey();
        // custom methods are common to every clients, we don't want duplicate tests
        if (operation.startsWith("custom")) {
          continue;
        }

        if (baseCTS.containsKey(operation)) {
          baseCTS.put(operation, ArrayUtils.addAll(baseCTS.get(operation), entry.getValue()));
        } else {
          baseCTS.put(operation, entry.getValue());
        }
      }
    }

    return baseCTS;
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

    this.supportingFiles = supportingFiles;

    supportingFiles.add(
      new SupportingFile(
        "tests/requests/requests.mustache",
        "tests/output/" + language + "/" + outputFolder + "/requests",
        Helpers.createClientName(client, language) + extension
      )
    );
    if (new File("templates/" + language + "/tests/e2e/e2e.mustache").exists()) {
      supportingFiles.add(
        new SupportingFile(
          "tests/e2e/e2e.mustache",
          "tests/output/" + language + "/" + outputFolder + "/e2e",
          Helpers.createClientName(client, language) + extension
        )
      );
    }
  }

  private String escapeBody(String body) {
    if (body == null) {
      return null;
    }

    switch (language) {
      case "go": // jsonassert expect % to be formatted, we need to escape them
        return body.replace("%", "%%");
      case "dart": // Same thing but for $
        return body.replace("$", "\\$");
      default:
        return body;
    }
  }

  @Override
  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    Map<String, Request[]> cts = loadRequestCTS();

    if (this.client.equals("search")) {
      bundle.put("isSearchClient", true);
    }

    List<Object> blocks = new ArrayList<>();
    List<Object> blocksE2E = new ArrayList<>();
    ParametersWithDataType paramsType = new ParametersWithDataType(models, language, client);

    bundle.put("e2eApiKey", client.equals("monitoring") ? "MONITORING_API_KEY" : "ALGOLIA_ADMIN_KEY");

    for (Map.Entry<String, CodegenOperation> entry : operations.entrySet()) {
      String operationId = entry.getKey();
      CodegenOperation ope = entry.getValue();
      boolean isHelper = (boolean) ope.vendorExtensions.getOrDefault("x-helper", false);
      if (!cts.containsKey(operationId)) {
        if (isHelper) {
          continue; // some helpers don't have tests
        }

        throw new CTSException(
          "operationId '" +
          operationId +
          "' does not exist in the " +
          client +
          " tests suite, please create the file:" +
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

      List<Map<String, Object>> tests = new ArrayList<>();
      for (int i = 0; i < op.length; i++) {
        Map<String, Object> test = new HashMap<>();
        Request req = op[i];
        test.put("method", operationId);
        test.put("testName", req.testName == null ? operationId : req.testName);
        test.put("testIndex", i == 0 ? "" : i);
        test.put("isSnippet", req.isSnippet);
        if (ope.returnType != null && ope.returnType.length() > 0) {
          test.put("returnType", camelize(ope.returnType));
        }

        try {
          test.put("isGeneric", (boolean) ope.vendorExtensions.getOrDefault("x-is-generic", false));
          if (Helpers.CUSTOM_METHODS.contains(ope.operationIdOriginal)) {
            test.put("isCustomRequest", true);
          }

          if (req.request != null && !isHelper) {
            // We check on the spec if body parameters should be present in the CTS
            // If so, we change the `null` default to an empty object, so we know if
            // tests are properly written
            if (ope.bodyParams.size() != 0 && req.request.body == null) {
              req.request.body = "{}";
            }

            req.request.body = escapeBody(req.request.body);

            // In a case of a `GET` or `DELETE` request, we want to assert if the body
            // is correctly parsed (absent from the payload)
            if (req.request.method.equals("GET") || req.request.method.equals("DELETE")) {
              test.put("assertNullBody", true);
            }
          }

          if (req.response != null) {
            req.response.body = escapeBody(req.response.body);
            test.put("response", req.response);
          }

          test.put("request", req.request);
          test.put("isAsync", true);
          test.put("hasParams", ope.hasParams);
          test.put("isHelper", isHelper);

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

      if (withSnippets) {
        List<Map<String, Object>> snippets = tests.stream().filter(t -> (boolean) t.getOrDefault("isSnippet", false)).toList();
        if (snippets.size() == 0) {
          Map<String, Object> snippet = tests.get(0);
          snippet.put("description", snippet.get("testName"));
          snippet.put("testName", "default");
          snippets = List.of(snippet);
        } else {
          for (Map<String, Object> snippet : snippets) {
            snippet.put("description", snippet.get("testName"));
          }
        }
        testObj.put("snippets", snippets);
      }

      blocks.add(testObj);

      // extract e2e
      List<Map<String, Object>> e2e = tests.stream().filter(t -> t.get("response") != null).toList();
      if (e2e.size() > 0) {
        Map<String, Object> e2eObj = new HashMap<>();
        e2eObj.put("tests", e2e);
        e2eObj.put("operationId", operationId);
        blocksE2E.add(e2eObj);
      }
    }
    bundle.put("blocksRequests", blocks);
    if (!blocksE2E.isEmpty()) {
      bundle.put("blocksE2E", blocksE2E);
    } else if (supportingFiles != null) {
      supportingFiles.removeIf(f -> f.getTemplateFile().equals("tests/e2e/e2e.mustache"));
    }
  }
}
