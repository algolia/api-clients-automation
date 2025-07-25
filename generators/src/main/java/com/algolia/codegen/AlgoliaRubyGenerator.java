package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.RubyClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaRubyGenerator extends RubyClientCodegen {

  private String CLIENT;

  @Override
  public String getName() {
    return "algolia-ruby";
  }

  @Override
  public void processOpts() {
    CLIENT = (String) additionalProperties.get("client");

    additionalProperties.put("is" + Helpers.capitalize(Helpers.camelize((String) additionalProperties.get("client"))) + "Client", true);
    additionalProperties.put("packageVersion", Helpers.getClientConfigField("ruby", "packageVersion"));
    setGemName("algolia");
    additionalProperties.put("modelModule", Helpers.capitalize(Helpers.camelize(CLIENT)));

    setApiNameSuffix(Helpers.API_SUFFIX);

    super.processOpts();

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();

    reservedWords.add("object_id");
    reservedWordsMappings.put("object_id", "algolia_object_id");

    Helpers.addCommonSupportingFiles(supportingFiles, "");

    // Remove some files we don't want to output or change their paths
    supportingFiles.removeIf(
      file ->
        file.getTemplateFile().equals("gitignore.mustache") ||
        file.getTemplateFile().equals("travis.mustache") ||
        file.getTemplateFile().equals("rspec.mustache") ||
        file.getTemplateFile().equals("Gemfile.mustache") ||
        file.getTemplateFile().equals("gem.mustache") ||
        file.getTemplateFile().equals("gemspec.mustache") ||
        file.getTemplateFile().equals("api_client.mustache") ||
        file.getTemplateFile().equals("configuration.mustache") ||
        file.getTemplateFile().equals("api_error.mustache") ||
        file.getTemplateFile().equals("README.mustache") ||
        file.getTemplateFile().equals("Rakefile.mustache") ||
        file.getTemplateFile().equals("api_client_spec.mustache") ||
        file.getTemplateFile().equals("git_push.sh.mustache") ||
        file.getTemplateFile().equals("api_test.mustache") ||
        file.getTemplateFile().equals("configuration_spec.mustache") ||
        file.getTemplateFile().equals("gitlab-ci.mustache") ||
        file.getTemplateFile().equals("spec_helper.mustache") ||
        file.getTemplateFile().equals("rubocop.mustache")
    );
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
    return operations;
  }

  @Override
  public String modelFileFolder() {
    return outputFolder + "/lib/" + gemName + "/models/" + CLIENT;
  }

  @Override
  public String toEnumVarName(String value, String datatype) {
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
    }

    return super.toEnumVarName(value, datatype);
  }
}
