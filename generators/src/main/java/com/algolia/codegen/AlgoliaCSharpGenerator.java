package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import java.io.File;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.CSharpClientCodegen;

public class AlgoliaCSharpGenerator extends CSharpClientCodegen {

  @Override
  public String getName() {
    return "algolia-csharp";
  }

  @Override
  public void processOpts() {
    String client = (String) additionalProperties.get("client");
    additionalProperties.put("library", "httpClient");
    additionalProperties.put("netCoreProjectFile", true);
    additionalProperties.put("targetFramework", "netstandard2.0");
    additionalProperties.put("isSearchClient", client.equals("search"));

    String outputFolder = "algolia" + File.separator + client;
    setOutputDir(getOutputDir() + File.separator + outputFolder);

    super.processOpts();

    // Generation notice, added on every generated files
    Utils.setGenerationBanner(additionalProperties);
  }
}
