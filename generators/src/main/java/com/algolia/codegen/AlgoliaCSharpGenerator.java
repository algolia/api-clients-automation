package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import com.google.common.collect.ImmutableMap.Builder;
import com.samskivert.mustache.Mustache.Lambda;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.io.IOException;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.CSharpClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaCSharpGenerator extends CSharpClientCodegen {

  @Override
  public String getName() {
    return "algolia-csharp";
  }

  public String getClientName(String client) {
    return Helpers.createClientName(client, "csharp");
  }

  @Override
  public void processOpts() {
    String version = Helpers.getClientConfigField("csharp", "packageVersion");
    String client = (String) additionalProperties.get("client");

    setLibrary("httpclient");

    try {
      additionalProperties.put("languageVersion", Helpers.getLanguageVersion("csharp"));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    additionalProperties.put("packageVersion", version);
    additionalProperties.put("sourceFolder", "");
    additionalProperties.put("netCoreProjectFile", true);
    additionalProperties.put("targetFramework", "netstandard2.1;netstandard2.0;net9.0");
    additionalProperties.put("is" + Helpers.capitalize(Helpers.camelize((String) additionalProperties.get("client"))) + "Client", true);
    additionalProperties.put("apiPackageName", getClientName(client));
    additionalProperties.put("equatable", false);
    additionalProperties.put("disallowAdditionalPropertiesIfNotPresent", true);
    additionalProperties.put(CodegenConstants.EXCLUDE_TESTS, true);

    setApiNameSuffix(Helpers.API_SUFFIX);

    String packageName = getClientName(client);
    setPackageName("");
    setApiPackage("Clients");
    setModelPackage("Models/" + packageName);
    setOutputDir(getOutputDir() + "/algoliasearch/");

    super.processOpts();

    modelNameMapping.put("Task", "IngestionTask");

    typeMapping.put("Object", "object");

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();

    // Remove some files we don't want to output or change their paths
    supportingFiles.removeIf(
      file ->
        file.getTemplateFile().equals("git_push.sh.mustache") ||
        file.getTemplateFile().equals("openapi.mustache") ||
        file.getTemplateFile().equals("Solution.mustache") ||
        file.getTemplateFile().equals("README.mustache") ||
        file.getTemplateFile().equals("netcore_project.mustache") ||
        file.getTemplateFile().equals("netcore_testproject.mustache") ||
        file.getTemplateFile().equals("gitignore.mustache") ||
        file.getTemplateFile().equals("IApiAccessor.mustache") ||
        file.getTemplateFile().equals("HttpSigningConfiguration.mustache") ||
        file.getTemplateFile().equals("IAsynchronousClient.mustache") ||
        file.getTemplateFile().equals("FileParameter.mustache") ||
        file.getTemplateFile().equals("RetryConfiguration.mustache") ||
        file.getTemplateFile().equals("ApiClient.mustache") ||
        file.getTemplateFile().equals("OpenAPIDateConverter.mustache") ||
        file.getTemplateFile().equals("ExceptionFactory.mustache") ||
        file.getTemplateFile().equals("ISynchronousClient.mustache") ||
        file.getTemplateFile().equals("ReadOnlyDictionary.mustache") ||
        file.getTemplateFile().equals("WebRequestPathBuilder.mustache") ||
        file.getTemplateFile().equals("RequestOptions.mustache") ||
        file.getTemplateFile().equals("AbstractOpenAPISchema.mustache") ||
        file.getTemplateFile().equals("ApiResponse.mustache") ||
        file.getTemplateFile().equals("Multimap.mustache") ||
        file.getTemplateFile().equals("modelInnerEnum.mustache") ||
        file.getTemplateFile().equals("ApiException.mustache") ||
        file.getTemplateFile().equals("GlobalConfiguration.mustache") ||
        file.getTemplateFile().equals("IReadableConfiguration.mustache") ||
        file.getTemplateFile().equals("ClientUtils.mustache") ||
        file.getTemplateFile().equals("Configuration.mustache") ||
        file.getTemplateFile().equals("nuspec.mustache") ||
        file.getTemplateFile().equals("appveyor.mustache")
    );

    // repository
    supportingFiles.add(new SupportingFile("Solution.mustache", "../", "Algolia.Search.sln"));
    supportingFiles.add(new SupportingFile("netcore_project.mustache", "Algolia.Search.csproj"));
    supportingFiles.add(new SupportingFile("Configuration.mustache", "Clients", packageName + "Configuration.cs"));

    Helpers.addCommonSupportingFiles(supportingFiles, "../");

    reservedWords.removeIf(word -> word.equals("Configuration"));
  }

  /** Escape <> in generic with {} */
  private String escapeGenericForDoc(String type) {
    return type.replaceAll("<", "{").replaceAll(">", "}");
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
    ModelPruner.removeOrphanModelFiles(this, operations, models);
    Helpers.removeHelpers(operations);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    OneOf.updateModelsOneOf(models, modelPackage);
    GenericPropagator.propagateGenericsToModels(models);
    OneOf.addOneOfMetadata(models);
    return models;
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    return Helpers.specifyCustomRequest(super.fromOperation(path, httpMethod, operation, servers));
  }

  /** Convert a Seq type to a valid class name. */
  private String typeToName(String content) {
    // for dictionary, remove the key type
    String[] parts = content.replace("string, ", "").split("<");
    String name = "";
    for (int i = 0; i < parts.length; i++) {
      name += Helpers.capitalize(parts[i].replace(">", "").replace(",", "").replace(" ", ""));
    }
    return name;
  }

  @Override
  protected Builder<String, Lambda> addMustacheLambdas() {
    Builder<String, Lambda> lambdas = super.addMustacheLambdas();

    lambdas.put("type-to-name", (fragment, writer) -> writer.write(typeToName(fragment.execute())));
    lambdas.put("escape-generic", (fragment, writer) -> writer.write(escapeGenericForDoc(fragment.execute())));

    return lambdas;
  }
}
