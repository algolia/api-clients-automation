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
    /// SearchForFacetValuesResponse
    /// </summary>
    [DataContract(Name = "searchForFacetValuesResponse")]
    public partial class SearchForFacetValuesResponse : IEquatable<SearchForFacetValuesResponse>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SearchForFacetValuesResponse" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected SearchForFacetValuesResponse() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="SearchForFacetValuesResponse" /> class.
        /// </summary>
        /// <param name="facetHits">facetHits (required).</param>
        public SearchForFacetValuesResponse(List<FacetHits> facetHits = default(List<FacetHits>))
        {
            // to ensure "facetHits" is required (not null)
            if (facetHits == null)
            {
                throw new ArgumentNullException("facetHits is a required property for SearchForFacetValuesResponse and cannot be null");
            }
            this.FacetHits = facetHits;
        }

        /// <summary>
        /// Gets or Sets FacetHits
        /// </summary>
        [DataMember(Name = "facetHits", IsRequired = true, EmitDefaultValue = true)]
        public List<FacetHits> FacetHits { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class SearchForFacetValuesResponse {\n");
            sb.Append("  FacetHits: ").Append(FacetHits).Append("\n");
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
            return this.Equals(input as SearchForFacetValuesResponse);
        }

        /// <summary>
        /// Returns true if SearchForFacetValuesResponse instances are equal
        /// </summary>
        /// <param name="input">Instance of SearchForFacetValuesResponse to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(SearchForFacetValuesResponse input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.FacetHits == input.FacetHits ||
                    this.FacetHits != null &&
                    input.FacetHits != null &&
                    this.FacetHits.SequenceEqual(input.FacetHits)
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
                if (this.FacetHits != null)
                {
                    hashCode = (hashCode * 59) + this.FacetHits.GetHashCode();
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
