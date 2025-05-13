package com.algolia.codegen.cts.tests;

import com.algolia.codegen.cts.manager.CTSManager;
import com.algolia.codegen.exceptions.CTSException;
import com.algolia.codegen.utils.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenResponse;
import org.openapitools.codegen.SupportingFile;

public class TestsClient extends TestsGenerator {

  private final boolean withBenchmark;
  private final boolean withSyncTests;
  private final String testType;

  public TestsClient(CTSManager ctsManager, boolean withBenchmark) {
    super(ctsManager);
    this.withBenchmark = withBenchmark;
    this.withSyncTests = language.equals("python") && !withBenchmark;
    this.testType = withBenchmark ? "benchmark" : "client";
  }

  @Override
  public boolean available() {
    // no `lite` client test for now
    if ((language.equals("javascript") || language.equals("dart")) && client.equals("algoliasearch")) {
      return false;
    }

    File templates = new File("templates/" + language + "/tests/client/" + testType + ".mustache");
    if (!templates.exists()) {
      return false;
    }

    if (withBenchmark) {
      File benchmarkTest = new File("tests/CTS/benchmark/" + client + "/benchmark.json");
      return benchmarkTest.exists();
    }

    return true;
  }

  @Override
  public void addSupportingFiles(List<SupportingFile> supportingFiles, String outputFolder, String extension) {
    if (!available()) {
      return;
    }
    supportingFiles.add(
      new SupportingFile(
        "tests/client/" + testType + ".mustache",
        "tests/output/" + language + "/" + outputFolder + "/" + testType,
        Helpers.createClientName(client, language) + extension
      )
    );
  }

  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    Map<String, ClientTestData[]> cts = loadCTS(testType, client, ClientTestData[].class);
    ParametersWithDataType paramsType = new ParametersWithDataType(models, language, client, false);

