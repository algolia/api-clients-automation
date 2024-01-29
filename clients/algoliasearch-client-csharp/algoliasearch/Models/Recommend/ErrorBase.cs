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

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// Error.
/// </summary>
[DataContract(Name = "ErrorBase")]
[JsonObject(MemberSerialization.OptOut)]
public partial class ErrorBase
{
  /// <summary>
  /// Initializes a new instance of the ErrorBase class.
  /// </summary>
  public ErrorBase()
  {
    AdditionalProperties = new Dictionary<string, object>();
  }

  /// <summary>
  /// Gets or Sets Message
  /// </summary>
  [DataMember(Name = "message", EmitDefaultValue = false)]
  public string Message { get; set; }

  /// <summary>
  /// Gets or Sets additional properties
  /// </summary>
  [JsonExtensionData]
  public IDictionary<string, object> AdditionalProperties { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ErrorBase {\n");
    sb.Append("  Message: ").Append(Message).Append("\n");
    sb.Append("  AdditionalProperties: ").Append(AdditionalProperties).Append("\n");
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

