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
/// Task run outcome.
/// </summary>
/// <value>Task run outcome.</value>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<RunOutcome>))]
public enum RunOutcome
{
  /// <summary>
  /// Enum Success for value: success
  /// </summary>
  [JsonPropertyName("success")]
  Success = 1,

  /// <summary>
  /// Enum Failure for value: failure
  /// </summary>
  [JsonPropertyName("failure")]
  Failure = 2
}