    List<Object> blocks = new ArrayList<>();
    for (Map.Entry<String, ClientTestData[]> blockEntry : cts.entrySet()) {
      Map<String, Object> testObj = new HashMap<>();
      List<Object> tests = new ArrayList<>();
      int testIndex = 0;
      skipTest: for (ClientTestData test : blockEntry.getValue()) {
        try {
          Map<String, Object> testOut = new HashMap<>();
          List<Map<String, Object>> steps = new ArrayList<>();
          int methodCount = 0;
          testOut.put("inClientTest", true);
          testOut.put("testName", test.testName);
          testOut.put("testIndex", testIndex++);
          testOut.put("autoCreateClient", test.autoCreateClient);
          testOut.put("useEchoRequester", true);
          testOut.put("isBenchmark", withBenchmark);

          if (language.equals("go") && "`addApiKey` throws with invalid parameters".equals(test.testName)) {
            // skip this test because the body is flattened in go
            continue;
          }

          for (Step step : test.steps) {
            Map<String, Object> stepOut = new HashMap<>();
            if (step.times > 1) stepOut.put("times", step.times);
            CodegenOperation ope = null;
            if (step.type.equals("createClient")) {
              stepOut.put("stepTemplate", "tests/client/createClient.mustache");
              stepOut.put("isCreateClient", true); // TODO: remove once kotlin is converted

              boolean hasCustomHosts = step.parameters != null && step.parameters.containsKey("customHosts");
              if (hasCustomHosts) testOut.put("useEchoRequester", false);
              stepOut.put("hasCustomHosts", hasCustomHosts);
              if (hasCustomHosts) {
                stepOut.put("customHosts", step.parameters.get("customHosts"));
              }

              boolean hasTransformationRegion = step.parameters != null && step.parameters.containsKey("transformationRegion");
              if (hasTransformationRegion) testOut.put("useEchoRequester", false);
              stepOut.put("hasTransformationRegion", hasTransformationRegion);
              if (hasTransformationRegion) {
                stepOut.put("transformationRegion", step.parameters.get("transformationRegion"));
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
              ope = operations.get(step.method);
              if (ope == null) {
                throw new CTSException("Cannot find operation for method: " + step.method, test.testName);
              }

              boolean isHelper = (boolean) ope.vendorExtensions.getOrDefault("x-helper", false);

              if (isHelper) {
                List<String> availableLanguages = (List<String>) ope.vendorExtensions.getOrDefault(
                  "x-available-languages",
                  new ArrayList<>()
                );

                if (availableLanguages.size() > 0 && !availableLanguages.contains(language)) {
                  continue skipTest;
                }
              }

              stepOut.put("stepTemplate", "tests/client/method.mustache");
              stepOut.put("isMethod", true); // TODO: remove once kotlin is converted
              stepOut.put("hasParams", ope.getHasParams());
              stepOut.put("isGeneric", (boolean) ope.vendorExtensions.getOrDefault("x-is-generic", false));
              if (ope.returnType != null && ope.returnType.length() > 0) {
                stepOut.put("returnType", Helpers.toPascalCase(ope.returnType));
                stepOut.put("returnsBoolean", ope.returnType.equals("Boolean")); // ruby requires a ? for boolean functions.
              }

              stepOut.put("isHelper", isHelper);
              // default to true because most api calls are asynchronous
              stepOut.put("isAsyncMethod", (boolean) ope.vendorExtensions.getOrDefault("x-asynchronous-helper", true));

              // Determines whether the endpoint is expected to return a response payload
              // deserialized and therefore a variable to store it into.
              stepOut.put("hasResponse", true);
              for (CodegenResponse response : ope.responses) {
                if (response.code.equals("204")) {
                  stepOut.put("hasResponse", false);
                }
              }

              // set on testOut because we need to wrap everything for java.
              testOut.put("isHelper", isHelper);

              // default to true because most api calls are asynchronous
              testOut.put("isAsyncMethod", (boolean) ope.vendorExtensions.getOrDefault("x-asynchronous-helper", true));

              setOptionalParameters(language, ope, stepOut, step.parameters, isHelper);
              addRequestOptions(paramsType, step.requestOptions, stepOut);

              methodCount++;
            }

            stepOut.put("method", step.method);
            stepOut.put("isCustomRequest", step.method != null && Helpers.CUSTOM_METHODS.contains(step.method));

            paramsType.enhanceParameters(step.parameters, stepOut, ope);

            // Swift is strongly-typed and compiled language,
            // it can't have nil object when something is expected
            if (language.equals("swift")) {
              @SuppressWarnings("unchecked")
              var isNotTestable =
                step.type != null &&
                step.type.equals("method") &&
                ((List<Map<String, Object>>) stepOut.getOrDefault("parametersWithDataType", new ArrayList<>())).stream().anyMatch(
                  item -> (boolean) item.getOrDefault("isNullObject", false) || (boolean) item.getOrDefault("isNull", false)
                );
              if (isNotTestable) {
                System.out.println("Skipping test " + test.testName + " for " + language + " because of nil object");
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
                    Map<String, Integer> timeouts = (Map<String, Integer>) step.expected.match;
                    stepOut.put("matchConnectTimeout", timeouts.get("connectTimeout"));
                    stepOut.put("matchResponseTimeout", timeouts.get("responseTimeout"));
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
                if (step.expected.error instanceof Map errorMap) {
                  stepOut.put("expectedError", errorMap.getOrDefault(language, "<missing error for " + language + ">"));
                } else {
                  stepOut.put("expectedError", step.expected.error);
                }
                if (language.equals("go") && step.method != null) {
                  // hack for go that use PascalCase, but just in the operationID
                  stepOut.put(
                    "expectedError",
                    ((String) stepOut.get("expectedError")).replace(step.method, Helpers.toPascalCase(step.method))
                  );
                }
              }
              stepOut.put("match", paramsType.enhanceParameter(step.expected.match));
            } else if (!step.type.equals("createClient")) {
              stepOut.put("useEchoRequester", false);
            }
            steps.add(stepOut);
          }
          for (Map<String, Object> step : steps) {
            step.put(
              "shouldScope",
              (boolean) step.getOrDefault("isMethod", false) && (methodCount > 1 || (boolean) step.getOrDefault("isHelper", false))
            );
          }
          testOut.put("steps", steps);
          tests.add(testOut);
        } catch (CTSException e) {
          e.setTestName(test.testName);
          throw e;
        }
      }
      testObj.put("isSyncClient", false);
      testObj.put("tests", tests);
      testObj.put("testType", blockEntry.getKey());
      blocks.add(testObj);
    }
    if (this.withSyncTests) {
      List<Object> modes = new ArrayList<>();

      Map<String, Object> async = new HashMap<>();
      async.put(withBenchmark ? "blocksBenchmark" : "blocksClient", Helpers.deepCopy(blocks));
      modes.add(async);

      Map<String, Object> sync = new HashMap<>();
      sync.put("isSyncClient", true);
      List<Object> blocksSync = Helpers.deepCopy(blocks);
      for (Object block : blocksSync) {
        Map<String, Object> testObj = (Map<String, Object>) block;
        testObj.put("isSyncClient", true);
      }
      sync.put(withBenchmark ? "blocksBenchmark" : "blocksClient", blocksSync);
      modes.add(sync);

      bundle.put("modes", modes);
    } else {
      bundle.put(withBenchmark ? "blocksBenchmark" : "blocksClient", blocks);
    }
  }
}
