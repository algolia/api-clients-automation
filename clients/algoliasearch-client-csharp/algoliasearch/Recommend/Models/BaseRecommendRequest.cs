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

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// BaseRecommendRequest
  /// </summary>
  [DataContract(Name = "baseRecommendRequest")]
  public partial class BaseRecommendRequest
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseRecommendRequest" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected BaseRecommendRequest() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseRecommendRequest" /> class.
    /// </summary>
    /// <param name="indexName">Algolia index name. (required).</param>
    /// <param name="threshold">Recommendations with a confidence score lower than &#x60;threshold&#x60; won&#39;t appear in results. &gt; **Note**: Each recommendation has a confidence score of 0 to 100. The closer the score is to 100, the more relevant the recommendations are. .</param>
    /// <param name="maxRecommendations">Maximum number of recommendations to retrieve. If 0, all recommendations will be returned. (default to 0).</param>
    public BaseRecommendRequest(string indexName = default(string), int threshold = default(int), int maxRecommendations = 0)
    {
      // to ensure "indexName" is required (not null)
      if (indexName == null)
      {
        throw new ArgumentNullException("indexName is a required property for BaseRecommendRequest and cannot be null");
      }
      this.IndexName = indexName;
      this.Threshold = threshold;
      this.MaxRecommendations = maxRecommendations;
    }

    /// <summary>
    /// Algolia index name.
    /// </summary>
    /// <value>Algolia index name.</value>
    [DataMember(Name = "indexName", IsRequired = true, EmitDefaultValue = true)]
    public string IndexName { get; set; }

    /// <summary>
    /// Recommendations with a confidence score lower than &#x60;threshold&#x60; won&#39;t appear in results. &gt; **Note**: Each recommendation has a confidence score of 0 to 100. The closer the score is to 100, the more relevant the recommendations are. 
    /// </summary>
    /// <value>Recommendations with a confidence score lower than &#x60;threshold&#x60; won&#39;t appear in results. &gt; **Note**: Each recommendation has a confidence score of 0 to 100. The closer the score is to 100, the more relevant the recommendations are. </value>
    [DataMember(Name = "threshold", EmitDefaultValue = false)]
    public int Threshold { get; set; }

    /// <summary>
    /// Maximum number of recommendations to retrieve. If 0, all recommendations will be returned.
    /// </summary>
    /// <value>Maximum number of recommendations to retrieve. If 0, all recommendations will be returned.</value>
    [DataMember(Name = "maxRecommendations", EmitDefaultValue = false)]
    public int MaxRecommendations { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BaseRecommendRequest {\n");
      sb.Append("  IndexName: ").Append(IndexName).Append("\n");
      sb.Append("  Threshold: ").Append(Threshold).Append("\n");
      sb.Append("  MaxRecommendations: ").Append(MaxRecommendations).Append("\n");
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
