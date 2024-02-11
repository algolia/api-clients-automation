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

namespace Algolia.Search.Models.Search;

/// <summary>
/// AddApiKeyResponse
/// </summary>
[DataContract(Name = "addApiKeyResponse")]
public partial class AddApiKeyResponse
{
  /// <summary>
  /// Initializes a new instance of the AddApiKeyResponse class.
  /// </summary>
  [JsonConstructor]
  public AddApiKeyResponse() { }
  /// <summary>
  /// Initializes a new instance of the AddApiKeyResponse class.
  /// </summary>
  /// <param name="key">API key. (required).</param>
  /// <param name="createdAt">Timestamp of creation in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
  public AddApiKeyResponse(string key, string createdAt)
  {
    Key = key ?? throw new ArgumentNullException(nameof(key));
    CreatedAt = createdAt ?? throw new ArgumentNullException(nameof(createdAt));
  }

  /// <summary>
  /// API key.
  /// </summary>
  /// <value>API key.</value>
  [DataMember(Name = "key")]
  public string Key { get; set; }

  /// <summary>
  /// Timestamp of creation in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.
  /// </summary>
  /// <value>Timestamp of creation in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
  [DataMember(Name = "createdAt")]
  public string CreatedAt { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class AddApiKeyResponse {\n");
    sb.Append("  Key: ").Append(Key).Append("\n");
    sb.Append("  CreatedAt: ").Append(CreatedAt).Append("\n");
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

