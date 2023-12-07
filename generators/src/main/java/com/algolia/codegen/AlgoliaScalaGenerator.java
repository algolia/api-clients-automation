package com.algolia.codegen;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.samskivert.mustache.Mustache;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.ScalaSttpClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaScalaGenerator extends ScalaSttpClientCodegen {

  final Logger logger = Logger.getLogger(AlgoliaScalaGenerator.class.getName());

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
    super.processOpts();
    setApiNameSuffix(Utils.API_SUFFIX);
    Utils.setGenerationBanner(additionalProperties);

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

    try {
      Utils.generateServer(client, additionalProperties);
      additionalProperties.put("packageVersion", Utils.getClientConfigField("scala", "packageVersion"));
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
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    CodegenOperation ope = super.fromOperation(path, httpMethod, operation, servers);
    ope.path = encodedPath(path); // override "path" to fix incorrectly skipped paths
    return Utils.specifyCustomRequest(ope);
  }

  private String encodedPath(String path) {
    var sanitized = path.replaceAll("\"", "%22");
    var buf = new StringBuilder(sanitized.length());
    var matcher = Pattern.compile("[{](.*?)[}]").matcher(sanitized);
    while (matcher.find()) {
      matcher.appendReplacement(buf, "\\${escape(" + toParamName(matcher.group(0)) + ")}");
    }
    matcher.appendTail(buf);
    return buf.toString();
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    GenericPropagator.propagateGenericsToModels(models);
    OneOfUtils.updateModelsOneOf(models, modelPackage);
    OneOfUtils.addOneOfMetadata(models);
    return models;
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }
}
