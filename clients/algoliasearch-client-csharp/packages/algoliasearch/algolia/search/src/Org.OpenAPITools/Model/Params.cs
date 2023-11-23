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
    /// Additional search parameters.
    /// </summary>
    [DataContract(Name = "varParams")]
    public partial class Params : IEquatable<Params>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Params" /> class.
        /// </summary>
        /// <param name="query">query.</param>
        /// <param name="automaticFacetFilters">automaticFacetFilters.</param>
        /// <param name="automaticOptionalFacetFilters">automaticOptionalFacetFilters.</param>
        /// <param name="renderingContent">renderingContent.</param>
        public Params(ConsequenceQuery query = default(ConsequenceQuery), AutomaticFacetFilters automaticFacetFilters = default(AutomaticFacetFilters), AutomaticFacetFilters automaticOptionalFacetFilters = default(AutomaticFacetFilters), RenderingContent renderingContent = default(RenderingContent))
        {
            this.Query = query;
            this.AutomaticFacetFilters = automaticFacetFilters;
            this.AutomaticOptionalFacetFilters = automaticOptionalFacetFilters;
            this.RenderingContent = renderingContent;
        }

        /// <summary>
        /// Gets or Sets Query
        /// </summary>
        [DataMember(Name = "query", EmitDefaultValue = false)]
        public ConsequenceQuery Query { get; set; }

        /// <summary>
        /// Gets or Sets AutomaticFacetFilters
        /// </summary>
        [DataMember(Name = "automaticFacetFilters", EmitDefaultValue = false)]
        public AutomaticFacetFilters AutomaticFacetFilters { get; set; }

        /// <summary>
        /// Gets or Sets AutomaticOptionalFacetFilters
        /// </summary>
        [DataMember(Name = "automaticOptionalFacetFilters", EmitDefaultValue = false)]
        public AutomaticFacetFilters AutomaticOptionalFacetFilters { get; set; }

        /// <summary>
        /// Gets or Sets RenderingContent
        /// </summary>
        [DataMember(Name = "renderingContent", EmitDefaultValue = false)]
        public RenderingContent RenderingContent { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Params {\n");
            sb.Append("  Query: ").Append(Query).Append("\n");
            sb.Append("  AutomaticFacetFilters: ").Append(AutomaticFacetFilters).Append("\n");
            sb.Append("  AutomaticOptionalFacetFilters: ").Append(AutomaticOptionalFacetFilters).Append("\n");
            sb.Append("  RenderingContent: ").Append(RenderingContent).Append("\n");
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
            return this.Equals(input as Params);
        }

        /// <summary>
        /// Returns true if Params instances are equal
        /// </summary>
        /// <param name="input">Instance of Params to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Params input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Query == input.Query ||
                    (this.Query != null &&
                    this.Query.Equals(input.Query))
                ) && 
                (
                    this.AutomaticFacetFilters == input.AutomaticFacetFilters ||
                    (this.AutomaticFacetFilters != null &&
                    this.AutomaticFacetFilters.Equals(input.AutomaticFacetFilters))
                ) && 
                (
                    this.AutomaticOptionalFacetFilters == input.AutomaticOptionalFacetFilters ||
                    (this.AutomaticOptionalFacetFilters != null &&
                    this.AutomaticOptionalFacetFilters.Equals(input.AutomaticOptionalFacetFilters))
                ) && 
                (
                    this.RenderingContent == input.RenderingContent ||
                    (this.RenderingContent != null &&
                    this.RenderingContent.Equals(input.RenderingContent))
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
                if (this.Query != null)
                {
                    hashCode = (hashCode * 59) + this.Query.GetHashCode();
                }
                if (this.AutomaticFacetFilters != null)
                {
                    hashCode = (hashCode * 59) + this.AutomaticFacetFilters.GetHashCode();
                }
                if (this.AutomaticOptionalFacetFilters != null)
                {
                    hashCode = (hashCode * 59) + this.AutomaticOptionalFacetFilters.GetHashCode();
                }
                if (this.RenderingContent != null)
                {
                    hashCode = (hashCode * 59) + this.RenderingContent.GetHashCode();
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
