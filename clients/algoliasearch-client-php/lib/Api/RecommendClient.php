<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Api;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Configuration\RecommendConfig;
use Algolia\AlgoliaSearch\ObjectSerializer;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapperInterface;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;

/**
 * RecommendClient Class Doc Comment
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class RecommendClient
{
    /**
     * @var ApiWrapperInterface
     */
    protected $api;

    /**
     * @var RecommendConfig
     */
    protected $config;

    /**
     * @param RecommendConfig $config
     * @param ApiWrapperInterface $apiWrapper
     */
    public function __construct(ApiWrapperInterface $apiWrapper, RecommendConfig $config)
    {
        $this->config = $config;
        $this->api = $apiWrapper;
    }

    /**
     * Instantiate the client with basic credentials
     *
     * @param string $appId  Application ID
     * @param string $apiKey Algolia API Key
     */
    public static function create($appId = null, $apiKey = null)
    {
        return static::createWithConfig(RecommendConfig::create($appId, $apiKey));
    }

    /**
     * Instantiate the client with configuration
     *
     * @param RecommendConfig $config Configuration
     */
    public static function createWithConfig(RecommendConfig $config)
    {
        $config = clone $config;

        $apiWrapper = new ApiWrapper(
            Algolia::getHttpClient(),
            $config,
            self::getClusterHosts($config)
        );

        return new static($apiWrapper, $config);
    }

    /**
     * Gets the cluster hosts depending on the config
     *
     * @param RecommendConfig $config
     *
     * @return ClusterHosts
     */
    public static function getClusterHosts(RecommendConfig $config)
    {
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

        return $clusterHosts;
    }

    /**
     * @return RecommendConfig
     */
    public function getClientConfig()
    {
        return $this->config;
    }

    /**
     * Send requests to the Algolia REST API.
     *
     * @param string $path Path of the endpoint, anything after \&quot;/1\&quot; must be specified. (required)
     * @param array $parameters Query parameters to apply to the current query. (optional)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function del($path, $parameters = null, $requestOptions = [])
    {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `del`.'
            );
        }

        $resourcePath = '/1{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        if ($parameters !== null) {
            $queryParameters = $parameters;
        }

        // path params
        if ($path !== null) {
            $resourcePath = str_replace(
                '{path}',
                $path,
                $resourcePath
            );
        }

        return $this->sendRequest('DELETE', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, );
    }

    /**
     * Delete a Recommend rule.
     *
     * @param string $indexName Index on which to perform the request. (required)
     * @param array $model [Recommend models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models). (required)
     * @param string $objectID Unique record (object) identifier. (required)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|\Algolia\AlgoliaSearch\Model\Recommend\DeletedAtResponse
     */
    public function deleteRecommendRule($indexName, $model, $objectID, $requestOptions = [])
    {
        // verify the required parameter 'indexName' is set
        if (!isset($indexName)) {
            throw new \InvalidArgumentException(
                'Parameter `indexName` is required when calling `deleteRecommendRule`.'
            );
        }
        // verify the required parameter 'model' is set
        if (!isset($model)) {
            throw new \InvalidArgumentException(
                'Parameter `model` is required when calling `deleteRecommendRule`.'
            );
        }
        // verify the required parameter 'objectID' is set
        if (!isset($objectID)) {
            throw new \InvalidArgumentException(
                'Parameter `objectID` is required when calling `deleteRecommendRule`.'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/{model}/recommend/rules/{objectID}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{indexName}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }

        // path params
        if ($model !== null) {
            $resourcePath = str_replace(
                '{model}',
                ObjectSerializer::toPathValue($model),
                $resourcePath
            );
        }

        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{objectID}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }

        return $this->sendRequest('DELETE', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, );
    }

    /**
     * Send requests to the Algolia REST API.
     *
     * @param string $path Path of the endpoint, anything after \&quot;/1\&quot; must be specified. (required)
     * @param array $parameters Query parameters to apply to the current query. (optional)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function get($path, $parameters = null, $requestOptions = [])
    {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `get`.'
            );
        }

        $resourcePath = '/1{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        if ($parameters !== null) {
            $queryParameters = $parameters;
        }

        // path params
        if ($path !== null) {
            $resourcePath = str_replace(
                '{path}',
                $path,
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, );
    }

    /**
     * Get a Recommend rule.
     *
     * @param string $indexName Index on which to perform the request. (required)
     * @param array $model [Recommend models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models). (required)
     * @param string $objectID Unique record (object) identifier. (required)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|\Algolia\AlgoliaSearch\Model\Recommend\RuleResponse
     */
    public function getRecommendRule($indexName, $model, $objectID, $requestOptions = [])
    {
        // verify the required parameter 'indexName' is set
        if (!isset($indexName)) {
            throw new \InvalidArgumentException(
                'Parameter `indexName` is required when calling `getRecommendRule`.'
            );
        }
        // verify the required parameter 'model' is set
        if (!isset($model)) {
            throw new \InvalidArgumentException(
                'Parameter `model` is required when calling `getRecommendRule`.'
            );
        }
        // verify the required parameter 'objectID' is set
        if (!isset($objectID)) {
            throw new \InvalidArgumentException(
                'Parameter `objectID` is required when calling `getRecommendRule`.'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/{model}/recommend/rules/{objectID}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{indexName}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }

        // path params
        if ($model !== null) {
            $resourcePath = str_replace(
                '{model}',
                ObjectSerializer::toPathValue($model),
                $resourcePath
            );
        }

        // path params
        if ($objectID !== null) {
            $resourcePath = str_replace(
                '{objectID}',
                ObjectSerializer::toPathValue($objectID),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, );
    }

    /**
     * Get a Recommend task&#39;s status.
     *
     * @param string $indexName Index on which to perform the request. (required)
     * @param array $model [Recommend models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models). (required)
     * @param int $taskID Unique identifier of a task. Numeric value (up to 64bits). (required)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|\Algolia\AlgoliaSearch\Model\Recommend\GetRecommendTaskResponse
     */
    public function getRecommendStatus($indexName, $model, $taskID, $requestOptions = [])
    {
        // verify the required parameter 'indexName' is set
        if (!isset($indexName)) {
            throw new \InvalidArgumentException(
                'Parameter `indexName` is required when calling `getRecommendStatus`.'
            );
        }
        // verify the required parameter 'model' is set
        if (!isset($model)) {
            throw new \InvalidArgumentException(
                'Parameter `model` is required when calling `getRecommendStatus`.'
            );
        }
        // verify the required parameter 'taskID' is set
        if (!isset($taskID)) {
            throw new \InvalidArgumentException(
                'Parameter `taskID` is required when calling `getRecommendStatus`.'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/{model}/task/{taskID}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{indexName}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }

        // path params
        if ($model !== null) {
            $resourcePath = str_replace(
                '{model}',
                ObjectSerializer::toPathValue($model),
                $resourcePath
            );
        }

        // path params
        if ($taskID !== null) {
            $resourcePath = str_replace(
                '{taskID}',
                ObjectSerializer::toPathValue($taskID),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, );
    }

    /**
     * Get recommendations and trending items.
     *
     * @param array $getRecommendationsParams getRecommendationsParams (required)
     * - $getRecommendationsParams['requests'] => (array) Request parameters depend on the model (recommendations or trending). (required)
     *
     * @see \Algolia\AlgoliaSearch\Model\Recommend\GetRecommendationsParams
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|\Algolia\AlgoliaSearch\Model\Recommend\GetRecommendationsResponse
     */
    public function getRecommendations($getRecommendationsParams, $requestOptions = [])
    {
        // verify the required parameter 'getRecommendationsParams' is set
        if (!isset($getRecommendationsParams)) {
            throw new \InvalidArgumentException(
                'Parameter `getRecommendationsParams` is required when calling `getRecommendations`.'
            );
        }

        $resourcePath = '/1/indexes/*/recommendations';
        $queryParameters = [];
        $headers = [];
        $httpBody = $getRecommendationsParams;

        return $this->sendRequest('POST', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, true);
    }

    /**
     * Send requests to the Algolia REST API.
     *
     * @param string $path Path of the endpoint, anything after \&quot;/1\&quot; must be specified. (required)
     * @param array $parameters Query parameters to apply to the current query. (optional)
     * @param array $body Parameters to send with the custom request. (optional)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function post($path, $parameters = null, $body = null, $requestOptions = [])
    {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `post`.'
            );
        }

        $resourcePath = '/1{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody =  isset($body) ? $body : [];

        if ($parameters !== null) {
            $queryParameters = $parameters;
        }

        // path params
        if ($path !== null) {
            $resourcePath = str_replace(
                '{path}',
                $path,
                $resourcePath
            );
        }

        return $this->sendRequest('POST', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, );
    }

    /**
     * Send requests to the Algolia REST API.
     *
     * @param string $path Path of the endpoint, anything after \&quot;/1\&quot; must be specified. (required)
     * @param array $parameters Query parameters to apply to the current query. (optional)
     * @param array $body Parameters to send with the custom request. (optional)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function put($path, $parameters = null, $body = null, $requestOptions = [])
    {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `put`.'
            );
        }

        $resourcePath = '/1{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody =  isset($body) ? $body : [];

        if ($parameters !== null) {
            $queryParameters = $parameters;
        }

        // path params
        if ($path !== null) {
            $resourcePath = str_replace(
                '{path}',
                $path,
                $resourcePath
            );
        }

        return $this->sendRequest('PUT', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, );
    }

    /**
     * List Recommend rules.
     *
     * @param string $indexName Index on which to perform the request. (required)
     * @param array $model [Recommend models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models). (required)
     * @param array $searchRecommendRulesParams searchRecommendRulesParams (optional)
     * - $searchRecommendRulesParams['query'] => (string) Full-text query.
     * - $searchRecommendRulesParams['context'] => (string) Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules).
     * - $searchRecommendRulesParams['page'] => (int) Requested page (the first page is page 0).
     * - $searchRecommendRulesParams['hitsPerPage'] => (int) Maximum number of hits per page.
     * - $searchRecommendRulesParams['enabled'] => (bool) Restricts responses to enabled rules. When absent (default), _all_ rules are retrieved.
     * - $searchRecommendRulesParams['requestOptions'] => (array) Request options to send with the API call.
     *
     * @see \Algolia\AlgoliaSearch\Model\Recommend\SearchRecommendRulesParams
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|\Algolia\AlgoliaSearch\Model\Recommend\SearchRecommendRulesResponse
     */
    public function searchRecommendRules($indexName, $model, $searchRecommendRulesParams = null, $requestOptions = [])
    {
        // verify the required parameter 'indexName' is set
        if (!isset($indexName)) {
            throw new \InvalidArgumentException(
                'Parameter `indexName` is required when calling `searchRecommendRules`.'
            );
        }
        // verify the required parameter 'model' is set
        if (!isset($model)) {
            throw new \InvalidArgumentException(
                'Parameter `model` is required when calling `searchRecommendRules`.'
            );
        }

        $resourcePath = '/1/indexes/{indexName}/{model}/recommend/rules/search';
        $queryParameters = [];
        $headers = [];
        $httpBody =  isset($searchRecommendRulesParams) ? $searchRecommendRulesParams : [];

        // path params
        if ($indexName !== null) {
            $resourcePath = str_replace(
                '{indexName}',
                ObjectSerializer::toPathValue($indexName),
                $resourcePath
            );
        }

        // path params
        if ($model !== null) {
            $resourcePath = str_replace(
                '{model}',
                ObjectSerializer::toPathValue($model),
                $resourcePath
            );
        }

        return $this->sendRequest('POST', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, true);
    }

    private function sendRequest($method, $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions, $useReadTransporter = false)
    {
        if (!isset($requestOptions['headers'])) {
            $requestOptions['headers'] = [];
        }
        if (!isset($requestOptions['queryParameters'])) {
            $requestOptions['queryParameters'] = [];
        }

        $requestOptions['headers'] = array_merge($headers, $requestOptions['headers']);
        $requestOptions['queryParameters'] = array_merge($queryParameters, $requestOptions['queryParameters']);
        $query = \GuzzleHttp\Psr7\Query::build($requestOptions['queryParameters']);

        return $this->api->sendRequest(
            $method,
            $resourcePath . ($query ? "?{$query}" : ''),
            $httpBody,
            $requestOptions,
            $useReadTransporter
        );
    }
}
