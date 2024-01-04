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

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// Recommend rules search parameters.
  /// </summary>
  [DataContract(Name = "searchRecommendRulesParams")]
  public partial class SearchRecommendRulesParams
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchRecommendRulesParams" /> class.
    /// </summary>
    /// <param name="query">Full-text query. (default to &quot;&quot;).</param>
    /// <param name="context">Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules)..</param>
    /// <param name="page">Requested page (the first page is page 0)..</param>
    /// <param name="hitsPerPage">Maximum number of hits per page. (default to 20).</param>
    /// <param name="enabled">Restricts responses to enabled rules. When absent (default), _all_ rules are retrieved..</param>
    public SearchRecommendRulesParams(string query = @"", string context = default(string), int page = default(int), int hitsPerPage = 20, bool? enabled = default(bool?))
    {
      // use default value if no "query" provided
      this.Query = query ?? @"";
      this.Context = context;
      this.Page = page;
      this.HitsPerPage = hitsPerPage;
      this.Enabled = enabled;
    }

    /// <summary>
    /// Full-text query.
    /// </summary>
    /// <value>Full-text query.</value>
    [DataMember(Name = "query", EmitDefaultValue = false)]
    public string Query { get; set; }

    /// <summary>
    /// Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules).
    /// </summary>
    /// <value>Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules).</value>
    [DataMember(Name = "context", EmitDefaultValue = false)]
    public string Context { get; set; }

    /// <summary>
    /// Requested page (the first page is page 0).
    /// </summary>
    /// <value>Requested page (the first page is page 0).</value>
    [DataMember(Name = "page", EmitDefaultValue = false)]
    public int Page { get; set; }

    /// <summary>
    /// Maximum number of hits per page.
    /// </summary>
    /// <value>Maximum number of hits per page.</value>
    [DataMember(Name = "hitsPerPage", EmitDefaultValue = false)]
    public int HitsPerPage { get; set; }

    /// <summary>
    /// Restricts responses to enabled rules. When absent (default), _all_ rules are retrieved.
    /// </summary>
    /// <value>Restricts responses to enabled rules. When absent (default), _all_ rules are retrieved.</value>
    [DataMember(Name = "enabled", EmitDefaultValue = true)]
    public bool? Enabled { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchRecommendRulesParams {\n");
      sb.Append("  Query: ").Append(Query).Append("\n");
      sb.Append("  Context: ").Append(Context).Append("\n");
      sb.Append("  Page: ").Append(Page).Append("\n");
      sb.Append("  HitsPerPage: ").Append(HitsPerPage).Append("\n");
      sb.Append("  Enabled: ").Append(Enabled).Append("\n");
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
