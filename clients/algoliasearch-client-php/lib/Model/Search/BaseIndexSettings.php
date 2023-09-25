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
        'replicas' => 'string[]',
        'paginationLimitedTo' => 'int',
        'unretrievableAttributes' => 'string[]',
        'disableTypoToleranceOnWords' => 'string[]',
        'attributesToTransliterate' => 'string[]',
        'camelCaseAttributes' => 'string[]',
        'decompoundedAttributes' => 'object',
        'indexLanguages' => 'string[]',
        'disablePrefixOnAttributes' => 'string[]',
        'allowCompressionOfIntegerArray' => 'bool',
        'numericAttributesForFiltering' => 'string[]',
        'separatorsToIndex' => 'string',
        'searchableAttributes' => 'string[]',
        'userData' => 'mixed',
        'customNormalization' => 'array<string,array<string,string>>',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
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
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
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
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
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
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
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
        return [];
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
     * @param null|string[] $replicas Creates [replicas](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/), which are copies of a primary index with the same records but different settings.
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
     * @param null|int $paginationLimitedTo maximum number of hits accessible through pagination
     *
     * @return self
     */
    public function setPaginationLimitedTo($paginationLimitedTo)
    {
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
     * @param null|string[] $unretrievableAttributes attributes that can't be retrieved at query time
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
     * @param null|string[] $disableTypoToleranceOnWords Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).
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
     * @param null|string[] $attributesToTransliterate Attributes in your index to which [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead) applies. This will ensure that words indexed in Katakana or Kanji can also be searched in Hiragana.
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
     * @param null|string[] $camelCaseAttributes Attributes on which to split [camel case](https://wikipedia.org/wiki/Camel_case) words.
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
     * @param null|object $decompoundedAttributes Attributes in your index to which [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding) applies.
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
     * @return null|string[]
     */
    public function getIndexLanguages()
    {
        return $this->container['indexLanguages'] ?? null;
    }

    /**
     * Sets indexLanguages.
     *
     * @param null|string[] $indexLanguages Set the languages of your index, for language-specific processing steps such as [tokenization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/tokenization/) and [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
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
     * @param null|string[] $disablePrefixOnAttributes Attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).
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
     * @param null|bool $allowCompressionOfIntegerArray Incidates whether the engine compresses arrays with exclusively non-negative integers. When enabled, the compressed arrays may be reordered.
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
     * @param null|string[] $numericAttributesForFiltering Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).
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
     * @param null|string $separatorsToIndex Controls which separators are added to an Algolia index as part of [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean). Separators are all non-letter characters except spaces and currency characters, such as $€£¥.
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
     * @param null|string[] $searchableAttributes [Attributes used for searching](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/), including determining [if matches at the beginning of a word are important (ordered) or not (unordered)](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/how-to/configuring-searchable-attributes-the-right-way/#understanding-word-position).
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
     * @param null|mixed $userData lets you store custom data in your indices
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
     * @param null|array<string,array<string,string>> $customNormalization A list of characters and their normalized replacements to override Algolia's default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
     *
     * @return self
     */
    public function setCustomNormalization($customNormalization)
    {
        $this->container['customNormalization'] = $customNormalization;

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
