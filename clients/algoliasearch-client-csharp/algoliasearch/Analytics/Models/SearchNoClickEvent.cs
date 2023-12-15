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

namespace Algolia.Search.Analytics.Models
{
  /// <summary>
  /// SearchNoClickEvent
  /// </summary>
  [DataContract(Name = "searchNoClickEvent")]
  public partial class SearchNoClickEvent
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchNoClickEvent" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected SearchNoClickEvent() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchNoClickEvent" /> class.
    /// </summary>
    /// <param name="search">User query. (required).</param>
    /// <param name="count">Number of occurrences. (required).</param>
    /// <param name="withFilterCount">Number of occurrences. (required).</param>
    public SearchNoClickEvent(string search = default(string), int count = default(int), int withFilterCount = default(int))
    {
      // to ensure "search" is required (not null)
      if (search == null)
      {
        throw new ArgumentNullException("search is a required property for SearchNoClickEvent and cannot be null");
      }
      this.Search = search;
      this.Count = count;
      this.WithFilterCount = withFilterCount;
    }

    /// <summary>
    /// User query.
    /// </summary>
    /// <value>User query.</value>
    [DataMember(Name = "search", IsRequired = true, EmitDefaultValue = true)]
    public string Search { get; set; }

    /// <summary>
    /// Number of occurrences.
    /// </summary>
    /// <value>Number of occurrences.</value>
    [DataMember(Name = "count", IsRequired = true, EmitDefaultValue = true)]
    public int Count { get; set; }

    /// <summary>
    /// Number of occurrences.
    /// </summary>
    /// <value>Number of occurrences.</value>
    [DataMember(Name = "withFilterCount", IsRequired = true, EmitDefaultValue = true)]
    public int WithFilterCount { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchNoClickEvent {\n");
      sb.Append("  Search: ").Append(Search).Append("\n");
      sb.Append("  Count: ").Append(Count).Append("\n");
      sb.Append("  WithFilterCount: ").Append(WithFilterCount).Append("\n");
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
