# Algolia.search.Model.Consequence
[Consequences](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#consequences) of a rule. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**VarParams** | [**ConsequenceParams**](ConsequenceParams.md) |  | [optional] 
**Promote** | [**List&lt;Promote&gt;**](Promote.md) | Records to promote. | [optional] 
**FilterPromotes** | **bool** | Only use in combination with the &#x60;promote&#x60; consequence. When &#x60;true&#x60;, promoted results will be restricted to match the filters of the current search. When &#x60;false&#x60;, the promoted results will show up regardless of the filters. | [optional] [default to false]
**Hide** | [**List&lt;ConsequenceHide&gt;**](ConsequenceHide.md) | Records to hide. By default, you can hide up to 50 records per rule. | [optional] 
**UserData** | **Object** | Custom JSON object that will be appended to the userData array in the response. This object isn&#39;t interpreted by the API. It&#39;s limited to 1kB of minified JSON. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

