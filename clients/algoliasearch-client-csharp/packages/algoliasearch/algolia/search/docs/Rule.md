# Org.OpenAPITools.Model.Rule
Rule object.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ObjectID** | **string** | Unique identifier for a rule object. | 
**Conditions** | [**List&lt;Condition&gt;**](Condition.md) | [Conditions](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#conditions) required to activate a rule. You can use up to 25 conditions per rule.  | [optional] 
**Consequence** | [**Consequence**](Consequence.md) |  | [optional] 
**Description** | **string** | Description of the rule&#39;s purpose. This can be helpful for display in the Algolia dashboard. | [optional] 
**Enabled** | **bool** | Indicates whether to enable the rule. If it isn&#39;t enabled, it isn&#39;t applied at query time. | [optional] [default to true]
**Validity** | [**List&lt;TimeRange&gt;**](TimeRange.md) | If you specify a validity period, the rule _only_ applies only during that period. If specified, the array must not be empty. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

