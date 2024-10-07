package com.algolia.codegen.cts.guides;

import com.algolia.codegen.cts.manager.CTSManager;
import com.algolia.codegen.cts.tests.TestsGenerator;
import com.algolia.codegen.utils.*;
import java.io.File;
import java.util.*;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;

public class GuidesGenerator extends TestsGenerator {

  public GuidesGenerator(CTSManager ctsManager) {
    super(ctsManager);
  }

  @Override
  public boolean available() {
    File templates = new File("templates/" + language + "/guides/" + client);
    return templates.exists();
  }

  @Override
  public void addSupportingFiles(List<SupportingFile> supportingFiles, String outputFolder, String extension) {
    if (!available()) {
      return;
    }

    // same extension as the snippets
    extension = Helpers.getClientConfigField(language, "snippets", "extension");
    outputFolder = Helpers.getClientConfigField(language, "snippets", "outputFolder");

    if (!outputFolder.equals("")) {
      outputFolder = "/" + outputFolder + "/";
    } else {
      outputFolder = "/";
    }

    File templates = new File("templates/" + language + "/guides/" + client);
    for (File f : templates.listFiles()) {
      String fileName = f.getName().replace(".mustache", "");

      if (language.equals("swift")) {
        fileName = Helpers.capitalize(fileName) + "/main";
      }

      supportingFiles.add(
        new SupportingFile("guides/" + client + "/" + f.getName(), "guides/" + language + outputFolder + fileName + extension)
      );
    }
  }

  @Override
  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    if (this.client.equals("search")) {
      bundle.put("isSearchClient", true);
    }
    bundle.put("isSyncClient", true);

    if (language.equals("swift")) {
      File templates = new File("templates/" + language + "/guides/" + client);
      bundle.put(
        "guides",
        Arrays.stream(templates.listFiles()).map(File::getName).map(name -> Helpers.capitalize(name.replace(".mustache", ""))).toArray()
      );
    }
    // no data to add to the bundle, the mustache uses dynamicSnippets lambda
  }
}
