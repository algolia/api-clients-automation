// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package snippets

// >IMPORT
import "github.com/algolia/algoliasearch-client-go/v4/algolia/insights"

// IMPORT<

func SnippetForCustomDeleteOfInsights() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// >SEPARATOR customDelete allow del method for a custom path with minimal parameters
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
		"test/minimal"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomDeleteOfInsights1() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with all parameters
	*/

	// >SEPARATOR customDelete allow del method for a custom path with all parameters
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
		"test/all").WithParameters(map[string]any{"query": "parameters"}))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomGetOfInsights() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// >SEPARATOR customGet allow get method for a custom path with minimal parameters
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomGet(client.NewApiCustomGetRequest(
		"test/minimal"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomGetOfInsights1() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with all parameters
	*/

	// >SEPARATOR customGet allow get method for a custom path with all parameters
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomGet(client.NewApiCustomGetRequest(
		"test/all").WithParameters(map[string]any{"query": "parameters with space"}))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomGetOfInsights2() {
	/*
	   Snippet for the customGet method.

	   requestOptions should be escaped too
	*/

	// >SEPARATOR customGet requestOptions should be escaped too
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomGet(client.NewApiCustomGetRequest(
		"test/all").WithParameters(map[string]any{"query": "to be overriden"}), insights.WithQueryParam("query", "parameters with space"), insights.WithQueryParam("and an array",
		[]string{"array", "with spaces"}), insights.WithHeaderParam("x-header-1", "spaces are left alone"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPost allow post method for a custom path with minimal parameters
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/minimal"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights1() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with all parameters
	*/

	// >SEPARATOR customPost allow post method for a custom path with all parameters
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/all").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights2() {
	/*
	   Snippet for the customPost method.

	   requestOptions can override default query parameters
	*/

	// >SEPARATOR customPost requestOptions can override default query parameters
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/requestOptions").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}), insights.WithQueryParam("query", "myQueryParameter"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights3() {
	/*
	   Snippet for the customPost method.

	   requestOptions merges query parameters with default ones
	*/

	// >SEPARATOR customPost requestOptions merges query parameters with default ones
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/requestOptions").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}), insights.WithQueryParam("query2", "myQueryParameter"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights4() {
	/*
	   Snippet for the customPost method.

	   requestOptions can override default headers
	*/

	// >SEPARATOR customPost requestOptions can override default headers
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/requestOptions").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}), insights.WithHeaderParam("x-algolia-api-key", "ALGOLIA_API_KEY"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights5() {
	/*
	   Snippet for the customPost method.

	   requestOptions merges headers with default ones
	*/

	// >SEPARATOR customPost requestOptions merges headers with default ones
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/requestOptions").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}), insights.WithHeaderParam("x-algolia-api-key", "ALGOLIA_API_KEY"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights6() {
	/*
	   Snippet for the customPost method.

	   requestOptions queryParameters accepts booleans
	*/

	// >SEPARATOR customPost requestOptions queryParameters accepts booleans
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/requestOptions").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}), insights.WithQueryParam("isItWorking", true))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights7() {
	/*
	   Snippet for the customPost method.

	   requestOptions queryParameters accepts integers
	*/

	// >SEPARATOR customPost requestOptions queryParameters accepts integers
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/requestOptions").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}), insights.WithQueryParam("myParam", 2))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights8() {
	/*
	   Snippet for the customPost method.

	   requestOptions queryParameters accepts list of string
	*/

	// >SEPARATOR customPost requestOptions queryParameters accepts list of string
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/requestOptions").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}), insights.WithQueryParam("myParam",
		[]string{"b and c", "d"}))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights9() {
	/*
	   Snippet for the customPost method.

	   requestOptions queryParameters accepts list of booleans
	*/

	// >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/requestOptions").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}), insights.WithQueryParam("myParam",
		[]bool{true, true, false}))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfInsights10() {
	/*
	   Snippet for the customPost method.

	   requestOptions queryParameters accepts list of integers
	*/

	// >SEPARATOR customPost requestOptions queryParameters accepts list of integers
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/requestOptions").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}), insights.WithQueryParam("myParam",
		[]int32{1, 2}))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPutOfInsights() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPut allow put method for a custom path with minimal parameters
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPut(client.NewApiCustomPutRequest(
		"test/minimal"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPutOfInsights1() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with all parameters
	*/

	// >SEPARATOR customPut allow put method for a custom path with all parameters
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPut(client.NewApiCustomPutRequest(
		"test/all").WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForDeleteUserTokenOfInsights() {
	/*
	   Snippet for the deleteUserToken method.

	   deleteUserToken
	*/

	// >SEPARATOR deleteUserToken default
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	err = client.DeleteUserToken(client.NewApiDeleteUserTokenRequest(
		"test-user-1"))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// SEPARATOR<
}
func SnippetForPushEventsOfInsights() {
	/*
	   Snippet for the pushEvents method.

	   pushEvents
	*/

	// >SEPARATOR pushEvents pushEvents
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.PushEvents(client.NewApiPushEventsRequest(

		insights.NewEmptyInsightsEvents().SetEvents(
			[]insights.EventsItems{*insights.ClickedObjectIDsAfterSearchAsEventsItems(
				insights.NewEmptyClickedObjectIDsAfterSearch().SetEventType(insights.ClickEvent("click")).SetEventName("Product Clicked").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
					[]string{"9780545139700", "9780439784542"}).SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7").SetPositions(
					[]int32{7, 6}))})))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForPushEventsOfInsights1() {
	/*
	   Snippet for the pushEvents method.

	   Many events type
	*/

	// >SEPARATOR pushEvents Many events type
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.PushEvents(client.NewApiPushEventsRequest(

		insights.NewEmptyInsightsEvents().SetEvents(
			[]insights.EventsItems{*insights.ConvertedObjectIDsAfterSearchAsEventsItems(
				insights.NewEmptyConvertedObjectIDsAfterSearch().SetEventType(insights.ConversionEvent("conversion")).SetEventName("Product Purchased").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1743638400000).SetObjectIDs(
					[]string{"9780545139700", "9780439784542"}).SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7")), *insights.ViewedObjectIDsAsEventsItems(
				insights.NewEmptyViewedObjectIDs().SetEventType(insights.ViewEvent("view")).SetEventName("Product Detail Page Viewed").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1743638400000).SetObjectIDs(
					[]string{"9780545139700", "9780439784542"}))})))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForPushEventsOfInsights2() {
	/*
	   Snippet for the pushEvents method.

	   ConvertedObjectIDsAfterSearch
	*/

	// >SEPARATOR pushEvents ConvertedObjectIDsAfterSearch
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.PushEvents(client.NewApiPushEventsRequest(

		insights.NewEmptyInsightsEvents().SetEvents(
			[]insights.EventsItems{*insights.ConvertedObjectIDsAfterSearchAsEventsItems(
				insights.NewEmptyConvertedObjectIDsAfterSearch().SetEventType(insights.ConversionEvent("conversion")).SetEventName("Product Purchased").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
					[]string{"9780545139700", "9780439784542"}).SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7"))})))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForPushEventsOfInsights3() {
	/*
	   Snippet for the pushEvents method.

	   ViewedObjectIDs
	*/

	// >SEPARATOR pushEvents ViewedObjectIDs
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.PushEvents(client.NewApiPushEventsRequest(

		insights.NewEmptyInsightsEvents().SetEvents(
			[]insights.EventsItems{*insights.ViewedObjectIDsAsEventsItems(
				insights.NewEmptyViewedObjectIDs().SetEventType(insights.ViewEvent("view")).SetEventName("Product Detail Page Viewed").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
					[]string{"9780545139700", "9780439784542"}))})))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForPushEventsOfInsights4() {
	/*
	   Snippet for the pushEvents method.

	   AddedToCartObjectIDs
	*/

	// >SEPARATOR pushEvents AddedToCartObjectIDs
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.PushEvents(client.NewApiPushEventsRequest(

		insights.NewEmptyInsightsEvents().SetEvents(
			[]insights.EventsItems{*insights.AddedToCartObjectIDsAfterSearchAsEventsItems(
				insights.NewEmptyAddedToCartObjectIDsAfterSearch().SetEventType(insights.ConversionEvent("conversion")).SetEventSubtype(insights.AddToCartEvent("addToCart")).SetEventName("Product Added To Cart").SetIndex("products").SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
					[]string{"9780545139700", "9780439784542"}).SetObjectData(
					[]insights.ObjectDataAfterSearch{*insights.NewEmptyObjectDataAfterSearch().SetPrice(insights.Float64AsPrice(19.99)).SetQuantity(10).SetDiscount(insights.Float64AsDiscount(2.5)), *insights.NewEmptyObjectDataAfterSearch().SetPrice(insights.StringAsPrice("8$")).SetQuantity(7).SetDiscount(insights.StringAsDiscount("30%"))}).SetCurrency("USD"))})))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForSetClientApiKeyOfInsights() {
	/*
	   Snippet for the setClientApiKey method.

	   switch API key
	*/

	// >SEPARATOR setClientApiKey default
	// Initialize the client with your application region, eg. insights.ALGOLIA_APPLICATION_REGION
	client, err := insights.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", insights.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	err = client.SetClientApiKey(
		"updated-api-key")
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// SEPARATOR<
}
