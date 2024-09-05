<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * ApiKey Class Doc Comment.
 *
 * @category Class
 *
 * @description API key object.
 */
class ApiKey extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'acl' => '\Algolia\AlgoliaSearch\Model\Search\Acl[]',
        'description' => 'string',
        'indexes' => 'string[]',
        'maxHitsPerQuery' => 'int',
        'maxQueriesPerIPPerHour' => 'int',
        'queryParameters' => 'string',
        'referers' => 'string[]',
        'validity' => 'int',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'acl' => null,
        'description' => null,
        'indexes' => null,
        'maxHitsPerQuery' => null,
        'maxQueriesPerIPPerHour' => null,
        'queryParameters' => null,
        'referers' => null,
        'validity' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'acl' => 'acl',
        'description' => 'description',
        'indexes' => 'indexes',
        'maxHitsPerQuery' => 'maxHitsPerQuery',
        'maxQueriesPerIPPerHour' => 'maxQueriesPerIPPerHour',
        'queryParameters' => 'queryParameters',
        'referers' => 'referers',
        'validity' => 'validity',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'acl' => 'setAcl',
        'description' => 'setDescription',
        'indexes' => 'setIndexes',
        'maxHitsPerQuery' => 'setMaxHitsPerQuery',
        'maxQueriesPerIPPerHour' => 'setMaxQueriesPerIPPerHour',
        'queryParameters' => 'setQueryParameters',
        'referers' => 'setReferers',
        'validity' => 'setValidity',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'acl' => 'getAcl',
        'description' => 'getDescription',
        'indexes' => 'getIndexes',
        'maxHitsPerQuery' => 'getMaxHitsPerQuery',
        'maxQueriesPerIPPerHour' => 'getMaxQueriesPerIPPerHour',
        'queryParameters' => 'getQueryParameters',
        'referers' => 'getReferers',
        'validity' => 'getValidity',
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
        if (isset($data['acl'])) {
            $this->container['acl'] = $data['acl'];
        }
        if (isset($data['description'])) {
            $this->container['description'] = $data['description'];
        }
        if (isset($data['indexes'])) {
            $this->container['indexes'] = $data['indexes'];
        }
        if (isset($data['maxHitsPerQuery'])) {
            $this->container['maxHitsPerQuery'] = $data['maxHitsPerQuery'];
        }
        if (isset($data['maxQueriesPerIPPerHour'])) {
            $this->container['maxQueriesPerIPPerHour'] = $data['maxQueriesPerIPPerHour'];
        }
        if (isset($data['queryParameters'])) {
            $this->container['queryParameters'] = $data['queryParameters'];
        }
        if (isset($data['referers'])) {
            $this->container['referers'] = $data['referers'];
        }
        if (isset($data['validity'])) {
            $this->container['validity'] = $data['validity'];
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

        if (!isset($this->container['acl']) || null === $this->container['acl']) {
            $invalidProperties[] = "'acl' can't be null";
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
     * Gets acl.
     *
     * @return \Algolia\AlgoliaSearch\Model\Search\Acl[]
     */
    public function getAcl()
    {
        return $this->container['acl'] ?? null;
    }

    /**
     * Sets acl.
     *
     * @param \Algolia\AlgoliaSearch\Model\Search\Acl[] $acl Permissions that determine the type of API requests this key can make. The required ACL is listed in each endpoint's reference. For more information, see [access control list](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl).
     *
     * @return self
     */
    public function setAcl($acl)
    {
        $this->container['acl'] = $acl;

        return $this;
    }

    /**
     * Gets description.
     *
     * @return null|string
     */
    public function getDescription()
    {
        return $this->container['description'] ?? null;
    }

    /**
     * Sets description.
     *
     * @param null|string $description description of an API key to help you identify this API key
     *
     * @return self
     */
    public function setDescription($description)
    {
        $this->container['description'] = $description;

        return $this;
    }

    /**
     * Gets indexes.
     *
     * @return null|string[]
     */
    public function getIndexes()
    {
        return $this->container['indexes'] ?? null;
    }

    /**
     * Sets indexes.
     *
     * @param null|string[] $indexes Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\".
     *
     * @return self
     */
    public function setIndexes($indexes)
    {
        $this->container['indexes'] = $indexes;

        return $this;
    }

    /**
     * Gets maxHitsPerQuery.
     *
     * @return null|int
     */
    public function getMaxHitsPerQuery()
    {
        return $this->container['maxHitsPerQuery'] ?? null;
    }

    /**
     * Sets maxHitsPerQuery.
     *
     * @param null|int $maxHitsPerQuery Maximum number of results this API key can retrieve in one query. By default, there's no limit.
     *
     * @return self
     */
    public function setMaxHitsPerQuery($maxHitsPerQuery)
    {
        $this->container['maxHitsPerQuery'] = $maxHitsPerQuery;

        return $this;
    }

    /**
     * Gets maxQueriesPerIPPerHour.
     *
     * @return null|int
     */
    public function getMaxQueriesPerIPPerHour()
    {
        return $this->container['maxQueriesPerIPPerHour'] ?? null;
    }

    /**
     * Sets maxQueriesPerIPPerHour.
     *
     * @param null|int $maxQueriesPerIPPerHour Maximum number of API requests allowed per IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) per hour.  If this limit is reached, the API returns an error with status code `429`. By default, there's no limit.
     *
     * @return self
     */
    public function setMaxQueriesPerIPPerHour($maxQueriesPerIPPerHour)
    {
        $this->container['maxQueriesPerIPPerHour'] = $maxQueriesPerIPPerHour;

        return $this;
    }

    /**
     * Gets queryParameters.
     *
     * @return null|string
     */
    public function getQueryParameters()
    {
        return $this->container['queryParameters'] ?? null;
    }

    /**
     * Sets queryParameters.
     *
     * @param null|string $queryParameters Query parameters to add when making API requests with this API key.  To restrict this API key to specific IP addresses, add the `restrictSources` parameter. You can only add a single source, but you can provide a range of IP addresses.  Creating an API key fails if the request is made from an IP address that's outside the restricted range.
     *
     * @return self
     */
    public function setQueryParameters($queryParameters)
    {
        $this->container['queryParameters'] = $queryParameters;

        return $this;
    }

    /**
     * Gets referers.
     *
     * @return null|string[]
     */
    public function getReferers()
    {
        return $this->container['referers'] ?? null;
    }

    /**
     * Sets referers.
     *
     * @param null|string[] $referers Allowed HTTP referrers for this API key.  By default, all referrers are allowed. You can use leading and trailing wildcard characters (`*`):  - `https://algolia.com/_*` allows all referrers starting with \"https://algolia.com/\" - `*.algolia.com` allows all referrers ending with \".algolia.com\" - `*algolia.com*` allows all referrers in the domain \"algolia.com\".  Like all HTTP headers, referrers can be spoofed. Don't rely on them to secure your data. For more information, see [HTTP referrer restrictions](https://www.algolia.com/doc/guides/security/security-best-practices/#http-referrers-restrictions).
     *
     * @return self
     */
    public function setReferers($referers)
    {
        $this->container['referers'] = $referers;

        return $this;
    }

    /**
     * Gets validity.
     *
     * @return null|int
     */
    public function getValidity()
    {
        return $this->container['validity'] ?? null;
    }

    /**
     * Sets validity.
     *
     * @param null|int $validity Duration (in seconds) after which the API key expires. By default, API keys don't expire.
     *
     * @return self
     */
    public function setValidity($validity)
    {
        $this->container['validity'] = $validity;

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
