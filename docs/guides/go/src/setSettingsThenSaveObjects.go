package main

import (
	"context"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/search"
)

func getAppIDFor(_ string) (string, error) {
	return "", nil // Implement your logic here
}

func getIndexingAPIKeyFor(_ string) (string, error) {
	return "", nil // Implement your logic here
}

func setSettingsThenSaveObjects() {
	playlists := []map[string]any{{ /* Your records */ }}

	for _, playlist := range playlists {
		// Fetch from your own data storage and with your own code
		// the associated application ID and API key for this user
		appID, err := getAppIDFor(playlist["user"].(string))
		if err != nil {
			fmt.Println(err)

			return
		}

		apiKey, err := getIndexingAPIKeyFor(playlist["user"].(string))
		if err != nil {
			fmt.Println(err)

			return
		}

		client, err := search.NewClient(appID, apiKey)
		if err != nil {
			fmt.Println(err)

			return
		}

		settings := &search.IndexSettings{
			AttributesForFaceting: []string{"filterOnly(user)"},
		}

		_, err = client.SetSettings(context.Background(), "<YOUR_INDEX_NAME>", settings, nil)
		if err != nil {
			panic(err)
		}

		_, err = client.SaveObjects(context.Background(), "<YOUR_INDEX_NAME>", playlists)
		if err != nil {
			panic(err)
		}
	}
}
