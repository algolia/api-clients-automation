/*
 * Search API
 * API powering the Search feature of Algolia.
 *
 * The version of the OpenAPI document: 0.1.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.algolia.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** BaseIndexSettings */
@JsonPropertyOrder(
  {
    BaseIndexSettings.JSON_PROPERTY_REPLICAS,
    BaseIndexSettings.JSON_PROPERTY_PAGINATION_LIMITED_TO,
    BaseIndexSettings.JSON_PROPERTY_DISABLE_TYPO_TOLERANCE_ON_WORDS,
    BaseIndexSettings.JSON_PROPERTY_ATTRIBUTES_TO_TRANSLITERATE,
    BaseIndexSettings.JSON_PROPERTY_CAMEL_CASE_ATTRIBUTES,
    BaseIndexSettings.JSON_PROPERTY_DECOMPOUNDED_ATTRIBUTES,
    BaseIndexSettings.JSON_PROPERTY_INDEX_LANGUAGES,
    BaseIndexSettings.JSON_PROPERTY_FILTER_PROMOTES,
    BaseIndexSettings.JSON_PROPERTY_DISABLE_PREFIX_ON_ATTRIBUTES,
    BaseIndexSettings.JSON_PROPERTY_ALLOW_COMPRESSION_OF_INTEGER_ARRAY,
    BaseIndexSettings.JSON_PROPERTY_NUMERIC_ATTRIBUTES_FOR_FILTERING,
    BaseIndexSettings.JSON_PROPERTY_USER_DATA,
  }
)
@JsonTypeName("baseIndexSettings")
public class BaseIndexSettings {

  public static final String JSON_PROPERTY_REPLICAS = "replicas";
  private List<String> replicas = null;

  public static final String JSON_PROPERTY_PAGINATION_LIMITED_TO =
    "paginationLimitedTo";
  private Integer paginationLimitedTo = 1000;

  public static final String JSON_PROPERTY_DISABLE_TYPO_TOLERANCE_ON_WORDS =
    "disableTypoToleranceOnWords";
  private List<String> disableTypoToleranceOnWords = null;

  public static final String JSON_PROPERTY_ATTRIBUTES_TO_TRANSLITERATE =
    "attributesToTransliterate";
  private List<String> attributesToTransliterate = null;

  public static final String JSON_PROPERTY_CAMEL_CASE_ATTRIBUTES =
    "camelCaseAttributes";
  private List<String> camelCaseAttributes = null;

  public static final String JSON_PROPERTY_DECOMPOUNDED_ATTRIBUTES =
    "decompoundedAttributes";
  private Map<String, Object> decompoundedAttributes = null;

  public static final String JSON_PROPERTY_INDEX_LANGUAGES = "indexLanguages";
  private List<String> indexLanguages = null;

  public static final String JSON_PROPERTY_FILTER_PROMOTES = "filterPromotes";
  private Boolean filterPromotes = false;

  public static final String JSON_PROPERTY_DISABLE_PREFIX_ON_ATTRIBUTES =
    "disablePrefixOnAttributes";
  private List<String> disablePrefixOnAttributes = null;

  public static final String JSON_PROPERTY_ALLOW_COMPRESSION_OF_INTEGER_ARRAY =
    "allowCompressionOfIntegerArray";
  private Boolean allowCompressionOfIntegerArray = false;

  public static final String JSON_PROPERTY_NUMERIC_ATTRIBUTES_FOR_FILTERING =
    "numericAttributesForFiltering";
  private List<String> numericAttributesForFiltering = null;

  public static final String JSON_PROPERTY_USER_DATA = "userData";
  private Map<String, Object> userData = null;

  public BaseIndexSettings replicas(List<String> replicas) {
    this.replicas = replicas;
    return this;
  }

  public BaseIndexSettings addReplicasItem(String replicasItem) {
    if (this.replicas == null) {
      this.replicas = new ArrayList<>();
    }
    this.replicas.add(replicasItem);
    return this;
  }

