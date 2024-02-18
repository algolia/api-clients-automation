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
/// BaseQuerySuggestionsConfigurationWithIndex
/// </summary>
public partial class BaseQuerySuggestionsConfigurationWithIndex
{
  /// <summary>
  /// Initializes a new instance of the BaseQuerySuggestionsConfigurationWithIndex class.
  /// </summary>
  [JsonConstructor]
  public BaseQuerySuggestionsConfigurationWithIndex() { }
  /// <summary>
  /// Initializes a new instance of the BaseQuerySuggestionsConfigurationWithIndex class.
  /// </summary>
  /// <param name="indexName">Query Suggestions index name. (required).</param>
  public BaseQuerySuggestionsConfigurationWithIndex(string indexName)
  {
    IndexName = indexName ?? throw new ArgumentNullException(nameof(indexName));
  }

  /// <summary>
  /// Query Suggestions index name.
  /// </summary>
  /// <value>Query Suggestions index name.</value>
  [JsonPropertyName("indexName")]
  public string IndexName { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class BaseQuerySuggestionsConfigurationWithIndex {\n");
    sb.Append("  IndexName: ").Append(IndexName).Append("\n");
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
    if (obj is not BaseQuerySuggestionsConfigurationWithIndex input)
    {
      return false;
    }

    return
        (IndexName == input.IndexName || (IndexName != null && IndexName.Equals(input.IndexName)));
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
      return hashCode;
    }
  }

}

