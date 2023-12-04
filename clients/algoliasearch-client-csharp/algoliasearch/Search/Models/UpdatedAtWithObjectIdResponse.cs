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
using System.ComponentModel.DataAnnotations;
using FileParameter = Algolia.Search.Search.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Search.Client.OpenAPIDateConverter;

namespace Algolia.Search.Search.Models
{
  /// <summary>
  /// Response, taskID, unique object identifier, and an update timestamp.
  /// </summary>
  [DataContract(Name = "updatedAtWithObjectIdResponse")]
  public partial class UpdatedAtWithObjectIdResponse : IEquatable<UpdatedAtWithObjectIdResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="UpdatedAtWithObjectIdResponse" /> class.
    /// </summary>
    /// <param name="taskID">Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;. .</param>
    /// <param name="updatedAt">Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format..</param>
    /// <param name="objectID">Unique object identifier..</param>
    public UpdatedAtWithObjectIdResponse(long taskID = default(long), string updatedAt = default(string), string objectID = default(string))
    {
      this.TaskID = taskID;
      this.UpdatedAt = updatedAt;
      this.ObjectID = objectID;
    }

    /// <summary>
    /// Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;. 
    /// </summary>
    /// <value>Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task&#39;s progress with the &#x60;task&#x60; operation and this &#x60;taskID&#x60;. </value>
    [DataMember(Name = "taskID", EmitDefaultValue = false)]
    public long TaskID { get; set; }

    /// <summary>
    /// Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
    /// </summary>
    /// <value>Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
    [DataMember(Name = "updatedAt", EmitDefaultValue = false)]
    public string UpdatedAt { get; set; }

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
      sb.Append("class UpdatedAtWithObjectIdResponse {\n");
      sb.Append("  TaskID: ").Append(TaskID).Append("\n");
      sb.Append("  UpdatedAt: ").Append(UpdatedAt).Append("\n");
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

    /// <summary>
    /// Returns true if objects are equal
    /// </summary>
    /// <param name="input">Object to be compared</param>
    /// <returns>Boolean</returns>
    public override bool Equals(object input)
    {
      return this.Equals(input as UpdatedAtWithObjectIdResponse);
    }

    /// <summary>
    /// Returns true if UpdatedAtWithObjectIdResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of UpdatedAtWithObjectIdResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(UpdatedAtWithObjectIdResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.TaskID == input.TaskID ||
              this.TaskID.Equals(input.TaskID)
          ) &&
          (
              this.UpdatedAt == input.UpdatedAt ||
              (this.UpdatedAt != null &&
              this.UpdatedAt.Equals(input.UpdatedAt))
          ) &&
          (
              this.ObjectID == input.ObjectID ||
              (this.ObjectID != null &&
              this.ObjectID.Equals(input.ObjectID))
          );
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
        hashCode = (hashCode * 59) + this.TaskID.GetHashCode();
        if (this.UpdatedAt != null)
        {
          hashCode = (hashCode * 59) + this.UpdatedAt.GetHashCode();
        }
        if (this.ObjectID != null)
        {
          hashCode = (hashCode * 59) + this.ObjectID.GetHashCode();
        }
        return hashCode;
      }
    }

    /// <summary>
    /// To validate all properties of the instance
    /// </summary>
    /// <param name="validationContext">Validation context</param>
    /// <returns>Validation Result</returns>
    IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
    {
      yield break;
    }
  }

}
