package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.languages.TypeScriptNodeClientCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaJavascriptGenerator extends TypeScriptNodeClientCodegen {

  private String CLIENT;
  private boolean isAlgoliasearchClient;

  @Override
  public String getName() {
    return "algolia-javascript";
  }

  @Override
  public void processOpts() {
    super.processOpts();

    CLIENT = Helpers.camelize((String) additionalProperties.get("client"));
    isAlgoliasearchClient = CLIENT.equals("algoliasearch");

    // generator specific options
    setSupportsES6(true);
    setModelPropertyNaming("original");
    setApiPackage("src");
    reservedWordsMappings.put("queryParameters", "queryParameters");
    reservedWordsMappings.put("requestOptions", "requestOptions");
    reservedWordsMappings.put("delete", "delete");

    // Generation notice, added on every generated files
    Helpers.setGenerationBanner(additionalProperties);

    languageSpecificPrimitives.add("Record");
    instantiationTypes.put("map", "Record");
    // clear all supported files to avoid unwanted ones
    supportingFiles.clear();

    // Files common to both generations
    supportingFiles.add(new SupportingFile("tsup.config.mustache", "", "tsup.config.ts"));
    supportingFiles.add(new SupportingFile("rollup.config.mustache", "", "rollup.config.js"));
    supportingFiles.add(new SupportingFile("package.mustache", "", "package.json"));
    supportingFiles.add(new SupportingFile("tsconfig.mustache", "", "tsconfig.json"));

    // root export files
    supportingFiles.add(new SupportingFile("index.mustache", "", "index.js"));
    supportingFiles.add(new SupportingFile("index.d.mustache", "", "index.d.ts"));

    supportingFiles.add(new SupportingFile("LICENSE", "", "LICENSE"));
    supportingFiles.add(new SupportingFile("LICENSE", "", "../../LICENSE"));
    supportingFiles.add(new SupportingFile("issue.yml", "../../.github/workflows", "issue.yml"));
    supportingFiles.add(new SupportingFile("Bug_report.yml", "../../.github/ISSUE_TEMPLATE", "Bug_report.yml"));

    supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));

    // `client` related files, `algoliasearch` have it's own logic below
    if (!isAlgoliasearchClient) {
      // models
      supportingFiles.add(new SupportingFile("client/model/clientMethodProps.mustache", "model", "clientMethodProps.ts"));
      supportingFiles.add(new SupportingFile("client/model/modelBarrel.mustache", "model", "index.ts"));

      // builds
      supportingFiles.add(new SupportingFile("client/builds/browser.mustache", "builds", "browser.ts"));
      supportingFiles.add(new SupportingFile("client/builds/node.mustache", "builds", "node.ts"));
      supportingFiles.add(new SupportingFile("client/builds/fetch.mustache", "builds", "fetch.ts"));
    }
    // `algoliasearch` related files
    else {
      supportingFiles.add(new SupportingFile("README.mustache", "", "../../README.md"));

      // `algoliasearch` builds
      supportingFiles.add(new SupportingFile("algoliasearch/builds/definition.mustache", "builds", "browser.ts"));
      supportingFiles.add(new SupportingFile("algoliasearch/builds/definition.mustache", "builds", "node.ts"));
      supportingFiles.add(new SupportingFile("algoliasearch/builds/definition.mustache", "builds", "fetch.ts"));
      supportingFiles.add(new SupportingFile("algoliasearch/builds/models.mustache", "builds", "models.ts"));

      // `lite` builds
      supportingFiles.add(new SupportingFile("client/builds/browser.mustache", "lite/builds", "browser.ts"));
      supportingFiles.add(new SupportingFile("client/builds/node.mustache", "lite/builds", "node.ts"));
      supportingFiles.add(new SupportingFile("client/builds/liteNode.mustache", "lite/builds", "node.ts"));

      // `lite` models
      supportingFiles.add(new SupportingFile("client/model/clientMethodProps.mustache", "lite/model", "clientMethodProps.ts"));
      supportingFiles.add(new SupportingFile("client/model/modelBarrel.mustache", "lite/model", "index.ts"));

      // `lite root export files
      supportingFiles.add(new SupportingFile("algoliasearch/lite.mustache", "", "lite.js"));
      supportingFiles.add(new SupportingFile("algoliasearch/lite.d.mustache", "", "lite.d.ts"));
      supportingFiles.add(new SupportingFile("algoliasearch/lite.tsconfig.mustache", "", "lite/tsconfig.json"));
    }
  }

  @Override
  public String apiFileFolder() {
    String fileFolder = super.apiFileFolder();

    if (!isAlgoliasearchClient) {
      return fileFolder;
    }

    return fileFolder.replace("src", "lite/src");
  }

  @Override
  public String modelFileFolder() {
    String fileFolder = super.modelFileFolder();

    if (!isAlgoliasearchClient) {
      return fileFolder;
    }

    return fileFolder.replace("model", "lite/model");
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    return Helpers.specifyCustomRequest(super.fromOperation(path, httpMethod, operation, servers));
  }

  // Get the packageName from the output field in clients.config.json
  public static String getPackageName(String client) throws ConfigException {
    String output = StreamSupport.stream(
      Spliterators.spliteratorUnknownSize(Helpers.getClientConfig("javascript").get("clients").elements(), Spliterator.ORDERED),
      false
    )
      .filter(node -> node.get("name").asText().equals(client))
      .findFirst()
      .orElseThrow(() -> new ConfigException("Cannot find client " + client + " in config/clients.config.json"))
      .get("output")
      .asText();

    return output.substring(output.lastIndexOf("/") + 1);
  }

  /** Set default generator options */
  private void setDefaultGeneratorOptions() {
    String apiName = CLIENT + Helpers.API_SUFFIX;
    String packageName = getPackageName((String) additionalProperties.get("client"));

    additionalProperties.put("apiName", apiName);
    additionalProperties.put("algoliaAgent", Helpers.capitalize(CLIENT));
    additionalProperties.put("isSearchClient", CLIENT.equals("search") || isAlgoliasearchClient);
    additionalProperties.put("isIngestionClient", CLIENT.equals("ingestion"));
    additionalProperties.put("isAlgoliasearchClient", isAlgoliasearchClient);
    additionalProperties.put("packageVersion", Helpers.getPackageJsonVersion(packageName));
    additionalProperties.put("packageName", packageName);
    additionalProperties.put("npmPackageName", isAlgoliasearchClient ? packageName : "@algolia/" + packageName);
    additionalProperties.put("nodeSearchHelpers", CLIENT.equals("search") || isAlgoliasearchClient);

    if (isAlgoliasearchClient) {
      // Files used to create the package.json of the algoliasearch package
      additionalProperties.put("analyticsVersion", Helpers.getPackageJsonVersion("client-analytics"));
      additionalProperties.put("abtestingVersion", Helpers.getPackageJsonVersion("client-abtesting"));
      additionalProperties.put("personalizationVersion", Helpers.getPackageJsonVersion("client-personalization"));
      additionalProperties.put("searchVersion", Helpers.getPackageJsonVersion("client-search"));
      additionalProperties.put("recommendVersion", Helpers.getPackageJsonVersion("recommend"));

      // Files used to generate the `lite` client
      apiName = "lite" + Helpers.API_SUFFIX;
      additionalProperties.put("apiName", apiName);
      additionalProperties.put("algoliaAgent", "Lite");
    }
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> models = super.postProcessAllModels(objs);
    GenericPropagator.propagateGenericsToModels(models);
    return models;
  }

  /** Provides an opportunity to inspect and modify operation data before the code is generated. */
  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> allModels) {
    OperationsMap results = super.postProcessOperationsWithModels(objs, allModels);
    Helpers.removeHelpers(results);

    setDefaultGeneratorOptions();
    try {
      additionalProperties.put("utilsPackageVersion", Helpers.getPackageJsonVersion("client-common"));
    } catch (GeneratorException e) {
      e.printStackTrace();
      System.exit(1);
    }

    List<CodegenOperation> operations = results.getOperations().getOperation();

    // We read operations and detect if we should wrap parameters under an object.
    // We only wrap if there is a mix between body parameters and other parameters.
    for (CodegenOperation ope : operations) {
      // Nothing to wrap as there is no parameters
      if (!ope.hasParams) {
        continue;
      }

      boolean hasBodyParams = !ope.bodyParams.isEmpty();
      boolean hasHeaderParams = !ope.headerParams.isEmpty();
      boolean hasQueryParams = !ope.queryParams.isEmpty();
      boolean hasPathParams = !ope.pathParams.isEmpty();

      // If there is nothing but body params, we just check if it's a single param
      if (hasBodyParams && !hasHeaderParams && !hasQueryParams && !hasPathParams) {
        // At this point the single parameter is already an object, to avoid double wrapping
        // we skip it
        if (ope.bodyParams.size() == 1 && !ope.bodyParams.get(0).isArray) {
          ope.vendorExtensions.put("x-is-single-body-param", true);
          continue;
        }
      }

      // Any other cases here are wrapped
      ope.vendorExtensions.put("x-create-wrapping-object", true);
    }

    GenericPropagator.propagateGenericsToOperations(results, allModels);

    return results;
  }

  /**
   * The `apiSuffix` option is not supported on the TypeScript client, so we override the names
   * method to use it with our suffix.
   */

  /** The `apiName` is capitalized. */
  @Override
  public String toApiName(String name) {
    if (name.length() == 0) {
      return "Default" + Helpers.API_SUFFIX;
    }

    String endClient = isAlgoliasearchClient ? "lite" : CLIENT;

    return Helpers.capitalize(endClient + Helpers.API_SUFFIX);
  }

  /** The `apiFileName` is in camelCase. */
  @Override
  public String toApiFilename(String name) {
    if (name.length() == 0) {
      return "default" + Helpers.API_SUFFIX;
    }

    String endClient = isAlgoliasearchClient ? "lite" : CLIENT;

    return endClient + Helpers.API_SUFFIX;
  }

  /** The `apiFileName` is in camelCase. */
  @Override
  public String apiFilename(String templateName, String tag) {
    return super.apiFilename(templateName, toApiFilename(CLIENT));
  }
}
