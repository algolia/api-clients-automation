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

namespace Algolia.Search.Models.Abtesting;

/// <summary>
/// ListABTestsResponse
/// </summary>
public partial class ListABTestsResponse
{
  /// <summary>
  /// Initializes a new instance of the ListABTestsResponse class.
  /// </summary>
  [JsonConstructor]
  public ListABTestsResponse() { }
  /// <summary>
  /// Initializes a new instance of the ListABTestsResponse class.
  /// </summary>
  /// <param name="abtests">A/B tests. (required).</param>
  /// <param name="count">Number of A/B tests implemented. (required).</param>
  /// <param name="total">Number of retrievable A/B tests. (required).</param>
  public ListABTestsResponse(List<ABTest> abtests, int count, int total)
  {
    Abtests = abtests ?? throw new ArgumentNullException(nameof(abtests));
    Count = count;
    Total = total;
  }

  /// <summary>
  /// A/B tests.
  /// </summary>
  /// <value>A/B tests.</value>
  [JsonPropertyName("abtests")]
  public List<ABTest> Abtests { get; set; }

  /// <summary>
  /// Number of A/B tests implemented.
  /// </summary>
  /// <value>Number of A/B tests implemented.</value>
  [JsonPropertyName("count")]
  public int Count { get; set; }

  /// <summary>
  /// Number of retrievable A/B tests.
  /// </summary>
  /// <value>Number of retrievable A/B tests.</value>
  [JsonPropertyName("total")]
  public int Total { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ListABTestsResponse {\n");
    sb.Append("  Abtests: ").Append(Abtests).Append("\n");
    sb.Append("  Count: ").Append(Count).Append("\n");
    sb.Append("  Total: ").Append(Total).Append("\n");
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
    if (obj is not ListABTestsResponse input)
    {
      return false;
    }

    return
        (Abtests == input.Abtests || Abtests != null && input.Abtests != null && Abtests.SequenceEqual(input.Abtests)) &&
        (Count == input.Count || Count.Equals(input.Count)) &&
        (Total == input.Total || Total.Equals(input.Total));
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
      if (Abtests != null)
      {
        hashCode = (hashCode * 59) + Abtests.GetHashCode();
      }
      hashCode = (hashCode * 59) + Count.GetHashCode();
      hashCode = (hashCode * 59) + Total.GetHashCode();
      return hashCode;
    }
  }

}

