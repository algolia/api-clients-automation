package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.AbtestingV3Client;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.abtestingv3.*;
import java.util.*;

class SnippetAbtestingV3Client {

  // Snippet for the addABTests method.
  //
  // addABTests with minimal parameters
  void snippetForAddABTests() throws Exception {
    // >SEPARATOR addABTests default
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.addABTests(
      new AddABTestsRequest()
        .setEndAt("2022-12-31T00:00:00.000Z")
        .setName("myABTest")
        .setMetrics(Arrays.asList(new CreateMetric().setName("myMetric")))
        .setVariants(
          Arrays.asList(
            new AbTestsVariant().setIndex("AB_TEST_1").setTrafficPercentage(30),
            new AbTestsVariant().setIndex("AB_TEST_2").setTrafficPercentage(50)
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customDelete("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with all parameters
  void snippetForCustomDelete1() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customDelete(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customGet("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with all parameters
  void snippetForCustomGet1() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters with space");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // requestOptions should be escaped too
  void snippetForCustomGet2() throws Exception {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customGet(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with all parameters
  void snippetForCustomPost1() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default query parameters
  void snippetForCustomPost2() throws Exception {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges query parameters with default ones
  void snippetForCustomPost3() throws Exception {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default headers
  void snippetForCustomPost4() throws Exception {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges headers with default ones
  void snippetForCustomPost5() throws Exception {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts booleans
  void snippetForCustomPost6() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts integers
  void snippetForCustomPost7() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of string
  void snippetForCustomPost8() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of booleans
  void snippetForCustomPost9() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of integers
  void snippetForCustomPost10() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with all parameters
  void snippetForCustomPut1() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPut(
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
    // SEPARATOR<
  }

  // Snippet for the deleteABTest method.
  //
  // deleteABTest
  void snippetForDeleteABTest() throws Exception {
    // >SEPARATOR deleteABTest default
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.deleteABTest(42);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the estimateABTest method.
  //
  // estimate AB Test sample size
  void snippetForEstimateABTest() throws Exception {
    // >SEPARATOR estimateABTest default
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.estimateABTest(
      new EstimateABTestRequest()
        .setConfiguration(
          new EstimateConfiguration().setMinimumDetectableEffect(
            new MinimumDetectableEffect().setSize(0.03).setMetric(EffectMetric.CONVERSION_RATE)
          )
        )
        .setVariants(
          Arrays.asList(
            new AbTestsVariant().setIndex("AB_TEST_1").setTrafficPercentage(50),
            new AbTestsVariant().setIndex("AB_TEST_2").setTrafficPercentage(50)
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getABTest method.
  //
  // getABTest
  void snippetForGetABTest() throws Exception {
    // >SEPARATOR getABTest default
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getABTest(42);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTimeseries method.
  //
  // getTimeseries
  void snippetForGetTimeseries() throws Exception {
    // >SEPARATOR getTimeseries default
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getTimeseries(42);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listABTests method.
  //
  // listABTests with minimal parameters
  void snippetForListABTests() throws Exception {
    // >SEPARATOR listABTests listABTests with minimal parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.listABTests();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listABTests method.
  //
  // listABTests with parameters
  void snippetForListABTests1() throws Exception {
    // >SEPARATOR listABTests listABTests with parameters
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.listABTests(0, 21, "cts_e2e ab", "t", Direction.ASC);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the scheduleABTest method.
  //
  // scheduleABTest with minimal parameters
  void snippetForScheduleABTest() throws Exception {
    // >SEPARATOR scheduleABTest default
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.scheduleABTest(
      new ScheduleABTestsRequest()
        .setEndAt("2022-12-31T00:00:00.000Z")
        .setScheduledAt("2022-11-31T00:00:00.000Z")
        .setName("myABTest")
        .setMetrics(Arrays.asList(new CreateMetric().setName("myMetric")))
        .setVariants(
          Arrays.asList(
            new AbTestsVariant().setIndex("AB_TEST_1").setTrafficPercentage(30),
            new AbTestsVariant().setIndex("AB_TEST_2").setTrafficPercentage(50)
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() throws Exception {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the stopABTest method.
  //
  // stopABTest
  void snippetForStopABTest() throws Exception {
    // >SEPARATOR stopABTest default
    // Initialize the client
    AbtestingV3Client client = new AbtestingV3Client("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.stopABTest(42);
    // >LOG
    // SEPARATOR<
  }
}
