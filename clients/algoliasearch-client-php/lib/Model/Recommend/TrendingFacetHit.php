<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Recommend;

/**
 * TrendingFacetHit Class Doc Comment.
 *
 * @category Class
 *
 * @description Trending facet hit.
 */
class TrendingFacetHit extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'score' => 'float',
        'facetName' => 'string',
        'facetValue' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'score' => 'double',
        'facetName' => null,
        'facetValue' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'score' => '_score',
        'facetName' => 'facetName',
        'facetValue' => 'facetValue',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'score' => 'setScore',
        'facetName' => 'setFacetName',
        'facetValue' => 'setFacetValue',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'score' => 'getScore',
        'facetName' => 'getFacetName',
        'facetValue' => 'getFacetValue',
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
        if (isset($data['score'])) {
            $this->container['score'] = $data['score'];
        }
        if (isset($data['facetName'])) {
            $this->container['facetName'] = $data['facetName'];
        }
        if (isset($data['facetValue'])) {
            $this->container['facetValue'] = $data['facetValue'];
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

        if (!isset($this->container['score']) || null === $this->container['score']) {
            $invalidProperties[] = "'score' can't be null";
        }
        if ($this->container['score'] > 100) {
            $invalidProperties[] = "invalid value for 'score', must be smaller than or equal to 100.";
        }

        if ($this->container['score'] < 0) {
            $invalidProperties[] = "invalid value for 'score', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['facetName']) || null === $this->container['facetName']) {
            $invalidProperties[] = "'facetName' can't be null";
        }
        if (!isset($this->container['facetValue']) || null === $this->container['facetValue']) {
            $invalidProperties[] = "'facetValue' can't be null";
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
     * Gets score.
     *
     * @return float
     */
    public function getScore()
    {
        return $this->container['score'] ?? null;
    }

    /**
     * Sets score.
     *
     * @param float $score recommendation score
     *
     * @return self
     */
    public function setScore($score)
    {
        if ($score > 100) {
            throw new \InvalidArgumentException('invalid value for $score when calling TrendingFacetHit., must be smaller than or equal to 100.');
        }
        if ($score < 0) {
            throw new \InvalidArgumentException('invalid value for $score when calling TrendingFacetHit., must be bigger than or equal to 0.');
        }

        $this->container['score'] = $score;

        return $this;
    }

    /**
     * Gets facetName.
     *
     * @return string
     */
    public function getFacetName()
    {
        return $this->container['facetName'] ?? null;
    }

    /**
     * Sets facetName.
     *
     * @param string $facetName facet name for trending models
     *
     * @return self
     */
    public function setFacetName($facetName)
    {
        $this->container['facetName'] = $facetName;

        return $this;
    }

    /**
     * Gets facetValue.
     *
     * @return string
     */
    public function getFacetValue()
    {
        return $this->container['facetValue'] ?? null;
    }

    /**
     * Sets facetValue.
     *
     * @param string $facetValue facet value for trending models
     *
     * @return self
     */
    public function setFacetValue($facetValue)
    {
        $this->container['facetValue'] = $facetValue;

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
