package main

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func getGoogleAnalyticsUserIDFromBrowserCookie(_ string) (string, error) {
	return "", nil // Implement your logic here
}

func searchWithGAToken() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	userToken, err := getGoogleAnalyticsUserIDFromBrowserCookie("_ga")
	if err != nil {
		panic(err)
	}

	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery("<YOUR_SEARCH_QUERY>").
			SetUserToken(userToken),
	)

	_, err = client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"<YOUR_INDEX_NAME>").WithSearchParams(searchParams))
	if err != nil {
		panic(err)
	}

	var loggedInUser *string

	if loggedInUser != nil {
		searchParams = search.SearchParamsObjectAsSearchParams(searchParams.SearchParamsObject.SetUserToken(*loggedInUser))
	}

	_, err = client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"<YOUR_INDEX_NAME>").WithSearchParams(searchParams))
	if err != nil {
		panic(err)
	}
}
