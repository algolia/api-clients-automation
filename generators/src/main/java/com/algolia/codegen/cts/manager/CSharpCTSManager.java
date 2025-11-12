package com.algolia.codegen.cts.manager;

import com.algolia.codegen.cts.lambda.CSharpIdentifierLambda;
import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.samskivert.mustache.Mustache.Lambda;
import java.io.IOException;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class CSharpCTSManager implements CTSManager {

  private final String client;
  private final String overrideLanguageVersion;

  public CSharpCTSManager(String client, String overrideLanguageVersion) {
    this.client = client;
    this.overrideLanguageVersion = overrideLanguageVersion;
  }

  public String getLanguage() {
    return "csharp";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(
      new SupportingFile("tests/Algolia.Search.Tests.csproj.mustache", "tests/output/csharp/src", "Algolia.Search.Tests.csproj")
    );
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/src.csproj.mustache", output + "/csharp/src/src.csproj"));
    supportingFiles.add(new SupportingFile("snippets/.gitignore.mustache", output + "/csharp/.gitignore"));
    supportingFiles.add(new SupportingFile("snippets/Algolia.mustache", output + "/csharp/Algolia.sln"));
    supportingFiles.add(new SupportingFile("snippets/dotnet-tools.mustache", output + "/csharp/.config/dotnet-tools.json"));
    supportingFiles.add(new SupportingFile("snippets/csharpierignore.mustache", output + "/csharp/.csharpierignore"));

    if (output.equals("docs/snippets")) {
      supportingFiles.add(new SupportingFile("snippets/Program.mustache", output + "/csharp/src/Program.cs"));
    }
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    try {
      String dotnetVersion = getLanguageVersion(overrideLanguageVersion);
      String[] parts = dotnetVersion.split("\\.");
      bundle.put("dotnetVersion", parts[0] + "." + parts[1]);
    } catch (IOException e) {
      throw new GeneratorException("Failed to compute dotnet version", e);
    }
  }

  @Override
  public void addMustacheLambdas(Map<String, Lambda> lambdas) {
    lambdas.put("identifier", new CSharpIdentifierLambda(client));
  }
}
