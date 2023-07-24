<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\QuerySuggestions;

/**
 * QuerySuggestionsConfigurationResponseAllOf Class Doc Comment
 *
 * @category Class
 * @package Algolia\AlgoliaSearch
 */
class QuerySuggestionsConfigurationResponseAllOf extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
      * Array of property to type mappings. Used for (de)serialization
      *
      * @var string[]
      */
    protected static $modelTypes = [
        'appId' => 'string',
        'sourceIndicesAPIKey' => 'string',
        'suggestionsIndicesAPIKey' => 'string',
        'externalIndicesAPIKey' => 'string',
    ];

    /**
      * Array of property to format mappings. Used for (de)serialization
      *
      * @var string[]
      */
    protected static $modelFormats = [
        'appId' => null,
        'sourceIndicesAPIKey' => null,
        'suggestionsIndicesAPIKey' => null,
        'externalIndicesAPIKey' => null,
    ];

    /**
      * Array of attributes where the key is the local name,
      * and the value is the original name
      *
      * @var string[]
    */
    protected static $attributeMap = [
        'appId' => 'appId',
        'sourceIndicesAPIKey' => 'sourceIndicesAPIKey',
        'suggestionsIndicesAPIKey' => 'suggestionsIndicesAPIKey',
        'externalIndicesAPIKey' => 'externalIndicesAPIKey',
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
     * Array of property to type mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function modelTypes()
    {
        return self::$modelTypes;
    }

    /**
     * Array of property to format mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function modelFormats()
    {
        return self::$modelFormats;
    }

    /**
     * Array of attributes to setter functions (for deserialization of responses)
     *
     * @var string[]
     */
    protected static $setters = [
        'appId' => 'setAppId',
        'sourceIndicesAPIKey' => 'setSourceIndicesAPIKey',
        'suggestionsIndicesAPIKey' => 'setSuggestionsIndicesAPIKey',
        'externalIndicesAPIKey' => 'setExternalIndicesAPIKey',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests)
     *
     * @var string[]
     */
    protected static $getters = [
        'appId' => 'getAppId',
        'sourceIndicesAPIKey' => 'getSourceIndicesAPIKey',
        'suggestionsIndicesAPIKey' => 'getSuggestionsIndicesAPIKey',
        'externalIndicesAPIKey' => 'getExternalIndicesAPIKey',
    ];

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
     * Associative array for storing property values
     *
     * @var mixed[]
     */
    protected $container = [];

    /**
     * Constructor
     *
     * @param mixed[] $data Associated array of property values
     */
    public function __construct(array $data = null)
    {
        if (isset($data['appId'])) {
            $this->container['appId'] = $data['appId'];
        }
        if (isset($data['sourceIndicesAPIKey'])) {
            $this->container['sourceIndicesAPIKey'] = $data['sourceIndicesAPIKey'];
        }
        if (isset($data['suggestionsIndicesAPIKey'])) {
            $this->container['suggestionsIndicesAPIKey'] = $data['suggestionsIndicesAPIKey'];
        }
        if (isset($data['externalIndicesAPIKey'])) {
            $this->container['externalIndicesAPIKey'] = $data['externalIndicesAPIKey'];
        }
    }

    /**
     * Show all the invalid properties with reasons.
     *
     * @return array invalid properties with reasons
     */
    public function listInvalidProperties()
    {
        $invalidProperties = [];

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
     * Gets appId
     *
     * @return string|null
     */
    public function getAppId()
    {
        return $this->container['appId'] ?? null;
    }

    /**
     * Sets appId
     *
     * @param string|null $appId your Algolia application ID
     *
     * @return self
     */
    public function setAppId($appId)
    {
        $this->container['appId'] = $appId;

        return $this;
    }

    /**
     * Gets sourceIndicesAPIKey
     *
     * @return string|null
     */
    public function getSourceIndicesAPIKey()
    {
        return $this->container['sourceIndicesAPIKey'] ?? null;
    }

    /**
     * Sets sourceIndicesAPIKey
     *
     * @param string|null $sourceIndicesAPIKey API key used to read from your source index
     *
     * @return self
     */
    public function setSourceIndicesAPIKey($sourceIndicesAPIKey)
    {
        $this->container['sourceIndicesAPIKey'] = $sourceIndicesAPIKey;

        return $this;
    }

    /**
     * Gets suggestionsIndicesAPIKey
     *
     * @return string|null
     */
    public function getSuggestionsIndicesAPIKey()
    {
        return $this->container['suggestionsIndicesAPIKey'] ?? null;
    }

    /**
     * Sets suggestionsIndicesAPIKey
     *
     * @param string|null $suggestionsIndicesAPIKey API key used to write and configure your Query Suggestions index
     *
     * @return self
     */
    public function setSuggestionsIndicesAPIKey($suggestionsIndicesAPIKey)
    {
        $this->container['suggestionsIndicesAPIKey'] = $suggestionsIndicesAPIKey;

        return $this;
    }

    /**
     * Gets externalIndicesAPIKey
     *
     * @return string|null
     */
    public function getExternalIndicesAPIKey()
    {
        return $this->container['externalIndicesAPIKey'] ?? null;
    }

    /**
     * Sets externalIndicesAPIKey
     *
     * @param string|null $externalIndicesAPIKey API key used to read from external Algolia indices
     *
     * @return self
     */
    public function setExternalIndicesAPIKey($externalIndicesAPIKey)
    {
        $this->container['externalIndicesAPIKey'] = $externalIndicesAPIKey;

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
}

