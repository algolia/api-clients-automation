//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//

using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using Algolia.Search.Models;

namespace Algolia.Search.Models.Search
{
  /// <summary>
  /// userIDs data.
  /// </summary>
  [DataContract(Name = "searchUserIdsResponse")]
  [JsonObject(MemberSerialization.OptOut)]
  public partial class SearchUserIdsResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchUserIdsResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public SearchUserIdsResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchUserIdsResponse" /> class.
    /// </summary>
    /// <param name="hits">User objects that match the query. (required).</param>
    /// <param name="nbHits">Number of hits the search query matched. (required).</param>
    /// <param name="page">Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;). (required) (default to 0).</param>
    /// <param name="hitsPerPage">Maximum number of hits per page. (required) (default to 20).</param>
    /// <param name="updatedAt">Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
    public SearchUserIdsResponse(List<UserHit> hits, int? nbHits, int? page, int? hitsPerPage, string updatedAt)
    {
      this.Hits = hits ?? throw new ArgumentNullException("hits is a required property for SearchUserIdsResponse and cannot be null");
      this.NbHits = nbHits;
      this.Page = page;
      this.HitsPerPage = hitsPerPage;
      this.UpdatedAt = updatedAt ?? throw new ArgumentNullException("updatedAt is a required property for SearchUserIdsResponse and cannot be null");
    }

    /// <summary>
    /// User objects that match the query.
    /// </summary>
    /// <value>User objects that match the query.</value>
    [DataMember(Name = "hits", IsRequired = true, EmitDefaultValue = false)]
    public List<UserHit> Hits { get; set; }

    /// <summary>
    /// Number of hits the search query matched.
    /// </summary>
    /// <value>Number of hits the search query matched.</value>
    [DataMember(Name = "nbHits", IsRequired = true, EmitDefaultValue = false)]
    public int? NbHits { get; set; }

    /// <summary>
    /// Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;).
    /// </summary>
    /// <value>Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;).</value>
    [DataMember(Name = "page", IsRequired = true, EmitDefaultValue = false)]
    public int? Page { get; set; }

    /// <summary>
    /// Maximum number of hits per page.
    /// </summary>
    /// <value>Maximum number of hits per page.</value>
    [DataMember(Name = "hitsPerPage", IsRequired = true, EmitDefaultValue = false)]
    public int? HitsPerPage { get; set; }

    /// <summary>
    /// Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
    /// </summary>
    /// <value>Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
    [DataMember(Name = "updatedAt", IsRequired = true, EmitDefaultValue = false)]
    public string UpdatedAt { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchUserIdsResponse {\n");
      sb.Append("  Hits: ").Append(Hits).Append("\n");
      sb.Append("  NbHits: ").Append(NbHits).Append("\n");
      sb.Append("  Page: ").Append(Page).Append("\n");
      sb.Append("  HitsPerPage: ").Append(HitsPerPage).Append("\n");
      sb.Append("  UpdatedAt: ").Append(UpdatedAt).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public virtual string ToJson()
    {
      return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
    }

  }

}
