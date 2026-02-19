import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

let getUserToken = { "" } // Implement your logic here

func abTestImplementationChecklist() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    // Set the searchParams and get the current user token
    let userToken = getUserToken()

    // Is the user token anonymous?
    let searchParams =
        if userToken.isEmpty || userToken == "YOUR_ANONYMOUS_USER_TOKEN" {
            // Disable A/B testing for this request
            SearchSearchParams.searchSearchParamsObject(
                SearchSearchParamsObject(query: "User search query", enableABTest: false)
            )
        } else {
            // Set the user token to the current user token
            SearchSearchParams.searchSearchParamsObject(
                SearchSearchParamsObject(query: "User search query", userToken: userToken, enableABTest: true)
            )
        }

    do {
        // Perform the searchSingleIndex
        let result: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: searchParams
        )
        // SearchSingleIndex results
        print(result)
    } catch {
        // SearchSingleIndex errors
        print(error)
    }
}
