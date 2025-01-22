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

namespace Algolia.Search.Models.Composition;

/// <summary>
/// ResultsCompositionInfoResponse
/// </summary>
public partial class ResultsCompositionInfoResponse
{
  /// <summary>
  /// Initializes a new instance of the ResultsCompositionInfoResponse class.
  /// </summary>
  [JsonConstructor]
  public ResultsCompositionInfoResponse() { }
  /// <summary>
  /// Initializes a new instance of the ResultsCompositionInfoResponse class.
  /// </summary>
  /// <param name="injectedItems">injectedItems (required).</param>
  public ResultsCompositionInfoResponse(List<ResultsInjectedItemInfoResponse> injectedItems)
  {
    InjectedItems = injectedItems ?? throw new ArgumentNullException(nameof(injectedItems));
  }

  /// <summary>
  /// Gets or Sets InjectedItems
  /// </summary>
  [JsonPropertyName("injectedItems")]
  public List<ResultsInjectedItemInfoResponse> InjectedItems { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ResultsCompositionInfoResponse {\n");
    sb.Append("  InjectedItems: ").Append(InjectedItems).Append("\n");
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
    if (obj is not ResultsCompositionInfoResponse input)
    {
      return false;
    }

    return
        (InjectedItems == input.InjectedItems || InjectedItems != null && input.InjectedItems != null && InjectedItems.SequenceEqual(input.InjectedItems));
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
      if (InjectedItems != null)
      {
        hashCode = (hashCode * 59) + InjectedItems.GetHashCode();
      }
      return hashCode;
    }
  }

}

