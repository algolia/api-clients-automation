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

namespace Algolia.Search.Models.Ingestion
{
  /// <summary>
  /// DestinationIndexPrefix
  /// </summary>
  [DataContract(Name = "DestinationIndexPrefix")]
  [JsonObject(MemberSerialization.OptOut)]
  public partial class DestinationIndexPrefix
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="DestinationIndexPrefix" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public DestinationIndexPrefix() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="DestinationIndexPrefix" /> class.
    /// </summary>
    /// <param name="indexPrefix">The prefix of the final index name. (required).</param>
    public DestinationIndexPrefix(string indexPrefix)
    {
      this.IndexPrefix = indexPrefix ?? throw new ArgumentNullException("indexPrefix is a required property for DestinationIndexPrefix and cannot be null");
    }

    /// <summary>
    /// The prefix of the final index name.
    /// </summary>
    /// <value>The prefix of the final index name.</value>
    [DataMember(Name = "indexPrefix", IsRequired = true, EmitDefaultValue = false)]
    public string IndexPrefix { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class DestinationIndexPrefix {\n");
      sb.Append("  IndexPrefix: ").Append(IndexPrefix).Append("\n");
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
