<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Ingestion;

/**
 * SourceInput Class Doc Comment.
 *
 * @category Class
 */
class SourceInput extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
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
        'projectKey' => 'string',
        'fallbackIsInStockValue' => 'bool',
        'customFields' => 'string[]',
        'storeHash' => 'string',
        'channel' => '\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceChannel',
        'productMetafields' => '\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceMetafield[]',
        'variantMetafields' => '\Algolia\AlgoliaSearch\Model\Ingestion\BigCommerceMetafield[]',
        'uniqueIDColumn' => 'string',
        'method' => '\Algolia\AlgoliaSearch\Model\Ingestion\MethodType',
        'mapping' => 'array<string,\Algolia\AlgoliaSearch\Model\Ingestion\MappingTypeCSV>',
        'delimiter' => 'string',
        'projectID' => 'string',
        'datasetID' => 'string',
        'dataType' => '\Algolia\AlgoliaSearch\Model\Ingestion\BigQueryDataType',
        'table' => 'string',
        'tablePrefix' => 'string',
        'customSQLRequest' => 'string',
        'imageType' => '\Algolia\AlgoliaSearch\Model\Ingestion\DockerImageType',
        'registry' => '\Algolia\AlgoliaSearch\Model\Ingestion\DockerRegistry',
        'image' => 'string',
        'version' => 'string',
        'configuration' => 'object',
        'collectionIDIndexing' => 'bool',
        'increaseProductCollectionLimit' => 'bool',
        'defaultPriceRatioAsOne' => 'bool',
        'excludeOOSVariantsForPriceAtTRS' => 'bool',
        'includeVariantsInventory' => 'bool',
        'hasCollectionSearchPage' => 'bool',
        'productNamedTags' => 'bool',
        'shopURL' => 'string',
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
        'projectKey' => null,
        'fallbackIsInStockValue' => null,
        'customFields' => null,
        'storeHash' => null,
        'channel' => null,
        'productMetafields' => null,
        'variantMetafields' => null,
        'uniqueIDColumn' => null,
        'method' => null,
        'mapping' => null,
        'delimiter' => null,
        'projectID' => null,
        'datasetID' => null,
        'dataType' => null,
        'table' => null,
        'tablePrefix' => null,
        'customSQLRequest' => null,
        'imageType' => null,
        'registry' => null,
        'image' => null,
        'version' => null,
        'configuration' => null,
        'collectionIDIndexing' => null,
        'increaseProductCollectionLimit' => null,
        'defaultPriceRatioAsOne' => null,
        'excludeOOSVariantsForPriceAtTRS' => null,
        'includeVariantsInventory' => null,
        'hasCollectionSearchPage' => null,
        'productNamedTags' => null,
        'shopURL' => null,
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
        'projectKey' => 'projectKey',
        'fallbackIsInStockValue' => 'fallbackIsInStockValue',
        'customFields' => 'customFields',
        'storeHash' => 'storeHash',
        'channel' => 'channel',
        'productMetafields' => 'productMetafields',
        'variantMetafields' => 'variantMetafields',
        'uniqueIDColumn' => 'uniqueIDColumn',
        'method' => 'method',
        'mapping' => 'mapping',
        'delimiter' => 'delimiter',
        'projectID' => 'projectID',
        'datasetID' => 'datasetID',
        'dataType' => 'dataType',
        'table' => 'table',
        'tablePrefix' => 'tablePrefix',
        'customSQLRequest' => 'customSQLRequest',
        'imageType' => 'imageType',
        'registry' => 'registry',
        'image' => 'image',
        'version' => 'version',
        'configuration' => 'configuration',
        'collectionIDIndexing' => 'collectionIDIndexing',
        'increaseProductCollectionLimit' => 'increaseProductCollectionLimit',
        'defaultPriceRatioAsOne' => 'defaultPriceRatioAsOne',
        'excludeOOSVariantsForPriceAtTRS' => 'excludeOOSVariantsForPriceAtTRS',
        'includeVariantsInventory' => 'includeVariantsInventory',
        'hasCollectionSearchPage' => 'hasCollectionSearchPage',
        'productNamedTags' => 'productNamedTags',
        'shopURL' => 'shopURL',
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
        'projectKey' => 'setProjectKey',
        'fallbackIsInStockValue' => 'setFallbackIsInStockValue',
        'customFields' => 'setCustomFields',
        'storeHash' => 'setStoreHash',
        'channel' => 'setChannel',
        'productMetafields' => 'setProductMetafields',
        'variantMetafields' => 'setVariantMetafields',
        'uniqueIDColumn' => 'setUniqueIDColumn',
        'method' => 'setMethod',
        'mapping' => 'setMapping',
        'delimiter' => 'setDelimiter',
        'projectID' => 'setProjectID',
        'datasetID' => 'setDatasetID',
        'dataType' => 'setDataType',
        'table' => 'setTable',
        'tablePrefix' => 'setTablePrefix',
        'customSQLRequest' => 'setCustomSQLRequest',
        'imageType' => 'setImageType',
        'registry' => 'setRegistry',
        'image' => 'setImage',
        'version' => 'setVersion',
        'configuration' => 'setConfiguration',
        'collectionIDIndexing' => 'setCollectionIDIndexing',
        'increaseProductCollectionLimit' => 'setIncreaseProductCollectionLimit',
        'defaultPriceRatioAsOne' => 'setDefaultPriceRatioAsOne',
        'excludeOOSVariantsForPriceAtTRS' => 'setExcludeOOSVariantsForPriceAtTRS',
        'includeVariantsInventory' => 'setIncludeVariantsInventory',
        'hasCollectionSearchPage' => 'setHasCollectionSearchPage',
        'productNamedTags' => 'setProductNamedTags',
        'shopURL' => 'setShopURL',
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
        'projectKey' => 'getProjectKey',
        'fallbackIsInStockValue' => 'getFallbackIsInStockValue',
        'customFields' => 'getCustomFields',
        'storeHash' => 'getStoreHash',
        'channel' => 'getChannel',
        'productMetafields' => 'getProductMetafields',
        'variantMetafields' => 'getVariantMetafields',
        'uniqueIDColumn' => 'getUniqueIDColumn',
        'method' => 'getMethod',
        'mapping' => 'getMapping',
        'delimiter' => 'getDelimiter',
        'projectID' => 'getProjectID',
        'datasetID' => 'getDatasetID',
        'dataType' => 'getDataType',
        'table' => 'getTable',
        'tablePrefix' => 'getTablePrefix',
        'customSQLRequest' => 'getCustomSQLRequest',
        'imageType' => 'getImageType',
        'registry' => 'getRegistry',
        'image' => 'getImage',
        'version' => 'getVersion',
        'configuration' => 'getConfiguration',
        'collectionIDIndexing' => 'getCollectionIDIndexing',
        'increaseProductCollectionLimit' => 'getIncreaseProductCollectionLimit',
        'defaultPriceRatioAsOne' => 'getDefaultPriceRatioAsOne',
        'excludeOOSVariantsForPriceAtTRS' => 'getExcludeOOSVariantsForPriceAtTRS',
        'includeVariantsInventory' => 'getIncludeVariantsInventory',
        'hasCollectionSearchPage' => 'getHasCollectionSearchPage',
        'productNamedTags' => 'getProductNamedTags',
        'shopURL' => 'getShopURL',
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
        if (isset($data['storeKeys'])) {
            $this->container['storeKeys'] = $data['storeKeys'];
        }
        if (isset($data['locales'])) {
            $this->container['locales'] = $data['locales'];
        }
        if (isset($data['url'])) {
            $this->container['url'] = $data['url'];
        }
        if (isset($data['projectKey'])) {
            $this->container['projectKey'] = $data['projectKey'];
        }
        if (isset($data['fallbackIsInStockValue'])) {
            $this->container['fallbackIsInStockValue'] = $data['fallbackIsInStockValue'];
        }
        if (isset($data['customFields'])) {
            $this->container['customFields'] = $data['customFields'];
        }
        if (isset($data['storeHash'])) {
            $this->container['storeHash'] = $data['storeHash'];
        }
        if (isset($data['channel'])) {
            $this->container['channel'] = $data['channel'];
        }
        if (isset($data['productMetafields'])) {
            $this->container['productMetafields'] = $data['productMetafields'];
        }
        if (isset($data['variantMetafields'])) {
            $this->container['variantMetafields'] = $data['variantMetafields'];
        }
        if (isset($data['uniqueIDColumn'])) {
            $this->container['uniqueIDColumn'] = $data['uniqueIDColumn'];
        }
        if (isset($data['method'])) {
            $this->container['method'] = $data['method'];
        }
        if (isset($data['mapping'])) {
            $this->container['mapping'] = $data['mapping'];
        }
        if (isset($data['delimiter'])) {
            $this->container['delimiter'] = $data['delimiter'];
        }
        if (isset($data['projectID'])) {
            $this->container['projectID'] = $data['projectID'];
        }
        if (isset($data['datasetID'])) {
            $this->container['datasetID'] = $data['datasetID'];
        }
        if (isset($data['dataType'])) {
            $this->container['dataType'] = $data['dataType'];
        }
        if (isset($data['table'])) {
            $this->container['table'] = $data['table'];
        }
        if (isset($data['tablePrefix'])) {
            $this->container['tablePrefix'] = $data['tablePrefix'];
        }
        if (isset($data['customSQLRequest'])) {
            $this->container['customSQLRequest'] = $data['customSQLRequest'];
        }
        if (isset($data['imageType'])) {
            $this->container['imageType'] = $data['imageType'];
        }
        if (isset($data['registry'])) {
            $this->container['registry'] = $data['registry'];
        }
        if (isset($data['image'])) {
            $this->container['image'] = $data['image'];
        }
        if (isset($data['version'])) {
            $this->container['version'] = $data['version'];
        }
        if (isset($data['configuration'])) {
            $this->container['configuration'] = $data['configuration'];
        }
        if (isset($data['collectionIDIndexing'])) {
            $this->container['collectionIDIndexing'] = $data['collectionIDIndexing'];
        }
        if (isset($data['increaseProductCollectionLimit'])) {
            $this->container['increaseProductCollectionLimit'] = $data['increaseProductCollectionLimit'];
        }
        if (isset($data['defaultPriceRatioAsOne'])) {
            $this->container['defaultPriceRatioAsOne'] = $data['defaultPriceRatioAsOne'];
        }
        if (isset($data['excludeOOSVariantsForPriceAtTRS'])) {
            $this->container['excludeOOSVariantsForPriceAtTRS'] = $data['excludeOOSVariantsForPriceAtTRS'];
        }
        if (isset($data['includeVariantsInventory'])) {
            $this->container['includeVariantsInventory'] = $data['includeVariantsInventory'];
        }
        if (isset($data['hasCollectionSearchPage'])) {
            $this->container['hasCollectionSearchPage'] = $data['hasCollectionSearchPage'];
        }
        if (isset($data['productNamedTags'])) {
            $this->container['productNamedTags'] = $data['productNamedTags'];
        }
        if (isset($data['shopURL'])) {
            $this->container['shopURL'] = $data['shopURL'];
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

        if (!isset($this->container['url']) || null === $this->container['url']) {
            $invalidProperties[] = "'url' can't be null";
        }
        if (!isset($this->container['projectKey']) || null === $this->container['projectKey']) {
            $invalidProperties[] = "'projectKey' can't be null";
        }
        if (!isset($this->container['storeHash']) || null === $this->container['storeHash']) {
            $invalidProperties[] = "'storeHash' can't be null";
        }
        if (isset($this->container['delimiter']) && (mb_strlen($this->container['delimiter']) > 1)) {
            $invalidProperties[] = "invalid value for 'delimiter', the character length must be smaller than or equal to 1.";
        }

        if (isset($this->container['delimiter']) && (mb_strlen($this->container['delimiter']) < 1)) {
            $invalidProperties[] = "invalid value for 'delimiter', the character length must be bigger than or equal to 1.";
        }

        if (!isset($this->container['projectID']) || null === $this->container['projectID']) {
            $invalidProperties[] = "'projectID' can't be null";
        }
        if (!isset($this->container['datasetID']) || null === $this->container['datasetID']) {
            $invalidProperties[] = "'datasetID' can't be null";
        }
        if (!isset($this->container['tablePrefix']) || null === $this->container['tablePrefix']) {
            $invalidProperties[] = "'tablePrefix' can't be null";
        }
        if (!isset($this->container['imageType']) || null === $this->container['imageType']) {
            $invalidProperties[] = "'imageType' can't be null";
        }
        if (!isset($this->container['registry']) || null === $this->container['registry']) {
            $invalidProperties[] = "'registry' can't be null";
        }
        if (!isset($this->container['image']) || null === $this->container['image']) {
            $invalidProperties[] = "'image' can't be null";
        }
        if (!isset($this->container['configuration']) || null === $this->container['configuration']) {
            $invalidProperties[] = "'configuration' can't be null";
        }
        if (!isset($this->container['shopURL']) || null === $this->container['shopURL']) {
            $invalidProperties[] = "'shopURL' can't be null";
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
     * @return string
     */
    public function getUrl()
    {
        return $this->container['url'] ?? null;
    }

    /**
     * Sets url.
     *
     * @param string $url URL of the file
     *
     * @return self
     */
    public function setUrl($url)
    {
        $this->container['url'] = $url;

        return $this;
    }

    /**
     * Gets projectKey.
     *
     * @return string
     */
    public function getProjectKey()
    {
        return $this->container['projectKey'] ?? null;
    }

    /**
     * Sets projectKey.
     *
     * @param string $projectKey projectKey
     *
     * @return self
     */
    public function setProjectKey($projectKey)
    {
        $this->container['projectKey'] = $projectKey;

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
     * Gets storeHash.
     *
     * @return string
     */
    public function getStoreHash()
    {
        return $this->container['storeHash'] ?? null;
    }

    /**
     * Sets storeHash.
     *
     * @param string $storeHash store hash identifying your BigCommerce store
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
     * Gets uniqueIDColumn.
     *
     * @return null|string
     */
    public function getUniqueIDColumn()
    {
        return $this->container['uniqueIDColumn'] ?? null;
    }

    /**
     * Sets uniqueIDColumn.
     *
     * @param null|string $uniqueIDColumn name of a column that contains a unique ID which will be used as `objectID` in Algolia
     *
     * @return self
     */
    public function setUniqueIDColumn($uniqueIDColumn)
    {
        $this->container['uniqueIDColumn'] = $uniqueIDColumn;

        return $this;
    }

    /**
     * Gets method.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\MethodType
     */
    public function getMethod()
    {
        return $this->container['method'] ?? null;
    }

    /**
     * Sets method.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\MethodType $method method
     *
     * @return self
     */
    public function setMethod($method)
    {
        $this->container['method'] = $method;

        return $this;
    }

    /**
     * Gets mapping.
     *
     * @return null|array<string,\Algolia\AlgoliaSearch\Model\Ingestion\MappingTypeCSV>
     */
    public function getMapping()
    {
        return $this->container['mapping'] ?? null;
    }

    /**
     * Sets mapping.
     *
     * @param null|array<string,\Algolia\AlgoliaSearch\Model\Ingestion\MappingTypeCSV> $mapping key-value pairs of column names and their expected types
     *
     * @return self
     */
    public function setMapping($mapping)
    {
        $this->container['mapping'] = $mapping;

        return $this;
    }

    /**
     * Gets delimiter.
     *
     * @return null|string
     */
    public function getDelimiter()
    {
        return $this->container['delimiter'] ?? null;
    }

    /**
     * Sets delimiter.
     *
     * @param null|string $delimiter the character used to split the value on each line, default to a comma (\\r, \\n, 0xFFFD, and space are forbidden)
     *
     * @return self
     */
    public function setDelimiter($delimiter)
    {
        if (!is_null($delimiter) && (mb_strlen($delimiter) > 1)) {
            throw new \InvalidArgumentException('invalid length for $delimiter when calling SourceInput., must be smaller than or equal to 1.');
        }
        if (!is_null($delimiter) && (mb_strlen($delimiter) < 1)) {
            throw new \InvalidArgumentException('invalid length for $delimiter when calling SourceInput., must be bigger than or equal to 1.');
        }

        $this->container['delimiter'] = $delimiter;

        return $this;
    }

    /**
     * Gets projectID.
     *
     * @return string
     */
    public function getProjectID()
    {
        return $this->container['projectID'] ?? null;
    }

    /**
     * Sets projectID.
     *
     * @param string $projectID GCP project ID that the BigQuery export writes to
     *
     * @return self
     */
    public function setProjectID($projectID)
    {
        $this->container['projectID'] = $projectID;

        return $this;
    }

    /**
     * Gets datasetID.
     *
     * @return string
     */
    public function getDatasetID()
    {
        return $this->container['datasetID'] ?? null;
    }

    /**
     * Sets datasetID.
     *
     * @param string $datasetID bigQuery dataset ID that the BigQuery export writes to
     *
     * @return self
     */
    public function setDatasetID($datasetID)
    {
        $this->container['datasetID'] = $datasetID;

        return $this;
    }

    /**
     * Gets dataType.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Ingestion\BigQueryDataType
     */
    public function getDataType()
    {
        return $this->container['dataType'] ?? null;
    }

    /**
     * Sets dataType.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Ingestion\BigQueryDataType $dataType dataType
     *
     * @return self
     */
    public function setDataType($dataType)
    {
        $this->container['dataType'] = $dataType;

        return $this;
    }

    /**
     * Gets table.
     *
     * @return null|string
     */
    public function getTable()
    {
        return $this->container['table'] ?? null;
    }

    /**
     * Sets table.
     *
     * @param null|string $table table name for the BigQuery export
     *
     * @return self
     */
    public function setTable($table)
    {
        $this->container['table'] = $table;

        return $this;
    }

    /**
     * Gets tablePrefix.
     *
     * @return string
     */
    public function getTablePrefix()
    {
        return $this->container['tablePrefix'] ?? null;
    }

    /**
     * Sets tablePrefix.
     *
     * @param string $tablePrefix prefix of the tables that the BigQuery Export writes to
     *
     * @return self
     */
    public function setTablePrefix($tablePrefix)
    {
        $this->container['tablePrefix'] = $tablePrefix;

        return $this;
    }

    /**
     * Gets customSQLRequest.
     *
     * @return null|string
     */
    public function getCustomSQLRequest()
    {
        return $this->container['customSQLRequest'] ?? null;
    }

    /**
     * Sets customSQLRequest.
     *
     * @param null|string $customSQLRequest custom SQL request to extract data from the BigQuery table
     *
     * @return self
     */
    public function setCustomSQLRequest($customSQLRequest)
    {
        $this->container['customSQLRequest'] = $customSQLRequest;

        return $this;
    }

    /**
     * Gets imageType.
     *
     * @return \Algolia\AlgoliaSearch\Model\Ingestion\DockerImageType
     */
    public function getImageType()
    {
        return $this->container['imageType'] ?? null;
    }

    /**
     * Sets imageType.
     *
     * @param \Algolia\AlgoliaSearch\Model\Ingestion\DockerImageType $imageType imageType
     *
     * @return self
     */
    public function setImageType($imageType)
    {
        $this->container['imageType'] = $imageType;

        return $this;
    }

    /**
     * Gets registry.
     *
     * @return \Algolia\AlgoliaSearch\Model\Ingestion\DockerRegistry
     */
    public function getRegistry()
    {
        return $this->container['registry'] ?? null;
    }

    /**
     * Sets registry.
     *
     * @param \Algolia\AlgoliaSearch\Model\Ingestion\DockerRegistry $registry registry
     *
     * @return self
     */
    public function setRegistry($registry)
    {
        $this->container['registry'] = $registry;

        return $this;
    }

    /**
     * Gets image.
     *
     * @return string
     */
    public function getImage()
    {
        return $this->container['image'] ?? null;
    }

    /**
     * Sets image.
     *
     * @param string $image docker image name
     *
     * @return self
     */
    public function setImage($image)
    {
        $this->container['image'] = $image;

        return $this;
    }

    /**
     * Gets version.
     *
     * @return null|string
     */
    public function getVersion()
    {
        return $this->container['version'] ?? null;
    }

    /**
     * Sets version.
     *
     * @param null|string $version docker image version
     *
     * @return self
     */
    public function setVersion($version)
    {
        $this->container['version'] = $version;

        return $this;
    }

    /**
     * Gets configuration.
     *
     * @return object
     */
    public function getConfiguration()
    {
        return $this->container['configuration'] ?? null;
    }

    /**
     * Sets configuration.
     *
     * @param object $configuration configuration of the spec
     *
     * @return self
     */
    public function setConfiguration($configuration)
    {
        $this->container['configuration'] = $configuration;

        return $this;
    }

    /**
     * Gets collectionIDIndexing.
     *
     * @return null|bool
     */
    public function getCollectionIDIndexing()
    {
        return $this->container['collectionIDIndexing'] ?? null;
    }

    /**
     * Sets collectionIDIndexing.
     *
     * @param null|bool $collectionIDIndexing Whether to index collection IDs.   If your store has `has_collection_search_page` set to true, collection IDs will be indexed even if `collectionIDIndexing` is false.
     *
     * @return self
     */
    public function setCollectionIDIndexing($collectionIDIndexing)
    {
        $this->container['collectionIDIndexing'] = $collectionIDIndexing;

        return $this;
    }

    /**
     * Gets increaseProductCollectionLimit.
     *
     * @return null|bool
     */
    public function getIncreaseProductCollectionLimit()
    {
        return $this->container['increaseProductCollectionLimit'] ?? null;
    }

    /**
     * Sets increaseProductCollectionLimit.
     *
     * @param null|bool $increaseProductCollectionLimit Whether to increase the number of indexed collections per product. If true, Algolia indexes 200 collections per product. If false, 100 collections per product are indexed.
     *
     * @return self
     */
    public function setIncreaseProductCollectionLimit($increaseProductCollectionLimit)
    {
        $this->container['increaseProductCollectionLimit'] = $increaseProductCollectionLimit;

        return $this;
    }

    /**
     * Gets defaultPriceRatioAsOne.
     *
     * @return null|bool
     */
    public function getDefaultPriceRatioAsOne()
    {
        return $this->container['defaultPriceRatioAsOne'] ?? null;
    }

    /**
     * Sets defaultPriceRatioAsOne.
     *
     * @param null|bool $defaultPriceRatioAsOne Whether to set the default price ratio to 1 if no sale price is present.  The price ratio is determined by the ratio: `sale_price` / `regular_price`. If no sale price is present, the price ratio would be 0. If `defaultPriceRatioAsOne` is true, the price ratio is indexed as 1 instead.
     *
     * @return self
     */
    public function setDefaultPriceRatioAsOne($defaultPriceRatioAsOne)
    {
        $this->container['defaultPriceRatioAsOne'] = $defaultPriceRatioAsOne;

        return $this;
    }

    /**
     * Gets excludeOOSVariantsForPriceAtTRS.
     *
     * @return null|bool
     */
    public function getExcludeOOSVariantsForPriceAtTRS()
    {
        return $this->container['excludeOOSVariantsForPriceAtTRS'] ?? null;
    }

    /**
     * Sets excludeOOSVariantsForPriceAtTRS.
     *
     * @param null|bool $excludeOOSVariantsForPriceAtTRS whether to exclude out-of-stock variants when determining the `max_variant_price` and `min_variant_price` attributes
     *
     * @return self
     */
    public function setExcludeOOSVariantsForPriceAtTRS($excludeOOSVariantsForPriceAtTRS)
    {
        $this->container['excludeOOSVariantsForPriceAtTRS'] = $excludeOOSVariantsForPriceAtTRS;

        return $this;
    }

    /**
     * Gets includeVariantsInventory.
     *
     * @return null|bool
     */
    public function getIncludeVariantsInventory()
    {
        return $this->container['includeVariantsInventory'] ?? null;
    }

    /**
     * Sets includeVariantsInventory.
     *
     * @param null|bool $includeVariantsInventory whether to include an inventory with every variant for every product record
     *
     * @return self
     */
    public function setIncludeVariantsInventory($includeVariantsInventory)
    {
        $this->container['includeVariantsInventory'] = $includeVariantsInventory;

        return $this;
    }

    /**
     * Gets hasCollectionSearchPage.
     *
     * @return null|bool
     */
    public function getHasCollectionSearchPage()
    {
        return $this->container['hasCollectionSearchPage'] ?? null;
    }

    /**
     * Sets hasCollectionSearchPage.
     *
     * @param null|bool $hasCollectionSearchPage whether to include collection IDs and handles in the product records
     *
     * @return self
     */
    public function setHasCollectionSearchPage($hasCollectionSearchPage)
    {
        $this->container['hasCollectionSearchPage'] = $hasCollectionSearchPage;

        return $this;
    }

    /**
     * Gets productNamedTags.
     *
     * @return null|bool
     */
    public function getProductNamedTags()
    {
        return $this->container['productNamedTags'] ?? null;
    }

    /**
     * Sets productNamedTags.
     *
     * @param null|bool $productNamedTags Whether to convert tags on products to named tags.  To learn more, see [Named tags](https://www.algolia.com/doc/integration/shopify/sending-and-managing-data/named-tags).
     *
     * @return self
     */
    public function setProductNamedTags($productNamedTags)
    {
        $this->container['productNamedTags'] = $productNamedTags;

        return $this;
    }

    /**
     * Gets shopURL.
     *
     * @return string
     */
    public function getShopURL()
    {
        return $this->container['shopURL'] ?? null;
    }

    /**
     * Sets shopURL.
     *
     * @param string $shopURL URL of the Shopify store
     *
     * @return self
     */
    public function setShopURL($shopURL)
    {
        $this->container['shopURL'] = $shopURL;

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
