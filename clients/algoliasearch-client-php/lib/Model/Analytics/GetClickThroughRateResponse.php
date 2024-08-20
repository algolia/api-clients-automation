<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Analytics;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * GetClickThroughRateResponse Class Doc Comment.
 *
 * @category Class
 */
class GetClickThroughRateResponse extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'rate' => 'float',
        'clickCount' => 'int',
        'trackedSearchCount' => 'int',
        'dates' => '\Algolia\AlgoliaSearch\Model\Analytics\DailyClickThroughRates[]',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'rate' => 'double',
        'clickCount' => null,
        'trackedSearchCount' => null,
        'dates' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'rate' => 'rate',
        'clickCount' => 'clickCount',
        'trackedSearchCount' => 'trackedSearchCount',
        'dates' => 'dates',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'rate' => 'setRate',
        'clickCount' => 'setClickCount',
        'trackedSearchCount' => 'setTrackedSearchCount',
        'dates' => 'setDates',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'rate' => 'getRate',
        'clickCount' => 'getClickCount',
        'trackedSearchCount' => 'getTrackedSearchCount',
        'dates' => 'getDates',
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
        if (isset($data['rate'])) {
            $this->container['rate'] = $data['rate'];
        }
        if (isset($data['clickCount'])) {
            $this->container['clickCount'] = $data['clickCount'];
        }
        if (isset($data['trackedSearchCount'])) {
            $this->container['trackedSearchCount'] = $data['trackedSearchCount'];
        }
        if (isset($data['dates'])) {
            $this->container['dates'] = $data['dates'];
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

        if (!isset($this->container['rate']) || null === $this->container['rate']) {
            $invalidProperties[] = "'rate' can't be null";
        }
        if ($this->container['rate'] > 1) {
            $invalidProperties[] = "invalid value for 'rate', must be smaller than or equal to 1.";
        }

        if ($this->container['rate'] < 0) {
            $invalidProperties[] = "invalid value for 'rate', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['clickCount']) || null === $this->container['clickCount']) {
            $invalidProperties[] = "'clickCount' can't be null";
        }
        if ($this->container['clickCount'] < 0) {
            $invalidProperties[] = "invalid value for 'clickCount', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['trackedSearchCount']) || null === $this->container['trackedSearchCount']) {
            $invalidProperties[] = "'trackedSearchCount' can't be null";
        }
        if (!isset($this->container['dates']) || null === $this->container['dates']) {
            $invalidProperties[] = "'dates' can't be null";
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
     * Gets rate.
     *
     * @return float
     */
    public function getRate()
    {
        return $this->container['rate'] ?? null;
    }

    /**
     * Sets rate.
     *
     * @param float $rate Click-through rate, calculated as number of tracked searches with at least one click event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setRate($rate)
    {
        if ($rate > 1) {
            throw new \InvalidArgumentException('invalid value for $rate when calling GetClickThroughRateResponse., must be smaller than or equal to 1.');
        }
        if ($rate < 0) {
            throw new \InvalidArgumentException('invalid value for $rate when calling GetClickThroughRateResponse., must be bigger than or equal to 0.');
        }

        $this->container['rate'] = $rate;

        return $this;
    }

    /**
     * Gets clickCount.
     *
     * @return int
     */
    public function getClickCount()
    {
        return $this->container['clickCount'] ?? null;
    }

    /**
     * Sets clickCount.
     *
     * @param int $clickCount number of clicks associated with this search
     *
     * @return self
     */
    public function setClickCount($clickCount)
    {
        if ($clickCount < 0) {
            throw new \InvalidArgumentException('invalid value for $clickCount when calling GetClickThroughRateResponse., must be bigger than or equal to 0.');
        }

        $this->container['clickCount'] = $clickCount;

        return $this;
    }

    /**
     * Gets trackedSearchCount.
     *
     * @return int
     */
    public function getTrackedSearchCount()
    {
        return $this->container['trackedSearchCount'] ?? null;
    }

    /**
     * Sets trackedSearchCount.
     *
     * @param int $trackedSearchCount Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
     *
     * @return self
     */
    public function setTrackedSearchCount($trackedSearchCount)
    {
        $this->container['trackedSearchCount'] = $trackedSearchCount;

        return $this;
    }

    /**
     * Gets dates.
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\DailyClickThroughRates[]
     */
    public function getDates()
    {
        return $this->container['dates'] ?? null;
    }

    /**
     * Sets dates.
     *
     * @param \Algolia\AlgoliaSearch\Model\Analytics\DailyClickThroughRates[] $dates daily click-through rates
     *
     * @return self
     */
    public function setDates($dates)
    {
        $this->container['dates'] = $dates;

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
