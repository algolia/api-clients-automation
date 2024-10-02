using System.Text.Json.Serialization;

namespace Algolia.Search.Models.Search;

/// <summary>
/// Represents a banner configured in the merchandising studio
/// </summary>
public class Banner
{
  /// <summary>
  /// Gets or sets image
  /// </summary>
  [JsonPropertyName("image")]
  public BannerImage Image { get; set; }

  /// <summary>
  /// Gets or sets link
  /// </summary>
  [JsonPropertyName("link")]
  public BannerLink Link { get; set; }
}
