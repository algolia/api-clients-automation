<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Analytics;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * ClickPosition Class Doc Comment.
 *
 * @category Class
 *
 * @description Click position.
 */
class ClickPosition extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'position' => 'int[]',
        'clickCount' => 'int',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'position' => null,
        'clickCount' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'position' => 'position',
        'clickCount' => 'clickCount',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'position' => 'setPosition',
        'clickCount' => 'setClickCount',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'position' => 'getPosition',
        'clickCount' => 'getClickCount',
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
        if (isset($data['position'])) {
            $this->container['position'] = $data['position'];
        }
        if (isset($data['clickCount'])) {
            $this->container['clickCount'] = $data['clickCount'];
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

        if (isset($this->container['position']) && (count($this->container['position']) > 2)) {
            $invalidProperties[] = "invalid value for 'position', number of items must be less than or equal to 2.";
        }

        if (isset($this->container['position']) && (count($this->container['position']) < 2)) {
            $invalidProperties[] = "invalid value for 'position', number of items must be greater than or equal to 2.";
        }

        if (isset($this->container['clickCount']) && ($this->container['clickCount'] < 0)) {
            $invalidProperties[] = "invalid value for 'clickCount', must be bigger than or equal to 0.";
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
     * Gets position.
     *
     * @return null|int[]
     */
    public function getPosition()
    {
        return $this->container['position'] ?? null;
    }

    /**
     * Sets position.
     *
     * @param null|int[] $position Range of positions in the search results, using the pattern `[start,end]`.  For positions 11 and up, click events are summed over the specified range. `-1` indicates the end of the list of search results.
     *
     * @return self
     */
    public function setPosition($position)
    {
        if (!is_null($position) && (count($position) > 2)) {
            throw new \InvalidArgumentException('invalid value for $position when calling ClickPosition., number of items must be less than or equal to 2.');
        }
        if (!is_null($position) && (count($position) < 2)) {
            throw new \InvalidArgumentException('invalid length for $position when calling ClickPosition., number of items must be greater than or equal to 2.');
        }
        $this->container['position'] = $position;

        return $this;
    }

    /**
     * Gets clickCount.
     *
     * @return null|int
     */
    public function getClickCount()
    {
        return $this->container['clickCount'] ?? null;
    }

    /**
     * Sets clickCount.
     *
     * @param null|int $clickCount number of times this search has been clicked at that position
     *
     * @return self
     */
    public function setClickCount($clickCount)
    {
        if (!is_null($clickCount) && ($clickCount < 0)) {
            throw new \InvalidArgumentException('invalid value for $clickCount when calling ClickPosition., must be bigger than or equal to 0.');
        }

        $this->container['clickCount'] = $clickCount;

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
