package com.algolia.codegen;

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

    // Generation notice, added on every generated files
    Utils.setGenerationBanner(additionalProperties);
  }
}
