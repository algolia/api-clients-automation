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
using FileParameter = Org.OpenAPITools.Client.FileParameter;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;
using System.Reflection;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  /// Removes stop (common) words from the query before executing it. &#x60;removeStopWords&#x60; is used in conjunction with the &#x60;queryLanguages&#x60; setting. _list_: language ISO codes for which stop words should be enabled. This list will override any values that you may have set in &#x60;queryLanguages&#x60;. _true_: enables the stop words feature, ensuring that stop words are removed from consideration in a search. The languages supported here are either [every language](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/) (this is the default) or those set by &#x60;queryLanguages&#x60;. _false_: turns off the stop words feature, allowing stop words to be taken into account in a search. 
  /// </summary>
  [JsonConverter(typeof(RemoveStopWordsJsonConverter))]
  [DataContract(Name = "removeStopWords")]
  public partial class RemoveStopWords : AbstractOpenAPISchema, IEquatable<RemoveStopWords>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="RemoveStopWords" /> class
    /// with the <see cref="List{String}" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of List&lt;string&gt;.</param>
    public RemoveStopWords(List<string> actualInstance)
    {
      this.IsNullable = false;
      this.SchemaType = "oneOf";
      this.ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
    }

    /// <summary>
    /// Initializes a new instance of the <see cref="RemoveStopWords" /> class
    /// with the <see cref="bool" /> class
    /// </summary>
    /// <param name="actualInstance">An instance of bool.</param>
    public RemoveStopWords(bool actualInstance)
    {
      this.IsNullable = false;
      this.SchemaType = "oneOf";
      this.ActualInstance = actualInstance;
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
        if (value.GetType() == typeof(List<string>))
        {
          this._actualInstance = value;
        }
        else if (value.GetType() == typeof(bool))
        {
          this._actualInstance = value;
        }
        else
        {
          throw new ArgumentException("Invalid instance found. Must be the following types: List<string>, bool");
        }
      }
    }

    /// <summary>
    /// Get the actual instance of `List&lt;string&gt;`. If the actual instance is not `List&lt;string&gt;`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of List&lt;string&gt;</returns>
    public List<string> GetList()
    {
      return (List<string>)this.ActualInstance;
    }

    /// <summary>
    /// Get the actual instance of `bool`. If the actual instance is not `bool`,
    /// the InvalidClassException will be thrown
    /// </summary>
    /// <returns>An instance of bool</returns>
    public bool GetBool()
    {
      return (bool)this.ActualInstance;
    }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      var sb = new StringBuilder();
      sb.Append("class RemoveStopWords {\n");
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
      return JsonConvert.SerializeObject(this.ActualInstance, RemoveStopWords.SerializerSettings);
    }

    /// <summary>
    /// Converts the JSON string into an instance of RemoveStopWords
    /// </summary>
    /// <param name="jsonString">JSON string</param>
    /// <returns>An instance of RemoveStopWords</returns>
    public static RemoveStopWords FromJson(string jsonString)
    {
      RemoveStopWords newRemoveStopWords = null;

      if (string.IsNullOrEmpty(jsonString))
      {
        return newRemoveStopWords;
      }
      int match = 0;
      List<string> matchedTypes = new List<string>();

      try
      {
        // if it does not contains "AdditionalProperties", use SerializerSettings to deserialize
        if (typeof(List<string>).GetProperty("AdditionalProperties") == null)
        {
          newRemoveStopWords = new RemoveStopWords(JsonConvert.DeserializeObject<List<string>>(jsonString, RemoveStopWords.SerializerSettings));
        }
        else
        {
          newRemoveStopWords = new RemoveStopWords(JsonConvert.DeserializeObject<List<string>>(jsonString, RemoveStopWords.AdditionalPropertiesSerializerSettings));
        }
        matchedTypes.Add("List<string>");
        match++;
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into List<string>: {1}", jsonString, exception.ToString()));
      }

      try
      {
        // if it does not contains "AdditionalProperties", use SerializerSettings to deserialize
        if (typeof(bool).GetProperty("AdditionalProperties") == null)
        {
          newRemoveStopWords = new RemoveStopWords(JsonConvert.DeserializeObject<bool>(jsonString, RemoveStopWords.SerializerSettings));
        }
        else
        {
          newRemoveStopWords = new RemoveStopWords(JsonConvert.DeserializeObject<bool>(jsonString, RemoveStopWords.AdditionalPropertiesSerializerSettings));
        }
        matchedTypes.Add("bool");
        match++;
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine(string.Format("Failed to deserialize `{0}` into bool: {1}", jsonString, exception.ToString()));
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
      return newRemoveStopWords;
    }

    /// <summary>
    /// Returns true if objects are equal
    /// </summary>
    /// <param name="input">Object to be compared</param>
    /// <returns>Boolean</returns>
    public override bool Equals(object input)
    {
      return this.Equals(input as RemoveStopWords);
    }

    /// <summary>
    /// Returns true if RemoveStopWords instances are equal
    /// </summary>
    /// <param name="input">Instance of RemoveStopWords to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(RemoveStopWords input)
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
  /// Custom JSON converter for RemoveStopWords
  /// </summary>
  public class RemoveStopWordsJsonConverter : JsonConverter
  {
    /// <summary>
    /// To write the JSON string
    /// </summary>
    /// <param name="writer">JSON writer</param>
    /// <param name="value">Object to be converted into a JSON string</param>
    /// <param name="serializer">JSON Serializer</param>
    public override void WriteJson(JsonWriter writer, object value, JsonSerializer serializer)
    {
      writer.WriteRawValue((string)(typeof(RemoveStopWords).GetMethod("ToJson").Invoke(value, null)));
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
        return RemoveStopWords.FromJson(JObject.Load(reader).ToString(Formatting.None));
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
