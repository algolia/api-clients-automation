package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.AgentStudioClient;
import com.algolia.config.*;
import com.algolia.model.agentstudio.*;
import com.algolia.utils.TestHelpers;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AgentStudioClientRequestsTestsE2E {

  private AgentStudioClient client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new AgentStudioClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"), "us");
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new AgentStudioClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"), "us");
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("e2e get agent")
  void getAgentTest1() {
    AgentWithVersionResponse res = client.getAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"id\":\"785b14e4-61a8-4c03-8028-bf2ba3ae85ff\",\"name\":\"cts_e2e_agent\",\"status\":\"published\",\"instructions\":\"You" +
          " are a helpful assistant for CTS e2e testing.\"}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("e2e getApplicationConfiguration")
  void getApplicationConfigurationTest1() {
    ApplicationConfigResponse res = client.getApplicationConfiguration();
    assertDoesNotThrow(() -> TestHelpers.lenientJsonAssert("{\"maxRetentionDays\":90}", json.writeValueAsString(res)));
  }

  @Test
  @DisplayName("e2e get provider")
  void getProviderTest1() {
    ProviderAuthenticationResponse res = client.getProvider("5e33d805-7892-4329-bda7-b524dc3fd04a");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"id\":\"5e33d805-7892-4329-bda7-b524dc3fd04a\",\"name\":\"cts_e2e_provider\",\"providerName\":\"openai\"}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("listAgentConversations with all parameters")
  void listAgentConversationsTest1() {
    PaginatedConversationsResponse res = client.listAgentConversations(
      "785b14e4-61a8-4c03-8028-bf2ba3ae85ff",
      "2024-01-01",
      "2024-12-31",
      2,
      10,
      null
    );
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"data\":[],\"pagination\":{\"page\":2,\"limit\":10,\"totalCount\":0,\"totalPages\":0}}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("e2e list agents")
  void listAgentsTest2() {
    PaginatedAgentsResponse res = client.listAgents(1, 2, null);
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"data\":[{\"name\":\"cts_e2e_agent\",\"status\":\"published\"}],\"pagination\":{\"page\":1,\"limit\":2}}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("e2e list models")
  void listModelsTest1() {
    Map res = client.listModels();
    assertDoesNotThrow(() -> TestHelpers.lenientJsonAssert("{\"openai\":[\"gpt-4\"]}", json.writeValueAsString(res)));
  }

  @Test
  @DisplayName("e2e list providers")
  void listProvidersTest2() {
    PaginatedProviderAuthenticationsResponse res = client.listProviders(1, 2);
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"data\":[{\"name\":\"cts_e2e_provider\"}],\"pagination\":{\"page\":1,\"limit\":2}}",
        json.writeValueAsString(res)
      )
    );
  }
}
