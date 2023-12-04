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
using FileParameter = Algolia.Search.QuerySuggestions.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.QuerySuggestions.Client.OpenAPIDateConverter;

namespace Algolia.Search.QuerySuggestions.Models
{
  /// <summary>
  /// QuerySuggestionsConfigurationResponse
  /// </summary>
  [DataContract(Name = "QuerySuggestionsConfigurationResponse")]
  public partial class QuerySuggestionsConfigurationResponse : IEquatable<QuerySuggestionsConfigurationResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="QuerySuggestionsConfigurationResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected QuerySuggestionsConfigurationResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="QuerySuggestionsConfigurationResponse" /> class.
    /// </summary>
    /// <param name="appId">Your Algolia application ID..</param>
    /// <param name="sourceIndicesAPIKey">API key used to read from your source index..</param>
    /// <param name="suggestionsIndicesAPIKey">API key used to write and configure your Query Suggestions index..</param>
    /// <param name="externalIndicesAPIKey">API key used to read from external Algolia indices. (default to &quot;&quot;).</param>
    /// <param name="indexName">Query Suggestions index name. (required).</param>
    /// <param name="sourceIndices">Algolia indices from which to get the popular searches for query suggestions. (required).</param>
    /// <param name="languages">languages.</param>
    /// <param name="exclude">Patterns to exclude from query suggestions..</param>
    /// <param name="enablePersonalization">Turn on personalized query suggestions. (default to false).</param>
    /// <param name="allowSpecialCharacters">Allow suggestions with special characters. (default to false).</param>
    public QuerySuggestionsConfigurationResponse(string appId = default(string), string sourceIndicesAPIKey = default(string), string suggestionsIndicesAPIKey = default(string), string externalIndicesAPIKey = @"", string indexName = default(string), List<SourceIndex> sourceIndices = default(List<SourceIndex>), Languages languages = default(Languages), List<string> exclude = default(List<string>), bool enablePersonalization = false, bool allowSpecialCharacters = false)
    {
      // to ensure "indexName" is required (not null)
      if (indexName == null)
      {
        throw new ArgumentNullException("indexName is a required property for QuerySuggestionsConfigurationResponse and cannot be null");
      }
      this.IndexName = indexName;
      // to ensure "sourceIndices" is required (not null)
      if (sourceIndices == null)
      {
        throw new ArgumentNullException("sourceIndices is a required property for QuerySuggestionsConfigurationResponse and cannot be null");
      }
      this.SourceIndices = sourceIndices;
      this.AppId = appId;
      this.SourceIndicesAPIKey = sourceIndicesAPIKey;
      this.SuggestionsIndicesAPIKey = suggestionsIndicesAPIKey;
      // use default value if no "externalIndicesAPIKey" provided
      this.ExternalIndicesAPIKey = externalIndicesAPIKey ?? @"";
      this.Languages = languages;
      this.Exclude = exclude;
      this.EnablePersonalization = enablePersonalization;
      this.AllowSpecialCharacters = allowSpecialCharacters;
    }

    /// <summary>
    /// Your Algolia application ID.
    /// </summary>
    /// <value>Your Algolia application ID.</value>
    [DataMember(Name = "appId", EmitDefaultValue = false)]
    public string AppId { get; set; }

    /// <summary>
    /// API key used to read from your source index.
    /// </summary>
    /// <value>API key used to read from your source index.</value>
    [DataMember(Name = "sourceIndicesAPIKey", EmitDefaultValue = false)]
    public string SourceIndicesAPIKey { get; set; }

    /// <summary>
    /// API key used to write and configure your Query Suggestions index.
    /// </summary>
    /// <value>API key used to write and configure your Query Suggestions index.</value>
    [DataMember(Name = "suggestionsIndicesAPIKey", EmitDefaultValue = false)]
    public string SuggestionsIndicesAPIKey { get; set; }

    /// <summary>
    /// API key used to read from external Algolia indices.
    /// </summary>
    /// <value>API key used to read from external Algolia indices.</value>
    [DataMember(Name = "externalIndicesAPIKey", EmitDefaultValue = false)]
    public string ExternalIndicesAPIKey { get; set; }

    /// <summary>
    /// Query Suggestions index name.
    /// </summary>
    /// <value>Query Suggestions index name.</value>
    [DataMember(Name = "indexName", IsRequired = true, EmitDefaultValue = true)]
    public string IndexName { get; set; }

    /// <summary>
    /// Algolia indices from which to get the popular searches for query suggestions.
    /// </summary>
    /// <value>Algolia indices from which to get the popular searches for query suggestions.</value>
    [DataMember(Name = "sourceIndices", IsRequired = true, EmitDefaultValue = true)]
    public List<SourceIndex> SourceIndices { get; set; }

    /// <summary>
    /// Gets or Sets Languages
    /// </summary>
    [DataMember(Name = "languages", EmitDefaultValue = false)]
    public Languages Languages { get; set; }

    /// <summary>
    /// Patterns to exclude from query suggestions.
    /// </summary>
    /// <value>Patterns to exclude from query suggestions.</value>
    [DataMember(Name = "exclude", EmitDefaultValue = true)]
    public List<string> Exclude { get; set; }

