/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


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
using FileParameter = Algolia.Search.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Client.OpenAPIDateConverter;

namespace Algolia.Search.Model
{
  /// <summary>
  /// Dictionary entry.
  /// </summary>
  [DataContract(Name = "dictionaryEntry")]
  public partial class DictionaryEntry : Dictionary<String, Object>, IEquatable<DictionaryEntry>, IValidatableObject
  {

    /// <summary>
    /// Gets or Sets State
    /// </summary>
    [DataMember(Name = "state", EmitDefaultValue = false)]
    public DictionaryEntryState? State { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="DictionaryEntry" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected DictionaryEntry()
    {
      this.AdditionalProperties = new Dictionary<string, object>();
    }
    /// <summary>
    /// Initializes a new instance of the <see cref="DictionaryEntry" /> class.
    /// </summary>
    /// <param name="objectID">Unique identifier for a dictionary object. (required).</param>
    /// <param name="language">[Supported language ISO code](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/).  (required).</param>
    /// <param name="word">Dictionary entry word. Usage depends on the type of dictionary entry. **&#x60;stopwordEntry&#x60;** The stop word you want to add or update. If the entry already exists in Algolia&#39;s standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its &#x60;state&#x60; to &#x60;disabled&#x60;. **&#x60;compoundEntry&#x60;** When &#x60;decomposition&#x60; is empty: adds &#x60;word&#x60; as a compound atom. For example, atom “kino” decomposes the query “kopfkino” into \&quot;kopf\&quot; and \&quot;kino\&quot;. When &#x60;decomposition&#x60; isn&#39;t empty: creates a decomposition exception. For example, when decomposition is set to the [\&quot;hund\&quot;, \&quot;hutte\&quot;] exception, \&quot;hundehutte\&quot; decomposes into “hund” and “hutte”, discarding the linking \&quot;e\&quot;. .</param>
    /// <param name="words">Compound dictionary [word declensions](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-plurals-and-other-declensions/). If the entry already exists in Algolia&#39;s standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its &#x60;state&#x60; to &#x60;disabled&#x60;. .</param>
    /// <param name="decomposition">For compound entries, governs the behavior of the &#x60;word&#x60; parameter..</param>
    /// <param name="state">state.</param>
    public DictionaryEntry(string objectID = default(string), string language = default(string), string word = default(string), List<string> words = default(List<string>), List<string> decomposition = default(List<string>), DictionaryEntryState? state = default(DictionaryEntryState?)) : base()
    {
      // to ensure "objectID" is required (not null)
      if (objectID == null)
      {
        throw new ArgumentNullException("objectID is a required property for DictionaryEntry and cannot be null");
      }
      this.ObjectID = objectID;
      // to ensure "language" is required (not null)
      if (language == null)
      {
        throw new ArgumentNullException("language is a required property for DictionaryEntry and cannot be null");
      }
      this.Language = language;
      this.Word = word;
      this.Words = words;
      this.Decomposition = decomposition;
      this.State = state;
      this.AdditionalProperties = new Dictionary<string, object>();
    }

    /// <summary>
    /// Unique identifier for a dictionary object.
    /// </summary>
    /// <value>Unique identifier for a dictionary object.</value>
    [DataMember(Name = "objectID", IsRequired = true, EmitDefaultValue = true)]
    public string ObjectID { get; set; }

    /// <summary>
    /// [Supported language ISO code](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/). 
    /// </summary>
    /// <value>[Supported language ISO code](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/). </value>
    [DataMember(Name = "language", IsRequired = true, EmitDefaultValue = true)]
    public string Language { get; set; }

    /// <summary>
    /// Dictionary entry word. Usage depends on the type of dictionary entry. **&#x60;stopwordEntry&#x60;** The stop word you want to add or update. If the entry already exists in Algolia&#39;s standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its &#x60;state&#x60; to &#x60;disabled&#x60;. **&#x60;compoundEntry&#x60;** When &#x60;decomposition&#x60; is empty: adds &#x60;word&#x60; as a compound atom. For example, atom “kino” decomposes the query “kopfkino” into \&quot;kopf\&quot; and \&quot;kino\&quot;. When &#x60;decomposition&#x60; isn&#39;t empty: creates a decomposition exception. For example, when decomposition is set to the [\&quot;hund\&quot;, \&quot;hutte\&quot;] exception, \&quot;hundehutte\&quot; decomposes into “hund” and “hutte”, discarding the linking \&quot;e\&quot;. 
    /// </summary>
    /// <value>Dictionary entry word. Usage depends on the type of dictionary entry. **&#x60;stopwordEntry&#x60;** The stop word you want to add or update. If the entry already exists in Algolia&#39;s standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its &#x60;state&#x60; to &#x60;disabled&#x60;. **&#x60;compoundEntry&#x60;** When &#x60;decomposition&#x60; is empty: adds &#x60;word&#x60; as a compound atom. For example, atom “kino” decomposes the query “kopfkino” into \&quot;kopf\&quot; and \&quot;kino\&quot;. When &#x60;decomposition&#x60; isn&#39;t empty: creates a decomposition exception. For example, when decomposition is set to the [\&quot;hund\&quot;, \&quot;hutte\&quot;] exception, \&quot;hundehutte\&quot; decomposes into “hund” and “hutte”, discarding the linking \&quot;e\&quot;. </value>
    [DataMember(Name = "word", EmitDefaultValue = false)]
    public string Word { get; set; }

    /// <summary>
    /// Compound dictionary [word declensions](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-plurals-and-other-declensions/). If the entry already exists in Algolia&#39;s standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its &#x60;state&#x60; to &#x60;disabled&#x60;. 
    /// </summary>
    /// <value>Compound dictionary [word declensions](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-plurals-and-other-declensions/). If the entry already exists in Algolia&#39;s standard dictionary, you can override its behavior by adding it to the custom dictionary and setting its &#x60;state&#x60; to &#x60;disabled&#x60;. </value>
    [DataMember(Name = "words", EmitDefaultValue = false)]
    public List<string> Words { get; set; }

    /// <summary>
    /// For compound entries, governs the behavior of the &#x60;word&#x60; parameter.
    /// </summary>
    /// <value>For compound entries, governs the behavior of the &#x60;word&#x60; parameter.</value>
    [DataMember(Name = "decomposition", EmitDefaultValue = false)]
    public List<string> Decomposition { get; set; }

    /// <summary>
    /// Gets or Sets additional properties
    /// </summary>
    [JsonExtensionData]
    public IDictionary<string, object> AdditionalProperties { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class DictionaryEntry {\n");
      sb.Append("  ").Append(base.ToString().Replace("\n", "\n  ")).Append("\n");
      sb.Append("  ObjectID: ").Append(ObjectID).Append("\n");
      sb.Append("  Language: ").Append(Language).Append("\n");
      sb.Append("  Word: ").Append(Word).Append("\n");
      sb.Append("  Words: ").Append(Words).Append("\n");
      sb.Append("  Decomposition: ").Append(Decomposition).Append("\n");
      sb.Append("  State: ").Append(State).Append("\n");
      sb.Append("  AdditionalProperties: ").Append(AdditionalProperties).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public string ToJson()
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
      return this.Equals(input as DictionaryEntry);
    }

    /// <summary>
    /// Returns true if DictionaryEntry instances are equal
    /// </summary>
    /// <param name="input">Instance of DictionaryEntry to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(DictionaryEntry input)
    {
      if (input == null)
      {
        return false;
      }
      return base.Equals(input) &&
          (
              this.ObjectID == input.ObjectID ||
              (this.ObjectID != null &&
              this.ObjectID.Equals(input.ObjectID))
          ) && base.Equals(input) &&
          (
              this.Language == input.Language ||
              (this.Language != null &&
              this.Language.Equals(input.Language))
          ) && base.Equals(input) &&
          (
              this.Word == input.Word ||
              (this.Word != null &&
              this.Word.Equals(input.Word))
          ) && base.Equals(input) &&
          (
              this.Words == input.Words ||
              this.Words != null &&
              input.Words != null &&
              this.Words.SequenceEqual(input.Words)
          ) && base.Equals(input) &&
          (
              this.Decomposition == input.Decomposition ||
              this.Decomposition != null &&
              input.Decomposition != null &&
              this.Decomposition.SequenceEqual(input.Decomposition)
          ) && base.Equals(input) &&
          (
              this.State == input.State ||
              this.State.Equals(input.State)
          )
          && (this.AdditionalProperties.Count == input.AdditionalProperties.Count && !this.AdditionalProperties.Except(input.AdditionalProperties).Any());
    }

    /// <summary>
    /// Gets the hash code
    /// </summary>
    /// <returns>Hash code</returns>
    public override int GetHashCode()
    {
      unchecked // Overflow is fine, just wrap
      {
        int hashCode = base.GetHashCode();
        if (this.ObjectID != null)
        {
          hashCode = (hashCode * 59) + this.ObjectID.GetHashCode();
        }
        if (this.Language != null)
        {
          hashCode = (hashCode * 59) + this.Language.GetHashCode();
        }
        if (this.Word != null)
        {
          hashCode = (hashCode * 59) + this.Word.GetHashCode();
        }
        if (this.Words != null)
        {
          hashCode = (hashCode * 59) + this.Words.GetHashCode();
        }
        if (this.Decomposition != null)
        {
          hashCode = (hashCode * 59) + this.Decomposition.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.State.GetHashCode();
        if (this.AdditionalProperties != null)
        {
          hashCode = (hashCode * 59) + this.AdditionalProperties.GetHashCode();
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
      return this.BaseValidate(validationContext);
    }

    /// <summary>
    /// To validate all properties of the instance
    /// </summary>
    /// <param name="validationContext">Validation context</param>
    /// <returns>Validation Result</returns>
    protected IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> BaseValidate(ValidationContext validationContext)
    {
      yield break;
    }
  }

}
