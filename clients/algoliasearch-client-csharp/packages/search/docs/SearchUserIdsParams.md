# Algolia.search.Model.SearchUserIdsParams
OK

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Query** | **string** | Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users. | 
**ClusterName** | **string** | Cluster name. | [optional] 
**Page** | **int** | Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;). | [optional] [default to 0]
**HitsPerPage** | **int** | Number of hits per page. | [optional] [default to 20]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

