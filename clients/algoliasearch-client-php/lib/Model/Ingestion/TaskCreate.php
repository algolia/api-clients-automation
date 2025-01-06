<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * TaskCreate Class Doc Comment.
 *
 * @category Class
 *
 * @description API request body for creating a task.
 */
class TaskCreate extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'sourceID' => 'string',
        'destinationID' => 'string',
        'action' => '\Algolia\AlgoliaSearch\Model\Ingestion\ActionType',
        'cron' => 'string',
        'enabled' => 'bool',
        'failureThreshold' => 'int',
        'input' => '\Algolia\AlgoliaSearch\Model\Ingestion\TaskInput',
        'cursor' => 'string',
        'notifications' => '\Algolia\AlgoliaSearch\Model\Ingestion\Notifications',
        'policies' => '\Algolia\AlgoliaSearch\Model\Ingestion\Policies',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'sourceID' => null,
        'destinationID' => null,
        'action' => null,
        'cron' => null,
        'enabled' => null,
        'failureThreshold' => null,
        'input' => null,
        'cursor' => null,
        'notifications' => null,
        'policies' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'sourceID' => 'sourceID',
        'destinationID' => 'destinationID',
        'action' => 'action',
        'cron' => 'cron',
        'enabled' => 'enabled',
        'failureThreshold' => 'failureThreshold',
        'input' => 'input',
        'cursor' => 'cursor',
        'notifications' => 'notifications',
        'policies' => 'policies',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'sourceID' => 'setSourceID',
        'destinationID' => 'setDestinationID',
        'action' => 'setAction',
        'cron' => 'setCron',
        'enabled' => 'setEnabled',
        'failureThreshold' => 'setFailureThreshold',
        'input' => 'setInput',
        'cursor' => 'setCursor',
        'notifications' => 'setNotifications',
        'policies' => 'setPolicies',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'sourceID' => 'getSourceID',
        'destinationID' => 'getDestinationID',
        'action' => 'getAction',
        'cron' => 'getCron',
        'enabled' => 'getEnabled',
        'failureThreshold' => 'getFailureThreshold',
        'input' => 'getInput',
        'cursor' => 'getCursor',
        'notifications' => 'getNotifications',
        'policies' => 'getPolicies',
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
        if (isset($data['sourceID'])) {
            $this->container['sourceID'] = $data['sourceID'];
        }
        if (isset($data['destinationID'])) {
            $this->container['destinationID'] = $data['destinationID'];
        }
        if (isset($data['action'])) {
            $this->container['action'] = $data['action'];
        }
        if (isset($data['cron'])) {
            $this->container['cron'] = $data['cron'];
        }
        if (isset($data['enabled'])) {
            $this->container['enabled'] = $data['enabled'];
        }
        if (isset($data['failureThreshold'])) {
            $this->container['failureThreshold'] = $data['failureThreshold'];
        }
        if (isset($data['input'])) {
            $this->container['input'] = $data['input'];
        }
        if (isset($data['cursor'])) {
            $this->container['cursor'] = $data['cursor'];
        }
        if (isset($data['notifications'])) {
            $this->container['notifications'] = $data['notifications'];
        }
        if (isset($data['policies'])) {
            $this->container['policies'] = $data['policies'];
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

        if (!isset($this->container['sourceID']) || null === $this->container['sourceID']) {
            $invalidProperties[] = "'sourceID' can't be null";
        }
        if (!isset($this->container['destinationID']) || null === $this->container['destinationID']) {
            $invalidProperties[] = "'destinationID' can't be null";
        }
        if (!isset($this->container['action']) || null === $this->container['action']) {
            $invalidProperties[] = "'action' can't be null";
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
     * Gets enabled.
     *
     * @return null|bool
     */
    public function getEnabled()
    {
        return $this->container['enabled'] ?? null;
    }

    /**
     * Sets enabled.
     *
     * @param null|bool $enabled whether the task is enabled
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
        $this->container['failureThreshold'] = $failureThreshold;

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
     * Gets notifications.
     *
     * @return null|Notifications
     */
    public function getNotifications()
    {
        return $this->container['notifications'] ?? null;
    }

    /**
     * Sets notifications.
     *
     * @param null|Notifications $notifications notifications
     *
     * @return self
     */
    public function setNotifications($notifications)
    {
        $this->container['notifications'] = $notifications;

        return $this;
    }

    /**
     * Gets policies.
     *
     * @return null|Policies
     */
    public function getPolicies()
    {
        return $this->container['policies'] ?? null;
    }

    /**
     * Sets policies.
     *
     * @param null|Policies $policies policies
     *
     * @return self
     */
    public function setPolicies($policies)
    {
        $this->container['policies'] = $policies;

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
