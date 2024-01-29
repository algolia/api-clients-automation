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
/// UserHit
/// </summary>
[DataContract(Name = "userHit")]
[JsonObject(MemberSerialization.OptOut)]
public partial class UserHit
{
  /// <summary>
  /// Initializes a new instance of the UserHit class.
  /// </summary>
  [JsonConstructor]
  public UserHit() { }
  /// <summary>
  /// Initializes a new instance of the UserHit class.
  /// </summary>
  /// <param name="userID">userID of the user. (required).</param>
  /// <param name="clusterName">Cluster name. (required).</param>
  /// <param name="nbRecords">Number of records in the cluster. (required).</param>
  /// <param name="dataSize">Data size taken by all the users assigned to the cluster. (required).</param>
  /// <param name="objectID">userID of the requested user. Same as userID. (required).</param>
  /// <param name="highlightResult">highlightResult (required).</param>
  public UserHit(string userID, string clusterName, int? nbRecords, int? dataSize, string objectID, UserHighlightResult highlightResult)
  {
    UserID = userID ?? throw new ArgumentNullException(nameof(userID));
    ClusterName = clusterName ?? throw new ArgumentNullException(nameof(clusterName));
    NbRecords = nbRecords;
    DataSize = dataSize;
    ObjectID = objectID ?? throw new ArgumentNullException(nameof(objectID));
    HighlightResult = highlightResult ?? throw new ArgumentNullException(nameof(highlightResult));
  }

  /// <summary>
  /// userID of the user.
  /// </summary>
  /// <value>userID of the user.</value>
  [DataMember(Name = "userID", IsRequired = true, EmitDefaultValue = false)]
  public string UserID { get; set; }

  /// <summary>
  /// Cluster name.
  /// </summary>
  /// <value>Cluster name.</value>
  [DataMember(Name = "clusterName", IsRequired = true, EmitDefaultValue = false)]
  public string ClusterName { get; set; }

  /// <summary>
  /// Number of records in the cluster.
  /// </summary>
  /// <value>Number of records in the cluster.</value>
  [DataMember(Name = "nbRecords", IsRequired = true, EmitDefaultValue = false)]
  public int? NbRecords { get; set; }

  /// <summary>
  /// Data size taken by all the users assigned to the cluster.
  /// </summary>
  /// <value>Data size taken by all the users assigned to the cluster.</value>
  [DataMember(Name = "dataSize", IsRequired = true, EmitDefaultValue = false)]
  public int? DataSize { get; set; }

  /// <summary>
  /// userID of the requested user. Same as userID.
  /// </summary>
  /// <value>userID of the requested user. Same as userID.</value>
  [DataMember(Name = "objectID", IsRequired = true, EmitDefaultValue = false)]
  public string ObjectID { get; set; }

  /// <summary>
  /// Gets or Sets HighlightResult
  /// </summary>
  [DataMember(Name = "_highlightResult", IsRequired = true, EmitDefaultValue = false)]
  public UserHighlightResult HighlightResult { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class UserHit {\n");
    sb.Append("  UserID: ").Append(UserID).Append("\n");
    sb.Append("  ClusterName: ").Append(ClusterName).Append("\n");
    sb.Append("  NbRecords: ").Append(NbRecords).Append("\n");
    sb.Append("  DataSize: ").Append(DataSize).Append("\n");
    sb.Append("  ObjectID: ").Append(ObjectID).Append("\n");
    sb.Append("  HighlightResult: ").Append(HighlightResult).Append("\n");
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

