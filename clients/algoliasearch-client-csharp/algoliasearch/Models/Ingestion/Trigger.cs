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

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// Trigger that runs the task.
/// </summary>
[JsonConverter(typeof(TriggerJsonConverter))]
public partial class Trigger : AbstractSchema
{
  /// <summary>
  /// Initializes a new instance of the Trigger class
  /// with a OnDemandTrigger
  /// </summary>
  /// <param name="actualInstance">An instance of OnDemandTrigger.</param>
  public Trigger(OnDemandTrigger actualInstance)
  {
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the Trigger class
  /// with a ScheduleTrigger
  /// </summary>
  /// <param name="actualInstance">An instance of ScheduleTrigger.</param>
  public Trigger(ScheduleTrigger actualInstance)
  {
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the Trigger class
  /// with a SubscriptionTrigger
  /// </summary>
  /// <param name="actualInstance">An instance of SubscriptionTrigger.</param>
  public Trigger(SubscriptionTrigger actualInstance)
  {
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the Trigger class
  /// with a StreamingTrigger
  /// </summary>
  /// <param name="actualInstance">An instance of StreamingTrigger.</param>
  public Trigger(StreamingTrigger actualInstance)
  {
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }


  /// <summary>
  /// Gets or Sets ActualInstance
  /// </summary>
  public sealed override object ActualInstance { get; set; }

  /// <summary>
  /// Get the actual instance of `OnDemandTrigger`. If the actual instance is not `OnDemandTrigger`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of OnDemandTrigger</returns>
  public OnDemandTrigger AsOnDemandTrigger()
  {
    return (OnDemandTrigger)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `ScheduleTrigger`. If the actual instance is not `ScheduleTrigger`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ScheduleTrigger</returns>
  public ScheduleTrigger AsScheduleTrigger()
  {
    return (ScheduleTrigger)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `SubscriptionTrigger`. If the actual instance is not `SubscriptionTrigger`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of SubscriptionTrigger</returns>
  public SubscriptionTrigger AsSubscriptionTrigger()
  {
    return (SubscriptionTrigger)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `StreamingTrigger`. If the actual instance is not `StreamingTrigger`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of StreamingTrigger</returns>
  public StreamingTrigger AsStreamingTrigger()
  {
    return (StreamingTrigger)ActualInstance;
  }


  /// <summary>
  /// Check if the actual instance is of `OnDemandTrigger` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsOnDemandTrigger()
  {
    return ActualInstance.GetType() == typeof(OnDemandTrigger);
  }

  /// <summary>
  /// Check if the actual instance is of `ScheduleTrigger` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsScheduleTrigger()
  {
    return ActualInstance.GetType() == typeof(ScheduleTrigger);
  }

  /// <summary>
  /// Check if the actual instance is of `SubscriptionTrigger` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsSubscriptionTrigger()
  {
    return ActualInstance.GetType() == typeof(SubscriptionTrigger);
  }

  /// <summary>
  /// Check if the actual instance is of `StreamingTrigger` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsStreamingTrigger()
  {
    return ActualInstance.GetType() == typeof(StreamingTrigger);
  }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    var sb = new StringBuilder();
    sb.Append("class Trigger {\n");
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
    if (obj is not Trigger input)
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
/// Custom JSON converter for Trigger
/// </summary>
public class TriggerJsonConverter : JsonConverter<Trigger>
{

  /// <summary>
  /// Check if the object can be converted
  /// </summary>
  /// <param name="objectType">Object type</param>
  /// <returns>True if the object can be converted</returns>
  public override bool CanConvert(Type objectType)
  {
    return objectType == typeof(Trigger);
  }

  /// <summary>
  /// To convert a JSON string into an object
  /// </summary>
  /// <param name="reader">JSON reader</param>
  /// <param name="typeToConvert">Object type</param>
  /// <param name="options">Serializer options</param>
  /// <returns>The object converted from the JSON string</returns>
  public override Trigger Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
  {
    var jsonDocument = JsonDocument.ParseValue(ref reader);
    var root = jsonDocument.RootElement;
    if (root.ValueKind == JsonValueKind.Object)
    {
      try
      {
        return new Trigger(jsonDocument.Deserialize<OnDemandTrigger>(JsonConfig.Options));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize into OnDemandTrigger: {exception}");
      }
    }
    if (root.ValueKind == JsonValueKind.Object)
    {
      try
      {
        return new Trigger(jsonDocument.Deserialize<ScheduleTrigger>(JsonConfig.Options));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize into ScheduleTrigger: {exception}");
      }
    }
    if (root.ValueKind == JsonValueKind.Object)
    {
      try
      {
        return new Trigger(jsonDocument.Deserialize<SubscriptionTrigger>(JsonConfig.Options));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize into SubscriptionTrigger: {exception}");
      }
    }
    if (root.ValueKind == JsonValueKind.Object)
    {
      try
      {
        return new Trigger(jsonDocument.Deserialize<StreamingTrigger>(JsonConfig.Options));
      }
      catch (Exception exception)
      {
        // deserialization failed, try the next one
        System.Diagnostics.Debug.WriteLine($"Failed to deserialize into StreamingTrigger: {exception}");
      }
    }
    throw new InvalidDataException($"The JSON string cannot be deserialized into any schema defined.");
  }

  /// <summary>
  /// To write the JSON string
  /// </summary>
  /// <param name="writer">JSON writer</param>
  /// <param name="value">Trigger to be converted into a JSON string</param>
  /// <param name="options">JSON Serializer options</param>
  public override void Write(Utf8JsonWriter writer, Trigger value, JsonSerializerOptions options)
  {
    writer.WriteRawValue(value.ToJson());
  }
}

