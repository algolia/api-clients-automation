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
    /// LogQuery
    /// </summary>
    [DataContract(Name = "logQuery")]
    public partial class LogQuery : IEquatable<LogQuery>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="LogQuery" /> class.
        /// </summary>
        /// <param name="indexName">Index targeted by the query..</param>
        /// <param name="userToken">User identifier..</param>
        /// <param name="queryId">Unique query identifier..</param>
        public LogQuery(string indexName = default(string), string userToken = default(string), string queryId = default(string))
        {
            this.IndexName = indexName;
            this.UserToken = userToken;
            this.QueryId = queryId;
        }

        /// <summary>
        /// Index targeted by the query.
        /// </summary>
        /// <value>Index targeted by the query.</value>
        /// <example>best_buy</example>
        [DataMember(Name = "index_name", EmitDefaultValue = false)]
        public string IndexName { get; set; }

        /// <summary>
        /// User identifier.
        /// </summary>
        /// <value>User identifier.</value>
        /// <example>93.189.166.128</example>
        [DataMember(Name = "user_token", EmitDefaultValue = false)]
        public string UserToken { get; set; }

        /// <summary>
        /// Unique query identifier.
        /// </summary>
        /// <value>Unique query identifier.</value>
        /// <example>313453231</example>
        [DataMember(Name = "query_id", EmitDefaultValue = false)]
        public string QueryId { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class LogQuery {\n");
            sb.Append("  IndexName: ").Append(IndexName).Append("\n");
            sb.Append("  UserToken: ").Append(UserToken).Append("\n");
            sb.Append("  QueryId: ").Append(QueryId).Append("\n");
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
            return this.Equals(input as LogQuery);
        }

        /// <summary>
        /// Returns true if LogQuery instances are equal
        /// </summary>
        /// <param name="input">Instance of LogQuery to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(LogQuery input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.IndexName == input.IndexName ||
                    (this.IndexName != null &&
                    this.IndexName.Equals(input.IndexName))
                ) && 
                (
                    this.UserToken == input.UserToken ||
                    (this.UserToken != null &&
                    this.UserToken.Equals(input.UserToken))
                ) && 
                (
                    this.QueryId == input.QueryId ||
                    (this.QueryId != null &&
                    this.QueryId.Equals(input.QueryId))
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
                if (this.IndexName != null)
                {
                    hashCode = (hashCode * 59) + this.IndexName.GetHashCode();
                }
                if (this.UserToken != null)
                {
                    hashCode = (hashCode * 59) + this.UserToken.GetHashCode();
                }
                if (this.QueryId != null)
                {
                    hashCode = (hashCode * 59) + this.QueryId.GetHashCode();
                }
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
