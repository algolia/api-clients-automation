package main

import (
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/next/insights"
)

func testInsights(appID, apiKey string) int {
	insightsClient, err := insights.NewClient(appID, apiKey, insights.US)
	if err != nil {
		panic(err)
	}

	events := []insights.EventsItems{
		*insights.ClickedObjectIDsAsEventsItems(insights.NewClickedObjectIDs("myEvent",
			insights.CLICK_EVENT_CLICK,
			"test_index",
			[]string{"myObjectID"},
			"myToken",
			insights.WithClickedObjectIDsTimestamp(1234567890))),
	}
	eventsResponse, err := insightsClient.PushEvents(events)
	if err != nil {
		fmt.Printf("request error with PushEvents: %v\n", err)
		return 1
	}

	printResponse(eventsResponse)

	return 0
}
