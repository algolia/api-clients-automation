package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
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
  public void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles) {
    supportingFiles.add(new SupportingFile("snippets/.gitignore.mustache", "snippets/dart/.gitignore"));
    supportingFiles.add(new SupportingFile("snippets/analysis_options.mustache", "snippets/dart/analysis_options.yaml"));
    supportingFiles.add(new SupportingFile("snippets/pubspec.mustache", "snippets/dart/pubspec.yaml"));
    supportingFiles.add(new SupportingFile("snippets/pubspec_overrides.mustache", "snippets/dart/pubspec_overrides.yaml"));
  }
}
