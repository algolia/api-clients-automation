package com.algolia.codegen.utils;

import com.algolia.codegen.exceptions.*;
import com.fasterxml.jackson.databind.*;
import java.util.*;

public class Timeouts {

  /** Inject timeouts info into the client bundle at x-timeouts */
  public static void enrichBundle(HashMap<String, Object> timeouts, Map<String, Object> bundle) throws ConfigException {
    HashMap<String, Object> xtimeouts = new HashMap<>();

    HashMap<String, Object> browser = new HashMap<>();
    HashMap<String, Object> server = new HashMap<>();

    if (timeouts != null) {
      browser = (HashMap<String, Object>) timeouts.getOrDefault("browser", new HashMap<>());
      server = (HashMap<String, Object>) timeouts.getOrDefault("server", new HashMap<>());
    }

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
      browser.put("connect", browser.getOrDefault("connect", defaultBrowser.get("connect")));
      browser.put("read", browser.getOrDefault("read", defaultBrowser.get("read")));
      browser.put("write", browser.getOrDefault("write", defaultBrowser.get("write")));
      xtimeouts.put("browser", browser);
    }

    if (server == null) {
      xtimeouts.put("server", defaultServer);
    } else {
      server.put("connect", server.getOrDefault("connect", defaultServer.get("connect")));
      server.put("read", server.getOrDefault("read", defaultServer.get("read")));
      server.put("write", server.getOrDefault("write", defaultServer.get("write")));
      xtimeouts.put("server", server);
    }

    bundle.put("x-timeouts", xtimeouts);
  }
}
