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
/// List of available AI models for transformation purposes.
/// </summary>
public partial class TransformationModels
{
  /// <summary>
  /// Initializes a new instance of the TransformationModels class.
  /// </summary>
  [JsonConstructor]
  public TransformationModels() { }
  /// <summary>
  /// Initializes a new instance of the TransformationModels class.
  /// </summary>
  /// <param name="llms">llms (required).</param>
  public TransformationModels(List<Model> llms)
  {
    Llms = llms ?? throw new ArgumentNullException(nameof(llms));
  }

  /// <summary>
  /// Gets or Sets Llms
  /// </summary>
  [JsonPropertyName("llms")]
  public List<Model> Llms { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class TransformationModels {\n");
    sb.Append("  Llms: ").Append(Llms).Append("\n");
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
    if (obj is not TransformationModels input)
    {
      return false;
    }

    return
        (Llms == input.Llms || Llms != null && input.Llms != null && Llms.SequenceEqual(input.Llms));
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
      if (Llms != null)
      {
        hashCode = (hashCode * 59) + Llms.GetHashCode();
      }
      return hashCode;
    }
  }

}

