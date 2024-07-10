<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * SearchRulesParams Class Doc Comment.
 *
 * @category Class
 *
 * @description Rules search parameters.
 */
class SearchRulesParams extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'query' => 'string',
        'anchoring' => '\Algolia\AlgoliaSearch\Model\Search\Anchoring',
        'context' => 'string',
        'page' => 'int',
        'hitsPerPage' => 'int',
        'enabled' => 'bool',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'query' => null,
        'anchoring' => null,
        'context' => null,
        'page' => null,
        'hitsPerPage' => null,
        'enabled' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'query' => 'query',
        'anchoring' => 'anchoring',
        'context' => 'context',
        'page' => 'page',
        'hitsPerPage' => 'hitsPerPage',
        'enabled' => 'enabled',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'query' => 'setQuery',
        'anchoring' => 'setAnchoring',
        'context' => 'setContext',
        'page' => 'setPage',
        'hitsPerPage' => 'setHitsPerPage',
        'enabled' => 'setEnabled',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'query' => 'getQuery',
        'anchoring' => 'getAnchoring',
        'context' => 'getContext',
        'page' => 'getPage',
        'hitsPerPage' => 'getHitsPerPage',
        'enabled' => 'getEnabled',
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
        if (isset($data['query'])) {
            $this->container['query'] = $data['query'];
        }
        if (isset($data['anchoring'])) {
            $this->container['anchoring'] = $data['anchoring'];
        }
        if (isset($data['context'])) {
            $this->container['context'] = $data['context'];
        }
        if (isset($data['page'])) {
            $this->container['page'] = $data['page'];
        }
        if (isset($data['hitsPerPage'])) {
            $this->container['hitsPerPage'] = $data['hitsPerPage'];
        }
        if (isset($data['enabled'])) {
            $this->container['enabled'] = $data['enabled'];
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

        if (isset($this->container['page']) && ($this->container['page'] < 0)) {
            $invalidProperties[] = "invalid value for 'page', must be bigger than or equal to 0.";
        }

        if (isset($this->container['hitsPerPage']) && ($this->container['hitsPerPage'] > 1000)) {
            $invalidProperties[] = "invalid value for 'hitsPerPage', must be smaller than or equal to 1000.";
        }

        if (isset($this->container['hitsPerPage']) && ($this->container['hitsPerPage'] < 1)) {
            $invalidProperties[] = "invalid value for 'hitsPerPage', must be bigger than or equal to 1.";
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
     * Gets query.
     *
     * @return null|string
     */
    public function getQuery()
    {
        return $this->container['query'] ?? null;
    }

    /**
     * Sets query.
     *
     * @param null|string $query search query for rules
     *
     * @return self
     */
    public function setQuery($query)
    {
        $this->container['query'] = $query;

        return $this;
    }

    /**
     * Gets anchoring.
     *
     * @return null|Anchoring
     */
    public function getAnchoring()
    {
        return $this->container['anchoring'] ?? null;
    }

    /**
     * Sets anchoring.
     *
     * @param null|Anchoring $anchoring anchoring
     *
     * @return self
     */
    public function setAnchoring($anchoring)
    {
        $this->container['anchoring'] = $anchoring;

        return $this;
    }

    /**
     * Gets context.
     *
     * @return null|string
     */
    public function getContext()
    {
        return $this->container['context'] ?? null;
    }

    /**
     * Sets context.
     *
     * @param null|string $context only return rules that match the context (exact match)
     *
     * @return self
     */
    public function setContext($context)
    {
        $this->container['context'] = $context;

        return $this;
    }

    /**
     * Gets page.
     *
     * @return null|int
     */
    public function getPage()
    {
        return $this->container['page'] ?? null;
    }

    /**
     * Sets page.
     *
     * @param null|int $page requested page of the API response
     *
     * @return self
     */
    public function setPage($page)
    {
        if (!is_null($page) && ($page < 0)) {
            throw new \InvalidArgumentException('invalid value for $page when calling SearchRulesParams., must be bigger than or equal to 0.');
        }

        $this->container['page'] = $page;

        return $this;
    }

    /**
     * Gets hitsPerPage.
     *
     * @return null|int
     */
    public function getHitsPerPage()
    {
        return $this->container['hitsPerPage'] ?? null;
    }

    /**
     * Sets hitsPerPage.
     *
     * @param null|int $hitsPerPage maximum number of hits per page
     *
     * @return self
     */
    public function setHitsPerPage($hitsPerPage)
    {
        if (!is_null($hitsPerPage) && ($hitsPerPage > 1000)) {
            throw new \InvalidArgumentException('invalid value for $hitsPerPage when calling SearchRulesParams., must be smaller than or equal to 1000.');
        }
        if (!is_null($hitsPerPage) && ($hitsPerPage < 1)) {
            throw new \InvalidArgumentException('invalid value for $hitsPerPage when calling SearchRulesParams., must be bigger than or equal to 1.');
        }

        $this->container['hitsPerPage'] = $hitsPerPage;

        return $this;
    }

    /**
     * Gets enabled.
     *
     * @return null|bool
     */
    public function getEnabled()
    {
        return $this->container['enabled'] ?? null;
    }

    /**
     * Sets enabled.
     *
     * @param null|bool $enabled If `true`, return only enabled rules. If `false`, return only inactive rules. By default, _all_ rules are returned.
     *
     * @return self
     */
    public function setEnabled($enabled)
    {
        $this->container['enabled'] = $enabled;

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
