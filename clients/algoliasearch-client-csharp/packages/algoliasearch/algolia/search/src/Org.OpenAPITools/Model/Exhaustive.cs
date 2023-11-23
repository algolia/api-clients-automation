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
    /// Whether certain properties of the search response are calculated exhaustive (exact) or approximated.
    /// </summary>
    [DataContract(Name = "exhaustive")]
    public partial class Exhaustive : IEquatable<Exhaustive>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Exhaustive" /> class.
        /// </summary>
        /// <param name="facetsCount">Whether the facet count is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). See the [related discussion](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-)..</param>
        /// <param name="facetValues">The value is &#x60;false&#x60; if not all facet values are retrieved..</param>
        /// <param name="nbHits">Whether the &#x60;nbHits&#x60; is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). When the query takes more than 50ms to be processed, the engine makes an approximation. This can happen when using complex filters on millions of records, when typo-tolerance was not exhaustive, or when enough hits have been retrieved (for example, after the engine finds 10,000 exact matches). &#x60;nbHits&#x60; is reported as non-exhaustive whenever an approximation is made, even if the approximation didn’t, in the end, impact the exhaustivity of the query..</param>
        /// <param name="rulesMatch">Rules matching exhaustivity. The value is &#x60;false&#x60; if rules were enable for this query, and could not be fully processed due a timeout. This is generally caused by the number of alternatives (such as typos) which is too large..</param>
        /// <param name="typo">Whether the typo search was exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). An approximation is done when the typo search query part takes more than 10% of the query budget (ie. 5ms by default) to be processed (this can happen when a lot of typo alternatives exist for the query). This field will not be included when typo-tolerance is entirely disabled..</param>
        public Exhaustive(bool facetsCount = default(bool), bool facetValues = default(bool), bool nbHits = default(bool), bool rulesMatch = default(bool), bool typo = default(bool))
        {
            this.FacetsCount = facetsCount;
            this.FacetValues = facetValues;
            this.NbHits = nbHits;
            this.RulesMatch = rulesMatch;
            this.Typo = typo;
        }

        /// <summary>
        /// Whether the facet count is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). See the [related discussion](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).
        /// </summary>
        /// <value>Whether the facet count is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). See the [related discussion](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).</value>
        [DataMember(Name = "facetsCount", EmitDefaultValue = true)]
        public bool FacetsCount { get; set; }

        /// <summary>
        /// The value is &#x60;false&#x60; if not all facet values are retrieved.
        /// </summary>
        /// <value>The value is &#x60;false&#x60; if not all facet values are retrieved.</value>
        [DataMember(Name = "facetValues", EmitDefaultValue = true)]
        public bool FacetValues { get; set; }

        /// <summary>
        /// Whether the &#x60;nbHits&#x60; is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). When the query takes more than 50ms to be processed, the engine makes an approximation. This can happen when using complex filters on millions of records, when typo-tolerance was not exhaustive, or when enough hits have been retrieved (for example, after the engine finds 10,000 exact matches). &#x60;nbHits&#x60; is reported as non-exhaustive whenever an approximation is made, even if the approximation didn’t, in the end, impact the exhaustivity of the query.
        /// </summary>
        /// <value>Whether the &#x60;nbHits&#x60; is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). When the query takes more than 50ms to be processed, the engine makes an approximation. This can happen when using complex filters on millions of records, when typo-tolerance was not exhaustive, or when enough hits have been retrieved (for example, after the engine finds 10,000 exact matches). &#x60;nbHits&#x60; is reported as non-exhaustive whenever an approximation is made, even if the approximation didn’t, in the end, impact the exhaustivity of the query.</value>
        [DataMember(Name = "nbHits", EmitDefaultValue = true)]
        public bool NbHits { get; set; }

        /// <summary>
        /// Rules matching exhaustivity. The value is &#x60;false&#x60; if rules were enable for this query, and could not be fully processed due a timeout. This is generally caused by the number of alternatives (such as typos) which is too large.
        /// </summary>
        /// <value>Rules matching exhaustivity. The value is &#x60;false&#x60; if rules were enable for this query, and could not be fully processed due a timeout. This is generally caused by the number of alternatives (such as typos) which is too large.</value>
        [DataMember(Name = "rulesMatch", EmitDefaultValue = true)]
        public bool RulesMatch { get; set; }

        /// <summary>
        /// Whether the typo search was exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). An approximation is done when the typo search query part takes more than 10% of the query budget (ie. 5ms by default) to be processed (this can happen when a lot of typo alternatives exist for the query). This field will not be included when typo-tolerance is entirely disabled.
        /// </summary>
        /// <value>Whether the typo search was exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). An approximation is done when the typo search query part takes more than 10% of the query budget (ie. 5ms by default) to be processed (this can happen when a lot of typo alternatives exist for the query). This field will not be included when typo-tolerance is entirely disabled.</value>
        [DataMember(Name = "typo", EmitDefaultValue = true)]
        public bool Typo { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Exhaustive {\n");
            sb.Append("  FacetsCount: ").Append(FacetsCount).Append("\n");
            sb.Append("  FacetValues: ").Append(FacetValues).Append("\n");
            sb.Append("  NbHits: ").Append(NbHits).Append("\n");
            sb.Append("  RulesMatch: ").Append(RulesMatch).Append("\n");
            sb.Append("  Typo: ").Append(Typo).Append("\n");
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
            return this.Equals(input as Exhaustive);
        }

        /// <summary>
        /// Returns true if Exhaustive instances are equal
        /// </summary>
        /// <param name="input">Instance of Exhaustive to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Exhaustive input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.FacetsCount == input.FacetsCount ||
                    this.FacetsCount.Equals(input.FacetsCount)
                ) && 
                (
                    this.FacetValues == input.FacetValues ||
                    this.FacetValues.Equals(input.FacetValues)
                ) && 
                (
                    this.NbHits == input.NbHits ||
                    this.NbHits.Equals(input.NbHits)
                ) && 
                (
                    this.RulesMatch == input.RulesMatch ||
                    this.RulesMatch.Equals(input.RulesMatch)
                ) && 
                (
                    this.Typo == input.Typo ||
                    this.Typo.Equals(input.Typo)
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
                hashCode = (hashCode * 59) + this.FacetsCount.GetHashCode();
                hashCode = (hashCode * 59) + this.FacetValues.GetHashCode();
                hashCode = (hashCode * 59) + this.NbHits.GetHashCode();
                hashCode = (hashCode * 59) + this.RulesMatch.GetHashCode();
                hashCode = (hashCode * 59) + this.Typo.GetHashCode();
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
