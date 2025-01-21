package com.algolia.codegen.cts.lambda;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeIdentifierLambda implements Mustache.Lambda {

  private final UnaryOperator<String> convert;

  public CodeIdentifierLambda(UnaryOperator<String> convert) {
    this.convert = convert;
  }

  @Override
  public void execute(Template.Fragment fragment, Writer writer) throws IOException {
    String text = fragment.execute();
    Pattern pattern = Pattern.compile("`(.*?)`");
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      text = matcher.replaceAll(m -> "`" + convert.apply(matcher.group(1)) + "`");
    }

    writer.write(text);
  }
}
