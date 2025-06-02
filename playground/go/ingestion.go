package main

import (
	"context"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/ingestion"
)

func testIngestion(ctx context.Context, appID, apiKey string) int {
	ingestionClient, err := ingestion.NewClient(appID, apiKey, ingestion.US)
	if err != nil {
		panic(err)
	}

	// another example to generate payload for a request.
	res, err := ingestionClient.ListTasks(ctx, nil)
	if err != nil {
		fmt.Printf("request error: %v\n", err)

		return 1
	}

	fmt.Println(res)

	return 0
}
