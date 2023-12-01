package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.RubyClientCodegen;

public class AlgoliaRubyGenerator extends RubyClientCodegen {

  private String CLIENT;

  @Override
  public String getName() {
    return "algolia-ruby";
  }

  @Override
  public void processOpts() {
    CLIENT = (String) additionalProperties.get("client");

    additionalProperties.put("isSearchClient", CLIENT.equals("search"));
    additionalProperties.put("packageVersion", Utils.getClientConfigField("ruby", "packageVersion"));
    setGemName("algolia");

    setApiNameSuffix(Utils.API_SUFFIX);

    super.processOpts();

    // // Generation notice, added on every generated files
    Utils.setGenerationBanner(additionalProperties);

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();

    // Remove some files we don't want to output or change their paths
    supportingFiles.removeIf(file ->
      file.getTemplateFile().equals("gitignore.mustache") ||
      file.getTemplateFile().equals("travis.mustache") ||
      file.getTemplateFile().equals("rspec.mustache") ||
      file.getTemplateFile().equals("Gemfile.mustache") ||
      file.getTemplateFile().equals("Rakefile.mustache") ||
      file.getTemplateFile().equals("api_client_spec.mustache") ||
      file.getTemplateFile().equals("git_push.sh.mustache") ||
      file.getTemplateFile().equals("api_test.mustache") ||
      file.getTemplateFile().equals("configuration_spec.mustache") ||
      file.getTemplateFile().equals("gitlab-ci.mustache") ||
      file.getTemplateFile().equals("spec_helper.mustache") ||
      file.getTemplateFile().equals("rubocop.mustache")
    );

    // repository

    try {
      Utils.generateServer(CLIENT, additionalProperties);
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  public String modelFileFolder() {
    return outputFolder + "/lib/" + gemName + "/models/" + CLIENT;
  }
}
