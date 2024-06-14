<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * OnDemandDateUtilsInput Class Doc Comment.
 *
 * @category Class
 * @description Input for a manually-triggered task whose source is of type &#x60;bigquery&#x60; and for which extracted data spans a given time range.
 */
class OnDemandDateUtilsInput extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'startDate' => 'string',
        'endDate' => 'string',
        'mapping' => '\Algolia\AlgoliaSearch\Model\Ingestion\MappingInput',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'startDate' => null,
        'endDate' => null,
        'mapping' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'startDate' => 'startDate',
        'endDate' => 'endDate',
        'mapping' => 'mapping',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'startDate' => 'setStartDate',
        'endDate' => 'setEndDate',
        'mapping' => 'setMapping',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'startDate' => 'getStartDate',
        'endDate' => 'getEndDate',
        'mapping' => 'getMapping',
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
        if (isset($data['startDate'])) {
            $this->container['startDate'] = $data['startDate'];
        }
        if (isset($data['endDate'])) {
            $this->container['endDate'] = $data['endDate'];
        }
        if (isset($data['mapping'])) {
            $this->container['mapping'] = $data['mapping'];
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

        if (!isset($this->container['startDate']) || null === $this->container['startDate']) {
            $invalidProperties[] = "'startDate' can't be null";
        }
        if (!isset($this->container['endDate']) || null === $this->container['endDate']) {
            $invalidProperties[] = "'endDate' can't be null";
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
     * Gets startDate.
     *
     * @return string
     */
    public function getStartDate()
    {
        return $this->container['startDate'] ?? null;
    }

    /**
     * Sets startDate.
     *
     * @param string $startDate earliest date in RFC 3339 format of the extracted data from Big Query
     *
     * @return self
     */
    public function setStartDate($startDate)
    {
        $this->container['startDate'] = $startDate;

        return $this;
    }

    /**
     * Gets endDate.
     *
     * @return string
     */
    public function getEndDate()
    {
        return $this->container['endDate'] ?? null;
    }

    /**
     * Sets endDate.
     *
     * @param string $endDate latest date in RFC 3339 format of the extracted data from Big Query
     *
     * @return self
     */
    public function setEndDate($endDate)
    {
        $this->container['endDate'] = $endDate;

        return $this;
    }

    /**
     * Gets mapping.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\MappingInput
     */
    public function getMapping()
    {
        return $this->container['mapping'] ?? null;
    }

    /**
     * Sets mapping.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\MappingInput $mapping mapping
     *
     * @return self
     */
    public function setMapping($mapping)
    {
        $this->container['mapping'] = $mapping;

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
