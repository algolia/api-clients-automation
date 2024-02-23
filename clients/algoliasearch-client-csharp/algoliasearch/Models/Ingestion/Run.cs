//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Text;
using System.Linq;
using System.Text.Json.Serialization;
using System.Collections.Generic;
using Algolia.Search.Serializer;
using System.Text.Json;

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// Run
/// </summary>
public partial class Run
{

  /// <summary>
  /// Gets or Sets Status
  /// </summary>
  [JsonPropertyName("status")]
  public RunStatus? Status { get; set; }

  /// <summary>
  /// Gets or Sets Outcome
  /// </summary>
  [JsonPropertyName("outcome")]
  public RunOutcome? Outcome { get; set; }

  /// <summary>
  /// Gets or Sets ReasonCode
  /// </summary>
  [JsonPropertyName("reasonCode")]
  public RunReasonCode? ReasonCode { get; set; }

  /// <summary>
  /// Gets or Sets Type
  /// </summary>
  [JsonPropertyName("type")]
  public RunType? Type { get; set; }
  /// <summary>
  /// Initializes a new instance of the Run class.
  /// </summary>
  [JsonConstructor]
  public Run() { }
  /// <summary>
  /// Initializes a new instance of the Run class.
  /// </summary>
  /// <param name="runID">The run UUID. (required).</param>
  /// <param name="appID">appID (required).</param>
  /// <param name="taskID">The task UUID. (required).</param>
  /// <param name="status">status (required).</param>
  /// <param name="type">type (required).</param>
  /// <param name="createdAt">Date of creation (RFC3339 format). (required).</param>
  public Run(string runID, string appID, string taskID, RunStatus? status, RunType? type, string createdAt)
  {
    RunID = runID ?? throw new ArgumentNullException(nameof(runID));
    AppID = appID ?? throw new ArgumentNullException(nameof(appID));
    TaskID = taskID ?? throw new ArgumentNullException(nameof(taskID));
    Status = status;
    Type = type;
    CreatedAt = createdAt ?? throw new ArgumentNullException(nameof(createdAt));
  }

  /// <summary>
  /// The run UUID.
  /// </summary>
  /// <value>The run UUID.</value>
  [JsonPropertyName("runID")]
  public string RunID { get; set; }

  /// <summary>
  /// Gets or Sets AppID
  /// </summary>
  [JsonPropertyName("appID")]
  public string AppID { get; set; }

  /// <summary>
  /// The task UUID.
  /// </summary>
  /// <value>The task UUID.</value>
  [JsonPropertyName("taskID")]
  public string TaskID { get; set; }

  /// <summary>
  /// Gets or Sets Progress
  /// </summary>
  [JsonPropertyName("progress")]
  public RunProgress Progress { get; set; }

  /// <summary>
  /// A percentage representing the accepted failure threshold to determine if a `run` succeeded or not.
  /// </summary>
  /// <value>A percentage representing the accepted failure threshold to determine if a `run` succeeded or not.</value>
  [JsonPropertyName("failureThreshold")]
  public int? FailureThreshold { get; set; }

  /// <summary>
  /// Explains the result of outcome.
  /// </summary>
  /// <value>Explains the result of outcome.</value>
  [JsonPropertyName("reason")]
  public string Reason { get; set; }

  /// <summary>
  /// Date of creation (RFC3339 format).
  /// </summary>
  /// <value>Date of creation (RFC3339 format).</value>
  [JsonPropertyName("createdAt")]
  public string CreatedAt { get; set; }

  /// <summary>
  /// Date of start (RFC3339 format).
  /// </summary>
  /// <value>Date of start (RFC3339 format).</value>
  [JsonPropertyName("startedAt")]
  public string StartedAt { get; set; }

