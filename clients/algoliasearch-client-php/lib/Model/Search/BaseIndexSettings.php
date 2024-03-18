<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * BaseIndexSettings Class Doc Comment.
 *
 * @category Class
 */
class BaseIndexSettings extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'attributesForFaceting' => 'string[]',
        'replicas' => 'string[]',
        'paginationLimitedTo' => 'int',
        'unretrievableAttributes' => 'string[]',
        'disableTypoToleranceOnWords' => 'string[]',
        'attributesToTransliterate' => 'string[]',
        'camelCaseAttributes' => 'string[]',
        'decompoundedAttributes' => 'object',
        'indexLanguages' => '\Algolia\AlgoliaSearch\Model\Search\SupportedLanguage[]',
        'disablePrefixOnAttributes' => 'string[]',
        'allowCompressionOfIntegerArray' => 'bool',
        'numericAttributesForFiltering' => 'string[]',
        'separatorsToIndex' => 'string',
        'searchableAttributes' => 'string[]',
        'userData' => 'mixed',
        'customNormalization' => 'array<string,array<string,string>>',
        'attributeForDistinct' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'attributesForFaceting' => null,
        'replicas' => null,
        'paginationLimitedTo' => null,
        'unretrievableAttributes' => null,
        'disableTypoToleranceOnWords' => null,
        'attributesToTransliterate' => null,
        'camelCaseAttributes' => null,
        'decompoundedAttributes' => null,
        'indexLanguages' => null,
        'disablePrefixOnAttributes' => null,
        'allowCompressionOfIntegerArray' => null,
        'numericAttributesForFiltering' => null,
        'separatorsToIndex' => null,
        'searchableAttributes' => null,
        'userData' => null,
        'customNormalization' => null,
        'attributeForDistinct' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'attributesForFaceting' => 'attributesForFaceting',
        'replicas' => 'replicas',
        'paginationLimitedTo' => 'paginationLimitedTo',
        'unretrievableAttributes' => 'unretrievableAttributes',
        'disableTypoToleranceOnWords' => 'disableTypoToleranceOnWords',
        'attributesToTransliterate' => 'attributesToTransliterate',
        'camelCaseAttributes' => 'camelCaseAttributes',
        'decompoundedAttributes' => 'decompoundedAttributes',
        'indexLanguages' => 'indexLanguages',
        'disablePrefixOnAttributes' => 'disablePrefixOnAttributes',
        'allowCompressionOfIntegerArray' => 'allowCompressionOfIntegerArray',
        'numericAttributesForFiltering' => 'numericAttributesForFiltering',
        'separatorsToIndex' => 'separatorsToIndex',
        'searchableAttributes' => 'searchableAttributes',
        'userData' => 'userData',
        'customNormalization' => 'customNormalization',
        'attributeForDistinct' => 'attributeForDistinct',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'attributesForFaceting' => 'setAttributesForFaceting',
        'replicas' => 'setReplicas',
        'paginationLimitedTo' => 'setPaginationLimitedTo',
        'unretrievableAttributes' => 'setUnretrievableAttributes',
        'disableTypoToleranceOnWords' => 'setDisableTypoToleranceOnWords',
        'attributesToTransliterate' => 'setAttributesToTransliterate',
        'camelCaseAttributes' => 'setCamelCaseAttributes',
        'decompoundedAttributes' => 'setDecompoundedAttributes',
        'indexLanguages' => 'setIndexLanguages',
        'disablePrefixOnAttributes' => 'setDisablePrefixOnAttributes',
        'allowCompressionOfIntegerArray' => 'setAllowCompressionOfIntegerArray',
        'numericAttributesForFiltering' => 'setNumericAttributesForFiltering',
        'separatorsToIndex' => 'setSeparatorsToIndex',
        'searchableAttributes' => 'setSearchableAttributes',
        'userData' => 'setUserData',
        'customNormalization' => 'setCustomNormalization',
        'attributeForDistinct' => 'setAttributeForDistinct',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'attributesForFaceting' => 'getAttributesForFaceting',
        'replicas' => 'getReplicas',
        'paginationLimitedTo' => 'getPaginationLimitedTo',
        'unretrievableAttributes' => 'getUnretrievableAttributes',
        'disableTypoToleranceOnWords' => 'getDisableTypoToleranceOnWords',
        'attributesToTransliterate' => 'getAttributesToTransliterate',
        'camelCaseAttributes' => 'getCamelCaseAttributes',
        'decompoundedAttributes' => 'getDecompoundedAttributes',
        'indexLanguages' => 'getIndexLanguages',
        'disablePrefixOnAttributes' => 'getDisablePrefixOnAttributes',
        'allowCompressionOfIntegerArray' => 'getAllowCompressionOfIntegerArray',
        'numericAttributesForFiltering' => 'getNumericAttributesForFiltering',
        'separatorsToIndex' => 'getSeparatorsToIndex',
        'searchableAttributes' => 'getSearchableAttributes',
        'userData' => 'getUserData',
        'customNormalization' => 'getCustomNormalization',
        'attributeForDistinct' => 'getAttributeForDistinct',
    ];

    /**
     * Associative array for storing property values.
     *
     * @var mixed[]
     */
    protected $container = [];

    /**
     * Constructor.
     *
     * @param mixed[] $data Associated array of property values
     */
    public function __construct(array $data = null)
    {
        if (isset($data['attributesForFaceting'])) {
            $this->container['attributesForFaceting'] = $data['attributesForFaceting'];
        }
        if (isset($data['replicas'])) {
            $this->container['replicas'] = $data['replicas'];
        }
        if (isset($data['paginationLimitedTo'])) {
            $this->container['paginationLimitedTo'] = $data['paginationLimitedTo'];
        }
        if (isset($data['unretrievableAttributes'])) {
            $this->container['unretrievableAttributes'] = $data['unretrievableAttributes'];
        }
        if (isset($data['disableTypoToleranceOnWords'])) {
            $this->container['disableTypoToleranceOnWords'] = $data['disableTypoToleranceOnWords'];
        }
        if (isset($data['attributesToTransliterate'])) {
            $this->container['attributesToTransliterate'] = $data['attributesToTransliterate'];
        }
        if (isset($data['camelCaseAttributes'])) {
            $this->container['camelCaseAttributes'] = $data['camelCaseAttributes'];
        }
        if (isset($data['decompoundedAttributes'])) {
            $this->container['decompoundedAttributes'] = $data['decompoundedAttributes'];
        }
        if (isset($data['indexLanguages'])) {
            $this->container['indexLanguages'] = $data['indexLanguages'];
        }
        if (isset($data['disablePrefixOnAttributes'])) {
            $this->container['disablePrefixOnAttributes'] = $data['disablePrefixOnAttributes'];
        }
        if (isset($data['allowCompressionOfIntegerArray'])) {
            $this->container['allowCompressionOfIntegerArray'] = $data['allowCompressionOfIntegerArray'];
        }
        if (isset($data['numericAttributesForFiltering'])) {
            $this->container['numericAttributesForFiltering'] = $data['numericAttributesForFiltering'];
        }
        if (isset($data['separatorsToIndex'])) {
            $this->container['separatorsToIndex'] = $data['separatorsToIndex'];
        }
        if (isset($data['searchableAttributes'])) {
            $this->container['searchableAttributes'] = $data['searchableAttributes'];
        }
        if (isset($data['userData'])) {
            $this->container['userData'] = $data['userData'];
        }
        if (isset($data['customNormalization'])) {
            $this->container['customNormalization'] = $data['customNormalization'];
        }
        if (isset($data['attributeForDistinct'])) {
            $this->container['attributeForDistinct'] = $data['attributeForDistinct'];
        }
    }

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @return array
     */
    public static function attributeMap()
    {
        return self::$attributeMap;
    }

    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @return array
     */
    public static function modelTypes()
    {
        return self::$modelTypes;
    }

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @return array
     */
    public static function modelFormats()
    {
        return self::$modelFormats;
    }

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @return array
     */
    public static function setters()
    {
        return self::$setters;
    }

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @return array
     */
    public static function getters()
    {
        return self::$getters;
    }

    /**
     * Show all the invalid properties with reasons.
     *
     * @return array invalid properties with reasons
     */
    public function listInvalidProperties()
    {
        $invalidProperties = [];

        if (isset($this->container['paginationLimitedTo']) && ($this->container['paginationLimitedTo'] > 20000)) {
            $invalidProperties[] = "invalid value for 'paginationLimitedTo', must be smaller than or equal to 20000.";
        }

        return $invalidProperties;
    }

    /**
     * Validate all the properties in the model
     * return true if all passed.
     *
     * @return bool True if all properties are valid
     */
    public function valid()
    {
        return 0 === count($this->listInvalidProperties());
    }

    /**
     * Gets attributesForFaceting.
     *
     * @return null|string[]
     */
    public function getAttributesForFaceting()
    {
        return $this->container['attributesForFaceting'] ?? null;
    }

    /**
     * Sets attributesForFaceting.
     *
     * @param null|string[] $attributesForFaceting Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/).  Facets are ways to categorize search results based on attributes. Facets can be used to let user filter search results. By default, no attribute is used for faceting.  **Modifiers**  <dl> <dt><code>filterOnly(\"ATTRIBUTE\")</code></dt> <dd>Allows using this attribute as a filter, but doesn't evalue the facet values.</dd> <dt><code>searchable(\"ATTRIBUTE\")</code></dt> <dd>Allows searching for facet values.</dd> <dt><code>afterDistinct(\"ATTRIBUTE\")</code></dt> <dd>  Evaluates the facet count _after_ deduplication with `distinct`. This ensures accurate facet counts. You can apply this modifier to searchable facets: `afterDistinct(searchable(ATTRIBUTE))`.  </dd> </dl>  Without modifiers, the attribute is used as a regular facet.
     *
     * @return self
     */
    public function setAttributesForFaceting($attributesForFaceting)
    {
        $this->container['attributesForFaceting'] = $attributesForFaceting;

        return $this;
    }

    /**
     * Gets replicas.
     *
     * @return null|string[]
     */
    public function getReplicas()
    {
        return $this->container['replicas'] ?? null;
    }

    /**
     * Sets replicas.
     *
     * @param null|string[] $replicas Creates [replica indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/).  Replicas are copies of a primary index with the same records but different settings, synonyms, or rules. If you want to offer a different ranking or sorting of your search results, you'll use replica indices. All index operations on a primary index are automatically forwarded to its replicas. To add a replica index, you must provide the complete set of replicas to this parameter. If you omit a replica from this list, the replica turns into a regular, standalone index that will no longer by synced with the primary index.  **Modifier**  <dl> <dt><code>virtual(\"REPLICA\")</code></dt> <dd>  Create a virtual replica, Virtual replicas don't increase the number of records and are optimized for [Relevant sorting](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/relevant-sort/).  </dd> </dl>  Without modifier, a standard replica is created, which duplicates your record count and is used for strict, or [exhaustive sorting](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/exhaustive-sort/).
     *
     * @return self
     */
    public function setReplicas($replicas)
    {
        $this->container['replicas'] = $replicas;

        return $this;
    }

    /**
     * Gets paginationLimitedTo.
     *
     * @return null|int
     */
    public function getPaginationLimitedTo()
    {
        return $this->container['paginationLimitedTo'] ?? null;
    }

    /**
     * Sets paginationLimitedTo.
     *
     * @param null|int $paginationLimitedTo Maximum number of search results that can be obtained through pagination.  Higher pagination limits might slow down your search. For pagination limits above 1,000, the sorting of results beyond the 1,000th hit can't be guaranteed.
     *
     * @return self
     */
    public function setPaginationLimitedTo($paginationLimitedTo)
    {
        if (!is_null($paginationLimitedTo) && ($paginationLimitedTo > 20000)) {
            throw new \InvalidArgumentException('invalid value for $paginationLimitedTo when calling BaseIndexSettings., must be smaller than or equal to 20000.');
        }

        $this->container['paginationLimitedTo'] = $paginationLimitedTo;

        return $this;
    }

    /**
     * Gets unretrievableAttributes.
     *
     * @return null|string[]
     */
    public function getUnretrievableAttributes()
    {
        return $this->container['unretrievableAttributes'] ?? null;
    }

    /**
     * Sets unretrievableAttributes.
     *
     * @param null|string[] $unretrievableAttributes Attributes that can't be retrieved at query time.  This can be useful if you want to use an attribute for ranking or to [restrict access](https://www.algolia.com/doc/guides/security/api-keys/how-to/user-restricted-access-to-data/), but don't want to include it in the search results.
     *
     * @return self
     */
    public function setUnretrievableAttributes($unretrievableAttributes)
    {
        $this->container['unretrievableAttributes'] = $unretrievableAttributes;

        return $this;
    }

    /**
     * Gets disableTypoToleranceOnWords.
     *
     * @return null|string[]
     */
    public function getDisableTypoToleranceOnWords()
    {
        return $this->container['disableTypoToleranceOnWords'] ?? null;
    }

    /**
     * Sets disableTypoToleranceOnWords.
     *
     * @param null|string[] $disableTypoToleranceOnWords Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). This also turns off [word splitting and concatenation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/splitting-and-concatenation/) for the specified words.
     *
     * @return self
     */
    public function setDisableTypoToleranceOnWords($disableTypoToleranceOnWords)
    {
        $this->container['disableTypoToleranceOnWords'] = $disableTypoToleranceOnWords;

        return $this;
    }

    /**
     * Gets attributesToTransliterate.
     *
     * @return null|string[]
     */
    public function getAttributesToTransliterate()
    {
        return $this->container['attributesToTransliterate'] ?? null;
    }

    /**
     * Sets attributesToTransliterate.
     *
     * @param null|string[] $attributesToTransliterate Attributes, for which you want to support [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead).  Transliteration supports searching in any of the Japanese writing systems. To support transliteration, you must set the indexing language to Japanese.
     *
     * @return self
     */
    public function setAttributesToTransliterate($attributesToTransliterate)
    {
        $this->container['attributesToTransliterate'] = $attributesToTransliterate;

        return $this;
    }

    /**
     * Gets camelCaseAttributes.
     *
     * @return null|string[]
     */
    public function getCamelCaseAttributes()
    {
        return $this->container['camelCaseAttributes'] ?? null;
    }

    /**
     * Sets camelCaseAttributes.
     *
     * @param null|string[] $camelCaseAttributes Attributes for which to split [camel case](https://wikipedia.org/wiki/Camel_case) words.
     *
     * @return self
     */
    public function setCamelCaseAttributes($camelCaseAttributes)
    {
        $this->container['camelCaseAttributes'] = $camelCaseAttributes;

        return $this;
    }

    /**
     * Gets decompoundedAttributes.
     *
     * @return null|object
     */
    public function getDecompoundedAttributes()
    {
        return $this->container['decompoundedAttributes'] ?? null;
    }

    /**
     * Sets decompoundedAttributes.
     *
     * @param null|object $decompoundedAttributes Searchable attributes to which Algolia should apply [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding).  Compound words are formed by combining two or more individual words, and are particularly prevalent in Germanic languages—for example, \"firefighter\". With decompounding, the individual components are indexed separately.  You can specify different lists for different languages. Decompounding is supported for these languages: Dutch (`nl`), German (`de`), Finnish (`fi`), Danish (`da`), Swedish (`sv`), and Norwegian (`no`).
     *
     * @return self
     */
    public function setDecompoundedAttributes($decompoundedAttributes)
    {
        $this->container['decompoundedAttributes'] = $decompoundedAttributes;

        return $this;
    }

    /**
     * Gets indexLanguages.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Search\SupportedLanguage[]
     */
    public function getIndexLanguages()
    {
        return $this->container['indexLanguages'] ?? null;
    }

    /**
     * Sets indexLanguages.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Search\SupportedLanguage[] $indexLanguages Languages for language-specific processing steps, such as word detection and dictionary settings.  **You should always specify an indexing language.** If you don't specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
     *
     * @return self
     */
    public function setIndexLanguages($indexLanguages)
    {
        $this->container['indexLanguages'] = $indexLanguages;

        return $this;
    }

    /**
     * Gets disablePrefixOnAttributes.
     *
     * @return null|string[]
     */
    public function getDisablePrefixOnAttributes()
    {
        return $this->container['disablePrefixOnAttributes'] ?? null;
    }

    /**
     * Sets disablePrefixOnAttributes.
     *
     * @param null|string[] $disablePrefixOnAttributes Searchable attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).
     *
     * @return self
     */
    public function setDisablePrefixOnAttributes($disablePrefixOnAttributes)
    {
        $this->container['disablePrefixOnAttributes'] = $disablePrefixOnAttributes;

        return $this;
    }

    /**
     * Gets allowCompressionOfIntegerArray.
     *
     * @return null|bool
     */
    public function getAllowCompressionOfIntegerArray()
    {
        return $this->container['allowCompressionOfIntegerArray'] ?? null;
    }

    /**
     * Sets allowCompressionOfIntegerArray.
     *
     * @param null|bool $allowCompressionOfIntegerArray Whether arrays with exclusively non-negative integers should be compressed for better performance. If true, the compressed arrays may be reordered.
     *
     * @return self
     */
    public function setAllowCompressionOfIntegerArray($allowCompressionOfIntegerArray)
    {
        $this->container['allowCompressionOfIntegerArray'] = $allowCompressionOfIntegerArray;

        return $this;
    }

    /**
     * Gets numericAttributesForFiltering.
     *
     * @return null|string[]
     */
    public function getNumericAttributesForFiltering()
    {
        return $this->container['numericAttributesForFiltering'] ?? null;
    }

    /**
     * Sets numericAttributesForFiltering.
     *
     * @param null|string[] $numericAttributesForFiltering Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).  By default, all numeric attributes are available as numerical filters. For faster indexing, reduce the number of numeric attributes.  If you want to turn off filtering for all numeric attributes, specifiy an attribute that doesn't exist in your index, such as `NO_NUMERIC_FILTERING`.  **Modifier**  <dl> <dt><code>equalOnly(\"ATTRIBUTE\")</code></dt> <dd>  Support only filtering based on equality comparisons `=` and `!=`.  </dd> </dl>  Without modifier, all numeric comparisons are supported.
     *
     * @return self
     */
    public function setNumericAttributesForFiltering($numericAttributesForFiltering)
    {
        $this->container['numericAttributesForFiltering'] = $numericAttributesForFiltering;

        return $this;
    }

    /**
     * Gets separatorsToIndex.
     *
     * @return null|string
     */
    public function getSeparatorsToIndex()
    {
        return $this->container['separatorsToIndex'] ?? null;
    }

    /**
     * Sets separatorsToIndex.
     *
     * @param null|string $separatorsToIndex Controls which separators are indexed.  Separators are all non-letter characters except spaces and currency characters, such as $€£¥. By default, separator characters aren't indexed. With `separatorsToIndex`, Algolia treats separator characters as separate words. For example, a search for `C#` would report two matches.
     *
     * @return self
     */
    public function setSeparatorsToIndex($separatorsToIndex)
    {
        $this->container['separatorsToIndex'] = $separatorsToIndex;

        return $this;
    }

    /**
     * Gets searchableAttributes.
     *
     * @return null|string[]
     */
    public function getSearchableAttributes()
    {
        return $this->container['searchableAttributes'] ?? null;
    }

    /**
     * Sets searchableAttributes.
     *
     * @param null|string[] $searchableAttributes Attributes used for searching.  By default, all attributes are searchable and the [Attribute](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute) ranking criterion is turned off. With a non-empty list, Algolia only returns results with matches in the selected attributes. In addition, the Attribute ranking criterion is turned on: matches in attributes that are higher in the list of `searchableAttributes` rank first. To make matches in two attributes rank equally, include them in a comma-separated string, such as `\"title,alternate_title\"`. Attributes with the same priority are always unordered.  For more information, see [Searchable attributes](https://www.algolia.com/doc/guides/sending-and-managing-data/prepare-your-data/how-to/setting-searchable-attributes/).  **Modifier**  <dl> <dt><code>unordered(\"ATTRIBUTE\")</code></dt> <dd> Ignore the position of a match within the attribute. </dd> </dl>  Without modifier, matches at the beginning of an attribute rank higer than matches at the end.
     *
     * @return self
     */
    public function setSearchableAttributes($searchableAttributes)
    {
        $this->container['searchableAttributes'] = $searchableAttributes;

        return $this;
    }

    /**
     * Gets userData.
     *
     * @return null|mixed
     */
    public function getUserData()
    {
        return $this->container['userData'] ?? null;
    }

    /**
     * Sets userData.
     *
     * @param null|mixed $userData An object with custom data.  You can store up to 32&nbsp;kB as custom data.
     *
     * @return self
     */
    public function setUserData($userData)
    {
        $this->container['userData'] = $userData;

        return $this;
    }

    /**
     * Gets customNormalization.
     *
     * @return null|array<string,array<string,string>>
     */
    public function getCustomNormalization()
    {
        return $this->container['customNormalization'] ?? null;
    }

    /**
     * Sets customNormalization.
     *
     * @param null|array<string,array<string,string>> $customNormalization Characters and their normalized replacements. This overrides Algolia's default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
     *
     * @return self
     */
    public function setCustomNormalization($customNormalization)
    {
        $this->container['customNormalization'] = $customNormalization;

        return $this;
    }

    /**
     * Gets attributeForDistinct.
     *
     * @return null|string
     */
    public function getAttributeForDistinct()
    {
        return $this->container['attributeForDistinct'] ?? null;
    }

    /**
     * Sets attributeForDistinct.
     *
     * @param null|string $attributeForDistinct Attribute that should be used to establish groups of results.  All records with the same value for this attribute are considered a group. You can combine `attributeForDistinct` with the `distinct` search parameter to control how many items per group are included in the search results.  If you want to use the same attribute also for faceting, use the `afterDistinct` modifier of the `attributesForFaceting` setting. This applies faceting _after_ deduplication, which will result in accurate facet counts.
     *
     * @return self
     */
    public function setAttributeForDistinct($attributeForDistinct)
    {
        $this->container['attributeForDistinct'] = $attributeForDistinct;

        return $this;
    }

    /**
     * Returns true if offset exists. False otherwise.
     *
     * @param int $offset Offset
     *
     * @return bool
     */
    public function offsetExists($offset)
    {
        return isset($this->container[$offset]);
    }

    /**
     * Gets offset.
     *
     * @param int $offset Offset
     *
     * @return null|mixed
     */
    public function offsetGet($offset)
    {
        return $this->container[$offset] ?? null;
    }

    /**
     * Sets value based on offset.
     *
     * @param null|int $offset Offset
     * @param mixed    $value  Value to be set
     */
    public function offsetSet($offset, $value)
    {
        if (is_null($offset)) {
            $this->container[] = $value;
        } else {
            $this->container[$offset] = $value;
        }
    }

    /**
     * Unsets offset.
     *
     * @param int $offset Offset
     */
    public function offsetUnset($offset)
    {
        unset($this->container[$offset]);
    }
}
