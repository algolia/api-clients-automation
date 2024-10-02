using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace Algolia.Search.Models.Search;

/// <summary>
/// A banner image, contains urls for the images and a title
/// </summary>
public class BannerImage
{
  /// <summary>
  /// Gets or sets urls
  /// </summary>
  [JsonPropertyName("urls")]
  public IReadOnlyCollection<BannerImageUrl> Urls { get; set; }

  /// <summary>
  /// Gets or sets title
  /// </summary>
  [JsonPropertyName("title")]
  public string Title { get; set; }
}
