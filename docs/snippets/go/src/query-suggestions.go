// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package snippets

// >IMPORT
import suggestions "github.com/algolia/algoliasearch-client-go/v4/algolia/query-suggestions"

// IMPORT<

func SnippetForCreateConfigOfSuggestions() {
	/*
	   Snippet for the createConfig method.

	   createConfig
	*/

	// >SEPARATOR createConfig default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.CreateConfig(client.NewApiCreateConfigRequest(

		suggestions.NewEmptyConfigurationWithIndex().SetIndexName("<YOUR_INDEX_NAME>").SetSourceIndices(
			[]suggestions.SourceIndex{*suggestions.NewEmptySourceIndex().SetIndexName("<YOUR_INDEX_NAME>").SetFacets(
				[]suggestions.Facet{*suggestions.NewEmptyFacet().SetAttribute("test")}).SetGenerate(
				[][]string{
					[]string{"facetA", "facetB"},
					[]string{"facetC"}})}).SetLanguages(suggestions.ArrayOfStringAsLanguages(
			[]string{"french"})).SetExclude(
			[]string{"test"}),
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
func SnippetForCustomDeleteOfSuggestions() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// >SEPARATOR customDelete default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
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
func SnippetForCustomGetOfSuggestions() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// >SEPARATOR customGet default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
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
func SnippetForCustomPostOfSuggestions() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPost default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
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
func SnippetForCustomPutOfSuggestions() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPut default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
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
func SnippetForDeleteConfigOfSuggestions() {
	/*
	   Snippet for the deleteConfig method.

	   deleteConfig
	*/

	// >SEPARATOR deleteConfig default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.DeleteConfig(client.NewApiDeleteConfigRequest(
		"<YOUR_INDEX_NAME>",
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
func SnippetForGetAllConfigsOfSuggestions() {
	/*
	   Snippet for the getAllConfigs method.

	   getAllConfigs
	*/

	// >SEPARATOR getAllConfigs default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetAllConfigs()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForGetConfigOfSuggestions() {
	/*
	   Snippet for the getConfig method.

	   Retrieve QS config e2e
	*/

	// >SEPARATOR getConfig default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetConfig(client.NewApiGetConfigRequest(
		"<YOUR_INDEX_NAME>",
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
func SnippetForGetConfigStatusOfSuggestions() {
	/*
	   Snippet for the getConfigStatus method.

	   getConfigStatus
	*/

	// >SEPARATOR getConfigStatus default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetConfigStatus(client.NewApiGetConfigStatusRequest(
		"<YOUR_INDEX_NAME>",
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
func SnippetForGetLogFileOfSuggestions() {
	/*
	   Snippet for the getLogFile method.

	   getLogFile
	*/

	// >SEPARATOR getLogFile default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.GetLogFile(client.NewApiGetLogFileRequest(
		"<YOUR_INDEX_NAME>",
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
func SnippetForSetClientApiKeyOfSuggestions() {
	/*
	   Snippet for the setClientApiKey method.

	   switch API key
	*/

	// >SEPARATOR setClientApiKey default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
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
func SnippetForUpdateConfigOfSuggestions() {
	/*
	   Snippet for the updateConfig method.

	   updateConfig
	*/

	// >SEPARATOR updateConfig default
	// Initialize the client with your application region, eg. suggestions.ALGOLIA_APPLICATION_REGION
	client, err := suggestions.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", suggestions.US)
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.UpdateConfig(client.NewApiUpdateConfigRequest(
		"<YOUR_INDEX_NAME>",
		suggestions.NewEmptyConfiguration().SetSourceIndices(
			[]suggestions.SourceIndex{*suggestions.NewEmptySourceIndex().SetIndexName("<YOUR_INDEX_NAME>").SetFacets(
				[]suggestions.Facet{*suggestions.NewEmptyFacet().SetAttribute("test")}).SetGenerate(
				[][]string{
					[]string{"facetA", "facetB"},
					[]string{"facetC"}})}).SetLanguages(suggestions.ArrayOfStringAsLanguages(
			[]string{"french"})).SetExclude(
			[]string{"test"}),
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
