package com.algolia.codegen.cts.tests;

import static org.openapitools.codegen.utils.StringUtils.camelize;

import com.algolia.codegen.cts.manager.CTSManager;
import com.algolia.codegen.exceptions.CTSException;
import com.algolia.codegen.utils.*;
import java.io.File;
import java.util.*;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenResponse;
import org.openapitools.codegen.SupportingFile;

public class TestsRequest extends TestsGenerator {

  private final boolean withSyncTests;
  private List<SupportingFile> supportingFiles;

  public TestsRequest(CTSManager ctsManager) {
    super(ctsManager);
    this.withSyncTests = false;
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
    Map<String, Request[]> cts = loadFullCTS(Request[].class);

    if (this.client.equals("search")) {
      bundle.put("isSearchClient", true);
    }

    List<Object> blocks = new ArrayList<>();
    List<Object> blocksE2E = new ArrayList<>();
    ParametersWithDataType paramsType = new ParametersWithDataType(models, language, client, false);

    bundle.put(
      "e2eAppID",
      client.startsWith("composition") || client.startsWith("advanced-personalization") ? "METIS_APPLICATION_ID" : "ALGOLIA_APPLICATION_ID"
    );
    bundle.put(
      "e2eApiKey",
      client.startsWith("composition") || client.startsWith("advanced-personalization")
        ? "METIS_API_KEY"
        : (client.equals("monitoring") ? "MONITORING_API_KEY" : "ALGOLIA_ADMIN_KEY")
    );
    bundle.put("useEchoRequester", true);

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
            " https://api-clients-automation.netlify.app/docs/testing/common-test-suite"
        );
      }
      Request[] op = cts.get(operationId);

      List<Map<String, Object>> tests = new ArrayList<>();
      for (int i = 0; i < op.length; i++) {
        Map<String, Object> test = new HashMap<>();
        Request req = op[i];
        if (req.skipLanguages != null && req.skipLanguages.contains(language)) {
          System.out.println(
            "Skipping request test " +
              (req.testName == null ? operationId : req.testName) +
              " for language " +
              language +
              ", please fix this"
          );
          continue;
        }
        test.put("method", operationId);
        test.put("testName", req.testName == null ? operationId : req.testName);
        test.put("testIndex", i == 0 ? "" : i);
        if (ope.returnType != null && ope.returnType.length() > 0) {
          test.put("returnType", camelize(ope.returnType));
        }

        try {
          test.put("isGeneric", (boolean) ope.vendorExtensions.getOrDefault("x-is-generic", false));
          test.put("isCustomRequest", Helpers.CUSTOM_METHODS.contains(ope.operationIdOriginal));

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
          test.put("isAsyncMethod", true);
          test.put("hasParams", ope.getHasParams());
          test.put("isHelper", isHelper);

          setOptionalParameters(ope, test, req.parameters);
          addRequestOptions(paramsType, req.requestOptions, test);

          // Determines whether the endpoint is expected to return a response payload deserialized
          // and therefore a variable to store it into.
          test.put("hasResponse", true);

          for (CodegenResponse response : ope.responses) {
            if (response.code.equals("204")) {
              test.put("hasResponse", false);
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

      blocks.add(testObj);

      // extract e2e
      List<Map<String, Object>> e2e = tests
        .stream()
        .filter(t -> t.get("response") != null)
        .toList();
      if (e2e.size() > 0) {
        Map<String, Object> e2eObj = new HashMap<>();
        e2eObj.put("tests", e2e);
        e2eObj.put("operationId", operationId);
        blocksE2E.add(e2eObj);
      }
    }
    if (this.withSyncTests) {
      List<Object> modes = new ArrayList<>();

      if (!blocksE2E.isEmpty()) {
        Map<String, Object> sync = new HashMap<>();
        sync.put("isSyncClient", true);
        sync.put("blocksE2E", blocksE2E);

        Map<String, Object> async = new HashMap<>();
        sync.put("blocksE2E", blocksE2E);

        modes.add(sync);
        modes.add(async);
      }

      Map<String, Object> sync = new HashMap<>();
      sync.put("isSyncClient", true);
      sync.put("blocksRequests", blocks);

      Map<String, Object> async = new HashMap<>();
      async.put("blocksRequests", blocks);

      modes.add(sync);
      modes.add(async);

      bundle.put("modes", modes);
    } else {
      bundle.put("blocksRequests", blocks);
      if (!blocksE2E.isEmpty()) {
        bundle.put("blocksE2E", blocksE2E);
      } else if (supportingFiles != null) {
        supportingFiles.removeIf(f -> f.getTemplateFile().equals("tests/e2e/e2e.mustache"));
      }
    }
  }
}
