package com.algolia.codegen.lambda;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;

public class ToSecondsLambda implements Mustache.Lambda {

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    writer.write(Integer.toString(Integer.parseInt(fragment.execute()) / 1000));
  }
}
