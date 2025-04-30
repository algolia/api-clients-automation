package com.algolia.codegen.cts.lambda;

import com.algolia.codegen.AlgoliaSwiftGenerator;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;

public class SwiftPrefixLambda implements Mustache.Lambda {

  private final String client;

  public SwiftPrefixLambda(String client) {
    this.client = client;
  }

  @Override
  public void execute(Template.Fragment frag, Writer out) throws IOException {
    out.write(AlgoliaSwiftGenerator.prefixReservedModelName(frag.execute(), client));
  }
}
