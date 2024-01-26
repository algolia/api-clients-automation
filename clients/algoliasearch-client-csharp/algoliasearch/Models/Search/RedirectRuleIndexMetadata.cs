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

namespace Algolia.Search.Models.Search;

/// <summary>
/// RedirectRuleIndexMetadata
/// </summary>
[DataContract(Name = "RedirectRuleIndexMetadata")]
[JsonObject(MemberSerialization.OptOut)]
public partial class RedirectRuleIndexMetadata
{
  /// <summary>
  /// Initializes a new instance of the RedirectRuleIndexMetadata class.
  /// </summary>
  [JsonConstructor]
  public RedirectRuleIndexMetadata() { }
  /// <summary>
  /// Initializes a new instance of the RedirectRuleIndexMetadata class.
  /// </summary>
  /// <param name="varSource">Source index for the redirect rule. (required).</param>
  /// <param name="dest">Destination index for the redirect rule. (required).</param>
  /// <param name="reason">Reason for the redirect rule. (required).</param>
  /// <param name="succeed">Redirect rule status. (required).</param>
  /// <param name="data">data (required).</param>
  public RedirectRuleIndexMetadata(string varSource, string dest, string reason, bool? succeed, RedirectRuleIndexMetadataData data)
  {
    VarSource = varSource ?? throw new ArgumentNullException(nameof(varSource));
    Dest = dest ?? throw new ArgumentNullException(nameof(dest));
    Reason = reason ?? throw new ArgumentNullException(nameof(reason));
    Succeed = succeed;
    Data = data ?? throw new ArgumentNullException(nameof(data));
  }

  /// <summary>
  /// Source index for the redirect rule.
  /// </summary>
  /// <value>Source index for the redirect rule.</value>
  [DataMember(Name = "source", IsRequired = true, EmitDefaultValue = false)]
  public string VarSource { get; set; }

  /// <summary>
  /// Destination index for the redirect rule.
  /// </summary>
  /// <value>Destination index for the redirect rule.</value>
  [DataMember(Name = "dest", IsRequired = true, EmitDefaultValue = false)]
  public string Dest { get; set; }

  /// <summary>
  /// Reason for the redirect rule.
  /// </summary>
  /// <value>Reason for the redirect rule.</value>
  [DataMember(Name = "reason", IsRequired = true, EmitDefaultValue = false)]
  public string Reason { get; set; }

  /// <summary>
  /// Redirect rule status.
  /// </summary>
  /// <value>Redirect rule status.</value>
  [DataMember(Name = "succeed", IsRequired = true, EmitDefaultValue = false)]
  public bool? Succeed { get; set; }

  /// <summary>
  /// Gets or Sets Data
  /// </summary>
  [DataMember(Name = "data", IsRequired = true, EmitDefaultValue = false)]
  public RedirectRuleIndexMetadataData Data { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class RedirectRuleIndexMetadata {\n");
    sb.Append("  VarSource: ").Append(VarSource).Append("\n");
    sb.Append("  Dest: ").Append(Dest).Append("\n");
    sb.Append("  Reason: ").Append(Reason).Append("\n");
    sb.Append("  Succeed: ").Append(Succeed).Append("\n");
    sb.Append("  Data: ").Append(Data).Append("\n");
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

