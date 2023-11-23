# Org.OpenAPITools.Model.Exhaustive
Whether certain properties of the search response are calculated exhaustive (exact) or approximated.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**FacetsCount** | **bool** | Whether the facet count is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). See the [related discussion](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-). | [optional] 
**FacetValues** | **bool** | The value is &#x60;false&#x60; if not all facet values are retrieved. | [optional] 
**NbHits** | **bool** | Whether the &#x60;nbHits&#x60; is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). When the query takes more than 50ms to be processed, the engine makes an approximation. This can happen when using complex filters on millions of records, when typo-tolerance was not exhaustive, or when enough hits have been retrieved (for example, after the engine finds 10,000 exact matches). &#x60;nbHits&#x60; is reported as non-exhaustive whenever an approximation is made, even if the approximation didn’t, in the end, impact the exhaustivity of the query. | [optional] 
**RulesMatch** | **bool** | Rules matching exhaustivity. The value is &#x60;false&#x60; if rules were enable for this query, and could not be fully processed due a timeout. This is generally caused by the number of alternatives (such as typos) which is too large. | [optional] 
**Typo** | **bool** | Whether the typo search was exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). An approximation is done when the typo search query part takes more than 10% of the query budget (ie. 5ms by default) to be processed (this can happen when a lot of typo alternatives exist for the query). This field will not be included when typo-tolerance is entirely disabled. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

