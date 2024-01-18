package com.algolia.codegen;

import static org.openapitools.codegen.utils.StringUtils.camelize;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.GenericPropagator;
import com.algolia.codegen.utils.Helpers;
import com.algolia.codegen.utils.OneOf;
import com.samskivert.mustache.Mustache;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.Swift5ClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;
import org.openapitools.codegen.utils.ModelUtils;

public class AlgoliaSwiftGenerator extends Swift5ClientCodegen {

  private String CLIENT;

  @Override
  public String getName() {
    return "algolia-swift";
  }

  public String getClientName(String client) {
    return Helpers.createClientName(client, "swift");
  }

  @Override
  public void processOpts() {
    CLIENT = (String) additionalProperties.get("client");

    // We will use the default URLSession library coming from the Foundation package to handle HTTP
    // requests
    setLibrary(LIBRARY_URLSESSION);

    additionalProperties.put("isSearchClient", CLIENT.equals("search"));
    additionalProperties.put(CodegenConstants.EXCLUDE_TESTS, true);

    additionalProperties.put(RESPONSE_AS, new String[] { RESPONSE_LIBRARY_ASYNC_AWAIT });
    additionalProperties.put(CodegenConstants.PROJECT_NAME, "AlgoliaSearchClient");
    additionalProperties.put(CodegenConstants.API_NAME_SUFFIX, Helpers.API_SUFFIX);
    additionalProperties.put(SWIFT_PACKAGE_PATH, "Sources" + File.separator + getClientName(CLIENT));
    additionalProperties.put(OBJC_COMPATIBLE, false);

    additionalProperties.put("lambda.type-to-name", (Mustache.Lambda) (fragment, writer) -> writer.write(typeToName(fragment.execute())));
    additionalProperties.put(
      "lambda.client-to-name",
      (Mustache.Lambda) (fragment, writer) -> writer.write(getClientName(fragment.execute()))
    );
    additionalProperties.put(
      "lambda.to-codable",
      (Mustache.Lambda) (fragment, writer) -> {
        String initialType = fragment.execute();
        writer.write(initialType.equalsIgnoreCase("AnyCodable") ? "Codable" : initialType);
      }
    );

    super.processOpts();

    supportingFiles.add(new SupportingFile("client_configuration.mustache", sourceFolder, "Configuration.swift"));
    supportingFiles.add(new SupportingFile("Package.mustache", "Package.swift"));
    supportingFiles.add(new SupportingFile("podspec.mustache", projectName + ".podspec"));
    supportingFiles.add(
      new SupportingFile(
        "Version.mustache",
        "Sources" + File.separator + "Core" + File.separator + "Helpers" + File.separator + "Version.swift"
      )
    );

    supportingFiles.removeIf(file ->
      file.getTemplateFile().equals("gitignore.mustache") ||
      file.getTemplateFile().equals("Package.swift.mustache") ||
      file.getTemplateFile().equals("CodableHelper.mustache") ||
      file.getTemplateFile().equals("JSONDataEncoding.mustache") ||
      file.getTemplateFile().equals("JSONEncodingHelper.mustache") ||
      file.getTemplateFile().equals("SynchronizedDictionary.mustache") ||
      file.getTemplateFile().equals("APIHelper.mustache") ||
      file.getTemplateFile().equals("Models.mustache") ||
      file.getTemplateFile().equals("Configuration.mustache") ||
      file.getTemplateFile().equals("Extensions.mustache") ||
      file.getTemplateFile().equals("OpenISO8601DateFormatter.mustache") ||
      file.getTemplateFile().equals("OpenAPIDateWithoutTime.mustache") ||
      file.getTemplateFile().equals("APIs.mustache") ||
      file.getTemplateFile().equals("Validation.mustache") ||
      file.getTemplateFile().equals("AlamofireImplementations.mustache") ||
      file.getTemplateFile().equals("URLSessionImplementations.mustache") ||
      file.getTemplateFile().equals("README.mustache") ||
      file.getTemplateFile().equals("git_push.sh.mustache") ||
      file.getTemplateFile().equals("Cartfile.mustache") ||
      file.getTemplateFile().equals("XcodeGen.mustache") ||
      file.getTemplateFile().equals("swiftformat.mustache") ||
      file.getTemplateFile().equals("Podspec.mustache")
    );

    reservedWords.add("LogLevel");

    setProjectName(getClientName(CLIENT));
    setUseSPMFileStructure(true);

    setApiNamePrefix("");
    setApiNameSuffix(Helpers.API_SUFFIX);
    setModelNamePrefix("");
    setApiPackage("");
    setModelPackage(File.separator + "Models");

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    try {
      additionalProperties.put("packageVersion", Helpers.getClientConfigField("swift", "packageVersion"));
      additionalProperties.put("packageList", Helpers.getClientListForLanguage("swift"));
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();
  }

  private String typeToName(String content) {
    var trimmedContent = content.trim();
    var isList = trimmedContent.charAt(0) == '[' && trimmedContent.charAt(trimmedContent.length() - 1) == ']';
    var isDictionary = isList && trimmedContent.contains(": ");
    var name = trimmedContent;
    if (isDictionary) {
      name = trimmedContent.replace("[", "DictionaryOf").replace(": ", "To").replace("]", "");
    } else if (isList) {
      name = trimmedContent.replace("[", "ArrayOf").replace("]", "");
    }

    return name;
  }

  private void markOneOfChildrenForSwift(Map<String, ModelsMap> models, CodegenModel model) {
    var oneOfList = new ArrayList<Map<String, Object>>();
    for (String oneOf : model.oneOf) {
      Logger.getGlobal().severe(oneOf);
      var oneOfModel = new HashMap<String, Object>();
      oneOfModel.put("type", oneOf);
      var isList = oneOf.charAt(0) == '[' && oneOf.charAt(oneOf.length() - 1) == ']';
      Logger.getGlobal().severe("isList: " + isList);
      var isDictionary = isList && oneOf.contains(": ");
      Logger.getGlobal().severe("isDictionary: " + isDictionary);
      var name = oneOf;
      if (isDictionary) {
        isList = false;
        name = oneOf.replace("[", "DictionaryOf").replace(": ", "To").replace("]", "");
        oneOfModel.put("listElementType", oneOf.replace("[", "").replace("]", ""));
      }
      if (isList) {
        name = oneOf.replace("[", "ArrayOf").replace("]", "");
      }
      oneOfModel.put("name", name);
      oneOfModel.put("isList", isList);
      oneOfModel.put("isDictionary", isDictionary);
      OneOf.markCompounds(models, oneOf, oneOfModel, model);
      oneOfList.add(oneOfModel);
      Logger.getGlobal().severe(name);
    }
    oneOfList.sort(OneOf.comparator); // have fields with "discriminators" in the start of the list
    model.vendorExtensions.put("x-one-of-list", oneOfList);
  }

  private void updateModelsOneOfForSwift(Map<String, ModelsMap> models, String modelPackage) {
    for (ModelsMap modelContainer : models.values()) {
      // modelContainers always have 1 and only 1 model in our specs
      var model = modelContainer.getModels().get(0).getModel();
      if (model.oneOf.isEmpty()) continue;
      this.markOneOfChildrenForSwift(models, model);
      OneOf.generateSealedChildren(models, modelPackage, model);
      model.vendorExtensions.put("x-is-one-of", true);
      model.vendorExtensions.put("x-one-of-explicit-name", Helpers.shouldUseExplicitOneOfName(model.oneOf));
    }
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    this.updateModelsOneOfForSwift(models, modelPackage);
    GenericPropagator.propagateGenericsToModels(models);
    return models;
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }

  @Override
  public String toRegularExpression(String pattern) {
    return escapeText(pattern);
  }

  // Stolen from the SwiftCombineGenerator, as it works way better
  @Override
  public String getTypeDeclaration(Schema p) {
    Schema<?> schema = ModelUtils.unaliasSchema(this.openAPI, p, importMapping);
    Schema<?> target = ModelUtils.isGenerateAliasAsModel() ? p : schema;
    if (ModelUtils.isArraySchema(target)) {
      Schema<?> items = getSchemaItems((ArraySchema) schema);
      return ModelUtils.isSet(target) && ModelUtils.isObjectSchema(items)
        ? "Set<" + getTypeDeclaration(items) + ">"
        : "[" + getTypeDeclaration(items) + "]";
    } else if (ModelUtils.isMapSchema(target)) {
      // Note: ModelUtils.isMapSchema(p) returns true when p is a composed schema that also defines
      // additionalproperties: true
      Schema<?> inner = ModelUtils.getAdditionalProperties(target);
      if (inner == null) {
        Logger
          .getGlobal()
          .warning("`" + p.getName() + "` (map property) does not have a proper inner type defined. Default to" + " type:string");
        inner = new StringSchema().description("TODO default missing map inner type to string");
        p.setAdditionalProperties(inner);
      }
      return "[String: " + getTypeDeclaration(inner) + "]";
    } else if (ModelUtils.isComposedSchema(target)) {
      List<Schema> schemas = ModelUtils.getInterfaces((ComposedSchema) target);
      if (schemas.size() == 1) {
        return getTypeDeclaration(schemas.get(0));
      } else {
        super.getTypeDeclaration(target);
      }
    }
    return super.getTypeDeclaration(target);
  }

  @Override
  public String toApiName(String name) {
    return camelize(getApiNamePrefix() + name + getApiNameSuffix());
  }
}
