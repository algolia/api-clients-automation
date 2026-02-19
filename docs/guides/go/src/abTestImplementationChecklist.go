package main

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func getUserToken() (string, error) {
	// Implement your logic here
	return "", nil
}

func abTestImplementationChecklist() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Set the searchParams and get the current user token
	userToken, err := getUserToken()
	if err != nil {
		panic(err)
	}

	var searchParams *search.SearchParams

	// Is the user token anonymous?
	if userToken == "" || userToken == "YOUR_ANONYMOUS_USER_TOKEN" {
		// Disable A/B testing for this request
		searchParams = search.SearchParamsObjectAsSearchParams(
			search.NewSearchParamsObject().
				SetQuery("User search query").
				SetEnableABTest(false),
		)
	} else {
		// Set the user token to the current user token
		searchParams = search.SearchParamsObjectAsSearchParams(
			search.NewSearchParamsObject().
				SetQuery("User search query").
				SetEnableABTest(true).
				SetUserToken(userToken),
		)
	}

	// Perform the searchSingleIndex
	_, err = client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"<YOUR_INDEX_NAME>").WithSearchParams(searchParams))
	if err != nil {
		// SearchSingleIndex errors
		panic(err)
	}
}
