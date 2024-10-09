package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.AnalyticsClient;
import com.algolia.model.analytics.*;
// IMPORT<
import java.util.*;

class SnippetAnalyticsClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
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
  void snippetForCustomGet() throws Exception {
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
  void snippetForCustomPost() throws Exception {
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
  void snippetForCustomPut() throws Exception {
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
  void snippetForGetAddToCartRate() throws Exception {
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
  void snippetForGetAverageClickPosition() throws Exception {
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
  void snippetForGetClickPositions() throws Exception {
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
  void snippetForGetClickThroughRate() throws Exception {
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
  void snippetForGetConversionRate() throws Exception {
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
  void snippetForGetNoClickRate() throws Exception {
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
  void snippetForGetNoResultsRate() throws Exception {
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
  void snippetForGetPurchaseRate() throws Exception {
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
  void snippetForGetRevenue() throws Exception {
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
  void snippetForGetSearchesCount() throws Exception {
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
  void snippetForGetSearchesNoClicks() throws Exception {
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
  void snippetForGetSearchesNoResults() throws Exception {
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
  void snippetForGetStatus() throws Exception {
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
  void snippetForGetTopCountries() throws Exception {
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
  void snippetForGetTopFilterAttributes() throws Exception {
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
  void snippetForGetTopFilterForAttribute() throws Exception {
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
  void snippetForGetTopFiltersNoResults() throws Exception {
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
  void snippetForGetTopHits() throws Exception {
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
  void snippetForGetTopSearches() throws Exception {
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
  void snippetForGetUsersCount() throws Exception {
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
  void snippetForSetClientApiKey() throws Exception {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }
}
