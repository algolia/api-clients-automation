# # GetLogsResponseLogs

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**timestamp** | **string** | Timestamp in ISO-8601 format. |
**method** | **string** | HTTP method of the perfomed request. |
**answerCode** | **string** | HTTP response code. |
**queryBody** | **string** | Request body. Truncated after 1000 characters. |
**answer** | **string** | Answer body. Truncated after 1000 characters. |
**url** | **string** | Request URL. |
**ip** | **string** | IP of the client which perfomed the request. |
**queryHeaders** | **string** | Request Headers (API Key is obfuscated). |
**sha1** | **string** | SHA1 signature of the log entry. |
**nbApiCalls** | **string** | Number of API calls. |
**processingTimeMs** | **string** | Processing time for the query. It doesn&#39;t include network time. |
**index** | **string** | Index targeted by the query. | [optional]
**queryParams** | **string** | Query parameters sent with the request. | [optional]
**queryNbHits** | **string** | Number of hits returned for the query. | [optional]
**innerQueries** | [**\Algolia\AlgoliaSearch\Model\GetLogsResponseInnerQueries[]**](GetLogsResponseInnerQueries.md) | Array of all performed queries for the given request. | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
