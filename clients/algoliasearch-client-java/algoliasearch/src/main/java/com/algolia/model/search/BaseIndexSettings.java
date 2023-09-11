// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** BaseIndexSettings */
public class BaseIndexSettings {

  @JsonProperty("replicas")
  private List<String> replicas;

  @JsonProperty("paginationLimitedTo")
  private Integer paginationLimitedTo;

  @JsonProperty("unretrievableAttributes")
  private List<String> unretrievableAttributes;

  @JsonProperty("disableTypoToleranceOnWords")
  private List<String> disableTypoToleranceOnWords;

  @JsonProperty("attributesToTransliterate")
  private List<String> attributesToTransliterate;

  @JsonProperty("camelCaseAttributes")
  private List<String> camelCaseAttributes;

  @JsonProperty("decompoundedAttributes")
  private Object decompoundedAttributes;

  @JsonProperty("indexLanguages")
  private List<String> indexLanguages;

  @JsonProperty("disablePrefixOnAttributes")
  private List<String> disablePrefixOnAttributes;

  @JsonProperty("allowCompressionOfIntegerArray")
  private Boolean allowCompressionOfIntegerArray;

  @JsonProperty("numericAttributesForFiltering")
  private List<String> numericAttributesForFiltering;

  @JsonProperty("separatorsToIndex")
  private String separatorsToIndex;

  @JsonProperty("searchableAttributes")
  private List<String> searchableAttributes;

  @JsonProperty("userData")
  private Object userData;

  @JsonProperty("customNormalization")
  private Map<String, Map<String, String>> customNormalization;

  public BaseIndexSettings setReplicas(List<String> replicas) {
    this.replicas = replicas;
    return this;
  }

  public BaseIndexSettings addReplicas(String replicasItem) {
    if (this.replicas == null) {
      this.replicas = new ArrayList<>();
    }
    this.replicas.add(replicasItem);
    return this;
  }

  /**
   * Creates
   * [replicas](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/),
   * which are copies of a primary index with the same records but different settings.
   */
  @javax.annotation.Nullable
  public List<String> getReplicas() {
    return replicas;
  }

  public BaseIndexSettings setPaginationLimitedTo(Integer paginationLimitedTo) {
    this.paginationLimitedTo = paginationLimitedTo;
    return this;
  }

  /** Maximum number of hits accessible through pagination. */
  @javax.annotation.Nullable
  public Integer getPaginationLimitedTo() {
    return paginationLimitedTo;
  }

  public BaseIndexSettings setUnretrievableAttributes(List<String> unretrievableAttributes) {
    this.unretrievableAttributes = unretrievableAttributes;
    return this;
  }

  public BaseIndexSettings addUnretrievableAttributes(String unretrievableAttributesItem) {
    if (this.unretrievableAttributes == null) {
      this.unretrievableAttributes = new ArrayList<>();
    }
    this.unretrievableAttributes.add(unretrievableAttributesItem);
    return this;
  }

  /** Attributes that can't be retrieved at query time. */
  @javax.annotation.Nullable
  public List<String> getUnretrievableAttributes() {
    return unretrievableAttributes;
  }

  public BaseIndexSettings setDisableTypoToleranceOnWords(List<String> disableTypoToleranceOnWords) {
    this.disableTypoToleranceOnWords = disableTypoToleranceOnWords;
    return this;
  }

  public BaseIndexSettings addDisableTypoToleranceOnWords(String disableTypoToleranceOnWordsItem) {
    if (this.disableTypoToleranceOnWords == null) {
      this.disableTypoToleranceOnWords = new ArrayList<>();
    }
    this.disableTypoToleranceOnWords.add(disableTypoToleranceOnWordsItem);
    return this;
  }

  /**
   * Words for which you want to turn off [typo
   * tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).
   */
  @javax.annotation.Nullable
  public List<String> getDisableTypoToleranceOnWords() {
    return disableTypoToleranceOnWords;
  }

  public BaseIndexSettings setAttributesToTransliterate(List<String> attributesToTransliterate) {
    this.attributesToTransliterate = attributesToTransliterate;
    return this;
  }

  public BaseIndexSettings addAttributesToTransliterate(String attributesToTransliterateItem) {
    if (this.attributesToTransliterate == null) {
      this.attributesToTransliterate = new ArrayList<>();
    }
    this.attributesToTransliterate.add(attributesToTransliterateItem);
    return this;
  }

  /**
   * Attributes in your index to which [Japanese
   * transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead)
   * applies. This will ensure that words indexed in Katakana or Kanji can also be searched in
   * Hiragana.
   */
  @javax.annotation.Nullable
  public List<String> getAttributesToTransliterate() {
    return attributesToTransliterate;
  }

