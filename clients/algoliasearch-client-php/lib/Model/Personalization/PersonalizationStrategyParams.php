<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Personalization;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * PersonalizationStrategyParams Class Doc Comment.
 *
 * @category Class
 */
class PersonalizationStrategyParams extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'eventsScoring' => '\Algolia\AlgoliaSearch\Model\Personalization\EventsScoring[]',
        'facetsScoring' => '\Algolia\AlgoliaSearch\Model\Personalization\FacetsScoring[]',
        'personalizationImpact' => 'int',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'eventsScoring' => null,
        'facetsScoring' => null,
        'personalizationImpact' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'eventsScoring' => 'eventsScoring',
        'facetsScoring' => 'facetsScoring',
        'personalizationImpact' => 'personalizationImpact',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'eventsScoring' => 'setEventsScoring',
        'facetsScoring' => 'setFacetsScoring',
        'personalizationImpact' => 'setPersonalizationImpact',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'eventsScoring' => 'getEventsScoring',
        'facetsScoring' => 'getFacetsScoring',
        'personalizationImpact' => 'getPersonalizationImpact',
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
        if (isset($data['eventsScoring'])) {
            $this->container['eventsScoring'] = $data['eventsScoring'];
        }
        if (isset($data['facetsScoring'])) {
            $this->container['facetsScoring'] = $data['facetsScoring'];
        }
        if (isset($data['personalizationImpact'])) {
            $this->container['personalizationImpact'] = $data['personalizationImpact'];
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

        if (!isset($this->container['eventsScoring']) || null === $this->container['eventsScoring']) {
            $invalidProperties[] = "'eventsScoring' can't be null";
        }
        if (!isset($this->container['facetsScoring']) || null === $this->container['facetsScoring']) {
            $invalidProperties[] = "'facetsScoring' can't be null";
        }
        if (!isset($this->container['personalizationImpact']) || null === $this->container['personalizationImpact']) {
            $invalidProperties[] = "'personalizationImpact' can't be null";
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
     * Gets eventsScoring.
     *
     * @return EventsScoring[]
     */
    public function getEventsScoring()
    {
        return $this->container['eventsScoring'] ?? null;
    }

    /**
     * Sets eventsScoring.
     *
     * @param EventsScoring[] $eventsScoring Scores associated with each event.  The higher the scores, the higher the impact of those events on the personalization of search results.
     *
     * @return self
     */
    public function setEventsScoring($eventsScoring)
    {
        $this->container['eventsScoring'] = $eventsScoring;

        return $this;
    }

    /**
     * Gets facetsScoring.
     *
     * @return FacetsScoring[]
     */
    public function getFacetsScoring()
    {
        return $this->container['facetsScoring'] ?? null;
    }

    /**
     * Sets facetsScoring.
     *
     * @param FacetsScoring[] $facetsScoring Scores associated with each facet.  The higher the scores, the higher the impact of those events on the personalization of search results.
     *
     * @return self
     */
    public function setFacetsScoring($facetsScoring)
    {
        $this->container['facetsScoring'] = $facetsScoring;

        return $this;
    }

    /**
     * Gets personalizationImpact.
     *
     * @return int
     */
    public function getPersonalizationImpact()
    {
        return $this->container['personalizationImpact'] ?? null;
    }

    /**
     * Sets personalizationImpact.
     *
     * @param int $personalizationImpact Impact of personalization on the search results.  If set to 0, personalization has no impact on the search results.
     *
     * @return self
     */
    public function setPersonalizationImpact($personalizationImpact)
    {
        $this->container['personalizationImpact'] = $personalizationImpact;

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
