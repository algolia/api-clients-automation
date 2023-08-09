package com.algolia.codegen.cs.manager;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.openapitools.codegen.SupportingFile;

public interface CSManager {
  default List<SupportingFile> getSupportingFiles() {
    return Collections.emptyList();
  }

  default Map<String, Object> getDataToBundle() {
    return Collections.emptyMap();
  }
}
