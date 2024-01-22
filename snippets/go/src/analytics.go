package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/analytics"
)

func SnippetForCustomDeleteOfAnalytics() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
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
func SnippetForCustomGetOfAnalytics() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
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
func SnippetForCustomPostOfAnalytics() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
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
func SnippetForCustomPutOfAnalytics() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
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
func SnippetForGetAverageClickPositionOfAnalytics() {
	/*
	   Snippet for the getAverageClickPosition method.

	   get getAverageClickPosition with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetAverageClickPosition(client.NewApiGetAverageClickPositionRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetClickPositionsOfAnalytics() {
	/*
	   Snippet for the getClickPositions method.

	   get getClickPositions with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetClickPositions(client.NewApiGetClickPositionsRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetClickThroughRateOfAnalytics() {
	/*
	   Snippet for the getClickThroughRate method.

	   get getClickThroughRate with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetClickThroughRate(client.NewApiGetClickThroughRateRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetConversationRateOfAnalytics() {
	/*
	   Snippet for the getConversationRate method.

	   get getConversationRate with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetConversationRate(client.NewApiGetConversationRateRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetNoClickRateOfAnalytics() {
	/*
	   Snippet for the getNoClickRate method.

	   get getNoClickRate with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetNoClickRate(client.NewApiGetNoClickRateRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetNoResultsRateOfAnalytics() {
	/*
	   Snippet for the getNoResultsRate method.

	   get getNoResultsRate with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetNoResultsRate(client.NewApiGetNoResultsRateRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetSearchesCountOfAnalytics() {
	/*
	   Snippet for the getSearchesCount method.

	   get getSearchesCount with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetSearchesCount(client.NewApiGetSearchesCountRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetSearchesNoClicksOfAnalytics() {
	/*
	   Snippet for the getSearchesNoClicks method.

	   get getSearchesNoClicks with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetSearchesNoClicks(client.NewApiGetSearchesNoClicksRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetSearchesNoResultsOfAnalytics() {
	/*
	   Snippet for the getSearchesNoResults method.

	   get getSearchesNoResults with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetSearchesNoResults(client.NewApiGetSearchesNoResultsRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetStatusOfAnalytics() {
	/*
	   Snippet for the getStatus method.

	   get getStatus with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetStatus(client.NewApiGetStatusRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetTopCountriesOfAnalytics() {
	/*
	   Snippet for the getTopCountries method.

	   get getTopCountries with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTopCountries(client.NewApiGetTopCountriesRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetTopFilterAttributesOfAnalytics() {
	/*
	   Snippet for the getTopFilterAttributes method.

	   get getTopFilterAttributes with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTopFilterAttributes(client.NewApiGetTopFilterAttributesRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetTopFilterForAttributeOfAnalytics() {
	/*
	   Snippet for the getTopFilterForAttribute method.

	   get getTopFilterForAttribute with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTopFilterForAttribute(client.NewApiGetTopFilterForAttributeRequest(
		"myAttribute", "index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetTopFiltersNoResultsOfAnalytics() {
	/*
	   Snippet for the getTopFiltersNoResults method.

	   get getTopFiltersNoResults with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTopFiltersNoResults(client.NewApiGetTopFiltersNoResultsRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetTopHitsOfAnalytics() {
	/*
	   Snippet for the getTopHits method.

	   get getTopHits with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTopHits(client.NewApiGetTopHitsRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetTopSearchesOfAnalytics() {
	/*
	   Snippet for the getTopSearches method.

	   get getTopSearches with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTopSearches(client.NewApiGetTopSearchesRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetUsersCountOfAnalytics() {
	/*
	   Snippet for the getUsersCount method.

	   get getUsersCount with minimal parameters
	*/

	// Initialize the client with your application region, eg. analytics.YOUR_APP_ID_REGION
	client, err := analytics.NewClient("YOUR_APP_ID", "YOUR_API_KEY", analytics.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetUsersCount(client.NewApiGetUsersCountRequest(
		"index",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
