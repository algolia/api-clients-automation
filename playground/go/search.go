package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
	// "github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func testSearch(appID, apiKey string) int {
	// indexName := getEnvWithDefault("SEARCH_INDEX", "test_index")
	searchClient, err := search.NewClient(appID, apiKey)
	if err != nil {
		panic(err)
	}

	err = searchClient.BrowseObjects("test-flag", *search.NewEmptyBrowseParamsObject(), search.WithAggregator(func(res any, err error) {
		if err != nil {
			panic(err)
		}
		fmt.Println(len(res.(*search.BrowseResponse).Hits))
	}))
	if err != nil {
		panic(err)
	}

	// old way
	//searchClient.Search(searchClient.NewApiSearchRequest(search.NewSearchMethodParams([]search.SearchQuery{
	//	*search.SearchForHitsAsSearchQuery(search.NewSearchForHits("indexName", search.WithSearchForHitsQuery("foo"))),
	//})))

	// new way
	//searchClient.Search([]search.SearchQuery{
	//	search.NewSearchForHits("indexName").WithQuery("foo"),
	//}, nil)

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
