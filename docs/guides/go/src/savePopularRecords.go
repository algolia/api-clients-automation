package main

import (
	"context"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func savePopularRecords() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	records := []map[string]any{{ /* Your records */ }}

	err = client.BrowseObjects(
		context.Background(),
		"<YOUR_INDEX_NAME>",
		search.BrowseParamsObject{},
		search.WithAggregator(func(res any, err error) {
			if err != nil {
				panic(err)
			}

			browseRes, ok := res.(search.BrowseResponse)
			if !ok {
				panic("Invalid response")
			}

			for _, hit := range browseRes.Hits {
				record := hit.AdditionalProperties
				record["isPopular"] = record["nbFollowers"].(int) >= 1_000_000

				records = append(records, record)
			}
		}),
	)
	if err != nil {
		panic(err)
	}

	_, err = client.SaveObjects(context.Background(), "<YOUR_INDEX_NAME>", records)
	if err != nil {
		panic(err)
	}
}
