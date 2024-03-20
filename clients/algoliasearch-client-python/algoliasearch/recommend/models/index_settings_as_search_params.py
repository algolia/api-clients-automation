# coding: utf-8

"""
Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
"""
from __future__ import annotations

from json import loads
from typing import Annotated, Any, Dict, List, Optional, Self

from pydantic import BaseModel, Field, StrictBool, StrictInt, StrictStr

from algoliasearch.recommend.models.advanced_syntax_features import (
    AdvancedSyntaxFeatures,
)
from algoliasearch.recommend.models.alternatives_as_exact import AlternativesAsExact
from algoliasearch.recommend.models.distinct import Distinct
from algoliasearch.recommend.models.exact_on_single_word_query import (
    ExactOnSingleWordQuery,
)
from algoliasearch.recommend.models.ignore_plurals import IgnorePlurals
from algoliasearch.recommend.models.mode import Mode
from algoliasearch.recommend.models.query_type import QueryType
from algoliasearch.recommend.models.re_ranking_apply_filter import ReRankingApplyFilter
from algoliasearch.recommend.models.remove_stop_words import RemoveStopWords
from algoliasearch.recommend.models.remove_words_if_no_results import (
    RemoveWordsIfNoResults,
)
from algoliasearch.recommend.models.rendering_content import RenderingContent
from algoliasearch.recommend.models.semantic_search import SemanticSearch
from algoliasearch.recommend.models.supported_language import SupportedLanguage
from algoliasearch.recommend.models.typo_tolerance import TypoTolerance


