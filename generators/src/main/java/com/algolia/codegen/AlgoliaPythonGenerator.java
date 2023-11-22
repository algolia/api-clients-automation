package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.languages.PythonClientCodegen;

public class AlgoliaPythonGenerator extends PythonClientCodegen {

  @Override
  public String getName() {
    return "algolia-python";
  }

  @Override
  public void processOpts() {
    String client = (String) additionalProperties.get("client");

    additionalProperties.put("isSearchClient", client.equals("search"));
    additionalProperties.put("packageVersion", Utils.getClientConfigField("python", "packageVersion"));
    additionalProperties.put(CodegenConstants.EXCLUDE_TESTS, true);

    setApiNameSuffix(Utils.API_SUFFIX);

    setPackageName(Utils.toSnakeCase(client));
    setApiPackage("api");
    setModelPackage("models");

    super.processOpts();

    // // Generation notice, added on every generated files
    Utils.setGenerationBanner(additionalProperties);

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();

    // Remove some files we don't want to output or change their paths
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("git_push.sh.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("requirements.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("test-requirements.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("tox.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("setup_cfg.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("setup.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("pyproject.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("py.typed.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("rest.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("README.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("api_test.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("model_test.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("github-workflow.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("travis.mustache"));
    supportingFiles.removeIf(file -> file.getTemplateFile().equals("gitlab-ci.mustache"));

    // repository
    supportingFiles.add(new SupportingFile("pyproject.mustache", "../", "pyproject.toml"));
    supportingFiles.add(new SupportingFile("LICENSE.mustache", "../", "LICENSE"));
    supportingFiles.add(new SupportingFile("SECURITY.mustache", "../", "SECURITY.md"));
    supportingFiles.add(new SupportingFile("CONTRIBUTING.mustache", "../", "CONTRIBUTING.md"));
    supportingFiles.add(new SupportingFile("README.mustache", "../", "README.md"));

    try {
      Utils.generateServer(client, additionalProperties);
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
