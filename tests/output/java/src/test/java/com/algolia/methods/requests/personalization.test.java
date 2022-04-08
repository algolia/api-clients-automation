package com.algolia.methods.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algolia.model.personalization.*;
import com.algolia.utils.echo.*;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonalizationApiTests {

  private PersonalizationApi client;

  @BeforeAll
  void init() {
    client = new PersonalizationApi("appId", "apiKey", new EchoRequester());
  }

  @Test
  @DisplayName("delete deleteUserProfile")
  void deleteUserProfileTest0() {
    String userToken0 = "UserToken";

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteUserProfile(userToken0);
      }
    );

    assertEquals(req.getPath(), "/1/profiles/UserToken");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("get getPersonalizationStrategy")
  void getPersonalizationStrategyTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getPersonalizationStrategy();
      }
    );

    assertEquals(req.getPath(), "/1/strategies/personalization");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("get getUserTokenProfile")
  void getUserTokenProfileTest0() {
    String userToken0 = "UserToken";

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getUserTokenProfile(userToken0);
      }
    );

    assertEquals(req.getPath(), "/1/profiles/personalization/UserToken");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("set setPersonalizationStrategy")
  void setPersonalizationStrategyTest0() {
    PersonalizationStrategyParams personalizationStrategyParams0 = new PersonalizationStrategyParams();
    {
      List eventScoring1 = new ArrayList();
      {
        EventScoring eventScoring_02 = new EventScoring();
        {
          int score3 = 42;

          eventScoring_02.setScore(score3);
          String eventName3 = "Algolia";

          eventScoring_02.setEventName(eventName3);
          String eventType3 = "Event";

          eventScoring_02.setEventType(eventType3);
        }
        eventScoring1.add(eventScoring_02);
      }

      personalizationStrategyParams0.setEventScoring(eventScoring1);

      List facetScoring1 = new ArrayList();
      {
        FacetScoring facetScoring_02 = new FacetScoring();
        {
          int score3 = 42;

          facetScoring_02.setScore(score3);
          String facetName3 = "Event";

          facetScoring_02.setFacetName(facetName3);
        }
        facetScoring1.add(facetScoring_02);
      }

      personalizationStrategyParams0.setFacetScoring(facetScoring1);

      int personalizationImpact1 = 42;

      personalizationStrategyParams0.setPersonalizationImpact(
        personalizationImpact1
      );
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.setPersonalizationStrategy(
          personalizationStrategyParams0
        );
      }
    );

    assertEquals(req.getPath(), "/1/strategies/personalization");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"eventScoring\":[{\"score\":42,\"eventName\":\"Algolia\",\"eventType\":\"Event\"}],\"facetScoring\":[{\"score\":42,\"facetName\":\"Event\"}],\"personalizationImpact\":42}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }
}
