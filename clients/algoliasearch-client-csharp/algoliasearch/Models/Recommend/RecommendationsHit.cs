//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// RecommendationsHit
/// </summary>
[JsonConverter(typeof(RecommendationsHitJsonConverter))]
public partial class RecommendationsHit : AbstractSchema
{
  /// <summary>
  /// Initializes a new instance of the RecommendationsHit class
  /// with a TrendingFacetHit
  /// </summary>
  /// <param name="actualInstance">An instance of TrendingFacetHit.</param>
  public RecommendationsHit(TrendingFacetHit actualInstance)
  {
    ActualInstance =
      actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the RecommendationsHit class
  /// with a RecommendHit
  /// </summary>
  /// <param name="actualInstance">An instance of RecommendHit.</param>
  public RecommendationsHit(RecommendHit actualInstance)
  {
    ActualInstance =
      actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Gets or Sets ActualInstance
  /// </summary>
  public sealed override object ActualInstance { get; set; }

  /// <summary>
  /// Get the actual instance of `TrendingFacetHit`. If the actual instance is not `TrendingFacetHit`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of TrendingFacetHit</returns>
  public TrendingFacetHit AsTrendingFacetHit()
  {
    return (TrendingFacetHit)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `RecommendHit`. If the actual instance is not `RecommendHit`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of RecommendHit</returns>
  public RecommendHit AsRecommendHit()
  {
    return (RecommendHit)ActualInstance;
  }

  /// <summary>
  /// Check if the actual instance is of `TrendingFacetHit` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsTrendingFacetHit()
  {
    return ActualInstance.GetType() == typeof(TrendingFacetHit);
  }

  /// <summary>
  /// Check if the actual instance is of `RecommendHit` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsRecommendHit()
  {
    return ActualInstance.GetType() == typeof(RecommendHit);
  }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    var sb = new StringBuilder();
    sb.Append("class RecommendationsHit {\n");
    sb.Append("  ActualInstance: ").Append(ActualInstance).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public override string ToJson()
  {
    return JsonSerializer.Serialize(ActualInstance, JsonConfig.Options);
  }

  /// <summary>
  /// Returns true if objects are equal
  /// </summary>
  /// <param name="obj">Object to be compared</param>
  /// <returns>Boolean</returns>
  public override bool Equals(object obj)
  {
    if (obj is not RecommendationsHit input)
    {
      return false;
    }

    return ActualInstance.Equals(input.ActualInstance);
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
      if (ActualInstance != null)
        hashCode = hashCode * 59 + ActualInstance.GetHashCode();
      return hashCode;
    }
  }
}

/// <summary>
/// Custom JSON converter for RecommendationsHit
/// </summary>
public class RecommendationsHitJsonConverter : JsonConverter<RecommendationsHit>
{
  /// <summary>
  /// Check if the object can be converted
  /// </summary>
  /// <param name="objectType">Object type</param>
  /// <returns>True if the object can be converted</returns>
  public override bool CanConvert(Type objectType)
  {
    return objectType == typeof(RecommendationsHit);
  }

  /// <summary>
  /// To convert a JSON string into an object
  /// </summary>
  /// <param name="reader">JSON reader</param>
  /// <param name="typeToConvert">Object type</param>
  /// <param name="options">Serializer options</param>
  /// <returns>The object converted from the JSON string</returns>
  public override RecommendationsHit Read(
    ref Utf8JsonReader reader,
    Type typeToConvert,
    JsonSerializerOptions options
  )
  {
    var jsonDocument = JsonDocument.ParseValue(ref reader);
    var root = jsonDocument.RootElement;
    if (
      root.ValueKind == JsonValueKind.Object
      && root.TryGetProperty("facetName", out _)
      && root.TryGetProperty("facetValue", out _)
    )
    {
      try
      {
        return new RecommendationsHit(
          jsonDocument.Deserialize<TrendingFacetHit>(JsonConfig.Options)
        );
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(
          $"Failed to deserialize into TrendingFacetHit: {exception}"
        );
      }
    }
    if (root.ValueKind == JsonValueKind.Object)
    {
      try
      {
        return new RecommendationsHit(jsonDocument.Deserialize<RecommendHit>(JsonConfig.Options));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize into RecommendHit: {exception}");
      }
    }
    throw new InvalidDataException(
      $"The JSON string cannot be deserialized into any schema defined."
    );
  }

  /// <summary>
  /// To write the JSON string
  /// </summary>
  /// <param name="writer">JSON writer</param>
  /// <param name="value">RecommendationsHit to be converted into a JSON string</param>
  /// <param name="options">JSON Serializer options</param>
  public override void Write(
    Utf8JsonWriter writer,
    RecommendationsHit value,
    JsonSerializerOptions options
  )
  {
    writer.WriteRawValue(value.ToJson());
  }
}
