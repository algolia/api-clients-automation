package com.algolia.codegen.utils;

import java.io.File;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.OperationsMap;

public class OrphanDestroyer {

  private static Set<String> primitiveModels = new HashSet<>(Arrays.asList("object", "array", "string", "boolean", "integer"));

  private Map<String, CodegenModel> models;
  private HashSet<String> visitedModels;

  private OrphanDestroyer(Map<String, CodegenModel> models) {
    this.visitedModels = new HashSet<>();
    this.models = models;
  }

  private CodegenModel getModel(String name) {
    // openapi generator returns some weird error when looking for primitive type, so we filter them
    // by hand
    if (primitiveModels.contains(name)) {
      return null;
    }

    return models.get(name);
  }

  private CodegenModel propertyToModel(CodegenProperty prop) {
    return prop == null ? null : getModel(prop.openApiType);
  }

  private void exploreProperties(CodegenModel model, List<CodegenProperty> properties) {
    for (CodegenProperty property : properties) {
      CodegenModel propModel = propertyToModel(property);
      if (propModel != null && !visitedModels.contains(propModel.name)) {
        System.out.println("Visiting property: " + propModel.name + " from " + model.name);
        visitedModels.add(propModel.name);
        visitModelRecursive(propModel);
      }
      CodegenModel itemsModel = propertyToModel(property.mostInnerItems);
      if (itemsModel != null && !visitedModels.contains(itemsModel.name)) {
        System.out.println("Visiting item: " + itemsModel.name + " from " + model.name);
        visitedModels.add(itemsModel.name);
        visitModelRecursive(itemsModel);
      }
    }
  }

  private void visitModelRecursive(CodegenModel model) {
    exploreProperties(model, model.getVars());
    if (model.getComposedSchemas() != null && model.getComposedSchemas().getOneOf() != null) {
      exploreProperties(model, model.getComposedSchemas().getOneOf());
    }
  }

  private static Map<String, CodegenModel> convertToMap(List<ModelMap> models) {
    Map<String, CodegenModel> modelsMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    for (ModelMap modelMap : models) {
      CodegenModel model = modelMap.getModel();
      modelsMap.put(model.name, model);
    }
    return modelsMap;
  }

  private void exploreGraph(OperationsMap operations) {
    for (CodegenModel model : models.values()) {
      visitModelRecursive(model);
    }

    for (CodegenOperation ope : operations.getOperations().getOperation()) {
      if (ope.returnType != null) {
        CodegenModel returnType = getModel(ope.returnBaseType);
        if (returnType != null) {
          visitedModels.add(returnType.name);
        }
      }
      for (CodegenParameter param : ope.allParams) {
        CodegenModel paramType = getModel(param.baseType != null ? param.baseType : param.dataType);
        if (paramType != null) {
          visitedModels.add(paramType.name);
        }
        CodegenModel itemsModel = propertyToModel(param.mostInnerItems);
        if (itemsModel != null) {
          visitedModels.add(itemsModel.name);
        }
      }
    }
  }

  /** remove all the unused models, most likely the sub models of allOf */
  public static void removeOrphans(CodegenConfig config, OperationsMap operations, List<ModelMap> allModels, boolean keepError) {
    // visit all the models that are accessible from:
    // - the properties of a model (needs recursive search)
    // - the return type of an operation
    // - the parameters of an operation

    OrphanDestroyer orphanDestroyer = new OrphanDestroyer(convertToMap(allModels));

    orphanDestroyer.exploreGraph(operations);

    List<String> toRemove = new ArrayList<>();
    for (String modelName : orphanDestroyer.models.keySet()) {
      if (keepError && modelName.equals("ErrorBase")) {
        continue;
      }
      if (!orphanDestroyer.visitedModels.contains(modelName)) {
        toRemove.add(modelName);
      }
    }

    String templateName = config.modelTemplateFiles().keySet().iterator().next();

    for (String modelName : toRemove) {
      String filename = config.modelFilename(templateName, modelName);
      File file = new File(filename);
      if (file.exists()) {
        file.delete();
        System.out.println("Removed orphan model: " + modelName);
      }
    }
  }

  public static void removeOrphans(CodegenConfig config, OperationsMap operations, List<ModelMap> allModels) {
    removeOrphans(config, operations, allModels, false);
  }
}
