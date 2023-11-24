# Algolia.search.Model.RemoveStopWords
Removes stop (common) words from the query before executing it. `removeStopWords` is used in conjunction with the `queryLanguages` setting. _list_: language ISO codes for which stop words should be enabled. This list will override any values that you may have set in `queryLanguages`. _true_: enables the stop words feature, ensuring that stop words are removed from consideration in a search. The languages supported here are either [every language](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/) (this is the default) or those set by `queryLanguages`. _false_: turns off the stop words feature, allowing stop words to be taken into account in a search. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

