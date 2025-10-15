package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import com.google.common.collect.ImmutableMap.Builder;
import com.samskivert.mustache.Mustache.Lambda;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.servers.Server;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.JavaClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

@SuppressWarnings("unchecked")
public class AlgoliaJavaGenerator extends JavaClientCodegen {

  @Override
  public String getName() {
    return "algolia-java";
  }

  @Override
  public void processOpts() {
    // generator specific options
    String client = (String) additionalProperties.get("client");
    setSourceFolder("algoliasearch/src/main/java");
    setGroupId("com.algolia");
    setModelPackage("com.algolia.model." + Helpers.camelize(client).toLowerCase());
    additionalProperties.put("invokerPackage", "com.algolia");
    setApiPackage("com.algolia.api");
    setApiNameSuffix(Helpers.API_SUFFIX);

    super.processOpts();

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    // Prevent all useless file to generate
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();

    supportingFiles.clear();
    final String invokerFolder = (sourceFolder + '/' + invokerPackage).replace(".", "/");
    supportingFiles.add(new SupportingFile("build_config.mustache", invokerFolder, "BuildConfig.java"));
    supportingFiles.add(new SupportingFile("gradle.properties.mustache", "", "gradle.properties"));
    additionalProperties.put("is" + Helpers.capitalize(Helpers.camelize((String) additionalProperties.get("client"))) + "Client", true);

    Helpers.addCommonSupportingFiles(supportingFiles, "");

    reservedWords.removeIf(word -> word.equals("configuration"));

    try {
      additionalProperties.put("packageVersion", Helpers.getClientConfigField("java", "packageVersion"));
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
    Timeouts.enrichBundle(openAPI, additionalProperties);
  }

  @Override
  protected void addAdditionPropertiesToCodeGenModel(CodegenModel codegenModel, Schema schema) {
    // this is needed to preserve additionalProperties: true
    super.addParentContainer(codegenModel, codegenModel.name, schema);
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    return Helpers.specifyCustomRequest(super.fromOperation(path, httpMethod, operation, servers));
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    GenericPropagator.propagateGenericsToModels(models);
    OneOf.updateModelsOneOf(models, modelPackage);
    OneOf.addOneOfMetadata(models);
    return models;
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    ModelPruner.removeOrphanModelFiles(this, operations, models);
    Helpers.removeHelpers(operations);
    Timeouts.propagate(operations);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }

  public static String toEnum(String value) {
    // In some cases, the API might accept characters instead of the textual notation, we will
    // replace it internally so that it doesn't output the character itself.
    switch (value) {
      case "*":
        return "ALL";
      case ":":
        return "APPLY";
      case "=":
        return "EQUALS";
      case "!=":
        return "NOT_EQUALS";
      case "<":
        return "LESS_THAN";
      case "<=":
        return "LESS_EQUALS";
      case ">":
        return "GREATER_THAN";
      case ">=":
        return "GREATER_EQUALS";
      case "90p_processing_time":
        return "NINETY_P_PROCESSING_TIME";
      case "99p_processing_time":
        return "NINETY_NINE_P_PROCESSING_TIME";
      case "mappingkit/v1":
        return "MAPPINGKIT_V1";
    }

    if (!value.matches("[A-Z0-9_]+")) {
      return Helpers.toScreamingSnakeCase(value);
    }

    return value;
  }

  @Override
  public String toEnumVarName(String value, String datatype) {
    // when it's not a string, we don't want to change the name of the variable generated
    if (!"String".equals(datatype)) {
      return super.toEnumVarName(value, datatype);
    }

    return super.toEnumVarName(toEnum(value), datatype);
  }

  /** Convert a Seq type to a valid class name. */
  private String typeToName(String content) {
    return content.trim().replace("<", "Of").replace(">", "").replace(",", "").replace(" ", "");
  }

  @Override
  protected Builder<String, Lambda> addMustacheLambdas() {
    Builder<String, Lambda> lambdas = super.addMustacheLambdas();

    lambdas.put("type-to-name", (fragment, writer) -> writer.write(typeToName(fragment.execute())));

    return lambdas;
  }
}
