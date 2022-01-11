# # RankingInfo

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | **int** | This field is reserved for advanced usage. | [optional]
**firstMatchedWord** | **int** | Position of the most important matched attribute in the attributes to index list. | [optional]
**geoDistance** | **int** | Distance between the geo location in the search query and the best matching geo location in the record, divided by the geo precision (in meters). | [optional]
**geoPrecision** | **int** | Precision used when computing the geo distance, in meters. | [optional]
**matchedGeoLocation** | [**array<string,\Algolia\AlgoliaSearch\Model\RankingInfoMatchedGeoLocation>**](RankingInfoMatchedGeoLocation.md) |  | [optional]
**nbExactWords** | **int** | Number of exactly matched words. | [optional]
**nbTypos** | **int** | Number of typos encountered when matching the record. | [optional]
**promoted** | **bool** | Present and set to true if a Rule promoted the hit. | [optional]
**proximityDistance** | **int** | When the query contains more than one word, the sum of the distances between matched words (in meters). | [optional]
**userScore** | **int** | Custom ranking for the object, expressed as a single integer value. | [optional]
**word** | **int** | Number of matched words, including prefixes and typos. | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
