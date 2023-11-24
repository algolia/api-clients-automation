# Algolia.search.Model.SearchResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**AbTestID** | **int** | A/B test ID. This is only included in the response for indices that are part of an A/B test. | [optional] 
**AbTestVariantID** | **int** | Variant ID. This is only included in the response for indices that are part of an A/B test. | [optional] 
**AroundLatLng** | **string** | Computed geographical location. | [optional] 
**AutomaticRadius** | **string** | Automatically-computed radius. | [optional] 
**Exhaustive** | [**Exhaustive**](Exhaustive.md) |  | [optional] 
**ExhaustiveFacetsCount** | **bool** | See the &#x60;facetsCount&#x60; field of the &#x60;exhaustive&#x60; object in the response. | [optional] 
**ExhaustiveNbHits** | **bool** | See the &#x60;nbHits&#x60; field of the &#x60;exhaustive&#x60; object in the response. | [optional] 
**ExhaustiveTypo** | **bool** | See the &#x60;typo&#x60; field of the &#x60;exhaustive&#x60; object in the response. | [optional] 
**Facets** | **Dictionary&lt;string, Dictionary&lt;string, int&gt;&gt;** | Mapping of each facet name to the corresponding facet counts. | [optional] 
**FacetsStats** | [**Dictionary&lt;string, FacetsStats&gt;**](FacetsStats.md) | Statistics for numerical facets. | [optional] 
**HitsPerPage** | **int** | Number of hits per page. | [default to 20]
**Index** | **string** | Index name used for the query. | [optional] 
**IndexUsed** | **string** | Index name used for the query. During A/B testing, the targeted index isn&#39;t always the index used by the query. | [optional] 
**Message** | **string** | Warnings about the query. | [optional] 
**NbHits** | **int** | Number of hits the search query matched. | 
**NbPages** | **int** | Number of pages of results for the current query. | 
**NbSortedHits** | **int** | Number of hits selected and sorted by the relevant sort algorithm. | [optional] 
**Page** | **int** | Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;). | [default to 0]
**ParsedQuery** | **string** | Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched. | [optional] 
**ProcessingTimeMS** | **int** | Time the server took to process the request, in milliseconds. | 
**ProcessingTimingsMS** | **Object** | Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues. | [optional] 
**QueryAfterRemoval** | **string** | Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set. | [optional] 
**Redirect** | [**Redirect**](Redirect.md) |  | [optional] 
**RenderingContent** | [**RenderingContent**](RenderingContent.md) |  | [optional] 
**ServerTimeMS** | **int** | Time the server took to process the request, in milliseconds. | [optional] 
**ServerUsed** | **string** | Host name of the server that processed the request. | [optional] 
**UserData** | **Object** | Lets you store custom data in your indices. | [optional] 
**Hits** | [**List&lt;Hit&gt;**](Hit.md) |  | 
**Query** | **string** | Text to search for in an index. | [default to ""]
**VarParams** | **string** | URL-encoded string of all search parameters. | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

