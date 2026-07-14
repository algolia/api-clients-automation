package main

import (
	"fmt"
	"time"

	agentStudio "github.com/algolia/algoliasearch-client-go/v4/algolia/agent-studio"
)

func testAgentStudio(appID, apiKey string) int {
	client, err := agentStudio.NewClient(appID, apiKey)
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

// testAgentStudioStreaming creates a temporary agent, streams a completion
// from it with CreateAgentCompletionStream and deletes it. Go equivalent of
// playground/javascript/node/agentStudioStreaming.ts.
func testAgentStudioStreaming(appID, apiKey string) int {
	client, err := agentStudio.NewClient(appID, apiKey)
	if err != nil {
		panic(err)
	}

	fmt.Println("─── Step 1: Finding a provider ───")

	providers, err := client.ListProviders(client.NewApiListProvidersRequest())
	if err != nil {
		fmt.Printf("cannot list providers: %v\n", err)

		return 1
	}

	if len(providers.Data) == 0 {
		fmt.Println("no providers found, configure one first")

		return 1
	}

	provider := providers.Data[0]
	fmt.Printf("using provider %q (%s)\n", provider.GetName(), provider.GetId())

	fmt.Println("─── Step 2: Creating temporary agent ───")

	agent, err := client.CreateAgent(client.NewApiCreateAgentRequest(
		agentStudio.NewEmptyAgentConfigCreate().
			SetName(fmt.Sprintf("streaming-test-%d", time.Now().UnixMilli())).
			SetInstructions("You are a helpful assistant. Keep your answers short and concise.").
			SetProviderId(provider.GetId()).
			SetModel("gpt-4.1-mini"),
	))
	if err != nil {
		fmt.Printf("cannot create agent: %v\n", err)

		return 1
	}

	fmt.Printf("created agent %q (ID: %s)\n", agent.GetName(), agent.GetId())

	defer func() {
		fmt.Println("─── Teardown ───")

		err := client.DeleteAgent(client.NewApiDeleteAgentRequest(agent.GetId()))
		if err != nil {
			fmt.Printf("cannot delete agent %s: %v\n", agent.GetId(), err)

			return
		}

		fmt.Printf("deleted agent %s\n", agent.GetId())
	}()

	_, err = client.PublishAgent(client.NewApiPublishAgentRequest(agent.GetId()))
	if err != nil {
		fmt.Printf("cannot publish agent: %v\n", err)

		return 1
	}

	fmt.Println("agent published")

	fmt.Println("─── Step 3: Calling CreateAgentCompletionStream ───")

	stream, err := client.CreateAgentCompletionStream(client.NewApiCreateAgentCompletionRequest(
		agent.GetId(),
		agentStudio.CompatibilityMode("ai-sdk-5"),
		agentStudio.NewEmptyAgentCompletionRequest().SetMessages(agentStudio.ArrayOfMessageV5AsMessagesUnion(
			[]agentStudio.MessageV5{*agentStudio.UserMessageV5AsMessageV5(
				agentStudio.NewEmptyUserMessageV5().SetRole("user").SetParts(
					[]agentStudio.TextPartV5{
						*agentStudio.NewEmptyTextPartV5().SetType("text").SetText("Hello, what can you do? Keep it short."),
					}))},
		)),
	).WithStream(true))
	if err != nil {
		fmt.Printf("cannot create completion stream: %v\n", err)

		return 1
	}

	defer stream.Close()

	fmt.Println("─── Step 4: Receiving SSE events ───")

	start := time.Now()
	eventCount := 0

	for stream.Next() {
		eventCount++

		keys := make([]string, 0, len(stream.Current()))
		for key := range stream.Current() {
			keys = append(keys, key)
		}

		fmt.Printf("[EVENT #%d] (t+%.2fs) keys=%v\n", eventCount, time.Since(start).Seconds(), keys)
	}

	if err := stream.Err(); err != nil {
		fmt.Printf("stream error: %v\n", err)

		return 1
	}

	fmt.Printf("─── Done: received %d events in %.2fs ───\n", eventCount, time.Since(start).Seconds())

	return 0
}
