package com.algolia.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringUtils {

  private StringUtils() {
    // Empty.
  }

  /**
   * Escape the given string to be used as URL query value.
   *
   * @param str String to be escaped
   * @return Escaped string
   */
  public static String escape(String str) {
    try {
      return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
    } catch (UnsupportedEncodingException e) {
      return str;
    }
  }

  public static String pathFormat(String template, Object... values) {
    int i = 0;
    while (template.contains("{") && i < values.length) {
      String value = escape(String.valueOf(values[i]));
      template = template.replaceFirst("\\{[^}]+}", value);
      i++;
    }
    if (template.contains("{")) {
      throw new IllegalArgumentException("Not enough replacement values for all placeholders.");
    }
    if (i < values.length) {
      throw new IllegalArgumentException("More replacement values provided than placeholders.");
    }
    return template;
  }
}
