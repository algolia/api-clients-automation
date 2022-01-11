# # Index

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** | Index name. |
**createdAt** | **\DateTime** | Index creation date. An empty string means that the index has no records. |
**updatedAt** | **\DateTime** | Date of last update (ISO-8601 format). |
**entries** | **int** | Number of records contained in the index. |
**dataSize** | **int** | Number of bytes of the index in minified format. |
**fileSize** | **int** | Number of bytes of the index binary file. |
**lastBuildTimeS** | **int** | Last build time |
**numberOfPendingTask** | **int** | Number of pending indexing operations. This value is deprecated and should not be used. | [optional]
**pendingTask** | **bool** | A boolean which says whether the index has pending tasks. This value is deprecated and should not be used. |
**primary** | **string** | Only present if the index is a replica. Contains the name of the related primary index. | [optional]
**replicas** | **string[]** | Only present if the index is a primary index with replicas. Contains the names of all linked replicas. | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
