package main

import (
	"context"
	"encoding/json"
	"os"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func saveObjectsModified() {
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	content, err := os.ReadFile("products.json")
	if err != nil {
		panic(err)
	}

	var products []map[string]any

	err = json.Unmarshal(content, &products)
	if err != nil {
		panic(err)
	}

	records := make([]map[string]any, 0, len(products))

	for _, product := range products {
		reference := product["product_reference"].(string)
		suffixes := make([]string, 0, len(reference)-1)

		for i := len(reference); i > 1; i-- {
			suffixes = append(suffixes, reference[i:])
		}

		record := product
		record["product_reference_suffixes"] = suffixes

		records = append(records, record)
	}

	_, err = client.SaveObjects(context.Background(), "<YOUR_INDEX_NAME>", records)
	if err != nil {
		panic(err)
	}
}
