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

namespace Algolia.Search.Ingestion.Models
{
  /// <summary>
  /// DestinationInput
  /// </summary>
  [JsonConverter(typeof(DestinationInputJsonConverter))]
  [DataContract(Name = "DestinationInput")]
  public partial class DestinationInput : AbstractSchema
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="DestinationInput" /> class
    /// with the <see cref="DestinationIndexPrefix" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of DestinationIndexPrefix.</param>
    public DestinationInput(DestinationIndexPrefix actualInstance)
    {
      this.IsNullable = false;
      this.SchemaType = "oneOf";
      this.ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
    }

    /// <summary>
    /// Initializes a new instance of the <see cref="DestinationInput" /> class
    /// with the <see cref="DestinationIndexName" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of DestinationIndexName.</param>
    public DestinationInput(DestinationIndexName actualInstance)
    {
      this.IsNullable = false;
      this.SchemaType = "oneOf";
      this.ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
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
        if (value.GetType() == typeof(DestinationIndexName))
        {
          this._actualInstance = value;
        }
        else if (value.GetType() == typeof(DestinationIndexPrefix))
        {
          this._actualInstance = value;
        }
        else
        {
          throw new ArgumentException("Invalid instance found. Must be the following types: DestinationIndexName, DestinationIndexPrefix");
        }
      }
    }

    /// <summary>
    /// Get the actual instance of `DestinationIndexPrefix`. If the actual instance is not `DestinationIndexPrefix`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of DestinationIndexPrefix</returns>
    public DestinationIndexPrefix GetterDestinationIndexPrefix()
    {
      return (DestinationIndexPrefix)this.ActualInstance;
    }

    /// <summary>
    /// Get the actual instance of `DestinationIndexName`. If the actual instance is not `DestinationIndexName`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of DestinationIndexName</returns>
    public DestinationIndexName GetterDestinationIndexName()
    {
      return (DestinationIndexName)this.ActualInstance;
    }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      var sb = new StringBuilder();
      sb.Append("class DestinationInput {\n");
      sb.Append("  ActualInstance: ").Append(this.ActualInstance).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public override string ToJson()
    {
      return JsonConvert.SerializeObject(this.ActualInstance, DestinationInput.SerializerSettings);
    }

    /// <summary>
    /// Converts the JSON string into an instance of DestinationInput
    /// </summary>
    /// <param name="jsonString">JSON string</param>
    /// <returns>An instance of DestinationInput</returns>
    public static DestinationInput FromJson(string jsonString)
    {
      DestinationInput newDestinationInput = null;

      if (string.IsNullOrEmpty(jsonString))
      {
        return newDestinationInput;
      }
      int match = 0;
      List<string> matchedTypes = new List<string>();

      try
      {
        // if it does not contains "AdditionalProperties", use SerializerSettings to deserialize
        if (typeof(DestinationIndexName).GetProperty("AdditionalProperties") == null)
        {
          newDestinationInput = new DestinationInput(JsonConvert.DeserializeObject<DestinationIndexName>(jsonString, DestinationInput.SerializerSettings));
        }
        else
        {
          newDestinationInput = new DestinationInput(JsonConvert.DeserializeObject<DestinationIndexName>(jsonString, DestinationInput.AdditionalPropertiesSerializerSettings));
        }
        matchedTypes.Add("DestinationIndexName");
        match++;
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into DestinationIndexName: {1}", jsonString, exception.ToString()));
      }

      try
      {
        // if it does not contains "AdditionalProperties", use SerializerSettings to deserialize
        if (typeof(DestinationIndexPrefix).GetProperty("AdditionalProperties") == null)
        {
          newDestinationInput = new DestinationInput(JsonConvert.DeserializeObject<DestinationIndexPrefix>(jsonString, DestinationInput.SerializerSettings));
        }
        else
        {
          newDestinationInput = new DestinationInput(JsonConvert.DeserializeObject<DestinationIndexPrefix>(jsonString, DestinationInput.AdditionalPropertiesSerializerSettings));
        }
        matchedTypes.Add("DestinationIndexPrefix");
        match++;
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into DestinationIndexPrefix: {1}", jsonString, exception.ToString()));
      }

      if (match == 0)
      {
        throw new InvalidDataException("The JSON string `" + jsonString + "` cannot be deserialized into any schema defined.");
      }
      else if (match > 1)
      {
        throw new InvalidDataException("The JSON string `" + jsonString + "` incorrectly matches more than one schema (should be exactly one match): " + String.Join(",", matchedTypes));
      }

      // deserialization is considered successful at this point if no exception has been thrown.
      return newDestinationInput;
    }

  }

  /// <summary>
  /// Custom JSON converter for DestinationInput
  /// </summary>
  public class DestinationInputJsonConverter : JsonConverter
  {
    /// <summary>
    /// To write the JSON string
    /// </summary>
    /// <param name="writer">JSON writer</param>
    /// <param name="value">Object to be converted into a JSON string</param>
    /// <param name="serializer">JSON Serializer</param>
    public override void WriteJson(JsonWriter writer, object value, JsonSerializer serializer)
    {
      writer.WriteRawValue((string)(typeof(DestinationInput).GetMethod("ToJson").Invoke(value, null)));
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
        return DestinationInput.FromJson(JObject.Load(reader).ToString(Formatting.None));
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
