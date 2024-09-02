package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.*;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

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
}
