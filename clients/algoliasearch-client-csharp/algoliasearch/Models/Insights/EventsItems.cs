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

namespace Algolia.Search.Models.Insights;

/// <summary>
/// EventsItems
/// </summary>
[JsonConverter(typeof(EventsItemsJsonConverter))]
[DataContract(Name = "EventsItems")]
public partial class EventsItems : AbstractSchema
{
  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a ClickedObjectIDsAfterSearch
  /// </summary>
  /// <param name="actualInstance">An instance of ClickedObjectIDsAfterSearch.</param>
  public EventsItems(ClickedObjectIDsAfterSearch actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a AddedToCartObjectIDsAfterSearch
  /// </summary>
  /// <param name="actualInstance">An instance of AddedToCartObjectIDsAfterSearch.</param>
  public EventsItems(AddedToCartObjectIDsAfterSearch actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a PurchasedObjectIDsAfterSearch
  /// </summary>
  /// <param name="actualInstance">An instance of PurchasedObjectIDsAfterSearch.</param>
  public EventsItems(PurchasedObjectIDsAfterSearch actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a ConvertedObjectIDsAfterSearch
  /// </summary>
  /// <param name="actualInstance">An instance of ConvertedObjectIDsAfterSearch.</param>
  public EventsItems(ConvertedObjectIDsAfterSearch actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a ClickedObjectIDs
  /// </summary>
  /// <param name="actualInstance">An instance of ClickedObjectIDs.</param>
  public EventsItems(ClickedObjectIDs actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a PurchasedObjectIDs
  /// </summary>
  /// <param name="actualInstance">An instance of PurchasedObjectIDs.</param>
  public EventsItems(PurchasedObjectIDs actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a AddedToCartObjectIDs
  /// </summary>
  /// <param name="actualInstance">An instance of AddedToCartObjectIDs.</param>
  public EventsItems(AddedToCartObjectIDs actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a ConvertedObjectIDs
  /// </summary>
  /// <param name="actualInstance">An instance of ConvertedObjectIDs.</param>
  public EventsItems(ConvertedObjectIDs actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a ClickedFilters
  /// </summary>
  /// <param name="actualInstance">An instance of ClickedFilters.</param>
  public EventsItems(ClickedFilters actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a ConvertedFilters
  /// </summary>
  /// <param name="actualInstance">An instance of ConvertedFilters.</param>
  public EventsItems(ConvertedFilters actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a ViewedObjectIDs
  /// </summary>
  /// <param name="actualInstance">An instance of ViewedObjectIDs.</param>
  public EventsItems(ViewedObjectIDs actualInstance)
  {
    IsNullable = false;
    SchemaType = "oneOf";
    ActualInstance = actualInstance ?? throw new ArgumentException("Invalid instance found. Must not be null.");
  }

  /// <summary>
  /// Initializes a new instance of the EventsItems class
  /// with a ViewedFilters
  /// </summary>
  /// <param name="actualInstance">An instance of ViewedFilters.</param>
  public EventsItems(ViewedFilters actualInstance)
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
  /// Get the actual instance of `ClickedObjectIDsAfterSearch`. If the actual instance is not `ClickedObjectIDsAfterSearch`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ClickedObjectIDsAfterSearch</returns>
  public ClickedObjectIDsAfterSearch AsClickedObjectIDsAfterSearch()
  {
    return (ClickedObjectIDsAfterSearch)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `AddedToCartObjectIDsAfterSearch`. If the actual instance is not `AddedToCartObjectIDsAfterSearch`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of AddedToCartObjectIDsAfterSearch</returns>
  public AddedToCartObjectIDsAfterSearch AsAddedToCartObjectIDsAfterSearch()
  {
    return (AddedToCartObjectIDsAfterSearch)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `PurchasedObjectIDsAfterSearch`. If the actual instance is not `PurchasedObjectIDsAfterSearch`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of PurchasedObjectIDsAfterSearch</returns>
  public PurchasedObjectIDsAfterSearch AsPurchasedObjectIDsAfterSearch()
  {
    return (PurchasedObjectIDsAfterSearch)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `ConvertedObjectIDsAfterSearch`. If the actual instance is not `ConvertedObjectIDsAfterSearch`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ConvertedObjectIDsAfterSearch</returns>
  public ConvertedObjectIDsAfterSearch AsConvertedObjectIDsAfterSearch()
  {
    return (ConvertedObjectIDsAfterSearch)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `ClickedObjectIDs`. If the actual instance is not `ClickedObjectIDs`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ClickedObjectIDs</returns>
  public ClickedObjectIDs AsClickedObjectIDs()
  {
    return (ClickedObjectIDs)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `PurchasedObjectIDs`. If the actual instance is not `PurchasedObjectIDs`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of PurchasedObjectIDs</returns>
  public PurchasedObjectIDs AsPurchasedObjectIDs()
  {
    return (PurchasedObjectIDs)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `AddedToCartObjectIDs`. If the actual instance is not `AddedToCartObjectIDs`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of AddedToCartObjectIDs</returns>
  public AddedToCartObjectIDs AsAddedToCartObjectIDs()
  {
    return (AddedToCartObjectIDs)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `ConvertedObjectIDs`. If the actual instance is not `ConvertedObjectIDs`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ConvertedObjectIDs</returns>
  public ConvertedObjectIDs AsConvertedObjectIDs()
  {
    return (ConvertedObjectIDs)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `ClickedFilters`. If the actual instance is not `ClickedFilters`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ClickedFilters</returns>
  public ClickedFilters AsClickedFilters()
  {
    return (ClickedFilters)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `ConvertedFilters`. If the actual instance is not `ConvertedFilters`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ConvertedFilters</returns>
  public ConvertedFilters AsConvertedFilters()
  {
    return (ConvertedFilters)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `ViewedObjectIDs`. If the actual instance is not `ViewedObjectIDs`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ViewedObjectIDs</returns>
  public ViewedObjectIDs AsViewedObjectIDs()
  {
    return (ViewedObjectIDs)ActualInstance;
  }

  /// <summary>
  /// Get the actual instance of `ViewedFilters`. If the actual instance is not `ViewedFilters`,
  /// the InvalidClassException will be thrown
  /// </summary>
  /// <returns>An instance of ViewedFilters</returns>
  public ViewedFilters AsViewedFilters()
  {
    return (ViewedFilters)ActualInstance;
  }


  /// <summary>
  /// Check if the actual instance is of `ClickedObjectIDsAfterSearch` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsClickedObjectIDsAfterSearch()
  {
    return ActualInstance.GetType() == typeof(ClickedObjectIDsAfterSearch);
  }

  /// <summary>
  /// Check if the actual instance is of `AddedToCartObjectIDsAfterSearch` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsAddedToCartObjectIDsAfterSearch()
  {
    return ActualInstance.GetType() == typeof(AddedToCartObjectIDsAfterSearch);
  }

  /// <summary>
  /// Check if the actual instance is of `PurchasedObjectIDsAfterSearch` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsPurchasedObjectIDsAfterSearch()
  {
    return ActualInstance.GetType() == typeof(PurchasedObjectIDsAfterSearch);
  }

  /// <summary>
  /// Check if the actual instance is of `ConvertedObjectIDsAfterSearch` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsConvertedObjectIDsAfterSearch()
  {
    return ActualInstance.GetType() == typeof(ConvertedObjectIDsAfterSearch);
  }

  /// <summary>
  /// Check if the actual instance is of `ClickedObjectIDs` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsClickedObjectIDs()
  {
    return ActualInstance.GetType() == typeof(ClickedObjectIDs);
  }

  /// <summary>
  /// Check if the actual instance is of `PurchasedObjectIDs` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsPurchasedObjectIDs()
  {
    return ActualInstance.GetType() == typeof(PurchasedObjectIDs);
  }

  /// <summary>
  /// Check if the actual instance is of `AddedToCartObjectIDs` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsAddedToCartObjectIDs()
  {
    return ActualInstance.GetType() == typeof(AddedToCartObjectIDs);
  }

  /// <summary>
  /// Check if the actual instance is of `ConvertedObjectIDs` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsConvertedObjectIDs()
  {
    return ActualInstance.GetType() == typeof(ConvertedObjectIDs);
  }

  /// <summary>
  /// Check if the actual instance is of `ClickedFilters` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsClickedFilters()
  {
    return ActualInstance.GetType() == typeof(ClickedFilters);
  }

  /// <summary>
  /// Check if the actual instance is of `ConvertedFilters` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsConvertedFilters()
  {
    return ActualInstance.GetType() == typeof(ConvertedFilters);
  }

  /// <summary>
  /// Check if the actual instance is of `ViewedObjectIDs` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsViewedObjectIDs()
  {
    return ActualInstance.GetType() == typeof(ViewedObjectIDs);
  }

  /// <summary>
  /// Check if the actual instance is of `ViewedFilters` type.
  /// </summary>
  /// <returns>Whether or not the instance is the type</returns>
  public bool IsViewedFilters()
  {
    return ActualInstance.GetType() == typeof(ViewedFilters);
  }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    var sb = new StringBuilder();
    sb.Append("class EventsItems {\n");
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
  /// Converts the JSON string into an instance of EventsItems
  /// </summary>
  /// <param name="jsonString">JSON string</param>
  /// <returns>An instance of EventsItems</returns>
  public static EventsItems FromJson(string jsonString)
  {
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<ClickedObjectIDsAfterSearch>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into ClickedObjectIDsAfterSearch: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<AddedToCartObjectIDsAfterSearch>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into AddedToCartObjectIDsAfterSearch: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<PurchasedObjectIDsAfterSearch>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into PurchasedObjectIDsAfterSearch: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<ConvertedObjectIDsAfterSearch>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into ConvertedObjectIDsAfterSearch: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<ClickedObjectIDs>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into ClickedObjectIDs: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<PurchasedObjectIDs>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into PurchasedObjectIDs: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<AddedToCartObjectIDs>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into AddedToCartObjectIDs: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<ConvertedObjectIDs>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into ConvertedObjectIDs: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<ClickedFilters>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into ClickedFilters: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<ConvertedFilters>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into ConvertedFilters: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<ViewedObjectIDs>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into ViewedObjectIDs: {exception}");
    }
    try
    {
      return new EventsItems(JsonConvert.DeserializeObject<ViewedFilters>(jsonString, JsonConfig.DeserializeOneOfSettings));
    }
    catch (Exception exception)
    {
      // deserialization failed, try the next one
      System.Diagnostics.Debug.WriteLine($"Failed to deserialize `{jsonString}` into ViewedFilters: {exception}");
    }

    throw new InvalidDataException($"The JSON string `{jsonString}` cannot be deserialized into any schema defined.");
  }

}

/// <summary>
/// Custom JSON converter for EventsItems
/// </summary>
public class EventsItemsJsonConverter : JsonConverter
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

