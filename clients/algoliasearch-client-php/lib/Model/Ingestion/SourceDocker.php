<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * SourceDocker Class Doc Comment.
 *
 * @category Class
 */
class SourceDocker extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'imageType' => '\Algolia\AlgoliaSearch\Model\Ingestion\DockerImageType',
        'registry' => '\Algolia\AlgoliaSearch\Model\Ingestion\DockerRegistry',
        'image' => 'string',
        'version' => 'string',
        'configuration' => 'object',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'imageType' => null,
        'registry' => null,
        'image' => null,
        'version' => null,
        'configuration' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'imageType' => 'imageType',
        'registry' => 'registry',
        'image' => 'image',
        'version' => 'version',
        'configuration' => 'configuration',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'imageType' => 'setImageType',
        'registry' => 'setRegistry',
        'image' => 'setImage',
        'version' => 'setVersion',
        'configuration' => 'setConfiguration',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'imageType' => 'getImageType',
        'registry' => 'getRegistry',
        'image' => 'getImage',
        'version' => 'getVersion',
        'configuration' => 'getConfiguration',
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
        if (isset($data['imageType'])) {
            $this->container['imageType'] = $data['imageType'];
        }
        if (isset($data['registry'])) {
            $this->container['registry'] = $data['registry'];
        }
        if (isset($data['image'])) {
            $this->container['image'] = $data['image'];
        }
        if (isset($data['version'])) {
            $this->container['version'] = $data['version'];
        }
        if (isset($data['configuration'])) {
            $this->container['configuration'] = $data['configuration'];
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

        if (!isset($this->container['imageType']) || null === $this->container['imageType']) {
            $invalidProperties[] = "'imageType' can't be null";
        }
        if (!isset($this->container['registry']) || null === $this->container['registry']) {
            $invalidProperties[] = "'registry' can't be null";
        }
        if (!isset($this->container['image']) || null === $this->container['image']) {
            $invalidProperties[] = "'image' can't be null";
        }
        if (!isset($this->container['configuration']) || null === $this->container['configuration']) {
            $invalidProperties[] = "'configuration' can't be null";
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
     * Gets imageType.
     *
     * @return \Algolia\AlgoliaSearch\Model\Ingestion\DockerImageType
     */
    public function getImageType()
    {
        return $this->container['imageType'] ?? null;
    }

    /**
     * Sets imageType.
     *
     * @param \Algolia\AlgoliaSearch\Model\Ingestion\DockerImageType $imageType imageType
     *
     * @return self
     */
    public function setImageType($imageType)
    {
        $this->container['imageType'] = $imageType;

        return $this;
    }

    /**
     * Gets registry.
     *
     * @return \Algolia\AlgoliaSearch\Model\Ingestion\DockerRegistry
     */
    public function getRegistry()
    {
        return $this->container['registry'] ?? null;
    }

    /**
     * Sets registry.
     *
     * @param \Algolia\AlgoliaSearch\Model\Ingestion\DockerRegistry $registry registry
     *
     * @return self
     */
    public function setRegistry($registry)
    {
        $this->container['registry'] = $registry;

        return $this;
    }

    /**
     * Gets image.
     *
     * @return string
     */
    public function getImage()
    {
        return $this->container['image'] ?? null;
    }

    /**
     * Sets image.
     *
     * @param string $image docker image name
     *
     * @return self
     */
    public function setImage($image)
    {
        $this->container['image'] = $image;

        return $this;
    }

    /**
     * Gets version.
     *
     * @return null|string
     */
    public function getVersion()
    {
        return $this->container['version'] ?? null;
    }

    /**
     * Sets version.
     *
     * @param null|string $version docker image version
     *
     * @return self
     */
    public function setVersion($version)
    {
        $this->container['version'] = $version;

        return $this;
    }

    /**
     * Gets configuration.
     *
     * @return object
     */
    public function getConfiguration()
    {
        return $this->container['configuration'] ?? null;
    }

    /**
     * Sets configuration.
     *
     * @param object $configuration configuration of the spec
     *
     * @return self
     */
    public function setConfiguration($configuration)
    {
        $this->container['configuration'] = $configuration;

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
