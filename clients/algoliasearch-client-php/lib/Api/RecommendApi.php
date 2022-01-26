<?php

namespace Algolia\AlgoliaSearch\Api;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Configuration\RecommendConfig;
use Algolia\AlgoliaSearch\HeaderSelector;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapperInterface;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;

/**
 * RecommendApi Class Doc Comment
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class RecommendApi
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
     * @var HeaderSelector
     */
    protected $headerSelector;

    /**
     * @param RecommendConfig $config
     * @param ApiWrapperInterface $apiWrapper
     */
    public function __construct(ApiWrapperInterface $apiWrapper, RecommendConfig $config)
    {
        $this->config = $config;

        $this->api = $apiWrapper;
        $this->headerSelector = new HeaderSelector();
    }

    /**
     * Instantiate the client with basic credentials and region
     *
     * @param string $appId  Application ID
     * @param string $apiKey Algolia API Key
     * @param string $region Region
     */
    public static function create($appId = null, $apiKey = null, $region = null)
    {
        $config = RecommendConfig::create($appId, $apiKey, $region);

        return static::createWithConfig($config);
    }

    /**
     * Instantiate the client with congiguration
     *
     * @param RecommendConfig $config Configuration
     */
    public static function createWithConfig(RecommendConfig $config)
    {
        $config = clone $config;

        if ($hosts = $config->getHosts()) {
            // If a list of hosts was passed, we ignore the cache
            $clusterHosts = ClusterHosts::create($hosts);
        } else {
            $clusterHosts = ClusterHosts::createFromAppId($config->getAppId());
        }

        $apiWrapper = new ApiWrapper(
            Algolia::getHttpClient(),
            $config,
            $clusterHosts
        );

        return new static($apiWrapper, $config);
    }

    /**
     * @return RecommendConfig
     */
    public function getClientConfig()
    {
        return $this->config;
    }

    /**
     * Operation getRecommendations
     *
     * @param  \Algolia\AlgoliaSearch\Model\GetRecommendations $getRecommendations getRecommendations (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\GetRecommendationsResponse|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase|\Algolia\AlgoliaSearch\Model\ErrorBase
     */
    public function getRecommendations($getRecommendations)
    {
        // verify the required parameter 'getRecommendations' is set
        if ($getRecommendations === null || (is_array($getRecommendations) && count($getRecommendations) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $getRecommendations when calling getRecommendations'
            );
        }

        $resourcePath = '/1/indexes/*/recommendations';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        $headers = $this->headerSelector->selectHeaders(
            ['application/json'],
            ['application/json']
        );
        if (isset($getRecommendations)) {
            $httpBody = $getRecommendations;
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
