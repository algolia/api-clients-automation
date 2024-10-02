package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.PersonalizationClient;
import com.algolia.model.personalization.*;

// IMPORT<

class SnippetPersonalizationClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    PersonalizationClient client = new PersonalizationClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    PersonalizationClient client = new PersonalizationClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    PersonalizationClient client = new PersonalizationClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteUserProfile method.
  //
  // delete deleteUserProfile
  void snippetForDeleteUserProfile() {
    // >SEPARATOR deleteUserProfile default
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.deleteUserProfile("UserToken");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getPersonalizationStrategy method.
  //
  // get getPersonalizationStrategy
  void snippetForGetPersonalizationStrategy() {
    // >SEPARATOR getPersonalizationStrategy default
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getPersonalizationStrategy();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getUserTokenProfile method.
  //
  // get getUserTokenProfile
  void snippetForGetUserTokenProfile() {
    // >SEPARATOR getUserTokenProfile default
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getUserTokenProfile("UserToken");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setPersonalizationStrategy method.
  //
  // set setPersonalizationStrategy
  void snippetForSetPersonalizationStrategy() {
    // >SEPARATOR setPersonalizationStrategy default
    // Initialize the client
    PersonalizationClient client = new PersonalizationClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.setPersonalizationStrategy(
      new PersonalizationStrategyParams()
        .setEventScoring(Arrays.asList(new EventScoring().setScore(42).setEventName("Algolia").setEventType(EventType.CLICK)))
        .setFacetScoring(Arrays.asList(new FacetScoring().setScore(42).setFacetName("Event")))
        .setPersonalizationImpact(42)
    );
    // >LOG
    // SEPARATOR<
  }
}
