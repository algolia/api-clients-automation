package com.algolia.codegen;

import com.algolia.codegen.utils.*;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.KotlinClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaKotlinGenerator extends KotlinClientCodegen {

  @Override
  public String getName() {
    return "algolia-kotlin";
  }

  @Override
  public void processOpts() {
    // generator specific options
    setLibrary("multiplatform");
    setApiPackage("api");
    setApiNameSuffix(Helpers.API_SUFFIX);
    setGroupId("com.algolia");
    setArtifactId("algoliasearch-client-kotlin");
    setApiPackage("com.algolia.client.api");
    setPackageName("com.algolia.client");
    String client = (String) additionalProperties.get("client");
    setModelPackage("com.algolia.client.model." + Helpers.camelize(client).toLowerCase());
    additionalProperties.put(CodegenConstants.SOURCE_FOLDER, "client/src/commonMain/kotlin");
    additionalProperties.put("lambda.type-to-name", (Mustache.Lambda) (fragment, writer) -> writer.write(typeToName(fragment.execute())));
    additionalProperties.put("dateLibrary", "kotlinx-datetime");

    super.processOpts();

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    // Remove auth files
    supportingFiles.removeIf(file -> file.getTemplateFile().contains("auth"));

    // Search config
    additionalProperties.put("is" + Helpers.capitalize(Helpers.camelize((String) additionalProperties.get("client"))) + "Client", true);

    additionalProperties.put("requestIdSupport", Helpers.requestIdSupport(client));

    // We don't extend hashmap
    propertyAdditionalKeywords.clear();

    // Simplify types
    List<String> primitives = Arrays.asList(
      "Byte",
      "ByteArray",
      "Short",
      "Int",
      "Long",
      "Float",
      "Double",
      "Boolean",
      "Char",
      "String",
      "Array",
      "List",
      "MutableList",
      "Map",
      "MutableMap",
      "Set",
      "MutableSet"
    );
    languageSpecificPrimitives = new HashSet<>(primitives);

    // Types mapping
    typeMapping.put("string", "String");
    typeMapping.put("boolean", "Boolean");
    typeMapping.put("integer", "Int");
    typeMapping.put("float", "Double");
    typeMapping.put("number", "Double");
    typeMapping.put("long", "Long");
    typeMapping.put("double", "Double");
    typeMapping.put("array", "List"); // use List instead of Array
    typeMapping.put("list", "List");
    typeMapping.put("set", "Set");
    typeMapping.put("map", "Map");
    typeMapping.put("AnyType", "Any");
    typeMapping.put("object", "JsonObject"); // from kotlinx.serialization

    // Container types
    instantiationTypes.put("map", "AbstractMap");
    instantiationTypes.put("array", "AbstractList");
    instantiationTypes.put("set", "AbstractSet");

    // Prevent generating tests
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();

    // Prevent generating custom docs
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    supportingFiles.clear();

    // Add custom files
    final String packageFolder = (sourceFolder + File.separator + packageName).replace(".", "/");
    supportingFiles.add(new SupportingFile("BuildConfig.kt.mustache", packageFolder, "BuildConfig.kt"));
    final String apiFolder = (sourceFolder + File.separator + apiPackage).replace(".", "/");
    supportingFiles.add(new SupportingFile("ApiClient.kt.mustache", apiFolder, "ApiClient.kt"));
    supportingFiles.add(new SupportingFile("gradle.properties.mustache", "", "gradle.properties"));
    supportingFiles.add(new SupportingFile("README_BOM.mustache", "client-bom", "README.md"));

    Helpers.addCommonSupportingFiles(supportingFiles, "");

    additionalProperties.put("packageVersion", Helpers.getClientConfigField("kotlin", "packageVersion"));
  }

  /** Convert a Seq type to a valid class name. */
  private String typeToName(String content) {
    return content.trim().replace("<", "Of").replace(">", "").replace(", ", "").replace(".", "");
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);

    String host = (String) additionalProperties.get("regionalHost");
    if (host != null) {
      String hostForKotlin = host.replaceAll("\\{([^}]+)}", "\\$$1");
      additionalProperties.put("hostForKotlin", hostForKotlin);
    }

    Timeouts.enrichBundle(openAPI, additionalProperties);
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    CodegenOperation codegenOperation = Helpers.specifyCustomRequest(super.fromOperation(path, httpMethod, operation, servers));
    // Set pathForKotlin by replacing the path variables with Kotlin's string
    // interpolation syntax
    List<String> segments = extractSegments(path);
    codegenOperation.vendorExtensions.put("pathSegments", segments);
    return codegenOperation;
  }

  private List<String> extractSegments(String input) {
    List<String> segments = new ArrayList<>();
    Pattern pattern = Pattern.compile("\\{([^}]+)}");
    for (String part : input.split("/")) {
      if (!part.isEmpty()) {
        Matcher matcher = pattern.matcher(part);
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        if (matcher.find()) {
          sb.append("$");
          sb.append(matcher.group(1));
        } else {
          sb.append(part);
        }
        sb.append("\"");
        segments.add(sb.toString());
      }
    }

    return segments;
  }

  private record SavedVarLists(
    List<CodegenProperty> vars,
    List<CodegenProperty> allVars,
    List<CodegenProperty> optionalVars,
    List<CodegenProperty> requiredVars,
    List<CodegenProperty> readOnlyVars,
    List<CodegenProperty> readWriteVars
  ) {
    SavedVarLists(CodegenModel model) {
      this(
        new ArrayList<>(model.vars),
        new ArrayList<>(model.allVars),
        new ArrayList<>(model.optionalVars),
        new ArrayList<>(model.requiredVars),
        new ArrayList<>(model.readOnlyVars),
        new ArrayList<>(model.readWriteVars)
      );
    }
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    // Save all var lists before super strips discriminator properties from child models
    var savedModels = new HashMap<String, SavedVarLists>();
    for (var entry : objs.entrySet()) {
      var model = entry.getValue().getModels().get(0).getModel();
      savedModels.put(entry.getKey(), new SavedVarLists(model));
    }

    Map<String, ModelsMap> models = super.postProcessAllModels(objs);

    // Restore discriminator properties stripped by KotlinClientCodegen
    for (var entry : models.entrySet()) {
      var model = entry.getValue().getModels().get(0).getModel();
      var saved = savedModels.get(entry.getKey());
      if (saved != null && model.vars.size() < saved.vars().size()) {
        model.vars = saved.vars();
        model.allVars = saved.allVars();
        model.optionalVars = saved.optionalVars();
        model.requiredVars = saved.requiredVars();
        model.readOnlyVars = saved.readOnlyVars();
        model.readWriteVars = saved.readWriteVars();
      }
    }

    replaceFreeFormMaps(models);
    OneOf.updateModelsOneOf(models, modelPackage);
    GenericPropagator.propagateGenericsToModels(models, true);
    OneOf.addOneOfMetadata(models);
    jsonParent(models);
    return models;
  }

  private void collectSearchDslModels(OperationsMap operations, List<ModelMap> allModels) {
    if (!"search".equals(additionalProperties.get("client"))) {
      return;
    }

    Set<String> orphans = new HashSet<>(ModelPruner.getOrphanModelNames(this, operations, allModels));
    List<CodegenModel> objectModels = new ArrayList<>();
    for (ModelMap modelMap : allModels) {
      CodegenModel model = modelMap.getModel();
      if (orphans.contains(toModelName(model.name))) {
        continue;
      }
      if (isSearchDslObjectModel(model)) {
        objectModels.add(model);
      }
    }
    objectModels.sort(Comparator.comparing(model -> model.classname));

    List<Map<String, Object>> dslModels = new ArrayList<>();
    for (CodegenModel model : objectModels) {
      Map<String, Object> dslModel = new LinkedHashMap<>();
      dslModel.put("classname", model.classname);
      dslModel.put("vars", model.vars);
      dslModels.add(dslModel);
    }
    writeSearchDslBuilders(dslModels);
  }

  /**
   * One builder per file. A single SearchDsl.kt with every object model OOMs the Kotlin Native
   * compiler on the macOS CI job ({@code compileKotlinIosArm64}).
   */
  private void writeSearchDslBuilders(List<Map<String, Object>> dslModels) {
    String dslFolder = (sourceFolder + File.separator + "com.algolia.client.dsl.generated").replace(".", "/");
    File outDir = new File(getOutputDir(), dslFolder);
    try {
      Files.createDirectories(outDir.toPath());
    } catch (IOException e) {
      throw new RuntimeException("Cannot create DSL builder directory " + outDir, e);
    }
    File[] stale = outDir.listFiles((dir, name) -> name.endsWith(".kt"));
    if (stale != null) {
      for (File file : stale) {
        if (!file.delete()) {
          throw new RuntimeException("Cannot delete stale DSL builder " + file);
        }
      }
    }

    Template template = compileDslTemplate();
    for (Map<String, Object> dslModel : dslModels) {
      Map<String, Object> data = new HashMap<>(additionalProperties);
      data.putAll(dslModel);
      String classname = (String) dslModel.get("classname");
      File out = new File(outDir, classname + "Builder.kt");
      StringWriter rendered = new StringWriter();
      template.execute(data, rendered);
      try {
        Files.writeString(out.toPath(), rendered.toString(), StandardCharsets.UTF_8);
      } catch (IOException e) {
        throw new RuntimeException("Cannot write DSL builder " + out, e);
      }
    }
  }

  private Template compileDslTemplate() {
    File root = new File(templateDir());
    Mustache.Compiler compiler = Mustache.compiler()
      .defaultValue("")
      .withLoader(name -> {
        String fileName = name.endsWith(".mustache") ? name : name + ".mustache";
        File partial = new File(root, fileName);
        return new InputStreamReader(Files.newInputStream(partial.toPath()), StandardCharsets.UTF_8);
      });
    File dsl = new File(root, "dsl.mustache");
    try (Reader reader = new InputStreamReader(Files.newInputStream(dsl.toPath()), StandardCharsets.UTF_8)) {
      return compiler.compile(reader);
    } catch (IOException e) {
      throw new RuntimeException("Cannot compile dsl.mustache from " + dsl, e);
    }
  }

  /**
   * Object models get a builder. OneOf wrappers (FacetFilters, SearchParams) and enums do not: they
   * have no constructor fields to assign.
   */
  private static boolean isSearchDslObjectModel(CodegenModel model) {
    if (model.isEnum) {
      return false;
    }
    if (Boolean.TRUE.equals(model.vendorExtensions.get("x-is-one-of"))) {
      return false;
    }
    if (Boolean.TRUE.equals(model.vendorExtensions.get("x-map-parent"))) {
      return false;
    }
    return model.vars != null && !model.vars.isEmpty();
  }

  private static final String FREE_FORM_MAP = "Map<kotlin.String, Any>";
  private static final String JSON_OBJECT = "JsonObject";

  private static void replaceFreeFormMaps(Map<String, ModelsMap> models) {
    for (ModelsMap modelContainer : models.values()) {
      CodegenModel model = modelContainer.getModels().get(0).getModel();

      if (model.vars != null) {
        for (CodegenProperty prop : model.vars) {
          replaceFreeFormType(prop);
        }
      }

      if (model.oneOf != null && model.oneOf.stream().anyMatch(t -> t.contains(FREE_FORM_MAP))) {
        Set<String> replaced = new LinkedHashSet<>();
        for (String t : model.oneOf) {
          replaced.add(t.contains(FREE_FORM_MAP) ? t.replace(FREE_FORM_MAP, JSON_OBJECT) : t);
        }
        model.oneOf.clear();
        model.oneOf.addAll(replaced);
      }

      if (model.getComposedSchemas() != null && model.getComposedSchemas().getOneOf() != null) {
        for (CodegenProperty prop : model.getComposedSchemas().getOneOf()) {
          replaceFreeFormType(prop);
        }
      }
    }
  }

  private static void replaceFreeFormType(CodegenProperty prop) {
    if (prop.datatypeWithEnum != null && prop.datatypeWithEnum.contains(FREE_FORM_MAP)) {
      prop.datatypeWithEnum = prop.datatypeWithEnum.replace(FREE_FORM_MAP, JSON_OBJECT);
      prop.dataType = prop.dataType.replace(FREE_FORM_MAP, JSON_OBJECT);
    }
  }

  private static void jsonParent(Map<String, ModelsMap> models) {
    for (ModelsMap modelContainer : models.values()) {
      CodegenModel model = modelContainer.getModels().get(0).getModel();
      if (model.parent != null && model.parent.startsWith("AbstractMap")) {
        model.vendorExtensions.put("x-map-parent", true);
      }
    }
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    ModelPruner.removeOrphanModelFiles(this, operations, models);
    collectSearchDslModels(operations, models);
    Helpers.removeHelpers(operations);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }

  @Override
  public String toEnumVarName(String value, String datatype) {
    if (!"String".equals(datatype)) return super.toEnumVarName(value, datatype);
    // In some cases, the API might accept characters instead of the textual notation, we will
    // replace it internally so that it doesn't output the character itself.
    switch (value) {
      case "90p_processing_time":
        return "NinetyPProcessingTime";
      case "99p_processing_time":
        return "NinetyNinePProcessingTime";
    }

    String enumVarName = value.replace("-", "_");
    return super.toEnumVarName(enumVarName, datatype);
  }

  @Override
  public String toVarName(String name) {
    String newName = super.toVarName(name);
    if (StringUtils.isAllUpperCase(newName)) {
      // e.g. LTE, GT.
      return StringUtils.lowerCase(newName);
    }
    return newName;
  }
}
