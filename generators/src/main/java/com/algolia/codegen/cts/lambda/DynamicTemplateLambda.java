package com.algolia.codegen.cts.lambda;

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

  private TemplatingExecutor executor;
  private TemplatingEngineAdapter adaptor;

  public DynamicTemplateLambda(DefaultCodegen generator) {
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
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    Map<String, Object> context = (Map<String, Object>) fragment.context();
    for (int contextIndex = 1;; contextIndex++) {
      try {
        Map<String, Object> parent = (Map<String, Object>) fragment.context(contextIndex);
        parent.forEach((key, value) -> context.putIfAbsent(key, value));
      } catch (Exception exception) {
        break;
      }
    }

    writer.write(adaptor.compileTemplate(executor, context, context.get("stepTemplate").toString()));
  }
}
