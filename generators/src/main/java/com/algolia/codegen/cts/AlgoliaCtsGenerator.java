package com.algolia.codegen.cts;

import org.openapitools.codegen.*;

import java.util.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableMap.Builder;
import com.samskivert.mustache.Mustache.Lambda;

import java.io.File;
import java.io.IOException;

import io.swagger.v3.core.util.Json;

public class AlgoliaCtsGenerator extends DefaultCodegen {

  // source folder where to write the files
  protected String sourceFolder = "src";
  protected String apiVersion = "1.0.0";

  // cache the models
  private Map<String, CodegenModel> models = new HashMap<String, CodegenModel>();

  /**
   * Configures the type of generator.
   *
   * @return the CodegenType for this generator
   * @see org.openapitools.codegen.CodegenType
   */
  public CodegenType getTag() {
    return CodegenType.OTHER;
  }

  /**
   * Configures a friendly name for the generator. This will be used by the
   * generator
   * to select the library with the -g flag.
   *
   * @return the friendly name for the generator
   */
  public String getName() {
    return "algolia-cts";
  }

  /**
   * Returns human-friendly help for the generator. Provide the consumer with help
   * tips, parameters here
   *
   * @return A string value for the help message
   */
  public String getHelp() {
    return "Generates the CTS";
  }

  @Override
  public Map<String, Object> postProcessAllModels(Map<String, Object> objs) {
    Map<String, Object> m = super.postProcessAllModels(objs);
    for (String name : m.keySet()) {
      List<Object> innerModel = ((Map<String, List<Object>>) m.get(name)).get("models");
      if (innerModel.size() > 0) {
        models.put(name, (CodegenModel) ((Map<String, Object>) innerModel.get(0)).get("model"));
      }
    }
    return m;
  }

  public AlgoliaCtsGenerator() {
    super();
    supportingFiles
        .add(new SupportingFile("requests.mustache", "src/test/java/com/algolia/methods/requests", "search.test.java"));
  }

  @Override
  protected Builder<String, Lambda> addMustacheLambdas() {
    Builder<String, Lambda> lambdas = super.addMustacheLambdas();

    lambdas.put("escapequotes", new EscapeQuotesLambda());
    return lambdas;
  }

  @Override
  public Map<String, Object> postProcessSupportingFileData(Map<String, Object> objs) {
    Map<String, Request[]> cts = null;
    try {
      cts = loadCTS();
    } catch (IOException e) {
      e.printStackTrace();
      throw new Error("Failed to load CTS");
    }

    Map<String, CodegenOperation> operations = buildOperations(objs).get("Search");

    Map<String, Object> bundle = super.postProcessSupportingFileData(objs);

    // We can put whatever we want in the bundle, and it will be accessible in the
    // template
    bundle.put("client", "SearchApi");

    List<Object> blocks = new ArrayList<Object>();

    for (String operationId : cts.keySet()) {
      Request[] reqs = cts.get(operationId);
      if (!operations.containsKey(operationId)) {
        throw new Error("operationId " + operationId + " does not exist in the spec");
      }
      CodegenOperation op = operations.get(operationId);

      List<Object> tests = new ArrayList<Object>();
      for (int i = 0; i < reqs.length; i++) {
        try {
          Map<String, Object> test = buildJSONForRequest(reqs[i], op, i);
          tests.add(test);
        } catch (CTSException e) {
          throw new Error(e.getMessage());
        }
      }
      Map<String, Object> testObj = new HashMap<String, Object>();
      testObj.put("tests", tests);
      blocks.add(testObj);
    }
    bundle.put("blocks", blocks);

    return bundle;
  }

  private Map<String, Object> buildJSONForRequest(Request req, CodegenOperation ope, int testIndex)
      throws CTSException {
    Map<String, Object> test = new HashMap<String, Object>();
    test.put("method", req.method);
    test.put("testName", req.testName == null ? req.method : req.testName);
    test.put("testIndex", testIndex);
    test.put("request", req.request);

    List<Object> parametersWithDataType = new ArrayList<Object>();

    // special case if there is only bodyParam which is not an array
    if (ope.allParams.size() == 1 && ope.bodyParams.size() == 1 && !ope.bodyParam.isArray) {
      parametersWithDataType.add(traverseParams(ope.bodyParam.paramName, req.parameters, ope.bodyParam, "", 0));
    } else {
      for (String paramName : req.parameters.keySet()) {
        CodegenParameter specParam = null;
        for (CodegenParameter sp : ope.allParams) {
          if (sp.paramName.equals(paramName)) {
            specParam = sp;
            break;
          }
        }
        if (specParam == null) {
          throw new CTSException("Parameter " + paramName + " not found in the root parameter");
        }
        parametersWithDataType.add(traverseParams(paramName, req.parameters.get(paramName), specParam, "", 0));
      }
    }

    test.put("parametersWithDataType", parametersWithDataType);
    return test;
  }

