# # Rule

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**objectID** | **string** | Unique identifier of the object. |
**conditions** | [**\Algolia\AlgoliaSearch\Model\Condition[]**](Condition.md) | A list of conditions that should apply to activate a Rule. You can use up to 25 conditions per Rule. | [optional]
**consequence** | [**\Algolia\AlgoliaSearch\Model\Consequence**](Consequence.md) |  |
**description** | **string** | This field is intended for Rule management purposes, in particular to ease searching for Rules and presenting them to human readers. It&#39;s not interpreted by the API. | [optional]
**enabled** | **bool** | Whether the Rule is enabled. Disabled Rules remain in the index, but aren&#39;t applied at query time. | [optional] [default to true]
**validity** | [**\Algolia\AlgoliaSearch\Model\TimeRange[]**](TimeRange.md) | By default, Rules are permanently valid. When validity periods are specified, the Rule applies only during those periods; it&#39;s ignored the rest of the time. The list must not be empty. | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
