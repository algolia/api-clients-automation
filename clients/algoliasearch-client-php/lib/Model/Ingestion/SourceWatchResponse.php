<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * SourceWatchResponse Class Doc Comment.
 *
 * @category Class
 */
class SourceWatchResponse extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'runID' => 'string',
        'data' => 'object[]',
        'events' => '\Algolia\AlgoliaSearch\Model\Ingestion\Event[]',
        'message' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'runID' => null,
        'data' => null,
        'events' => null,
        'message' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'runID' => 'runID',
        'data' => 'data',
        'events' => 'events',
        'message' => 'message',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'runID' => 'setRunID',
        'data' => 'setData',
        'events' => 'setEvents',
        'message' => 'setMessage',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'runID' => 'getRunID',
        'data' => 'getData',
        'events' => 'getEvents',
        'message' => 'getMessage',
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
        if (isset($data['runID'])) {
            $this->container['runID'] = $data['runID'];
        }
        if (isset($data['data'])) {
            $this->container['data'] = $data['data'];
        }
        if (isset($data['events'])) {
            $this->container['events'] = $data['events'];
        }
        if (isset($data['message'])) {
            $this->container['message'] = $data['message'];
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

        if (!isset($this->container['message']) || null === $this->container['message']) {
            $invalidProperties[] = "'message' can't be null";
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
     * Gets runID.
     *
     * @return null|string
     */
    public function getRunID()
    {
        return $this->container['runID'] ?? null;
    }

    /**
     * Sets runID.
     *
     * @param null|string $runID universally unique identifier (UUID) of a task run
     *
     * @return self
     */
    public function setRunID($runID)
    {
        $this->container['runID'] = $runID;

        return $this;
    }

    /**
     * Gets data.
     *
     * @return null|object[]
     */
    public function getData()
    {
        return $this->container['data'] ?? null;
    }

    /**
     * Sets data.
     *
     * @param null|object[] $data depending on the source type, the validation returns sampling data of your source (JSON, CSV, BigQuery)
     *
     * @return self
     */
    public function setData($data)
    {
        $this->container['data'] = $data;

        return $this;
    }

    /**
     * Gets events.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\Event[]
     */
    public function getEvents()
    {
        return $this->container['events'] ?? null;
    }

    /**
     * Sets events.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\Event[] $events in case of error, observability events will be added to the response, if any
     *
     * @return self
     */
    public function setEvents($events)
    {
        $this->container['events'] = $events;

        return $this;
    }

    /**
     * Gets message.
     *
     * @return string
     */
    public function getMessage()
    {
        return $this->container['message'] ?? null;
    }

    /**
     * Sets message.
     *
     * @param string $message a message describing the outcome of a validate run
     *
     * @return self
     */
    public function setMessage($message)
    {
        $this->container['message'] = $message;

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
