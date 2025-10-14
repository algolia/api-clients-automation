package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func deleteMultipleIndices() {
	// You need an API key with `deleteIndex`
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// List all indices
	indices, err := client.ListIndices(client.NewApiListIndicesRequest())
	if err != nil {
		panic(err)
	}

	// Primary indices don't have a `primary` key
	primaryIndices := make([]search.FetchedIndex, 0, len(indices.Items))
	replicaIndices := make([]search.FetchedIndex, 0, len(indices.Items))

	for _, index := range indices.Items {
		if index.Primary == nil {
			primaryIndices = append(primaryIndices, index)
		} else {
			replicaIndices = append(replicaIndices, index)
		}
	}

	// Delete primary indices first
	if len(primaryIndices) > 0 {
		requests := make([]search.MultipleBatchRequest, 0, len(primaryIndices))

		for _, index := range primaryIndices {
			requests = append(requests, search.MultipleBatchRequest{
				Action:    "delete",
				IndexName: index.Name,
			})
		}

		_, err = client.MultipleBatch(client.NewApiMultipleBatchRequest(

			search.NewEmptyBatchParams().SetRequests(requests)))
		if err != nil {
			panic(err)
		}

		fmt.Println("Deleted primary indices.")
	}

	// Now, delete replica indices
	if len(replicaIndices) > 0 {
		requests := make([]search.MultipleBatchRequest, 0, len(primaryIndices))

		for _, index := range primaryIndices {
			requests = append(requests, search.MultipleBatchRequest{
				Action:    "delete",
				IndexName: index.Name,
			})
		}

		_, err = client.MultipleBatch(client.NewApiMultipleBatchRequest(

			search.NewEmptyBatchParams().SetRequests(requests)))
		if err != nil {
			panic(err)
		}

		fmt.Println("Deleted replica indices.")
	}
}
