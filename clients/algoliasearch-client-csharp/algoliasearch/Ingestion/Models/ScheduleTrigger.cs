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
  /// The trigger information for a task of type &#39;schedule&#39;.
  /// </summary>
  [DataContract(Name = "ScheduleTrigger")]
  public partial class ScheduleTrigger
  {

    /// <summary>
    /// Gets or Sets Type
    /// </summary>
    [DataMember(Name = "type", IsRequired = true, EmitDefaultValue = true)]
    public ScheduleTriggerType Type { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="ScheduleTrigger" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public ScheduleTrigger() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="ScheduleTrigger" /> class.
    /// </summary>
    /// <param name="type">type (required).</param>
    /// <param name="cron">A cron expression that represent at which regularity the task should run. (required).</param>
    /// <param name="nextRun">The next scheduled run of the task (RFC3339 format). (required).</param>
    public ScheduleTrigger(ScheduleTriggerType type, string cron, string nextRun)
    {
      this.Type = type;
      this.Cron = cron ?? throw new ArgumentNullException("cron is a required property for ScheduleTrigger and cannot be null");
      this.NextRun = nextRun ?? throw new ArgumentNullException("nextRun is a required property for ScheduleTrigger and cannot be null");
    }

    /// <summary>
    /// A cron expression that represent at which regularity the task should run.
    /// </summary>
    /// <value>A cron expression that represent at which regularity the task should run.</value>
    [DataMember(Name = "cron", IsRequired = true, EmitDefaultValue = true)]
    public string Cron { get; set; }

    /// <summary>
    /// The last time the scheduled task ran (RFC3339 format).
    /// </summary>
    /// <value>The last time the scheduled task ran (RFC3339 format).</value>
    [DataMember(Name = "lastRun", EmitDefaultValue = false)]
    public string LastRun { get; set; }

    /// <summary>
    /// The next scheduled run of the task (RFC3339 format).
    /// </summary>
    /// <value>The next scheduled run of the task (RFC3339 format).</value>
    [DataMember(Name = "nextRun", IsRequired = true, EmitDefaultValue = true)]
    public string NextRun { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class ScheduleTrigger {\n");
      sb.Append("  Type: ").Append(Type).Append("\n");
      sb.Append("  Cron: ").Append(Cron).Append("\n");
      sb.Append("  LastRun: ").Append(LastRun).Append("\n");
      sb.Append("  NextRun: ").Append(NextRun).Append("\n");
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
