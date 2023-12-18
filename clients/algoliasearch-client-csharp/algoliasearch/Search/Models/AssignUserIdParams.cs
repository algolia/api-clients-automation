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
  /// Assign userID parameters.
  /// </summary>
  [DataContract(Name = "assignUserIdParams")]
  public partial class AssignUserIdParams
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="AssignUserIdParams" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected AssignUserIdParams() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="AssignUserIdParams" /> class.
    /// </summary>
    /// <param name="cluster">Cluster name. (required).</param>
    public AssignUserIdParams(string cluster = default(string))
    {
      // to ensure "cluster" is required (not null)
      if (cluster == null)
      {
        throw new ArgumentNullException("cluster is a required property for AssignUserIdParams and cannot be null");
      }
      this.Cluster = cluster;
    }

    /// <summary>
    /// Cluster name.
    /// </summary>
    /// <value>Cluster name.</value>
    [DataMember(Name = "cluster", IsRequired = true, EmitDefaultValue = true)]
    public string Cluster { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class AssignUserIdParams {\n");
      sb.Append("  Cluster: ").Append(Cluster).Append("\n");
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
