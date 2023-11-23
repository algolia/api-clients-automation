# Org.OpenAPITools.Api.SearchApi

All URIs are relative to *https://myAppId.algolia.net*

| Method | HTTP request | Description |
|--------|--------------|-------------|
| [**AddApiKey**](SearchApi.md#addapikey) | **POST** /1/keys | Add API key. |
| [**AddOrUpdateObject**](SearchApi.md#addorupdateobject) | **PUT** /1/indexes/{indexName}/{objectID} | Add or update a record (using objectID). |
| [**AppendSource**](SearchApi.md#appendsource) | **POST** /1/security/sources/append | Add a source. |
| [**AssignUserId**](SearchApi.md#assignuserid) | **POST** /1/clusters/mapping | Assign or move a user ID. |
| [**Batch**](SearchApi.md#batch) | **POST** /1/indexes/{indexName}/batch | Batch write operations on one index. |
| [**BatchAssignUserIds**](SearchApi.md#batchassignuserids) | **POST** /1/clusters/mapping/batch | Batch assign userIDs. |
| [**BatchDictionaryEntries**](SearchApi.md#batchdictionaryentries) | **POST** /1/dictionaries/{dictionaryName}/batch | Batch dictionary entries. |
| [**Browse**](SearchApi.md#browse) | **POST** /1/indexes/{indexName}/browse | Get all records from an index. |
| [**ClearAllSynonyms**](SearchApi.md#clearallsynonyms) | **POST** /1/indexes/{indexName}/synonyms/clear | Delete all synonyms. |
| [**ClearObjects**](SearchApi.md#clearobjects) | **POST** /1/indexes/{indexName}/clear | Delete all records from an index. |
| [**ClearRules**](SearchApi.md#clearrules) | **POST** /1/indexes/{indexName}/rules/clear | Delete all rules. |
| [**Del**](SearchApi.md#del) | **DELETE** /1{path} | Send requests to the Algolia REST API. |
| [**DeleteApiKey**](SearchApi.md#deleteapikey) | **DELETE** /1/keys/{key} | Delete API key. |
| [**DeleteBy**](SearchApi.md#deleteby) | **POST** /1/indexes/{indexName}/deleteByQuery | Delete all records matching a query. |
| [**DeleteIndex**](SearchApi.md#deleteindex) | **DELETE** /1/indexes/{indexName} | Delete index. |
| [**DeleteObject**](SearchApi.md#deleteobject) | **DELETE** /1/indexes/{indexName}/{objectID} | Delete a record. |
| [**DeleteRule**](SearchApi.md#deleterule) | **DELETE** /1/indexes/{indexName}/rules/{objectID} | Delete a rule. |
| [**DeleteSource**](SearchApi.md#deletesource) | **DELETE** /1/security/sources/{source} | Remove a source. |
| [**DeleteSynonym**](SearchApi.md#deletesynonym) | **DELETE** /1/indexes/{indexName}/synonyms/{objectID} | Delete a synonym. |
| [**Get**](SearchApi.md#get) | **GET** /1{path} | Send requests to the Algolia REST API. |
| [**GetApiKey**](SearchApi.md#getapikey) | **GET** /1/keys/{key} | Get API key permissions. |
| [**GetDictionaryLanguages**](SearchApi.md#getdictionarylanguages) | **GET** /1/dictionaries/*/languages | List available languages. |
| [**GetDictionarySettings**](SearchApi.md#getdictionarysettings) | **GET** /1/dictionaries/*/settings | Get stop word settings. |
| [**GetLogs**](SearchApi.md#getlogs) | **GET** /1/logs | Return the latest log entries. |
| [**GetObject**](SearchApi.md#getobject) | **GET** /1/indexes/{indexName}/{objectID} | Get a record. |
| [**GetObjects**](SearchApi.md#getobjects) | **POST** /1/indexes/*/objects | Get multiple records. |
| [**GetRule**](SearchApi.md#getrule) | **GET** /1/indexes/{indexName}/rules/{objectID} | Get a rule. |
| [**GetSettings**](SearchApi.md#getsettings) | **GET** /1/indexes/{indexName}/settings | Get index settings. |
| [**GetSources**](SearchApi.md#getsources) | **GET** /1/security/sources | Get all allowed IP addresses. |
| [**GetSynonym**](SearchApi.md#getsynonym) | **GET** /1/indexes/{indexName}/synonyms/{objectID} | Get a synonym object. |
| [**GetTask**](SearchApi.md#gettask) | **GET** /1/indexes/{indexName}/task/{taskID} | Check a task&#39;s status. |
| [**GetTopUserIds**](SearchApi.md#gettopuserids) | **GET** /1/clusters/mapping/top | Get top userID. |
| [**GetUserId**](SearchApi.md#getuserid) | **GET** /1/clusters/mapping/{userID} | Get userID. |
| [**HasPendingMappings**](SearchApi.md#haspendingmappings) | **GET** /1/clusters/mapping/pending | Get migration and user mapping status. |
| [**ListApiKeys**](SearchApi.md#listapikeys) | **GET** /1/keys | List API keys. |
| [**ListClusters**](SearchApi.md#listclusters) | **GET** /1/clusters | List clusters. |
| [**ListIndices**](SearchApi.md#listindices) | **GET** /1/indexes | List indices. |
| [**ListUserIds**](SearchApi.md#listuserids) | **GET** /1/clusters/mapping | List userIDs. |
| [**MultipleBatch**](SearchApi.md#multiplebatch) | **POST** /1/indexes/*/batch | Batch write operations on multiple indices. |
| [**OperationIndex**](SearchApi.md#operationindex) | **POST** /1/indexes/{indexName}/operation | Copy, move, or rename an index. |
| [**PartialUpdateObject**](SearchApi.md#partialupdateobject) | **POST** /1/indexes/{indexName}/{objectID}/partial | Update record attributes. |
| [**Post**](SearchApi.md#post) | **POST** /1{path} | Send requests to the Algolia REST API. |
| [**Put**](SearchApi.md#put) | **PUT** /1{path} | Send requests to the Algolia REST API. |
| [**RemoveUserId**](SearchApi.md#removeuserid) | **DELETE** /1/clusters/mapping/{userID} | Remove userID. |
| [**ReplaceSources**](SearchApi.md#replacesources) | **PUT** /1/security/sources | Replace all sources. |
| [**RestoreApiKey**](SearchApi.md#restoreapikey) | **POST** /1/keys/{key}/restore | Restore API key. |
| [**SaveObject**](SearchApi.md#saveobject) | **POST** /1/indexes/{indexName} | Add or update a record. |
| [**SaveRule**](SearchApi.md#saverule) | **PUT** /1/indexes/{indexName}/rules/{objectID} | Create or update a rule. |
| [**SaveRules**](SearchApi.md#saverules) | **POST** /1/indexes/{indexName}/rules/batch | Save a batch of rules. |
| [**SaveSynonym**](SearchApi.md#savesynonym) | **PUT** /1/indexes/{indexName}/synonyms/{objectID} | Save a synonym. |
| [**SaveSynonyms**](SearchApi.md#savesynonyms) | **POST** /1/indexes/{indexName}/synonyms/batch | Save a batch of synonyms. |
| [**Search**](SearchApi.md#search) | **POST** /1/indexes/*/queries | Search multiple indices. |
| [**SearchDictionaryEntries**](SearchApi.md#searchdictionaryentries) | **POST** /1/dictionaries/{dictionaryName}/search | Search dictionary entries. |
| [**SearchForFacetValues**](SearchApi.md#searchforfacetvalues) | **POST** /1/indexes/{indexName}/facets/{facetName}/query | Search for facet values. |
| [**SearchRules**](SearchApi.md#searchrules) | **POST** /1/indexes/{indexName}/rules/search | Search for rules. |
| [**SearchSingleIndex**](SearchApi.md#searchsingleindex) | **POST** /1/indexes/{indexName}/query | Search an index. |
| [**SearchSynonyms**](SearchApi.md#searchsynonyms) | **POST** /1/indexes/{indexName}/synonyms/search | Search for synonyms. |
| [**SearchUserIds**](SearchApi.md#searchuserids) | **POST** /1/clusters/mapping/search | Search for a user ID. |
| [**SetDictionarySettings**](SearchApi.md#setdictionarysettings) | **PUT** /1/dictionaries/*/settings | Set stop word settings. |
| [**SetSettings**](SearchApi.md#setsettings) | **PUT** /1/indexes/{indexName}/settings | Update index settings. |
| [**UpdateApiKey**](SearchApi.md#updateapikey) | **PUT** /1/keys/{key} | Update an API key. |

<a id="addapikey"></a>
# **AddApiKey**
> AddApiKeyResponse AddApiKey (ApiKey apiKey)

Add API key.

Add a new API key with specific permissions and restrictions. The request must be authenticated with the admin API key. The response returns an API key string. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class AddApiKeyExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var apiKey = new ApiKey(); // ApiKey | 

            try
            {
                // Add API key.
                AddApiKeyResponse result = apiInstance.AddApiKey(apiKey);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.AddApiKey: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the AddApiKeyWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Add API key.
    ApiResponse<AddApiKeyResponse> response = apiInstance.AddApiKeyWithHttpInfo(apiKey);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.AddApiKeyWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **apiKey** | [**ApiKey**](ApiKey.md) |  |  |

### Return type

[**AddApiKeyResponse**](AddApiKeyResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="addorupdateobject"></a>
# **AddOrUpdateObject**
> UpdatedAtWithObjectIdResponse AddOrUpdateObject (string indexName, string objectID, Object body)

Add or update a record (using objectID).

If you use an existing `objectID`, the existing record will be replaced with the new one.  To update only some attributes of an existing record, use the [`partial` operation](#tag/Records/operation/partialUpdateObject) instead.  To add multiple records to your index in a single API request, use the [`batch` operation](#tag/Records/operation/batch). 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class AddOrUpdateObjectExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = 123;  // string | Unique record (object) identifier.
            var body = null;  // Object | Algolia record.

            try
            {
                // Add or update a record (using objectID).
                UpdatedAtWithObjectIdResponse result = apiInstance.AddOrUpdateObject(indexName, objectID, body);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.AddOrUpdateObject: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the AddOrUpdateObjectWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Add or update a record (using objectID).
    ApiResponse<UpdatedAtWithObjectIdResponse> response = apiInstance.AddOrUpdateObjectWithHttpInfo(indexName, objectID, body);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.AddOrUpdateObjectWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique record (object) identifier. |  |
| **body** | **Object** | Algolia record. |  |

### Return type

[**UpdatedAtWithObjectIdResponse**](UpdatedAtWithObjectIdResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="appendsource"></a>
# **AppendSource**
> CreatedAtResponse AppendSource (Source source)

Add a source.

Add a source to the list of allowed sources.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class AppendSourceExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var source = new Source(); // Source | Source to add.

            try
            {
                // Add a source.
                CreatedAtResponse result = apiInstance.AppendSource(source);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.AppendSource: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the AppendSourceWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Add a source.
    ApiResponse<CreatedAtResponse> response = apiInstance.AppendSourceWithHttpInfo(source);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.AppendSourceWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **source** | [**Source**](Source.md) | Source to add. |  |

### Return type

[**CreatedAtResponse**](CreatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="assignuserid"></a>
# **AssignUserId**
> CreatedAtResponse AssignUserId (string xAlgoliaUserID, AssignUserIdParams assignUserIdParams)

Assign or move a user ID.

Assign or move a user ID to a cluster. The time it takes to move a user is proportional to the amount of data linked to the user ID. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class AssignUserIdExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var xAlgoliaUserID = "xAlgoliaUserID_example";  // string | userID to assign.
            var assignUserIdParams = new AssignUserIdParams(); // AssignUserIdParams | 

            try
            {
                // Assign or move a user ID.
                CreatedAtResponse result = apiInstance.AssignUserId(xAlgoliaUserID, assignUserIdParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.AssignUserId: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the AssignUserIdWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Assign or move a user ID.
    ApiResponse<CreatedAtResponse> response = apiInstance.AssignUserIdWithHttpInfo(xAlgoliaUserID, assignUserIdParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.AssignUserIdWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **xAlgoliaUserID** | **string** | userID to assign. |  |
| **assignUserIdParams** | [**AssignUserIdParams**](AssignUserIdParams.md) |  |  |

### Return type

[**CreatedAtResponse**](CreatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="batch"></a>
# **Batch**
> BatchResponse Batch (string indexName, BatchWriteParams batchWriteParams)

Batch write operations on one index.

To reduce the time spent on network round trips, you can perform several write actions in a single API call. Actions are applied in the order they are specified. The supported `action`s are equivalent to the individual operations of the same name. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class BatchExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var batchWriteParams = new BatchWriteParams(); // BatchWriteParams | 

            try
            {
                // Batch write operations on one index.
                BatchResponse result = apiInstance.Batch(indexName, batchWriteParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.Batch: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the BatchWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Batch write operations on one index.
    ApiResponse<BatchResponse> response = apiInstance.BatchWithHttpInfo(indexName, batchWriteParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.BatchWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **batchWriteParams** | [**BatchWriteParams**](BatchWriteParams.md) |  |  |

### Return type

[**BatchResponse**](BatchResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="batchassignuserids"></a>
# **BatchAssignUserIds**
> CreatedAtResponse BatchAssignUserIds (string xAlgoliaUserID, BatchAssignUserIdsParams batchAssignUserIdsParams)

Batch assign userIDs.

Assign multiple user IDs to a cluster. **You can't _move_ users with this operation.**. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class BatchAssignUserIdsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var xAlgoliaUserID = "xAlgoliaUserID_example";  // string | userID to assign.
            var batchAssignUserIdsParams = new BatchAssignUserIdsParams(); // BatchAssignUserIdsParams | 

            try
            {
                // Batch assign userIDs.
                CreatedAtResponse result = apiInstance.BatchAssignUserIds(xAlgoliaUserID, batchAssignUserIdsParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.BatchAssignUserIds: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the BatchAssignUserIdsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Batch assign userIDs.
    ApiResponse<CreatedAtResponse> response = apiInstance.BatchAssignUserIdsWithHttpInfo(xAlgoliaUserID, batchAssignUserIdsParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.BatchAssignUserIdsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **xAlgoliaUserID** | **string** | userID to assign. |  |
| **batchAssignUserIdsParams** | [**BatchAssignUserIdsParams**](BatchAssignUserIdsParams.md) |  |  |

### Return type

[**CreatedAtResponse**](CreatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="batchdictionaryentries"></a>
# **BatchDictionaryEntries**
> UpdatedAtResponse BatchDictionaryEntries (DictionaryType dictionaryName, BatchDictionaryEntriesParams batchDictionaryEntriesParams)

Batch dictionary entries.

Add or remove a batch of dictionary entries.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class BatchDictionaryEntriesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var dictionaryName = new DictionaryType(); // DictionaryType | Dictionary to search in.
            var batchDictionaryEntriesParams = new BatchDictionaryEntriesParams(); // BatchDictionaryEntriesParams | 

            try
            {
                // Batch dictionary entries.
                UpdatedAtResponse result = apiInstance.BatchDictionaryEntries(dictionaryName, batchDictionaryEntriesParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.BatchDictionaryEntries: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the BatchDictionaryEntriesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Batch dictionary entries.
    ApiResponse<UpdatedAtResponse> response = apiInstance.BatchDictionaryEntriesWithHttpInfo(dictionaryName, batchDictionaryEntriesParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.BatchDictionaryEntriesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **dictionaryName** | [**DictionaryType**](DictionaryType.md) | Dictionary to search in. |  |
| **batchDictionaryEntriesParams** | [**BatchDictionaryEntriesParams**](BatchDictionaryEntriesParams.md) |  |  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="browse"></a>
# **Browse**
> BrowseResponse Browse (string indexName, BrowseParams browseParams = null)

Get all records from an index.

Retrieve up to 1,000 records per call. Supports full-text search and filters. For better performance, it doesn't support: - The `distinct` query parameter - Sorting by typos, proximity, words, or geographical distance. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class BrowseExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var browseParams = new BrowseParams(); // BrowseParams |  (optional) 

            try
            {
                // Get all records from an index.
                BrowseResponse result = apiInstance.Browse(indexName, browseParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.Browse: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the BrowseWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get all records from an index.
    ApiResponse<BrowseResponse> response = apiInstance.BrowseWithHttpInfo(indexName, browseParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.BrowseWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **browseParams** | [**BrowseParams**](BrowseParams.md) |  | [optional]  |

### Return type

[**BrowseResponse**](BrowseResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="clearallsynonyms"></a>
# **ClearAllSynonyms**
> UpdatedAtResponse ClearAllSynonyms (string indexName, bool? forwardToReplicas = null)

Delete all synonyms.

Delete all synonyms in the index.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ClearAllSynonymsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var forwardToReplicas = true;  // bool? | Indicates whether changed index settings are forwarded to the replica indices. (optional) 

            try
            {
                // Delete all synonyms.
                UpdatedAtResponse result = apiInstance.ClearAllSynonyms(indexName, forwardToReplicas);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.ClearAllSynonyms: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the ClearAllSynonymsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Delete all synonyms.
    ApiResponse<UpdatedAtResponse> response = apiInstance.ClearAllSynonymsWithHttpInfo(indexName, forwardToReplicas);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.ClearAllSynonymsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **forwardToReplicas** | **bool?** | Indicates whether changed index settings are forwarded to the replica indices. | [optional]  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="clearobjects"></a>
# **ClearObjects**
> UpdatedAtResponse ClearObjects (string indexName)

Delete all records from an index.

Delete the records but leave settings and index-specific API keys untouched.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ClearObjectsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.

            try
            {
                // Delete all records from an index.
                UpdatedAtResponse result = apiInstance.ClearObjects(indexName);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.ClearObjects: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the ClearObjectsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Delete all records from an index.
    ApiResponse<UpdatedAtResponse> response = apiInstance.ClearObjectsWithHttpInfo(indexName);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.ClearObjectsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="clearrules"></a>
# **ClearRules**
> UpdatedAtResponse ClearRules (string indexName, bool? forwardToReplicas = null)

Delete all rules.

Delete all rules in the index.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ClearRulesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var forwardToReplicas = true;  // bool? | Indicates whether changed index settings are forwarded to the replica indices. (optional) 

            try
            {
                // Delete all rules.
                UpdatedAtResponse result = apiInstance.ClearRules(indexName, forwardToReplicas);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.ClearRules: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the ClearRulesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Delete all rules.
    ApiResponse<UpdatedAtResponse> response = apiInstance.ClearRulesWithHttpInfo(indexName, forwardToReplicas);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.ClearRulesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **forwardToReplicas** | **bool?** | Indicates whether changed index settings are forwarded to the replica indices. | [optional]  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="del"></a>
# **Del**
> Object Del (string path, Dictionary<string, Object> parameters = null)

Send requests to the Algolia REST API.

This method allow you to send requests to the Algolia REST API.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class DelExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var path = /keys;  // string | Path of the endpoint, anything after \"/1\" must be specified.
            var parameters = new Dictionary<string, Object>(); // Dictionary<string, Object> | Query parameters to apply to the current query. (optional) 

            try
            {
                // Send requests to the Algolia REST API.
                Object result = apiInstance.Del(path, parameters);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.Del: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the DelWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Send requests to the Algolia REST API.
    ApiResponse<Object> response = apiInstance.DelWithHttpInfo(path, parameters);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.DelWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **path** | **string** | Path of the endpoint, anything after \&quot;/1\&quot; must be specified. |  |
| **parameters** | [**Dictionary&lt;string, Object&gt;**](Object.md) | Query parameters to apply to the current query. | [optional]  |

### Return type

**Object**

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="deleteapikey"></a>
# **DeleteApiKey**
> DeleteApiKeyResponse DeleteApiKey (string key)

Delete API key.

Delete an existing API key. The request must be authenticated with the admin API key. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class DeleteApiKeyExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var key = YourAPIKey;  // string | API key.

            try
            {
                // Delete API key.
                DeleteApiKeyResponse result = apiInstance.DeleteApiKey(key);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.DeleteApiKey: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the DeleteApiKeyWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Delete API key.
    ApiResponse<DeleteApiKeyResponse> response = apiInstance.DeleteApiKeyWithHttpInfo(key);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.DeleteApiKeyWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **key** | **string** | API key. |  |

### Return type

[**DeleteApiKeyResponse**](DeleteApiKeyResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="deleteby"></a>
# **DeleteBy**
> DeletedAtResponse DeleteBy (string indexName, DeleteByParams deleteByParams)

Delete all records matching a query.

This operation doesn't support all the query options, only its filters (numeric, facet, or tag) and geo queries. It doesn't accept empty filters or queries. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class DeleteByExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var deleteByParams = new DeleteByParams(); // DeleteByParams | 

            try
            {
                // Delete all records matching a query.
                DeletedAtResponse result = apiInstance.DeleteBy(indexName, deleteByParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.DeleteBy: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the DeleteByWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Delete all records matching a query.
    ApiResponse<DeletedAtResponse> response = apiInstance.DeleteByWithHttpInfo(indexName, deleteByParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.DeleteByWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **deleteByParams** | [**DeleteByParams**](DeleteByParams.md) |  |  |

### Return type

[**DeletedAtResponse**](DeletedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="deleteindex"></a>
# **DeleteIndex**
> DeletedAtResponse DeleteIndex (string indexName)

Delete index.

Delete an existing index.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class DeleteIndexExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.

            try
            {
                // Delete index.
                DeletedAtResponse result = apiInstance.DeleteIndex(indexName);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.DeleteIndex: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the DeleteIndexWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Delete index.
    ApiResponse<DeletedAtResponse> response = apiInstance.DeleteIndexWithHttpInfo(indexName);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.DeleteIndexWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |

### Return type

[**DeletedAtResponse**](DeletedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="deleteobject"></a>
# **DeleteObject**
> DeletedAtResponse DeleteObject (string indexName, string objectID)

Delete a record.

To delete a set of records matching a query, use the [`deleteByQuery` operation](#tag/Records/operation/deleteBy) instead.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class DeleteObjectExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = 123;  // string | Unique record (object) identifier.

            try
            {
                // Delete a record.
                DeletedAtResponse result = apiInstance.DeleteObject(indexName, objectID);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.DeleteObject: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the DeleteObjectWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Delete a record.
    ApiResponse<DeletedAtResponse> response = apiInstance.DeleteObjectWithHttpInfo(indexName, objectID);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.DeleteObjectWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique record (object) identifier. |  |

### Return type

[**DeletedAtResponse**](DeletedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="deleterule"></a>
# **DeleteRule**
> UpdatedAtResponse DeleteRule (string indexName, string objectID, bool? forwardToReplicas = null)

Delete a rule.

Delete a rule by its `objectID`. To find the `objectID` for rules, use the [`search` operation](#tag/Rules/operation/searchRules).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class DeleteRuleExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = a-rule-id;  // string | Unique identifier of a rule object.
            var forwardToReplicas = true;  // bool? | Indicates whether changed index settings are forwarded to the replica indices. (optional) 

            try
            {
                // Delete a rule.
                UpdatedAtResponse result = apiInstance.DeleteRule(indexName, objectID, forwardToReplicas);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.DeleteRule: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the DeleteRuleWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Delete a rule.
    ApiResponse<UpdatedAtResponse> response = apiInstance.DeleteRuleWithHttpInfo(indexName, objectID, forwardToReplicas);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.DeleteRuleWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique identifier of a rule object. |  |
| **forwardToReplicas** | **bool?** | Indicates whether changed index settings are forwarded to the replica indices. | [optional]  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="deletesource"></a>
# **DeleteSource**
> DeleteSourceResponse DeleteSource (string source)

Remove a source.

Remove a source from the list of allowed sources.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class DeleteSourceExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var source = 10.0.0.1/32;  // string | IP address range of the source.

            try
            {
                // Remove a source.
                DeleteSourceResponse result = apiInstance.DeleteSource(source);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.DeleteSource: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the DeleteSourceWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Remove a source.
    ApiResponse<DeleteSourceResponse> response = apiInstance.DeleteSourceWithHttpInfo(source);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.DeleteSourceWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **source** | **string** | IP address range of the source. |  |

### Return type

[**DeleteSourceResponse**](DeleteSourceResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="deletesynonym"></a>
# **DeleteSynonym**
> DeletedAtResponse DeleteSynonym (string indexName, string objectID, bool? forwardToReplicas = null)

Delete a synonym.

Delete a synonym by its `objectID`. To find the object IDs of your synonyms, use the [`search` operation](#tag/Synonyms/operation/searchSynonyms).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class DeleteSynonymExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = synonymID;  // string | Unique identifier of a synonym object.
            var forwardToReplicas = true;  // bool? | Indicates whether changed index settings are forwarded to the replica indices. (optional) 

            try
            {
                // Delete a synonym.
                DeletedAtResponse result = apiInstance.DeleteSynonym(indexName, objectID, forwardToReplicas);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.DeleteSynonym: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the DeleteSynonymWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Delete a synonym.
    ApiResponse<DeletedAtResponse> response = apiInstance.DeleteSynonymWithHttpInfo(indexName, objectID, forwardToReplicas);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.DeleteSynonymWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique identifier of a synonym object. |  |
| **forwardToReplicas** | **bool?** | Indicates whether changed index settings are forwarded to the replica indices. | [optional]  |

### Return type

[**DeletedAtResponse**](DeletedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="get"></a>
# **Get**
> Object Get (string path, Dictionary<string, Object> parameters = null)

Send requests to the Algolia REST API.

This method allow you to send requests to the Algolia REST API.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var path = /keys;  // string | Path of the endpoint, anything after \"/1\" must be specified.
            var parameters = new Dictionary<string, Object>(); // Dictionary<string, Object> | Query parameters to apply to the current query. (optional) 

            try
            {
                // Send requests to the Algolia REST API.
                Object result = apiInstance.Get(path, parameters);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.Get: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Send requests to the Algolia REST API.
    ApiResponse<Object> response = apiInstance.GetWithHttpInfo(path, parameters);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **path** | **string** | Path of the endpoint, anything after \&quot;/1\&quot; must be specified. |  |
| **parameters** | [**Dictionary&lt;string, Object&gt;**](Object.md) | Query parameters to apply to the current query. | [optional]  |

### Return type

**Object**

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getapikey"></a>
# **GetApiKey**
> GetApiKeyResponse GetApiKey (string key)

Get API key permissions.

Get the permissions and restrictions of a specific API key. When authenticating with the admin API key, you can request information for any of your application's keys. When authenticating with other API keys, you can only retrieve information for that key. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetApiKeyExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var key = YourAPIKey;  // string | API key.

            try
            {
                // Get API key permissions.
                GetApiKeyResponse result = apiInstance.GetApiKey(key);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetApiKey: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetApiKeyWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get API key permissions.
    ApiResponse<GetApiKeyResponse> response = apiInstance.GetApiKeyWithHttpInfo(key);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetApiKeyWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **key** | **string** | API key. |  |

### Return type

[**GetApiKeyResponse**](GetApiKeyResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getdictionarylanguages"></a>
# **GetDictionaryLanguages**
> Dictionary&lt;string, Languages&gt; GetDictionaryLanguages ()

List available languages.

Lists Algolia's [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/) and any customizations applied to each language's [stop word](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-stop-words/), [plural](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-plurals-and-other-declensions/), and [segmentation (compound)](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) features.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetDictionaryLanguagesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);

            try
            {
                // List available languages.
                Dictionary<string, Languages> result = apiInstance.GetDictionaryLanguages();
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetDictionaryLanguages: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetDictionaryLanguagesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // List available languages.
    ApiResponse<Dictionary<string, Languages>> response = apiInstance.GetDictionaryLanguagesWithHttpInfo();
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetDictionaryLanguagesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters
This endpoint does not need any parameter.
### Return type

[**Dictionary&lt;string, Languages&gt;**](Languages.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getdictionarysettings"></a>
# **GetDictionarySettings**
> GetDictionarySettingsResponse GetDictionarySettings ()

Get stop word settings.

Get the languages for which [stop words are turned off](#tag/Dictionaries/operation/setDictionarySettings).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetDictionarySettingsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);

            try
            {
                // Get stop word settings.
                GetDictionarySettingsResponse result = apiInstance.GetDictionarySettings();
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetDictionarySettings: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetDictionarySettingsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get stop word settings.
    ApiResponse<GetDictionarySettingsResponse> response = apiInstance.GetDictionarySettingsWithHttpInfo();
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetDictionarySettingsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters
This endpoint does not need any parameter.
### Return type

[**GetDictionarySettingsResponse**](GetDictionarySettingsResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getlogs"></a>
# **GetLogs**
> GetLogsResponse GetLogs (int? offset = null, int? length = null, string indexName = null, LogType type = null)

Return the latest log entries.

The request must be authenticated by an API key with the [`logs` ACL](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl). Logs are held for the last seven days. There's also a logging limit of 1,000 API calls per server. This request counts towards your [operations quota](https://support.algolia.com/hc/en-us/articles/4406981829777-How-does-Algolia-count-records-and-operations-) but doesn't appear in the logs itself. > **Note**: To fetch the logs for a Distributed Search Network (DSN) cluster, target the [DSN's endpoint](https://www.algolia.com/doc/guides/scaling/distributed-search-network-dsn/#accessing-dsn-servers). 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetLogsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var offset = 0;  // int? | First log entry to retrieve. Sorted by decreasing date with 0 being the most recent. (optional)  (default to 0)
            var length = 10;  // int? | Maximum number of entries to retrieve. (optional)  (default to 10)
            var indexName = products;  // string | Index for which log entries should be retrieved. When omitted, log entries are retrieved for all indices. (optional) 
            var type = new LogType(); // LogType | Type of log entries to retrieve. When omitted, all log entries are retrieved. (optional) 

            try
            {
                // Return the latest log entries.
                GetLogsResponse result = apiInstance.GetLogs(offset, length, indexName, type);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetLogs: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetLogsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Return the latest log entries.
    ApiResponse<GetLogsResponse> response = apiInstance.GetLogsWithHttpInfo(offset, length, indexName, type);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetLogsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **offset** | **int?** | First log entry to retrieve. Sorted by decreasing date with 0 being the most recent. | [optional] [default to 0] |
| **length** | **int?** | Maximum number of entries to retrieve. | [optional] [default to 10] |
| **indexName** | **string** | Index for which log entries should be retrieved. When omitted, log entries are retrieved for all indices. | [optional]  |
| **type** | [**LogType**](LogType.md) | Type of log entries to retrieve. When omitted, all log entries are retrieved. | [optional]  |

### Return type

[**GetLogsResponse**](GetLogsResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getobject"></a>
# **GetObject**
> Dictionary&lt;string, string&gt; GetObject (string indexName, string objectID, List<string> attributesToRetrieve = null)

Get a record.

To get more than one record, use the [`objects` operation](#tag/Records/operation/getObjects).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetObjectExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = 123;  // string | Unique record (object) identifier.
            var attributesToRetrieve = new List<string>(); // List<string> | Attributes to include with the records in the response. This is useful to reduce the size of the API response. By default, all retrievable attributes are returned. `objectID` is always retrieved, even when not specified. [`unretrievableAttributes`](https://www.algolia.com/doc/api-reference/api-parameters/unretrievableAttributes/) won't be retrieved unless the request is authenticated with the admin API key.  (optional) 

            try
            {
                // Get a record.
                Dictionary<string, string> result = apiInstance.GetObject(indexName, objectID, attributesToRetrieve);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetObject: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetObjectWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get a record.
    ApiResponse<Dictionary<string, string>> response = apiInstance.GetObjectWithHttpInfo(indexName, objectID, attributesToRetrieve);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetObjectWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique record (object) identifier. |  |
| **attributesToRetrieve** | [**List&lt;string&gt;**](string.md) | Attributes to include with the records in the response. This is useful to reduce the size of the API response. By default, all retrievable attributes are returned. &#x60;objectID&#x60; is always retrieved, even when not specified. [&#x60;unretrievableAttributes&#x60;](https://www.algolia.com/doc/api-reference/api-parameters/unretrievableAttributes/) won&#39;t be retrieved unless the request is authenticated with the admin API key.  | [optional]  |

### Return type

**Dictionary<string, string>**

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getobjects"></a>
# **GetObjects**
> GetObjectsResponse GetObjects (GetObjectsParams getObjectsParams)

Get multiple records.

Retrieve one or more records, potentially from different indices, in a single API operation. Results will be received in the same order as the requests. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetObjectsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var getObjectsParams = new GetObjectsParams(); // GetObjectsParams | Request object.

            try
            {
                // Get multiple records.
                GetObjectsResponse result = apiInstance.GetObjects(getObjectsParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetObjects: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetObjectsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get multiple records.
    ApiResponse<GetObjectsResponse> response = apiInstance.GetObjectsWithHttpInfo(getObjectsParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetObjectsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **getObjectsParams** | [**GetObjectsParams**](GetObjectsParams.md) | Request object. |  |

### Return type

[**GetObjectsResponse**](GetObjectsResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getrule"></a>
# **GetRule**
> Rule GetRule (string indexName, string objectID)

Get a rule.

Get a rule by its `objectID`. To find the `objectID` for rules, use the [`search` operation](#tag/Rules/operation/searchRules).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetRuleExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = a-rule-id;  // string | Unique identifier of a rule object.

            try
            {
                // Get a rule.
                Rule result = apiInstance.GetRule(indexName, objectID);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetRule: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetRuleWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get a rule.
    ApiResponse<Rule> response = apiInstance.GetRuleWithHttpInfo(indexName, objectID);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetRuleWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique identifier of a rule object. |  |

### Return type

[**Rule**](Rule.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getsettings"></a>
# **GetSettings**
> IndexSettings GetSettings (string indexName)

Get index settings.

Return an object containing an index's [configuration settings](https://www.algolia.com/doc/api-reference/settings-api-parameters/).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetSettingsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.

            try
            {
                // Get index settings.
                IndexSettings result = apiInstance.GetSettings(indexName);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetSettings: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetSettingsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get index settings.
    ApiResponse<IndexSettings> response = apiInstance.GetSettingsWithHttpInfo(indexName);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetSettingsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |

### Return type

[**IndexSettings**](IndexSettings.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getsources"></a>
# **GetSources**
> List&lt;Source&gt; GetSources ()

Get all allowed IP addresses.

Get all allowed sources (IP addresses).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetSourcesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);

            try
            {
                // Get all allowed IP addresses.
                List<Source> result = apiInstance.GetSources();
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetSources: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetSourcesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get all allowed IP addresses.
    ApiResponse<List<Source>> response = apiInstance.GetSourcesWithHttpInfo();
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetSourcesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters
This endpoint does not need any parameter.
### Return type

[**List&lt;Source&gt;**](Source.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getsynonym"></a>
# **GetSynonym**
> SynonymHit GetSynonym (string indexName, string objectID)

Get a synonym object.

Get a syonym by its `objectID`. To find the object IDs for your synonyms, use the [`search` operation](#tag/Synonyms/operation/searchSynonyms).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetSynonymExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = synonymID;  // string | Unique identifier of a synonym object.

            try
            {
                // Get a synonym object.
                SynonymHit result = apiInstance.GetSynonym(indexName, objectID);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetSynonym: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetSynonymWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get a synonym object.
    ApiResponse<SynonymHit> response = apiInstance.GetSynonymWithHttpInfo(indexName, objectID);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetSynonymWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique identifier of a synonym object. |  |

### Return type

[**SynonymHit**](SynonymHit.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="gettask"></a>
# **GetTask**
> GetTaskResponse GetTask (string indexName, long taskID)

Check a task's status.

Some operations, such as copying an index, will respond with a `taskID` value. Use this value here to check the status of that task.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetTaskExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var taskID = 1506303845001;  // long | Unique task identifier.

            try
            {
                // Check a task's status.
                GetTaskResponse result = apiInstance.GetTask(indexName, taskID);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetTask: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetTaskWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Check a task's status.
    ApiResponse<GetTaskResponse> response = apiInstance.GetTaskWithHttpInfo(indexName, taskID);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetTaskWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **taskID** | **long** | Unique task identifier. |  |

### Return type

[**GetTaskResponse**](GetTaskResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="gettopuserids"></a>
# **GetTopUserIds**
> GetTopUserIdsResponse GetTopUserIds ()

Get top userID.

Get the IDs of the 10 users with the highest number of records per cluster. Since it can take up to a few seconds to get the data from the different clusters, the response isn't real-time. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetTopUserIdsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);

            try
            {
                // Get top userID.
                GetTopUserIdsResponse result = apiInstance.GetTopUserIds();
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetTopUserIds: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetTopUserIdsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get top userID.
    ApiResponse<GetTopUserIdsResponse> response = apiInstance.GetTopUserIdsWithHttpInfo();
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetTopUserIdsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters
This endpoint does not need any parameter.
### Return type

[**GetTopUserIdsResponse**](GetTopUserIdsResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="getuserid"></a>
# **GetUserId**
> UserId GetUserId (string userID)

Get userID.

Returns the userID data stored in the mapping. Since it can take up to a few seconds to get the data from the different clusters, the response isn't real-time. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetUserIdExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var userID = "userID_example";  // string | userID to assign.

            try
            {
                // Get userID.
                UserId result = apiInstance.GetUserId(userID);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.GetUserId: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the GetUserIdWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get userID.
    ApiResponse<UserId> response = apiInstance.GetUserIdWithHttpInfo(userID);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.GetUserIdWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **userID** | **string** | userID to assign. |  |

### Return type

[**UserId**](UserId.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="haspendingmappings"></a>
# **HasPendingMappings**
> HasPendingMappingsResponse HasPendingMappings (bool? getClusters = null)

Get migration and user mapping status.

To determine when the time-consuming process of creating a large batch of users or migrating users from one cluster to another is complete, this operation retrieves the status of the process. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class HasPendingMappingsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var getClusters = true;  // bool? | Indicates whether to include the cluster's pending mapping state in the response. (optional) 

            try
            {
                // Get migration and user mapping status.
                HasPendingMappingsResponse result = apiInstance.HasPendingMappings(getClusters);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.HasPendingMappings: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the HasPendingMappingsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Get migration and user mapping status.
    ApiResponse<HasPendingMappingsResponse> response = apiInstance.HasPendingMappingsWithHttpInfo(getClusters);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.HasPendingMappingsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **getClusters** | **bool?** | Indicates whether to include the cluster&#39;s pending mapping state in the response. | [optional]  |

### Return type

[**HasPendingMappingsResponse**](HasPendingMappingsResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="listapikeys"></a>
# **ListApiKeys**
> ListApiKeysResponse ListApiKeys ()

List API keys.

List all API keys associated with your Algolia application, including their permissions and restrictions.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ListApiKeysExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);

            try
            {
                // List API keys.
                ListApiKeysResponse result = apiInstance.ListApiKeys();
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.ListApiKeys: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the ListApiKeysWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // List API keys.
    ApiResponse<ListApiKeysResponse> response = apiInstance.ListApiKeysWithHttpInfo();
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.ListApiKeysWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters
This endpoint does not need any parameter.
### Return type

[**ListApiKeysResponse**](ListApiKeysResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="listclusters"></a>
# **ListClusters**
> ListClustersResponse ListClusters ()

List clusters.

List the available clusters in a multi-cluster setup.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ListClustersExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);

            try
            {
                // List clusters.
                ListClustersResponse result = apiInstance.ListClusters();
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.ListClusters: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the ListClustersWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // List clusters.
    ApiResponse<ListClustersResponse> response = apiInstance.ListClustersWithHttpInfo();
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.ListClustersWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters
This endpoint does not need any parameter.
### Return type

[**ListClustersResponse**](ListClustersResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="listindices"></a>
# **ListIndices**
> ListIndicesResponse ListIndices (int? page = null, int? hitsPerPage = null)

List indices.

List indices in an Algolia application.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ListIndicesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var page = 56;  // int? | Returns the requested page number. The page size is determined by the `hitsPerPage` parameter. You can see the number of available pages in the `nbPages` response attribute. When `page` is null, the API response is not paginated.  (optional) 
            var hitsPerPage = 100;  // int? | Maximum number of hits per page. (optional)  (default to 100)

            try
            {
                // List indices.
                ListIndicesResponse result = apiInstance.ListIndices(page, hitsPerPage);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.ListIndices: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the ListIndicesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // List indices.
    ApiResponse<ListIndicesResponse> response = apiInstance.ListIndicesWithHttpInfo(page, hitsPerPage);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.ListIndicesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **page** | **int?** | Returns the requested page number. The page size is determined by the &#x60;hitsPerPage&#x60; parameter. You can see the number of available pages in the &#x60;nbPages&#x60; response attribute. When &#x60;page&#x60; is null, the API response is not paginated.  | [optional]  |
| **hitsPerPage** | **int?** | Maximum number of hits per page. | [optional] [default to 100] |

### Return type

[**ListIndicesResponse**](ListIndicesResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="listuserids"></a>
# **ListUserIds**
> ListUserIdsResponse ListUserIds (int? page = null, int? hitsPerPage = null)

List userIDs.

List the userIDs assigned to a multi-cluster application. Since it can take up to a few seconds to get the data from the different clusters, the response isn't real-time. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ListUserIdsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var page = 56;  // int? | Returns the requested page number. The page size is determined by the `hitsPerPage` parameter. You can see the number of available pages in the `nbPages` response attribute. When `page` is null, the API response is not paginated.  (optional) 
            var hitsPerPage = 100;  // int? | Maximum number of hits per page. (optional)  (default to 100)

            try
            {
                // List userIDs.
                ListUserIdsResponse result = apiInstance.ListUserIds(page, hitsPerPage);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.ListUserIds: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the ListUserIdsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // List userIDs.
    ApiResponse<ListUserIdsResponse> response = apiInstance.ListUserIdsWithHttpInfo(page, hitsPerPage);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.ListUserIdsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **page** | **int?** | Returns the requested page number. The page size is determined by the &#x60;hitsPerPage&#x60; parameter. You can see the number of available pages in the &#x60;nbPages&#x60; response attribute. When &#x60;page&#x60; is null, the API response is not paginated.  | [optional]  |
| **hitsPerPage** | **int?** | Maximum number of hits per page. | [optional] [default to 100] |

### Return type

[**ListUserIdsResponse**](ListUserIdsResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="multiplebatch"></a>
# **MultipleBatch**
> MultipleBatchResponse MultipleBatch (BatchParams batchParams)

Batch write operations on multiple indices.

To reduce the time spent on network round trips, you can perform several write actions in a single request. It's a multi-index version of the [`batch` operation](#tag/Records/operation/batch). Actions are applied in the order they are specified. The supported actions are equivalent to the individual operations of the same name. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class MultipleBatchExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var batchParams = new BatchParams(); // BatchParams | 

            try
            {
                // Batch write operations on multiple indices.
                MultipleBatchResponse result = apiInstance.MultipleBatch(batchParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.MultipleBatch: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the MultipleBatchWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Batch write operations on multiple indices.
    ApiResponse<MultipleBatchResponse> response = apiInstance.MultipleBatchWithHttpInfo(batchParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.MultipleBatchWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **batchParams** | [**BatchParams**](BatchParams.md) |  |  |

### Return type

[**MultipleBatchResponse**](MultipleBatchResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="operationindex"></a>
# **OperationIndex**
> UpdatedAtResponse OperationIndex (string indexName, OperationIndexParams operationIndexParams)

Copy, move, or rename an index.

This `operation`, _copy_ or _move_, will copy or move a source index's (`IndexName`) records, settings, synonyms, and rules to a `destination` index. If the destination index exists, it will be replaced, except for index-specific API keys and analytics data. If the destination index doesn't exist, it will be created.  The choice between moving or copying an index depends on your needs. Choose:  - **Move** to rename an index. - **Copy** to create a new index with the same records and configuration as an existing one.  > **Note**: When considering copying or moving, be aware of the [rate limitations](https://www.algolia.com/doc/guides/scaling/algolia-service-limits/#application-record-and-index-limits) on these processes and the [impact on your analytics data](https://www.algolia.com/doc/guides/sending-and-managing-data/manage-indices-and-apps/manage-indices/concepts/indices-analytics/).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class OperationIndexExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var operationIndexParams = new OperationIndexParams(); // OperationIndexParams | 

            try
            {
                // Copy, move, or rename an index.
                UpdatedAtResponse result = apiInstance.OperationIndex(indexName, operationIndexParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.OperationIndex: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the OperationIndexWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Copy, move, or rename an index.
    ApiResponse<UpdatedAtResponse> response = apiInstance.OperationIndexWithHttpInfo(indexName, operationIndexParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.OperationIndexWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **operationIndexParams** | [**OperationIndexParams**](OperationIndexParams.md) |  |  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="partialupdateobject"></a>
# **PartialUpdateObject**
> UpdatedAtWithObjectIdResponse PartialUpdateObject (string indexName, string objectID, Dictionary<string, AttributeToUpdate> attributesToUpdate, bool? createIfNotExists = null)

Update record attributes.

Add new attributes or update current ones in an existing record. You can use any first-level attribute but not nested attributes. If you specify a [nested attribute](https://www.algolia.com/doc/guides/sending-and-managing-data/prepare-your-data/how-to/creating-and-using-nested-attributes/), the engine treats it as a replacement for its first-level ancestor. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class PartialUpdateObjectExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = 123;  // string | Unique record (object) identifier.
            var attributesToUpdate = new Dictionary<string, AttributeToUpdate>(); // Dictionary<string, AttributeToUpdate> | Object with attributes to update.
            var createIfNotExists = true;  // bool? | Indicates whether to create a new record if it doesn't exist yet.  (optional)  (default to true)

            try
            {
                // Update record attributes.
                UpdatedAtWithObjectIdResponse result = apiInstance.PartialUpdateObject(indexName, objectID, attributesToUpdate, createIfNotExists);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.PartialUpdateObject: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the PartialUpdateObjectWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Update record attributes.
    ApiResponse<UpdatedAtWithObjectIdResponse> response = apiInstance.PartialUpdateObjectWithHttpInfo(indexName, objectID, attributesToUpdate, createIfNotExists);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.PartialUpdateObjectWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique record (object) identifier. |  |
| **attributesToUpdate** | [**Dictionary&lt;string, AttributeToUpdate&gt;**](AttributeToUpdate.md) | Object with attributes to update. |  |
| **createIfNotExists** | **bool?** | Indicates whether to create a new record if it doesn&#39;t exist yet.  | [optional] [default to true] |

### Return type

[**UpdatedAtWithObjectIdResponse**](UpdatedAtWithObjectIdResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="post"></a>
# **Post**
> Object Post (string path, Dictionary<string, Object> parameters = null, Object body = null)

Send requests to the Algolia REST API.

This method allow you to send requests to the Algolia REST API.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class PostExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var path = /keys;  // string | Path of the endpoint, anything after \"/1\" must be specified.
            var parameters = new Dictionary<string, Object>(); // Dictionary<string, Object> | Query parameters to apply to the current query. (optional) 
            var body = null;  // Object | Parameters to send with the custom request. (optional) 

            try
            {
                // Send requests to the Algolia REST API.
                Object result = apiInstance.Post(path, parameters, body);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.Post: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the PostWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Send requests to the Algolia REST API.
    ApiResponse<Object> response = apiInstance.PostWithHttpInfo(path, parameters, body);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.PostWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **path** | **string** | Path of the endpoint, anything after \&quot;/1\&quot; must be specified. |  |
| **parameters** | [**Dictionary&lt;string, Object&gt;**](Object.md) | Query parameters to apply to the current query. | [optional]  |
| **body** | **Object** | Parameters to send with the custom request. | [optional]  |

### Return type

**Object**

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="put"></a>
# **Put**
> Object Put (string path, Dictionary<string, Object> parameters = null, Object body = null)

Send requests to the Algolia REST API.

This method allow you to send requests to the Algolia REST API.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class PutExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var path = /keys;  // string | Path of the endpoint, anything after \"/1\" must be specified.
            var parameters = new Dictionary<string, Object>(); // Dictionary<string, Object> | Query parameters to apply to the current query. (optional) 
            var body = null;  // Object | Parameters to send with the custom request. (optional) 

            try
            {
                // Send requests to the Algolia REST API.
                Object result = apiInstance.Put(path, parameters, body);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.Put: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the PutWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Send requests to the Algolia REST API.
    ApiResponse<Object> response = apiInstance.PutWithHttpInfo(path, parameters, body);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.PutWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **path** | **string** | Path of the endpoint, anything after \&quot;/1\&quot; must be specified. |  |
| **parameters** | [**Dictionary&lt;string, Object&gt;**](Object.md) | Query parameters to apply to the current query. | [optional]  |
| **body** | **Object** | Parameters to send with the custom request. | [optional]  |

### Return type

**Object**

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="removeuserid"></a>
# **RemoveUserId**
> RemoveUserIdResponse RemoveUserId (string userID)

Remove userID.

Remove a userID and its associated data from the multi-clusters.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class RemoveUserIdExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var userID = "userID_example";  // string | userID to assign.

            try
            {
                // Remove userID.
                RemoveUserIdResponse result = apiInstance.RemoveUserId(userID);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.RemoveUserId: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the RemoveUserIdWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Remove userID.
    ApiResponse<RemoveUserIdResponse> response = apiInstance.RemoveUserIdWithHttpInfo(userID);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.RemoveUserIdWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **userID** | **string** | userID to assign. |  |

### Return type

[**RemoveUserIdResponse**](RemoveUserIdResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="replacesources"></a>
# **ReplaceSources**
> ReplaceSourceResponse ReplaceSources (List<Source> source)

Replace all sources.

Replace all allowed sources.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class ReplaceSourcesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var source = new List<Source>(); // List<Source> | Allowed sources.

            try
            {
                // Replace all sources.
                ReplaceSourceResponse result = apiInstance.ReplaceSources(source);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.ReplaceSources: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the ReplaceSourcesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Replace all sources.
    ApiResponse<ReplaceSourceResponse> response = apiInstance.ReplaceSourcesWithHttpInfo(source);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.ReplaceSourcesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **source** | [**List&lt;Source&gt;**](Source.md) | Allowed sources. |  |

### Return type

[**ReplaceSourceResponse**](ReplaceSourceResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="restoreapikey"></a>
# **RestoreApiKey**
> AddApiKeyResponse RestoreApiKey (string key)

Restore API key.

Restore a deleted API key, along with its associated permissions. The request must be authenticated with the admin API key. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class RestoreApiKeyExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var key = YourAPIKey;  // string | API key.

            try
            {
                // Restore API key.
                AddApiKeyResponse result = apiInstance.RestoreApiKey(key);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.RestoreApiKey: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the RestoreApiKeyWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Restore API key.
    ApiResponse<AddApiKeyResponse> response = apiInstance.RestoreApiKeyWithHttpInfo(key);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.RestoreApiKeyWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **key** | **string** | API key. |  |

### Return type

[**AddApiKeyResponse**](AddApiKeyResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="saveobject"></a>
# **SaveObject**
> SaveObjectResponse SaveObject (string indexName, Object body)

Add or update a record.

Add a record (object) to an index or replace it. If the record doesn't contain an `objectID`, Algolia automatically adds it. If you use an existing `objectID`, the existing record is replaced with the new one. To add multiple records to your index in a single API request, use the [`batch` operation](#tag/Records/operation/batch). 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SaveObjectExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var body = null;  // Object | The Algolia record.

            try
            {
                // Add or update a record.
                SaveObjectResponse result = apiInstance.SaveObject(indexName, body);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SaveObject: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SaveObjectWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Add or update a record.
    ApiResponse<SaveObjectResponse> response = apiInstance.SaveObjectWithHttpInfo(indexName, body);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SaveObjectWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **body** | **Object** | The Algolia record. |  |

### Return type

[**SaveObjectResponse**](SaveObjectResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="saverule"></a>
# **SaveRule**
> UpdatedRuleResponse SaveRule (string indexName, string objectID, Rule rule, bool? forwardToReplicas = null)

Create or update a rule.

To create or update more than one rule, use the [`batch` operation](#tag/Rules/operation/saveRules).

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SaveRuleExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = a-rule-id;  // string | Unique identifier of a rule object.
            var rule = new Rule(); // Rule | 
            var forwardToReplicas = true;  // bool? | Indicates whether changed index settings are forwarded to the replica indices. (optional) 

            try
            {
                // Create or update a rule.
                UpdatedRuleResponse result = apiInstance.SaveRule(indexName, objectID, rule, forwardToReplicas);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SaveRule: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SaveRuleWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Create or update a rule.
    ApiResponse<UpdatedRuleResponse> response = apiInstance.SaveRuleWithHttpInfo(indexName, objectID, rule, forwardToReplicas);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SaveRuleWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique identifier of a rule object. |  |
| **rule** | [**Rule**](Rule.md) |  |  |
| **forwardToReplicas** | **bool?** | Indicates whether changed index settings are forwarded to the replica indices. | [optional]  |

### Return type

[**UpdatedRuleResponse**](UpdatedRuleResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="saverules"></a>
# **SaveRules**
> UpdatedAtResponse SaveRules (string indexName, List<Rule> rules, bool? forwardToReplicas = null, bool? clearExistingRules = null)

Save a batch of rules.

Create or update multiple rules.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SaveRulesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var rules = new List<Rule>(); // List<Rule> | 
            var forwardToReplicas = true;  // bool? | Indicates whether changed index settings are forwarded to the replica indices. (optional) 
            var clearExistingRules = true;  // bool? | Indicates whether existing rules should be deleted before adding this batch. (optional) 

            try
            {
                // Save a batch of rules.
                UpdatedAtResponse result = apiInstance.SaveRules(indexName, rules, forwardToReplicas, clearExistingRules);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SaveRules: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SaveRulesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Save a batch of rules.
    ApiResponse<UpdatedAtResponse> response = apiInstance.SaveRulesWithHttpInfo(indexName, rules, forwardToReplicas, clearExistingRules);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SaveRulesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **rules** | [**List&lt;Rule&gt;**](Rule.md) |  |  |
| **forwardToReplicas** | **bool?** | Indicates whether changed index settings are forwarded to the replica indices. | [optional]  |
| **clearExistingRules** | **bool?** | Indicates whether existing rules should be deleted before adding this batch. | [optional]  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="savesynonym"></a>
# **SaveSynonym**
> SaveSynonymResponse SaveSynonym (string indexName, string objectID, SynonymHit synonymHit, bool? forwardToReplicas = null)

Save a synonym.

Add a [synonym](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/#the-different-types-of-synonyms) to an index or replace it. If the synonym `objectID` doesn't exist, Algolia adds a new one. If you use an existing synonym `objectID`, the existing synonym is replaced with the new one. To add multiple synonyms in a single API request, use the [`batch` operation](#tag/Synonyms/operation/saveSynonyms). 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SaveSynonymExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var objectID = synonymID;  // string | Unique identifier of a synonym object.
            var synonymHit = new SynonymHit(); // SynonymHit | 
            var forwardToReplicas = true;  // bool? | Indicates whether changed index settings are forwarded to the replica indices. (optional) 

            try
            {
                // Save a synonym.
                SaveSynonymResponse result = apiInstance.SaveSynonym(indexName, objectID, synonymHit, forwardToReplicas);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SaveSynonym: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SaveSynonymWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Save a synonym.
    ApiResponse<SaveSynonymResponse> response = apiInstance.SaveSynonymWithHttpInfo(indexName, objectID, synonymHit, forwardToReplicas);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SaveSynonymWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **objectID** | **string** | Unique identifier of a synonym object. |  |
| **synonymHit** | [**SynonymHit**](SynonymHit.md) |  |  |
| **forwardToReplicas** | **bool?** | Indicates whether changed index settings are forwarded to the replica indices. | [optional]  |

### Return type

[**SaveSynonymResponse**](SaveSynonymResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="savesynonyms"></a>
# **SaveSynonyms**
> UpdatedAtResponse SaveSynonyms (string indexName, List<SynonymHit> synonymHit, bool? forwardToReplicas = null, bool? replaceExistingSynonyms = null)

Save a batch of synonyms.

Create or update multiple synonyms.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SaveSynonymsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var synonymHit = new List<SynonymHit>(); // List<SynonymHit> | 
            var forwardToReplicas = true;  // bool? | Indicates whether changed index settings are forwarded to the replica indices. (optional) 
            var replaceExistingSynonyms = true;  // bool? | Indicates whether to replace all synonyms in the index with the ones sent with this request. (optional) 

            try
            {
                // Save a batch of synonyms.
                UpdatedAtResponse result = apiInstance.SaveSynonyms(indexName, synonymHit, forwardToReplicas, replaceExistingSynonyms);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SaveSynonyms: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SaveSynonymsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Save a batch of synonyms.
    ApiResponse<UpdatedAtResponse> response = apiInstance.SaveSynonymsWithHttpInfo(indexName, synonymHit, forwardToReplicas, replaceExistingSynonyms);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SaveSynonymsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **synonymHit** | [**List&lt;SynonymHit&gt;**](SynonymHit.md) |  |  |
| **forwardToReplicas** | **bool?** | Indicates whether changed index settings are forwarded to the replica indices. | [optional]  |
| **replaceExistingSynonyms** | **bool?** | Indicates whether to replace all synonyms in the index with the ones sent with this request. | [optional]  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="search"></a>
# **Search**
> SearchResponses Search (SearchMethodParams searchMethodParams)

Search multiple indices.

Send multiple search queries to one or more indices.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SearchExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var searchMethodParams = new SearchMethodParams(); // SearchMethodParams | Query requests and strategies. Results will be received in the same order as the queries.

            try
            {
                // Search multiple indices.
                SearchResponses result = apiInstance.Search(searchMethodParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.Search: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SearchWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Search multiple indices.
    ApiResponse<SearchResponses> response = apiInstance.SearchWithHttpInfo(searchMethodParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SearchWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **searchMethodParams** | [**SearchMethodParams**](SearchMethodParams.md) | Query requests and strategies. Results will be received in the same order as the queries. |  |

### Return type

[**SearchResponses**](SearchResponses.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="searchdictionaryentries"></a>
# **SearchDictionaryEntries**
> UpdatedAtResponse SearchDictionaryEntries (DictionaryType dictionaryName, SearchDictionaryEntriesParams searchDictionaryEntriesParams)

Search dictionary entries.

Search for standard and [custom](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-stop-words/) entries in the [stop words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-stop-words/), [plurals](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-plurals-and-other-declensions/), or [segmentation (compounds)](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) dictionaries.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SearchDictionaryEntriesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var dictionaryName = new DictionaryType(); // DictionaryType | Dictionary to search in.
            var searchDictionaryEntriesParams = new SearchDictionaryEntriesParams(); // SearchDictionaryEntriesParams | 

            try
            {
                // Search dictionary entries.
                UpdatedAtResponse result = apiInstance.SearchDictionaryEntries(dictionaryName, searchDictionaryEntriesParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SearchDictionaryEntries: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SearchDictionaryEntriesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Search dictionary entries.
    ApiResponse<UpdatedAtResponse> response = apiInstance.SearchDictionaryEntriesWithHttpInfo(dictionaryName, searchDictionaryEntriesParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SearchDictionaryEntriesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **dictionaryName** | [**DictionaryType**](DictionaryType.md) | Dictionary to search in. |  |
| **searchDictionaryEntriesParams** | [**SearchDictionaryEntriesParams**](SearchDictionaryEntriesParams.md) |  |  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="searchforfacetvalues"></a>
# **SearchForFacetValues**
> SearchForFacetValuesResponse SearchForFacetValues (string indexName, string facetName, SearchForFacetValuesRequest searchForFacetValuesRequest = null)

Search for facet values.

[Search for a facet's values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values), optionally restricting the returned values to those contained in records matching other search criteria. > **Note**: Pagination isn't supported (`page` and `hitsPerPage` are ignored). By default, the engine returns a maximum of 10 values but you can adjust this with `maxFacetHits`. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SearchForFacetValuesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var facetName = "facetName_example";  // string | Facet name.
            var searchForFacetValuesRequest = new SearchForFacetValuesRequest(); // SearchForFacetValuesRequest |  (optional) 

            try
            {
                // Search for facet values.
                SearchForFacetValuesResponse result = apiInstance.SearchForFacetValues(indexName, facetName, searchForFacetValuesRequest);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SearchForFacetValues: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SearchForFacetValuesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Search for facet values.
    ApiResponse<SearchForFacetValuesResponse> response = apiInstance.SearchForFacetValuesWithHttpInfo(indexName, facetName, searchForFacetValuesRequest);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SearchForFacetValuesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **facetName** | **string** | Facet name. |  |
| **searchForFacetValuesRequest** | [**SearchForFacetValuesRequest**](SearchForFacetValuesRequest.md) |  | [optional]  |

### Return type

[**SearchForFacetValuesResponse**](SearchForFacetValuesResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="searchrules"></a>
# **SearchRules**
> SearchRulesResponse SearchRules (string indexName, SearchRulesParams searchRulesParams = null)

Search for rules.

Search for rules in your index. You can control the search with parameters. To list all rules, send an empty request body.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SearchRulesExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var searchRulesParams = new SearchRulesParams(); // SearchRulesParams |  (optional) 

            try
            {
                // Search for rules.
                SearchRulesResponse result = apiInstance.SearchRules(indexName, searchRulesParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SearchRules: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SearchRulesWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Search for rules.
    ApiResponse<SearchRulesResponse> response = apiInstance.SearchRulesWithHttpInfo(indexName, searchRulesParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SearchRulesWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **searchRulesParams** | [**SearchRulesParams**](SearchRulesParams.md) |  | [optional]  |

### Return type

[**SearchRulesResponse**](SearchRulesResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="searchsingleindex"></a>
# **SearchSingleIndex**
> SearchResponse SearchSingleIndex (string indexName, SearchParams searchParams = null)

Search an index.

Return records that match the query.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SearchSingleIndexExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var searchParams = new SearchParams(); // SearchParams |  (optional) 

            try
            {
                // Search an index.
                SearchResponse result = apiInstance.SearchSingleIndex(indexName, searchParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SearchSingleIndex: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SearchSingleIndexWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Search an index.
    ApiResponse<SearchResponse> response = apiInstance.SearchSingleIndexWithHttpInfo(indexName, searchParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SearchSingleIndexWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **searchParams** | [**SearchParams**](SearchParams.md) |  | [optional]  |

### Return type

[**SearchResponse**](SearchResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="searchsynonyms"></a>
# **SearchSynonyms**
> SearchSynonymsResponse SearchSynonyms (string indexName, SynonymType type = null, int? page = null, int? hitsPerPage = null, SearchSynonymsParams searchSynonymsParams = null)

Search for synonyms.

Search for synonyms in your index. You can control and filter the search with parameters. To get all synonyms, send an empty request body.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SearchSynonymsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var type = new SynonymType(); // SynonymType | Search for specific [types of synonyms](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/#the-different-types-of-synonyms). (optional) 
            var page = 0;  // int? | Returns the requested page number (the first page is 0). Page size is set by `hitsPerPage`. When null, there's no pagination.  (optional)  (default to 0)
            var hitsPerPage = 100;  // int? | Maximum number of hits per page. (optional)  (default to 100)
            var searchSynonymsParams = new SearchSynonymsParams(); // SearchSynonymsParams | Body of the `searchSynonyms` operation. (optional) 

            try
            {
                // Search for synonyms.
                SearchSynonymsResponse result = apiInstance.SearchSynonyms(indexName, type, page, hitsPerPage, searchSynonymsParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SearchSynonyms: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SearchSynonymsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Search for synonyms.
    ApiResponse<SearchSynonymsResponse> response = apiInstance.SearchSynonymsWithHttpInfo(indexName, type, page, hitsPerPage, searchSynonymsParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SearchSynonymsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **type** | [**SynonymType**](SynonymType.md) | Search for specific [types of synonyms](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/#the-different-types-of-synonyms). | [optional]  |
| **page** | **int?** | Returns the requested page number (the first page is 0). Page size is set by &#x60;hitsPerPage&#x60;. When null, there&#39;s no pagination.  | [optional] [default to 0] |
| **hitsPerPage** | **int?** | Maximum number of hits per page. | [optional] [default to 100] |
| **searchSynonymsParams** | [**SearchSynonymsParams**](SearchSynonymsParams.md) | Body of the &#x60;searchSynonyms&#x60; operation. | [optional]  |

### Return type

[**SearchSynonymsResponse**](SearchSynonymsResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="searchuserids"></a>
# **SearchUserIds**
> SearchUserIdsResponse SearchUserIds (SearchUserIdsParams searchUserIdsParams)

Search for a user ID.

Since it can take up to a few seconds to get the data from the different clusters, the response isn't real-time. To ensure rapid updates, the user IDs index isn't built at the same time as the mapping. Instead, it's built every 12 hours, at the same time as the update of user ID usage. For example, if you add or move a user ID, the search will show an old value until the next time the mapping is rebuilt (every 12 hours).  

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SearchUserIdsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var searchUserIdsParams = new SearchUserIdsParams(); // SearchUserIdsParams | 

            try
            {
                // Search for a user ID.
                SearchUserIdsResponse result = apiInstance.SearchUserIds(searchUserIdsParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SearchUserIds: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SearchUserIdsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Search for a user ID.
    ApiResponse<SearchUserIdsResponse> response = apiInstance.SearchUserIdsWithHttpInfo(searchUserIdsParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SearchUserIdsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **searchUserIdsParams** | [**SearchUserIdsParams**](SearchUserIdsParams.md) |  |  |

### Return type

[**SearchUserIdsResponse**](SearchUserIdsResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="setdictionarysettings"></a>
# **SetDictionarySettings**
> UpdatedAtResponse SetDictionarySettings (DictionarySettingsParams dictionarySettingsParams)

Set stop word settings.

Set stop word settings for a specific language.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SetDictionarySettingsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var dictionarySettingsParams = new DictionarySettingsParams(); // DictionarySettingsParams | 

            try
            {
                // Set stop word settings.
                UpdatedAtResponse result = apiInstance.SetDictionarySettings(dictionarySettingsParams);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SetDictionarySettings: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SetDictionarySettingsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Set stop word settings.
    ApiResponse<UpdatedAtResponse> response = apiInstance.SetDictionarySettingsWithHttpInfo(dictionarySettingsParams);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SetDictionarySettingsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **dictionarySettingsParams** | [**DictionarySettingsParams**](DictionarySettingsParams.md) |  |  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="setsettings"></a>
# **SetSettings**
> UpdatedAtResponse SetSettings (string indexName, IndexSettings indexSettings, bool? forwardToReplicas = null)

Update index settings.

Update the specified [index settings](https://www.algolia.com/doc/api-reference/settings-api-parameters/). Specifying null for a setting resets it to its default value.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class SetSettingsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var indexName = myIndexName;  // string | Index on which to perform the request.
            var indexSettings = new IndexSettings(); // IndexSettings | 
            var forwardToReplicas = true;  // bool? | Indicates whether changed index settings are forwarded to the replica indices. (optional) 

            try
            {
                // Update index settings.
                UpdatedAtResponse result = apiInstance.SetSettings(indexName, indexSettings, forwardToReplicas);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.SetSettings: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the SetSettingsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Update index settings.
    ApiResponse<UpdatedAtResponse> response = apiInstance.SetSettingsWithHttpInfo(indexName, indexSettings, forwardToReplicas);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.SetSettingsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **indexName** | **string** | Index on which to perform the request. |  |
| **indexSettings** | [**IndexSettings**](IndexSettings.md) |  |  |
| **forwardToReplicas** | **bool?** | Indicates whether changed index settings are forwarded to the replica indices. | [optional]  |

### Return type

[**UpdatedAtResponse**](UpdatedAtResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="updateapikey"></a>
# **UpdateApiKey**
> UpdateApiKeyResponse UpdateApiKey (string key, ApiKey apiKey)

Update an API key.

Replace the permissions of an existing API key. Any unspecified parameter resets that permission to its default value. The request must be authenticated with the admin API key. 

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class UpdateApiKeyExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "https://myAppId.algolia.net";
            // Configure API key authorization: apiKey
            config.AddApiKey("X-Algolia-API-Key", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-API-Key", "Bearer");
            // Configure API key authorization: appId
            config.AddApiKey("X-Algolia-Application-Id", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // config.AddApiKeyPrefix("X-Algolia-Application-Id", "Bearer");

            // create instances of HttpClient, HttpClientHandler to be reused later with different Api classes
            HttpClient httpClient = new HttpClient();
            HttpClientHandler httpClientHandler = new HttpClientHandler();
            var apiInstance = new SearchApi(httpClient, config, httpClientHandler);
            var key = YourAPIKey;  // string | API key.
            var apiKey = new ApiKey(); // ApiKey | 

            try
            {
                // Update an API key.
                UpdateApiKeyResponse result = apiInstance.UpdateApiKey(key, apiKey);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling SearchApi.UpdateApiKey: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the UpdateApiKeyWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Update an API key.
    ApiResponse<UpdateApiKeyResponse> response = apiInstance.UpdateApiKeyWithHttpInfo(key, apiKey);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling SearchApi.UpdateApiKeyWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **key** | **string** | API key. |  |
| **apiKey** | [**ApiKey**](ApiKey.md) |  |  |

### Return type

[**UpdateApiKeyResponse**](UpdateApiKeyResponse.md)

### Authorization

[apiKey](../README.md#apiKey), [appId](../README.md#appId)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request or request arguments. |  -  |
| **402** | This feature is not enabled on your Algolia account. |  -  |
| **403** | Method not allowed with this API key. |  -  |
| **404** | Index not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

