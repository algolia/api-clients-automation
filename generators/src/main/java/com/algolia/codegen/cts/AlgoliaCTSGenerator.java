package com.algolia.codegen.cts;

import com.algolia.codegen.cts.guides.GuidesGenerator;
import com.algolia.codegen.cts.lambda.*;
import com.algolia.codegen.cts.manager.CTSManager;
import com.algolia.codegen.cts.manager.CTSManagerFactory;
import com.algolia.codegen.cts.tests.*;
import com.algolia.codegen.exceptions.*;
import com.algolia.codegen.utils.*;
import com.google.common.collect.ImmutableMap.Builder;
import com.samskivert.mustache.Mustache.Lambda;
import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.openapitools.codegen.*;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

@SuppressWarnings("unchecked")
public class AlgoliaCTSGenerator extends DefaultCodegen {

  // cache the models
  private final Map<String, CodegenModel> models = new HashMap<>();
  private String language, client, mode;
  private CTSManager ctsManager;
  private List<TestsGenerator> testsGenerators = new ArrayList<>();

  @Override
  public CodegenType getTag() {
    return CodegenType.OTHER;
  }

  @Override
  public String getName() {
    return "algolia-cts";
  }

  @Override
  public void processOpts() {
    super.processOpts();

    language = (String) additionalProperties.get("language");
    client = (String) additionalProperties.get("client");
    mode = (String) additionalProperties.get("mode");
    ctsManager = CTSManagerFactory.getManager(language, client, (String) additionalProperties.getOrDefault("languageVersion", ""));

    if (ctsManager == null) {
      // skip the generation
      System.out.println("No CTS manager found for language " + language + ", skipping");
      System.exit(0);
    }

    String outputFolder = Helpers.getClientConfigField(language, "tests", "outputFolder");
    String extension = Helpers.getClientConfigField(language, "tests", "extension");

    setTemplateDir("templates/" + language);

    if (mode.equals("tests")) {
      ctsManager.addTestsSupportingFiles(supportingFiles);

      testsGenerators.add(new TestsRequest(ctsManager));

      testsGenerators.add(new TestsClient(ctsManager, true));
      testsGenerators.add(new TestsClient(ctsManager, false));
    } else if (mode.equals("snippets")) {
      ctsManager.addSnippetsSupportingFiles(supportingFiles, "docs/" + mode);

      testsGenerators.add(new SnippetsGenerator(ctsManager));
    } else if (mode.equals("guides")) {
      ctsManager.addSnippetsSupportingFiles(supportingFiles, "docs/" + mode);

      testsGenerators.add(new GuidesGenerator(ctsManager));
    } else {
      throw new CTSException("Unknown mode: " + mode);
    }

    for (TestsGenerator testGen : testsGenerators) {
      testGen.addSupportingFiles(supportingFiles, outputFolder, extension);
    }
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    Map<String, ModelsMap> mod = super.postProcessAllModels(objs);
    for (Entry<String, ModelsMap> entry : mod.entrySet()) {
      List<ModelMap> innerModel = entry.getValue().getModels();
      if (!innerModel.isEmpty()) {
        models.put(entry.getKey(), innerModel.get(0).getModel());
      }
    }
    GenericPropagator.propagateGenericsToModels(mod);
    return mod;
  }

  @Override
  protected Builder<String, Lambda> addMustacheLambdas() {
    Builder<String, Lambda> lambdas = super.addMustacheLambdas();

    lambdas.put("escapeDollar", new EscapeDollarLambda());
    lambdas.put("escapeQuotes", new EscapeQuotesLambda());
    lambdas.put("escapeSlash", new EscapeSlashLambda());
    lambdas.put("escapeJSON", new EscapeJSONLambda());
    lambdas.put("replaceBacktick", new ReplaceBacktickLambda());

    return lambdas;
  }

