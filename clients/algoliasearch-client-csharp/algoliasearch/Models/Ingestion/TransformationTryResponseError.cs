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

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// The error if the transformation failed.
/// </summary>
public partial class TransformationTryResponseError
{
  /// <summary>
  /// Initializes a new instance of the TransformationTryResponseError class.
  /// </summary>
  public TransformationTryResponseError()
  {
  }

  /// <summary>
  /// The error status code.
  /// </summary>
  /// <value>The error status code.</value>
  [JsonPropertyName("code")]
  public int? Code { get; set; }

  /// <summary>
  /// A descriptive message explaining the failure.
  /// </summary>
  /// <value>A descriptive message explaining the failure.</value>
  [JsonPropertyName("message")]
  public string Message { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class TransformationTryResponseError {\n");
    sb.Append("  Code: ").Append(Code).Append("\n");
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
    return JsonSerializer.Serialize(this, JsonConfig.Options);
  }

  /// <summary>
  /// Returns true if objects are equal
  /// </summary>
  /// <param name="obj">Object to be compared</param>
  /// <returns>Boolean</returns>
  public override bool Equals(object obj)
  {
    if (obj is not TransformationTryResponseError input)
    {
      return false;
    }

    return
        (Code == input.Code || Code.Equals(input.Code)) &&
        (Message == input.Message || (Message != null && Message.Equals(input.Message)));
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
      hashCode = (hashCode * 59) + Code.GetHashCode();
      if (Message != null)
      {
        hashCode = (hashCode * 59) + Message.GetHashCode();
      }
      return hashCode;
    }
  }

}

