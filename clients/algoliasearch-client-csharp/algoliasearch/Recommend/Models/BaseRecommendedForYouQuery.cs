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

namespace Algolia.Search.Models.Recommend
{
  /// <summary>
  /// BaseRecommendedForYouQuery
  /// </summary>
  [DataContract(Name = "baseRecommendedForYouQuery")]
  public partial class BaseRecommendedForYouQuery
  {

    /// <summary>
    /// Gets or Sets Model
    /// </summary>
    [DataMember(Name = "model", IsRequired = true, EmitDefaultValue = true)]
    public RecommendedForYouModel Model { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseRecommendedForYouQuery" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public BaseRecommendedForYouQuery() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseRecommendedForYouQuery" /> class.
    /// </summary>
    /// <param name="model">model (required).</param>
    public BaseRecommendedForYouQuery(RecommendedForYouModel model)
    {
      this.Model = model;
    }

    /// <summary>
    /// Gets or Sets QueryParameters
    /// </summary>
    [DataMember(Name = "queryParameters", EmitDefaultValue = false)]
    public RecommendedForYouQueryParameters QueryParameters { get; set; }

    /// <summary>
    /// Gets or Sets FallbackParameters
    /// </summary>
    [DataMember(Name = "fallbackParameters", EmitDefaultValue = false)]
    public RecommendedForYouQueryParameters FallbackParameters { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BaseRecommendedForYouQuery {\n");
      sb.Append("  Model: ").Append(Model).Append("\n");
      sb.Append("  QueryParameters: ").Append(QueryParameters).Append("\n");
      sb.Append("  FallbackParameters: ").Append(FallbackParameters).Append("\n");
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
