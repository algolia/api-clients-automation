package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.AbtestingClient;
import com.algolia.model.abtesting.*;
// IMPORT<
import java.util.*;

class SnippetAbtestingClient {

  // Snippet for the addABTests method.
  //
  // addABTests with minimal parameters
  void snippetForAddABTests() throws Exception {
    // >SEPARATOR addABTests default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.addABTests(
      new AddABTestsRequest()
        .setEndAt("2022-12-31T00:00:00.000Z")
        .setName("myABTest")
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
    // >SEPARATOR customDelete default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteABTest method.
  //
  // deleteABTest
  void snippetForDeleteABTest() throws Exception {
    // >SEPARATOR deleteABTest default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.estimateABTest(
      new EstimateABTestRequest()
        .setConfiguration(
          new EstimateConfiguration()
            .setEmptySearch(new EmptySearch().setExclude(true))
            .setMinimumDetectableEffect(new MinimumDetectableEffect().setSize(0.03).setMetric(EffectMetric.CONVERSION_RATE))
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
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getABTest(42);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listABTests method.
  //
  // listABTests with minimal parameters
  void snippetForListABTests() throws Exception {
    // >SEPARATOR listABTests default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.listABTests();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the scheduleABTest method.
  //
  // scheduleABTest with minimal parameters
  void snippetForScheduleABTest() throws Exception {
    // >SEPARATOR scheduleABTest default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.scheduleABTest(
      new ScheduleABTestsRequest()
        .setEndAt("2022-12-31T00:00:00.000Z")
        .setScheduledAt("2022-11-31T00:00:00.000Z")
        .setName("myABTest")
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
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    AbtestingClient client = new AbtestingClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.stopABTest(42);
    // >LOG
    // SEPARATOR<
  }
}
