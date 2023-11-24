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
  /// Assign userID parameters.
  /// </summary>
  [DataContract(Name = "batchAssignUserIdsParams")]
  public partial class BatchAssignUserIdsParams : IEquatable<BatchAssignUserIdsParams>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="BatchAssignUserIdsParams" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected BatchAssignUserIdsParams() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="BatchAssignUserIdsParams" /> class.
    /// </summary>
    /// <param name="cluster">Cluster name. (required).</param>
    /// <param name="users">User IDs to assign. (required).</param>
    public BatchAssignUserIdsParams(string cluster = default(string), List<string> users = default(List<string>))
    {
      // to ensure "cluster" is required (not null)
      if (cluster == null)
      {
        throw new ArgumentNullException("cluster is a required property for BatchAssignUserIdsParams and cannot be null");
      }
      this.Cluster = cluster;
      // to ensure "users" is required (not null)
      if (users == null)
      {
        throw new ArgumentNullException("users is a required property for BatchAssignUserIdsParams and cannot be null");
      }
      this.Users = users;
    }

    /// <summary>
    /// Cluster name.
    /// </summary>
    /// <value>Cluster name.</value>
    [DataMember(Name = "cluster", IsRequired = true, EmitDefaultValue = true)]
    public string Cluster { get; set; }

    /// <summary>
    /// User IDs to assign.
    /// </summary>
    /// <value>User IDs to assign.</value>
    [DataMember(Name = "users", IsRequired = true, EmitDefaultValue = true)]
    public List<string> Users { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BatchAssignUserIdsParams {\n");
      sb.Append("  Cluster: ").Append(Cluster).Append("\n");
      sb.Append("  Users: ").Append(Users).Append("\n");
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
      return this.Equals(input as BatchAssignUserIdsParams);
    }

    /// <summary>
    /// Returns true if BatchAssignUserIdsParams instances are equal
    /// </summary>
    /// <param name="input">Instance of BatchAssignUserIdsParams to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(BatchAssignUserIdsParams input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Cluster == input.Cluster ||
              (this.Cluster != null &&
              this.Cluster.Equals(input.Cluster))
          ) &&
          (
              this.Users == input.Users ||
              this.Users != null &&
              input.Users != null &&
              this.Users.SequenceEqual(input.Users)
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
        if (this.Cluster != null)
        {
          hashCode = (hashCode * 59) + this.Cluster.GetHashCode();
        }
        if (this.Users != null)
        {
          hashCode = (hashCode * 59) + this.Users.GetHashCode();
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
