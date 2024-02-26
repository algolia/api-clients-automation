//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Text;
using System.Linq;
using System.Text.Json.Serialization;
using System.Collections.Generic;
using Algolia.Search.Serializer;
using System.Text.Json;

namespace Algolia.Search.Models.Analytics;

/// <summary>
/// UserWithDate
/// </summary>
public partial class UserWithDate
{
  /// <summary>
  /// Initializes a new instance of the UserWithDate class.
  /// </summary>
  [JsonConstructor]
  public UserWithDate() { }
  /// <summary>
  /// Initializes a new instance of the UserWithDate class.
  /// </summary>
  /// <param name="date">Date of the event in the format YYYY-MM-DD. (required).</param>
  /// <param name="count">Number of occurrences. (required).</param>
  public UserWithDate(string date, int count)
  {
    Date = date ?? throw new ArgumentNullException(nameof(date));
    Count = count;
  }

  /// <summary>
  /// Date of the event in the format YYYY-MM-DD.
  /// </summary>
  /// <value>Date of the event in the format YYYY-MM-DD.</value>
  [JsonPropertyName("date")]
  public string Date { get; set; }

  /// <summary>
  /// Number of occurrences.
  /// </summary>
  /// <value>Number of occurrences.</value>
  [JsonPropertyName("count")]
  public int Count { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class UserWithDate {\n");
    sb.Append("  Date: ").Append(Date).Append("\n");
    sb.Append("  Count: ").Append(Count).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonSerializer.Serialize(this, JsonConfig.Options);
  }

  /// <summary>
  /// Returns true if objects are equal
  /// </summary>
  /// <param name="obj">Object to be compared</param>
  /// <returns>Boolean</returns>
  public override bool Equals(object obj)
  {
    if (obj is not UserWithDate input)
    {
      return false;
    }

    return
        (Date == input.Date || (Date != null && Date.Equals(input.Date))) &&
        (Count == input.Count || Count.Equals(input.Count));
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
      if (Date != null)
      {
        hashCode = (hashCode * 59) + Date.GetHashCode();
      }
      hashCode = (hashCode * 59) + Count.GetHashCode();
      return hashCode;
    }
  }

}

