package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import java.io.File;
import java.util.*;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.Swift5ClientCodegen;

public class AlgoliaSwiftGenerator extends Swift5ClientCodegen {

  private String CLIENT;

  @Override
  public String getName() {
    return "algolia-swift";
  }

  public String getClientName(String client) {
    return Utils.createClientName(client, "swift");
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
    //    additionalProperties.put(SWIFT_USE_API_NAMESPACE, false);

    setSwiftPackagePath("");
    setObjcCompatible(true);
    setProjectName("AlgoliaSearchClient");
    setUseSPMFileStructure(true);

    setApiPackage("Sources" + File.separator + projectName);
    setModelPackage("Sources" + File.separator + projectName + "Models");

    super.processOpts();

    // Generation notice, added on every generated files
    Utils.setGenerationBanner(additionalProperties);

    // Prevent all useless file to generate
    apiDocTemplateFiles.clear();
    modelDocTemplateFiles.clear();
    apiTestTemplateFiles.clear();
    modelTestTemplateFiles.clear();
  }
}
