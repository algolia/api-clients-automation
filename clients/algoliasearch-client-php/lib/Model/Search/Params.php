<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

/**
 * Params Class Doc Comment.
 *
 * @category Class
 * @description Parameters to apply to this search.  You can use all search parameters, plus special &#x60;automaticFacetFilters&#x60;, &#x60;automaticOptionalFacetFilters&#x60;, and &#x60;query&#x60;.
 */
class Params extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'query' => '\Algolia\AlgoliaSearch\Model\Search\ConsequenceQuery',
        'automaticFacetFilters' => '\Algolia\AlgoliaSearch\Model\Search\AutomaticFacetFilters',
        'automaticOptionalFacetFilters' => '\Algolia\AlgoliaSearch\Model\Search\AutomaticFacetFilters',
        'renderingContent' => '\Algolia\AlgoliaSearch\Model\Search\RenderingContent',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'query' => null,
        'automaticFacetFilters' => null,
        'automaticOptionalFacetFilters' => null,
        'renderingContent' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'query' => 'query',
        'automaticFacetFilters' => 'automaticFacetFilters',
        'automaticOptionalFacetFilters' => 'automaticOptionalFacetFilters',
        'renderingContent' => 'renderingContent',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'query' => 'setQuery',
        'automaticFacetFilters' => 'setAutomaticFacetFilters',
        'automaticOptionalFacetFilters' => 'setAutomaticOptionalFacetFilters',
        'renderingContent' => 'setRenderingContent',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'query' => 'getQuery',
        'automaticFacetFilters' => 'getAutomaticFacetFilters',
        'automaticOptionalFacetFilters' => 'getAutomaticOptionalFacetFilters',
        'renderingContent' => 'getRenderingContent',
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
        if (isset($data['query'])) {
            $this->container['query'] = $data['query'];
        }
        if (isset($data['automaticFacetFilters'])) {
            $this->container['automaticFacetFilters'] = $data['automaticFacetFilters'];
        }
        if (isset($data['automaticOptionalFacetFilters'])) {
            $this->container['automaticOptionalFacetFilters'] = $data['automaticOptionalFacetFilters'];
        }
        if (isset($data['renderingContent'])) {
            $this->container['renderingContent'] = $data['renderingContent'];
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
     * Gets query.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Search\ConsequenceQuery
     */
    public function getQuery()
    {
        return $this->container['query'] ?? null;
    }

    /**
     * Sets query.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Search\ConsequenceQuery $query query
     *
     * @return self
     */
    public function setQuery($query)
    {
        $this->container['query'] = $query;

        return $this;
    }

    /**
     * Gets automaticFacetFilters.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Search\AutomaticFacetFilters
     */
    public function getAutomaticFacetFilters()
    {
        return $this->container['automaticFacetFilters'] ?? null;
    }

    /**
     * Sets automaticFacetFilters.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Search\AutomaticFacetFilters $automaticFacetFilters automaticFacetFilters
     *
     * @return self
     */
    public function setAutomaticFacetFilters($automaticFacetFilters)
    {
        $this->container['automaticFacetFilters'] = $automaticFacetFilters;

        return $this;
    }

    /**
     * Gets automaticOptionalFacetFilters.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Search\AutomaticFacetFilters
     */
    public function getAutomaticOptionalFacetFilters()
    {
        return $this->container['automaticOptionalFacetFilters'] ?? null;
    }

    /**
     * Sets automaticOptionalFacetFilters.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Search\AutomaticFacetFilters $automaticOptionalFacetFilters automaticOptionalFacetFilters
     *
     * @return self
     */
    public function setAutomaticOptionalFacetFilters($automaticOptionalFacetFilters)
    {
        $this->container['automaticOptionalFacetFilters'] = $automaticOptionalFacetFilters;

        return $this;
    }

    /**
     * Gets renderingContent.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Search\RenderingContent
     */
    public function getRenderingContent()
    {
        return $this->container['renderingContent'] ?? null;
    }

    /**
     * Sets renderingContent.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Search\RenderingContent $renderingContent renderingContent
     *
     * @return self
     */
    public function setRenderingContent($renderingContent)
    {
        $this->container['renderingContent'] = $renderingContent;

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
