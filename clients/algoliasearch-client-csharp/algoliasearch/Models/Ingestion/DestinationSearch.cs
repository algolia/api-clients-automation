//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// API request body for searching destinations.
/// </summary>
public partial class DestinationSearch
{
  /// <summary>
  /// Initializes a new instance of the DestinationSearch class.
  /// </summary>
  [JsonConstructor]
  public DestinationSearch() { }

  /// <summary>
  /// Initializes a new instance of the DestinationSearch class.
  /// </summary>
  /// <param name="destinationIDs">destinationIDs (required).</param>
  public DestinationSearch(List<string> destinationIDs)
  {
    DestinationIDs = destinationIDs ?? throw new ArgumentNullException(nameof(destinationIDs));
  }

  /// <summary>
  /// Gets or Sets DestinationIDs
  /// </summary>
  [JsonPropertyName("destinationIDs")]
  public List<string> DestinationIDs { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class DestinationSearch {\n");
    sb.Append("  DestinationIDs: ").Append(DestinationIDs).Append("\n");
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
    if (obj is not DestinationSearch input)
    {
      return false;
    }

    return (
      DestinationIDs == input.DestinationIDs
      || DestinationIDs != null
        && input.DestinationIDs != null
        && DestinationIDs.SequenceEqual(input.DestinationIDs)
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
      if (DestinationIDs != null)
      {
        hashCode = (hashCode * 59) + DestinationIDs.GetHashCode();
      }
      return hashCode;
    }
  }
}
