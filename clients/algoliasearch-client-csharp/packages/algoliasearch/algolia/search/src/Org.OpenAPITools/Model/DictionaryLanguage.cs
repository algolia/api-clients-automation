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
    /// Custom entries for a dictionary.
    /// </summary>
    [DataContract(Name = "dictionaryLanguage")]
    public partial class DictionaryLanguage : IEquatable<DictionaryLanguage>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="DictionaryLanguage" /> class.
        /// </summary>
        /// <param name="nbCustomEntries">If &#x60;0&#x60;, the dictionary hasn&#39;t been customized and only contains standard entries provided by Algolia. If &#x60;null&#x60;, that feature isn&#39;t available or isn&#39;t supported for that language. .</param>
        public DictionaryLanguage(int nbCustomEntries = default(int))
        {
            this.NbCustomEntries = nbCustomEntries;
        }

        /// <summary>
        /// If &#x60;0&#x60;, the dictionary hasn&#39;t been customized and only contains standard entries provided by Algolia. If &#x60;null&#x60;, that feature isn&#39;t available or isn&#39;t supported for that language. 
        /// </summary>
        /// <value>If &#x60;0&#x60;, the dictionary hasn&#39;t been customized and only contains standard entries provided by Algolia. If &#x60;null&#x60;, that feature isn&#39;t available or isn&#39;t supported for that language. </value>
        [DataMember(Name = "nbCustomEntries", EmitDefaultValue = false)]
        public int NbCustomEntries { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class DictionaryLanguage {\n");
            sb.Append("  NbCustomEntries: ").Append(NbCustomEntries).Append("\n");
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
            return this.Equals(input as DictionaryLanguage);
        }

        /// <summary>
        /// Returns true if DictionaryLanguage instances are equal
        /// </summary>
        /// <param name="input">Instance of DictionaryLanguage to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(DictionaryLanguage input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.NbCustomEntries == input.NbCustomEntries ||
                    this.NbCustomEntries.Equals(input.NbCustomEntries)
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
                hashCode = (hashCode * 59) + this.NbCustomEntries.GetHashCode();
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
