package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func globalAlgoliaUserID() {
	client, err := search.NewClient("YourApplicationID", "YourAdminAPIKey")
	if err != nil {
		fmt.Println(err)
	}

	client.AddDefaultHeader("X-Algolia-UserToken", "test-user-123")
}
