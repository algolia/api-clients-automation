<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

use Algolia\AlgoliaSearch\Model\AbstractModel;

/**
 * AuthInput Class Doc Comment.
 *
 * @category Class
 */
class AuthInput extends AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'clientEmail' => 'string',
        'privateKey' => 'string',
        'username' => 'string',
        'password' => 'string',
        'key' => 'string',
        'url' => 'string',
        'clientId' => 'string',
        'clientSecret' => 'string',
        'scope' => 'string',
        'appID' => 'string',
        'apiKey' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'clientEmail' => null,
        'privateKey' => null,
        'username' => null,
        'password' => null,
        'key' => null,
        'url' => null,
        'clientId' => null,
        'clientSecret' => null,
        'scope' => null,
        'appID' => null,
        'apiKey' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'clientEmail' => 'clientEmail',
        'privateKey' => 'privateKey',
        'username' => 'username',
        'password' => 'password',
        'key' => 'key',
        'url' => 'url',
        'clientId' => 'client_id',
        'clientSecret' => 'client_secret',
        'scope' => 'scope',
        'appID' => 'appID',
        'apiKey' => 'apiKey',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'clientEmail' => 'setClientEmail',
        'privateKey' => 'setPrivateKey',
        'username' => 'setUsername',
        'password' => 'setPassword',
        'key' => 'setKey',
        'url' => 'setUrl',
        'clientId' => 'setClientId',
        'clientSecret' => 'setClientSecret',
        'scope' => 'setScope',
        'appID' => 'setAppID',
        'apiKey' => 'setApiKey',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'clientEmail' => 'getClientEmail',
        'privateKey' => 'getPrivateKey',
        'username' => 'getUsername',
        'password' => 'getPassword',
        'key' => 'getKey',
        'url' => 'getUrl',
        'clientId' => 'getClientId',
        'clientSecret' => 'getClientSecret',
        'scope' => 'getScope',
        'appID' => 'getAppID',
        'apiKey' => 'getApiKey',
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
        if (isset($data['clientEmail'])) {
            $this->container['clientEmail'] = $data['clientEmail'];
        }
        if (isset($data['privateKey'])) {
            $this->container['privateKey'] = $data['privateKey'];
        }
        if (isset($data['username'])) {
            $this->container['username'] = $data['username'];
        }
        if (isset($data['password'])) {
            $this->container['password'] = $data['password'];
        }
        if (isset($data['key'])) {
            $this->container['key'] = $data['key'];
        }
        if (isset($data['url'])) {
            $this->container['url'] = $data['url'];
        }
        if (isset($data['clientId'])) {
            $this->container['clientId'] = $data['clientId'];
        }
        if (isset($data['clientSecret'])) {
            $this->container['clientSecret'] = $data['clientSecret'];
        }
        if (isset($data['scope'])) {
            $this->container['scope'] = $data['scope'];
        }
        if (isset($data['appID'])) {
            $this->container['appID'] = $data['appID'];
        }
        if (isset($data['apiKey'])) {
            $this->container['apiKey'] = $data['apiKey'];
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

        if (!isset($this->container['clientEmail']) || null === $this->container['clientEmail']) {
            $invalidProperties[] = "'clientEmail' can't be null";
        }
        if (!isset($this->container['privateKey']) || null === $this->container['privateKey']) {
            $invalidProperties[] = "'privateKey' can't be null";
        }
        if (!isset($this->container['username']) || null === $this->container['username']) {
            $invalidProperties[] = "'username' can't be null";
        }
        if (!isset($this->container['password']) || null === $this->container['password']) {
            $invalidProperties[] = "'password' can't be null";
        }
        if (!isset($this->container['key']) || null === $this->container['key']) {
            $invalidProperties[] = "'key' can't be null";
        }
        if (!isset($this->container['url']) || null === $this->container['url']) {
            $invalidProperties[] = "'url' can't be null";
        }
        if (!isset($this->container['clientId']) || null === $this->container['clientId']) {
            $invalidProperties[] = "'clientId' can't be null";
        }
        if (!isset($this->container['clientSecret']) || null === $this->container['clientSecret']) {
            $invalidProperties[] = "'clientSecret' can't be null";
        }
        if (!isset($this->container['appID']) || null === $this->container['appID']) {
            $invalidProperties[] = "'appID' can't be null";
        }
        if (!isset($this->container['apiKey']) || null === $this->container['apiKey']) {
            $invalidProperties[] = "'apiKey' can't be null";
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
     * Gets clientEmail.
     *
     * @return string
     */
    public function getClientEmail()
    {
        return $this->container['clientEmail'] ?? null;
    }

    /**
     * Sets clientEmail.
     *
     * @param string $clientEmail email address of the Google service account
     *
     * @return self
     */
    public function setClientEmail($clientEmail)
    {
        $this->container['clientEmail'] = $clientEmail;

        return $this;
    }

    /**
     * Gets privateKey.
     *
     * @return string
     */
    public function getPrivateKey()
    {
        return $this->container['privateKey'] ?? null;
    }

    /**
     * Sets privateKey.
     *
     * @param string $privateKey Private key of the Google service account. This field is `null` in the API response.
     *
     * @return self
     */
    public function setPrivateKey($privateKey)
    {
        $this->container['privateKey'] = $privateKey;

        return $this;
    }

    /**
     * Gets username.
     *
     * @return string
     */
    public function getUsername()
    {
        return $this->container['username'] ?? null;
    }

    /**
     * Sets username.
     *
     * @param string $username username
     *
     * @return self
     */
    public function setUsername($username)
    {
        $this->container['username'] = $username;

        return $this;
    }

    /**
     * Gets password.
     *
     * @return string
     */
    public function getPassword()
    {
        return $this->container['password'] ?? null;
    }

    /**
     * Sets password.
     *
     * @param string $password Password. This field is `null` in the API response.
     *
     * @return self
     */
    public function setPassword($password)
    {
        $this->container['password'] = $password;

        return $this;
    }

    /**
     * Gets key.
     *
     * @return string
     */
    public function getKey()
    {
        return $this->container['key'] ?? null;
    }

    /**
     * Sets key.
     *
     * @param string $key API key. This field is `null` in the API response.
     *
     * @return self
     */
    public function setKey($key)
    {
        $this->container['key'] = $key;

        return $this;
    }

    /**
     * Gets url.
     *
     * @return string
     */
    public function getUrl()
    {
        return $this->container['url'] ?? null;
    }

    /**
     * Sets url.
     *
     * @param string $url URL for the OAuth endpoint
     *
     * @return self
     */
    public function setUrl($url)
    {
        $this->container['url'] = $url;

        return $this;
    }

    /**
     * Gets clientId.
     *
     * @return string
     */
    public function getClientId()
    {
        return $this->container['clientId'] ?? null;
    }

    /**
     * Sets clientId.
     *
     * @param string $clientId client ID
     *
     * @return self
     */
    public function setClientId($clientId)
    {
        $this->container['clientId'] = $clientId;

        return $this;
    }

    /**
     * Gets clientSecret.
     *
     * @return string
     */
    public function getClientSecret()
    {
        return $this->container['clientSecret'] ?? null;
    }

    /**
     * Sets clientSecret.
     *
     * @param string $clientSecret Client secret. This field is `null` in the API response.
     *
     * @return self
     */
    public function setClientSecret($clientSecret)
    {
        $this->container['clientSecret'] = $clientSecret;

        return $this;
    }

    /**
     * Gets scope.
     *
     * @return null|string
     */
    public function getScope()
    {
        return $this->container['scope'] ?? null;
    }

    /**
     * Sets scope.
     *
     * @param null|string $scope OAuth scope
     *
     * @return self
     */
    public function setScope($scope)
    {
        $this->container['scope'] = $scope;

        return $this;
    }

    /**
     * Gets appID.
     *
     * @return string
     */
    public function getAppID()
    {
        return $this->container['appID'] ?? null;
    }

    /**
     * Sets appID.
     *
     * @param string $appID algolia application ID
     *
     * @return self
     */
    public function setAppID($appID)
    {
        $this->container['appID'] = $appID;

        return $this;
    }

    /**
     * Gets apiKey.
     *
     * @return string
     */
    public function getApiKey()
    {
        return $this->container['apiKey'] ?? null;
    }

    /**
     * Sets apiKey.
     *
     * @param string $apiKey Algolia API key with the ACL: `search`. This field is `null` in the API response.
     *
     * @return self
     */
    public function setApiKey($apiKey)
    {
        $this->container['apiKey'] = $apiKey;

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