  @Override
  public Map<String, Object> postProcessSupportingFileData(Map<String, Object> objs) {
    try {
      Map<String, CodegenOperation> operations = buildOperations(objs);

      Map<String, Lambda> lambda = new HashMap<>((Map<String, Lambda>) objs.get("lambda"));
      List<CodegenServer> servers = (List<CodegenServer>) objs.get("servers");
      CodegenServerVariable regionVariable = null;
      outerLoop: for (CodegenServer server : servers) {
        for (CodegenServerVariable variable : server.variables) {
          if (variable.name.equals("region")) {
            regionVariable = variable;
            break outerLoop;
          }
        }
      }

      boolean hasRegionalHost = regionVariable != null;

      Map<String, Object> bundle = objs;
      bundle.clear();

      for (CodegenServer server : servers) {
        if (server.variables.isEmpty()) {
          bundle.put("fallbackToAliasHost", server.url);
          break;
        }
      }

      // This only exists for the `javascript-algoliasearch` combo, because the `lite` client is
      // nested inside `algoliasearch`.
      String importClientName = client;
      if ((language.equals("javascript") || language.equals("dart")) && client.equals("algoliasearch")) {
        importClientName = "lite";
      }

      // We can put whatever we want in the bundle, and it will be accessible in the template
      bundle.put("mode", mode);
      bundle.put("is" + Helpers.capitalize(Helpers.camelize(client)) + "Client", true);
      bundle.put("isSearchClient", client.contains("search")); // just so algoliasearch is treated as a search client too
      bundle.put("client", Helpers.createClientName(importClientName, language) + "Client");
      bundle.put("clientPrefix", Helpers.createClientName(importClientName, language));
      bundle.put("hasRegionalHost", hasRegionalHost);
      if (hasRegionalHost) {
        bundle.put("defaultRegion", regionVariable.defaultValue);
      }
      bundle.put("isSyncClient", false);
      // special lambda for dynamic templates
      bundle.put("dynamicTemplate", new DynamicTemplateLambda(this));
      if (new File("tests/CTS/guides/" + client + ".json").exists()) {
        bundle.put("dynamicSnippet", new DynamicSnippetLambda(this, models, operations, language, client));
      }
      // restore the lambda from the original bundle
      ctsManager.addMustacheLambdas(lambda);
      bundle.put("lambda", lambda);

      // Set some default values in the bundle
      bundle.put("packageVersion", ctsManager.getPackageVersion());

      String languageVersion = ctsManager.getLanguageVersion((String) additionalProperties.getOrDefault("languageVersion", ""));
      bundle.put("languageVersion", languageVersion);

      ctsManager.addDataToBundle(bundle);

      for (TestsGenerator testGen : testsGenerators) {
        try {
          testGen.run(models, operations, bundle);
        } catch (CTSException e) {
          if (e.isSkipable()) {
            System.out.println(e.getMessage());
            continue;
          }
          System.err.println("\n\n");
          System.err.println(e.getMessage());
          e.printStackTrace();
          System.exit(1);
        } catch (Exception e) {
          e.printStackTrace();
          System.exit(1);
        }
      }

      // Generation notice, added on every generated files
      bundle.put("generationBanner", Helpers.setGenerationBanner(additionalProperties));

      return bundle;
    } catch (CTSException e) {
      if (e.isSkipable()) {
        System.out.println(e.getMessage());
        System.exit(0);
      }
      e.printStackTrace();
      System.exit(1);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    return null;
  }

  // operationId -> CodegenOperation
  private TreeMap<String, CodegenOperation> buildOperations(Map<String, Object> objs) {
    HashMap<String, CodegenOperation> result = new HashMap<>();
    List<Map<String, Object>> apis = ((Map<String, List<Map<String, Object>>>) objs.get("apiInfo")).get("apis");

    for (Map<String, Object> api : apis) {
      String apiName = ((String) api.get("baseName")).toLowerCase();
      if (!apiName.equals(client.replace("-", ""))) {
        continue;
      }

      List<CodegenOperation> operations = ((Map<String, List<CodegenOperation>>) api.get("operations")).get("operation");

      for (CodegenOperation ope : operations) {
        result.put(ope.operationId, ope);
      }
    }

    return new TreeMap<String, CodegenOperation>(result);
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    OperationsMap operations = super.postProcessOperationsWithModels(objs, models);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }

  @Override
  public String escapeUnsafeCharacters(String input) {
    return input;
  }

  public String escapeQuotationMark(String input) {
    return input.replace("\"", "\\\"");
  }
}
