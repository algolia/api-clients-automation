//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Text;
using System.Linq;
using System.Text.Json.Serialization;
using System.Collections.Generic;
using Algolia.Search.Serializer;
using System.Text.Json;

namespace Algolia.Search.Models.Search;

/// <summary>
/// Update to perform on the attribute.
/// </summary>
public partial class BuiltInOperation
{

  /// <summary>
  /// Gets or Sets Operation
  /// </summary>
  [JsonPropertyName("_operation")]
  public BuiltInOperationType? Operation { get; set; }
  /// <summary>
  /// Initializes a new instance of the BuiltInOperation class.
  /// </summary>
  [JsonConstructor]
  public BuiltInOperation() { }
  /// <summary>
  /// Initializes a new instance of the BuiltInOperation class.
  /// </summary>
  /// <param name="operation">operation (required).</param>
  /// <param name="value">Value that corresponds to the operation, for example an &#x60;Increment&#x60; or &#x60;Decrement&#x60; step, or an &#x60;Add&#x60; or &#x60;Remove&#x60; value. (required).</param>
  public BuiltInOperation(BuiltInOperationType? operation, string value)
  {
    Operation = operation;
    Value = value ?? throw new ArgumentNullException(nameof(value));
  }

  /// <summary>
  /// Value that corresponds to the operation, for example an `Increment` or `Decrement` step, or an `Add` or `Remove` value.
  /// </summary>
  /// <value>Value that corresponds to the operation, for example an `Increment` or `Decrement` step, or an `Add` or `Remove` value.</value>
  [JsonPropertyName("value")]
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
    return JsonSerializer.Serialize(this, JsonConfig.Options);
  }

  /// <summary>
  /// Returns true if objects are equal
  /// </summary>
  /// <param name="obj">Object to be compared</param>
  /// <returns>Boolean</returns>
  public override bool Equals(object obj)
  {
    if (obj is not BuiltInOperation input)
    {
      return false;
    }

    return
        (Operation == input.Operation || Operation.Equals(input.Operation)) &&
        (Value == input.Value || (Value != null && Value.Equals(input.Value)));
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
      hashCode = (hashCode * 59) + Operation.GetHashCode();
      if (Value != null)
      {
        hashCode = (hashCode * 59) + Value.GetHashCode();
      }
      return hashCode;
    }
  }

}

