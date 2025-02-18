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
/// Image to show inside a banner.
/// </summary>
public partial class BannerImage
{
  /// <summary>
  /// Initializes a new instance of the BannerImage class.
  /// </summary>
  public BannerImage()
  {
  }

  /// <summary>
  /// Gets or Sets Urls
  /// </summary>
  [JsonPropertyName("urls")]
  public List<BannerImageUrl> Urls { get; set; }

  /// <summary>
  /// Gets or Sets Title
  /// </summary>
  [JsonPropertyName("title")]
  public string Title { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class BannerImage {\n");
    sb.Append("  Urls: ").Append(Urls).Append("\n");
    sb.Append("  Title: ").Append(Title).Append("\n");
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
    if (obj is not BannerImage input)
    {
      return false;
    }

    return
        (Urls == input.Urls || Urls != null && input.Urls != null && Urls.SequenceEqual(input.Urls)) &&
        (Title == input.Title || (Title != null && Title.Equals(input.Title)));
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
      if (Urls != null)
      {
        hashCode = (hashCode * 59) + Urls.GetHashCode();
      }
      if (Title != null)
      {
        hashCode = (hashCode * 59) + Title.GetHashCode();
      }
      return hashCode;
    }
  }

}

