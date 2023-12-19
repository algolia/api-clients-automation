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

namespace Algolia.Search.Analytics.Models
{
  /// <summary>
  /// GetClickPositionsResponse
  /// </summary>
  [DataContract(Name = "getClickPositionsResponse")]
  public partial class GetClickPositionsResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="GetClickPositionsResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected GetClickPositionsResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="GetClickPositionsResponse" /> class.
    /// </summary>
    /// <param name="positions">Click positions. (required).</param>
    public GetClickPositionsResponse(List<ClickPosition> positions = default(List<ClickPosition>))
    {
      // to ensure "positions" is required (not null)
      if (positions == null)
      {
        throw new ArgumentNullException("positions is a required property for GetClickPositionsResponse and cannot be null");
      }
      this.Positions = positions;
    }

    /// <summary>
    /// Click positions.
    /// </summary>
    /// <value>Click positions.</value>
    [DataMember(Name = "positions", IsRequired = true, EmitDefaultValue = true)]
    public List<ClickPosition> Positions { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class GetClickPositionsResponse {\n");
      sb.Append("  Positions: ").Append(Positions).Append("\n");
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
