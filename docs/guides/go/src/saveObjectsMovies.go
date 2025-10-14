package main

import (
	"context"
	"encoding/json"
	"fmt"
	"net/http"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func saveObjectsMovies() {
	// read json file
	url := "https://dashboard.algolia.com/api/1/sample_datasets?type=movie"

	response, err := http.Get(url)
	if err != nil {
		fmt.Println("Could not open url")

		return
	}

	defer response.Body.Close()

	// parse json file to Movie struct
	var movies []map[string]interface{}

	err = json.NewDecoder(response.Body).Decode(&movies)
	if err != nil {
		fmt.Println("Could not decode body")

		return
	}

	// initiate client with your app ID and write API key
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// push data to algolia
	result, err := client.SaveObjects(context.Background(), "<YOUR_INDEX_NAME>", movies)
	if err != nil {
		panic(err)
	}

	fmt.Printf("Done! Uploaded records in %d batches.", len(result))
}
