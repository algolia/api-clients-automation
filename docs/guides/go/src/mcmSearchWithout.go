package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func mcmSearchWithout() {
	getAppIDFor := func(_ string) (string, error) {
		return "", nil // Implement your logic here
	}

	getIndexingApiKeyFor := func(_ string) (string, error) {
		return "", nil // Implement your logic here
	}

	// Fetch from your own data storage and with your own code
	// the associated application ID and API key for this user
	appID, err := getAppIDFor("user42")
	if err != nil {
		fmt.Println(err)
		return
	}

	apiKey, err := getIndexingApiKeyFor("user42")
	if err != nil {
		fmt.Println(err)
		return
	}

	client, err := search.NewClient(appID, apiKey)
	if err != nil {
		fmt.Println(err)
		return
	}

	searchParams := search.SearchParamsObjectAsSearchParams(
		search.NewSearchParamsObject().
			SetQuery("<YOUR_SEARCH_QUERY>").
			SetFacetFilters(
				search.ArrayOfFacetFiltersAsFacetFilters(
					[]search.FacetFilters{
						*search.StringAsFacetFilters("user:user42"),
						*search.StringAsFacetFilters("user:public"),
					},
				),
			),
	)

	_, err = client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"<YOUR_INDEX_NAME>").WithSearchParams(searchParams))
	if err != nil {
		panic(err)
	}
}
