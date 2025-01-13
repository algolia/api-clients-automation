package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.lambda.ToSecondsLambda;
import com.algolia.codegen.utils.*;
import com.google.common.collect.ImmutableMap;
import com.samskivert.mustache.Mustache;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.util.*;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.languages.PhpClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaPhpGenerator extends PhpClientCodegen {

  @Override
  public String getName() {
    return "algolia-php";
  }

  public static String getClientName(String client) {
    return Helpers.createClientName(client, "php");
  }

  @Override
  public void processOpts() {
    // generator specific options
    String client = (String) additionalProperties.get("client");
    setApiNameSuffix(Helpers.API_SUFFIX);
    setParameterNamingConvention("camelCase");
    additionalProperties.put("modelPackage", "Model\\" + getClientName(client));
    additionalProperties.put("invokerPackage", "Algolia\\AlgoliaSearch");
    additionalProperties.put("clientName", getClientName(client));

    super.processOpts();

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    // Remove base template as we want to change its path
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("Configuration.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals(".php-cs-fixer.php"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals(".php-cs-fixer.dist.php"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("phpunit.xml.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("AbstractModel.php"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("ApiException.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("ObjectSerializer.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("ModelInterface.mustache"));

    supportingFiles.add(new SupportingFile("client_config.mustache", "lib/Configuration", getClientName(client) + "Config.php"));
    supportingFiles.add(new SupportingFile("Algolia.mustache", "lib", "Algolia.php"));

    Helpers.addCommonSupportingFiles(supportingFiles, "");

    additionalProperties.put("isSearchClient", client.equals("search"));
    additionalProperties.put("configClassname", getClientName(client) + "Config");

    try {
      additionalProperties.put("packageVersion", Helpers.getClientConfigField("php", "packageVersion"));
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  protected ImmutableMap.Builder<String, Mustache.Lambda> addMustacheLambdas() {
    return super.addMustacheLambdas().put("toSeconds", new ToSecondsLambda());
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
    Timeouts.enrichBundle(openAPI, additionalProperties);
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    return Helpers.specifyCustomRequest(super.fromOperation(path, httpMethod, operation, servers));
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    ModelPruner.removeOrphans(this, operations, models);
    Helpers.removeHelpers(operations);
    return operations;
  }

  @Override
  public String getComposerPackageName() {
    return "algolia/algoliasearch-client-php";
  }
}
