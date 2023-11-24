# Algolia.search.Model.DeleteByParams

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**FacetFilters** | [**FacetFilters**](FacetFilters.md) |  | [optional] 
**Filters** | **string** | [Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters.  | [optional] [default to ""]
**NumericFilters** | [**NumericFilters**](NumericFilters.md) |  | [optional] 
**TagFilters** | [**TagFilters**](TagFilters.md) |  | [optional] 
**AroundLatLng** | **string** | Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area. | [optional] [default to ""]
**AroundRadius** | [**AroundRadius**](AroundRadius.md) |  | [optional] 
**InsideBoundingBox** | **List&lt;List&lt;double&gt;&gt;** | Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates). | [optional] 
**InsidePolygon** | **List&lt;List&lt;double&gt;&gt;** | Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates). | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

