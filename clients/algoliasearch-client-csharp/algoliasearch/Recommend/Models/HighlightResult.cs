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
using System.ComponentModel.DataAnnotations;
using FileParameter = Algolia.Search.Recommend.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Recommend.Client.OpenAPIDateConverter;
using System.Reflection;

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// HighlightResult
  /// </summary>
  [JsonConverter(typeof(HighlightResultJsonConverter))]
  [DataContract(Name = "highlightResult")]
  public partial class HighlightResult : AbstractOpenAPISchema, IEquatable<HighlightResult>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="HighlightResult" /> class
    /// with the <see cref="HighlightResultOption" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of HighlightResultOption.</param>
    public HighlightResult(HighlightResultOption actualInstance)
    {
      this.IsNullable = false;
      this.SchemaType = "oneOf";
      this.ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
    }

    /// <summary>
    /// Initializes a new instance of the <see cref="HighlightResult" /> class
    /// with the <see cref="List{HighlightResultOption}" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of List&lt;HighlightResultOption&gt;.</param>
    public HighlightResult(List<HighlightResultOption> actualInstance)
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
        if (value.GetType() == typeof(HighlightResultOption))
        {
          this._actualInstance = value;
        }
        else if (value.GetType() == typeof(List<HighlightResultOption>))
        {
          this._actualInstance = value;
        }
        else
        {
          throw new ArgumentException("Invalid instance found. Must be the following types: HighlightResultOption, List<HighlightResultOption>");
        }
      }
    }

    /// <summary>
    /// Get the actual instance of `HighlightResultOption`. If the actual instance is not `HighlightResultOption`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of HighlightResultOption</returns>
    public HighlightResultOption GetterHighlightResultOption()
    {
      return (HighlightResultOption)this.ActualInstance;
    }

    /// <summary>
    /// Get the actual instance of `List&lt;HighlightResultOption&gt;`. If the actual instance is not `List&lt;HighlightResultOption&gt;`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of List&lt;HighlightResultOption&gt;</returns>
    public List<HighlightResultOption> GetterList()
    {
      return (List<HighlightResultOption>)this.ActualInstance;
    }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      var sb = new StringBuilder();
      sb.Append("class HighlightResult {\n");
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
      return JsonConvert.SerializeObject(this.ActualInstance, HighlightResult.SerializerSettings);
    }

    /// <summary>
    /// Converts the JSON string into an instance of HighlightResult
    /// </summary>
    /// <param name="jsonString">JSON string</param>
    /// <returns>An instance of HighlightResult</returns>
    public static HighlightResult FromJson(string jsonString)
    {
      HighlightResult newHighlightResult = null;

      if (string.IsNullOrEmpty(jsonString))
      {
        return newHighlightResult;
      }
      int match = 0;
      List<string> matchedTypes = new List<string>();

      try
      {
        // if it does not contains "AdditionalProperties", use SerializerSettings to deserialize
        if (typeof(HighlightResultOption).GetProperty("AdditionalProperties") == null)
        {
          newHighlightResult = new HighlightResult(JsonConvert.DeserializeObject<HighlightResultOption>(jsonString, HighlightResult.SerializerSettings));
        }
        else
        {
          newHighlightResult = new HighlightResult(JsonConvert.DeserializeObject<HighlightResultOption>(jsonString, HighlightResult.AdditionalPropertiesSerializerSettings));
        }
        matchedTypes.Add("HighlightResultOption");
        match++;
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into HighlightResultOption: {1}", jsonString, exception.ToString()));
      }

      try
      {
        // if it does not contains "AdditionalProperties", use SerializerSettings to deserialize
        if (typeof(List<HighlightResultOption>).GetProperty("AdditionalProperties") == null)
        {
          newHighlightResult = new HighlightResult(JsonConvert.DeserializeObject<List<HighlightResultOption>>(jsonString, HighlightResult.SerializerSettings));
        }
        else
        {
          newHighlightResult = new HighlightResult(JsonConvert.DeserializeObject<List<HighlightResultOption>>(jsonString, HighlightResult.AdditionalPropertiesSerializerSettings));
        }
        matchedTypes.Add("List<HighlightResultOption>");
        match++;
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into List<HighlightResultOption>: {1}", jsonString, exception.ToString()));
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
      return newHighlightResult;
    }

    /// <summary>
    /// Returns true if objects are equal
    /// </summary>
    /// <param name="input">Object to be compared</param>
    /// <returns>Boolean</returns>
    public override bool Equals(object input)
    {
      return this.Equals(input as HighlightResult);
    }

    /// <summary>
    /// Returns true if HighlightResult instances are equal
    /// </summary>
    /// <param name="input">Instance of HighlightResult to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(HighlightResult input)
    {
      if (input == null)
        return false;

      return this.ActualInstance.Equals(input.ActualInstance);
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
        if (this.ActualInstance != null)
          hashCode = hashCode * 59 + this.ActualInstance.GetHashCode();
        return hashCode;
      }
    }

    /// <summary>
    /// To validate all properties of the instance
    /// </summary>
    /// <param name="validationContext">Validation context</param>
    /// <returns>Validation Result</returns>
    IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
    {
      yield break;
    }
  }

  /// <summary>
  /// Custom JSON converter for HighlightResult
  /// </summary>
  public class HighlightResultJsonConverter : JsonConverter
  {
    /// <summary>
    /// To write the JSON string
    /// </summary>
    /// <param name="writer">JSON writer</param>
    /// <param name="value">Object to be converted into a JSON string</param>
    /// <param name="serializer">JSON Serializer</param>
    public override void WriteJson(JsonWriter writer, object value, JsonSerializer serializer)
    {
      writer.WriteRawValue((string)(typeof(HighlightResult).GetMethod("ToJson").Invoke(value, null)));
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
        return HighlightResult.FromJson(JObject.Load(reader).ToString(Formatting.None));
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
