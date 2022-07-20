package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class GenericPropagator {

  // Only static use of this class
  private GenericPropagator() {}

  /**
   * Add the property x-true-generic to a model or property, meaning it should be replaced with T
   * directly
   */
  private static void setIsTrueGeneric(IJsonSchemaValidationProperties property) {
    if (property instanceof CodegenModel) {
      System.out.println("model is true generic " + ((CodegenModel) property).name);
      ((CodegenModel) property).vendorExtensions.put("x-true-generic", true);
    } else if (property instanceof CodegenProperty) {
      System.out.println("property is true generic " + ((CodegenProperty) property).name);
      ((CodegenProperty) property).vendorExtensions.put("x-true-generic", true);
    }
  }

  /**
   * Add the property x-has-child-generic to a model or property, meaning one of it's members is
   * generic and it should propagate the T
   */
  private static void setHasChildGeneric(IJsonSchemaValidationProperties property) {
    if (property instanceof CodegenModel) {
      System.out.println("model has child generic " + ((CodegenModel) property).name);
      ((CodegenModel) property).vendorExtensions.put("x-has-child-generic", true);
    } else if (property instanceof CodegenProperty) {
      System.out.println("property has child generic " + ((CodegenProperty) property).name);
      ((CodegenProperty) property).vendorExtensions.put("x-has-child-generic", true);
    }
  }

  private static boolean hasGeneric(IJsonSchemaValidationProperties property) {
    if (property instanceof CodegenModel) {
      return (
        (boolean) ((CodegenModel) property).vendorExtensions.getOrDefault("x-true-generic", false) ||
        (boolean) ((CodegenModel) property).vendorExtensions.getOrDefault("x-has-child-generic", false)
      );
    } else if (property instanceof CodegenProperty) {
      return (
        (boolean) ((CodegenProperty) property).vendorExtensions.getOrDefault("x-true-generic", false) ||
        (boolean) ((CodegenProperty) property).vendorExtensions.getOrDefault("x-has-child-generic", false)
      );
    }
    return false;
  }

  private static CodegenModel propertyToModel(Map<String, ModelsMap> models, CodegenProperty prop) {
    // openapi generator returns some weird error when looking for primitive type,
    // so we filter them by hand
    if (prop == null || prop.openApiType.equals("boolean") || prop.openApiType.equals("object") || !models.containsKey(prop.openApiType)) {
      return null;
    }
    ModelsMap map = models.get(prop.openApiType);
    return map.getModels().get(0).getModel();
  }

  private static boolean markTrueGeneric(Map<String, ModelsMap> models, IJsonSchemaValidationProperties model) {
    CodegenProperty items = model.getItems();
    if (items != null && ((boolean) items.vendorExtensions.getOrDefault("x-is-generic", false) || markTrueGeneric(models, items))) {
      setIsTrueGeneric(model);
      return true;
    }
    for (CodegenProperty var : model.getVars()) {
      if ((boolean) var.vendorExtensions.getOrDefault("x-is-generic", false) || markTrueGeneric(models, var)) {
        setIsTrueGeneric(model);
        return true;
      }
    }
    return false;
  }

  private static boolean propagateGeneric(Map<String, ModelsMap> models, IJsonSchemaValidationProperties property) {
    // check the item
    CodegenProperty items = property.getItems();
    if (items != null && ((hasGeneric(items) || propagateGeneric(models, items) || hasGeneric(propertyToModel(models, items))))) {
      setHasChildGeneric(property);
      return true;
    }
    // recurse on vars
    for (CodegenProperty var : property.getVars()) {
      if (hasGeneric(var) || propagateGeneric(models, var) || hasGeneric(propertyToModel(models, var))) {
        setHasChildGeneric(property);
        return true;
      }
    }
    return false;
  }

  /** Models and their members will be marked with either x-true-generic or x-has-child-generic */
  public static void propagateGenericsToModels(Map<String, ModelsMap> models) {
    // We propagate generics in two phases:
    // 1. We mark the direct parent of the generic model to replace it with T
    // 2. We tell each parent with generic properties to pass that generic type all the way down

    for (ModelsMap modelContainer : models.values()) {
      CodegenModel model = modelContainer.getModels().get(0).getModel();
      markTrueGeneric(models, model);
    }

    for (ModelsMap modelContainer : models.values()) {
      CodegenModel model = modelContainer.getModels().get(0).getModel();
      propagateGeneric(models, model);
    }
  }

  /** Mark operations with a generic return type with x-is-generic */
  public static void propagateGenericsToOperations(OperationsMap operations, List<ModelMap> models) {
    for (CodegenOperation ope : operations.getOperations().getOperation()) {
      for (ModelMap modelMap : models) {
        CodegenModel model = modelMap.getModel();
        if (ope.returnType.toLowerCase().equals(model.name.toLowerCase()) && hasGeneric(model)) {
          ope.vendorExtensions.put("x-is-generic", true);
          // we use {{#optionalParams.0}} to check for optionalParams, so we loose the
          // vendorExtensions at the operation level
          if (ope.optionalParams.size() > 0) {
            ope.optionalParams.get(0).vendorExtensions.put("x-is-generic", true);
          }
        }
      }
    }
  }
}
