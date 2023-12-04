package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.CSharpClientCodegen;

public class AlgoliaCSharpGenerator extends CSharpClientCodegen {

  private String CLIENT;

  @Override
  public String getName() {
    return "algolia-csharp";
  }

  public String getClientName(String client) {
    return Utils.createClientName(client, "csharp");
  }

  @Override
  public void processOpts() {
    CLIENT = (String) additionalProperties.get("client");
    setLibrary("httpclient");

    additionalProperties.put("sourceFolder", "");
    additionalProperties.put("netCoreProjectFile", true);
    additionalProperties.put("targetFramework", "netstandard2.0");
    additionalProperties.put("isSearchClient", CLIENT.equals("search"));
    additionalProperties.put(CodegenConstants.EXCLUDE_TESTS, true);

    setApiNameSuffix(Utils.API_SUFFIX);

    String packageName = getClientName(CLIENT);
    setPackageName(packageName);
    setApiPackage("");
    setModelPackage("Models");

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
      file.getTemplateFile().equals("Solution.mustache") ||
      file.getTemplateFile().equals("README.mustache") ||
      file.getTemplateFile().equals("netcore_project.mustache") ||
      file.getTemplateFile().equals("netcore_testproject.mustache") ||
      file.getTemplateFile().equals("gitignore.mustache") ||
      file.getTemplateFile().equals("IApiAccessor.mustache") ||
      file.getTemplateFile().equals("HttpSigningConfiguration.mustache") ||
      file.getTemplateFile().equals("RetryConfiguration.mustache") ||
      file.getTemplateFile().equals("appveyor.mustache")
    );

    // repository
    supportingFiles.add(new SupportingFile("Solution.mustache", "../", "Algolia.Search.sln"));
    supportingFiles.add(new SupportingFile("netcore_project.mustache", "Algolia.Search.csproj"));
    supportingFiles.add(new SupportingFile("Solution.mustache", "../", "Algolia.Search.sln"));
    supportingFiles.add(new SupportingFile("gitignore.mustache", "../", ".gitignore"));

    try {
      Utils.generateServer(CLIENT, additionalProperties);
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
