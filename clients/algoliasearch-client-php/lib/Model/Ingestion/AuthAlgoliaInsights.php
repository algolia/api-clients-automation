<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * AuthAlgoliaInsights Class Doc Comment.
 *
 * @category Class
 *
 * @description Credentials for authenticating with the Algolia Insights API.
 */
class AuthAlgoliaInsights extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'appID' => 'string',
        'apiKey' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'appID' => null,
        'apiKey' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'appID' => 'appID',
        'apiKey' => 'apiKey',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'appID' => 'setAppID',
        'apiKey' => 'setApiKey',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'appID' => 'getAppID',
        'apiKey' => 'getApiKey',
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
        if (isset($data['appID'])) {
            $this->container['appID'] = $data['appID'];
        }
        if (isset($data['apiKey'])) {
            $this->container['apiKey'] = $data['apiKey'];
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

        if (!isset($this->container['appID']) || null === $this->container['appID']) {
            $invalidProperties[] = "'appID' can't be null";
        }
        if (!isset($this->container['apiKey']) || null === $this->container['apiKey']) {
            $invalidProperties[] = "'apiKey' can't be null";
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
     * Gets appID.
     *
     * @return string
     */
    public function getAppID()
    {
        return $this->container['appID'] ?? null;
    }

    /**
     * Sets appID.
     *
     * @param string $appID algolia application ID
     *
     * @return self
     */
    public function setAppID($appID)
    {
        $this->container['appID'] = $appID;

        return $this;
    }

    /**
     * Gets apiKey.
     *
     * @return string
     */
    public function getApiKey()
    {
        return $this->container['apiKey'] ?? null;
    }

    /**
     * Sets apiKey.
     *
     * @param string $apiKey Algolia API key with the ACL: `search`. This field is `null` in the API response.
     *
     * @return self
     */
    public function setApiKey($apiKey)
    {
        $this->container['apiKey'] = $apiKey;

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
