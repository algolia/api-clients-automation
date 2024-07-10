<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Abtesting;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * ListABTestsResponse Class Doc Comment.
 *
 * @category Class
 */
class ListABTestsResponse extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'abtests' => '\Algolia\AlgoliaSearch\Model\Abtesting\ABTest[]',
        'count' => 'int',
        'total' => 'int',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'abtests' => null,
        'count' => null,
        'total' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'abtests' => 'abtests',
        'count' => 'count',
        'total' => 'total',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'abtests' => 'setAbtests',
        'count' => 'setCount',
        'total' => 'setTotal',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'abtests' => 'getAbtests',
        'count' => 'getCount',
        'total' => 'getTotal',
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
        if (isset($data['abtests'])) {
            $this->container['abtests'] = $data['abtests'];
        }
        if (isset($data['count'])) {
            $this->container['count'] = $data['count'];
        }
        if (isset($data['total'])) {
            $this->container['total'] = $data['total'];
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

        if (!isset($this->container['abtests']) || null === $this->container['abtests']) {
            $invalidProperties[] = "'abtests' can't be null";
        }
        if (!isset($this->container['count']) || null === $this->container['count']) {
            $invalidProperties[] = "'count' can't be null";
        }
        if (!isset($this->container['total']) || null === $this->container['total']) {
            $invalidProperties[] = "'total' can't be null";
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
     * Gets abtests.
     *
     * @return \Algolia\AlgoliaSearch\Model\Abtesting\ABTest[]
     */
    public function getAbtests()
    {
        return $this->container['abtests'] ?? null;
    }

    /**
     * Sets abtests.
     *
     * @param \Algolia\AlgoliaSearch\Model\Abtesting\ABTest[] $abtests A/B tests
     *
     * @return self
     */
    public function setAbtests($abtests)
    {
        $this->container['abtests'] = $abtests;

        return $this;
    }

    /**
     * Gets count.
     *
     * @return int
     */
    public function getCount()
    {
        return $this->container['count'] ?? null;
    }

    /**
     * Sets count.
     *
     * @param int $count number of A/B tests
     *
     * @return self
     */
    public function setCount($count)
    {
        $this->container['count'] = $count;

        return $this;
    }

    /**
     * Gets total.
     *
     * @return int
     */
    public function getTotal()
    {
        return $this->container['total'] ?? null;
    }

    /**
     * Sets total.
     *
     * @param int $total number of retrievable A/B tests
     *
     * @return self
     */
    public function setTotal($total)
    {
        $this->container['total'] = $total;

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
