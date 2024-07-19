package main

import (
	"context"
	"fmt"
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/personalization"
)

func testPersonalization(appID, apiKey string) int {
	personalizationClient, err := personalization.NewClient(appID, apiKey, personalization.US)
	if err != nil {
		panic(err)
	}
	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Millisecond)
	defer cancel()

	// it will fail expectedly because of the very short timeout to showcase the context usage.
	deleteUserProfileResponse, err := personalizationClient.DeleteUserProfile(
		personalizationClient.NewApiDeleteUserProfileRequest("userToken"),
		personalization.WithContext(ctx),
	)
	if err != nil {
		fmt.Printf("request error with DeleteUserProfile: %v\n", err)
		return 1
	}

	printResponse(deleteUserProfileResponse)

	return 0
}
