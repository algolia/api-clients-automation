package com.algolia.codegen.utils;

import com.algolia.codegen.exceptions.*;
import com.fasterxml.jackson.databind.*;
import io.swagger.v3.oas.models.OpenAPI;
import java.util.*;

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

  /** Inject timeouts in miliseconds into the given bundle, under the x-timeouts property * */
  public static void enrichBundle(OpenAPI spec, Map<String, Object> bundle) throws ConfigException {
    TimeoutsBundle defaults = new TimeoutsBundle();
    // the default below are what the search API expect, which was previously used for any client
    defaults.browser.connect = 1000;
    defaults.browser.read = 2000;
    defaults.browser.write = 30000;

    defaults.server.connect = 2000;
    defaults.server.read = 5000;
    defaults.server.write = 30000;

    TimeoutsBundle specTimeouts = new ObjectMapper().convertValue(spec.getExtensions().get("x-timeouts"), TimeoutsBundle.class);
    if (specTimeouts == null) {
      specTimeouts = new TimeoutsBundle();
      specTimeouts.browser = defaults.browser;
      specTimeouts.server = defaults.server;
    }
    if (specTimeouts.browser == null) {
      specTimeouts.browser = defaults.browser;
    }
    if (specTimeouts.server == null) {
      specTimeouts.server = defaults.server;
    }

    bundle.put("x-timeouts", specTimeouts);
  }
}
