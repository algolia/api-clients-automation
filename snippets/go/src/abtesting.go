package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/abtesting"
)

func SnippetForAddABTestsOfAbtesting() {
	/*
	   Snippet for the addABTests method.

	   addABTests with minimal parameters
	*/

	// Initialize the client with your application region, eg. abtesting.YOUR_APP_ID_REGION
	client, err := abtesting.NewClient("YOUR_APP_ID", "YOUR_API_KEY", abtesting.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.AddABTests(client.NewApiAddABTestsRequest(

		abtesting.NewEmptyAddABTestsRequest().SetEndAt("2022-12-31T00:00:00.000Z").SetName("myABTest").SetVariants(
			[]abtesting.AddABTestsVariant{*abtesting.AbTestsVariantAsAddABTestsVariant(
				abtesting.NewEmptyAbTestsVariant().SetIndex("AB_TEST_1").SetTrafficPercentage(30)), *abtesting.AbTestsVariantAsAddABTestsVariant(
				abtesting.NewEmptyAbTestsVariant().SetIndex("AB_TEST_2").SetTrafficPercentage(50))}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForCustomDeleteOfAbtesting() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// Initialize the client with your application region, eg. abtesting.YOUR_APP_ID_REGION
	client, err := abtesting.NewClient("YOUR_APP_ID", "YOUR_API_KEY", abtesting.US)
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
func SnippetForCustomGetOfAbtesting() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// Initialize the client with your application region, eg. abtesting.YOUR_APP_ID_REGION
	client, err := abtesting.NewClient("YOUR_APP_ID", "YOUR_API_KEY", abtesting.US)
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
func SnippetForCustomPostOfAbtesting() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// Initialize the client with your application region, eg. abtesting.YOUR_APP_ID_REGION
	client, err := abtesting.NewClient("YOUR_APP_ID", "YOUR_API_KEY", abtesting.US)
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
func SnippetForCustomPutOfAbtesting() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// Initialize the client with your application region, eg. abtesting.YOUR_APP_ID_REGION
	client, err := abtesting.NewClient("YOUR_APP_ID", "YOUR_API_KEY", abtesting.US)
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
func SnippetForDeleteABTestOfAbtesting() {
	/*
	   Snippet for the deleteABTest method.

	   deleteABTest
	*/

	// Initialize the client with your application region, eg. abtesting.YOUR_APP_ID_REGION
	client, err := abtesting.NewClient("YOUR_APP_ID", "YOUR_API_KEY", abtesting.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteABTest(client.NewApiDeleteABTestRequest(
		42,
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetABTestOfAbtesting() {
	/*
	   Snippet for the getABTest method.

	   getABTest
	*/

	// Initialize the client with your application region, eg. abtesting.YOUR_APP_ID_REGION
	client, err := abtesting.NewClient("YOUR_APP_ID", "YOUR_API_KEY", abtesting.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetABTest(client.NewApiGetABTestRequest(
		42,
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForListABTestsOfAbtesting() {
	/*
	   Snippet for the listABTests method.

	   listABTests with minimal parameters
	*/

	// Initialize the client with your application region, eg. abtesting.YOUR_APP_ID_REGION
	client, err := abtesting.NewClient("YOUR_APP_ID", "YOUR_API_KEY", abtesting.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.ListABTests(client.NewApiListABTestsRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForStopABTestOfAbtesting() {
	/*
	   Snippet for the stopABTest method.

	   stopABTest
	*/

	// Initialize the client with your application region, eg. abtesting.YOUR_APP_ID_REGION
	client, err := abtesting.NewClient("YOUR_APP_ID", "YOUR_API_KEY", abtesting.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.StopABTest(client.NewApiStopABTestRequest(
		42,
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
