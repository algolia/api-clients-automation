package com.algolia.methods.snippets;

import com.algolia.api.AnalyticsClient;
import com.algolia.model.analytics.*;

class SnippetAnalyticsClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the getAverageClickPosition method.
  //
  // get getAverageClickPosition with minimal parameters
  void snippetForGetAverageClickPosition() {
    // >SEPARATOR getAverageClickPosition
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getAverageClickPosition("index");
    // SEPARATOR<
  }

  // Snippet for the getClickPositions method.
  //
  // get getClickPositions with minimal parameters
  void snippetForGetClickPositions() {
    // >SEPARATOR getClickPositions
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getClickPositions("index");
    // SEPARATOR<
  }

  // Snippet for the getClickThroughRate method.
  //
  // get getClickThroughRate with minimal parameters
  void snippetForGetClickThroughRate() {
    // >SEPARATOR getClickThroughRate
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getClickThroughRate("index");
    // SEPARATOR<
  }

  // Snippet for the getConversationRate method.
  //
  // get getConversationRate with minimal parameters
  void snippetForGetConversationRate() {
    // >SEPARATOR getConversationRate
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getConversationRate("index");
    // SEPARATOR<
  }

  // Snippet for the getNoClickRate method.
  //
  // get getNoClickRate with minimal parameters
  void snippetForGetNoClickRate() {
    // >SEPARATOR getNoClickRate
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getNoClickRate("index");
    // SEPARATOR<
  }

  // Snippet for the getNoResultsRate method.
  //
  // get getNoResultsRate with minimal parameters
  void snippetForGetNoResultsRate() {
    // >SEPARATOR getNoResultsRate
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getNoResultsRate("index");
    // SEPARATOR<
  }

  // Snippet for the getSearchesCount method.
  //
  // get getSearchesCount with minimal parameters
  void snippetForGetSearchesCount() {
    // >SEPARATOR getSearchesCount
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSearchesCount("index");
    // SEPARATOR<
  }

  // Snippet for the getSearchesNoClicks method.
  //
  // get getSearchesNoClicks with minimal parameters
  void snippetForGetSearchesNoClicks() {
    // >SEPARATOR getSearchesNoClicks
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSearchesNoClicks("index");
    // SEPARATOR<
  }

  // Snippet for the getSearchesNoResults method.
  //
  // get getSearchesNoResults with minimal parameters
  void snippetForGetSearchesNoResults() {
    // >SEPARATOR getSearchesNoResults
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSearchesNoResults("index");
    // SEPARATOR<
  }

  // Snippet for the getStatus method.
  //
  // get getStatus with minimal parameters
  void snippetForGetStatus() {
    // >SEPARATOR getStatus
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getStatus("index");
    // SEPARATOR<
  }

  // Snippet for the getTopCountries method.
  //
  // get getTopCountries with minimal parameters
  void snippetForGetTopCountries() {
    // >SEPARATOR getTopCountries
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopCountries("index");
    // SEPARATOR<
  }

  // Snippet for the getTopFilterAttributes method.
  //
  // get getTopFilterAttributes with minimal parameters
  void snippetForGetTopFilterAttributes() {
    // >SEPARATOR getTopFilterAttributes
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopFilterAttributes("index");
    // SEPARATOR<
  }

  // Snippet for the getTopFilterForAttribute method.
  //
  // get getTopFilterForAttribute with minimal parameters
  void snippetForGetTopFilterForAttribute() {
    // >SEPARATOR getTopFilterForAttribute
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopFilterForAttribute("myAttribute", "index");
    // SEPARATOR<
  }

  // Snippet for the getTopFiltersNoResults method.
  //
  // get getTopFiltersNoResults with minimal parameters
  void snippetForGetTopFiltersNoResults() {
    // >SEPARATOR getTopFiltersNoResults
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopFiltersNoResults("index");
    // SEPARATOR<
  }

  // Snippet for the getTopHits method.
  //
  // get getTopHits with minimal parameters
  void snippetForGetTopHits() {
    // >SEPARATOR getTopHits
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopHits("index");
    // SEPARATOR<
  }

  // Snippet for the getTopSearches method.
  //
  // get getTopSearches with minimal parameters
  void snippetForGetTopSearches() {
    // >SEPARATOR getTopSearches
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTopSearches("index");
    // SEPARATOR<
  }

  // Snippet for the getUsersCount method.
  //
  // get getUsersCount with minimal parameters
  void snippetForGetUsersCount() {
    // >SEPARATOR getUsersCount
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getUsersCount("index");
    // SEPARATOR<
  }
}
