// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package snippets

// >IMPORT
import "github.com/algolia/algoliasearch-client-go/v4/algolia/composition"

// IMPORT<

func SnippetForSearchOfComposition() {
	/*
	   Snippet for the search method.

	   search
	*/

	// >SEPARATOR search default
	// Initialize the client
	client, err := composition.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.Search(client.NewApiSearchRequest(
		"foo",
		composition.NewEmptyRequestBody().SetParams(
			composition.NewEmptyParams().SetQuery("batman"))))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
func SnippetForSearchForFacetValuesOfComposition() {
	/*
	   Snippet for the searchForFacetValues method.

	   searchForFacetValues
	*/

	// >SEPARATOR searchForFacetValues default
	// Initialize the client
	client, err := composition.NewClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	response, err := client.SearchForFacetValues(client.NewApiSearchForFacetValuesRequest(
		"foo", "brand").WithSearchForFacetValuesRequest(
		composition.NewEmptySearchForFacetValuesRequest().SetParams(
			composition.NewEmptySearchForFacetValuesParams().SetMaxFacetHits(10))))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// >LOG
	// use the model directly
	print(response)
	// SEPARATOR<
}
