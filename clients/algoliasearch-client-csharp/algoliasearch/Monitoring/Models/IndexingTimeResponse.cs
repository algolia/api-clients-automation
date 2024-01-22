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
  /// IndexingTimeResponse
  /// </summary>
  [DataContract(Name = "IndexingTimeResponse")]
  [JsonObject(MemberSerialization.OptOut)]
  public partial class IndexingTimeResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="IndexingTimeResponse" /> class.
    /// </summary>
    public IndexingTimeResponse()
    {
    }

    /// <summary>
    /// Gets or Sets Metrics
    /// </summary>
    [DataMember(Name = "metrics", EmitDefaultValue = false)]
    public IndexingTimeResponseMetrics Metrics { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class IndexingTimeResponse {\n");
      sb.Append("  Metrics: ").Append(Metrics).Append("\n");
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
