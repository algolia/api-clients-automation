using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text.Json.Serialization;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;
using Algolia.Search.Utils;

namespace Algolia.Search.Models.Common;

/// <summary>
/// Secured Api Key restrictions
/// </summary>
public class SecuredApiKeyRestriction
{
  /// <summary>
  /// Search query parameters
  /// </summary>
  public IndexSettingsAsSearchParams Query { get; set; }

  /// <summary>
  /// A Unix timestamp used to define the expiration date of the API key.
  /// </summary>
  [JsonPropertyName("validUntil")]
  public long? ValidUntil { get; set; }

  /// <summary>
  /// List of index names that can be queried.
  /// </summary>
  [JsonPropertyName("restrictIndices")]
  public List<string> RestrictIndices { get; set; }

  /// <summary>
  /// IPv4 network allowed to use the generated key. This is used for more protection against API key leaking and reuse.
  /// </summary>
  [JsonPropertyName("restrictSources")]
  public List<string> RestrictSources { get; set; }

  /// <summary>
  /// Specify a user identifier. This is often used with rate limits.
  /// </summary>
  [JsonPropertyName("userToken")]
  public string UserToken { get; set; }

  /// <summary>
  /// Transforms the restriction into a query string
  /// </summary>
  /// <returns></returns>
  public string ToQueryString()
  {
    string restrictionQuery = null;
    if (Query != null)
    {
      restrictionQuery = ToQueryString(Query);
    }

    var restrictions = ToQueryString(this, nameof(Query));
    var array = new[] { restrictionQuery, restrictions };

    return string.Join("&", array.Where(s => !string.IsNullOrEmpty(s)));
  }

  /// <summary>
  /// Transform a poco (only class of primitive objects) to a query string
  /// </summary>
  /// <param name="value"></param>
  /// <param name="ignoreList"></param>
  /// <typeparam name="T"></typeparam>
  /// <returns></returns>
  private static string ToQueryString<T>(T value, params string[] ignoreList)
  {
    var properties = typeof(T).GetTypeInfo()
      .DeclaredProperties.Where(p =>
        p.GetValue(value, null) != null && !ignoreList.Contains(p.Name) &&
        p.GetCustomAttribute<JsonPropertyNameAttribute>() != null)
      .Select(p => new
      {
        propsName = p.GetCustomAttribute<JsonPropertyNameAttribute>().Name,
        value = ClientUtils.ParameterToString(p.GetValue(value, null))
      }).ToDictionary(p => p.propsName, p => p.value);

    return properties.ToQueryString();
  }

}
