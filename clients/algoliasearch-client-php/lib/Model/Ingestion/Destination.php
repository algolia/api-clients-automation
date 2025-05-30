<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * Destination Class Doc Comment.
 *
 * @category Class
 *
 * @description Destinations are Algolia resources like indices or event streams.
 */
class Destination extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'destinationID' => 'string',
        'type' => '\Algolia\AlgoliaSearch\Model\Ingestion\DestinationType',
        'name' => 'string',
        'owner' => 'string',
        'input' => '\Algolia\AlgoliaSearch\Model\Ingestion\DestinationInput',
        'createdAt' => 'string',
        'updatedAt' => 'string',
        'authenticationID' => 'string',
        'transformationIDs' => 'string[]',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'destinationID' => null,
        'type' => null,
        'name' => null,
        'owner' => null,
        'input' => null,
        'createdAt' => null,
        'updatedAt' => null,
        'authenticationID' => null,
        'transformationIDs' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'destinationID' => 'destinationID',
        'type' => 'type',
        'name' => 'name',
        'owner' => 'owner',
        'input' => 'input',
        'createdAt' => 'createdAt',
        'updatedAt' => 'updatedAt',
        'authenticationID' => 'authenticationID',
        'transformationIDs' => 'transformationIDs',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'destinationID' => 'setDestinationID',
        'type' => 'setType',
        'name' => 'setName',
        'owner' => 'setOwner',
        'input' => 'setInput',
        'createdAt' => 'setCreatedAt',
        'updatedAt' => 'setUpdatedAt',
        'authenticationID' => 'setAuthenticationID',
        'transformationIDs' => 'setTransformationIDs',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'destinationID' => 'getDestinationID',
        'type' => 'getType',
        'name' => 'getName',
        'owner' => 'getOwner',
        'input' => 'getInput',
        'createdAt' => 'getCreatedAt',
        'updatedAt' => 'getUpdatedAt',
        'authenticationID' => 'getAuthenticationID',
        'transformationIDs' => 'getTransformationIDs',
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
        if (isset($data['destinationID'])) {
            $this->container['destinationID'] = $data['destinationID'];
        }
        if (isset($data['type'])) {
            $this->container['type'] = $data['type'];
        }
        if (isset($data['name'])) {
            $this->container['name'] = $data['name'];
        }
        if (isset($data['owner'])) {
            $this->container['owner'] = $data['owner'];
        }
        if (isset($data['input'])) {
            $this->container['input'] = $data['input'];
        }
        if (isset($data['createdAt'])) {
            $this->container['createdAt'] = $data['createdAt'];
        }
        if (isset($data['updatedAt'])) {
            $this->container['updatedAt'] = $data['updatedAt'];
        }
        if (isset($data['authenticationID'])) {
            $this->container['authenticationID'] = $data['authenticationID'];
        }
        if (isset($data['transformationIDs'])) {
            $this->container['transformationIDs'] = $data['transformationIDs'];
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

        if (!isset($this->container['destinationID']) || null === $this->container['destinationID']) {
            $invalidProperties[] = "'destinationID' can't be null";
        }
        if (!isset($this->container['type']) || null === $this->container['type']) {
            $invalidProperties[] = "'type' can't be null";
        }
        if (!isset($this->container['name']) || null === $this->container['name']) {
            $invalidProperties[] = "'name' can't be null";
        }
        if (!isset($this->container['input']) || null === $this->container['input']) {
            $invalidProperties[] = "'input' can't be null";
        }
        if (!isset($this->container['createdAt']) || null === $this->container['createdAt']) {
            $invalidProperties[] = "'createdAt' can't be null";
        }
        if (!isset($this->container['updatedAt']) || null === $this->container['updatedAt']) {
            $invalidProperties[] = "'updatedAt' can't be null";
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
     * Gets type.
     *
     * @return DestinationType
     */
    public function getType()
    {
        return $this->container['type'] ?? null;
    }

    /**
     * Sets type.
     *
     * @param DestinationType $type type
     *
     * @return self
     */
    public function setType($type)
    {
        $this->container['type'] = $type;

        return $this;
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
     * @param string $name descriptive name for the resource
     *
     * @return self
     */
    public function setName($name)
    {
        $this->container['name'] = $name;

        return $this;
    }

    /**
     * Gets owner.
     *
     * @return null|string
     */
    public function getOwner()
    {
        return $this->container['owner'] ?? null;
    }

    /**
     * Sets owner.
     *
     * @param null|string $owner owner of the resource
     *
     * @return self
     */
    public function setOwner($owner)
    {
        $this->container['owner'] = $owner;

        return $this;
    }

    /**
     * Gets input.
     *
     * @return DestinationInput
     */
    public function getInput()
    {
        return $this->container['input'] ?? null;
    }

    /**
     * Sets input.
     *
     * @param DestinationInput $input input
     *
     * @return self
     */
    public function setInput($input)
    {
        $this->container['input'] = $input;

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
     * @return string
     */
    public function getUpdatedAt()
    {
        return $this->container['updatedAt'] ?? null;
    }

    /**
     * Sets updatedAt.
     *
     * @param string $updatedAt date of last update in RFC 3339 format
     *
     * @return self
     */
    public function setUpdatedAt($updatedAt)
    {
        $this->container['updatedAt'] = $updatedAt;

        return $this;
    }

    /**
     * Gets authenticationID.
     *
     * @return null|string
     */
    public function getAuthenticationID()
    {
        return $this->container['authenticationID'] ?? null;
    }

    /**
     * Sets authenticationID.
     *
     * @param null|string $authenticationID universally unique identifier (UUID) of an authentication resource
     *
     * @return self
     */
    public function setAuthenticationID($authenticationID)
    {
        $this->container['authenticationID'] = $authenticationID;

        return $this;
    }

    /**
     * Gets transformationIDs.
     *
     * @return null|string[]
     */
    public function getTransformationIDs()
    {
        return $this->container['transformationIDs'] ?? null;
    }

    /**
     * Sets transformationIDs.
     *
     * @param null|string[] $transformationIDs transformationIDs
     *
     * @return self
     */
    public function setTransformationIDs($transformationIDs)
    {
        $this->container['transformationIDs'] = $transformationIDs;

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
