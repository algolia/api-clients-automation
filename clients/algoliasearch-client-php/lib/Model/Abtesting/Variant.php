<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Abtesting;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * Variant Class Doc Comment.
 *
 * @category Class
 */
class Variant extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'addToCartCount' => 'int',
        'addToCartRate' => 'float',
        'averageClickPosition' => 'int',
        'clickCount' => 'int',
        'clickThroughRate' => 'float',
        'conversionCount' => 'int',
        'conversionRate' => 'float',
        'currencies' => 'array<string,\Algolia\AlgoliaSearch\Model\Abtesting\Currency>',
        'description' => 'string',
        'estimatedSampleSize' => 'int',
        'filterEffects' => '\Algolia\AlgoliaSearch\Model\Abtesting\FilterEffects',
        'index' => 'string',
        'noResultCount' => 'int',
        'purchaseCount' => 'int',
        'purchaseRate' => 'float',
        'searchCount' => 'int',
        'trackedSearchCount' => 'int',
        'trafficPercentage' => 'int',
        'userCount' => 'int',
        'trackedUserCount' => 'int',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'addToCartCount' => null,
        'addToCartRate' => 'double',
        'averageClickPosition' => null,
        'clickCount' => null,
        'clickThroughRate' => 'double',
        'conversionCount' => null,
        'conversionRate' => 'double',
        'currencies' => null,
        'description' => null,
        'estimatedSampleSize' => null,
        'filterEffects' => null,
        'index' => null,
        'noResultCount' => null,
        'purchaseCount' => null,
        'purchaseRate' => 'double',
        'searchCount' => null,
        'trackedSearchCount' => null,
        'trafficPercentage' => null,
        'userCount' => null,
        'trackedUserCount' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'addToCartCount' => 'addToCartCount',
        'addToCartRate' => 'addToCartRate',
        'averageClickPosition' => 'averageClickPosition',
        'clickCount' => 'clickCount',
        'clickThroughRate' => 'clickThroughRate',
        'conversionCount' => 'conversionCount',
        'conversionRate' => 'conversionRate',
        'currencies' => 'currencies',
        'description' => 'description',
        'estimatedSampleSize' => 'estimatedSampleSize',
        'filterEffects' => 'filterEffects',
        'index' => 'index',
        'noResultCount' => 'noResultCount',
        'purchaseCount' => 'purchaseCount',
        'purchaseRate' => 'purchaseRate',
        'searchCount' => 'searchCount',
        'trackedSearchCount' => 'trackedSearchCount',
        'trafficPercentage' => 'trafficPercentage',
        'userCount' => 'userCount',
        'trackedUserCount' => 'trackedUserCount',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'addToCartCount' => 'setAddToCartCount',
        'addToCartRate' => 'setAddToCartRate',
        'averageClickPosition' => 'setAverageClickPosition',
        'clickCount' => 'setClickCount',
        'clickThroughRate' => 'setClickThroughRate',
        'conversionCount' => 'setConversionCount',
        'conversionRate' => 'setConversionRate',
        'currencies' => 'setCurrencies',
        'description' => 'setDescription',
        'estimatedSampleSize' => 'setEstimatedSampleSize',
        'filterEffects' => 'setFilterEffects',
        'index' => 'setIndex',
        'noResultCount' => 'setNoResultCount',
        'purchaseCount' => 'setPurchaseCount',
        'purchaseRate' => 'setPurchaseRate',
        'searchCount' => 'setSearchCount',
        'trackedSearchCount' => 'setTrackedSearchCount',
        'trafficPercentage' => 'setTrafficPercentage',
        'userCount' => 'setUserCount',
        'trackedUserCount' => 'setTrackedUserCount',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'addToCartCount' => 'getAddToCartCount',
        'addToCartRate' => 'getAddToCartRate',
        'averageClickPosition' => 'getAverageClickPosition',
        'clickCount' => 'getClickCount',
        'clickThroughRate' => 'getClickThroughRate',
        'conversionCount' => 'getConversionCount',
        'conversionRate' => 'getConversionRate',
        'currencies' => 'getCurrencies',
        'description' => 'getDescription',
        'estimatedSampleSize' => 'getEstimatedSampleSize',
        'filterEffects' => 'getFilterEffects',
        'index' => 'getIndex',
        'noResultCount' => 'getNoResultCount',
        'purchaseCount' => 'getPurchaseCount',
        'purchaseRate' => 'getPurchaseRate',
        'searchCount' => 'getSearchCount',
        'trackedSearchCount' => 'getTrackedSearchCount',
        'trafficPercentage' => 'getTrafficPercentage',
        'userCount' => 'getUserCount',
        'trackedUserCount' => 'getTrackedUserCount',
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
        if (isset($data['addToCartCount'])) {
            $this->container['addToCartCount'] = $data['addToCartCount'];
        }
        if (isset($data['addToCartRate'])) {
            $this->container['addToCartRate'] = $data['addToCartRate'];
        }
        if (isset($data['averageClickPosition'])) {
            $this->container['averageClickPosition'] = $data['averageClickPosition'];
        }
        if (isset($data['clickCount'])) {
            $this->container['clickCount'] = $data['clickCount'];
        }
        if (isset($data['clickThroughRate'])) {
            $this->container['clickThroughRate'] = $data['clickThroughRate'];
        }
        if (isset($data['conversionCount'])) {
            $this->container['conversionCount'] = $data['conversionCount'];
        }
        if (isset($data['conversionRate'])) {
            $this->container['conversionRate'] = $data['conversionRate'];
        }
        if (isset($data['currencies'])) {
            $this->container['currencies'] = $data['currencies'];
        }
        if (isset($data['description'])) {
            $this->container['description'] = $data['description'];
        }
        if (isset($data['estimatedSampleSize'])) {
            $this->container['estimatedSampleSize'] = $data['estimatedSampleSize'];
        }
        if (isset($data['filterEffects'])) {
            $this->container['filterEffects'] = $data['filterEffects'];
        }
        if (isset($data['index'])) {
            $this->container['index'] = $data['index'];
        }
        if (isset($data['noResultCount'])) {
            $this->container['noResultCount'] = $data['noResultCount'];
        }
        if (isset($data['purchaseCount'])) {
            $this->container['purchaseCount'] = $data['purchaseCount'];
        }
        if (isset($data['purchaseRate'])) {
            $this->container['purchaseRate'] = $data['purchaseRate'];
        }
        if (isset($data['searchCount'])) {
            $this->container['searchCount'] = $data['searchCount'];
        }
        if (isset($data['trackedSearchCount'])) {
            $this->container['trackedSearchCount'] = $data['trackedSearchCount'];
        }
        if (isset($data['trafficPercentage'])) {
            $this->container['trafficPercentage'] = $data['trafficPercentage'];
        }
        if (isset($data['userCount'])) {
            $this->container['userCount'] = $data['userCount'];
        }
        if (isset($data['trackedUserCount'])) {
            $this->container['trackedUserCount'] = $data['trackedUserCount'];
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

        if (!isset($this->container['addToCartCount']) || null === $this->container['addToCartCount']) {
            $invalidProperties[] = "'addToCartCount' can't be null";
        }
        if (!isset($this->container['addToCartRate']) || null === $this->container['addToCartRate']) {
            $invalidProperties[] = "'addToCartRate' can't be null";
        }
        if (!isset($this->container['averageClickPosition']) || null === $this->container['averageClickPosition']) {
            $invalidProperties[] = "'averageClickPosition' can't be null";
        }
        if (!isset($this->container['clickCount']) || null === $this->container['clickCount']) {
            $invalidProperties[] = "'clickCount' can't be null";
        }
        if (!isset($this->container['clickThroughRate']) || null === $this->container['clickThroughRate']) {
            $invalidProperties[] = "'clickThroughRate' can't be null";
        }
        if (!isset($this->container['conversionCount']) || null === $this->container['conversionCount']) {
            $invalidProperties[] = "'conversionCount' can't be null";
        }
        if (!isset($this->container['conversionRate']) || null === $this->container['conversionRate']) {
            $invalidProperties[] = "'conversionRate' can't be null";
        }
        if (!isset($this->container['description']) || null === $this->container['description']) {
            $invalidProperties[] = "'description' can't be null";
        }
        if (!isset($this->container['index']) || null === $this->container['index']) {
            $invalidProperties[] = "'index' can't be null";
        }
        if (!isset($this->container['noResultCount']) || null === $this->container['noResultCount']) {
            $invalidProperties[] = "'noResultCount' can't be null";
        }
        if (!isset($this->container['purchaseCount']) || null === $this->container['purchaseCount']) {
            $invalidProperties[] = "'purchaseCount' can't be null";
        }
        if (!isset($this->container['purchaseRate']) || null === $this->container['purchaseRate']) {
            $invalidProperties[] = "'purchaseRate' can't be null";
        }
        if (!isset($this->container['searchCount']) || null === $this->container['searchCount']) {
            $invalidProperties[] = "'searchCount' can't be null";
        }
        if (!isset($this->container['trafficPercentage']) || null === $this->container['trafficPercentage']) {
            $invalidProperties[] = "'trafficPercentage' can't be null";
        }
        if ($this->container['trafficPercentage'] > 100) {
            $invalidProperties[] = "invalid value for 'trafficPercentage', must be smaller than or equal to 100.";
        }

        if ($this->container['trafficPercentage'] < 0) {
            $invalidProperties[] = "invalid value for 'trafficPercentage', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['userCount']) || null === $this->container['userCount']) {
            $invalidProperties[] = "'userCount' can't be null";
        }
        if (!isset($this->container['trackedUserCount']) || null === $this->container['trackedUserCount']) {
            $invalidProperties[] = "'trackedUserCount' can't be null";
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
     * @param int $addToCartCount number of add-to-cart events for this variant
     *
     * @return self
     */
    public function setAddToCartCount($addToCartCount)
    {
        $this->container['addToCartCount'] = $addToCartCount;

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
     * @param float $addToCartRate [Add-to-cart rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#add-to-cart-rate) for this variant.
     *
     * @return self
     */
    public function setAddToCartRate($addToCartRate)
    {
        $this->container['addToCartRate'] = $addToCartRate;

        return $this;
    }

    /**
     * Gets averageClickPosition.
     *
     * @return int
     */
    public function getAverageClickPosition()
    {
        return $this->container['averageClickPosition'] ?? null;
    }

    /**
     * Sets averageClickPosition.
     *
     * @param int $averageClickPosition [Average click position](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-position) for this variant.
     *
     * @return self
     */
    public function setAverageClickPosition($averageClickPosition)
    {
        $this->container['averageClickPosition'] = $averageClickPosition;

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
     * @param int $clickCount number of click events for this variant
     *
     * @return self
     */
    public function setClickCount($clickCount)
    {
        $this->container['clickCount'] = $clickCount;

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
     * @param float $clickThroughRate [Click-through rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate) for this variant.
     *
     * @return self
     */
    public function setClickThroughRate($clickThroughRate)
    {
        $this->container['clickThroughRate'] = $clickThroughRate;

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
     * @param int $conversionCount number of click events for this variant
     *
     * @return self
     */
    public function setConversionCount($conversionCount)
    {
        $this->container['conversionCount'] = $conversionCount;

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
     * @param float $conversionRate [Conversion rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate) for this variant.
     *
     * @return self
     */
    public function setConversionRate($conversionRate)
    {
        $this->container['conversionRate'] = $conversionRate;

        return $this;
    }

    /**
     * Gets currencies.
     *
     * @return null|array<string,\Algolia\AlgoliaSearch\Model\Abtesting\Currency>
     */
    public function getCurrencies()
    {
        return $this->container['currencies'] ?? null;
    }

    /**
     * Sets currencies.
     *
     * @param null|array<string,\Algolia\AlgoliaSearch\Model\Abtesting\Currency> $currencies A/B test currencies
     *
     * @return self
     */
    public function setCurrencies($currencies)
    {
        $this->container['currencies'] = $currencies;

        return $this;
    }

    /**
     * Gets description.
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->container['description'] ?? null;
    }

    /**
     * Sets description.
     *
     * @param string $description description for this variant
     *
     * @return self
     */
    public function setDescription($description)
    {
        $this->container['description'] = $description;

        return $this;
    }

    /**
     * Gets estimatedSampleSize.
     *
     * @return null|int
     */
    public function getEstimatedSampleSize()
    {
        return $this->container['estimatedSampleSize'] ?? null;
    }

    /**
     * Sets estimatedSampleSize.
     *
     * @param null|int $estimatedSampleSize Estimated number of searches required to achieve the desired statistical significance.  The A/B test configuration must include a `mininmumDetectableEffect` setting for this number to be included in the response.
     *
     * @return self
     */
    public function setEstimatedSampleSize($estimatedSampleSize)
    {
        $this->container['estimatedSampleSize'] = $estimatedSampleSize;

        return $this;
    }

    /**
     * Gets filterEffects.
     *
     * @return null|FilterEffects
     */
    public function getFilterEffects()
    {
        return $this->container['filterEffects'] ?? null;
    }

    /**
     * Sets filterEffects.
     *
     * @param null|FilterEffects $filterEffects filterEffects
     *
     * @return self
     */
    public function setFilterEffects($filterEffects)
    {
        $this->container['filterEffects'] = $filterEffects;

        return $this;
    }

    /**
     * Gets index.
     *
     * @return string
     */
    public function getIndex()
    {
        return $this->container['index'] ?? null;
    }

    /**
     * Sets index.
     *
     * @param string $index index name of the A/B test variant (case-sensitive)
     *
     * @return self
     */
    public function setIndex($index)
    {
        $this->container['index'] = $index;

        return $this;
    }

    /**
     * Gets noResultCount.
     *
     * @return int
     */
    public function getNoResultCount()
    {
        return $this->container['noResultCount'] ?? null;
    }

    /**
     * Sets noResultCount.
     *
     * @param int $noResultCount Number of [searches without results](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#searches-without-results) for this variant.
     *
     * @return self
     */
    public function setNoResultCount($noResultCount)
    {
        $this->container['noResultCount'] = $noResultCount;

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
     * @param int $purchaseCount number of purchase events for this variant
     *
     * @return self
     */
    public function setPurchaseCount($purchaseCount)
    {
        $this->container['purchaseCount'] = $purchaseCount;

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
     * @param float $purchaseRate [Purchase rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#purchase-rate) for this variant.
     *
     * @return self
     */
    public function setPurchaseRate($purchaseRate)
    {
        $this->container['purchaseRate'] = $purchaseRate;

        return $this;
    }

    /**
     * Gets searchCount.
     *
     * @return int
     */
    public function getSearchCount()
    {
        return $this->container['searchCount'] ?? null;
    }

    /**
     * Sets searchCount.
     *
     * @param int $searchCount number of searches for this variant
     *
     * @return self
     */
    public function setSearchCount($searchCount)
    {
        $this->container['searchCount'] = $searchCount;

        return $this;
    }

    /**
     * Gets trackedSearchCount.
     *
     * @return null|int
     */
    public function getTrackedSearchCount()
    {
        return $this->container['trackedSearchCount'] ?? null;
    }

    /**
     * Sets trackedSearchCount.
     *
     * @param null|int $trackedSearchCount Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
     *
     * @return self
     */
    public function setTrackedSearchCount($trackedSearchCount)
    {
        $this->container['trackedSearchCount'] = $trackedSearchCount;

        return $this;
    }

    /**
     * Gets trafficPercentage.
     *
     * @return int
     */
    public function getTrafficPercentage()
    {
        return $this->container['trafficPercentage'] ?? null;
    }

    /**
     * Sets trafficPercentage.
     *
     * @param int $trafficPercentage percentage of search requests each variant receives
     *
     * @return self
     */
    public function setTrafficPercentage($trafficPercentage)
    {
        if ($trafficPercentage > 100) {
            throw new \InvalidArgumentException('invalid value for $trafficPercentage when calling Variant., must be smaller than or equal to 100.');
        }
        if ($trafficPercentage < 0) {
            throw new \InvalidArgumentException('invalid value for $trafficPercentage when calling Variant., must be bigger than or equal to 0.');
        }

        $this->container['trafficPercentage'] = $trafficPercentage;

        return $this;
    }

    /**
     * Gets userCount.
     *
     * @return int
     */
    public function getUserCount()
    {
        return $this->container['userCount'] ?? null;
    }

    /**
     * Sets userCount.
     *
     * @param int $userCount number of users that made searches to this variant
     *
     * @return self
     */
    public function setUserCount($userCount)
    {
        $this->container['userCount'] = $userCount;

        return $this;
    }

    /**
     * Gets trackedUserCount.
     *
     * @return int
     */
    public function getTrackedUserCount()
    {
        return $this->container['trackedUserCount'] ?? null;
    }

    /**
     * Sets trackedUserCount.
     *
     * @param int $trackedUserCount number of users that made tracked searches to this variant
     *
     * @return self
     */
    public function setTrackedUserCount($trackedUserCount)
    {
        $this->container['trackedUserCount'] = $trackedUserCount;

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
