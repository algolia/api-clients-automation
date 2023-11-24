# Algolia.search.Model.DictionaryEntry
Dictionary entry.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ObjectID** | **string** | Unique identifier for a dictionary object. | 
**Language** | **string** | [Supported language ISO code](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/).  | 
**Word** | **string** | Dictionary entry word. Usage depends on the type of dictionary entry. **&#x60;stopwordEntry&#x60;** The stop word you want to add or update. If the entry already exists in Algolia&#39;s standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its &#x60;state&#x60; to &#x60;disabled&#x60;. **&#x60;compoundEntry&#x60;** When &#x60;decomposition&#x60; is empty: adds &#x60;word&#x60; as a compound atom. For example, atom “kino” decomposes the query “kopfkino” into \&quot;kopf\&quot; and \&quot;kino\&quot;. When &#x60;decomposition&#x60; isn&#39;t empty: creates a decomposition exception. For example, when decomposition is set to the [\&quot;hund\&quot;, \&quot;hutte\&quot;] exception, \&quot;hundehutte\&quot; decomposes into “hund” and “hutte”, discarding the linking \&quot;e\&quot;.  | [optional] 
**Words** | **List&lt;string&gt;** | Compound dictionary [word declensions](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-plurals-and-other-declensions/). If the entry already exists in Algolia&#39;s standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its &#x60;state&#x60; to &#x60;disabled&#x60;.  | [optional] 
**Decomposition** | **List&lt;string&gt;** | For compound entries, governs the behavior of the &#x60;word&#x60; parameter. | [optional] 
**State** | **DictionaryEntryState** |  | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