    /// <summary>
    /// Turn on personalized query suggestions.
    /// </summary>
    /// <value>Turn on personalized query suggestions.</value>
    [DataMember(Name = "enablePersonalization", EmitDefaultValue = true)]
    public bool EnablePersonalization { get; set; }

    /// <summary>
    /// Allow suggestions with special characters.
    /// </summary>
    /// <value>Allow suggestions with special characters.</value>
    [DataMember(Name = "allowSpecialCharacters", EmitDefaultValue = true)]
    public bool AllowSpecialCharacters { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class QuerySuggestionsConfigurationResponse {\n");
      sb.Append("  AppId: ").Append(AppId).Append("\n");
      sb.Append("  SourceIndicesAPIKey: ").Append(SourceIndicesAPIKey).Append("\n");
      sb.Append("  SuggestionsIndicesAPIKey: ").Append(SuggestionsIndicesAPIKey).Append("\n");
      sb.Append("  ExternalIndicesAPIKey: ").Append(ExternalIndicesAPIKey).Append("\n");
      sb.Append("  IndexName: ").Append(IndexName).Append("\n");
      sb.Append("  SourceIndices: ").Append(SourceIndices).Append("\n");
      sb.Append("  Languages: ").Append(Languages).Append("\n");
      sb.Append("  Exclude: ").Append(Exclude).Append("\n");
      sb.Append("  EnablePersonalization: ").Append(EnablePersonalization).Append("\n");
      sb.Append("  AllowSpecialCharacters: ").Append(AllowSpecialCharacters).Append("\n");
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
      return this.Equals(input as QuerySuggestionsConfigurationResponse);
    }

    /// <summary>
    /// Returns true if QuerySuggestionsConfigurationResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of QuerySuggestionsConfigurationResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(QuerySuggestionsConfigurationResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.AppId == input.AppId ||
              (this.AppId != null &&
              this.AppId.Equals(input.AppId))
          ) &&
          (
              this.SourceIndicesAPIKey == input.SourceIndicesAPIKey ||
              (this.SourceIndicesAPIKey != null &&
              this.SourceIndicesAPIKey.Equals(input.SourceIndicesAPIKey))
          ) &&
          (
              this.SuggestionsIndicesAPIKey == input.SuggestionsIndicesAPIKey ||
              (this.SuggestionsIndicesAPIKey != null &&
              this.SuggestionsIndicesAPIKey.Equals(input.SuggestionsIndicesAPIKey))
          ) &&
          (
              this.ExternalIndicesAPIKey == input.ExternalIndicesAPIKey ||
              (this.ExternalIndicesAPIKey != null &&
              this.ExternalIndicesAPIKey.Equals(input.ExternalIndicesAPIKey))
          ) &&
          (
              this.IndexName == input.IndexName ||
              (this.IndexName != null &&
              this.IndexName.Equals(input.IndexName))
          ) &&
          (
              this.SourceIndices == input.SourceIndices ||
              this.SourceIndices != null &&
              input.SourceIndices != null &&
              this.SourceIndices.SequenceEqual(input.SourceIndices)
          ) &&
          (
              this.Languages == input.Languages ||
              (this.Languages != null &&
              this.Languages.Equals(input.Languages))
          ) &&
          (
              this.Exclude == input.Exclude ||
              this.Exclude != null &&
              input.Exclude != null &&
              this.Exclude.SequenceEqual(input.Exclude)
          ) &&
          (
              this.EnablePersonalization == input.EnablePersonalization ||
              this.EnablePersonalization.Equals(input.EnablePersonalization)
          ) &&
          (
              this.AllowSpecialCharacters == input.AllowSpecialCharacters ||
              this.AllowSpecialCharacters.Equals(input.AllowSpecialCharacters)
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
        if (this.AppId != null)
        {
          hashCode = (hashCode * 59) + this.AppId.GetHashCode();
        }
        if (this.SourceIndicesAPIKey != null)
        {
          hashCode = (hashCode * 59) + this.SourceIndicesAPIKey.GetHashCode();
        }
        if (this.SuggestionsIndicesAPIKey != null)
        {
          hashCode = (hashCode * 59) + this.SuggestionsIndicesAPIKey.GetHashCode();
        }
        if (this.ExternalIndicesAPIKey != null)
        {
          hashCode = (hashCode * 59) + this.ExternalIndicesAPIKey.GetHashCode();
        }
        if (this.IndexName != null)
        {
          hashCode = (hashCode * 59) + this.IndexName.GetHashCode();
        }
        if (this.SourceIndices != null)
        {
          hashCode = (hashCode * 59) + this.SourceIndices.GetHashCode();
        }
        if (this.Languages != null)
        {
          hashCode = (hashCode * 59) + this.Languages.GetHashCode();
        }
        if (this.Exclude != null)
        {
          hashCode = (hashCode * 59) + this.Exclude.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.EnablePersonalization.GetHashCode();
        hashCode = (hashCode * 59) + this.AllowSpecialCharacters.GetHashCode();
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
