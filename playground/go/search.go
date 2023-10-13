package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func testSearch(appID, apiKey string) int {
	indexName := getEnvWithDefault("SEARCH_INDEX", "test_index")
	searchClient := search.NewClient(appID, apiKey)

	searchParams := search.SearchParamsStringAsSearchParams(search.NewSearchParamsString(search.WithSearchParamsStringParams("query=jeans&hitsPerPage=2")))
	_, err := searchClient.SearchSingleIndex(searchClient.NewApiSearchSingleIndexRequest(indexName).WithSearchParams(&searchParams))
	if err != nil {
		fmt.Printf("request error with SearchSingleIndex: %v\n", err)
		return 1
	}

	operationIndexRequest := searchClient.NewApiOperationIndexRequest(
		indexName,
		&search.OperationIndexParams{
			Operation:   search.OPERATIONTYPE_COPY,
			Destination: "test-go-4",
		},
	)

	response, err := searchClient.OperationIndex(operationIndexRequest)
	if err != nil {
		panic(err)
	}

	taskResponse, err := searchClient.WaitForTask(
		indexName,
		response.TaskID,
		nil,
		nil,
		nil,
	)
	if err != nil {
		panic(err)
	}

	printResponse(taskResponse)

	return 0
}
