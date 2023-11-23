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
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  /// HasPendingMappingsResponse
  /// </summary>
  [DataContract(Name = "hasPendingMappingsResponse")]
  public partial class HasPendingMappingsResponse : IEquatable<HasPendingMappingsResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="HasPendingMappingsResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected HasPendingMappingsResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="HasPendingMappingsResponse" /> class.
    /// </summary>
    /// <param name="pending">Indicates whether there are clusters undergoing migration, creation, or deletion. (required).</param>
    /// <param name="clusters">Cluster pending mapping state: migrating, creating, deleting. .</param>
    public HasPendingMappingsResponse(bool pending = default(bool), Dictionary<string, List<string>> clusters = default(Dictionary<string, List<string>>))
    {
      this.Pending = pending;
      this.Clusters = clusters;
    }

    /// <summary>
    /// Indicates whether there are clusters undergoing migration, creation, or deletion.
    /// </summary>
    /// <value>Indicates whether there are clusters undergoing migration, creation, or deletion.</value>
    [DataMember(Name = "pending", IsRequired = true, EmitDefaultValue = true)]
    public bool Pending { get; set; }

    /// <summary>
    /// Cluster pending mapping state: migrating, creating, deleting. 
    /// </summary>
    /// <value>Cluster pending mapping state: migrating, creating, deleting. </value>
    [DataMember(Name = "clusters", EmitDefaultValue = false)]
    public Dictionary<string, List<string>> Clusters { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class HasPendingMappingsResponse {\n");
      sb.Append("  Pending: ").Append(Pending).Append("\n");
      sb.Append("  Clusters: ").Append(Clusters).Append("\n");
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
      return this.Equals(input as HasPendingMappingsResponse);
    }

    /// <summary>
    /// Returns true if HasPendingMappingsResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of HasPendingMappingsResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(HasPendingMappingsResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Pending == input.Pending ||
              this.Pending.Equals(input.Pending)
          ) &&
          (
              this.Clusters == input.Clusters ||
              this.Clusters != null &&
              input.Clusters != null &&
              this.Clusters.SequenceEqual(input.Clusters)
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
        hashCode = (hashCode * 59) + this.Pending.GetHashCode();
        if (this.Clusters != null)
        {
          hashCode = (hashCode * 59) + this.Clusters.GetHashCode();
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
