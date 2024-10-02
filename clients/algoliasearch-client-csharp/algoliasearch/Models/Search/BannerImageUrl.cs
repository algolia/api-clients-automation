using System.Text.Json.Serialization;

namespace Algolia.Search.Models.Search;

/// <summary>
/// Url specified for the banner image in the merchandising studio
/// </summary>
public class BannerImageUrl
{
  /// <summary>
  /// Gets or sets url
  /// </summary>
  [JsonPropertyName("url")]
  public string Url { get; set; }
}
