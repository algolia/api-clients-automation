package com.algolia.codegen.cts.manager;

import com.algolia.codegen.cts.lambda.CodeIdentifierLambda;
import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.Helpers;
import com.samskivert.mustache.Mustache.Lambda;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class PythonCTSManager implements CTSManager {

  private final String client;

  public PythonCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "python";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/__init__.mustache", "tests/output/python/tests/", "__init__.py"));
    supportingFiles.add(new SupportingFile("tests/__init__.mustache", "tests/output/python/tests/requests", "__init__.py"));
    supportingFiles.add(new SupportingFile("tests/__init__.mustache", "tests/output/python/tests/client", "__init__.py"));
    supportingFiles.add(new SupportingFile("tests/__init__.mustache", "tests/output/python/tests/e2e", "__init__.py"));
    supportingFiles.add(new SupportingFile("tests/__init__.mustache", "tests/output/python/tests/benchmark", "__init__.py"));
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/pyproject.mustache", output + "/python", "pyproject.toml"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("import", Helpers.toSnakeCase(this.client).toLowerCase());
  }

  @Override
  public void addMustacheLambdas(Map<String, Lambda> lambdas) {
    lambdas.put("codeIdentifier", new CodeIdentifierLambda(Helpers::toSnakeCase));
  }
}
