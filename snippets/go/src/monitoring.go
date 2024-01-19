package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/monitoring"
)

func SnippetForCustomDeleteOfMonitoring() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForCustomGetOfMonitoring() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomGet(client.NewApiCustomGetRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForCustomPostOfMonitoring() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomPost(client.NewApiCustomPostRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForCustomPutOfMonitoring() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomPut(client.NewApiCustomPutRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetClusterIncidentsOfMonitoring() {
	/*
	   Snippet for the getClusterIncidents method.

	   getClusterIncidents
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetClusterIncidents(client.NewApiGetClusterIncidentsRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetClusterStatusOfMonitoring() {
	/*
	   Snippet for the getClusterStatus method.

	   getClusterStatus
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetClusterStatus(client.NewApiGetClusterStatusRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetIncidentsOfMonitoring() {
	/*
	   Snippet for the getIncidents method.

	   getIncidents
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetIncidents()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetIndexingTimeOfMonitoring() {
	/*
	   Snippet for the getIndexingTime method.

	   getIndexingTime
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetIndexingTime(client.NewApiGetIndexingTimeRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetInventoryOfMonitoring() {
	/*
	   Snippet for the getInventory method.

	   getInventory
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetInventory()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetLatencyOfMonitoring() {
	/*
	   Snippet for the getLatency method.

	   getLatency
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetLatency(client.NewApiGetLatencyRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetMetricsOfMonitoring() {
	/*
	   Snippet for the getMetrics method.

	   getMetrics
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetMetrics(client.NewApiGetMetricsRequest(
		monitoring.Metric("avg_build_time"), monitoring.Period("minute"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetReachabilityOfMonitoring() {
	/*
	   Snippet for the getReachability method.

	   getReachability
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetReachability(client.NewApiGetReachabilityRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
func SnippetForGetStatusOfMonitoring() {
	/*
	   Snippet for the getStatus method.

	   getStatus
	*/

	// Initialize the client
	client, err := monitoring.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetStatus()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
}
