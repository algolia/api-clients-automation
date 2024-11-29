package com.algolia.codegen.utils;

import com.algolia.codegen.exceptions.*;
import com.fasterxml.jackson.databind.*;
import java.util.*;

public class Timeouts {

  public static void enrichBundle(HashMap<String, Object> timeouts, Map<String, Object> bundle) throws ConfigException {
    enrichBundle(timeouts, bundle, 1);
  }

  /**
   * Inject timeouts (in miliseconds / divider) into the given bundle, under the x-timeouts property
   * *
   */
  public static void enrichBundle(HashMap<String, Object> timeouts, Map<String, Object> bundle, int divider) throws ConfigException {
    HashMap<String, Object> xtimeouts = new HashMap<>();

    HashMap<String, Object> browser = new HashMap<>();
    HashMap<String, Object> server = new HashMap<>();

    if (timeouts != null) {
      browser = (HashMap<String, Object>) timeouts.getOrDefault("browser", new HashMap<>());
      server = (HashMap<String, Object>) timeouts.getOrDefault("server", new HashMap<>());
    }

    // the default below are what the search API expect, which was previously used for any client
    HashMap<String, Object> defaultBrowser = new HashMap<>();
    defaultBrowser.put("connect", 1000);
    defaultBrowser.put("read", 2000);
    defaultBrowser.put("write", 30000);

    HashMap<String, Object> defaultServer = new HashMap<>();
    defaultServer.put("connect", 2000);
    defaultServer.put("read", 5000);
    defaultServer.put("write", 30000);

    if (browser == null) {
      xtimeouts.put("browser", defaultBrowser);
    } else {
      browser.put("connect", ((int) browser.getOrDefault("connect", defaultBrowser.get("connect"))) / divider);
      browser.put("read", ((int) browser.getOrDefault("read", defaultBrowser.get("read"))) / divider);
      browser.put("write", ((int) browser.getOrDefault("write", defaultBrowser.get("write"))) / divider);
      xtimeouts.put("browser", browser);
    }

    if (server == null) {
      xtimeouts.put("server", defaultServer);
    } else {
      server.put("connect", ((int) server.getOrDefault("connect", defaultServer.get("connect"))) / divider);
      server.put("read", ((int) server.getOrDefault("read", defaultServer.get("read"))) / divider);
      server.put("write", ((int) server.getOrDefault("write", defaultServer.get("write"))) / divider);
      xtimeouts.put("server", server);
    }

    bundle.put("x-timeouts", xtimeouts);
  }
}
