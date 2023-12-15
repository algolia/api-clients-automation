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

namespace Algolia.Search.Search.Models
{
  /// <summary>
  /// Source.
  /// </summary>
  [DataContract(Name = "source")]
  public partial class Source
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="Source" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected Source() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="Source" /> class.
    /// </summary>
    /// <param name="varSource">IP address range of the source. (required).</param>
    /// <param name="description">Source description..</param>
    public Source(string varSource = default(string), string description = default(string))
    {
      // to ensure "varSource" is required (not null)
      if (varSource == null)
      {
        throw new ArgumentNullException("varSource is a required property for Source and cannot be null");
      }
      this.VarSource = varSource;
      this.Description = description;
    }

    /// <summary>
    /// IP address range of the source.
    /// </summary>
    /// <value>IP address range of the source.</value>
    [DataMember(Name = "source", IsRequired = true, EmitDefaultValue = true)]
    public string VarSource { get; set; }

    /// <summary>
    /// Source description.
    /// </summary>
    /// <value>Source description.</value>
    [DataMember(Name = "description", EmitDefaultValue = false)]
    public string Description { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Source {\n");
      sb.Append("  VarSource: ").Append(VarSource).Append("\n");
      sb.Append("  Description: ").Append(Description).Append("\n");
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
