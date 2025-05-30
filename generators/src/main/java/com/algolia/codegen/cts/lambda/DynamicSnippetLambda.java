package com.algolia.codegen.cts.lambda;

import com.algolia.codegen.cts.tests.ParametersWithDataType;
import com.algolia.codegen.cts.tests.Snippet;
import com.algolia.codegen.exceptions.CTSException;
import com.algolia.codegen.utils.Helpers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import io.swagger.v3.core.util.Json;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.DefaultCodegen;
import org.openapitools.codegen.TemplateManager;
import org.openapitools.codegen.api.TemplatePathLocator;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.api.TemplatingExecutor;
import org.openapitools.codegen.templating.CommonTemplateContentLocator;
import org.openapitools.codegen.templating.GeneratorTemplateContentLocator;
import org.openapitools.codegen.templating.TemplateManagerOptions;

public class DynamicSnippetLambda implements Mustache.Lambda {

  private final TemplatingExecutor executor;
  private final TemplatingEngineAdapter adaptor;

  private final ParametersWithDataType paramsType;
  private final Map<String, CodegenOperation> operations;

  private final Map<String, Snippet> snippets;
  private final String language;

  public DynamicSnippetLambda(
    DefaultCodegen generator,
    Map<String, CodegenModel> models,
    Map<String, CodegenOperation> operations,
    String language,
    String client
  ) {
    this.operations = operations;
    this.language = language;
    this.paramsType = new ParametersWithDataType(models, language, client, true);

    JsonNode snippetsFile = Helpers.readJsonFile("tests/CTS/guides/" + client + ".json");
    this.snippets = Json.mapper().convertValue(snippetsFile, new TypeReference<Map<String, Snippet>>() {});

    // we can't access the default template manager, so we have to create our own
    TemplateManager templateManager = new TemplateManager(
      new TemplateManagerOptions(generator.isEnableMinimalUpdate(), generator.isSkipOverwrite()),
      generator.getTemplatingEngine(),
      new TemplatePathLocator[] { new GeneratorTemplateContentLocator(generator), new CommonTemplateContentLocator() }
    );

    this.executor = templateManager;
    this.adaptor = generator.getTemplatingEngine();
  }

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException, CTSException {
    String snippetName = fragment.execute();
    Snippet snippet = snippets.get(snippetName);
    if (snippet == null) {
      throw new CTSException("Cannot find snippet: " + snippetName);
    }

    String operationId = snippet.method;

    CodegenOperation operation = operations.get(operationId);
    if (operation == null) {
      throw new CTSException("Cannot find operation for method: " + operationId);
    }

    // set the method attributes
    Map<String, Object> context = (Map<String, Object>) fragment.context();
    snippet.addMethodCall(language, context, paramsType, operation);

    writer.write(adaptor.compileTemplate(executor, context, "tests/method.mustache"));
  }
}
