<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * FacetsStats Class Doc Comment.
 *
 * @category Class
 */
class FacetsStats extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'min' => 'float',
        'max' => 'float',
        'avg' => 'float',
        'sum' => 'float',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'min' => 'double',
        'max' => 'double',
        'avg' => 'double',
        'sum' => 'double',
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'min' => 'min',
        'max' => 'max',
        'avg' => 'avg',
        'sum' => 'sum',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'min' => 'setMin',
        'max' => 'setMax',
        'avg' => 'setAvg',
        'sum' => 'setSum',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'min' => 'getMin',
        'max' => 'getMax',
        'avg' => 'getAvg',
        'sum' => 'getSum',
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
        if (isset($data['min'])) {
            $this->container['min'] = $data['min'];
        }
        if (isset($data['max'])) {
            $this->container['max'] = $data['max'];
        }
        if (isset($data['avg'])) {
            $this->container['avg'] = $data['avg'];
        }
        if (isset($data['sum'])) {
            $this->container['sum'] = $data['sum'];
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
     * Gets min.
     *
     * @return null|float
     */
    public function getMin()
    {
        return $this->container['min'] ?? null;
    }

    /**
     * Sets min.
     *
     * @param null|float $min minimum value in the results
     *
     * @return self
     */
    public function setMin($min)
    {
        $this->container['min'] = $min;

        return $this;
    }

    /**
     * Gets max.
     *
     * @return null|float
     */
    public function getMax()
    {
        return $this->container['max'] ?? null;
    }

    /**
     * Sets max.
     *
     * @param null|float $max maximum value in the results
     *
     * @return self
     */
    public function setMax($max)
    {
        $this->container['max'] = $max;

        return $this;
    }

    /**
     * Gets avg.
     *
     * @return null|float
     */
    public function getAvg()
    {
        return $this->container['avg'] ?? null;
    }

    /**
     * Sets avg.
     *
     * @param null|float $avg average facet value in the results
     *
     * @return self
     */
    public function setAvg($avg)
    {
        $this->container['avg'] = $avg;

        return $this;
    }

    /**
     * Gets sum.
     *
     * @return null|float
     */
    public function getSum()
    {
        return $this->container['sum'] ?? null;
    }

    /**
     * Sets sum.
     *
     * @param null|float $sum sum of all values in the results
     *
     * @return self
     */
    public function setSum($sum)
    {
        $this->container['sum'] = $sum;

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
