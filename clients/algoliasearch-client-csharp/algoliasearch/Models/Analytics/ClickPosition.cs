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

namespace Algolia.Search.Models.Analytics;

/// <summary>
/// ClickPosition
/// </summary>
[DataContract(Name = "clickPosition")]
public partial class ClickPosition
{
  /// <summary>
  /// Initializes a new instance of the ClickPosition class.
  /// </summary>
  [JsonConstructor]
  public ClickPosition() { }
  /// <summary>
  /// Initializes a new instance of the ClickPosition class.
  /// </summary>
  /// <param name="position">Range of positions with the following pattern: - For positions 1 to 10, the number of click events are shown for each position - For positions 11 to 20, all click events are grouped - For positions 21 and up, all click events are grouped.  (required).</param>
  /// <param name="clickCount">Number of click events. (required).</param>
  public ClickPosition(List<int> position, int clickCount)
  {
    Position = position ?? throw new ArgumentNullException(nameof(position));
    ClickCount = clickCount;
  }

  /// <summary>
  /// Range of positions with the following pattern: - For positions 1 to 10, the number of click events are shown for each position - For positions 11 to 20, all click events are grouped - For positions 21 and up, all click events are grouped. 
  /// </summary>
  /// <value>Range of positions with the following pattern: - For positions 1 to 10, the number of click events are shown for each position - For positions 11 to 20, all click events are grouped - For positions 21 and up, all click events are grouped. </value>
  [DataMember(Name = "position")]
  public List<int> Position { get; set; }

  /// <summary>
  /// Number of click events.
  /// </summary>
  /// <value>Number of click events.</value>
  [DataMember(Name = "clickCount")]
  public int ClickCount { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ClickPosition {\n");
    sb.Append("  Position: ").Append(Position).Append("\n");
    sb.Append("  ClickCount: ").Append(ClickCount).Append("\n");
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

