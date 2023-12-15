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

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// Response, taskID, and deletion timestamp.
  /// </summary>
  [DataContract(Name = "deletedAtResponse")]
  public partial class DeletedAtResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="DeletedAtResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected DeletedAtResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="DeletedAtResponse" /> class.
    /// </summary>
    /// <param name="taskID">Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;.  (required).</param>
    /// <param name="deletedAt">Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
    public DeletedAtResponse(long taskID = default(long), string deletedAt = default(string))
    {
      this.TaskID = taskID;
      // to ensure "deletedAt" is required (not null)
      if (deletedAt == null)
      {
        throw new ArgumentNullException("deletedAt is a required property for DeletedAtResponse and cannot be null");
      }
      this.DeletedAt = deletedAt;
    }

    /// <summary>
    /// Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;. 
    /// </summary>
    /// <value>Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;. </value>
    [DataMember(Name = "taskID", IsRequired = true, EmitDefaultValue = true)]
    public long TaskID { get; set; }

    /// <summary>
    /// Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
    /// </summary>
    /// <value>Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
    [DataMember(Name = "deletedAt", IsRequired = true, EmitDefaultValue = true)]
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
      return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
    }

  }

}
