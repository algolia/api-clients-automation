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
/// The trigger input for a task of type 'schedule'.
/// </summary>
public partial class ScheduleTriggerInput
{

  /// <summary>
  /// Gets or Sets Type
  /// </summary>
  [JsonPropertyName("type")]
  public ScheduleTriggerType? Type { get; set; }
  /// <summary>
  /// Initializes a new instance of the ScheduleTriggerInput class.
  /// </summary>
  [JsonConstructor]
  public ScheduleTriggerInput() { }
  /// <summary>
  /// Initializes a new instance of the ScheduleTriggerInput class.
  /// </summary>
  /// <param name="type">type (required).</param>
  /// <param name="cron">A cron expression that represent at which regularity the task should run. (required).</param>
  public ScheduleTriggerInput(ScheduleTriggerType? type, string cron)
  {
    Type = type;
    Cron = cron ?? throw new ArgumentNullException(nameof(cron));
  }

  /// <summary>
  /// A cron expression that represent at which regularity the task should run.
  /// </summary>
  /// <value>A cron expression that represent at which regularity the task should run.</value>
  [JsonPropertyName("cron")]
  public string Cron { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ScheduleTriggerInput {\n");
    sb.Append("  Type: ").Append(Type).Append("\n");
    sb.Append("  Cron: ").Append(Cron).Append("\n");
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
    if (obj is not ScheduleTriggerInput input)
    {
      return false;
    }

    return
        (Type == input.Type || Type.Equals(input.Type)) &&
        (Cron == input.Cron || (Cron != null && Cron.Equals(input.Cron)));
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
      hashCode = (hashCode * 59) + Type.GetHashCode();
      if (Cron != null)
      {
        hashCode = (hashCode * 59) + Cron.GetHashCode();
      }
      return hashCode;
    }
  }

}

