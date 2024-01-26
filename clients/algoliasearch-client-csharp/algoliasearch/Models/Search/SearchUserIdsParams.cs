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
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Search;

/// <summary>
/// OK
/// </summary>
[DataContract(Name = "searchUserIdsParams")]
[JsonObject(MemberSerialization.OptOut)]
public partial class SearchUserIdsParams
{
  /// <summary>
  /// Initializes a new instance of the SearchUserIdsParams class.
  /// </summary>
  [JsonConstructor]
  public SearchUserIdsParams() { }
  /// <summary>
  /// Initializes a new instance of the SearchUserIdsParams class.
  /// </summary>
  /// <param name="query">Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users. (required).</param>
  public SearchUserIdsParams(string query)
  {
    Query = query ?? throw new ArgumentNullException(nameof(query));
  }

  /// <summary>
  /// Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users.
  /// </summary>
  /// <value>Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users.</value>
  [DataMember(Name = "query", IsRequired = true, EmitDefaultValue = false)]
  public string Query { get; set; }

  /// <summary>
  /// Cluster name.
  /// </summary>
  /// <value>Cluster name.</value>
  [DataMember(Name = "clusterName", EmitDefaultValue = false)]
  public string ClusterName { get; set; }

  /// <summary>
  /// Page to retrieve (the first page is `0`, not `1`).
  /// </summary>
  /// <value>Page to retrieve (the first page is `0`, not `1`).</value>
  [DataMember(Name = "page", EmitDefaultValue = false)]
  public int? Page { get; set; }

  /// <summary>
  /// Number of hits per page.
  /// </summary>
  /// <value>Number of hits per page.</value>
  [DataMember(Name = "hitsPerPage", EmitDefaultValue = false)]
  public int? HitsPerPage { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SearchUserIdsParams {\n");
    sb.Append("  Query: ").Append(Query).Append("\n");
    sb.Append("  ClusterName: ").Append(ClusterName).Append("\n");
    sb.Append("  Page: ").Append(Page).Append("\n");
    sb.Append("  HitsPerPage: ").Append(HitsPerPage).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonConvert.SerializeObject(this, Formatting.Indented);
  }

}

