package com.algolia.codegen.cts.tests;

import com.algolia.codegen.AlgoliaSwiftGenerator;
import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.util.Json;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.openapitools.codegen.*;

@SuppressWarnings("unchecked")
public class ParametersWithDataType {

  private final Map<String, CodegenModel> models;
  private final String language;
  private final String client;
  private final boolean prettyIndexName;

  public ParametersWithDataType(Map<String, CodegenModel> models, String language, String client, boolean prettyIndexName) {
    this.models = models;
    this.language = language;
    this.client = client;
    this.prettyIndexName = prettyIndexName;
  }

  public void enhanceParameters(Map<String, Object> parameters, Map<String, Object> bundle)
    throws CTSException, JsonMappingException, JsonProcessingException {
    this.enhanceParameters(parameters, bundle, null);
  }

  public Map<String, Object> enhanceParameter(Object param) throws CTSException, JsonMappingException, JsonProcessingException {
    Map<String, Object> testOutput = createDefaultOutput();
    testOutput.put("isRoot", true);
    if (param == null) {
      handleNull(null, testOutput);
    } else if (param instanceof List || param instanceof Map) {
      testOutput.put("isString", true);
      testOutput.put("value", Json.mapper().writeValueAsString(param));
    } else {
      handlePrimitive(param, testOutput, null);
    }
    return testOutput;
  }

  /**
   * @param parameters The object to traverse and annotate with type
   * @param bundle The output object
   * @param operation (optional) The model in which to look for spec
   */
  public void enhanceParameters(Map<String, Object> parameters, Map<String, Object> bundle, CodegenOperation operation)
    throws CTSException, JsonMappingException, JsonProcessingException {
    if (parameters != null && parameters.size() == 0) {
      bundle.put("parameters", "{}");
      return;
    }
    IJsonSchemaValidationProperties spec = null;
    String paramName = null;
    // special case if there is only bodyParam which is not an array
    if (operation != null && operation.allParams.size() == 1 && operation.bodyParams.size() == 1 && !operation.bodyParam.isArray) {
      spec = operation.bodyParam;
      paramName = operation.bodyParam.paramName;
    }

    List<Map<String, Object>> parametersWithDataType = new ArrayList<>();
    Map<String, Object> parametersWithDataTypeMap = new HashMap<>();

    if (paramName == null) {
      if (parameters != null) {
        for (Entry<String, Object> param : parameters.entrySet()) {
          CodegenParameter specParam = null;
          if (operation != null) {
            for (CodegenParameter sp : operation.allParams) {
              if (sp.paramName.equals(param.getKey())) {
                specParam = sp;
                break;
              }
            }
            if (specParam == null) {
              throw new CTSException("Parameter " + param.getKey() + " not found in the root parameter");
            }
          }
          Map<String, Object> paramWithType = traverseParams(param.getKey(), param.getValue(), specParam, "", 0, false);
          parametersWithDataType.add(paramWithType);
          parametersWithDataTypeMap.put((String) paramWithType.get("key"), paramWithType);
        }
      }
    } else {
      Map<String, Object> paramWithType = traverseParams(paramName, parameters, spec, "", 0, false);
      parametersWithDataType.add(paramWithType);
      parametersWithDataTypeMap.put((String) paramWithType.get("key"), paramWithType);
    }

    // Give the stringified version to mustache, for js
    bundle.put("parameters", toJSONWithVar(parameters));
    bundle.put("parametersWithDataType", parametersWithDataType);
    // Also provide a map version for those who know which keys to look for
    bundle.put("parametersWithDataTypeMap", parametersWithDataTypeMap);
  }

  private String toJSONWithVar(Map<String, Object> parameters) throws JsonProcessingException {
    return Json.mapper().writeValueAsString(parameters).replaceAll("\"\\$var: (.*?)\"", "$1");
  }

