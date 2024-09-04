package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.InsightsClient;
import com.algolia.model.insights.*;

// IMPORT<

class SnippetInsightsClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customDelete("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet default
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customGet("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost default
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPost("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut default
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the deleteUserToken method.
  //
  // deleteUserToken
  void snippetForDeleteUserToken() {
    // >SEPARATOR deleteUserToken default
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteUserToken("test-user-1");
    // SEPARATOR<
  }

  // Snippet for the pushEvents method.
  //
  // pushEvents
  void snippetForPushEvents() {
    // >SEPARATOR pushEvents default
    // Initialize the client
    InsightsClient client = new InsightsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.pushEvents(
      new InsightsEvents()
        .setEvents(
          Arrays.asList(
            new ClickedObjectIDsAfterSearch()
              .setEventType(ClickEvent.CLICK)
              .setEventName("Product Clicked")
              .setIndex("products")
              .setUserToken("user-123456")
              .setAuthenticatedUserToken("user-123456")
              .setTimestamp(1641290601962L)
              .setObjectIDs(Arrays.asList("9780545139700", "9780439784542"))
              .setQueryID("43b15df305339e827f0ac0bdc5ebcaa7")
              .setPositions(Arrays.asList(7, 6))
          )
        )
    );
    // SEPARATOR<
  }
}
