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

    additionalProperties.put("packageName", client.equals("query-suggestions") ? "suggestions" : Helpers.camelize(client));
    additionalProperties.put("enumClassPrefix", true);
    additionalProperties.put("is" + Helpers.capitalize(Helpers.camelize(client)) + "Client", true);
    additionalProperties.put("requestIdSupport", Helpers.requestIdSupport(client));

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

    if ("search".equals(client)) {
      supportingFiles.add(new SupportingFile("transformation_options.mustache", "", "transformation_options.go"));
    }

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

      addFieldMetadata(model);

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

      inheritRefDescriptions(model, models);
      markAccessors(model);

      // for some reason the property additionalPropertiesIsAnyType is not propagated to the
      // property
      for (CodegenProperty prop : model.getVars()) {
        ModelsMap propertyModel = models.get(prop.datatypeWithEnum);
        if (propertyModel != null && propertyModel.getModels().get(0).getModel().getAdditionalPropertiesIsAnyType()) {
          // consider it the same as model for our purpose
          prop.isModel = true;
        }
      }

      // simplify some dataTypes. The field, constructor params, getters and setters come from
      // distinct CodegenProperty instances, so we need to update every var list.
      for (CodegenProperty prop : Iterables.concat(model.vars, model.allVars, model.requiredVars, model.optionalVars)) {
        if (prop.dataType.contains("[]*[]")) {
          prop.dataType = prop.dataType.replace("[]*[]", "[][]");
          prop.vendorExtensions.put("x-go-base-type", prop.dataType);
        }

        // a map is already a nilable reference type, so a pointer to a map in a slice is
        // redundant: a `null` JSON element unmarshals to a nil map either way.
        if (prop.dataType.contains("[]*map[")) {
          prop.dataType = prop.dataType.replace("[]*map[", "[]map[");
          prop.vendorExtensions.put("x-go-base-type", prop.dataType);
        }
      }
    }
    return models;
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    ModelPruner.removeOrphanModelFiles(this, operations, models);
    Helpers.removeHelpers(operations);
    GenericPropagator.propagateGenericsToOperations(operations, models);

    // GetConfiguration clashes with the hardcoded client method that returns the config object.
    String client = (String) additionalProperties.get("client");
    for (CodegenOperation op : operations.getOperations().getOperation()) {
      if (op.operationId.equals("GetConfiguration")) {
        String renamed = "agent-studio".equals(client) ? "GetAgentStudioConfiguration" : "GetApplicationConfiguration";
        op.operationId = renamed;
        op.nickname = renamed;
      }
    }

    // Gates the sse imports and the callAPIStream helper in the templates, as Go
    // fails to compile on unused imports.
    for (CodegenOperation op : operations.getOperations().getOperation()) {
      if ((boolean) op.vendorExtensions.getOrDefault("x-streaming", false)) {
        additionalProperties.put("hasStreamingOperations", true);
        break;
      }
    }

    return operations;
  }

  // addFieldMetadata exposes Go-safe literals for the template's FieldExamples and
  // FieldDescriptions maps, which only iterate model.vars.
  private static void addFieldMetadata(CodegenModel model) {
    for (CodegenProperty param : model.vars) {
      param.vendorExtensions.put("x-go-basename-literal", goStringLiteral(param.baseName));

      // OpenAPI Generator fabricates the string "null" as the example of any property without one.
      if ("null".equals(param.example)) {
        param.example = null;
      }

      if (param.example != null && !param.example.isEmpty()) {
        param.vendorExtensions.put("x-go-example-literal", goStringLiteral(param.example));
        // a line break would end the `// Example:` comment and turn the rest into Go code.
        param.example = singleLine(param.example);
      }

      // param.description is pre-escaped for comments (quotes become \"), so the literal needs the
      // unescaped one.
      String description = param.unescapedDescription != null ? param.unescapedDescription : param.description;
      if (description != null && !description.isEmpty()) {
        param.vendorExtensions.put("x-go-description-literal", goStringLiteral(description));
      }
    }
  }

  // markAccessors enables the template's accessors for a model with metadata, unless a field named
  // like an accessor would not compile next to it.
  private static void markAccessors(CodegenModel model) {
    boolean hasExamples = false;
    boolean hasDescriptions = false;

    for (CodegenProperty param : model.vars) {
      if ("FieldExample".equals(param.name) || "FieldDescription".equals(param.name)) {
        return;
      }

      hasExamples |= param.vendorExtensions.containsKey("x-go-example-literal");
      hasDescriptions |= param.vendorExtensions.containsKey("x-go-description-literal");
    }

    if (hasExamples) {
      model.vendorExtensions.put("x-has-field-examples", true);
    }
    if (hasDescriptions) {
      model.vendorExtensions.put("x-has-field-descriptions", true);
    }
  }

  // inheritRefDescriptions gives a property that $refs a schema the schema's description, since
  // OpenAPI ignores siblings of a $ref.
  private static void inheritRefDescriptions(CodegenModel model, Map<String, ModelsMap> models) {
    for (CodegenProperty param : model.vars) {
      if (param.isContainer || param.vendorExtensions.containsKey("x-go-description-literal")) {
        continue;
      }

      String description = refDescription(param, models);
      if (description != null) {
        param.vendorExtensions.put("x-go-description-literal", goStringLiteral(description));
      }
    }
  }

  private static String refDescription(CodegenProperty param, Map<String, ModelsMap> models) {
    String refName = param.complexType != null ? param.complexType : param.datatypeWithEnum;
    ModelsMap ref = models.get(refName);
    if (ref == null) {
      return null;
    }

    CodegenModel refModel = ref.getModels().get(0).getModel();
    String description = refModel.unescapedDescription != null ? refModel.unescapedDescription : refModel.description;
    return description == null || description.isEmpty() ? null : description;
  }

  private static String singleLine(String s) {
    return s.replaceAll("\\s*[\\r\\n]+\\s*", " ");
  }

  // goStringLiteral turns an arbitrary string into a double-quoted Go string literal, escaping the
  // characters that would otherwise break the literal (examples often contain quotes and JSON).
  private static String goStringLiteral(String s) {
    StringBuilder sb = new StringBuilder("\"");
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '\\':
          sb.append("\\\\");
          break;
        case '"':
          sb.append("\\\"");
          break;
        case '\n':
          sb.append("\\n");
          break;
        case '\r':
          sb.append("\\r");
          break;
        case '\t':
          sb.append("\\t");
          break;
        default:
          if (c < 0x20 || c == 0x7f) {
            sb.append(String.format("\\u%04x", (int) c));
          } else {
            sb.append(c);
          }
      }
    }
    return sb.append("\"").toString();
  }
}
