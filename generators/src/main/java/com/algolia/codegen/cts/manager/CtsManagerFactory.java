package com.algolia.codegen.cts.manager;

import com.algolia.codegen.Utils;
import com.algolia.codegen.cts.manager.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public class CtsManagerFactory {

  public static CtsManager getManager(String language) {
    if (language == null) {
      return null;
    }
    switch (language) {
      case "javascript":
        return new JavaScriptCtsManager();
      case "java":
        return new JavaCtsManager();
      case "php":
        return new PhpCtsManager();
    }
    return null;
  }
}
