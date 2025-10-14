package main

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func searchWithLogicalOr() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	query := "the query"
	optionalWords := search.ArrayOfStringAsOptionalWords([]string{"the", "query"})
	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery(query).
			SetOptionalWords(optionalWords),
	)

	_, err = client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"<YOUR_INDEX_NAME>").WithSearchParams(searchParams))
	if err != nil {
		panic(err)
	}
}
