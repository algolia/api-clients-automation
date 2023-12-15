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

namespace Algolia.Search.Ingestion.Models
{
  /// <summary>
  /// SourceUpdateResponse
  /// </summary>
  [DataContract(Name = "SourceUpdateResponse")]
  public partial class SourceUpdateResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SourceUpdateResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected SourceUpdateResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="SourceUpdateResponse" /> class.
    /// </summary>
    /// <param name="sourceID">The source UUID. (required).</param>
    /// <param name="name">name (required).</param>
    /// <param name="updatedAt">Date of last update (RFC3339 format). (required).</param>
    public SourceUpdateResponse(string sourceID = default(string), string name = default(string), string updatedAt = default(string))
    {
      // to ensure "sourceID" is required (not null)
      if (sourceID == null)
      {
        throw new ArgumentNullException("sourceID is a required property for SourceUpdateResponse and cannot be null");
      }
      this.SourceID = sourceID;
      // to ensure "name" is required (not null)
      if (name == null)
      {
        throw new ArgumentNullException("name is a required property for SourceUpdateResponse and cannot be null");
      }
      this.Name = name;
      // to ensure "updatedAt" is required (not null)
      if (updatedAt == null)
      {
        throw new ArgumentNullException("updatedAt is a required property for SourceUpdateResponse and cannot be null");
      }
      this.UpdatedAt = updatedAt;
    }

    /// <summary>
    /// The source UUID.
    /// </summary>
    /// <value>The source UUID.</value>
    [DataMember(Name = "sourceID", IsRequired = true, EmitDefaultValue = true)]
    public string SourceID { get; set; }

    /// <summary>
    /// Gets or Sets Name
    /// </summary>
    [DataMember(Name = "name", IsRequired = true, EmitDefaultValue = true)]
    public string Name { get; set; }

    /// <summary>
    /// Date of last update (RFC3339 format).
    /// </summary>
    /// <value>Date of last update (RFC3339 format).</value>
    [DataMember(Name = "updatedAt", IsRequired = true, EmitDefaultValue = true)]
    public string UpdatedAt { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SourceUpdateResponse {\n");
      sb.Append("  SourceID: ").Append(SourceID).Append("\n");
      sb.Append("  Name: ").Append(Name).Append("\n");
      sb.Append("  UpdatedAt: ").Append(UpdatedAt).Append("\n");
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
