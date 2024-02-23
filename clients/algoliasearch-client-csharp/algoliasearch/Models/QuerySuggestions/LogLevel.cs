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

namespace Algolia.Search.Models.QuerySuggestions;

/// <summary>
/// The type of log entry.   - `SKIP`. A query is skipped because it doesn't match the conditions for successful inclusion. For example, when a query doesn't generate enough search results. - `INFO`. An informative log entry. - `ERROR`. The Query Suggestions process encountered an error. 
/// </summary>
/// <value>The type of log entry.   - `SKIP`. A query is skipped because it doesn't match the conditions for successful inclusion. For example, when a query doesn't generate enough search results. - `INFO`. An informative log entry. - `ERROR`. The Query Suggestions process encountered an error. </value>
public enum LogLevel
{
  /// <summary>
  /// Enum SKIP for value: SKIP
  /// </summary>
  [JsonPropertyName("SKIP")]
  SKIP = 1,

  /// <summary>
  /// Enum INFO for value: INFO
  /// </summary>
  [JsonPropertyName("INFO")]
  INFO = 2,

  /// <summary>
  /// Enum ERROR for value: ERROR
  /// </summary>
  [JsonPropertyName("ERROR")]
  ERROR = 3
}

