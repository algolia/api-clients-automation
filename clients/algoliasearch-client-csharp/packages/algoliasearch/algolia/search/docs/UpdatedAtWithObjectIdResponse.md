# Org.OpenAPITools.Model.UpdatedAtWithObjectIdResponse
Response, taskID, unique object identifier, and an update timestamp.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TaskID** | **long** | Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;.  | [optional] 
**UpdatedAt** | **string** | Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. | [optional] 
**ObjectID** | **string** | Unique object identifier. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

