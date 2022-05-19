package com.algolia.playground;

import com.algolia.api.SearchClient;
import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaRetryException;
import com.algolia.exceptions.AlgoliaRuntimeException;
import com.algolia.model.search.*;
import com.algolia.utils.AlgoliaAgent;
import io.github.cdimascio.dotenv.Dotenv;
import java.lang.InterruptedException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Search {

  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.configure().directory("../").load();

    SearchClient client = new SearchClient(
      dotenv.get("ALGOLIA_APPLICATION_ID"),
      dotenv.get("ALGOLIA_SEARCH_KEY"),
      new AlgoliaAgent.Segment[] {
        new AlgoliaAgent.Segment("test", "8.0.0"),
        new AlgoliaAgent.Segment("JVM", "11.0.14"),
        new AlgoliaAgent.Segment("no version"),
      }
    );

    String indexName = dotenv.get("SEARCH_INDEX");
    String query = dotenv.get("SEARCH_QUERY");

    try {
      SearchMethodParams searchMethodParams = new SearchMethodParams();
      List<SearchQueries> requests = new ArrayList<>();
      SearchQueries request = new SearchQueries();
      request.setIndexName(indexName);
      request.setQuery(query);
      requests.add(request);
      searchMethodParams.setRequests(requests);

      CompletableFuture<SearchResponses> result = client.searchAsync(
        searchMethodParams
      );

      SearchResponses sr = result.get();
      System.out.println(sr);
    } catch (InterruptedException e) {
      System.err.println("InterrupedException" + e.getMessage());
      e.printStackTrace();
    } catch (ExecutionException e) {
      System.err.println("ExecutionException" + e.getMessage());
      e.printStackTrace();
    } catch (AlgoliaApiException e) {
      // the API failed
      System.err.println("Exception when calling SearchClient#search");
      System.err.println("Status code: " + e.getHttpErrorCode());
      System.err.println("Reason: " + e.getMessage());
      e.printStackTrace();
    } catch (AlgoliaRetryException e) {
      // the retry failed
      System.err.println("Exception in the retry strategy");
      e.printStackTrace();
    } catch (AlgoliaRuntimeException e) {
      // the serialization or something else failed
      e.printStackTrace();
    }
  }
}
