/** Search API The Algolia Search API lets you search, configure, and mange your indices and records. ## Client
  * libraries Use Algolia's API clients and libraries to reliably integrate Algolia's APIs with your apps. The official
  * API clients are covered by Algolia's [Service Level Agreement](https://www.algolia.com/policies/sla/). See:
  * [Algolia's ecosystem](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) ##
  * Base URLs The base URLs for requests to the Search API are: - `https://{APPLICATION_ID}.algolia.net` -
  * `https://{APPLICATION_ID}-dsn.algolia.net`. If your subscription includes a [Distributed Search
  * Network](https://dashboard.algolia.com/infra), this ensures that requests are sent to servers closest to users. Both
  * URLs provide high availability by distributing requests with load balancing. **All requests must use HTTPS.** ##
  * Retry strategy To guarantee a high availability, implement a retry strategy for all API requests using the URLs of
  * your servers as fallbacks: - `https://{APPLICATION_ID}-1.algolianet.com` -
  * `https://{APPLICATION_ID}-2.algolianet.com` - `https://{APPLICATION_ID}-3.algolianet.com` These URLs use a different
  * DNS provider than the primary URLs. You should randomize this list to ensure an even load across the three servers.
  * All Algolia API clients implement this retry strategy. ## Authentication To authenticate your API requests, add
  * these headers: - `x-algolia-application-id`. Your Algolia application ID. - `x-algolia-api-key`. An API key with the
  * necessary permissions to make the request. The required access control list (ACL) to make a request is listed in
  * each endpoint's reference. You can find your application ID and API key in the [Algolia
  * dashboard](https://dashboard.algolia.com/account). ## Request format Depending on the endpoint, request bodies are
  * either JSON objects or arrays of JSON objects, ## Parameters Parameters are passed as query parameters for GET and
  * DELETE requests, and in the request body for POST and PUT requests. Query parameters must be
  * [URL-encoded](https://developer.mozilla.org/en-US/docs/Glossary/Percent-encoding). Non-ASCII characters must be
  * UTF-8 encoded. Plus characters (`+`) are interpreted as spaces. Arrays as query parameters must be one of: - A
  * comma-separated string: `attributesToRetrieve=title,description` - A URL-encoded JSON array:
  * `attributesToRetrieve=%5B%22title%22,%22description%22%D` ## Response status and errors The Search API returns JSON
  * responses. Since JSON doesn't guarantee any specific ordering, don't rely on the order of attributes in the API
  * response. Successful responses return a `2xx` status. Client errors return a `4xx` status. Server errors are
  * indicated by a `5xx` status. Error responses have a `message` property with more information. ## Version The current
  * version of the Search API is version 1, as indicated by the `/1/` in each endpoint's URL.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.search

import algoliasearch.search.AdvancedSyntaxFeatures._
import algoliasearch.search.AlternativesAsExact._
import algoliasearch.search.ExactOnSingleWordQuery._
import algoliasearch.search.Mode._
import algoliasearch.search.QueryType._
import algoliasearch.search.RemoveWordsIfNoResults._
import algoliasearch.search.SupportedLanguage._

/** Index settings.
  *
  * @param attributesForFaceting
  *   Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/).
  *   Facets are ways to categorize search results based on attributes. Facets can be used to let user filter search
  *   results. By default, no attribute is used for faceting. **Modifiers** - `filterOnly(\"ATTRIBUTE\")`. Allows using
  *   this attribute as a filter, but doesn't evalue the facet values. - `searchable(\"ATTRIBUTE\")`. Allows searching
  *   for facet values. - `afterDistinct(\"ATTRIBUTE\")`. Evaluates the facet count _after_ deduplication with
  *   `distinct`. This ensures accurate facet counts. You can apply this modifier to searchable facets:
  *   `afterDistinct(searchable(ATTRIBUTE))`.
  * @param replicas
  *   Creates [replica
  *   indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/). Replicas
  *   are copies of a primary index with the same records but different settings, synonyms, or rules. If you want to
  *   offer a different ranking or sorting of your search results, you'll use replica indices. All index operations on a
  *   primary index are automatically forwarded to its replicas. To add a replica index, you must provide the complete
  *   set of replicas to this parameter. If you omit a replica from this list, the replica turns into a regular,
  *   standalone index that will no longer by synced with the primary index. **Modifier** - `virtual(\"REPLICA\")`.
  *   Create a virtual replica, Virtual replicas don't increase the number of records and are optimized for [Relevant
  *   sorting](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/relevant-sort/).
  * @param paginationLimitedTo
  *   Maximum number of search results that can be obtained through pagination. Higher pagination limits might slow down
  *   your search. For pagination limits above 1,000, the sorting of results beyond the 1,000th hit can't be guaranteed.
  * @param unretrievableAttributes
  *   Attributes that can't be retrieved at query time. This can be useful if you want to use an attribute for ranking
  *   or to [restrict
  *   access](https://www.algolia.com/doc/guides/security/api-keys/how-to/user-restricted-access-to-data/), but don't
  *   want to include it in the search results.
  * @param disableTypoToleranceOnWords
  *   Words for which you want to turn off [typo
  *   tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). This also
  *   turns off [word splitting and
  *   concatenation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/splitting-and-concatenation/)
  *   for the specified words.
  * @param attributesToTransliterate
  *   Attributes, for which you want to support [Japanese
  *   transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead).
  *   Transliteration supports searching in any of the Japanese writing systems. To support transliteration, you must
  *   set the indexing language to Japanese.
  * @param camelCaseAttributes
  *   Attributes for which to split [camel case](https://wikipedia.org/wiki/Camel_case) words.
  * @param decompoundedAttributes
  *   Searchable attributes to which Algolia should apply [word
  *   segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/)
  *   (decompounding). Compound words are formed by combining two or more individual words, and are particularly
  *   prevalent in Germanic languages—for example, \"firefighter\". With decompounding, the individual components are
  *   indexed separately. You can specify different lists for different languages. Decompounding is supported for these
  *   languages: Dutch (`nl`), German (`de`), Finnish (`fi`), Danish (`da`), Swedish (`sv`), and Norwegian (`no`).
  * @param indexLanguages
  *   Languages for language-specific processing steps, such as word detection and dictionary settings. **You should
  *   always specify an indexing language.** If you don't specify an indexing language, the search engine uses all
  *   [supported
  *   languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/),
  *   or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to
  *   unexpected search results. For more information, see [Language-specific
  *   configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
  * @param disablePrefixOnAttributes
  *   Searchable attributes for which you want to turn off [prefix
  *   matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).
  * @param allowCompressionOfIntegerArray
  *   Whether arrays with exclusively non-negative integers should be compressed for better performance. If true, the
  *   compressed arrays may be reordered.
  * @param numericAttributesForFiltering
  *   Numeric attributes that can be used as [numerical
  *   filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).
  *   By default, all numeric attributes are available as numerical filters. For faster indexing, reduce the number of
  *   numeric attributes. If you want to turn off filtering for all numeric attributes, specifiy an attribute that
  *   doesn't exist in your index, such as `NO_NUMERIC_FILTERING`. **Modifier** - `equalOnly(\"ATTRIBUTE\")`. Support
  *   only filtering based on equality comparisons `=` and `!=`.
  * @param separatorsToIndex
  *   Controls which separators are indexed. Separators are all non-letter characters except spaces and currency
  *   characters, such as $€£¥. By default, separator characters aren't indexed. With `separatorsToIndex`, Algolia
  *   treats separator characters as separate words. For example, a search for `C#` would report two matches.
  * @param searchableAttributes
  *   Attributes used for searching. By default, all attributes are searchable and the
  *   [Attribute](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute)
  *   ranking criterion is turned off. With a non-empty list, Algolia only returns results with matches in the selected
  *   attributes. In addition, the Attribute ranking criterion is turned on: matches in attributes that are higher in
  *   the list of `searchableAttributes` rank first. To make matches in two attributes rank equally, include them in a
  *   comma-separated string, such as `\"title,alternate_title\"`. Attributes with the same priority are always
  *   unordered. For more information, see [Searchable
  *   attributes](https://www.algolia.com/doc/guides/sending-and-managing-data/prepare-your-data/how-to/setting-searchable-attributes/).
  *   **Modifier** - `unordered(\"ATTRIBUTE\")`. Ignore the position of a match within the attribute. Without modifier,
  *   matches at the beginning of an attribute rank higer than matches at the end.
  * @param userData
  *   An object with custom data. You can store up to 32&nbsp;kB as custom data.
  * @param customNormalization
  *   Characters and their normalized replacements. This overrides Algolia's default
  *   [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
  * @param attributeForDistinct
  *   Attribute that should be used to establish groups of results. All records with the same value for this attribute
  *   are considered a group. You can combine `attributeForDistinct` with the `distinct` search parameter to control how
  *   many items per group are included in the search results. If you want to use the same attribute also for faceting,
  *   use the `afterDistinct` modifier of the `attributesForFaceting` setting. This applies faceting _after_
  *   deduplication, which will result in accurate facet counts.
  * @param attributesToRetrieve
  *   Attributes to include in the API response. To reduce the size of your response, you can retrieve only some of the
  *   attributes. - `*` retrieves all attributes, except attributes included in the `customRanking` and
  *   `unretrievableAttributes` settings. - To retrieve all attributes except a specific one, prefix the attribute with
  *   a dash and combine it with the `*`: `[\"*\", \"-ATTRIBUTE\"]`. - The `objectID` attribute is always included.
  * @param ranking
  *   Determines the order in which Algolia returns your results. By default, each entry corresponds to a [ranking
  *   criteria](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/). The
  *   tie-breaking algorithm sequentially applies each criterion in the order they're specified. If you configure a
  *   replica index for [sorting by an
  *   attribute](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/how-to/sort-by-attribute/),
  *   you put the sorting attribute at the top of the list. **Modifiers** - `asc(\"ATTRIBUTE\")`. Sort the index by the
  *   values of an attribute, in ascending order. - `desc(\"ATTRIBUTE\")`. Sort the index by the values of an attribute,
  *   in descending order. Before you modify the default setting, you should test your changes in the dashboard, and by
  *   [A/B testing](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/).
  * @param customRanking
  *   Attributes to use as [custom
  *   ranking](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). The custom ranking
  *   attributes decide which items are shown first if the other ranking criteria are equal. Records with missing values
  *   for your selected custom ranking attributes are always sorted last. Boolean attributes are sorted based on their
  *   alphabetical order. **Modifiers** - `asc(\"ATTRIBUTE\")`. Sort the index by the values of an attribute, in
  *   ascending order. - `desc(\"ATTRIBUTE\")`. Sort the index by the values of an attribute, in descending order. If
  *   you use two or more custom ranking attributes, [reduce the
  *   precision](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/how-to/controlling-custom-ranking-metrics-precision/)
  *   of your first attributes, or the other attributes will never be applied.
  * @param relevancyStrictness
  *   Relevancy threshold below which less relevant results aren't included in the results. You can only set
  *   `relevancyStrictness` on [virtual replica
  *   indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/#what-are-virtual-replicas).
  *   Use this setting to strike a balance between the relevance and number of returned results.
  * @param attributesToHighlight
  *   Attributes to highlight. By default, all searchable attributes are highlighted. Use `*` to highlight all
  *   attributes or use an empty array `[]` to turn off highlighting. With highlighting, strings that match the search
  *   query are surrounded by HTML tags defined by `highlightPreTag` and `highlightPostTag`. You can use this to
  *   visually highlight matching parts of a search query in your UI. For more information, see [Highlighting and
  *   snippeting](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/highlighting-snippeting/js/).
  * @param attributesToSnippet
  *   Attributes for which to enable snippets. Snippets provide additional context to matched words. If you enable
  *   snippets, they include 10 words, including the matched word. The matched word will also be wrapped by HTML tags
  *   for highlighting. You can adjust the number of words with the following notation: `ATTRIBUTE:NUMBER`, where
  *   `NUMBER` is the number of words to be extracted.
  * @param highlightPreTag
  *   HTML tag to insert before the highlighted parts in all highlighted results and snippets.
  * @param highlightPostTag
  *   HTML tag to insert after the highlighted parts in all highlighted results and snippets.
  * @param snippetEllipsisText
  *   String used as an ellipsis indicator when a snippet is truncated.
  * @param restrictHighlightAndSnippetArrays
  *   Whether to restrict highlighting and snippeting to items that at least partially matched the search query. By
  *   default, all items are highlighted and snippeted.
  * @param hitsPerPage
  *   Number of hits per page.
  * @param minWordSizefor1Typo
  *   Minimum number of characters a word in the search query must contain to accept matches with [one
  *   typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  * @param minWordSizefor2Typos
  *   Minimum number of characters a word in the search query must contain to accept matches with [two
  *   typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  * @param allowTyposOnNumericTokens
  *   Whether to allow typos on numbers in the search query. Turn off this setting to reduce the number of irrelevant
  *   matches when searching in large sets of similar numbers.
  * @param disableTypoToleranceOnAttributes
  *   Attributes for which you want to turn off [typo
  *   tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). Returning
  *   only exact matches can help when: - [Searching in hyphenated
  *   attributes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/how-to/how-to-search-in-hyphenated-attributes/).
  *   \- Reducing the number of matches when you have too many. This can happen with attributes that are long blocks of
  *   text, such as product descriptions. Consider alternatives such as `disableTypoToleranceOnWords` or adding synonyms
  *   if your attributes have intentional unusual spellings that might look like typos.
  * @param keepDiacriticsOnCharacters
  *   Characters for which diacritics should be preserved. By default, Algolia removes diacritics from letters. For
  *   example, `é` becomes `e`. If this causes issues in your search, you can specify characters that should keep their
  *   diacritics.
  * @param queryLanguages
  *   Languages for language-specific query processing steps such as plurals, stop-word removal, and word-detection
  *   dictionaries. This setting sets a default list of languages used by the `removeStopWords` and `ignorePlurals`
  *   settings. This setting also sets a dictionary for word detection in the logogram-based
  *   [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk)
  *   languages. To support this, you must place the CJK language **first**. **You should always specify a query
  *   language.** If you don't specify an indexing language, the search engine uses all [supported
  *   languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/),
  *   or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to
  *   unexpected search results. For more information, see [Language-specific
  *   configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
  * @param decompoundQuery
  *   Whether to split compound words into their building blocks. For more information, see [Word
  *   segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words).
  *   Word segmentation is supported for these languages: German, Dutch, Finnish, Swedish, and Norwegian.
  * @param enableRules
  *   Whether to enable rules.
  * @param enablePersonalization
  *   Whether to enable Personalization.
  * @param advancedSyntax
  *   Whether to support phrase matching and excluding words from search queries. Use the `advancedSyntaxFeatures`
  *   parameter to control which feature is supported.
  * @param optionalWords
  *   Words that should be considered optional when found in the query. By default, records must match all words in the
  *   search query to be included in the search results. Adding optional words can help to increase the number of search
  *   results by running an additional search query that doesn't include the optional words. For example, if the search
  *   query is \"action video\" and \"video\" is an optional word, the search engine runs two queries. One for \"action
  *   video\" and one for \"action\". Records that match all words are ranked higher. For a search query with 4 or more
  *   words **and** all its words are optional, the number of matched words required for a record to be included in the
  *   search results increases for every 1,000 records: - If `optionalWords` has less than 10 words, the required number
  *   of matched words increases by 1: results 1 to 1,000 require 1 matched word, results 1,001 to 2000 need 2 matched
  *   words. - If `optionalWords` has 10 or more words, the number of required matched words increases by the number of
  *   optional words dividied by 5 (rounded down). For example, with 18 optional words: results 1 to 1,000 require 1
  *   matched word, results 1,001 to 2000 need 4 matched words. For more information, see [Optional
  *   words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words).
  * @param disableExactOnAttributes
  *   Searchable attributes for which you want to [turn off the Exact ranking
  *   criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).
  *   This can be useful for attributes with long values, where the likelyhood of an exact match is high, such as
  *   product descriptions. Turning off the Exact ranking criterion for these attributes favors exact matching on other
  *   attributes. This reduces the impact of individual attributes with a lot of content on ranking.
  * @param alternativesAsExact
  *   Alternatives of query words that should be considered as exact matches by the Exact ranking criterion. -
  *   `ignorePlurals`. Plurals and similar declensions added by the `ignorePlurals` setting are considered exact
  *   matches. - `singleWordSynonym`. Single-word synonyms, such as \"NY/NYC\" are considered exact matches. -
  *   `multiWordsSynonym`. Multi-word synonyms, such as \"NY/New York\" are considered exact matches.
  * @param advancedSyntaxFeatures
  *   Advanced search syntax features you want to support. - `exactPhrase`. Phrases in quotes must match exactly. For
  *   example, `sparkly blue \"iPhone case\"` only returns records with the exact string \"iPhone case\". -
  *   `excludeWords`. Query words prefixed with a `-` must not occur in a record. For example, `search -engine` matches
  *   records that contain \"search\" but not \"engine\". This setting only has an effect if `advancedSyntax` is true.
  * @param replaceSynonymsInHighlight
  *   Whether to replace a highlighted word with the matched synonym. By default, the original words are highlighted
  *   even if a synonym matches. For example, with `home` as a synonym for `house` and a search for `home`, records
  *   matching either \"home\" or \"house\" are included in the search results, and either \"home\" or \"house\" are
  *   highlighted. With `replaceSynonymsInHighlight` set to `true`, a search for `home` still matches the same records,
  *   but all occurences of \"house\" are replaced by \"home\" in the highlighted response.
  * @param minProximity
  *   Minimum proximity score for two matching words. This adjusts the [Proximity ranking
  *   criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity)
  *   by equally scoring matches that are farther apart. For example, if `minProximity` is 2, neighboring matches and
  *   matches with one word between them would have the same score.
  * @param responseFields
  *   Properties to include in the API response of `search` and `browse` requests. By default, all response properties
  *   are included. To reduce the response size, you can select, which attributes should be included. You can't exclude
  *   these properties: `message`, `warning`, `cursor`, `serverUsed`, `indexUsed`, `abTestVariantID`, `parsedQuery`, or
  *   any property triggered by the `getRankingInfo` parameter. Don't exclude properties that you might need in your
  *   search UI.
  * @param maxFacetHits
  *   Maximum number of facet values to return when [searching for facet
  *   values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
  * @param maxValuesPerFacet
  *   Maximum number of facet values to return for each facet.
  * @param sortFacetValuesBy
  *   Order in which to retrieve facet values. - `count`. Facet values are retrieved by decreasing count. The count is
  *   the number of matching records containing this facet value. - `alpha`. Retrieve facet values alphabetically. This
  *   setting doesn't influence how facet values are displayed in your UI (see `renderingContent`). For more
  *   information, see [facet value
  *   display](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/facet-display/js/).
  * @param attributeCriteriaComputedByMinProximity
  *   Whether the best matching attribute should be determined by minimum proximity. This setting only affects ranking
  *   if the Attribute ranking criterion comes before Proximity in the `ranking` setting. If true, the best matching
  *   attribute is selected based on the minimum proximity of multiple matches. Otherwise, the best matching attribute
  *   is determined by the order in the `searchableAttributes` setting.
  * @param enableReRanking
  *   Whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/). This
  *   setting only has an effect if you activated Dynamic Re-Ranking for this index in the Algolia dashboard.
  */