  private Map<String, Object> traverseParams(
    String paramName,
    Object param,
    IJsonSchemaValidationProperties spec,
    String parent,
    int depth,
    boolean isParentFreeFormObject
  ) throws CTSException {
    if (spec == null) {
      return traverseParamsWithoutSpec(paramName, param, parent, depth);
    }
    String baseType = getTypeName(spec);
    if (baseType == null) {
      throw new CTSException("Cannot determine type of " + paramName + " (value: " + param + ")");
    }

    boolean isCodegenModel = spec instanceof CodegenModel;
    Boolean isRequired = null;

    if (spec instanceof CodegenParameter parameter) {
      isRequired = parameter.required;
    } else if (spec instanceof CodegenProperty property) {
      isRequired = property.required;
    }

    Map<String, Object> testOutput = createDefaultOutput();

    if (!isCodegenModel) {
      // don't overwrite it if it's already a model sometimes it's in lowercase for some reason
      String lowerBaseType = baseType.substring(0, 1).toLowerCase() + baseType.substring(1);
      if (models.containsKey(baseType)) {
        // get the real model if possible
        spec = models.get(baseType);
      } else if (models.containsKey(lowerBaseType)) {
        spec = models.get(lowerBaseType);
      }
      isCodegenModel = spec instanceof CodegenModel;
    }

    boolean hasDefaultValue = false;
    if (spec instanceof CodegenParameter parameter) {
      hasDefaultValue = parameter.defaultValue != null && !parameter.defaultValue.equals("null");
    } else if (spec instanceof CodegenProperty property) {
      hasDefaultValue = property.defaultValue != null && !property.defaultValue.equals("null");
    }

    testOutput.put("key", paramName);
    testOutput.put("useAnonymousKey", !paramName.matches("(.*)_[0-9]+$") && depth != 0);
    testOutput.put("parent", parent);
    testOutput.put("isRoot", "".equals(parent));
    testOutput.put("objectName", getObjectNameForLanguage(baseType));
    testOutput.put("isParentFreeFormObject", isParentFreeFormObject);
    testOutput.put("hasDefaultValue", hasDefaultValue);

    if (isRequired != null) {
      testOutput.put("required", isRequired);
      testOutput.put("goFunctionalParam", !isRequired && depth == 0);
    }

    if (param == null) {
      handleNull(spec, testOutput);
    } else if (param instanceof String && ((String) param).startsWith("$var: ")) {
      // bypass for verbatim variables used in the guides, we don't need to do any validation
      testOutput.put("isVerbatim", true);
      testOutput.put("isString", false);
      testOutput.put("value", ((String) param).substring(6));
    } else if (spec.getIsArray()) {
      handleArray(paramName, param, testOutput, spec, depth);
    } else if (spec.getIsEnum()) {
      handleEnum(param, testOutput);
    } else if (spec.getIsModel() || isCodegenModel) {
      // recursive object
      handleModel(paramName, param, testOutput, spec, baseType, parent, depth, isParentFreeFormObject, isRequired != null && isRequired);
    } else if (baseType.equals("Object")) {
      // not var, no item, pure free form
      handleObject(paramName, param, testOutput, true, depth);
    } else if (spec.getIsMap()) {
      // free key but only one type
      handleMap(paramName, param, testOutput, spec, depth);
    } else {
      handlePrimitive(param, testOutput, spec);
    }

    // for snippets, we want pretty index names, unless they are already pretty
    if (
      prettyIndexName &&
      paramName.equals("indexName") &&
      !((String) testOutput.get("value")).startsWith("<") &&
      !((Boolean) testOutput.getOrDefault("isVerbatim", false))
    ) {
      testOutput.put("value", "<YOUR_INDEX_NAME>");
    }

    return testOutput;
  }

  /** Same method but with inference only */
  private Map<String, Object> traverseParamsWithoutSpec(String paramName, Object param, String parent, int depth) throws CTSException {
    Map<String, Object> testOutput = createDefaultOutput();
    testOutput.put("key", paramName);
    testOutput.put("useAnonymousKey", !paramName.matches("(.*)_[0-9]+$") && depth != 0);
    testOutput.put("parent", parent);
    testOutput.put("isRoot", "".equals(parent));
    // try to infer the type
    try {
      String dataType = inferDataType(param, null, testOutput);
      testOutput.put("objectName", getObjectNameForLanguage(dataType));
    } catch (CTSException e) {
      // ignore the error
    }

    if (param == null) {
      handleNull(null, testOutput);
    } else if (param instanceof String && ((String) param).startsWith("$var: ")) {
      // bypass for verbatim variables used in the guides, we don't need to do any validation
      testOutput.put("isVerbatim", true);
      testOutput.put("isString", false);
      testOutput.put("value", ((String) param).substring(6));
    } else if (param instanceof List) {
      handleArray(paramName, param, testOutput, null, depth);
    } else if (param instanceof Map) {
      handleObject(paramName, param, testOutput, false, depth);
    } else {
      handlePrimitive(param, testOutput, null);
    }
    return testOutput;
  }

