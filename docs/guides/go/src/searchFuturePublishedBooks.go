package main

import (
	"fmt"
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func searchFuturePublishedBooks() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	dateTimestamp := time.Now().UnixMilli()
	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery("<YOUR_SEARCH_QUERY>").
			SetFilters(fmt.Sprintf("date_timestamp > %d", dateTimestamp)),
	)

	_, err = client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"<YOUR_INDEX_NAME>").WithSearchParams(searchParams))
	if err != nil {
		panic(err)
	}
}
