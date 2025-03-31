<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Api;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Configuration\MonitoringConfig;
use Algolia\AlgoliaSearch\Model\Monitoring\IncidentsResponse;
use Algolia\AlgoliaSearch\Model\Monitoring\IndexingTimeResponse;
use Algolia\AlgoliaSearch\Model\Monitoring\InfrastructureResponse;
use Algolia\AlgoliaSearch\Model\Monitoring\InventoryResponse;
use Algolia\AlgoliaSearch\Model\Monitoring\LatencyResponse;
use Algolia\AlgoliaSearch\Model\Monitoring\StatusResponse;
use Algolia\AlgoliaSearch\ObjectSerializer;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapperInterface;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use GuzzleHttp\Psr7\Query;

/**
 * MonitoringClient Class Doc Comment.
 *
 * @category Class
 */
class MonitoringClient
{
    public const VERSION = '4.18.0';

    /**
     * @var ApiWrapperInterface
     */
    protected $api;

    /**
     * @var MonitoringConfig
     */
    protected $config;

    public function __construct(ApiWrapperInterface $apiWrapper, MonitoringConfig $config)
    {
        $this->config = $config;
        $this->api = $apiWrapper;
    }

    /**
     * Instantiate the client with basic credentials.
     *
     * @param string $appId  Application ID
     * @param string $apiKey Algolia API Key
     */
    public static function create($appId = null, $apiKey = null)
    {
        return static::createWithConfig(MonitoringConfig::create($appId, $apiKey));
    }

    /**
     * Instantiate the client with configuration.
     *
     * @param MonitoringConfig $config Configuration
     */
    public static function createWithConfig(MonitoringConfig $config)
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
     * Gets the cluster hosts depending on the config.
     *
     * @return ClusterHosts
     */
    public static function getClusterHosts(MonitoringConfig $config)
    {
        if ($hosts = $config->getHosts()) {
            // If a list of hosts was passed, we ignore the cache
            $clusterHosts = ClusterHosts::create($hosts);
        } else {
            $clusterHosts = ClusterHosts::create([
                'status.algolia.com',
            ]);
        }

        return $clusterHosts;
    }

    /**
     * @return MonitoringConfig
     */
    public function getClientConfig()
    {
        return $this->config;
    }

    /**
     * Stub method setting a new API key to authenticate requests.
     *
     * @param string $apiKey
     */
    public function setClientApiKey($apiKey)
    {
        $this->config->setClientApiKey($apiKey);
    }

