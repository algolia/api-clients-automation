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
  /// User ID data.
  /// </summary>
  [DataContract(Name = "listUserIdsResponse")]
  public partial class ListUserIdsResponse : IEquatable<ListUserIdsResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="ListUserIdsResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected ListUserIdsResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="ListUserIdsResponse" /> class.
    /// </summary>
    /// <param name="userIDs">User IDs. (required).</param>
    public ListUserIdsResponse(List<UserId> userIDs = default(List<UserId>))
    {
      // to ensure "userIDs" is required (not null)
      if (userIDs == null)
      {
        throw new ArgumentNullException("userIDs is a required property for ListUserIdsResponse and cannot be null");
      }
      this.UserIDs = userIDs;
    }

    /// <summary>
    /// User IDs.
    /// </summary>
    /// <value>User IDs.</value>
    [DataMember(Name = "userIDs", IsRequired = true, EmitDefaultValue = true)]
    public List<UserId> UserIDs { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class ListUserIdsResponse {\n");
      sb.Append("  UserIDs: ").Append(UserIDs).Append("\n");
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
      return this.Equals(input as ListUserIdsResponse);
    }

    /// <summary>
    /// Returns true if ListUserIdsResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of ListUserIdsResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(ListUserIdsResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.UserIDs == input.UserIDs ||
              this.UserIDs != null &&
              input.UserIDs != null &&
              this.UserIDs.SequenceEqual(input.UserIDs)
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
        if (this.UserIDs != null)
        {
          hashCode = (hashCode * 59) + this.UserIDs.GetHashCode();
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
