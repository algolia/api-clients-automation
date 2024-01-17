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
  /// The window parameter represents the holds the dates used to query the Observability data from the database in a given window.
  /// </summary>
  [DataContract(Name = "Window")]
  public partial class Window
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="Window" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public Window() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="Window" /> class.
    /// </summary>
    /// <param name="startDate">A date in format RFC3339 representing the oldest possible data in query window. (required).</param>
    /// <param name="endDate">A date in format RFC3339 representing the newest possible data in query window. (required).</param>
    public Window(string startDate, string endDate)
    {
      this.StartDate = startDate ?? throw new ArgumentNullException("startDate is a required property for Window and cannot be null");
      this.EndDate = endDate ?? throw new ArgumentNullException("endDate is a required property for Window and cannot be null");
    }

    /// <summary>
    /// A date in format RFC3339 representing the oldest possible data in query window.
    /// </summary>
    /// <value>A date in format RFC3339 representing the oldest possible data in query window.</value>
    [DataMember(Name = "startDate", IsRequired = true, EmitDefaultValue = false)]
    public string StartDate { get; set; }

    /// <summary>
    /// A date in format RFC3339 representing the newest possible data in query window.
    /// </summary>
    /// <value>A date in format RFC3339 representing the newest possible data in query window.</value>
    [DataMember(Name = "endDate", IsRequired = true, EmitDefaultValue = false)]
    public string EndDate { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Window {\n");
      sb.Append("  StartDate: ").Append(StartDate).Append("\n");
      sb.Append("  EndDate: ").Append(EndDate).Append("\n");
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
