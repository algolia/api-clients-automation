package com.algolia.codegen.cts.lambda;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import org.openapitools.codegen.DefaultCodegen;
import org.openapitools.codegen.TemplateManager;
import org.openapitools.codegen.api.TemplatePathLocator;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.api.TemplatingExecutor;
import org.openapitools.codegen.templating.CommonTemplateContentLocator;
import org.openapitools.codegen.templating.GeneratorTemplateContentLocator;
import org.openapitools.codegen.templating.TemplateManagerOptions;

public class DynamicTemplateLambda implements Mustache.Lambda {

  private final TemplatingExecutor executor;
  private final TemplatingEngineAdapter adaptor;
  private final String templateProperty;
  private final ObjectMapper mapper;

  public DynamicTemplateLambda(DefaultCodegen generator, String templateProperty) {
    // we can't access the default template manager, so we have to create our own
    TemplateManager templateManager = new TemplateManager(
      new TemplateManagerOptions(generator.isEnableMinimalUpdate(), generator.isSkipOverwrite()),
      generator.getTemplatingEngine(),
      new TemplatePathLocator[] { new GeneratorTemplateContentLocator(generator), new CommonTemplateContentLocator() }
    );

    this.executor = templateManager;
    this.adaptor = generator.getTemplatingEngine();
    this.templateProperty = templateProperty;
    this.mapper = new ObjectMapper();
  }

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    Map<String, Object> context = this.mapper.convertValue(fragment.context(), new TypeReference<Map<String, Object>>() {});

    for (int contextIndex = 1;; contextIndex++) {
      try {
        Map<String, Object> parent = this.mapper.convertValue(fragment.context(contextIndex), new TypeReference<Map<String, Object>>() {});
        parent.forEach((key, value) -> context.putIfAbsent(key, value));
      } catch (Exception exception) {
        break;
      }
    }

    writer.write(adaptor.compileTemplate(executor, context, context.get(this.templateProperty).toString() + ".mustache"));
  }
}
