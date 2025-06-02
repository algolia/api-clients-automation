package main

import (
	"context"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func reduceLabelsToFilters(_ []string) (search.OptionalFilters, error) {
	return search.OptionalFilters{}, nil // Implement your logic here
}

func searchWithOptionalFilters() {
	labels := []string{ /* A list of labels */ }

	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	optionalFilters, err := reduceLabelsToFilters(labels)
	if err != nil {
		panic(err)
	}

	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery("<YOUR_SEARCH_QUERY>").
			SetOptionalFilters(&optionalFilters),
	)

	_, err = client.SearchSingleIndex(context.Background(), "<YOUR_INDEX_NAME>", searchParams)
	if err != nil {
		panic(err)
	}
}
