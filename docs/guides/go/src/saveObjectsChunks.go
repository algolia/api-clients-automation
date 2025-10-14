package main

import (
	"context"
	"encoding/json"
	"os"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func saveObjectsChunks() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	content, err := os.ReadFile("actors.json")
	if err != nil {
		panic(err)
	}

	var records []map[string]any

	err = json.Unmarshal(content, &records)
	if err != nil {
		panic(err)
	}

	chunkSize := 10000

	for beginIndex := 0; beginIndex < len(records); beginIndex += chunkSize {
		chunk := records[beginIndex:min(beginIndex+chunkSize, len(records))]

		_, err = client.SaveObjects(context.Background(), "<YOUR_INDEX_NAME>", chunk)
		if err != nil {
			panic(err)
		}
	}
}
