package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
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
    return Helpers.createClientName(client, "csharp");
  }

  @Override
  public void processOpts() {
    CLIENT = (String) additionalProperties.get("client");
    setLibrary("httpclient");

    additionalProperties.put("sourceFolder", "");
    additionalProperties.put("netCoreProjectFile", true);
    additionalProperties.put("targetFramework", "netstandard2.1;netstandard2.0");
    additionalProperties.put("isSearchClient", CLIENT.equals("search"));
    additionalProperties.put("validatable", false);
    additionalProperties.put("equatable", false);
    additionalProperties.put(CodegenConstants.EXCLUDE_TESTS, true);

    setApiNameSuffix(Helpers.API_SUFFIX);

    String packageName = getClientName(CLIENT);
    setPackageName(packageName);
    setApiPackage("");
    setModelPackage("Models");

    super.processOpts();

    modelNameMapping.put("Task", "IngestionTask");

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

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
      file.getTemplateFile().equals("IAsynchronousClient.mustache") ||
      file.getTemplateFile().equals("FileParameter.mustache") ||
      file.getTemplateFile().equals("RetryConfiguration.mustache") ||
      file.getTemplateFile().equals("ApiClient.mustache") ||
      file.getTemplateFile().equals("OpenAPIDateConverter.mustache") ||
      file.getTemplateFile().equals("ExceptionFactory.mustache") ||
      file.getTemplateFile().equals("ISynchronousClient.mustache") ||
      file.getTemplateFile().equals("ReadOnlyDictionary.mustache") ||
      file.getTemplateFile().equals("WebRequestPathBuilder.mustache") ||
      file.getTemplateFile().equals("RequestOptions.mustache") ||
      file.getTemplateFile().equals("AbstractOpenAPISchema.mustache") ||
      file.getTemplateFile().equals("ApiResponse.mustache") ||
      file.getTemplateFile().equals("GlobalConfiguration.mustache") ||
      file.getTemplateFile().equals("IReadableConfiguration.mustache") ||
      file.getTemplateFile().equals("ClientUtils.mustache") ||
      file.getTemplateFile().equals("appveyor.mustache")
    );

    // repository
    supportingFiles.add(new SupportingFile("Solution.mustache", "../", "Algolia.Search.sln"));
    supportingFiles.add(new SupportingFile("netcore_project.mustache", "Algolia.Search.csproj"));
    supportingFiles.add(new SupportingFile("RequestOptions.mustache", "Lib", "RequestOptions.cs"));
    supportingFiles.add(new SupportingFile("AbstractOpenAPISchema.mustache", "Models", "AbstractSchema.cs"));
    supportingFiles.add(new SupportingFile("ClientUtils.mustache", "Lib", "ClientUtils.cs"));
    supportingFiles.add(new SupportingFile("gitignore.mustache", "../", ".gitignore"));

    try {
      Helpers.generateServer(CLIENT, additionalProperties);
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
