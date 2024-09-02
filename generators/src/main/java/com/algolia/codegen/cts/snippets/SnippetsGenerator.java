package com.algolia.codegen.cts.snippets;

import com.algolia.codegen.cts.manager.CTSManager;
import com.algolia.codegen.cts.tests.*;
import com.algolia.codegen.utils.*;
import java.io.File;
import java.util.*;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;

public class SnippetsGenerator extends TestsRequest {

  public SnippetsGenerator(CTSManager ctsManager) {
    super(ctsManager, true);
  }

  @Override
  public boolean available() {
    File templates = new File("templates/" + language + "/snippets/method.mustache");
    return templates.exists();
  }

  @Override
  public void addSupportingFiles(List<SupportingFile> supportingFiles, String outputFolder, String extension) {
    if (!available()) {
      return;
    }

    extension = Helpers.getClientConfigField(language, "snippets", "extension");
    outputFolder = Helpers.getClientConfigField(language, "snippets", "outputFolder");

    if (!outputFolder.equals("")) {
      outputFolder = "/" + outputFolder + "/";
    } else {
      outputFolder = "/";
    }

    supportingFiles.add(
      new SupportingFile(
        "snippets/method.mustache",
        "snippets/" + language + outputFolder + Helpers.createClientName(client, language) + extension
      )
    );
  }

  @Override
  public void run(Map<String, CodegenModel> models, Map<String, CodegenOperation> operations, Map<String, Object> bundle) throws Exception {
    super.run(models, operations, bundle);
  }
}
