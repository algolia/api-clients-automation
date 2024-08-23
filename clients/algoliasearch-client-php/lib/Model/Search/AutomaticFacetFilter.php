<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * AutomaticFacetFilter Class Doc Comment.
 *
 * @category Class
 *
 * @description Filter or optional filter to be applied to the search.
 */
class AutomaticFacetFilter extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'facet' => 'string',
        'score' => 'int',
        'disjunctive' => 'bool',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'facet' => null,
        'score' => null,
        'disjunctive' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'facet' => 'facet',
        'score' => 'score',
        'disjunctive' => 'disjunctive',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'facet' => 'setFacet',
        'score' => 'setScore',
        'disjunctive' => 'setDisjunctive',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'facet' => 'getFacet',
        'score' => 'getScore',
        'disjunctive' => 'getDisjunctive',
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
        if (isset($data['facet'])) {
            $this->container['facet'] = $data['facet'];
        }
        if (isset($data['score'])) {
            $this->container['score'] = $data['score'];
        }
        if (isset($data['disjunctive'])) {
            $this->container['disjunctive'] = $data['disjunctive'];
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

        if (!isset($this->container['facet']) || null === $this->container['facet']) {
            $invalidProperties[] = "'facet' can't be null";
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
     * Gets facet.
     *
     * @return string
     */
    public function getFacet()
    {
        return $this->container['facet'] ?? null;
    }

    /**
     * Sets facet.
     *
     * @param string $facet Facet name to be applied as filter. The name must match placeholders in the `pattern` parameter. For example, with `pattern: {facet:genre}`, `automaticFacetFilters` must be `genre`.
     *
     * @return self
     */
    public function setFacet($facet)
    {
        $this->container['facet'] = $facet;

        return $this;
    }

    /**
     * Gets score.
     *
     * @return null|int
     */
    public function getScore()
    {
        return $this->container['score'] ?? null;
    }

    /**
     * Sets score.
     *
     * @param null|int $score filter scores to give different weights to individual filters
     *
     * @return self
     */
    public function setScore($score)
    {
        $this->container['score'] = $score;

        return $this;
    }

    /**
     * Gets disjunctive.
     *
     * @return null|bool
     */
    public function getDisjunctive()
    {
        return $this->container['disjunctive'] ?? null;
    }

    /**
     * Sets disjunctive.
     *
     * @param null|bool $disjunctive Whether the filter is disjunctive or conjunctive.  If true the filter has multiple matches, multiple occurences are combined with the logical `OR` operation. If false, multiple occurences are combined with the logical `AND` operation.
     *
     * @return self
     */
    public function setDisjunctive($disjunctive)
    {
        $this->container['disjunctive'] = $disjunctive;

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
