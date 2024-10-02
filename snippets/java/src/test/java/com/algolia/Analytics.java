package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.AnalyticsClient;
import com.algolia.model.analytics.*;

// IMPORT<

class SnippetAnalyticsClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customDelete("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customGet("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getAddToCartRate method.
  //
  // get getAddToCartRate with minimal parameters
  void snippetForGetAddToCartRate() {
    // >SEPARATOR getAddToCartRate default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getAddToCartRate("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getAverageClickPosition method.
  //
  // get getAverageClickPosition with minimal parameters
  void snippetForGetAverageClickPosition() {
    // >SEPARATOR getAverageClickPosition default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getAverageClickPosition("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getClickPositions method.
  //
  // get getClickPositions with minimal parameters
  void snippetForGetClickPositions() {
    // >SEPARATOR getClickPositions default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getClickPositions("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getClickThroughRate method.
  //
  // get getClickThroughRate with minimal parameters
  void snippetForGetClickThroughRate() {
    // >SEPARATOR getClickThroughRate default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getClickThroughRate("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getConversionRate method.
  //
  // get getConversationRate with minimal parameters
  void snippetForGetConversionRate() {
    // >SEPARATOR getConversionRate default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getConversionRate("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getNoClickRate method.
  //
  // get getNoClickRate with minimal parameters
  void snippetForGetNoClickRate() {
    // >SEPARATOR getNoClickRate default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getNoClickRate("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getNoResultsRate method.
  //
  // get getNoResultsRate with minimal parameters
  void snippetForGetNoResultsRate() {
    // >SEPARATOR getNoResultsRate default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getNoResultsRate("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getPurchaseRate method.
  //
  // get getPurchaseRate with minimal parameters
  void snippetForGetPurchaseRate() {
    // >SEPARATOR getPurchaseRate default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getPurchaseRate("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getRevenue method.
  //
  // get getRevenue with minimal parameters
  void snippetForGetRevenue() {
    // >SEPARATOR getRevenue default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getRevenue("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getSearchesCount method.
  //
  // get getSearchesCount with minimal parameters
  void snippetForGetSearchesCount() {
    // >SEPARATOR getSearchesCount default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getSearchesCount("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getSearchesNoClicks method.
  //
  // get getSearchesNoClicks with minimal parameters
  void snippetForGetSearchesNoClicks() {
    // >SEPARATOR getSearchesNoClicks default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getSearchesNoClicks("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getSearchesNoResults method.
  //
  // get getSearchesNoResults with minimal parameters
  void snippetForGetSearchesNoResults() {
    // >SEPARATOR getSearchesNoResults default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getSearchesNoResults("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getStatus method.
  //
  // get getStatus with minimal parameters
  void snippetForGetStatus() {
    // >SEPARATOR getStatus default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getStatus("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTopCountries method.
  //
  // get getTopCountries with minimal parameters
  void snippetForGetTopCountries() {
    // >SEPARATOR getTopCountries default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getTopCountries("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTopFilterAttributes method.
  //
  // get getTopFilterAttributes with minimal parameters
  void snippetForGetTopFilterAttributes() {
    // >SEPARATOR getTopFilterAttributes default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getTopFilterAttributes("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTopFilterForAttribute method.
  //
  // get getTopFilterForAttribute with minimal parameters
  void snippetForGetTopFilterForAttribute() {
    // >SEPARATOR getTopFilterForAttribute default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getTopFilterForAttribute("myAttribute", "index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTopFiltersNoResults method.
  //
  // get getTopFiltersNoResults with minimal parameters
  void snippetForGetTopFiltersNoResults() {
    // >SEPARATOR getTopFiltersNoResults default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getTopFiltersNoResults("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTopHits method.
  //
  // get getTopHits with minimal parameters
  void snippetForGetTopHits() {
    // >SEPARATOR getTopHits default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getTopHits("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTopSearches method.
  //
  // get getTopSearches with minimal parameters
  void snippetForGetTopSearches() {
    // >SEPARATOR getTopSearches default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getTopSearches("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getUsersCount method.
  //
  // get getUsersCount with minimal parameters
  void snippetForGetUsersCount() {
    // >SEPARATOR getUsersCount default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getUsersCount("index");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }
}
