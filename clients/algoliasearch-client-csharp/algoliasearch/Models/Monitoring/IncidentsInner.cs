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

namespace Algolia.Search.Models.Monitoring;

/// <summary>
/// IncidentsInner
/// </summary>
public partial class IncidentsInner
{
  /// <summary>
  /// Initializes a new instance of the IncidentsInner class.
  /// </summary>
  public IncidentsInner()
  {
  }

  /// <summary>
  /// Timestamp in [Unix epoch time](https://wikipedia.org/wiki/Unix_time) in milliseconds.
  /// </summary>
  /// <value>Timestamp in [Unix epoch time](https://wikipedia.org/wiki/Unix_time) in milliseconds.</value>
  [JsonPropertyName("t")]
  public long? T { get; set; }

  /// <summary>
  /// Gets or Sets V
  /// </summary>
  [JsonPropertyName("v")]
  public Incident V { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class IncidentsInner {\n");
    sb.Append("  T: ").Append(T).Append("\n");
    sb.Append("  V: ").Append(V).Append("\n");
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
    if (obj is not IncidentsInner input)
    {
      return false;
    }

    return
        (T == input.T || T.Equals(input.T)) &&
        (V == input.V || (V != null && V.Equals(input.V)));
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
      hashCode = (hashCode * 59) + T.GetHashCode();
      if (V != null)
      {
        hashCode = (hashCode * 59) + V.GetHashCode();
      }
      return hashCode;
    }
  }

}

