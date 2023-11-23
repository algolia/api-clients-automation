# Org.OpenAPITools.Model.SearchRulesParams
Rules search parameters.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Query** | **string** | Rule object query. | [optional] [default to ""]
**Anchoring** | **Anchoring** |  | [optional] 
**Context** | **string** | Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules). | [optional] 
**Page** | **int** | Requested page (the first page is page 0). | [optional] 
**HitsPerPage** | **int** | Maximum number of hits per page. | [optional] [default to 20]
**Enabled** | **bool?** | Restricts responses to enabled rules. When not specified (default), _all_ rules are retrieved. | [optional] 
**RequestOptions** | **List&lt;Object&gt;** | Request options to send with the API call. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

