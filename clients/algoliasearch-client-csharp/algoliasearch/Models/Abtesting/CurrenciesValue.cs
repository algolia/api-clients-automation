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
/// CurrenciesValue
/// </summary>
public partial class CurrenciesValue
{
  /// <summary>
  /// Initializes a new instance of the CurrenciesValue class.
  /// </summary>
  public CurrenciesValue()
  {
  }

  /// <summary>
  /// Currency code.
  /// </summary>
  /// <value>Currency code.</value>
  [JsonPropertyName("currency")]
  public string Currency { get; set; }

  /// <summary>
  /// Revenue for this currency.
  /// </summary>
  /// <value>Revenue for this currency.</value>
  [JsonPropertyName("revenue")]
  public double? Revenue { get; set; }

  /// <summary>
  /// Mean for this currency.
  /// </summary>
  /// <value>Mean for this currency.</value>
  [JsonPropertyName("mean")]
  public double? Mean { get; set; }

  /// <summary>
  /// Standard deviation for this currency.
  /// </summary>
  /// <value>Standard deviation for this currency.</value>
  [JsonPropertyName("standardDeviation")]
  public double? StandardDeviation { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class CurrenciesValue {\n");
    sb.Append("  Currency: ").Append(Currency).Append("\n");
    sb.Append("  Revenue: ").Append(Revenue).Append("\n");
    sb.Append("  Mean: ").Append(Mean).Append("\n");
    sb.Append("  StandardDeviation: ").Append(StandardDeviation).Append("\n");
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
    if (obj is not CurrenciesValue input)
    {
      return false;
    }

    return
        (Currency == input.Currency || (Currency != null && Currency.Equals(input.Currency))) &&
        (Revenue == input.Revenue || Revenue.Equals(input.Revenue)) &&
        (Mean == input.Mean || Mean.Equals(input.Mean)) &&
        (StandardDeviation == input.StandardDeviation || StandardDeviation.Equals(input.StandardDeviation));
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
      if (Currency != null)
      {
        hashCode = (hashCode * 59) + Currency.GetHashCode();
      }
      hashCode = (hashCode * 59) + Revenue.GetHashCode();
      hashCode = (hashCode * 59) + Mean.GetHashCode();
      hashCode = (hashCode * 59) + StandardDeviation.GetHashCode();
      return hashCode;
    }
  }

}

