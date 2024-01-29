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
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Search;

/// <summary>
/// User ID data.
/// </summary>
[DataContract(Name = "listUserIdsResponse")]
[JsonObject(MemberSerialization.OptOut)]
public partial class ListUserIdsResponse
{
  /// <summary>
  /// Initializes a new instance of the ListUserIdsResponse class.
  /// </summary>
  [JsonConstructor]
  public ListUserIdsResponse() { }
  /// <summary>
  /// Initializes a new instance of the ListUserIdsResponse class.
  /// </summary>
  /// <param name="userIDs">User IDs. (required).</param>
  public ListUserIdsResponse(List<UserId> userIDs)
  {
    UserIDs = userIDs ?? throw new ArgumentNullException(nameof(userIDs));
  }

  /// <summary>
  /// User IDs.
  /// </summary>
  /// <value>User IDs.</value>
  [DataMember(Name = "userIDs", IsRequired = true, EmitDefaultValue = false)]
  public List<UserId> UserIDs { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ListUserIdsResponse {\n");
    sb.Append("  UserIDs: ").Append(UserIDs).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonConvert.SerializeObject(this, Formatting.Indented);
  }

}

