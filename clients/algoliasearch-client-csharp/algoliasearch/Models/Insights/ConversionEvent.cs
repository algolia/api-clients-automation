//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Insights;

/// <summary>
/// Defines ConversionEvent
/// </summary>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<ConversionEvent>))]
public enum ConversionEvent
{
  /// <summary>
  /// Enum Conversion for value: conversion
  /// </summary>
  [JsonPropertyName("conversion")]
  Conversion = 1,
}
