package com.algolia.codegen.cts.lambda;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;

public class CSharpIdentifierLambda implements Mustache.Lambda {

  private final String client;

  public CSharpIdentifierLambda(String client) {
    this.client = client;
  }

  @Override
  public void execute(Template.Fragment frag, Writer out) throws IOException {
    String text = frag.execute();
    if (client.equals("search") && text.equals("source")) {
      out.write("varSource");

      return;
    }

    out.write(text);
  }
}
