package com.algolia.codegen.cts.lambda;

import com.algolia.codegen.AlgoliaCSharpGenerator;
import com.algolia.codegen.utils.Helpers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class CSharpIdentifierLambda implements Mustache.Lambda {

  private static final String[] RUBY_KEYWORDS = new String[] { "source" };

  @Override
  public void execute(Template.Fragment frag, Writer out) throws IOException {
    String text = frag.execute();
    if (Arrays.stream(RUBY_KEYWORDS).anyMatch(text::equals)) {
      out.write("var" + Helpers.capitalize(text));
      return;
    }

    var formatted = AlgoliaCSharpGenerator.formatIdentifier(text);
    out.write(formatted);
  }
}
