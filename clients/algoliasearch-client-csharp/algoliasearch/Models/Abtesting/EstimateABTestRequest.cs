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

namespace Algolia.Search.Models.Abtesting;

/// <summary>
/// EstimateABTestRequest
/// </summary>
public partial class EstimateABTestRequest
{
  /// <summary>
  /// Initializes a new instance of the EstimateABTestRequest class.
  /// </summary>
  [JsonConstructor]
  public EstimateABTestRequest() { }

  /// <summary>
  /// Initializes a new instance of the EstimateABTestRequest class.
  /// </summary>
  /// <param name="configuration">configuration (required).</param>
  /// <param name="variants">A/B test variants. (required).</param>
  public EstimateABTestRequest(
    EstimateConfiguration configuration,
    List<AddABTestsVariant> variants
  )
  {
    Configuration = configuration ?? throw new ArgumentNullException(nameof(configuration));
    Variants = variants ?? throw new ArgumentNullException(nameof(variants));
  }

  /// <summary>
  /// Gets or Sets Configuration
  /// </summary>
  [JsonPropertyName("configuration")]
  public EstimateConfiguration Configuration { get; set; }

  /// <summary>
  /// A/B test variants.
  /// </summary>
  /// <value>A/B test variants.</value>
  [JsonPropertyName("variants")]
  public List<AddABTestsVariant> Variants { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class EstimateABTestRequest {\n");
    sb.Append("  Configuration: ").Append(Configuration).Append("\n");
    sb.Append("  Variants: ").Append(Variants).Append("\n");
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
    if (obj is not EstimateABTestRequest input)
    {
      return false;
    }

    return (
        Configuration == input.Configuration
        || (Configuration != null && Configuration.Equals(input.Configuration))
      )
      && (
        Variants == input.Variants
        || Variants != null && input.Variants != null && Variants.SequenceEqual(input.Variants)
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
      if (Configuration != null)
      {
        hashCode = (hashCode * 59) + Configuration.GetHashCode();
      }
      if (Variants != null)
      {
        hashCode = (hashCode * 59) + Variants.GetHashCode();
      }
      return hashCode;
    }
  }
}