  private Map<String, Object> traverseParams(String paramName, Object param, IJsonSchemaValidationProperties spec,
      String parent, int suffix)
      throws CTSException {
    String baseType = getTypeName(spec);
    if (baseType == null) {
      throw new CTSException("Cannot determine type of " + paramName + " (value: " + param + ")");
    }

    if (!(spec instanceof CodegenModel)) {
      // don't overwrite it if it's already a model

      // sometimes it's in lowercase for some reason
      String lowerBaseType = baseType.substring(0, 1).toLowerCase() + baseType.substring(1);
      if (models.containsKey(baseType)) {
        // get the real model if possible
        spec = models.get(baseType);
      } else if (models.containsKey(lowerBaseType)) {
        spec = models.get(lowerBaseType);
      }
    }

    boolean isCodegenModel = spec instanceof CodegenModel;
    boolean isEnum = isEnum(spec);

    String finalParamName = paramName;
    if (paramName.startsWith("_")) {
      finalParamName = paramName.substring(1);
    }

    Map<String, Object> testOut = new HashMap<String, Object>();
    testOut.put("key", finalParamName);
    testOut.put("parentSuffix", suffix - 1);
    testOut.put("suffix", suffix);
    testOut.put("parent", parent);
    testOut.put("objectName", baseType.substring(0, 1).toUpperCase() + baseType.substring(1));

    // we need to set all types to false otherwise mustache will read the one from
    // the parent context and run into a infinite loop
    testOut.put("isObject", false);
    testOut.put("isArray", false);
    testOut.put("isFreeFormObject", false);
    testOut.put("isString", false);
    testOut.put("isInteger", false);
    testOut.put("isDouble", false);
    testOut.put("isBoolean", false);
    testOut.put("isEnum", false);

    if (spec.getIsArray()) {
      List<Object> items = (List<Object>) param;

      List<Object> values = new ArrayList<Object>();
      for (int i = 0; i < items.size(); i++) {
        values.add(traverseParams(paramName + "_" + i, items.get(i), spec.getItems(), paramName, suffix + 1));
      }

      testOut.put("isArray", true);
      testOut.put("value", values);
    } else if (isEnum) {
      testOut.put("isEnum", true);
      testOut.put("value", param);
    } else if (spec.getIsModel() || isCodegenModel) {
      // recursive object
      assert (spec.getHasVars());
      assert (spec.getItems() == null);

      if (isCodegenModel && ((CodegenModel) spec).oneOf.size() > 0) {
        // find a discriminator to handle oneOf
        CodegenModel model = (CodegenModel) spec;
        IJsonSchemaValidationProperties match = findMatchingOneOf(param, model);
        testOut = traverseParams(paramName, param, match, parent, suffix);
        testOut.put("oneOfModel", baseType);
        return testOut;
      }

      Map<String, Object> vars = (Map<String, Object>) param;
      List<Object> values = new ArrayList<Object>();
      for (String varName : vars.keySet()) {
        IJsonSchemaValidationProperties varSpec = null;
        for (IJsonSchemaValidationProperties vs : spec.getVars()) {
          if (vs instanceof CodegenProperty && ((CodegenProperty) vs).baseName.equals(varName)) {
            varSpec = vs;
            break;
          }
        }
        if (varSpec == null) {
          throw new CTSException("Parameter " + varName + " not found in " + paramName
              + ". You might have a type conflict in the spec for " + baseType);
        }

        values.add(traverseParams(varName, vars.get(varName), varSpec, paramName, suffix + 1));
      }
      testOut.put("isObject", true);
      testOut.put("value", values);
    } else if (baseType.equals("Object")) {
      // not var, no item, pure free form
      assert (!spec.getHasVars());
      assert (spec.getItems() == null);

      Map<String, Object> vars = (Map<String, Object>) param;

      List<Object> values = new ArrayList<Object>();
      for (String varName : vars.keySet()) {
        CodegenParameter objSpec = new CodegenParameter();
        objSpec.dataType = inferDataType(vars.get(varName), objSpec, null);
        values.add(traverseParams(varName, vars.get(varName), objSpec, paramName, suffix + 1));
      }

      testOut.put("isFreeFormObject", true);
      testOut.put("value", values);
    } else if (spec.getIsMap()) {
      // free key but only one type

      assert (!spec.getHasVars());
      assert (spec.getItems() != null);

      Map<String, Object> vars = (Map<String, Object>) param;

      List<Object> values = new ArrayList<Object>();
      for (String varName : vars.keySet()) {
        values.add(traverseParams(varName, vars.get(varName), spec.getItems(), paramName, suffix + 1));
      }

      testOut.put("isFreeFormObject", true);
      testOut.put("value", values);
    } else {
      // primitive
      inferDataType(param, null, testOut);
      testOut.put("value", param);
    }
    return testOut;
  }

