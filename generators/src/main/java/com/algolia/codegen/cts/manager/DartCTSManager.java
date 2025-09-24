package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import com.samskivert.mustache.Mustache.Lambda;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.openapitools.codegen.SupportingFile;

public class DartCTSManager implements CTSManager {

  private final String client;

  public DartCTSManager(String client) {
    this.client = client;
  }

  public String getLanguage() {
    return "dart";
  }

  public String getClient() {
    return client;
  }

  @Override
  public void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    bundle.put("packageVersion", getVersion());
    if (client.equals("algoliasearch")) {
      bundle.put("import", "package:algoliasearch/algoliasearch_lite.dart");
      bundle.put("client", "SearchClient");
    } else {
      String packageName = "algolia_client_" + StringUtils.lowerCase(client).replace("-", "_");
      bundle.put("import", "package:" + packageName + "/" + packageName + ".dart");
      bundle.put("client", WordUtils.capitalizeFully(client, '-').replace("-", "") + "Client");
    }
  }

  @Override
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    supportingFiles.add(new SupportingFile("snippets/.gitignore.mustache", output + "/dart/.gitignore"));
    supportingFiles.add(new SupportingFile("analysis_options.tests.mustache", output + "/dart/analysis_options.yaml"));
    supportingFiles.add(new SupportingFile("pubspec.tests.mustache", output + "/dart/pubspec.yaml"));
    supportingFiles.add(new SupportingFile("pubspec_overrides.tests.mustache", output + "/dart/pubspec_overrides.yaml"));
  }

  @Override
  public void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("analysis_options.tests.mustache", "tests/output/dart/analysis_options.yaml"));
    supportingFiles.add(new SupportingFile("pubspec.tests.mustache", "tests/output/dart/pubspec.yaml"));
    supportingFiles.add(new SupportingFile("pubspec_overrides.tests.mustache", "tests/output/dart/pubspec_overrides.yaml"));
  }

  @Override
  public void addMustacheLambdas(Map<String, Lambda> lambdas) {
    lambdas.put("identifier", (fragment, writer) -> {
      String text = fragment.execute();
      if (text.equals("external")) {
        writer.write("external_");
      } else {
        writer.write(text);
      }
    });
  }
}