class IndexSettingsAsSearchParams(BaseModel):
    """
    IndexSettingsAsSearchParams
    """

    attributes_to_retrieve: Optional[List[StrictStr]] = Field(
        default=None,
        description='Attributes to include in the API response.  To reduce the size of your response, you can retrieve only some of the attributes.  - `*` retrieves all attributes, except attributes included in the `customRanking` and `unretrievableAttributes` settings. - To retrieve all attributes except a specific one, prefix the attribute with a dash and combine it with the `*`: `["*", "-ATTRIBUTE"]`. - The `objectID` attribute is always included. ',
        alias="attributesToRetrieve",
    )
    ranking: Optional[List[StrictStr]] = Field(
        default=None,
        description='Determines the order in which Algolia returns your results.  By default, each entry corresponds to a [ranking criteria](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/). The tie-breaking algorithm sequentially applies each criterion in the order they\'re specified. If you configure a replica index for [sorting by an attribute](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/how-to/sort-by-attribute/), you put the sorting attribute at the top of the list.  **Modifiers**  <dl> <dt><code>asc("ATTRIBUTE")</code></dt> <dd>Sort the index by the values of an attribute, in ascending order.</dd> <dt><code>desc("ATTRIBUTE")</code></dt> <dd>Sort the index by the values of an attribute, in descending order.</dd> </dl>  Before you modify the default setting, you should test your changes in the dashboard, and by [A/B testing](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/). ',
    )
    custom_ranking: Optional[List[StrictStr]] = Field(
        default=None,
        description='Attributes to use as [custom ranking](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/).  The custom ranking attributes decide which items are shown first if the other ranking criteria are equal.  Records with missing values for your selected custom ranking attributes are always sorted last. Boolean attributes are sorted based on their alphabetical order.  **Modifiers**  <dl> <dt><code>asc("ATTRIBUTE")</code></dt> <dd>Sort the index by the values of an attribute, in ascending order.</dd> <dt><code>desc("ATTRIBUTE")</code></dt> <dd>Sort the index by the values of an attribute, in descending order.</dd> </dl>  If you use two or more custom ranking attributes, [reduce the precision](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/how-to/controlling-custom-ranking-metrics-precision/) of your first attributes, or the other attributes will never be applied. ',
        alias="customRanking",
    )
    relevancy_strictness: Optional[StrictInt] = Field(
        default=100,
        description="Relevancy threshold below which less relevant results aren't included in the results.  You can only set `relevancyStrictness` on [virtual replica indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/#what-are-virtual-replicas). Use this setting to strike a balance between the relevance and number of returned results. ",
        alias="relevancyStrictness",
    )
    attributes_to_highlight: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes to highlight.  By default, all searchable attributes are highlighted. Use `*` to highlight all attributes or use an empty array `[]` to turn off highlighting.  With highlighting, strings that match the search query are surrounded by HTML tags defined by `highlightPreTag` and `highlightPostTag`. You can use this to visually highlight matching parts of a search query in your UI.  For more information, see [Highlighting and snippeting](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/highlighting-snippeting/js/). ",
        alias="attributesToHighlight",
    )
    attributes_to_snippet: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes for which to enable snippets.  Snippets provide additional context to matched words. If you enable snippets, they include 10 words, including the matched word. The matched word will also be wrapped by HTML tags for highlighting. You can adjust the number of words with the following notation: `ATTRIBUTE:NUMBER`, where `NUMBER` is the number of words to be extracted. ",
        alias="attributesToSnippet",
    )
    highlight_pre_tag: Optional[StrictStr] = Field(
        default="<em>",
        description="HTML tag to insert before the highlighted parts in all highlighted results and snippets.",
        alias="highlightPreTag",
    )
    highlight_post_tag: Optional[StrictStr] = Field(
        default="</em>",
        description="HTML tag to insert after the highlighted parts in all highlighted results and snippets.",
        alias="highlightPostTag",
    )
    snippet_ellipsis_text: Optional[StrictStr] = Field(
        default="…",
        description="String used as an ellipsis indicator when a snippet is truncated.",
        alias="snippetEllipsisText",
    )
    restrict_highlight_and_snippet_arrays: Optional[StrictBool] = Field(
        default=False,
        description="Whether to restrict highlighting and snippeting to items that at least partially matched the search query. By default, all items are highlighted and snippeted. ",
        alias="restrictHighlightAndSnippetArrays",
    )
    hits_per_page: Optional[Annotated[int, Field(le=1000, strict=True, ge=1)]] = Field(
        default=20, description="Number of hits per page.", alias="hitsPerPage"
    )
    min_word_sizefor1_typo: Optional[StrictInt] = Field(
        default=4,
        description="Minimum number of characters a word in the search query must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).",
        alias="minWordSizefor1Typo",
    )
    min_word_sizefor2_typos: Optional[StrictInt] = Field(
        default=8,
        description="Minimum number of characters a word in the search query must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).",
        alias="minWordSizefor2Typos",
    )
    typo_tolerance: Optional[TypoTolerance] = Field(default=None, alias="typoTolerance")
    allow_typos_on_numeric_tokens: Optional[StrictBool] = Field(
        default=True,
        description="Whether to allow typos on numbers in the search query.  Turn off this setting to reduce the number of irrelevant matches when searching in large sets of similar numbers. ",
        alias="allowTyposOnNumericTokens",
    )
    disable_typo_tolerance_on_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).  Returning only exact matches can help when:  - [Searching in hyphenated attributes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/how-to/how-to-search-in-hyphenated-attributes/). - Reducing the number of matches when you have too many.   This can happen with attributes that are long blocks of text, such as product descriptions.  Consider alternatives such as `disableTypoToleranceOnWords` or adding synonyms if your attributes have intentional unusual spellings that might look like typos. ",
        alias="disableTypoToleranceOnAttributes",
    )
    ignore_plurals: Optional[IgnorePlurals] = Field(default=None, alias="ignorePlurals")
    remove_stop_words: Optional[RemoveStopWords] = Field(
        default=None, alias="removeStopWords"
    )
    keep_diacritics_on_characters: Optional[StrictStr] = Field(
        default="",
        description="Characters for which diacritics should be preserved.  By default, Algolia removes diacritics from letters. For example, `é` becomes `e`. If this causes issues in your search, you can specify characters that should keep their diacritics. ",
        alias="keepDiacriticsOnCharacters",
    )
    query_languages: Optional[List[SupportedLanguage]] = Field(
        default=None,
        description="Languages for language-specific query processing steps such as plurals, stop-word removal, and word-detection dictionaries.  This setting sets a default list of languages used by the `removeStopWords` and `ignorePlurals` settings. This setting also sets a dictionary for word detection in the logogram-based [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) languages. To support this, you must place the CJK language **first**.  **You should always specify a query language.** If you don't specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/). ",
        alias="queryLanguages",
    )
    decompound_query: Optional[StrictBool] = Field(
        default=True,
        description="Whether to split compound words into their building blocks.  For more information, see [Word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words). Word segmentation is supported for these languages: German, Dutch, Finnish, Swedish, and Norwegian. ",
        alias="decompoundQuery",
    )
    enable_rules: Optional[StrictBool] = Field(
        default=True, description="Whether to enable rules.", alias="enableRules"
    )
    enable_personalization: Optional[StrictBool] = Field(
        default=False,
        description="Whether to enable Personalization.",
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
        description="Whether to support phrase matching and excluding words from search queries.  Use the `advancedSyntaxFeatures` parameter to control which feature is supported. ",
        alias="advancedSyntax",
    )
    optional_words: Optional[List[StrictStr]] = Field(
        default=None,
        description='Words that should be considered optional when found in the query.  By default, records must match all words in the search query to be included in the search results. Adding optional words can help to increase the number of search results by running an additional search query that doesn\'t include the optional words. For example, if the search query is "action video" and "video" is an optional word, the search engine runs two queries. One for "action video" and one for "action". Records that match all words are ranked higher.  For a search query with 4 or more words **and** all its words are optional, the number of matched words required for a record to be included in the search results increases for every 1,000 records:  - If `optionalWords` has less than 10 words, the required number of matched words increases by 1:   results 1 to 1,000 require 1 matched word, results 1,001 to 2000 need 2 matched words. - If `optionalWords` has 10 or more words, the number of required matched words increases by the number of optional words dividied by 5 (rounded down).   For example, with 18 optional words: results 1 to 1,000 require 1 matched word, results 1,001 to 2000 need 4 matched words.  For more information, see [Optional words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words). ',
        alias="optionalWords",
    )
    disable_exact_on_attributes: Optional[List[StrictStr]] = Field(
        default=None,
        description="Searchable attributes for which you want to [turn off the Exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).  This can be useful for attributes with long values, where the likelyhood of an exact match is high, such as product descriptions. Turning off the Exact ranking criterion for these attributes favors exact matching on other attributes. This reduces the impact of individual attributes with a lot of content on ranking. ",
        alias="disableExactOnAttributes",
    )
    exact_on_single_word_query: Optional[ExactOnSingleWordQuery] = Field(
        default=None, alias="exactOnSingleWordQuery"
    )
    alternatives_as_exact: Optional[List[AlternativesAsExact]] = Field(
        default=None,
        description='Alternatives of query words that should be considered as exact matches by the Exact ranking criterion.  <dl> <dt><code>ignorePlurals</code></dt> <dd>  Plurals and similar declensions added by the `ignorePlurals` setting are considered exact matches.  </dd> <dt><code>singleWordSynonym</code></dt> <dd> Single-word synonyms, such as "NY/NYC" are considered exact matches. </dd> <dt><code>multiWordsSynonym</code></dt> <dd> Multi-word synonyms, such as "NY/New York" are considered exact matches. </dd> </dl>. ',
        alias="alternativesAsExact",
    )
    advanced_syntax_features: Optional[List[AdvancedSyntaxFeatures]] = Field(
        default=None,
        description='Advanced search syntax features you want to support.  <dl> <dt><code>exactPhrase</code></dt> <dd>  Phrases in quotes must match exactly. For example, `sparkly blue "iPhone case"` only returns records with the exact string "iPhone case".  </dd> <dt><code>excludeWords</code></dt> <dd>  Query words prefixed with a `-` must not occur in a record. For example, `search -engine` matches records that contain "search" but not "engine".  </dd> </dl>  This setting only has an effect if `advancedSyntax` is true. ',
        alias="advancedSyntaxFeatures",
    )
    distinct: Optional[Distinct] = None
    replace_synonyms_in_highlight: Optional[StrictBool] = Field(
        default=False,
        description='Whether to replace a highlighted word with the matched synonym.  By default, the original words are highlighted even if a synonym matches. For example, with `home` as a synonym for `house` and a search for `home`, records matching either "home" or "house" are included in the search results, and either "home" or "house" are highlighted.  With `replaceSynonymsInHighlight` set to `true`, a search for `home` still matches the same records, but all occurences of "house" are replaced by "home" in the highlighted response. ',
        alias="replaceSynonymsInHighlight",
    )
    min_proximity: Optional[Annotated[int, Field(le=7, strict=True, ge=1)]] = Field(
        default=1,
        description="Minimum proximity score for two matching words.  This adjusts the [Proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity) by equally scoring matches that are farther apart.  For example, if `minProximity` is 2, neighboring matches and matches with one word between them would have the same score. ",
        alias="minProximity",
    )
    response_fields: Optional[List[StrictStr]] = Field(
        default=None,
        description="Properties to include in the API response of `search` and `browse` requests.  By default, all response properties are included. To reduce the response size, you can select, which attributes should be included.  You can't exclude these properties: `message`, `warning`, `cursor`, `serverUsed`, `indexUsed`, `abTestVariantID`, `parsedQuery`, or any property triggered by the `getRankingInfo` parameter.  Don't exclude properties that you might need in your search UI. ",
        alias="responseFields",
    )
    max_facet_hits: Optional[Annotated[int, Field(le=100, strict=True)]] = Field(
        default=10,
        description="Maximum number of facet values to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).",
        alias="maxFacetHits",
    )
    max_values_per_facet: Optional[Annotated[int, Field(le=1000, strict=True)]] = Field(
        default=100,
        description="Maximum number of facet values to return for each facet.",
        alias="maxValuesPerFacet",
    )
    sort_facet_values_by: Optional[StrictStr] = Field(
        default="count",
        description="Order in which to retrieve facet values.  <dl> <dt><code>count</code></dt> <dd> Facet values are retrieved by decreasing count. The count is the number of matching records containing this facet value. </dd> <dt><code>alpha</code></dt> <dd>Retrieve facet values alphabetically.</dd> </dl>  This setting doesn't influence how facet values are displayed in your UI (see `renderingContent`). For more information, see [facet value display](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/facet-display/js/). ",
        alias="sortFacetValuesBy",
    )
    attribute_criteria_computed_by_min_proximity: Optional[StrictBool] = Field(
        default=False,
        description="Whether the best matching attribute should be determined by minimum proximity.  This setting only affects ranking if the Attribute ranking criterion comes before Proximity in the `ranking` setting. If true, the best matching attribute is selected based on the minimum proximity of multiple matches. Otherwise, the best matching attribute is determined by the order in the `searchableAttributes` setting. ",
        alias="attributeCriteriaComputedByMinProximity",
    )
    rendering_content: Optional[RenderingContent] = Field(
        default=None, alias="renderingContent"
    )
    enable_re_ranking: Optional[StrictBool] = Field(
        default=True,
        description="Whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).  This setting only has an effect if you activated Dynamic Re-Ranking for this index in the Algolia dashboard. ",
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
        """Create an instance of IndexSettingsAsSearchParams from a JSON string"""
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
        """Create an instance of IndexSettingsAsSearchParams from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate(
            {
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
                "typoTolerance": (
                    TypoTolerance.from_dict(obj.get("typoTolerance"))
                    if obj.get("typoTolerance") is not None
                    else None
                ),
                "allowTyposOnNumericTokens": obj.get("allowTyposOnNumericTokens"),
                "disableTypoToleranceOnAttributes": obj.get(
                    "disableTypoToleranceOnAttributes"
                ),
                "ignorePlurals": (
                    IgnorePlurals.from_dict(obj.get("ignorePlurals"))
                    if obj.get("ignorePlurals") is not None
                    else None
                ),
                "removeStopWords": (
                    RemoveStopWords.from_dict(obj.get("removeStopWords"))
                    if obj.get("removeStopWords") is not None
                    else None
                ),
                "keepDiacriticsOnCharacters": obj.get("keepDiacriticsOnCharacters"),
                "queryLanguages": obj.get("queryLanguages"),
                "decompoundQuery": obj.get("decompoundQuery"),
                "enableRules": obj.get("enableRules"),
                "enablePersonalization": obj.get("enablePersonalization"),
                "queryType": obj.get("queryType"),
                "removeWordsIfNoResults": obj.get("removeWordsIfNoResults"),
                "mode": obj.get("mode"),
                "semanticSearch": (
                    SemanticSearch.from_dict(obj.get("semanticSearch"))
                    if obj.get("semanticSearch") is not None
                    else None
                ),
                "advancedSyntax": obj.get("advancedSyntax"),
                "optionalWords": obj.get("optionalWords"),
                "disableExactOnAttributes": obj.get("disableExactOnAttributes"),
                "exactOnSingleWordQuery": obj.get("exactOnSingleWordQuery"),
                "alternativesAsExact": obj.get("alternativesAsExact"),
                "advancedSyntaxFeatures": obj.get("advancedSyntaxFeatures"),
                "distinct": (
                    Distinct.from_dict(obj.get("distinct"))
                    if obj.get("distinct") is not None
                    else None
                ),
                "replaceSynonymsInHighlight": obj.get("replaceSynonymsInHighlight"),
                "minProximity": obj.get("minProximity"),
                "responseFields": obj.get("responseFields"),
                "maxFacetHits": obj.get("maxFacetHits"),
                "maxValuesPerFacet": obj.get("maxValuesPerFacet"),
                "sortFacetValuesBy": obj.get("sortFacetValuesBy"),
                "attributeCriteriaComputedByMinProximity": obj.get(
                    "attributeCriteriaComputedByMinProximity"
                ),
                "renderingContent": (
                    RenderingContent.from_dict(obj.get("renderingContent"))
                    if obj.get("renderingContent") is not None
                    else None
                ),
                "enableReRanking": obj.get("enableReRanking"),
                "reRankingApplyFilter": (
                    ReRankingApplyFilter.from_dict(obj.get("reRankingApplyFilter"))
                    if obj.get("reRankingApplyFilter") is not None
                    else None
                ),
            }
        )
        return _obj
