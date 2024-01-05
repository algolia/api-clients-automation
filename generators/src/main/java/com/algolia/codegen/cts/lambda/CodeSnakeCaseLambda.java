package com.algolia.codegen.cts.lambda;

import com.algolia.codegen.utils.Helpers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeSnakeCaseLambda implements Mustache.Lambda {

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    String text = fragment.execute();
    Pattern pattern = Pattern.compile("`.*?`");
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      text = matcher.replaceAll(m -> Helpers.toSnakeCase(matcher.group(0)));
    }

    writer.write(text);
  }
}
