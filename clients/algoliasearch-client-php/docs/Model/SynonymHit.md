# # SynonymHit

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**objectID** | **string** | Unique identifier of the synonym object to be created or updated. |
**type** | **string** | Type of the synonym object. |
**synonyms** | **string[]** | Words or phrases to be considered equivalent. | [optional]
**input** | **string** | Word or phrase to appear in query strings (for onewaysynonym). | [optional]
**word** | **string** | Word or phrase to appear in query strings (for altcorrection1 and altcorrection2). | [optional]
**corrections** | **string[]** | Words to be matched in records. | [optional]
**placeholder** | **string** | Token to be put inside records. | [optional]
**replacements** | **string[]** | List of query words that will match the token. | [optional]
**highlightResult** | [**\Algolia\AlgoliaSearch\Model\SynonymHitHighlightResult**](SynonymHitHighlightResult.md) |  | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
