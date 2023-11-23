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
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  /// BaseIndexSettings
  /// </summary>
  [DataContract(Name = "baseIndexSettings")]
  public partial class BaseIndexSettings : IEquatable<BaseIndexSettings>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseIndexSettings" /> class.
    /// </summary>
    /// <param name="replicas">Creates [replicas](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/), which are copies of a primary index with the same records but different settings..</param>
    /// <param name="paginationLimitedTo">Maximum number of hits accessible through pagination. (default to 1000).</param>
    /// <param name="unretrievableAttributes">Attributes that can&#39;t be retrieved at query time..</param>
    /// <param name="disableTypoToleranceOnWords">Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/)..</param>
    /// <param name="attributesToTransliterate">Attributes in your index to which [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead) applies. This will ensure that words indexed in Katakana or Kanji can also be searched in Hiragana..</param>
    /// <param name="camelCaseAttributes">Attributes on which to split [camel case](https://wikipedia.org/wiki/Camel_case) words..</param>
    /// <param name="decompoundedAttributes">Attributes in your index to which [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding) applies..</param>
    /// <param name="indexLanguages">Set the languages of your index, for language-specific processing steps such as [tokenization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/tokenization/) and [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/)..</param>
    /// <param name="disablePrefixOnAttributes">Attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search)..</param>
    /// <param name="allowCompressionOfIntegerArray">Incidates whether the engine compresses arrays with exclusively non-negative integers. When enabled, the compressed arrays may be reordered.  (default to false).</param>
    /// <param name="numericAttributesForFiltering">Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters)..</param>
    /// <param name="separatorsToIndex">Controls which separators are added to an Algolia index as part of [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean). Separators are all non-letter characters except spaces and currency characters, such as $€£¥. (default to &quot;&quot;).</param>
    /// <param name="searchableAttributes">[Attributes used for searching](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/), including determining [if matches at the beginning of a word are important (ordered) or not (unordered)](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/how-to/configuring-searchable-attributes-the-right-way/#understanding-word-position). .</param>
    /// <param name="userData">Lets you store custom data in your indices..</param>
    /// <param name="customNormalization">A list of characters and their normalized replacements to override Algolia&#39;s default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/)..</param>
    /// <param name="attributeForDistinct">Name of the deduplication attribute to be used with Algolia&#39;s [_distinct_ feature](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/#introducing-algolias-distinct-feature)..</param>
    public BaseIndexSettings(List<string> replicas = default(List<string>), int paginationLimitedTo = 1000, List<string> unretrievableAttributes = default(List<string>), List<string> disableTypoToleranceOnWords = default(List<string>), List<string> attributesToTransliterate = default(List<string>), List<string> camelCaseAttributes = default(List<string>), Object decompoundedAttributes = default(Object), List<string> indexLanguages = default(List<string>), List<string> disablePrefixOnAttributes = default(List<string>), bool allowCompressionOfIntegerArray = false, List<string> numericAttributesForFiltering = default(List<string>), string separatorsToIndex = @"", List<string> searchableAttributes = default(List<string>), Object userData = default(Object), Dictionary<string, Dictionary<string, string>> customNormalization = default(Dictionary<string, Dictionary<string, string>>), string attributeForDistinct = default(string))
    {
      this.Replicas = replicas;
      this.PaginationLimitedTo = paginationLimitedTo;
      this.UnretrievableAttributes = unretrievableAttributes;
      this.DisableTypoToleranceOnWords = disableTypoToleranceOnWords;
      this.AttributesToTransliterate = attributesToTransliterate;
      this.CamelCaseAttributes = camelCaseAttributes;
      this.DecompoundedAttributes = decompoundedAttributes;
      this.IndexLanguages = indexLanguages;
      this.DisablePrefixOnAttributes = disablePrefixOnAttributes;
      this.AllowCompressionOfIntegerArray = allowCompressionOfIntegerArray;
      this.NumericAttributesForFiltering = numericAttributesForFiltering;
      // use default value if no "separatorsToIndex" provided
      this.SeparatorsToIndex = separatorsToIndex ?? @"";
      this.SearchableAttributes = searchableAttributes;
      this.UserData = userData;
      this.CustomNormalization = customNormalization;
      this.AttributeForDistinct = attributeForDistinct;
    }

    /// <summary>
    /// Creates [replicas](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/), which are copies of a primary index with the same records but different settings.
    /// </summary>
    /// <value>Creates [replicas](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/), which are copies of a primary index with the same records but different settings.</value>
    /// <example>[&quot;virtual(prod_products_price_asc)&quot;,&quot;dev_products_replica&quot;]</example>
    [DataMember(Name = "replicas", EmitDefaultValue = false)]
    public List<string> Replicas { get; set; }

    /// <summary>
    /// Maximum number of hits accessible through pagination.
    /// </summary>
    /// <value>Maximum number of hits accessible through pagination.</value>
    /// <example>20</example>
    [DataMember(Name = "paginationLimitedTo", EmitDefaultValue = false)]
    public int PaginationLimitedTo { get; set; }

    /// <summary>
    /// Attributes that can&#39;t be retrieved at query time.
    /// </summary>
    /// <value>Attributes that can&#39;t be retrieved at query time.</value>
    /// <example>[&quot;popularity&quot;]</example>
    [DataMember(Name = "unretrievableAttributes", EmitDefaultValue = false)]
    public List<string> UnretrievableAttributes { get; set; }

    /// <summary>
    /// Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).
    /// </summary>
    /// <value>Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).</value>
    /// <example>[&quot;wheel&quot;,&quot;1X2BCD&quot;]</example>
    [DataMember(Name = "disableTypoToleranceOnWords", EmitDefaultValue = false)]
    public List<string> DisableTypoToleranceOnWords { get; set; }

    /// <summary>
    /// Attributes in your index to which [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead) applies. This will ensure that words indexed in Katakana or Kanji can also be searched in Hiragana.
    /// </summary>
    /// <value>Attributes in your index to which [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead) applies. This will ensure that words indexed in Katakana or Kanji can also be searched in Hiragana.</value>
    /// <example>[&quot;name&quot;,&quot;description&quot;]</example>
    [DataMember(Name = "attributesToTransliterate", EmitDefaultValue = false)]
    public List<string> AttributesToTransliterate { get; set; }

    /// <summary>
    /// Attributes on which to split [camel case](https://wikipedia.org/wiki/Camel_case) words.
    /// </summary>
    /// <value>Attributes on which to split [camel case](https://wikipedia.org/wiki/Camel_case) words.</value>
    /// <example>[&quot;description&quot;]</example>
    [DataMember(Name = "camelCaseAttributes", EmitDefaultValue = false)]
    public List<string> CamelCaseAttributes { get; set; }

    /// <summary>
    /// Attributes in your index to which [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding) applies.
    /// </summary>
    /// <value>Attributes in your index to which [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding) applies.</value>
    /// <example>{&quot;de&quot;:[&quot;name&quot;]}</example>
    [DataMember(Name = "decompoundedAttributes", EmitDefaultValue = false)]
    public Object DecompoundedAttributes { get; set; }

    /// <summary>
    /// Set the languages of your index, for language-specific processing steps such as [tokenization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/tokenization/) and [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
    /// </summary>
    /// <value>Set the languages of your index, for language-specific processing steps such as [tokenization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/tokenization/) and [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).</value>
    /// <example>[&quot;ja&quot;]</example>
    [DataMember(Name = "indexLanguages", EmitDefaultValue = false)]
    public List<string> IndexLanguages { get; set; }

    /// <summary>
    /// Attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).
    /// </summary>
    /// <value>Attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).</value>
    /// <example>[&quot;sku&quot;]</example>
    [DataMember(Name = "disablePrefixOnAttributes", EmitDefaultValue = false)]
    public List<string> DisablePrefixOnAttributes { get; set; }

    /// <summary>
    /// Incidates whether the engine compresses arrays with exclusively non-negative integers. When enabled, the compressed arrays may be reordered. 
    /// </summary>
    /// <value>Incidates whether the engine compresses arrays with exclusively non-negative integers. When enabled, the compressed arrays may be reordered. </value>
    [DataMember(Name = "allowCompressionOfIntegerArray", EmitDefaultValue = true)]
    public bool AllowCompressionOfIntegerArray { get; set; }

    /// <summary>
    /// Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).
    /// </summary>
    /// <value>Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).</value>
    /// <example>[&quot;quantity&quot;,&quot;popularity&quot;]</example>
    [DataMember(Name = "numericAttributesForFiltering", EmitDefaultValue = false)]
    public List<string> NumericAttributesForFiltering { get; set; }

    /// <summary>
    /// Controls which separators are added to an Algolia index as part of [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean). Separators are all non-letter characters except spaces and currency characters, such as $€£¥.
    /// </summary>
    /// <value>Controls which separators are added to an Algolia index as part of [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean). Separators are all non-letter characters except spaces and currency characters, such as $€£¥.</value>
    /// <example>+#</example>
    [DataMember(Name = "separatorsToIndex", EmitDefaultValue = false)]
    public string SeparatorsToIndex { get; set; }

    /// <summary>
    /// [Attributes used for searching](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/), including determining [if matches at the beginning of a word are important (ordered) or not (unordered)](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/how-to/configuring-searchable-attributes-the-right-way/#understanding-word-position). 
    /// </summary>
    /// <value>[Attributes used for searching](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/), including determining [if matches at the beginning of a word are important (ordered) or not (unordered)](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/how-to/configuring-searchable-attributes-the-right-way/#understanding-word-position). </value>
    /// <example>[&quot;title,alternative_title&quot;,&quot;author&quot;,&quot;unordered(text)&quot;,&quot;emails.personal&quot;]</example>
    [DataMember(Name = "searchableAttributes", EmitDefaultValue = false)]
    public List<string> SearchableAttributes { get; set; }

    /// <summary>
    /// Lets you store custom data in your indices.
    /// </summary>
    /// <value>Lets you store custom data in your indices.</value>
    /// <example>{&quot;settingID&quot;:&quot;f2a7b51e3503acc6a39b3784ffb84300&quot;,&quot;pluginVersion&quot;:&quot;1.6.0&quot;}</example>
    [DataMember(Name = "userData", EmitDefaultValue = true)]
    public Object UserData { get; set; }

        /// <summary>
        /// A list of characters and their normalized replacements to override Algolia&#39;s default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
        /// </summary>
        /// <value>A list of characters and their normalized replacements to override Algolia&#39;s default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).</value>
        /// <example>{default: {&#39;ä&#39;: &#39;ae&#39;, &#39;ü&#39;: &#39;ue&#39;}}
