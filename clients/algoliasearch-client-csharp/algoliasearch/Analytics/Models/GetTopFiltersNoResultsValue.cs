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

namespace Algolia.Search.Models.Analytics
{
  /// <summary>
  /// GetTopFiltersNoResultsValue
  /// </summary>
  [DataContract(Name = "getTopFiltersNoResultsValue")]
  [JsonObject(MemberSerialization.OptOut)]
  public partial class GetTopFiltersNoResultsValue
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="GetTopFiltersNoResultsValue" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public GetTopFiltersNoResultsValue() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="GetTopFiltersNoResultsValue" /> class.
    /// </summary>
    /// <param name="attribute">Attribute name. (required).</param>
    /// <param name="varOperator">Operator. (required).</param>
    /// <param name="value">Attribute value. (required).</param>
    public GetTopFiltersNoResultsValue(string attribute, string varOperator, string value)
    {
      this.Attribute = attribute ?? throw new ArgumentNullException("attribute is a required property for GetTopFiltersNoResultsValue and cannot be null");
      this.VarOperator = varOperator ?? throw new ArgumentNullException("varOperator is a required property for GetTopFiltersNoResultsValue and cannot be null");
      this.Value = value ?? throw new ArgumentNullException("value is a required property for GetTopFiltersNoResultsValue and cannot be null");
    }

    /// <summary>
    /// Attribute name.
    /// </summary>
    /// <value>Attribute name.</value>
    [DataMember(Name = "attribute", IsRequired = true, EmitDefaultValue = false)]
    public string Attribute { get; set; }

    /// <summary>
    /// Operator.
    /// </summary>
    /// <value>Operator.</value>
    [DataMember(Name = "operator", IsRequired = true, EmitDefaultValue = false)]
    public string VarOperator { get; set; }

    /// <summary>
    /// Attribute value.
    /// </summary>
    /// <value>Attribute value.</value>
    [DataMember(Name = "value", IsRequired = true, EmitDefaultValue = false)]
    public string Value { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class GetTopFiltersNoResultsValue {\n");
      sb.Append("  Attribute: ").Append(Attribute).Append("\n");
      sb.Append("  VarOperator: ").Append(VarOperator).Append("\n");
      sb.Append("  Value: ").Append(Value).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public virtual string ToJson()
    {
      return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
    }

  }

}
