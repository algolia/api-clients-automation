<?php

namespace Algolia\AlgoliaSearch\Model\Search;

use \Algolia\AlgoliaSearch\ObjectSerializer;
use \ArrayAccess;

/**
 * Languages Class Doc Comment
 *
 * @category Class
 * @description A dictionary language.
 *
 * @package  Algolia\AlgoliaSearch
 * @implements \ArrayAccess<TKey, TValue>
 * @template TKey int|null
 * @template TValue mixed|null
 */
class Languages implements ModelInterface, ArrayAccess, \JsonSerializable
{
    public const DISCRIMINATOR = null;

    /**
      * The original name of the model.
      *
      * @var string
      */
    protected static $openAPIModelName = 'languages';

    /**
      * Array of property to type mappings. Used for (de)serialization
      *
      * @var string[]
      */
    protected static $openAPITypes = [
        'plurals' => '\Algolia\AlgoliaSearch\Model\Search\DictionaryLanguage',
        'stopwords' => '\Algolia\AlgoliaSearch\Model\Search\DictionaryLanguage',
        'compounds' => '\Algolia\AlgoliaSearch\Model\Search\DictionaryLanguage',
    ];

    /**
      * Array of property to format mappings. Used for (de)serialization
      *
      * @var string[]
      * @phpstan-var array<string, string|null>
      * @psalm-var array<string, string|null>
      */
    protected static $openAPIFormats = [
        'plurals' => null,
        'stopwords' => null,
        'compounds' => null,
    ];

    /**
     * Array of property to type mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function openAPITypes()
    {
        return self::$openAPITypes;
    }

    /**
     * Array of property to format mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function openAPIFormats()
    {
        return self::$openAPIFormats;
    }

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'plurals' => 'plurals',
        'stopwords' => 'stopwords',
        'compounds' => 'compounds',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses)
     *
     * @var string[]
     */
    protected static $setters = [
        'plurals' => 'setPlurals',
        'stopwords' => 'setStopwords',
        'compounds' => 'setCompounds',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests)
     *
     * @var string[]
     */
    protected static $getters = [
        'plurals' => 'getPlurals',
        'stopwords' => 'getStopwords',
        'compounds' => 'getCompounds',
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name
     *
     * @return array
     */
    public static function attributeMap()
    {
        return self::$attributeMap;
    }

    /**
     * Array of attributes to setter functions (for deserialization of responses)
     *
     * @return array
     */
    public static function setters()
    {
        return self::$setters;
    }

    /**
     * Array of attributes to getter functions (for serialization of requests)
     *
     * @return array
     */
    public static function getters()
    {
        return self::$getters;
    }

    /**
     * The original name of the model.
     *
     * @return string
     */
    public function getModelName()
    {
        return self::$openAPIModelName;
    }

    /**
     * Associative array for storing property values
     *
     * @var mixed[]
     */
    protected $container = [];

    /**
     * Constructor
     *
     * @param mixed[] $data Associated array of property values
     *                      initializing the model
     */
    public function __construct(array $data = null)
    {
        $this->container['plurals'] = $data['plurals'] ?? null;
        $this->container['stopwords'] = $data['stopwords'] ?? null;
        $this->container['compounds'] = $data['compounds'] ?? null;
    }

    /**
     * Show all the invalid properties with reasons.
     *
     * @return array invalid properties with reasons
     */
    public function listInvalidProperties()
    {
        $invalidProperties = [];

        if ($this->container['plurals'] === null) {
            $invalidProperties[] = "'plurals' can't be null";
        }
        if ($this->container['stopwords'] === null) {
            $invalidProperties[] = "'stopwords' can't be null";
        }
        if ($this->container['compounds'] === null) {
            $invalidProperties[] = "'compounds' can't be null";
        }

        return $invalidProperties;
    }

    /**
     * Validate all the properties in the model
     * return true if all passed
     *
     * @return bool True if all properties are valid
     */
    public function valid()
    {
        return count($this->listInvalidProperties()) === 0;
    }

    /**
     * Gets plurals
     *
     * @return \Algolia\AlgoliaSearch\Model\Search\DictionaryLanguage
     */
    public function getPlurals()
    {
        return $this->container['plurals'];
    }

    /**
     * Sets plurals
     *
     * @param \Algolia\AlgoliaSearch\Model\Search\DictionaryLanguage $plurals plurals
     *
     * @return self
     */
    public function setPlurals($plurals)
    {
        $this->container['plurals'] = $plurals;

        return $this;
    }

    /**
     * Gets stopwords
     *
     * @return \Algolia\AlgoliaSearch\Model\Search\DictionaryLanguage
     */
    public function getStopwords()
    {
        return $this->container['stopwords'];
    }

    /**
     * Sets stopwords
     *
     * @param \Algolia\AlgoliaSearch\Model\Search\DictionaryLanguage $stopwords stopwords
     *
     * @return self
     */
    public function setStopwords($stopwords)
    {
        $this->container['stopwords'] = $stopwords;

        return $this;
    }

    /**
     * Gets compounds
     *
     * @return \Algolia\AlgoliaSearch\Model\Search\DictionaryLanguage
     */
    public function getCompounds()
    {
        return $this->container['compounds'];
    }

    /**
     * Sets compounds
     *
     * @param \Algolia\AlgoliaSearch\Model\Search\DictionaryLanguage $compounds compounds
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
    public function offsetExists($offset)
    {
        return isset($this->container[$offset]);
    }

    /**
     * Gets offset.
     *
     * @param int $offset Offset
     *
     * @return mixed|null
     */
    public function offsetGet($offset)
    {
        return $this->container[$offset] ?? null;
    }

    /**
     * Sets value based on offset.
     *
     * @param int|null $offset Offset
     * @param mixed    $value  Value to be set
     *
     * @return void
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
     *
     * @return void
     */
    public function offsetUnset($offset)
    {
        unset($this->container[$offset]);
    }

    /**
     * Serializes the object to a value that can be serialized natively by json_encode().
     *
     * @link https://www.php.net/manual/en/jsonserializable.jsonserialize.php
     *
     * @return mixed returns data which can be serialized by json_encode(), which is a value
     * of any type other than a resource
     */
    public function jsonSerialize()
    {
        return ObjectSerializer::sanitizeForSerialization($this);
    }

    /**
     * Gets the string presentation of the object
     *
     * @return string
     */
    public function __toString()
    {
        return json_encode(
            ObjectSerializer::sanitizeForSerialization($this),
            JSON_PRETTY_PRINT
        );
    }

    /**
     * Gets a header-safe presentation of the object
     *
     * @return string
     */
    public function toHeaderValue()
    {
        return json_encode(ObjectSerializer::sanitizeForSerialization($this));
    }
}

