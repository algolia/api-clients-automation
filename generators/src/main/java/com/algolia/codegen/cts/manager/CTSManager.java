package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import com.algolia.codegen.utils.Helpers;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public interface CTSManager {
  public String getLanguage();

  public String getClient();

  public default String getLanguageCased() {
    return Helpers.capitalize(getLanguage());
  }

  public default String getVersion() {
    return Helpers.getClientConfigField(getLanguage(), "packageVersion");
  }

  public default void addTestsSupportingFiles(List<SupportingFile> supportingFiles) {
    // NO-OP
  }

  public default void addSnippetsSupportingFiles(List<SupportingFile> supportingFiles) {
    // NO-OP
  }

  public default void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    // NO-OP
  }
}
