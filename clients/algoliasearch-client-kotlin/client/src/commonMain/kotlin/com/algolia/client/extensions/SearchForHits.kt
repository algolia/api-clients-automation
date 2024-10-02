package com.algolia.client.extensions

import com.algolia.client.model.search.SearchForHits
import com.algolia.client.model.search.SearchParamsObject
import com.algolia.client.model.search.SearchTypeDefault

/**
 * Create a new [SearchForHits] from a [SearchParamsObject] and an [indexName] string.
 * Can take an optional [params] string.
 */
public fun SearchForHits.Companion.from(
  searchParamsObject: SearchParamsObject,
  indexName: String,
  params: String? = null
): SearchForHits {
  return SearchForHits(
    params = params,
    query = searchParamsObject.query,
    similarQuery = searchParamsObject.similarQuery,
    filters = searchParamsObject.filters,
    facetFilters = searchParamsObject.facetFilters,
    optionalFilters = searchParamsObject.optionalFilters,
    numericFilters = searchParamsObject.numericFilters,
    tagFilters = searchParamsObject.tagFilters,
    sumOrFiltersScores = searchParamsObject.sumOrFiltersScores,
    restrictSearchableAttributes = searchParamsObject.restrictSearchableAttributes,
    facets = searchParamsObject.facets,
    facetingAfterDistinct = searchParamsObject.facetingAfterDistinct,
    page = searchParamsObject.page,
    offset = searchParamsObject.offset,
    length = searchParamsObject.length,
    aroundLatLng = searchParamsObject.aroundLatLng,
    aroundLatLngViaIP = searchParamsObject.aroundLatLngViaIP,
    aroundRadius = searchParamsObject.aroundRadius,
    aroundPrecision = searchParamsObject.aroundPrecision,
    minimumAroundRadius = searchParamsObject.minimumAroundRadius,
    insideBoundingBox = searchParamsObject.insideBoundingBox,
    insidePolygon = searchParamsObject.insidePolygon,
    naturalLanguages = searchParamsObject.naturalLanguages,
    ruleContexts = searchParamsObject.ruleContexts,
    personalizationImpact = searchParamsObject.personalizationImpact,
    userToken = searchParamsObject.userToken,
    getRankingInfo = searchParamsObject.getRankingInfo,
    synonyms = searchParamsObject.synonyms,
    clickAnalytics = searchParamsObject.clickAnalytics,
    analytics = searchParamsObject.analytics,
    analyticsTags = searchParamsObject.analyticsTags,
    percentileComputation = searchParamsObject.percentileComputation,
    enableABTest = searchParamsObject.enableABTest,
    attributesToRetrieve = searchParamsObject.attributesToRetrieve,
    ranking = searchParamsObject.ranking,
    customRanking = searchParamsObject.customRanking,
    relevancyStrictness = searchParamsObject.relevancyStrictness,
    attributesToHighlight = searchParamsObject.attributesToHighlight,
    attributesToSnippet = searchParamsObject.attributesToSnippet,
    highlightPreTag = searchParamsObject.highlightPreTag,
    highlightPostTag = searchParamsObject.highlightPostTag,
    snippetEllipsisText = searchParamsObject.snippetEllipsisText,
    restrictHighlightAndSnippetArrays = searchParamsObject.restrictHighlightAndSnippetArrays,
    hitsPerPage = searchParamsObject.hitsPerPage,
    minWordSizefor1Typo = searchParamsObject.minWordSizefor1Typo,
    minWordSizefor2Typos = searchParamsObject.minWordSizefor2Typos,
    typoTolerance = searchParamsObject.typoTolerance,
    allowTyposOnNumericTokens = searchParamsObject.allowTyposOnNumericTokens,
    disableTypoToleranceOnAttributes = searchParamsObject.disableTypoToleranceOnAttributes,
    ignorePlurals = searchParamsObject.ignorePlurals,
    removeStopWords = searchParamsObject.removeStopWords,
    keepDiacriticsOnCharacters = searchParamsObject.keepDiacriticsOnCharacters,
    queryLanguages = searchParamsObject.queryLanguages,
    decompoundQuery = searchParamsObject.decompoundQuery,
    enableRules = searchParamsObject.enableRules,
    enablePersonalization = searchParamsObject.enablePersonalization,
    queryType = searchParamsObject.queryType,
    removeWordsIfNoResults = searchParamsObject.removeWordsIfNoResults,
    mode = searchParamsObject.mode,
    semanticSearch = searchParamsObject.semanticSearch,
    advancedSyntax = searchParamsObject.advancedSyntax,
    optionalWords = searchParamsObject.optionalWords,
    disableExactOnAttributes = searchParamsObject.disableExactOnAttributes,
    exactOnSingleWordQuery = searchParamsObject.exactOnSingleWordQuery,
    alternativesAsExact = searchParamsObject.alternativesAsExact,
    advancedSyntaxFeatures = searchParamsObject.advancedSyntaxFeatures,
    distinct = searchParamsObject.distinct,
    replaceSynonymsInHighlight = searchParamsObject.replaceSynonymsInHighlight,
    minProximity = searchParamsObject.minProximity,
    responseFields = searchParamsObject.responseFields,
    maxFacetHits = searchParamsObject.maxFacetHits,
    maxValuesPerFacet = searchParamsObject.maxValuesPerFacet,
    sortFacetValuesBy = searchParamsObject.sortFacetValuesBy,
    attributeCriteriaComputedByMinProximity = searchParamsObject.attributeCriteriaComputedByMinProximity,
    renderingContent = searchParamsObject.renderingContent,
    enableReRanking = searchParamsObject.enableReRanking,
    reRankingApplyFilter = searchParamsObject.reRankingApplyFilter,
    indexName = indexName,
    type = SearchTypeDefault.Default,
  )
}
