<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Recommend;

/**
 * LookingSimilarQuery Class Doc Comment.
 *
 * @category Class
 */
class LookingSimilarQuery extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'indexName' => 'string',
        'threshold' => 'float',
        'maxRecommendations' => 'int',
        'queryParameters' => '\Algolia\AlgoliaSearch\Model\Recommend\SearchParams',
        'model' => '\Algolia\AlgoliaSearch\Model\Recommend\LookingSimilarModel',
        'objectID' => 'string',
        'fallbackParameters' => '\Algolia\AlgoliaSearch\Model\Recommend\FallbackParams',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'indexName' => null,
        'threshold' => 'double',
        'maxRecommendations' => null,
        'queryParameters' => null,
        'model' => null,
        'objectID' => null,
        'fallbackParameters' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'indexName' => 'indexName',
        'threshold' => 'threshold',
        'maxRecommendations' => 'maxRecommendations',
        'queryParameters' => 'queryParameters',
        'model' => 'model',
        'objectID' => 'objectID',
        'fallbackParameters' => 'fallbackParameters',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'indexName' => 'setIndexName',
        'threshold' => 'setThreshold',
        'maxRecommendations' => 'setMaxRecommendations',
        'queryParameters' => 'setQueryParameters',
        'model' => 'setModel',
        'objectID' => 'setObjectID',
        'fallbackParameters' => 'setFallbackParameters',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'indexName' => 'getIndexName',
        'threshold' => 'getThreshold',
        'maxRecommendations' => 'getMaxRecommendations',
        'queryParameters' => 'getQueryParameters',
        'model' => 'getModel',
        'objectID' => 'getObjectID',
        'fallbackParameters' => 'getFallbackParameters',
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
        if (isset($data['indexName'])) {
            $this->container['indexName'] = $data['indexName'];
        }
        if (isset($data['threshold'])) {
            $this->container['threshold'] = $data['threshold'];
        }
        if (isset($data['maxRecommendations'])) {
            $this->container['maxRecommendations'] = $data['maxRecommendations'];
        }
        if (isset($data['queryParameters'])) {
            $this->container['queryParameters'] = $data['queryParameters'];
        }
        if (isset($data['model'])) {
            $this->container['model'] = $data['model'];
        }
        if (isset($data['objectID'])) {
            $this->container['objectID'] = $data['objectID'];
        }
        if (isset($data['fallbackParameters'])) {
            $this->container['fallbackParameters'] = $data['fallbackParameters'];
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

        if (!isset($this->container['indexName']) || null === $this->container['indexName']) {
            $invalidProperties[] = "'indexName' can't be null";
        }
        if (!isset($this->container['threshold']) || null === $this->container['threshold']) {
            $invalidProperties[] = "'threshold' can't be null";
        }
        if ($this->container['threshold'] > 100) {
            $invalidProperties[] = "invalid value for 'threshold', must be smaller than or equal to 100.";
        }

        if ($this->container['threshold'] < 0) {
            $invalidProperties[] = "invalid value for 'threshold', must be bigger than or equal to 0.";
        }

        if (isset($this->container['maxRecommendations']) && ($this->container['maxRecommendations'] > 1000)) {
            $invalidProperties[] = "invalid value for 'maxRecommendations', must be smaller than or equal to 1000.";
        }

        if (isset($this->container['maxRecommendations']) && ($this->container['maxRecommendations'] < 1)) {
            $invalidProperties[] = "invalid value for 'maxRecommendations', must be bigger than or equal to 1.";
        }

        if (!isset($this->container['model']) || null === $this->container['model']) {
            $invalidProperties[] = "'model' can't be null";
        }
        if (!isset($this->container['objectID']) || null === $this->container['objectID']) {
            $invalidProperties[] = "'objectID' can't be null";
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
     * Gets indexName.
     *
     * @return string
     */
    public function getIndexName()
    {
        return $this->container['indexName'] ?? null;
    }

    /**
     * Sets indexName.
     *
     * @param string $indexName index name (case-sensitive)
     *
     * @return self
     */
    public function setIndexName($indexName)
    {
        $this->container['indexName'] = $indexName;

        return $this;
    }

    /**
     * Gets threshold.
     *
     * @return float
     */
    public function getThreshold()
    {
        return $this->container['threshold'] ?? null;
    }

    /**
     * Sets threshold.
     *
     * @param float $threshold minimum score a recommendation must have to be included in the response
     *
     * @return self
     */
    public function setThreshold($threshold)
    {
        if ($threshold > 100) {
            throw new \InvalidArgumentException('invalid value for $threshold when calling LookingSimilarQuery., must be smaller than or equal to 100.');
        }
        if ($threshold < 0) {
            throw new \InvalidArgumentException('invalid value for $threshold when calling LookingSimilarQuery., must be bigger than or equal to 0.');
        }

        $this->container['threshold'] = $threshold;

        return $this;
    }

    /**
     * Gets maxRecommendations.
     *
     * @return null|int
     */
    public function getMaxRecommendations()
    {
        return $this->container['maxRecommendations'] ?? null;
    }

    /**
     * Sets maxRecommendations.
     *
     * @param null|int $maxRecommendations Maximum number of recommendations to retrieve. By default, all recommendations are returned and no fallback request is made. Depending on the available recommendations and the other request parameters, the actual number of recommendations may be lower than this value.
     *
     * @return self
     */
    public function setMaxRecommendations($maxRecommendations)
    {
        if (!is_null($maxRecommendations) && ($maxRecommendations > 1000)) {
            throw new \InvalidArgumentException('invalid value for $maxRecommendations when calling LookingSimilarQuery., must be smaller than or equal to 1000.');
        }
        if (!is_null($maxRecommendations) && ($maxRecommendations < 1)) {
            throw new \InvalidArgumentException('invalid value for $maxRecommendations when calling LookingSimilarQuery., must be bigger than or equal to 1.');
        }

        $this->container['maxRecommendations'] = $maxRecommendations;

        return $this;
    }

    /**
     * Gets queryParameters.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Recommend\SearchParams
     */
    public function getQueryParameters()
    {
        return $this->container['queryParameters'] ?? null;
    }

    /**
     * Sets queryParameters.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Recommend\SearchParams $queryParameters queryParameters
     *
     * @return self
     */
    public function setQueryParameters($queryParameters)
    {
        $this->container['queryParameters'] = $queryParameters;

        return $this;
    }

    /**
     * Gets model.
     *
     * @return \Algolia\AlgoliaSearch\Model\Recommend\LookingSimilarModel
     */
    public function getModel()
    {
        return $this->container['model'] ?? null;
    }

    /**
     * Sets model.
     *
     * @param \Algolia\AlgoliaSearch\Model\Recommend\LookingSimilarModel $model model
     *
     * @return self
     */
    public function setModel($model)
    {
        $this->container['model'] = $model;

        return $this;
    }

    /**
     * Gets objectID.
     *
     * @return string
     */
    public function getObjectID()
    {
        return $this->container['objectID'] ?? null;
    }

    /**
     * Sets objectID.
     *
     * @param string $objectID unique record identifier
     *
     * @return self
     */
    public function setObjectID($objectID)
    {
        $this->container['objectID'] = $objectID;

        return $this;
    }

    /**
     * Gets fallbackParameters.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Recommend\FallbackParams
     */
    public function getFallbackParameters()
    {
        return $this->container['fallbackParameters'] ?? null;
    }

    /**
     * Sets fallbackParameters.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Recommend\FallbackParams $fallbackParameters fallbackParameters
     *
     * @return self
     */
    public function setFallbackParameters($fallbackParameters)
    {
        $this->container['fallbackParameters'] = $fallbackParameters;

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
