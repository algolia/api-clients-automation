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

namespace Algolia.Search.Monitoring.Models
{
  /// <summary>
  /// IncidentsResponse
  /// </summary>
  [DataContract(Name = "IncidentsResponse")]
  public partial class IncidentsResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="IncidentsResponse" /> class.
    /// </summary>
    /// <param name="incidents">incidents.</param>
    public IncidentsResponse(Dictionary<string, List<IncidentsInner>> incidents = default(Dictionary<string, List<IncidentsInner>>))
    {
      this.Incidents = incidents;
    }

    /// <summary>
    /// Gets or Sets Incidents
    /// </summary>
    [DataMember(Name = "incidents", EmitDefaultValue = false)]
    public Dictionary<string, List<IncidentsInner>> Incidents { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class IncidentsResponse {\n");
      sb.Append("  Incidents: ").Append(Incidents).Append("\n");
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
