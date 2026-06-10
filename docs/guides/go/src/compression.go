package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/compression"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func enableCompression() {
	// Initialize the client with gzip compression enabled
	// Compression reduces the size of request bodies sent to Algolia
	cfg := search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:       "ALGOLIA_APPLICATION_ID",
			ApiKey:      "ALGOLIA_API_KEY", // #nosec G101 -- credentials are placeholders
			Compression: compression.GZIP,
		},
	}

	client, err := search.NewClientWithConfig(cfg)
	if err != nil {
		panic(err)
	}

	// Search with compressed request body
	result, err := client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"<YOUR_INDEX_NAME>").WithSearchParams(search.SearchParamsObjectAsSearchParams(
		search.NewEmptySearchParamsObject().SetQuery("comedy"))))
	if err != nil {
		panic(err)
	}

	_ = result

	fmt.Println("Search with compression completed successfully")
}
