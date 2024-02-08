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

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// RunProgress
/// </summary>
[DataContract(Name = "Run_progress")]
public partial class RunProgress
{
  /// <summary>
  /// Initializes a new instance of the RunProgress class.
  /// </summary>
  public RunProgress()
  {
  }

  /// <summary>
  /// Gets or Sets ExpectedNbOfEvents
  /// </summary>
  [DataMember(Name = "expectedNbOfEvents")]
  public int? ExpectedNbOfEvents { get; set; }

  /// <summary>
  /// Gets or Sets ReceivedNbOfEvents
  /// </summary>
  [DataMember(Name = "receivedNbOfEvents")]
  public int? ReceivedNbOfEvents { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class RunProgress {\n");
    sb.Append("  ExpectedNbOfEvents: ").Append(ExpectedNbOfEvents).Append("\n");
    sb.Append("  ReceivedNbOfEvents: ").Append(ReceivedNbOfEvents).Append("\n");
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

