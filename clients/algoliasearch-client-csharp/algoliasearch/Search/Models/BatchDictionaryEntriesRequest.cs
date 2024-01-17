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

namespace Algolia.Search.Models.Search
{
  /// <summary>
  /// BatchDictionaryEntriesRequest
  /// </summary>
  [DataContract(Name = "batchDictionaryEntriesRequest")]
  public partial class BatchDictionaryEntriesRequest
  {

    /// <summary>
    /// Gets or Sets Action
    /// </summary>
    [DataMember(Name = "action", IsRequired = true, EmitDefaultValue = false)]
    public DictionaryAction Action { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="BatchDictionaryEntriesRequest" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public BatchDictionaryEntriesRequest() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="BatchDictionaryEntriesRequest" /> class.
    /// </summary>
    /// <param name="action">action (required).</param>
    /// <param name="body">body (required).</param>
    public BatchDictionaryEntriesRequest(DictionaryAction action, DictionaryEntry body)
    {
      this.Action = action;
      this.Body = body ?? throw new ArgumentNullException("body is a required property for BatchDictionaryEntriesRequest and cannot be null");
    }

    /// <summary>
    /// Gets or Sets Body
    /// </summary>
    [DataMember(Name = "body", IsRequired = true, EmitDefaultValue = false)]
    public DictionaryEntry Body { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BatchDictionaryEntriesRequest {\n");
      sb.Append("  Action: ").Append(Action).Append("\n");
      sb.Append("  Body: ").Append(Body).Append("\n");
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
