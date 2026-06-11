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
      this.client = new AgentStudioClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"));
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new AgentStudioClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"));
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("e2e export conversations")
  void exportConversationsTest2() {
    List res = client.exportConversations("76710f1b-8231-42e5-b0d1-f43aac618e15");
  }

  @Test
  @DisplayName("e2e get agent")
  void getAgentTest1() {
    AgentWithVersionResponse res = client.getAgent("76710f1b-8231-42e5-b0d1-f43aac618e15");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"id\":\"76710f1b-8231-42e5-b0d1-f43aac618e15\",\"name\":\"cts_e2e_agent\",\"status\":\"published\",\"instructions\":\"You" +
          " are a helpful assistant for CTS e2e testing.\"}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("e2e get allowed domain")
  void getAllowedDomainTest1() {
    AllowedDomainResponse res = client.getAllowedDomain("6e8a0441-9a41-477c-a1d6-679a461e0990", "76710f1b-8231-42e5-b0d1-f43aac618e15");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"id\":\"6e8a0441-9a41-477c-a1d6-679a461e0990\",\"domain\":\"cts-e2e.algolia.com\",\"agentId\":\"76710f1b-8231-42e5-b0d1-f43aac618e15\"}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("e2e getConfiguration")
  void getConfigurationTest1() {
    ApplicationConfigResponse res = client.getConfiguration();
    assertDoesNotThrow(() -> TestHelpers.lenientJsonAssert("{\"maxRetentionDays\":90}", json.writeValueAsString(res)));
  }

  @Test
  @DisplayName("e2e get conversation")
  void getConversationTest1() {
    ConversationFullResponse res = client.getConversation("alg_cnv_miss_yqcZtaOSPTF8bJsJ", "76710f1b-8231-42e5-b0d1-f43aac618e15");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"id\":\"alg_cnv_miss_yqcZtaOSPTF8bJsJ\",\"agentId\":\"76710f1b-8231-42e5-b0d1-f43aac618e15\",\"title\":\"General" +
          " Greeting\"}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("e2e get provider")
  void getProviderTest1() {
    ProviderAuthenticationResponse res = client.getProvider("c2905529-b933-4b69-87ec-75f9829d5f59");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"id\":\"c2905529-b933-4b69-87ec-75f9829d5f59\",\"name\":\"cts_e2e_provider\",\"providerName\":\"openai\"}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("e2e get secret key")
  void getSecretKeyTest1() {
    SecretKeyResponse res = client.getSecretKey("c110e615-7d5a-4103-865f-c5062c0d6f4d");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"id\":\"c110e615-7d5a-4103-865f-c5062c0d6f4d\",\"name\":\"cts_e2e_secret_key\"}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("e2e list agent allowed domains")
  void listAgentAllowedDomainsTest1() {
    AllowedDomainListResponse res = client.listAgentAllowedDomains("76710f1b-8231-42e5-b0d1-f43aac618e15");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"domains\":[{\"id\":\"6e8a0441-9a41-477c-a1d6-679a461e0990\",\"domain\":\"cts-e2e.algolia.com\"}]}",
        json.writeValueAsString(res)
      )
    );
  }

  @Test
  @DisplayName("listAgentConversations with all parameters")
  void listAgentConversationsTest1() {
    PaginatedConversationsResponse res = client.listAgentConversations(
      "76710f1b-8231-42e5-b0d1-f43aac618e15",
      "2024-01-01",
      "2024-12-31",
      true,
      1,
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
  @DisplayName("e2e list agent conversations")
  void listAgentConversationsTest2() {
    PaginatedConversationsResponse res = client.listAgentConversations("76710f1b-8231-42e5-b0d1-f43aac618e15");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"data\":[{\"id\":\"alg_cnv_miss_yqcZtaOSPTF8bJsJ\",\"agentId\":\"76710f1b-8231-42e5-b0d1-f43aac618e15\",\"title\":\"General" +
          " Greeting\"}]}",
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
  @DisplayName("e2e list provider models")
  void listProviderModelsTest1() {
    List res = client.listProviderModels("c2905529-b933-4b69-87ec-75f9829d5f59");
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

  @Test
  @DisplayName("e2e list secret keys")
  void listSecretKeysTest2() {
    PaginatedSecretKeysResponse res = client.listSecretKeys(1, 10);
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"data\":[{\"name\":\"cts_e2e_secret_key\"}],\"pagination\":{\"page\":1,\"limit\":10}}",
        json.writeValueAsString(res)
      )
    );
  }
}
