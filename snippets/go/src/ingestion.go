package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
)

func SnippetForCreateAuthenticationOfIngestion() {
	/*
	   Snippet for the createAuthentication method.

	   createAuthenticationOAuth
	*/

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
}
func SnippetForCreateDestinationOfIngestion() {
	/*
	   Snippet for the createDestination method.

	   createDestination
	*/

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
}
func SnippetForCreateSourceOfIngestion() {
	/*
	   Snippet for the createSource method.

	   createSource
	*/

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
}
func SnippetForCreateTaskOfIngestion() {
	/*
	   Snippet for the createTask method.

	   createTaskOnDemand
	*/

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
}
func SnippetForCustomDeleteOfIngestion() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

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
}
func SnippetForCustomGetOfIngestion() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

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
}
func SnippetForCustomPostOfIngestion() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

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
}
func SnippetForCustomPutOfIngestion() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

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
}
func SnippetForDeleteAuthenticationOfIngestion() {
	/*
	   Snippet for the deleteAuthentication method.

	   deleteAuthentication
	*/

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
}
func SnippetForDeleteDestinationOfIngestion() {
	/*
	   Snippet for the deleteDestination method.

	   deleteDestination
	*/

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
}
func SnippetForDeleteSourceOfIngestion() {
	/*
	   Snippet for the deleteSource method.

	   deleteSource
	*/

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
}
func SnippetForDeleteTaskOfIngestion() {
	/*
	   Snippet for the deleteTask method.

	   deleteTask
	*/

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
}
func SnippetForDisableTaskOfIngestion() {
	/*
	   Snippet for the disableTask method.

	   disableTask
	*/

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
}
func SnippetForEnableTaskOfIngestion() {
	/*
	   Snippet for the enableTask method.

	   enableTask
	*/

	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.EnableTask(client.NewApiEnableTaskRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetAuthenticationOfIngestion() {
	/*
	   Snippet for the getAuthentication method.

	   getAuthentication
	*/

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
}
func SnippetForGetAuthenticationsOfIngestion() {
	/*
	   Snippet for the getAuthentications method.

	   getAuthentications
	*/

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
}
func SnippetForGetDestinationOfIngestion() {
	/*
	   Snippet for the getDestination method.

	   getDestination
	*/

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
}
func SnippetForGetDestinationsOfIngestion() {
	/*
	   Snippet for the getDestinations method.

	   getDestinations
	*/

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
}
func SnippetForGetDockerSourceStreamsOfIngestion() {
	/*
	   Snippet for the getDockerSourceStreams method.

	   getDockerSourceStreams
	*/

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
}
func SnippetForGetEventOfIngestion() {
	/*
	   Snippet for the getEvent method.

	   getEvent
	*/

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
}
func SnippetForGetEventsOfIngestion() {
	/*
	   Snippet for the getEvents method.

	   getEvents
	*/

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
}
func SnippetForGetRunOfIngestion() {
	/*
	   Snippet for the getRun method.

	   getRun
	*/

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
}
func SnippetForGetRunsOfIngestion() {
	/*
	   Snippet for the getRuns method.

	   getRuns
	*/

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
}
func SnippetForGetSourceOfIngestion() {
	/*
	   Snippet for the getSource method.

	   getSource
	*/

	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetSource(client.NewApiGetSourceRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetSourcesOfIngestion() {
	/*
	   Snippet for the getSources method.

	   getSources
	*/

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
}
func SnippetForGetTaskOfIngestion() {
	/*
	   Snippet for the getTask method.

	   getTask
	*/

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
}
func SnippetForGetTasksOfIngestion() {
	/*
	   Snippet for the getTasks method.

	   getTasks
	*/

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
}
func SnippetForRunTaskOfIngestion() {
	/*
	   Snippet for the runTask method.

	   runTask
	*/

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
}
func SnippetForSearchAuthenticationsOfIngestion() {
	/*
	   Snippet for the searchAuthentications method.

	   searchAuthentications
	*/

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
}
func SnippetForSearchDestinationsOfIngestion() {
	/*
	   Snippet for the searchDestinations method.

	   searchDestinations
	*/

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
}
func SnippetForSearchSourcesOfIngestion() {
	/*
	   Snippet for the searchSources method.

	   searchSources
	*/

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
}
func SnippetForSearchTasksOfIngestion() {
	/*
	   Snippet for the searchTasks method.

	   searchTasks
	*/

	// Initialize the client with your application region, eg. ingestion.YOUR_APP_ID_REGION
	client, err := ingestion.NewClient("YOUR_APP_ID", "YOUR_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchTasks(client.NewApiSearchTasksRequest(

		ingestion.NewEmptyTaskSearch().SetTaskIDs(
			[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForTriggerDockerSourceDiscoverOfIngestion() {
	/*
	   Snippet for the triggerDockerSourceDiscover method.

	   triggerDockerSourceDiscover
	*/

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
}
func SnippetForUpdateAuthenticationOfIngestion() {
	/*
	   Snippet for the updateAuthentication method.

	   updateAuthentication
	*/

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
}
func SnippetForUpdateDestinationOfIngestion() {
	/*
	   Snippet for the updateDestination method.

	   updateDestination
	*/

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
}
func SnippetForUpdateSourceOfIngestion() {
	/*
	   Snippet for the updateSource method.

	   updateSource
	*/

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
}
func SnippetForUpdateTaskOfIngestion() {
	/*
	   Snippet for the updateTask method.

	   updateTask
	*/

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
}
