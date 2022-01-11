# # BaseSearchParams

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**similarQuery** | **string** | Overrides the query parameter and performs a more generic search that can be used to find \&quot;similar\&quot; results. | [optional] [default to '']
**filters** | **string** | Filter the query with numeric, facet and/or tag filters. | [optional] [default to '']
**facetFilters** | **string[]** | Filter hits by facet value. | [optional]
**optionalFilters** | **string[]** | Create filters for ranking purposes, where records that match the filter are ranked higher, or lower in the case of a negative optional filter. | [optional]
**numericFilters** | **string[]** | Filter on numeric attributes. | [optional]
**tagFilters** | **string[]** | Filter hits by tags. | [optional]
**sumOrFiltersScores** | **bool** | Determines how to calculate the total score for filtering. | [optional] [default to false]
**facets** | **string[]** | Retrieve facets and their facet values. | [optional]
**maxValuesPerFacet** | **int** | Maximum number of facet values to return for each facet during a regular search. | [optional] [default to 100]
**facetingAfterDistinct** | **bool** | Force faceting to be applied after de-duplication (via the Distinct setting). | [optional] [default to false]
**sortFacetValuesBy** | **string** | Controls how facet values are fetched. | [optional] [default to 'count']
**page** | **int** | Specify the page to retrieve. | [optional] [default to 0]
**offset** | **int** | Specify the offset of the first hit to return. | [optional]
**length** | **int** | Set the number of hits to retrieve (used only with offset). | [optional]
**aroundLatLng** | **string** | Search for entries around a central geolocation, enabling a geo search within a circular area. | [optional] [default to '']
**aroundLatLngViaIP** | **bool** | Search for entries around a given location automatically computed from the requester&#39;s IP address. | [optional] [default to false]
**aroundRadius** | [**OneOfIntegerString**](OneOfIntegerString.md) | Define the maximum radius for a geo search (in meters). | [optional]
**aroundPrecision** | **int** | Precision of geo search (in meters), to add grouping by geo location to the ranking formula. | [optional] [default to 10]
**minimumAroundRadius** | **int** | Minimum radius (in meters) used for a geo search when aroundRadius is not set. | [optional]
**insideBoundingBox** | **float[]** | Search inside a rectangular area (in geo coordinates). | [optional]
**insidePolygon** | **float[]** | Search inside a polygon (in geo coordinates). | [optional]
**naturalLanguages** | **string[]** | This parameter changes the default values of certain parameters and settings that work best for a natural language query, such as ignorePlurals, removeStopWords, removeWordsIfNoResults, analyticsTags and ruleContexts. These parameters and settings work well together when the query is formatted in natural language instead of keywords, for example when your user performs a voice search. | [optional]
**ruleContexts** | **string[]** | Enables contextual rules. | [optional]
**personalizationImpact** | **int** | Define the impact of the Personalization feature. | [optional] [default to 100]
**userToken** | **string** | Associates a certain user token with the current search. | [optional]
**getRankingInfo** | **bool** | Retrieve detailed ranking information. | [optional] [default to false]
**clickAnalytics** | **bool** | Enable the Click Analytics feature. | [optional] [default to false]
**analytics** | **bool** | Whether the current query will be taken into account in the Analytics. | [optional] [default to true]
**analyticsTags** | **string[]** | List of tags to apply to the query for analytics purposes. | [optional]
**percentileComputation** | **bool** | Whether to include or exclude a query from the processing-time percentile computation. | [optional] [default to true]
**enableABTest** | **bool** | Whether this search should participate in running AB tests. | [optional] [default to true]
**enableReRanking** | **bool** | Whether this search should use AI Re-Ranking. | [optional] [default to true]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
