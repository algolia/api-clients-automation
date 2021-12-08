package com.test;

/**
 * Hello world!
 *
 */

import com.algolia.auth.*;
import com.algolia.model.*;
import com.algolia.search.SearchApi;
import com.algolia.ApiClient;
import com.algolia.ApiException;
import com.algolia.Configuration;

public class App {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        // Configure API key authorization: apiKey
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token"
        // (defaults to null)
        // apiKey.setApiKeyPrefix("Token");

        // Configure API key authorization: appId
        ApiKeyAuth appId = (ApiKeyAuth) defaultClient.getAuthentication("appId");
        appId.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token"
        // (defaults to null)
        // appId.setApiKeyPrefix("Token");

        SearchApi apiInstance = new SearchApi(defaultClient);
        String indexName = "myIndexName"; // String | The index in which to perform the request.
        BatchObject batchObject = new BatchObject(); // BatchObject |
        try {
            BatchResponse result = apiInstance.batch(indexName, batchObject);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SearchApi#batch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