  private Map<String, Object> createDefaultOutput() {
    Map<String, Object> testOutput = new HashMap<>();

    // we need to set all types to false otherwise mustache will read the one from the parent
    // context and run into a infinite loop
    testOutput.put("isObject", false);
    testOutput.put("isNullObject", false);
    testOutput.put("isArray", false);
    testOutput.put("isNull", false);
    testOutput.put("isFreeFormObject", false);
    testOutput.put("isParentFreeFormObject", false);
    testOutput.put("isAnyType", false);
    testOutput.put("isString", false);
    testOutput.put("isInteger", false);
    testOutput.put("isLong", false);
    testOutput.put("isDouble", false);
    testOutput.put("isNumber", false);
    testOutput.put("isBoolean", false);
    testOutput.put("isEnum", false);
    testOutput.put("isSimpleObject", false);
    testOutput.put("oneOfModel", false);
    testOutput.put("isAdditionalProperty", false);
    testOutput.put("isPrimitive", false);

    return testOutput;
  }

  private void handleNull(IJsonSchemaValidationProperties spec, Map<String, Object> testOutput) {
    testOutput.put("isPrimitive", true);
    testOutput.put("isNull", true);
    if (spec != null && (spec.getIsModel() || spec instanceof CodegenModel)) {
      testOutput.put("isNullObject", true);
    }
  }

  private void handleArray(String paramName, Object param, Map<String, Object> testOutput, IJsonSchemaValidationProperties spec, int depth)
    throws CTSException {
    List<Object> items = (List<Object>) param;

    List<Object> values = new ArrayList<>();
    for (int i = 0; i < items.size(); i++) {
      values.add(traverseParams(paramName + "_" + i, items.get(i), spec == null ? null : spec.getItems(), paramName, depth + 1, false));
    }

    testOutput.put("isArray", true);
    testOutput.put("value", values);
  }

  private void handleEnum(Object param, Map<String, Object> testOutput) {
    testOutput.put("isEnum", true);
    testOutput.put("value", param);
  }

