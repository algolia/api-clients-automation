# Org.OpenAPITools.Model.Hit
A single hit.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ObjectID** | **string** | Unique object identifier. | 
**HighlightResult** | [**Dictionary&lt;string, HighlightResult&gt;**](HighlightResult.md) | Show highlighted section and words matched on a query. | [optional] 
**SnippetResult** | [**Dictionary&lt;string, SnippetResult&gt;**](SnippetResult.md) | Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty. | [optional] 
**RankingInfo** | [**RankingInfo**](RankingInfo.md) |  | [optional] 
**DistinctSeqID** | **int** |  | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

