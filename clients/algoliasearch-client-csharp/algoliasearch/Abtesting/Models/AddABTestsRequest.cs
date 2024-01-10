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

namespace Algolia.Search.Models.Abtesting
{
  /// <summary>
  /// AddABTestsRequest
  /// </summary>
  [DataContract(Name = "addABTestsRequest")]
  public partial class AddABTestsRequest
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="AddABTestsRequest" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public AddABTestsRequest() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="AddABTestsRequest" /> class.
    /// </summary>
    /// <param name="name">A/B test name. (required).</param>
    /// <param name="variants">A/B test variants. (required).</param>
    /// <param name="endAt">End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
    public AddABTestsRequest(string name, List<AddABTestsVariant> variants, string endAt)
    {
      this.Name = name ?? throw new ArgumentNullException("name is a required property for AddABTestsRequest and cannot be null");
      this.Variants = variants ?? throw new ArgumentNullException("variants is a required property for AddABTestsRequest and cannot be null");
      this.EndAt = endAt ?? throw new ArgumentNullException("endAt is a required property for AddABTestsRequest and cannot be null");
    }

    /// <summary>
    /// A/B test name.
    /// </summary>
    /// <value>A/B test name.</value>
    [DataMember(Name = "name", IsRequired = true, EmitDefaultValue = true)]
    public string Name { get; set; }

    /// <summary>
    /// A/B test variants.
    /// </summary>
    /// <value>A/B test variants.</value>
    [DataMember(Name = "variants", IsRequired = true, EmitDefaultValue = true)]
    public List<AddABTestsVariant> Variants { get; set; }

    /// <summary>
    /// End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.
    /// </summary>
    /// <value>End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
    [DataMember(Name = "endAt", IsRequired = true, EmitDefaultValue = true)]
    public string EndAt { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class AddABTestsRequest {\n");
      sb.Append("  Name: ").Append(Name).Append("\n");
      sb.Append("  Variants: ").Append(Variants).Append("\n");
      sb.Append("  EndAt: ").Append(EndAt).Append("\n");
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
