# # ApiKey

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**acl** | **string[]** | Set of permissions associated with the key. |
**description** | **string** | A comment used to identify a key more easily in the dashboard. It is not interpreted by the API. | [optional] [default to '']
**indexes** | **string[]** | Restrict this new API key to a list of indices or index patterns. If the list is empty, all indices are allowed. | [optional]
**maxHitsPerQuery** | **int** | Maximum number of hits this API key can retrieve in one query. If zero, no limit is enforced. | [optional] [default to 0]
**maxQueriesPerIPPerHour** | **int** | Maximum number of API calls per hour allowed from a given IP address or a user token. | [optional] [default to 0]
**queryParameters** | **string** | URL-encoded query string. Force some query parameters to be applied for each query made with this API key. | [optional] [default to '']
**referers** | **string[]** | Restrict this new API key to specific referers. If empty or blank, defaults to all referers. | [optional]
**validity** | **int** | Validity limit for this key in seconds. The key will automatically be removed after this period of time. | [optional] [default to 0]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
