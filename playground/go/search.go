package main

import (
	"context"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func testSearch(appID, apiKey string) int {
	// indexName := getEnvWithDefault("SEARCH_INDEX", "test_index")
	searchClient, err := search.NewClient(appID, apiKey)
	if err != nil {
		panic(err)
	}

	res, err := searchClient.WaitForApiKey("test", search.API_KEY_OPERATION_ADD, search.WithContext(context.Background()), search.WithMaxRetries(4))
	print(res)
	print(err.Error())

	/*
		response, err := searchClient.AddOrUpdateObject(
			searchClient.NewApiAddOrUpdateObjectRequest(
				indexName,
				"1",
				map[string]any{
					"name": "Foo",
					"age":  42,
					"city": "Paris",
				},
			),
		)
		if err != nil {
			panic(err)
		}

		_, err = searchClient.WaitForTask(indexName, *response.TaskID)
		if err != nil {
			panic(err)
		}

		searchResponse, err := searchClient.Search(
			searchClient.NewApiSearchRequest(
				search.NewSearchMethodParams(
					[]search.SearchQuery{
						*search.SearchForHitsAsSearchQuery(
							search.NewSearchForHits(
								indexName,
								search.WithSearchForHitsQuery("foo"),
							),
						),
					},
				),
			),
		)
		if err != nil {
			panic(err)
		}

		for _, result := range searchResponse.Results {
			fmt.Printf("Result: %v", result.SearchResponse)
		}
	*/

	return 0
}
