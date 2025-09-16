package com.algolia.codegen;

import static org.openapitools.codegen.utils.CamelizeOption.LOWERCASE_FIRST_LETTER;
import static org.openapitools.codegen.utils.StringUtils.camelize;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.lambda.ToSecondsLambda;
import com.algolia.codegen.utils.*;
import com.google.common.collect.ImmutableMap;
import com.samskivert.mustache.Mustache.Lambda;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.servers.Server;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.Swift5ClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;
import org.openapitools.codegen.utils.ModelUtils;

public class AlgoliaSwiftGenerator extends Swift5ClientCodegen {

  private static final List<String> reservedModelNames = List.of(
    "abtest",
    "abtestconfiguration",
    "abtestresponse",
    "abtestsvariant",
    "abtestsvariantsearchparams",
    "action",
    "addabtestsrequest",
    "addabtestsvariant",
    "advancedsyntaxfeatures",
    "alternativesasexact",
    "anchoring",
    "aroundprecision",
    "aroundprecisionfromvalueinner",
    "aroundradius",
    "aroundradiusall",
    "automaticfacetfilter",
    "automaticfacetfilters",
    "banner",
    "bannerimage",
    "bannerimageurl",
    "bannerlink",
    "baseindexsettings",
    "basesearchparams",
    "basesearchparamswithoutquery",
    "basesearchresponse",
    "batchrequest",
    "batchwriteparams",
    "booleanstring",
    "condition",
    "configuration",
    "consequence",
    "consequencehide",
    "consequenceparams",
    "consequencequery",
    "consequencequeryobject",
    "customsearchparams",
    "deletedatresponse",
    "direction",
    "distinct",
    "edit",
    "edittype",
    "effectmetric",
    "emptysearchfilter",
    "errorbase",
    "estimateabtestrequest",
    "estimateabtestresponse",
    "estimateconfiguration",
    "event",
    "eventstatus",
    "eventtype",
    "exactonsinglewordquery",
    "exhaustive",
    "facetfilters",
    "facetordering",
    "facets",
    "facetstats",
    "filtereffects",
    "forbidden",
    "highlightresult",
    "highlightresultoption",
    "ignoreplurals",
    "indexsettingsassearchparams",
    "insideboundingbox",
    "languages",
    "listabtestsresponse",
    "loglevel",
    "matchedgeolocation",
    "matchlevel",
    "minimumdetectableeffect",
    "mode",
    "numericfilters",
    "optionalfilters",
    "optionalwords",
    "outliersfilter",
    "params",
    "personalization",
    "promote",
    "promoteobjectid",
    "promoteobjectids",
    "querysuggestionsconfiguration",
    "querytype",
    "range",
    "rankinginfo",
    "redirect",
    "redirectruleindexdata",
    "redirectruleindexmetadata",
    "redirecturl",
    "region",
    "removestopwords",
    "removewordsifnoresults",
    "renderingcontent",
    "rerankingapplyfilter",
    "scheduleabtestresponse",
    "scheduleabtestsrequest",
    "searchpagination",
    "searchparams",
    "searchparamsobject",
    "searchparamsquery",
    "semanticsearch",
    "snippetresult",
    "snippetresultoption",
    "sortremainingby",
    "source",
    "status",
    "supportedlanguage",
    "tagfilters",
    "task",
    "taskstatus",
    "timerange",
    "typotolerance",
    "typotoleranceenum",
    "value",
    "variant",
    "watchresponse",
    "widgets"
  );

  // This is used for the CTS generation
  private static final AlgoliaSwiftGenerator INSTANCE = new AlgoliaSwiftGenerator();

  /** Convert a text to a valid Swift identifier. */
  public static String formatIdentifier(String text) {
    INSTANCE.useBacktickEscapes = true;
    if (INSTANCE.typeMapping.containsKey(text)) {
      return Helpers.camelize(INSTANCE.typeMapping.get(text));
    }

    return INSTANCE.isReservedWord(text) ? INSTANCE.escapeReservedWord(text) : text;
  }

  public static Boolean isReservedModelName(String name, String client) {
    return client.equalsIgnoreCase("composition") || reservedModelNames.contains(name.toLowerCase());
  }

  public static String prefixReservedModelName(String name, String client) {
    if (name == null || name.isEmpty()) {
      return name;
    }

    var camelizedName = camelize(name);
    if (isReservedModelName(camelizedName, client)) {
      return getClientName(client) + Helpers.capitalize(camelizedName);
    }

    return name;
  }

