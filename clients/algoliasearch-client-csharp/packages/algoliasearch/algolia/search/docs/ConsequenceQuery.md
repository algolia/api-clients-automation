# Org.OpenAPITools.Model.ConsequenceQuery
When providing a string, it replaces the entire query string. When providing an object, it describes incremental edits to be made to the query string (but you can't do both).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Remove** | **List&lt;string&gt;** | Words to remove. | [optional] 
**Edits** | [**List&lt;Edit&gt;**](Edit.md) | Edits to apply. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

