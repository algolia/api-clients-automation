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
  /// MultipleBatchRequest
  /// </summary>
  [DataContract(Name = "multipleBatchRequest")]
  public partial class MultipleBatchRequest
  {

    /// <summary>
    /// Gets or Sets Action
    /// </summary>
    [DataMember(Name = "action", IsRequired = true, EmitDefaultValue = false)]
    public Action Action { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="MultipleBatchRequest" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public MultipleBatchRequest() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="MultipleBatchRequest" /> class.
    /// </summary>
    /// <param name="action">action (required).</param>
    /// <param name="body">Operation arguments (varies with specified &#x60;action&#x60;). (required).</param>
    /// <param name="indexName">Index to target for this operation. (required).</param>
    public MultipleBatchRequest(Action action, Object body, string indexName)
    {
      this.Action = action;
      this.Body = body ?? throw new ArgumentNullException("body is a required property for MultipleBatchRequest and cannot be null");
      this.IndexName = indexName ?? throw new ArgumentNullException("indexName is a required property for MultipleBatchRequest and cannot be null");
    }

    /// <summary>
    /// Operation arguments (varies with specified &#x60;action&#x60;).
    /// </summary>
    /// <value>Operation arguments (varies with specified &#x60;action&#x60;).</value>
    [DataMember(Name = "body", IsRequired = true, EmitDefaultValue = false)]
    public Object Body { get; set; }

    /// <summary>
    /// Index to target for this operation.
    /// </summary>
    /// <value>Index to target for this operation.</value>
    [DataMember(Name = "indexName", IsRequired = true, EmitDefaultValue = false)]
    public string IndexName { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class MultipleBatchRequest {\n");
      sb.Append("  Action: ").Append(Action).Append("\n");
      sb.Append("  Body: ").Append(Body).Append("\n");
      sb.Append("  IndexName: ").Append(IndexName).Append("\n");
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
