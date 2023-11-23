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
  /// TimeRange
  /// </summary>
  [DataContract(Name = "timeRange")]
  public partial class TimeRange : IEquatable<TimeRange>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="TimeRange" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected TimeRange() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="TimeRange" /> class.
    /// </summary>
    /// <param name="from">Lower bound of the time range (Unix timestamp). (required).</param>
    /// <param name="until">Upper bound of the time range (Unix timestamp). (required).</param>
    public TimeRange(int from = default(int), int until = default(int))
    {
      this.From = from;
      this.Until = until;
    }

    /// <summary>
    /// Lower bound of the time range (Unix timestamp).
    /// </summary>
    /// <value>Lower bound of the time range (Unix timestamp).</value>
    [DataMember(Name = "from", IsRequired = true, EmitDefaultValue = true)]
    public int From { get; set; }

    /// <summary>
    /// Upper bound of the time range (Unix timestamp).
    /// </summary>
    /// <value>Upper bound of the time range (Unix timestamp).</value>
    [DataMember(Name = "until", IsRequired = true, EmitDefaultValue = true)]
    public int Until { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class TimeRange {\n");
      sb.Append("  From: ").Append(From).Append("\n");
      sb.Append("  Until: ").Append(Until).Append("\n");
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
      return this.Equals(input as TimeRange);
    }

    /// <summary>
    /// Returns true if TimeRange instances are equal
    /// </summary>
    /// <param name="input">Instance of TimeRange to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(TimeRange input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.From == input.From ||
              this.From.Equals(input.From)
          ) &&
          (
              this.Until == input.Until ||
              this.Until.Equals(input.Until)
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
        hashCode = (hashCode * 59) + this.From.GetHashCode();
        hashCode = (hashCode * 59) + this.Until.GetHashCode();
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
