<?php

namespace Algolia\AlgoliaSearch\Model;

use \Algolia\AlgoliaSearch\ObjectSerializer;
use \ArrayAccess;

/**
 * InsightEvent Class Doc Comment
 *
 * @category Class
 * @description Insights event.
 *
 * @package  Algolia\AlgoliaSearch
 * @implements \ArrayAccess<TKey, TValue>
 * @template TKey int|null
 * @template TValue mixed|null
 */
class InsightEvent implements ModelInterface, ArrayAccess, \JsonSerializable
{
    public const DISCRIMINATOR = null;

    /**
      * The original name of the model.
      *
      * @var string
      */
    protected static $openAPIModelName = 'InsightEvent';

    /**
      * Array of property to type mappings. Used for (de)serialization
      *
      * @var string[]
      */
    protected static $openAPITypes = [
        'eventType' => 'string',
        'eventName' => 'string',
        'index' => 'string',
        'userToken' => 'string',
        'timestamp' => 'int',
        'queryID' => 'string',
        'objectIDs' => 'string[]',
        'filters' => 'string[]',
        'positions' => 'int[]',
    ];

    /**
      * Array of property to format mappings. Used for (de)serialization
      *
      * @var string[]
      * @phpstan-var array<string, string|null>
      * @psalm-var array<string, string|null>
      */
    protected static $openAPIFormats = [
        'eventType' => null,
        'eventName' => null,
        'index' => null,
        'userToken' => null,
        'timestamp' => null,
        'queryID' => null,
        'objectIDs' => null,
        'filters' => null,
        'positions' => null,
    ];

