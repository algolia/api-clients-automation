<?php

// This file is generated, manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.

namespace Algolia\AlgoliaSearch\Api;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Configuration\RecommendConfig;
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
    public function __construct(
        ApiWrapperInterface $apiWrapper,
        RecommendConfig $config
    ) {
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
        return static::createWithConfig(
            RecommendConfig::create($appId, $apiKey)
        );
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
        $cacheKey = sprintf(
            '%s-clusterHosts-%s',
            __CLASS__,
            $config->getAppId()
        );

        if ($hosts = $config->getHosts()) {
            // If a list of hosts was passed, we ignore the cache
            $clusterHosts = ClusterHosts::create($hosts);
        } elseif (
            false === ($clusterHosts = ClusterHosts::createFromCache($cacheKey))
        ) {
            // We'll try to restore the ClusterHost from cache, if we cannot
            // we create a new instance and set the cache key
            $clusterHosts = ClusterHosts::createFromAppId(
                $config->getAppId()
            )->setCacheKey($cacheKey);
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
     * @param string $path The path of the API endpoint to target, anything after the /1 needs to be specified. (required)
     * @param array $parameters Query parameters to be applied to the current query. (optional)
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
            $resourcePath = str_replace('{path}', $path, $resourcePath);
        }

        return $this->sendRequest(
            'DELETE',
            $resourcePath,
            $headers,
            $queryParameters,
            $httpBody,
            $requestOptions
        );
    }

    /**
     * Send requests to the Algolia REST API.
     *
     * @param string $path The path of the API endpoint to target, anything after the /1 needs to be specified. (required)
     * @param array $parameters Query parameters to be applied to the current query. (optional)
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
            $resourcePath = str_replace('{path}', $path, $resourcePath);
        }

        return $this->sendRequest(
            'GET',
            $resourcePath,
            $headers,
            $queryParameters,
            $httpBody,
            $requestOptions
        );
    }

    /**
     * Get results.
     *
     * @param array $getRecommendationsParams getRecommendationsParams (required)
     * - $getRecommendationsParams['requests'] => (array) The `getRecommendations` requests. (required)
     *
     * @see \Algolia\AlgoliaSearch\Model\Recommend\GetRecommendationsParams
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|\Algolia\AlgoliaSearch\Model\Recommend\GetRecommendationsResponse
     */
    public function getRecommendations(
        $getRecommendationsParams,
        $requestOptions = []
    ) {
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

        return $this->sendRequest(
            'POST',
            $resourcePath,
            $headers,
            $queryParameters,
            $httpBody,
            $requestOptions,
            true
        );
    }

    /**
     * Send requests to the Algolia REST API.
     *
     * @param string $path The path of the API endpoint to target, anything after the /1 needs to be specified. (required)
     * @param array $parameters Query parameters to be applied to the current query. (optional)
     * @param array $body The parameters to send with the custom request. (optional)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function post(
        $path,
        $parameters = null,
        $body = null,
        $requestOptions = []
    ) {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `post`.'
            );
        }

        $resourcePath = '/1{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody = isset($body) ? $body : [];

        if ($parameters !== null) {
            $queryParameters = $parameters;
        }

        // path params
        if ($path !== null) {
            $resourcePath = str_replace('{path}', $path, $resourcePath);
        }

        return $this->sendRequest(
            'POST',
            $resourcePath,
            $headers,
            $queryParameters,
            $httpBody,
            $requestOptions
        );
    }

    /**
     * Send requests to the Algolia REST API.
     *
     * @param string $path The path of the API endpoint to target, anything after the /1 needs to be specified. (required)
     * @param array $parameters Query parameters to be applied to the current query. (optional)
     * @param array $body The parameters to send with the custom request. (optional)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function put(
        $path,
        $parameters = null,
        $body = null,
        $requestOptions = []
    ) {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `put`.'
            );
        }

        $resourcePath = '/1{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody = isset($body) ? $body : [];

        if ($parameters !== null) {
            $queryParameters = $parameters;
        }

        // path params
        if ($path !== null) {
            $resourcePath = str_replace('{path}', $path, $resourcePath);
        }

        return $this->sendRequest(
            'PUT',
            $resourcePath,
            $headers,
            $queryParameters,
            $httpBody,
            $requestOptions
        );
    }

    private function sendRequest(
        $method,
        $resourcePath,
        $headers,
        $queryParameters,
        $httpBody,
        $requestOptions,
        $useReadTransporter = false
    ) {
        if (!isset($requestOptions['headers'])) {
            $requestOptions['headers'] = [];
        }
        if (!isset($requestOptions['queryParameters'])) {
            $requestOptions['queryParameters'] = [];
        }

        $requestOptions['headers'] = array_merge(
            $headers,
            $requestOptions['headers']
        );
        $requestOptions['queryParameters'] = array_merge(
            $queryParameters,
            $requestOptions['queryParameters']
        );
        $query = \GuzzleHttp\Psr7\Query::build(
            $requestOptions['queryParameters']
        );

        return $this->api->sendRequest(
            $method,
            $resourcePath . ($query ? "?{$query}" : ''),
            $httpBody,
            $requestOptions,
            $useReadTransporter
        );
    }
}
