# # BrowseResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**abTestID** | **int** | If a search encounters an index that is being A/B tested, abTestID reports the ongoing A/B test ID. | [optional]
**abTestVariantID** | **int** | If a search encounters an index that is being A/B tested, abTestVariantID reports the variant ID of the index used. | [optional]
**aroundLatLng** | **string** | The computed geo location. | [optional]
**automaticRadius** | **string** | The automatically computed radius. For legacy reasons, this parameter is a string and not an integer. | [optional]
**exhaustiveFacetsCount** | **bool** | Whether the facet count is exhaustive or approximate. | [optional]
**exhaustiveNbHits** | **bool** | Indicate if the nbHits count was exhaustive or approximate |
**exhaustiveTypo** | **bool** | Indicate if the typo-tolerence search was exhaustive or approximate (only included when typo-tolerance is enabled) |
**facets** | **array<string,array<string,string>>** | A mapping of each facet name to the corresponding facet counts. | [optional]
**facetsStats** | [**array<string,\Algolia\AlgoliaSearch\Model\BaseSearchResponseFacetsStats>**](BaseSearchResponseFacetsStats.md) | Statistics for numerical facets. | [optional]
**hitsPerPage** | **int** | Set the number of hits per page. | [default to 20]
**index** | **string** | Index name used for the query. | [optional]
**indexUsed** | **string** | Index name used for the query. In the case of an A/B test, the targeted index isn&#39;t always the index used by the query. | [optional]
**message** | **string** | Used to return warnings about the query. | [optional]
**nbHits** | **int** | Number of hits that the search query matched. |
**nbPages** | **int** | Number of pages available for the current query |
**nbSortedHits** | **int** | The number of hits selected and sorted by the relevant sort algorithm | [optional]
**page** | **int** | Specify the page to retrieve. | [default to 0]
**params** | **string** | A url-encoded string of all search parameters. |
**parsedQuery** | **string** | The query string that will be searched, after normalization. | [optional]
**processingTimeMS** | **int** | Time the server took to process the request, in milliseconds. |
**query** | **string** | The text to search in the index. | [default to '']
**queryAfterRemoval** | **string** | A markup text indicating which parts of the original query have been removed in order to retrieve a non-empty result set. | [optional]
**serverUsed** | **string** | Actual host name of the server that processed the request. | [optional]
**userData** | **array<string,object>** | Lets you store custom data in your indices. | [optional]
**hits** | [**\Algolia\AlgoliaSearch\Model\Record[]**](Record.md) |  |
**cursor** | **string** | Cursor indicating the location to resume browsing from. Must match the value returned by the previous call. |

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
