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
/// Authentication input used for token credentials.
/// </summary>
[DataContract(Name = "AuthAPIKeyPartial")]
[JsonObject(MemberSerialization.OptOut)]
public partial class AuthAPIKeyPartial
{
  /// <summary>
  /// Initializes a new instance of the AuthAPIKeyPartial class.
  /// </summary>
  public AuthAPIKeyPartial()
  {
  }

  /// <summary>
  /// Gets or Sets Key
  /// </summary>
  [DataMember(Name = "key")]
  public string? Key { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class AuthAPIKeyPartial {\n");
    sb.Append("  Key: ").Append(Key).Append("\n");
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

