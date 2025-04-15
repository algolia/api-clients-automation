<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * SourceUpdateCommercetools Class Doc Comment.
 *
 * @category Class
 */
class SourceUpdateCommercetools extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'storeKeys' => 'string[]',
        'locales' => 'string[]',
        'url' => 'string',
        'fallbackIsInStockValue' => 'bool',
        'productQueryPredicate' => 'string',
        'customFields' => '\Algolia\AlgoliaSearch\Model\Ingestion\CommercetoolsCustomFields',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'storeKeys' => null,
        'locales' => null,
        'url' => null,
        'fallbackIsInStockValue' => null,
        'productQueryPredicate' => null,
        'customFields' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'storeKeys' => 'storeKeys',
        'locales' => 'locales',
        'url' => 'url',
        'fallbackIsInStockValue' => 'fallbackIsInStockValue',
        'productQueryPredicate' => 'productQueryPredicate',
        'customFields' => 'customFields',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'storeKeys' => 'setStoreKeys',
        'locales' => 'setLocales',
        'url' => 'setUrl',
        'fallbackIsInStockValue' => 'setFallbackIsInStockValue',
        'productQueryPredicate' => 'setProductQueryPredicate',
        'customFields' => 'setCustomFields',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'storeKeys' => 'getStoreKeys',
        'locales' => 'getLocales',
        'url' => 'getUrl',
        'fallbackIsInStockValue' => 'getFallbackIsInStockValue',
        'productQueryPredicate' => 'getProductQueryPredicate',
        'customFields' => 'getCustomFields',
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
        if (isset($data['storeKeys'])) {
            $this->container['storeKeys'] = $data['storeKeys'];
        }
        if (isset($data['locales'])) {
            $this->container['locales'] = $data['locales'];
        }
        if (isset($data['url'])) {
            $this->container['url'] = $data['url'];
        }
        if (isset($data['fallbackIsInStockValue'])) {
            $this->container['fallbackIsInStockValue'] = $data['fallbackIsInStockValue'];
        }
        if (isset($data['productQueryPredicate'])) {
            $this->container['productQueryPredicate'] = $data['productQueryPredicate'];
        }
        if (isset($data['customFields'])) {
            $this->container['customFields'] = $data['customFields'];
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
     * Gets storeKeys.
     *
     * @return null|string[]
     */
    public function getStoreKeys()
    {
        return $this->container['storeKeys'] ?? null;
    }

    /**
     * Sets storeKeys.
     *
     * @param null|string[] $storeKeys storeKeys
     *
     * @return self
     */
    public function setStoreKeys($storeKeys)
    {
        $this->container['storeKeys'] = $storeKeys;

        return $this;
    }

    /**
     * Gets locales.
     *
     * @return null|string[]
     */
    public function getLocales()
    {
        return $this->container['locales'] ?? null;
    }

    /**
     * Sets locales.
     *
     * @param null|string[] $locales locales for your commercetools stores
     *
     * @return self
     */
    public function setLocales($locales)
    {
        $this->container['locales'] = $locales;

        return $this;
    }

    /**
     * Gets url.
     *
     * @return null|string
     */
    public function getUrl()
    {
        return $this->container['url'] ?? null;
    }

    /**
     * Sets url.
     *
     * @param null|string $url url
     *
     * @return self
     */
    public function setUrl($url)
    {
        $this->container['url'] = $url;

        return $this;
    }

    /**
     * Gets fallbackIsInStockValue.
     *
     * @return null|bool
     */
    public function getFallbackIsInStockValue()
    {
        return $this->container['fallbackIsInStockValue'] ?? null;
    }

    /**
     * Sets fallbackIsInStockValue.
     *
     * @param null|bool $fallbackIsInStockValue whether a fallback value is stored in the Algolia record if there's no inventory information about the product
     *
     * @return self
     */
    public function setFallbackIsInStockValue($fallbackIsInStockValue)
    {
        $this->container['fallbackIsInStockValue'] = $fallbackIsInStockValue;

        return $this;
    }

    /**
     * Gets productQueryPredicate.
     *
     * @return null|string
     */
    public function getProductQueryPredicate()
    {
        return $this->container['productQueryPredicate'] ?? null;
    }

    /**
     * Sets productQueryPredicate.
     *
     * @param null|string $productQueryPredicate Predicate to filter out specific products when indexing. For more information, see [Query Predicate](https://docs.commercetools.com/api/predicates/query).
     *
     * @return self
     */
    public function setProductQueryPredicate($productQueryPredicate)
    {
        $this->container['productQueryPredicate'] = $productQueryPredicate;

        return $this;
    }

    /**
     * Gets customFields.
     *
     * @return null|CommercetoolsCustomFields
     */
    public function getCustomFields()
    {
        return $this->container['customFields'] ?? null;
    }

    /**
     * Sets customFields.
     *
     * @param null|CommercetoolsCustomFields $customFields customFields
     *
     * @return self
     */
    public function setCustomFields($customFields)
    {
        $this->container['customFields'] = $customFields;

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
