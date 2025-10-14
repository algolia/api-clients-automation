package main

import (
	"context"
	"fmt"
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/personalization"
)

func testPersonalization(ctx context.Context, appID, apiKey string) int {
	personalizationClient, err := personalization.NewClient(appID, apiKey, personalization.US)
	if err != nil {
		panic(err)
	}
	ctx, cancel := context.WithTimeout(ctx, 10*time.Millisecond)
	defer cancel()

	// it will fail expectedly because of the very short timeout to showcase the context usage.
	deleteUserProfileResponse, err := personalizationClient.DeleteUserProfile(ctx, "userToken")
	if err != nil {
		fmt.Printf("request error with DeleteUserProfile: %v\n", err)
		return 1
	}

	printResponse(deleteUserProfileResponse)

	return 0
}
