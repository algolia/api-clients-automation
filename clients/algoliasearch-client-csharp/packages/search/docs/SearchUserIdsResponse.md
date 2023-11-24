# Algolia.search.Model.SearchUserIdsResponse
userIDs data.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Hits** | [**List&lt;UserHit&gt;**](UserHit.md) | User objects that match the query. | 
**NbHits** | **int** | Number of hits the search query matched. | 
**Page** | **int** | Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;). | [default to 0]
**HitsPerPage** | **int** | Maximum number of hits per page. | [default to 20]
**UpdatedAt** | **string** | Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

