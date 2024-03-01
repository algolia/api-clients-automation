package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
)

func SnippetForCreateAuthenticationOfIngestion() {
	/*
	   Snippet for the createAuthentication method.

	   createAuthenticationOAuth
	*/

	// >SEPARATOR createAuthentication
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CreateAuthentication(client.NewApiCreateAuthenticationRequest(

		ingestion.NewEmptyAuthenticationCreate().SetType(ingestion.AuthenticationType("oauth")).SetName("authName").SetInput(ingestion.AuthOAuthAsAuthInput(
			ingestion.NewEmptyAuthOAuth().SetUrl("http://test.oauth").SetClientId("myID").SetClientSecret("mySecret"))),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCreateDestinationOfIngestion() {
	/*
	   Snippet for the createDestination method.

	   createDestination
	*/

	// >SEPARATOR createDestination
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CreateDestination(client.NewApiCreateDestinationRequest(

		ingestion.NewEmptyDestinationCreate().SetType(ingestion.DestinationType("search")).SetName("destinationName").SetInput(ingestion.DestinationIndexPrefixAsDestinationInput(
			ingestion.NewEmptyDestinationIndexPrefix().SetIndexPrefix("prefix_"))).SetAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCreateSourceOfIngestion() {
	/*
	   Snippet for the createSource method.

	   createSource
	*/

	// >SEPARATOR createSource
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CreateSource(client.NewApiCreateSourceRequest(

		ingestion.NewEmptySourceCreate().SetType(ingestion.SourceType("commercetools")).SetName("sourceName").SetInput(ingestion.SourceCommercetoolsAsSourceInput(
			ingestion.NewEmptySourceCommercetools().SetStoreKeys(
				[]string{"myStore"}).SetLocales(
				[]string{"de"}).SetUrl("http://commercetools.com").SetProjectKey("keyID"))).SetAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCreateTaskOfIngestion() {
	/*
	   Snippet for the createTask method.

	   createTaskOnDemand
	*/

	// >SEPARATOR createTask
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CreateTask(client.NewApiCreateTaskRequest(

		ingestion.NewEmptyTaskCreate().SetSourceID("search").SetDestinationID("destinationName").SetTrigger(ingestion.OnDemandTriggerInputAsTaskCreateTrigger(
			ingestion.NewEmptyOnDemandTriggerInput().SetType(ingestion.OnDemandTriggerType("onDemand")))).SetAction(ingestion.ActionType("replace")),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCustomDeleteOfIngestion() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// >SEPARATOR customDelete
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCustomGetOfIngestion() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// >SEPARATOR customGet
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomGet(client.NewApiCustomGetRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCustomPostOfIngestion() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPost
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomPost(client.NewApiCustomPostRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCustomPutOfIngestion() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPut
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomPut(client.NewApiCustomPutRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteAuthenticationOfIngestion() {
	/*
	   Snippet for the deleteAuthentication method.

	   deleteAuthentication
	*/

	// >SEPARATOR deleteAuthentication
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteAuthentication(client.NewApiDeleteAuthenticationRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteDestinationOfIngestion() {
	/*
	   Snippet for the deleteDestination method.

	   deleteDestination
	*/

	// >SEPARATOR deleteDestination
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteDestination(client.NewApiDeleteDestinationRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteSourceOfIngestion() {
	/*
	   Snippet for the deleteSource method.

	   deleteSource
	*/

	// >SEPARATOR deleteSource
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteSource(client.NewApiDeleteSourceRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteTaskOfIngestion() {
	/*
	   Snippet for the deleteTask method.

	   deleteTask
	*/

	// >SEPARATOR deleteTask
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteTask(client.NewApiDeleteTaskRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDisableTaskOfIngestion() {
	/*
	   Snippet for the disableTask method.

	   disableTask
	*/

	// >SEPARATOR disableTask
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DisableTask(client.NewApiDisableTaskRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForEnableTaskOfIngestion() {
	/*
	   Snippet for the enableTask method.

	   enable task e2e
	*/

	// >SEPARATOR enableTask
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.EnableTask(client.NewApiEnableTaskRequest(
		"76ab4c2a-ce17-496f-b7a6-506dc59ee498",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetAuthenticationOfIngestion() {
	/*
	   Snippet for the getAuthentication method.

	   getAuthentication
	*/

	// >SEPARATOR getAuthentication
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetAuthentication(client.NewApiGetAuthenticationRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetAuthenticationsOfIngestion() {
	/*
	   Snippet for the getAuthentications method.

	   getAuthentications
	*/

	// >SEPARATOR getAuthentications
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetAuthentications(client.NewApiGetAuthenticationsRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetDestinationOfIngestion() {
	/*
	   Snippet for the getDestination method.

	   getDestination
	*/

	// >SEPARATOR getDestination
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetDestination(client.NewApiGetDestinationRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetDestinationsOfIngestion() {
	/*
	   Snippet for the getDestinations method.

	   getDestinations
	*/

	// >SEPARATOR getDestinations
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetDestinations(client.NewApiGetDestinationsRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetDockerSourceStreamsOfIngestion() {
	/*
	   Snippet for the getDockerSourceStreams method.

	   getDockerSourceStreams
	*/

	// >SEPARATOR getDockerSourceStreams
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetDockerSourceStreams(client.NewApiGetDockerSourceStreamsRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetEventOfIngestion() {
	/*
	   Snippet for the getEvent method.

	   getEvent
	*/

	// >SEPARATOR getEvent
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetEvent(client.NewApiGetEventRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetEventsOfIngestion() {
	/*
	   Snippet for the getEvents method.

	   getEvents
	*/

	// >SEPARATOR getEvents
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetEvents(client.NewApiGetEventsRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetRunOfIngestion() {
	/*
	   Snippet for the getRun method.

	   getRun
	*/

	// >SEPARATOR getRun
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetRun(client.NewApiGetRunRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetRunsOfIngestion() {
	/*
	   Snippet for the getRuns method.

	   getRuns
	*/

	// >SEPARATOR getRuns
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetRuns(client.NewApiGetRunsRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetSourceOfIngestion() {
	/*
	   Snippet for the getSource method.

	   getSource
	*/

	// >SEPARATOR getSource
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetSource(client.NewApiGetSourceRequest(
		"75eeb306-51d3-4e5e-a279-3c92bd8893ac",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetSourcesOfIngestion() {
	/*
	   Snippet for the getSources method.

	   getSources
	*/

	// >SEPARATOR getSources
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetSources(client.NewApiGetSourcesRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetTaskOfIngestion() {
	/*
	   Snippet for the getTask method.

	   getTask
	*/

	// >SEPARATOR getTask
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTask(client.NewApiGetTaskRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetTasksOfIngestion() {
	/*
	   Snippet for the getTasks method.

	   getTasks
	*/

	// >SEPARATOR getTasks
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTasks(client.NewApiGetTasksRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForRunTaskOfIngestion() {
	/*
	   Snippet for the runTask method.

	   runTask
	*/

	// >SEPARATOR runTask
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.RunTask(client.NewApiRunTaskRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchAuthenticationsOfIngestion() {
	/*
	   Snippet for the searchAuthentications method.

	   searchAuthentications
	*/

	// >SEPARATOR searchAuthentications
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchAuthentications(client.NewApiSearchAuthenticationsRequest(

		ingestion.NewEmptyAuthenticationSearch().SetAuthenticationIDs(
			[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchDestinationsOfIngestion() {
	/*
	   Snippet for the searchDestinations method.

	   searchDestinations
	*/

	// >SEPARATOR searchDestinations
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchDestinations(client.NewApiSearchDestinationsRequest(

		ingestion.NewEmptyDestinationSearch().SetDestinationIDs(
			[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchSourcesOfIngestion() {
	/*
	   Snippet for the searchSources method.

	   searchSources
	*/

	// >SEPARATOR searchSources
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchSources(client.NewApiSearchSourcesRequest(

		ingestion.NewEmptySourceSearch().SetSourceIDs(
			[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchTasksOfIngestion() {
	/*
	   Snippet for the searchTasks method.

	   searchTasks
	*/

	// >SEPARATOR searchTasks
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchTasks(client.NewApiSearchTasksRequest(

		ingestion.NewEmptyTaskSearch().SetTaskIDs(
			[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForTriggerDockerSourceDiscoverOfIngestion() {
	/*
	   Snippet for the triggerDockerSourceDiscover method.

	   triggerDockerSourceDiscover
	*/

	// >SEPARATOR triggerDockerSourceDiscover
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.TriggerDockerSourceDiscover(client.NewApiTriggerDockerSourceDiscoverRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForUpdateAuthenticationOfIngestion() {
	/*
	   Snippet for the updateAuthentication method.

	   updateAuthentication
	*/

	// >SEPARATOR updateAuthentication
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.UpdateAuthentication(client.NewApiUpdateAuthenticationRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		ingestion.NewEmptyAuthenticationUpdate().SetName("newName"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForUpdateDestinationOfIngestion() {
	/*
	   Snippet for the updateDestination method.

	   updateDestination
	*/

	// >SEPARATOR updateDestination
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.UpdateDestination(client.NewApiUpdateDestinationRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		ingestion.NewEmptyDestinationUpdate().SetName("newName"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForUpdateSourceOfIngestion() {
	/*
	   Snippet for the updateSource method.

	   updateSource
	*/

	// >SEPARATOR updateSource
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.UpdateSource(client.NewApiUpdateSourceRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		ingestion.NewEmptySourceUpdate().SetName("newName"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForUpdateTaskOfIngestion() {
	/*
	   Snippet for the updateTask method.

	   updateTask
	*/

	// >SEPARATOR updateTask
	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.UpdateTask(client.NewApiUpdateTaskRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		ingestion.NewEmptyTaskUpdate().SetEnabled(false),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
