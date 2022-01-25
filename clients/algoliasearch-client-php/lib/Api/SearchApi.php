<?php

namespace Algolia\AlgoliaSearch\Api;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\HeaderSelector;
use Algolia\AlgoliaSearch\ObjectSerializer;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapperInterface;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;

/**
 * SearchApi Class Doc Comment
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class SearchApi
{
    /**
     * @var ApiWrapperInterface
     */
    protected $api;

    /**
     * @var SearchConfig
     */
    protected $config;

    /**
     * @var HeaderSelector
     */
    protected $headerSelector;

    /**
     * @param SearchConfig $config
     * @param ApiWrapperInterface $apiWrapper
     */
    public function __construct(ApiWrapperInterface $apiWrapper, SearchConfig $config)
    {
        $this->config = $config;

        $this->api = $apiWrapper;
        $this->headerSelector = new HeaderSelector();
    }

    /**
     * Instantiate the client with basic credentials
     *
     * @param string $appId  Application ID
     * @param string $apiKey Algolia API Key
     */
    public static function create($appId = null, $apiKey = null)
    {
        return static::createWithConfig(SearchConfig::create($appId, $apiKey));
    }

    /**
     * Instantiate the client with congiguration
     *
     * @param SearchConfig $config Configuration
     */
    public static function createWithConfig(SearchConfig $config)
    {
        $config = clone $config;

        $cacheKey = sprintf('%s-clusterHosts-%s', __CLASS__, $config->getAppId());

        if ($hosts = $config->getHosts()) {
            // If a list of hosts was passed, we ignore the cache
            $clusterHosts = ClusterHosts::create($hosts);
        } elseif (false === ($clusterHosts = ClusterHosts::createFromCache($cacheKey))) {
            // We'll try to restore the ClusterHost from cache, if we cannot
            // we create a new instance and set the cache key
            $clusterHosts = ClusterHosts::createFromAppId($config->getAppId())
                ->setCacheKey($cacheKey);
        }

        $apiWrapper = new ApiWrapper(
            Algolia::getHttpClient(),
            $config,
            $clusterHosts
        );

        return new static($apiWrapper, $config);
    }

    /**
     * @return SearchConfig
     */
    public function getConfig()
    {
        return $this->config;
    }

    /**
     * Operation addApiKey
     *
     * Create a new API key.
     *
     * @param  \Algolia\AlgoliaSearch\Model\ApiKey $apiKey apiKey (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\AddApiKeyResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function addApiKey($apiKey)
    {
        // verify the required parameter 'apiKey' is set
        if ($apiKey === null || (is_array($apiKey) && count($apiKey) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $apiKey when calling addApiKey'
            );
        }

        $resourcePath = '/1/keys';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($apiKey)) {
            $httpBody = $apiKey;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation addOrUpdateObject
     *
     * Add or replace an object with a given object ID.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     * @param  object $body The Algolia object. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtWithObjectIdResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function addOrUpdateObject($indexName, $objectID, $body)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling addOrUpdateObject'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling addOrUpdateObject'
            );
        }
        // verify the required parameter 'body' is set
        if ($body === null || (is_array($body) && count($body) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $body when calling addOrUpdateObject'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/{objectID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($body)) {
            $httpBody = $body;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('PUT', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation appendSource
     *
     * @param  \Algolia\AlgoliaSearch\Model\Source $source The source to add. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\CreatedAtResponse
     */
    public function appendSource($source)
    {
        // verify the required parameter 'source' is set
        if ($source === null || (is_array($source) && count($source) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $source when calling appendSource'
            );
        }

        $resourcePath = '/1/security/sources/append';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($source)) {
            $httpBody = $source;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation assignUserId
     *
     * Assign or Move userID
     *
     * @param  string $xAlgoliaUserID userID to assign. (required)
     * @param  \Algolia\AlgoliaSearch\Model\AssignUserIdObject $assignUserIdObject assignUserIdObject (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\CreatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function assignUserId($xAlgoliaUserID, $assignUserIdObject)
    {
        // verify the required parameter 'xAlgoliaUserID' is set
        if ($xAlgoliaUserID === null || (is_array($xAlgoliaUserID) && count($xAlgoliaUserID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $xAlgoliaUserID when calling assignUserId'
            );
        }
        if (!preg_match('/^[a-zA-Z0-9 \\-*.]+$/', $xAlgoliaUserID)) {
            throw new \InvalidArgumentException('invalid value for "xAlgoliaUserID" when calling SearchApi.assignUserId, must conform to the pattern /^[a-zA-Z0-9 \\-*.]+$/.');
        }

        // verify the required parameter 'assignUserIdObject' is set
        if ($assignUserIdObject === null || (is_array($assignUserIdObject) && count($assignUserIdObject) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $assignUserIdObject when calling assignUserId'
            );
        }

        $resourcePath = '/1/clusters/mapping';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($xAlgoliaUserID)) {
            $xAlgoliaUserID = ObjectSerializer::serializeCollection($xAlgoliaUserID, '', true);
        }
        if ($xAlgoliaUserID !== null) {
            $queryParams['X-Algolia-User-ID'] = $xAlgoliaUserID;
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($assignUserIdObject)) {
            $httpBody = $assignUserIdObject;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation batch
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  \Algolia\AlgoliaSearch\Model\BatchWriteObject $batchWriteObject batchWriteObject (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\BatchResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function batch($indexName, $batchWriteObject)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling batch'
            );
        }
        // verify the required parameter 'batchWriteObject' is set
        if ($batchWriteObject === null || (is_array($batchWriteObject) && count($batchWriteObject) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $batchWriteObject when calling batch'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/batch';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($batchWriteObject)) {
            $httpBody = $batchWriteObject;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation batchAssignUserIds
     *
     * Batch assign userIDs
     *
     * @param  string $xAlgoliaUserID userID to assign. (required)
     * @param  \Algolia\AlgoliaSearch\Model\BatchAssignUserIdsObject $batchAssignUserIdsObject batchAssignUserIdsObject (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\CreatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function batchAssignUserIds($xAlgoliaUserID, $batchAssignUserIdsObject)
    {
        // verify the required parameter 'xAlgoliaUserID' is set
        if ($xAlgoliaUserID === null || (is_array($xAlgoliaUserID) && count($xAlgoliaUserID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $xAlgoliaUserID when calling batchAssignUserIds'
            );
        }
        if (!preg_match('/^[a-zA-Z0-9 \\-*.]+$/', $xAlgoliaUserID)) {
            throw new \InvalidArgumentException('invalid value for "xAlgoliaUserID" when calling SearchApi.batchAssignUserIds, must conform to the pattern /^[a-zA-Z0-9 \\-*.]+$/.');
        }

        // verify the required parameter 'batchAssignUserIdsObject' is set
        if ($batchAssignUserIdsObject === null || (is_array($batchAssignUserIdsObject) && count($batchAssignUserIdsObject) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $batchAssignUserIdsObject when calling batchAssignUserIds'
            );
        }

        $resourcePath = '/1/clusters/mapping/batch';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($xAlgoliaUserID)) {
            $xAlgoliaUserID = ObjectSerializer::serializeCollection($xAlgoliaUserID, '', true);
        }
        if ($xAlgoliaUserID !== null) {
            $queryParams['X-Algolia-User-ID'] = $xAlgoliaUserID;
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($batchAssignUserIdsObject)) {
            $httpBody = $batchAssignUserIdsObject;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation batchDictionaryEntries
     *
     * Send a batch of dictionary entries.
     *
     * @param  string $dictionaryName The dictionary to search in. (required)
     * @param  \Algolia\AlgoliaSearch\Model\BatchDictionaryEntries $batchDictionaryEntries batchDictionaryEntries (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function batchDictionaryEntries($dictionaryName, $batchDictionaryEntries)
    {
        // verify the required parameter 'dictionaryName' is set
        if ($dictionaryName === null || (is_array($dictionaryName) && count($dictionaryName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $dictionaryName when calling batchDictionaryEntries'
            );
        }
        // verify the required parameter 'batchDictionaryEntries' is set
        if ($batchDictionaryEntries === null || (is_array($batchDictionaryEntries) && count($batchDictionaryEntries) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $batchDictionaryEntries when calling batchDictionaryEntries'
            );
        }

        $resourcePath = '/1/dictionaries/{dictionaryName}/batch';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($dictionaryName !== null) {
            $resourcePath = str_replace(
                '{' . 'dictionaryName' . '}',
                ObjectSerializer::toPathValue($dictionaryName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($batchDictionaryEntries)) {
            $httpBody = $batchDictionaryEntries;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation batchRules
     *
     * Batch Rules.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  \Algolia\AlgoliaSearch\Model\Rule[] $rule rule (required)
     * @param  bool $forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
     * @param  bool $clearExistingRules When true, existing Rules are cleared before adding this batch. When false, existing Rules are kept. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function batchRules($indexName, $rule, $forwardToReplicas = null, $clearExistingRules = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling batchRules'
            );
        }
        // verify the required parameter 'rule' is set
        if ($rule === null || (is_array($rule) && count($rule) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $rule when calling batchRules'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/rules/batch';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($forwardToReplicas)) {
            $forwardToReplicas = ObjectSerializer::serializeCollection($forwardToReplicas, '', true);
        }
        if ($forwardToReplicas !== null) {
            $queryParams['forwardToReplicas'] = $forwardToReplicas;
        }
        // query params
        if (is_array($clearExistingRules)) {
            $clearExistingRules = ObjectSerializer::serializeCollection($clearExistingRules, '', true);
        }
        if ($clearExistingRules !== null) {
            $queryParams['clearExistingRules'] = $clearExistingRules;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($rule)) {
            $httpBody = $rule;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation browse
     *
     * Retrieve all index content.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  \Algolia\AlgoliaSearch\Model\BrowseRequest $browseRequest browseRequest (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\BrowseResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function browse($indexName, $browseRequest = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling browse'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/browse';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($browseRequest)) {
            $httpBody = $browseRequest;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation clearAllSynonyms
     *
     * Clear all synonyms.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  bool $forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function clearAllSynonyms($indexName, $forwardToReplicas = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling clearAllSynonyms'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/synonyms/clear';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($forwardToReplicas)) {
            $forwardToReplicas = ObjectSerializer::serializeCollection($forwardToReplicas, '', true);
        }
        if ($forwardToReplicas !== null) {
            $queryParams['forwardToReplicas'] = $forwardToReplicas;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation clearObjects
     *
     * clear all objects from an index.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function clearObjects($indexName)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling clearObjects'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/clear';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation clearRules
     *
     * Clear Rules.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  bool $forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function clearRules($indexName, $forwardToReplicas = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling clearRules'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/rules/clear';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($forwardToReplicas)) {
            $forwardToReplicas = ObjectSerializer::serializeCollection($forwardToReplicas, '', true);
        }
        if ($forwardToReplicas !== null) {
            $queryParams['forwardToReplicas'] = $forwardToReplicas;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation deleteApiKey
     *
     * Delete an API key.
     *
     * @param  string $key API Key string. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\DeleteApiKeyResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function deleteApiKey($key)
    {
        // verify the required parameter 'key' is set
        if ($key === null || (is_array($key) && count($key) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $key when calling deleteApiKey'
            );
        }

        $resourcePath = '/1/keys/{key}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($key !== null) {
            $resourcePath = str_replace(
                '{' . 'key' . '}',
                ObjectSerializer::toPathValue($key),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('DELETE', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation deleteBy
     *
     * Delete all records matching the query.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  \Algolia\AlgoliaSearch\Model\SearchParams $searchParams searchParams (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\DeletedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function deleteBy($indexName, $searchParams)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling deleteBy'
            );
        }
        // verify the required parameter 'searchParams' is set
        if ($searchParams === null || (is_array($searchParams) && count($searchParams) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $searchParams when calling deleteBy'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/deleteByQuery';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($searchParams)) {
            $httpBody = $searchParams;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation deleteIndex
     *
     * Delete index.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\DeletedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function deleteIndex($indexName)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling deleteIndex'
            );
        }

        $resourcePath = '/1/indexes/{indexName}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('DELETE', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation deleteObject
     *
     * Delete object.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\DeletedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function deleteObject($indexName, $objectID)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling deleteObject'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling deleteObject'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/{objectID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('DELETE', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation deleteRule
     *
     * Delete a rule.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     * @param  bool $forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function deleteRule($indexName, $objectID, $forwardToReplicas = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling deleteRule'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling deleteRule'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/rules/{objectID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($forwardToReplicas)) {
            $forwardToReplicas = ObjectSerializer::serializeCollection($forwardToReplicas, '', true);
        }
        if ($forwardToReplicas !== null) {
            $queryParams['forwardToReplicas'] = $forwardToReplicas;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('DELETE', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation deleteSource
     *
     * @param  string $source The IP range of the source. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\DeleteSourceResponse
     */
    public function deleteSource($source)
    {
        // verify the required parameter 'source' is set
        if ($source === null || (is_array($source) && count($source) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $source when calling deleteSource'
            );
        }

        $resourcePath = '/1/security/sources/{source}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($source !== null) {
            $resourcePath = str_replace(
                '{' . 'source' . '}',
                ObjectSerializer::toPathValue($source),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('DELETE', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation deleteSynonym
     *
     * Delete synonym.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     * @param  bool $forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\DeletedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function deleteSynonym($indexName, $objectID, $forwardToReplicas = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling deleteSynonym'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling deleteSynonym'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/synonyms/{objectID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($forwardToReplicas)) {
            $forwardToReplicas = ObjectSerializer::serializeCollection($forwardToReplicas, '', true);
        }
        if ($forwardToReplicas !== null) {
            $queryParams['forwardToReplicas'] = $forwardToReplicas;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('DELETE', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getApiKey
     *
     * Get an API key.
     *
     * @param  string $key API Key string. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\KeyObject|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getApiKey($key)
    {
        // verify the required parameter 'key' is set
        if ($key === null || (is_array($key) && count($key) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $key when calling getApiKey'
            );
        }

        $resourcePath = '/1/keys/{key}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($key !== null) {
            $resourcePath = str_replace(
                '{' . 'key' . '}',
                ObjectSerializer::toPathValue($key),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getDictionaryLanguages
     *
     * List dictionaries supported per language.
     *
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return array<string,\Algolia\AlgoliaSearch\Model\Languages>|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getDictionaryLanguages()
    {
        $resourcePath = '/1/dictionaries/*/languages';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getDictionarySettings
     *
     * Retrieve dictionaries settings. The API stores languages whose standard entries are disabled. Fetch settings does not return false values.
     *
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\GetDictionarySettingsResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getDictionarySettings()
    {
        $resourcePath = '/1/dictionaries/*/settings';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getLogs
     *
     * @param  int $offset First entry to retrieve (zero-based). Log entries are sorted by decreasing date, therefore 0 designates the most recent log entry. (optional, default to 0)
     * @param  int $length Maximum number of entries to retrieve. The maximum allowed value is 1000. (optional, default to 10)
     * @param  string $indexName Index for which log entries should be retrieved. When omitted, log entries are retrieved across all indices. (optional)
     * @param  string $type Type of log entries to retrieve. When omitted, all log entries are retrieved. (optional, default to 'all')
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\GetLogsResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getLogs($offset = 0, $length = 10, $indexName = null, $type = 'all')
    {
        if ($length !== null && $length > 1000) {
            throw new \InvalidArgumentException('invalid value for "$length" when calling SearchApi.getLogs, must be smaller than or equal to 1000.');
        }

        $resourcePath = '/1/logs';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($offset)) {
            $offset = ObjectSerializer::serializeCollection($offset, '', true);
        }
        if ($offset !== null) {
            $queryParams['offset'] = $offset;
        }
        // query params
        if (is_array($length)) {
            $length = ObjectSerializer::serializeCollection($length, '', true);
        }
        if ($length !== null) {
            $queryParams['length'] = $length;
        }
        // query params
        if (is_array($indexName)) {
            $indexName = ObjectSerializer::serializeCollection($indexName, '', true);
        }
        if ($indexName !== null) {
            $queryParams['indexName'] = $indexName;
        }
        // query params
        if (is_array($type)) {
            $type = ObjectSerializer::serializeCollection($type, '', true);
        }
        if ($type !== null) {
            $queryParams['type'] = $type;
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getObject
     *
     * Retrieve one object from the index.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     * @param  string[] $attributesToRetrieve List of attributes to retrieve. If not specified, all retrievable attributes are returned. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return array<string,string>|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getObject($indexName, $objectID, $attributesToRetrieve = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling getObject'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling getObject'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/{objectID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($attributesToRetrieve)) {
            $attributesToRetrieve = ObjectSerializer::serializeCollection($attributesToRetrieve, 'csv', true);
        }
        if ($attributesToRetrieve !== null) {
            $queryParams['attributesToRetrieve'] = $attributesToRetrieve;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getObjects
     *
     * Retrieve one or more objects.
     *
     * @param  \Algolia\AlgoliaSearch\Model\GetObjectsObject $getObjectsObject getObjectsObject (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\GetObjectsResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getObjects($getObjectsObject)
    {
        // verify the required parameter 'getObjectsObject' is set
        if ($getObjectsObject === null || (is_array($getObjectsObject) && count($getObjectsObject) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $getObjectsObject when calling getObjects'
            );
        }

        $resourcePath = '/1/indexes/*/objects';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($getObjectsObject)) {
            $httpBody = $getObjectsObject;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getRule
     *
     * Get a rule.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Rule|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getRule($indexName, $objectID)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling getRule'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling getRule'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/rules/{objectID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getSettings
     *
     * @param  string $indexName The index in which to perform the request. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\IndexSettings|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getSettings($indexName)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling getSettings'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/settings';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getSources
     *
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Source[]
     */
    public function getSources()
    {
        $resourcePath = '/1/security/sources';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getSynonym
     *
     * Get synonym.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\SynonymHit|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getSynonym($indexName, $objectID)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling getSynonym'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling getSynonym'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/synonyms/{objectID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getTask
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  int $taskID Unique identifier of an task. Numeric value (up to 64bits) (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\GetTaskResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getTask($indexName, $taskID)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling getTask'
            );
        }
        // verify the required parameter 'taskID' is set
        if ($taskID === null || (is_array($taskID) && count($taskID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $taskID when calling getTask'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/task/{taskID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($taskID !== null) {
            $resourcePath = str_replace(
                '{' . 'taskID' . '}',
                ObjectSerializer::toPathValue($taskID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getTopUserIds
     *
     * Get top userID
     *
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\GetTopUserIdsResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getTopUserIds()
    {
        $resourcePath = '/1/clusters/mapping/top';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation getUserId
     *
     * Get userID
     *
     * @param  string $userID userID to assign. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UserId|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getUserId($userID)
    {
        // verify the required parameter 'userID' is set
        if ($userID === null || (is_array($userID) && count($userID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $userID when calling getUserId'
            );
        }
        if (!preg_match('/^[a-zA-Z0-9 \\-*.]+$/', $userID)) {
            throw new \InvalidArgumentException('invalid value for "userID" when calling SearchApi.getUserId, must conform to the pattern /^[a-zA-Z0-9 \\-*.]+$/.');
        }

        $resourcePath = '/1/clusters/mapping/{userID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($userID !== null) {
            $resourcePath = str_replace(
                '{' . 'userID' . '}',
                ObjectSerializer::toPathValue($userID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation hasPendingMappings
     *
     * Has pending mappings
     *
     * @param  bool $getClusters Whether to get clusters or not. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\CreatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function hasPendingMappings($getClusters = null)
    {
        $resourcePath = '/1/clusters/mapping/pending';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($getClusters)) {
            $getClusters = ObjectSerializer::serializeCollection($getClusters, '', true);
        }
        if ($getClusters !== null) {
            $queryParams['getClusters'] = $getClusters;
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation listApiKeys
     *
     * Get the full list of API Keys.
     *
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\ListApiKeysResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function listApiKeys()
    {
        $resourcePath = '/1/keys';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation listClusters
     *
     * List clusters
     *
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\ListClustersResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function listClusters()
    {
        $resourcePath = '/1/clusters';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation listIndices
     *
     * List existing indexes.
     *
     * @param  int $page Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\ListIndicesResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function listIndices($page = null)
    {
        $resourcePath = '/1/indexes';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($page)) {
            $page = ObjectSerializer::serializeCollection($page, '', true);
        }
        if ($page !== null) {
            $queryParams['page'] = $page;
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation listUserIds
     *
     * List userIDs
     *
     * @param  int $page Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). (optional)
     * @param  int $hitsPerPage Maximum number of objects to retrieve. (optional, default to 100)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\ListUserIdsResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function listUserIds($page = null, $hitsPerPage = 100)
    {
        $resourcePath = '/1/clusters/mapping';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($page)) {
            $page = ObjectSerializer::serializeCollection($page, '', true);
        }
        if ($page !== null) {
            $queryParams['page'] = $page;
        }
        // query params
        if (is_array($hitsPerPage)) {
            $hitsPerPage = ObjectSerializer::serializeCollection($hitsPerPage, '', true);
        }
        if ($hitsPerPage !== null) {
            $queryParams['hitsPerPage'] = $hitsPerPage;
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('GET', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation multipleBatch
     *
     * @param  \Algolia\AlgoliaSearch\Model\BatchObject $batchObject batchObject (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\MultipleBatchResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function multipleBatch($batchObject)
    {
        // verify the required parameter 'batchObject' is set
        if ($batchObject === null || (is_array($batchObject) && count($batchObject) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $batchObject when calling multipleBatch'
            );
        }

        $resourcePath = '/1/indexes/*/batch';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($batchObject)) {
            $httpBody = $batchObject;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation multipleQueries
     *
     * @param  \Algolia\AlgoliaSearch\Model\MultipleQueriesObject $multipleQueriesObject multipleQueriesObject (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\MultipleQueriesResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function multipleQueries($multipleQueriesObject)
    {
        // verify the required parameter 'multipleQueriesObject' is set
        if ($multipleQueriesObject === null || (is_array($multipleQueriesObject) && count($multipleQueriesObject) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $multipleQueriesObject when calling multipleQueries'
            );
        }

        $resourcePath = '/1/indexes/*/queries';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($multipleQueriesObject)) {
            $httpBody = $multipleQueriesObject;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation operationIndex
     *
     * Copy/move index.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  \Algolia\AlgoliaSearch\Model\OperationIndexObject $operationIndexObject operationIndexObject (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function operationIndex($indexName, $operationIndexObject)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling operationIndex'
            );
        }
        // verify the required parameter 'operationIndexObject' is set
        if ($operationIndexObject === null || (is_array($operationIndexObject) && count($operationIndexObject) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $operationIndexObject when calling operationIndex'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/operation';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($operationIndexObject)) {
            $httpBody = $operationIndexObject;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation partialUpdateObject
     *
     * Partially update an object.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     * @param  array<string,OneOfStringBuildInOperation>[] $oneOfStringBuildInOperation List of attributes to update. (required)
     * @param  bool $createIfNotExists Creates the record if it does not exist yet. (optional, default to true)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtWithObjectIdResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function partialUpdateObject($indexName, $objectID, $oneOfStringBuildInOperation, $createIfNotExists = true)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling partialUpdateObject'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling partialUpdateObject'
            );
        }
        // verify the required parameter 'oneOfStringBuildInOperation' is set
        if ($oneOfStringBuildInOperation === null || (is_array($oneOfStringBuildInOperation) && count($oneOfStringBuildInOperation) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $oneOfStringBuildInOperation when calling partialUpdateObject'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/{objectID}/partial';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($createIfNotExists)) {
            $createIfNotExists = ObjectSerializer::serializeCollection($createIfNotExists, '', true);
        }
        if ($createIfNotExists !== null) {
            $queryParams['createIfNotExists'] = $createIfNotExists;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($oneOfStringBuildInOperation)) {
            $httpBody = $oneOfStringBuildInOperation;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation removeUserId
     *
     * Remove userID
     *
     * @param  string $userID userID to assign. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\RemoveUserIdResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function removeUserId($userID)
    {
        // verify the required parameter 'userID' is set
        if ($userID === null || (is_array($userID) && count($userID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $userID when calling removeUserId'
            );
        }
        if (!preg_match('/^[a-zA-Z0-9 \\-*.]+$/', $userID)) {
            throw new \InvalidArgumentException('invalid value for "userID" when calling SearchApi.removeUserId, must conform to the pattern /^[a-zA-Z0-9 \\-*.]+$/.');
        }

        $resourcePath = '/1/clusters/mapping/{userID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($userID !== null) {
            $resourcePath = str_replace(
                '{' . 'userID' . '}',
                ObjectSerializer::toPathValue($userID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('DELETE', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation replaceSources
     *
     * @param  \Algolia\AlgoliaSearch\Model\Source[] $source The sources to allow. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\ReplaceSourceResponse
     */
    public function replaceSources($source)
    {
        // verify the required parameter 'source' is set
        if ($source === null || (is_array($source) && count($source) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $source when calling replaceSources'
            );
        }

        $resourcePath = '/1/security/sources';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($source)) {
            $httpBody = $source;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('PUT', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation restoreApiKey
     *
     * Restore an API key.
     *
     * @param  string $key API Key string. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\AddApiKeyResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function restoreApiKey($key)
    {
        // verify the required parameter 'key' is set
        if ($key === null || (is_array($key) && count($key) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $key when calling restoreApiKey'
            );
        }

        $resourcePath = '/1/keys/{key}/restore';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($key !== null) {
            $resourcePath = str_replace(
                '{' . 'key' . '}',
                ObjectSerializer::toPathValue($key),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation saveObject
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  object $body The Algolia object. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\SaveObjectResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function saveObject($indexName, $body)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling saveObject'
            );
        }
        // verify the required parameter 'body' is set
        if ($body === null || (is_array($body) && count($body) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $body when calling saveObject'
            );
        }

        $resourcePath = '/1/indexes/{indexName}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($body)) {
            $httpBody = $body;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation saveRule
     *
     * Save/Update a rule.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     * @param  \Algolia\AlgoliaSearch\Model\Rule $rule rule (required)
     * @param  bool $forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedRuleResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function saveRule($indexName, $objectID, $rule, $forwardToReplicas = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling saveRule'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling saveRule'
            );
        }
        // verify the required parameter 'rule' is set
        if ($rule === null || (is_array($rule) && count($rule) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $rule when calling saveRule'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/rules/{objectID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($forwardToReplicas)) {
            $forwardToReplicas = ObjectSerializer::serializeCollection($forwardToReplicas, '', true);
        }
        if ($forwardToReplicas !== null) {
            $queryParams['forwardToReplicas'] = $forwardToReplicas;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($rule)) {
            $httpBody = $rule;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('PUT', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation saveSynonym
     *
     * Save synonym.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $objectID Unique identifier of an object. (required)
     * @param  \Algolia\AlgoliaSearch\Model\SynonymHit $synonymHit synonymHit (required)
     * @param  bool $forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\SaveSynonymResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function saveSynonym($indexName, $objectID, $synonymHit, $forwardToReplicas = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling saveSynonym'
            );
        }
        // verify the required parameter 'objectID' is set
        if ($objectID === null || (is_array($objectID) && count($objectID) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $objectID when calling saveSynonym'
            );
        }
        // verify the required parameter 'synonymHit' is set
        if ($synonymHit === null || (is_array($synonymHit) && count($synonymHit) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $synonymHit when calling saveSynonym'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/synonyms/{objectID}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($forwardToReplicas)) {
            $forwardToReplicas = ObjectSerializer::serializeCollection($forwardToReplicas, '', true);
        }
        if ($forwardToReplicas !== null) {
            $queryParams['forwardToReplicas'] = $forwardToReplicas;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{' . 'objectID' . '}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($synonymHit)) {
            $httpBody = $synonymHit;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('PUT', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation saveSynonyms
     *
     * Save a batch of synonyms.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  \Algolia\AlgoliaSearch\Model\SynonymHit[] $synonymHit synonymHit (required)
     * @param  bool $forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
     * @param  bool $replaceExistingSynonyms Replace all synonyms of the index with the ones sent with this request. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function saveSynonyms($indexName, $synonymHit, $forwardToReplicas = null, $replaceExistingSynonyms = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling saveSynonyms'
            );
        }
        // verify the required parameter 'synonymHit' is set
        if ($synonymHit === null || (is_array($synonymHit) && count($synonymHit) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $synonymHit when calling saveSynonyms'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/synonyms/batch';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($forwardToReplicas)) {
            $forwardToReplicas = ObjectSerializer::serializeCollection($forwardToReplicas, '', true);
        }
        if ($forwardToReplicas !== null) {
            $queryParams['forwardToReplicas'] = $forwardToReplicas;
        }
        // query params
        if (is_array($replaceExistingSynonyms)) {
            $replaceExistingSynonyms = ObjectSerializer::serializeCollection($replaceExistingSynonyms, '', true);
        }
        if ($replaceExistingSynonyms !== null) {
            $queryParams['replaceExistingSynonyms'] = $replaceExistingSynonyms;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($synonymHit)) {
            $httpBody = $synonymHit;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation search
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  \Algolia\AlgoliaSearch\Model\SearchParams $searchParams searchParams (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\SearchResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function search($indexName, $searchParams)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling search'
            );
        }
        // verify the required parameter 'searchParams' is set
        if ($searchParams === null || (is_array($searchParams) && count($searchParams) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $searchParams when calling search'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/query';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($searchParams)) {
            $httpBody = $searchParams;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation searchDictionaryEntries
     *
     * Search the dictionary entries.
     *
     * @param  string $dictionaryName The dictionary to search in. (required)
     * @param  \Algolia\AlgoliaSearch\Model\SearchDictionaryEntries $searchDictionaryEntries searchDictionaryEntries (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function searchDictionaryEntries($dictionaryName, $searchDictionaryEntries)
    {
        // verify the required parameter 'dictionaryName' is set
        if ($dictionaryName === null || (is_array($dictionaryName) && count($dictionaryName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $dictionaryName when calling searchDictionaryEntries'
            );
        }
        // verify the required parameter 'searchDictionaryEntries' is set
        if ($searchDictionaryEntries === null || (is_array($searchDictionaryEntries) && count($searchDictionaryEntries) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $searchDictionaryEntries when calling searchDictionaryEntries'
            );
        }

        $resourcePath = '/1/dictionaries/{dictionaryName}/search';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($dictionaryName !== null) {
            $resourcePath = str_replace(
                '{' . 'dictionaryName' . '}',
                ObjectSerializer::toPathValue($dictionaryName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($searchDictionaryEntries)) {
            $httpBody = $searchDictionaryEntries;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation searchForFacetValues
     *
     * Search for values of a given facet
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $facetName The facet name. (required)
     * @param  \Algolia\AlgoliaSearch\Model\SearchForFacetValuesRequest $searchForFacetValuesRequest searchForFacetValuesRequest (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\SearchForFacetValuesResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function searchForFacetValues($indexName, $facetName, $searchForFacetValuesRequest = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling searchForFacetValues'
            );
        }
        // verify the required parameter 'facetName' is set
        if ($facetName === null || (is_array($facetName) && count($facetName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $facetName when calling searchForFacetValues'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/facets/{facetName}/query';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        // path params
        if ($facetName !== null) {
            $resourcePath = str_replace(
                '{' . 'facetName' . '}',
                ObjectSerializer::toPathValue($facetName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($searchForFacetValuesRequest)) {
            $httpBody = $searchForFacetValuesRequest;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation searchRules
     *
     * Search for rules.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  \Algolia\AlgoliaSearch\Model\SearchRulesParams $searchRulesParams searchRulesParams (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\SearchRulesResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function searchRules($indexName, $searchRulesParams)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling searchRules'
            );
        }
        // verify the required parameter 'searchRulesParams' is set
        if ($searchRulesParams === null || (is_array($searchRulesParams) && count($searchRulesParams) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $searchRulesParams when calling searchRules'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/rules/search';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($searchRulesParams)) {
            $httpBody = $searchRulesParams;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation searchSynonyms
     *
     * Get all synonyms that match a query.
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  string $query Search for specific synonyms matching this string. (optional, default to '')
     * @param  string $type Only search for specific types of synonyms. (optional)
     * @param  int $page Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). (optional, default to 0)
     * @param  int $hitsPerPage Maximum number of objects to retrieve. (optional, default to 100)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\SearchSynonymsResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function searchSynonyms($indexName, $query = '', $type = null, $page = 0, $hitsPerPage = 100)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling searchSynonyms'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/synonyms/search';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($query)) {
            $query = ObjectSerializer::serializeCollection($query, '', true);
        }
        if ($query !== null) {
            $queryParams['query'] = $query;
        }
        // query params
        if (is_array($type)) {
            $type = ObjectSerializer::serializeCollection($type, '', true);
        }
        if ($type !== null) {
            $queryParams['type'] = $type;
        }
        // query params
        if (is_array($page)) {
            $page = ObjectSerializer::serializeCollection($page, '', true);
        }
        if ($page !== null) {
            $queryParams['page'] = $page;
        }
        // query params
        if (is_array($hitsPerPage)) {
            $hitsPerPage = ObjectSerializer::serializeCollection($hitsPerPage, '', true);
        }
        if ($hitsPerPage !== null) {
            $queryParams['hitsPerPage'] = $hitsPerPage;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            []
        );

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation searchUserIds
     *
     * Search userID
     *
     * @param  \Algolia\AlgoliaSearch\Model\SearchUserIdsObject $searchUserIdsObject searchUserIdsObject (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\SearchUserIdsResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function searchUserIds($searchUserIdsObject)
    {
        // verify the required parameter 'searchUserIdsObject' is set
        if ($searchUserIdsObject === null || (is_array($searchUserIdsObject) && count($searchUserIdsObject) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $searchUserIdsObject when calling searchUserIds'
            );
        }

        $resourcePath = '/1/clusters/mapping/search';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($searchUserIdsObject)) {
            $httpBody = $searchUserIdsObject;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('POST', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation setDictionarySettings
     *
     * Set dictionary settings.
     *
     * @param  \Algolia\AlgoliaSearch\Model\DictionarySettingsRequest $dictionarySettingsRequest dictionarySettingsRequest (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function setDictionarySettings($dictionarySettingsRequest)
    {
        // verify the required parameter 'dictionarySettingsRequest' is set
        if ($dictionarySettingsRequest === null || (is_array($dictionarySettingsRequest) && count($dictionarySettingsRequest) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $dictionarySettingsRequest when calling setDictionarySettings'
            );
        }

        $resourcePath = '/1/dictionaries/*/settings';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($dictionarySettingsRequest)) {
            $httpBody = $dictionarySettingsRequest;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('PUT', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation setSettings
     *
     * @param  string $indexName The index in which to perform the request. (required)
     * @param  \Algolia\AlgoliaSearch\Model\IndexSettings $indexSettings indexSettings (required)
     * @param  bool $forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdatedAtResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function setSettings($indexName, $indexSettings, $forwardToReplicas = null)
    {
        // verify the required parameter 'indexName' is set
        if ($indexName === null || (is_array($indexName) && count($indexName) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexName when calling setSettings'
            );
        }
        // verify the required parameter 'indexSettings' is set
        if ($indexSettings === null || (is_array($indexSettings) && count($indexSettings) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $indexSettings when calling setSettings'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/settings';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if (is_array($forwardToReplicas)) {
            $forwardToReplicas = ObjectSerializer::serializeCollection($forwardToReplicas, '', true);
        }
        if ($forwardToReplicas !== null) {
            $queryParams['forwardToReplicas'] = $forwardToReplicas;
        }
        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{' . 'indexName' . '}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($indexSettings)) {
            $httpBody = $indexSettings;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('PUT', $resourcePath, $query, $httpBody);
    }
    /**
     * Operation updateApiKey
     *
     * Update an API key.
     *
     * @param  string $key API Key string. (required)
     * @param  \Algolia\AlgoliaSearch\Model\ApiKey $apiKey apiKey (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\UpdateApiKeyResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function updateApiKey($key, $apiKey)
    {
        // verify the required parameter 'key' is set
        if ($key === null || (is_array($key) && count($key) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $key when calling updateApiKey'
            );
        }
        // verify the required parameter 'apiKey' is set
        if ($apiKey === null || (is_array($apiKey) && count($apiKey) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $apiKey when calling updateApiKey'
            );
        }

        $resourcePath = '/1/keys/{key}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // path params
        if ($key !== null) {
            $resourcePath = str_replace(
                '{' . 'key' . '}',
                ObjectSerializer::toPathValue($key),
                $resourcePath
            );
        }
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($apiKey)) {
            $httpBody = $apiKey;
        }

        $defaultHeaders = [];
        if ($this->config->getUserAgent()) {
            $defaultHeaders['User-Agent'] = $this->config->getUserAgent();
        }

        $headers = array_merge(
            $defaultHeaders,
            $headerParams,
            $headers
        );

        $query = \GuzzleHttp\Psr7\Query::build($queryParams);

        return $this->sendRequest('PUT', $resourcePath, $query, $httpBody);
    }

    private function sendRequest($method, $resourcePath, $query, $httpBody)
    {
        if ($method === 'GET') {
            $request = $this->api->read(
                $method,
                $resourcePath . ($query ? "?{$query}" : '')
            );
        } else {
            $request = $this->api->write(
                $method,
                $resourcePath . ($query ? "?{$query}" : ''),
                $httpBody
            );
        }

        return $request;
    }
}
