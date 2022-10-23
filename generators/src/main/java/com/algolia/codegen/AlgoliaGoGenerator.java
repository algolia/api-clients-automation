package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import java.io.File;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.languages.GoClientCodegen;

public class AlgoliaGoGenerator extends GoClientCodegen {

  private final String OUTPUT_FOLDER = "algolia/ingestion";

  @Override
  public String getName() {
    return "algolia-go";
  }

  @Override
  public void processOpts() {
    String client = (String) additionalProperties.get("client");
    additionalProperties.put("enumClassPrefix", true);

    super.processOpts();

    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();

    supportingFiles.clear();
    supportingFiles.add(new SupportingFile("configuration.mustache", OUTPUT_FOLDER, "configuration.go"));
    supportingFiles.add(new SupportingFile("client.mustache", OUTPUT_FOLDER, "client.go"));
    supportingFiles.add(new SupportingFile("response.mustache", OUTPUT_FOLDER, "response.go"));

    try {
      Utils.generateServer(client, additionalProperties);

      additionalProperties.put("packageVersion", Utils.getClientConfigField("go", "packageVersion"));
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  public String modelFileFolder() {
    return super.modelFileFolder() + OUTPUT_FOLDER + File.separator;
  }

  @Override
  public String apiFileFolder() {
    return super.apiFileFolder() + OUTPUT_FOLDER + File.separator;
  }
}
