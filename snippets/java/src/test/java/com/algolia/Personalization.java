package com.algolia.methods.snippets;

import com.algolia.api.PersonalizationClient;
import com.algolia.model.personalization.*;

class SnippetPersonalizationClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("/test/minimal");
  }

  // Snippet for the deleteUserProfile method.
  //
  // delete deleteUserProfile
  void snippetForDeleteUserProfile() {
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteUserProfile("UserToken");
  }

  // Snippet for the getPersonalizationStrategy method.
  //
  // get getPersonalizationStrategy
  void snippetForGetPersonalizationStrategy() {
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getPersonalizationStrategy();
  }

  // Snippet for the getUserTokenProfile method.
  //
  // get getUserTokenProfile
  void snippetForGetUserTokenProfile() {
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getUserTokenProfile("UserToken");
  }

  // Snippet for the setPersonalizationStrategy method.
  //
  // set setPersonalizationStrategy
  void snippetForSetPersonalizationStrategy() {
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.setPersonalizationStrategy(
      new PersonalizationStrategyParams()
        .setEventScoring(List.of(new EventScoring().setScore(42).setEventName("Algolia").setEventType("Event")))
        .setFacetScoring(List.of(new FacetScoring().setScore(42).setFacetName("Event")))
        .setPersonalizationImpact(42)
    );
  }
}
