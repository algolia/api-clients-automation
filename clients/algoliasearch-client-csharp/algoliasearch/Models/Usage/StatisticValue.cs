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

namespace Algolia.Search.Models.Usage;

/// <summary>
/// StatisticValue
/// </summary>
[JsonConverter(typeof(StatisticValueJsonConverter))]
public partial class StatisticValue : AbstractSchema
{
  /// <summary>
  /// Initializes a new instance of the StatisticValue class
  /// with a int
  /// </summary>
  /// <param name="actualInstance">An instance of int.</param>
  public StatisticValue(int actualInstance)
  {
    ActualInstance = actualInstance;
  }

  /// <summary>
  /// Initializes a new instance of the StatisticValue class
  /// with a Dictionary{string, int}
  /// </summary>
  /// <param name="actualInstance">An instance of Dictionary&lt;string, int&gt;.</param>
  public StatisticValue(Dictionary<string, int> actualInstance)
  {
    ActualInstance = actualInstance;
  }


  /// <summary>
  /// Gets or Sets ActualInstance
  /// </summary>
  public sealed override object ActualInstance { get; set; }

  /// <summary>
  /// Get the actual instance of `int`. If the actual instance is not `int`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of int</returns>
  public int AsInt()
  {
    return (int)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `Dictionary{string, int}`. If the actual instance is not `Dictionary{string, int}`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of Dictionary&lt;string, int&gt;</returns>
  public Dictionary<string, int> AsDictionary()
  {
    return (Dictionary<string, int>)ActualInstance;
  }


  /// <summary>
  /// Check if the actual instance is of `int` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsInt()
  {
    return ActualInstance.GetType() == typeof(int);
  }

  /// <summary>
  /// Check if the actual instance is of `Dictionary{string, int}` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsDictionary()
  {
    return ActualInstance.GetType() == typeof(Dictionary<string, int>);
  }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    var sb = new StringBuilder();
    sb.Append("class StatisticValue {\n");
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
    if (obj is not StatisticValue input)
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
/// Custom JSON converter for StatisticValue
/// </summary>
public class StatisticValueJsonConverter : JsonConverter<StatisticValue>
{

  /// <summary>
  /// Check if the object can be converted
  /// </summary>
  /// <param name="objectType">Object type</param>
  /// <returns>True if the object can be converted</returns>
  public override bool CanConvert(Type objectType)
  {
    return objectType == typeof(StatisticValue);
  }

  /// <summary>
  /// To convert a JSON string into an object
  /// </summary>
  /// <param name="reader">JSON reader</param>
  /// <param name="typeToConvert">Object type</param>
  /// <param name="options">Serializer options</param>
  /// <returns>The object converted from the JSON string</returns>
  public override StatisticValue Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
  {
    var jsonDocument = JsonDocument.ParseValue(ref reader);
    var root = jsonDocument.RootElement;
    if (root.ValueKind == JsonValueKind.Number)
    {
      try
      {
        return new StatisticValue(jsonDocument.Deserialize<int>(JsonConfig.Options));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize into int: {exception}");
      }
    }
    if (root.ValueKind == JsonValueKind.Object)
    {
      try
      {
        return new StatisticValue(jsonDocument.Deserialize<Dictionary<string, int>>(JsonConfig.Options));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize into Dictionary<string, int>: {exception}");
      }
    }
    throw new InvalidDataException($"The JSON string cannot be deserialized into any schema defined.");
  }

  /// <summary>
  /// To write the JSON string
  /// </summary>
  /// <param name="writer">JSON writer</param>
  /// <param name="value">StatisticValue to be converted into a JSON string</param>
  /// <param name="options">JSON Serializer options</param>
  public override void Write(Utf8JsonWriter writer, StatisticValue value, JsonSerializerOptions options)
  {
    writer.WriteRawValue(value.ToJson());
  }
}

