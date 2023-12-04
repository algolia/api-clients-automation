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
using FileParameter = Algolia.Search.Ingestion.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Ingestion.Client.OpenAPIDateConverter;

namespace Algolia.Search.Ingestion.Models
{
  /// <summary>
  /// An authentication is used to login into a Source or a Destination.
  /// </summary>
  [DataContract(Name = "Authentication")]
  public partial class Authentication : IEquatable<Authentication>, IValidatableObject
  {

    /// <summary>
    /// Gets or Sets Type
    /// </summary>
    [DataMember(Name = "type", IsRequired = true, EmitDefaultValue = true)]
    public AuthenticationType Type { get; set; }

    /// <summary>
    /// Gets or Sets Platform
    /// </summary>
    [DataMember(Name = "platform", EmitDefaultValue = false)]
    public Platform? Platform { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="Authentication" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected Authentication() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="Authentication" /> class.
    /// </summary>
    /// <param name="authenticationID">The authentication UUID. (required).</param>
    /// <param name="type">type (required).</param>
    /// <param name="name">An human readable name describing the object. (required).</param>
    /// <param name="platform">platform.</param>
    /// <param name="input">input (required).</param>
    /// <param name="createdAt">Date of creation (RFC3339 format). (required).</param>
    /// <param name="updatedAt">Date of last update (RFC3339 format)..</param>
    public Authentication(string authenticationID = default(string), AuthenticationType type = default(AuthenticationType), string name = default(string), Platform? platform = default(Platform?), AuthInput input = default(AuthInput), string createdAt = default(string), string updatedAt = default(string))
    {
      // to ensure "authenticationID" is required (not null)
      if (authenticationID == null)
      {
        throw new ArgumentNullException("authenticationID is a required property for Authentication and cannot be null");
      }
      this.AuthenticationID = authenticationID;
      this.Type = type;
      // to ensure "name" is required (not null)
      if (name == null)
      {
        throw new ArgumentNullException("name is a required property for Authentication and cannot be null");
      }
      this.Name = name;
      // to ensure "input" is required (not null)
      if (input == null)
      {
        throw new ArgumentNullException("input is a required property for Authentication and cannot be null");
      }
      this.Input = input;
      // to ensure "createdAt" is required (not null)
      if (createdAt == null)
      {
        throw new ArgumentNullException("createdAt is a required property for Authentication and cannot be null");
      }
      this.CreatedAt = createdAt;
      this.Platform = platform;
      this.UpdatedAt = updatedAt;
    }

    /// <summary>
    /// The authentication UUID.
    /// </summary>
    /// <value>The authentication UUID.</value>
    [DataMember(Name = "authenticationID", IsRequired = true, EmitDefaultValue = true)]
    public string AuthenticationID { get; set; }

    /// <summary>
    /// An human readable name describing the object.
    /// </summary>
    /// <value>An human readable name describing the object.</value>
    [DataMember(Name = "name", IsRequired = true, EmitDefaultValue = true)]
    public string Name { get; set; }

    /// <summary>
    /// Gets or Sets Input
    /// </summary>
    [DataMember(Name = "input", IsRequired = true, EmitDefaultValue = true)]
    public AuthInput Input { get; set; }

    /// <summary>
    /// Date of creation (RFC3339 format).
    /// </summary>
    /// <value>Date of creation (RFC3339 format).</value>
    [DataMember(Name = "createdAt", IsRequired = true, EmitDefaultValue = true)]
    public string CreatedAt { get; set; }

    /// <summary>
    /// Date of last update (RFC3339 format).
    /// </summary>
    /// <value>Date of last update (RFC3339 format).</value>
    [DataMember(Name = "updatedAt", EmitDefaultValue = false)]
    public string UpdatedAt { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Authentication {\n");
      sb.Append("  AuthenticationID: ").Append(AuthenticationID).Append("\n");
      sb.Append("  Type: ").Append(Type).Append("\n");
      sb.Append("  Name: ").Append(Name).Append("\n");
      sb.Append("  Platform: ").Append(Platform).Append("\n");
      sb.Append("  Input: ").Append(Input).Append("\n");
      sb.Append("  CreatedAt: ").Append(CreatedAt).Append("\n");
      sb.Append("  UpdatedAt: ").Append(UpdatedAt).Append("\n");
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
      return this.Equals(input as Authentication);
    }

    /// <summary>
    /// Returns true if Authentication instances are equal
    /// </summary>
    /// <param name="input">Instance of Authentication to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(Authentication input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.AuthenticationID == input.AuthenticationID ||
              (this.AuthenticationID != null &&
              this.AuthenticationID.Equals(input.AuthenticationID))
          ) &&
          (
              this.Type == input.Type ||
              this.Type.Equals(input.Type)
          ) &&
          (
              this.Name == input.Name ||
              (this.Name != null &&
              this.Name.Equals(input.Name))
          ) &&
          (
              this.Platform == input.Platform ||
              this.Platform.Equals(input.Platform)
          ) &&
          (
              this.Input == input.Input ||
              (this.Input != null &&
              this.Input.Equals(input.Input))
          ) &&
          (
              this.CreatedAt == input.CreatedAt ||
              (this.CreatedAt != null &&
              this.CreatedAt.Equals(input.CreatedAt))
          ) &&
          (
              this.UpdatedAt == input.UpdatedAt ||
              (this.UpdatedAt != null &&
              this.UpdatedAt.Equals(input.UpdatedAt))
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
        if (this.AuthenticationID != null)
        {
          hashCode = (hashCode * 59) + this.AuthenticationID.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.Type.GetHashCode();
        if (this.Name != null)
        {
          hashCode = (hashCode * 59) + this.Name.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.Platform.GetHashCode();
        if (this.Input != null)
        {
          hashCode = (hashCode * 59) + this.Input.GetHashCode();
        }
        if (this.CreatedAt != null)
        {
          hashCode = (hashCode * 59) + this.CreatedAt.GetHashCode();
        }
        if (this.UpdatedAt != null)
        {
          hashCode = (hashCode * 59) + this.UpdatedAt.GetHashCode();
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