  public BaseIndexSettings setCamelCaseAttributes(List<String> camelCaseAttributes) {
    this.camelCaseAttributes = camelCaseAttributes;
    return this;
  }

  public BaseIndexSettings addCamelCaseAttributes(String camelCaseAttributesItem) {
    if (this.camelCaseAttributes == null) {
      this.camelCaseAttributes = new ArrayList<>();
    }
    this.camelCaseAttributes.add(camelCaseAttributesItem);
    return this;
  }

  /** Attributes on which to split [camel case](https://wikipedia.org/wiki/Camel_case) words. */
  @javax.annotation.Nullable
  public List<String> getCamelCaseAttributes() {
    return camelCaseAttributes;
  }

  public BaseIndexSettings setDecompoundedAttributes(Object decompoundedAttributes) {
    this.decompoundedAttributes = decompoundedAttributes;
    return this;
  }

  /**
   * Attributes in your index to which [word
   * segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/)
   * (decompounding) applies.
   */
  @javax.annotation.Nullable
  public Object getDecompoundedAttributes() {
    return decompoundedAttributes;
  }

  public BaseIndexSettings setIndexLanguages(List<String> indexLanguages) {
    this.indexLanguages = indexLanguages;
    return this;
  }

  public BaseIndexSettings addIndexLanguages(String indexLanguagesItem) {
    if (this.indexLanguages == null) {
      this.indexLanguages = new ArrayList<>();
    }
    this.indexLanguages.add(indexLanguagesItem);
    return this;
  }

  /**
   * Set the languages of your index, for language-specific processing steps such as
   * [tokenization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/tokenization/)
   * and
   * [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
   */
  @javax.annotation.Nullable
  public List<String> getIndexLanguages() {
    return indexLanguages;
  }

  public BaseIndexSettings setDisablePrefixOnAttributes(List<String> disablePrefixOnAttributes) {
    this.disablePrefixOnAttributes = disablePrefixOnAttributes;
    return this;
  }

  public BaseIndexSettings addDisablePrefixOnAttributes(String disablePrefixOnAttributesItem) {
    if (this.disablePrefixOnAttributes == null) {
      this.disablePrefixOnAttributes = new ArrayList<>();
    }
    this.disablePrefixOnAttributes.add(disablePrefixOnAttributesItem);
    return this;
  }

  /**
   * Attributes for which you want to turn off [prefix
   * matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).
   */
  @javax.annotation.Nullable
  public List<String> getDisablePrefixOnAttributes() {
    return disablePrefixOnAttributes;
  }

  public BaseIndexSettings setAllowCompressionOfIntegerArray(Boolean allowCompressionOfIntegerArray) {
    this.allowCompressionOfIntegerArray = allowCompressionOfIntegerArray;
    return this;
  }

  /**
   * Incidates whether the engine compresses arrays with exclusively non-negative integers. When
   * enabled, the compressed arrays may be reordered.
   */
  @javax.annotation.Nullable
  public Boolean getAllowCompressionOfIntegerArray() {
    return allowCompressionOfIntegerArray;
  }

  public BaseIndexSettings setNumericAttributesForFiltering(List<String> numericAttributesForFiltering) {
    this.numericAttributesForFiltering = numericAttributesForFiltering;
    return this;
  }

  public BaseIndexSettings addNumericAttributesForFiltering(String numericAttributesForFilteringItem) {
    if (this.numericAttributesForFiltering == null) {
      this.numericAttributesForFiltering = new ArrayList<>();
    }
    this.numericAttributesForFiltering.add(numericAttributesForFilteringItem);
    return this;
  }

  /**
   * Numeric attributes that can be used as [numerical
   * filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).
   */
  @javax.annotation.Nullable
  public List<String> getNumericAttributesForFiltering() {
    return numericAttributesForFiltering;
  }

  public BaseIndexSettings setSeparatorsToIndex(String separatorsToIndex) {
    this.separatorsToIndex = separatorsToIndex;
    return this;
  }

  /**
   * Controls which separators are added to an Algolia index as part of
   * [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean).
   * Separators are all non-letter characters except spaces and currency characters, such as $€£¥.
   */
  @javax.annotation.Nullable
  public String getSeparatorsToIndex() {
    return separatorsToIndex;
  }

  public BaseIndexSettings setSearchableAttributes(List<String> searchableAttributes) {
    this.searchableAttributes = searchableAttributes;
    return this;
  }

  public BaseIndexSettings addSearchableAttributes(String searchableAttributesItem) {
    if (this.searchableAttributes == null) {
      this.searchableAttributes = new ArrayList<>();
    }
    this.searchableAttributes.add(searchableAttributesItem);
    return this;
  }

