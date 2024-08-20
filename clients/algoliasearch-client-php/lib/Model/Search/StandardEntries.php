<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * StandardEntries Class Doc Comment.
 *
 * @category Class
 *
 * @description Key-value pairs of [supported language ISO codes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/) and boolean values.
 */
class StandardEntries extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'plurals' => 'array<string,bool>',
        'stopwords' => 'array<string,bool>',
        'compounds' => 'array<string,bool>',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'plurals' => null,
        'stopwords' => null,
        'compounds' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'plurals' => 'plurals',
        'stopwords' => 'stopwords',
        'compounds' => 'compounds',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'plurals' => 'setPlurals',
        'stopwords' => 'setStopwords',
        'compounds' => 'setCompounds',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'plurals' => 'getPlurals',
        'stopwords' => 'getStopwords',
        'compounds' => 'getCompounds',
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
    public function __construct(?array $data = null)
    {
        if (isset($data['plurals'])) {
            $this->container['plurals'] = $data['plurals'];
        }
        if (isset($data['stopwords'])) {
            $this->container['stopwords'] = $data['stopwords'];
        }
        if (isset($data['compounds'])) {
            $this->container['compounds'] = $data['compounds'];
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
     * Gets plurals.
     *
     * @return null|array<string,bool>
     */
    public function getPlurals()
    {
        return $this->container['plurals'] ?? null;
    }

    /**
     * Sets plurals.
     *
     * @param null|array<string,bool> $plurals key-value pair of a language ISO code and a boolean value
     *
     * @return self
     */
    public function setPlurals($plurals)
    {
        $this->container['plurals'] = $plurals;

        return $this;
    }

    /**
     * Gets stopwords.
     *
     * @return null|array<string,bool>
     */
    public function getStopwords()
    {
        return $this->container['stopwords'] ?? null;
    }

    /**
     * Sets stopwords.
     *
     * @param null|array<string,bool> $stopwords key-value pair of a language ISO code and a boolean value
     *
     * @return self
     */
    public function setStopwords($stopwords)
    {
        $this->container['stopwords'] = $stopwords;

        return $this;
    }

    /**
     * Gets compounds.
     *
     * @return null|array<string,bool>
     */
    public function getCompounds()
    {
        return $this->container['compounds'] ?? null;
    }

    /**
     * Sets compounds.
     *
     * @param null|array<string,bool> $compounds key-value pair of a language ISO code and a boolean value
     *
     * @return self
     */
    public function setCompounds($compounds)
    {
        $this->container['compounds'] = $compounds;

        return $this;
    }

    /**
     * Returns true if offset exists. False otherwise.
     *
     * @param int $offset Offset
     *
     * @return bool
     */
    public function offsetExists($offset): bool
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
    public function offsetGet($offset): mixed
    {
        return $this->container[$offset] ?? null;
    }

    /**
     * Sets value based on offset.
     *
     * @param null|int $offset Offset
     * @param mixed    $value  Value to be set
     */
    public function offsetSet($offset, $value): void
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
    public function offsetUnset($offset): void
    {
        unset($this->container[$offset]);
    }
}
