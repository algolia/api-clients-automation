# Org.OpenAPITools.Model.IgnorePlurals
Treats singular, plurals, and other forms of declensions as matching terms. `ignorePlurals` is used in conjunction with the `queryLanguages` setting. _list_: language ISO codes for which ignoring plurals should be enabled. This list will override any values that you may have set in `queryLanguages`. _true_: enables the ignore plurals feature, where singulars and plurals are considered equivalent (\"foot\" = \"feet\"). The languages supported here are either [every language](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/) (this is the default) or those set by `queryLanguages`. _false_: turns off the ignore plurals feature, so that singulars and plurals aren't considered to be the same (\"foot\" will not find \"feet\"). 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

