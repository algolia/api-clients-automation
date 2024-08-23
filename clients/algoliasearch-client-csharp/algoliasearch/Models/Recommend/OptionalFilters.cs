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
using System.IO;
using System.Reflection;
using Algolia.Search.Models.Common;

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// Filters to promote or demote records in the search results.  Optional filters work like facet filters, but they don't exclude records from the search results. Records that match the optional filter rank before records that don't match. If you're using a negative filter `facet:-value`, matching records rank after records that don't match.  - Optional filters don't work on virtual replicas. - Optional filters are applied _after_ sort-by attributes. - Optional filters don't work with numeric attributes. 
/// </summary>
[JsonConverter(typeof(OptionalFiltersJsonConverter))]
public partial class OptionalFilters : AbstractSchema
{
  /// <summary>
  /// Initializes a new instance of the OptionalFilters class
  /// with a List{OptionalFilters}
  /// </summary>
  /// <param name="actualInstance">An instance of List&lt;OptionalFilters&gt;.</param>
  public OptionalFilters(List<OptionalFilters> actualInstance)
  {
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the OptionalFilters class
  /// with a string
  /// </summary>
  /// <param name="actualInstance">An instance of string.</param>
  public OptionalFilters(string actualInstance)
  {
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }


  /// <summary>
  /// Gets or Sets ActualInstance
  /// </summary>
  public sealed override object ActualInstance { get; set; }

  /// <summary>
  /// Get the actual instance of `List{OptionalFilters}`. If the actual instance is not `List{OptionalFilters}`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of List&lt;OptionalFilters&gt;</returns>
  public List<OptionalFilters> AsListOptionalFilters()
  {
    return (List<OptionalFilters>)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `string`. If the actual instance is not `string`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of string</returns>
  public string AsString()
  {
    return (string)ActualInstance;
  }


  /// <summary>
  /// Check if the actual instance is of `List{OptionalFilters}` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsListOptionalFilters()
  {
    return ActualInstance.GetType() == typeof(List<OptionalFilters>);
  }

  /// <summary>
  /// Check if the actual instance is of `string` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsString()
  {
    return ActualInstance.GetType() == typeof(string);
  }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    var sb = new StringBuilder();
    sb.Append("class OptionalFilters {\n");
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
    if (obj is not OptionalFilters input)
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
/// Custom JSON converter for OptionalFilters
/// </summary>
public class OptionalFiltersJsonConverter : JsonConverter<OptionalFilters>
{

  /// <summary>
  /// Check if the object can be converted
  /// </summary>
  /// <param name="objectType">Object type</param>
  /// <returns>True if the object can be converted</returns>
  public override bool CanConvert(Type objectType)
  {
    return objectType == typeof(OptionalFilters);
  }

  /// <summary>
  /// To convert a JSON string into an object
  /// </summary>
  /// <param name="reader">JSON reader</param>
  /// <param name="typeToConvert">Object type</param>
  /// <param name="options">Serializer options</param>
  /// <returns>The object converted from the JSON string</returns>
  public override OptionalFilters Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
  {
    var jsonDocument = JsonDocument.ParseValue(ref reader);
    var root = jsonDocument.RootElement;
    if (root.ValueKind == JsonValueKind.Array)
    {
      try
      {
        return new OptionalFilters(jsonDocument.Deserialize<List<OptionalFilters>>(JsonConfig.Options));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize into List<OptionalFilters>: {exception}");
      }
    }
    if (root.ValueKind == JsonValueKind.String)
    {
      try
      {
        return new OptionalFilters(jsonDocument.Deserialize<string>(JsonConfig.Options));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize into string: {exception}");
      }
    }
    throw new InvalidDataException($"The JSON string cannot be deserialized into any schema defined.");
  }

  /// <summary>
  /// To write the JSON string
  /// </summary>
  /// <param name="writer">JSON writer</param>
  /// <param name="value">OptionalFilters to be converted into a JSON string</param>
  /// <param name="options">JSON Serializer options</param>
  public override void Write(Utf8JsonWriter writer, OptionalFilters value, JsonSerializerOptions options)
  {
    writer.WriteRawValue(value.ToJson());
  }
}

