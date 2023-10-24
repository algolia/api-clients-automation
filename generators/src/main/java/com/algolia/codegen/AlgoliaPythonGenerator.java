package com.algolia.codegen;

import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.languages.PythonClientCodegen;

public class AlgoliaPythonGenerator extends PythonClientCodegen {

  @Override
  public String getName() {
    return "algolia-python";
  }

  @Override
  public void processOpts() {
    // generator specific options
    String client = (String) additionalProperties.get("client");
    setPackageName("algoliasearch");
    setApiNameSuffix(Utils.API_SUFFIX);
    setModelPackage(client);
    setApiPackage(""); // root
    super.processOpts();

    // Generation notice, added on every generated files
    Utils.setGenerationBanner(additionalProperties);

    // Prevent generating tests
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();

    // Prevent generating custom docs
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();

    // Remove default supporting files
    supportingFiles.clear();

    additionalProperties.put("packageVersion", Utils.getClientConfigField("python", "packageVersion"));

    supportingFiles.add(new SupportingFile("pyproject.mustache", "", "pyproject.toml"));
    supportingFiles.add(new SupportingFile("version.mustache", packagePath(), "version.py"));
  }
}
