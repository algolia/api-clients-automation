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
/// TaskSearch
/// </summary>
[DataContract(Name = "TaskSearch")]
[JsonObject(MemberSerialization.OptOut)]
public partial class TaskSearch
{
  /// <summary>
  /// Initializes a new instance of the TaskSearch class.
  /// </summary>
  [JsonConstructor]
  public TaskSearch() { }
  /// <summary>
  /// Initializes a new instance of the TaskSearch class.
  /// </summary>
  /// <param name="taskIDs">taskIDs (required).</param>
  public TaskSearch(List<string> taskIDs)
  {
    TaskIDs = taskIDs ?? throw new ArgumentNullException(nameof(taskIDs));
  }

  /// <summary>
  /// Gets or Sets TaskIDs
  /// </summary>
  [DataMember(Name = "taskIDs", IsRequired = true, EmitDefaultValue = false)]
  public List<string> TaskIDs { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class TaskSearch {\n");
    sb.Append("  TaskIDs: ").Append(TaskIDs).Append("\n");
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

