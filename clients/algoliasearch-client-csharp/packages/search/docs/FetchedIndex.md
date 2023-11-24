# Algolia.search.Model.FetchedIndex

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | **string** | Index name. | 
**CreatedAt** | **string** | Index creation date. An empty string means that the index has no records. | 
**UpdatedAt** | **string** | Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. | 
**Entries** | **int** | Number of records contained in the index. | 
**DataSize** | **int** | Number of bytes of the index in minified format. | 
**FileSize** | **int** | Number of bytes of the index binary file. | 
**LastBuildTimeS** | **int** | Last build time. | 
**NumberOfPendingTasks** | **int** | Number of pending indexing operations. This value is deprecated and should not be used. | [default to 0]
**PendingTask** | **bool** | A boolean which says whether the index has pending tasks. This value is deprecated and should not be used. | [default to false]
**Primary** | **string** | Only present if the index is a replica. Contains the name of the related primary index. | [optional] 
**Replicas** | **List&lt;string&gt;** | Only present if the index is a primary index with replicas. Contains the names of all linked replicas. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

