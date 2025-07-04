//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// Input for a transformation that contains the source code of the transformation.
/// </summary>
public partial class TransformationCode
{
  /// <summary>
  /// Initializes a new instance of the TransformationCode class.
  /// </summary>
  [JsonConstructor]
  public TransformationCode() { }

  /// <summary>
  /// Initializes a new instance of the TransformationCode class.
  /// </summary>
  /// <param name="code">The source code of the transformation. (required).</param>
  public TransformationCode(string code)
  {
    Code = code ?? throw new ArgumentNullException(nameof(code));
  }

  /// <summary>
  /// The source code of the transformation.
  /// </summary>
  /// <value>The source code of the transformation.</value>
  [JsonPropertyName("code")]
  public string Code { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class TransformationCode {\n");
    sb.Append("  Code: ").Append(Code).Append("\n");
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
    if (obj is not TransformationCode input)
    {
      return false;
    }

    return (Code == input.Code || (Code != null && Code.Equals(input.Code)));
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
      if (Code != null)
      {
        hashCode = (hashCode * 59) + Code.GetHashCode();
      }
      return hashCode;
    }
  }
}
