package com.algolia.codegen.cts.lambda;

import com.algolia.codegen.utils.Helpers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

public class ScreamingSnakeCaseLambda implements Mustache.Lambda {

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    writer.write(Helpers.toSnakeCase(fragment.execute()).toUpperCase(Locale.ROOT));
  }
}
