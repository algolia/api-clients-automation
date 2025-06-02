package main

import (
	"context"
	"flag"
	"fmt"
	"os"

	"github.com/joho/godotenv"
)

func main() {
	fmt.Println("Go playground")
	err := godotenv.Load("../.env")
	if err != nil {
		panic(fmt.Errorf("error loading .env file: %w", err))
	}

	appID := os.Getenv("ALGOLIA_APPLICATION_ID")
	apiKey := os.Getenv("ALGOLIA_ADMIN_KEY")

	var client string
	var returnCode int

	flag.StringVar(&client, "client", "", "client name")
	flag.Parse()

	if client == "" {
		fmt.Println("Please specify a client name")
		os.Exit(1)
	}

	// debug.Enable()

	ctx := context.Background()

	switch client {
	case "ingestion":
		returnCode = testIngestion(ctx, appID, apiKey)
	case "search":
		returnCode = testSearch(ctx, appID, apiKey)
	case "analytics":
		returnCode = testAnalytics(ctx, appID, apiKey)
	case "insights":
		returnCode = testInsights(ctx, appID, apiKey)
	case "personalization":
		returnCode = testPersonalization(ctx, appID, apiKey)
	case "query-suggestions":
		returnCode = testQuerySuggestions(ctx, appID, apiKey)
	case "recommend":
		returnCode = testRecommend(ctx, appID, apiKey)
	default:
		fmt.Println("Please specify a valid client name")
		os.Exit(1)
	}

	os.Exit(returnCode)
}
