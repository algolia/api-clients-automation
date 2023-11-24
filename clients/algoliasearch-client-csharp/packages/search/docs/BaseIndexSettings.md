# Algolia.search.Model.BaseIndexSettings

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Replicas** | **List&lt;string&gt;** | Creates [replicas](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/), which are copies of a primary index with the same records but different settings. | [optional] 
**PaginationLimitedTo** | **int** | Maximum number of hits accessible through pagination. | [optional] [default to 1000]
**UnretrievableAttributes** | **List&lt;string&gt;** | Attributes that can&#39;t be retrieved at query time. | [optional] 
**DisableTypoToleranceOnWords** | **List&lt;string&gt;** | Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). | [optional] 
**AttributesToTransliterate** | **List&lt;string&gt;** | Attributes in your index to which [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead) applies. This will ensure that words indexed in Katakana or Kanji can also be searched in Hiragana. | [optional] 
**CamelCaseAttributes** | **List&lt;string&gt;** | Attributes on which to split [camel case](https://wikipedia.org/wiki/Camel_case) words. | [optional] 
**DecompoundedAttributes** | **Object** | Attributes in your index to which [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding) applies. | [optional] 
**IndexLanguages** | **List&lt;string&gt;** | Set the languages of your index, for language-specific processing steps such as [tokenization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/tokenization/) and [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/). | [optional] 
**DisablePrefixOnAttributes** | **List&lt;string&gt;** | Attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search). | [optional] 
**AllowCompressionOfIntegerArray** | **bool** | Incidates whether the engine compresses arrays with exclusively non-negative integers. When enabled, the compressed arrays may be reordered.  | [optional] [default to false]
**NumericAttributesForFiltering** | **List&lt;string&gt;** | Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters). | [optional] 
**SeparatorsToIndex** | **string** | Controls which separators are added to an Algolia index as part of [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean). Separators are all non-letter characters except spaces and currency characters, such as $€£¥. | [optional] [default to ""]
**SearchableAttributes** | **List&lt;string&gt;** | [Attributes used for searching](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/), including determining [if matches at the beginning of a word are important (ordered) or not (unordered)](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/how-to/configuring-searchable-attributes-the-right-way/#understanding-word-position).  | [optional] 
**UserData** | **Object** | Lets you store custom data in your indices. | [optional] 
**CustomNormalization** | **Dictionary&lt;string, Dictionary&lt;string, string&gt;&gt;** | A list of characters and their normalized replacements to override Algolia&#39;s default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/). | [optional] 
**AttributeForDistinct** | **string** | Name of the deduplication attribute to be used with Algolia&#39;s [_distinct_ feature](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/#introducing-algolias-distinct-feature). | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

