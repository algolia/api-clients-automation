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
/// Record to promote.
/// </summary>
[DataContract(Name = "promoteObjectID")]
[JsonObject(MemberSerialization.OptOut)]
public partial class PromoteObjectID
{
  /// <summary>
  /// Initializes a new instance of the PromoteObjectID class.
  /// </summary>
  [JsonConstructor]
  public PromoteObjectID() { }
  /// <summary>
  /// Initializes a new instance of the PromoteObjectID class.
  /// </summary>
  /// <param name="objectID">Unique identifier of the record to promote. (required).</param>
  /// <param name="position">The position to promote the records to. If you pass objectIDs, the records are placed at this position as a group. For example, if you pronmote four objectIDs to position 0, the records take the first four positions. (required).</param>
  public PromoteObjectID(string objectID, int position)
  {
    ObjectID = objectID ?? throw new ArgumentNullException(nameof(objectID));
    Position = position;
  }

  /// <summary>
  /// Unique identifier of the record to promote.
  /// </summary>
  /// <value>Unique identifier of the record to promote.</value>
  [DataMember(Name = "objectID")]
  public string ObjectID { get; set; }

  /// <summary>
  /// The position to promote the records to. If you pass objectIDs, the records are placed at this position as a group. For example, if you pronmote four objectIDs to position 0, the records take the first four positions.
  /// </summary>
  /// <value>The position to promote the records to. If you pass objectIDs, the records are placed at this position as a group. For example, if you pronmote four objectIDs to position 0, the records take the first four positions.</value>
  [DataMember(Name = "position")]
  public int Position { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class PromoteObjectID {\n");
    sb.Append("  ObjectID: ").Append(ObjectID).Append("\n");
    sb.Append("  Position: ").Append(Position).Append("\n");
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

