<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Analytics;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * TopHitWithRevenueAnalytics Class Doc Comment.
 *
 * @category Class
 */
class TopHitWithRevenueAnalytics extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'hit' => 'string',
        'count' => 'int',
        'clickThroughRate' => 'float',
        'conversionRate' => 'float',
        'trackedHitCount' => 'int',
        'clickCount' => 'int',
        'conversionCount' => 'int',
        'addToCartRate' => 'float',
        'addToCartCount' => 'int',
        'purchaseRate' => 'float',
        'purchaseCount' => 'int',
        'currencies' => 'array<string,\Algolia\AlgoliaSearch\Model\Analytics\CurrencyCode>',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'hit' => null,
        'count' => null,
        'clickThroughRate' => 'double',
        'conversionRate' => 'double',
        'trackedHitCount' => null,
        'clickCount' => null,
        'conversionCount' => null,
        'addToCartRate' => 'double',
        'addToCartCount' => null,
        'purchaseRate' => 'double',
        'purchaseCount' => null,
        'currencies' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'hit' => 'hit',
        'count' => 'count',
        'clickThroughRate' => 'clickThroughRate',
        'conversionRate' => 'conversionRate',
        'trackedHitCount' => 'trackedHitCount',
        'clickCount' => 'clickCount',
        'conversionCount' => 'conversionCount',
        'addToCartRate' => 'addToCartRate',
        'addToCartCount' => 'addToCartCount',
        'purchaseRate' => 'purchaseRate',
        'purchaseCount' => 'purchaseCount',
        'currencies' => 'currencies',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'hit' => 'setHit',
        'count' => 'setCount',
        'clickThroughRate' => 'setClickThroughRate',
        'conversionRate' => 'setConversionRate',
        'trackedHitCount' => 'setTrackedHitCount',
        'clickCount' => 'setClickCount',
        'conversionCount' => 'setConversionCount',
        'addToCartRate' => 'setAddToCartRate',
        'addToCartCount' => 'setAddToCartCount',
        'purchaseRate' => 'setPurchaseRate',
        'purchaseCount' => 'setPurchaseCount',
        'currencies' => 'setCurrencies',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'hit' => 'getHit',
        'count' => 'getCount',
        'clickThroughRate' => 'getClickThroughRate',
        'conversionRate' => 'getConversionRate',
        'trackedHitCount' => 'getTrackedHitCount',
        'clickCount' => 'getClickCount',
        'conversionCount' => 'getConversionCount',
        'addToCartRate' => 'getAddToCartRate',
        'addToCartCount' => 'getAddToCartCount',
        'purchaseRate' => 'getPurchaseRate',
        'purchaseCount' => 'getPurchaseCount',
        'currencies' => 'getCurrencies',
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
        if (isset($data['hit'])) {
            $this->container['hit'] = $data['hit'];
        }
        if (isset($data['count'])) {
            $this->container['count'] = $data['count'];
        }
        if (isset($data['clickThroughRate'])) {
            $this->container['clickThroughRate'] = $data['clickThroughRate'];
        }
        if (isset($data['conversionRate'])) {
            $this->container['conversionRate'] = $data['conversionRate'];
        }
        if (isset($data['trackedHitCount'])) {
            $this->container['trackedHitCount'] = $data['trackedHitCount'];
        }
        if (isset($data['clickCount'])) {
            $this->container['clickCount'] = $data['clickCount'];
        }
        if (isset($data['conversionCount'])) {
            $this->container['conversionCount'] = $data['conversionCount'];
        }
        if (isset($data['addToCartRate'])) {
            $this->container['addToCartRate'] = $data['addToCartRate'];
        }
        if (isset($data['addToCartCount'])) {
            $this->container['addToCartCount'] = $data['addToCartCount'];
        }
        if (isset($data['purchaseRate'])) {
            $this->container['purchaseRate'] = $data['purchaseRate'];
        }
        if (isset($data['purchaseCount'])) {
            $this->container['purchaseCount'] = $data['purchaseCount'];
        }
        if (isset($data['currencies'])) {
            $this->container['currencies'] = $data['currencies'];
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

        if (!isset($this->container['hit']) || null === $this->container['hit']) {
            $invalidProperties[] = "'hit' can't be null";
        }
        if (!isset($this->container['count']) || null === $this->container['count']) {
            $invalidProperties[] = "'count' can't be null";
        }
        if (!isset($this->container['clickThroughRate']) || null === $this->container['clickThroughRate']) {
            $invalidProperties[] = "'clickThroughRate' can't be null";
        }
        if (!isset($this->container['conversionRate']) || null === $this->container['conversionRate']) {
            $invalidProperties[] = "'conversionRate' can't be null";
        }
        if (!isset($this->container['trackedHitCount']) || null === $this->container['trackedHitCount']) {
            $invalidProperties[] = "'trackedHitCount' can't be null";
        }
        if (!isset($this->container['clickCount']) || null === $this->container['clickCount']) {
            $invalidProperties[] = "'clickCount' can't be null";
        }
        if (!isset($this->container['conversionCount']) || null === $this->container['conversionCount']) {
            $invalidProperties[] = "'conversionCount' can't be null";
        }
        if (!isset($this->container['addToCartRate']) || null === $this->container['addToCartRate']) {
            $invalidProperties[] = "'addToCartRate' can't be null";
        }
        if (!isset($this->container['addToCartCount']) || null === $this->container['addToCartCount']) {
            $invalidProperties[] = "'addToCartCount' can't be null";
        }
        if (!isset($this->container['purchaseRate']) || null === $this->container['purchaseRate']) {
            $invalidProperties[] = "'purchaseRate' can't be null";
        }
        if (!isset($this->container['purchaseCount']) || null === $this->container['purchaseCount']) {
            $invalidProperties[] = "'purchaseCount' can't be null";
        }
        if (!isset($this->container['currencies']) || null === $this->container['currencies']) {
            $invalidProperties[] = "'currencies' can't be null";
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
     * Gets hit.
     *
     * @return string
     */
    public function getHit()
    {
        return $this->container['hit'] ?? null;
    }

    /**
     * Sets hit.
     *
     * @param string $hit object ID of a record returned as a search result
     *
     * @return self
     */
    public function setHit($hit)
    {
        $this->container['hit'] = $hit;

        return $this;
    }

    /**
     * Gets count.
     *
     * @return int
     */
    public function getCount()
    {
        return $this->container['count'] ?? null;
    }

    /**
     * Sets count.
     *
     * @param int $count number of occurrences
     *
     * @return self
     */
    public function setCount($count)
    {
        $this->container['count'] = $count;

        return $this;
    }

    /**
     * Gets clickThroughRate.
     *
     * @return float
     */
    public function getClickThroughRate()
    {
        return $this->container['clickThroughRate'] ?? null;
    }

    /**
     * Sets clickThroughRate.
     *
     * @param float $clickThroughRate Click-through rate: calculated as the number of tracked searches with at least one click event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setClickThroughRate($clickThroughRate)
    {
        $this->container['clickThroughRate'] = $clickThroughRate;

        return $this;
    }

    /**
     * Gets conversionRate.
     *
     * @return float
     */
    public function getConversionRate()
    {
        return $this->container['conversionRate'] ?? null;
    }

    /**
     * Sets conversionRate.
     *
     * @param float $conversionRate Conversion rate: calculated as the number of tracked searches with at least one conversion event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setConversionRate($conversionRate)
    {
        $this->container['conversionRate'] = $conversionRate;

        return $this;
    }

    /**
     * Gets trackedHitCount.
     *
     * @return int
     */
    public function getTrackedHitCount()
    {
        return $this->container['trackedHitCount'] ?? null;
    }

    /**
     * Sets trackedHitCount.
     *
     * @param int $trackedHitCount Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
     *
     * @return self
     */
    public function setTrackedHitCount($trackedHitCount)
    {
        $this->container['trackedHitCount'] = $trackedHitCount;

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
        $this->container['clickCount'] = $clickCount;

        return $this;
    }

    /**
     * Gets conversionCount.
     *
     * @return int
     */
    public function getConversionCount()
    {
        return $this->container['conversionCount'] ?? null;
    }

    /**
     * Sets conversionCount.
     *
     * @param int $conversionCount number of conversions from this search
     *
     * @return self
     */
    public function setConversionCount($conversionCount)
    {
        $this->container['conversionCount'] = $conversionCount;

        return $this;
    }

    /**
     * Gets addToCartRate.
     *
     * @return float
     */
    public function getAddToCartRate()
    {
        return $this->container['addToCartRate'] ?? null;
    }

    /**
     * Sets addToCartRate.
     *
     * @param float $addToCartRate Add-to-cart rate: calculated as the number of tracked searches with at least one add-to-cart event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setAddToCartRate($addToCartRate)
    {
        $this->container['addToCartRate'] = $addToCartRate;

        return $this;
    }

    /**
     * Gets addToCartCount.
     *
     * @return int
     */
    public function getAddToCartCount()
    {
        return $this->container['addToCartCount'] ?? null;
    }

    /**
     * Sets addToCartCount.
     *
     * @param int $addToCartCount number of add-to-cart events from this search
     *
     * @return self
     */
    public function setAddToCartCount($addToCartCount)
    {
        $this->container['addToCartCount'] = $addToCartCount;

        return $this;
    }

    /**
     * Gets purchaseRate.
     *
     * @return float
     */
    public function getPurchaseRate()
    {
        return $this->container['purchaseRate'] ?? null;
    }

    /**
     * Sets purchaseRate.
     *
     * @param float $purchaseRate Purchase rate: calculated as the number of tracked searches with at least one purchase event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setPurchaseRate($purchaseRate)
    {
        $this->container['purchaseRate'] = $purchaseRate;

        return $this;
    }

    /**
     * Gets purchaseCount.
     *
     * @return int
     */
    public function getPurchaseCount()
    {
        return $this->container['purchaseCount'] ?? null;
    }

    /**
     * Sets purchaseCount.
     *
     * @param int $purchaseCount number of purchase events from this search
     *
     * @return self
     */
    public function setPurchaseCount($purchaseCount)
    {
        $this->container['purchaseCount'] = $purchaseCount;

        return $this;
    }

    /**
     * Gets currencies.
     *
     * @return array<string,CurrencyCode>
     */
    public function getCurrencies()
    {
        return $this->container['currencies'] ?? null;
    }

    /**
     * Sets currencies.
     *
     * @param array<string,CurrencyCode> $currencies revenue associated with this search: broken down by currency
     *
     * @return self
     */
    public function setCurrencies($currencies)
    {
        $this->container['currencies'] = $currencies;

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
