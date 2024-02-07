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

namespace Algolia.Search.Models.Personalization;

/// <summary>
/// SetPersonalizationStrategyResponse
/// </summary>
[DataContract(Name = "setPersonalizationStrategyResponse")]
[JsonObject(MemberSerialization.OptOut)]
public partial class SetPersonalizationStrategyResponse
{
  /// <summary>
  /// Initializes a new instance of the SetPersonalizationStrategyResponse class.
  /// </summary>
  [JsonConstructor]
  public SetPersonalizationStrategyResponse() { }
  /// <summary>
  /// Initializes a new instance of the SetPersonalizationStrategyResponse class.
  /// </summary>
  /// <param name="message">A message confirming the strategy update. (required).</param>
  public SetPersonalizationStrategyResponse(string message)
  {
    Message = message ?? throw new ArgumentNullException(nameof(message));
  }

  /// <summary>
  /// A message confirming the strategy update.
  /// </summary>
  /// <value>A message confirming the strategy update.</value>
  [DataMember(Name = "message")]
  public string Message { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SetPersonalizationStrategyResponse {\n");
    sb.Append("  Message: ").Append(Message).Append("\n");
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

