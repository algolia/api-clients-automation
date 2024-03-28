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

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// Trigger information for manually-triggered tasks.
/// </summary>
public partial class OnDemandTrigger
{

  /// <summary>
  /// Gets or Sets Type
  /// </summary>
  [JsonPropertyName("type")]
  public OnDemandTriggerType? Type { get; set; }
  /// <summary>
  /// Initializes a new instance of the OnDemandTrigger class.
  /// </summary>
  [JsonConstructor]
  public OnDemandTrigger() { }
  /// <summary>
  /// Initializes a new instance of the OnDemandTrigger class.
  /// </summary>
  /// <param name="type">type (required).</param>
  public OnDemandTrigger(OnDemandTriggerType? type)
  {
    Type = type;
  }

  /// <summary>
  /// The last time the scheduled task ran in RFC3339 format.
  /// </summary>
  /// <value>The last time the scheduled task ran in RFC3339 format.</value>
  [JsonPropertyName("lastRun")]
  public string LastRun { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class OnDemandTrigger {\n");
    sb.Append("  Type: ").Append(Type).Append("\n");
    sb.Append("  LastRun: ").Append(LastRun).Append("\n");
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
    if (obj is not OnDemandTrigger input)
    {
      return false;
    }

    return
        (Type == input.Type || Type.Equals(input.Type)) &&
        (LastRun == input.LastRun || (LastRun != null && LastRun.Equals(input.LastRun)));
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
      hashCode = (hashCode * 59) + Type.GetHashCode();
      if (LastRun != null)
      {
        hashCode = (hashCode * 59) + LastRun.GetHashCode();
      }
      return hashCode;
    }
  }

}