case class IndexSettings(
    attributesForFaceting: Option[Seq[String]] = scala.None,
    replicas: Option[Seq[String]] = scala.None,
    paginationLimitedTo: Option[Int] = scala.None,
    unretrievableAttributes: Option[Seq[String]] = scala.None,
    disableTypoToleranceOnWords: Option[Seq[String]] = scala.None,
    attributesToTransliterate: Option[Seq[String]] = scala.None,
    camelCaseAttributes: Option[Seq[String]] = scala.None,
    decompoundedAttributes: Option[Any] = scala.None,
    indexLanguages: Option[Seq[SupportedLanguage]] = scala.None,
    disablePrefixOnAttributes: Option[Seq[String]] = scala.None,
    allowCompressionOfIntegerArray: Option[Boolean] = scala.None,
    numericAttributesForFiltering: Option[Seq[String]] = scala.None,
    separatorsToIndex: Option[String] = scala.None,
    searchableAttributes: Option[Seq[String]] = scala.None,
    userData: Option[Any] = scala.None,
    customNormalization: Option[Map[String, Map[String, String]]] = scala.None,
    attributeForDistinct: Option[String] = scala.None,
    attributesToRetrieve: Option[Seq[String]] = scala.None,
    ranking: Option[Seq[String]] = scala.None,
    customRanking: Option[Seq[String]] = scala.None,
    relevancyStrictness: Option[Int] = scala.None,
    attributesToHighlight: Option[Seq[String]] = scala.None,
    attributesToSnippet: Option[Seq[String]] = scala.None,
    highlightPreTag: Option[String] = scala.None,
    highlightPostTag: Option[String] = scala.None,
    snippetEllipsisText: Option[String] = scala.None,
    restrictHighlightAndSnippetArrays: Option[Boolean] = scala.None,
    hitsPerPage: Option[Int] = scala.None,
    minWordSizefor1Typo: Option[Int] = scala.None,
    minWordSizefor2Typos: Option[Int] = scala.None,
    typoTolerance: Option[TypoTolerance] = scala.None,
    allowTyposOnNumericTokens: Option[Boolean] = scala.None,
    disableTypoToleranceOnAttributes: Option[Seq[String]] = scala.None,
    ignorePlurals: Option[IgnorePlurals] = scala.None,
    removeStopWords: Option[RemoveStopWords] = scala.None,
    keepDiacriticsOnCharacters: Option[String] = scala.None,
    queryLanguages: Option[Seq[SupportedLanguage]] = scala.None,
    decompoundQuery: Option[Boolean] = scala.None,
    enableRules: Option[Boolean] = scala.None,
    enablePersonalization: Option[Boolean] = scala.None,
    queryType: Option[QueryType] = scala.None,
    removeWordsIfNoResults: Option[RemoveWordsIfNoResults] = scala.None,
    mode: Option[Mode] = scala.None,
    semanticSearch: Option[SemanticSearch] = scala.None,
    advancedSyntax: Option[Boolean] = scala.None,
    optionalWords: Option[Seq[String]] = scala.None,
    disableExactOnAttributes: Option[Seq[String]] = scala.None,
    exactOnSingleWordQuery: Option[ExactOnSingleWordQuery] = scala.None,
    alternativesAsExact: Option[Seq[AlternativesAsExact]] = scala.None,
    advancedSyntaxFeatures: Option[Seq[AdvancedSyntaxFeatures]] = scala.None,
    distinct: Option[Distinct] = scala.None,
    replaceSynonymsInHighlight: Option[Boolean] = scala.None,
    minProximity: Option[Int] = scala.None,
    responseFields: Option[Seq[String]] = scala.None,
    maxFacetHits: Option[Int] = scala.None,
    maxValuesPerFacet: Option[Int] = scala.None,
    sortFacetValuesBy: Option[String] = scala.None,
    attributeCriteriaComputedByMinProximity: Option[Boolean] = scala.None,
    renderingContent: Option[RenderingContent] = scala.None,
    enableReRanking: Option[Boolean] = scala.None,
    reRankingApplyFilter: Option[ReRankingApplyFilter] = scala.None
)
