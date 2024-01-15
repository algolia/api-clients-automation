package com.algolia.methods.snippets;

import com.algolia.api.AbtestingClient;
import com.algolia.model.abtesting.*;

class SnippetAbtestingClient {

  // Snippet for the addABTests method.
  //
  // addABTests with minimal parameters
  void SnippetForAddABTests() {
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void SnippetForCustomDelete() {
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void SnippetForCustomGet() {
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void SnippetForCustomPost() {
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void SnippetForCustomPut() {
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPut("/test/minimal");
  }

  // Snippet for the deleteABTest method.
  //
  // deleteABTest
  void SnippetForDeleteABTest() {
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.deleteABTest(42);
  }

  // Snippet for the getABTest method.
  //
  // getABTest
  void SnippetForGetABTest() {
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getABTest(42);
  }

  // Snippet for the listABTests method.
  //
  // listABTests with minimal parameters
  void SnippetForListABTests() {
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.listABTests();
  }

  // Snippet for the stopABTest method.
  //
  // stopABTest
  void SnippetForStopABTest() {
    AbtestingClient client = new AbtestingClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.stopABTest(42);
  }
}
