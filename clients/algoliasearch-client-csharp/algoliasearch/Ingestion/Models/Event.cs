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
  /// An event describe a step of the task execution flow..
  /// </summary>
  [DataContract(Name = "Event")]
  public partial class Event
  {

    /// <summary>
    /// Gets or Sets Status
    /// </summary>
    [DataMember(Name = "status", IsRequired = true, EmitDefaultValue = false)]
    public EventStatus Status { get; set; }

    /// <summary>
    /// Gets or Sets Type
    /// </summary>
    [DataMember(Name = "type", IsRequired = true, EmitDefaultValue = false)]
    public EventType Type { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="Event" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public Event() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="Event" /> class.
    /// </summary>
    /// <param name="eventID">The event UUID. (required).</param>
    /// <param name="runID">The run UUID. (required).</param>
    /// <param name="status">status (required).</param>
    /// <param name="type">type (required).</param>
    /// <param name="batchSize">The extracted record batch size. (required).</param>
    /// <param name="publishedAt">Date of publish (RFC3339 format). (required).</param>
    public Event(string eventID, string runID, EventStatus status, EventType type, int? batchSize, string publishedAt)
    {
      this.EventID = eventID ?? throw new ArgumentNullException("eventID is a required property for Event and cannot be null");
      this.RunID = runID ?? throw new ArgumentNullException("runID is a required property for Event and cannot be null");
      this.Status = status;
      this.Type = type;
      this.BatchSize = batchSize;
      this.PublishedAt = publishedAt ?? throw new ArgumentNullException("publishedAt is a required property for Event and cannot be null");
    }

    /// <summary>
    /// The event UUID.
    /// </summary>
    /// <value>The event UUID.</value>
    [DataMember(Name = "eventID", IsRequired = true, EmitDefaultValue = false)]
    public string EventID { get; set; }

    /// <summary>
    /// The run UUID.
    /// </summary>
    /// <value>The run UUID.</value>
    [DataMember(Name = "runID", IsRequired = true, EmitDefaultValue = false)]
    public string RunID { get; set; }

    /// <summary>
    /// The parent event, the cause of this event.
    /// </summary>
    /// <value>The parent event, the cause of this event.</value>
    [DataMember(Name = "parentID", EmitDefaultValue = false)]
    public string ParentID { get; set; }

    /// <summary>
    /// The extracted record batch size.
    /// </summary>
    /// <value>The extracted record batch size.</value>
    [DataMember(Name = "batchSize", IsRequired = true, EmitDefaultValue = false)]
    public int? BatchSize { get; set; }

    /// <summary>
    /// Gets or Sets Data
    /// </summary>
    [DataMember(Name = "data", EmitDefaultValue = false)]
    public Dictionary<string, Object> Data { get; set; }

    /// <summary>
    /// Date of publish (RFC3339 format).
    /// </summary>
    /// <value>Date of publish (RFC3339 format).</value>
    [DataMember(Name = "publishedAt", IsRequired = true, EmitDefaultValue = false)]
    public string PublishedAt { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Event {\n");
      sb.Append("  EventID: ").Append(EventID).Append("\n");
      sb.Append("  RunID: ").Append(RunID).Append("\n");
      sb.Append("  ParentID: ").Append(ParentID).Append("\n");
      sb.Append("  Status: ").Append(Status).Append("\n");
      sb.Append("  Type: ").Append(Type).Append("\n");
      sb.Append("  BatchSize: ").Append(BatchSize).Append("\n");
      sb.Append("  Data: ").Append(Data).Append("\n");
      sb.Append("  PublishedAt: ").Append(PublishedAt).Append("\n");
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
