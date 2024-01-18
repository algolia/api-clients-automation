package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import com.algolia.codegen.utils.OneOf;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.CSharpClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaCSharpGenerator extends CSharpClientCodegen {

  // This is used for the CTS generation
  private static final AlgoliaCSharpGenerator INSTANCE = new AlgoliaCSharpGenerator();

  public AlgoliaCSharpGenerator() {
    super();
    reservedWords.add("source");
  }

  /** Convert a text to a valid csharp identifier. */
  public static String formatIdentifier(String text) {
    return INSTANCE.escapeReservedWord(text);
  }

  private String CLIENT;

  @Override
  public String getName() {
    return "algolia-csharp";
  }

  public String getClientName(String client) {
    return Helpers.createClientName(client, "csharp");
  }

  @Override
  public void processOpts() {
    CLIENT = (String) additionalProperties.get("client");

    setLibrary("httpclient");

    try {
      additionalProperties.put("dotnetSdkMajorVersion", Files.readString(Paths.get("config/.csharp-version")).trim());
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    additionalProperties.put("sourceFolder", "");
    additionalProperties.put("netCoreProjectFile", true);
    additionalProperties.put("targetFramework", "netstandard2.1;netstandard2.0");
    additionalProperties.put("isSearchClient", CLIENT.equals("search"));
    additionalProperties.put("validatable", false);
    additionalProperties.put("equatable", false);
    additionalProperties.put("disallowAdditionalPropertiesIfNotPresent", true);
    additionalProperties.put(CodegenConstants.EXCLUDE_TESTS, true);

    setApiNameSuffix(Helpers.API_SUFFIX);

    String packageName = getClientName(CLIENT);
    setPackageName(packageName);
    setApiPackage("");
    setModelPackage("Models");
    setOutputDir(getOutputDir() + "/algoliasearch/");

    super.processOpts();

    modelNameMapping.put("Task", "IngestionTask");

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();

    // Remove some files we don't want to output or change their paths
    supportingFiles.removeIf(file ->
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
      file.getTemplateFile().equals("ApiException.mustache") ||
      file.getTemplateFile().equals("GlobalConfiguration.mustache") ||
      file.getTemplateFile().equals("IReadableConfiguration.mustache") ||
      file.getTemplateFile().equals("ClientUtils.mustache") ||
      file.getTemplateFile().equals("appveyor.mustache")
    );

    // repository
    supportingFiles.add(new SupportingFile("Solution.mustache", "../", "Algolia.Search.sln"));
    supportingFiles.add(new SupportingFile("globaljson.mustache", "../", "global.json"));
    supportingFiles.add(new SupportingFile("netcore_project.mustache", "Algolia.Search.csproj"));
    supportingFiles.add(new SupportingFile("AbstractOpenAPISchema.mustache", "Models", "AbstractSchema.cs"));
    supportingFiles.add(new SupportingFile("gitignore.mustache", "../", ".gitignore"));
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
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
}
