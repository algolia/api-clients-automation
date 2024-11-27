<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * Rule Class Doc Comment.
 *
 * @category Class
 *
 * @description Rule object.
 */
class Rule extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'objectID' => 'string',
        'conditions' => '\Algolia\AlgoliaSearch\Model\Search\Condition[]',
        'consequence' => '\Algolia\AlgoliaSearch\Model\Search\Consequence',
        'description' => 'string',
        'enabled' => 'bool',
        'validity' => '\Algolia\AlgoliaSearch\Model\Search\TimeRange[]',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'objectID' => null,
        'conditions' => null,
        'consequence' => null,
        'description' => null,
        'enabled' => null,
        'validity' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'objectID' => 'objectID',
        'conditions' => 'conditions',
        'consequence' => 'consequence',
        'description' => 'description',
        'enabled' => 'enabled',
        'validity' => 'validity',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'objectID' => 'setObjectID',
        'conditions' => 'setConditions',
        'consequence' => 'setConsequence',
        'description' => 'setDescription',
        'enabled' => 'setEnabled',
        'validity' => 'setValidity',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'objectID' => 'getObjectID',
        'conditions' => 'getConditions',
        'consequence' => 'getConsequence',
        'description' => 'getDescription',
        'enabled' => 'getEnabled',
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
        if (isset($data['objectID'])) {
            $this->container['objectID'] = $data['objectID'];
        }
        if (isset($data['conditions'])) {
            $this->container['conditions'] = $data['conditions'];
        }
        if (isset($data['consequence'])) {
            $this->container['consequence'] = $data['consequence'];
        }
        if (isset($data['description'])) {
            $this->container['description'] = $data['description'];
        }
        if (isset($data['enabled'])) {
            $this->container['enabled'] = $data['enabled'];
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

        if (!isset($this->container['objectID']) || null === $this->container['objectID']) {
            $invalidProperties[] = "'objectID' can't be null";
        }
        if (!isset($this->container['consequence']) || null === $this->container['consequence']) {
            $invalidProperties[] = "'consequence' can't be null";
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
     * Gets objectID.
     *
     * @return string
     */
    public function getObjectID()
    {
        return $this->container['objectID'] ?? null;
    }

    /**
     * Sets objectID.
     *
     * @param string $objectID unique identifier of a rule object
     *
     * @return self
     */
    public function setObjectID($objectID)
    {
        $this->container['objectID'] = $objectID;

        return $this;
    }

    /**
     * Gets conditions.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Search\Condition[]
     */
    public function getConditions()
    {
        return $this->container['conditions'] ?? null;
    }

    /**
     * Sets conditions.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Search\Condition[] $conditions Conditions that trigger a rule.  Some consequences require specific conditions or don't require any condition. For more information, see [Conditions](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#conditions).
     *
     * @return self
     */
    public function setConditions($conditions)
    {
        $this->container['conditions'] = $conditions;

        return $this;
    }

    /**
     * Gets consequence.
     *
     * @return Consequence
     */
    public function getConsequence()
    {
        return $this->container['consequence'] ?? null;
    }

    /**
     * Sets consequence.
     *
     * @param Consequence $consequence consequence
     *
     * @return self
     */
    public function setConsequence($consequence)
    {
        $this->container['consequence'] = $consequence;

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
     * @param null|string $description description of the rule's purpose to help you distinguish between different rules
     *
     * @return self
     */
    public function setDescription($description)
    {
        $this->container['description'] = $description;

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
     * @param null|bool $enabled whether the rule is active
     *
     * @return self
     */
    public function setEnabled($enabled)
    {
        $this->container['enabled'] = $enabled;

        return $this;
    }

    /**
     * Gets validity.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Search\TimeRange[]
     */
    public function getValidity()
    {
        return $this->container['validity'] ?? null;
    }

    /**
     * Sets validity.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Search\TimeRange[] $validity time periods when the rule is active
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
