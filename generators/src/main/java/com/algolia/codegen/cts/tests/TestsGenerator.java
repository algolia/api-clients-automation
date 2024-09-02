package com.algolia.codegen.cts.tests;

import com.algolia.codegen.cts.manager.CTSManager;
import com.algolia.codegen.exceptions.CTSException;
import com.algolia.codegen.utils.*;
import io.swagger.v3.core.util.Json;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;

public abstract class TestsGenerator {

  protected final CTSManager ctsManager;
  protected final String language, client;

  public TestsGenerator(CTSManager ctsManager) {
    this.ctsManager = ctsManager;
    this.language = ctsManager.getLanguage();
    this.client = ctsManager.getClient();
  }

  public abstract boolean available();

  public abstract void addSupportingFiles(List<SupportingFile> supportingFiles, String outputFolder, String extension);

  public abstract void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle)
    throws Exception;

  protected <T> Map<String, T> loadCTS(String path, String clientName, Class<T> jsonType) throws Exception {
    if (!available()) {
      throw new CTSException("Templates not found for " + path, true);
    }

    File dir = new File("tests/CTS/" + path + "/" + clientName);
    File commonTestDir = new File("tests/CTS/" + path + "/common");
    if (!dir.exists()) {
      throw new CTSException("CTS not found at " + dir.getAbsolutePath(), true);
    }
    List<File> allTests = new ArrayList<>();
    Collections.addAll(allTests, dir.listFiles());
    if (commonTestDir.exists()) {
      Collections.addAll(allTests, commonTestDir.listFiles());
    }

    Map<String, T> cts = new TreeMap<>();

    for (File f : allTests) {
      String json = new String(Files.readAllBytes(Paths.get(f.getAbsolutePath())));
      json = injectVariables(json);
      cts.put(f.getName().replace(".json", ""), Json.mapper().readValue(json, jsonType));
    }
    return cts;
  }

  private String injectVariables(String json) {
    long threeDays = 3 * 24 * 60 * 60 * 1000;
    json = json
      .replace("${{language}}", language)
      .replace("${{languageCased}}", ctsManager.getLanguageCased())
      .replace("${{languageVersion}}", ctsManager.getVersion())
      .replace("${{clientPascalCase}}", Helpers.capitalize(Helpers.camelize(client)))
      .replace("\"${{nowRounded}}\"", String.valueOf(Math.round(System.currentTimeMillis() / threeDays) * threeDays));

    if (!language.equals("javascript") && !"true".equals(System.getenv("CI"))) {
      // hack for docker on mac, the `network=host` does not work so we need to use
      // another local IP
      json = json.replace("${{localhost}}", "host.docker.internal");
    } else {
      json = json.replace("${{localhost}}", "localhost");
    }
    return json;
  }
}
