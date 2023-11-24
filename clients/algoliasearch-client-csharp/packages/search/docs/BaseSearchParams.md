# Algolia.search.Model.BaseSearchParams

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Query** | **string** | Text to search for in an index. | [optional] [default to ""]
**SimilarQuery** | **string** | Overrides the query parameter and performs a more generic search. | [optional] [default to ""]
**Filters** | **string** | [Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters.  | [optional] [default to ""]
**FacetFilters** | [**FacetFilters**](FacetFilters.md) |  | [optional] 
**OptionalFilters** | [**OptionalFilters**](OptionalFilters.md) |  | [optional] 
**NumericFilters** | [**NumericFilters**](NumericFilters.md) |  | [optional] 
**TagFilters** | [**TagFilters**](TagFilters.md) |  | [optional] 
**SumOrFiltersScores** | **bool** | Determines how to calculate [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores). If &#x60;false&#x60;, maximum score is kept. If &#x60;true&#x60;, score is summed.  | [optional] [default to false]
**RestrictSearchableAttributes** | **List&lt;string&gt;** | Restricts a query to only look at a subset of your [searchable attributes](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/). | [optional] 
**Facets** | **List&lt;string&gt;** | Returns [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts), their facet values, and the number of matching facet values. | [optional] 
**FacetingAfterDistinct** | **bool** | Forces faceting to be applied after [de-duplication](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/) (with the distinct feature). Alternatively, the &#x60;afterDistinct&#x60; [modifier](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) of &#x60;attributesForFaceting&#x60; allows for more granular control.  | [optional] [default to false]
**Page** | **int** | Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;). | [optional] [default to 0]
**Offset** | **int** | Specifies the offset of the first hit to return. &gt; **Note**: Using &#x60;page&#x60; and &#x60;hitsPerPage&#x60; is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use &#x60;offset&#x60; and &#x60;length&#x60; to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length).  | [optional] 
**Length** | **int** | Sets the number of hits to retrieve (for use with &#x60;offset&#x60;). &gt; **Note**: Using &#x60;page&#x60; and &#x60;hitsPerPage&#x60; is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use &#x60;offset&#x60; and &#x60;length&#x60; to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length).  | [optional] 
**AroundLatLng** | **string** | Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area. | [optional] [default to ""]
**AroundLatLngViaIP** | **bool** | Search for entries around a location. The location is automatically computed from the requester&#39;s IP address. | [optional] [default to false]
**AroundRadius** | [**AroundRadius**](AroundRadius.md) |  | [optional] 
**AroundPrecision** | [**AroundPrecision**](AroundPrecision.md) |  | [optional] 
**MinimumAroundRadius** | **int** | Minimum radius (in meters) used for a geographical search when &#x60;aroundRadius&#x60; isn&#39;t set. | [optional] 
**InsideBoundingBox** | **List&lt;List&lt;double&gt;&gt;** | Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates). | [optional] 
**InsidePolygon** | **List&lt;List&lt;double&gt;&gt;** | Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates). | [optional] 
**NaturalLanguages** | **List&lt;string&gt;** | Changes the default values of parameters that work best for a natural language query, such as &#x60;ignorePlurals&#x60;, &#x60;removeStopWords&#x60;, &#x60;removeWordsIfNoResults&#x60;, &#x60;analyticsTags&#x60;, and &#x60;ruleContexts&#x60;. These parameters work well together when the query consists of fuller natural language strings instead of keywords, for example when processing voice search queries. | [optional] 
**RuleContexts** | **List&lt;string&gt;** | Assigns [rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) to search queries. | [optional] 
**PersonalizationImpact** | **int** | Defines how much [Personalization affects results](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact). | [optional] [default to 100]
**UserToken** | **string** | Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search. | [optional] 
**GetRankingInfo** | **bool** | Incidates whether the search response includes [detailed ranking information](https://www.algolia.com/doc/guides/building-search-ui/going-further/backend-search/in-depth/understanding-the-api-response/#ranking-information). | [optional] [default to false]
**Explain** | **List&lt;string&gt;** | Enriches the API&#39;s response with information about how the query was processed. | [optional] 
**Synonyms** | **bool** | Whether to take into account an index&#39;s synonyms for a particular search. | [optional] [default to true]
**ClickAnalytics** | **bool** | Indicates whether a query ID parameter is included in the search response. This is required for [tracking click and conversion events](https://www.algolia.com/doc/guides/sending-events/concepts/event-types/#events-related-to-algolia-requests). | [optional] [default to false]
**Analytics** | **bool** | Indicates whether this query will be included in [analytics](https://www.algolia.com/doc/guides/search-analytics/guides/exclude-queries/). | [optional] [default to true]
**AnalyticsTags** | **List&lt;string&gt;** | Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/). | [optional] 
**PercentileComputation** | **bool** | Whether to include or exclude a query from the processing-time percentile computation. | [optional] [default to true]
**EnableABTest** | **bool** | Incidates whether this search will be considered in A/B testing. | [optional] [default to true]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

