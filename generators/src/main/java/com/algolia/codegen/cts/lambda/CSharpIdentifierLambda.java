package com.algolia.codegen.cts.lambda;

import com.algolia.codegen.AlgoliaCSharpGenerator;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;

public class CSharpIdentifierLambda implements Mustache.Lambda {

  @Override
  public void execute(Template.Fragment frag, Writer out) throws IOException {
    String text = frag.execute();
    var formatted = AlgoliaCSharpGenerator.formatIdentifier(text);
    out.write(formatted);
  }
}
