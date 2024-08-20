<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Monitoring;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * Metrics Class Doc Comment.
 *
 * @category Class
 */
class Metrics extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'cpuUsage' => 'array<string,array>',
        'ramIndexingUsage' => 'array<string,array>',
        'ramSearchUsage' => 'array<string,array>',
        'ssdUsage' => 'array<string,array>',
        'avgBuildTime' => 'array<string,array>',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'cpuUsage' => null,
        'ramIndexingUsage' => null,
        'ramSearchUsage' => null,
        'ssdUsage' => null,
        'avgBuildTime' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'cpuUsage' => 'cpu_usage',
        'ramIndexingUsage' => 'ram_indexing_usage',
        'ramSearchUsage' => 'ram_search_usage',
        'ssdUsage' => 'ssd_usage',
        'avgBuildTime' => 'avg_build_time',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'cpuUsage' => 'setCpuUsage',
        'ramIndexingUsage' => 'setRamIndexingUsage',
        'ramSearchUsage' => 'setRamSearchUsage',
        'ssdUsage' => 'setSsdUsage',
        'avgBuildTime' => 'setAvgBuildTime',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'cpuUsage' => 'getCpuUsage',
        'ramIndexingUsage' => 'getRamIndexingUsage',
        'ramSearchUsage' => 'getRamSearchUsage',
        'ssdUsage' => 'getSsdUsage',
        'avgBuildTime' => 'getAvgBuildTime',
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
        if (isset($data['cpuUsage'])) {
            $this->container['cpuUsage'] = $data['cpuUsage'];
        }
        if (isset($data['ramIndexingUsage'])) {
            $this->container['ramIndexingUsage'] = $data['ramIndexingUsage'];
        }
        if (isset($data['ramSearchUsage'])) {
            $this->container['ramSearchUsage'] = $data['ramSearchUsage'];
        }
        if (isset($data['ssdUsage'])) {
            $this->container['ssdUsage'] = $data['ssdUsage'];
        }
        if (isset($data['avgBuildTime'])) {
            $this->container['avgBuildTime'] = $data['avgBuildTime'];
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
     * Gets cpuUsage.
     *
     * @return null|array<string,array>
     */
    public function getCpuUsage()
    {
        return $this->container['cpuUsage'] ?? null;
    }

    /**
     * Sets cpuUsage.
     *
     * @param null|array<string,array> $cpuUsage CPU idleness in %
     *
     * @return self
     */
    public function setCpuUsage($cpuUsage)
    {
        $this->container['cpuUsage'] = $cpuUsage;

        return $this;
    }

    /**
     * Gets ramIndexingUsage.
     *
     * @return null|array<string,array>
     */
    public function getRamIndexingUsage()
    {
        return $this->container['ramIndexingUsage'] ?? null;
    }

    /**
     * Sets ramIndexingUsage.
     *
     * @param null|array<string,array> $ramIndexingUsage RAM used for indexing in MB
     *
     * @return self
     */
    public function setRamIndexingUsage($ramIndexingUsage)
    {
        $this->container['ramIndexingUsage'] = $ramIndexingUsage;

        return $this;
    }

    /**
     * Gets ramSearchUsage.
     *
     * @return null|array<string,array>
     */
    public function getRamSearchUsage()
    {
        return $this->container['ramSearchUsage'] ?? null;
    }

    /**
     * Sets ramSearchUsage.
     *
     * @param null|array<string,array> $ramSearchUsage RAM used for search in MB
     *
     * @return self
     */
    public function setRamSearchUsage($ramSearchUsage)
    {
        $this->container['ramSearchUsage'] = $ramSearchUsage;

        return $this;
    }

    /**
     * Gets ssdUsage.
     *
     * @return null|array<string,array>
     */
    public function getSsdUsage()
    {
        return $this->container['ssdUsage'] ?? null;
    }

    /**
     * Sets ssdUsage.
     *
     * @param null|array<string,array> $ssdUsage Solid-state disk (SSD) usage expressed as % of RAM.  0% means no SSD usage. A value of 50% indicates 32&nbsp;GB SSD usage for a machine with 64&nbsp;RAM.
     *
     * @return self
     */
    public function setSsdUsage($ssdUsage)
    {
        $this->container['ssdUsage'] = $ssdUsage;

        return $this;
    }

    /**
     * Gets avgBuildTime.
     *
     * @return null|array<string,array>
     */
    public function getAvgBuildTime()
    {
        return $this->container['avgBuildTime'] ?? null;
    }

    /**
     * Sets avgBuildTime.
     *
     * @param null|array<string,array> $avgBuildTime average build time of the indices in seconds
     *
     * @return self
     */
    public function setAvgBuildTime($avgBuildTime)
    {
        $this->container['avgBuildTime'] = $avgBuildTime;

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
