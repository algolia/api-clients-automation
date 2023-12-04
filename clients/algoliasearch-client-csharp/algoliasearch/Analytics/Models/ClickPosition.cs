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
using FileParameter = Algolia.Search.Analytics.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Analytics.Client.OpenAPIDateConverter;

namespace Algolia.Search.Analytics.Models
{
  /// <summary>
  /// ClickPosition
  /// </summary>
  [DataContract(Name = "clickPosition")]
  public partial class ClickPosition : IEquatable<ClickPosition>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="ClickPosition" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected ClickPosition() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="ClickPosition" /> class.
    /// </summary>
    /// <param name="position">Range of positions with the following pattern: - For positions 1 to 10, the number of click events are shown for each position - For positions 11 to 20, all click events are grouped - For positions 21 and up, all click events are grouped.  (required).</param>
    /// <param name="clickCount">Number of click events. (required).</param>
    public ClickPosition(List<int> position = default(List<int>), int clickCount = default(int))
    {
      // to ensure "position" is required (not null)
      if (position == null)
      {
        throw new ArgumentNullException("position is a required property for ClickPosition and cannot be null");
      }
      this.Position = position;
      this.ClickCount = clickCount;
    }

    /// <summary>
    /// Range of positions with the following pattern: - For positions 1 to 10, the number of click events are shown for each position - For positions 11 to 20, all click events are grouped - For positions 21 and up, all click events are grouped. 
    /// </summary>
    /// <value>Range of positions with the following pattern: - For positions 1 to 10, the number of click events are shown for each position - For positions 11 to 20, all click events are grouped - For positions 21 and up, all click events are grouped. </value>
    [DataMember(Name = "position", IsRequired = true, EmitDefaultValue = true)]
    public List<int> Position { get; set; }

    /// <summary>
    /// Number of click events.
    /// </summary>
    /// <value>Number of click events.</value>
    [DataMember(Name = "clickCount", IsRequired = true, EmitDefaultValue = true)]
    public int ClickCount { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class ClickPosition {\n");
      sb.Append("  Position: ").Append(Position).Append("\n");
      sb.Append("  ClickCount: ").Append(ClickCount).Append("\n");
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
      return this.Equals(input as ClickPosition);
    }

    /// <summary>
    /// Returns true if ClickPosition instances are equal
    /// </summary>
    /// <param name="input">Instance of ClickPosition to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(ClickPosition input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Position == input.Position ||
              this.Position != null &&
              input.Position != null &&
              this.Position.SequenceEqual(input.Position)
          ) &&
          (
              this.ClickCount == input.ClickCount ||
              this.ClickCount.Equals(input.ClickCount)
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
        if (this.Position != null)
        {
          hashCode = (hashCode * 59) + this.Position.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.ClickCount.GetHashCode();
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
