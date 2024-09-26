package com.algolia.codegen.cts.lambda;

import com.algolia.codegen.cts.tests.ParametersWithDataType;
import com.algolia.codegen.exceptions.CTSException;
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

  private ParametersWithDataType paramsType;
  private Map<String, CodegenOperation> operations;

  public DynamicSnippetLambda(
    DefaultCodegen generator,
    Map<String, CodegenModel> models,
    Map<String, CodegenOperation> operations,
    String language,
    String client
  ) {
    this.operations = operations;
    this.paramsType = new ParametersWithDataType(models, language, client, true);

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
    String snippet = fragment.execute();
    String operationId = snippet.split(" ", 2)[0];
    
    CodegenOperation operation = operations.get(operationId);
    if (operation == null) {
      throw new CTSException("Cannot find operation for method: " + operationId);
    }

    // set the method attributes
    Map<String, Object> context = (Map<String, Object>) fragment.context();
    context.put("method", operationId);
    context.put("isAsyncMethod", (boolean) operation.vendorExtensions.getOrDefault("x-asynchronous-helper", true));
    context.put("isHelper", (boolean) operation.vendorExtensions.getOrDefault("x-helper", false));
    context.put("hasParams", operation.hasParams);

    // set the parameters
    Map<String, Object> parameters = Json.mapper().readValue(params, Map.class);
    System.out.println("parameters: " + parameters);
    context.put("parameters", params);

    writer.write(adaptor.compileTemplate(executor, context, "tests/client/method.mustache"));
  }
}
