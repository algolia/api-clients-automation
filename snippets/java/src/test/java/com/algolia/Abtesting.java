package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.AbtestingClient;
import com.algolia.model.abtesting.*;

// IMPORT<

class SnippetAbtestingClient {

  // Snippet for the addABTests method.
  //
  // addABTests with minimal parameters
  void snippetForAddABTests() {
    // >SEPARATOR addABTests default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.addABTests(
      new AddABTestsRequest()
        .setEndAt("2022-12-31T00:00:00.000Z")
        .setName("myABTest")
        .setVariants(
          List.of(
            new AbTestsVariant().setIndex("AB_TEST_1").setTrafficPercentage(30),
            new AbTestsVariant().setIndex("AB_TEST_2").setTrafficPercentage(50)
          )
        )
    );
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the deleteABTest method.
  //
  // deleteABTest
  void snippetForDeleteABTest() {
    // >SEPARATOR deleteABTest default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteABTest(42);
    // SEPARATOR<
  }

  // Snippet for the getABTest method.
  //
  // getABTest
  void snippetForGetABTest() {
    // >SEPARATOR getABTest default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getABTest(42);
    // SEPARATOR<
  }

  // Snippet for the listABTests method.
  //
  // listABTests with minimal parameters
  void snippetForListABTests() {
    // >SEPARATOR listABTests default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.listABTests();
    // SEPARATOR<
  }

  // Snippet for the stopABTest method.
  //
  // stopABTest
  void snippetForStopABTest() {
    // >SEPARATOR stopABTest default
    // Initialize the client
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.stopABTest(42);
    // SEPARATOR<
  }
}
