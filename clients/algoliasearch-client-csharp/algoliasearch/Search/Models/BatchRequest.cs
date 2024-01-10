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
  /// BatchRequest
  /// </summary>
  [DataContract(Name = "batchRequest")]
  public partial class BatchRequest
  {

    /// <summary>
    /// Gets or Sets Action
    /// </summary>
    [DataMember(Name = "action", IsRequired = true, EmitDefaultValue = true)]
    public Action Action { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="BatchRequest" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public BatchRequest() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="BatchRequest" /> class.
    /// </summary>
    /// <param name="action">action (required).</param>
    /// <param name="body">Operation arguments (varies with specified &#x60;action&#x60;). (required).</param>
    public BatchRequest(Action action, Object body)
    {
      this.Action = action;
      this.Body = body ?? throw new ArgumentNullException("body is a required property for BatchRequest and cannot be null");
    }

    /// <summary>
    /// Operation arguments (varies with specified &#x60;action&#x60;).
    /// </summary>
    /// <value>Operation arguments (varies with specified &#x60;action&#x60;).</value>
    [DataMember(Name = "body", IsRequired = true, EmitDefaultValue = true)]
    public Object Body { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BatchRequest {\n");
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
