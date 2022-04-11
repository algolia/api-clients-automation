<?php

namespace Algolia\AlgoliaSearch\Model\Recommend;

/**
 * SnippetResult Class Doc Comment
 *
 * @category Class
 * @package Algolia\AlgoliaSearch
 */
class SnippetResult extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
      * Array of property to type mappings. Used for (de)serialization
      *
      * @var string[]
      */
    protected static $modelTypes = [
        'value' => 'string',
        'matchLevel' => 'string',
    ];

    /**
      * Array of property to format mappings. Used for (de)serialization
      *
      * @var string[]
      */
    protected static $modelFormats = [
        'value' => null,
        'matchLevel' => null,
    ];

    /**
     * Array of property to type mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function modelTypes()
    {
        return self::$modelTypes;
    }

    /**
     * Array of property to format mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function modelFormats()
    {
        return self::$modelFormats;
    }

    /**
     * Array of attributes to setter functions (for deserialization of responses)
     *
     * @var string[]
     */
    protected static $setters = [
        'value' => 'setValue',
        'matchLevel' => 'setMatchLevel',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests)
     *
     * @var string[]
     */
    protected static $getters = [
        'value' => 'getValue',
        'matchLevel' => 'getMatchLevel',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses)
     *
     * @return array
     */
    public static function setters()
    {
        return self::$setters;
    }

    /**
     * Array of attributes to getter functions (for serialization of requests)
     *
     * @return array
     */
    public static function getters()
    {
        return self::$getters;
    }

    const MATCH_LEVEL_NONE = 'none';
    const MATCH_LEVEL_PARTIAL = 'partial';
    const MATCH_LEVEL_FULL = 'full';

    /**
     * Gets allowable values of the enum
     *
     * @return string[]
     */
    public function getMatchLevelAllowableValues()
    {
        return [
            self::MATCH_LEVEL_NONE,
            self::MATCH_LEVEL_PARTIAL,
            self::MATCH_LEVEL_FULL,
        ];
    }

    /**
     * Associative array for storing property values
     *
     * @var mixed[]
     */
    protected $container = [];

    /**
     * Constructor
     *
     * @param mixed[] $data Associated array of property values
     */
    public function __construct(array $data = null)
    {
        if (isset($data['value'])) {
            $this->container['value'] = $data['value'];
        }
        if (isset($data['matchLevel'])) {
            $this->container['matchLevel'] = $data['matchLevel'];
        }
    }

    /**
     * Show all the invalid properties with reasons.
     *
     * @return array invalid properties with reasons
     */
    public function listInvalidProperties()
    {
        $invalidProperties = [];

        $allowedValues = $this->getMatchLevelAllowableValues();
        if (isset($this->container['matchLevel']) && !in_array($this->container['matchLevel'], $allowedValues, true)) {
            $invalidProperties[] = sprintf(
                "invalid value '%s' for 'matchLevel', must be one of '%s'",
                $this->container['matchLevel'],
                implode("', '", $allowedValues)
            );
        }

        return $invalidProperties;
    }

    /**
     * Validate all the properties in the model
     * return true if all passed
     *
     * @return bool True if all properties are valid
     */
    public function valid()
    {
        return count($this->listInvalidProperties()) === 0;
    }

    /**
     * Gets value
     *
     * @return string|null
     */
    public function getValue()
    {
        return $this->container['value'] ?? null;
    }

    /**
     * Sets value
     *
     * @param string|null $value markup text with occurrences highlighted
     *
     * @return self
     */
    public function setValue($value)
    {
        $this->container['value'] = $value;

        return $this;
    }

    /**
     * Gets matchLevel
     *
     * @return string|null
     */
    public function getMatchLevel()
    {
        return $this->container['matchLevel'] ?? null;
    }

    /**
     * Sets matchLevel
     *
     * @param string|null $matchLevel indicates how well the attribute matched the search query
     *
     * @return self
     */
    public function setMatchLevel($matchLevel)
    {
        $allowedValues = $this->getMatchLevelAllowableValues();
        if (!is_null($matchLevel) && !in_array($matchLevel, $allowedValues, true)) {
            throw new \InvalidArgumentException(
                sprintf(
                    "Invalid value '%s' for 'matchLevel', must be one of '%s'",
                    $matchLevel,
                    implode("', '", $allowedValues)
                )
            );
        }
        $this->container['matchLevel'] = $matchLevel;

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
     * @return mixed|null
     */
    public function offsetGet($offset)
    {
        return $this->container[$offset] ?? null;
    }

    /**
     * Sets value based on offset.
     *
     * @param int|null $offset Offset
     * @param mixed    $value  Value to be set
     *
     * @return void
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
     *
     * @return void
     */
    public function offsetUnset($offset)
    {
        unset($this->container[$offset]);
    }
}

