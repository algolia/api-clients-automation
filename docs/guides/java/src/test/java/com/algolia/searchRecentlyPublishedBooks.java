package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class searchRecentlyPublishedBooks {

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");) {
      long dateTimestamp = ZonedDateTime.now(ZoneOffset.UTC).plusYears(-1).toEpochSecond();
      SearchParams searchParams = new SearchParamsObject().setQuery("<YOUR_SEARCH_QUERY>").setFilters("date_timestamp > " + dateTimestamp);

      client.searchSingleIndex("<YOUR_INDEX_NAME>", searchParams, Hit.class);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}
