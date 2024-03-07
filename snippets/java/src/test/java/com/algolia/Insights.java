package com.algolia.methods.snippets;

import com.algolia.api.InsightsClient;
import com.algolia.model.insights.*;

class SnippetInsightsClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customDelete("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customGet("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPost("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the deleteUserToken method.
  //
  // deleteUserToken0
  void snippetForDeleteUserToken() {
    // >SEPARATOR deleteUserToken
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteUserToken("test-user-1");
    // SEPARATOR<
  }

  // Snippet for the pushEvents method.
  //
  // pushEvents0
  void snippetForPushEvents() {
    // >SEPARATOR pushEvents
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.pushEvents(
      new InsightsEvents()
        .setEvents(
          List.of(
            new ClickedObjectIDsAfterSearch()
              .setEventType(ClickEvent.fromValue("click"))
              .setEventName("Product Clicked")
              .setIndex("products")
              .setUserToken("user-123456")
              .setAuthenticatedUserToken("user-123456")
              .setTimestamp(1641290601962L)
              .setObjectIDs(List.of("9780545139700", "9780439784542"))
              .setQueryID("43b15df305339e827f0ac0bdc5ebcaa7")
              .setPositions(List.of(7, 6))
          )
        )
    );
    // SEPARATOR<
  }
}
