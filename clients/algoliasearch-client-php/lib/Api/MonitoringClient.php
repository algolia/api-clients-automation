<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Api;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Configuration\MonitoringConfig;
use Algolia\AlgoliaSearch\ObjectSerializer;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapperInterface;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;

/**
 * MonitoringClient Class Doc Comment.
 *
 * @category Class
 */
class MonitoringClient
{
    public const VERSION = '4.0.0-alpha.99';

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
            $clusterHosts = ClusterHosts::create('status.algolia.com');
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
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param string $path           Path of the endpoint, anything after \&quot;/1\&quot; must be specified. (required)
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

        $resourcePath = '/1{path}';
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
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param string $path           Path of the endpoint, anything after \&quot;/1\&quot; must be specified. (required)
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

        $resourcePath = '/1{path}';
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
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param string $path           Path of the endpoint, anything after \&quot;/1\&quot; must be specified. (required)
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

        $resourcePath = '/1{path}';
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
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param string $path           Path of the endpoint, anything after \&quot;/1\&quot; must be specified. (required)
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

        $resourcePath = '/1{path}';
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
     * List known incidents for selected clusters.
     *
     * @param string $clusters       Subset of clusters, separated by comma. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Monitoring\IncidentsResponse|array<string, mixed>
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
     * Report whether a cluster is operational.
     *
     * @param string $clusters       Subset of clusters, separated by comma. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Monitoring\StatusResponse|array<string, mixed>
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
     * List known incidents for all clusters.
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Monitoring\IncidentsResponse|array<string, mixed>
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
     * List the average times for indexing operations for selected clusters.
     *
     * @param string $clusters       Subset of clusters, separated by comma. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Monitoring\IndexingTimeResponse|array<string, mixed>
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
     * List the servers belonging to clusters.  The response depends on whether you authenticate your API request:  - With authentication, the response lists the servers assigned to your Algolia application's cluster.  - Without authentication, the response lists the servers for all Algolia clusters.
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Monitoring\InventoryResponse|array<string, mixed>
     */
    public function getInventory($requestOptions = [])
    {
        $resourcePath = '/1/inventory/servers';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * List the average latency for search requests for selected clusters.
     *
     * @param string $clusters       Subset of clusters, separated by comma. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Monitoring\LatencyResponse|array<string, mixed>
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
     * Report the aggregate value of a metric for a selected period of time.
     *
     * @param array $metric         Metric to report.  For more information about the individual metrics, see the response. To include all metrics, use &#x60;*&#x60; as the parameter. (required)
     * @param array $period         Period over which to aggregate the metrics:  - &#x60;minute&#x60;. Aggregate the last minute. 1 data point per 10 seconds. - &#x60;hour&#x60;. Aggregate the last hour. 1 data point per minute. - &#x60;day&#x60;. Aggregate the last day. 1 data point per 10 minutes. - &#x60;week&#x60;. Aggregate the last week. 1 data point per hour. - &#x60;month&#x60;. Aggregate the last month. 1 data point per day. (required)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Monitoring\InfrastructureResponse|array<string, mixed>
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
     * @param string $clusters       Subset of clusters, separated by comma. (required)
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
     * Report whether clusters are operational.  The response depends on whether you authenticate your API request.  - With authentication, the response includes the status of the cluster assigned to your Algolia application.  - Without authentication, the response lists the statuses of all public Algolia clusters.
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Monitoring\StatusResponse|array<string, mixed>
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
        $query = \GuzzleHttp\Psr7\Query::build($requestOptions['queryParameters']);

        return $this->api->sendRequest(
            $method,
            $resourcePath.($query ? "?{$query}" : ''),
            $httpBody,
            $requestOptions,
            $useReadTransporter
        );
    }
}
