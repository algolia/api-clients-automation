<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * SearchUserIdsResponse Class Doc Comment.
 *
 * @category Class
 *
 * @description userIDs data.
 */
class SearchUserIdsResponse extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'hits' => '\Algolia\AlgoliaSearch\Model\Search\UserHit[]',
        'nbHits' => 'int',
        'page' => 'int',
        'hitsPerPage' => 'int',
        'updatedAt' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'hits' => null,
        'nbHits' => null,
        'page' => null,
        'hitsPerPage' => null,
        'updatedAt' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'hits' => 'hits',
        'nbHits' => 'nbHits',
        'page' => 'page',
        'hitsPerPage' => 'hitsPerPage',
        'updatedAt' => 'updatedAt',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'hits' => 'setHits',
        'nbHits' => 'setNbHits',
        'page' => 'setPage',
        'hitsPerPage' => 'setHitsPerPage',
        'updatedAt' => 'setUpdatedAt',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'hits' => 'getHits',
        'nbHits' => 'getNbHits',
        'page' => 'getPage',
        'hitsPerPage' => 'getHitsPerPage',
        'updatedAt' => 'getUpdatedAt',
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
        if (isset($data['hits'])) {
            $this->container['hits'] = $data['hits'];
        }
        if (isset($data['nbHits'])) {
            $this->container['nbHits'] = $data['nbHits'];
        }
        if (isset($data['page'])) {
            $this->container['page'] = $data['page'];
        }
        if (isset($data['hitsPerPage'])) {
            $this->container['hitsPerPage'] = $data['hitsPerPage'];
        }
        if (isset($data['updatedAt'])) {
            $this->container['updatedAt'] = $data['updatedAt'];
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

        if (!isset($this->container['hits']) || null === $this->container['hits']) {
            $invalidProperties[] = "'hits' can't be null";
        }
        if (!isset($this->container['nbHits']) || null === $this->container['nbHits']) {
            $invalidProperties[] = "'nbHits' can't be null";
        }
        if (!isset($this->container['page']) || null === $this->container['page']) {
            $invalidProperties[] = "'page' can't be null";
        }
        if ($this->container['page'] < 0) {
            $invalidProperties[] = "invalid value for 'page', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['hitsPerPage']) || null === $this->container['hitsPerPage']) {
            $invalidProperties[] = "'hitsPerPage' can't be null";
        }
        if ($this->container['hitsPerPage'] > 1000) {
            $invalidProperties[] = "invalid value for 'hitsPerPage', must be smaller than or equal to 1000.";
        }

        if ($this->container['hitsPerPage'] < 1) {
            $invalidProperties[] = "invalid value for 'hitsPerPage', must be bigger than or equal to 1.";
        }

        if (!isset($this->container['updatedAt']) || null === $this->container['updatedAt']) {
            $invalidProperties[] = "'updatedAt' can't be null";
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
     * Gets hits.
     *
     * @return \Algolia\AlgoliaSearch\Model\Search\UserHit[]
     */
    public function getHits()
    {
        return $this->container['hits'] ?? null;
    }

    /**
     * Sets hits.
     *
     * @param \Algolia\AlgoliaSearch\Model\Search\UserHit[] $hits user objects that match the query
     *
     * @return self
     */
    public function setHits($hits)
    {
        $this->container['hits'] = $hits;

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
     * Gets page.
     *
     * @return int
     */
    public function getPage()
    {
        return $this->container['page'] ?? null;
    }

    /**
     * Sets page.
     *
     * @param int $page page of search results to retrieve
     *
     * @return self
     */
    public function setPage($page)
    {
        if ($page < 0) {
            throw new \InvalidArgumentException('invalid value for $page when calling SearchUserIdsResponse., must be bigger than or equal to 0.');
        }

        $this->container['page'] = $page;

        return $this;
    }

    /**
     * Gets hitsPerPage.
     *
     * @return int
     */
    public function getHitsPerPage()
    {
        return $this->container['hitsPerPage'] ?? null;
    }

    /**
     * Sets hitsPerPage.
     *
     * @param int $hitsPerPage maximum number of hits per page
     *
     * @return self
     */
    public function setHitsPerPage($hitsPerPage)
    {
        if ($hitsPerPage > 1000) {
            throw new \InvalidArgumentException('invalid value for $hitsPerPage when calling SearchUserIdsResponse., must be smaller than or equal to 1000.');
        }
        if ($hitsPerPage < 1) {
            throw new \InvalidArgumentException('invalid value for $hitsPerPage when calling SearchUserIdsResponse., must be bigger than or equal to 1.');
        }

        $this->container['hitsPerPage'] = $hitsPerPage;

        return $this;
    }

    /**
     * Gets updatedAt.
     *
     * @return string
     */
    public function getUpdatedAt()
    {
        return $this->container['updatedAt'] ?? null;
    }

    /**
     * Sets updatedAt.
     *
     * @param string $updatedAt date and time when the object was updated, in RFC 3339 format
     *
     * @return self
     */
    public function setUpdatedAt($updatedAt)
    {
        $this->container['updatedAt'] = $updatedAt;

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
