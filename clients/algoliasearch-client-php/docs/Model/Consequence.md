# # Consequence

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**params** | [**\Algolia\AlgoliaSearch\Model\ConsequenceParams**](ConsequenceParams.md) |  | [optional]
**promote** | [**\Algolia\AlgoliaSearch\Model\Promote[]**](Promote.md) | Objects to promote as hits. | [optional]
**filterPromotes** | **bool** | Only use in combination with the promote consequence. When true, promoted results will be restricted to match the filters of the current search. When false, the promoted results will show up regardless of the filters. | [optional] [default to false]
**hide** | [**\Algolia\AlgoliaSearch\Model\ConsequenceHide[]**](ConsequenceHide.md) | Objects to hide from hits. Each object must contain an objectID field. By default, you can hide up to 50 items per rule. | [optional]
**userData** | **array<string,object>** | Custom JSON object that will be appended to the userData array in the response. This object isn&#39;t interpreted by the API. It&#39;s limited to 1kB of minified JSON. | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
