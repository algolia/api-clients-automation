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

namespace Algolia.Search.Models.Analytics;

/// <summary>
/// GetSearchesCountResponse
/// </summary>
[DataContract(Name = "getSearchesCountResponse")]
[JsonObject(MemberSerialization.OptOut)]
public partial class GetSearchesCountResponse
{
  /// <summary>
  /// Initializes a new instance of the GetSearchesCountResponse class.
  /// </summary>
  [JsonConstructor]
  public GetSearchesCountResponse() { }
  /// <summary>
  /// Initializes a new instance of the GetSearchesCountResponse class.
  /// </summary>
  /// <param name="count">Number of occurrences. (required).</param>
  /// <param name="dates">Search events with their associated dates and hit counts. (required).</param>
  public GetSearchesCountResponse(int? count, List<SearchEvent> dates)
  {
    Count = count;
    Dates = dates ?? throw new ArgumentNullException(nameof(dates));
  }

  /// <summary>
  /// Number of occurrences.
  /// </summary>
  /// <value>Number of occurrences.</value>
  [DataMember(Name = "count", IsRequired = true, EmitDefaultValue = false)]
  public int? Count { get; set; }

  /// <summary>
  /// Search events with their associated dates and hit counts.
  /// </summary>
  /// <value>Search events with their associated dates and hit counts.</value>
  [DataMember(Name = "dates", IsRequired = true, EmitDefaultValue = false)]
  public List<SearchEvent> Dates { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class GetSearchesCountResponse {\n");
    sb.Append("  Count: ").Append(Count).Append("\n");
    sb.Append("  Dates: ").Append(Dates).Append("\n");
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

