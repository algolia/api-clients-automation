package com.algolia.codegen;

import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.util.*;
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

    CLIENT = Helpers.camelize(Helpers.getClientConfigClientName((String) additionalProperties.get("client")));
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
    languageSpecificPrimitives.add("Record<string, unknown>");
    instantiationTypes.put("map", "Record");
    instantiationTypes.put("object", "Record<string, unknown>");
    typeMapping.put("object", "Record<string, unknown>");
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

    Helpers.addCommonSupportingFiles(supportingFiles, "../../");

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
      supportingFiles.add(new SupportingFile("client/builds/worker.mustache", "builds", "worker.ts"));
    }
    // `algoliasearch` related files
    else {
      supportingFiles.add(new SupportingFile("README.mustache", "", "../../README.md"));

      // `algoliasearch` builds
      supportingFiles.add(new SupportingFile("algoliasearch/builds/definition.mustache", "builds", "browser.ts"));
      supportingFiles.add(new SupportingFile("algoliasearch/builds/definition.mustache", "builds", "node.ts"));
      supportingFiles.add(new SupportingFile("algoliasearch/builds/definition.mustache", "builds", "fetch.ts"));
      supportingFiles.add(new SupportingFile("algoliasearch/builds/definition.mustache", "builds", "worker.ts"));
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
    String clientName = CLIENT + Helpers.API_SUFFIX;
    String packageName = getPackageName((String) additionalProperties.get("client"));

    additionalProperties.put("apiName", CLIENT);
    additionalProperties.put("clientName", clientName);
    additionalProperties.put("algoliaAgent", Helpers.capitalize(CLIENT));
    additionalProperties.put("is" + Helpers.capitalize(Helpers.camelize((String) additionalProperties.get("client"))) + "Client", true);
    additionalProperties.put("isSearchClient", CLIENT.equals("search") || isAlgoliasearchClient);
    additionalProperties.put("isAlgoliasearchClient", isAlgoliasearchClient);
    additionalProperties.put("packageVersion", Helpers.getPackageJsonVersion(packageName));
    additionalProperties.put("packageName", packageName);
    additionalProperties.put("npmPackageName", isAlgoliasearchClient ? packageName : "@algolia/" + packageName);
    additionalProperties.put("searchHelpers", CLIENT.equals("search"));

    if (isAlgoliasearchClient) {
      var dependencies = new ArrayList<Map<String, Object>>();
      List<Map<String, Object>> packages = Helpers.getClientConfigList("javascript", "clients");
      for (Map<String, Object> pkg : packages) {
        String name = ((String) pkg.get("output")).replace("clients/algoliasearch-client-javascript/packages/", "");
        if (name.contains("algoliasearch")) {
          continue;
        }

        String version = Helpers.getPackageJsonVersion(name);

        if (version.contains("alpha") || version.contains("beta") || (boolean) pkg.getOrDefault("isStandaloneClient", false) == true) {
          continue;
        }

        var dependency = new HashMap<String, Object>();
        dependency.put("dependencyName", Helpers.createClientName((String) pkg.get("name"), "javascript"));
        dependency.put("dependencyPackage", "@algolia/" + name);
        dependency.put("dependencyVersion", version);
        dependency.put("withInitMethod", !name.contains("search"));
        dependency.put(
          "dependencyHasRegionalHosts",
          !name.contains("search") && !name.contains("recommend") && !name.contains("monitoring") && !name.startsWith("composition")
        );

        dependencies.add(dependency);
      }
      additionalProperties.put("dependencies", dependencies);

      // Files used to generate the `lite` client
      additionalProperties.put("apiName", "search");
      additionalProperties.put("clientName", "lite" + Helpers.API_SUFFIX);
      additionalProperties.put("algoliaAgent", "Lite");
    }
  }

  @Override
  public void processOpenAPI(OpenAPI openAPI) {
    super.processOpenAPI(openAPI);
    Helpers.generateServers(super.fromServers(openAPI.getServers()), additionalProperties);
    Timeouts.enrichBundle(openAPI, additionalProperties);
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
      if (!ope.getHasParams()) {
        continue;
      }

      boolean hasBodyParams = ope.bodyParam != null;
      boolean hasHeaderParams = !ope.headerParams.isEmpty();
      boolean hasQueryParams = !ope.queryParams.isEmpty();
      boolean hasPathParams = !ope.pathParams.isEmpty();

      // If there is nothing but body params, we just check if it's a single param
      if (hasBodyParams && !hasHeaderParams && !hasQueryParams && !hasPathParams && !ope.bodyParam.isArray) {
        // At this point the single parameter is already an object, to avoid double wrapping we skip
        // it
        ope.vendorExtensions.put("x-is-single-body-param", true);
        continue;
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
