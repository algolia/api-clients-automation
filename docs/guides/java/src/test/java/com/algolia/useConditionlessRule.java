package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;

public class useConditionlessRule {

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");) {
      String objectID = "a-rule-id";

      Rule rule = new Rule().setObjectID(objectID).setConsequence(new Consequence(/* Set relevant consequence */));

      // Set validity (optional)
      rule.setValidity(List.of(new TimeRange().setFrom(1688774400L).setUntil(1738972800L)));

      client.saveRule("<YOUR_INDEX_NAME>", objectID, rule);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}
