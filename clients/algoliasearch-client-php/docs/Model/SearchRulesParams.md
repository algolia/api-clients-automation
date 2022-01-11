# # SearchRulesParams

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**query** | **string** | Full text query. | [optional] [default to '']
**anchoring** | [**\Algolia\AlgoliaSearch\Model\Anchoring**](Anchoring.md) |  | [optional]
**context** | **string** | Restricts matches to contextual rules with a specific context (exact match). | [optional]
**page** | **int** | Requested page (zero-based). | [optional] [default to 0]
**hitsPerPage** | **int** | Maximum number of hits in a page. Minimum is 1, maximum is 1000. | [optional] [default to 20]
**enabled** | **bool** | When specified, restricts matches to rules with a specific enabled status. When absent (default), all rules are retrieved, regardless of their enabled status. | [optional]
**requestOptions** | **array<string,object>[]** | A mapping of requestOptions to send along with the request. | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
