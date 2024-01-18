package com.algolia.codegen;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.samskivert.mustache.Mustache;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.io.File;
import java.util.List;
import java.util.Map;
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
   * Custom mapping for field names This a workaround; a better solution would be to use json4s'
   * FieldSerializer for all fields with special cases.
   */
  static final Map<String, String> NAME_MAPPING = Map.of(
    "_operation",
    "_operation",
    "client_id",
    "client_id",
    "client_secret",
    "client_secret"
  );

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
    additionalProperties.put("lambda.type-to-name", (Mustache.Lambda) (fragment, writer) -> writer.write(typeToName(fragment.execute())));
    additionalProperties.put("lambda.escape-path", (Mustache.Lambda) (fragment, writer) -> writer.write(escapePath(fragment.execute())));
    super.processOpts();
    setApiNameSuffix(Helpers.API_SUFFIX);
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
    additionalProperties.put("isSearchClient", client.equals("search"));
    typeMapping.put("AnyType", "Any");

    nameMapping.putAll(NAME_MAPPING);

    try {
      additionalProperties.put("packageVersion", Helpers.getClientConfigField("scala", "packageVersion"));
    } catch (GeneratorException e) {
      logger.severe(e.getMessage());
      System.exit(1);
    }
  }

  /** Convert a Seq type to a valid class name. */
  private String typeToName(String content) {
    return content.trim().replace("[", "Of").replace("]", "").replace(".", "").replace(", ", "");
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
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
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    GenericPropagator.propagateGenericsToModels(models, true);
    OneOf.updateModelsOneOf(models, modelPackage);
    OneOf.addOneOfMetadata(models);
    return models;
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }
}
