<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * SecuredAPIKeyRestrictions Class Doc Comment.
 *
 * @category Class
 */
class SecuredAPIKeyRestrictions extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'searchParams' => '\Algolia\AlgoliaSearch\Model\Search\SearchParamsObject',
        'filters' => 'string',
        'validUntil' => 'int',
        'restrictIndices' => 'string[]',
        'restrictSources' => 'string',
        'userToken' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'searchParams' => null,
        'filters' => null,
        'validUntil' => 'int64',
        'restrictIndices' => null,
        'restrictSources' => null,
        'userToken' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'searchParams' => 'searchParams',
        'filters' => 'filters',
        'validUntil' => 'validUntil',
        'restrictIndices' => 'restrictIndices',
        'restrictSources' => 'restrictSources',
        'userToken' => 'userToken',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'searchParams' => 'setSearchParams',
        'filters' => 'setFilters',
        'validUntil' => 'setValidUntil',
        'restrictIndices' => 'setRestrictIndices',
        'restrictSources' => 'setRestrictSources',
        'userToken' => 'setUserToken',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'searchParams' => 'getSearchParams',
        'filters' => 'getFilters',
        'validUntil' => 'getValidUntil',
        'restrictIndices' => 'getRestrictIndices',
        'restrictSources' => 'getRestrictSources',
        'userToken' => 'getUserToken',
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
        if (isset($data['searchParams'])) {
            $this->container['searchParams'] = $data['searchParams'];
        }
        if (isset($data['filters'])) {
            $this->container['filters'] = $data['filters'];
        }
        if (isset($data['validUntil'])) {
            $this->container['validUntil'] = $data['validUntil'];
        }
        if (isset($data['restrictIndices'])) {
            $this->container['restrictIndices'] = $data['restrictIndices'];
        }
        if (isset($data['restrictSources'])) {
            $this->container['restrictSources'] = $data['restrictSources'];
        }
        if (isset($data['userToken'])) {
            $this->container['userToken'] = $data['userToken'];
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
     * Gets searchParams.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Search\SearchParamsObject
     */
    public function getSearchParams()
    {
        return $this->container['searchParams'] ?? null;
    }

    /**
     * Sets searchParams.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Search\SearchParamsObject $searchParams searchParams
     *
     * @return self
     */
    public function setSearchParams($searchParams)
    {
        $this->container['searchParams'] = $searchParams;

        return $this;
    }

    /**
     * Gets filters.
     *
     * @return null|string
     */
    public function getFilters()
    {
        return $this->container['filters'] ?? null;
    }

    /**
     * Sets filters.
     *
     * @param null|string $filters Filters that apply to every search made with the secured API key. Extra filters added at search time will be combined with `AND`. For example, if you set `group:admin` as fixed filter on your generated API key, and add `groups:visitors` to the search query, the complete set of filters will be `group:admin AND groups:visitors`.
     *
     * @return self
     */
    public function setFilters($filters)
    {
        $this->container['filters'] = $filters;

        return $this;
    }

    /**
     * Gets validUntil.
     *
     * @return null|int
     */
    public function getValidUntil()
    {
        return $this->container['validUntil'] ?? null;
    }

    /**
     * Sets validUntil.
     *
     * @param null|int $validUntil Timestamp in [Unix epoch time](https://en.wikipedia.org/wiki/Unix_time) when the API key should expire.
     *
     * @return self
     */
    public function setValidUntil($validUntil)
    {
        $this->container['validUntil'] = $validUntil;

        return $this;
    }

    /**
     * Gets restrictIndices.
     *
     * @return null|string[]
     */
    public function getRestrictIndices()
    {
        return $this->container['restrictIndices'] ?? null;
    }

    /**
     * Sets restrictIndices.
     *
     * @param null|string[] $restrictIndices Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\".
     *
     * @return self
     */
    public function setRestrictIndices($restrictIndices)
    {
        $this->container['restrictIndices'] = $restrictIndices;

        return $this;
    }

    /**
     * Gets restrictSources.
     *
     * @return null|string
     */
    public function getRestrictSources()
    {
        return $this->container['restrictSources'] ?? null;
    }

    /**
     * Sets restrictSources.
     *
     * @param null|string $restrictSources IP network that are allowed to use this key.  You can only add a single source, but you can provide a range of IP addresses. Use this to protect against API key leaking and reuse.
     *
     * @return self
     */
    public function setRestrictSources($restrictSources)
    {
        $this->container['restrictSources'] = $restrictSources;

        return $this;
    }

    /**
     * Gets userToken.
     *
     * @return null|string
     */
    public function getUserToken()
    {
        return $this->container['userToken'] ?? null;
    }

    /**
     * Sets userToken.
     *
     * @param null|string $userToken Pseudonymous user identifier to restrict usage of this API key to specific users.  By default, rate limits are set based on IP addresses. This can be an issue if many users search from the same IP address. To avoid this, add a user token to each generated API key.
     *
     * @return self
     */
    public function setUserToken($userToken)
    {
        $this->container['userToken'] = $userToken;

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
