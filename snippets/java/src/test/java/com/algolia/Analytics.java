package com.algolia.methods.snippets;

import com.algolia.api.AnalyticsClient;
import com.algolia.model.analytics.*;

class SnippetAnalyticsClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void SnippetForCustomDelete() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void SnippetForCustomGet() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void SnippetForCustomPost() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void SnippetForCustomPut() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPut("/test/minimal");
  }

  // Snippet for the getAverageClickPosition method.
  //
  // get getAverageClickPosition with minimal parameters
  void SnippetForGetAverageClickPosition() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getAverageClickPosition("index");
  }

  // Snippet for the getClickPositions method.
  //
  // get getClickPositions with minimal parameters
  void SnippetForGetClickPositions() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getClickPositions("index");
  }

  // Snippet for the getClickThroughRate method.
  //
  // get getClickThroughRate with minimal parameters
  void SnippetForGetClickThroughRate() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getClickThroughRate("index");
  }

  // Snippet for the getConversationRate method.
  //
  // get getConversationRate with minimal parameters
  void SnippetForGetConversationRate() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getConversationRate("index");
  }

  // Snippet for the getNoClickRate method.
  //
  // get getNoClickRate with minimal parameters
  void SnippetForGetNoClickRate() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getNoClickRate("index");
  }

  // Snippet for the getNoResultsRate method.
  //
  // get getNoResultsRate with minimal parameters
  void SnippetForGetNoResultsRate() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getNoResultsRate("index");
  }

  // Snippet for the getSearchesCount method.
  //
  // get getSearchesCount with minimal parameters
  void SnippetForGetSearchesCount() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getSearchesCount("index");
  }

  // Snippet for the getSearchesNoClicks method.
  //
  // get getSearchesNoClicks with minimal parameters
  void SnippetForGetSearchesNoClicks() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getSearchesNoClicks("index");
  }

  // Snippet for the getSearchesNoResults method.
  //
  // get getSearchesNoResults with minimal parameters
  void SnippetForGetSearchesNoResults() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getSearchesNoResults("index");
  }

  // Snippet for the getStatus method.
  //
  // get getStatus with minimal parameters
  void SnippetForGetStatus() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getStatus("index");
  }

  // Snippet for the getTopCountries method.
  //
  // get getTopCountries with minimal parameters
  void SnippetForGetTopCountries() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getTopCountries("index");
  }

  // Snippet for the getTopFilterAttributes method.
  //
  // get getTopFilterAttributes with minimal parameters
  void SnippetForGetTopFilterAttributes() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getTopFilterAttributes("index");
  }

  // Snippet for the getTopFilterForAttribute method.
  //
  // get getTopFilterForAttribute with minimal parameters
  void SnippetForGetTopFilterForAttribute() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getTopFilterForAttribute("myAttribute", "index");
  }

  // Snippet for the getTopFiltersNoResults method.
  //
  // get getTopFiltersNoResults with minimal parameters
  void SnippetForGetTopFiltersNoResults() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getTopFiltersNoResults("index");
  }

  // Snippet for the getTopHits method.
  //
  // get getTopHits with minimal parameters
  void SnippetForGetTopHits() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getTopHits("index");
  }

  // Snippet for the getTopSearches method.
  //
  // get getTopSearches with minimal parameters
  void SnippetForGetTopSearches() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getTopSearches("index");
  }

  // Snippet for the getUsersCount method.
  //
  // get getUsersCount with minimal parameters
  void SnippetForGetUsersCount() {
    AnalyticsClient client = new AnalyticsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getUsersCount("index");
  }
}
