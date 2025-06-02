package main

import (
	"context"
	"fmt"
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func searchRecentlyPublishedBooks() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	dateTimestamp := time.Now().AddDate(-1, 0, 0).Unix()
	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery("<YOUR_SEARCH_QUERY>").
			SetFilters(fmt.Sprintf("date_timestamp > %d", dateTimestamp)),
	)

	_, err = client.SearchSingleIndex(context.Background(), "<YOUR_INDEX_NAME>", searchParams)
	if err != nil {
		panic(err)
	}
}
