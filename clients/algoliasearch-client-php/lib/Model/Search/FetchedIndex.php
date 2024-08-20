<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * FetchedIndex Class Doc Comment.
 *
 * @category Class
 */
class FetchedIndex extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'name' => 'string',
        'createdAt' => 'string',
        'updatedAt' => 'string',
        'entries' => 'int',
        'dataSize' => 'int',
        'fileSize' => 'int',
        'lastBuildTimeS' => 'int',
        'numberOfPendingTasks' => 'int',
        'pendingTask' => 'bool',
        'primary' => 'string',
        'replicas' => 'string[]',
        'virtual' => 'bool',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'name' => null,
        'createdAt' => null,
        'updatedAt' => null,
        'entries' => null,
        'dataSize' => null,
        'fileSize' => null,
        'lastBuildTimeS' => null,
        'numberOfPendingTasks' => null,
        'pendingTask' => null,
        'primary' => null,
        'replicas' => null,
        'virtual' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'name' => 'name',
        'createdAt' => 'createdAt',
        'updatedAt' => 'updatedAt',
        'entries' => 'entries',
        'dataSize' => 'dataSize',
        'fileSize' => 'fileSize',
        'lastBuildTimeS' => 'lastBuildTimeS',
        'numberOfPendingTasks' => 'numberOfPendingTasks',
        'pendingTask' => 'pendingTask',
        'primary' => 'primary',
        'replicas' => 'replicas',
        'virtual' => 'virtual',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'name' => 'setName',
        'createdAt' => 'setCreatedAt',
        'updatedAt' => 'setUpdatedAt',
        'entries' => 'setEntries',
        'dataSize' => 'setDataSize',
        'fileSize' => 'setFileSize',
        'lastBuildTimeS' => 'setLastBuildTimeS',
        'numberOfPendingTasks' => 'setNumberOfPendingTasks',
        'pendingTask' => 'setPendingTask',
        'primary' => 'setPrimary',
        'replicas' => 'setReplicas',
        'virtual' => 'setVirtual',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'name' => 'getName',
        'createdAt' => 'getCreatedAt',
        'updatedAt' => 'getUpdatedAt',
        'entries' => 'getEntries',
        'dataSize' => 'getDataSize',
        'fileSize' => 'getFileSize',
        'lastBuildTimeS' => 'getLastBuildTimeS',
        'numberOfPendingTasks' => 'getNumberOfPendingTasks',
        'pendingTask' => 'getPendingTask',
        'primary' => 'getPrimary',
        'replicas' => 'getReplicas',
        'virtual' => 'getVirtual',
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
        if (isset($data['name'])) {
            $this->container['name'] = $data['name'];
        }
        if (isset($data['createdAt'])) {
            $this->container['createdAt'] = $data['createdAt'];
        }
        if (isset($data['updatedAt'])) {
            $this->container['updatedAt'] = $data['updatedAt'];
        }
        if (isset($data['entries'])) {
            $this->container['entries'] = $data['entries'];
        }
        if (isset($data['dataSize'])) {
            $this->container['dataSize'] = $data['dataSize'];
        }
        if (isset($data['fileSize'])) {
            $this->container['fileSize'] = $data['fileSize'];
        }
        if (isset($data['lastBuildTimeS'])) {
            $this->container['lastBuildTimeS'] = $data['lastBuildTimeS'];
        }
        if (isset($data['numberOfPendingTasks'])) {
            $this->container['numberOfPendingTasks'] = $data['numberOfPendingTasks'];
        }
        if (isset($data['pendingTask'])) {
            $this->container['pendingTask'] = $data['pendingTask'];
        }
        if (isset($data['primary'])) {
            $this->container['primary'] = $data['primary'];
        }
        if (isset($data['replicas'])) {
            $this->container['replicas'] = $data['replicas'];
        }
        if (isset($data['virtual'])) {
            $this->container['virtual'] = $data['virtual'];
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

        if (!isset($this->container['name']) || null === $this->container['name']) {
            $invalidProperties[] = "'name' can't be null";
        }
        if (!isset($this->container['createdAt']) || null === $this->container['createdAt']) {
            $invalidProperties[] = "'createdAt' can't be null";
        }
        if (!isset($this->container['updatedAt']) || null === $this->container['updatedAt']) {
            $invalidProperties[] = "'updatedAt' can't be null";
        }
        if (!isset($this->container['entries']) || null === $this->container['entries']) {
            $invalidProperties[] = "'entries' can't be null";
        }
        if (!isset($this->container['dataSize']) || null === $this->container['dataSize']) {
            $invalidProperties[] = "'dataSize' can't be null";
        }
        if (!isset($this->container['fileSize']) || null === $this->container['fileSize']) {
            $invalidProperties[] = "'fileSize' can't be null";
        }
        if (!isset($this->container['lastBuildTimeS']) || null === $this->container['lastBuildTimeS']) {
            $invalidProperties[] = "'lastBuildTimeS' can't be null";
        }
        if (!isset($this->container['numberOfPendingTasks']) || null === $this->container['numberOfPendingTasks']) {
            $invalidProperties[] = "'numberOfPendingTasks' can't be null";
        }
        if (!isset($this->container['pendingTask']) || null === $this->container['pendingTask']) {
            $invalidProperties[] = "'pendingTask' can't be null";
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
     * Gets name.
     *
     * @return string
     */
    public function getName()
    {
        return $this->container['name'] ?? null;
    }

    /**
     * Sets name.
     *
     * @param string $name index name
     *
     * @return self
     */
    public function setName($name)
    {
        $this->container['name'] = $name;

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
     * @param string $createdAt Index creation date. An empty string means that the index has no records.
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
     * @return string
     */
    public function getUpdatedAt()
    {
        return $this->container['updatedAt'] ?? null;
    }

    /**
     * Sets updatedAt.
     *
     * @param string $updatedAt date and time when the object was updated, in RFC 3339 format
     *
     * @return self
     */
    public function setUpdatedAt($updatedAt)
    {
        $this->container['updatedAt'] = $updatedAt;

        return $this;
    }

    /**
     * Gets entries.
     *
     * @return int
     */
    public function getEntries()
    {
        return $this->container['entries'] ?? null;
    }

    /**
     * Sets entries.
     *
     * @param int $entries number of records contained in the index
     *
     * @return self
     */
    public function setEntries($entries)
    {
        $this->container['entries'] = $entries;

        return $this;
    }

    /**
     * Gets dataSize.
     *
     * @return int
     */
    public function getDataSize()
    {
        return $this->container['dataSize'] ?? null;
    }

    /**
     * Sets dataSize.
     *
     * @param int $dataSize number of bytes of the index in minified format
     *
     * @return self
     */
    public function setDataSize($dataSize)
    {
        $this->container['dataSize'] = $dataSize;

        return $this;
    }

    /**
     * Gets fileSize.
     *
     * @return int
     */
    public function getFileSize()
    {
        return $this->container['fileSize'] ?? null;
    }

    /**
     * Sets fileSize.
     *
     * @param int $fileSize number of bytes of the index binary file
     *
     * @return self
     */
    public function setFileSize($fileSize)
    {
        $this->container['fileSize'] = $fileSize;

        return $this;
    }

    /**
     * Gets lastBuildTimeS.
     *
     * @return int
     */
    public function getLastBuildTimeS()
    {
        return $this->container['lastBuildTimeS'] ?? null;
    }

    /**
     * Sets lastBuildTimeS.
     *
     * @param int $lastBuildTimeS last build time
     *
     * @return self
     */
    public function setLastBuildTimeS($lastBuildTimeS)
    {
        $this->container['lastBuildTimeS'] = $lastBuildTimeS;

        return $this;
    }

    /**
     * Gets numberOfPendingTasks.
     *
     * @return int
     */
    public function getNumberOfPendingTasks()
    {
        return $this->container['numberOfPendingTasks'] ?? null;
    }

    /**
     * Sets numberOfPendingTasks.
     *
     * @param int $numberOfPendingTasks Number of pending indexing operations. This value is deprecated and should not be used.
     *
     * @return self
     */
    public function setNumberOfPendingTasks($numberOfPendingTasks)
    {
        $this->container['numberOfPendingTasks'] = $numberOfPendingTasks;

        return $this;
    }

    /**
     * Gets pendingTask.
     *
     * @return bool
     */
    public function getPendingTask()
    {
        return $this->container['pendingTask'] ?? null;
    }

    /**
     * Sets pendingTask.
     *
     * @param bool $pendingTask A boolean which says whether the index has pending tasks. This value is deprecated and should not be used.
     *
     * @return self
     */
    public function setPendingTask($pendingTask)
    {
        $this->container['pendingTask'] = $pendingTask;

        return $this;
    }

    /**
     * Gets primary.
     *
     * @return null|string
     */
    public function getPrimary()
    {
        return $this->container['primary'] ?? null;
    }

    /**
     * Sets primary.
     *
     * @param null|string $primary Only present if the index is a replica. Contains the name of the related primary index.
     *
     * @return self
     */
    public function setPrimary($primary)
    {
        $this->container['primary'] = $primary;

        return $this;
    }

    /**
     * Gets replicas.
     *
     * @return null|string[]
     */
    public function getReplicas()
    {
        return $this->container['replicas'] ?? null;
    }

    /**
     * Sets replicas.
     *
     * @param null|string[] $replicas Only present if the index is a primary index with replicas. Contains the names of all linked replicas.
     *
     * @return self
     */
    public function setReplicas($replicas)
    {
        $this->container['replicas'] = $replicas;

        return $this;
    }

    /**
     * Gets virtual.
     *
     * @return null|bool
     */
    public function getVirtual()
    {
        return $this->container['virtual'] ?? null;
    }

    /**
     * Sets virtual.
     *
     * @param null|bool $virtual Only present if the index is a [virtual replica](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/how-to/sort-an-index-alphabetically/#virtual-replicas).
     *
     * @return self
     */
    public function setVirtual($virtual)
    {
        $this->container['virtual'] = $virtual;

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
