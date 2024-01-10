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

namespace Algolia.Search.Models.Search
{
  /// <summary>
  /// SnippetResult
  /// </summary>
  [JsonConverter(typeof(SnippetResultJsonConverter))]
  [DataContract(Name = "snippetResult")]
  public partial class SnippetResult : AbstractSchema
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SnippetResult" /> class
    /// with the <see cref="SnippetResultOption" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of SnippetResultOption.</param>
    public SnippetResult(SnippetResultOption actualInstance)
    {
      IsNullable = false;
      SchemaType = "oneOf";
      ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
    }

    /// <summary>
    /// Initializes a new instance of the <see cref="SnippetResult" /> class
    /// with the <see cref="Dictionary{string, SnippetResultOption}" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of Dictionary&lt;string, SnippetResultOption&gt;.</param>
    public SnippetResult(Dictionary<string, SnippetResultOption> actualInstance)
    {
      IsNullable = false;
      SchemaType = "oneOf";
      ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
    }


    private Object _actualInstance;

    /// <summary>
    /// Gets or Sets ActualInstance
    /// </summary>
    public override Object ActualInstance
    {
      get
      {
        return _actualInstance;
      }
      set
      {
        this._actualInstance = value;
      }
    }

    /// <summary>
    /// Get the actual instance of `SnippetResultOption`. If the actual instance is not `SnippetResultOption`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of SnippetResultOption</returns>
    public SnippetResultOption AsSnippetResultOption()
    {
      return (SnippetResultOption)ActualInstance;
    }

    /// <summary>
    /// Get the actual instance of `Dictionary&lt;string, SnippetResultOption&gt;`. If the actual instance is not `Dictionary&lt;string, SnippetResultOption&gt;`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of Dictionary&lt;string, SnippetResultOption&gt;</returns>
    public Dictionary<string, SnippetResultOption> AsDictionary()
    {
      return (Dictionary<string, SnippetResultOption>)ActualInstance;
    }


    /// <summary>
    /// Check if the actual instance is of `SnippetResultOption` type.
    /// </summary>
    /// <returns>Whether or not the instance is the type</returns>
    public bool IsSnippetResultOption()
    {
      return ActualInstance.GetType() == typeof(SnippetResultOption);
    }

    /// <summary>
    /// Check if the actual instance is of `Dictionary&lt;string, SnippetResultOption&gt;` type.
    /// </summary>
    /// <returns>Whether or not the instance is the type</returns>
    public bool IsDictionary()
    {
      return ActualInstance.GetType() == typeof(Dictionary<string, SnippetResultOption>);
    }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      var sb = new StringBuilder();
      sb.Append("class SnippetResult {\n");
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
      return JsonConvert.SerializeObject(ActualInstance, SerializerSettings);
    }

    /// <summary>
    /// Converts the JSON string into an instance of SnippetResult
    /// </summary>
    /// <param name="jsonString">JSON string</param>
    /// <returns>An instance of SnippetResult</returns>
    public static SnippetResult FromJson(string jsonString)
    {
      SnippetResult newSnippetResult = null;

      if (string.IsNullOrEmpty(jsonString))
      {
        return newSnippetResult;
      }
      try
      {
        return new SnippetResult(JsonConvert.DeserializeObject<SnippetResultOption>(jsonString, AdditionalPropertiesSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into SnippetResultOption: {1}", jsonString, exception.ToString()));
      }
      try
      {
        return new SnippetResult(JsonConvert.DeserializeObject<Dictionary<string, SnippetResultOption>>(jsonString, AdditionalPropertiesSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into Dictionary<string, SnippetResultOption>: {1}", jsonString, exception.ToString()));
      }

      throw new InvalidDataException("The JSON string `" + jsonString + "` cannot be deserialized into any schema defined.");
    }

  }

  /// <summary>
  /// Custom JSON converter for SnippetResult
  /// </summary>
  public class SnippetResultJsonConverter : JsonConverter
  {
    /// <summary>
    /// To write the JSON string
    /// </summary>
    /// <param name="writer">JSON writer</param>
    /// <param name="value">Object to be converted into a JSON string</param>
    /// <param name="serializer">JSON Serializer</param>
    public override void WriteJson(JsonWriter writer, object value, JsonSerializer serializer)
    {
      writer.WriteRawValue((string)(typeof(SnippetResult).GetMethod("ToJson").Invoke(value, null)));
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
        return objectType.GetMethod("FromJson").Invoke(null, new[] { JObject.Load(reader).ToString(Formatting.None) });
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

}