  /**
   * [Attributes used for
   * searching](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/),
   * including determining [if matches at the beginning of a word are important (ordered) or not
   * (unordered)](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/how-to/configuring-searchable-attributes-the-right-way/#understanding-word-position).
   */
  @javax.annotation.Nullable
  public List<String> getSearchableAttributes() {
    return searchableAttributes;
  }

  public BaseIndexSettings setUserData(Object userData) {
    this.userData = userData;
    return this;
  }

  /** Lets you store custom data in your indices. */
  @javax.annotation.Nullable
  public Object getUserData() {
    return userData;
  }

  public BaseIndexSettings setCustomNormalization(Map<String, Map<String, String>> customNormalization) {
    this.customNormalization = customNormalization;
    return this;
  }

  public BaseIndexSettings putCustomNormalization(String key, Map<String, String> customNormalizationItem) {
    if (this.customNormalization == null) {
      this.customNormalization = new HashMap<>();
    }
    this.customNormalization.put(key, customNormalizationItem);
    return this;
  }

  /**
   * A list of characters and their normalized replacements to override Algolia's default
   * [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
   */
  @javax.annotation.Nullable
  public Map<String, Map<String, String>> getCustomNormalization() {
    return customNormalization;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseIndexSettings baseIndexSettings = (BaseIndexSettings) o;
    return (
      Objects.equals(this.replicas, baseIndexSettings.replicas) &&
      Objects.equals(this.paginationLimitedTo, baseIndexSettings.paginationLimitedTo) &&
      Objects.equals(this.unretrievableAttributes, baseIndexSettings.unretrievableAttributes) &&
      Objects.equals(this.disableTypoToleranceOnWords, baseIndexSettings.disableTypoToleranceOnWords) &&
      Objects.equals(this.attributesToTransliterate, baseIndexSettings.attributesToTransliterate) &&
      Objects.equals(this.camelCaseAttributes, baseIndexSettings.camelCaseAttributes) &&
      Objects.equals(this.decompoundedAttributes, baseIndexSettings.decompoundedAttributes) &&
      Objects.equals(this.indexLanguages, baseIndexSettings.indexLanguages) &&
      Objects.equals(this.disablePrefixOnAttributes, baseIndexSettings.disablePrefixOnAttributes) &&
      Objects.equals(this.allowCompressionOfIntegerArray, baseIndexSettings.allowCompressionOfIntegerArray) &&
      Objects.equals(this.numericAttributesForFiltering, baseIndexSettings.numericAttributesForFiltering) &&
      Objects.equals(this.separatorsToIndex, baseIndexSettings.separatorsToIndex) &&
      Objects.equals(this.searchableAttributes, baseIndexSettings.searchableAttributes) &&
      Objects.equals(this.userData, baseIndexSettings.userData) &&
      Objects.equals(this.customNormalization, baseIndexSettings.customNormalization)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      replicas,
      paginationLimitedTo,
      unretrievableAttributes,
      disableTypoToleranceOnWords,
      attributesToTransliterate,
      camelCaseAttributes,
      decompoundedAttributes,
      indexLanguages,
      disablePrefixOnAttributes,
      allowCompressionOfIntegerArray,
      numericAttributesForFiltering,
      separatorsToIndex,
      searchableAttributes,
      userData,
      customNormalization
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseIndexSettings {\n");
    sb.append("    replicas: ").append(toIndentedString(replicas)).append("\n");
    sb.append("    paginationLimitedTo: ").append(toIndentedString(paginationLimitedTo)).append("\n");
    sb.append("    unretrievableAttributes: ").append(toIndentedString(unretrievableAttributes)).append("\n");
    sb.append("    disableTypoToleranceOnWords: ").append(toIndentedString(disableTypoToleranceOnWords)).append("\n");
    sb.append("    attributesToTransliterate: ").append(toIndentedString(attributesToTransliterate)).append("\n");
    sb.append("    camelCaseAttributes: ").append(toIndentedString(camelCaseAttributes)).append("\n");
    sb.append("    decompoundedAttributes: ").append(toIndentedString(decompoundedAttributes)).append("\n");
    sb.append("    indexLanguages: ").append(toIndentedString(indexLanguages)).append("\n");
    sb.append("    disablePrefixOnAttributes: ").append(toIndentedString(disablePrefixOnAttributes)).append("\n");
    sb.append("    allowCompressionOfIntegerArray: ").append(toIndentedString(allowCompressionOfIntegerArray)).append("\n");
    sb.append("    numericAttributesForFiltering: ").append(toIndentedString(numericAttributesForFiltering)).append("\n");
    sb.append("    separatorsToIndex: ").append(toIndentedString(separatorsToIndex)).append("\n");
    sb.append("    searchableAttributes: ").append(toIndentedString(searchableAttributes)).append("\n");
    sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
    sb.append("    customNormalization: ").append(toIndentedString(customNormalization)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
