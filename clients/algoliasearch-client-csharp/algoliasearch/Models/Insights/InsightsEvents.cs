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

namespace Algolia.Search.Models.Insights;

/// <summary>
/// InsightsEvents
/// </summary>
public partial class InsightsEvents
{
  /// <summary>
  /// Initializes a new instance of the InsightsEvents class.
  /// </summary>
  [JsonConstructor]
  public InsightsEvents() { }
  /// <summary>
  /// Initializes a new instance of the InsightsEvents class.
  /// </summary>
  /// <param name="events">Click and conversion events.  **All** events must be valid, otherwise the API returns an error.  (required).</param>
  public InsightsEvents(List<EventsItems> events)
  {
    Events = events ?? throw new ArgumentNullException(nameof(events));
  }

  /// <summary>
  /// Click and conversion events.  **All** events must be valid, otherwise the API returns an error. 
  /// </summary>
  /// <value>Click and conversion events.  **All** events must be valid, otherwise the API returns an error. </value>
  [JsonPropertyName("events")]
  public List<EventsItems> Events { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class InsightsEvents {\n");
    sb.Append("  Events: ").Append(Events).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonSerializer.Serialize(this, JsonConfig.Options);
  }

  /// <summary>
  /// Returns true if objects are equal
  /// </summary>
  /// <param name="obj">Object to be compared</param>
  /// <returns>Boolean</returns>
  public override bool Equals(object obj)
  {
    if (obj is not InsightsEvents input)
    {
      return false;
    }

    return
        (Events == input.Events || Events != null && input.Events != null && Events.SequenceEqual(input.Events));
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
      if (Events != null)
      {
        hashCode = (hashCode * 59) + Events.GetHashCode();
      }
      return hashCode;
    }
  }

}

