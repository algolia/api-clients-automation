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
/// To update an attribute without pushing the entire record, you can use these built-in operations.
/// </summary>
[DataContract(Name = "builtInOperation")]
public partial class BuiltInOperation
{

  /// <summary>
  /// Gets or Sets Operation
  /// </summary>
  [DataMember(Name = "_operation")]
  public BuiltInOperationType Operation { get; set; }
  /// <summary>
  /// Initializes a new instance of the BuiltInOperation class.
  /// </summary>
  [JsonConstructor]
  public BuiltInOperation() { }
  /// <summary>
  /// Initializes a new instance of the BuiltInOperation class.
  /// </summary>
  /// <param name="operation">operation (required).</param>
  /// <param name="value">Value that corresponds to the operation, for example an &#x60;Increment&#x60; or &#x60;Decrement&#x60; step, &#x60;Add&#x60; or &#x60;Remove&#x60; value. (required).</param>
  public BuiltInOperation(BuiltInOperationType operation, string value)
  {
    Operation = operation;
    Value = value ?? throw new ArgumentNullException(nameof(value));
  }

  /// <summary>
  /// Value that corresponds to the operation, for example an `Increment` or `Decrement` step, `Add` or `Remove` value.
  /// </summary>
  /// <value>Value that corresponds to the operation, for example an `Increment` or `Decrement` step, `Add` or `Remove` value.</value>
  [DataMember(Name = "value")]
  public string Value { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class BuiltInOperation {\n");
    sb.Append("  Operation: ").Append(Operation).Append("\n");
    sb.Append("  Value: ").Append(Value).Append("\n");
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

