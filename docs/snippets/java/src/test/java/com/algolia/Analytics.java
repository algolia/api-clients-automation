package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.AnalyticsClient;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.analytics.*;
import java.util.*;

class SnippetAnalyticsClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customDelete("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with all parameters
  void snippetForCustomDelete1() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customDelete(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customGet("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with all parameters
  void snippetForCustomGet1() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters with space");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // requestOptions should be escaped too
  void snippetForCustomGet2() throws Exception {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "to be overridden");
        }
      },
      new RequestOptions()
        .addExtraQueryParameters("query", "parameters with space")
        .addExtraQueryParameters("and an array", Arrays.asList("array", "with spaces"))
        .addExtraHeader("x-header-1", "spaces are left alone")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with all parameters
  void snippetForCustomPost1() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("body", "parameters");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default query parameters
  void snippetForCustomPost2() throws Exception {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("query", "myQueryParameter")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges query parameters with default ones
  void snippetForCustomPost3() throws Exception {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("query2", "myQueryParameter")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default headers
  void snippetForCustomPost4() throws Exception {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges headers with default ones
  void snippetForCustomPost5() throws Exception {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts booleans
  void snippetForCustomPost6() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("isItWorking", true)
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts integers
  void snippetForCustomPost7() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", 2)
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of string
  void snippetForCustomPost8() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList("b and c", "d"))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of booleans
  void snippetForCustomPost9() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(true, true, false))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of integers
  void snippetForCustomPost10() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(1, 2))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPut("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with all parameters
  void snippetForCustomPut1() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPut(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("body", "parameters");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getAddToCartRate method.
  //
  // get getAddToCartRate with minimal parameters
  void snippetForGetAddToCartRate() throws Exception {
    // >SEPARATOR getAddToCartRate get getAddToCartRate with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetAddToCartRateResponse response = client.getAddToCartRate("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getAddToCartRate method.
  //
  // get getAddToCartRate with all parameters
  void snippetForGetAddToCartRate1() throws Exception {
    // >SEPARATOR getAddToCartRate get getAddToCartRate with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetAddToCartRateResponse response = client.getAddToCartRate("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getAverageClickPosition method.
  //
  // get getAverageClickPosition with minimal parameters
  void snippetForGetAverageClickPosition() throws Exception {
    // >SEPARATOR getAverageClickPosition get getAverageClickPosition with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetAverageClickPositionResponse response = client.getAverageClickPosition("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getAverageClickPosition method.
  //
  // get getAverageClickPosition with all parameters
  void snippetForGetAverageClickPosition1() throws Exception {
    // >SEPARATOR getAverageClickPosition get getAverageClickPosition with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetAverageClickPositionResponse response = client.getAverageClickPosition("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getClickPositions method.
  //
  // get getClickPositions with minimal parameters
  void snippetForGetClickPositions() throws Exception {
    // >SEPARATOR getClickPositions get getClickPositions with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetClickPositionsResponse response = client.getClickPositions("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getClickPositions method.
  //
  // get getClickPositions with all parameters
  void snippetForGetClickPositions1() throws Exception {
    // >SEPARATOR getClickPositions get getClickPositions with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetClickPositionsResponse response = client.getClickPositions("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getClickThroughRate method.
  //
  // get getClickThroughRate with minimal parameters
  void snippetForGetClickThroughRate() throws Exception {
    // >SEPARATOR getClickThroughRate get getClickThroughRate with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetClickThroughRateResponse response = client.getClickThroughRate("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getClickThroughRate method.
  //
  // get getClickThroughRate with all parameters
  void snippetForGetClickThroughRate1() throws Exception {
    // >SEPARATOR getClickThroughRate get getClickThroughRate with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetClickThroughRateResponse response = client.getClickThroughRate("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getConversionRate method.
  //
  // get getConversationRate with minimal parameters
  void snippetForGetConversionRate() throws Exception {
    // >SEPARATOR getConversionRate get getConversationRate with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetConversionRateResponse response = client.getConversionRate("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getConversionRate method.
  //
  // get getConversationRate with all parameters
  void snippetForGetConversionRate1() throws Exception {
    // >SEPARATOR getConversionRate get getConversationRate with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetConversionRateResponse response = client.getConversionRate("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getNoClickRate method.
  //
  // get getNoClickRate with minimal parameters
  void snippetForGetNoClickRate() throws Exception {
    // >SEPARATOR getNoClickRate get getNoClickRate with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetNoClickRateResponse response = client.getNoClickRate("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getNoClickRate method.
  //
  // get getNoClickRate with all parameters
  void snippetForGetNoClickRate1() throws Exception {
    // >SEPARATOR getNoClickRate get getNoClickRate with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetNoClickRateResponse response = client.getNoClickRate("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getNoResultsRate method.
  //
  // get getNoResultsRate with minimal parameters
  void snippetForGetNoResultsRate() throws Exception {
    // >SEPARATOR getNoResultsRate get getNoResultsRate with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetNoResultsRateResponse response = client.getNoResultsRate("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getNoResultsRate method.
  //
  // get getNoResultsRate with all parameters
  void snippetForGetNoResultsRate1() throws Exception {
    // >SEPARATOR getNoResultsRate get getNoResultsRate with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetNoResultsRateResponse response = client.getNoResultsRate("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getPurchaseRate method.
  //
  // get getPurchaseRate with minimal parameters
  void snippetForGetPurchaseRate() throws Exception {
    // >SEPARATOR getPurchaseRate get getPurchaseRate with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetPurchaseRateResponse response = client.getPurchaseRate("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getPurchaseRate method.
  //
  // get getPurchaseRate with all parameters
  void snippetForGetPurchaseRate1() throws Exception {
    // >SEPARATOR getPurchaseRate get getPurchaseRate with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetPurchaseRateResponse response = client.getPurchaseRate("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRevenue method.
  //
  // get getRevenue with minimal parameters
  void snippetForGetRevenue() throws Exception {
    // >SEPARATOR getRevenue get getRevenue with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetRevenue response = client.getRevenue("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRevenue method.
  //
  // get getRevenue with all parameters
  void snippetForGetRevenue1() throws Exception {
    // >SEPARATOR getRevenue get getRevenue with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetRevenue response = client.getRevenue("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getSearchesCount method.
  //
  // get getSearchesCount with minimal parameters
  void snippetForGetSearchesCount() throws Exception {
    // >SEPARATOR getSearchesCount get getSearchesCount with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetSearchesCountResponse response = client.getSearchesCount("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getSearchesCount method.
  //
  // get getSearchesCount with all parameters
  void snippetForGetSearchesCount1() throws Exception {
    // >SEPARATOR getSearchesCount get getSearchesCount with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetSearchesCountResponse response = client.getSearchesCount("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getSearchesNoClicks method.
  //
  // get getSearchesNoClicks with minimal parameters
  void snippetForGetSearchesNoClicks() throws Exception {
    // >SEPARATOR getSearchesNoClicks get getSearchesNoClicks with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetSearchesNoClicksResponse response = client.getSearchesNoClicks("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getSearchesNoClicks method.
  //
  // get getSearchesNoClicks with all parameters
  void snippetForGetSearchesNoClicks1() throws Exception {
    // >SEPARATOR getSearchesNoClicks get getSearchesNoClicks with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetSearchesNoClicksResponse response = client.getSearchesNoClicks("index", "1999-09-19", "2001-01-01", 21, 42, "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getSearchesNoResults method.
  //
  // get getSearchesNoResults with minimal parameters
  void snippetForGetSearchesNoResults() throws Exception {
    // >SEPARATOR getSearchesNoResults get getSearchesNoResults with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetSearchesNoResultsResponse response = client.getSearchesNoResults("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getSearchesNoResults method.
  //
  // get getSearchesNoResults with all parameters
  void snippetForGetSearchesNoResults1() throws Exception {
    // >SEPARATOR getSearchesNoResults get getSearchesNoResults with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetSearchesNoResultsResponse response = client.getSearchesNoResults("index", "1999-09-19", "2001-01-01", 21, 42, "tag");
    // >LOG
    // print the response
    System.out.println(response);
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
    GetStatusResponse response = client.getStatus("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopCountries method.
  //
  // get getTopCountries with minimal parameters
  void snippetForGetTopCountries() throws Exception {
    // >SEPARATOR getTopCountries get getTopCountries with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopCountriesResponse response = client.getTopCountries("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopCountries method.
  //
  // get getTopCountries with all parameters
  void snippetForGetTopCountries1() throws Exception {
    // >SEPARATOR getTopCountries get getTopCountries with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopCountriesResponse response = client.getTopCountries("index", "1999-09-19", "2001-01-01", 21, 42, "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopFilterAttributes method.
  //
  // get getTopFilterAttributes with minimal parameters
  void snippetForGetTopFilterAttributes() throws Exception {
    // >SEPARATOR getTopFilterAttributes get getTopFilterAttributes with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopFilterAttributesResponse response = client.getTopFilterAttributes("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopFilterAttributes method.
  //
  // get getTopFilterAttributes with all parameters
  void snippetForGetTopFilterAttributes1() throws Exception {
    // >SEPARATOR getTopFilterAttributes get getTopFilterAttributes with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopFilterAttributesResponse response = client.getTopFilterAttributes("index", "mySearch", "1999-09-19", "2001-01-01", 21, 42, "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopFilterForAttribute method.
  //
  // get getTopFilterForAttribute with minimal parameters
  void snippetForGetTopFilterForAttribute() throws Exception {
    // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopFilterForAttributeResponse response = client.getTopFilterForAttribute("myAttribute", "index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopFilterForAttribute method.
  //
  // get getTopFilterForAttribute with minimal parameters and multiple attributes
  void snippetForGetTopFilterForAttribute1() throws Exception {
    // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with minimal parameters and
    // multiple attributes
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopFilterForAttributeResponse response = client.getTopFilterForAttribute("myAttribute1,myAttribute2", "index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopFilterForAttribute method.
  //
  // get getTopFilterForAttribute with all parameters
  void snippetForGetTopFilterForAttribute2() throws Exception {
    // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopFilterForAttributeResponse response = client.getTopFilterForAttribute(
      "myAttribute",
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopFilterForAttribute method.
  //
  // get getTopFilterForAttribute with all parameters and multiple attributes
  void snippetForGetTopFilterForAttribute3() throws Exception {
    // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with all parameters and
    // multiple attributes
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopFilterForAttributeResponse response = client.getTopFilterForAttribute(
      "myAttribute1,myAttribute2",
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopFiltersNoResults method.
  //
  // get getTopFiltersNoResults with minimal parameters
  void snippetForGetTopFiltersNoResults() throws Exception {
    // >SEPARATOR getTopFiltersNoResults get getTopFiltersNoResults with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopFiltersNoResultsResponse response = client.getTopFiltersNoResults("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopFiltersNoResults method.
  //
  // get getTopFiltersNoResults with all parameters
  void snippetForGetTopFiltersNoResults1() throws Exception {
    // >SEPARATOR getTopFiltersNoResults get getTopFiltersNoResults with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopFiltersNoResultsResponse response = client.getTopFiltersNoResults("index", "mySearch", "1999-09-19", "2001-01-01", 21, 42, "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopHits method.
  //
  // get getTopHits with minimal parameters
  void snippetForGetTopHits() throws Exception {
    // >SEPARATOR getTopHits get getTopHits with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopHitsResponse response = client.getTopHits("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopHits method.
  //
  // get getTopHits with all parameters
  void snippetForGetTopHits1() throws Exception {
    // >SEPARATOR getTopHits get getTopHits with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopHitsResponse response = client.getTopHits("index", "mySearch", true, true, "1999-09-19", "2001-01-01", 21, 42, "tag");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopSearches method.
  //
  // get getTopSearches with minimal parameters
  void snippetForGetTopSearches() throws Exception {
    // >SEPARATOR getTopSearches get getTopSearches with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopSearchesResponse response = client.getTopSearches("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTopSearches method.
  //
  // get getTopSearches with all parameters
  void snippetForGetTopSearches1() throws Exception {
    // >SEPARATOR getTopSearches get getTopSearches with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetTopSearchesResponse response = client.getTopSearches(
      "index",
      true,
      true,
      "1999-09-19",
      "2001-01-01",
      OrderBy.SEARCH_COUNT,
      Direction.ASC,
      21,
      42,
      "tag"
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getUsersCount method.
  //
  // get getUsersCount with minimal parameters
  void snippetForGetUsersCount() throws Exception {
    // >SEPARATOR getUsersCount get getUsersCount with minimal parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetUsersCountResponse response = client.getUsersCount("index");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getUsersCount method.
  //
  // get getUsersCount with all parameters
  void snippetForGetUsersCount1() throws Exception {
    // >SEPARATOR getUsersCount get getUsersCount with all parameters
    // Initialize the client
    AnalyticsClient client = new AnalyticsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    GetUsersCountResponse response = client.getUsersCount("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // print the response
    System.out.println(response);
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
