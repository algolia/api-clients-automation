package main

import (
	"fmt"

	suggestions "github.com/algolia/algoliasearch-client-go/v4/algolia/query-suggestions"
)

func testQuerySuggestions(appID, apiKey string) int {
	suggestionsClient, err := suggestions.NewClient(appID, apiKey, suggestions.US)
	if err != nil {
		panic(err)
	}

	querySuggestionsIndex, err := suggestionsClient.GetAllConfigs()
	if err != nil {
		fmt.Printf("request error with GetAllConfigs: %v\n", err)
		return 1
	}

	printResponse(querySuggestionsIndex)

	return 0
}
