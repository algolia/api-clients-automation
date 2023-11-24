# Algolia.search.Model.RankingInfo

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Filters** | **int** | This field is reserved for advanced usage. | 
**FirstMatchedWord** | **int** | Position of the most important matched attribute in the attributes to index list. | 
**GeoDistance** | **int** | Distance between the geo location in the search query and the best matching geo location in the record, divided by the geo precision (in meters). | 
**GeoPrecision** | **int** | Precision used when computing the geo distance, in meters. | [optional] 
**MatchedGeoLocation** | [**MatchedGeoLocation**](MatchedGeoLocation.md) |  | [optional] 
**Personalization** | [**Personalization**](Personalization.md) |  | [optional] 
**NbExactWords** | **int** | Number of exactly matched words. | 
**NbTypos** | **int** | Number of typos encountered when matching the record. | 
**Promoted** | **bool** | Present and set to true if a Rule promoted the hit. | 
**ProximityDistance** | **int** | When the query contains more than one word, the sum of the distances between matched words (in meters). | [optional] 
**UserScore** | **int** | Custom ranking for the object, expressed as a single integer value. | 
**Words** | **int** | Number of matched words, including prefixes and typos. | 
**PromotedByReRanking** | **bool** | Wether the record are promoted by the re-ranking strategy. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

