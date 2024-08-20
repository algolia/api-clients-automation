<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * Task Class Doc Comment.
 *
 * @category Class
 */
class Task extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'taskID' => 'string',
        'sourceID' => 'string',
        'destinationID' => 'string',
        'cron' => 'string',
        'lastRun' => 'string',
        'nextRun' => 'string',
        'input' => '\Algolia\AlgoliaSearch\Model\Ingestion\TaskInput',
        'enabled' => 'bool',
        'failureThreshold' => 'int',
        'action' => '\Algolia\AlgoliaSearch\Model\Ingestion\ActionType',
        'cursor' => 'string',
        'createdAt' => 'string',
        'updatedAt' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'taskID' => null,
        'sourceID' => null,
        'destinationID' => null,
        'cron' => null,
        'lastRun' => null,
        'nextRun' => null,
        'input' => null,
        'enabled' => null,
        'failureThreshold' => null,
        'action' => null,
        'cursor' => null,
        'createdAt' => null,
        'updatedAt' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'taskID' => 'taskID',
        'sourceID' => 'sourceID',
        'destinationID' => 'destinationID',
        'cron' => 'cron',
        'lastRun' => 'lastRun',
        'nextRun' => 'nextRun',
        'input' => 'input',
        'enabled' => 'enabled',
        'failureThreshold' => 'failureThreshold',
        'action' => 'action',
        'cursor' => 'cursor',
        'createdAt' => 'createdAt',
        'updatedAt' => 'updatedAt',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'taskID' => 'setTaskID',
        'sourceID' => 'setSourceID',
        'destinationID' => 'setDestinationID',
        'cron' => 'setCron',
        'lastRun' => 'setLastRun',
        'nextRun' => 'setNextRun',
        'input' => 'setInput',
        'enabled' => 'setEnabled',
        'failureThreshold' => 'setFailureThreshold',
        'action' => 'setAction',
        'cursor' => 'setCursor',
        'createdAt' => 'setCreatedAt',
        'updatedAt' => 'setUpdatedAt',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'taskID' => 'getTaskID',
        'sourceID' => 'getSourceID',
        'destinationID' => 'getDestinationID',
        'cron' => 'getCron',
        'lastRun' => 'getLastRun',
        'nextRun' => 'getNextRun',
        'input' => 'getInput',
        'enabled' => 'getEnabled',
        'failureThreshold' => 'getFailureThreshold',
        'action' => 'getAction',
        'cursor' => 'getCursor',
        'createdAt' => 'getCreatedAt',
        'updatedAt' => 'getUpdatedAt',
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
        if (isset($data['taskID'])) {
            $this->container['taskID'] = $data['taskID'];
        }
        if (isset($data['sourceID'])) {
            $this->container['sourceID'] = $data['sourceID'];
        }
        if (isset($data['destinationID'])) {
            $this->container['destinationID'] = $data['destinationID'];
        }
        if (isset($data['cron'])) {
            $this->container['cron'] = $data['cron'];
        }
        if (isset($data['lastRun'])) {
            $this->container['lastRun'] = $data['lastRun'];
        }
        if (isset($data['nextRun'])) {
            $this->container['nextRun'] = $data['nextRun'];
        }
        if (isset($data['input'])) {
            $this->container['input'] = $data['input'];
        }
        if (isset($data['enabled'])) {
            $this->container['enabled'] = $data['enabled'];
        }
        if (isset($data['failureThreshold'])) {
            $this->container['failureThreshold'] = $data['failureThreshold'];
        }
        if (isset($data['action'])) {
            $this->container['action'] = $data['action'];
        }
        if (isset($data['cursor'])) {
            $this->container['cursor'] = $data['cursor'];
        }
        if (isset($data['createdAt'])) {
            $this->container['createdAt'] = $data['createdAt'];
        }
        if (isset($data['updatedAt'])) {
            $this->container['updatedAt'] = $data['updatedAt'];
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

        if (!isset($this->container['taskID']) || null === $this->container['taskID']) {
            $invalidProperties[] = "'taskID' can't be null";
        }
        if (!isset($this->container['sourceID']) || null === $this->container['sourceID']) {
            $invalidProperties[] = "'sourceID' can't be null";
        }
        if (!isset($this->container['destinationID']) || null === $this->container['destinationID']) {
            $invalidProperties[] = "'destinationID' can't be null";
        }
        if (!isset($this->container['enabled']) || null === $this->container['enabled']) {
            $invalidProperties[] = "'enabled' can't be null";
        }
        if (isset($this->container['failureThreshold']) && ($this->container['failureThreshold'] > 100)) {
            $invalidProperties[] = "invalid value for 'failureThreshold', must be smaller than or equal to 100.";
        }

        if (isset($this->container['failureThreshold']) && ($this->container['failureThreshold'] < 0)) {
            $invalidProperties[] = "invalid value for 'failureThreshold', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['action']) || null === $this->container['action']) {
            $invalidProperties[] = "'action' can't be null";
        }
        if (!isset($this->container['createdAt']) || null === $this->container['createdAt']) {
            $invalidProperties[] = "'createdAt' can't be null";
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
     * Gets taskID.
     *
     * @return string
     */
    public function getTaskID()
    {
        return $this->container['taskID'] ?? null;
    }

    /**
     * Sets taskID.
     *
     * @param string $taskID universally unique identifier (UUID) of a task
     *
     * @return self
     */
    public function setTaskID($taskID)
    {
        $this->container['taskID'] = $taskID;

        return $this;
    }

    /**
     * Gets sourceID.
     *
     * @return string
     */
    public function getSourceID()
    {
        return $this->container['sourceID'] ?? null;
    }

    /**
     * Sets sourceID.
     *
     * @param string $sourceID universally uniqud identifier (UUID) of a source
     *
     * @return self
     */
    public function setSourceID($sourceID)
    {
        $this->container['sourceID'] = $sourceID;

        return $this;
    }

    /**
     * Gets destinationID.
     *
     * @return string
     */
    public function getDestinationID()
    {
        return $this->container['destinationID'] ?? null;
    }

    /**
     * Sets destinationID.
     *
     * @param string $destinationID universally unique identifier (UUID) of a destination resource
     *
     * @return self
     */
    public function setDestinationID($destinationID)
    {
        $this->container['destinationID'] = $destinationID;

        return $this;
    }

    /**
     * Gets cron.
     *
     * @return null|string
     */
    public function getCron()
    {
        return $this->container['cron'] ?? null;
    }

    /**
     * Sets cron.
     *
     * @param null|string $cron cron expression for the task's schedule
     *
     * @return self
     */
    public function setCron($cron)
    {
        $this->container['cron'] = $cron;

        return $this;
    }

    /**
     * Gets lastRun.
     *
     * @return null|string
     */
    public function getLastRun()
    {
        return $this->container['lastRun'] ?? null;
    }

    /**
     * Sets lastRun.
     *
     * @param null|string $lastRun the last time the scheduled task ran in RFC 3339 format
     *
     * @return self
     */
    public function setLastRun($lastRun)
    {
        $this->container['lastRun'] = $lastRun;

        return $this;
    }

    /**
     * Gets nextRun.
     *
     * @return null|string
     */
    public function getNextRun()
    {
        return $this->container['nextRun'] ?? null;
    }

    /**
     * Sets nextRun.
     *
     * @param null|string $nextRun the next scheduled run of the task in RFC 3339 format
     *
     * @return self
     */
    public function setNextRun($nextRun)
    {
        $this->container['nextRun'] = $nextRun;

        return $this;
    }

    /**
     * Gets input.
     *
     * @return null|TaskInput
     */
    public function getInput()
    {
        return $this->container['input'] ?? null;
    }

    /**
     * Sets input.
     *
     * @param null|TaskInput $input input
     *
     * @return self
     */
    public function setInput($input)
    {
        $this->container['input'] = $input;

        return $this;
    }

    /**
     * Gets enabled.
     *
     * @return bool
     */
    public function getEnabled()
    {
        return $this->container['enabled'] ?? null;
    }

    /**
     * Sets enabled.
     *
     * @param bool $enabled whether the task is enabled
     *
     * @return self
     */
    public function setEnabled($enabled)
    {
        $this->container['enabled'] = $enabled;

        return $this;
    }

    /**
     * Gets failureThreshold.
     *
     * @return null|int
     */
    public function getFailureThreshold()
    {
        return $this->container['failureThreshold'] ?? null;
    }

    /**
     * Sets failureThreshold.
     *
     * @param null|int $failureThreshold maximum accepted percentage of failures for a task run to finish successfully
     *
     * @return self
     */
    public function setFailureThreshold($failureThreshold)
    {
        if (!is_null($failureThreshold) && ($failureThreshold > 100)) {
            throw new \InvalidArgumentException('invalid value for $failureThreshold when calling Task., must be smaller than or equal to 100.');
        }
        if (!is_null($failureThreshold) && ($failureThreshold < 0)) {
            throw new \InvalidArgumentException('invalid value for $failureThreshold when calling Task., must be bigger than or equal to 0.');
        }

        $this->container['failureThreshold'] = $failureThreshold;

        return $this;
    }

    /**
     * Gets action.
     *
     * @return ActionType
     */
    public function getAction()
    {
        return $this->container['action'] ?? null;
    }

    /**
     * Sets action.
     *
     * @param ActionType $action action
     *
     * @return self
     */
    public function setAction($action)
    {
        $this->container['action'] = $action;

        return $this;
    }

    /**
     * Gets cursor.
     *
     * @return null|string
     */
    public function getCursor()
    {
        return $this->container['cursor'] ?? null;
    }

    /**
     * Sets cursor.
     *
     * @param null|string $cursor date of the last cursor in RFC 3339 format
     *
     * @return self
     */
    public function setCursor($cursor)
    {
        $this->container['cursor'] = $cursor;

        return $this;
    }

    /**
     * Gets createdAt.
     *
     * @return string
     */
    public function getCreatedAt()
    {
        return $this->container['createdAt'] ?? null;
    }

    /**
     * Sets createdAt.
     *
     * @param string $createdAt date of creation in RFC 3339 format
     *
     * @return self
     */
    public function setCreatedAt($createdAt)
    {
        $this->container['createdAt'] = $createdAt;

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
     * @param null|string $updatedAt date of last update in RFC 3339 format
     *
     * @return self
     */
    public function setUpdatedAt($updatedAt)
    {
        $this->container['updatedAt'] = $updatedAt;

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
