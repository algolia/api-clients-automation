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
using System.ComponentModel.DataAnnotations;
using FileParameter = Algolia.Search.Ingestion.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Ingestion.Client.OpenAPIDateConverter;

namespace Algolia.Search.Ingestion.Models
{
  /// <summary>
  /// Determines the indexing strategy to use for a given e-commerce source.
  /// </summary>
  /// <value>Determines the indexing strategy to use for a given e-commerce source.</value>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum RecordType
  {
    /// <summary>
    /// Enum Product for value: product
    /// </summary>
    [EnumMember(Value = "product")]
    Product = 1,

    /// <summary>
    /// Enum Variant for value: variant
    /// </summary>
    [EnumMember(Value = "variant")]
    Variant = 2
  }

}
