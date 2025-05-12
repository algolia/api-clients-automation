package com.algolia.codegen.cts.manager;

import com.algolia.codegen.AlgoliaGoGenerator;
import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.samskivert.mustache.Mustache.Lambda;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class GoCTSManager implements CTSManager {

  private final String client;

  public GoCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "go";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    String clientPrefix = (String) bundle.get("clientPrefix");
    bundle.put("clientName", Helpers.toPascalCase(this.client));

    if (clientPrefix.equals("query-suggestions")) {
      bundle.put("clientPrefix", "suggestions");
    } else {
      bundle.put("clientPrefix", Helpers.camelize(clientPrefix));
    }

    bundle.put("clientImport", clientPrefix);
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/.golangci.mustache", output + "/go/.golangci.yml"));
    supportingFiles.add(new SupportingFile("snippets/go.mod.mustache", output + "/go/go.mod"));
  }

  @Override
  public void addMustacheLambdas(Map<String, Lambda> lambdas) {
    lambdas.put("toEnum", (fragment, writer) -> writer.write(AlgoliaGoGenerator.toEnum(fragment.execute())));
  }
}
