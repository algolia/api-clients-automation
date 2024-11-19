package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
)

func testIngestion(appID, apiKey string) int {
	ingestionClient, err := ingestion.NewClient(appID, apiKey, ingestion.US)
	if err != nil {
		panic(err)
	}

	// another example to generate payload for a request.
	_, payload, err := ingestionClient.ListTasksWithHTTPInfo(ingestionClient.NewApiListTasksRequest())
	if err != nil {
		fmt.Printf("request error: %v\n", err)

		return 1
	}

	fmt.Println(string(payload))

	return 0
}
