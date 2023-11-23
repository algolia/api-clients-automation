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
using FileParameter = Org.OpenAPITools.Client.FileParameter;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  /// Unique identifier of the record to hide.
  /// </summary>
  [DataContract(Name = "consequenceHide")]
  public partial class ConsequenceHide : IEquatable<ConsequenceHide>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="ConsequenceHide" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected ConsequenceHide() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="ConsequenceHide" /> class.
    /// </summary>
    /// <param name="objectID">Unique object identifier. (required).</param>
    public ConsequenceHide(string objectID = default(string))
    {
      // to ensure "objectID" is required (not null)
      if (objectID == null)
      {
        throw new ArgumentNullException("objectID is a required property for ConsequenceHide and cannot be null");
      }
      this.ObjectID = objectID;
    }

    /// <summary>
    /// Unique object identifier.
    /// </summary>
    /// <value>Unique object identifier.</value>
    /// <example>product-1</example>
    [DataMember(Name = "objectID", IsRequired = true, EmitDefaultValue = true)]
    public string ObjectID { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class ConsequenceHide {\n");
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
      return this.Equals(input as ConsequenceHide);
    }

    /// <summary>
    /// Returns true if ConsequenceHide instances are equal
    /// </summary>
    /// <param name="input">Instance of ConsequenceHide to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(ConsequenceHide input)
    {
      if (input == null)
      {
        return false;
      }
      return
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
