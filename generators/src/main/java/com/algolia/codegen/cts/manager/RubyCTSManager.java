package com.algolia.codegen.cts.manager;

import com.algolia.codegen.cts.lambda.CodeIdentifierLambda;
import com.algolia.codegen.cts.lambda.RubyIdentifierLambda;
import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.samskivert.mustache.Mustache.Lambda;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class RubyCTSManager implements CTSManager {

  private final String client;

  public RubyCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "ruby";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("modelModule", Helpers.capitalize(Helpers.camelize(client)));
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/Gemfile.mustache", output + "/ruby", "Gemfile"));
  }

  @Override
  public void addMustacheLambdas(Map<String, Lambda> lambdas) {
    lambdas.put("identifier", new RubyIdentifierLambda());
    lambdas.put("codeIdentifier", new CodeIdentifierLambda(RubyIdentifierLambda::formatIdentifier));
  }
}
