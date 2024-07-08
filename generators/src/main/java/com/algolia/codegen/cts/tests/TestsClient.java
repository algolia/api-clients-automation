package com.algolia.codegen.cts.tests;

import static com.algolia.codegen.utils.Helpers.CUSTOM_METHODS;

import com.algolia.codegen.exceptions.CTSException;
import com.algolia.codegen.utils.*;
import io.swagger.util.Json;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;

public class TestsClient extends TestsGenerator {

  public TestsClient(String language, String client) {
    super(language, client);
  }

  @Override
  public boolean available() {
    // no `lite` client test for now
    if ((language.equals("javascript") || language.equals("dart")) && client.equals("algoliasearch")) {
      return false;
    }

    File templates = new File("templates/" + language + "/tests/client/suite.mustache");
    return templates.exists();
  }

  @Override
  public void addSupportingFiles(List<SupportingFile> supportingFiles, String outputFolder, String extension) {
    if (!available()) {
      return;
    }
    supportingFiles.add(
      new SupportingFile(
        "tests/client/suite.mustache",
        "tests/output/" + language + "/" + outputFolder + "/client",
        Helpers.createClientName(client, language) + extension
      )
    );
  }

  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    Map<String, ClientTestData[]> cts = loadCTS("client", client, ClientTestData[].class);
    ParametersWithDataType paramsType = new ParametersWithDataType(models, language, client);

    List<Object> blocks = new ArrayList<>();
    for (Map.Entry<String, ClientTestData[]> blockEntry : cts.entrySet()) {
      Map<String, Object> testObj = new HashMap<>();
      List<Object> tests = new ArrayList<>();
      int testIndex = 0;
      skipTest:for (ClientTestData test : blockEntry.getValue()) {
        try {
          Map<String, Object> testOut = new HashMap<>();
          List<Object> steps = new ArrayList<>();
          testOut.put("inClientTest", true);
          testOut.put("testName", test.testName);
          testOut.put("testIndex", testIndex++);
          testOut.put("autoCreateClient", test.autoCreateClient);
          for (Step step : test.steps) {
            Map<String, Object> stepOut = new HashMap<>();
            stepOut.put("useEchoRequester", true);
            CodegenOperation ope = null;
            if (step.type.equals("createClient")) {
              stepOut.put("stepTemplate", "tests/client/createClient.mustache");
              stepOut.put("isCreateClient", true); // TODO: remove once dart and kotlin are converted

              boolean hasCustomHosts = step.parameters != null && step.parameters.containsKey("customHosts");

              stepOut.put("useEchoRequester", !hasCustomHosts);
              stepOut.put("hasCustomHosts", hasCustomHosts);
              if (hasCustomHosts) {
                stepOut.put("customHosts", step.parameters.get("customHosts"));
              }

              boolean gzipEncoding = step.parameters != null && step.parameters.getOrDefault("gzip", false).equals(true);
              // many languages don't support gzip yet
              if (
                gzipEncoding &&
                (language.equals("javascript") || language.equals("dart") || language.equals("python") || language.equals("php"))
              ) {
                continue skipTest;
              }
              stepOut.put("gzipEncoding", gzipEncoding);
            } else if (step.type.equals("method")) {
              ope = operations.get(step.path);
              if (ope == null) {
                throw new CTSException("Cannot find operation for method: " + step.path, test.testName);
              }
              stepOut.put("stepTemplate", "tests/client/method.mustache");
              stepOut.put("isMethod", true); // TODO: remove once kotlin is converted
              stepOut.put("hasOperationParams", ope.hasParams);

              // set on testOut because we need to wrap everything for java.
              testOut.put("isHelper", (boolean) ope.vendorExtensions.getOrDefault("x-helper", false));
              testOut.put("isAsync", (boolean) ope.vendorExtensions.getOrDefault("x-asynchronous-helper", true)); // default to true because most api calls are asynchronous
            }

            stepOut.put("object", step.object);
            stepOut.put("path", step.path);

            if (step.requestOptions != null) {
              Map<String, Object> requestOptions = new HashMap<>();
              paramsType.enhanceParameters(step.requestOptions, requestOptions);
              stepOut.put("requestOptions", requestOptions);
            }

            if (step.path != null && CUSTOM_METHODS.contains(step.path)) {
              stepOut.put("isCustom", true);
            }
            paramsType.enhanceParameters(step.parameters, stepOut, ope);

            // Swift is strongly-typed and compiled language,
            // it can't have nil object when something is expected
            if (language.equals("swift")) {
              @SuppressWarnings("unchecked")
              var isNotTestable =
                step.type != null &&
                step.type.equals("method") &&
                ((List<Map<String, Object>>) stepOut.getOrDefault("parametersWithDataType", new ArrayList<>())).stream()
                  .anyMatch(item -> (boolean) item.getOrDefault("isNullObject", false) || (boolean) item.getOrDefault("isNull", false));
              if (isNotTestable) {
                continue;
              }
            }

            if (step.expected != null) {
              if (step.expected.type != null) {
                switch (step.expected.type) {
                  case "userAgent":
                    stepOut.put("testUserAgent", true);
                    break;
                  case "host":
                    stepOut.put("testHost", true);
                    break;
                  case "timeouts":
                    stepOut.put("testTimeouts", true);
                    break;
                  case "response":
                    stepOut.put("testResponse", true);
                    stepOut.put("useEchoRequester", false);
                    break;
                  default:
                    throw new CTSException("Unknown expected type: " + step.expected.type, test.testName);
                }
              }
              if (step.expected.error != null) {
                stepOut.put("isError", true);
                stepOut.put("expectedError", step.expected.error);
                if (language.equals("go") && step.path != null) {
                  // hack for go that use PascalCase, but just in the operationID
                  stepOut.put("expectedError", step.expected.error.replace(step.path, Helpers.toPascalCase(step.path)));
                }
              } else if (step.expected.match != null) {
                Map<String, Object> matchMap = new HashMap<>();
                if (step.expected.match instanceof Map match) {
                  paramsType.enhanceParameters(match, matchMap);
                  stepOut.put("match", matchMap);
                  stepOut.put("matchIsJSON", true);
                } else if (step.expected.match instanceof List match) {
                  matchMap.put("parameters", Json.mapper().writeValueAsString(step.expected.match));
                  stepOut.put("match", matchMap);
                  stepOut.put("matchIsJSON", true);
                } else {
                  stepOut.put("match", step.expected.match);
                }
              }
            }
            steps.add(stepOut);
          }
          testOut.put("steps", steps);
          tests.add(testOut);
        } catch (CTSException e) {
          e.setTestName(test.testName);
          throw e;
        }
      }
      testObj.put("tests", tests);
      testObj.put("testType", blockEntry.getKey());
      blocks.add(testObj);
    }
    bundle.put("blocksClient", blocks);
  }
}
