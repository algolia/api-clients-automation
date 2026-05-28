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
    if (client.equals("algoliasearch")) {
      bundle.put("import", "package:algoliasearch/algoliasearch_lite.dart");
      bundle.put("client", "SearchClient");
    } else {
      String packageName = "algolia_client_" + StringUtils.lowerCase(client).replace("-", "_");
      bundle.put("import", "package:" + packageName + "/" + packageName + ".dart");
      bundle.put("client", WordUtils.capitalizeFully(client, '-').replace("-", "") + "Client");
    }

    // Spec server timeouts per client, mirroring what Timeouts.enrichBundle exposes
    // to the production api.mustache. Used by tests/client templates to construct
    // ClientOptions with the same defaults the generated client would supply.
    long connect = 2000;
    long read = 5000;
    long write = 30000;
    if (client.equals("ingestion")) {
      connect = 25000;
      read = 25000;
      write = 25000;
    }
    bundle.put("serverConnectTimeout", connect);
    bundle.put("serverReadTimeout", read);
    bundle.put("serverWriteTimeout", write);
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
        writer.write(snakeToCamel(text));
      }
    });
  }

  private static String snakeToCamel(String s) {
    if (!s.contains("_")) return s;
    StringBuilder sb = new StringBuilder();
    boolean nextUpper = false;
    for (char c : s.toCharArray()) {
      if (c == '_') {
        nextUpper = true;
      } else if (nextUpper) {
        sb.append(Character.toUpperCase(c));
        nextUpper = false;
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
