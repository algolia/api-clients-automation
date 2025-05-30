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

namespace Algolia.Search.Models.QuerySuggestions;

/// <summary>
/// API response for retrieving Query Suggestions configurations.
/// </summary>
public partial class ConfigurationResponse
{
  /// <summary>
  /// Initializes a new instance of the ConfigurationResponse class.
  /// </summary>
  [JsonConstructor]
  public ConfigurationResponse() { }

  /// <summary>
  /// Initializes a new instance of the ConfigurationResponse class.
  /// </summary>
  /// <param name="appID">Algolia application ID to which this Query Suggestions configuration belongs. (required).</param>
  /// <param name="indexName">Name of the Query Suggestions index (case-sensitive). (required).</param>
  /// <param name="sourceIndices">Algolia indices from which to get the popular searches for query suggestions. (required).</param>
  /// <param name="languages">languages (required).</param>
  /// <param name="exclude">exclude (required).</param>
  /// <param name="enablePersonalization">Whether to turn on personalized query suggestions. (required) (default to false).</param>
  /// <param name="allowSpecialCharacters">Whether to include suggestions with special characters. (required) (default to false).</param>
  public ConfigurationResponse(
    string appID,
    string indexName,
    List<SourceIndex> sourceIndices,
    Languages languages,
    List<string> exclude,
    bool enablePersonalization,
    bool allowSpecialCharacters
  )
  {
    AppID = appID ?? throw new ArgumentNullException(nameof(appID));
    IndexName = indexName ?? throw new ArgumentNullException(nameof(indexName));
    SourceIndices = sourceIndices ?? throw new ArgumentNullException(nameof(sourceIndices));
    Languages = languages ?? throw new ArgumentNullException(nameof(languages));
    Exclude = exclude ?? throw new ArgumentNullException(nameof(exclude));
    EnablePersonalization = enablePersonalization;
    AllowSpecialCharacters = allowSpecialCharacters;
  }

  /// <summary>
  /// Algolia application ID to which this Query Suggestions configuration belongs.
  /// </summary>
  /// <value>Algolia application ID to which this Query Suggestions configuration belongs.</value>
  [JsonPropertyName("appID")]
  public string AppID { get; set; }

  /// <summary>
  /// Name of the Query Suggestions index (case-sensitive).
  /// </summary>
  /// <value>Name of the Query Suggestions index (case-sensitive).</value>
  [JsonPropertyName("indexName")]
  public string IndexName { get; set; }

  /// <summary>
  /// Algolia indices from which to get the popular searches for query suggestions.
  /// </summary>
  /// <value>Algolia indices from which to get the popular searches for query suggestions.</value>
  [JsonPropertyName("sourceIndices")]
  public List<SourceIndex> SourceIndices { get; set; }

  /// <summary>
  /// Gets or Sets Languages
  /// </summary>
  [JsonPropertyName("languages")]
  public Languages Languages { get; set; }

  /// <summary>
  /// Gets or Sets Exclude
  /// </summary>
  [JsonPropertyName("exclude")]
  public List<string> Exclude { get; set; }

  /// <summary>
  /// Whether to turn on personalized query suggestions.
  /// </summary>
  /// <value>Whether to turn on personalized query suggestions.</value>
  [JsonPropertyName("enablePersonalization")]
  public bool EnablePersonalization { get; set; }

  /// <summary>
  /// Whether to include suggestions with special characters.
  /// </summary>
  /// <value>Whether to include suggestions with special characters.</value>
  [JsonPropertyName("allowSpecialCharacters")]
  public bool AllowSpecialCharacters { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ConfigurationResponse {\n");
    sb.Append("  AppID: ").Append(AppID).Append("\n");
    sb.Append("  IndexName: ").Append(IndexName).Append("\n");
    sb.Append("  SourceIndices: ").Append(SourceIndices).Append("\n");
    sb.Append("  Languages: ").Append(Languages).Append("\n");
    sb.Append("  Exclude: ").Append(Exclude).Append("\n");
    sb.Append("  EnablePersonalization: ").Append(EnablePersonalization).Append("\n");
    sb.Append("  AllowSpecialCharacters: ").Append(AllowSpecialCharacters).Append("\n");
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
    if (obj is not ConfigurationResponse input)
    {
      return false;
    }

    return (AppID == input.AppID || (AppID != null && AppID.Equals(input.AppID)))
      && (IndexName == input.IndexName || (IndexName != null && IndexName.Equals(input.IndexName)))
      && (
        SourceIndices == input.SourceIndices
        || SourceIndices != null
          && input.SourceIndices != null
          && SourceIndices.SequenceEqual(input.SourceIndices)
      )
      && (Languages == input.Languages || (Languages != null && Languages.Equals(input.Languages)))
      && (
        Exclude == input.Exclude
        || Exclude != null && input.Exclude != null && Exclude.SequenceEqual(input.Exclude)
      )
      && (
        EnablePersonalization == input.EnablePersonalization
        || EnablePersonalization.Equals(input.EnablePersonalization)
      )
      && (
        AllowSpecialCharacters == input.AllowSpecialCharacters
        || AllowSpecialCharacters.Equals(input.AllowSpecialCharacters)
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
      if (AppID != null)
      {
        hashCode = (hashCode * 59) + AppID.GetHashCode();
      }
      if (IndexName != null)
      {
        hashCode = (hashCode * 59) + IndexName.GetHashCode();
      }
      if (SourceIndices != null)
      {
        hashCode = (hashCode * 59) + SourceIndices.GetHashCode();
      }
      if (Languages != null)
      {
        hashCode = (hashCode * 59) + Languages.GetHashCode();
      }
      if (Exclude != null)
      {
        hashCode = (hashCode * 59) + Exclude.GetHashCode();
      }
      hashCode = (hashCode * 59) + EnablePersonalization.GetHashCode();
      hashCode = (hashCode * 59) + AllowSpecialCharacters.GetHashCode();
      return hashCode;
    }
  }
}
