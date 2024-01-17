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

namespace Algolia.Search.Models.Analytics
{
  /// <summary>
  /// GetUsersCountResponse
  /// </summary>
  [DataContract(Name = "getUsersCountResponse")]
  public partial class GetUsersCountResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="GetUsersCountResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public GetUsersCountResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="GetUsersCountResponse" /> class.
    /// </summary>
    /// <param name="count">Number of occurrences. (required).</param>
    /// <param name="dates">User count. (required).</param>
    public GetUsersCountResponse(int? count, List<UserWithDate> dates)
    {
      this.Count = count;
      this.Dates = dates ?? throw new ArgumentNullException("dates is a required property for GetUsersCountResponse and cannot be null");
    }

    /// <summary>
    /// Number of occurrences.
    /// </summary>
    /// <value>Number of occurrences.</value>
    [DataMember(Name = "count", IsRequired = true, EmitDefaultValue = false)]
    public int? Count { get; set; }

    /// <summary>
    /// User count.
    /// </summary>
    /// <value>User count.</value>
    [DataMember(Name = "dates", IsRequired = true, EmitDefaultValue = false)]
    public List<UserWithDate> Dates { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class GetUsersCountResponse {\n");
      sb.Append("  Count: ").Append(Count).Append("\n");
      sb.Append("  Dates: ").Append(Dates).Append("\n");
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
