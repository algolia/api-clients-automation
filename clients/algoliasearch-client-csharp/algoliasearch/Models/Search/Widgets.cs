using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace Algolia.Search.Models.Search;

public class Widgets
{
  /// <summary>
  /// Gets or sets banners
  /// </summary>
  [JsonPropertyName("banners")]
  public IReadOnlyCollection<Banner> Banners { get; set; }
}
