package main

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func saveObjectsPublicUser() {
	playlists := []map[string]any{{ /* Your records */ }}

	client, err := search.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	_, err = client.SaveObjects(
		"<YOUR_INDEX_NAME>", playlists, search.WithWaitForTasks(false), search.WithBatchSize(1000), search.WithHeaderParam("X-Algolia-User-ID", "*"))
	if err != nil {
		panic(err)
	}
}
