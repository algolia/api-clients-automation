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
/// ListApiKeysResponse
/// </summary>
[DataContract(Name = "listApiKeysResponse")]
[JsonObject(MemberSerialization.OptOut)]
public partial class ListApiKeysResponse
{
  /// <summary>
  /// Initializes a new instance of the ListApiKeysResponse class.
  /// </summary>
  [JsonConstructor]
  public ListApiKeysResponse() { }
  /// <summary>
  /// Initializes a new instance of the ListApiKeysResponse class.
  /// </summary>
  /// <param name="keys">API keys. (required).</param>
  public ListApiKeysResponse(List<GetApiKeyResponse> keys)
  {
    Keys = keys ?? throw new ArgumentNullException(nameof(keys));
  }

  /// <summary>
  /// API keys.
  /// </summary>
  /// <value>API keys.</value>
  [DataMember(Name = "keys", IsRequired = true, EmitDefaultValue = false)]
  public List<GetApiKeyResponse> Keys { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ListApiKeysResponse {\n");
    sb.Append("  Keys: ").Append(Keys).Append("\n");
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

