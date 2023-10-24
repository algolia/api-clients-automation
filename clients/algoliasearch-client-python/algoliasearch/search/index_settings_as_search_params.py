# coding: utf-8

"""
    Search API

    Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import List, Optional
from pydantic import BaseModel, Field, StrictBool, StrictInt, StrictStr, conint, conlist
from algoliasearch.models.advanced_syntax_features import AdvancedSyntaxFeatures
from algoliasearch.models.alternatives_as_exact import AlternativesAsExact
from algoliasearch.models.distinct import Distinct
from algoliasearch.models.exact_on_single_word_query import ExactOnSingleWordQuery
from algoliasearch.models.ignore_plurals import IgnorePlurals
from algoliasearch.models.mode import Mode
from algoliasearch.models.query_type import QueryType
from algoliasearch.models.re_ranking_apply_filter import ReRankingApplyFilter
from algoliasearch.models.remove_stop_words import RemoveStopWords
from algoliasearch.models.remove_words_if_no_results import RemoveWordsIfNoResults
from algoliasearch.models.rendering_content import RenderingContent
from algoliasearch.models.semantic_search import SemanticSearch
from algoliasearch.models.typo_tolerance import TypoTolerance

class IndexSettingsAsSearchParams(BaseModel):
    """
    IndexSettingsAsSearchParams
    """
    attributes_for_faceting: Optional[conlist(StrictStr)] = Field(None, alias="attributesForFaceting", description="Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/) and the [modifiers](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) that can be applied: `filterOnly`, `searchable`, and `afterDistinct`. ")
    attributes_to_retrieve: Optional[conlist(StrictStr)] = Field(None, alias="attributesToRetrieve", description="Attributes to include in the API response. To reduce the size of your response, you can retrieve only some of the attributes. By default, the response includes all attributes.")
    ranking: Optional[conlist(StrictStr)] = Field(None, description="Determines the order in which Algolia [returns your results](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/).")
    custom_ranking: Optional[conlist(StrictStr)] = Field(None, alias="customRanking", description="Specifies the [Custom ranking criterion](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Use the `asc` and `desc` modifiers to specify the ranking order: ascending or descending. ")
    relevancy_strictness: Optional[StrictInt] = Field(100, alias="relevancyStrictness", description="Relevancy threshold below which less relevant results aren't included in the results.")
    attributes_to_highlight: Optional[conlist(StrictStr)] = Field(None, alias="attributesToHighlight", description="Attributes to highlight. Strings that match the search query in the attributes are highlighted by surrounding them with HTML tags (`highlightPreTag` and `highlightPostTag`).")
    attributes_to_snippet: Optional[conlist(StrictStr)] = Field(None, alias="attributesToSnippet", description="Attributes to _snippet_. 'Snippeting' is shortening the attribute to a certain number of words. If not specified, the attribute is shortened to the 10 words around the matching string but you can specify the number. For example: `body:20`. ")
    highlight_pre_tag: Optional[StrictStr] = Field('<em>', alias="highlightPreTag", description="HTML string to insert before the highlighted parts in all highlight and snippet results.")
    highlight_post_tag: Optional[StrictStr] = Field('</em>', alias="highlightPostTag", description="HTML string to insert after the highlighted parts in all highlight and snippet results.")
    snippet_ellipsis_text: Optional[StrictStr] = Field('…', alias="snippetEllipsisText", description="String used as an ellipsis indicator when a snippet is truncated.")
    restrict_highlight_and_snippet_arrays: Optional[StrictBool] = Field(False, alias="restrictHighlightAndSnippetArrays", description="Restrict highlighting and snippeting to items that matched the query.")
    hits_per_page: Optional[conint(strict=True, le=1000, ge=1)] = Field(20, alias="hitsPerPage", description="Number of hits per page.")
    min_word_sizefor1_typo: Optional[StrictInt] = Field(4, alias="minWordSizefor1Typo", description="Minimum number of characters a word in the query string must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).")
    min_word_sizefor2_typos: Optional[StrictInt] = Field(8, alias="minWordSizefor2Typos", description="Minimum number of characters a word in the query string must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).")
    typo_tolerance: Optional[TypoTolerance] = Field(None, alias="typoTolerance")
    allow_typos_on_numeric_tokens: Optional[StrictBool] = Field(True, alias="allowTyposOnNumericTokens", description="Whether to allow typos on numbers (\"numeric tokens\") in the query string.")
    disable_typo_tolerance_on_attributes: Optional[conlist(StrictStr)] = Field(None, alias="disableTypoToleranceOnAttributes", description="Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).")
    ignore_plurals: Optional[IgnorePlurals] = Field(None, alias="ignorePlurals")
    remove_stop_words: Optional[RemoveStopWords] = Field(None, alias="removeStopWords")
    keep_diacritics_on_characters: Optional[StrictStr] = Field('', alias="keepDiacriticsOnCharacters", description="Characters that the engine shouldn't automatically [normalize](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).")
    query_languages: Optional[conlist(StrictStr)] = Field(None, alias="queryLanguages", description="Sets your user's search language. This adjusts language-specific settings and features such as `ignorePlurals`, `removeStopWords`, and [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) word detection.")
    decompound_query: Optional[StrictBool] = Field(True, alias="decompoundQuery", description="[Splits compound words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words) into their component word parts in the query. ")
    enable_rules: Optional[StrictBool] = Field(True, alias="enableRules", description="Incidates whether [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/) are enabled.")
    enable_personalization: Optional[StrictBool] = Field(False, alias="enablePersonalization", description="Incidates whether [Personalization](https://www.algolia.com/doc/guides/personalization/what-is-personalization/) is enabled.")
    query_type: Optional[QueryType] = Field(None, alias="queryType")
    remove_words_if_no_results: Optional[RemoveWordsIfNoResults] = Field(None, alias="removeWordsIfNoResults")
    mode: Optional[Mode] = None
    semantic_search: Optional[SemanticSearch] = Field(None, alias="semanticSearch")
    advanced_syntax: Optional[StrictBool] = Field(False, alias="advancedSyntax", description="Enables the [advanced query syntax](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#advanced-syntax).")
    optional_words: Optional[conlist(StrictStr)] = Field(None, alias="optionalWords", description="Words which should be considered [optional](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words) when found in a query.")
    disable_exact_on_attributes: Optional[conlist(StrictStr)] = Field(None, alias="disableExactOnAttributes", description="Attributes for which you want to [turn off the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).")
    exact_on_single_word_query: Optional[ExactOnSingleWordQuery] = Field(None, alias="exactOnSingleWordQuery")
    alternatives_as_exact: Optional[conlist(AlternativesAsExact)] = Field(None, alias="alternativesAsExact", description="Alternatives that should be considered an exact match by [the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).")
    advanced_syntax_features: Optional[conlist(AdvancedSyntaxFeatures)] = Field(None, alias="advancedSyntaxFeatures", description="Allows you to specify which advanced syntax features are active when `advancedSyntax` is enabled.")
    distinct: Optional[Distinct] = None
    replace_synonyms_in_highlight: Optional[StrictBool] = Field(False, alias="replaceSynonymsInHighlight", description="Whether to highlight and snippet the original word that matches the synonym or the synonym itself.")
    min_proximity: Optional[conint(strict=True, le=7, ge=1)] = Field(1, alias="minProximity", description="Precision of the [proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity).")
    response_fields: Optional[conlist(StrictStr)] = Field(None, alias="responseFields", description="Attributes to include in the API response for search and browse queries.")
    max_facet_hits: Optional[conint(strict=True, le=100)] = Field(10, alias="maxFacetHits", description="Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).")
    max_values_per_facet: Optional[StrictInt] = Field(100, alias="maxValuesPerFacet", description="Maximum number of facet values to return for each facet.")
    sort_facet_values_by: Optional[StrictStr] = Field('count', alias="sortFacetValuesBy", description="Controls how facet values are fetched.")
    attribute_criteria_computed_by_min_proximity: Optional[StrictBool] = Field(False, alias="attributeCriteriaComputedByMinProximity", description="When the [Attribute criterion is ranked above Proximity](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute-and-proximity-combinations) in your ranking formula, Proximity is used to select which searchable attribute is matched in the Attribute ranking stage.")
    rendering_content: Optional[RenderingContent] = Field(None, alias="renderingContent")
    enable_re_ranking: Optional[StrictBool] = Field(True, alias="enableReRanking", description="Indicates whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).")
    re_ranking_apply_filter: Optional[ReRankingApplyFilter] = Field(None, alias="reRankingApplyFilter")
    __properties = ["attributesForFaceting", "attributesToRetrieve", "ranking", "customRanking", "relevancyStrictness", "attributesToHighlight", "attributesToSnippet", "highlightPreTag", "highlightPostTag", "snippetEllipsisText", "restrictHighlightAndSnippetArrays", "hitsPerPage", "minWordSizefor1Typo", "minWordSizefor2Typos", "typoTolerance", "allowTyposOnNumericTokens", "disableTypoToleranceOnAttributes", "ignorePlurals", "removeStopWords", "keepDiacriticsOnCharacters", "queryLanguages", "decompoundQuery", "enableRules", "enablePersonalization", "queryType", "removeWordsIfNoResults", "mode", "semanticSearch", "advancedSyntax", "optionalWords", "disableExactOnAttributes", "exactOnSingleWordQuery", "alternativesAsExact", "advancedSyntaxFeatures", "distinct", "replaceSynonymsInHighlight", "minProximity", "responseFields", "maxFacetHits", "maxValuesPerFacet", "sortFacetValuesBy", "attributeCriteriaComputedByMinProximity", "renderingContent", "enableReRanking", "reRankingApplyFilter"]

    class Config:
        """Pydantic configuration"""
        allow_population_by_field_name = True
        validate_assignment = True

    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.dict(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> IndexSettingsAsSearchParams:
        """Create an instance of IndexSettingsAsSearchParams from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self):
        """Returns the dictionary representation of the model using alias"""
        _dict = self.dict(by_alias=True,
                          exclude={
                          },
                          exclude_none=True)
        # override the default output from pydantic by calling `to_dict()` of typo_tolerance
        if self.typo_tolerance:
            _dict['typoTolerance'] = self.typo_tolerance.to_dict()
        # override the default output from pydantic by calling `to_dict()` of ignore_plurals
        if self.ignore_plurals:
            _dict['ignorePlurals'] = self.ignore_plurals.to_dict()
        # override the default output from pydantic by calling `to_dict()` of remove_stop_words
        if self.remove_stop_words:
            _dict['removeStopWords'] = self.remove_stop_words.to_dict()
        # override the default output from pydantic by calling `to_dict()` of semantic_search
        if self.semantic_search:
            _dict['semanticSearch'] = self.semantic_search.to_dict()
        # override the default output from pydantic by calling `to_dict()` of distinct
        if self.distinct:
            _dict['distinct'] = self.distinct.to_dict()
        # override the default output from pydantic by calling `to_dict()` of rendering_content
        if self.rendering_content:
            _dict['renderingContent'] = self.rendering_content.to_dict()
        # override the default output from pydantic by calling `to_dict()` of re_ranking_apply_filter
        if self.re_ranking_apply_filter:
            _dict['reRankingApplyFilter'] = self.re_ranking_apply_filter.to_dict()
        # set to None if re_ranking_apply_filter (nullable) is None
        # and __fields_set__ contains the field
        if self.re_ranking_apply_filter is None and "re_ranking_apply_filter" in self.__fields_set__:
            _dict['reRankingApplyFilter'] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: dict) -> IndexSettingsAsSearchParams:
        """Create an instance of IndexSettingsAsSearchParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return IndexSettingsAsSearchParams.parse_obj(obj)

        _obj = IndexSettingsAsSearchParams.parse_obj({
            "attributes_for_faceting": obj.get("attributesForFaceting"),
            "attributes_to_retrieve": obj.get("attributesToRetrieve"),
            "ranking": obj.get("ranking"),
            "custom_ranking": obj.get("customRanking"),
            "relevancy_strictness": obj.get("relevancyStrictness") if obj.get("relevancyStrictness") is not None else 100,
            "attributes_to_highlight": obj.get("attributesToHighlight"),
            "attributes_to_snippet": obj.get("attributesToSnippet"),
            "highlight_pre_tag": obj.get("highlightPreTag") if obj.get("highlightPreTag") is not None else '<em>',
            "highlight_post_tag": obj.get("highlightPostTag") if obj.get("highlightPostTag") is not None else '</em>',
            "snippet_ellipsis_text": obj.get("snippetEllipsisText") if obj.get("snippetEllipsisText") is not None else '…',
            "restrict_highlight_and_snippet_arrays": obj.get("restrictHighlightAndSnippetArrays") if obj.get("restrictHighlightAndSnippetArrays") is not None else False,
            "hits_per_page": obj.get("hitsPerPage") if obj.get("hitsPerPage") is not None else 20,
            "min_word_sizefor1_typo": obj.get("minWordSizefor1Typo") if obj.get("minWordSizefor1Typo") is not None else 4,
            "min_word_sizefor2_typos": obj.get("minWordSizefor2Typos") if obj.get("minWordSizefor2Typos") is not None else 8,
            "typo_tolerance": TypoTolerance.from_dict(obj.get("typoTolerance")) if obj.get("typoTolerance") is not None else None,
            "allow_typos_on_numeric_tokens": obj.get("allowTyposOnNumericTokens") if obj.get("allowTyposOnNumericTokens") is not None else True,
            "disable_typo_tolerance_on_attributes": obj.get("disableTypoToleranceOnAttributes"),
            "ignore_plurals": IgnorePlurals.from_dict(obj.get("ignorePlurals")) if obj.get("ignorePlurals") is not None else None,
            "remove_stop_words": RemoveStopWords.from_dict(obj.get("removeStopWords")) if obj.get("removeStopWords") is not None else None,
            "keep_diacritics_on_characters": obj.get("keepDiacriticsOnCharacters") if obj.get("keepDiacriticsOnCharacters") is not None else '',
            "query_languages": obj.get("queryLanguages"),
            "decompound_query": obj.get("decompoundQuery") if obj.get("decompoundQuery") is not None else True,
            "enable_rules": obj.get("enableRules") if obj.get("enableRules") is not None else True,
            "enable_personalization": obj.get("enablePersonalization") if obj.get("enablePersonalization") is not None else False,
            "query_type": obj.get("queryType"),
            "remove_words_if_no_results": obj.get("removeWordsIfNoResults"),
            "mode": obj.get("mode"),
            "semantic_search": SemanticSearch.from_dict(obj.get("semanticSearch")) if obj.get("semanticSearch") is not None else None,
            "advanced_syntax": obj.get("advancedSyntax") if obj.get("advancedSyntax") is not None else False,
            "optional_words": obj.get("optionalWords"),
            "disable_exact_on_attributes": obj.get("disableExactOnAttributes"),
            "exact_on_single_word_query": obj.get("exactOnSingleWordQuery"),
            "alternatives_as_exact": obj.get("alternativesAsExact"),
            "advanced_syntax_features": obj.get("advancedSyntaxFeatures"),
            "distinct": Distinct.from_dict(obj.get("distinct")) if obj.get("distinct") is not None else None,
            "replace_synonyms_in_highlight": obj.get("replaceSynonymsInHighlight") if obj.get("replaceSynonymsInHighlight") is not None else False,
            "min_proximity": obj.get("minProximity") if obj.get("minProximity") is not None else 1,
            "response_fields": obj.get("responseFields"),
            "max_facet_hits": obj.get("maxFacetHits") if obj.get("maxFacetHits") is not None else 10,
            "max_values_per_facet": obj.get("maxValuesPerFacet") if obj.get("maxValuesPerFacet") is not None else 100,
            "sort_facet_values_by": obj.get("sortFacetValuesBy") if obj.get("sortFacetValuesBy") is not None else 'count',
            "attribute_criteria_computed_by_min_proximity": obj.get("attributeCriteriaComputedByMinProximity") if obj.get("attributeCriteriaComputedByMinProximity") is not None else False,
            "rendering_content": RenderingContent.from_dict(obj.get("renderingContent")) if obj.get("renderingContent") is not None else None,
            "enable_re_ranking": obj.get("enableReRanking") if obj.get("enableReRanking") is not None else True,
            "re_ranking_apply_filter": ReRankingApplyFilter.from_dict(obj.get("reRankingApplyFilter")) if obj.get("reRankingApplyFilter") is not None else None
        })
        return _obj


