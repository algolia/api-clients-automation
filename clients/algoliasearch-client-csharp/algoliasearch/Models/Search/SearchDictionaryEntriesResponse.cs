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

namespace Algolia.Search.Models.Search;

/// <summary>
/// SearchDictionaryEntriesResponse
/// </summary>
public partial class SearchDictionaryEntriesResponse
{
  /// <summary>
  /// Initializes a new instance of the SearchDictionaryEntriesResponse class.
  /// </summary>
  [JsonConstructor]
  public SearchDictionaryEntriesResponse() { }
  /// <summary>
  /// Initializes a new instance of the SearchDictionaryEntriesResponse class.
  /// </summary>
  /// <param name="hits">Dictionary entries matching the search criteria. (required).</param>
  /// <param name="page">Requested page of the API response. (required).</param>
  /// <param name="nbHits">Number of results (hits). (required).</param>
  /// <param name="nbPages">Number of pages of results. (required).</param>
  public SearchDictionaryEntriesResponse(List<DictionaryEntry> hits, int page, int nbHits, int nbPages)
  {
    Hits = hits ?? throw new ArgumentNullException(nameof(hits));
    Page = page;
    NbHits = nbHits;
    NbPages = nbPages;
  }

  /// <summary>
  /// Dictionary entries matching the search criteria.
  /// </summary>
  /// <value>Dictionary entries matching the search criteria.</value>
  [JsonPropertyName("hits")]
  public List<DictionaryEntry> Hits { get; set; }

  /// <summary>
  /// Requested page of the API response.
  /// </summary>
  /// <value>Requested page of the API response.</value>
  [JsonPropertyName("page")]
  public int Page { get; set; }

  /// <summary>
  /// Number of results (hits).
  /// </summary>
  /// <value>Number of results (hits).</value>
  [JsonPropertyName("nbHits")]
  public int NbHits { get; set; }

  /// <summary>
  /// Number of pages of results.
  /// </summary>
  /// <value>Number of pages of results.</value>
  [JsonPropertyName("nbPages")]
  public int NbPages { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SearchDictionaryEntriesResponse {\n");
    sb.Append("  Hits: ").Append(Hits).Append("\n");
    sb.Append("  Page: ").Append(Page).Append("\n");
    sb.Append("  NbHits: ").Append(NbHits).Append("\n");
    sb.Append("  NbPages: ").Append(NbPages).Append("\n");
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
    if (obj is not SearchDictionaryEntriesResponse input)
    {
      return false;
    }

    return
        (Hits == input.Hits || Hits != null && input.Hits != null && Hits.SequenceEqual(input.Hits)) &&
        (Page == input.Page || Page.Equals(input.Page)) &&
        (NbHits == input.NbHits || NbHits.Equals(input.NbHits)) &&
        (NbPages == input.NbPages || NbPages.Equals(input.NbPages));
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
      if (Hits != null)
      {
        hashCode = (hashCode * 59) + Hits.GetHashCode();
      }
      hashCode = (hashCode * 59) + Page.GetHashCode();
      hashCode = (hashCode * 59) + NbHits.GetHashCode();
      hashCode = (hashCode * 59) + NbPages.GetHashCode();
      return hashCode;
    }
  }

}

