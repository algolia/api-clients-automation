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
/// Personalization
/// </summary>
[DataContract(Name = "personalization")]
[JsonObject(MemberSerialization.OptOut)]
public partial class Personalization
{
  /// <summary>
  /// Initializes a new instance of the Personalization class.
  /// </summary>
  public Personalization()
  {
  }

  /// <summary>
  /// The score of the filters.
  /// </summary>
  /// <value>The score of the filters.</value>
  [DataMember(Name = "filtersScore", EmitDefaultValue = false)]
  public int? FiltersScore { get; set; }

  /// <summary>
  /// The score of the ranking.
  /// </summary>
  /// <value>The score of the ranking.</value>
  [DataMember(Name = "rankingScore", EmitDefaultValue = false)]
  public int? RankingScore { get; set; }

  /// <summary>
  /// The score of the event.
  /// </summary>
  /// <value>The score of the event.</value>
  [DataMember(Name = "score", EmitDefaultValue = false)]
  public int? Score { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class Personalization {\n");
    sb.Append("  FiltersScore: ").Append(FiltersScore).Append("\n");
    sb.Append("  RankingScore: ").Append(RankingScore).Append("\n");
    sb.Append("  Score: ").Append(Score).Append("\n");
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

