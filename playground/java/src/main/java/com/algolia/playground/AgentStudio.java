package com.algolia.playground;

import com.algolia.api.AgentStudioClient;
import io.github.cdimascio.dotenv.Dotenv;

public class AgentStudio {

  public static void main(String[] args) throws Exception {
    var dotenv = Dotenv.configure().directory("../").load();
    var appId = dotenv.get("ALGOLIA_APPLICATION_ID");
    var apiKey = dotenv.get("ALGOLIA_ADMIN_KEY");

    var client = new AgentStudioClient(appId, apiKey);

    try {
      var response = client.listAgents();
      System.out.println("List of agents:");
      for (var agent : response.getData()) {
        System.out.println("- " + agent.getName() + " (ID: " + agent.getId() + ")");
      }
    } finally {
      client.close();
    }
  }
}
