<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * Exhaustive Class Doc Comment.
 *
 * @category Class
 *
 * @description Whether certain properties of the search response are calculated exhaustive (exact) or approximated.
 */
class Exhaustive extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'facetsCount' => 'bool',
        'facetValues' => 'bool',
        'nbHits' => 'bool',
        'rulesMatch' => 'bool',
        'typo' => 'bool',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'facetsCount' => null,
        'facetValues' => null,
        'nbHits' => null,
        'rulesMatch' => null,
        'typo' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'facetsCount' => 'facetsCount',
        'facetValues' => 'facetValues',
        'nbHits' => 'nbHits',
        'rulesMatch' => 'rulesMatch',
        'typo' => 'typo',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'facetsCount' => 'setFacetsCount',
        'facetValues' => 'setFacetValues',
        'nbHits' => 'setNbHits',
        'rulesMatch' => 'setRulesMatch',
        'typo' => 'setTypo',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'facetsCount' => 'getFacetsCount',
        'facetValues' => 'getFacetValues',
        'nbHits' => 'getNbHits',
        'rulesMatch' => 'getRulesMatch',
        'typo' => 'getTypo',
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
        if (isset($data['facetsCount'])) {
            $this->container['facetsCount'] = $data['facetsCount'];
        }
        if (isset($data['facetValues'])) {
            $this->container['facetValues'] = $data['facetValues'];
        }
        if (isset($data['nbHits'])) {
            $this->container['nbHits'] = $data['nbHits'];
        }
        if (isset($data['rulesMatch'])) {
            $this->container['rulesMatch'] = $data['rulesMatch'];
        }
        if (isset($data['typo'])) {
            $this->container['typo'] = $data['typo'];
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
     * Gets facetsCount.
     *
     * @return null|bool
     */
    public function getFacetsCount()
    {
        return $this->container['facetsCount'] ?? null;
    }

    /**
     * Sets facetsCount.
     *
     * @param null|bool $facetsCount Whether the facet count is exhaustive (`true`) or approximate (`false`). See the [related discussion](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).
     *
     * @return self
     */
    public function setFacetsCount($facetsCount)
    {
        $this->container['facetsCount'] = $facetsCount;

        return $this;
    }

    /**
     * Gets facetValues.
     *
     * @return null|bool
     */
    public function getFacetValues()
    {
        return $this->container['facetValues'] ?? null;
    }

    /**
     * Sets facetValues.
     *
     * @param null|bool $facetValues the value is `false` if not all facet values are retrieved
     *
     * @return self
     */
    public function setFacetValues($facetValues)
    {
        $this->container['facetValues'] = $facetValues;

        return $this;
    }

    /**
     * Gets nbHits.
     *
     * @return null|bool
     */
    public function getNbHits()
    {
        return $this->container['nbHits'] ?? null;
    }

    /**
     * Sets nbHits.
     *
     * @param null|bool $nbHits Whether the `nbHits` is exhaustive (`true`) or approximate (`false`). When the query takes more than 50ms to be processed, the engine makes an approximation. This can happen when using complex filters on millions of records, when typo-tolerance was not exhaustive, or when enough hits have been retrieved (for example, after the engine finds 10,000 exact matches). `nbHits` is reported as non-exhaustive whenever an approximation is made, even if the approximation didn’t, in the end, impact the exhaustivity of the query.
     *
     * @return self
     */
    public function setNbHits($nbHits)
    {
        $this->container['nbHits'] = $nbHits;

        return $this;
    }

    /**
     * Gets rulesMatch.
     *
     * @return null|bool
     */
    public function getRulesMatch()
    {
        return $this->container['rulesMatch'] ?? null;
    }

    /**
     * Sets rulesMatch.
     *
     * @param null|bool $rulesMatch Rules matching exhaustivity. The value is `false` if rules were enable for this query, and could not be fully processed due a timeout. This is generally caused by the number of alternatives (such as typos) which is too large.
     *
     * @return self
     */
    public function setRulesMatch($rulesMatch)
    {
        $this->container['rulesMatch'] = $rulesMatch;

        return $this;
    }

    /**
     * Gets typo.
     *
     * @return null|bool
     */
    public function getTypo()
    {
        return $this->container['typo'] ?? null;
    }

    /**
     * Sets typo.
     *
     * @param null|bool $typo Whether the typo search was exhaustive (`true`) or approximate (`false`). An approximation is done when the typo search query part takes more than 10% of the query budget (ie. 5ms by default) to be processed (this can happen when a lot of typo alternatives exist for the query). This field will not be included when typo-tolerance is entirely disabled.
     *
     * @return self
     */
    public function setTypo($typo)
    {
        $this->container['typo'] = $typo;

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
