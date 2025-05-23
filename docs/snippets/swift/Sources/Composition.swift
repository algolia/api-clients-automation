#if canImport(Core)
    import Core
#endif
// >IMPORT
import Composition

// IMPORT<

final class CompositionClientSnippet {
    /// Snippet for the search method.
    ///
    /// search
    func snippetForSearch() async throws {
        // >SEPARATOR search default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: CompositionSearchResponse<CompositionHit> = try await client.search(
            compositionID: "foo",
            requestBody: CompositionRequestBody(params: CompositionParams(query: "batman"))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchForFacetValues method.
    ///
    /// searchForFacetValues
    func snippetForSearchForFacetValues() async throws {
        // >SEPARATOR searchForFacetValues default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchForFacetValues(
            compositionID: "foo",
            facetName: "brand",
            searchForFacetValuesRequest: CompositionSearchForFacetValuesRequest(
                params: CompositionSearchForFacetValuesParams(maxFacetHits: 10)
            )
        )
        // >LOG
        // SEPARATOR<
    }
}
