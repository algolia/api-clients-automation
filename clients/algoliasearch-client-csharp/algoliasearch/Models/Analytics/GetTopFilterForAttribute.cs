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
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Analytics;

/// <summary>
/// GetTopFilterForAttribute
/// </summary>
[DataContract(Name = "getTopFilterForAttribute")]
public partial class GetTopFilterForAttribute
{
  /// <summary>
  /// Initializes a new instance of the GetTopFilterForAttribute class.
  /// </summary>
  [JsonConstructor]
  public GetTopFilterForAttribute() { }
  /// <summary>
  /// Initializes a new instance of the GetTopFilterForAttribute class.
  /// </summary>
  /// <param name="attribute">Attribute name. (required).</param>
  /// <param name="varOperator">Operator. (required).</param>
  /// <param name="value">Attribute value. (required).</param>
  /// <param name="count">Number of occurrences. (required).</param>
  public GetTopFilterForAttribute(string attribute, string varOperator, string value, int count)
  {
    Attribute = attribute ?? throw new ArgumentNullException(nameof(attribute));
    VarOperator = varOperator ?? throw new ArgumentNullException(nameof(varOperator));
    Value = value ?? throw new ArgumentNullException(nameof(value));
    Count = count;
  }

  /// <summary>
  /// Attribute name.
  /// </summary>
  /// <value>Attribute name.</value>
  [DataMember(Name = "attribute")]
  public string Attribute { get; set; }

  /// <summary>
  /// Operator.
  /// </summary>
  /// <value>Operator.</value>
  [DataMember(Name = "operator")]
  public string VarOperator { get; set; }

  /// <summary>
  /// Attribute value.
  /// </summary>
  /// <value>Attribute value.</value>
  [DataMember(Name = "value")]
  public string Value { get; set; }

  /// <summary>
  /// Number of occurrences.
  /// </summary>
  /// <value>Number of occurrences.</value>
  [DataMember(Name = "count")]
  public int Count { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class GetTopFilterForAttribute {\n");
    sb.Append("  Attribute: ").Append(Attribute).Append("\n");
    sb.Append("  VarOperator: ").Append(VarOperator).Append("\n");
    sb.Append("  Value: ").Append(Value).Append("\n");
    sb.Append("  Count: ").Append(Count).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonConvert.SerializeObject(this, Formatting.Indented);
  }

}