    /**
     * Array of property to type mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function openAPITypes()
    {
        return self::$openAPITypes;
    }

    /**
     * Array of property to format mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function openAPIFormats()
    {
        return self::$openAPIFormats;
    }

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'eventType' => 'eventType',
        'eventName' => 'eventName',
        'index' => 'index',
        'userToken' => 'userToken',
        'timestamp' => 'timestamp',
        'queryID' => 'queryID',
        'objectIDs' => 'objectIDs',
        'filters' => 'filters',
        'positions' => 'positions',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses)
     *
     * @var string[]
     */
    protected static $setters = [
        'eventType' => 'setEventType',
        'eventName' => 'setEventName',
        'index' => 'setIndex',
        'userToken' => 'setUserToken',
        'timestamp' => 'setTimestamp',
        'queryID' => 'setQueryID',
        'objectIDs' => 'setObjectIDs',
        'filters' => 'setFilters',
        'positions' => 'setPositions',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests)
     *
     * @var string[]
     */
    protected static $getters = [
        'eventType' => 'getEventType',
        'eventName' => 'getEventName',
        'index' => 'getIndex',
        'userToken' => 'getUserToken',
        'timestamp' => 'getTimestamp',
        'queryID' => 'getQueryID',
        'objectIDs' => 'getObjectIDs',
        'filters' => 'getFilters',
        'positions' => 'getPositions',
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
     * The original name of the model.
     *
     * @return string
     */
    public function getModelName()
    {
        return self::$openAPIModelName;
    }

    const EVENT_TYPE_CLICK = 'click';
    const EVENT_TYPE_CONVERSION = 'conversion';
    const EVENT_TYPE_VIEW = 'view';

    /**
     * Gets allowable values of the enum
     *
     * @return string[]
     */
    public function getEventTypeAllowableValues()
    {
        return [
            self::EVENT_TYPE_CLICK,
            self::EVENT_TYPE_CONVERSION,
            self::EVENT_TYPE_VIEW,
        ];
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
     *                      initializing the model
     */
    public function __construct(array $data = null)
    {
        $this->container['eventType'] = $data['eventType'] ?? null;
        $this->container['eventName'] = $data['eventName'] ?? null;
        $this->container['index'] = $data['index'] ?? null;
        $this->container['userToken'] = $data['userToken'] ?? null;
        $this->container['timestamp'] = $data['timestamp'] ?? null;
        $this->container['queryID'] = $data['queryID'] ?? null;
        $this->container['objectIDs'] = $data['objectIDs'] ?? null;
        $this->container['filters'] = $data['filters'] ?? null;
        $this->container['positions'] = $data['positions'] ?? null;
    }

    /**
     * Show all the invalid properties with reasons.
     *
     * @return array invalid properties with reasons
     */
    public function listInvalidProperties()
    {
        $invalidProperties = [];

        if ($this->container['eventType'] === null) {
            $invalidProperties[] = "'eventType' can't be null";
        }
        $allowedValues = $this->getEventTypeAllowableValues();
        if (!is_null($this->container['eventType']) && !in_array($this->container['eventType'], $allowedValues, true)) {
            $invalidProperties[] = sprintf(
                "invalid value '%s' for 'eventType', must be one of '%s'",
                $this->container['eventType'],
                implode("', '", $allowedValues)
            );
        }

        if ($this->container['eventName'] === null) {
            $invalidProperties[] = "'eventName' can't be null";
        }
        if ($this->container['index'] === null) {
            $invalidProperties[] = "'index' can't be null";
        }
        if ($this->container['userToken'] === null) {
            $invalidProperties[] = "'userToken' can't be null";
        }

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
     * Gets eventType
     *
     * @return string
     */
    public function getEventType()
    {
        return $this->container['eventType'];
    }

    /**
     * Sets eventType
     *
     * @param string $eventType an eventType can be a click, a conversion, or a view
     *
     * @return self
     */
    public function setEventType($eventType)
    {
        $allowedValues = $this->getEventTypeAllowableValues();
        if (!in_array($eventType, $allowedValues, true)) {
            throw new \InvalidArgumentException(
                sprintf(
                    "Invalid value '%s' for 'eventType', must be one of '%s'",
                    $eventType,
                    implode("', '", $allowedValues)
                )
            );
        }
        $this->container['eventType'] = $eventType;

        return $this;
    }

    /**
     * Gets eventName
     *
     * @return string
     */
    public function getEventName()
    {
        return $this->container['eventName'];
    }

    /**
     * Sets eventName
     *
     * @param string $eventName a user-defined string used to categorize events
     *
     * @return self
     */
    public function setEventName($eventName)
    {
        $this->container['eventName'] = $eventName;

        return $this;
    }

    /**
     * Gets index
     *
     * @return string
     */
    public function getIndex()
    {
        return $this->container['index'];
    }

    /**
     * Sets index
     *
     * @param string $index name of the targeted index
     *
     * @return self
     */
    public function setIndex($index)
    {
        $this->container['index'] = $index;

        return $this;
    }

    /**
     * Gets userToken
     *
     * @return string
     */
    public function getUserToken()
    {
        return $this->container['userToken'];
    }

    /**
     * Sets userToken
     *
     * @param string $userToken A user identifier. Depending if the user is logged-in or not, several strategies can be used from a sessionId to a technical identifier.
     *
     * @return self
     */
    public function setUserToken($userToken)
    {
        $this->container['userToken'] = $userToken;

        return $this;
    }

    /**
     * Gets timestamp
     *
     * @return int|null
     */
    public function getTimestamp()
    {
        return $this->container['timestamp'];
    }

    /**
     * Sets timestamp
     *
     * @param int|null $timestamp time of the event expressed in milliseconds since the Unix epoch
     *
     * @return self
     */
    public function setTimestamp($timestamp)
    {
        $this->container['timestamp'] = $timestamp;

        return $this;
    }

    /**
     * Gets queryID
     *
     * @return string|null
     */
    public function getQueryID()
    {
        return $this->container['queryID'];
    }

    /**
     * Sets queryID
     *
     * @param string|null $queryID Algolia queryID. This is required when an event is tied to a search.
     *
     * @return self
     */
    public function setQueryID($queryID)
    {
        $this->container['queryID'] = $queryID;

        return $this;
    }

    /**
     * Gets objectIDs
     *
     * @return string[]|null
     */
    public function getObjectIDs()
    {
        return $this->container['objectIDs'];
    }

    /**
     * Sets objectIDs
     *
     * @param string[]|null $objectIDs An array of index objectID. Limited to 20 objects. An event can’t have both objectIDs and filters at the same time.
     *
     * @return self
     */
    public function setObjectIDs($objectIDs)
    {
        $this->container['objectIDs'] = $objectIDs;

        return $this;
    }

    /**
     * Gets filters
     *
     * @return string[]|null
     */
    public function getFilters()
    {
        return $this->container['filters'];
    }

    /**
     * Sets filters
     *
     * @param string[]|null $filters An array of filters. Limited to 10 filters. An event can’t have both objectIDs and filters at the same time.
     *
     * @return self
     */
    public function setFilters($filters)
    {
        $this->container['filters'] = $filters;

        return $this;
    }

    /**
     * Gets positions
     *
     * @return int[]|null
     */
    public function getPositions()
    {
        return $this->container['positions'];
    }

    /**
     * Sets positions
     *
     * @param int[]|null $positions Position of the click in the list of Algolia search results. This field is required if a queryID is provided. One position must be provided for each objectID.
     *
     * @return self
     */
    public function setPositions($positions)
    {
        $this->container['positions'] = $positions;

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

    /**
     * Serializes the object to a value that can be serialized natively by json_encode().
     *
     * @link https://www.php.net/manual/en/jsonserializable.jsonserialize.php
     *
     * @return mixed returns data which can be serialized by json_encode(), which is a value
     * of any type other than a resource
     */
    public function jsonSerialize()
    {
        return ObjectSerializer::sanitizeForSerialization($this);
    }

    /**
     * Gets the string presentation of the object
     *
     * @return string
     */
    public function __toString()
    {
        return json_encode(
            ObjectSerializer::sanitizeForSerialization($this),
            JSON_PRETTY_PRINT
        );
    }

    /**
     * Gets a header-safe presentation of the object
     *
     * @return string
     */
    public function toHeaderValue()
    {
        return json_encode(ObjectSerializer::sanitizeForSerialization($this));
    }
}

