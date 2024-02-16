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
/// GetSearchesNoClicksResponse
/// </summary>
public partial class GetSearchesNoClicksResponse
{
  /// <summary>
  /// Initializes a new instance of the GetSearchesNoClicksResponse class.
  /// </summary>
  [JsonConstructor]
  public GetSearchesNoClicksResponse() { }
  /// <summary>
  /// Initializes a new instance of the GetSearchesNoClicksResponse class.
  /// </summary>
  /// <param name="searches">Searches with no clicks. (required).</param>
  public GetSearchesNoClicksResponse(List<SearchNoClickEvent> searches)
  {
    Searches = searches ?? throw new ArgumentNullException(nameof(searches));
  }

  /// <summary>
  /// Searches with no clicks.
  /// </summary>
  /// <value>Searches with no clicks.</value>
  [JsonPropertyName("searches")]
  public List<SearchNoClickEvent> Searches { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class GetSearchesNoClicksResponse {\n");
    sb.Append("  Searches: ").Append(Searches).Append("\n");
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
    if (obj is not GetSearchesNoClicksResponse input)
    {
      return false;
    }

    return
        (Searches == input.Searches || Searches != null && input.Searches != null && Searches.SequenceEqual(input.Searches));
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
      if (Searches != null)
      {
        hashCode = (hashCode * 59) + Searches.GetHashCode();
      }
      return hashCode;
    }
  }

}

