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
using System.ComponentModel.DataAnnotations;
using FileParameter = Algolia.Search.Recommend.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Recommend.Client.OpenAPIDateConverter;

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// GetRecommendationsResponse
  /// </summary>
  [DataContract(Name = "getRecommendationsResponse")]
  public partial class GetRecommendationsResponse : IEquatable<GetRecommendationsResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="GetRecommendationsResponse" /> class.
    /// </summary>
    /// <param name="results">results.</param>
    public GetRecommendationsResponse(List<RecommendationsResponse> results = default(List<RecommendationsResponse>))
    {
      this.Results = results;
    }

    /// <summary>
    /// Gets or Sets Results
    /// </summary>
    [DataMember(Name = "results", EmitDefaultValue = false)]
    public List<RecommendationsResponse> Results { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class GetRecommendationsResponse {\n");
      sb.Append("  Results: ").Append(Results).Append("\n");
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

    /// <summary>
    /// Returns true if objects are equal
    /// </summary>
    /// <param name="input">Object to be compared</param>
    /// <returns>Boolean</returns>
    public override bool Equals(object input)
    {
      return this.Equals(input as GetRecommendationsResponse);
    }

    /// <summary>
    /// Returns true if GetRecommendationsResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of GetRecommendationsResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(GetRecommendationsResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Results == input.Results ||
              this.Results != null &&
              input.Results != null &&
              this.Results.SequenceEqual(input.Results)
          );
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
        if (this.Results != null)
        {
          hashCode = (hashCode * 59) + this.Results.GetHashCode();
        }
        return hashCode;
      }
    }

    /// <summary>
    /// To validate all properties of the instance
    /// </summary>
    /// <param name="validationContext">Validation context</param>
    /// <returns>Validation Result</returns>
    IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
    {
      yield break;
    }
  }

}
