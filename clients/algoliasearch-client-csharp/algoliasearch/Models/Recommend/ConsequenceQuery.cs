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
using System.Reflection;
using Algolia.Search.Models;
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// When providing a string, it replaces the entire query string. When providing an object, it describes incremental edits to be made to the query string (but you can't do both).
/// </summary>
[JsonConverter(typeof(ConsequenceQueryJsonConverter))]
[DataContract(Name = "consequenceQuery")]
public partial class ConsequenceQuery : AbstractSchema
{
  /// <summary>
  /// Initializes a new instance of the ConsequenceQuery class
  /// with a ConsequenceQueryObject
  /// </summary>
  /// <param name="actualInstance">An instance of ConsequenceQueryObject.</param>
  public ConsequenceQuery(ConsequenceQueryObject actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the ConsequenceQuery class
  /// with a string
  /// </summary>
  /// <param name="actualInstance">An instance of string.</param>
  public ConsequenceQuery(string actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }


  /// <summary>
  /// Gets or Sets ActualInstance
  /// </summary>
  public sealed override object ActualInstance { get; set; }

  /// <summary>
  /// Get the actual instance of `ConsequenceQueryObject`. If the actual instance is not `ConsequenceQueryObject`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ConsequenceQueryObject</returns>
  public ConsequenceQueryObject AsConsequenceQueryObject()
  {
    return (ConsequenceQueryObject)ActualInstance;
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
  /// Check if the actual instance is of `ConsequenceQueryObject` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsConsequenceQueryObject()
  {
    return ActualInstance.GetType() == typeof(ConsequenceQueryObject);
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
    sb.Append("class ConsequenceQuery {\n");
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
    return JsonConvert.SerializeObject(ActualInstance, JsonConfig.AlgoliaJsonSerializerSettings);
  }

  /// <summary>
  /// Converts the JSON string into an instance of ConsequenceQuery
  /// </summary>
  /// <param name="jsonString">JSON string</param>
  /// <returns>An instance of ConsequenceQuery</returns>
  public static ConsequenceQuery FromJson(string jsonString)
  {
    var jToken = JToken.Parse(jsonString);
    if (jToken.Type == JTokenType.Object)
    {
      try
      {
        return new ConsequenceQuery(JsonConvert.DeserializeObject<ConsequenceQueryObject>(jsonString, JsonConfig.AlgoliaJsonSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into ConsequenceQueryObject: {exception}");
      }
    }
    if (jToken.Type == JTokenType.String)
    {
      try
      {
        return new ConsequenceQuery(JsonConvert.DeserializeObject<string>(jsonString, JsonConfig.AlgoliaJsonSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into string: {exception}");
      }
    }

    throw new InvalidDataException($"The JSON string `{jsonString}` cannot be deserialized into any schema defined.");
  }

}

/// <summary>
/// Custom JSON converter for ConsequenceQuery
/// </summary>
public class ConsequenceQueryJsonConverter : JsonConverter
{
  /// <summary>
  /// To write the JSON string
  /// </summary>
  /// <param name="writer">JSON writer</param>
  /// <param name="value">Object to be converted into a JSON string</param>
  /// <param name="serializer">JSON Serializer</param>
  public override void WriteJson(JsonWriter writer, object value, JsonSerializer serializer)
  {
    writer.WriteRawValue((string)value?.GetType().GetMethod("ToJson")?.Invoke(value, null));
  }

  /// <summary>
  /// To convert a JSON string into an object
  /// </summary>
  /// <param name="reader">JSON reader</param>
  /// <param name="objectType">Object type</param>
  /// <param name="existingValue">Existing value</param>
  /// <param name="serializer">JSON Serializer</param>
  /// <returns>The object converted from the JSON string</returns>
  public override object ReadJson(JsonReader reader, Type objectType, object existingValue, JsonSerializer serializer)
  {
    if (reader.TokenType != JsonToken.Null)
    {
      return objectType.GetMethod("FromJson")?.Invoke(null, new object[] { JToken.Load(reader).ToString(Formatting.None) });
    }
    return null;
  }

  /// <summary>
  /// Check if the object can be converted
  /// </summary>
  /// <param name="objectType">Object type</param>
  /// <returns>True if the object can be converted</returns>
  public override bool CanConvert(Type objectType)
  {
    return false;
  }
}

