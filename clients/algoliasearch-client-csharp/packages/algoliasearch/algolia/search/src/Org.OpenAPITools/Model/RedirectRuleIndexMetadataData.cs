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
  /// Redirect rule data.
  /// </summary>
  [DataContract(Name = "RedirectRuleIndexMetadata_data")]
  public partial class RedirectRuleIndexMetadataData : IEquatable<RedirectRuleIndexMetadataData>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="RedirectRuleIndexMetadataData" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected RedirectRuleIndexMetadataData() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="RedirectRuleIndexMetadataData" /> class.
    /// </summary>
    /// <param name="ruleObjectID">ruleObjectID (required).</param>
    public RedirectRuleIndexMetadataData(string ruleObjectID = default(string))
    {
      // to ensure "ruleObjectID" is required (not null)
      if (ruleObjectID == null)
      {
        throw new ArgumentNullException("ruleObjectID is a required property for RedirectRuleIndexMetadataData and cannot be null");
      }
      this.RuleObjectID = ruleObjectID;
    }

    /// <summary>
    /// Gets or Sets RuleObjectID
    /// </summary>
    [DataMember(Name = "ruleObjectID", IsRequired = true, EmitDefaultValue = true)]
    public string RuleObjectID { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class RedirectRuleIndexMetadataData {\n");
      sb.Append("  RuleObjectID: ").Append(RuleObjectID).Append("\n");
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
      return this.Equals(input as RedirectRuleIndexMetadataData);
    }

    /// <summary>
    /// Returns true if RedirectRuleIndexMetadataData instances are equal
    /// </summary>
    /// <param name="input">Instance of RedirectRuleIndexMetadataData to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(RedirectRuleIndexMetadataData input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.RuleObjectID == input.RuleObjectID ||
              (this.RuleObjectID != null &&
              this.RuleObjectID.Equals(input.RuleObjectID))
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
        if (this.RuleObjectID != null)
        {
          hashCode = (hashCode * 59) + this.RuleObjectID.GetHashCode();
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
