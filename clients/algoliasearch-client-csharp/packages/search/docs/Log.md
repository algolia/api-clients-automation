# Algolia.search.Model.Log

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Timestamp** | **string** | Timestamp in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. | 
**Method** | **string** | HTTP method of the performed request. | 
**AnswerCode** | **string** | HTTP response code. | 
**QueryBody** | **string** | Request body. Truncated after 1,000 characters. | 
**Answer** | **string** | Answer body. Truncated after 1,000 characters. | 
**Url** | **string** | Request URL. | 
**Ip** | **string** | IP address of the client that performed the request. | 
**QueryHeaders** | **string** | Request headers (API key is obfuscated). | 
**Sha1** | **string** | SHA1 signature of the log entry. | 
**NbApiCalls** | **string** | Number of API calls. | 
**ProcessingTimeMs** | **string** | Processing time for the query. Doesn&#39;t include network time. | 
**Index** | **string** | Index targeted by the query. | [optional] 
**QueryParams** | **string** | Query parameters sent with the request. | [optional] 
**QueryNbHits** | **string** | Number of hits returned for the query. | [optional] 
**InnerQueries** | [**List&lt;LogQuery&gt;**](LogQuery.md) | Performed queries for the given request. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

