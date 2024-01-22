package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/recommend"
)

func SnippetForCustomDeleteOfRecommend() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// Initialize the client
	client, err := recommend.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
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
func SnippetForCustomGetOfRecommend() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// Initialize the client
	client, err := recommend.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
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
func SnippetForCustomPostOfRecommend() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// Initialize the client
	client, err := recommend.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
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
func SnippetForCustomPutOfRecommend() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// Initialize the client
	client, err := recommend.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
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
func SnippetForDeleteRecommendRuleOfRecommend() {
	/*
	   Snippet for the deleteRecommendRule method.

	   deleteRecommendRule0
	*/

	// Initialize the client
	client, err := recommend.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteRecommendRule(client.NewApiDeleteRecommendRuleRequest(
		"indexName", recommend.RecommendModels("related-products"), "objectID",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetRecommendRuleOfRecommend() {
	/*
	   Snippet for the getRecommendRule method.

	   getRecommendRule0
	*/

	// Initialize the client
	client, err := recommend.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetRecommendRule(client.NewApiGetRecommendRuleRequest(
		"indexName", recommend.RecommendModels("related-products"), "objectID",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetRecommendStatusOfRecommend() {
	/*
	   Snippet for the getRecommendStatus method.

	   getRecommendStatus0
	*/

	// Initialize the client
	client, err := recommend.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetRecommendStatus(client.NewApiGetRecommendStatusRequest(
		"indexName", recommend.RecommendModels("related-products"), 12345,
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetRecommendationsOfRecommend() {
	/*
	   Snippet for the getRecommendations method.

	   get recommendations for recommend model with minimal parameters
	*/

	// Initialize the client
	client, err := recommend.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetRecommendations(client.NewApiGetRecommendationsRequest(

		recommend.NewEmptyGetRecommendationsParams().SetRequests(
			[]recommend.RecommendationsRequest{*recommend.RecommendationsQueryAsRecommendationsRequest(
				recommend.NewEmptyRecommendationsQuery().SetIndexName("indexName").SetObjectID("objectID").SetModel(recommend.RecommendationModels("related-products")).SetThreshold(42))}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForSearchRecommendRulesOfRecommend() {
	/*
	   Snippet for the searchRecommendRules method.

	   searchRecommendRules0
	*/

	// Initialize the client
	client, err := recommend.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchRecommendRules(client.NewApiSearchRecommendRulesRequest(
		"indexName", recommend.RecommendModels("related-products"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
