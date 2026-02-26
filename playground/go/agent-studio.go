package main

import (
	"fmt"

	agentStudio "github.com/algolia/algoliasearch-client-go/v4/algolia/agent-studio"
)

func testAgentStudio(appID, apiKey string) int {
	client, err := agentStudio.NewClient(appID, apiKey, agentStudio.US)
	if err != nil {
		panic(err)
	}

	response, err := client.ListAgents(client.NewApiListAgentsRequest())
	if err != nil {
		fmt.Printf("request error: %v\n", err)

		return 1
	}

	fmt.Println("List of agents:")
	for _, agent := range response.Data {
		fmt.Printf("- %s (ID: %s)\n", agent.Name, agent.Id)
	}

	return 0
}
