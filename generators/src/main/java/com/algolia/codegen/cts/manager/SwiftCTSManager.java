package com.algolia.codegen.cts.manager;

import com.algolia.codegen.AlgoliaSwiftGenerator;
import com.algolia.codegen.cts.lambda.SwiftPrefixLambda;
import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.Helpers;
import com.samskivert.mustache.Mustache.Lambda;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openapitools.codegen.SupportingFile;

public class SwiftCTSManager implements CTSManager {

  private final String client;

  public SwiftCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "swift";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("tests/Package.mustache", "tests/output/swift", "Package.swift"));
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("import", Helpers.capitalize(Helpers.camelize(this.client)));
    bundle.put(
      "packageList",
      Helpers.getClientListForLanguage("swift")
        .stream()
        .map(packageName -> Helpers.capitalize(Helpers.camelize(packageName)))
        .collect(Collectors.toList())
    );
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/.swiftformat.mustache", output + "/swift", ".swiftformat"));
    supportingFiles.add(new SupportingFile("snippets/.gitignore.mustache", output + "/swift", ".gitignore"));

    if (output.equals("docs/snippets")) {
      supportingFiles.add(new SupportingFile("snippets/Package.mustache", output + "/swift", "Package.swift"));
    } else if (output.equals("docs/guides")) {
      supportingFiles.add(new SupportingFile("guides/Package.mustache", output + "/swift", "Package.swift"));
    }
  }

  @Override
  public void addMustacheLambdas(Map<String, Lambda> lambdas) {
    lambdas.put("identifier", (fragment, writer) -> writer.write(AlgoliaSwiftGenerator.formatIdentifier(fragment.execute())));
    lambdas.put("prefix", new SwiftPrefixLambda(client));
  }
}
