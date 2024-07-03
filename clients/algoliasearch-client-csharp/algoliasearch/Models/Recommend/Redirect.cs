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

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// [Redirect results to a URL](https://www.algolia.com/doc/guides/managing-results/rules/merchandising-and-promoting/how-to/redirects/), this this parameter is for internal use only. 
/// </summary>
public partial class Redirect
{
  /// <summary>
  /// Initializes a new instance of the Redirect class.
  /// </summary>
  public Redirect()
  {
  }

  /// <summary>
  /// Gets or Sets Index
  /// </summary>
  [JsonPropertyName("index")]
  public List<RedirectRuleIndexMetadata> Index { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class Redirect {\n");
    sb.Append("  Index: ").Append(Index).Append("\n");
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
    if (obj is not Redirect input)
    {
      return false;
    }

    return
        (Index == input.Index || Index != null && input.Index != null && Index.SequenceEqual(input.Index));
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
      if (Index != null)
      {
        hashCode = (hashCode * 59) + Index.GetHashCode();
      }
      return hashCode;
    }
  }

}

