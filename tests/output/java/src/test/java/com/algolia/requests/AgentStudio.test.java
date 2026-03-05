package com.algolia.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.AgentStudioClient;
import com.algolia.config.*;
import com.algolia.model.agentstudio.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AgentStudioClientRequestsTests {

  private AgentStudioClient client;
  private EchoInterceptor echo;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
    this.echo = new EchoInterceptor();
    ClientOptions options = ClientOptions.builder()
      .setRequesterConfig(requester -> requester.addInterceptor(echo))
      .build();
    this.client = new AgentStudioClient("appId", "apiKey", "us", options);
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("createAgent with minimal parameters")
  void createAgentTest() {
    assertDoesNotThrow(() -> {
      client.createAgent(new AgentConfigCreate().setName("test-agent").setInstructions("You are a helpful assistant."));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"name\":\"test-agent\",\"instructions\":\"You are a helpful assistant.\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createAgent with all parameters")
  void createAgentTest1() {
    assertDoesNotThrow(() -> {
      client.createAgent(
        new AgentConfigCreate()
          .setName("test-agent")
          .setDescription("A test agent for CTS")
          .setProviderId("5e33d805-7892-4329-bda7-b524dc3fd04a")
          .setModel("gpt-4")
          .setInstructions("You are a helpful assistant.")
          .setConfig(
            new HashMap() {
              {
                put("sendUsage", true);
                put("sendReasoning", true);
                put("temperature", 0.7);
                put("max_tokens", 1500);
              }
            }
          )
          .setTools(Arrays.asList(new StartPart().setType("start")))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"name\":\"test-agent\",\"description\":\"A test agent for" +
          " CTS\",\"providerId\":\"5e33d805-7892-4329-bda7-b524dc3fd04a\",\"model\":\"gpt-4\",\"instructions\":\"You" +
          " are a helpful" +
          " assistant.\",\"config\":{\"sendUsage\":true,\"sendReasoning\":true,\"temperature\":0.7,\"max_tokens\":1500},\"tools\":[{\"type\":\"start\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createAgentCompletion with v4 messages")
  void createAgentCompletionTest() {
    assertDoesNotThrow(() -> {
      client.createAgentCompletion(
        "785b14e4-61a8-4c03-8028-bf2ba3ae85ff",
        CompatibilityMode.AI_SDK_4,
        new AgentCompletionRequest().setMessages(
          MessagesUnion.ofListOfMessageV4(Arrays.asList(new UserMessageV4().setRole("user").setContent("Hello, how are you?")))
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/completions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"messages\":[{\"role\":\"user\",\"content\":\"Hello, how are you?\"}]}", req.body, JSONCompareMode.STRICT)
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"compatibilityMode\":\"ai-sdk-4\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("createAgentCompletion with v5 messages and all query params")
  void createAgentCompletionTest1() {
    assertDoesNotThrow(() -> {
      client.createAgentCompletion(
        "785b14e4-61a8-4c03-8028-bf2ba3ae85ff",
        CompatibilityMode.AI_SDK_5,
        new AgentCompletionRequest()
          .setMessages(
            MessagesUnion.ofListOfMessageV5(
              Arrays.asList(
                new UserMessageV5().setRole("user").setParts(Arrays.asList(new TextPartV5().setType("text").setText("What is Algolia?")))
              )
            )
          )
          .setId("test-conversation-id"),
        false,
        false,
        false
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/completions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"messages\":[{\"role\":\"user\",\"parts\":[{\"type\":\"text\",\"text\":\"What is" +
          " Algolia?\"}]}],\"id\":\"test-conversation-id\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"compatibilityMode\":\"ai-sdk-5\",\"stream\":\"false\",\"cache\":\"false\",\"memory\":\"false\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("createAgentCompletion with test configuration")
  void createAgentCompletionTest2() {
    assertDoesNotThrow(() -> {
      client.createAgentCompletion(
        "785b14e4-61a8-4c03-8028-bf2ba3ae85ff",
        CompatibilityMode.AI_SDK_4,
        new AgentCompletionRequest()
          .setMessages(MessagesUnion.ofListOfMessageV4(Arrays.asList(new UserMessageV4().setRole("user").setContent("Hello"))))
          .setConfiguration(
            new AgentTestConfiguration()
              .setInstructions("Test instructions override")
              .setConfig(
                new HashMap() {
                  {
                    put("temperature", 0.2);
                  }
                }
              )
              .setTools(Arrays.asList(new StartPart().setType("start")))
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/completions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"messages\":[{\"role\":\"user\",\"content\":\"Hello\"}],\"configuration\":{\"instructions\":\"Test" +
          " instructions" +
          " override\",\"config\":{\"temperature\":0.2},\"tools\":[{\"type\":\"start\"}]}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"compatibilityMode\":\"ai-sdk-4\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("createProvider with OpenAI")
  void createProviderTest() {
    assertDoesNotThrow(() -> {
      client.createProvider(
        new ProviderAuthenticationCreate()
          .setName("My OpenAI Provider")
          .setProviderName(ProviderName.OPENAI)
          .setInput(new OpenAIProviderInput().setApiKey("sk-test-key-1234"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"name\":\"My OpenAI" + " Provider\",\"providerName\":\"openai\",\"input\":{\"apiKey\":\"sk-test-key-1234\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createProvider with Azure OpenAI")
  void createProviderTest1() {
    assertDoesNotThrow(() -> {
      client.createProvider(
        new ProviderAuthenticationCreate()
          .setName("My Azure Provider")
          .setProviderName(ProviderName.AZURE_OPENAI)
          .setInput(
            new AzureOpenAIProviderInput()
              .setApiKey("az-test-key-5678")
              .setAzureEndpoint("https://my-resource.openai.azure.com")
              .setAzureDeployment("gpt-4o")
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"name\":\"My Azure" +
          " Provider\",\"providerName\":\"azure_openai\",\"input\":{\"apiKey\":\"az-test-key-5678\",\"azureEndpoint\":\"https://my-resource.openai.azure.com\",\"azureDeployment\":\"gpt-4o\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("allow del method for a custom path with minimal parameters")
  void customDeleteTest() {
    assertDoesNotThrow(() -> {
      client.customDelete("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow del method for a custom path with all parameters")
  void customDeleteTest1() {
    assertDoesNotThrow(() -> {
      client.customDelete(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("allow get method for a custom path with minimal parameters")
  void customGetTest() {
    assertDoesNotThrow(() -> {
      client.customGet("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow get method for a custom path with all parameters")
  void customGetTest1() {
    assertDoesNotThrow(() -> {
      client.customGet(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters with space");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters%20with%20space\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions should be escaped too")
  void customGetTest2() {
    assertDoesNotThrow(() -> {
      client.customGet(
        "test/all",
        new HashMap() {
          {
            put("query", "to be overridden");
          }
        },
        new RequestOptions()
          .addExtraQueryParameters("query", "parameters with space")
          .addExtraQueryParameters("and an array", Arrays.asList("array", "with spaces"))
          .addExtraHeader("x-header-1", "spaces are left alone")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters%20with%20space\",\"and%20an%20array\":\"array%2Cwith%20spaces\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-header-1\":\"spaces are left alone\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("allow post method for a custom path with minimal parameters")
  void customPostTest() {
    assertDoesNotThrow(() -> {
      client.customPost("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow post method for a custom path with all parameters")
  void customPostTest1() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("body", "parameters");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"body\":\"parameters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions can override default query parameters")
  void customPostTest2() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("query", "myQueryParameter")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"myQueryParameter\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions merges query parameters with default ones")
  void customPostTest3() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("query2", "myQueryParameter")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"query2\":\"myQueryParameter\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions can override default headers")
  void customPostTest4() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-api-key\":\"ALGOLIA_API_KEY\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("requestOptions merges headers with default ones")
  void customPostTest5() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-api-key\":\"ALGOLIA_API_KEY\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts booleans")
  void customPostTest6() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("isItWorking", true)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"isItWorking\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts integers")
  void customPostTest7() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("myParam", 2)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"2\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts list of string")
  void customPostTest8() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList("b and c", "d"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"b%20and%20c%2Cd\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts list of booleans")
  void customPostTest9() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(true, true, false))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"true%2Ctrue%2Cfalse\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts list of integers")
  void customPostTest10() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(1, 2))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"1%2C2\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("allow put method for a custom path with minimal parameters")
  void customPutTest() {
    assertDoesNotThrow(() -> {
      client.customPut("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow put method for a custom path with all parameters")
  void customPutTest1() {
    assertDoesNotThrow(() -> {
      client.customPut(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("body", "parameters");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"body\":\"parameters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("deleteAgent")
  void deleteAgentTest() {
    assertDoesNotThrow(() -> {
      client.deleteAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteAgentConversations without filters")
  void deleteAgentConversationsTest() {
    assertDoesNotThrow(() -> {
      client.deleteAgentConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/conversations", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteAgentConversations with date filters")
  void deleteAgentConversationsTest1() {
    assertDoesNotThrow(() -> {
      client.deleteAgentConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "2024-01-01", "2024-06-30");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/conversations", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"startDate\":\"2024-01-01\",\"endDate\":\"2024-06-30\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("deleteConversation")
  void deleteConversationTest() {
    assertDoesNotThrow(() -> {
      client.deleteConversation("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "test-conversation-id");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/conversations/test-conversation-id", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteProvider")
  void deleteProviderTest() {
    assertDoesNotThrow(() -> {
      client.deleteProvider("5e33d805-7892-4329-bda7-b524dc3fd04a");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers/5e33d805-7892-4329-bda7-b524dc3fd04a", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteUserData")
  void deleteUserDataTest() {
    assertDoesNotThrow(() -> {
      client.deleteUserData("test-user-token");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/user-data/test-user-token", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("exportConversations without filters")
  void exportConversationsTest() {
    assertDoesNotThrow(() -> {
      client.exportConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/conversations/export", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("exportConversations with date filters")
  void exportConversationsTest1() {
    assertDoesNotThrow(() -> {
      client.exportConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "2024-01-01", "2024-12-31");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/conversations/export", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"startDate\":\"2024-01-01\",\"endDate\":\"2024-12-31\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("getAgent")
  void getAgentTest() {
    assertDoesNotThrow(() -> {
      client.getAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("e2e get agent")
  void getAgentTest1() {
    assertDoesNotThrow(() -> {
      client.getAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getApplicationConfiguration")
  void getApplicationConfigurationTest() {
    assertDoesNotThrow(() -> {
      client.getApplicationConfiguration();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/configuration", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("e2e getApplicationConfiguration")
  void getApplicationConfigurationTest1() {
    assertDoesNotThrow(() -> {
      client.getApplicationConfiguration();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/configuration", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getConversation")
  void getConversationTest() {
    assertDoesNotThrow(() -> {
      client.getConversation("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "test-conversation-id");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/conversations/test-conversation-id", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getProvider")
  void getProviderTest() {
    assertDoesNotThrow(() -> {
      client.getProvider("5e33d805-7892-4329-bda7-b524dc3fd04a");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers/5e33d805-7892-4329-bda7-b524dc3fd04a", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("e2e get provider")
  void getProviderTest1() {
    assertDoesNotThrow(() -> {
      client.getProvider("5e33d805-7892-4329-bda7-b524dc3fd04a");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers/5e33d805-7892-4329-bda7-b524dc3fd04a", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getUserData")
  void getUserDataTest() {
    assertDoesNotThrow(() -> {
      client.getUserData("test-user-token");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/user-data/test-user-token", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("invalidateAgentCache without before")
  void invalidateAgentCacheTest() {
    assertDoesNotThrow(() -> {
      client.invalidateAgentCache("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/cache", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("invalidateAgentCache with before date")
  void invalidateAgentCacheTest1() {
    assertDoesNotThrow(() -> {
      client.invalidateAgentCache("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "2024-12-01");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/cache", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"before\":\"2024-12-01\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("listAgentConversations with minimal parameters")
  void listAgentConversationsTest() {
    assertDoesNotThrow(() -> {
      client.listAgentConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/conversations", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listAgentConversations with all parameters")
  void listAgentConversationsTest1() {
    assertDoesNotThrow(() -> {
      client.listAgentConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "2024-01-01", "2024-12-31", 2, 10, null);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/conversations", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"startDate\":\"2024-01-01\",\"endDate\":\"2024-12-31\",\"page\":\"2\",\"limit\":\"10\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("list agents with no params")
  void listAgentsTest() {
    assertDoesNotThrow(() -> {
      client.listAgents();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("list agents with all parameters")
  void listAgentsTest1() {
    assertDoesNotThrow(() -> {
      client.listAgents(2, 5, "5e33d805-7892-4329-bda7-b524dc3fd04a");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"page\":\"2\",\"limit\":\"5\",\"providerId\":\"5e33d805-7892-4329-bda7-b524dc3fd04a\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("e2e list agents")
  void listAgentsTest2() {
    assertDoesNotThrow(() -> {
      client.listAgents(1, 2, null);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"page\":\"1\",\"limit\":\"2\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("listModels")
  void listModelsTest() {
    assertDoesNotThrow(() -> {
      client.listModels();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers/models", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("e2e list models")
  void listModelsTest1() {
    assertDoesNotThrow(() -> {
      client.listModels();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers/models", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listProviderModels")
  void listProviderModelsTest() {
    assertDoesNotThrow(() -> {
      client.listProviderModels("5e33d805-7892-4329-bda7-b524dc3fd04a");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers/5e33d805-7892-4329-bda7-b524dc3fd04a/models", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listProviders with no params")
  void listProvidersTest() {
    assertDoesNotThrow(() -> {
      client.listProviders();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listProviders with pagination")
  void listProvidersTest1() {
    assertDoesNotThrow(() -> {
      client.listProviders(2, 5);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"page\":\"2\",\"limit\":\"5\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("e2e list providers")
  void listProvidersTest2() {
    assertDoesNotThrow(() -> {
      client.listProviders(1, 2);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"page\":\"1\",\"limit\":\"2\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("publishAgent")
  void publishAgentTest() {
    assertDoesNotThrow(() -> {
      client.publishAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/publish", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("unpublishAgent")
  void unpublishAgentTest() {
    assertDoesNotThrow(() -> {
      client.unpublishAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff/unpublish", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("updateAgent with minimal parameters")
  void updateAgentTest() {
    assertDoesNotThrow(() -> {
      client.updateAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", new AgentConfigUpdate().setName("updated-agent-name"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"name\":\"updated-agent-name\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateAgent with all parameters")
  void updateAgentTest1() {
    assertDoesNotThrow(() -> {
      client.updateAgent(
        "785b14e4-61a8-4c03-8028-bf2ba3ae85ff",
        new AgentConfigUpdate()
          .setName("updated-agent")
          .setDescription("Updated description")
          .setProviderId("new-provider-id")
          .setModel("gpt-4o")
          .setInstructions("Updated instructions.")
          .setConfig(
            new HashMap() {
              {
                put("temperature", 0.5);
              }
            }
          )
          .setTools(Arrays.asList(new StartPart().setType("start")))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/agents/785b14e4-61a8-4c03-8028-bf2ba3ae85ff", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"name\":\"updated-agent\",\"description\":\"Updated" +
          " description\",\"providerId\":\"new-provider-id\",\"model\":\"gpt-4o\",\"instructions\":\"Updated" +
          " instructions.\",\"config\":{\"temperature\":0.5},\"tools\":[{\"type\":\"start\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("updateConfiguration")
  void updateConfigurationTest() {
    assertDoesNotThrow(() -> {
      client.updateConfiguration(new ApplicationConfigPatch().setMaxRetentionDays(30));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/configuration", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"maxRetentionDays\":30}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateProvider")
  void updateProviderTest() {
    assertDoesNotThrow(() -> {
      client.updateProvider("5e33d805-7892-4329-bda7-b524dc3fd04a", new ProviderAuthenticationPatch().setName("Updated Provider Name"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers/5e33d805-7892-4329-bda7-b524dc3fd04a", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"name\":\"Updated Provider Name\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateProvider with input")
  void updateProviderTest1() {
    assertDoesNotThrow(() -> {
      client.updateProvider(
        "5e33d805-7892-4329-bda7-b524dc3fd04a",
        new ProviderAuthenticationPatch().setName("Updated Provider").setInput(new OpenAIProviderInput().setApiKey("sk-new-key-5678"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/providers/5e33d805-7892-4329-bda7-b524dc3fd04a", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"name\":\"Updated Provider\",\"input\":{\"apiKey\":\"sk-new-key-5678\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }
}
