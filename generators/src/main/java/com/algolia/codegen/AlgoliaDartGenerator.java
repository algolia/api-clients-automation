package com.algolia.codegen;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.util.*;
import java.util.stream.Collectors;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.DartDioClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;
import org.openapitools.codegen.utils.StringUtils;

public class AlgoliaDartGenerator extends DartDioClientCodegen {

  private final SchemaSupport support = new SchemaSupport();

  String libName;
  boolean isAlgoliasearchClient;

  @Override
  public String getName() {
    return "algolia-dart";
  }

  @Override
  public void processOpts() {
    String client = (String) additionalProperties.get("client");
    isAlgoliasearchClient = client.equals("algoliasearch");
    String version = Utils.getOpenApiToolsField("dart", client, "packageVersion");
    additionalProperties.put("isAlgoliasearchClient", isAlgoliasearchClient);

    // pubspec.yaml
    setPubAuthor("Algolia");
    setPubAuthorEmail("hey@algolia.com");
    setPubHomepage("https://www.algolia.com/doc/");
    setPubVersion(version);
    String packageFolder;
    if (isAlgoliasearchClient) {
      libName = "algoliasearch";
      packageFolder = libName;
      setPubDescription(
        "A Dart package for Algolia. Enables seamless integration for instant search, typo" +
        " tolerance & user insights, and more, in Dart/Flutter apps."
      );
    } else {
      String packageName = client.replace("-", "_");
      libName = "algolia_client_" + packageName;
      packageFolder = "client_" + packageName;
      setApiNameSuffix(Utils.API_SUFFIX);
      setPubDescription(
        "A sub-package of the AlgoliaSearch library, offering " +
        client.replace("-", " ") +
        "-specific functionalities for enhanced search and discovery in Dart/Flutter" +
        " apps."
      );
    }
    setPubName(libName);
    setPubLibrary(libName);
    setPubRepository("https://github.com/algolia/algoliasearch-client-dart/tree/main/packages/" + packageFolder);

    // configs
    additionalProperties.put(CodegenConstants.SERIALIZATION_LIBRARY, SERIALIZATION_LIBRARY_JSON_SERIALIZABLE);

    super.processOpts();

    Arrays.asList("source", "get", "hide").forEach(reservedWords::remove); // reserved words from dart-keywords.txt

    if (isAlgoliasearchClient) {
      supportingFiles.removeIf(file -> file.getTemplateFile().contains("lib"));
      supportingFiles.add(new SupportingFile("lib.mustache", libPath, "algoliasearch_lite.dart"));
      additionalProperties.put("searchVersion", Utils.getOpenApiToolsField("dart", "search", "packageVersion"));
      additionalProperties.put("insightsVersion", Utils.getOpenApiToolsField("dart", "insights", "packageVersion"));
    }

    // disable documentation and tests
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();

    // Generation notice, added on every generated files
    Utils.setGenerationBanner(additionalProperties);

    // Cleanup supporting files
    supportingFiles.removeIf(file -> file.getTemplateFile().contains("auth"));
    supportingFiles.removeIf(file -> file.getTemplateFile().contains("api_client"));
    supportingFiles.removeIf(file -> file.getTemplateFile().contains("gitignore"));
    supportingFiles.removeIf(file -> file.getTemplateFile().contains("build"));
    supportingFiles.removeIf(file -> file.getTemplateFile().contains("analysis_options"));
    supportingFiles.removeIf(file -> file.getTemplateFile().contains("README"));

    final String srcFolder = libPath + sourceFolder;
    supportingFiles.add(new SupportingFile("version.mustache", srcFolder, "version.dart"));

    // Search config
    additionalProperties.put("isSearchClient", client.equals("search"));
    additionalProperties.put("packageVersion", Utils.getClientConfigField("dart", "packageVersion"));

    // Generate server info
    Utils.generateServer(client, additionalProperties);
  }

  @Override
  public String toApiName(String name) {
    return isAlgoliasearchClient ? "SearchClient" : super.toApiName(name);
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> modelsMap = super.postProcessAllModels(objs);
    return support.clearOneOfFromModels(libName, modelsMap);
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    CodegenOperation op = super.fromOperation(path, httpMethod, operation, servers);
    CodegenOperation codegenOperation = Utils.specifyCustomRequest(op);
    return support.clearOneOfFromOperation(codegenOperation);
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> allModels) {
    OperationsMap operationsMap = super.postProcessOperationsWithModels(objs, allModels);
    return support.clearOneOfFromApiImports(operationsMap);
  }

  @Override
  public String toModelFilename(String name) {
    return support.classnames().contains(name) ? null : super.toModelFilename(name);
  }
}

class SchemaSupport {

  private static final String GENERIC_TYPE = "dynamic";
  private static final String X_ONEOF_TYPES = "x-oneof-types";
  private static final String X_IS_ONEOF = "x-is-oneof";

  private final Map<String, OneOfMetadata> oneOfs = new HashMap<>(); // Maintain a list of deleted class names

  public Set<String> classnames() {
    return oneOfs.keySet();
  }

  public Collection<String> imports() {
    return oneOfs.values().stream().map(e -> e.imprt).collect(Collectors.toSet());
  }

  Map<String, ModelsMap> clearOneOfFromModels(String libName, Map<String, ModelsMap> modelsMap) {
    removeModels(libName, modelsMap);
    updateField(modelsMap);
    removeImports(modelsMap);
    return modelsMap;
  }