  private void handleModel(
    String paramName,
    Object param,
    Map<String, Object> testOutput,
    IJsonSchemaValidationProperties spec,
    String baseType,
    String parent,
    int depth,
    boolean isParentFreeFormObject,
    boolean parentIsRequired
  ) throws CTSException {
    if (!spec.getHasVars()) {
      // In this case we might have a complex `allOf`, we will first check if it exists
      CodegenComposedSchemas composedSchemas = spec.getComposedSchemas();

      if (composedSchemas != null) {
        List<CodegenProperty> allOf = composedSchemas.getAllOf();

        if (allOf != null && !allOf.isEmpty()) {
          traverseParams(paramName, param, allOf.get(0), parent, depth, false);

          return;
        }
      }
      // We only throw if there is no `composedSchemas`, because `oneOf` can also be handled below
      else {
        throw new CTSException("Spec has no vars.");
      }
    }

    if (spec.getItems() != null) {
      throw new CTSException("Spec has items.");
    }

    if (spec instanceof CodegenModel && ((CodegenModel) spec).oneOf.size() > 0) {
      // find a discriminator to handle oneOf
      CodegenModel model = (CodegenModel) spec;
      IJsonSchemaValidationProperties match = findMatchingOneOf(param, model);

      testOutput.putAll(traverseParams(paramName, param, match, parent, depth, isParentFreeFormObject));

      Map<String, Object> oneOfModel = new HashMap<>();
      IJsonSchemaValidationProperties current = match;
      String typeName = getTypeName(current);
      boolean isList = false;
      if (language.equals("go") || language.equals("swift")) {
        typeName = Helpers.capitalize(getObjectNameForLanguage(typeName));
        while (current.getItems() != null) {
          current = current.getItems();
          typeName += "Of" + Helpers.capitalize(getObjectNameForLanguage(getTypeName(current)));
          isList = true;
        }
      } else {
        while (current.getItems() != null) {
          current = current.getItems();
          typeName += "Of" + Helpers.capitalize(getTypeName(current));
          isList = true;
        }
      }

      boolean useExplicitName;
      CodegenComposedSchemas composedSchemas = model.getComposedSchemas();
      if (composedSchemas != null && composedSchemas.getOneOf() != null && !composedSchemas.getOneOf().isEmpty()) {
        useExplicitName = Helpers.shouldUseExplicitOneOfName(composedSchemas.getOneOf().stream().map(this::getTypeName).toList());
      } else {
        useExplicitName = Helpers.shouldUseExplicitOneOfName(model.oneOf);
      }

      typeName = getTransformedParamName(typeName);
      baseType = getTransformedParamName(baseType);

      oneOfModel.put("parentClassName", Helpers.capitalize(baseType));
      oneOfModel.put("type", typeName);
      oneOfModel.put("x-one-of-explicit-name", useExplicitName);
      oneOfModel.put("hasWrapper", isList || isString(current) || current.getIsNumber() || current.getIsBoolean());
      testOutput.put("oneOfModel", oneOfModel);
      // use required from the parent since oneOf don't have that property
      testOutput.put("required", parentIsRequired);
      return;
    }

    Map<String, Object> vars = (Map<String, Object>) param;
    List<Map<String, Object>> values = new ArrayList<>();
    List<Map<String, Object>> additionalPropertyValues = new ArrayList<>();
    for (Entry<String, Object> entry : vars.entrySet()) {
      IJsonSchemaValidationProperties varSpec = null;
      for (CodegenProperty vs : spec.getVars()) {
        if (vs.baseName.equals(entry.getKey())) {
          varSpec = vs;
          break;
        }
      }
      if (varSpec == null) {
        if (spec.getAdditionalPropertiesIsAnyType()) {
          // we hit an additionalProperties, infer it's type
          CodegenParameter additionalPropertiesSpec = new CodegenParameter();
          additionalPropertiesSpec.dataType = inferDataType(entry.getValue(), additionalPropertiesSpec, null);
          Map<String, Object> value = traverseParams(
            entry.getKey(),
            entry.getValue(),
            additionalPropertiesSpec,
            paramName,
            depth + 1,
            false
          );
          value.put("isAdditionalProperty", true);
          values.add(value);
        } else {
          throw new CTSException(
            "Parameter '" +
            entry.getKey() +
            "' not found in '" +
            paramName +
            "'. Available properties are: " +
            spec
              .getVars()
              .stream()
              .map(v -> v.baseName)
              .collect(Collectors.joining(", ")) +
            (spec.getAdditionalPropertiesIsAnyType() ? " (and any additional properties)" : "") +
            ". Or you might have a type conflict in the spec for '" +
            baseType +
            "'"
          );
        }
      } else {
        Map<String, Object> transformedParam = traverseParams(entry.getKey(), entry.getValue(), varSpec, paramName, depth + 1, false);
        values.add(transformedParam);
      }
    }

    if (language.equals("swift")) {
      // Store ordered params from the spec
      var orderedParams = spec
        .getVars()
        .stream()
        .map(v -> v.baseName)
        .toList();

      // Create a map to store the indices of each string in orderedParams
      Map<String, Integer> indexMap = IntStream.range(0, orderedParams.size())
        .boxed()
        .collect(Collectors.toMap(orderedParams::get, i -> i));

      values.sort(Comparator.comparing(value -> indexMap.getOrDefault((String) value.get("key"), Integer.MAX_VALUE)));
    }

    var hasAdditionalProperties = values
      .stream()
      .anyMatch(el -> el.containsKey("isAdditionalProperty") && (boolean) el.get("isAdditionalProperty"));
    testOutput.put("hasAdditionalProperties", hasAdditionalProperties);

    testOutput.put("isObject", true);
    testOutput.put("value", values);
    testOutput.put("additionalProperties", additionalPropertyValues);
  }

  private String getTransformedParamName(String paramName) {
    if (language.equals("swift")) {
      paramName = AlgoliaSwiftGenerator.prefixReservedModelName(paramName, client);
    }
    return paramName;
  }

  private void handleObject(String paramName, Object param, Map<String, Object> testOutput, boolean isSimpleObject, int depth)
    throws CTSException {
    Map<String, Object> vars = (Map<String, Object>) param;

    List<Object> values = new ArrayList<>();
    for (Entry<String, Object> entry : vars.entrySet()) {
      CodegenParameter objSpec = new CodegenParameter();
      objSpec.dataType = inferDataType(entry.getValue(), objSpec, null);
      values.add(traverseParams(entry.getKey(), entry.getValue(), objSpec, paramName, depth + 1, true));
    }

    testOutput.put("isSimpleObject", isSimpleObject);
    testOutput.put("isFreeFormObject", true);
    testOutput.put("value", values);
  }

