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
    /// BatchDictionaryEntriesRequest
    /// </summary>
    [DataContract(Name = "batchDictionaryEntriesRequest")]
    public partial class BatchDictionaryEntriesRequest : IEquatable<BatchDictionaryEntriesRequest>, IValidatableObject
    {

        /// <summary>
        /// Gets or Sets Action
        /// </summary>
        [DataMember(Name = "action", IsRequired = true, EmitDefaultValue = true)]
        public DictionaryAction Action { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="BatchDictionaryEntriesRequest" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected BatchDictionaryEntriesRequest() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="BatchDictionaryEntriesRequest" /> class.
        /// </summary>
        /// <param name="action">action (required).</param>
        /// <param name="body">body (required).</param>
        public BatchDictionaryEntriesRequest(DictionaryAction action = default(DictionaryAction), DictionaryEntry body = default(DictionaryEntry))
        {
            this.Action = action;
            // to ensure "body" is required (not null)
            if (body == null)
            {
                throw new ArgumentNullException("body is a required property for BatchDictionaryEntriesRequest and cannot be null");
            }
            this.Body = body;
        }

        /// <summary>
        /// Gets or Sets Body
        /// </summary>
        [DataMember(Name = "body", IsRequired = true, EmitDefaultValue = true)]
        public DictionaryEntry Body { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class BatchDictionaryEntriesRequest {\n");
            sb.Append("  Action: ").Append(Action).Append("\n");
            sb.Append("  Body: ").Append(Body).Append("\n");
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
            return this.Equals(input as BatchDictionaryEntriesRequest);
        }

        /// <summary>
        /// Returns true if BatchDictionaryEntriesRequest instances are equal
        /// </summary>
        /// <param name="input">Instance of BatchDictionaryEntriesRequest to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(BatchDictionaryEntriesRequest input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Action == input.Action ||
                    this.Action.Equals(input.Action)
                ) && 
                (
                    this.Body == input.Body ||
                    (this.Body != null &&
                    this.Body.Equals(input.Body))
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
                hashCode = (hashCode * 59) + this.Action.GetHashCode();
                if (this.Body != null)
                {
                    hashCode = (hashCode * 59) + this.Body.GetHashCode();
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
