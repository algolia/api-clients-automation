package com.algolia.codegen.cts.lambda;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;

public class EscapeSlashLambda implements Mustache.Lambda {

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    String text = fragment.execute();
    // replace all backslashes with double backslashes, unless they are followed by a $
    writer.write(text.replaceAll("\\\\(?!\\$)", "\\\\\\\\"));
  }
}
