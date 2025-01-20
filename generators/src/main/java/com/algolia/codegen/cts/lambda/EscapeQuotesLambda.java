package com.algolia.codegen.cts.lambda;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;

public class EscapeQuotesLambda implements Mustache.Lambda {

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    String text = fragment.execute();
    // replaces all occurrences of " that are not preceded by a backslash with \"
    writer.write(text.replaceAll("(?<!\\\\)\"", "\\\\\""));
  }
}
