/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


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
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;
using System.Reflection;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  /// When providing a string, it replaces the entire query string. When providing an object, it describes incremental edits to be made to the query string (but you can&#39;t do both).
  /// </summary>
  [JsonConverter(typeof(ConsequenceQueryJsonConverter))]
  [DataContract(Name = "consequenceQuery")]
  public partial class ConsequenceQuery : AbstractOpenAPISchema, IEquatable<ConsequenceQuery>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="ConsequenceQuery" /> class
    /// with the <see cref="ConsequenceQueryObject" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of ConsequenceQueryObject.</param>
    public ConsequenceQuery(ConsequenceQueryObject actualInstance)
    {
      this.IsNullable = false;
      this.SchemaType = "oneOf";
      this.ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
    }

    /// <summary>
    /// Initializes a new instance of the <see cref="ConsequenceQuery" /> class
    /// with the <see cref="string" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of string.</param>
    public ConsequenceQuery(string actualInstance)
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
        if (value.GetType() == typeof(ConsequenceQueryObject))
        {
          this._actualInstance = value;
        }
        else if (value.GetType() == typeof(string))
        {
          this._actualInstance = value;
        }
        else
        {
          throw new ArgumentException("Invalid instance found. Must be the following types: ConsequenceQueryObject, string");
        }
      }
    }

    /// <summary>
    /// Get the actual instance of `ConsequenceQueryObject`. If the actual instance is not `ConsequenceQueryObject`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of ConsequenceQueryObject</returns>
    public ConsequenceQueryObject GetConsequenceQueryObject()
    {
      return (ConsequenceQueryObject)this.ActualInstance;
    }

    /// <summary>
    /// Get the actual instance of `string`. If the actual instance is not `string`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of string</returns>
    public string GetString()
    {
      return (string)this.ActualInstance;
    }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      var sb = new StringBuilder();
      sb.Append("class ConsequenceQuery {\n");
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
      return JsonConvert.SerializeObject(this.ActualInstance, ConsequenceQuery.SerializerSettings);
    }

    /// <summary>
    /// Converts the JSON string into an instance of ConsequenceQuery
    /// </summary>
    /// <param name="jsonString">JSON string</param>
    /// <returns>An instance of ConsequenceQuery</returns>
    public static ConsequenceQuery FromJson(string jsonString)
    {
      ConsequenceQuery newConsequenceQuery = null;

      if (string.IsNullOrEmpty(jsonString))
      {
        return newConsequenceQuery;
      }
      int match = 0;
      List<string> matchedTypes = new List<string>();

      try
      {
        // if it does not contains "AdditionalProperties", use SerializerSettings to deserialize
        if (typeof(ConsequenceQueryObject).GetProperty("AdditionalProperties") == null)
        {
          newConsequenceQuery = new ConsequenceQuery(JsonConvert.DeserializeObject<ConsequenceQueryObject>(jsonString, ConsequenceQuery.SerializerSettings));
        }
        else
        {
          newConsequenceQuery = new ConsequenceQuery(JsonConvert.DeserializeObject<ConsequenceQueryObject>(jsonString, ConsequenceQuery.AdditionalPropertiesSerializerSettings));
        }
        matchedTypes.Add("ConsequenceQueryObject");
        match++;
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into ConsequenceQueryObject: {1}", jsonString, exception.ToString()));
      }

      try
      {
        // if it does not contains "AdditionalProperties", use SerializerSettings to deserialize
        if (typeof(string).GetProperty("AdditionalProperties") == null)
        {
          newConsequenceQuery = new ConsequenceQuery(JsonConvert.DeserializeObject<string>(jsonString, ConsequenceQuery.SerializerSettings));
        }
        else
        {
          newConsequenceQuery = new ConsequenceQuery(JsonConvert.DeserializeObject<string>(jsonString, ConsequenceQuery.AdditionalPropertiesSerializerSettings));
        }
        matchedTypes.Add("string");
        match++;
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into string: {1}", jsonString, exception.ToString()));
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
      return newConsequenceQuery;
    }

    /// <summary>
    /// Returns true if objects are equal
    /// </summary>
    /// <param name="input">Object to be compared</param>
    /// <returns>Boolean</returns>
    public override bool Equals(object input)
    {
      return this.Equals(input as ConsequenceQuery);
    }

    /// <summary>
    /// Returns true if ConsequenceQuery instances are equal
    /// </summary>
    /// <param name="input">Instance of ConsequenceQuery to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(ConsequenceQuery input)
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
      writer.WriteRawValue((string)(typeof(ConsequenceQuery).GetMethod("ToJson").Invoke(value, null)));
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
        return ConsequenceQuery.FromJson(JObject.Load(reader).ToString(Formatting.None));
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