</example>
        [DataMember(Name = "customNormalization", EmitDefaultValue = false)]
    public Dictionary<string, Dictionary<string, string>> CustomNormalization { get; set; }

    /// <summary>
    /// Name of the deduplication attribute to be used with Algolia&#39;s [_distinct_ feature](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/#introducing-algolias-distinct-feature).
    /// </summary>
    /// <value>Name of the deduplication attribute to be used with Algolia&#39;s [_distinct_ feature](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/#introducing-algolias-distinct-feature).</value>
    /// <example>url</example>
    [DataMember(Name = "attributeForDistinct", EmitDefaultValue = false)]
    public string AttributeForDistinct { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BaseIndexSettings {\n");
      sb.Append("  Replicas: ").Append(Replicas).Append("\n");
      sb.Append("  PaginationLimitedTo: ").Append(PaginationLimitedTo).Append("\n");
      sb.Append("  UnretrievableAttributes: ").Append(UnretrievableAttributes).Append("\n");
      sb.Append("  DisableTypoToleranceOnWords: ").Append(DisableTypoToleranceOnWords).Append("\n");
      sb.Append("  AttributesToTransliterate: ").Append(AttributesToTransliterate).Append("\n");
      sb.Append("  CamelCaseAttributes: ").Append(CamelCaseAttributes).Append("\n");
      sb.Append("  DecompoundedAttributes: ").Append(DecompoundedAttributes).Append("\n");
      sb.Append("  IndexLanguages: ").Append(IndexLanguages).Append("\n");
      sb.Append("  DisablePrefixOnAttributes: ").Append(DisablePrefixOnAttributes).Append("\n");
      sb.Append("  AllowCompressionOfIntegerArray: ").Append(AllowCompressionOfIntegerArray).Append("\n");
      sb.Append("  NumericAttributesForFiltering: ").Append(NumericAttributesForFiltering).Append("\n");
      sb.Append("  SeparatorsToIndex: ").Append(SeparatorsToIndex).Append("\n");
      sb.Append("  SearchableAttributes: ").Append(SearchableAttributes).Append("\n");
      sb.Append("  UserData: ").Append(UserData).Append("\n");
      sb.Append("  CustomNormalization: ").Append(CustomNormalization).Append("\n");
      sb.Append("  AttributeForDistinct: ").Append(AttributeForDistinct).Append("\n");
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
      return this.Equals(input as BaseIndexSettings);
    }

    /// <summary>
    /// Returns true if BaseIndexSettings instances are equal
    /// </summary>
    /// <param name="input">Instance of BaseIndexSettings to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(BaseIndexSettings input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Replicas == input.Replicas ||
              this.Replicas != null &&
              input.Replicas != null &&
              this.Replicas.SequenceEqual(input.Replicas)
          ) &&
          (
              this.PaginationLimitedTo == input.PaginationLimitedTo ||
              this.PaginationLimitedTo.Equals(input.PaginationLimitedTo)
          ) &&
          (
              this.UnretrievableAttributes == input.UnretrievableAttributes ||
              this.UnretrievableAttributes != null &&
              input.UnretrievableAttributes != null &&
              this.UnretrievableAttributes.SequenceEqual(input.UnretrievableAttributes)
          ) &&
          (
              this.DisableTypoToleranceOnWords == input.DisableTypoToleranceOnWords ||
              this.DisableTypoToleranceOnWords != null &&
              input.DisableTypoToleranceOnWords != null &&
              this.DisableTypoToleranceOnWords.SequenceEqual(input.DisableTypoToleranceOnWords)
          ) &&
          (
              this.AttributesToTransliterate == input.AttributesToTransliterate ||
              this.AttributesToTransliterate != null &&
              input.AttributesToTransliterate != null &&
              this.AttributesToTransliterate.SequenceEqual(input.AttributesToTransliterate)
          ) &&
          (
              this.CamelCaseAttributes == input.CamelCaseAttributes ||
              this.CamelCaseAttributes != null &&
              input.CamelCaseAttributes != null &&
              this.CamelCaseAttributes.SequenceEqual(input.CamelCaseAttributes)
          ) &&
          (
              this.DecompoundedAttributes == input.DecompoundedAttributes ||
              (this.DecompoundedAttributes != null &&
              this.DecompoundedAttributes.Equals(input.DecompoundedAttributes))
          ) &&
          (
              this.IndexLanguages == input.IndexLanguages ||
              this.IndexLanguages != null &&
              input.IndexLanguages != null &&
              this.IndexLanguages.SequenceEqual(input.IndexLanguages)
          ) &&
          (
              this.DisablePrefixOnAttributes == input.DisablePrefixOnAttributes ||
              this.DisablePrefixOnAttributes != null &&
              input.DisablePrefixOnAttributes != null &&
              this.DisablePrefixOnAttributes.SequenceEqual(input.DisablePrefixOnAttributes)
          ) &&
          (
              this.AllowCompressionOfIntegerArray == input.AllowCompressionOfIntegerArray ||
              this.AllowCompressionOfIntegerArray.Equals(input.AllowCompressionOfIntegerArray)
          ) &&
          (
              this.NumericAttributesForFiltering == input.NumericAttributesForFiltering ||
              this.NumericAttributesForFiltering != null &&
              input.NumericAttributesForFiltering != null &&
              this.NumericAttributesForFiltering.SequenceEqual(input.NumericAttributesForFiltering)
          ) &&
          (
              this.SeparatorsToIndex == input.SeparatorsToIndex ||
              (this.SeparatorsToIndex != null &&
              this.SeparatorsToIndex.Equals(input.SeparatorsToIndex))
          ) &&
          (
              this.SearchableAttributes == input.SearchableAttributes ||
              this.SearchableAttributes != null &&
              input.SearchableAttributes != null &&
              this.SearchableAttributes.SequenceEqual(input.SearchableAttributes)
          ) &&
          (
              this.UserData == input.UserData ||
              (this.UserData != null &&
              this.UserData.Equals(input.UserData))
          ) &&
          (
              this.CustomNormalization == input.CustomNormalization ||
              this.CustomNormalization != null &&
              input.CustomNormalization != null &&
              this.CustomNormalization.SequenceEqual(input.CustomNormalization)
          ) &&
          (
              this.AttributeForDistinct == input.AttributeForDistinct ||
              (this.AttributeForDistinct != null &&
              this.AttributeForDistinct.Equals(input.AttributeForDistinct))
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
        if (this.Replicas != null)
        {
          hashCode = (hashCode * 59) + this.Replicas.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.PaginationLimitedTo.GetHashCode();
        if (this.UnretrievableAttributes != null)
        {
          hashCode = (hashCode * 59) + this.UnretrievableAttributes.GetHashCode();
        }
        if (this.DisableTypoToleranceOnWords != null)
        {
          hashCode = (hashCode * 59) + this.DisableTypoToleranceOnWords.GetHashCode();
        }
        if (this.AttributesToTransliterate != null)
        {
          hashCode = (hashCode * 59) + this.AttributesToTransliterate.GetHashCode();
        }
        if (this.CamelCaseAttributes != null)
        {
          hashCode = (hashCode * 59) + this.CamelCaseAttributes.GetHashCode();
        }
        if (this.DecompoundedAttributes != null)
        {
          hashCode = (hashCode * 59) + this.DecompoundedAttributes.GetHashCode();
        }
        if (this.IndexLanguages != null)
        {
          hashCode = (hashCode * 59) + this.IndexLanguages.GetHashCode();
        }
        if (this.DisablePrefixOnAttributes != null)
        {
          hashCode = (hashCode * 59) + this.DisablePrefixOnAttributes.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.AllowCompressionOfIntegerArray.GetHashCode();
        if (this.NumericAttributesForFiltering != null)
        {
          hashCode = (hashCode * 59) + this.NumericAttributesForFiltering.GetHashCode();
        }
        if (this.SeparatorsToIndex != null)
        {
          hashCode = (hashCode * 59) + this.SeparatorsToIndex.GetHashCode();
        }
        if (this.SearchableAttributes != null)
        {
          hashCode = (hashCode * 59) + this.SearchableAttributes.GetHashCode();
        }
        if (this.UserData != null)
        {
          hashCode = (hashCode * 59) + this.UserData.GetHashCode();
        }
        if (this.CustomNormalization != null)
        {
          hashCode = (hashCode * 59) + this.CustomNormalization.GetHashCode();
        }
        if (this.AttributeForDistinct != null)
        {
          hashCode = (hashCode * 59) + this.AttributeForDistinct.GetHashCode();
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
