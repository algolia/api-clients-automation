<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * Run Class Doc Comment.
 *
 * @category Class
 */
class Run extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'runID' => 'string',
        'appID' => 'string',
        'taskID' => 'string',
        'status' => '\Algolia\AlgoliaSearch\Model\Ingestion\RunStatus',
        'progress' => '\Algolia\AlgoliaSearch\Model\Ingestion\RunProgress',
        'outcome' => '\Algolia\AlgoliaSearch\Model\Ingestion\RunOutcome',
        'failureThreshold' => 'int',
        'reason' => 'string',
        'reasonCode' => '\Algolia\AlgoliaSearch\Model\Ingestion\RunReasonCode',
        'type' => '\Algolia\AlgoliaSearch\Model\Ingestion\RunType',
        'createdAt' => 'string',
        'startedAt' => 'string',
        'finishedAt' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'runID' => null,
        'appID' => null,
        'taskID' => null,
        'status' => null,
        'progress' => null,
        'outcome' => null,
        'failureThreshold' => null,
        'reason' => null,
        'reasonCode' => null,
        'type' => null,
        'createdAt' => null,
        'startedAt' => null,
        'finishedAt' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'runID' => 'runID',
        'appID' => 'appID',
        'taskID' => 'taskID',
        'status' => 'status',
        'progress' => 'progress',
        'outcome' => 'outcome',
        'failureThreshold' => 'failureThreshold',
        'reason' => 'reason',
        'reasonCode' => 'reasonCode',
        'type' => 'type',
        'createdAt' => 'createdAt',
        'startedAt' => 'startedAt',
        'finishedAt' => 'finishedAt',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'runID' => 'setRunID',
        'appID' => 'setAppID',
        'taskID' => 'setTaskID',
        'status' => 'setStatus',
        'progress' => 'setProgress',
        'outcome' => 'setOutcome',
        'failureThreshold' => 'setFailureThreshold',
        'reason' => 'setReason',
        'reasonCode' => 'setReasonCode',
        'type' => 'setType',
        'createdAt' => 'setCreatedAt',
        'startedAt' => 'setStartedAt',
        'finishedAt' => 'setFinishedAt',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'runID' => 'getRunID',
        'appID' => 'getAppID',
        'taskID' => 'getTaskID',
        'status' => 'getStatus',
        'progress' => 'getProgress',
        'outcome' => 'getOutcome',
        'failureThreshold' => 'getFailureThreshold',
        'reason' => 'getReason',
        'reasonCode' => 'getReasonCode',
        'type' => 'getType',
        'createdAt' => 'getCreatedAt',
        'startedAt' => 'getStartedAt',
        'finishedAt' => 'getFinishedAt',
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
        if (isset($data['runID'])) {
            $this->container['runID'] = $data['runID'];
        }
        if (isset($data['appID'])) {
            $this->container['appID'] = $data['appID'];
        }
        if (isset($data['taskID'])) {
            $this->container['taskID'] = $data['taskID'];
        }
        if (isset($data['status'])) {
            $this->container['status'] = $data['status'];
        }
        if (isset($data['progress'])) {
            $this->container['progress'] = $data['progress'];
        }
        if (isset($data['outcome'])) {
            $this->container['outcome'] = $data['outcome'];
        }
        if (isset($data['failureThreshold'])) {
            $this->container['failureThreshold'] = $data['failureThreshold'];
        }
        if (isset($data['reason'])) {
            $this->container['reason'] = $data['reason'];
        }
        if (isset($data['reasonCode'])) {
            $this->container['reasonCode'] = $data['reasonCode'];
        }
        if (isset($data['type'])) {
            $this->container['type'] = $data['type'];
        }
        if (isset($data['createdAt'])) {
            $this->container['createdAt'] = $data['createdAt'];
        }
        if (isset($data['startedAt'])) {
            $this->container['startedAt'] = $data['startedAt'];
        }
        if (isset($data['finishedAt'])) {
            $this->container['finishedAt'] = $data['finishedAt'];
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

        if (!isset($this->container['runID']) || null === $this->container['runID']) {
            $invalidProperties[] = "'runID' can't be null";
        }
        if (!isset($this->container['appID']) || null === $this->container['appID']) {
            $invalidProperties[] = "'appID' can't be null";
        }
        if (!isset($this->container['taskID']) || null === $this->container['taskID']) {
            $invalidProperties[] = "'taskID' can't be null";
        }
        if (!isset($this->container['status']) || null === $this->container['status']) {
            $invalidProperties[] = "'status' can't be null";
        }
        if (isset($this->container['failureThreshold']) && ($this->container['failureThreshold'] > 100)) {
            $invalidProperties[] = "invalid value for 'failureThreshold', must be smaller than or equal to 100.";
        }

        if (isset($this->container['failureThreshold']) && ($this->container['failureThreshold'] < 0)) {
            $invalidProperties[] = "invalid value for 'failureThreshold', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['type']) || null === $this->container['type']) {
            $invalidProperties[] = "'type' can't be null";
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
     * Gets runID.
     *
     * @return string
     */
    public function getRunID()
    {
        return $this->container['runID'] ?? null;
    }

    /**
     * Sets runID.
     *
     * @param string $runID the run UUID
     *
     * @return self
     */
    public function setRunID($runID)
    {
        $this->container['runID'] = $runID;

        return $this;
    }

    /**
     * Gets appID.
     *
     * @return string
     */
    public function getAppID()
    {
        return $this->container['appID'] ?? null;
    }

    /**
     * Sets appID.
     *
     * @param string $appID appID
     *
     * @return self
     */
    public function setAppID($appID)
    {
        $this->container['appID'] = $appID;

        return $this;
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
     * @param string $taskID the task UUID
     *
     * @return self
     */
    public function setTaskID($taskID)
    {
        $this->container['taskID'] = $taskID;

        return $this;
    }

    /**
     * Gets status.
     *
     * @return \Algolia\AlgoliaSearch\Model\Ingestion\RunStatus
     */
    public function getStatus()
    {
        return $this->container['status'] ?? null;
    }

    /**
     * Sets status.
     *
     * @param \Algolia\AlgoliaSearch\Model\Ingestion\RunStatus $status status
     *
     * @return self
     */
    public function setStatus($status)
    {
        $this->container['status'] = $status;

        return $this;
    }

    /**
     * Gets progress.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\RunProgress
     */
    public function getProgress()
    {
        return $this->container['progress'] ?? null;
    }

    /**
     * Sets progress.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\RunProgress $progress progress
     *
     * @return self
     */
    public function setProgress($progress)
    {
        $this->container['progress'] = $progress;

        return $this;
    }

    /**
     * Gets outcome.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\RunOutcome
     */
    public function getOutcome()
    {
        return $this->container['outcome'] ?? null;
    }

    /**
     * Sets outcome.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\RunOutcome $outcome outcome
     *
     * @return self
     */
    public function setOutcome($outcome)
    {
        $this->container['outcome'] = $outcome;

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
     * @param null|int $failureThreshold a percentage representing the accepted failure threshold to determine if a `run` succeeded or not
     *
     * @return self
     */
    public function setFailureThreshold($failureThreshold)
    {
        if (!is_null($failureThreshold) && ($failureThreshold > 100)) {
            throw new \InvalidArgumentException('invalid value for $failureThreshold when calling Run., must be smaller than or equal to 100.');
        }
        if (!is_null($failureThreshold) && ($failureThreshold < 0)) {
            throw new \InvalidArgumentException('invalid value for $failureThreshold when calling Run., must be bigger than or equal to 0.');
        }

        $this->container['failureThreshold'] = $failureThreshold;

        return $this;
    }

    /**
     * Gets reason.
     *
     * @return null|string
     */
    public function getReason()
    {
        return $this->container['reason'] ?? null;
    }

    /**
     * Sets reason.
     *
     * @param null|string $reason explains the result of outcome
     *
     * @return self
     */
    public function setReason($reason)
    {
        $this->container['reason'] = $reason;

        return $this;
    }

    /**
     * Gets reasonCode.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\RunReasonCode
     */
    public function getReasonCode()
    {
        return $this->container['reasonCode'] ?? null;
    }

    /**
     * Sets reasonCode.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\RunReasonCode $reasonCode reasonCode
     *
     * @return self
     */
    public function setReasonCode($reasonCode)
    {
        $this->container['reasonCode'] = $reasonCode;

        return $this;
    }

    /**
     * Gets type.
     *
     * @return \Algolia\AlgoliaSearch\Model\Ingestion\RunType
     */
    public function getType()
    {
        return $this->container['type'] ?? null;
    }

    /**
     * Sets type.
     *
     * @param \Algolia\AlgoliaSearch\Model\Ingestion\RunType $type type
     *
     * @return self
     */
    public function setType($type)
    {
        $this->container['type'] = $type;

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
     * @param string $createdAt date of creation (RFC3339 format)
     *
     * @return self
     */
    public function setCreatedAt($createdAt)
    {
        $this->container['createdAt'] = $createdAt;

        return $this;
    }

    /**
     * Gets startedAt.
     *
     * @return null|string
     */
    public function getStartedAt()
    {
        return $this->container['startedAt'] ?? null;
    }

    /**
     * Sets startedAt.
     *
     * @param null|string $startedAt date of start (RFC3339 format)
     *
     * @return self
     */
    public function setStartedAt($startedAt)
    {
        $this->container['startedAt'] = $startedAt;

        return $this;
    }

    /**
     * Gets finishedAt.
     *
     * @return null|string
     */
    public function getFinishedAt()
    {
        return $this->container['finishedAt'] ?? null;
    }

    /**
     * Sets finishedAt.
     *
     * @param null|string $finishedAt date of finish (RFC3339 format)
     *
     * @return self
     */
    public function setFinishedAt($finishedAt)
    {
        $this->container['finishedAt'] = $finishedAt;

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
