package com.algolia.codegen.cts.tests;

import com.algolia.codegen.AlgoliaGoGenerator;
import com.algolia.codegen.cts.manager.CTSManager;
import com.algolia.codegen.exceptions.CTSException;
import com.algolia.codegen.utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.v3.core.util.Json;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;
import org.openapitools.codegen.*;

public abstract class TestsGenerator {

  protected final CTSManager ctsManager;
  protected final String language, client;

  public TestsGenerator(CTSManager ctsManager) {
    this.ctsManager = ctsManager;
    this.language = ctsManager.getLanguage();
    this.client = ctsManager.getClient();
  }

  public abstract boolean available();

  public abstract void addSupportingFiles(List<SupportingFile> supportingFiles, String outputFolder, String extension);

  public abstract void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle)
    throws Exception;

  protected <T> Map<String, T> loadCTS(String path, String clientName, Class<T> jsonType) throws Exception {
    if (!available()) {
      throw new CTSException("Templates not found for " + path, true);
    }

    File dir = new File("tests/CTS/" + path + "/" + clientName);
    File commonTestDir = new File("tests/CTS/" + path + "/common");
    if (!dir.exists()) {
      throw new CTSException("CTS not found at " + dir.getAbsolutePath(), true);
    }
    List<File> allTests = new ArrayList<>();
    Collections.addAll(allTests, dir.listFiles());
    if (commonTestDir.exists()) {
      Collections.addAll(allTests, commonTestDir.listFiles());
    }

    Map<String, T> cts = new TreeMap<>();

    skipFile: for (File f : allTests) {
      String json = new String(Files.readAllBytes(Paths.get(f.getAbsolutePath())));
      json = injectVariables(json);
      String key = f.getName().replace(".json", "");
      cts.put(key, Json.mapper().readValue(json, jsonType));
    }
    return cts;
  }

  protected <T> Map<String, T[]> loadFullCTS(Class<T[]> jsonType) throws Exception {
    String clientName = client;
    // This special case allow us to read the `search` CTS to generated the tests for the
    // `lite` client, which is available in Javascript and Dart
    if (client.equals("algoliasearch")) {
      clientName = "search";
    }

    Map<String, T[]> baseCTS = loadCTS("requests", clientName, jsonType);

    // The algoliasearch client bundles many client and therefore should provide tests for all the
    // subsequent specs
    if (client.equals("algoliasearch")) {
      Map<String, T[]> recommendCTS = loadCTS("requests", "recommend", jsonType);
      for (Map.Entry<String, T[]> entry : recommendCTS.entrySet()) {
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

  private String injectVariables(String json) {
    long threeDays = 3 * 24 * 60 * 60 * 1000;
    return json
      .replace("${{language}}", language)
      .replace("${{languageCased}}", ctsManager.getLanguageCased())
      .replace("${{languageVersion}}", ctsManager.getVersion())
      .replace("${{clientPascalCase}}", Helpers.capitalize(Helpers.camelize(Helpers.getClientConfigClientName(client))))
      .replace("\"${{nowRounded}}\"", String.valueOf(Math.round(System.currentTimeMillis() / threeDays) * threeDays));
  }

  protected void addRequestOptions(ParametersWithDataType paramsType, RequestOptions req, Map<String, Object> output)
    throws JsonMappingException, JsonProcessingException {
    output.put("hasRequestOptions", req != null);
    if (req != null) {
      Map<String, Object> requestOptions = new HashMap<>();
      if (req.queryParameters != null) {
        Map<String, Object> queryParameters = new HashMap<>();
        paramsType.enhanceParameters(req.queryParameters, queryParameters);
        requestOptions.put("queryParameters", queryParameters);
      }
      if (req.headers != null) {
        Map<String, Object> headers = new HashMap<>();
        // convert the headers to an acceptable type
        paramsType.enhanceParameters(new HashMap<String, Object>(req.headers), headers);
        requestOptions.put("headers", headers);
      }
      Map<String, Object> timeouts = null;
      if (req.readTimeout != null || req.writeTimeout != null || req.connectTimeout != null) {
        timeouts = new HashMap<>();
        if (req.readTimeout != null) timeouts.put("read", req.readTimeout);
        if (req.writeTimeout != null) timeouts.put("write", req.writeTimeout);
        if (req.connectTimeout != null) timeouts.put("connect", req.connectTimeout);
        paramsType.enhanceParameters(timeouts, timeouts);
      }
      requestOptions.put("timeouts", timeouts);
      output.put("requestOptions", requestOptions);
    }
  }

  public static void setOptionalParameters(
    String language,
    CodegenOperation ope,
    Map<String, Object> test,
    Map<String, Object> parameters,
    boolean isHelper
  ) {
    if (!"go".equals(language)) return;

    boolean isBodyRequired = ope.bodyParam != null && ope.bodyParam.required;
    boolean alreadyInlinedBody = ope.allParams.size() == 1 && ope.bodyParam != null && !ope.bodyParam.isArray;
    // I can't figure out the correct condition for this one so it's harcoded for now
    boolean isSFFV =
      "searchForFacetValues".equals(ope.operationId) && !ope.tags.isEmpty() && "composition".equals(ope.tags.get(0).getName());

    int bodyPropsOptional = 0;
    boolean isBodyTooBig = false;
    boolean actuallyHasOptional = false;

    if (AlgoliaGoGenerator.canFlattenBody(ope) && ope.bodyParam != null) {
      List<CodegenProperty> vars = ope.bodyParam.getVars();
      bodyPropsOptional = (int) vars.stream().filter(p -> !p.required).count();
      isBodyTooBig = vars.isEmpty();

      Map<String, Object> paramBody = parameters;
      if (!alreadyInlinedBody) {
        Object paramObj = parameters.get(ope.bodyParam.paramName);
        if (paramObj instanceof String) {
          actuallyHasOptional = !isBodyRequired;
        } else if (paramObj instanceof Map) {
          paramBody = (Map<String, Object>) paramObj;
        }
      }

      for (CodegenProperty prop : vars) {
        if (!prop.required && paramBody != null && paramBody.containsKey(prop.baseName)) {
          actuallyHasOptional = true;
        }
      }
    }

    for (CodegenParameter param : ope.allParams) {
      if (!param.required && parameters.containsKey(param.baseName)) {
        actuallyHasOptional = true;
        break;
      }
    }

    int totalOptional = ope.optionalParams.size() + bodyPropsOptional;

    // hasOptionalWrapper if there is more that one optional param, after the body has been
    // flattened.
    boolean hasOptionalWrapper = totalOptional > 1 && actuallyHasOptional && !isSFFV;
    boolean hasInlineOptional = ((totalOptional == 1 || isSFFV) && actuallyHasOptional) || isBodyTooBig;
    boolean hasNilOptional = totalOptional > 0 && !actuallyHasOptional && !isHelper;
    if (isBodyTooBig && !isBodyRequired) {
      boolean isBodySet = alreadyInlinedBody ? !parameters.isEmpty() : parameters.containsKey(ope.bodyParam.paramName);
      hasNilOptional = !isBodySet;
    }

    test.put("hasOptionalWrapper", hasOptionalWrapper);
    test.put("hasInlineOptional", hasInlineOptional);
    test.put("hasNilOptional", hasNilOptional);
  }
}
