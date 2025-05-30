package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/analytics"
)

func testAnalytics(appID, apiKey string) int {
	indexName := getEnvWithDefault("ANALYTICS_INDEX", "test_index")
	analyticsClient, err := analytics.NewClient(appID, apiKey, analytics.US)
	if err != nil {
		panic(err)
	}

	getTopFilterForAttributeResponse, err := analyticsClient.GetTopFilterForAttribute("myAttribute1,myAttribute2", indexName, nil)
	if err != nil {
		fmt.Printf("request error with GetTopFilterForAttribute: %v\n", err)
		return 1
	}

	printResponse(getTopFilterForAttributeResponse)

	return 0
}
