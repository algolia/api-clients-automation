package com.algolia.methods.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algolia.JSON;
import com.algolia.Pair;
import com.algolia.api.AbtestingApi;
import com.algolia.model.abtesting.*;
import com.algolia.utils.echo.*;
import com.google.gson.reflect.TypeToken;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbtestingApiTests {

  private AbtestingApi client;

  @BeforeAll
  void init() {
    client = new AbtestingApi("appId", "apiKey", new EchoRequester());
  }

  @Test
  @DisplayName("addABTests with minimal parameters")
  void addABTestsTest0() {
    AddABTestsRequest addABTestsRequest0 = new AddABTestsRequest();
    {
      String endAt1 = "2022-12-31T00:00:00.000Z";

      addABTestsRequest0.setEndAt(endAt1);
      String name1 = "myABTest";

      addABTestsRequest0.setName(name1);

      List<AddABTestsVariant> variant1 = new ArrayList<>();

      {
        AbTestsVariant variant_02 = new AbTestsVariant();
        {
          String index3 = "AB_TEST_1";

          variant_02.setIndex(index3);

          int trafficPercentage3 = 30;

          variant_02.setTrafficPercentage(trafficPercentage3);
        }
        variant1.add(AddABTestsVariant.ofAbTestsVariant(variant_02));

        AbTestsVariant variant_12 = new AbTestsVariant();
        {
          String index3 = "AB_TEST_2";

          variant_12.setIndex(index3);

          int trafficPercentage3 = 50;

          variant_12.setTrafficPercentage(trafficPercentage3);
        }
        variant1.add(AddABTestsVariant.ofAbTestsVariant(variant_12));
      }
      addABTestsRequest0.setVariant(variant1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.addABTests(addABTestsRequest0);
      }
    );

    assertEquals(req.getPath(), "/2/abtests");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"endAt\":\"2022-12-31T00:00:00.000Z\",\"name\":\"myABTest\",\"variant\":[{\"index\":\"AB_TEST_1\",\"trafficPercentage\":30},{\"index\":\"AB_TEST_2\",\"trafficPercentage\":50}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("deleteABTest")
  void deleteABTestTest0() {
    int id0 = 42;

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteABTest(id0);
      }
    );

    assertEquals(req.getPath(), "/2/abtests/42");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("getABTest")
  void getABTestTest0() {
    int id0 = 42;

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getABTest(id0);
      }
    );

    assertEquals(req.getPath(), "/2/abtests/42");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("listABTests with minimal parameters")
  void listABTestsTest0() {
    int offset0 = 42;

    int limit0 = 21;

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.listABTests(offset0, limit0);
      }
    );

    assertEquals(req.getPath(), "/2/abtests");
    assertEquals(req.getMethod(), "GET");

    HashMap<String, String> expectedQuery = JSON.deserialize(
      "{\"offset\":\"42\",\"limit\":\"21\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("stopABTest")
  void stopABTestTest0() {
    int id0 = 42;

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.stopABTest(id0);
      }
    );

    assertEquals(req.getPath(), "/2/abtests/42/stop");
    assertEquals(req.getMethod(), "POST");
  }
}
