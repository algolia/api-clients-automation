package com.algolia.methods.snippets;

import com.algolia.api.PersonalizationClient;
import com.algolia.model.personalization.*;

class SnippetPersonalizationClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the deleteUserProfile method.
  //
  // delete deleteUserProfile
  void snippetForDeleteUserProfile() {
    // >SEPARATOR deleteUserProfile
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteUserProfile("UserToken");
    // SEPARATOR<
  }

  // Snippet for the getPersonalizationStrategy method.
  //
  // get getPersonalizationStrategy
  void snippetForGetPersonalizationStrategy() {
    // >SEPARATOR getPersonalizationStrategy
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getPersonalizationStrategy();
    // SEPARATOR<
  }

  // Snippet for the getUserTokenProfile method.
  //
  // get getUserTokenProfile
  void snippetForGetUserTokenProfile() {
    // >SEPARATOR getUserTokenProfile
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getUserTokenProfile("UserToken");
    // SEPARATOR<
  }

  // Snippet for the setPersonalizationStrategy method.
  //
  // set setPersonalizationStrategy
  void snippetForSetPersonalizationStrategy() {
    // >SEPARATOR setPersonalizationStrategy
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.setPersonalizationStrategy(
      new PersonalizationStrategyParams()
        .setEventScoring(List.of(new EventScoring().setScore(42).setEventName("Algolia").setEventType("Event")))
        .setFacetScoring(List.of(new FacetScoring().setScore(42).setFacetName("Event")))
        .setPersonalizationImpact(42)
    );
    // SEPARATOR<
  }
}
