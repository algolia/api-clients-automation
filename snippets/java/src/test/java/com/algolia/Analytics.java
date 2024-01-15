package com.algolia.methods.snippets;

import com.algolia.api.AnalyticsClient;
import com.algolia.model.analytics.*;

class SnippetAnalyticsClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("/test/minimal");
  }

  // Snippet for the getAverageClickPosition method.
  //
  // get getAverageClickPosition with minimal parameters
  void snippetForGetAverageClickPosition() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getAverageClickPosition("index");
  }

  // Snippet for the getClickPositions method.
  //
  // get getClickPositions with minimal parameters
  void snippetForGetClickPositions() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getClickPositions("index");
  }

  // Snippet for the getClickThroughRate method.
  //
  // get getClickThroughRate with minimal parameters
  void snippetForGetClickThroughRate() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getClickThroughRate("index");
  }

  // Snippet for the getConversationRate method.
  //
  // get getConversationRate with minimal parameters
  void snippetForGetConversationRate() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getConversationRate("index");
  }

  // Snippet for the getNoClickRate method.
  //
  // get getNoClickRate with minimal parameters
  void snippetForGetNoClickRate() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getNoClickRate("index");
  }

  // Snippet for the getNoResultsRate method.
  //
  // get getNoResultsRate with minimal parameters
  void snippetForGetNoResultsRate() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getNoResultsRate("index");
  }

  // Snippet for the getSearchesCount method.
  //
  // get getSearchesCount with minimal parameters
  void snippetForGetSearchesCount() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSearchesCount("index");
  }

  // Snippet for the getSearchesNoClicks method.
  //
  // get getSearchesNoClicks with minimal parameters
  void snippetForGetSearchesNoClicks() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSearchesNoClicks("index");
  }

  // Snippet for the getSearchesNoResults method.
  //
  // get getSearchesNoResults with minimal parameters
  void snippetForGetSearchesNoResults() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSearchesNoResults("index");
  }

  // Snippet for the getStatus method.
  //
  // get getStatus with minimal parameters
  void snippetForGetStatus() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getStatus("index");
  }

  // Snippet for the getTopCountries method.
  //
  // get getTopCountries with minimal parameters
  void snippetForGetTopCountries() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopCountries("index");
  }

  // Snippet for the getTopFilterAttributes method.
  //
  // get getTopFilterAttributes with minimal parameters
  void snippetForGetTopFilterAttributes() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopFilterAttributes("index");
  }

  // Snippet for the getTopFilterForAttribute method.
  //
  // get getTopFilterForAttribute with minimal parameters
  void snippetForGetTopFilterForAttribute() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopFilterForAttribute("myAttribute", "index");
  }

  // Snippet for the getTopFiltersNoResults method.
  //
  // get getTopFiltersNoResults with minimal parameters
  void snippetForGetTopFiltersNoResults() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopFiltersNoResults("index");
  }

  // Snippet for the getTopHits method.
  //
  // get getTopHits with minimal parameters
  void snippetForGetTopHits() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopHits("index");
  }

  // Snippet for the getTopSearches method.
  //
  // get getTopSearches with minimal parameters
  void snippetForGetTopSearches() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopSearches("index");
  }

  // Snippet for the getUsersCount method.
  //
  // get getUsersCount with minimal parameters
  void snippetForGetUsersCount() {
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getUsersCount("index");
  }
}