  private String getTypeName(IJsonSchemaValidationProperties param) {
    if (param instanceof CodegenParameter) {
      return ((CodegenParameter) param).dataType;
    }
    if (param instanceof CodegenProperty) {
      return ((CodegenProperty) param).dataType;
    }
    if (param instanceof CodegenModel) {
      // TODO: try dataType
      return ((CodegenModel) param).classname;
    }
    if (param instanceof CodegenResponse) {
      return ((CodegenResponse) param).dataType;
    }
    return null;
  }

  private boolean isEnum(IJsonSchemaValidationProperties param) {
    if (param instanceof CodegenParameter) {
      return ((CodegenParameter) param).isEnum;
    }
    if (param instanceof CodegenProperty) {
      return ((CodegenProperty) param).isEnum;
    }
    if (param instanceof CodegenModel) {
      return ((CodegenModel) param).isEnum;
    }
    return false;
  }

  private String inferDataType(Object param, CodegenParameter spec, Map<String, Object> output) throws CTSException {
    switch (param.getClass().getSimpleName()) {
      case "String":
        if (spec != null)
          spec.setIsString(true);
        if (output != null)
          output.put("isString", true);
        return "String";
      case "Integer":
        if (spec != null)
          spec.setIsNumber(true);
        if (output != null)
          output.put("isInteger", true);
        return "Integer";
      case "Double":
        if (spec != null)
          spec.setIsNumber(true);
        if (output != null)
          output.put("isDouble", true);
        return "Double";
      case "Boolean":
        if (spec != null)
          spec.setIsBoolean(true);
        if (output != null)
          output.put("isBoolean", true);
        return "Boolean";
      default:
        throw new CTSException("Unknown type: " + param.getClass().getSimpleName());
    }
  }

  private IJsonSchemaValidationProperties findMatchingOneOf(Object param, CodegenModel model) throws CTSException {
    if (param instanceof Map) {
      // for object, check which has the most of property in common

      int maxCount = 0;
      CodegenModel bestOneOf = model.interfaceModels.get(0);
      for (CodegenModel oneOf : model.interfaceModels) {
        if (oneOf.vars.size() == 0) {
          continue;
        }

        Map<String, Object> map = (Map<String, Object>) param;
        int commonCount = 0;
        for (String prop : map.keySet()) {
          for (CodegenProperty propOneOf : oneOf.vars) {
            if (prop.equals(propOneOf.name)) {
              commonCount++;
            }
          }
        }
        if (commonCount > maxCount) {
          maxCount = commonCount;
          bestOneOf = oneOf;
        }
      }
      return bestOneOf;
    }
    if (param instanceof List) {
      // no idea for list
      return null;
    }

    CodegenParameter maybeMatch = new CodegenParameter();
    String paramType = inferDataType(param, maybeMatch, null);
    maybeMatch.dataType = paramType;

    for (String oneOfName : model.oneOf) {
      if (oneOfName.equals(paramType)) {
        return maybeMatch;
      }
    }
    for (CodegenModel oneOf : model.interfaceModels) {
      if (oneOf.dataType.equals(paramType))
        return oneOf;
    }
    return null;
  }

  private Map<String, Request[]> loadCTS() throws JsonParseException, JsonMappingException, IOException {
    LinkedHashMap<String, Request[]> cts = new LinkedHashMap<String, Request[]>();
    File dir = new File("tests/CTS/methods/requests/search");
    for (File f : dir.listFiles()) {
      cts.put(f.getName().replace(".json", ""), Json.mapper().readValue(f, Request[].class));
    }
    cts.entrySet().stream().sorted(Map.Entry.comparingByKey());
    return cts;
  }

  // Client -> operationId -> CodegenOperation
  private HashMap<String, HashMap<String, CodegenOperation>> buildOperations(Map<String, Object> objs) {
    HashMap<String, HashMap<String, CodegenOperation>> result = new HashMap<String, HashMap<String, CodegenOperation>>();
    List<Map<String, Object>> apis = ((Map<String, List<Map<String, Object>>>) objs.get("apiInfo")).get("apis");
    for (Map<String, Object> api : apis) {
      String apiName = (String) api.get("baseName");
      List<CodegenOperation> operations = ((Map<String, List<CodegenOperation>>) api.get("operations"))
          .get("operation");

      HashMap<String, CodegenOperation> allOp = new HashMap<String, CodegenOperation>();
      for (CodegenOperation ope : operations) {
        allOp.put(ope.operationId, ope);
      }
      result.put(apiName, allOp);
    }
    return result;
  }

  /**
   * override with any special text escaping logic to handle unsafe
   * characters so as to avoid code injection
   *
   * @param input String to be cleaned up
   * @return string with unsafe characters removed or escaped
   */
  @Override
  public String escapeUnsafeCharacters(String input) {
    return input;
  }

  /**
   * Escape single and/or double quote to avoid code injection
   *
   * @param input String to be cleaned up
   * @return string with quotation mark removed or escaped
   */
  public String escapeQuotationMark(String input) {
    return input.replace("\"", "\\\"");
  }
}
