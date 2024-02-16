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
/// Used to sort the Task list endpoint.
/// </summary>
/// <value>Used to sort the Task list endpoint.</value>
public enum TaskSortKeys
{
  /// <summary>
  /// Enum Enabled for value: enabled
  /// </summary>
  [JsonPropertyName("enabled")]
  Enabled = 1,

  /// <summary>
  /// Enum TriggerType for value: triggerType
  /// </summary>
  [JsonPropertyName("triggerType")]
  TriggerType = 2,

  /// <summary>
  /// Enum Action for value: action
  /// </summary>
  [JsonPropertyName("action")]
  Action = 3,

  /// <summary>
  /// Enum UpdatedAt for value: updatedAt
  /// </summary>
  [JsonPropertyName("updatedAt")]
  UpdatedAt = 4,

  /// <summary>
  /// Enum CreatedAt for value: createdAt
  /// </summary>
  [JsonPropertyName("createdAt")]
  CreatedAt = 5
}

