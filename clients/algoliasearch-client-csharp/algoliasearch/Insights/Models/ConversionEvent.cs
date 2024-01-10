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
using Algolia.Search.Models;

namespace Algolia.Search.Models.Insights
{
  /// <summary>
  /// Defines ConversionEvent
  /// </summary>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum ConversionEvent
  {
    /// <summary>
    /// Enum Conversion for value: conversion
    /// </summary>
    [EnumMember(Value = "conversion")]
    Conversion = 1
  }

}
