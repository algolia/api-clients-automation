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

namespace Algolia.Search.Models.Abtesting;

/// <summary>
/// CurrenciesValue
/// </summary>
[DataContract(Name = "currencies_value")]
[JsonObject(MemberSerialization.OptOut)]
public partial class CurrenciesValue
{
  /// <summary>
  /// Initializes a new instance of the CurrenciesValue class.
  /// </summary>
  public CurrenciesValue()
  {
  }

  /// <summary>
  /// Currency code.
  /// </summary>
  /// <value>Currency code.</value>
  [DataMember(Name = "currency", EmitDefaultValue = false)]
  public string Currency { get; set; }

  /// <summary>
  /// Revenue for this currency.
  /// </summary>
  /// <value>Revenue for this currency.</value>
  [DataMember(Name = "revenue", EmitDefaultValue = false)]
  public double Revenue { get; set; }

  /// <summary>
  /// Mean for this currency.
  /// </summary>
  /// <value>Mean for this currency.</value>
  [DataMember(Name = "mean", EmitDefaultValue = false)]
  public double Mean { get; set; }

  /// <summary>
  /// Standard deviation for this currency.
  /// </summary>
  /// <value>Standard deviation for this currency.</value>
  [DataMember(Name = "standardDeviation", EmitDefaultValue = false)]
  public double StandardDeviation { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class CurrenciesValue {\n");
    sb.Append("  Currency: ").Append(Currency).Append("\n");
    sb.Append("  Revenue: ").Append(Revenue).Append("\n");
    sb.Append("  Mean: ").Append(Mean).Append("\n");
    sb.Append("  StandardDeviation: ").Append(StandardDeviation).Append("\n");
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

