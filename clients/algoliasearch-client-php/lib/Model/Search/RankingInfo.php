<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * RankingInfo Class Doc Comment.
 *
 * @category Class
 *
 * @description Object with detailed information about the record&#39;s ranking.
 */
class RankingInfo extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'filters' => 'int',
        'firstMatchedWord' => 'int',
        'geoDistance' => 'int',
        'geoPrecision' => 'int',
        'matchedGeoLocation' => '\Algolia\AlgoliaSearch\Model\Search\MatchedGeoLocation',
        'personalization' => '\Algolia\AlgoliaSearch\Model\Search\Personalization',
        'nbExactWords' => 'int',
        'nbTypos' => 'int',
        'promoted' => 'bool',
        'proximityDistance' => 'int',
        'userScore' => 'int',
        'words' => 'int',
        'promotedByReRanking' => 'bool',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'filters' => null,
        'firstMatchedWord' => null,
        'geoDistance' => null,
        'geoPrecision' => null,
        'matchedGeoLocation' => null,
        'personalization' => null,
        'nbExactWords' => null,
        'nbTypos' => null,
        'promoted' => null,
        'proximityDistance' => null,
        'userScore' => null,
        'words' => null,
        'promotedByReRanking' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'filters' => 'filters',
        'firstMatchedWord' => 'firstMatchedWord',
        'geoDistance' => 'geoDistance',
        'geoPrecision' => 'geoPrecision',
        'matchedGeoLocation' => 'matchedGeoLocation',
        'personalization' => 'personalization',
        'nbExactWords' => 'nbExactWords',
        'nbTypos' => 'nbTypos',
        'promoted' => 'promoted',
        'proximityDistance' => 'proximityDistance',
        'userScore' => 'userScore',
        'words' => 'words',
        'promotedByReRanking' => 'promotedByReRanking',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'filters' => 'setFilters',
        'firstMatchedWord' => 'setFirstMatchedWord',
        'geoDistance' => 'setGeoDistance',
        'geoPrecision' => 'setGeoPrecision',
        'matchedGeoLocation' => 'setMatchedGeoLocation',
        'personalization' => 'setPersonalization',
        'nbExactWords' => 'setNbExactWords',
        'nbTypos' => 'setNbTypos',
        'promoted' => 'setPromoted',
        'proximityDistance' => 'setProximityDistance',
        'userScore' => 'setUserScore',
        'words' => 'setWords',
        'promotedByReRanking' => 'setPromotedByReRanking',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'filters' => 'getFilters',
        'firstMatchedWord' => 'getFirstMatchedWord',
        'geoDistance' => 'getGeoDistance',
        'geoPrecision' => 'getGeoPrecision',
        'matchedGeoLocation' => 'getMatchedGeoLocation',
        'personalization' => 'getPersonalization',
        'nbExactWords' => 'getNbExactWords',
        'nbTypos' => 'getNbTypos',
        'promoted' => 'getPromoted',
        'proximityDistance' => 'getProximityDistance',
        'userScore' => 'getUserScore',
        'words' => 'getWords',
        'promotedByReRanking' => 'getPromotedByReRanking',
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
        if (isset($data['filters'])) {
            $this->container['filters'] = $data['filters'];
        }
        if (isset($data['firstMatchedWord'])) {
            $this->container['firstMatchedWord'] = $data['firstMatchedWord'];
        }
        if (isset($data['geoDistance'])) {
            $this->container['geoDistance'] = $data['geoDistance'];
        }
        if (isset($data['geoPrecision'])) {
            $this->container['geoPrecision'] = $data['geoPrecision'];
        }
        if (isset($data['matchedGeoLocation'])) {
            $this->container['matchedGeoLocation'] = $data['matchedGeoLocation'];
        }
        if (isset($data['personalization'])) {
            $this->container['personalization'] = $data['personalization'];
        }
        if (isset($data['nbExactWords'])) {
            $this->container['nbExactWords'] = $data['nbExactWords'];
        }
        if (isset($data['nbTypos'])) {
            $this->container['nbTypos'] = $data['nbTypos'];
        }
        if (isset($data['promoted'])) {
            $this->container['promoted'] = $data['promoted'];
        }
        if (isset($data['proximityDistance'])) {
            $this->container['proximityDistance'] = $data['proximityDistance'];
        }
        if (isset($data['userScore'])) {
            $this->container['userScore'] = $data['userScore'];
        }
        if (isset($data['words'])) {
            $this->container['words'] = $data['words'];
        }
        if (isset($data['promotedByReRanking'])) {
            $this->container['promotedByReRanking'] = $data['promotedByReRanking'];
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

        if (!isset($this->container['firstMatchedWord']) || null === $this->container['firstMatchedWord']) {
            $invalidProperties[] = "'firstMatchedWord' can't be null";
        }
        if (!isset($this->container['geoDistance']) || null === $this->container['geoDistance']) {
            $invalidProperties[] = "'geoDistance' can't be null";
        }
        if (!isset($this->container['nbExactWords']) || null === $this->container['nbExactWords']) {
            $invalidProperties[] = "'nbExactWords' can't be null";
        }
        if (!isset($this->container['nbTypos']) || null === $this->container['nbTypos']) {
            $invalidProperties[] = "'nbTypos' can't be null";
        }
        if (!isset($this->container['userScore']) || null === $this->container['userScore']) {
            $invalidProperties[] = "'userScore' can't be null";
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
     * Gets filters.
     *
     * @return null|int
     */
    public function getFilters()
    {
        return $this->container['filters'] ?? null;
    }

    /**
     * Sets filters.
     *
     * @param null|int $filters whether a filter matched the query
     *
     * @return self
     */
    public function setFilters($filters)
    {
        $this->container['filters'] = $filters;

        return $this;
    }

    /**
     * Gets firstMatchedWord.
     *
     * @return int
     */
    public function getFirstMatchedWord()
    {
        return $this->container['firstMatchedWord'] ?? null;
    }

    /**
     * Sets firstMatchedWord.
     *
     * @param int $firstMatchedWord position of the first matched word in the best matching attribute of the record
     *
     * @return self
     */
    public function setFirstMatchedWord($firstMatchedWord)
    {
        $this->container['firstMatchedWord'] = $firstMatchedWord;

        return $this;
    }

    /**
     * Gets geoDistance.
     *
     * @return int
     */
    public function getGeoDistance()
    {
        return $this->container['geoDistance'] ?? null;
    }

    /**
     * Sets geoDistance.
     *
     * @param int $geoDistance distance between the geo location in the search query and the best matching geo location in the record, divided by the geo precision (in meters)
     *
     * @return self
     */
    public function setGeoDistance($geoDistance)
    {
        $this->container['geoDistance'] = $geoDistance;

        return $this;
    }

    /**
     * Gets geoPrecision.
     *
     * @return null|int
     */
    public function getGeoPrecision()
    {
        return $this->container['geoPrecision'] ?? null;
    }

    /**
     * Sets geoPrecision.
     *
     * @param null|int $geoPrecision precision used when computing the geo distance, in meters
     *
     * @return self
     */
    public function setGeoPrecision($geoPrecision)
    {
        $this->container['geoPrecision'] = $geoPrecision;

        return $this;
    }

    /**
     * Gets matchedGeoLocation.
     *
     * @return null|MatchedGeoLocation
     */
    public function getMatchedGeoLocation()
    {
        return $this->container['matchedGeoLocation'] ?? null;
    }

    /**
     * Sets matchedGeoLocation.
     *
     * @param null|MatchedGeoLocation $matchedGeoLocation matchedGeoLocation
     *
     * @return self
     */
    public function setMatchedGeoLocation($matchedGeoLocation)
    {
        $this->container['matchedGeoLocation'] = $matchedGeoLocation;

        return $this;
    }

    /**
     * Gets personalization.
     *
     * @return null|Personalization
     */
    public function getPersonalization()
    {
        return $this->container['personalization'] ?? null;
    }

    /**
     * Sets personalization.
     *
     * @param null|Personalization $personalization personalization
     *
     * @return self
     */
    public function setPersonalization($personalization)
    {
        $this->container['personalization'] = $personalization;

        return $this;
    }

    /**
     * Gets nbExactWords.
     *
     * @return int
     */
    public function getNbExactWords()
    {
        return $this->container['nbExactWords'] ?? null;
    }

    /**
     * Sets nbExactWords.
     *
     * @param int $nbExactWords number of exactly matched words
     *
     * @return self
     */
    public function setNbExactWords($nbExactWords)
    {
        $this->container['nbExactWords'] = $nbExactWords;

        return $this;
    }

    /**
     * Gets nbTypos.
     *
     * @return int
     */
    public function getNbTypos()
    {
        return $this->container['nbTypos'] ?? null;
    }

    /**
     * Sets nbTypos.
     *
     * @param int $nbTypos number of typos encountered when matching the record
     *
     * @return self
     */
    public function setNbTypos($nbTypos)
    {
        $this->container['nbTypos'] = $nbTypos;

        return $this;
    }

    /**
     * Gets promoted.
     *
     * @return null|bool
     */
    public function getPromoted()
    {
        return $this->container['promoted'] ?? null;
    }

    /**
     * Sets promoted.
     *
     * @param null|bool $promoted whether the record was promoted by a rule
     *
     * @return self
     */
    public function setPromoted($promoted)
    {
        $this->container['promoted'] = $promoted;

        return $this;
    }

    /**
     * Gets proximityDistance.
     *
     * @return null|int
     */
    public function getProximityDistance()
    {
        return $this->container['proximityDistance'] ?? null;
    }

    /**
     * Sets proximityDistance.
     *
     * @param null|int $proximityDistance Number of words between multiple matches in the query plus 1. For single word queries, `proximityDistance` is 0.
     *
     * @return self
     */
    public function setProximityDistance($proximityDistance)
    {
        $this->container['proximityDistance'] = $proximityDistance;

        return $this;
    }

    /**
     * Gets userScore.
     *
     * @return int
     */
    public function getUserScore()
    {
        return $this->container['userScore'] ?? null;
    }

    /**
     * Sets userScore.
     *
     * @param int $userScore Overall ranking of the record, expressed as a single integer. This attribute is internal.
     *
     * @return self
     */
    public function setUserScore($userScore)
    {
        $this->container['userScore'] = $userScore;

        return $this;
    }

    /**
     * Gets words.
     *
     * @return null|int
     */
    public function getWords()
    {
        return $this->container['words'] ?? null;
    }

    /**
     * Sets words.
     *
     * @param null|int $words number of matched words
     *
     * @return self
     */
    public function setWords($words)
    {
        $this->container['words'] = $words;

        return $this;
    }

    /**
     * Gets promotedByReRanking.
     *
     * @return null|bool
     */
    public function getPromotedByReRanking()
    {
        return $this->container['promotedByReRanking'] ?? null;
    }

    /**
     * Sets promotedByReRanking.
     *
     * @param null|bool $promotedByReRanking whether the record is re-ranked
     *
     * @return self
     */
    public function setPromotedByReRanking($promotedByReRanking)
    {
        $this->container['promotedByReRanking'] = $promotedByReRanking;

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
