package com.algolia.codegen;

import java.io.File;
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
    setApiPackage(client);
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
    String packagePath = packagePath() + File.separatorChar + modelPackage;
    supportingFiles.add(new SupportingFile("__init__.mustache", packagePath, "__init__.py"));
    // supportingFiles.add(new SupportingFile("__init__model.mustache", modelPath, "__init__.py"));
    // String apiPath = packagePath() + File.separatorChar + apiPackage.replace('.',
    // File.separatorChar);
    // supportingFiles.add(new SupportingFile("__init__api.mustache", apiPath, "__init__.py"));
  }
}
