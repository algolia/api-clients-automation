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

namespace Algolia.Search.Models.QuerySuggestions;

/// <summary>
/// GetConfigStatus200Response
/// </summary>
public partial class GetConfigStatus200Response
{
  /// <summary>
  /// Initializes a new instance of the GetConfigStatus200Response class.
  /// </summary>
  public GetConfigStatus200Response()
  {
  }

  /// <summary>
  /// Query Suggestions index name.
  /// </summary>
  /// <value>Query Suggestions index name.</value>
  [JsonPropertyName("indexName")]
  public string IndexName { get; set; }

  /// <summary>
  /// Indicates whether the creation or update of the Query Suggestions is in progress.
  /// </summary>
  /// <value>Indicates whether the creation or update of the Query Suggestions is in progress.</value>
  [JsonPropertyName("isRunning")]
  public bool? IsRunning { get; set; }

  /// <summary>
  /// Timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format when the Query Suggestions index was last built.
  /// </summary>
  /// <value>Timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format when the Query Suggestions index was last built.</value>
  [JsonPropertyName("lastBuiltAt")]
  public string LastBuiltAt { get; set; }

  /// <summary>
  /// Timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format when the Query Suggestions index was last updated successfully.
  /// </summary>
  /// <value>Timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format when the Query Suggestions index was last updated successfully.</value>
  [JsonPropertyName("lastSuccessfulBuiltAt")]
  public string LastSuccessfulBuiltAt { get; set; }

  /// <summary>
  /// Duration of the last successful build in seconds.
  /// </summary>
  /// <value>Duration of the last successful build in seconds.</value>
  [JsonPropertyName("lastSuccessfulBuildDuration")]
  public string LastSuccessfulBuildDuration { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class GetConfigStatus200Response {\n");
    sb.Append("  IndexName: ").Append(IndexName).Append("\n");
    sb.Append("  IsRunning: ").Append(IsRunning).Append("\n");
    sb.Append("  LastBuiltAt: ").Append(LastBuiltAt).Append("\n");
    sb.Append("  LastSuccessfulBuiltAt: ").Append(LastSuccessfulBuiltAt).Append("\n");
    sb.Append("  LastSuccessfulBuildDuration: ").Append(LastSuccessfulBuildDuration).Append("\n");
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
    if (obj is not GetConfigStatus200Response input)
    {
      return false;
    }

    return
        (IndexName == input.IndexName || (IndexName != null && IndexName.Equals(input.IndexName))) &&
        (IsRunning == input.IsRunning || IsRunning.Equals(input.IsRunning)) &&
        (LastBuiltAt == input.LastBuiltAt || (LastBuiltAt != null && LastBuiltAt.Equals(input.LastBuiltAt))) &&
        (LastSuccessfulBuiltAt == input.LastSuccessfulBuiltAt || (LastSuccessfulBuiltAt != null && LastSuccessfulBuiltAt.Equals(input.LastSuccessfulBuiltAt))) &&
        (LastSuccessfulBuildDuration == input.LastSuccessfulBuildDuration || (LastSuccessfulBuildDuration != null && LastSuccessfulBuildDuration.Equals(input.LastSuccessfulBuildDuration)));
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
      if (IndexName != null)
      {
        hashCode = (hashCode * 59) + IndexName.GetHashCode();
      }
      hashCode = (hashCode * 59) + IsRunning.GetHashCode();
      if (LastBuiltAt != null)
      {
        hashCode = (hashCode * 59) + LastBuiltAt.GetHashCode();
      }
      if (LastSuccessfulBuiltAt != null)
      {
        hashCode = (hashCode * 59) + LastSuccessfulBuiltAt.GetHashCode();
      }
      if (LastSuccessfulBuildDuration != null)
      {
        hashCode = (hashCode * 59) + LastSuccessfulBuildDuration.GetHashCode();
      }
      return hashCode;
    }
  }

}

