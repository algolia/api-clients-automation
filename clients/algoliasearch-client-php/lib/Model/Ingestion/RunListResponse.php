<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * RunListResponse Class Doc Comment.
 *
 * @category Class
 */
class RunListResponse extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'runs' => '\Algolia\AlgoliaSearch\Model\Ingestion\Run[]',
        'pagination' => '\Algolia\AlgoliaSearch\Model\Ingestion\Pagination',
        'window' => '\Algolia\AlgoliaSearch\Model\Ingestion\Window',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'runs' => null,
        'pagination' => null,
        'window' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'runs' => 'runs',
        'pagination' => 'pagination',
        'window' => 'window',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'runs' => 'setRuns',
        'pagination' => 'setPagination',
        'window' => 'setWindow',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'runs' => 'getRuns',
        'pagination' => 'getPagination',
        'window' => 'getWindow',
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
        if (isset($data['runs'])) {
            $this->container['runs'] = $data['runs'];
        }
        if (isset($data['pagination'])) {
            $this->container['pagination'] = $data['pagination'];
        }
        if (isset($data['window'])) {
            $this->container['window'] = $data['window'];
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

        if (!isset($this->container['runs']) || null === $this->container['runs']) {
            $invalidProperties[] = "'runs' can't be null";
        }
        if (!isset($this->container['pagination']) || null === $this->container['pagination']) {
            $invalidProperties[] = "'pagination' can't be null";
        }
        if (!isset($this->container['window']) || null === $this->container['window']) {
            $invalidProperties[] = "'window' can't be null";
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
     * Gets runs.
     *
     * @return \Algolia\AlgoliaSearch\Model\Ingestion\Run[]
     */
    public function getRuns()
    {
        return $this->container['runs'] ?? null;
    }

    /**
     * Sets runs.
     *
     * @param \Algolia\AlgoliaSearch\Model\Ingestion\Run[] $runs runs
     *
     * @return self
     */
    public function setRuns($runs)
    {
        $this->container['runs'] = $runs;

        return $this;
    }

    /**
     * Gets pagination.
     *
     * @return Pagination
     */
    public function getPagination()
    {
        return $this->container['pagination'] ?? null;
    }

    /**
     * Sets pagination.
     *
     * @param Pagination $pagination pagination
     *
     * @return self
     */
    public function setPagination($pagination)
    {
        $this->container['pagination'] = $pagination;

        return $this;
    }

    /**
     * Gets window.
     *
     * @return Window
     */
    public function getWindow()
    {
        return $this->container['window'] ?? null;
    }

    /**
     * Sets window.
     *
     * @param Window $window window
     *
     * @return self
     */
    public function setWindow($window)
    {
        $this->container['window'] = $window;

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
