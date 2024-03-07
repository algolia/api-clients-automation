package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/personalization"
)

func SnippetForCustomDeleteOfPersonalization() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// >SEPARATOR customDelete
	// Initialize the client with your application region, eg. personalization.YOUR_APP_ID_REGION
	client, err := personalization.NewClient("YOUR_APP_ID", "YOUR_API_KEY", personalization.US)
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
func SnippetForCustomGetOfPersonalization() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// >SEPARATOR customGet
	// Initialize the client with your application region, eg. personalization.YOUR_APP_ID_REGION
	client, err := personalization.NewClient("YOUR_APP_ID", "YOUR_API_KEY", personalization.US)
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
func SnippetForCustomPostOfPersonalization() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPost
	// Initialize the client with your application region, eg. personalization.YOUR_APP_ID_REGION
	client, err := personalization.NewClient("YOUR_APP_ID", "YOUR_API_KEY", personalization.US)
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
func SnippetForCustomPutOfPersonalization() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPut
	// Initialize the client with your application region, eg. personalization.YOUR_APP_ID_REGION
	client, err := personalization.NewClient("YOUR_APP_ID", "YOUR_API_KEY", personalization.US)
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
func SnippetForDeleteUserProfileOfPersonalization() {
	/*
	   Snippet for the deleteUserProfile method.

	   delete deleteUserProfile
	*/

	// >SEPARATOR deleteUserProfile
	// Initialize the client with your application region, eg. personalization.YOUR_APP_ID_REGION
	client, err := personalization.NewClient("YOUR_APP_ID", "YOUR_API_KEY", personalization.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteUserProfile(client.NewApiDeleteUserProfileRequest(
		"UserToken",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetPersonalizationStrategyOfPersonalization() {
	/*
	   Snippet for the getPersonalizationStrategy method.

	   get getPersonalizationStrategy
	*/

	// >SEPARATOR getPersonalizationStrategy
	// Initialize the client with your application region, eg. personalization.YOUR_APP_ID_REGION
	client, err := personalization.NewClient("YOUR_APP_ID", "YOUR_API_KEY", personalization.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetPersonalizationStrategy()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetUserTokenProfileOfPersonalization() {
	/*
	   Snippet for the getUserTokenProfile method.

	   get getUserTokenProfile
	*/

	// >SEPARATOR getUserTokenProfile
	// Initialize the client with your application region, eg. personalization.YOUR_APP_ID_REGION
	client, err := personalization.NewClient("YOUR_APP_ID", "YOUR_API_KEY", personalization.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetUserTokenProfile(client.NewApiGetUserTokenProfileRequest(
		"UserToken",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSetPersonalizationStrategyOfPersonalization() {
	/*
	   Snippet for the setPersonalizationStrategy method.

	   set setPersonalizationStrategy
	*/

	// >SEPARATOR setPersonalizationStrategy
	// Initialize the client with your application region, eg. personalization.YOUR_APP_ID_REGION
	client, err := personalization.NewClient("YOUR_APP_ID", "YOUR_API_KEY", personalization.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SetPersonalizationStrategy(client.NewApiSetPersonalizationStrategyRequest(

		personalization.NewEmptyPersonalizationStrategyParams().SetEventScoring(
			[]personalization.EventScoring{*personalization.NewEmptyEventScoring().SetScore(42).SetEventName("Algolia").SetEventType("Event")}).SetFacetScoring(
			[]personalization.FacetScoring{*personalization.NewEmptyFacetScoring().SetScore(42).SetFacetName("Event")}).SetPersonalizationImpact(42),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
