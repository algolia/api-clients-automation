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

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// AuthInput
/// </summary>
[JsonConverter(typeof(AuthInputJsonConverter))]
[DataContract(Name = "AuthInput")]
public partial class AuthInput : AbstractSchema
{
  /// <summary>
  /// Initializes a new instance of the AuthInput class
  /// with a AuthGoogleServiceAccount
  /// </summary>
  /// <param name="actualInstance">An instance of AuthGoogleServiceAccount.</param>
  public AuthInput(AuthGoogleServiceAccount actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the AuthInput class
  /// with a AuthBasic
  /// </summary>
  /// <param name="actualInstance">An instance of AuthBasic.</param>
  public AuthInput(AuthBasic actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the AuthInput class
  /// with a AuthAPIKey
  /// </summary>
  /// <param name="actualInstance">An instance of AuthAPIKey.</param>
  public AuthInput(AuthAPIKey actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the AuthInput class
  /// with a AuthOAuth
  /// </summary>
  /// <param name="actualInstance">An instance of AuthOAuth.</param>
  public AuthInput(AuthOAuth actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the AuthInput class
  /// with a AuthAlgolia
  /// </summary>
  /// <param name="actualInstance">An instance of AuthAlgolia.</param>
  public AuthInput(AuthAlgolia actualInstance)
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
  /// Get the actual instance of `AuthGoogleServiceAccount`. If the actual instance is not `AuthGoogleServiceAccount`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of AuthGoogleServiceAccount</returns>
  public AuthGoogleServiceAccount AsAuthGoogleServiceAccount()
  {
    return (AuthGoogleServiceAccount)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `AuthBasic`. If the actual instance is not `AuthBasic`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of AuthBasic</returns>
  public AuthBasic AsAuthBasic()
  {
    return (AuthBasic)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `AuthAPIKey`. If the actual instance is not `AuthAPIKey`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of AuthAPIKey</returns>
  public AuthAPIKey AsAuthAPIKey()
  {
    return (AuthAPIKey)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `AuthOAuth`. If the actual instance is not `AuthOAuth`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of AuthOAuth</returns>
  public AuthOAuth AsAuthOAuth()
  {
    return (AuthOAuth)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `AuthAlgolia`. If the actual instance is not `AuthAlgolia`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of AuthAlgolia</returns>
  public AuthAlgolia AsAuthAlgolia()
  {
    return (AuthAlgolia)ActualInstance;
  }


  /// <summary>
  /// Check if the actual instance is of `AuthGoogleServiceAccount` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsAuthGoogleServiceAccount()
  {
    return ActualInstance.GetType() == typeof(AuthGoogleServiceAccount);
  }

  /// <summary>
  /// Check if the actual instance is of `AuthBasic` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsAuthBasic()
  {
    return ActualInstance.GetType() == typeof(AuthBasic);
  }

  /// <summary>
  /// Check if the actual instance is of `AuthAPIKey` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsAuthAPIKey()
  {
    return ActualInstance.GetType() == typeof(AuthAPIKey);
  }

  /// <summary>
  /// Check if the actual instance is of `AuthOAuth` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsAuthOAuth()
  {
    return ActualInstance.GetType() == typeof(AuthOAuth);
  }

  /// <summary>
  /// Check if the actual instance is of `AuthAlgolia` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsAuthAlgolia()
  {
    return ActualInstance.GetType() == typeof(AuthAlgolia);
  }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    var sb = new StringBuilder();
    sb.Append("class AuthInput {\n");
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
  /// Converts the JSON string into an instance of AuthInput
  /// </summary>
  /// <param name="jsonString">JSON string</param>
  /// <returns>An instance of AuthInput</returns>
  public static AuthInput FromJson(string jsonString)
  {
    var jToken = JToken.Parse(jsonString);
    if (jToken.Type == JTokenType.Object)
    {
      try
      {
        return new AuthInput(JsonConvert.DeserializeObject<AuthGoogleServiceAccount>(jsonString, JsonConfig.AlgoliaJsonSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into AuthGoogleServiceAccount: {exception}");
      }
    }
    if (jToken.Type == JTokenType.Object)
    {
      try
      {
        return new AuthInput(JsonConvert.DeserializeObject<AuthBasic>(jsonString, JsonConfig.AlgoliaJsonSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into AuthBasic: {exception}");
      }
    }
    if (jToken.Type == JTokenType.Object)
    {
      try
      {
        return new AuthInput(JsonConvert.DeserializeObject<AuthAPIKey>(jsonString, JsonConfig.AlgoliaJsonSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into AuthAPIKey: {exception}");
      }
    }
    if (jToken.Type == JTokenType.Object)
    {
      try
      {
        return new AuthInput(JsonConvert.DeserializeObject<AuthOAuth>(jsonString, JsonConfig.AlgoliaJsonSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into AuthOAuth: {exception}");
      }
    }
    if (jToken.Type == JTokenType.Object)
    {
      try
      {
        return new AuthInput(JsonConvert.DeserializeObject<AuthAlgolia>(jsonString, JsonConfig.AlgoliaJsonSerializerSettings));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into AuthAlgolia: {exception}");
      }
    }

    throw new InvalidDataException($"The JSON string `{jsonString}` cannot be deserialized into any schema defined.");
  }

}

/// <summary>
/// Custom JSON converter for AuthInput
/// </summary>
public class AuthInputJsonConverter : JsonConverter
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