  private String CLIENT;

  @Override
  public String getName() {
    return "algolia-swift";
  }

  public static String getClientName(String client) {
    return Helpers.createClientName(client, "swift");
  }

  @Override
  public void processOpts() {
    CLIENT = (String) additionalProperties.get("client");

    // We will use the default URLSession library coming from the Foundation package to handle HTTP
    // requests
    setLibrary(LIBRARY_URLSESSION);

    try {
      additionalProperties.put("swiftVersion", Helpers.getLanguageVersion("swift"));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    additionalProperties.put("is" + Helpers.capitalize(Helpers.camelize((String) additionalProperties.get("client"))) + "Client", true);
    additionalProperties.put(CodegenConstants.EXCLUDE_TESTS, true);

    additionalProperties.put(RESPONSE_AS, new String[] { RESPONSE_LIBRARY_ASYNC_AWAIT });
    additionalProperties.put(CodegenConstants.PROJECT_NAME, "AlgoliaSearchClient");
    additionalProperties.put(CodegenConstants.API_NAME_SUFFIX, Helpers.API_SUFFIX);
    additionalProperties.put(SWIFT_PACKAGE_PATH, "Sources" + File.separator + getClientName(CLIENT));
    additionalProperties.put(OBJC_COMPATIBLE, false);
    additionalProperties.put(USE_BACKTICK_ESCAPES, true);
    additionalProperties.put("hashableModels", true);

    super.processOpts();

    supportingFiles.add(
      new SupportingFile("client_configuration.mustache", sourceFolder, getClientName(CLIENT) + "ClientConfiguration.swift")
    );
    Helpers.addCommonSupportingFiles(supportingFiles, "");

    supportingFiles.add(new SupportingFile("Package.mustache", "Package.swift"));
    supportingFiles.add(new SupportingFile("podspec.mustache", projectName + ".podspec"));
    supportingFiles.add(
      new SupportingFile(
        "Version.mustache",
        "Sources" + File.separator + "Core" + File.separator + "Helpers" + File.separator + "Version.swift"
      )
    );

    supportingFiles.removeIf(
      file ->
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

    nameMapping.put("appId", "appID");

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

  @Override
  protected ImmutableMap.Builder<String, Lambda> addMustacheLambdas() {
    ImmutableMap.Builder<String, Lambda> lambdas = super.addMustacheLambdas();

    lambdas.put("toSeconds", new ToSecondsLambda());
    lambdas.put("type-to-name", (fragment, writer) -> writer.write(typeToName(fragment.execute())));
    lambdas.put("client-to-name", (fragment, writer) -> writer.write(getClientName(fragment.execute())));
    lambdas.put("to-codable", (fragment, writer) -> {
      String initialType = fragment.execute();
      writer.write(initialType.equalsIgnoreCase("AnyCodable") ? "Codable" : initialType);
    });

    return lambdas;
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
    Timeouts.enrichBundle(openAPI, additionalProperties);
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    Helpers.removeHelpers(operations);
    GenericPropagator.propagateGenericsToOperations("swift", CLIENT, operations, models);
    return operations;
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    GenericPropagator.propagateGenericsToModels("swift", CLIENT, models);
    OneOf.updateModelsOneOf(models, modelPackage);
    OneOf.addOneOfMetadata(models);
    return models;
  }

  private Iterator getCurrentIterator(int i, CodegenModel cm) {
    List<List<CodegenProperty>> varContainers = List.of(cm.vars, cm.allVars, cm.requiredVars, cm.optionalVars);
    return varContainers.get(i).iterator();
  }

  @Override
  public ModelsMap postProcessModels(ModelsMap modelsMap) {
    ModelsMap processedModels = this.postProcessModelsEnum(modelsMap);

    // Iterate through each model
    for (ModelMap modelMap : processedModels.getModels()) {
      CodegenModel codegenModel = modelMap.getModel();
      var codegenModelVars = List.of(codegenModel.vars, codegenModel.allVars, codegenModel.requiredVars, codegenModel.optionalVars)
        .stream()
        .flatMap(Collection::stream)
        .toList();
      boolean modelHasEscapedPropertyName = false;

      // Iterate through each property of the model
      for (CodegenProperty property : codegenModelVars) {
        // Check if property name is different from base name
        if (!property.name.equals(property.baseName)) {
          property.vendorExtensions.put("x-codegen-escaped-property-name", true);
          modelHasEscapedPropertyName = true;
        }

        // Check if the property is null encodable
        if (
          property.vendorExtensions.containsKey("x-null-encodable") &&
          property.vendorExtensions.get("x-null-encodable").toString().equals("true")
        ) {
          // Set null encodable default value
          if ("null".equals(property.defaultValue)) {
            property.vendorExtensions.put("x-null-encodable-default-value", ".encodeValue(" + property.defaultValue + ")");
          } else {
            property.vendorExtensions.put("x-null-encodable-default-value", ".encodeNull");
          }
        }
      }

      // Set vendor extension if model has properties with escaped names
      if (modelHasEscapedPropertyName) {
        codegenModel.vendorExtensions.put("x-codegen-has-escaped-property-names", true);
      }
    }

    return processedModels;
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    return Helpers.specifyCustomRequest(super.fromOperation(path, httpMethod, operation, servers));
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
      Schema<?> items = ModelUtils.getSchemaItems(schema);
      return ModelUtils.isSet(target) && ModelUtils.isObjectSchema(items)
        ? "Set<" + getTypeDeclaration(items) + ">"
        : "[" + getTypeDeclaration(items) + "]";
    } else if (ModelUtils.isMapSchema(target)) {
      // Note: ModelUtils.isMapSchema(p) returns true when p is a composed schema that also defines
      // additionalproperties: true
      Schema<?> inner = ModelUtils.getAdditionalProperties(target);
      if (inner == null) {
        Logger.getGlobal().warning(
          "`" + p.getName() + "` (map property) does not have a proper inner type defined. Default to" + " type:string"
        );
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

  @Override
  public String toEnumVarName(String value, String datatype) {
    if (enumNameMapping.containsKey(value)) {
      return enumNameMapping.get(value);
    }

    if (value.length() == 0) {
      return "empty";
    }

    if (enumUnknownDefaultCase && value.equals(enumUnknownDefaultCaseName)) {
      return camelize(value, LOWERCASE_FIRST_LETTER);
    }

    // Reserved Name
    String nameLowercase = StringUtils.lowerCase(value);
    if (isReservedWord(nameLowercase)) {
      return escapeReservedWord(nameLowercase);
    }

    // Prefix with underscore if name starts with number
    if (value.matches("\\d.*")) {
      return "_" + camelize(value, LOWERCASE_FIRST_LETTER);
    }

    // for symbol, e.g. $, #
    if (getSymbolName(value) != null) {
      return camelize(WordUtils.capitalizeFully(getSymbolName(value).toUpperCase(Locale.ROOT)), LOWERCASE_FIRST_LETTER);
    }

    // Camelize only when we have a structure defined below
    boolean camelized = false;
    if (value.matches("[A-Z]?[a-z0-9]+[a-zA-Z0-9]*")) {
      value = camelize(value, LOWERCASE_FIRST_LETTER);
      camelized = true;
    }

    // Check for numerical conversions
    if (
      "Int".equals(datatype) ||
      "Int32".equals(datatype) ||
      "Int64".equals(datatype) ||
      "Float".equals(datatype) ||
      "Double".equals(datatype)
    ) {
      String varName = "number" + camelize(value);
      return varName;
    }

    // If we have already camelized the word, don't progress
    // any further
    if (camelized) {
      return value;
    }

    char[] separators = { '-', '_', ' ', ':', '(', ')' };
    return camelize(
      WordUtils.capitalizeFully(StringUtils.lowerCase(value), separators).replaceAll("[-_ :\\(\\)]", ""),
      LOWERCASE_FIRST_LETTER
    );
  }

  @Override
  public String toModelName(String name) {
    var sanitizedName = this.sanitizeName(name);
    var camelizedName = camelize(sanitizedName);
    if (isReservedModelName(camelizedName, getClientName(CLIENT))) {
      return prefixReservedModelName(camelizedName, CLIENT);
    }

    return super.toModelName(name);
  }

  @Override
  public String toParamName(String name) {
    var trimmedName = camelize(name.replaceFirst(getClientName(CLIENT), ""), LOWERCASE_FIRST_LETTER);
    if (isReservedModelName(trimmedName, getClientName(CLIENT))) {
      return trimmedName;
    }

    return super.toParamName(name);
  }
}
