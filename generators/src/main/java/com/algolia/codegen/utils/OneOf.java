package com.algolia.codegen.utils;

import java.util.*;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.model.ModelsMap;

public class OneOf {

  private OneOf() {
    // Empty.
  }

  public static void updateModelsOneOf(Map<String, ModelsMap> models, String modelPackage) {
    // first, propagate the discriminator of allOf to the parent
    for (ModelsMap modelContainer : models.values()) {
      var model = modelContainer.getModels().get(0).getModel();
      if (model.getComposedSchemas() != null && model.getComposedSchemas().getAllOf() != null) {
        for (CodegenProperty prop : model.getComposedSchemas().getAllOf()) {
          if (prop.vendorExtensions.containsKey("x-discriminator-fields")) {
            model.vendorExtensions.put("x-discriminator-fields", prop.vendorExtensions.get("x-discriminator-fields"));
          }
        }
      }
    }

    for (ModelsMap modelContainer : models.values()) {
      // modelContainers always have 1 and only 1 model in our specs
      var model = modelContainer.getModels().get(0).getModel();
      if (model.oneOf.isEmpty()) continue;
      markOneOfChildren(models, model);
      generateSealedChildren(models, modelPackage, model);
      model.vendorExtensions.put("x-is-one-of", true);
      model.vendorExtensions.put("x-one-of-explicit-name", Helpers.shouldUseExplicitOneOfName(model.oneOf));
    }
  }

  public static void generateSealedChildren(Map<String, ModelsMap> models, String modelPackage, CodegenModel model) {
    var sealedChilds = new ArrayList<>();
    for (String oneOf : model.oneOf) {
      ModelsMap modelsMap = models.get(oneOf);
      if (modelsMap != null) {
        CodegenModel compoundModel = modelsMap.getModels().get(0).getModel();
        compoundModel.vendorExtensions.put("x-one-of-explicit-name", compoundModel.classname);
        compoundModel.vendorExtensions.put("x-fully-qualified-classname", modelPackage + "." + compoundModel.classname);
        compoundModel.vendorExtensions.put("x-classname-or-alias", compoundModel.classname + "Impl");
        sealedChilds.add(compoundModel);
      } else {
        CodegenModel newModel = new CodegenModel();
        String name = oneOf.replace("<", "Of").replace(">", "");
        newModel.setClassname(name + "Wrapper");
        newModel.setDescription(model.classname + " as " + oneOf);
        CodegenProperty property = new CodegenProperty();
        property.setName("value");
        property.setRequired(true);
        property.setDatatypeWithEnum(oneOf);
        newModel.setVars(Collections.singletonList(property));
        newModel.vendorExtensions.put("x-is-number", newModel.isNumber);
        newModel.vendorExtensions.put("x-one-of-explicit-name", isNumberType(oneOf) ? "Number" : name);
        newModel.vendorExtensions.put("x-fully-qualified-classname", newModel.classname);
        sealedChilds.add(newModel);
      }
    }
    model.vendorExtensions.put("x-sealed-childs", sealedChilds);
  }

  private static void markOneOfChildren(Map<String, ModelsMap> models, CodegenModel model) {
    var oneOfList = new ArrayList<Map<String, Object>>();
    for (String oneOf : model.oneOf) {
      var oneOfModel = new HashMap<String, Object>();
      oneOfModel.put("type", oneOf);
      oneOfModel.put("name", oneOf.replace("<", "Of").replace(">", ""));
      oneOfModel.put("listElementType", oneOf.replace("List<", "").replace(">", ""));
      oneOfModel.put("isList", oneOf.contains("List"));
      markCompounds(models, oneOf, oneOfModel, model);
      oneOfList.add(oneOfModel);
    }
    model.vendorExtensions.put("x-one-of-list", oneOfList);
  }

  public static void markCompounds(Map<String, ModelsMap> models, String oneOf, Map<String, Object> oneOfModel, CodegenModel model) {
    // 1. Find child model
    var modelsMap = models.get(oneOf);
    if (modelsMap == null) return;
    oneOfModel.put("isObject", true);

    // 2. add the child to parent model
    var compoundModel = modelsMap.getModels().get(0).getModel();
    oneOfModel.put("child", compoundModel.classname);

    // 3. mark the child and add its parent (may have many)
    compoundModel.vendorExtensions.put("x-one-of-element", true);
    var parentInfo = new HashMap<String, Object>();
    parentInfo.put("parent_classname", model.classname);
    parentInfo.put("parent_is_generic", model.vendorExtensions.getOrDefault("x-has-child-generic", false));
    compoundParent(compoundModel).add(parentInfo);
    //noinspection unchecked
    var values = (List<String>) compoundModel.vendorExtensions.get("x-discriminator-fields");
    if (values != null) {
      oneOfModel.put("x-discriminator-fields", values);
      // find the matching composed schema and assign the discriminator
      for (var m : model.getComposedSchemas().getOneOf()) {
        if (m.openApiType.equals(compoundModel.classname)) {
          m.vendorExtensions.put("x-discriminator-fields", values);
        }
      }
    }
  }

