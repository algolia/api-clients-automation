package com.algolia.codegen.utils;

import com.algolia.codegen.exceptions.*;
import com.fasterxml.jackson.databind.*;
import io.swagger.v3.oas.models.OpenAPI;
import java.util.*;
import org.openapitools.codegen.model.OperationsMap;

class TimeoutsValues {

  public long connect;
  public long read;
  public long write;
}

class TimeoutsBundle {

  public TimeoutsValues browser = new TimeoutsValues();
  public TimeoutsValues server = new TimeoutsValues();
}

public class Timeouts {

  private static TimeoutsBundle defaults;

  /** Inject timeouts in miliseconds into the given bundle, under the x-timeouts property * */
  public static void enrichBundle(OpenAPI spec, Map<String, Object> bundle) throws ConfigException {
    defaults = new TimeoutsBundle();
    // the default below are what the search API expect, which was previously used for any client
    defaults.browser.connect = 1000;
    defaults.browser.read = 2000;
    defaults.browser.write = 30000;

    defaults.server.connect = 2000;
    defaults.server.read = 5000;
    defaults.server.write = 30000;

    TimeoutsBundle specTimeouts = new ObjectMapper().convertValue(spec.getExtensions().get("x-timeouts"), TimeoutsBundle.class);
    if (specTimeouts != null) {
      if (specTimeouts.browser != null) {
        defaults.browser = specTimeouts.browser;
      }
      if (specTimeouts.server == null) {
        defaults.server = specTimeouts.server;
      }
    }

    bundle.put("x-timeouts", defaults);
  }

  public static void propagate(OperationsMap operations) throws ConfigException {
    operations
      .getOperations()
      .getOperation()
      .forEach(entry -> {
        if (!entry.vendorExtensions.containsKey("x-timeouts")) {
          Map<String, Object> vendor = new HashMap<>();

          Map<String, Object> browser = new HashMap<>();
          browser.put("connect", defaults.browser.connect);
          browser.put("read", defaults.browser.read);
          browser.put("write", defaults.browser.write);
          vendor.put("browser", browser);

          Map<String, Object> server = new HashMap<>();
          server.put("connect", defaults.server.connect);
          server.put("read", defaults.server.read);
          server.put("write", defaults.server.write);
          vendor.put("server", server);

          entry.vendorExtensions.put("x-timeouts", vendor);
        }
      });
  }
}
