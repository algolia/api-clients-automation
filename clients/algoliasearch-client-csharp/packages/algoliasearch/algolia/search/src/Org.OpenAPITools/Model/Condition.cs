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
    /// Condition
    /// </summary>
    [DataContract(Name = "condition")]
    public partial class Condition : IEquatable<Condition>, IValidatableObject
    {

        /// <summary>
        /// Gets or Sets Anchoring
        /// </summary>
        [DataMember(Name = "anchoring", EmitDefaultValue = false)]
        public Anchoring? Anchoring { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="Condition" /> class.
        /// </summary>
        /// <param name="pattern">Query pattern syntax..</param>
        /// <param name="anchoring">anchoring.</param>
        /// <param name="alternatives">Whether the pattern matches on plurals, synonyms, and typos. (default to false).</param>
        /// <param name="context">Rule context format: [A-Za-z0-9_-]+)..</param>
        public Condition(string pattern = default(string), Anchoring? anchoring = default(Anchoring?), bool alternatives = false, string context = default(string))
        {
            this.Pattern = pattern;
            this.Anchoring = anchoring;
            this.Alternatives = alternatives;
            this.Context = context;
        }

        /// <summary>
        /// Query pattern syntax.
        /// </summary>
        /// <value>Query pattern syntax.</value>
        /// <example>{facet:brand}</example>
        [DataMember(Name = "pattern", EmitDefaultValue = false)]
        public string Pattern { get; set; }

        /// <summary>
        /// Whether the pattern matches on plurals, synonyms, and typos.
        /// </summary>
        /// <value>Whether the pattern matches on plurals, synonyms, and typos.</value>
        [DataMember(Name = "alternatives", EmitDefaultValue = true)]
        public bool Alternatives { get; set; }

        /// <summary>
        /// Rule context format: [A-Za-z0-9_-]+).
        /// </summary>
        /// <value>Rule context format: [A-Za-z0-9_-]+).</value>
        /// <example>trackedFilters</example>
        [DataMember(Name = "context", EmitDefaultValue = false)]
        public string Context { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Condition {\n");
            sb.Append("  Pattern: ").Append(Pattern).Append("\n");
            sb.Append("  Anchoring: ").Append(Anchoring).Append("\n");
            sb.Append("  Alternatives: ").Append(Alternatives).Append("\n");
            sb.Append("  Context: ").Append(Context).Append("\n");
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
            return this.Equals(input as Condition);
        }

        /// <summary>
        /// Returns true if Condition instances are equal
        /// </summary>
        /// <param name="input">Instance of Condition to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Condition input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Pattern == input.Pattern ||
                    (this.Pattern != null &&
                    this.Pattern.Equals(input.Pattern))
                ) && 
                (
                    this.Anchoring == input.Anchoring ||
                    this.Anchoring.Equals(input.Anchoring)
                ) && 
                (
                    this.Alternatives == input.Alternatives ||
                    this.Alternatives.Equals(input.Alternatives)
                ) && 
                (
                    this.Context == input.Context ||
                    (this.Context != null &&
                    this.Context.Equals(input.Context))
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
                if (this.Pattern != null)
                {
                    hashCode = (hashCode * 59) + this.Pattern.GetHashCode();
                }
                hashCode = (hashCode * 59) + this.Anchoring.GetHashCode();
                hashCode = (hashCode * 59) + this.Alternatives.GetHashCode();
                if (this.Context != null)
                {
                    hashCode = (hashCode * 59) + this.Context.GetHashCode();
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
