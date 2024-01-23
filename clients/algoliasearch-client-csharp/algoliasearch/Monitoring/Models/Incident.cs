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
  /// Incident details.
  /// </summary>
  [DataContract(Name = "Incident")]
  [JsonObject(MemberSerialization.OptOut)]
  public partial class Incident
  {

    /// <summary>
    /// Gets or Sets Status
    /// </summary>
    [DataMember(Name = "status", EmitDefaultValue = false)]
    public Status Status { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="Incident" /> class.
    /// </summary>
    public Incident()
    {
    }

    /// <summary>
    /// Description of the incident.
    /// </summary>
    /// <value>Description of the incident.</value>
    [DataMember(Name = "title", EmitDefaultValue = false)]
    public string Title { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Incident {\n");
      sb.Append("  Title: ").Append(Title).Append("\n");
      sb.Append("  Status: ").Append(Status).Append("\n");
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
