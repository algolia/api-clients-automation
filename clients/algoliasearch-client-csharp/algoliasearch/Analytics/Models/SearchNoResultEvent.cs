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

namespace Algolia.Search.Models.Analytics
{
  /// <summary>
  /// SearchNoResultEvent
  /// </summary>
  [DataContract(Name = "searchNoResultEvent")]
  public partial class SearchNoResultEvent
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchNoResultEvent" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public SearchNoResultEvent() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchNoResultEvent" /> class.
    /// </summary>
    /// <param name="search">User query. (required).</param>
    /// <param name="count">Number of occurrences. (required).</param>
    /// <param name="nbHits">Number of hits the search query matched. (required).</param>
    public SearchNoResultEvent(string search, int? count, int? nbHits)
    {
      this.Search = search ?? throw new ArgumentNullException("search is a required property for SearchNoResultEvent and cannot be null");
      this.Count = count;
      this.NbHits = nbHits;
    }

    /// <summary>
    /// User query.
    /// </summary>
    /// <value>User query.</value>
    [DataMember(Name = "search", IsRequired = true, EmitDefaultValue = false)]
    public string Search { get; set; }

    /// <summary>
    /// Number of occurrences.
    /// </summary>
    /// <value>Number of occurrences.</value>
    [DataMember(Name = "count", IsRequired = true, EmitDefaultValue = false)]
    public int? Count { get; set; }

    /// <summary>
    /// Number of hits the search query matched.
    /// </summary>
    /// <value>Number of hits the search query matched.</value>
    [DataMember(Name = "nbHits", IsRequired = true, EmitDefaultValue = false)]
    public int? NbHits { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchNoResultEvent {\n");
      sb.Append("  Search: ").Append(Search).Append("\n");
      sb.Append("  Count: ").Append(Count).Append("\n");
      sb.Append("  NbHits: ").Append(NbHits).Append("\n");
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
