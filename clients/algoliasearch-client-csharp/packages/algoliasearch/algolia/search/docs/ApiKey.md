# Org.OpenAPITools.Model.ApiKey
API key object.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Acl** | [**List&lt;Acl&gt;**](Acl.md) | [Permissions](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl) associated with the key.  | 
**Description** | **string** | Description of an API key for you and your team members. | [optional] [default to ""]
**Indexes** | **List&lt;string&gt;** | Restricts this API key to a list of indices or index patterns. If the list is empty, all indices are allowed. Specify either an exact index name or a pattern with a leading or trailing wildcard character (or both). For example: - &#x60;dev_*&#x60; matches all indices starting with \&quot;dev_\&quot; - &#x60;*_dev&#x60; matches all indices ending with \&quot;_dev\&quot; - &#x60;*_products_*&#x60; matches all indices containing \&quot;_products_\&quot;.  | [optional] 
**MaxHitsPerQuery** | **int** | Maximum number of hits this API key can retrieve in one query. If zero, no limit is enforced. &gt; **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index.  | [optional] [default to 0]
**MaxQueriesPerIPPerHour** | **int** | Maximum number of API calls per hour allowed from a given IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). Each time an API call is performed with this key, a check is performed. If there were more than the specified number of calls within the last hour, the API returns an error with the status code &#x60;429&#x60; (Too Many Requests).  &gt; **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index.  | [optional] [default to 0]
**QueryParameters** | **string** | Force some [query parameters](https://www.algolia.com/doc/api-reference/api-parameters/) to be applied for each query made with this API key. It&#39;s a URL-encoded query string.  | [optional] [default to ""]
**Referers** | **List&lt;string&gt;** | Restrict this API key to specific [referrers](https://www.algolia.com/doc/guides/security/api-keys/in-depth/api-key-restrictions/#http-referrers). If empty, all referrers are allowed. For example: - &#x60;https://algolia.com/_*&#x60; matches all referrers starting with \&quot;https://algolia.com/\&quot; - &#x60;*.algolia.com&#x60; matches all referrers ending with \&quot;.algolia.com\&quot; - &#x60;*algolia.com*&#x60; allows everything in the domain \&quot;algolia.com\&quot;.  | [optional] 
**Validity** | **int** | Validity duration of a key (in seconds).  The key will automatically be removed after this time has expired. The default value of 0 never expires. Short-lived API keys are useful to grant temporary access to your data. For example, in mobile apps, you can&#39;t [control when users update your app](https://www.algolia.com/doc/guides/security/security-best-practices/#use-secured-api-keys-in-mobile-apps). So instead of encoding keys into your app as you would for a web app, you should dynamically fetch them from your mobile app&#39;s backend.  | [optional] [default to 0]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

