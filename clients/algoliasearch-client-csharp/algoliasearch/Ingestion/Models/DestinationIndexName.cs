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
  /// DestinationIndexName
  /// </summary>
  [DataContract(Name = "DestinationIndexName")]
  [JsonObject(MemberSerialization.OptOut)]
  public partial class DestinationIndexName
  {

    /// <summary>
    /// Gets or Sets RecordType
    /// </summary>
    [DataMember(Name = "recordType", EmitDefaultValue = false)]
    public RecordType RecordType { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="DestinationIndexName" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public DestinationIndexName() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="DestinationIndexName" /> class.
    /// </summary>
    /// <param name="indexName">The index name to store data in. (required).</param>
    public DestinationIndexName(string indexName)
    {
      this.IndexName = indexName ?? throw new ArgumentNullException("indexName is a required property for DestinationIndexName and cannot be null");
    }

    /// <summary>
    /// The index name to store data in.
    /// </summary>
    /// <value>The index name to store data in.</value>
    [DataMember(Name = "indexName", IsRequired = true, EmitDefaultValue = false)]
    public string IndexName { get; set; }

    /// <summary>
    /// Determines the attributes to exclude from an Algolia record. To remove nested element, you can separate the path to the element with dots (&#x60;.&#x60;):   - \&quot;foo.bar\&quot;: will remove &#x60;bar&#x60; from &#x60;foo&#x60;. To remove elements from an array, you can use the following:   - \&quot;foo.[0].bar\&quot;: will only remove &#x60;bar&#x60; from the first element of &#x60;foo&#x60;.   - \&quot;foo.[*].bar\&quot;: will remove &#x60;bar&#x60; from every elements of &#x60;foo&#x60;. 
    /// </summary>
    /// <value>Determines the attributes to exclude from an Algolia record. To remove nested element, you can separate the path to the element with dots (&#x60;.&#x60;):   - \&quot;foo.bar\&quot;: will remove &#x60;bar&#x60; from &#x60;foo&#x60;. To remove elements from an array, you can use the following:   - \&quot;foo.[0].bar\&quot;: will only remove &#x60;bar&#x60; from the first element of &#x60;foo&#x60;.   - \&quot;foo.[*].bar\&quot;: will remove &#x60;bar&#x60; from every elements of &#x60;foo&#x60;. </value>
    [DataMember(Name = "attributesToExclude", EmitDefaultValue = false)]
    public List<string> AttributesToExclude { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class DestinationIndexName {\n");
      sb.Append("  IndexName: ").Append(IndexName).Append("\n");
      sb.Append("  RecordType: ").Append(RecordType).Append("\n");
      sb.Append("  AttributesToExclude: ").Append(AttributesToExclude).Append("\n");
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
