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

namespace Algolia.Search.Models.Recommend
{
  /// <summary>
  /// Create filters to boost or demote records.   Records that match the filter are ranked higher for positive and lower for negative optional filters. In contrast to regular filters, records that don&#39;t match the optional filter are still included in the results, only their ranking is affected. 
  /// </summary>
  [JsonConverter(typeof(OptionalFiltersJsonConverter))]
  [DataContract(Name = "optionalFilters")]
  public partial class OptionalFilters : AbstractSchema
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="OptionalFilters" /> class
    /// with the <see cref="List{MixedSearchFilters}" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of List&lt;MixedSearchFilters&gt;.</param>
    public OptionalFilters(List<MixedSearchFilters> actualInstance)
    {
      IsNullable = false;
      SchemaType = "oneOf";
      ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
    }

    /// <summary>
    /// Initializes a new instance of the <see cref="OptionalFilters" /> class
    /// with the <see cref="string" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of string.</param>
    public OptionalFilters(string actualInstance)
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
    /// Get the actual instance of `List&lt;MixedSearchFilters&gt;`. If the actual instance is not `List&lt;MixedSearchFilters&gt;`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of List&lt;MixedSearchFilters&gt;</returns>
    public List<MixedSearchFilters> AsList()
    {
      return (List<MixedSearchFilters>)ActualInstance;
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
    /// Check if the actual instance is of `List&lt;MixedSearchFilters&gt;` type.
    /// </summary>
    /// <returns>Whether or not the instance is the type</returns>
    public bool IsList()
    {
      return ActualInstance.GetType() == typeof(List<MixedSearchFilters>);
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
      return JsonConvert.SerializeObject(ActualInstance, SerializerSettings);
    }

    /// <summary>
    /// Converts the JSON string into an instance of OptionalFilters
    /// </summary>
    /// <param name="jsonString">JSON string</param>
    /// <returns>An instance of OptionalFilters</returns>
    public static OptionalFilters FromJson(string jsonString)
    {
      OptionalFilters newOptionalFilters = null;

      if (string.IsNullOrEmpty(jsonString))
      {
        return newOptionalFilters;
      }
      try
      {
        return new OptionalFilters(JsonConvert.DeserializeObject<List<MixedSearchFilters>>(jsonString, AdditionalPropertiesSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into List<MixedSearchFilters>: {1}", jsonString, exception.ToString()));
      }
      try
      {
        return new OptionalFilters(JsonConvert.DeserializeObject<string>(jsonString, AdditionalPropertiesSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into string: {1}", jsonString, exception.ToString()));
      }

      throw new InvalidDataException("The JSON string `" + jsonString + "` cannot be deserialized into any schema defined.");
    }

  }

  /// <summary>
  /// Custom JSON converter for OptionalFilters
  /// </summary>
  public class OptionalFiltersJsonConverter : JsonConverter
  {
    /// <summary>
    /// To write the JSON string
    /// </summary>
    /// <param name="writer">JSON writer</param>
    /// <param name="value">Object to be converted into a JSON string</param>
    /// <param name="serializer">JSON Serializer</param>
    public override void WriteJson(JsonWriter writer, object value, JsonSerializer serializer)
    {
      writer.WriteRawValue((string)(typeof(OptionalFilters).GetMethod("ToJson").Invoke(value, null)));
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
