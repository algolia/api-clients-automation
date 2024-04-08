# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, List, Optional, Self

from pydantic import BaseModel, Field, StrictBool, StrictStr

from algoliasearch.search.models.supported_language import SupportedLanguage


class BaseIndexSettings(BaseModel):
    """
    BaseIndexSettings
    """

    attributes_for_faceting: Optional[List[StrictStr]] = Field(
        default=None,
        description='Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/).  Facets are ways to categorize search results based on attributes. Facets can be used to let user filter search results. By default, no attribute is used for faceting.  **Modifiers**  - `filterOnly("ATTRIBUTE")`.   Allows using this attribute as a filter, but doesn\'t evalue the facet values.  - `searchable("ATTRIBUTE")`.   Allows searching for facet values.  - `afterDistinct("ATTRIBUTE")`.   Evaluates the facet count _after_ deduplication with `distinct`.   This ensures accurate facet counts.   You can apply this modifier to searchable facets: `afterDistinct(searchable(ATTRIBUTE))`. ',
        alias="attributesForFaceting",
    )
    replicas: Optional[List[StrictStr]] = Field(
        default=None,
        description="Creates [replica indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/).  Replicas are copies of a primary index with the same records but different settings, synonyms, or rules. If you want to offer a different ranking or sorting of your search results, you'll use replica indices. All index operations on a primary index are automatically forwarded to its replicas. To add a replica index, you must provide the complete set of replicas to this parameter. If you omit a replica from this list, the replica turns into a regular, standalone index that will no longer by synced with the primary index.  **Modifier**  - `virtual(\"REPLICA\")`.   Create a virtual replica,   Virtual replicas don't increase the number of records and are optimized for [Relevant sorting](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/relevant-sort/). ",
    )
    pagination_limited_to: Optional[Annotated[int, Field(le=20000, strict=True)]] = (
        Field(
            default=1000,
            description="Maximum number of search results that can be obtained through pagination.  Higher pagination limits might slow down your search. For pagination limits above 1,000, the sorting of results beyond the 1,000th hit can't be guaranteed. ",
            alias="paginationLimitedTo",
        )
    )
    unretrievable_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes that can't be retrieved at query time.  This can be useful if you want to use an attribute for ranking or to [restrict access](https://www.algolia.com/doc/guides/security/api-keys/how-to/user-restricted-access-to-data/), but don't want to include it in the search results. ",
        alias="unretrievableAttributes",
    )
    disable_typo_tolerance_on_words: Optional[List[StrictStr]] = Field(
        default=None,
        description="Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). This also turns off [word splitting and concatenation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/splitting-and-concatenation/) for the specified words. ",
        alias="disableTypoToleranceOnWords",
    )
    attributes_to_transliterate: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes, for which you want to support [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead).  Transliteration supports searching in any of the Japanese writing systems. To support transliteration, you must set the indexing language to Japanese. ",
        alias="attributesToTransliterate",
    )
    camel_case_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes for which to split [camel case](https://wikipedia.org/wiki/Camel_case) words.",
        alias="camelCaseAttributes",
    )
    decompounded_attributes: Optional[Dict[str, Any]] = Field(
        default=None,
        description='Searchable attributes to which Algolia should apply [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding).  Compound words are formed by combining two or more individual words, and are particularly prevalent in Germanic languages—for example, "firefighter". With decompounding, the individual components are indexed separately.  You can specify different lists for different languages. Decompounding is supported for these languages: Dutch (`nl`), German (`de`), Finnish (`fi`), Danish (`da`), Swedish (`sv`), and Norwegian (`no`). ',
        alias="decompoundedAttributes",
    )
    index_languages: Optional[List[SupportedLanguage]] = Field(
        default=None,
        description="Languages for language-specific processing steps, such as word detection and dictionary settings.  **You should always specify an indexing language.** If you don't specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/). ",
        alias="indexLanguages",
    )
    disable_prefix_on_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Searchable attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).",
        alias="disablePrefixOnAttributes",
    )
    allow_compression_of_integer_array: Optional[StrictBool] = Field(
        default=False,
        description="Whether arrays with exclusively non-negative integers should be compressed for better performance. If true, the compressed arrays may be reordered. ",
        alias="allowCompressionOfIntegerArray",
    )
    numeric_attributes_for_filtering: Optional[List[StrictStr]] = Field(
        default=None,
        description='Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).  By default, all numeric attributes are available as numerical filters. For faster indexing, reduce the number of numeric attributes.  If you want to turn off filtering for all numeric attributes, specifiy an attribute that doesn\'t exist in your index, such as `NO_NUMERIC_FILTERING`.  **Modifier**  - `equalOnly("ATTRIBUTE")`.   Support only filtering based on equality comparisons `=` and `!=`. ',
        alias="numericAttributesForFiltering",
    )
    separators_to_index: Optional[StrictStr] = Field(
        default="",
        description="Controls which separators are indexed.  Separators are all non-letter characters except spaces and currency characters, such as $€£¥. By default, separator characters aren't indexed. With `separatorsToIndex`, Algolia treats separator characters as separate words. For example, a search for `C#` would report two matches. ",
        alias="separatorsToIndex",
    )
    searchable_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description='Attributes used for searching.  By default, all attributes are searchable and the [Attribute](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute) ranking criterion is turned off. With a non-empty list, Algolia only returns results with matches in the selected attributes. In addition, the Attribute ranking criterion is turned on: matches in attributes that are higher in the list of `searchableAttributes` rank first. To make matches in two attributes rank equally, include them in a comma-separated string, such as `"title,alternate_title"`. Attributes with the same priority are always unordered.  For more information, see [Searchable attributes](https://www.algolia.com/doc/guides/sending-and-managing-data/prepare-your-data/how-to/setting-searchable-attributes/).  **Modifier**  - `unordered("ATTRIBUTE")`.   Ignore the position of a match within the attribute.  Without modifier, matches at the beginning of an attribute rank higer than matches at the end. ',
        alias="searchableAttributes",
    )
    user_data: Optional[Any] = Field(
        default=None,
        description="An object with custom data.  You can store up to 32&nbsp;kB as custom data. ",
        alias="userData",
    )
    custom_normalization: Optional[Dict[str, Dict[str, StrictStr]]] = Field(
        default=None,
        description="Characters and their normalized replacements. This overrides Algolia's default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/). ",
        alias="customNormalization",
    )
    attribute_for_distinct: Optional[StrictStr] = Field(
        default=None,
        description="Attribute that should be used to establish groups of results.  All records with the same value for this attribute are considered a group. You can combine `attributeForDistinct` with the `distinct` search parameter to control how many items per group are included in the search results.  If you want to use the same attribute also for faceting, use the `afterDistinct` modifier of the `attributesForFaceting` setting. This applies faceting _after_ deduplication, which will result in accurate facet counts. ",
        alias="attributeForDistinct",
    )

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of BaseIndexSettings from a JSON string"""
        return cls.from_dict(loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        _dict = self.model_dump(
            by_alias=True,
            exclude={},
            exclude_none=True,
        )
        # set to None if user_data (nullable) is None
        # and model_fields_set contains the field
        if self.user_data is None and "user_data" in self.model_fields_set:
            _dict["userData"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of BaseIndexSettings from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
                "attributesForFaceting": obj.get("attributesForFaceting"),
                "replicas": obj.get("replicas"),
                "paginationLimitedTo": obj.get("paginationLimitedTo"),
                "unretrievableAttributes": obj.get("unretrievableAttributes"),
                "disableTypoToleranceOnWords": obj.get("disableTypoToleranceOnWords"),
                "attributesToTransliterate": obj.get("attributesToTransliterate"),
                "camelCaseAttributes": obj.get("camelCaseAttributes"),
                "decompoundedAttributes": obj.get("decompoundedAttributes"),
                "indexLanguages": obj.get("indexLanguages"),
                "disablePrefixOnAttributes": obj.get("disablePrefixOnAttributes"),
                "allowCompressionOfIntegerArray": obj.get(
                    "allowCompressionOfIntegerArray"
                ),
                "numericAttributesForFiltering": obj.get(
                    "numericAttributesForFiltering"
                ),
                "separatorsToIndex": obj.get("separatorsToIndex"),
                "searchableAttributes": obj.get("searchableAttributes"),
                "userData": obj.get("userData"),
                "customNormalization": obj.get("customNormalization"),
                "attributeForDistinct": obj.get("attributeForDistinct"),
            }
        )
        return _obj