  /// <summary>
  /// Date of finish (RFC3339 format).
  /// </summary>
  /// <value>Date of finish (RFC3339 format).</value>
  [JsonPropertyName("finishedAt")]
  public string FinishedAt { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class Run {\n");
    sb.Append("  RunID: ").Append(RunID).Append("\n");
    sb.Append("  AppID: ").Append(AppID).Append("\n");
    sb.Append("  TaskID: ").Append(TaskID).Append("\n");
    sb.Append("  Status: ").Append(Status).Append("\n");
    sb.Append("  Progress: ").Append(Progress).Append("\n");
    sb.Append("  Outcome: ").Append(Outcome).Append("\n");
    sb.Append("  FailureThreshold: ").Append(FailureThreshold).Append("\n");
    sb.Append("  Reason: ").Append(Reason).Append("\n");
    sb.Append("  ReasonCode: ").Append(ReasonCode).Append("\n");
    sb.Append("  Type: ").Append(Type).Append("\n");
    sb.Append("  CreatedAt: ").Append(CreatedAt).Append("\n");
    sb.Append("  StartedAt: ").Append(StartedAt).Append("\n");
    sb.Append("  FinishedAt: ").Append(FinishedAt).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonSerializer.Serialize(this, JsonConfig.Options);
  }

  /// <summary>
  /// Returns true if objects are equal
  /// </summary>
  /// <param name="obj">Object to be compared</param>
  /// <returns>Boolean</returns>
  public override bool Equals(object obj)
  {
    if (obj is not Run input)
    {
      return false;
    }

    return
        (RunID == input.RunID || (RunID != null && RunID.Equals(input.RunID))) &&
        (AppID == input.AppID || (AppID != null && AppID.Equals(input.AppID))) &&
        (TaskID == input.TaskID || (TaskID != null && TaskID.Equals(input.TaskID))) &&
        (Status == input.Status || Status.Equals(input.Status)) &&
        (Progress == input.Progress || (Progress != null && Progress.Equals(input.Progress))) &&
        (Outcome == input.Outcome || Outcome.Equals(input.Outcome)) &&
        (FailureThreshold == input.FailureThreshold || FailureThreshold.Equals(input.FailureThreshold)) &&
        (Reason == input.Reason || (Reason != null && Reason.Equals(input.Reason))) &&
        (ReasonCode == input.ReasonCode || ReasonCode.Equals(input.ReasonCode)) &&
        (Type == input.Type || Type.Equals(input.Type)) &&
        (CreatedAt == input.CreatedAt || (CreatedAt != null && CreatedAt.Equals(input.CreatedAt))) &&
        (StartedAt == input.StartedAt || (StartedAt != null && StartedAt.Equals(input.StartedAt))) &&
        (FinishedAt == input.FinishedAt || (FinishedAt != null && FinishedAt.Equals(input.FinishedAt)));
  }

  /// <summary>
  /// Gets the hash code
  /// </summary>
  /// <returns>Hash code</returns>
  public override int GetHashCode()
  {
    unchecked // Overflow is fine, just wrap
    {
      int hashCode = 41;
      if (RunID != null)
      {
        hashCode = (hashCode * 59) + RunID.GetHashCode();
      }
      if (AppID != null)
      {
        hashCode = (hashCode * 59) + AppID.GetHashCode();
      }
      if (TaskID != null)
      {
        hashCode = (hashCode * 59) + TaskID.GetHashCode();
      }
      hashCode = (hashCode * 59) + Status.GetHashCode();
      if (Progress != null)
      {
        hashCode = (hashCode * 59) + Progress.GetHashCode();
      }
      hashCode = (hashCode * 59) + Outcome.GetHashCode();
      hashCode = (hashCode * 59) + FailureThreshold.GetHashCode();
      if (Reason != null)
      {
        hashCode = (hashCode * 59) + Reason.GetHashCode();
      }
      hashCode = (hashCode * 59) + ReasonCode.GetHashCode();
      hashCode = (hashCode * 59) + Type.GetHashCode();
      if (CreatedAt != null)
      {
        hashCode = (hashCode * 59) + CreatedAt.GetHashCode();
      }
      if (StartedAt != null)
      {
        hashCode = (hashCode * 59) + StartedAt.GetHashCode();
      }
      if (FinishedAt != null)
      {
        hashCode = (hashCode * 59) + FinishedAt.GetHashCode();
      }
      return hashCode;
    }
  }

}

