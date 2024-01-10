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

namespace Algolia.Search.Models.Monitoring
{
  /// <summary>
  /// The region where the cluster is located.
  /// </summary>
  /// <value>The region where the cluster is located.</value>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum Region
  {
    /// <summary>
    /// Enum Au for value: au
    /// </summary>
    [EnumMember(Value = "au")]
    Au = 1,

    /// <summary>
    /// Enum Br for value: br
    /// </summary>
    [EnumMember(Value = "br")]
    Br = 2,

    /// <summary>
    /// Enum Ca for value: ca
    /// </summary>
    [EnumMember(Value = "ca")]
    Ca = 3,

    /// <summary>
    /// Enum De for value: de
    /// </summary>
    [EnumMember(Value = "de")]
    De = 4,

    /// <summary>
    /// Enum Eu for value: eu
    /// </summary>
    [EnumMember(Value = "eu")]
    Eu = 5,

    /// <summary>
    /// Enum Hk for value: hk
    /// </summary>
    [EnumMember(Value = "hk")]
    Hk = 6,

    /// <summary>
    /// Enum In for value: in
    /// </summary>
    [EnumMember(Value = "in")]
    In = 7,

    /// <summary>
    /// Enum Jp for value: jp
    /// </summary>
    [EnumMember(Value = "jp")]
    Jp = 8,

    /// <summary>
    /// Enum Sg for value: sg
    /// </summary>
    [EnumMember(Value = "sg")]
    Sg = 9,

    /// <summary>
    /// Enum Uae for value: uae
    /// </summary>
    [EnumMember(Value = "uae")]
    Uae = 10,

    /// <summary>
    /// Enum Uk for value: uk
    /// </summary>
    [EnumMember(Value = "uk")]
    Uk = 11,

    /// <summary>
    /// Enum Usc for value: usc
    /// </summary>
    [EnumMember(Value = "usc")]
    Usc = 12,

    /// <summary>
    /// Enum Use for value: use
    /// </summary>
    [EnumMember(Value = "use")]
    Use = 13,

    /// <summary>
    /// Enum Usw for value: usw
    /// </summary>
    [EnumMember(Value = "usw")]
    Usw = 14,

    /// <summary>
    /// Enum Za for value: za
    /// </summary>
    [EnumMember(Value = "za")]
    Za = 15
  }

}
