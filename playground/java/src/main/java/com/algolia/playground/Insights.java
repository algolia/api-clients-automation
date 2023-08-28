package com.algolia.playground;

import com.algolia.api.InsightsClient;
import com.algolia.config.ClientOptions;
import com.algolia.config.LogLevel;
import com.algolia.exceptions.*;
import com.algolia.model.insights.*;
import io.github.cdimascio.dotenv.Dotenv;

public class Insights {

  public static void main(String[] args) throws Exception {
    var dotenv = Dotenv.configure().directory("../").load();
    var appId = dotenv.get("ALGOLIA_APPLICATION_ID");
    var apiKey = dotenv.get("ALGOLIA_SEARCH_KEY");
    var indexName = dotenv.get("SEARCH_INDEX");

    var options = new ClientOptions.Builder()
            .addAlgoliaAgentSegment("Playground")
            .setLogLevel(LogLevel.BASIC)
            .build();

    try(var client = new InsightsClient(appId, apiKey, options)) {
      var params = new InsightsEvents();
      var event = EventsItems.of(new ClickedObjectIDs()
              .setEventType(ClickEvent.CLICK)
              .setUserToken("user")
              .setIndex(indexName)
              .setEventName("test"));
      params.addEvents(event);
      var result = client.pushEvents(params);
      System.out.println(result);
    }
  }
}
