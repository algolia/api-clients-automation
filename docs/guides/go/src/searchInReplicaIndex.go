package main

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func searchInReplicaIndex() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// 1. Change the sort dynamically based on the UI events
	sortByPrice := false

	// 2. Get the index name based on sortByPrice
	indexName := "products"
	if sortByPrice {
		indexName = "products_price_desc"
	}

	// 3. Search on dynamic index name (primary or replica)
	_, err = client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		indexName).WithSearchParams(search.SearchParamsObjectAsSearchParams(
		search.NewEmptySearchParamsObject().SetQuery("query"))))
	if err != nil {
		panic(err)
	}
}
