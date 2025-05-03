package com.algolia.playground;

import com.algolia.api.SearchClient;
import com.algolia.config.ClientOptions;
import com.algolia.model.search.*;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.Arrays;
import java.util.List;

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
      .addAlgoliaAgentSegment("Playground", "1.0.0")
      // .setLogLevel(LogLevel.BODY)
      .build();

    var client = new SearchClient(appId, apiKey, options);
    var records = Arrays.asList(new Actor("Tom Cruise"), new Actor("Scarlett Johansson"));
    var batch = records.stream().map(entry -> new BatchRequest().setAction(Action.ADD_OBJECT).setBody(entry)).toList();
    var response = client.batch(indexName, new BatchWriteParams().setRequests(batch));
    client.waitForTask(indexName, response.getTaskID());

    var browse = client.browseObjects(indexName, new BrowseParamsObject().setQuery("tom"), Actor.class);
    System.out.println("-> Browse Objects:");
    for (var hit : browse) {
      System.out.println("> " + hit.name);
    }

    singleSearch(client, indexName, query);
    multiSearch(indexName, query, client);
    multiSearchHits(indexName, query, client);
    client.close();
  }

  private static void singleSearch(SearchClient client, String indexName, String query) {
    SearchParamsObject params = new SearchParamsObject()
      .setQuery(query)
      .setAroundPrecision(AroundPrecision.of(1000))
      .setAroundRadius(AroundRadiusAll.ALL);
    SearchResponse<Actor> actorSearchResponse = client.searchSingleIndex(indexName, params, Actor.class);
    System.out.println("-> Single Index Search:");
    for (var hit : actorSearchResponse.getHits()) {
      System.out.println("> " + hit.name);
    }
  }

  private static void multiSearch(String indexName, String query, SearchClient client) {
    var searchMethodParams = new SearchMethodParams();
    var searchQuery = new SearchForHits()
      .setIndexName(indexName)
      .setQuery(query)
      .addAttributesToSnippet("title")
      .addAttributesToSnippet("alternative_titles");
    List<SearchQuery> requests = List.of(searchQuery);
    searchMethodParams.setRequests(requests);

    var responses = client.search(searchMethodParams, Actor.class);
    System.out.println("-> Multi Index Search:");
    for (var result : responses.getResults()) {
      for (var hit : ((SearchResponse<Actor>) result).getHits()) {
        System.out.println("> " + hit.name);
      }
    }
  }

  private static void multiSearchHits(String indexName, String query, SearchClient client) {
    var searchQuery = new SearchForHits()
      .setIndexName(indexName)
      .setQuery(query)
      .addAttributesToSnippet("title")
      .addAttributesToSnippet("alternative_titles");
    List<SearchForHits> requests = List.of(searchQuery);
    // with searchForHits, all the types are known, no need to cast
    var responses = client.searchForHits(requests, Actor.class);
    System.out.println("-> Multi Index SearchForHits:");
    for (var result : responses) {
      for (var hit : result.getHits()) {
        System.out.println("> " + hit.name);
      }
    }
  }
}
