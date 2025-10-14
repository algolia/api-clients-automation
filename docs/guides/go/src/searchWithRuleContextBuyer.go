package main

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func getBuyerAccountID() (string, error) {
	return "", nil // Implement your logic here
}

func searchWithRuleContextBuyer() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// get the buyer account information
	buyer, err := getBuyerAccountID()
	if err != nil {
		panic(err)
	}

	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery("<YOUR_SEARCH_QUERY>").
			SetRuleContexts([]string{buyer}),
	)

	_, err = client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"<YOUR_INDEX_NAME>").WithSearchParams(searchParams))
	if err != nil {
		panic(err)
	}
}
