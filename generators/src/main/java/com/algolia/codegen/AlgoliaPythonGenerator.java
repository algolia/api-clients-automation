package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.languages.PythonClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaPythonGenerator extends PythonClientCodegen {

  private String CLIENT;

  @Override
  public String getName() {
    return "algolia-python";
  }

  @Override
  public void processOpts() {
    CLIENT = (String) additionalProperties.get("client");

    additionalProperties.put("isSearchClient", CLIENT.equals("search"));
    additionalProperties.put("packageVersion", Helpers.getClientConfigField("python", "packageVersion"));
    additionalProperties.put(CodegenConstants.EXCLUDE_TESTS, true);

    setApiNameSuffix(Helpers.API_SUFFIX);

    String packageName = Helpers.toSnakeCase(CLIENT);
    setPackageName(packageName);
    setApiPackage("");
    setModelPackage("models");
    setOutputDir(getOutputDir() + "/algoliasearch/");

    super.processOpts();

    // // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();

    // Remove some files we don't want to output or change their paths
    supportingFiles.removeIf(file ->
      file.getTemplateFile().equals("git_push.sh.mustache") ||
      file.getTemplateFile().equals("requirements.mustache") ||
      file.getTemplateFile().equals("test-requirements.mustache") ||
      file.getTemplateFile().equals("tox.mustache") ||
      file.getTemplateFile().equals("setup_cfg.mustache") ||
      file.getTemplateFile().equals("setup.mustache") ||
      file.getTemplateFile().equals("pyproject.mustache") ||
      file.getTemplateFile().equals("gitignore.mustache") ||
      file.getTemplateFile().equals("py.typed.mustache") ||
      file.getTemplateFile().equals("README.mustache") ||
      file.getTemplateFile().equals("api_test.mustache") ||
      file.getTemplateFile().equals("model_test.mustache") ||
      file.getTemplateFile().equals("github-workflow.mustache") ||
      file.getTemplateFile().equals("travis.mustache") ||
      file.getTemplateFile().equals("__init__api.mustache") ||
      file.getTemplateFile().equals("api_response.mustache") ||
      file.getTemplateFile().equals("exceptions.mustache") ||
      file.getTemplateFile().equals("api_client.mustache") ||
      file.getTemplateFile().equals("rest.mustache") ||
      file.getTemplateFile().equals("configuration.mustache") ||
      file.getTemplateFile().equals("__init__.model.mustache") ||
      file.getTemplateFile().equals("__init__.package.mustache") ||
      file.getTemplateFile().equals("model_anyof.mustache") ||
      file.getTemplateFile().equals("gitlab-ci.mustache")
    );

    // repository
    supportingFiles.add(new SupportingFile("pyproject.mustache", "../", "pyproject.toml"));
    supportingFiles.add(new SupportingFile("gitignore.mustache", "../", ".gitignore"));
    supportingFiles.add(new SupportingFile("__init__.mustache", "", "__init__.py"));
    supportingFiles.add(new SupportingFile("__init__.mustache", packageName, "__init__.py"));
    supportingFiles.add(new SupportingFile("__init__.mustache", packageName + "/models", "__init__.py"));
    supportingFiles.add(new SupportingFile("__init__.mustache", "http", "__init__.py"));
    supportingFiles.add(new SupportingFile("config.mustache", packageName, "config.py"));
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
  }

  @Override
  public String toApiFilename(String name) {
    return "client";
  }

  @Override
  public String toApiImport(String name) {
    return super.toApiImport(name).replace("from ", "from algoliasearch.");
  }

  @Override
  public String toModelImport(String name) {
    return super.toModelImport(name).replace("from ", "from algoliasearch.");
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    return Helpers.specifyCustomRequest(super.fromOperation(path, httpMethod, operation, servers));
  }

  // we need to override imports of all operations because somehow the methods `toModelImport` and
  // `toApiImport` does not override the imports used in the API client file (client.py).
  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);

    List<Map<String, String>> imports = operations.getImports();

    for (Map<String, String> imp : imports) {
      imp.put("import", imp.get("import").replace("from " + CLIENT + ".", "from algoliasearch." + CLIENT + "."));
    }

    operations.setImports(imports);

    return operations;
  }
}
