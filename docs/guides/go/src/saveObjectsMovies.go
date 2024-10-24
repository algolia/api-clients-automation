package main

import (
	"encoding/json"
	"fmt"
	"net/http"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func main() {
	// read json file
	url := "https://dashboard.algolia.com/sample_datasets/movie.json"
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

	// initiate client
	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// push data to algolia
	result, err := client.SaveObjects(
		"<YOUR_INDEX_NAME>", movies,
	)
	if err != nil {
		fmt.Println(err)
		return
	}

	fmt.Printf("Done! Uploaded records in %d batches.", len(result))
}
