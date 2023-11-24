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
    setApiNameSuffix(Utils.API_SUFFIX);

    additionalProperties.put("netCoreProjectFile", "true");
    additionalProperties.put("targetFramework", "netstandard2.0");
    additionalProperties.put("isSearchClient", client.equals("search"));
    additionalProperties.put("packageName", "Algolia." + Utils.capitalize(client));

    String outputFolder = "packages" + File.separator + client;
    setOutputDir(getOutputDir() + File.separator + outputFolder);

    super.processOpts();

    // Generation notice, added on every generated files
    Utils.setGenerationBanner(additionalProperties);

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();

    // Remove some files we don't want to output or change their paths
    supportingFiles.removeIf(file ->
      file.getTemplateFile().equals("git_push.sh.mustache") ||
      file.getTemplateFile().equals("openapi.mustache") ||
      file.getTemplateFile().equals("appveyor.mustache")
    );
  }
}
