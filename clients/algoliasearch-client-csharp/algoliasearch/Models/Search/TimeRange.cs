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
/// TimeRange
/// </summary>
[DataContract(Name = "timeRange")]
[JsonObject(MemberSerialization.OptOut)]
public partial class TimeRange
{
  /// <summary>
  /// Initializes a new instance of the TimeRange class.
  /// </summary>
  [JsonConstructor]
  public TimeRange() { }
  /// <summary>
  /// Initializes a new instance of the TimeRange class.
  /// </summary>
  /// <param name="from">Lower bound of the time range (Unix timestamp). (required).</param>
  /// <param name="until">Upper bound of the time range (Unix timestamp). (required).</param>
  public TimeRange(int from, int until)
  {
    From = from;
    Until = until;
  }

  /// <summary>
  /// Lower bound of the time range (Unix timestamp).
  /// </summary>
  /// <value>Lower bound of the time range (Unix timestamp).</value>
  [DataMember(Name = "from")]
  public int From { get; set; }

  /// <summary>
  /// Upper bound of the time range (Unix timestamp).
  /// </summary>
  /// <value>Upper bound of the time range (Unix timestamp).</value>
  [DataMember(Name = "until")]
  public int Until { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class TimeRange {\n");
    sb.Append("  From: ").Append(From).Append("\n");
    sb.Append("  Until: ").Append(Until).Append("\n");
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

