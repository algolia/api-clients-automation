package main

import (
	"context"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func getAllAppIDConfigurations() ([]struct{ appID, apiKey string }, error) {
	return []struct{ appID, apiKey string }{ /* A list of your MCM AppID/ApiKey pairs */ }, nil
}

func saveObjectsMCM() {
	playlists := []map[string]any{{ /* Your records */ }}

	// Fetch from your own data storage and with your own code
	// the list of application IDs and API keys to target each cluster
	configurations, err := getAllAppIDConfigurations()
	if err != nil {
		fmt.Println(err)

		return
	}

	// Send the records to each cluster
	for _, configuration := range configurations {
		client, err := search.NewClient(configuration.appID, configuration.apiKey)
		if err != nil {
			fmt.Println(err)

			return
		}

		_, err = client.SaveObjects(context.Background(), "<YOUR_INDEX_NAME>", playlists)
		if err != nil {
			panic(err)
		}
	}
}