  private void removeModels(String libName, Map<String, ModelsMap> modelsMap) {
    Iterator<Map.Entry<String, ModelsMap>> iterator = modelsMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, ModelsMap> entry = iterator.next();
      ModelsMap modelContainer = entry.getValue();
      ModelMap modelMap = modelContainer.getModels().get(0);
      CodegenModel model = modelMap.getModel();
      if (!model.oneOf.isEmpty()) {
        String classname = modelMap.getModel().classname;
        oneOfs.put(classname, new OneOfMetadata(asImport(libName, classname), model.oneOf));
        iterator.remove();
        continue;
      }
      if (model.allOf.size() == 1) { // Changed from 'oneOf' to 'allOf'
        String classname = modelMap.getModel().classname;
        oneOfs.put(classname, new OneOfMetadata(asImport(libName, classname), model.oneOf));
        iterator.remove();
      }

      if (model.allOf.size() == 1) {
        model.vendorExtensions.put("x-is-type-alias", true);
        ModelsMap map = modelsMap.get(model.allOf.iterator().next());
        String aliasType = map != null ? map.getModels().get(0).getModel().classname : GENERIC_TYPE;
        model.vendorExtensions.put("x-type-alias", aliasType);
      }
    }
  }

  private String asImport(String libName, String classname) {
    return "package:" + libName + "/src/model/" + StringUtils.underscore(classname) + ".dart";
  }

  private void updateField(Map<String, ModelsMap> modelsMap) {
    for (ModelsMap modelContainer : modelsMap.values()) {
      List<ModelMap> models = modelContainer.getModels();
      if (models == null || models.isEmpty()) continue;
      ModelMap modelMap = models.get(0);
      CodegenModel model = modelMap.getModel();
      for (CodegenProperty property : model.vars) {
        if (org.apache.commons.lang3.StringUtils.isAllUpperCase(property.name)) {
          property.name = org.apache.commons.lang3.StringUtils.lowerCase(property.name);
        }
        updatePropertyDataType(property);
      }
    }
  }

  private void updatePropertyDataType(CodegenProperty property) {
    if (
      oneOfs.containsKey(property.dataType) ||
      (property.isMap && oneOfs.containsKey(property.complexType)) ||
      (property.isContainer && oneOfs.containsKey(property.complexType))
    ) {
      String dataType;
      if (oneOfs.containsKey(property.dataType)) {
        dataType = GENERIC_TYPE;
      } else if (property.isMap) {
        dataType = "Map<String, " + GENERIC_TYPE + ">";
      } else {
        dataType = "Iterable<" + GENERIC_TYPE + ">";
      }

      property.setDatatypeWithEnum(dataType);
      Set<String> types = oneOfs.containsKey(property.dataType)
        ? oneOfs.get(property.dataType).types
        : oneOfs.get(property.complexType).types;
      Set<String> newTypes = getOneOfTypes(types);
      property.vendorExtensions.put(X_ONEOF_TYPES, newTypes);
      property.vendorExtensions.put(X_IS_ONEOF, true);
    }
  }

  private Set<String> getOneOfTypes(Set<String> types) {
    Set<String> newTypes = new HashSet<>();
    for (String type : types) {
      if (oneOfs.containsKey(type)) {
        newTypes.addAll(oneOfs.get(type).types);
      } else if (type.startsWith("List<")) { // only lists are supported for now.
        String innerType = type.substring(5, type.length() - 1);
        Set<String> innerTypes = getOneOfTypesList(innerType);
        newTypes.addAll(innerTypes);
      } else {
        newTypes.add(type);
      }
    }
    return newTypes;
  }

  private Set<String> getOneOfTypesList(String type) {
    if (oneOfs.containsKey(type)) {
      return oneOfs.get(type).types.stream().map(e -> "List<" + e + ">").collect(Collectors.toSet());
    } else {
      return Collections.singleton("List<" + type + ">");
    }
  }

  private void removeImports(Map<String, ModelsMap> modelsMap) {
    for (Map.Entry<String, ModelsMap> entry : modelsMap.entrySet()) {
      ModelsMap modelContainer = entry.getValue();
      ModelMap modelMap = modelContainer.getModels().get(0);
      CodegenModel model = modelMap.getModel();
      for (Map.Entry<String, OneOfMetadata> oneof : oneOfs.entrySet()) {
        String imprt = oneof.getValue().imprt;
        model.imports.remove(imprt);
      }
    }
  }

  CodegenOperation clearOneOfFromOperation(CodegenOperation operation) {
    for (CodegenParameter parameter : operation.allParams) {
      boolean isCleared = false;
      if (oneOfs.containsKey(parameter.dataType)) {
        parameter.dataType = GENERIC_TYPE;
        isCleared = true;
      } else if (parameter.isMap && oneOfs.containsKey(parameter.baseType)) {
        parameter.dataType = "Map<String, " + GENERIC_TYPE + ">";
        isCleared = true;
      } else if (parameter.isContainer && oneOfs.containsKey(parameter.baseType)) {
        parameter.dataType = "Iterable<" + GENERIC_TYPE + ">";
        isCleared = true;
      }
      if (isCleared) {
        parameter.isModel = false;
        // property.vendorExtensions.put("x-oneof-types", oneOfs.get(property.dataType).types);
      }
    }
    if (oneOfs.containsKey(operation.returnType)) {
      operation.returnType = GENERIC_TYPE;
      operation.returnBaseType = GENERIC_TYPE;
      operation.vendorExtensions.put("x-one-of-return-type", operation.returnType);
    }
    return operation;
  }

  OperationsMap clearOneOfFromApiImports(OperationsMap operationsMap) {
    //noinspection unchecked
    List<String> imports = (List<String>) operationsMap.get("imports");
    imports.removeAll(imports());
    return operationsMap;
  }
}

class OneOfMetadata {

  final String imprt;
  final Set<String> types;

  public OneOfMetadata(String imprt, Set<String> types) {
    this.imprt = imprt;
    this.types = types;
  }
}