    /**
     * This method lets you send requests to the Algolia REST API.
     *
     * @param string $path           Path of the endpoint, anything after \"/1\" must be specified. (required)
     * @param array  $parameters     Query parameters to apply to the current query. (optional)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function customDelete($path, $parameters = null, $requestOptions = [])
    {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `customDelete`.'
            );
        }

        $resourcePath = '/{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        if (null !== $parameters) {
            $queryParameters = $parameters;
        }

        // path params
        if (null !== $path) {
            $resourcePath = str_replace(
                '{path}',
                $path,
                $resourcePath
            );
        }

        return $this->sendRequest('DELETE', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * This method lets you send requests to the Algolia REST API.
     *
     * @param string $path           Path of the endpoint, anything after \"/1\" must be specified. (required)
     * @param array  $parameters     Query parameters to apply to the current query. (optional)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function customGet($path, $parameters = null, $requestOptions = [])
    {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `customGet`.'
            );
        }

        $resourcePath = '/{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        if (null !== $parameters) {
            $queryParameters = $parameters;
        }

        // path params
        if (null !== $path) {
            $resourcePath = str_replace(
                '{path}',
                $path,
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * This method lets you send requests to the Algolia REST API.
     *
     * @param string $path           Path of the endpoint, anything after \"/1\" must be specified. (required)
     * @param array  $parameters     Query parameters to apply to the current query. (optional)
     * @param array  $body           Parameters to send with the custom request. (optional)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function customPost($path, $parameters = null, $body = null, $requestOptions = [])
    {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `customPost`.'
            );
        }

        $resourcePath = '/{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody = isset($body) ? $body : [];

        if (null !== $parameters) {
            $queryParameters = $parameters;
        }

        // path params
        if (null !== $path) {
            $resourcePath = str_replace(
                '{path}',
                $path,
                $resourcePath
            );
        }

        return $this->sendRequest('POST', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * This method lets you send requests to the Algolia REST API.
     *
     * @param string $path           Path of the endpoint, anything after \"/1\" must be specified. (required)
     * @param array  $parameters     Query parameters to apply to the current query. (optional)
     * @param array  $body           Parameters to send with the custom request. (optional)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|object
     */
    public function customPut($path, $parameters = null, $body = null, $requestOptions = [])
    {
        // verify the required parameter 'path' is set
        if (!isset($path)) {
            throw new \InvalidArgumentException(
                'Parameter `path` is required when calling `customPut`.'
            );
        }

        $resourcePath = '/{path}';
        $queryParameters = [];
        $headers = [];
        $httpBody = isset($body) ? $body : [];

        if (null !== $parameters) {
            $queryParameters = $parameters;
        }

        // path params
        if (null !== $path) {
            $resourcePath = str_replace(
                '{path}',
                $path,
                $resourcePath
            );
        }

        return $this->sendRequest('PUT', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Retrieves known incidents for the selected clusters.
     *
     * @param string $clusters       Subset of clusters, separated by commas. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|IncidentsResponse
     */
    public function getClusterIncidents($clusters, $requestOptions = [])
    {
        // verify the required parameter 'clusters' is set
        if (!isset($clusters)) {
            throw new \InvalidArgumentException(
                'Parameter `clusters` is required when calling `getClusterIncidents`.'
            );
        }

        $resourcePath = '/1/incidents/{clusters}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $clusters) {
            $resourcePath = str_replace(
                '{clusters}',
                ObjectSerializer::toPathValue($clusters),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Retrieves the status of selected clusters.
     *
     * @param string $clusters       Subset of clusters, separated by commas. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|StatusResponse
     */
    public function getClusterStatus($clusters, $requestOptions = [])
    {
        // verify the required parameter 'clusters' is set
        if (!isset($clusters)) {
            throw new \InvalidArgumentException(
                'Parameter `clusters` is required when calling `getClusterStatus`.'
            );
        }

        $resourcePath = '/1/status/{clusters}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $clusters) {
            $resourcePath = str_replace(
                '{clusters}',
                ObjectSerializer::toPathValue($clusters),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Retrieves known incidents for all clusters.
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|IncidentsResponse
     */
    public function getIncidents($requestOptions = [])
    {
        $resourcePath = '/1/incidents';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Retrieves average times for indexing operations for selected clusters.
     *
     * @param string $clusters       Subset of clusters, separated by commas. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|IndexingTimeResponse
     */
    public function getIndexingTime($clusters, $requestOptions = [])
    {
        // verify the required parameter 'clusters' is set
        if (!isset($clusters)) {
            throw new \InvalidArgumentException(
                'Parameter `clusters` is required when calling `getIndexingTime`.'
            );
        }

        $resourcePath = '/1/indexing/{clusters}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $clusters) {
            $resourcePath = str_replace(
                '{clusters}',
                ObjectSerializer::toPathValue($clusters),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Retrieves the average latency for search requests for selected clusters.
     *
     * @param string $clusters       Subset of clusters, separated by commas. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|LatencyResponse
     */
    public function getLatency($clusters, $requestOptions = [])
    {
        // verify the required parameter 'clusters' is set
        if (!isset($clusters)) {
            throw new \InvalidArgumentException(
                'Parameter `clusters` is required when calling `getLatency`.'
            );
        }

        $resourcePath = '/1/latency/{clusters}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $clusters) {
            $resourcePath = str_replace(
                '{clusters}',
                ObjectSerializer::toPathValue($clusters),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Retrieves metrics related to your Algolia infrastructure, aggregated over a selected time window.  Access to this API is available as part of the [Premium or Elevate plans](https://www.algolia.com/pricing). You must authenticate requests with the `x-algolia-application-id` and `x-algolia-api-key` headers (using the Monitoring API key).
     *
     * @param array $metric         Metric to report.  For more information about the individual metrics, see the description of the API response. To include all metrics, use `*`. (required)
     * @param array $period         Period over which to aggregate the metrics:  - `minute`. Aggregate the last minute. 1 data point per 10 seconds. - `hour`. Aggregate the last hour. 1 data point per minute. - `day`. Aggregate the last day. 1 data point per 10 minutes. - `week`. Aggregate the last week. 1 data point per hour. - `month`. Aggregate the last month. 1 data point per day. (required)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|InfrastructureResponse
     */
    public function getMetrics($metric, $period, $requestOptions = [])
    {
        // verify the required parameter 'metric' is set
        if (!isset($metric)) {
            throw new \InvalidArgumentException(
                'Parameter `metric` is required when calling `getMetrics`.'
            );
        }
        // verify the required parameter 'period' is set
        if (!isset($period)) {
            throw new \InvalidArgumentException(
                'Parameter `period` is required when calling `getMetrics`.'
            );
        }

        $resourcePath = '/1/infrastructure/{metric}/period/{period}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $metric) {
            $resourcePath = str_replace(
                '{metric}',
                ObjectSerializer::toPathValue($metric),
                $resourcePath
            );
        }

        // path params
        if (null !== $period) {
            $resourcePath = str_replace(
                '{period}',
                ObjectSerializer::toPathValue($period),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Test whether clusters are reachable or not.
     *
     * @param string $clusters       Subset of clusters, separated by commas. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|array<string,array>
     */
    public function getReachability($clusters, $requestOptions = [])
    {
        // verify the required parameter 'clusters' is set
        if (!isset($clusters)) {
            throw new \InvalidArgumentException(
                'Parameter `clusters` is required when calling `getReachability`.'
            );
        }

        $resourcePath = '/1/reachability/{clusters}/probes';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $clusters) {
            $resourcePath = str_replace(
                '{clusters}',
                ObjectSerializer::toPathValue($clusters),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Retrieves the servers that belong to clusters.  The response depends on whether you authenticate your API request:  - With authentication, the response lists the servers assigned to your Algolia application's cluster.  - Without authentication, the response lists the servers for all Algolia clusters.
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|InventoryResponse
     */
    public function getServers($requestOptions = [])
    {
        $resourcePath = '/1/inventory/servers';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Retrieves the status of all Algolia clusters and instances.
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|StatusResponse
     */
    public function getStatus($requestOptions = [])
    {
        $resourcePath = '/1/status';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
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
        $query = Query::build($requestOptions['queryParameters']);

        return $this->api->sendRequest(
            $method,
            $resourcePath.($query ? "?{$query}" : ''),
            $httpBody,
            $requestOptions,
            $useReadTransporter
        );
    }
}