  private void handleMap(String paramName, Object param, Map<String, Object> testOutput, IJsonSchemaValidationProperties spec, int depth)
    throws CTSException {
    if (spec.getHasVars()) {
      throw new CTSException("Spec has vars.");
    }

    Map<String, Object> vars = (Map<String, Object>) param;

    List<Object> values = new ArrayList<>();

    CodegenProperty items = spec.getItems();

    for (Entry<String, Object> entry : vars.entrySet()) {
      IJsonSchemaValidationProperties itemType = items;

      // The generator consider a free form object type as an `object`, which
      // is wrong in our case, so we infer it to explore the right path in the traverseParams
      // function, but we keep the any type for the CTS.
      if (items == null || (items.openApiType.equals("object") && items.isFreeFormObject)) {
        CodegenParameter maybeMatch = new CodegenParameter();
        String paramType = inferDataType(entry.getValue(), maybeMatch, null);

        maybeMatch.dataType = paramType;
        maybeMatch.isAnyType = true;
        itemType = maybeMatch;
      }

      values.add(traverseParams(entry.getKey(), entry.getValue(), itemType, paramName, depth + 1, true));
    }

    testOutput.put("isFreeFormObject", true);
    testOutput.put("value", values);
  }

  private void handlePrimitive(Object param, Map<String, Object> testOutput, IJsonSchemaValidationProperties spec) throws CTSException {
    // some int64 are not considered primitive, thanks a lot openapi
    if (spec != null && (spec.getIsPrimitiveType() || spec.getIsLong())) {
      transferPrimitiveData(spec, testOutput);
    } else {
      inferDataType(param, null, testOutput);
      if (spec != null && spec.getIsAnyType()) {
        testOutput.put("isAnyType", true);
      }
    }
    testOutput.put("isPrimitive", true);
    testOutput.put("value", param);
  }

  private String getTypeName(IJsonSchemaValidationProperties param) {
    String typeName = param.getDataType();
    if (param instanceof CodegenModel parameter) {
      typeName = parameter.classname;
    }

    if (language.equals("scala") && typeName.equals("List")) {
      typeName = "Seq";
    }

    return typeName;
  }

  private boolean isString(IJsonSchemaValidationProperties param) {
    if (param instanceof CodegenParameter parameter) {
      return parameter.isString;
    }
    if (param instanceof CodegenProperty parameter) {
      return parameter.isString;
    }
    return false;
  }

  private String getObjectNameForLanguage(String objectName) {
    switch (language) {
      case "csharp":
        switch (objectName) {
          case "Map":
            return "Dictionary";
          case "Integer":
            return "int";
          case "String":
            return "string";
        }
        break;
      case "go":
        switch (objectName) {
          case "String":
            return "string";
          case "Double":
            return "float64";
          case "Integer":
            return "int32";
          case "Long":
            return "int64";
          case "Boolean":
            return "bool";
          case "List":
            return "Array";
          case "Object":
            return "map[string]any";
          case "range":
            return "ModelRange"; // range is a reserved keyword
        }
        break;
      case "swift":
        switch (objectName) {
          case "List":
            return "array";
          default:
            return Helpers.capitalize(getTransformedParamName(objectName));
        }
    }

    return Helpers.capitalize(objectName);
  }

  private String inferDataType(Object param, CodegenParameter spec, Map<String, Object> output) throws CTSException {
    if (param == null) {
      if (spec != null) spec.setIsNull(true);
      if (output != null) output.put("isNull", true);
      return "null";
    }
    switch (param.getClass().getSimpleName()) {
      case "String":
        if (spec != null) spec.setIsString(true);
        if (output != null) output.put("isString", true);
        return "String";
      case "Integer":
        if (spec != null) spec.setIsNumber(true);
        if (output != null) {
          output.put("isInteger", true);
          output.put("isNumber", true);
        }
        return "Integer";
      case "Long":
        if (spec != null) spec.setIsNumber(true);
        if (output != null) {
          output.put("isLong", true);
          output.put("isNumber", true);
        }
        return "Long";
      case "Double":
        if (spec != null) spec.setIsNumber(true);
        if (output != null) {
          output.put("isDouble", true);
          output.put("isNumber", true);
        }
        return "Double";
      case "Boolean":
        if (spec != null) spec.setIsBoolean(true);
        if (output != null) output.put("isBoolean", true);
        return "Boolean";
      case "ArrayList":
        if (spec != null) {
          spec.setIsArray(true);
          // This is just to find the correct path in `handlePrimitive`, but it's not always the
          // real type
          // FIXME: this set voluntarily the type to string, which will fail
          // We need to infer the real type
          CodegenProperty baseItems = new CodegenProperty();
          baseItems.dataType = "String";
          spec.setItems(baseItems);
        }
        if (output != null) output.put("isArray", true);
        return "List";
      case "LinkedHashMap":
        if (spec != null) spec.baseType = "Object";
        if (output != null) output.put("isFreeFormObject", true);
        return "Object";
      default:
        throw new CTSException("Unknown type: " + param.getClass().getSimpleName());
    }
  }

