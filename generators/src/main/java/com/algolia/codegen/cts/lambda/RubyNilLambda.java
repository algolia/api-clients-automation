package com.algolia.codegen.cts.lambda;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;

/**
 * Ruby inlines the expected response payload (a JSON string) as a Ruby literal, which relies on
 * JSON being valid Ruby. The only mismatch is the JSON `null` token, which must become Ruby `nil`.
 * This lambda rewrites bare `null` tokens (outside of string values) to `nil`.
 */
public class RubyNilLambda implements Mustache.Lambda {

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    String text = fragment.execute();
    StringBuilder out = new StringBuilder(text.length());
    boolean inString = false;

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);

      if (c == '"' && (i == 0 || text.charAt(i - 1) != '\\')) {
        inString = !inString;
      }

      if (!inString && text.startsWith("null", i) && isTokenBoundary(text, i - 1) && isTokenBoundary(text, i + 4)) {
        out.append("nil");
        i += 3;
        continue;
      }

      out.append(c);
    }

    writer.write(out.toString());
  }

  // A JSON `null` token is surrounded by structural characters (or the string edges), never by
  // identifier characters.
  private static boolean isTokenBoundary(String text, int index) {
    if (index < 0 || index >= text.length()) {
      return true;
    }
    char c = text.charAt(index);
    return !Character.isLetterOrDigit(c) && c != '_';
  }
}
