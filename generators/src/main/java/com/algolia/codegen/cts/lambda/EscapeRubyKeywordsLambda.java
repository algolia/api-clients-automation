package com.algolia.codegen.cts.lambda;

import com.algolia.codegen.utils.Helpers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Map;

public class EscapeRubyKeywordsLambda implements Mustache.Lambda {

  private static final String[] RUBY_KEYWORDS = new String[] { "until" };

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    String text = fragment.execute();
    if (Arrays.stream(RUBY_KEYWORDS).anyMatch(text::equals)) {
      text = "_" + text;
    }
    Map<String, Object> context = (Map<String, Object>) fragment.context();
    if (!((boolean) context.get("isParentFreeFormObject"))) {
      text = Helpers.toSnakeCase(text);
    }

    writer.write(text);
  }
}
