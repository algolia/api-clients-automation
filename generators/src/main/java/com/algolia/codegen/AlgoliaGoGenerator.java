package com.algolia.codegen;

import com.algolia.codegen.cts.lambda.ScreamingSnakeCaseLambda;
import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.samskivert.mustache.Mustache;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.GoClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaGoGenerator extends GoClientCodegen {

  // This is used for the CTS generation
  private static final AlgoliaGoGenerator INSTANCE = new AlgoliaGoGenerator();

  @Override
  public String getName() {
    return "algolia-go";
  }

  @Override
  public void processOpts() {
    String client = (String) additionalProperties.get("client");

    additionalProperties.put("packageName", client.equals("query-suggestions") ? "suggestions" : Helpers.camelize(client));
    additionalProperties.put("is" + Helpers.capitalize(Helpers.camelize(client)) + "Client", true);

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
    ImmutableMap.Builder<String, Mustache.Lambda> lambdas = super.addMustacheLambdas();

    lambdas.put("screamingSnakeCase", new ScreamingSnakeCaseLambda());

    return lambdas;
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
    Timeouts.enrichBundle(openAPI, additionalProperties);
    additionalProperties.put(
      "appDescription",
      Arrays.stream(openAPI.getInfo().getDescription().split("\n")).map(line -> "// " + line).collect(Collectors.joining("\n")).trim()
    );
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

    // Flatten body params to remove the wrapping object
    for (CodegenOperation ope : operations.getOperations().getOperation()) {
      // clean up the description
      String[] lines = ope.unescapedNotes.split("\n");
      ope.notes = (lines[0] + "\n" + Arrays.stream(lines).skip(1).map(line -> "// " + line).collect(Collectors.joining("\n"))).trim();

      // enrich the params
      for (CodegenParameter param : ope.optionalParams) {
        param.nameInPascalCase = Helpers.capitalize(param.baseName);
      }

      CodegenParameter bodyParam = ope.bodyParam;
      if (bodyParam != null) {
        flattenBody(ope);
      }

      // If the optional param struct only has 1 param, we can remove the wrapper
      if (ope.optionalParams.size() == 1) {
        CodegenParameter param = ope.optionalParams.get(0);

        // move it to required, it's easier to handle im mustache
        ope.hasOptionalParams = false;
        ope.optionalParams.clear();

        ope.hasRequiredParams = true;
        ope.requiredParams.add(param);
      }
    }

    ModelPruner.removeOrphans(this, operations, models);
    Helpers.removeHelpers(operations);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }

  private void flattenBody(CodegenOperation ope) {
    CodegenParameter bodyParam = ope.bodyParam;
    bodyParam.nameInPascalCase = Helpers.capitalize(bodyParam.baseName);
    if (!bodyParam.isModel) {
      return;
    }

    if (!canFlattenBody(ope)) {
      System.out.println(
        "Operation " + ope.operationId + " has body param " + bodyParam.paramName + " in colision with a parameter, skipping flattening"
      );
      return;
    }

    bodyParam.vendorExtensions.put("x-flat-body", bodyParam.getVars().size() > 0);

    if (bodyParam.getVars().size() > 0) {
      ope.allParams.removeIf(param -> param.isBodyParam);
      ope.requiredParams.removeIf(param -> param.isBodyParam);
      ope.optionalParams.removeIf(param -> param.isBodyParam);
    }

    for (CodegenProperty prop : bodyParam.getVars()) {
      // there is no easy way to convert a prop to a param, we need to copy all the fields
      CodegenParameter param = new CodegenParameter();

      prop.nameInLowerCase = toParamName(prop.baseName);
      param.nameInPascalCase = Helpers.capitalize(prop.baseName);
      param.paramName = toParamName(prop.baseName);
      param.baseName = prop.baseName;
      param.baseType = prop.baseType;
      param.dataType = prop.dataType;
      param.datatypeWithEnum = prop.datatypeWithEnum;
      param.description = prop.description;
      param.example = prop.example;
      param.isModel = prop.isModel;
      param.isArray = prop.isArray;
      param.isContainer = prop.isContainer;
      param.isMap = prop.isMap;
      param.isEnum = prop.isEnum;
      param.isEnumRef = prop.isEnumRef;
      param.isPrimitiveType = prop.isPrimitiveType;
      param.isString = prop.isString;
      param.isNumeric = prop.isNumeric;
      param.isBoolean = prop.isBoolean;
      param.isDate = prop.isDate;
      param.isDateTime = prop.isDateTime;
      param.isFreeFormObject = prop.isFreeFormObject;
      param.isNullable = prop.isNullable;
      param.jsonSchema = prop.jsonSchema;
      param.required = prop.required;
      param.vendorExtensions = prop.vendorExtensions;
      param.allowableValues = prop.allowableValues;

      if (prop.required) {
        ope.requiredParams.add(param);
        ope.hasRequiredParams = true;
      } else {
        ope.optionalParams.add(param);
        ope.hasOptionalParams = true;
      }
      ope.allParams.add(param);
    }
  }

  public static boolean canFlattenBody(CodegenOperation ope) {
    if (ope.bodyParam == null || !ope.bodyParam.isModel) {
      return false;
    }

    if (ope.allParams.size() == 1) {
      return true;
    }

    for (CodegenProperty prop : ope.bodyParam.getVars()) {
      for (CodegenParameter param : ope.allParams) {
        if (param.paramName.equals(prop.baseName)) {
          return false;
        }
      }
    }
    return true;
  }

  public static String toEnum(String value) {
    return INSTANCE.toEnumVarName(value, "String");
  }
}
