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
  /// ListAuthenticationsResponse
  /// </summary>
  [DataContract(Name = "listAuthenticationsResponse")]
  public partial class ListAuthenticationsResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="ListAuthenticationsResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public ListAuthenticationsResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="ListAuthenticationsResponse" /> class.
    /// </summary>
    /// <param name="authentications">authentications (required).</param>
    /// <param name="pagination">pagination (required).</param>
    public ListAuthenticationsResponse(List<Authentication> authentications, Pagination pagination)
    {
      this.Authentications = authentications ?? throw new ArgumentNullException("authentications is a required property for ListAuthenticationsResponse and cannot be null");
      this.Pagination = pagination ?? throw new ArgumentNullException("pagination is a required property for ListAuthenticationsResponse and cannot be null");
    }

    /// <summary>
    /// Gets or Sets Authentications
    /// </summary>
    [DataMember(Name = "authentications", IsRequired = true, EmitDefaultValue = true)]
    public List<Authentication> Authentications { get; set; }

    /// <summary>
    /// Gets or Sets Pagination
    /// </summary>
    [DataMember(Name = "pagination", IsRequired = true, EmitDefaultValue = true)]
    public Pagination Pagination { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class ListAuthenticationsResponse {\n");
      sb.Append("  Authentications: ").Append(Authentications).Append("\n");
      sb.Append("  Pagination: ").Append(Pagination).Append("\n");
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
