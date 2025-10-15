package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.IngestionClient;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.ingestion.*;
import java.util.*;

class SnippetIngestionClient {

  // Snippet for the createAuthentication method.
  //
  // createAuthenticationOAuth
  void snippetForCreateAuthentication() throws Exception {
    // >SEPARATOR createAuthentication createAuthenticationOAuth
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AuthenticationCreateResponse response = client.createAuthentication(
      new AuthenticationCreate()
        .setType(AuthenticationType.OAUTH)
        .setName("authName")
        .setInput(new AuthOAuth().setUrl("http://test.oauth").setClientId("myID").setClientSecret("mySecret"))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createAuthentication method.
  //
  // createAuthenticationAlgolia
  void snippetForCreateAuthentication1() throws Exception {
    // >SEPARATOR createAuthentication createAuthenticationAlgolia
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AuthenticationCreateResponse response = client.createAuthentication(
      new AuthenticationCreate()
        .setType(AuthenticationType.ALGOLIA)
        .setName("authName")
        .setInput(new AuthAlgolia().setAppID("ALGOLIA_APPLICATION_ID").setApiKey("ALGOLIA_API_KEY"))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createDestination method.
  //
  // createDestination
  void snippetForCreateDestination() throws Exception {
    // >SEPARATOR createDestination createDestination
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    DestinationCreateResponse response = client.createDestination(
      new DestinationCreate()
        .setType(DestinationType.SEARCH)
        .setName("destinationName")
        .setInput(new DestinationInput().setIndexName("<YOUR_INDEX_NAME>"))
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createDestination method.
  //
  // with transformationIDs
  void snippetForCreateDestination1() throws Exception {
    // >SEPARATOR createDestination with transformationIDs
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    DestinationCreateResponse response = client.createDestination(
      new DestinationCreate()
        .setType(DestinationType.SEARCH)
        .setName("destinationName")
        .setInput(new DestinationInput().setIndexName("<YOUR_INDEX_NAME>"))
        .setTransformationIDs(Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f"))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createSource method.
  //
  // createSource
  void snippetForCreateSource() throws Exception {
    // >SEPARATOR createSource createSource
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    SourceCreateResponse response = client.createSource(
      new SourceCreate()
        .setType(SourceType.COMMERCETOOLS)
        .setName("sourceName")
        .setInput(
          new SourceCommercetools()
            .setStoreKeys(Arrays.asList("myStore"))
            .setLocales(Arrays.asList("de"))
            .setUrl("http://commercetools.com")
            .setProjectKey("keyID")
            .setProductQueryPredicate("masterVariant(attributes(name=\"Brand\" and value=\"Algolia\"))")
        )
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createSource method.
  //
  // push
  void snippetForCreateSource1() throws Exception {
    // >SEPARATOR createSource push
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    SourceCreateResponse response = client.createSource(new SourceCreate().setType(SourceType.PUSH).setName("pushezpourentrer"));
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createTask method.
  //
  // task without cron
  void snippetForCreateTask() throws Exception {
    // >SEPARATOR createTask task without cron
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskCreateResponse response = client.createTask(
      new TaskCreate().setSourceID("search").setDestinationID("destinationID").setAction(ActionType.REPLACE)
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createTask method.
  //
  // task with cron
  void snippetForCreateTask1() throws Exception {
    // >SEPARATOR createTask task with cron
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskCreateResponse response = client.createTask(
      new TaskCreate()
        .setSourceID("search")
        .setDestinationID("destinationID")
        .setCron("* * * * *")
        .setAction(ActionType.REPLACE)
        .setNotifications(new Notifications().setEmail(new EmailNotifications().setEnabled(true)))
        .setPolicies(new Policies().setCriticalThreshold(8))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createTask method.
  //
  // task shopify
  void snippetForCreateTask2() throws Exception {
    // >SEPARATOR createTask task shopify
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskCreateResponse response = client.createTask(
      new TaskCreate()
        .setSourceID("search")
        .setDestinationID("destinationID")
        .setCron("* * * * *")
        .setAction(ActionType.REPLACE)
        .setInput(
          new DockerStreamsInput().setStreams(
            Arrays.asList(new DockerStreams().setName("foo").setSyncMode(DockerStreamsSyncMode.INCREMENTAL))
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createTaskV1 method.
  //
  // createTaskOnDemand
  void snippetForCreateTaskV1() throws Exception {
    // >SEPARATOR createTaskV1 createTaskOnDemand
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskCreateResponse response = client.createTaskV1(
      new TaskCreateV1()
        .setSourceID("search")
        .setDestinationID("destinationName")
        .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.ON_DEMAND))
        .setAction(ActionType.REPLACE)
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createTaskV1 method.
  //
  // createTaskSchedule
  void snippetForCreateTaskV11() throws Exception {
    // >SEPARATOR createTaskV1 createTaskSchedule
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskCreateResponse response = client.createTaskV1(
      new TaskCreateV1()
        .setSourceID("search")
        .setDestinationID("destinationName")
        .setTrigger(new ScheduleTriggerInput().setType(ScheduleTriggerType.SCHEDULE).setCron("* * * * *"))
        .setAction(ActionType.REPLACE)
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createTaskV1 method.
  //
  // createTaskSubscription
  void snippetForCreateTaskV12() throws Exception {
    // >SEPARATOR createTaskV1 createTaskSubscription
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskCreateResponse response = client.createTaskV1(
      new TaskCreateV1()
        .setSourceID("search")
        .setDestinationID("destinationName")
        .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.ON_DEMAND))
        .setAction(ActionType.REPLACE)
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createTaskV1 method.
  //
  // task shopify
  void snippetForCreateTaskV13() throws Exception {
    // >SEPARATOR createTaskV1 task shopify
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskCreateResponse response = client.createTaskV1(
      new TaskCreateV1()
        .setSourceID("search")
        .setDestinationID("destinationName")
        .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.ON_DEMAND))
        .setAction(ActionType.REPLACE)
        .setInput(
          new DockerStreamsInput().setStreams(
            Arrays.asList(new DockerStreams().setName("foo").setSyncMode(DockerStreamsSyncMode.INCREMENTAL))
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the createTransformation method.
  //
  // createTransformation
  void snippetForCreateTransformation() throws Exception {
    // >SEPARATOR createTransformation default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TransformationCreateResponse response = client.createTransformation(
      new TransformationCreate()
        .setInput(new TransformationCode().setCode("foo"))
        .setType(TransformationType.CODE)
        .setName("bar")
        .setDescription("baz")
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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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

  // Snippet for the deleteAuthentication method.
  //
  // deleteAuthentication
  void snippetForDeleteAuthentication() throws Exception {
    // >SEPARATOR deleteAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    DeleteResponse response = client.deleteAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the deleteDestination method.
  //
  // deleteDestination
  void snippetForDeleteDestination() throws Exception {
    // >SEPARATOR deleteDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    DeleteResponse response = client.deleteDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource
  void snippetForDeleteSource() throws Exception {
    // >SEPARATOR deleteSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    DeleteResponse response = client.deleteSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the deleteTask method.
  //
  // deleteTask
  void snippetForDeleteTask() throws Exception {
    // >SEPARATOR deleteTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    DeleteResponse response = client.deleteTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the deleteTaskV1 method.
  //
  // deleteTaskV1
  void snippetForDeleteTaskV1() throws Exception {
    // >SEPARATOR deleteTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    DeleteResponse response = client.deleteTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the deleteTransformation method.
  //
  // deleteTransformation
  void snippetForDeleteTransformation() throws Exception {
    // >SEPARATOR deleteTransformation default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    DeleteResponse response = client.deleteTransformation("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the disableTask method.
  //
  // disableTask
  void snippetForDisableTask() throws Exception {
    // >SEPARATOR disableTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskUpdateResponse response = client.disableTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the disableTaskV1 method.
  //
  // disableTaskV1
  void snippetForDisableTaskV1() throws Exception {
    // >SEPARATOR disableTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskUpdateResponse response = client.disableTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the enableTask method.
  //
  // enableTask
  void snippetForEnableTask() throws Exception {
    // >SEPARATOR enableTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskUpdateResponse response = client.enableTask("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the enableTaskV1 method.
  //
  // enableTaskV1
  void snippetForEnableTaskV1() throws Exception {
    // >SEPARATOR enableTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskUpdateResponse response = client.enableTaskV1("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getAuthentication method.
  //
  // getAuthentication
  void snippetForGetAuthentication() throws Exception {
    // >SEPARATOR getAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Authentication response = client.getAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getDestination method.
  //
  // getDestination
  void snippetForGetDestination() throws Exception {
    // >SEPARATOR getDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Destination response = client.getDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getEvent method.
  //
  // getEvent
  void snippetForGetEvent() throws Exception {
    // >SEPARATOR getEvent default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Event response = client.getEvent("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRun method.
  //
  // getRun
  void snippetForGetRun() throws Exception {
    // >SEPARATOR getRun default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Run response = client.getRun("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getSource method.
  //
  // getSource
  void snippetForGetSource() throws Exception {
    // >SEPARATOR getSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Source response = client.getSource("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTask method.
  //
  // getTask
  void snippetForGetTask() throws Exception {
    // >SEPARATOR getTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Task response = client.getTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTaskV1 method.
  //
  // getTaskV1
  void snippetForGetTaskV1() throws Exception {
    // >SEPARATOR getTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskV1 response = client.getTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTransformation method.
  //
  // getTransformation
  void snippetForGetTransformation() throws Exception {
    // >SEPARATOR getTransformation default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    Transformation response = client.getTransformation("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listAuthentications method.
  //
  // getAuthentications
  void snippetForListAuthentications() throws Exception {
    // >SEPARATOR listAuthentications getAuthentications
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ListAuthenticationsResponse response = client.listAuthentications();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listAuthentications method.
  //
  // getAuthentications with query params
  void snippetForListAuthentications1() throws Exception {
    // >SEPARATOR listAuthentications getAuthentications with query params
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ListAuthenticationsResponse response = client.listAuthentications(
      2,
      1,
      Arrays.asList(AuthenticationType.BASIC, AuthenticationType.ALGOLIA),
      Arrays.asList(PlatformNone.NONE),
      AuthenticationSortKeys.CREATED_AT,
      OrderKeys.ASC
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listDestinations method.
  //
  // getDestinations
  void snippetForListDestinations() throws Exception {
    // >SEPARATOR listDestinations default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ListDestinationsResponse response = client.listDestinations();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listEvents method.
  //
  // getEvents
  void snippetForListEvents() throws Exception {
    // >SEPARATOR listEvents default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ListEventsResponse response = client.listEvents("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listRuns method.
  //
  // listRuns
  void snippetForListRuns() throws Exception {
    // >SEPARATOR listRuns default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    RunListResponse response = client.listRuns();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listSources method.
  //
  // listSources
  void snippetForListSources() throws Exception {
    // >SEPARATOR listSources default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ListSourcesResponse response = client.listSources();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listTasks method.
  //
  // listTasks
  void snippetForListTasks() throws Exception {
    // >SEPARATOR listTasks default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ListTasksResponse response = client.listTasks();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listTasksV1 method.
  //
  // listTasksV1
  void snippetForListTasksV1() throws Exception {
    // >SEPARATOR listTasksV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ListTasksResponseV1 response = client.listTasksV1();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listTransformations method.
  //
  // listTransformations
  void snippetForListTransformations() throws Exception {
    // >SEPARATOR listTransformations listTransformations
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ListTransformationsResponse response = client.listTransformations();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listTransformations method.
  //
  // list with every parameters
  void snippetForListTransformations1() throws Exception {
    // >SEPARATOR listTransformations list with every parameters
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    ListTransformationsResponse response = client.listTransformations(
      2,
      1,
      TransformationSortKeys.CREATED_AT,
      OrderKeys.ASC,
      TransformationType.NO_CODE
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the push method.
  //
  // global push
  void snippetForPush() throws Exception {
    // >SEPARATOR push global push
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    WatchResponse response = client.push(
      "<YOUR_INDEX_NAME>",
      new PushTaskPayload()
        .setAction(Action.ADD_OBJECT)
        .setRecords(
          Arrays.asList(
            new PushTaskRecords().setAdditionalProperty("key", "bar").setAdditionalProperty("foo", "1").setObjectID("o"),
            new PushTaskRecords().setAdditionalProperty("key", "baz").setAdditionalProperty("foo", "2").setObjectID("k")
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the push method.
  //
  // global push with watch mode
  void snippetForPush1() throws Exception {
    // >SEPARATOR push global push with watch mode
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    WatchResponse response = client.push(
      "<YOUR_INDEX_NAME>",
      new PushTaskPayload()
        .setAction(Action.ADD_OBJECT)
        .setRecords(
          Arrays.asList(
            new PushTaskRecords().setAdditionalProperty("key", "bar").setAdditionalProperty("foo", "1").setObjectID("o"),
            new PushTaskRecords().setAdditionalProperty("key", "baz").setAdditionalProperty("foo", "2").setObjectID("k")
          )
        ),
      true,
      "foo"
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the pushTask method.
  //
  // pushTask
  void snippetForPushTask() throws Exception {
    // >SEPARATOR pushTask pushTask
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    WatchResponse response = client.pushTask(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new PushTaskPayload()
        .setAction(Action.ADD_OBJECT)
        .setRecords(
          Arrays.asList(
            new PushTaskRecords().setAdditionalProperty("key", "bar").setAdditionalProperty("foo", "1").setObjectID("o"),
            new PushTaskRecords().setAdditionalProperty("key", "baz").setAdditionalProperty("foo", "2").setObjectID("k")
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the pushTask method.
  //
  // allows for watch query parameter
  void snippetForPushTask1() throws Exception {
    // >SEPARATOR pushTask allows for watch query parameter
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    WatchResponse response = client.pushTask(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new PushTaskPayload()
        .setAction(Action.ADD_OBJECT)
        .setRecords(
          Arrays.asList(
            new PushTaskRecords().setAdditionalProperty("key", "bar").setAdditionalProperty("foo", "1").setObjectID("o"),
            new PushTaskRecords().setAdditionalProperty("key", "baz").setAdditionalProperty("foo", "2").setObjectID("k")
          )
        ),
      true
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the replaceTask method.
  //
  // fully replace task without cron
  void snippetForReplaceTask() throws Exception {
    // >SEPARATOR replaceTask fully replace task without cron
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskUpdateResponse response = client.replaceTask(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TaskReplace().setDestinationID("destinationID").setAction(ActionType.REPLACE)
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the replaceTask method.
  //
  // fully replace task with cron
  void snippetForReplaceTask1() throws Exception {
    // >SEPARATOR replaceTask fully replace task with cron
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskUpdateResponse response = client.replaceTask(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TaskReplace()
        .setDestinationID("destinationID")
        .setCron("* * * * *")
        .setAction(ActionType.REPLACE)
        .setNotifications(new Notifications().setEmail(new EmailNotifications().setEnabled(true)))
        .setPolicies(new Policies().setCriticalThreshold(8))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the replaceTask method.
  //
  // fully replace task shopify
  void snippetForReplaceTask2() throws Exception {
    // >SEPARATOR replaceTask fully replace task shopify
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskUpdateResponse response = client.replaceTask(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TaskReplace()
        .setDestinationID("destinationID")
        .setCron("* * * * *")
        .setAction(ActionType.REPLACE)
        .setInput(
          new DockerStreamsInput().setStreams(
            Arrays.asList(new DockerStreams().setName("foo").setSyncMode(DockerStreamsSyncMode.INCREMENTAL))
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the runSource method.
  //
  // runSource
  void snippetForRunSource() throws Exception {
    // >SEPARATOR runSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    RunSourceResponse response = client.runSource(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new RunSourcePayload()
        .setIndexToInclude(Arrays.asList("products_us", "products eu"))
        .setEntityIDs(Arrays.asList("1234", "5678"))
        .setEntityType(EntityType.PRODUCT)
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the runTask method.
  //
  // runTask
  void snippetForRunTask() throws Exception {
    // >SEPARATOR runTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    RunResponse response = client.runTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the runTaskV1 method.
  //
  // runTaskV1
  void snippetForRunTaskV1() throws Exception {
    // >SEPARATOR runTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    RunResponse response = client.runTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the searchAuthentications method.
  //
  // searchAuthentications
  void snippetForSearchAuthentications() throws Exception {
    // >SEPARATOR searchAuthentications default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    List response = client.searchAuthentications(
      new AuthenticationSearch().setAuthenticationIDs(
        Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the searchDestinations method.
  //
  // searchDestinations
  void snippetForSearchDestinations() throws Exception {
    // >SEPARATOR searchDestinations default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    List response = client.searchDestinations(
      new DestinationSearch().setDestinationIDs(
        Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the searchSources method.
  //
  // searchSources
  void snippetForSearchSources() throws Exception {
    // >SEPARATOR searchSources default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    List response = client.searchSources(
      new SourceSearch().setSourceIDs(Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the searchTasks method.
  //
  // searchTasks
  void snippetForSearchTasks() throws Exception {
    // >SEPARATOR searchTasks default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    List response = client.searchTasks(
      new TaskSearch().setTaskIDs(
        Arrays.asList(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the searchTasksV1 method.
  //
  // searchTasksV1
  void snippetForSearchTasksV1() throws Exception {
    // >SEPARATOR searchTasksV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    List response = client.searchTasksV1(
      new TaskSearch().setTaskIDs(
        Arrays.asList(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the searchTransformations method.
  //
  // searchTransformations
  void snippetForSearchTransformations() throws Exception {
    // >SEPARATOR searchTransformations default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    List response = client.searchTransformations(
      new TransformationSearch().setTransformationIDs(
        Arrays.asList(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    );
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
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the triggerDockerSourceDiscover method.
  //
  // triggerDockerSourceDiscover
  void snippetForTriggerDockerSourceDiscover() throws Exception {
    // >SEPARATOR triggerDockerSourceDiscover default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    WatchResponse response = client.triggerDockerSourceDiscover("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the tryTransformation method.
  //
  // tryTransformation
  void snippetForTryTransformation() throws Exception {
    // >SEPARATOR tryTransformation tryTransformation
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TransformationTryResponse response = client.tryTransformation(
      new TransformationTry()
        .setType(TransformationType.CODE)
        .setInput(new TransformationCode().setCode("foo"))
        .setSampleRecord(
          new HashMap() {
            {
              put("bar", "baz");
            }
          }
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the tryTransformation method.
  //
  // with authentications
  void snippetForTryTransformation1() throws Exception {
    // >SEPARATOR tryTransformation with authentications
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TransformationTryResponse response = client.tryTransformation(
      new TransformationTry()
        .setType(TransformationType.CODE)
        .setInput(new TransformationCode().setCode("foo"))
        .setSampleRecord(
          new HashMap() {
            {
              put("bar", "baz");
            }
          }
        )
        .setAuthentications(
          Arrays.asList(
            new AuthenticationCreate()
              .setType(AuthenticationType.OAUTH)
              .setName("authName")
              .setInput(new AuthOAuth().setUrl("http://test.oauth").setClientId("myID").setClientSecret("mySecret"))
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the tryTransformationBeforeUpdate method.
  //
  // tryTransformationBeforeUpdate
  void snippetForTryTransformationBeforeUpdate() throws Exception {
    // >SEPARATOR tryTransformationBeforeUpdate tryTransformationBeforeUpdate
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TransformationTryResponse response = client.tryTransformationBeforeUpdate(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TransformationTry()
        .setType(TransformationType.CODE)
        .setInput(new TransformationCode().setCode("foo"))
        .setSampleRecord(
          new HashMap() {
            {
              put("bar", "baz");
            }
          }
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the tryTransformationBeforeUpdate method.
  //
  // existing with authentications
  void snippetForTryTransformationBeforeUpdate1() throws Exception {
    // >SEPARATOR tryTransformationBeforeUpdate existing with authentications
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TransformationTryResponse response = client.tryTransformationBeforeUpdate(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TransformationTry()
        .setType(TransformationType.CODE)
        .setInput(new TransformationCode().setCode("foo"))
        .setSampleRecord(
          new HashMap() {
            {
              put("bar", "baz");
            }
          }
        )
        .setAuthentications(
          Arrays.asList(
            new AuthenticationCreate()
              .setType(AuthenticationType.OAUTH)
              .setName("authName")
              .setInput(new AuthOAuth().setUrl("http://test.oauth").setClientId("myID").setClientSecret("mySecret"))
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateAuthentication method.
  //
  // updateAuthentication
  void snippetForUpdateAuthentication() throws Exception {
    // >SEPARATOR updateAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    AuthenticationUpdateResponse response = client.updateAuthentication(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new AuthenticationUpdate().setName("newName")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateDestination method.
  //
  // updateDestination
  void snippetForUpdateDestination() throws Exception {
    // >SEPARATOR updateDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    DestinationUpdateResponse response = client.updateDestination(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new DestinationUpdate().setName("newName")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateSource method.
  //
  // updateSource
  void snippetForUpdateSource() throws Exception {
    // >SEPARATOR updateSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    SourceUpdateResponse response = client.updateSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new SourceUpdate().setName("newName"));
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateTask method.
  //
  // updateTask
  void snippetForUpdateTask() throws Exception {
    // >SEPARATOR updateTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskUpdateResponse response = client.updateTask(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TaskUpdate().setEnabled(false).setCron("* * * * *")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateTaskV1 method.
  //
  // updateTaskV1
  void snippetForUpdateTaskV1() throws Exception {
    // >SEPARATOR updateTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TaskUpdateResponse response = client.updateTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new TaskUpdateV1().setEnabled(false));
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the updateTransformation method.
  //
  // updateTransformation
  void snippetForUpdateTransformation() throws Exception {
    // >SEPARATOR updateTransformation default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    TransformationUpdateResponse response = client.updateTransformation(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TransformationCreate()
        .setInput(new TransformationCode().setCode("foo"))
        .setType(TransformationType.CODE)
        .setName("bar")
        .setDescription("baz")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the validateSource method.
  //
  // validateSource
  void snippetForValidateSource() throws Exception {
    // >SEPARATOR validateSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    WatchResponse response = client.validateSource(
      new SourceCreate()
        .setType(SourceType.COMMERCETOOLS)
        .setName("sourceName")
        .setInput(
          new SourceCommercetools()
            .setStoreKeys(Arrays.asList("myStore"))
            .setLocales(Arrays.asList("de"))
            .setUrl("http://commercetools.com")
            .setProjectKey("keyID")
        )
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the validateSourceBeforeUpdate method.
  //
  // validateSourceBeforeUpdate
  void snippetForValidateSourceBeforeUpdate() throws Exception {
    // >SEPARATOR validateSourceBeforeUpdate default
    // Initialize the client
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    WatchResponse response = client.validateSourceBeforeUpdate(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new SourceUpdate().setName("newName")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }
}
