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
/// GetTopFiltersNoResultsResponse
/// </summary>
[DataContract(Name = "getTopFiltersNoResultsResponse")]
public partial class GetTopFiltersNoResultsResponse
{
  /// <summary>
  /// Initializes a new instance of the GetTopFiltersNoResultsResponse class.
  /// </summary>
  [JsonConstructor]
  public GetTopFiltersNoResultsResponse() { }
  /// <summary>
  /// Initializes a new instance of the GetTopFiltersNoResultsResponse class.
  /// </summary>
  /// <param name="values">Filters with no results. (required).</param>
  public GetTopFiltersNoResultsResponse(List<GetTopFiltersNoResultsValues> values)
  {
    Values = values ?? throw new ArgumentNullException(nameof(values));
  }

  /// <summary>
  /// Filters with no results.
  /// </summary>
  /// <value>Filters with no results.</value>
  [DataMember(Name = "values")]
  public List<GetTopFiltersNoResultsValues> Values { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class GetTopFiltersNoResultsResponse {\n");
    sb.Append("  Values: ").Append(Values).Append("\n");
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

