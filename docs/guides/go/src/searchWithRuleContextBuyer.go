package main

import "github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"

func getBuyerAccountId() (string, error) {
	return "", nil // Implement your logic here
}

func searchWithRuleContextBuyer() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// get the buyer account information
	buyer, err := getBuyerAccountId()
	if err != nil {
		panic(err)
	}

	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery("<YOUR_SEARCH_QUERY>").
			SetRuleContexts([]string{buyer}),
	)

	_, err = client.SearchSingleIndex("<YOUR_INDEX_NAME>", searchParams)
	if err != nil {
		panic(err)
	}
}
