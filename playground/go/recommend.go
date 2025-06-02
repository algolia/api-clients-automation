package main

import (
	"context"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/recommend"
)

func testRecommend(ctx context.Context, appID, apiKey string) int {
	recommendClient, err := recommend.NewClient(appID, apiKey)
	if err != nil {
		panic(err)
	}

	/*
		params := []recommend.RecommendationsRequest{
			recommend.RecommendationRequestAsRecommendationsRequest(recommend.NewRecommendationRequest(recommend.RECOMMENDATIONMODELS_BOUGHT_TOGETHER, "test_query", "test_index", 0)),
		}
	*/
	// alternative way to create the payloads, a similar approach can be used with any of the other clients
	params := []recommend.RecommendationsRequest{{
		BoughtTogetherQuery: &recommend.BoughtTogetherQuery{
			Model:     recommend.FBT_MODEL_BOUGHT_TOGETHER,
			ObjectID:  "test_query",
			IndexName: "test_index",
			Threshold: 0,
		},
	}}

	searchResponse, err := recommendClient.GetRecommendations(ctx, params)
	if err != nil {
		fmt.Printf("request error with SearchSingleIndex: %v\n", err)
		return 1
	}

	printResponse(searchResponse)

	return 0
}
