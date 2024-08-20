<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Recommend;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * RecommendationsHit Class Doc Comment.
 *
 * @category Class
 */
class RecommendationsHit extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'objectID' => 'string',
        'highlightResult' => 'array<string,\Algolia\AlgoliaSearch\Model\Recommend\HighlightResult>',
        'snippetResult' => 'array<string,\Algolia\AlgoliaSearch\Model\Recommend\SnippetResult>',
        'rankingInfo' => '\Algolia\AlgoliaSearch\Model\Recommend\RankingInfo',
        'distinctSeqID' => 'int',
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
        'objectID' => null,
        'highlightResult' => null,
        'snippetResult' => null,
        'rankingInfo' => null,
        'distinctSeqID' => null,
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
        'objectID' => 'objectID',
        'highlightResult' => '_highlightResult',
        'snippetResult' => '_snippetResult',
        'rankingInfo' => '_rankingInfo',
        'distinctSeqID' => '_distinctSeqID',
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
        'objectID' => 'setObjectID',
        'highlightResult' => 'setHighlightResult',
        'snippetResult' => 'setSnippetResult',
        'rankingInfo' => 'setRankingInfo',
        'distinctSeqID' => 'setDistinctSeqID',
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
        'objectID' => 'getObjectID',
        'highlightResult' => 'getHighlightResult',
        'snippetResult' => 'getSnippetResult',
        'rankingInfo' => 'getRankingInfo',
        'distinctSeqID' => 'getDistinctSeqID',
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
    public function __construct(?array $data = null)
    {
        if (isset($data['objectID'])) {
            $this->container['objectID'] = $data['objectID'];
        }
        if (isset($data['highlightResult'])) {
            $this->container['highlightResult'] = $data['highlightResult'];
        }
        if (isset($data['snippetResult'])) {
            $this->container['snippetResult'] = $data['snippetResult'];
        }
        if (isset($data['rankingInfo'])) {
            $this->container['rankingInfo'] = $data['rankingInfo'];
        }
        if (isset($data['distinctSeqID'])) {
            $this->container['distinctSeqID'] = $data['distinctSeqID'];
        }
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

        if (!isset($this->container['objectID']) || null === $this->container['objectID']) {
            $invalidProperties[] = "'objectID' can't be null";
        }
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
     * Gets highlightResult.
     *
     * @return null|array<string,\Algolia\AlgoliaSearch\Model\Recommend\HighlightResult>
     */
    public function getHighlightResult()
    {
        return $this->container['highlightResult'] ?? null;
    }

    /**
     * Sets highlightResult.
     *
     * @param null|array<string,\Algolia\AlgoliaSearch\Model\Recommend\HighlightResult> $highlightResult surround words that match the query with HTML tags for highlighting
     *
     * @return self
     */
    public function setHighlightResult($highlightResult)
    {
        $this->container['highlightResult'] = $highlightResult;

        return $this;
    }

    /**
     * Gets snippetResult.
     *
     * @return null|array<string,\Algolia\AlgoliaSearch\Model\Recommend\SnippetResult>
     */
    public function getSnippetResult()
    {
        return $this->container['snippetResult'] ?? null;
    }

    /**
     * Sets snippetResult.
     *
     * @param null|array<string,\Algolia\AlgoliaSearch\Model\Recommend\SnippetResult> $snippetResult snippets that show the context around a matching search query
     *
     * @return self
     */
    public function setSnippetResult($snippetResult)
    {
        $this->container['snippetResult'] = $snippetResult;

        return $this;
    }

    /**
     * Gets rankingInfo.
     *
     * @return null|RankingInfo
     */
    public function getRankingInfo()
    {
        return $this->container['rankingInfo'] ?? null;
    }

    /**
     * Sets rankingInfo.
     *
     * @param null|RankingInfo $rankingInfo rankingInfo
     *
     * @return self
     */
    public function setRankingInfo($rankingInfo)
    {
        $this->container['rankingInfo'] = $rankingInfo;

        return $this;
    }

    /**
     * Gets distinctSeqID.
     *
     * @return null|int
     */
    public function getDistinctSeqID()
    {
        return $this->container['distinctSeqID'] ?? null;
    }

    /**
     * Sets distinctSeqID.
     *
     * @param null|int $distinctSeqID distinctSeqID
     *
     * @return self
     */
    public function setDistinctSeqID($distinctSeqID)
    {
        $this->container['distinctSeqID'] = $distinctSeqID;

        return $this;
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
            throw new \InvalidArgumentException('invalid value for $score when calling RecommendationsHit., must be smaller than or equal to 100.');
        }
        if ($score < 0) {
            throw new \InvalidArgumentException('invalid value for $score when calling RecommendationsHit., must be bigger than or equal to 0.');
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
     * @param string $facetName Facet attribute. To be used in combination with `facetValue`. If specified, only recommendations matching the facet filter will be returned.
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
     * @param string $facetValue Facet value. To be used in combination with `facetName`. If specified, only recommendations matching the facet filter will be returned.
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
