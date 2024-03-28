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
/// Input for a `streaming` task whose source is of type `ga4BigqueryExport` and for which extracted data is continuously streamed.
/// </summary>
public partial class StreamingUtilsInput
{
  /// <summary>
  /// Initializes a new instance of the StreamingUtilsInput class.
  /// </summary>
  [JsonConstructor]
  public StreamingUtilsInput() { }
  /// <summary>
  /// Initializes a new instance of the StreamingUtilsInput class.
  /// </summary>
  /// <param name="mapping">mapping (required).</param>
  public StreamingUtilsInput(MappingInput mapping)
  {
    Mapping = mapping ?? throw new ArgumentNullException(nameof(mapping));
  }

  /// <summary>
  /// Gets or Sets Mapping
  /// </summary>
  [JsonPropertyName("mapping")]
  public MappingInput Mapping { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class StreamingUtilsInput {\n");
    sb.Append("  Mapping: ").Append(Mapping).Append("\n");
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
    if (obj is not StreamingUtilsInput input)
    {
      return false;
    }

    return
        (Mapping == input.Mapping || (Mapping != null && Mapping.Equals(input.Mapping)));
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
      if (Mapping != null)
      {
        hashCode = (hashCode * 59) + Mapping.GetHashCode();
      }
      return hashCode;
    }
  }

}

