<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * Pagination Class Doc Comment.
 *
 * @category Class
 *
 * @description Paginated API response.
 */
class Pagination extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'nbPages' => 'int',
        'page' => 'int',
        'nbItems' => 'int',
        'itemsPerPage' => 'int',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'nbPages' => null,
        'page' => null,
        'nbItems' => null,
        'itemsPerPage' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'nbPages' => 'nbPages',
        'page' => 'page',
        'nbItems' => 'nbItems',
        'itemsPerPage' => 'itemsPerPage',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'nbPages' => 'setNbPages',
        'page' => 'setPage',
        'nbItems' => 'setNbItems',
        'itemsPerPage' => 'setItemsPerPage',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'nbPages' => 'getNbPages',
        'page' => 'getPage',
        'nbItems' => 'getNbItems',
        'itemsPerPage' => 'getItemsPerPage',
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
        if (isset($data['nbPages'])) {
            $this->container['nbPages'] = $data['nbPages'];
        }
        if (isset($data['page'])) {
            $this->container['page'] = $data['page'];
        }
        if (isset($data['nbItems'])) {
            $this->container['nbItems'] = $data['nbItems'];
        }
        if (isset($data['itemsPerPage'])) {
            $this->container['itemsPerPage'] = $data['itemsPerPage'];
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

        if (!isset($this->container['nbPages']) || null === $this->container['nbPages']) {
            $invalidProperties[] = "'nbPages' can't be null";
        }
        if ($this->container['nbPages'] < 1) {
            $invalidProperties[] = "invalid value for 'nbPages', must be bigger than or equal to 1.";
        }

        if (!isset($this->container['page']) || null === $this->container['page']) {
            $invalidProperties[] = "'page' can't be null";
        }
        if ($this->container['page'] < 1) {
            $invalidProperties[] = "invalid value for 'page', must be bigger than or equal to 1.";
        }

        if (!isset($this->container['nbItems']) || null === $this->container['nbItems']) {
            $invalidProperties[] = "'nbItems' can't be null";
        }
        if ($this->container['nbItems'] < 0) {
            $invalidProperties[] = "invalid value for 'nbItems', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['itemsPerPage']) || null === $this->container['itemsPerPage']) {
            $invalidProperties[] = "'itemsPerPage' can't be null";
        }
        if ($this->container['itemsPerPage'] > 100) {
            $invalidProperties[] = "invalid value for 'itemsPerPage', must be smaller than or equal to 100.";
        }

        if ($this->container['itemsPerPage'] < 1) {
            $invalidProperties[] = "invalid value for 'itemsPerPage', must be bigger than or equal to 1.";
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
     * Gets nbPages.
     *
     * @return int
     */
    public function getNbPages()
    {
        return $this->container['nbPages'] ?? null;
    }

    /**
     * Sets nbPages.
     *
     * @param int $nbPages number of pages in the API response
     *
     * @return self
     */
    public function setNbPages($nbPages)
    {
        if ($nbPages < 1) {
            throw new \InvalidArgumentException('invalid value for $nbPages when calling Pagination., must be bigger than or equal to 1.');
        }

        $this->container['nbPages'] = $nbPages;

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
     * @param int $page page of the API response to retrieve
     *
     * @return self
     */
    public function setPage($page)
    {
        if ($page < 1) {
            throw new \InvalidArgumentException('invalid value for $page when calling Pagination., must be bigger than or equal to 1.');
        }

        $this->container['page'] = $page;

        return $this;
    }

    /**
     * Gets nbItems.
     *
     * @return int
     */
    public function getNbItems()
    {
        return $this->container['nbItems'] ?? null;
    }

    /**
     * Sets nbItems.
     *
     * @param int $nbItems number of items in the API response
     *
     * @return self
     */
    public function setNbItems($nbItems)
    {
        if ($nbItems < 0) {
            throw new \InvalidArgumentException('invalid value for $nbItems when calling Pagination., must be bigger than or equal to 0.');
        }

        $this->container['nbItems'] = $nbItems;

        return $this;
    }

    /**
     * Gets itemsPerPage.
     *
     * @return int
     */
    public function getItemsPerPage()
    {
        return $this->container['itemsPerPage'] ?? null;
    }

    /**
     * Sets itemsPerPage.
     *
     * @param int $itemsPerPage number of items per page
     *
     * @return self
     */
    public function setItemsPerPage($itemsPerPage)
    {
        if ($itemsPerPage > 100) {
            throw new \InvalidArgumentException('invalid value for $itemsPerPage when calling Pagination., must be smaller than or equal to 100.');
        }
        if ($itemsPerPage < 1) {
            throw new \InvalidArgumentException('invalid value for $itemsPerPage when calling Pagination., must be bigger than or equal to 1.');
        }

        $this->container['itemsPerPage'] = $itemsPerPage;

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
