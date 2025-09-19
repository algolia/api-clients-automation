package com.algolia.codegen.cts.lambda;

import com.algolia.codegen.utils.Helpers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Map;

public class RubyIdentifierLambda implements Mustache.Lambda {

  private static final String[] RUBY_KEYWORDS = new String[] { "until" };

  public static String formatIdentifier(String text) {
    return formatIdentifier(text, false);
  }

  public static String formatIdentifier(String text, boolean isParentFreeFormObject) {
    if (Arrays.stream(RUBY_KEYWORDS).anyMatch(text::equals)) {
      text = "_" + text;
    }
    if (!isParentFreeFormObject) {
      if (text.equals("objectID")) {
        text = "algolia_object_id";
      }
      text = Helpers.toSnakeCase(text);
    }

    if (text.contains("-")) {
      text = "'" + text + "'";
    }

    return text;
  }

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    Map<String, Object> context = (Map<String, Object>) fragment.context();
    writer.write(formatIdentifier(fragment.execute(), (boolean) context.get("isParentFreeFormObject")));
  }
}
