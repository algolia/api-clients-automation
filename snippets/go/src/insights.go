package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/insights"
)

func SnippetForCustomDeleteOfInsights() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// >SEPARATOR customDelete
	// Initialize the client with your application region, eg. insights.YOUR_APP_ID_REGION
	client, err := insights.NewClient("YOUR_APP_ID", "YOUR_API_KEY", insights.US)
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
func SnippetForCustomGetOfInsights() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// >SEPARATOR customGet
	// Initialize the client with your application region, eg. insights.YOUR_APP_ID_REGION
	client, err := insights.NewClient("YOUR_APP_ID", "YOUR_API_KEY", insights.US)
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
func SnippetForCustomPostOfInsights() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPost
	// Initialize the client with your application region, eg. insights.YOUR_APP_ID_REGION
	client, err := insights.NewClient("YOUR_APP_ID", "YOUR_API_KEY", insights.US)
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
func SnippetForCustomPutOfInsights() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPut
	// Initialize the client with your application region, eg. insights.YOUR_APP_ID_REGION
	client, err := insights.NewClient("YOUR_APP_ID", "YOUR_API_KEY", insights.US)
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
func SnippetForDeleteUserTokenOfInsights() {
	/*
	   Snippet for the deleteUserToken method.

	   deleteUserToken0
	*/

	// >SEPARATOR deleteUserToken
	// Initialize the client with your application region, eg. insights.YOUR_APP_ID_REGION
	client, err := insights.NewClient("YOUR_APP_ID", "YOUR_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	err = client.DeleteUserToken(client.NewApiDeleteUserTokenRequest(
		"test-user-1",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// SEPARATOR<
}
func SnippetForPushEventsOfInsights() {
	/*
	   Snippet for the pushEvents method.

	   pushEvents0
	*/

	// >SEPARATOR pushEvents
	// Initialize the client with your application region, eg. insights.YOUR_APP_ID_REGION
	client, err := insights.NewClient("YOUR_APP_ID", "YOUR_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.PushEvents(client.NewApiPushEventsRequest(

		insights.NewEmptyInsightsEvents().SetEvents(
			[]insights.EventsItems{*insights.ClickedObjectIDsAfterSearchAsEventsItems(
				insights.NewEmptyClickedObjectIDsAfterSearch().SetEventType(insights.ClickEvent("click")).SetEventName("Product Clicked").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
					[]string{"9780545139700", "9780439784542"}).SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7").SetPositions(
					[]int32{7, 6}))}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
