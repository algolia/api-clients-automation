package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.Helpers;
import com.samskivert.mustache.Mustache.Lambda;
import java.io.IOException;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public interface CTSManager {
  public String getLanguage();

  public String getClient();

  public default String getLanguageCased() {
    return Helpers.capitalize(getLanguage());
  }

  public default String getPackageVersion() {
    return Helpers.getClientConfigField(getLanguage(), "packageVersion");
  }

  public default String getLanguageVersion(String override) throws IOException {
    if (override != null && !override.isEmpty()) {
      return override;
    }

    return Helpers.getLanguageVersion(getLanguage());
  }

  public default void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    // NO-OP
  }

  public default void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles, String output) {
    // NO-OP
  }

  public default void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    // NO-OP
  }

  public default void addMustacheLambdas(Map<String, Lambda> lambdas) {
    // NO-OP
  }
}
