package main

import (
	"context"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

func testSearch(appID, apiKey string) int {
	// indexName := getEnvWithDefault("SEARCH_INDEX", "test_index")
	searchClient, err := search.NewClient(appID, apiKey)
	if err != nil {
		panic(err)
	}

	res, err := searchClient.WaitForApiKey(search.API_KEY_OPERATION_ADD, "test", &search.ApiKey{}, utils.WithContext(context.Background()), utils.WithMaxRetries(4))
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
