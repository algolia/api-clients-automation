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

namespace Algolia.Search.Models.Ingestion
{
  /// <summary>
  /// SourceCreate
  /// </summary>
  [DataContract(Name = "SourceCreate")]
  [JsonObject(MemberSerialization.OptOut)]
  public partial class SourceCreate
  {

    /// <summary>
    /// Gets or Sets Type
    /// </summary>
    [DataMember(Name = "type", IsRequired = true, EmitDefaultValue = false)]
    public SourceType Type { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="SourceCreate" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public SourceCreate() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="SourceCreate" /> class.
    /// </summary>
    /// <param name="type">type (required).</param>
    /// <param name="name">name (required).</param>
    /// <param name="input">input (required).</param>
    public SourceCreate(SourceType type, string name, SourceInput input)
    {
      this.Type = type;
      this.Name = name ?? throw new ArgumentNullException("name is a required property for SourceCreate and cannot be null");
      this.Input = input ?? throw new ArgumentNullException("input is a required property for SourceCreate and cannot be null");
    }

    /// <summary>
    /// Gets or Sets Name
    /// </summary>
    [DataMember(Name = "name", IsRequired = true, EmitDefaultValue = false)]
    public string Name { get; set; }

    /// <summary>
    /// Gets or Sets Input
    /// </summary>
    [DataMember(Name = "input", IsRequired = true, EmitDefaultValue = false)]
    public SourceInput Input { get; set; }

    /// <summary>
    /// The authentication UUID.
    /// </summary>
    /// <value>The authentication UUID.</value>
    [DataMember(Name = "authenticationID", EmitDefaultValue = false)]
    public string AuthenticationID { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SourceCreate {\n");
      sb.Append("  Type: ").Append(Type).Append("\n");
      sb.Append("  Name: ").Append(Name).Append("\n");
      sb.Append("  Input: ").Append(Input).Append("\n");
      sb.Append("  AuthenticationID: ").Append(AuthenticationID).Append("\n");
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
