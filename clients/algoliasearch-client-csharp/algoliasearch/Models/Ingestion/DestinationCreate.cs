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
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// The payload when creating a destination.
/// </summary>
[DataContract(Name = "DestinationCreate")]
[JsonObject(MemberSerialization.OptOut)]
public partial class DestinationCreate
{

  /// <summary>
  /// Gets or Sets Type
  /// </summary>
  [DataMember(Name = "type", IsRequired = true, EmitDefaultValue = false)]
  public DestinationType Type { get; set; }
  /// <summary>
  /// Initializes a new instance of the DestinationCreate class.
  /// </summary>
  [JsonConstructor]
  public DestinationCreate() { }
  /// <summary>
  /// Initializes a new instance of the DestinationCreate class.
  /// </summary>
  /// <param name="type">type (required).</param>
  /// <param name="name">An human readable name describing the object. (required).</param>
  /// <param name="input">input (required).</param>
  public DestinationCreate(DestinationType type, string name, DestinationInput input)
  {
    Type = type;
    Name = name ?? throw new ArgumentNullException(nameof(name));
    Input = input ?? throw new ArgumentNullException(nameof(input));
  }

  /// <summary>
  /// An human readable name describing the object.
  /// </summary>
  /// <value>An human readable name describing the object.</value>
  [DataMember(Name = "name", IsRequired = true, EmitDefaultValue = false)]
  public string Name { get; set; }

  /// <summary>
  /// Gets or Sets Input
  /// </summary>
  [DataMember(Name = "input", IsRequired = true, EmitDefaultValue = false)]
  public DestinationInput Input { get; set; }

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
    sb.Append("class DestinationCreate {\n");
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
    return JsonConvert.SerializeObject(this, Formatting.Indented);
  }

}

