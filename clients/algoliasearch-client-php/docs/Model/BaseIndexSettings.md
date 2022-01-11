# # BaseIndexSettings

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**replicas** | **string[]** | Creates replicas, exact copies of an index. | [optional]
**paginationLimitedTo** | **int** | Set the maximum number of hits accessible via pagination. | [optional] [default to 1000]
**disableTypoToleranceOnWords** | **string[]** | A list of words for which you want to turn off typo tolerance. | [optional]
**attributesToTransliterate** | **string[]** | Specify on which attributes to apply transliteration. | [optional]
**camelCaseAttributes** | **string[]** | List of attributes on which to do a decomposition of camel case words. | [optional]
**decompoundedAttributes** | **array<string,object>** | Specify on which attributes in your index Algolia should apply word segmentation, also known as decompounding. | [optional]
**indexLanguages** | **string[]** | Sets the languages at the index level for language-specific processing such as tokenization and normalization. | [optional]
**filterPromotes** | **bool** | Whether promoted results should match the filters of the current search, except for geographic filters. | [optional] [default to false]
**disablePrefixOnAttributes** | **string[]** | List of attributes on which you want to disable prefix matching. | [optional]
**allowCompressionOfIntegerArray** | **bool** | Enables compression of large integer arrays. | [optional] [default to false]
**numericAttributesForFiltering** | **string[]** | List of numeric attributes that can be used as numerical filters. | [optional]
**userData** | **array<string,object>** | Lets you store custom data in your indices. | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
