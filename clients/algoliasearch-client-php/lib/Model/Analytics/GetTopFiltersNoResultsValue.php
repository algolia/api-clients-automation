<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Analytics;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * GetTopFiltersNoResultsValue Class Doc Comment.
 *
 * @category Class
 */
class GetTopFiltersNoResultsValue extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'attribute' => 'string',
        'operator' => '\Algolia\AlgoliaSearch\Model\Analytics\Operator',
        'value' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'attribute' => null,
        'operator' => null,
        'value' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'attribute' => 'attribute',
        'operator' => 'operator',
        'value' => 'value',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'attribute' => 'setAttribute',
        'operator' => 'setOperator',
        'value' => 'setValue',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'attribute' => 'getAttribute',
        'operator' => 'getOperator',
        'value' => 'getValue',
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
        if (isset($data['attribute'])) {
            $this->container['attribute'] = $data['attribute'];
        }
        if (isset($data['operator'])) {
            $this->container['operator'] = $data['operator'];
        }
        if (isset($data['value'])) {
            $this->container['value'] = $data['value'];
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

        if (!isset($this->container['attribute']) || null === $this->container['attribute']) {
            $invalidProperties[] = "'attribute' can't be null";
        }
        if (!isset($this->container['operator']) || null === $this->container['operator']) {
            $invalidProperties[] = "'operator' can't be null";
        }
        if (!isset($this->container['value']) || null === $this->container['value']) {
            $invalidProperties[] = "'value' can't be null";
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
     * Gets attribute.
     *
     * @return string
     */
    public function getAttribute()
    {
        return $this->container['attribute'] ?? null;
    }

    /**
     * Sets attribute.
     *
     * @param string $attribute attribute name
     *
     * @return self
     */
    public function setAttribute($attribute)
    {
        $this->container['attribute'] = $attribute;

        return $this;
    }

    /**
     * Gets operator.
     *
     * @return Operator
     */
    public function getOperator()
    {
        return $this->container['operator'] ?? null;
    }

    /**
     * Sets operator.
     *
     * @param Operator $operator operator
     *
     * @return self
     */
    public function setOperator($operator)
    {
        $this->container['operator'] = $operator;

        return $this;
    }

    /**
     * Gets value.
     *
     * @return string
     */
    public function getValue()
    {
        return $this->container['value'] ?? null;
    }

    /**
     * Sets value.
     *
     * @param string $value attribute value
     *
     * @return self
     */
    public function setValue($value)
    {
        $this->container['value'] = $value;

        return $this;
    }

    /**
     * Returns true if offset exists. False otherwise.
     *
     * @param int $offset Offset
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
