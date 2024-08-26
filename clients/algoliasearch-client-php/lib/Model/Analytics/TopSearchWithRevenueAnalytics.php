<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Analytics;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * TopSearchWithRevenueAnalytics Class Doc Comment.
 *
 * @category Class
 */
class TopSearchWithRevenueAnalytics extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'search' => 'string',
        'count' => 'int',
        'clickThroughRate' => 'float',
        'averageClickPosition' => 'float',
        'clickPositions' => '\Algolia\AlgoliaSearch\Model\Analytics\ClickPosition[]',
        'conversionRate' => 'float',
        'trackedSearchCount' => 'int',
        'clickCount' => 'int',
        'conversionCount' => 'int',
        'nbHits' => 'int',
        'currencies' => 'array<string,\Algolia\AlgoliaSearch\Model\Analytics\CurrencyCode>',
        'addToCartRate' => 'float',
        'addToCartCount' => 'int',
        'purchaseRate' => 'float',
        'purchaseCount' => 'int',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'search' => null,
        'count' => null,
        'clickThroughRate' => 'double',
        'averageClickPosition' => 'double',
        'clickPositions' => null,
        'conversionRate' => 'double',
        'trackedSearchCount' => null,
        'clickCount' => null,
        'conversionCount' => null,
        'nbHits' => null,
        'currencies' => null,
        'addToCartRate' => 'double',
        'addToCartCount' => null,
        'purchaseRate' => 'double',
        'purchaseCount' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'search' => 'search',
        'count' => 'count',
        'clickThroughRate' => 'clickThroughRate',
        'averageClickPosition' => 'averageClickPosition',
        'clickPositions' => 'clickPositions',
        'conversionRate' => 'conversionRate',
        'trackedSearchCount' => 'trackedSearchCount',
        'clickCount' => 'clickCount',
        'conversionCount' => 'conversionCount',
        'nbHits' => 'nbHits',
        'currencies' => 'currencies',
        'addToCartRate' => 'addToCartRate',
        'addToCartCount' => 'addToCartCount',
        'purchaseRate' => 'purchaseRate',
        'purchaseCount' => 'purchaseCount',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'search' => 'setSearch',
        'count' => 'setCount',
        'clickThroughRate' => 'setClickThroughRate',
        'averageClickPosition' => 'setAverageClickPosition',
        'clickPositions' => 'setClickPositions',
        'conversionRate' => 'setConversionRate',
        'trackedSearchCount' => 'setTrackedSearchCount',
        'clickCount' => 'setClickCount',
        'conversionCount' => 'setConversionCount',
        'nbHits' => 'setNbHits',
        'currencies' => 'setCurrencies',
        'addToCartRate' => 'setAddToCartRate',
        'addToCartCount' => 'setAddToCartCount',
        'purchaseRate' => 'setPurchaseRate',
        'purchaseCount' => 'setPurchaseCount',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'search' => 'getSearch',
        'count' => 'getCount',
        'clickThroughRate' => 'getClickThroughRate',
        'averageClickPosition' => 'getAverageClickPosition',
        'clickPositions' => 'getClickPositions',
        'conversionRate' => 'getConversionRate',
        'trackedSearchCount' => 'getTrackedSearchCount',
        'clickCount' => 'getClickCount',
        'conversionCount' => 'getConversionCount',
        'nbHits' => 'getNbHits',
        'currencies' => 'getCurrencies',
        'addToCartRate' => 'getAddToCartRate',
        'addToCartCount' => 'getAddToCartCount',
        'purchaseRate' => 'getPurchaseRate',
        'purchaseCount' => 'getPurchaseCount',
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
        if (isset($data['search'])) {
            $this->container['search'] = $data['search'];
        }
        if (isset($data['count'])) {
            $this->container['count'] = $data['count'];
        }
        if (isset($data['clickThroughRate'])) {
            $this->container['clickThroughRate'] = $data['clickThroughRate'];
        }
        if (isset($data['averageClickPosition'])) {
            $this->container['averageClickPosition'] = $data['averageClickPosition'];
        }
        if (isset($data['clickPositions'])) {
            $this->container['clickPositions'] = $data['clickPositions'];
        }
        if (isset($data['conversionRate'])) {
            $this->container['conversionRate'] = $data['conversionRate'];
        }
        if (isset($data['trackedSearchCount'])) {
            $this->container['trackedSearchCount'] = $data['trackedSearchCount'];
        }
        if (isset($data['clickCount'])) {
            $this->container['clickCount'] = $data['clickCount'];
        }
        if (isset($data['conversionCount'])) {
            $this->container['conversionCount'] = $data['conversionCount'];
        }
        if (isset($data['nbHits'])) {
            $this->container['nbHits'] = $data['nbHits'];
        }
        if (isset($data['currencies'])) {
            $this->container['currencies'] = $data['currencies'];
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

        if (!isset($this->container['search']) || null === $this->container['search']) {
            $invalidProperties[] = "'search' can't be null";
        }
        if (!isset($this->container['count']) || null === $this->container['count']) {
            $invalidProperties[] = "'count' can't be null";
        }
        if (!isset($this->container['clickThroughRate']) || null === $this->container['clickThroughRate']) {
            $invalidProperties[] = "'clickThroughRate' can't be null";
        }
        if ($this->container['clickThroughRate'] > 1) {
            $invalidProperties[] = "invalid value for 'clickThroughRate', must be smaller than or equal to 1.";
        }

        if ($this->container['clickThroughRate'] < 0) {
            $invalidProperties[] = "invalid value for 'clickThroughRate', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['averageClickPosition']) || null === $this->container['averageClickPosition']) {
            $invalidProperties[] = "'averageClickPosition' can't be null";
        }
        if ($this->container['averageClickPosition'] < 1) {
            $invalidProperties[] = "invalid value for 'averageClickPosition', must be bigger than or equal to 1.";
        }

        if (!isset($this->container['clickPositions']) || null === $this->container['clickPositions']) {
            $invalidProperties[] = "'clickPositions' can't be null";
        }
        if (count($this->container['clickPositions']) > 12) {
            $invalidProperties[] = "invalid value for 'clickPositions', number of items must be less than or equal to 12.";
        }

        if (count($this->container['clickPositions']) < 12) {
            $invalidProperties[] = "invalid value for 'clickPositions', number of items must be greater than or equal to 12.";
        }

        if (!isset($this->container['conversionRate']) || null === $this->container['conversionRate']) {
            $invalidProperties[] = "'conversionRate' can't be null";
        }
        if ($this->container['conversionRate'] > 1) {
            $invalidProperties[] = "invalid value for 'conversionRate', must be smaller than or equal to 1.";
        }

        if ($this->container['conversionRate'] < 0) {
            $invalidProperties[] = "invalid value for 'conversionRate', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['trackedSearchCount']) || null === $this->container['trackedSearchCount']) {
            $invalidProperties[] = "'trackedSearchCount' can't be null";
        }
        if (!isset($this->container['clickCount']) || null === $this->container['clickCount']) {
            $invalidProperties[] = "'clickCount' can't be null";
        }
        if ($this->container['clickCount'] < 0) {
            $invalidProperties[] = "invalid value for 'clickCount', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['conversionCount']) || null === $this->container['conversionCount']) {
            $invalidProperties[] = "'conversionCount' can't be null";
        }
        if ($this->container['conversionCount'] < 0) {
            $invalidProperties[] = "invalid value for 'conversionCount', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['nbHits']) || null === $this->container['nbHits']) {
            $invalidProperties[] = "'nbHits' can't be null";
        }
        if (!isset($this->container['currencies']) || null === $this->container['currencies']) {
            $invalidProperties[] = "'currencies' can't be null";
        }
        if (!isset($this->container['addToCartRate']) || null === $this->container['addToCartRate']) {
            $invalidProperties[] = "'addToCartRate' can't be null";
        }
        if ($this->container['addToCartRate'] > 1) {
            $invalidProperties[] = "invalid value for 'addToCartRate', must be smaller than or equal to 1.";
        }

        if ($this->container['addToCartRate'] < 0) {
            $invalidProperties[] = "invalid value for 'addToCartRate', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['addToCartCount']) || null === $this->container['addToCartCount']) {
            $invalidProperties[] = "'addToCartCount' can't be null";
        }
        if ($this->container['addToCartCount'] < 0) {
            $invalidProperties[] = "invalid value for 'addToCartCount', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['purchaseRate']) || null === $this->container['purchaseRate']) {
            $invalidProperties[] = "'purchaseRate' can't be null";
        }
        if ($this->container['purchaseRate'] > 1) {
            $invalidProperties[] = "invalid value for 'purchaseRate', must be smaller than or equal to 1.";
        }

        if ($this->container['purchaseRate'] < 0) {
            $invalidProperties[] = "invalid value for 'purchaseRate', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['purchaseCount']) || null === $this->container['purchaseCount']) {
            $invalidProperties[] = "'purchaseCount' can't be null";
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
     * Gets search.
     *
     * @return string
     */
    public function getSearch()
    {
        return $this->container['search'] ?? null;
    }

    /**
     * Sets search.
     *
     * @param string $search search query
     *
     * @return self
     */
    public function setSearch($search)
    {
        $this->container['search'] = $search;

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
     * @param int $count number of searches
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
     * @param float $clickThroughRate Click-through rate, calculated as number of tracked searches with at least one click event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setClickThroughRate($clickThroughRate)
    {
        if ($clickThroughRate > 1) {
            throw new \InvalidArgumentException('invalid value for $clickThroughRate when calling TopSearchWithRevenueAnalytics., must be smaller than or equal to 1.');
        }
        if ($clickThroughRate < 0) {
            throw new \InvalidArgumentException('invalid value for $clickThroughRate when calling TopSearchWithRevenueAnalytics., must be bigger than or equal to 0.');
        }

        $this->container['clickThroughRate'] = $clickThroughRate;

        return $this;
    }

    /**
     * Gets averageClickPosition.
     *
     * @return float
     */
    public function getAverageClickPosition()
    {
        return $this->container['averageClickPosition'] ?? null;
    }

    /**
     * Sets averageClickPosition.
     *
     * @param float $averageClickPosition Average position of a clicked search result in the list of search results. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setAverageClickPosition($averageClickPosition)
    {
        if ($averageClickPosition < 1) {
            throw new \InvalidArgumentException('invalid value for $averageClickPosition when calling TopSearchWithRevenueAnalytics., must be bigger than or equal to 1.');
        }

        $this->container['averageClickPosition'] = $averageClickPosition;

        return $this;
    }

    /**
     * Gets clickPositions.
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\ClickPosition[]
     */
    public function getClickPositions()
    {
        return $this->container['clickPositions'] ?? null;
    }

    /**
     * Sets clickPositions.
     *
     * @param \Algolia\AlgoliaSearch\Model\Analytics\ClickPosition[] $clickPositions list of positions in the search results and clicks associated with this search
     *
     * @return self
     */
    public function setClickPositions($clickPositions)
    {
        if (count($clickPositions) > 12) {
            throw new \InvalidArgumentException('invalid value for $clickPositions when calling TopSearchWithRevenueAnalytics., number of items must be less than or equal to 12.');
        }
        if (count($clickPositions) < 12) {
            throw new \InvalidArgumentException('invalid length for $clickPositions when calling TopSearchWithRevenueAnalytics., number of items must be greater than or equal to 12.');
        }
        $this->container['clickPositions'] = $clickPositions;

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
     * @param float $conversionRate Conversion rate, calculated as number of tracked searches with at least one conversion event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setConversionRate($conversionRate)
    {
        if ($conversionRate > 1) {
            throw new \InvalidArgumentException('invalid value for $conversionRate when calling TopSearchWithRevenueAnalytics., must be smaller than or equal to 1.');
        }
        if ($conversionRate < 0) {
            throw new \InvalidArgumentException('invalid value for $conversionRate when calling TopSearchWithRevenueAnalytics., must be bigger than or equal to 0.');
        }

        $this->container['conversionRate'] = $conversionRate;

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
            throw new \InvalidArgumentException('invalid value for $clickCount when calling TopSearchWithRevenueAnalytics., must be bigger than or equal to 0.');
        }

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
        if ($conversionCount < 0) {
            throw new \InvalidArgumentException('invalid value for $conversionCount when calling TopSearchWithRevenueAnalytics., must be bigger than or equal to 0.');
        }

        $this->container['conversionCount'] = $conversionCount;

        return $this;
    }

    /**
     * Gets nbHits.
     *
     * @return int
     */
    public function getNbHits()
    {
        return $this->container['nbHits'] ?? null;
    }

    /**
     * Sets nbHits.
     *
     * @param int $nbHits number of results (hits)
     *
     * @return self
     */
    public function setNbHits($nbHits)
    {
        $this->container['nbHits'] = $nbHits;

        return $this;
    }

    /**
     * Gets currencies.
     *
     * @return array<string,\Algolia\AlgoliaSearch\Model\Analytics\CurrencyCode>
     */
    public function getCurrencies()
    {
        return $this->container['currencies'] ?? null;
    }

    /**
     * Sets currencies.
     *
     * @param array<string,\Algolia\AlgoliaSearch\Model\Analytics\CurrencyCode> $currencies revenue associated with this search, broken-down by currencies
     *
     * @return self
     */
    public function setCurrencies($currencies)
    {
        $this->container['currencies'] = $currencies;

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
     * @param float $addToCartRate Add-to-cart rate, calculated as number of tracked searches with at least one add-to-cart event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setAddToCartRate($addToCartRate)
    {
        if ($addToCartRate > 1) {
            throw new \InvalidArgumentException('invalid value for $addToCartRate when calling TopSearchWithRevenueAnalytics., must be smaller than or equal to 1.');
        }
        if ($addToCartRate < 0) {
            throw new \InvalidArgumentException('invalid value for $addToCartRate when calling TopSearchWithRevenueAnalytics., must be bigger than or equal to 0.');
        }

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
        if ($addToCartCount < 0) {
            throw new \InvalidArgumentException('invalid value for $addToCartCount when calling TopSearchWithRevenueAnalytics., must be bigger than or equal to 0.');
        }

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
     * @param float $purchaseRate Purchase rate, calculated as number of tracked searches with at least one purchase event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
     *
     * @return self
     */
    public function setPurchaseRate($purchaseRate)
    {
        if ($purchaseRate > 1) {
            throw new \InvalidArgumentException('invalid value for $purchaseRate when calling TopSearchWithRevenueAnalytics., must be smaller than or equal to 1.');
        }
        if ($purchaseRate < 0) {
            throw new \InvalidArgumentException('invalid value for $purchaseRate when calling TopSearchWithRevenueAnalytics., must be bigger than or equal to 0.');
        }

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
