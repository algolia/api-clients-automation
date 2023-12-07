package com.algolia.codegen.cts.manager;

import com.algolia.codegen.exceptions.GeneratorException;
import java.util.*;
import org.openapitools.codegen.SupportingFile;

public interface CTSManager {
  public default void addSupportingFiles(List<SupportingFile> supportingFiles) {
    // NO-OP
  }

  public default void addDataToBundle(Map<String, Object> bundle) throws GeneratorException {
    // NO-OP
  }
}
