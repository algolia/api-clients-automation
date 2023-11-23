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
    /// Request parameters.
    /// </summary>
    [DataContract(Name = "getObjectsParams")]
    public partial class GetObjectsParams : IEquatable<GetObjectsParams>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="GetObjectsParams" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected GetObjectsParams() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="GetObjectsParams" /> class.
        /// </summary>
        /// <param name="requests">requests (required).</param>
        public GetObjectsParams(List<GetObjectsRequest> requests = default(List<GetObjectsRequest>))
        {
            // to ensure "requests" is required (not null)
            if (requests == null)
            {
                throw new ArgumentNullException("requests is a required property for GetObjectsParams and cannot be null");
            }
            this.Requests = requests;
        }

        /// <summary>
        /// Gets or Sets Requests
        /// </summary>
        [DataMember(Name = "requests", IsRequired = true, EmitDefaultValue = true)]
        public List<GetObjectsRequest> Requests { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class GetObjectsParams {\n");
            sb.Append("  Requests: ").Append(Requests).Append("\n");
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
            return this.Equals(input as GetObjectsParams);
        }

        /// <summary>
        /// Returns true if GetObjectsParams instances are equal
        /// </summary>
        /// <param name="input">Instance of GetObjectsParams to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(GetObjectsParams input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Requests == input.Requests ||
                    this.Requests != null &&
                    input.Requests != null &&
                    this.Requests.SequenceEqual(input.Requests)
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
                if (this.Requests != null)
                {
                    hashCode = (hashCode * 59) + this.Requests.GetHashCode();
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
