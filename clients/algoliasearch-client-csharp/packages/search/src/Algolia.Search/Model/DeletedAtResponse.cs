/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


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
using FileParameter = Algolia.Search.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Client.OpenAPIDateConverter;

namespace Algolia.Search.Model
{
  /// <summary>
  /// Response, taskID, and deletion timestamp.
  /// </summary>
  [DataContract(Name = "deletedAtResponse")]
  public partial class DeletedAtResponse : IEquatable<DeletedAtResponse>, IValidatableObject
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

    /// <summary>
    /// Returns true if objects are equal
    /// </summary>
    /// <param name="input">Object to be compared</param>
    /// <returns>Boolean</returns>
    public override bool Equals(object input)
    {
      return this.Equals(input as DeletedAtResponse);
    }

    /// <summary>
    /// Returns true if DeletedAtResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of DeletedAtResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(DeletedAtResponse input)
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
              this.DeletedAt == input.DeletedAt ||
              (this.DeletedAt != null &&
              this.DeletedAt.Equals(input.DeletedAt))
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
        if (this.DeletedAt != null)
        {
          hashCode = (hashCode * 59) + this.DeletedAt.GetHashCode();
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
