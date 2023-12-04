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
  /// AverageClickEvent
  /// </summary>
  [DataContract(Name = "averageClickEvent")]
  public partial class AverageClickEvent : IEquatable<AverageClickEvent>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="AverageClickEvent" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected AverageClickEvent() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="AverageClickEvent" /> class.
    /// </summary>
    /// <param name="average">Average count of all click events. (required).</param>
    /// <param name="clickCount">Number of click events. (required).</param>
    /// <param name="date">Date of the event in the format YYYY-MM-DD. (required).</param>
    public AverageClickEvent(double average = default(double), int clickCount = default(int), string date = default(string))
    {
      this.Average = average;
      this.ClickCount = clickCount;
      // to ensure "date" is required (not null)
      if (date == null)
      {
        throw new ArgumentNullException("date is a required property for AverageClickEvent and cannot be null");
      }
      this.Date = date;
    }

    /// <summary>
    /// Average count of all click events.
    /// </summary>
    /// <value>Average count of all click events.</value>
    [DataMember(Name = "average", IsRequired = true, EmitDefaultValue = true)]
    public double Average { get; set; }

    /// <summary>
    /// Number of click events.
    /// </summary>
    /// <value>Number of click events.</value>
    [DataMember(Name = "clickCount", IsRequired = true, EmitDefaultValue = true)]
    public int ClickCount { get; set; }

    /// <summary>
    /// Date of the event in the format YYYY-MM-DD.
    /// </summary>
    /// <value>Date of the event in the format YYYY-MM-DD.</value>
    [DataMember(Name = "date", IsRequired = true, EmitDefaultValue = true)]
    public string Date { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class AverageClickEvent {\n");
      sb.Append("  Average: ").Append(Average).Append("\n");
      sb.Append("  ClickCount: ").Append(ClickCount).Append("\n");
      sb.Append("  Date: ").Append(Date).Append("\n");
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
      return this.Equals(input as AverageClickEvent);
    }

    /// <summary>
    /// Returns true if AverageClickEvent instances are equal
    /// </summary>
    /// <param name="input">Instance of AverageClickEvent to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(AverageClickEvent input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Average == input.Average ||
              this.Average.Equals(input.Average)
          ) &&
          (
              this.ClickCount == input.ClickCount ||
              this.ClickCount.Equals(input.ClickCount)
          ) &&
          (
              this.Date == input.Date ||
              (this.Date != null &&
              this.Date.Equals(input.Date))
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
        hashCode = (hashCode * 59) + this.Average.GetHashCode();
        hashCode = (hashCode * 59) + this.ClickCount.GetHashCode();
        if (this.Date != null)
        {
          hashCode = (hashCode * 59) + this.Date.GetHashCode();
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
