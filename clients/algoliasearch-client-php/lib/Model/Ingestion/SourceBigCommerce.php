<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * SourceBigCommerce Class Doc Comment.
 *
 * @category Class
 */
class SourceBigCommerce extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'storeHash' => 'string',
        'channel' => '\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceChannel',
        'customFields' => 'string[]',
        'productMetafields' => '\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceMetafield[]',
        'variantMetafields' => '\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceMetafield[]',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'storeHash' => null,
        'channel' => null,
        'customFields' => null,
        'productMetafields' => null,
        'variantMetafields' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'storeHash' => 'storeHash',
        'channel' => 'channel',
        'customFields' => 'customFields',
        'productMetafields' => 'productMetafields',
        'variantMetafields' => 'variantMetafields',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'storeHash' => 'setStoreHash',
        'channel' => 'setChannel',
        'customFields' => 'setCustomFields',
        'productMetafields' => 'setProductMetafields',
        'variantMetafields' => 'setVariantMetafields',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'storeHash' => 'getStoreHash',
        'channel' => 'getChannel',
        'customFields' => 'getCustomFields',
        'productMetafields' => 'getProductMetafields',
        'variantMetafields' => 'getVariantMetafields',
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
        if (isset($data['storeHash'])) {
            $this->container['storeHash'] = $data['storeHash'];
        }
        if (isset($data['channel'])) {
            $this->container['channel'] = $data['channel'];
        }
        if (isset($data['customFields'])) {
            $this->container['customFields'] = $data['customFields'];
        }
        if (isset($data['productMetafields'])) {
            $this->container['productMetafields'] = $data['productMetafields'];
        }
        if (isset($data['variantMetafields'])) {
            $this->container['variantMetafields'] = $data['variantMetafields'];
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
     * Gets storeHash.
     *
     * @return null|string
     */
    public function getStoreHash()
    {
        return $this->container['storeHash'] ?? null;
    }

    /**
     * Sets storeHash.
     *
     * @param null|string $storeHash the store hash identifying the store the shopper is signing in to
     *
     * @return self
     */
    public function setStoreHash($storeHash)
    {
        $this->container['storeHash'] = $storeHash;

        return $this;
    }

    /**
     * Gets channel.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceChannel
     */
    public function getChannel()
    {
        return $this->container['channel'] ?? null;
    }

    /**
     * Sets channel.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceChannel $channel channel
     *
     * @return self
     */
    public function setChannel($channel)
    {
        $this->container['channel'] = $channel;

        return $this;
    }

    /**
     * Gets customFields.
     *
     * @return null|string[]
     */
    public function getCustomFields()
    {
        return $this->container['customFields'] ?? null;
    }

    /**
     * Sets customFields.
     *
     * @param null|string[] $customFields customFields
     *
     * @return self
     */
    public function setCustomFields($customFields)
    {
        $this->container['customFields'] = $customFields;

        return $this;
    }

    /**
     * Gets productMetafields.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceMetafield[]
     */
    public function getProductMetafields()
    {
        return $this->container['productMetafields'] ?? null;
    }

    /**
     * Sets productMetafields.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceMetafield[] $productMetafields productMetafields
     *
     * @return self
     */
    public function setProductMetafields($productMetafields)
    {
        $this->container['productMetafields'] = $productMetafields;

        return $this;
    }

    /**
     * Gets variantMetafields.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceMetafield[]
     */
    public function getVariantMetafields()
    {
        return $this->container['variantMetafields'] ?? null;
    }

    /**
     * Sets variantMetafields.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceMetafield[] $variantMetafields variantMetafields
     *
     * @return self
     */
    public function setVariantMetafields($variantMetafields)
    {
        $this->container['variantMetafields'] = $variantMetafields;

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
