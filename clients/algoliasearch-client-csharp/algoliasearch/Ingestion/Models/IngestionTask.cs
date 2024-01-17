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
  /// IngestionTask
  /// </summary>
  [DataContract(Name = "Task")]
  public partial class IngestionTask
  {

    /// <summary>
    /// Gets or Sets Action
    /// </summary>
    [DataMember(Name = "action", IsRequired = true, EmitDefaultValue = false)]
    public ActionType Action { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="IngestionTask" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public IngestionTask() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="IngestionTask" /> class.
    /// </summary>
    /// <param name="taskID">The task UUID. (required).</param>
    /// <param name="sourceID">The source UUID. (required).</param>
    /// <param name="destinationID">The destination UUID. (required).</param>
    /// <param name="trigger">trigger (required).</param>
    /// <param name="enabled">Whether the task is enabled or not. (required) (default to true).</param>
    /// <param name="action">action (required).</param>
    /// <param name="createdAt">Date of creation (RFC3339 format). (required).</param>
    public IngestionTask(string taskID, string sourceID, string destinationID, Trigger trigger, bool? enabled, ActionType action, string createdAt)
    {
      this.TaskID = taskID ?? throw new ArgumentNullException("taskID is a required property for IngestionTask and cannot be null");
      this.SourceID = sourceID ?? throw new ArgumentNullException("sourceID is a required property for IngestionTask and cannot be null");
      this.DestinationID = destinationID ?? throw new ArgumentNullException("destinationID is a required property for IngestionTask and cannot be null");
      this.Trigger = trigger ?? throw new ArgumentNullException("trigger is a required property for IngestionTask and cannot be null");
      this.Enabled = enabled;
      this.Action = action;
      this.CreatedAt = createdAt ?? throw new ArgumentNullException("createdAt is a required property for IngestionTask and cannot be null");
    }

    /// <summary>
    /// The task UUID.
    /// </summary>
    /// <value>The task UUID.</value>
    [DataMember(Name = "taskID", IsRequired = true, EmitDefaultValue = false)]
    public string TaskID { get; set; }

    /// <summary>
    /// The source UUID.
    /// </summary>
    /// <value>The source UUID.</value>
    [DataMember(Name = "sourceID", IsRequired = true, EmitDefaultValue = false)]
    public string SourceID { get; set; }

    /// <summary>
    /// The destination UUID.
    /// </summary>
    /// <value>The destination UUID.</value>
    [DataMember(Name = "destinationID", IsRequired = true, EmitDefaultValue = false)]
    public string DestinationID { get; set; }

    /// <summary>
    /// Gets or Sets Trigger
    /// </summary>
    [DataMember(Name = "trigger", IsRequired = true, EmitDefaultValue = false)]
    public Trigger Trigger { get; set; }

    /// <summary>
    /// Gets or Sets Input
    /// </summary>
    [DataMember(Name = "input", EmitDefaultValue = false)]
    public TaskInput Input { get; set; }

    /// <summary>
    /// Whether the task is enabled or not.
    /// </summary>
    /// <value>Whether the task is enabled or not.</value>
    [DataMember(Name = "enabled", IsRequired = true, EmitDefaultValue = false)]
    public bool? Enabled { get; set; }

    /// <summary>
    /// A percentage representing the accepted failure threshold to determine if a &#x60;run&#x60; succeeded or not.
    /// </summary>
    /// <value>A percentage representing the accepted failure threshold to determine if a &#x60;run&#x60; succeeded or not.</value>
    [DataMember(Name = "failureThreshold", EmitDefaultValue = false)]
    public int? FailureThreshold { get; set; }

    /// <summary>
    /// Date of creation (RFC3339 format).
    /// </summary>
    /// <value>Date of creation (RFC3339 format).</value>
    [DataMember(Name = "createdAt", IsRequired = true, EmitDefaultValue = false)]
    public string CreatedAt { get; set; }

    /// <summary>
    /// Date of last update (RFC3339 format).
    /// </summary>
    /// <value>Date of last update (RFC3339 format).</value>
    [DataMember(Name = "updatedAt", EmitDefaultValue = false)]
    public string UpdatedAt { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class IngestionTask {\n");
      sb.Append("  TaskID: ").Append(TaskID).Append("\n");
      sb.Append("  SourceID: ").Append(SourceID).Append("\n");
      sb.Append("  DestinationID: ").Append(DestinationID).Append("\n");
      sb.Append("  Trigger: ").Append(Trigger).Append("\n");
      sb.Append("  Input: ").Append(Input).Append("\n");
      sb.Append("  Enabled: ").Append(Enabled).Append("\n");
      sb.Append("  FailureThreshold: ").Append(FailureThreshold).Append("\n");
      sb.Append("  Action: ").Append(Action).Append("\n");
      sb.Append("  CreatedAt: ").Append(CreatedAt).Append("\n");
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
