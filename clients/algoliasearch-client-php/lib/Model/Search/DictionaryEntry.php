<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Search;

use Algolia\AlgoliaSearch\Model\AbstractModel;
use Algolia\AlgoliaSearch\Model\ModelInterface;

/**
 * DictionaryEntry Class Doc Comment.
 *
 * @category Class
 *
 * @description Dictionary entry.
 */
class DictionaryEntry extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'objectID' => 'string',
        'language' => '\Algolia\AlgoliaSearch\Model\Search\SupportedLanguage',
        'word' => 'string',
        'words' => 'string[]',
        'decomposition' => 'string[]',
        'state' => '\Algolia\AlgoliaSearch\Model\Search\DictionaryEntryState',
        'type' => '\Algolia\AlgoliaSearch\Model\Search\DictionaryEntryType',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'objectID' => null,
        'language' => null,
        'word' => null,
        'words' => null,
        'decomposition' => null,
        'state' => null,
        'type' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'objectID' => 'objectID',
        'language' => 'language',
        'word' => 'word',
        'words' => 'words',
        'decomposition' => 'decomposition',
        'state' => 'state',
        'type' => 'type',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'objectID' => 'setObjectID',
        'language' => 'setLanguage',
        'word' => 'setWord',
        'words' => 'setWords',
        'decomposition' => 'setDecomposition',
        'state' => 'setState',
        'type' => 'setType',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'objectID' => 'getObjectID',
        'language' => 'getLanguage',
        'word' => 'getWord',
        'words' => 'getWords',
        'decomposition' => 'getDecomposition',
        'state' => 'getState',
        'type' => 'getType',
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
        if (isset($data['language'])) {
            $this->container['language'] = $data['language'];
        }
        if (isset($data['word'])) {
            $this->container['word'] = $data['word'];
        }
        if (isset($data['words'])) {
            $this->container['words'] = $data['words'];
        }
        if (isset($data['decomposition'])) {
            $this->container['decomposition'] = $data['decomposition'];
        }
        if (isset($data['state'])) {
            $this->container['state'] = $data['state'];
        }
        if (isset($data['type'])) {
            $this->container['type'] = $data['type'];
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
     * @param string $objectID unique identifier for the dictionary entry
     *
     * @return self
     */
    public function setObjectID($objectID)
    {
        $this->container['objectID'] = $objectID;

        return $this;
    }

    /**
     * Gets language.
     *
     * @return null|SupportedLanguage
     */
    public function getLanguage()
    {
        return $this->container['language'] ?? null;
    }

    /**
     * Sets language.
     *
     * @param null|SupportedLanguage $language language
     *
     * @return self
     */
    public function setLanguage($language)
    {
        $this->container['language'] = $language;

        return $this;
    }

    /**
     * Gets word.
     *
     * @return null|string
     */
    public function getWord()
    {
        return $this->container['word'] ?? null;
    }

    /**
     * Sets word.
     *
     * @param null|string $word matching dictionary word for `stopwords` and `compounds` dictionaries
     *
     * @return self
     */
    public function setWord($word)
    {
        $this->container['word'] = $word;

        return $this;
    }

    /**
     * Gets words.
     *
     * @return null|string[]
     */
    public function getWords()
    {
        return $this->container['words'] ?? null;
    }

    /**
     * Sets words.
     *
     * @param null|string[] $words matching words in the `plurals` dictionary including declensions
     *
     * @return self
     */
    public function setWords($words)
    {
        $this->container['words'] = $words;

        return $this;
    }

    /**
     * Gets decomposition.
     *
     * @return null|string[]
     */
    public function getDecomposition()
    {
        return $this->container['decomposition'] ?? null;
    }

    /**
     * Sets decomposition.
     *
     * @param null|string[] $decomposition invividual components of a compound word in the `compounds` dictionary
     *
     * @return self
     */
    public function setDecomposition($decomposition)
    {
        $this->container['decomposition'] = $decomposition;

        return $this;
    }

    /**
     * Gets state.
     *
     * @return null|DictionaryEntryState
     */
    public function getState()
    {
        return $this->container['state'] ?? null;
    }

    /**
     * Sets state.
     *
     * @param null|DictionaryEntryState $state state
     *
     * @return self
     */
    public function setState($state)
    {
        $this->container['state'] = $state;

        return $this;
    }

    /**
     * Gets type.
     *
     * @return null|DictionaryEntryType
     */
    public function getType()
    {
        return $this->container['type'] ?? null;
    }

    /**
     * Sets type.
     *
     * @param null|DictionaryEntryType $type type
     *
     * @return self
     */
    public function setType($type)
    {
        $this->container['type'] = $type;

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
