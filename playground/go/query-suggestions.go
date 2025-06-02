package main

import (
	"context"
	"fmt"

	suggestions "github.com/algolia/algoliasearch-client-go/v4/algolia/next/query-suggestions"
)

func testQuerySuggestions(ctx context.Context, appID, apiKey string) int {
	suggestionsClient, err := suggestions.NewClient(appID, apiKey, suggestions.US)
	if err != nil {
		panic(err)
	}

	querySuggestionsIndex, err := suggestionsClient.GetAllConfigs(ctx)
	if err != nil {
		fmt.Printf("request error with GetAllConfigs: %v\n", err)
		return 1
	}

	printResponse(querySuggestionsIndex)

	return 0
}
