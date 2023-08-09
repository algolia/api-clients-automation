package com.algolia.codegen.cs;

import com.algolia.codegen.GenericPropagator;
import com.algolia.codegen.Utils;
import com.algolia.codegen.cs.manager.CSManager;
import com.algolia.codegen.cs.manager.CSManagerFactory;
import com.algolia.codegen.cs.snippets.SnippetsGenerator;
import com.algolia.codegen.cts.*;
import com.algolia.codegen.exceptions.CTSException;
import com.google.common.collect.ImmutableMap;
import com.samskivert.mustache.Mustache;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openapitools.codegen.*;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.model.OperationsMap;

public class AlgoliaCSGenerator extends DefaultCodegen {

  private static final Logger logger = Logger.getLogger(AlgoliaCSGenerator.class.getName());
  private final Map<String, CodegenModel> models = new HashMap<>();
  private SnippetsGenerator generator;
  private String language;
  private String client;
  private CSManager csManager;

  @Override
  public String getName() {
    return "algolia-cs";
  }

  @Override
  public CodegenType getTag() {
    return CodegenType.OTHER;
  }

  @Override
  public void processOpts() {
    super.processOpts();
    language = (String) additionalProperties.get("language");
    setTemplateDir("templates/" + language + "/snippets");
    setOutputDir("snippets/" + language);

    csManager = createCSManager();
    supportingFiles.addAll(csManager.getSupportingFiles());

    client = (String) additionalProperties.get("client");
    generator = new SnippetsGenerator(language, client);
    supportingFiles.addAll(generator.getSupportingFiles());
  }

  private CSManager createCSManager() {
    var manager = CSManagerFactory.create(language, client);
    if (csManager == null) {
      logger.log(Level.INFO, "No CS manager found for language {0}, skipping", language);
      System.exit(0);
    }
    return manager;
  }

  @Override
  public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
    var mod = super.postProcessAllModels(objs);
    for (Map.Entry<String, ModelsMap> entry : mod.entrySet()) {
      var innerModel = entry.getValue().getModels();
      if (!innerModel.isEmpty()) {
        models.put(entry.getKey(), innerModel.get(0).getModel());
      }
    }
    GenericPropagator.propagateGenericsToModels(mod);
    return mod;
  }

  @Override
  protected ImmutableMap.Builder<String, Mustache.Lambda> addMustacheLambdas() {
    return super
      .addMustacheLambdas()
      .put("escapeQuotes", new EscapeQuotesLambda())
      .put("escapeSlash", new EscapeSlashLambda())
      .put("replaceBacktick", new ReplaceBacktickLambda())
      .put("escapeReserved", new EscapeDartLambda())
      .put("escapeDollarSign", new EscapeDollarSignLambda())
      .put("lowerCamelCase", new LowerCamelCaseLambda());
  }

  @Override
  public Map<String, Object> postProcessSupportingFileData(Map<String, Object> objs) {
    var bundle = super.postProcessSupportingFileData(objs);
    bundle.putAll(csManager.getDataToBundle());

    var importClientName = (language.equals("javascript") || language.equals("dart")) && client.equals("algoliasearch") ? "lite" : client;
    bundle.put("client", Utils.createClientName(importClientName, language) + "Client");
    bundle.put("clientPrefix", Utils.createClientName(importClientName, language));
    bundle.put("lambda", objs.get("lambda"));
    var servers = (List<CodegenServer>) objs.get("servers");
    Optional<CodegenServerVariable> regionVariable = servers
      .stream()
      .flatMap(server -> server.variables.stream())
      .filter(variable -> "region".equals(variable.name))
      .findFirst();
    bundle.put("hasRegionalHost", regionVariable.isPresent());
    regionVariable.ifPresent(region -> bundle.put("defaultRegion", region));

    var operations = buildOperations(objs);
    generate(operations, bundle);
    return bundle;
  }

  private void generate(Map<String, CodegenOperation> operations, Map<String, Object> bundle) {
    try {
      generator.run(models, operations, bundle);
    } catch (CTSException e) {
      if (e.isSkipable()) {
        logger.warning(e.getMessage());
      } else {
        logger.severe(e.getMessage());
        System.exit(1);
      }
    } catch (Exception e) {
      logger.severe(e.getMessage());
      System.exit(1);
    }
  }

  private LinkedHashMap<String, CodegenOperation> buildOperations(Map<String, Object> objs) {
    var result = new LinkedHashMap<String, CodegenOperation>();
    for (Map<String, Object> api : getApis(objs)) {
      var apiName = ((String) api.get("baseName")).toLowerCase();
      if (!apiName.equals(client.replace("-", ""))) continue;
      var operations = getOperations(api);
      for (CodegenOperation operation : operations) {
        result.put(operation.operationId, operation);
      }
    }
    return result;
  }

  private List<Map<String, Object>> getApis(Map<String, Object> objs) {
    var apiInfo = (Map<String, List<Map<String, Object>>>) objs.get("apiInfo");
    return apiInfo.get("apis");
  }

  private List<CodegenOperation> getOperations(Map<String, Object> api) {
    var operationsMap = (Map<String, List<CodegenOperation>>) api.get("operations");
    return operationsMap.get("operation");
  }

  @Override
  public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
    var operations = super.postProcessOperationsWithModels(objs, models);
    GenericPropagator.propagateGenericsToOperations(operations, models);
    return operations;
  }
}
