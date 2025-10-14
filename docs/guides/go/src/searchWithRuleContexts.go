package main

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func getPlatformTag() (string, error) {
	return "", nil // Implement your logic here
}

func searchWithRuleContexts() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	platformTag, err := getPlatformTag()
	if err != nil {
		panic(err)
	}

	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery("<YOUR_SEARCH_QUERY>").
			SetRuleContexts([]string{platformTag}),
	)

	_, err = client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"<YOUR_INDEX_NAME>").WithSearchParams(searchParams))
	if err != nil {
		panic(err)
	}
}
