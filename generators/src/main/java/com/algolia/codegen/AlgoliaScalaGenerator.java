package com.algolia.codegen;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.google.common.collect.ImmutableMap;
import com.samskivert.mustache.Mustache.Lambda;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.ScalaSttpClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaScalaGenerator extends ScalaSttpClientCodegen {

  final Logger logger = Logger.getLogger(AlgoliaScalaGenerator.class.getName());

  // This is used for the CTS generation
  private static final AlgoliaScalaGenerator INSTANCE = new AlgoliaScalaGenerator();

  /** Convert a text to a valid scala identifier. */
  public static String formatIdentifier(String text) {
    if (NAME_MAPPING.containsKey(text)) return NAME_MAPPING.get(text);
    return INSTANCE.formatIdentifier(text, false);
  }

  /**
   * TODO FIXME: custom mapping for field names with an underscore. This a workaround; a better
   * solution would be to use json4s' FieldSerializer for all fields with special cases.
   */
  static final Map<String, String> NAME_MAPPING = new HashMap<>() {
    {
      //      put("_operation", "_operation");
      //      put("client_id", "client_id");
      //      put("client_secret", "client_secret");
      //      put("_highlightResult", "_highlightResult");
      //      put("_snippetResult", "_snippetResult");
      //      put("_rankingInfo", "_rankingInfo");
      //      put("_distinctSeqID", "_distinctSeqID");
      //      put("_score", "_score");
      //      put("_automaticInsights", "_automaticInsights");
      //      put("__type", "__type");
      //      put("_metadata", "_metadata");
    }
  };

  @Override
  public String getName() {
    return "algolia-scala";
  }

  @Override
  public void processOpts() {
    String client = (String) additionalProperties.get("client");
    String packageName = client.replace("-", ""); // e.g. query-suggestions -> querysuggestions
    additionalProperties.put(CodegenConstants.MODEL_PACKAGE, "algoliasearch." + packageName);
    additionalProperties.put(CodegenConstants.API_PACKAGE, "algoliasearch.api");
    additionalProperties.put(CodegenConstants.INVOKER_PACKAGE, "algoliasearch");

    super.processOpts();
    setApiNameSuffix(Helpers.API_SUFFIX);

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    // Prevent non-apis files generation
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();

    supportingFiles.clear();
    var modelFolder = sourceFolder + File.separator + modelPackage.replace(".", File.separator);
    supportingFiles.add(new SupportingFile("version.mustache", "", "version.sbt"));
    supportingFiles.add(new SupportingFile("jsonSupport.mustache", modelFolder, "JsonSupport.scala"));

    Helpers.addCommonSupportingFiles(supportingFiles, "");

    additionalProperties.put("is" + Helpers.capitalize(Helpers.camelize((String) additionalProperties.get("client"))) + "Client", true);
    typeMapping.put("AnyType", "Any");

    nameMapping.putAll(NAME_MAPPING);

    try {
      additionalProperties.put("packageVersion", Helpers.getClientConfigField("scala", "packageVersion"));
    } catch (GeneratorException e) {
      logger.severe(e.getMessage());
      System.exit(1);
    }
  }

  @Override
  protected ImmutableMap.Builder<String, Lambda> addMustacheLambdas() {
    ImmutableMap.Builder<String, Lambda> lambdas = super.addMustacheLambdas();

    lambdas.put("type-to-name", (fragment, writer) -> writer.write(typeToName(fragment.execute())));
    lambdas.put("escape-path", (fragment, writer) -> writer.write(escapePath(fragment.execute())));

    return lambdas;
  }

  /** Convert a Seq type to a valid class name. */
  private String typeToName(String content) {
    return content.trim().replace("[", "Of").replace("]", "").replace(".", "").replace(", ", "");
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
    Timeouts.enrichBundle(openAPI, additionalProperties);
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    CodegenOperation ope = super.fromOperation(path, httpMethod, operation, servers);
    return Helpers.specifyCustomRequest(ope);
  }

  @Override
  public String encodePath(String input) {
    StringBuffer buf = new StringBuffer(input.length());
    Matcher matcher = Pattern.compile("[{](.*?)[}]").matcher(input);
    while (matcher.find()) {
      matcher.appendReplacement(buf, "\\${" + toParamName(matcher.group(0)) + "}");
    }
    matcher.appendTail(buf);
    return buf.toString();
  }

  /** Escape path variables in the path. */
  private String escapePath(String path) {
    var sanitized = path.replaceAll("\"", "%22");
    var buf = new StringBuilder(sanitized.length());
    var matcher = Pattern.compile("[{](.*?)[}]").matcher(sanitized);
    while (matcher.find()) {
      matcher.appendReplacement(buf, "{escape(" + toParamName(matcher.group(0)) + ")}");
    }
    matcher.appendTail(buf);
    return buf.toString();
  }

  @Override
  protected void postProcessEnumVars(List<Map<String, Object>> enumVars) {
    Collections.reverse(enumVars);
    enumVars.forEach(v -> {
      String name = (String) v.get("name");
      long count = enumVars.stream().filter(v1 -> ((String) v1.get("name")).equalsIgnoreCase(name)).count();
      if (count > 1L) {
        String uniqueEnumName = this.getUniqueEnumName(name, enumVars);
        Object var10001 = v.get("name");
        this.logger.warning("Changing duplicate enumeration name from " + var10001 + " to " + uniqueEnumName);
        v.put("name", uniqueEnumName);
      }
    });
    Collections.reverse(enumVars);
  }

  private String getUniqueEnumName(String name, List<Map<String, Object>> enumVars) {
    long count = enumVars.stream().filter(v -> ((String) v.get("name")).equalsIgnoreCase(name)).count();
    return count > 1L ? this.getUniqueEnumName(name + "Alt", enumVars) : name;
  }

  @Override
  public String toEnumVarName(String value, String datatype) {
    if (value.isEmpty()) {
      return "Empty";
    } else {
      var var = lowerCamelCase(value);
      return this.reservedWords.contains(var) ? this.escapeReservedWord(var) : var;
    }
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    GenericPropagator.propagateGenericsToModels(models, true);
    OneOf.updateModelsOneOf(models, modelPackage);
    OneOf.addOneOfMetadata(models);

    // Add unescapedName for properties where Scala name differs from original
    for (var model : models.values()) {
      for (var modelMap : model.getModels()) {
        var codegenModel = modelMap.getModel();
        if (codegenModel.vars != null) {
          var hasUnescapedProperty = false;
          for (var property : codegenModel.vars) {
            if (!property.name.equals(property.baseName) && !this.isReservedWord(property.baseName)) {
              property.vendorExtensions.put("x-unescaped-name", property.baseName);
              hasUnescapedProperty = true;
            }
          }

          codegenModel.vendorExtensions.put("x-has-unescaped-property", hasUnescapedProperty);
        }
      }
      // Scala doesn't support sensitive casing for enums
      this.postProcessModelsEnum(model);
    }

    return models;
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    Helpers.removeHelpers(operations);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }
}
