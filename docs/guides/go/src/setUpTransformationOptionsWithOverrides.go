package main

import (
	"fmt"
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func setUpTransformationOptionsWithOverrides() {
	// Override the Ingestion API defaults. Any option you don't set keeps its default.
	// Replace "us" with "eu" if your Algolia application uses the Europe analytics region.
	client, err := search.NewClient(
		"ALGOLIA_APPLICATION_ID",
		"ALGOLIA_API_KEY",
		search.WithTransformationOptions(search.TransformationOptions{
			Region:         "us",
			ConnectTimeout: 5 * time.Second,
			ReadTimeout:    30 * time.Second,
		}),
	)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Save records, transforming them through the Push connector
	result, err := client.SaveObjectsWithTransformation(
		"<YOUR_INDEX_NAME>",
		[]map[string]any{{"objectID": "1", "name": "Adam"}, {"objectID": "2", "name": "Benoit"}}, search.WithWaitForTasks(true))
	if err != nil {
		panic(err)
	}

	fmt.Printf("Done! Uploaded records in %d batches.", len(result))
}
