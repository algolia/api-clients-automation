<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * RunSourcePayload Class Doc Comment.
 *
 * @category Class
 */
class RunSourcePayload extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'indexToInclude' => 'string[]',
        'indexToExclude' => 'string[]',
        'entityIDs' => 'string[]',
        'entityType' => '\Algolia\AlgoliaSearch\Model\Ingestion\EntityType',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'indexToInclude' => null,
        'indexToExclude' => null,
        'entityIDs' => null,
        'entityType' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'indexToInclude' => 'indexToInclude',
        'indexToExclude' => 'indexToExclude',
        'entityIDs' => 'entityIDs',
        'entityType' => 'entityType',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'indexToInclude' => 'setIndexToInclude',
        'indexToExclude' => 'setIndexToExclude',
        'entityIDs' => 'setEntityIDs',
        'entityType' => 'setEntityType',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'indexToInclude' => 'getIndexToInclude',
        'indexToExclude' => 'getIndexToExclude',
        'entityIDs' => 'getEntityIDs',
        'entityType' => 'getEntityType',
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
        if (isset($data['indexToInclude'])) {
            $this->container['indexToInclude'] = $data['indexToInclude'];
        }
        if (isset($data['indexToExclude'])) {
            $this->container['indexToExclude'] = $data['indexToExclude'];
        }
        if (isset($data['entityIDs'])) {
            $this->container['entityIDs'] = $data['entityIDs'];
        }
        if (isset($data['entityType'])) {
            $this->container['entityType'] = $data['entityType'];
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
     * Gets indexToInclude.
     *
     * @return null|string[]
     */
    public function getIndexToInclude()
    {
        return $this->container['indexToInclude'] ?? null;
    }

    /**
     * Sets indexToInclude.
     *
     * @param null|string[] $indexToInclude list of index names to include in reidexing/update
     *
     * @return self
     */
    public function setIndexToInclude($indexToInclude)
    {
        $this->container['indexToInclude'] = $indexToInclude;

        return $this;
    }

    /**
     * Gets indexToExclude.
     *
     * @return null|string[]
     */
    public function getIndexToExclude()
    {
        return $this->container['indexToExclude'] ?? null;
    }

    /**
     * Sets indexToExclude.
     *
     * @param null|string[] $indexToExclude list of index names to exclude in reidexing/update
     *
     * @return self
     */
    public function setIndexToExclude($indexToExclude)
    {
        $this->container['indexToExclude'] = $indexToExclude;

        return $this;
    }

    /**
     * Gets entityIDs.
     *
     * @return null|string[]
     */
    public function getEntityIDs()
    {
        return $this->container['entityIDs'] ?? null;
    }

    /**
     * Sets entityIDs.
     *
     * @param null|string[] $entityIDs list of entityID to update
     *
     * @return self
     */
    public function setEntityIDs($entityIDs)
    {
        $this->container['entityIDs'] = $entityIDs;

        return $this;
    }

    /**
     * Gets entityType.
     *
     * @return null|EntityType
     */
    public function getEntityType()
    {
        return $this->container['entityType'] ?? null;
    }

    /**
     * Sets entityType.
     *
     * @param null|EntityType $entityType entityType
     *
     * @return self
     */
    public function setEntityType($entityType)
    {
        $this->container['entityType'] = $entityType;

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
