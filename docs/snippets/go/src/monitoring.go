// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package snippets

// >IMPORT
import "github.com/algolia/algoliasearch-client-go/v4/algolia/monitoring"

// IMPORT<

func SnippetForCustomDeleteOfMonitoring() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// >SEPARATOR customDelete default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
		"test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomGetOfMonitoring() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// >SEPARATOR customGet default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomGet(client.NewApiCustomGetRequest(
		"test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPostOfMonitoring() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPost default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPost(client.NewApiCustomPostRequest(
		"test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForCustomPutOfMonitoring() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPut default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CustomPut(client.NewApiCustomPutRequest(
		"test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetClusterIncidentsOfMonitoring() {
	/*
	   Snippet for the getClusterIncidents method.

	   getClusterIncidents
	*/

	// >SEPARATOR getClusterIncidents default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetClusterIncidents(client.NewApiGetClusterIncidentsRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetClusterStatusOfMonitoring() {
	/*
	   Snippet for the getClusterStatus method.

	   getClusterStatus
	*/

	// >SEPARATOR getClusterStatus default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetClusterStatus(client.NewApiGetClusterStatusRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetIncidentsOfMonitoring() {
	/*
	   Snippet for the getIncidents method.

	   getIncidents
	*/

	// >SEPARATOR getIncidents default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetIncidents()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetIndexingTimeOfMonitoring() {
	/*
	   Snippet for the getIndexingTime method.

	   getIndexingTime
	*/

	// >SEPARATOR getIndexingTime default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetIndexingTime(client.NewApiGetIndexingTimeRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetLatencyOfMonitoring() {
	/*
	   Snippet for the getLatency method.

	   getLatency
	*/

	// >SEPARATOR getLatency default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetLatency(client.NewApiGetLatencyRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetMetricsOfMonitoring() {
	/*
	   Snippet for the getMetrics method.

	   getMetrics
	*/

	// >SEPARATOR getMetrics default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetMetrics(client.NewApiGetMetricsRequest(
		monitoring.Metric("avg_build_time"), monitoring.Period("minute"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetReachabilityOfMonitoring() {
	/*
	   Snippet for the getReachability method.

	   getReachability
	*/

	// >SEPARATOR getReachability default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetReachability(client.NewApiGetReachabilityRequest(
		"c1-de",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetServersOfMonitoring() {
	/*
	   Snippet for the getServers method.

	   getInventory
	*/

	// >SEPARATOR getServers default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetServers()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetStatusOfMonitoring() {
	/*
	   Snippet for the getStatus method.

	   getStatus
	*/

	// >SEPARATOR getStatus default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetStatus()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForSetClientApiKeyOfMonitoring() {
	/*
	   Snippet for the setClientApiKey method.

	   switch API key
	*/

	// >SEPARATOR setClientApiKey default
	// Initialize the client
	client, err := monitoring.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	err = client.SetClientApiKey(
		"updated-api-key",
	)
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// SEPARATOR<
}
