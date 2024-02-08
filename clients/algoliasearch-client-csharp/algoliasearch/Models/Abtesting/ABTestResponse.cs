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

namespace Algolia.Search.Models.Abtesting;

/// <summary>
/// ABTestResponse
/// </summary>
[DataContract(Name = "ABTestResponse")]
public partial class ABTestResponse
{
  /// <summary>
  /// Initializes a new instance of the ABTestResponse class.
  /// </summary>
  [JsonConstructor]
  public ABTestResponse() { }
  /// <summary>
  /// Initializes a new instance of the ABTestResponse class.
  /// </summary>
  /// <param name="index">A/B test index. (required).</param>
  /// <param name="abTestID">Unique A/B test ID. (required).</param>
  /// <param name="taskID">Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;.  (required).</param>
  public ABTestResponse(string index, int abTestID, long taskID)
  {
    Index = index ?? throw new ArgumentNullException(nameof(index));
    AbTestID = abTestID;
    TaskID = taskID;
  }

  /// <summary>
  /// A/B test index.
  /// </summary>
  /// <value>A/B test index.</value>
  [DataMember(Name = "index")]
  public string Index { get; set; }

  /// <summary>
  /// Unique A/B test ID.
  /// </summary>
  /// <value>Unique A/B test ID.</value>
  [DataMember(Name = "abTestID")]
  public int AbTestID { get; set; }

  /// <summary>
  /// Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`. 
  /// </summary>
  /// <value>Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`. </value>
  [DataMember(Name = "taskID")]
  public long TaskID { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ABTestResponse {\n");
    sb.Append("  Index: ").Append(Index).Append("\n");
    sb.Append("  AbTestID: ").Append(AbTestID).Append("\n");
    sb.Append("  TaskID: ").Append(TaskID).Append("\n");
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

