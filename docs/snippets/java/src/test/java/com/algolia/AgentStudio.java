package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.AgentStudioClient;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.agentstudio.*;
import java.util.*;

class SnippetAgentStudioClient {

  // Snippet for the createAgent method.
  //
  // createAgent with minimal parameters
  void snippetForCreateAgent() throws Exception {
    // >SEPARATOR createAgent createAgent with minimal parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentWithVersionResponse response = client.createAgent(
      new AgentConfigCreate().setName("test-agent").setInstructions("You are a helpful assistant.")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createAgent method.
  //
  // createAgent with all parameters
  void snippetForCreateAgent1() throws Exception {
    // >SEPARATOR createAgent createAgent with all parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentWithVersionResponse response = client.createAgent(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createAgentCompletion method.
  //
  // createAgentCompletion with v4 messages
  void snippetForCreateAgentCompletion() throws Exception {
    // >SEPARATOR createAgentCompletion createAgentCompletion with v4 messages
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentCompletionResponse response = client.createAgentCompletion(
      "785b14e4-61a8-4c03-8028-bf2ba3ae85ff",
      CompatibilityMode.AI_SDK_4,
      new AgentCompletionRequest().setMessages(
        MessagesUnion.ofListOfMessageV4(Arrays.asList(new UserMessageV4().setRole("user").setContent("Hello, how are you?")))
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createAgentCompletion method.
  //
  // createAgentCompletion with v5 messages and all query params
  void snippetForCreateAgentCompletion1() throws Exception {
    // >SEPARATOR createAgentCompletion createAgentCompletion with v5 messages and all query params
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentCompletionResponse response = client.createAgentCompletion(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createAgentCompletion method.
  //
  // createAgentCompletion with test configuration
  void snippetForCreateAgentCompletion2() throws Exception {
    // >SEPARATOR createAgentCompletion createAgentCompletion with test configuration
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentCompletionResponse response = client.createAgentCompletion(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createProvider method.
  //
  // createProvider with OpenAI
  void snippetForCreateProvider() throws Exception {
    // >SEPARATOR createProvider createProvider with OpenAI
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ProviderAuthenticationResponse response = client.createProvider(
      new ProviderAuthenticationCreate()
        .setName("My OpenAI Provider")
        .setProviderName(ProviderName.OPENAI)
        .setInput(new OpenAIProviderInput().setApiKey("sk-test-key-1234"))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createProvider method.
  //
  // createProvider with Azure OpenAI
  void snippetForCreateProvider1() throws Exception {
    // >SEPARATOR createProvider createProvider with Azure OpenAI
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ProviderAuthenticationResponse response = client.createProvider(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customDelete("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with all parameters
  void snippetForCustomDelete1() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customDelete(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customGet("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with all parameters
  void snippetForCustomGet1() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters with space");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // requestOptions should be escaped too
  void snippetForCustomGet2() throws Exception {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customGet(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with all parameters
  void snippetForCustomPost1() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default query parameters
  void snippetForCustomPost2() throws Exception {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges query parameters with default ones
  void snippetForCustomPost3() throws Exception {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default headers
  void snippetForCustomPost4() throws Exception {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges headers with default ones
  void snippetForCustomPost5() throws Exception {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts booleans
  void snippetForCustomPost6() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts integers
  void snippetForCustomPost7() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of string
  void snippetForCustomPost8() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of booleans
  void snippetForCustomPost9() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of integers
  void snippetForCustomPost10() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPut("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with all parameters
  void snippetForCustomPut1() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Object response = client.customPut(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the deleteAgent method.
  //
  // deleteAgent
  void snippetForDeleteAgent() throws Exception {
    // >SEPARATOR deleteAgent default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.deleteAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteAgentConversations method.
  //
  // deleteAgentConversations without filters
  void snippetForDeleteAgentConversations() throws Exception {
    // >SEPARATOR deleteAgentConversations deleteAgentConversations without filters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.deleteAgentConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteAgentConversations method.
  //
  // deleteAgentConversations with date filters
  void snippetForDeleteAgentConversations1() throws Exception {
    // >SEPARATOR deleteAgentConversations deleteAgentConversations with date filters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.deleteAgentConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "2024-01-01", "2024-06-30");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteConversation method.
  //
  // deleteConversation
  void snippetForDeleteConversation() throws Exception {
    // >SEPARATOR deleteConversation default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.deleteConversation("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "test-conversation-id");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteProvider method.
  //
  // deleteProvider
  void snippetForDeleteProvider() throws Exception {
    // >SEPARATOR deleteProvider default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.deleteProvider("5e33d805-7892-4329-bda7-b524dc3fd04a");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteUserData method.
  //
  // deleteUserData
  void snippetForDeleteUserData() throws Exception {
    // >SEPARATOR deleteUserData default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.deleteUserData("test-user-token");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the exportConversations method.
  //
  // exportConversations without filters
  void snippetForExportConversations() throws Exception {
    // >SEPARATOR exportConversations exportConversations without filters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    List response = client.exportConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the exportConversations method.
  //
  // exportConversations with date filters
  void snippetForExportConversations1() throws Exception {
    // >SEPARATOR exportConversations exportConversations with date filters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    List response = client.exportConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "2024-01-01", "2024-12-31");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getAgent method.
  //
  // getAgent
  void snippetForGetAgent() throws Exception {
    // >SEPARATOR getAgent getAgent
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentWithVersionResponse response = client.getAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getAgent method.
  //
  // e2e get agent
  void snippetForGetAgent1() throws Exception {
    // >SEPARATOR getAgent e2e get agent
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentWithVersionResponse response = client.getAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getApplicationConfiguration method.
  //
  // getApplicationConfiguration
  void snippetForGetApplicationConfiguration() throws Exception {
    // >SEPARATOR getApplicationConfiguration getApplicationConfiguration
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ApplicationConfigResponse response = client.getApplicationConfiguration();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getApplicationConfiguration method.
  //
  // e2e getApplicationConfiguration
  void snippetForGetApplicationConfiguration1() throws Exception {
    // >SEPARATOR getApplicationConfiguration e2e getApplicationConfiguration
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ApplicationConfigResponse response = client.getApplicationConfiguration();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getConversation method.
  //
  // getConversation
  void snippetForGetConversation() throws Exception {
    // >SEPARATOR getConversation default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ConversationFullResponse response = client.getConversation("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "test-conversation-id");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getProvider method.
  //
  // getProvider
  void snippetForGetProvider() throws Exception {
    // >SEPARATOR getProvider getProvider
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ProviderAuthenticationResponse response = client.getProvider("5e33d805-7892-4329-bda7-b524dc3fd04a");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getProvider method.
  //
  // e2e get provider
  void snippetForGetProvider1() throws Exception {
    // >SEPARATOR getProvider e2e get provider
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ProviderAuthenticationResponse response = client.getProvider("5e33d805-7892-4329-bda7-b524dc3fd04a");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getUserData method.
  //
  // getUserData
  void snippetForGetUserData() throws Exception {
    // >SEPARATOR getUserData default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    UserDataResponse response = client.getUserData("test-user-token");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the invalidateAgentCache method.
  //
  // invalidateAgentCache without before
  void snippetForInvalidateAgentCache() throws Exception {
    // >SEPARATOR invalidateAgentCache invalidateAgentCache without before
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.invalidateAgentCache("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the invalidateAgentCache method.
  //
  // invalidateAgentCache with before date
  void snippetForInvalidateAgentCache1() throws Exception {
    // >SEPARATOR invalidateAgentCache invalidateAgentCache with before date
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.invalidateAgentCache("785b14e4-61a8-4c03-8028-bf2ba3ae85ff", "2024-12-01");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listAgentConversations method.
  //
  // listAgentConversations with minimal parameters
  void snippetForListAgentConversations() throws Exception {
    // >SEPARATOR listAgentConversations listAgentConversations with minimal parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    PaginatedConversationsResponse response = client.listAgentConversations("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listAgentConversations method.
  //
  // listAgentConversations with all parameters
  void snippetForListAgentConversations1() throws Exception {
    // >SEPARATOR listAgentConversations listAgentConversations with all parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    PaginatedConversationsResponse response = client.listAgentConversations(
      "785b14e4-61a8-4c03-8028-bf2ba3ae85ff",
      "2024-01-01",
      "2024-12-31",
      2,
      10,
      null
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listAgents method.
  //
  // list agents with no params
  void snippetForListAgents() throws Exception {
    // >SEPARATOR listAgents list agents with no params
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    PaginatedAgentsResponse response = client.listAgents();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listAgents method.
  //
  // list agents with all parameters
  void snippetForListAgents1() throws Exception {
    // >SEPARATOR listAgents list agents with all parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    PaginatedAgentsResponse response = client.listAgents(2, 5, "5e33d805-7892-4329-bda7-b524dc3fd04a");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listAgents method.
  //
  // e2e list agents
  void snippetForListAgents2() throws Exception {
    // >SEPARATOR listAgents e2e list agents
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    PaginatedAgentsResponse response = client.listAgents(1, 2, null);
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listModels method.
  //
  // listModels
  void snippetForListModels() throws Exception {
    // >SEPARATOR listModels listModels
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Map response = client.listModels();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listModels method.
  //
  // e2e list models
  void snippetForListModels1() throws Exception {
    // >SEPARATOR listModels e2e list models
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Map response = client.listModels();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listProviderModels method.
  //
  // listProviderModels
  void snippetForListProviderModels() throws Exception {
    // >SEPARATOR listProviderModels default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    List response = client.listProviderModels("5e33d805-7892-4329-bda7-b524dc3fd04a");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listProviders method.
  //
  // listProviders with no params
  void snippetForListProviders() throws Exception {
    // >SEPARATOR listProviders listProviders with no params
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    PaginatedProviderAuthenticationsResponse response = client.listProviders();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listProviders method.
  //
  // listProviders with pagination
  void snippetForListProviders1() throws Exception {
    // >SEPARATOR listProviders listProviders with pagination
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    PaginatedProviderAuthenticationsResponse response = client.listProviders(2, 5);
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listProviders method.
  //
  // e2e list providers
  void snippetForListProviders2() throws Exception {
    // >SEPARATOR listProviders e2e list providers
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    PaginatedProviderAuthenticationsResponse response = client.listProviders(1, 2);
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the publishAgent method.
  //
  // publishAgent
  void snippetForPublishAgent() throws Exception {
    // >SEPARATOR publishAgent default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentWithVersionResponse response = client.publishAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() throws Exception {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the unpublishAgent method.
  //
  // unpublishAgent
  void snippetForUnpublishAgent() throws Exception {
    // >SEPARATOR unpublishAgent default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentWithVersionResponse response = client.unpublishAgent("785b14e4-61a8-4c03-8028-bf2ba3ae85ff");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateAgent method.
  //
  // updateAgent with minimal parameters
  void snippetForUpdateAgent() throws Exception {
    // >SEPARATOR updateAgent updateAgent with minimal parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentWithVersionResponse response = client.updateAgent(
      "785b14e4-61a8-4c03-8028-bf2ba3ae85ff",
      new AgentConfigUpdate().setName("updated-agent-name")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateAgent method.
  //
  // updateAgent with all parameters
  void snippetForUpdateAgent1() throws Exception {
    // >SEPARATOR updateAgent updateAgent with all parameters
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AgentWithVersionResponse response = client.updateAgent(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateConfiguration method.
  //
  // updateConfiguration
  void snippetForUpdateConfiguration() throws Exception {
    // >SEPARATOR updateConfiguration default
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ApplicationConfigResponse response = client.updateConfiguration(new ApplicationConfigPatch().setMaxRetentionDays(30));
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateProvider method.
  //
  // updateProvider
  void snippetForUpdateProvider() throws Exception {
    // >SEPARATOR updateProvider updateProvider
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ProviderAuthenticationResponse response = client.updateProvider(
      "5e33d805-7892-4329-bda7-b524dc3fd04a",
      new ProviderAuthenticationPatch().setName("Updated Provider Name")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateProvider method.
  //
  // updateProvider with input
  void snippetForUpdateProvider1() throws Exception {
    // >SEPARATOR updateProvider updateProvider with input
    // Initialize the client
    AgentStudioClient client = new AgentStudioClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ProviderAuthenticationResponse response = client.updateProvider(
      "5e33d805-7892-4329-bda7-b524dc3fd04a",
      new ProviderAuthenticationPatch().setName("Updated Provider").setInput(new OpenAIProviderInput().setApiKey("sk-new-key-5678"))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }
}
