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
/// EstimateABTestResponse
/// </summary>
public partial class EstimateABTestResponse
{
  /// <summary>
  /// Initializes a new instance of the EstimateABTestResponse class.
  /// </summary>
  public EstimateABTestResponse()
  {
  }

  /// <summary>
  /// Estimated number of days needed to reach the sample sizes required for detecting the configured effect. This value is based on historical traffic.
  /// </summary>
  /// <value>Estimated number of days needed to reach the sample sizes required for detecting the configured effect. This value is based on historical traffic.</value>
  [JsonPropertyName("durationDays")]
  public long? DurationDays { get; set; }

  /// <summary>
  /// Number of tracked searches needed to be able to detect the configured effect for the control variant.
  /// </summary>
  /// <value>Number of tracked searches needed to be able to detect the configured effect for the control variant.</value>
  [JsonPropertyName("controlSampleSize")]
  public long? ControlSampleSize { get; set; }

  /// <summary>
  /// Number of tracked searches needed to be able to detect the configured effect for the experiment variant.
  /// </summary>
  /// <value>Number of tracked searches needed to be able to detect the configured effect for the experiment variant.</value>
  [JsonPropertyName("experimentSampleSize")]
  public long? ExperimentSampleSize { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class EstimateABTestResponse {\n");
    sb.Append("  DurationDays: ").Append(DurationDays).Append("\n");
    sb.Append("  ControlSampleSize: ").Append(ControlSampleSize).Append("\n");
    sb.Append("  ExperimentSampleSize: ").Append(ExperimentSampleSize).Append("\n");
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
    if (obj is not EstimateABTestResponse input)
    {
      return false;
    }

    return
        (DurationDays == input.DurationDays || DurationDays.Equals(input.DurationDays)) &&
        (ControlSampleSize == input.ControlSampleSize || ControlSampleSize.Equals(input.ControlSampleSize)) &&
        (ExperimentSampleSize == input.ExperimentSampleSize || ExperimentSampleSize.Equals(input.ExperimentSampleSize));
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
      hashCode = (hashCode * 59) + DurationDays.GetHashCode();
      hashCode = (hashCode * 59) + ControlSampleSize.GetHashCode();
      hashCode = (hashCode * 59) + ExperimentSampleSize.GetHashCode();
      return hashCode;
    }
  }

}

