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
/// Describes how a destination object should be resolved by means of applying a set of directives.
/// </summary>
public partial class MappingKitAction
{
  /// <summary>
  /// Initializes a new instance of the MappingKitAction class.
  /// </summary>
  [JsonConstructor]
  public MappingKitAction() { }
  /// <summary>
  /// Initializes a new instance of the MappingKitAction class.
  /// </summary>
  /// <param name="enabled">Whether this action has any effect. (required).</param>
  /// <param name="trigger">Condition which must be satisfied to apply the action. If this evaluates to false, the action is not applied, and the process attempts to apply the next action, if any. (required).</param>
  /// <param name="fieldDirectives">fieldDirectives (required).</param>
  public MappingKitAction(bool enabled, string trigger, List<MappingFieldDirective> fieldDirectives)
  {
    Enabled = enabled;
    Trigger = trigger ?? throw new ArgumentNullException(nameof(trigger));
    FieldDirectives = fieldDirectives ?? throw new ArgumentNullException(nameof(fieldDirectives));
  }

  /// <summary>
  /// ID to uniquely identify this action.
  /// </summary>
  /// <value>ID to uniquely identify this action.</value>
  [JsonPropertyName("id")]
  public string Id { get; set; }

  /// <summary>
  /// Whether this action has any effect.
  /// </summary>
  /// <value>Whether this action has any effect.</value>
  [JsonPropertyName("enabled")]
  public bool Enabled { get; set; }

  /// <summary>
  /// Condition which must be satisfied to apply the action. If this evaluates to false, the action is not applied, and the process attempts to apply the next action, if any.
  /// </summary>
  /// <value>Condition which must be satisfied to apply the action. If this evaluates to false, the action is not applied, and the process attempts to apply the next action, if any.</value>
  [JsonPropertyName("trigger")]
  public string Trigger { get; set; }

  /// <summary>
  /// Gets or Sets FieldDirectives
  /// </summary>
  [JsonPropertyName("fieldDirectives")]
  public List<MappingFieldDirective> FieldDirectives { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class MappingKitAction {\n");
    sb.Append("  Id: ").Append(Id).Append("\n");
    sb.Append("  Enabled: ").Append(Enabled).Append("\n");
    sb.Append("  Trigger: ").Append(Trigger).Append("\n");
    sb.Append("  FieldDirectives: ").Append(FieldDirectives).Append("\n");
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
    if (obj is not MappingKitAction input)
    {
      return false;
    }

    return
        (Id == input.Id || (Id != null && Id.Equals(input.Id))) &&
        (Enabled == input.Enabled || Enabled.Equals(input.Enabled)) &&
        (Trigger == input.Trigger || (Trigger != null && Trigger.Equals(input.Trigger))) &&
        (FieldDirectives == input.FieldDirectives || FieldDirectives != null && input.FieldDirectives != null && FieldDirectives.SequenceEqual(input.FieldDirectives));
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
      if (Id != null)
      {
        hashCode = (hashCode * 59) + Id.GetHashCode();
      }
      hashCode = (hashCode * 59) + Enabled.GetHashCode();
      if (Trigger != null)
      {
        hashCode = (hashCode * 59) + Trigger.GetHashCode();
      }
      if (FieldDirectives != null)
      {
        hashCode = (hashCode * 59) + FieldDirectives.GetHashCode();
      }
      return hashCode;
    }
  }

}

