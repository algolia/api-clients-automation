<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * UpdatedAtWithObjectIdResponse Class Doc Comment.
 *
 * @category Class
 * @description Response, taskID, unique object identifier, and an update timestamp.
 */
class UpdatedAtWithObjectIdResponse extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'taskID' => 'int',
        'updatedAt' => 'string',
        'objectID' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'taskID' => 'int64',
        'updatedAt' => null,
        'objectID' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'taskID' => 'taskID',
        'updatedAt' => 'updatedAt',
        'objectID' => 'objectID',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'taskID' => 'setTaskID',
        'updatedAt' => 'setUpdatedAt',
        'objectID' => 'setObjectID',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'taskID' => 'getTaskID',
        'updatedAt' => 'getUpdatedAt',
        'objectID' => 'getObjectID',
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
        if (isset($data['taskID'])) {
            $this->container['taskID'] = $data['taskID'];
        }
        if (isset($data['updatedAt'])) {
            $this->container['updatedAt'] = $data['updatedAt'];
        }
        if (isset($data['objectID'])) {
            $this->container['objectID'] = $data['objectID'];
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
     * Gets taskID.
     *
     * @return null|int
     */
    public function getTaskID()
    {
        return $this->container['taskID'] ?? null;
    }

    /**
     * Sets taskID.
     *
     * @param null|int $taskID Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`.
     *
     * @return self
     */
    public function setTaskID($taskID)
    {
        $this->container['taskID'] = $taskID;

        return $this;
    }

    /**
     * Gets updatedAt.
     *
     * @return null|string
     */
    public function getUpdatedAt()
    {
        return $this->container['updatedAt'] ?? null;
    }

    /**
     * Sets updatedAt.
     *
     * @param null|string $updatedAt Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
     *
     * @return self
     */
    public function setUpdatedAt($updatedAt)
    {
        $this->container['updatedAt'] = $updatedAt;

        return $this;
    }

    /**
     * Gets objectID.
     *
     * @return null|string
     */
    public function getObjectID()
    {
        return $this->container['objectID'] ?? null;
    }

    /**
     * Sets objectID.
     *
     * @param null|string $objectID unique record identifier
     *
     * @return self
     */
    public function setObjectID($objectID)
    {
        $this->container['objectID'] = $objectID;

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
