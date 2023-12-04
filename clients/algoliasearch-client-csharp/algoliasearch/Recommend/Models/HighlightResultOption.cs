//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//

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
using FileParameter = Algolia.Search.Recommend.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Recommend.Client.OpenAPIDateConverter;

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// Show highlighted section and words matched on a query.
  /// </summary>
  [DataContract(Name = "highlightResultOption")]
  public partial class HighlightResultOption : IEquatable<HighlightResultOption>, IValidatableObject
  {

    /// <summary>
    /// Gets or Sets MatchLevel
    /// </summary>
    [DataMember(Name = "matchLevel", IsRequired = true, EmitDefaultValue = true)]
    public MatchLevel MatchLevel { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="HighlightResultOption" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected HighlightResultOption() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="HighlightResultOption" /> class.
    /// </summary>
    /// <param name="value">Markup text with &#x60;facetQuery&#x60; matches highlighted. (required).</param>
    /// <param name="matchLevel">matchLevel (required).</param>
    /// <param name="matchedWords">List of words from the query that matched the object. (required).</param>
    /// <param name="fullyHighlighted">Whether the entire attribute value is highlighted..</param>
    public HighlightResultOption(string value = default(string), MatchLevel matchLevel = default(MatchLevel), List<string> matchedWords = default(List<string>), bool fullyHighlighted = default(bool))
    {
      // to ensure "value" is required (not null)
      if (value == null)
      {
        throw new ArgumentNullException("value is a required property for HighlightResultOption and cannot be null");
      }
      this.Value = value;
      this.MatchLevel = matchLevel;
      // to ensure "matchedWords" is required (not null)
      if (matchedWords == null)
      {
        throw new ArgumentNullException("matchedWords is a required property for HighlightResultOption and cannot be null");
      }
      this.MatchedWords = matchedWords;
      this.FullyHighlighted = fullyHighlighted;
    }

    /// <summary>
    /// Markup text with &#x60;facetQuery&#x60; matches highlighted.
    /// </summary>
    /// <value>Markup text with &#x60;facetQuery&#x60; matches highlighted.</value>
    [DataMember(Name = "value", IsRequired = true, EmitDefaultValue = true)]
    public string Value { get; set; }

    /// <summary>
    /// List of words from the query that matched the object.
    /// </summary>
    /// <value>List of words from the query that matched the object.</value>
    [DataMember(Name = "matchedWords", IsRequired = true, EmitDefaultValue = true)]
    public List<string> MatchedWords { get; set; }

    /// <summary>
    /// Whether the entire attribute value is highlighted.
    /// </summary>
    /// <value>Whether the entire attribute value is highlighted.</value>
    [DataMember(Name = "fullyHighlighted", EmitDefaultValue = true)]
    public bool FullyHighlighted { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class HighlightResultOption {\n");
      sb.Append("  Value: ").Append(Value).Append("\n");
      sb.Append("  MatchLevel: ").Append(MatchLevel).Append("\n");
      sb.Append("  MatchedWords: ").Append(MatchedWords).Append("\n");
      sb.Append("  FullyHighlighted: ").Append(FullyHighlighted).Append("\n");
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
      return this.Equals(input as HighlightResultOption);
    }

    /// <summary>
    /// Returns true if HighlightResultOption instances are equal
    /// </summary>
    /// <param name="input">Instance of HighlightResultOption to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(HighlightResultOption input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Value == input.Value ||
              (this.Value != null &&
              this.Value.Equals(input.Value))
          ) &&
          (
              this.MatchLevel == input.MatchLevel ||
              this.MatchLevel.Equals(input.MatchLevel)
          ) &&
          (
              this.MatchedWords == input.MatchedWords ||
              this.MatchedWords != null &&
              input.MatchedWords != null &&
              this.MatchedWords.SequenceEqual(input.MatchedWords)
          ) &&
          (
              this.FullyHighlighted == input.FullyHighlighted ||
              this.FullyHighlighted.Equals(input.FullyHighlighted)
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
        if (this.Value != null)
        {
          hashCode = (hashCode * 59) + this.Value.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.MatchLevel.GetHashCode();
        if (this.MatchedWords != null)
        {
          hashCode = (hashCode * 59) + this.MatchedWords.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.FullyHighlighted.GetHashCode();
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
