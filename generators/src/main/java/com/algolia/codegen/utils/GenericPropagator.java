package com.algolia.codegen.utils;

import com.algolia.codegen.AlgoliaSwiftGenerator;
import java.util.*;
import java.util.function.Function;
import org.openapitools.codegen.*;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class GenericPropagator {

  private static Set<String> primitiveModels = new HashSet<>(Arrays.asList("object", "array", "string", "boolean", "integer"));

  // Only static use of this class
  private GenericPropagator() {}

  private static void setVendorExtension(IJsonSchemaValidationProperties property, String key, Object value) {
    if (property instanceof CodegenModel model) {
      model.vendorExtensions.put(key, value);
    } else if (property instanceof CodegenProperty prop) {
      prop.vendorExtensions.put(key, value);
    }
  }

  /**
   * Add the property x-propagated-generic to a model or property, meaning it should be replaced
   * with T directly
   */
  private static void setPropagatedGeneric(IJsonSchemaValidationProperties property) {
    setVendorExtension(property, "x-propagated-generic", true);
  }

  /**
   * Add the property x-has-child-generic to a model or property, meaning one of its members is
   * generic and it should propagate the T
   */
  private static void setHasChildGeneric(IJsonSchemaValidationProperties property) {
    setVendorExtension(property, "x-has-child-generic", true);
  }

  /**
   * @return true if the vendor extensions of the property contains either x-propagated-generic or
   *     x-has-child-generic
   */
  private static boolean hasGeneric(IJsonSchemaValidationProperties property) {
    Map<String, Object> vendorExtensions;
    if (property instanceof CodegenModel model) {
      vendorExtensions = model.vendorExtensions;
    } else if (property instanceof CodegenProperty prop) {
      vendorExtensions = prop.vendorExtensions;
    } else {
      return false;
    }
    return (
      (boolean) vendorExtensions.getOrDefault("x-propagated-generic", false) ||
      (boolean) vendorExtensions.getOrDefault("x-has-child-generic", false) ||
      (boolean) vendorExtensions.getOrDefault("x-is-generic", false)
    );
  }

  private static CodegenModel propertyToModel(Map<String, CodegenModel> models, CodegenProperty prop) {
    // openapi generator returns some weird error when looking for primitive type,
    // so we filter them by hand
    if (prop == null || primitiveModels.contains(prop.openApiType) || !models.containsKey(prop.openApiType)) {
      return null;
    }
    return models.get(prop.openApiType);
  }

  private static boolean markPropagatedGeneric(
    IJsonSchemaValidationProperties model,
    Function<IJsonSchemaValidationProperties, List<CodegenProperty>> getVar,
    boolean skipOneOf
  ) {
    CodegenProperty items = model.getItems();
    // Skip one-of types
    if (skipOneOf) {
      return false;
    }
    // if items itself isn't generic, we recurse on its items and properties until we reach the
    // end or find a generic property
    if (items != null && (hasGeneric(items) || markPropagatedGeneric(items, getVar, skipOneOf))) {
      setPropagatedGeneric(model);
      return true;
    }
    for (CodegenProperty variable : getVar.apply(model)) {
      // same thing for the variable, if it's not a generic, we recurse on it until we find one
      if (hasGeneric(items) || markPropagatedGeneric(variable, getVar, skipOneOf)) {
        setPropagatedGeneric(model);
        return true;
      }
    }
    return false;
  }

  private static boolean propagateGenericRecursive(
    Map<String, CodegenModel> models,
    IJsonSchemaValidationProperties property,
    Function<IJsonSchemaValidationProperties, List<CodegenProperty>> getVar
  ) {
    CodegenProperty items = property.getItems();
    // if items itself isn't generic, we recurse on its items and properties (and it's
    // equivalent model if we find one) until we reach the end or find a generic property.
    // We need to check the model too because the tree isn't complete sometime, depending on the ref
    // in the spec, so we get the model with the same name and recurse.
    if (
      items != null &&
      ((hasGeneric(items) || propagateGenericRecursive(models, items, getVar) || hasGeneric(propertyToModel(models, items))))
    ) {
      setHasChildGeneric(property);
      return true;
    }
    for (CodegenProperty variable : getVar.apply(property)) {
      // same thing for the variable
      if (hasGeneric(variable) || propagateGenericRecursive(models, variable, getVar) || hasGeneric(propertyToModel(models, variable))) {
        setHasChildGeneric(property);
        return true;
      }
    }
    return false;
  }

  private static void setGenericToComposedSchema(
    Map<String, CodegenModel> models,
    CodegenModel model,
    List<CodegenProperty> composedSchemas
  ) {
    if (composedSchemas == null) {
      return;
    }
    for (CodegenProperty prop : composedSchemas) {
      if (hasGeneric(prop) || hasGeneric(propertyToModel(models, prop))) {
        setHasChildGeneric(model);
        setHasChildGeneric(prop);
      }
    }
  }

  private static void propagateToComposedSchema(Map<String, CodegenModel> models, CodegenModel model) {
    CodegenComposedSchemas composedSchemas = model.getComposedSchemas();
    if (composedSchemas == null) {
      return;
    }
    setGenericToComposedSchema(models, model, composedSchemas.getOneOf());
    setGenericToComposedSchema(models, model, composedSchemas.getAllOf());
    setGenericToComposedSchema(models, model, composedSchemas.getAnyOf());
  }

  private static Map<String, CodegenModel> convertToMap(String language, String client, Map<String, ModelsMap> models) {
    Map<String, CodegenModel> modelsMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    for (ModelsMap modelMap : models.values()) {
      // modelContainers always have 1 and only 1 model in our specs
      CodegenModel model = modelMap.getModels().get(0).getModel();
      String modelName = model.name;
      if (language.equals("swift") && !client.equals("search")) {
        modelName = AlgoliaSwiftGenerator.prefixReservedModelName(modelName, client);
      }
      modelsMap.put(modelName, model);
    }
    return modelsMap;
  }

  private static Map<String, CodegenModel> convertToMap(String language, String client, List<ModelMap> models) {
    Map<String, CodegenModel> modelsMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    for (ModelMap modelMap : models) {
      CodegenModel model = modelMap.getModel();
      String modelName = model.name;
      if (language.equals("swift") && !client.equals("search")) {
        modelName = AlgoliaSwiftGenerator.prefixReservedModelName(modelName, client);
      }
      modelsMap.put(modelName, model);
    }
    return modelsMap;
  }

  /**
   * Models and their members will be marked with either x-propagated-generic or x-has-child-generic
   */
  public static void propagateGenericsToModels(String language, String client, Map<String, ModelsMap> modelsMap, boolean skipOneOf) {
    // We propagate generics in two phases:
    // 1. We mark the direct parent of the generic model to replace it with T
    // 2. We tell each parent with generic properties to pass that generic type all the way down

    Map<String, CodegenModel> models = convertToMap(language, client, modelsMap);

    // we don't know in which order the model will come, so we iterate multiple times to make sure
    // models at any depth are propagated
    for (int i = 0; i < 5; i++) {
      for (CodegenModel model : models.values()) {
        markPropagatedGeneric(model, m -> m.getVars(), skipOneOf);
        markPropagatedGeneric(model, m -> m.getRequiredVars(), skipOneOf);
      }

      for (CodegenModel model : models.values()) {
        propagateGenericRecursive(models, model, m -> m.getVars());
        propagateGenericRecursive(models, model, m -> m.getRequiredVars());
      }

      for (CodegenModel model : models.values()) {
        propagateToComposedSchema(models, model);
      }
    }
  }

  public static void propagateGenericsToModels(Map<String, ModelsMap> modelsMap) {
    propagateGenericsToModels(modelsMap, false);
  }

  public static void propagateGenericsToModels(Map<String, ModelsMap> modelsMap, boolean skipOneOf) {
    propagateGenericsToModels("dontcare", "dontcare", modelsMap, false);
  }

  public static void propagateGenericsToModels(String language, String client, Map<String, ModelsMap> modelsMap) {
    propagateGenericsToModels(language, client, modelsMap, false);
  }

  /** Mark operations with a generic return type with x-is-generic */
  public static void propagateGenericsToOperations(OperationsMap operations, List<ModelMap> allModels) {
    propagateGenericsToOperations("dontcare", "dontcare", operations, allModels);
  }

  public static void propagateGenericsToOperations(String language, String client, OperationsMap operations, List<ModelMap> allModels) {
    Map<String, CodegenModel> models = convertToMap(language, client, allModels);
    for (CodegenOperation ope : operations.getOperations().getOperation()) {
      if (ope.returnType == null) {
        continue;
      }
      CodegenModel returnType = models.get(ope.returnType);
      if (returnType != null && hasGeneric(returnType)) {
        ope.vendorExtensions.put("x-is-generic", true);
        // we use {{#optionalParams.0}} to check for optionalParams, so we loose the
        // vendorExtensions at the operation level
        if (!ope.optionalParams.isEmpty()) {
          ope.optionalParams.get(0).vendorExtensions.put("x-is-generic", true);
        }
      }
    }
  }
}
