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
    setLibrary("httpclient");

    additionalProperties.put("netCoreProjectFile", 'true');
    additionalProperties.put("targetFramework", "netstandard2.0");
    additionalProperties.put("isSearchClient", client.equals("search"));
    additionalProperties.put("packageName", "Algolia." + Utils.camelize(client));

    String outputFolder = "packages" + File.separator + client;
    setOutputDir(getOutputDir() + File.separator + outputFolder);

    super.processOpts();


    Utils.prettyPrint(supportingFiles);

    // Generation notice, added on every generated files
    Utils.setGenerationBanner(additionalProperties);
  }
}
