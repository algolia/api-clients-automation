package main

import (
	"context"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func searchWithAnalyticsAndHeader() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	/*
	  '94.228.178.246' should be replaced with your user's IP address.
	  Depending on your stack there are multiple ways to get this information.
	*/
	ip := "94.228.178.246"
	query := "query"

	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery(query).
			SetAnalytics(true),
	)

	_, err = client.SearchSingleIndex(context.Background(), "<YOUR_INDEX_NAME>", searchParams, search.WithHeaderParam("X-Forwarded-For", ip))
	if err != nil {
		panic(err)
	}
}
