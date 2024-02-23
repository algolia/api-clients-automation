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

namespace Algolia.Search.Models.Search;

/// <summary>
/// Rule object.
/// </summary>
public partial class Rule
{
  /// <summary>
  /// Initializes a new instance of the Rule class.
  /// </summary>
  [JsonConstructor]
  public Rule() { }
  /// <summary>
  /// Initializes a new instance of the Rule class.
  /// </summary>
  /// <param name="objectID">Unique identifier for a rule object. (required).</param>
  public Rule(string objectID)
  {
    ObjectID = objectID ?? throw new ArgumentNullException(nameof(objectID));
  }

  /// <summary>
  /// Unique identifier for a rule object.
  /// </summary>
  /// <value>Unique identifier for a rule object.</value>
  [JsonPropertyName("objectID")]
  public string ObjectID { get; set; }

  /// <summary>
  /// [Conditions](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#conditions) required to activate a rule. You can use up to 25 conditions per rule. 
  /// </summary>
  /// <value>[Conditions](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#conditions) required to activate a rule. You can use up to 25 conditions per rule. </value>
  [JsonPropertyName("conditions")]
  public List<Condition> Conditions { get; set; }

  /// <summary>
  /// Gets or Sets Consequence
  /// </summary>
  [JsonPropertyName("consequence")]
  public Consequence Consequence { get; set; }

  /// <summary>
  /// Description of the rule's purpose. This can be helpful for display in the Algolia dashboard.
  /// </summary>
  /// <value>Description of the rule's purpose. This can be helpful for display in the Algolia dashboard.</value>
  [JsonPropertyName("description")]
  public string Description { get; set; }

  /// <summary>
  /// Indicates whether to enable the rule. If it isn't enabled, it isn't applied at query time.
  /// </summary>
  /// <value>Indicates whether to enable the rule. If it isn't enabled, it isn't applied at query time.</value>
  [JsonPropertyName("enabled")]
  public bool? Enabled { get; set; }

  /// <summary>
  /// If you specify a validity period, the rule _only_ applies only during that period. If specified, the array must not be empty.
  /// </summary>
  /// <value>If you specify a validity period, the rule _only_ applies only during that period. If specified, the array must not be empty.</value>
  [JsonPropertyName("validity")]
  public List<TimeRange> Validity { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class Rule {\n");
    sb.Append("  ObjectID: ").Append(ObjectID).Append("\n");
    sb.Append("  Conditions: ").Append(Conditions).Append("\n");
    sb.Append("  Consequence: ").Append(Consequence).Append("\n");
    sb.Append("  Description: ").Append(Description).Append("\n");
    sb.Append("  Enabled: ").Append(Enabled).Append("\n");
    sb.Append("  Validity: ").Append(Validity).Append("\n");
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
    if (obj is not Rule input)
    {
      return false;
    }

    return
        (ObjectID == input.ObjectID || (ObjectID != null && ObjectID.Equals(input.ObjectID))) &&
        (Conditions == input.Conditions || Conditions != null && input.Conditions != null && Conditions.SequenceEqual(input.Conditions)) &&
        (Consequence == input.Consequence || (Consequence != null && Consequence.Equals(input.Consequence))) &&
        (Description == input.Description || (Description != null && Description.Equals(input.Description))) &&
        (Enabled == input.Enabled || Enabled.Equals(input.Enabled)) &&
        (Validity == input.Validity || Validity != null && input.Validity != null && Validity.SequenceEqual(input.Validity));
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
      if (ObjectID != null)
      {
        hashCode = (hashCode * 59) + ObjectID.GetHashCode();
      }
      if (Conditions != null)
      {
        hashCode = (hashCode * 59) + Conditions.GetHashCode();
      }
      if (Consequence != null)
      {
        hashCode = (hashCode * 59) + Consequence.GetHashCode();
      }
      if (Description != null)
      {
        hashCode = (hashCode * 59) + Description.GetHashCode();
      }
      hashCode = (hashCode * 59) + Enabled.GetHashCode();
      if (Validity != null)
      {
        hashCode = (hashCode * 59) + Validity.GetHashCode();
      }
      return hashCode;
    }
  }

}

