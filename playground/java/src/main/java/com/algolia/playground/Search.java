package com.algolia.playground;

import com.algolia.api.SearchClient;
import com.algolia.config.ClientOptions;
import com.algolia.config.CompressionType;
import com.algolia.config.LogLevel;
import com.algolia.exceptions.*;
import com.algolia.model.search.*;
import com.algolia.utils.*;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class Actor extends Hit {

  public String name;

  public Actor() {}

  public Actor(String name) {
    this.name = name;
  }
}

public class Search {

  public static void main(String[] args) throws Exception {
    var dotenv = Dotenv.configure().directory("../").load();
    var appId = dotenv.get("ALGOLIA_APPLICATION_ID");
    var apiKey = dotenv.get("ALGOLIA_ADMIN_KEY");
    var indexName = dotenv.get("SEARCH_INDEX");
    var query = dotenv.get("SEARCH_QUERY");

    var options = new ClientOptions.Builder()
            .addAlgoliaAgentSegment("test", "8.0.0")
            .addAlgoliaAgentSegment("JVM", "11.0.14")
            .addAlgoliaAgentSegment("no version")
            .setLogLevel(LogLevel.BODY)
            .build();
    try(var client = new SearchClient(appId, apiKey, options)) {
      var records = Arrays.asList(new Actor("Tom Cruise"), new Actor("Scarlett Johansson"));
      var batch = records.stream()
              .map(entry -> new BatchRequest().setAction(Action.ADD_OBJECT).setBody(entry))
              .toList();

      var response = client.batch(indexName, new BatchWriteParams().setRequests(batch));
      client.waitForTask(indexName, response.getTaskID());

      var searchMethodParams = new SearchMethodParams();
      var searchQuery = new SearchForHits()
              .setIndexName(indexName)
              .setQuery(query)
              .addAttributesToSnippet("title")
              .addAttributesToSnippet("alternative_titles");
      var requests = List.of(SearchQuery.of(searchQuery));
      searchMethodParams.setRequests(requests);

      var responses = client.search(searchMethodParams);
      var actorSearchResult = (SearchResponse<Map>) responses.getResults().get(0).getInsideValue();
      Map a = actorSearchResult.getHits().get(0);
      System.out.println(a);
    }
  }
}
