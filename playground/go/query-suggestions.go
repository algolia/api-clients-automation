package main

import (
	"fmt"
)

func testQuerySuggestions(appID, apiKey string) int {
	suggestionsClient, err := suggestions.NewClient(appID, apiKey, suggestions.US)
	if err != nil {
		panic(err)
	}

	// if there is no params for the requests, we don't need to give empty request instance such as `suggestionsClient.NewApiGetAllConfigsRequest()`.
	querySuggestionsIndex, err := suggestionsClient.GetAllConfigs()
	if err != nil {
		fmt.Printf("request error with GetAllConfigs: %v\n", err)
		return 1
	}

	printResponse(querySuggestionsIndex)

	return 0
}
