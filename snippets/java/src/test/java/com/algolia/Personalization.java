package com.algolia.methods.snippets;

import com.algolia.api.PersonalizationClient;
import com.algolia.model.personalization.*;

class SnippetPersonalizationClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void SnippetForCustomDelete() {
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void SnippetForCustomGet() {
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void SnippetForCustomPost() {
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void SnippetForCustomPut() {
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPut("/test/minimal");
  }

  // Snippet for the deleteUserProfile method.
  //
  // delete deleteUserProfile
  void SnippetForDeleteUserProfile() {
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.deleteUserProfile("UserToken");
  }

  // Snippet for the getPersonalizationStrategy method.
  //
  // get getPersonalizationStrategy
  void SnippetForGetPersonalizationStrategy() {
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getPersonalizationStrategy();
  }

  // Snippet for the getUserTokenProfile method.
  //
  // get getUserTokenProfile
  void SnippetForGetUserTokenProfile() {
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getUserTokenProfile("UserToken");
  }

  // Snippet for the setPersonalizationStrategy method.
  //
  // set setPersonalizationStrategy
  void SnippetForSetPersonalizationStrategy() {
    PersonalizationClient client = new PersonalizationClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.setPersonalizationStrategy(
      new PersonalizationStrategyParams()
        .setEventScoring(List.of(new EventScoring().setScore(42).setEventName("Algolia").setEventType("Event")))
        .setFacetScoring(List.of(new FacetScoring().setScore(42).setFacetName("Event")))
        .setPersonalizationImpact(42)
    );
  }
}
