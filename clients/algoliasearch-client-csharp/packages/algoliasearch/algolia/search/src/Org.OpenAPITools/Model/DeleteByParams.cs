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
    /// DeleteByParams
    /// </summary>
    [DataContract(Name = "deleteByParams")]
    public partial class DeleteByParams : IEquatable<DeleteByParams>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="DeleteByParams" /> class.
        /// </summary>
        /// <param name="facetFilters">facetFilters.</param>
        /// <param name="filters">[Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters.  (default to &quot;&quot;).</param>
        /// <param name="numericFilters">numericFilters.</param>
        /// <param name="tagFilters">tagFilters.</param>
        /// <param name="aroundLatLng">Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area. (default to &quot;&quot;).</param>
        /// <param name="aroundRadius">aroundRadius.</param>
        /// <param name="insideBoundingBox">Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates)..</param>
        /// <param name="insidePolygon">Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates)..</param>
        public DeleteByParams(FacetFilters facetFilters = default(FacetFilters), string filters = @"", NumericFilters numericFilters = default(NumericFilters), TagFilters tagFilters = default(TagFilters), string aroundLatLng = @"", AroundRadius aroundRadius = default(AroundRadius), List<List<double>> insideBoundingBox = default(List<List<double>>), List<List<double>> insidePolygon = default(List<List<double>>))
        {
            this.FacetFilters = facetFilters;
            // use default value if no "filters" provided
            this.Filters = filters ?? @"";
            this.NumericFilters = numericFilters;
            this.TagFilters = tagFilters;
            // use default value if no "aroundLatLng" provided
            this.AroundLatLng = aroundLatLng ?? @"";
            this.AroundRadius = aroundRadius;
            this.InsideBoundingBox = insideBoundingBox;
            this.InsidePolygon = insidePolygon;
        }

        /// <summary>
        /// Gets or Sets FacetFilters
        /// </summary>
        [DataMember(Name = "facetFilters", EmitDefaultValue = false)]
        public FacetFilters FacetFilters { get; set; }

        /// <summary>
        /// [Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters. 
        /// </summary>
        /// <value>[Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters. </value>
        /// <example>(category:Book OR category:Ebook) AND _tags:published</example>
        [DataMember(Name = "filters", EmitDefaultValue = false)]
        public string Filters { get; set; }

        /// <summary>
        /// Gets or Sets NumericFilters
        /// </summary>
        [DataMember(Name = "numericFilters", EmitDefaultValue = false)]
        public NumericFilters NumericFilters { get; set; }

        /// <summary>
        /// Gets or Sets TagFilters
        /// </summary>
        [DataMember(Name = "tagFilters", EmitDefaultValue = false)]
        public TagFilters TagFilters { get; set; }

        /// <summary>
        /// Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area.
        /// </summary>
        /// <value>Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area.</value>
        /// <example>40.71,-74.01</example>
        [DataMember(Name = "aroundLatLng", EmitDefaultValue = false)]
        public string AroundLatLng { get; set; }

        /// <summary>
        /// Gets or Sets AroundRadius
        /// </summary>
        [DataMember(Name = "aroundRadius", EmitDefaultValue = false)]
        public AroundRadius AroundRadius { get; set; }

        /// <summary>
        /// Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
        /// </summary>
        /// <value>Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).</value>
        /// <example>[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]]</example>
        [DataMember(Name = "insideBoundingBox", EmitDefaultValue = false)]
        public List<List<double>> InsideBoundingBox { get; set; }

        /// <summary>
        /// Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
        /// </summary>
        /// <value>Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).</value>
        /// <example>[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]]</example>
        [DataMember(Name = "insidePolygon", EmitDefaultValue = false)]
        public List<List<double>> InsidePolygon { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class DeleteByParams {\n");
            sb.Append("  FacetFilters: ").Append(FacetFilters).Append("\n");
            sb.Append("  Filters: ").Append(Filters).Append("\n");
            sb.Append("  NumericFilters: ").Append(NumericFilters).Append("\n");
            sb.Append("  TagFilters: ").Append(TagFilters).Append("\n");
            sb.Append("  AroundLatLng: ").Append(AroundLatLng).Append("\n");
            sb.Append("  AroundRadius: ").Append(AroundRadius).Append("\n");
            sb.Append("  InsideBoundingBox: ").Append(InsideBoundingBox).Append("\n");
            sb.Append("  InsidePolygon: ").Append(InsidePolygon).Append("\n");
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
            return this.Equals(input as DeleteByParams);
        }

        /// <summary>
        /// Returns true if DeleteByParams instances are equal
        /// </summary>
        /// <param name="input">Instance of DeleteByParams to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(DeleteByParams input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.FacetFilters == input.FacetFilters ||
                    (this.FacetFilters != null &&
                    this.FacetFilters.Equals(input.FacetFilters))
                ) && 
                (
                    this.Filters == input.Filters ||
                    (this.Filters != null &&
                    this.Filters.Equals(input.Filters))
                ) && 
                (
                    this.NumericFilters == input.NumericFilters ||
                    (this.NumericFilters != null &&
                    this.NumericFilters.Equals(input.NumericFilters))
                ) && 
                (
                    this.TagFilters == input.TagFilters ||
                    (this.TagFilters != null &&
                    this.TagFilters.Equals(input.TagFilters))
                ) && 
                (
                    this.AroundLatLng == input.AroundLatLng ||
                    (this.AroundLatLng != null &&
                    this.AroundLatLng.Equals(input.AroundLatLng))
                ) && 
                (
                    this.AroundRadius == input.AroundRadius ||
                    (this.AroundRadius != null &&
                    this.AroundRadius.Equals(input.AroundRadius))
                ) && 
                (
                    this.InsideBoundingBox == input.InsideBoundingBox ||
                    this.InsideBoundingBox != null &&
                    input.InsideBoundingBox != null &&
                    this.InsideBoundingBox.SequenceEqual(input.InsideBoundingBox)
                ) && 
                (
                    this.InsidePolygon == input.InsidePolygon ||
                    this.InsidePolygon != null &&
                    input.InsidePolygon != null &&
                    this.InsidePolygon.SequenceEqual(input.InsidePolygon)
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
                if (this.FacetFilters != null)
                {
                    hashCode = (hashCode * 59) + this.FacetFilters.GetHashCode();
                }
                if (this.Filters != null)
                {
                    hashCode = (hashCode * 59) + this.Filters.GetHashCode();
                }
                if (this.NumericFilters != null)
                {
                    hashCode = (hashCode * 59) + this.NumericFilters.GetHashCode();
                }
                if (this.TagFilters != null)
                {
                    hashCode = (hashCode * 59) + this.TagFilters.GetHashCode();
                }
                if (this.AroundLatLng != null)
                {
                    hashCode = (hashCode * 59) + this.AroundLatLng.GetHashCode();
                }
                if (this.AroundRadius != null)
                {
                    hashCode = (hashCode * 59) + this.AroundRadius.GetHashCode();
                }
                if (this.InsideBoundingBox != null)
                {
                    hashCode = (hashCode * 59) + this.InsideBoundingBox.GetHashCode();
                }
                if (this.InsidePolygon != null)
                {
                    hashCode = (hashCode * 59) + this.InsidePolygon.GetHashCode();
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
