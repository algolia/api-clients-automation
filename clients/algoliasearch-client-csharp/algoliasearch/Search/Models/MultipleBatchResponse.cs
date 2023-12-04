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
  /// MultipleBatchResponse
  /// </summary>
  [DataContract(Name = "multipleBatchResponse")]
  public partial class MultipleBatchResponse : IEquatable<MultipleBatchResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="MultipleBatchResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected MultipleBatchResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="MultipleBatchResponse" /> class.
    /// </summary>
    /// <param name="taskID">TaskIDs per index. (required).</param>
    /// <param name="objectIDs">Unique object (record) identifiers. (required).</param>
    public MultipleBatchResponse(Dictionary<string, long> taskID = default(Dictionary<string, long>), List<string> objectIDs = default(List<string>))
    {
      // to ensure "taskID" is required (not null)
      if (taskID == null)
      {
        throw new ArgumentNullException("taskID is a required property for MultipleBatchResponse and cannot be null");
      }
      this.TaskID = taskID;
      // to ensure "objectIDs" is required (not null)
      if (objectIDs == null)
      {
        throw new ArgumentNullException("objectIDs is a required property for MultipleBatchResponse and cannot be null");
      }
      this.ObjectIDs = objectIDs;
    }

    /// <summary>
    /// TaskIDs per index.
    /// </summary>
    /// <value>TaskIDs per index.</value>
    [DataMember(Name = "taskID", IsRequired = true, EmitDefaultValue = true)]
    public Dictionary<string, long> TaskID { get; set; }

    /// <summary>
    /// Unique object (record) identifiers.
    /// </summary>
    /// <value>Unique object (record) identifiers.</value>
    [DataMember(Name = "objectIDs", IsRequired = true, EmitDefaultValue = true)]
    public List<string> ObjectIDs { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class MultipleBatchResponse {\n");
      sb.Append("  TaskID: ").Append(TaskID).Append("\n");
      sb.Append("  ObjectIDs: ").Append(ObjectIDs).Append("\n");
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
      return this.Equals(input as MultipleBatchResponse);
    }

    /// <summary>
    /// Returns true if MultipleBatchResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of MultipleBatchResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(MultipleBatchResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.TaskID == input.TaskID ||
              this.TaskID != null &&
              input.TaskID != null &&
              this.TaskID.SequenceEqual(input.TaskID)
          ) &&
          (
              this.ObjectIDs == input.ObjectIDs ||
              this.ObjectIDs != null &&
              input.ObjectIDs != null &&
              this.ObjectIDs.SequenceEqual(input.ObjectIDs)
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
        if (this.TaskID != null)
        {
          hashCode = (hashCode * 59) + this.TaskID.GetHashCode();
        }
        if (this.ObjectIDs != null)
        {
          hashCode = (hashCode * 59) + this.ObjectIDs.GetHashCode();
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
