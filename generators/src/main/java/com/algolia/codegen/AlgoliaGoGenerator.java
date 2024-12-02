package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.lambda.ScreamingSnakeCaseLambda;
import com.algolia.codegen.utils.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.samskivert.mustache.Mustache;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.io.File;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.GoClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaGoGenerator extends GoClientCodegen {

  @Override
  public String getName() {
    return "algolia-go";
  }

  @Override
  public void processOpts() {
    String client = (String) additionalProperties.get("client");

    additionalProperties.put("packageName", client.equals("query-suggestions") ? "suggestions" : client);
    additionalProperties.put("enumClassPrefix", true);
    additionalProperties.put("isSearchClient", client.equals("search"));

    String outputFolder = "algolia" + File.separator + client;
    setOutputDir(getOutputDir() + File.separator + outputFolder);

    super.processOpts();

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    typeMapping.put("object", "map[string]any");
    typeMapping.put("AnyType", "any");

    modelNameMapping.put("range", "modelRange");

    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();

    supportingFiles.clear();
    supportingFiles.add(new SupportingFile("configuration.mustache", "", "configuration.go"));
    supportingFiles.add(new SupportingFile("client.mustache", "", "client.go"));

    Helpers.addCommonSupportingFiles(supportingFiles, "../../");

    try {
      additionalProperties.put("packageVersion", Helpers.getClientConfigField("go", "packageVersion"));
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  protected ImmutableMap.Builder<String, Mustache.Lambda> addMustacheLambdas() {
    return super.addMustacheLambdas().put("screamingSnakeCase", new ScreamingSnakeCaseLambda());
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
    Timeouts.enrichBundle((HashMap<String, Object>) openAPI.getExtensions().get("x-timeouts"), additionalProperties);
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    return Helpers.specifyCustomRequest(super.fromOperation(path, httpMethod, operation, servers));
  }

  @Override
  public ModelsMap postProcessModels(ModelsMap objs) {
    objs = super.postProcessModels(objs);

    for (ModelMap modelMap : objs.getModels()) {
      CodegenModel model = modelMap.getModel();
      if (model.isEnum) {
        continue;
      }

      for (CodegenProperty param : Iterables.concat(model.vars, model.allVars, model.requiredVars, model.optionalVars)) {
        if (!param.isNullable || param.isContainer || param.isFreeFormObject || (param.isAnyType && !param.isModel)) {
          continue;
        }

        param.dataType = "utils.Nullable[" + param.vendorExtensions.get("x-go-base-type") + "]";
      }
    }

    return objs;
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    OneOf.updateModelsOneOf(models, modelPackage);
    GenericPropagator.propagateGenericsToModels(models);
    OneOf.addOneOfMetadata(models);

    for (Map.Entry<String, ModelsMap> entry : models.entrySet()) {
      String modelName = entry.getKey();
      CodegenModel model = entry.getValue().getModels().get(0).getModel();

      // for some reason the property additionalPropertiesIsAnyType is not propagated to the
      // property
      for (CodegenProperty prop : model.getVars()) {
        ModelsMap propertyModel = models.get(prop.datatypeWithEnum);
        if (propertyModel != null && propertyModel.getModels().get(0).getModel().getAdditionalPropertiesIsAnyType()) {
          // consider it the same as model for our purpose
          prop.isModel = true;
        }

        // simplify some dataTypes
        if (prop.dataType.contains("[]*[]")) {
          prop.dataType = prop.dataType.replace("[]*[]", "[][]");
          prop.vendorExtensions.put("x-go-base-type", prop.dataType);
        }
      }
    }
    return models;
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    ModelPruner.removeOrphans(this, operations, models);
    Helpers.removeHelpers(operations);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }
}
