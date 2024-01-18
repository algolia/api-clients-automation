package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import com.algolia.codegen.utils.OneOf;
import com.samskivert.mustache.Mustache;
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
    additionalProperties.put("isSearchClient", client.equals("search"));
    additionalProperties.put("lambda.type-to-name", (Mustache.Lambda) (fragment, writer) -> writer.write(typeToName(fragment.execute())));

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
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }

  @Override
  public String toEnumVarName(String value, String datatype) {
    // when it's not a string, we don't want to change the name of the variable generated
    if (!"String".equals(datatype)) {
      return super.toEnumVarName(value, datatype);
    }

    // In some cases, the API might accept characters instead of the textual notation, we will
    // replace it internally so that it doesn't output the character itself.
    switch (value) {
      case "*":
        return "ALL";
    }

    if (!value.matches("[A-Z0-9_]+")) {
      // convert camelCase77String to CAMEL_CASE_77_STRING
      return value.replaceAll("-", "_").replaceAll("(.+?)([A-Z]|[0-9])", "$1_$2").toUpperCase(Locale.ROOT);
    }

    return super.toEnumVarName(value, datatype);
  }

  /** Convert a Seq type to a valid class name. */
  private String typeToName(String content) {
    return content.trim().replace("<", "Of").replace(">", "").replace(",", "").replace(" ", "");
  }
}
