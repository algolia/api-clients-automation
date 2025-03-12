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
      supportingFiles.add(
        new SupportingFile(
          "guides/" + client + "/" + f.getName(),
          "docs/guides/" + language + outputFolder + f.getName().replace(".mustache", "") + extension
        )
      );
    }

    switch (language) {
      case "csharp":
        supportingFiles.add(
          new SupportingFile("guides/program.mustache", "docs/guides/" + language + outputFolder + "program" + extension)
        );
        break;
      case "go":
        supportingFiles.add(new SupportingFile("guides/main.mustache", "docs/guides/" + language + outputFolder + "main" + extension));
        break;
      case "php":
        supportingFiles.add(new SupportingFile("guides/.gitignore", "docs/guides/" + language + outputFolder + ".gitignore"));
        supportingFiles.add(new SupportingFile("guides/composer.json", "docs/guides/" + language + outputFolder + "composer.json"));
        supportingFiles.add(new SupportingFile("guides/phpstan.neon", "docs/guides/" + language + outputFolder + "phpstan.neon"));
        break;
      default:
        break;
    }
  }

  @Override
  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    if (this.client.equals("search")) {
      bundle.put("isSearchClient", true);
    }
    bundle.put("isSyncClient", true);
    bundle.put("isGuide", true);
    // nothing to do here, the mustache uses dynamicSnippet lambda
  }
}
