# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, List, Optional, Self

from pydantic import BaseModel, Field, StrictBool, StrictInt, StrictStr

from algoliasearch.search.models.advanced_syntax_features import AdvancedSyntaxFeatures
from algoliasearch.search.models.alternatives_as_exact import AlternativesAsExact
from algoliasearch.search.models.distinct import Distinct
from algoliasearch.search.models.exact_on_single_word_query import (
    ExactOnSingleWordQuery,
)
from algoliasearch.search.models.ignore_plurals import IgnorePlurals
from algoliasearch.search.models.mode import Mode
from algoliasearch.search.models.query_type import QueryType
from algoliasearch.search.models.re_ranking_apply_filter import ReRankingApplyFilter
from algoliasearch.search.models.remove_stop_words import RemoveStopWords
from algoliasearch.search.models.remove_words_if_no_results import (
    RemoveWordsIfNoResults,
)
from algoliasearch.search.models.rendering_content import RenderingContent
from algoliasearch.search.models.semantic_search import SemanticSearch
from algoliasearch.search.models.typo_tolerance import TypoTolerance


class IndexSettings(BaseModel):
    """
    Algolia index settings.
    """

    replicas: Optional[List[StrictStr]] = Field(
        default=None,
        description="Creates [replicas](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/), which are copies of a primary index with the same records but different settings.",
    )
    pagination_limited_to: Optional[StrictInt] = Field(
        default=1000,
        description="Maximum number of hits accessible through pagination.",
        alias="paginationLimitedTo",
    )
    unretrievable_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes that can't be retrieved at query time.",
        alias="unretrievableAttributes",
    )
    disable_typo_tolerance_on_words: Optional[List[StrictStr]] = Field(
        default=None,
        description="Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).",
        alias="disableTypoToleranceOnWords",
    )
    attributes_to_transliterate: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes in your index to which [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead) applies. This will ensure that words indexed in Katakana or Kanji can also be searched in Hiragana.",
        alias="attributesToTransliterate",
    )
    camel_case_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes on which to split [camel case](https://wikipedia.org/wiki/Camel_case) words.",
        alias="camelCaseAttributes",
    )
    decompounded_attributes: Optional[Dict[str, Any]] = Field(
        default=None,
        description="Attributes in your index to which [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding) applies.",
        alias="decompoundedAttributes",
    )
    index_languages: Optional[List[StrictStr]] = Field(
        default=None,
        description="Set the languages of your index, for language-specific processing steps such as [tokenization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/tokenization/) and [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).",
        alias="indexLanguages",
    )
    disable_prefix_on_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).",
        alias="disablePrefixOnAttributes",
    )
    allow_compression_of_integer_array: Optional[StrictBool] = Field(
        default=False,
        description="Incidates whether the engine compresses arrays with exclusively non-negative integers. When enabled, the compressed arrays may be reordered. ",
        alias="allowCompressionOfIntegerArray",
    )
    numeric_attributes_for_filtering: Optional[List[StrictStr]] = Field(
        default=None,
        description="Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).",
        alias="numericAttributesForFiltering",
    )
    separators_to_index: Optional[StrictStr] = Field(
        default="",
        description="Controls which separators are added to an Algolia index as part of [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean). Separators are all non-letter characters except spaces and currency characters, such as $€£¥.",
        alias="separatorsToIndex",
    )
    searchable_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="[Attributes used for searching](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/), including determining [if matches at the beginning of a word are important (ordered) or not (unordered)](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/how-to/configuring-searchable-attributes-the-right-way/#understanding-word-position). ",
        alias="searchableAttributes",
    )
    user_data: Optional[Dict[str, Any]] = Field(
        default=None,
        description="Lets you store custom data in your indices.",
        alias="userData",
    )
    custom_normalization: Optional[Dict[str, Dict[str, StrictStr]]] = Field(
        default=None,
        description="A list of characters and their normalized replacements to override Algolia's default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).",
        alias="customNormalization",
    )
    attribute_for_distinct: Optional[StrictStr] = Field(
        default=None,
        description="Name of the deduplication attribute to be used with Algolia's [_distinct_ feature](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/#introducing-algolias-distinct-feature).",
        alias="attributeForDistinct",
    )
    attributes_for_faceting: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/) and the [modifiers](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) that can be applied: `filterOnly`, `searchable`, and `afterDistinct`. ",
        alias="attributesForFaceting",
    )
    attributes_to_retrieve: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes to include in the API response. To reduce the size of your response, you can retrieve only some of the attributes. By default, the response includes all attributes.",
        alias="attributesToRetrieve",
    )
    ranking: Optional[List[StrictStr]] = Field(
        default=None,
        description="Determines the order in which Algolia [returns your results](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/).",
    )
    custom_ranking: Optional[List[StrictStr]] = Field(
        default=None,
        description="Specifies the [Custom ranking criterion](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Use the `asc` and `desc` modifiers to specify the ranking order: ascending or descending. ",
        alias="customRanking",
    )
    relevancy_strictness: Optional[StrictInt] = Field(
        default=100,
        description="Relevancy threshold below which less relevant results aren't included in the results.",
        alias="relevancyStrictness",
    )
    attributes_to_highlight: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes to highlight. Strings that match the search query in the attributes are highlighted by surrounding them with HTML tags (`highlightPreTag` and `highlightPostTag`).",
        alias="attributesToHighlight",
    )
    attributes_to_snippet: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes to _snippet_. 'Snippeting' is shortening the attribute to a certain number of words. If not specified, the attribute is shortened to the 10 words around the matching string but you can specify the number. For example: `body:20`. ",
        alias="attributesToSnippet",
    )
    highlight_pre_tag: Optional[StrictStr] = Field(
        default="<em>",
        description="HTML string to insert before the highlighted parts in all highlight and snippet results.",
        alias="highlightPreTag",
    )
    highlight_post_tag: Optional[StrictStr] = Field(
        default="</em>",
        description="HTML string to insert after the highlighted parts in all highlight and snippet results.",
        alias="highlightPostTag",
    )
    snippet_ellipsis_text: Optional[StrictStr] = Field(
        default="…",
        description="String used as an ellipsis indicator when a snippet is truncated.",
        alias="snippetEllipsisText",
    )
    restrict_highlight_and_snippet_arrays: Optional[StrictBool] = Field(
        default=False,
        description="Restrict highlighting and snippeting to items that matched the query.",
        alias="restrictHighlightAndSnippetArrays",
    )
    hits_per_page: Optional[Annotated[int, Field(le=1000, strict=True, ge=1)]] = Field(
        default=20, description="Number of hits per page.", alias="hitsPerPage"
    )
    min_word_sizefor1_typo: Optional[StrictInt] = Field(
        default=4,
        description="Minimum number of characters a word in the query string must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).",
        alias="minWordSizefor1Typo",
    )
    min_word_sizefor2_typos: Optional[StrictInt] = Field(
        default=8,
        description="Minimum number of characters a word in the query string must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).",
        alias="minWordSizefor2Typos",
    )
    typo_tolerance: Optional[TypoTolerance] = Field(default=None, alias="typoTolerance")
    allow_typos_on_numeric_tokens: Optional[StrictBool] = Field(
        default=True,
        description='Whether to allow typos on numbers ("numeric tokens") in the query string.',
        alias="allowTyposOnNumericTokens",
    )
    disable_typo_tolerance_on_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).",
        alias="disableTypoToleranceOnAttributes",
    )
    ignore_plurals: Optional[IgnorePlurals] = Field(default=None, alias="ignorePlurals")
    remove_stop_words: Optional[RemoveStopWords] = Field(
        default=None, alias="removeStopWords"
    )
    keep_diacritics_on_characters: Optional[StrictStr] = Field(
        default="",
        description="Characters that the engine shouldn't automatically [normalize](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).",
        alias="keepDiacriticsOnCharacters",
    )
    query_languages: Optional[List[StrictStr]] = Field(
        default=None,
        description="Sets your user's search language. This adjusts language-specific settings and features such as `ignorePlurals`, `removeStopWords`, and [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) word detection.",
        alias="queryLanguages",
    )
    decompound_query: Optional[StrictBool] = Field(
        default=True,
        description="[Splits compound words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words) into their component word parts in the query. ",
        alias="decompoundQuery",
    )
    enable_rules: Optional[StrictBool] = Field(
        default=True,
        description="Incidates whether [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/) are enabled.",
        alias="enableRules",
    )
    enable_personalization: Optional[StrictBool] = Field(
        default=False,
        description="Incidates whether [Personalization](https://www.algolia.com/doc/guides/personalization/what-is-personalization/) is enabled.",
        alias="enablePersonalization",
    )
    query_type: Optional[QueryType] = Field(default=None, alias="queryType")
    remove_words_if_no_results: Optional[RemoveWordsIfNoResults] = Field(
        default=None, alias="removeWordsIfNoResults"
    )
    mode: Optional[Mode] = None
    semantic_search: Optional[SemanticSearch] = Field(
        default=None, alias="semanticSearch"
    )
    advanced_syntax: Optional[StrictBool] = Field(
        default=False,
        description="Enables the [advanced query syntax](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#advanced-syntax).",
        alias="advancedSyntax",
    )
    optional_words: Optional[List[StrictStr]] = Field(
        default=None,
        description="Words which should be considered [optional](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words) when found in a query.",
        alias="optionalWords",
    )
    disable_exact_on_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes for which you want to [turn off the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).",
        alias="disableExactOnAttributes",
    )
    exact_on_single_word_query: Optional[ExactOnSingleWordQuery] = Field(
        default=None, alias="exactOnSingleWordQuery"
    )
    alternatives_as_exact: Optional[List[AlternativesAsExact]] = Field(
        default=None,
        description="Alternatives that should be considered an exact match by [the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).",
        alias="alternativesAsExact",
    )
    advanced_syntax_features: Optional[List[AdvancedSyntaxFeatures]] = Field(
        default=None,
        description="Allows you to specify which advanced syntax features are active when `advancedSyntax` is enabled.",
        alias="advancedSyntaxFeatures",
    )
    distinct: Optional[Distinct] = None
    replace_synonyms_in_highlight: Optional[StrictBool] = Field(
        default=False,
        description="Whether to highlight and snippet the original word that matches the synonym or the synonym itself.",
        alias="replaceSynonymsInHighlight",
    )
    min_proximity: Optional[Annotated[int, Field(le=7, strict=True, ge=1)]] = Field(
        default=1,
        description="Precision of the [proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity).",
        alias="minProximity",
    )
    response_fields: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes to include in the API response for search and browse queries.",
        alias="responseFields",
    )
    max_facet_hits: Optional[Annotated[int, Field(le=100, strict=True)]] = Field(
        default=10,
        description="Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).",
        alias="maxFacetHits",
    )
    max_values_per_facet: Optional[StrictInt] = Field(
        default=100,
        description="Maximum number of facet values to return for each facet.",
        alias="maxValuesPerFacet",
    )
    sort_facet_values_by: Optional[StrictStr] = Field(
        default="count",
        description="Controls how facet values are fetched.",
        alias="sortFacetValuesBy",
    )
    attribute_criteria_computed_by_min_proximity: Optional[StrictBool] = Field(
        default=False,
        description="When the [Attribute criterion is ranked above Proximity](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute-and-proximity-combinations) in your ranking formula, Proximity is used to select which searchable attribute is matched in the Attribute ranking stage.",
        alias="attributeCriteriaComputedByMinProximity",
    )
    rendering_content: Optional[RenderingContent] = Field(
        default=None, alias="renderingContent"
    )
    enable_re_ranking: Optional[StrictBool] = Field(
        default=True,
        description="Indicates whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).",
        alias="enableReRanking",
    )
    re_ranking_apply_filter: Optional[ReRankingApplyFilter] = Field(
        default=None, alias="reRankingApplyFilter"
    )

    model_config = {"populate_by_name": True, "validate_assignment": True}

    def to_json(self) -> str:
        return self.model_dump_json(by_alias=True, exclude_unset=True)

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of IndexSettings from a JSON string"""
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
        if self.typo_tolerance:
            _dict["typoTolerance"] = self.typo_tolerance.to_dict()
        if self.ignore_plurals:
            _dict["ignorePlurals"] = self.ignore_plurals.to_dict()
        if self.remove_stop_words:
            _dict["removeStopWords"] = self.remove_stop_words.to_dict()
        if self.semantic_search:
            _dict["semanticSearch"] = self.semantic_search.to_dict()
        if self.distinct:
            _dict["distinct"] = self.distinct.to_dict()
        if self.rendering_content:
            _dict["renderingContent"] = self.rendering_content.to_dict()
        if self.re_ranking_apply_filter:
            _dict["reRankingApplyFilter"] = self.re_ranking_apply_filter.to_dict()
        # set to None if re_ranking_apply_filter (nullable) is None
        # and model_fields_set contains the field
        if (
            self.re_ranking_apply_filter is None
            and "re_ranking_apply_filter" in self.model_fields_set
        ):
            _dict["reRankingApplyFilter"] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of IndexSettings from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
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
                "attributesForFaceting": obj.get("attributesForFaceting"),
                "attributesToRetrieve": obj.get("attributesToRetrieve"),
                "ranking": obj.get("ranking"),
                "customRanking": obj.get("customRanking"),
                "relevancyStrictness": obj.get("relevancyStrictness"),
                "attributesToHighlight": obj.get("attributesToHighlight"),
                "attributesToSnippet": obj.get("attributesToSnippet"),
                "highlightPreTag": obj.get("highlightPreTag"),
                "highlightPostTag": obj.get("highlightPostTag"),
                "snippetEllipsisText": obj.get("snippetEllipsisText"),
                "restrictHighlightAndSnippetArrays": obj.get(
                    "restrictHighlightAndSnippetArrays"
                ),
                "hitsPerPage": obj.get("hitsPerPage"),
                "minWordSizefor1Typo": obj.get("minWordSizefor1Typo"),
                "minWordSizefor2Typos": obj.get("minWordSizefor2Typos"),
                "typoTolerance": TypoTolerance.from_dict(obj.get("typoTolerance"))
                if obj.get("typoTolerance") is not None
                else None,
                "allowTyposOnNumericTokens": obj.get("allowTyposOnNumericTokens"),
                "disableTypoToleranceOnAttributes": obj.get(
                    "disableTypoToleranceOnAttributes"
                ),
                "ignorePlurals": IgnorePlurals.from_dict(obj.get("ignorePlurals"))
                if obj.get("ignorePlurals") is not None
                else None,
                "removeStopWords": RemoveStopWords.from_dict(obj.get("removeStopWords"))
                if obj.get("removeStopWords") is not None
                else None,
                "keepDiacriticsOnCharacters": obj.get("keepDiacriticsOnCharacters"),
                "queryLanguages": obj.get("queryLanguages"),
                "decompoundQuery": obj.get("decompoundQuery"),
                "enableRules": obj.get("enableRules"),
                "enablePersonalization": obj.get("enablePersonalization"),
                "queryType": obj.get("queryType"),
                "removeWordsIfNoResults": obj.get("removeWordsIfNoResults"),
                "mode": obj.get("mode"),
                "semanticSearch": SemanticSearch.from_dict(obj.get("semanticSearch"))
                if obj.get("semanticSearch") is not None
                else None,
                "advancedSyntax": obj.get("advancedSyntax"),
                "optionalWords": obj.get("optionalWords"),
                "disableExactOnAttributes": obj.get("disableExactOnAttributes"),
                "exactOnSingleWordQuery": obj.get("exactOnSingleWordQuery"),
                "alternativesAsExact": obj.get("alternativesAsExact"),
                "advancedSyntaxFeatures": obj.get("advancedSyntaxFeatures"),
                "distinct": Distinct.from_dict(obj.get("distinct"))
                if obj.get("distinct") is not None
                else None,
                "replaceSynonymsInHighlight": obj.get("replaceSynonymsInHighlight"),
                "minProximity": obj.get("minProximity"),
                "responseFields": obj.get("responseFields"),
                "maxFacetHits": obj.get("maxFacetHits"),
                "maxValuesPerFacet": obj.get("maxValuesPerFacet"),
                "sortFacetValuesBy": obj.get("sortFacetValuesBy"),
                "attributeCriteriaComputedByMinProximity": obj.get(
                    "attributeCriteriaComputedByMinProximity"
                ),
                "renderingContent": RenderingContent.from_dict(
                    obj.get("renderingContent")
                )
                if obj.get("renderingContent") is not None
                else None,
                "enableReRanking": obj.get("enableReRanking"),
                "reRankingApplyFilter": ReRankingApplyFilter.from_dict(
                    obj.get("reRankingApplyFilter")
                )
                if obj.get("reRankingApplyFilter") is not None
                else None,
            }
        )
        return _obj
