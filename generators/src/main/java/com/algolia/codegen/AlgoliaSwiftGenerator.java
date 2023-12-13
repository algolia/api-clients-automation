package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.GenericPropagator;
import com.algolia.codegen.utils.Helpers;
import com.algolia.codegen.utils.OneOf;
import com.samskivert.mustache.Mustache;
import java.io.File;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.Swift5ClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaSwiftGenerator extends Swift5ClientCodegen {

  private String CLIENT;

  @Override
  public String getName() {
    return "algolia-swift";
  }

  public String getClientName(String client) {
    return Helpers.createClientName(client, "swift");
  }

  @Override
  public void processOpts() {
    CLIENT = (String) additionalProperties.get("client");

    // We will use the default URLSession library coming from the Foundation package to handle HTTP
    // requests
    setLibrary(LIBRARY_URLSESSION);

    additionalProperties.put("isSearchClient", CLIENT.equals("search"));
    additionalProperties.put(CodegenConstants.EXCLUDE_TESTS, true);

    additionalProperties.put(POD_SUMMARY, "Algolia Search API Client written in Swift.");
    additionalProperties.put(POD_HOMEPAGE, "https://github.com/algolia/algoliasearch-client-swift/tree/next");
    additionalProperties.put(POD_LICENSE, "{ :type => 'MIT', :file => 'LICENSE' }");
    additionalProperties.put(POD_DOCUMENTATION_URL, "https://www.algolia.com/doc/api-client/getting-started/what-is-the-api-client/swift/");
    additionalProperties.put(POD_SOURCE, "{ :git => 'https://github.com/algolia/algoliasearch-client-swift.git', :branch => 'next'" + " }");
    additionalProperties.put(POD_AUTHORS, "{ 'Algolia' => 'contact@algolia.com' }");
    additionalProperties.put(CodegenConstants.POD_VERSION, "9.0.0-alpha.0");
    additionalProperties.put(RESPONSE_AS, new String[] { RESPONSE_LIBRARY_ASYNC_AWAIT });
    additionalProperties.put(CodegenConstants.PROJECT_NAME, "AlgoliaSearchClient");
    additionalProperties.put(SWIFT_PACKAGE_PATH, "Sources" + File.separator + "AlgoliaSearchClient");

    additionalProperties.put("lambda.type-to-name", (Mustache.Lambda) (fragment, writer) -> writer.write(typeToName(fragment.execute())));

    setObjcCompatible(true);
    setProjectName("AlgoliaSearchClient");
    setUseSPMFileStructure(true);

    setApiNamePrefix("");
    setModelNamePrefix("");
    setApiPackage(File.separator + "Client");
    setModelPackage(File.separator + "Models");

    super.processOpts();

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    try {
      Helpers.generateServer(CLIENT, additionalProperties);
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();
  }

  private String typeToName(String content) {
    var trimmedContent = content.trim();
    var isList = trimmedContent.charAt(0) == '[' && trimmedContent.charAt(trimmedContent.length() - 1) == ']';
    var isDictionary = isList && trimmedContent.contains(": ");
    var name = trimmedContent;
    if (isDictionary) {
      isList = false;
      name = trimmedContent.replace("[", "DictionaryOf").replace(": ", "To").replace("]", "");
    }
    if (isList) {
      name = trimmedContent.replace("[", "ArrayOf").replace("]", "");
    }

    return name;
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    OneOf.updateModelsOneOfForSwift(models, modelPackage);
    GenericPropagator.propagateGenericsToModels(models);
    return models;
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }

  @Override
  public String toRegularExpression(String pattern) {
    return escapeText(pattern);
  }
}
