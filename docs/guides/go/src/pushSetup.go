package main

import (
	"encoding/json"
	"fmt"
	"os"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
)

func push() {
	// use the region matching your applicationID
	client, err := ingestion.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", ingestion.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	content, err := os.ReadFile("records.json")
	if err != nil {
		panic(err)
	}

	var records []ingestion.PushTaskRecords

	err = json.Unmarshal(content, &records)
	if err != nil {
		panic(err)
	}

	// setting `watch` to `true` will make the call synchronous
	resp, err := client.PushTask(client.NewApiPushTaskRequest(
		"YOUR_TASK_ID",
		ingestion.NewEmptyPushTaskPayload().SetAction(ingestion.Action("addObject")).SetRecords(records)).WithWatch(true))
	if err != nil {
		panic(err)
	}

	fmt.Printf("%#v\n", resp)
}
