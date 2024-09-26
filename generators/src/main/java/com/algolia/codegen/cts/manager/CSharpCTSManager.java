package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class CSharpCTSManager implements CTSManager {

  private final String client;

  public CSharpCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "csharp";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("globaljson.mustache", "tests/output/csharp", "global.json"));
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("snippets/src.csproj.mustache", "snippets/csharp/src/src.csproj"));
    supportingFiles.add(new SupportingFile("snippets/Program.mustache", "snippets/csharp/src/Program.cs"));
    supportingFiles.add(new SupportingFile("snippets/.gitignore.mustache", "snippets/csharp/.gitignore"));
    supportingFiles.add(new SupportingFile("snippets/Algolia.mustache", "snippets/csharp/Algolia.sln"));
    supportingFiles.add(new SupportingFile("snippets/dotnet-tools.mustache", "snippets/csharp/.config/dotnet-tools.json"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", getVersion());
  }
}