  /**
   * Creates replicas, exact copies of an index.
   *
   * @return replicas
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Creates replicas, exact copies of an index.")
  @JsonProperty(JSON_PROPERTY_REPLICAS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getReplicas() {
    return replicas;
  }

  @JsonProperty(JSON_PROPERTY_REPLICAS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReplicas(List<String> replicas) {
    this.replicas = replicas;
  }

  public BaseIndexSettings paginationLimitedTo(Integer paginationLimitedTo) {
    this.paginationLimitedTo = paginationLimitedTo;
    return this;
  }

  /**
   * Set the maximum number of hits accessible via pagination.
   *
   * @return paginationLimitedTo
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Set the maximum number of hits accessible via pagination."
  )
  @JsonProperty(JSON_PROPERTY_PAGINATION_LIMITED_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getPaginationLimitedTo() {
    return paginationLimitedTo;
  }

  @JsonProperty(JSON_PROPERTY_PAGINATION_LIMITED_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaginationLimitedTo(Integer paginationLimitedTo) {
    this.paginationLimitedTo = paginationLimitedTo;
  }

  public BaseIndexSettings disableTypoToleranceOnWords(
    List<String> disableTypoToleranceOnWords
  ) {
    this.disableTypoToleranceOnWords = disableTypoToleranceOnWords;
    return this;
  }

  public BaseIndexSettings addDisableTypoToleranceOnWordsItem(
    String disableTypoToleranceOnWordsItem
  ) {
    if (this.disableTypoToleranceOnWords == null) {
      this.disableTypoToleranceOnWords = new ArrayList<>();
    }
    this.disableTypoToleranceOnWords.add(disableTypoToleranceOnWordsItem);
    return this;
  }

  /**
   * A list of words for which you want to turn off typo tolerance.
   *
   * @return disableTypoToleranceOnWords
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "A list of words for which you want to turn off typo tolerance."
  )
  @JsonProperty(JSON_PROPERTY_DISABLE_TYPO_TOLERANCE_ON_WORDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getDisableTypoToleranceOnWords() {
    return disableTypoToleranceOnWords;
  }

  @JsonProperty(JSON_PROPERTY_DISABLE_TYPO_TOLERANCE_ON_WORDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisableTypoToleranceOnWords(
    List<String> disableTypoToleranceOnWords
  ) {
    this.disableTypoToleranceOnWords = disableTypoToleranceOnWords;
  }

  public BaseIndexSettings attributesToTransliterate(
    List<String> attributesToTransliterate
  ) {
    this.attributesToTransliterate = attributesToTransliterate;
    return this;
  }

  public BaseIndexSettings addAttributesToTransliterateItem(
    String attributesToTransliterateItem
  ) {
    if (this.attributesToTransliterate == null) {
      this.attributesToTransliterate = new ArrayList<>();
    }
    this.attributesToTransliterate.add(attributesToTransliterateItem);
    return this;
  }

  /**
   * Specify on which attributes to apply transliteration.
   *
   * @return attributesToTransliterate
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Specify on which attributes to apply transliteration."
  )
  @JsonProperty(JSON_PROPERTY_ATTRIBUTES_TO_TRANSLITERATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getAttributesToTransliterate() {
    return attributesToTransliterate;
  }

  @JsonProperty(JSON_PROPERTY_ATTRIBUTES_TO_TRANSLITERATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttributesToTransliterate(
    List<String> attributesToTransliterate
  ) {
    this.attributesToTransliterate = attributesToTransliterate;
  }

  public BaseIndexSettings camelCaseAttributes(
    List<String> camelCaseAttributes
  ) {
    this.camelCaseAttributes = camelCaseAttributes;
    return this;
  }

  public BaseIndexSettings addCamelCaseAttributesItem(
    String camelCaseAttributesItem
  ) {
    if (this.camelCaseAttributes == null) {
      this.camelCaseAttributes = new ArrayList<>();
    }
    this.camelCaseAttributes.add(camelCaseAttributesItem);
    return this;
  }

  /**
   * List of attributes on which to do a decomposition of camel case words.
   *
   * @return camelCaseAttributes
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "List of attributes on which to do a decomposition of camel case words."
  )
  @JsonProperty(JSON_PROPERTY_CAMEL_CASE_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getCamelCaseAttributes() {
    return camelCaseAttributes;
  }

  @JsonProperty(JSON_PROPERTY_CAMEL_CASE_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCamelCaseAttributes(List<String> camelCaseAttributes) {
    this.camelCaseAttributes = camelCaseAttributes;
  }

  public BaseIndexSettings decompoundedAttributes(
    Map<String, Object> decompoundedAttributes
  ) {
    this.decompoundedAttributes = decompoundedAttributes;
    return this;
  }

  public BaseIndexSettings putDecompoundedAttributesItem(
    String key,
    Object decompoundedAttributesItem
  ) {
    if (this.decompoundedAttributes == null) {
      this.decompoundedAttributes = new HashMap<>();
    }
    this.decompoundedAttributes.put(key, decompoundedAttributesItem);
    return this;
  }

  /**
   * Specify on which attributes in your index Algolia should apply word segmentation, also known as
   * decompounding.
   *
   * @return decompoundedAttributes
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Specify on which attributes in your index Algolia should apply word segmentation, also" +
    " known as decompounding."
  )
  @JsonProperty(JSON_PROPERTY_DECOMPOUNDED_ATTRIBUTES)
  @JsonInclude(
    content = JsonInclude.Include.ALWAYS,
    value = JsonInclude.Include.USE_DEFAULTS
  )
  public Map<String, Object> getDecompoundedAttributes() {
    return decompoundedAttributes;
  }

  @JsonProperty(JSON_PROPERTY_DECOMPOUNDED_ATTRIBUTES)
  @JsonInclude(
    content = JsonInclude.Include.ALWAYS,
    value = JsonInclude.Include.USE_DEFAULTS
  )
  public void setDecompoundedAttributes(
    Map<String, Object> decompoundedAttributes
  ) {
    this.decompoundedAttributes = decompoundedAttributes;
  }

  public BaseIndexSettings indexLanguages(List<String> indexLanguages) {
    this.indexLanguages = indexLanguages;
    return this;
  }

  public BaseIndexSettings addIndexLanguagesItem(String indexLanguagesItem) {
    if (this.indexLanguages == null) {
      this.indexLanguages = new ArrayList<>();
    }
    this.indexLanguages.add(indexLanguagesItem);
    return this;
  }

  /**
   * Sets the languages at the index level for language-specific processing such as tokenization and
   * normalization.
   *
   * @return indexLanguages
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Sets the languages at the index level for language-specific processing such as" +
    " tokenization and normalization."
  )
  @JsonProperty(JSON_PROPERTY_INDEX_LANGUAGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getIndexLanguages() {
    return indexLanguages;
  }

  @JsonProperty(JSON_PROPERTY_INDEX_LANGUAGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIndexLanguages(List<String> indexLanguages) {
    this.indexLanguages = indexLanguages;
  }

  public BaseIndexSettings filterPromotes(Boolean filterPromotes) {
    this.filterPromotes = filterPromotes;
    return this;
  }

  /**
   * Whether promoted results should match the filters of the current search, except for geographic
   * filters.
   *
   * @return filterPromotes
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Whether promoted results should match the filters of the current search, except for" +
    " geographic filters."
  )
  @JsonProperty(JSON_PROPERTY_FILTER_PROMOTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getFilterPromotes() {
    return filterPromotes;
  }

  @JsonProperty(JSON_PROPERTY_FILTER_PROMOTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFilterPromotes(Boolean filterPromotes) {
    this.filterPromotes = filterPromotes;
  }

  public BaseIndexSettings disablePrefixOnAttributes(
    List<String> disablePrefixOnAttributes
  ) {
    this.disablePrefixOnAttributes = disablePrefixOnAttributes;
    return this;
  }

  public BaseIndexSettings addDisablePrefixOnAttributesItem(
    String disablePrefixOnAttributesItem
  ) {
    if (this.disablePrefixOnAttributes == null) {
      this.disablePrefixOnAttributes = new ArrayList<>();
    }
    this.disablePrefixOnAttributes.add(disablePrefixOnAttributesItem);
    return this;
  }

  /**
   * List of attributes on which you want to disable prefix matching.
   *
   * @return disablePrefixOnAttributes
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "List of attributes on which you want to disable prefix matching."
  )
  @JsonProperty(JSON_PROPERTY_DISABLE_PREFIX_ON_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getDisablePrefixOnAttributes() {
    return disablePrefixOnAttributes;
  }

  @JsonProperty(JSON_PROPERTY_DISABLE_PREFIX_ON_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisablePrefixOnAttributes(
    List<String> disablePrefixOnAttributes
  ) {
    this.disablePrefixOnAttributes = disablePrefixOnAttributes;
  }

  public BaseIndexSettings allowCompressionOfIntegerArray(
    Boolean allowCompressionOfIntegerArray
  ) {
    this.allowCompressionOfIntegerArray = allowCompressionOfIntegerArray;
    return this;
  }

  /**
   * Enables compression of large integer arrays.
   *
   * @return allowCompressionOfIntegerArray
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Enables compression of large integer arrays.")
  @JsonProperty(JSON_PROPERTY_ALLOW_COMPRESSION_OF_INTEGER_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getAllowCompressionOfIntegerArray() {
    return allowCompressionOfIntegerArray;
  }

  @JsonProperty(JSON_PROPERTY_ALLOW_COMPRESSION_OF_INTEGER_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAllowCompressionOfIntegerArray(
    Boolean allowCompressionOfIntegerArray
  ) {
    this.allowCompressionOfIntegerArray = allowCompressionOfIntegerArray;
  }

  public BaseIndexSettings numericAttributesForFiltering(
    List<String> numericAttributesForFiltering
  ) {
    this.numericAttributesForFiltering = numericAttributesForFiltering;
    return this;
  }

  public BaseIndexSettings addNumericAttributesForFilteringItem(
    String numericAttributesForFilteringItem
  ) {
    if (this.numericAttributesForFiltering == null) {
      this.numericAttributesForFiltering = new ArrayList<>();
    }
    this.numericAttributesForFiltering.add(numericAttributesForFilteringItem);
    return this;
  }

  /**
   * List of numeric attributes that can be used as numerical filters.
   *
   * @return numericAttributesForFiltering
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "List of numeric attributes that can be used as numerical filters."
  )
  @JsonProperty(JSON_PROPERTY_NUMERIC_ATTRIBUTES_FOR_FILTERING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getNumericAttributesForFiltering() {
    return numericAttributesForFiltering;
  }

  @JsonProperty(JSON_PROPERTY_NUMERIC_ATTRIBUTES_FOR_FILTERING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumericAttributesForFiltering(
    List<String> numericAttributesForFiltering
  ) {
    this.numericAttributesForFiltering = numericAttributesForFiltering;
  }

  public BaseIndexSettings userData(Map<String, Object> userData) {
    this.userData = userData;
    return this;
  }

  public BaseIndexSettings putUserDataItem(String key, Object userDataItem) {
    if (this.userData == null) {
      this.userData = new HashMap<>();
    }
    this.userData.put(key, userDataItem);
    return this;
  }

  /**
   * Lets you store custom data in your indices.
   *
   * @return userData
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Lets you store custom data in your indices.")
  @JsonProperty(JSON_PROPERTY_USER_DATA)
  @JsonInclude(
    content = JsonInclude.Include.ALWAYS,
    value = JsonInclude.Include.USE_DEFAULTS
  )
  public Map<String, Object> getUserData() {
    return userData;
  }

  @JsonProperty(JSON_PROPERTY_USER_DATA)
  @JsonInclude(
    content = JsonInclude.Include.ALWAYS,
    value = JsonInclude.Include.USE_DEFAULTS
  )
  public void setUserData(Map<String, Object> userData) {
    this.userData = userData;
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
      Objects.equals(
        this.paginationLimitedTo,
        baseIndexSettings.paginationLimitedTo
      ) &&
      Objects.equals(
        this.disableTypoToleranceOnWords,
        baseIndexSettings.disableTypoToleranceOnWords
      ) &&
      Objects.equals(
        this.attributesToTransliterate,
        baseIndexSettings.attributesToTransliterate
      ) &&
      Objects.equals(
        this.camelCaseAttributes,
        baseIndexSettings.camelCaseAttributes
      ) &&
      Objects.equals(
        this.decompoundedAttributes,
        baseIndexSettings.decompoundedAttributes
      ) &&
      Objects.equals(this.indexLanguages, baseIndexSettings.indexLanguages) &&
      Objects.equals(this.filterPromotes, baseIndexSettings.filterPromotes) &&
      Objects.equals(
        this.disablePrefixOnAttributes,
        baseIndexSettings.disablePrefixOnAttributes
      ) &&
      Objects.equals(
        this.allowCompressionOfIntegerArray,
        baseIndexSettings.allowCompressionOfIntegerArray
      ) &&
      Objects.equals(
        this.numericAttributesForFiltering,
        baseIndexSettings.numericAttributesForFiltering
      ) &&
      Objects.equals(this.userData, baseIndexSettings.userData)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      replicas,
      paginationLimitedTo,
      disableTypoToleranceOnWords,
      attributesToTransliterate,
      camelCaseAttributes,
      decompoundedAttributes,
      indexLanguages,
      filterPromotes,
      disablePrefixOnAttributes,
      allowCompressionOfIntegerArray,
      numericAttributesForFiltering,
      userData
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseIndexSettings {\n");
    sb.append("    replicas: ").append(toIndentedString(replicas)).append("\n");
    sb
      .append("    paginationLimitedTo: ")
      .append(toIndentedString(paginationLimitedTo))
      .append("\n");
    sb
      .append("    disableTypoToleranceOnWords: ")
      .append(toIndentedString(disableTypoToleranceOnWords))
      .append("\n");
    sb
      .append("    attributesToTransliterate: ")
      .append(toIndentedString(attributesToTransliterate))
      .append("\n");
    sb
      .append("    camelCaseAttributes: ")
      .append(toIndentedString(camelCaseAttributes))
      .append("\n");
    sb
      .append("    decompoundedAttributes: ")
      .append(toIndentedString(decompoundedAttributes))
      .append("\n");
    sb
      .append("    indexLanguages: ")
      .append(toIndentedString(indexLanguages))
      .append("\n");
    sb
      .append("    filterPromotes: ")
      .append(toIndentedString(filterPromotes))
      .append("\n");
    sb
      .append("    disablePrefixOnAttributes: ")
      .append(toIndentedString(disablePrefixOnAttributes))
      .append("\n");
    sb
      .append("    allowCompressionOfIntegerArray: ")
      .append(toIndentedString(allowCompressionOfIntegerArray))
      .append("\n");
    sb
      .append("    numericAttributesForFiltering: ")
      .append(toIndentedString(numericAttributesForFiltering))
      .append("\n");
    sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
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