  private void transferPrimitiveData(IJsonSchemaValidationProperties spec, Map<String, Object> output) throws CTSException {
    switch (getTypeName(spec).toLowerCase()) {
      case "string":
        output.put("isString", true);
        break;
      case "uuid":
        output.put("isString", true);
        break;
      case "integer":
        output.put("isInteger", true);
        output.put("isNumber", true);
        break;
      case "long":
        output.put("isLong", true);
        output.put("isNumber", true);
        break;
      case "double":
        output.put("isDouble", true);
        output.put("isNumber", true);
        break;
      case "boolean":
        output.put("isBoolean", true);
        break;
      case "oas_any_type_not_mapped":
        output.put("isAnyType", true);
        output.put("isFreeFormObject", true);
        break;
      default:
        throw new CTSException("Unknown primitive: " + getTypeName(spec));
    }
  }

  private IJsonSchemaValidationProperties findMatchingOneOf(Object param, CodegenModel model) throws CTSException {
    if (param instanceof Map) {
      // for object, check which has the most of property in common
      int maxCount = 0;
      CodegenModel bestOneOf = model.interfaceModels.get(0);
      oneOfLoop: for (CodegenModel oneOf : model.interfaceModels) {
        if (oneOf.vars.size() == 0) {
          continue;
        }

        Map<String, Object> map = (Map<String, Object>) param;

        // if a required property is not in param, it's not a match
        for (CodegenProperty prop : oneOf.requiredVars) {
          if (!map.containsKey(prop.baseName)) {
            continue oneOfLoop;
          }
        }

        int commonCount = 0;
        for (String prop : map.keySet()) {
          for (CodegenProperty propOneOf : oneOf.vars) {
            if (prop.equals(propOneOf.baseName) && couldMatchEnum(map.get(prop), propOneOf)) {
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

    for (CodegenProperty prop : model.getComposedSchemas().getOneOf()) {
      // find the correct list
      if (param instanceof List && prop.getIsArray()) {
        return prop;
      }

      // find the correct enum
      if (param instanceof String && prop.getIsEnumOrRef() && couldMatchEnum(param, prop)) {
        return prop;
      }
    }

    CodegenParameter maybeMatch = new CodegenParameter();
    String paramType = inferDataType(param, maybeMatch, null);
    maybeMatch.dataType = paramType;

    boolean hasFloat = false;
    for (String oneOfName : model.oneOf) {
      if (oneOfName.equals(paramType)) {
        return maybeMatch;
      }
      if (oneOfName.equals("Float") || oneOfName.equals("Double")) {
        hasFloat = true;
      }
    }

    // If there is a number, try to use it as other number type, in the order
    // Integer, Long, Float, Double
    if (hasFloat && (paramType.equals("Integer") || paramType.equals("Long") || paramType.equals("Double"))) {
      return maybeMatch;
    }

    if (model == null || model.interfaceModels == null) {
      return maybeMatch;
    }

    for (CodegenModel oneOf : model.interfaceModels) {
      // Somehow the dataType can be in lower case?
      if (oneOf.dataType.equalsIgnoreCase(paramType)) {
        return oneOf;
      }
    }

    return maybeMatch;
  }

  // If the model is an enum and contains a valid list of allowed values,
  // it will check that 'value' is in the list.
  // Otherwise return true by default to avoid false negative.
  private boolean couldMatchEnum(Object value, CodegenProperty model) {
    if (!model.getIsEnumOrRef() || model.allowableValues == null || !model.allowableValues.containsKey("values")) return true;
    Object values = model.allowableValues.get("values");
    if (!(values instanceof List)) return true;

    return ((List) values).contains(value);
  }
}
