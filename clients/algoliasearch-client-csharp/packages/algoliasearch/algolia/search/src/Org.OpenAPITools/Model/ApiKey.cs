/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using System.ComponentModel.DataAnnotations;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
    /// <summary>
    /// API key object.
    /// </summary>
    [DataContract(Name = "apiKey")]
    public partial class ApiKey : IEquatable<ApiKey>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="ApiKey" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected ApiKey() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="ApiKey" /> class.
        /// </summary>
        /// <param name="acl">[Permissions](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl) associated with the key.  (required).</param>
        /// <param name="description">Description of an API key for you and your team members. (default to &quot;&quot;).</param>
        /// <param name="indexes">Restricts this API key to a list of indices or index patterns. If the list is empty, all indices are allowed. Specify either an exact index name or a pattern with a leading or trailing wildcard character (or both). For example: - &#x60;dev_*&#x60; matches all indices starting with \&quot;dev_\&quot; - &#x60;*_dev&#x60; matches all indices ending with \&quot;_dev\&quot; - &#x60;*_products_*&#x60; matches all indices containing \&quot;_products_\&quot;. .</param>
        /// <param name="maxHitsPerQuery">Maximum number of hits this API key can retrieve in one query. If zero, no limit is enforced. &gt; **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index.  (default to 0).</param>
        /// <param name="maxQueriesPerIPPerHour">Maximum number of API calls per hour allowed from a given IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). Each time an API call is performed with this key, a check is performed. If there were more than the specified number of calls within the last hour, the API returns an error with the status code &#x60;429&#x60; (Too Many Requests).  &gt; **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index.  (default to 0).</param>
        /// <param name="queryParameters">Force some [query parameters](https://www.algolia.com/doc/api-reference/api-parameters/) to be applied for each query made with this API key. It&#39;s a URL-encoded query string.  (default to &quot;&quot;).</param>
        /// <param name="referers">Restrict this API key to specific [referrers](https://www.algolia.com/doc/guides/security/api-keys/in-depth/api-key-restrictions/#http-referrers). If empty, all referrers are allowed. For example: - &#x60;https://algolia.com/_*&#x60; matches all referrers starting with \&quot;https://algolia.com/\&quot; - &#x60;*.algolia.com&#x60; matches all referrers ending with \&quot;.algolia.com\&quot; - &#x60;*algolia.com*&#x60; allows everything in the domain \&quot;algolia.com\&quot;. .</param>
        /// <param name="validity">Validity duration of a key (in seconds).  The key will automatically be removed after this time has expired. The default value of 0 never expires. Short-lived API keys are useful to grant temporary access to your data. For example, in mobile apps, you can&#39;t [control when users update your app](https://www.algolia.com/doc/guides/security/security-best-practices/#use-secured-api-keys-in-mobile-apps). So instead of encoding keys into your app as you would for a web app, you should dynamically fetch them from your mobile app&#39;s backend.  (default to 0).</param>
        public ApiKey(List<Acl> acl = default(List<Acl>), string description = @"", List<string> indexes = default(List<string>), int maxHitsPerQuery = 0, int maxQueriesPerIPPerHour = 0, string queryParameters = @"", List<string> referers = default(List<string>), int validity = 0)
        {
            // to ensure "acl" is required (not null)
            if (acl == null)
            {
                throw new ArgumentNullException("acl is a required property for ApiKey and cannot be null");
            }
            this.Acl = acl;
            // use default value if no "description" provided
            this.Description = description ?? @"";
            this.Indexes = indexes;
            this.MaxHitsPerQuery = maxHitsPerQuery;
            this.MaxQueriesPerIPPerHour = maxQueriesPerIPPerHour;
            // use default value if no "queryParameters" provided
            this.QueryParameters = queryParameters ?? @"";
            this.Referers = referers;
            this.Validity = validity;
        }

        /// <summary>
        /// [Permissions](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl) associated with the key. 
        /// </summary>
        /// <value>[Permissions](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl) associated with the key. </value>
        /// <example>[&quot;search&quot;,&quot;addObject&quot;]</example>
        [DataMember(Name = "acl", IsRequired = true, EmitDefaultValue = true)]
        public List<Acl> Acl { get; set; }

        /// <summary>
        /// Description of an API key for you and your team members.
        /// </summary>
        /// <value>Description of an API key for you and your team members.</value>
        /// <example>Browse-restricted key</example>
        [DataMember(Name = "description", EmitDefaultValue = false)]
        public string Description { get; set; }

        /// <summary>
        /// Restricts this API key to a list of indices or index patterns. If the list is empty, all indices are allowed. Specify either an exact index name or a pattern with a leading or trailing wildcard character (or both). For example: - &#x60;dev_*&#x60; matches all indices starting with \&quot;dev_\&quot; - &#x60;*_dev&#x60; matches all indices ending with \&quot;_dev\&quot; - &#x60;*_products_*&#x60; matches all indices containing \&quot;_products_\&quot;. 
        /// </summary>
        /// <value>Restricts this API key to a list of indices or index patterns. If the list is empty, all indices are allowed. Specify either an exact index name or a pattern with a leading or trailing wildcard character (or both). For example: - &#x60;dev_*&#x60; matches all indices starting with \&quot;dev_\&quot; - &#x60;*_dev&#x60; matches all indices ending with \&quot;_dev\&quot; - &#x60;*_products_*&#x60; matches all indices containing \&quot;_products_\&quot;. </value>
        /// <example>[&quot;dev_*&quot;,&quot;prod_products&quot;]</example>
        [DataMember(Name = "indexes", EmitDefaultValue = false)]
        public List<string> Indexes { get; set; }

        /// <summary>
        /// Maximum number of hits this API key can retrieve in one query. If zero, no limit is enforced. &gt; **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index. 
        /// </summary>
        /// <value>Maximum number of hits this API key can retrieve in one query. If zero, no limit is enforced. &gt; **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index. </value>
        [DataMember(Name = "maxHitsPerQuery", EmitDefaultValue = false)]
        public int MaxHitsPerQuery { get; set; }

        /// <summary>
        /// Maximum number of API calls per hour allowed from a given IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). Each time an API call is performed with this key, a check is performed. If there were more than the specified number of calls within the last hour, the API returns an error with the status code &#x60;429&#x60; (Too Many Requests).  &gt; **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index. 
        /// </summary>
        /// <value>Maximum number of API calls per hour allowed from a given IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). Each time an API call is performed with this key, a check is performed. If there were more than the specified number of calls within the last hour, the API returns an error with the status code &#x60;429&#x60; (Too Many Requests).  &gt; **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index. </value>
        [DataMember(Name = "maxQueriesPerIPPerHour", EmitDefaultValue = false)]
        public int MaxQueriesPerIPPerHour { get; set; }

        /// <summary>
        /// Force some [query parameters](https://www.algolia.com/doc/api-reference/api-parameters/) to be applied for each query made with this API key. It&#39;s a URL-encoded query string. 
        /// </summary>
        /// <value>Force some [query parameters](https://www.algolia.com/doc/api-reference/api-parameters/) to be applied for each query made with this API key. It&#39;s a URL-encoded query string. </value>
        /// <example>typoTolerance%3Dstrict%26ignorePlurals%3Dfalse%26filters%3Drights%3Apublic</example>
        [DataMember(Name = "queryParameters", EmitDefaultValue = false)]
        public string QueryParameters { get; set; }

        /// <summary>
        /// Restrict this API key to specific [referrers](https://www.algolia.com/doc/guides/security/api-keys/in-depth/api-key-restrictions/#http-referrers). If empty, all referrers are allowed. For example: - &#x60;https://algolia.com/_*&#x60; matches all referrers starting with \&quot;https://algolia.com/\&quot; - &#x60;*.algolia.com&#x60; matches all referrers ending with \&quot;.algolia.com\&quot; - &#x60;*algolia.com*&#x60; allows everything in the domain \&quot;algolia.com\&quot;. 
        /// </summary>
        /// <value>Restrict this API key to specific [referrers](https://www.algolia.com/doc/guides/security/api-keys/in-depth/api-key-restrictions/#http-referrers). If empty, all referrers are allowed. For example: - &#x60;https://algolia.com/_*&#x60; matches all referrers starting with \&quot;https://algolia.com/\&quot; - &#x60;*.algolia.com&#x60; matches all referrers ending with \&quot;.algolia.com\&quot; - &#x60;*algolia.com*&#x60; allows everything in the domain \&quot;algolia.com\&quot;. </value>
        /// <example>[&quot;*algolia.com*&quot;]</example>
        [DataMember(Name = "referers", EmitDefaultValue = false)]
        public List<string> Referers { get; set; }

        /// <summary>
        /// Validity duration of a key (in seconds).  The key will automatically be removed after this time has expired. The default value of 0 never expires. Short-lived API keys are useful to grant temporary access to your data. For example, in mobile apps, you can&#39;t [control when users update your app](https://www.algolia.com/doc/guides/security/security-best-practices/#use-secured-api-keys-in-mobile-apps). So instead of encoding keys into your app as you would for a web app, you should dynamically fetch them from your mobile app&#39;s backend. 
        /// </summary>
        /// <value>Validity duration of a key (in seconds).  The key will automatically be removed after this time has expired. The default value of 0 never expires. Short-lived API keys are useful to grant temporary access to your data. For example, in mobile apps, you can&#39;t [control when users update your app](https://www.algolia.com/doc/guides/security/security-best-practices/#use-secured-api-keys-in-mobile-apps). So instead of encoding keys into your app as you would for a web app, you should dynamically fetch them from your mobile app&#39;s backend. </value>
        /// <example>86400</example>
        [DataMember(Name = "validity", EmitDefaultValue = false)]
        public int Validity { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class ApiKey {\n");
            sb.Append("  Acl: ").Append(Acl).Append("\n");
            sb.Append("  Description: ").Append(Description).Append("\n");
            sb.Append("  Indexes: ").Append(Indexes).Append("\n");
            sb.Append("  MaxHitsPerQuery: ").Append(MaxHitsPerQuery).Append("\n");
            sb.Append("  MaxQueriesPerIPPerHour: ").Append(MaxQueriesPerIPPerHour).Append("\n");
            sb.Append("  QueryParameters: ").Append(QueryParameters).Append("\n");
            sb.Append("  Referers: ").Append(Referers).Append("\n");
            sb.Append("  Validity: ").Append(Validity).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }

        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public virtual string ToJson()
        {
            return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="input">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object input)
        {
            return this.Equals(input as ApiKey);
        }

        /// <summary>
        /// Returns true if ApiKey instances are equal
        /// </summary>
        /// <param name="input">Instance of ApiKey to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(ApiKey input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Acl == input.Acl ||
                    this.Acl != null &&
                    input.Acl != null &&
                    this.Acl.SequenceEqual(input.Acl)
                ) && 
                (
                    this.Description == input.Description ||
                    (this.Description != null &&
                    this.Description.Equals(input.Description))
                ) && 
                (
                    this.Indexes == input.Indexes ||
                    this.Indexes != null &&
                    input.Indexes != null &&
                    this.Indexes.SequenceEqual(input.Indexes)
                ) && 
                (
                    this.MaxHitsPerQuery == input.MaxHitsPerQuery ||
                    this.MaxHitsPerQuery.Equals(input.MaxHitsPerQuery)
                ) && 
                (
                    this.MaxQueriesPerIPPerHour == input.MaxQueriesPerIPPerHour ||
                    this.MaxQueriesPerIPPerHour.Equals(input.MaxQueriesPerIPPerHour)
                ) && 
                (
                    this.QueryParameters == input.QueryParameters ||
                    (this.QueryParameters != null &&
                    this.QueryParameters.Equals(input.QueryParameters))
                ) && 
                (
                    this.Referers == input.Referers ||
                    this.Referers != null &&
                    input.Referers != null &&
                    this.Referers.SequenceEqual(input.Referers)
                ) && 
                (
                    this.Validity == input.Validity ||
                    this.Validity.Equals(input.Validity)
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            unchecked // Overflow is fine, just wrap
            {
                int hashCode = 41;
                if (this.Acl != null)
                {
                    hashCode = (hashCode * 59) + this.Acl.GetHashCode();
                }
                if (this.Description != null)
                {
                    hashCode = (hashCode * 59) + this.Description.GetHashCode();
                }
                if (this.Indexes != null)
                {
                    hashCode = (hashCode * 59) + this.Indexes.GetHashCode();
                }
                hashCode = (hashCode * 59) + this.MaxHitsPerQuery.GetHashCode();
                hashCode = (hashCode * 59) + this.MaxQueriesPerIPPerHour.GetHashCode();
                if (this.QueryParameters != null)
                {
                    hashCode = (hashCode * 59) + this.QueryParameters.GetHashCode();
                }
                if (this.Referers != null)
                {
                    hashCode = (hashCode * 59) + this.Referers.GetHashCode();
                }
                hashCode = (hashCode * 59) + this.Validity.GetHashCode();
                return hashCode;
            }
        }

        /// <summary>
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            yield break;
        }
    }

}
