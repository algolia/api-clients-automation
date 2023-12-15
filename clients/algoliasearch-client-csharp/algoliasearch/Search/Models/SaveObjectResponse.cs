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

namespace Algolia.Search.Search.Models
{
  /// <summary>
  /// SaveObjectResponse
  /// </summary>
  [DataContract(Name = "saveObjectResponse")]
  public partial class SaveObjectResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SaveObjectResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected SaveObjectResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="SaveObjectResponse" /> class.
    /// </summary>
    /// <param name="createdAt">Date of creation (ISO-8601 format). (required).</param>
    /// <param name="taskID">Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;.  (required).</param>
    /// <param name="objectID">Unique object identifier..</param>
    public SaveObjectResponse(string createdAt = default(string), long taskID = default(long), string objectID = default(string))
    {
      // to ensure "createdAt" is required (not null)
      if (createdAt == null)
      {
        throw new ArgumentNullException("createdAt is a required property for SaveObjectResponse and cannot be null");
      }
      this.CreatedAt = createdAt;
      this.TaskID = taskID;
      this.ObjectID = objectID;
    }

    /// <summary>
    /// Date of creation (ISO-8601 format).
    /// </summary>
    /// <value>Date of creation (ISO-8601 format).</value>
    [DataMember(Name = "createdAt", IsRequired = true, EmitDefaultValue = true)]
    public string CreatedAt { get; set; }

    /// <summary>
    /// Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;. 
    /// </summary>
    /// <value>Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;. </value>
    [DataMember(Name = "taskID", IsRequired = true, EmitDefaultValue = true)]
    public long TaskID { get; set; }

    /// <summary>
    /// Unique object identifier.
    /// </summary>
    /// <value>Unique object identifier.</value>
    [DataMember(Name = "objectID", EmitDefaultValue = false)]
    public string ObjectID { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SaveObjectResponse {\n");
      sb.Append("  CreatedAt: ").Append(CreatedAt).Append("\n");
      sb.Append("  TaskID: ").Append(TaskID).Append("\n");
      sb.Append("  ObjectID: ").Append(ObjectID).Append("\n");
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
