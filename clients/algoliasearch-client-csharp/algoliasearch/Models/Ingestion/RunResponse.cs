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
/// The response from the run task API, containing an Observability Run ID and the time it was created at.
/// </summary>
public partial class RunResponse
{
  /// <summary>
  /// Initializes a new instance of the RunResponse class.
  /// </summary>
  [JsonConstructor]
  public RunResponse() { }
  /// <summary>
  /// Initializes a new instance of the RunResponse class.
  /// </summary>
  /// <param name="runID">The run UUID. (required).</param>
  /// <param name="createdAt">Date of creation (RFC3339 format). (required).</param>
  public RunResponse(string runID, string createdAt)
  {
    RunID = runID ?? throw new ArgumentNullException(nameof(runID));
    CreatedAt = createdAt ?? throw new ArgumentNullException(nameof(createdAt));
  }

  /// <summary>
  /// The run UUID.
  /// </summary>
  /// <value>The run UUID.</value>
  [JsonPropertyName("runID")]
  public string RunID { get; set; }

  /// <summary>
  /// Date of creation (RFC3339 format).
  /// </summary>
  /// <value>Date of creation (RFC3339 format).</value>
  [JsonPropertyName("createdAt")]
  public string CreatedAt { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class RunResponse {\n");
    sb.Append("  RunID: ").Append(RunID).Append("\n");
    sb.Append("  CreatedAt: ").Append(CreatedAt).Append("\n");
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
    if (obj is not RunResponse input)
    {
      return false;
    }

    return
        (RunID == input.RunID || (RunID != null && RunID.Equals(input.RunID))) &&
        (CreatedAt == input.CreatedAt || (CreatedAt != null && CreatedAt.Equals(input.CreatedAt)));
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
      if (RunID != null)
      {
        hashCode = (hashCode * 59) + RunID.GetHashCode();
      }
      if (CreatedAt != null)
      {
        hashCode = (hashCode * 59) + CreatedAt.GetHashCode();
      }
      return hashCode;
    }
  }

}

