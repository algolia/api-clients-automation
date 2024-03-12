//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Text;
using System.Linq;
using System.Text.Json.Serialization;
using System.Collections.Generic;
using Algolia.Search.Serializer;
using System.Text.Json;

namespace Algolia.Search.Models.Search;

/// <summary>
/// Response, taskID, and deletion timestamp.
/// </summary>
public partial class DeletedAtResponse
{
  /// <summary>
  /// Initializes a new instance of the DeletedAtResponse class.
  /// </summary>
  [JsonConstructor]
  public DeletedAtResponse() { }
  /// <summary>
  /// Initializes a new instance of the DeletedAtResponse class.
  /// </summary>
  /// <param name="taskID">Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the [&#x60;task&#x60; operation](#tag/Indices/operation/getTask) and this &#x60;taskID&#x60;.  (required).</param>
  /// <param name="deletedAt">Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
  public DeletedAtResponse(long taskID, string deletedAt)
  {
    TaskID = taskID;
    DeletedAt = deletedAt ?? throw new ArgumentNullException(nameof(deletedAt));
  }

  /// <summary>
  /// Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`. 
  /// </summary>
  /// <value>Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`. </value>
  [JsonPropertyName("taskID")]
  public long TaskID { get; set; }

  /// <summary>
  /// Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
  /// </summary>
  /// <value>Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
  [JsonPropertyName("deletedAt")]
  public string DeletedAt { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class DeletedAtResponse {\n");
    sb.Append("  TaskID: ").Append(TaskID).Append("\n");
    sb.Append("  DeletedAt: ").Append(DeletedAt).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonSerializer.Serialize(this, JsonConfig.Options);
  }

  /// <summary>
  /// Returns true if objects are equal
  /// </summary>
  /// <param name="obj">Object to be compared</param>
  /// <returns>Boolean</returns>
  public override bool Equals(object obj)
  {
    if (obj is not DeletedAtResponse input)
    {
      return false;
    }

    return
        (TaskID == input.TaskID || TaskID.Equals(input.TaskID)) &&
        (DeletedAt == input.DeletedAt || (DeletedAt != null && DeletedAt.Equals(input.DeletedAt)));
  }

  /// <summary>
  /// Gets the hash code
  /// </summary>
  /// <returns>Hash code</returns>
  public override int GetHashCode()
  {
    unchecked // Overflow is fine, just wrap
    {
      int hashCode = 41;
      hashCode = (hashCode * 59) + TaskID.GetHashCode();
      if (DeletedAt != null)
      {
        hashCode = (hashCode * 59) + DeletedAt.GetHashCode();
      }
      return hashCode;
    }
  }

}