  private static Set<Map<String, Object>> compoundParent(CodegenModel model) {
    //noinspection unchecked
    var parents = (Set<Map<String, Object>>) model.vendorExtensions.get("x-one-of-element-parents");
    if (parents != null) return parents;
    parents = new HashSet<>();
    model.vendorExtensions.put("x-one-of-element-parents", parents);
    return parents;
  }

  private static boolean isNumberType(String typeName) {
    return typeName.equals("Int") || typeName.equals("Double") || typeName.equals("Long");
  }

  /**
   * Add metadata about oneOfs models (e.g., if it has at least one model, if it has more than one
   * array-subtype, etc.)
   */
  public static void addOneOfMetadata(Map<String, ModelsMap> models) {
    for (ModelsMap modelContainer : models.values()) {
      // modelContainers always have 1 and only 1 model in our specs
      var model = modelContainer.getModels().get(0).getModel();
      var oneOfs = getCodegenProperties(model);
      if (isMultiArrayOneOfs(oneOfs)) model.vendorExtensions.put("x-is-multi-array", true);
      if (isMultiMapOneOfs(oneOfs)) model.vendorExtensions.put("x-is-multi-map", true);
      if (hasAtModelOrEnum(oneOfs)) model.vendorExtensions.put("x-has-model", true);
      if (hasDiscriminators(oneOfs)) model.vendorExtensions.put("x-has-discriminator", true);
      markOneOfModels(oneOfs);
      sortOneOfs(oneOfs);
    }
  }

  private static List<CodegenProperty> getCodegenProperties(CodegenModel model) {
    var schemas = model.getComposedSchemas();
    if (schemas == null) return Collections.emptyList();
    var oneOfs = schemas.getOneOf();
    if (oneOfs == null || oneOfs.isEmpty()) return Collections.emptyList();
    return oneOfs;
  }

  /** Get true if a composed type has more than a one array-subtype */
  private static boolean isMultiMapOneOfs(List<CodegenProperty> oneOfs) {
    var map = 0;
    for (var prop : oneOfs) {
      if (prop.isMap) map++;
    }
    return map > 1;
  }

  /** Get true if a composed type has more than a one array-subtype */
  private static boolean isMultiArrayOneOfs(List<CodegenProperty> oneOfs) {
    var arrays = 0;
    for (var prop : oneOfs) {
      if (prop.isArray) arrays++;
    }
    return arrays > 1;
  }

  /** Get true if a composed type has at least one model/enum. */
  private static boolean hasAtModelOrEnum(List<CodegenProperty> oneOfs) {
    for (var prop : oneOfs) {
      if (prop.isModel || prop.isEnumRef) return true;
    }
    return false;
  }

  /** Return true if at least one oneOf has discriminators */
  private static boolean hasDiscriminators(List<CodegenProperty> oneOfs) {
    for (var prop : oneOfs) {
      if (prop.vendorExtensions.containsKey("x-discriminator-fields")) return true;
    }
    return false;
  }

  /** Mark oneOf models */
  private static void markOneOfModels(List<CodegenProperty> oneOfs) {
    for (var prop : oneOfs) {
      if (prop.isModel) {
        prop.vendorExtensions.put("x-one-of-element", true);
      }
    }
  }

  private static void sortOneOfs(List<CodegenProperty> oneOfs) {
    if (oneOfs == null || oneOfs.isEmpty()) return;
    oneOfs.sort(propertyComparator);
  }

  private static final Comparator<CodegenProperty> propertyComparator = (propA, propB) -> {
    boolean hasDiscriminatorA = propA.vendorExtensions.containsKey("x-discriminator-fields");
    boolean hasDiscriminatorB = propB.vendorExtensions.containsKey("x-discriminator-fields");
    if (hasDiscriminatorA && !hasDiscriminatorB) {
      return -1;
    } else if (!hasDiscriminatorA && hasDiscriminatorB) {
      return 1;
    } else if (hasDiscriminatorA && hasDiscriminatorB) {
      List<?> discriminatorsA = (List<?>) propA.vendorExtensions.get("x-discriminator-fields");
      List<?> discriminatorsB = (List<?>) propB.vendorExtensions.get("x-discriminator-fields");
      return discriminatorsB.size() - discriminatorsA.size();
    } else if (propA.isBoolean && !propB.isBoolean) {
      // put boolean last, because of typoTolerance
      return 1;
    } else if (!propA.isBoolean && propB.isBoolean) {
      return -1;
    }
    return 0;
  };
}
