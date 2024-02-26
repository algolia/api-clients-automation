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
/// Payload to partially update an Authentication.
/// </summary>
public partial class AuthenticationUpdate
{

  /// <summary>
  /// Gets or Sets Type
  /// </summary>
  [JsonPropertyName("type")]
  public AuthenticationType? Type { get; set; }

  /// <summary>
  /// Gets or Sets Platform
  /// </summary>
  [JsonPropertyName("platform")]
  public Platform? Platform { get; set; }
  /// <summary>
  /// Initializes a new instance of the AuthenticationUpdate class.
  /// </summary>
  public AuthenticationUpdate()
  {
  }

  /// <summary>
  /// An human readable name describing the object.
  /// </summary>
  /// <value>An human readable name describing the object.</value>
  [JsonPropertyName("name")]
  public string Name { get; set; }

  /// <summary>
  /// Gets or Sets Input
  /// </summary>
  [JsonPropertyName("input")]
  public AuthInputPartial Input { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class AuthenticationUpdate {\n");
    sb.Append("  Type: ").Append(Type).Append("\n");
    sb.Append("  Name: ").Append(Name).Append("\n");
    sb.Append("  Platform: ").Append(Platform).Append("\n");
    sb.Append("  Input: ").Append(Input).Append("\n");
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
    if (obj is not AuthenticationUpdate input)
    {
      return false;
    }

    return
        (Type == input.Type || Type.Equals(input.Type)) &&
        (Name == input.Name || (Name != null && Name.Equals(input.Name))) &&
        (Platform == input.Platform || Platform.Equals(input.Platform)) &&
        (Input == input.Input || (Input != null && Input.Equals(input.Input)));
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
      hashCode = (hashCode * 59) + Type.GetHashCode();
      if (Name != null)
      {
        hashCode = (hashCode * 59) + Name.GetHashCode();
      }
      hashCode = (hashCode * 59) + Platform.GetHashCode();
      if (Input != null)
      {
        hashCode = (hashCode * 59) + Input.GetHashCode();
      }
      return hashCode;
    }
  }

}

