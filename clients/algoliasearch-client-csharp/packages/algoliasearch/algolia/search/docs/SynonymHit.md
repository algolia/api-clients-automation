# Org.OpenAPITools.Model.SynonymHit
Synonym object.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ObjectID** | **string** | Unique identifier of a synonym object. | 
**Type** | **SynonymType** |  | 
**Synonyms** | **List&lt;string&gt;** | Words or phrases considered equivalent. | [optional] 
**Input** | **string** | Word or phrase to appear in query strings (for [&#x60;onewaysynonym&#x60;s](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/in-depth/one-way-synonyms/)). | [optional] 
**Word** | **string** | Word or phrase to appear in query strings (for [&#x60;altcorrection1&#x60; and &#x60;altcorrection2&#x60;](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/in-depth/synonyms-alternative-corrections/)). | [optional] 
**Corrections** | **List&lt;string&gt;** | Words to be matched in records. | [optional] 
**Placeholder** | **string** | [Placeholder token](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/in-depth/synonyms-placeholders/) to be put inside records.  | [optional] 
**Replacements** | **List&lt;string&gt;** | Query words that will match the [placeholder token](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/in-depth/synonyms-placeholders/). | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

