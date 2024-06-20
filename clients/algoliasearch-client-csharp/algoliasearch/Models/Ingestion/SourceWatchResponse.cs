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

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// SourceWatchResponse
/// </summary>
public partial class SourceWatchResponse
{
  /// <summary>
  /// Initializes a new instance of the SourceWatchResponse class.
  /// </summary>
  [JsonConstructor]
  public SourceWatchResponse() { }
  /// <summary>
  /// Initializes a new instance of the SourceWatchResponse class.
  /// </summary>
  /// <param name="message">a message describing the outcome of a validate run. (required).</param>
  public SourceWatchResponse(string message)
  {
    Message = message ?? throw new ArgumentNullException(nameof(message));
  }

  /// <summary>
  /// Universally unique identifier (UUID) of a task run.
  /// </summary>
  /// <value>Universally unique identifier (UUID) of a task run.</value>
  [JsonPropertyName("runID")]
  public string RunID { get; set; }

  /// <summary>
  /// depending on the source type, the validation returns sampling data of your source (JSON, CSV, BigQuery).
  /// </summary>
  /// <value>depending on the source type, the validation returns sampling data of your source (JSON, CSV, BigQuery).</value>
  [JsonPropertyName("data")]
  public List<object> Data { get; set; }

  /// <summary>
  /// in case of error, observability events will be added to the response, if any.
  /// </summary>
  /// <value>in case of error, observability events will be added to the response, if any.</value>
  [JsonPropertyName("events")]
  public List<Event> Events { get; set; }

  /// <summary>
  /// a message describing the outcome of a validate run.
  /// </summary>
  /// <value>a message describing the outcome of a validate run.</value>
  [JsonPropertyName("message")]
  public string Message { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SourceWatchResponse {\n");
    sb.Append("  RunID: ").Append(RunID).Append("\n");
    sb.Append("  Data: ").Append(Data).Append("\n");
    sb.Append("  Events: ").Append(Events).Append("\n");
    sb.Append("  Message: ").Append(Message).Append("\n");
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
    if (obj is not SourceWatchResponse input)
    {
      return false;
    }

    return
        (RunID == input.RunID || (RunID != null && RunID.Equals(input.RunID))) &&
        (Data == input.Data || Data != null && input.Data != null && Data.SequenceEqual(input.Data)) &&
        (Events == input.Events || Events != null && input.Events != null && Events.SequenceEqual(input.Events)) &&
        (Message == input.Message || (Message != null && Message.Equals(input.Message)));
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
      if (RunID != null)
      {
        hashCode = (hashCode * 59) + RunID.GetHashCode();
      }
      if (Data != null)
      {
        hashCode = (hashCode * 59) + Data.GetHashCode();
      }
      if (Events != null)
      {
        hashCode = (hashCode * 59) + Events.GetHashCode();
      }
      if (Message != null)
      {
        hashCode = (hashCode * 59) + Message.GetHashCode();
      }
      return hashCode;
    }
  }

}

