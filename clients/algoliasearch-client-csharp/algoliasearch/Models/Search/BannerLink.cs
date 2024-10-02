using System.Text.Json.Serialization;

namespace Algolia.Search.Models.Search;

/// <summary>
/// The url specified on the banner in the merchandising studio
/// </summary>
public class BannerLink
{
  /// <summary>
  /// Gets or sets url
  /// </summary>
  [JsonPropertyName("url")]
  public string Url { get; set; }
}
