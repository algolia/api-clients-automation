<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Api;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Configuration\AbtestingConfig;
use Algolia\AlgoliaSearch\Model\Abtesting\ABTest;
use Algolia\AlgoliaSearch\Model\Abtesting\ABTestResponse;
use Algolia\AlgoliaSearch\Model\Abtesting\AddABTestsRequest;
use Algolia\AlgoliaSearch\Model\Abtesting\EstimateABTestRequest;
use Algolia\AlgoliaSearch\Model\Abtesting\EstimateABTestResponse;
use Algolia\AlgoliaSearch\Model\Abtesting\ListABTestsResponse;
use Algolia\AlgoliaSearch\Model\Abtesting\ScheduleABTestResponse;
use Algolia\AlgoliaSearch\Model\Abtesting\ScheduleABTestsRequest;
use Algolia\AlgoliaSearch\ObjectSerializer;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapperInterface;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use GuzzleHttp\Psr7\Query;

/**
 * AbtestingClient Class Doc Comment.
 *
 * @category Class
 */
class AbtestingClient
{
    public const VERSION = '4.15.1';

    /**
     * @var ApiWrapperInterface
     */
    protected $api;

    /**
     * @var AbtestingConfig
     */
    protected $config;

    public function __construct(ApiWrapperInterface $apiWrapper, AbtestingConfig $config)
    {
        $this->config = $config;
        $this->api = $apiWrapper;
    }

    /**
     * Instantiate the client with basic credentials and region.
     *
     * @param string $appId  Application ID
     * @param string $apiKey Algolia API Key
     * @param string $region Region
     */
    public static function create($appId = null, $apiKey = null, $region = null)
    {
        $config = AbtestingConfig::create($appId, $apiKey, $region);

        return static::createWithConfig($config);
    }

    /**
     * Instantiate the client with configuration.
     *
     * @param AbtestingConfig $config Configuration
     */
    public static function createWithConfig(AbtestingConfig $config)
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
    public static function getClusterHosts(AbtestingConfig $config)
    {
        if ($hosts = $config->getHosts()) {
            // If a list of hosts was passed, we ignore the cache
            $clusterHosts = ClusterHosts::create($hosts);
        } else {
            $url = null !== $config->getRegion() && '' !== $config->getRegion() ?
                str_replace('{region}', $config->getRegion(), 'analytics.{region}.algolia.com') :
                'analytics.algolia.com';
            $clusterHosts = ClusterHosts::create($url);
        }

        return $clusterHosts;
    }

    /**
     * @return AbtestingConfig
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
     * Creates a new A/B test.
     *
     * Required API Key ACLs:
     *  - editSettings
     *
     * @param AddABTestsRequest|array $addABTestsRequest addABTestsRequest (required)
     *                                                   - $addABTestsRequest['name'] => (string) A/B test name. (required)
     *                                                   - $addABTestsRequest['variants'] => (array) A/B test variants. (required)
     *                                                   - $addABTestsRequest['endAt'] => (string) End date and time of the A/B test, in RFC 3339 format. (required)
     *
     * @see AddABTestsRequest
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return ABTestResponse|array<string, mixed>
     */
    public function addABTests($addABTestsRequest, $requestOptions = [])
    {
        // verify the required parameter 'addABTestsRequest' is set
        if (!isset($addABTestsRequest)) {
            throw new \InvalidArgumentException(
                'Parameter `addABTestsRequest` is required when calling `addABTests`.'
            );
        }

        $resourcePath = '/2/abtests';
        $queryParameters = [];
        $headers = [];
        $httpBody = $addABTestsRequest;

        return $this->sendRequest('POST', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
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
     * Deletes an A/B test by its ID.
     *
     * Required API Key ACLs:
     *  - editSettings
     *
     * @param int   $id             Unique A/B test identifier. (required)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return ABTestResponse|array<string, mixed>
     */
    public function deleteABTest($id, $requestOptions = [])
    {
        // verify the required parameter 'id' is set
        if (!isset($id)) {
            throw new \InvalidArgumentException(
                'Parameter `id` is required when calling `deleteABTest`.'
            );
        }

        $resourcePath = '/2/abtests/{id}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $id) {
            $resourcePath = str_replace(
                '{id}',
                ObjectSerializer::toPathValue($id),
                $resourcePath
            );
        }

        return $this->sendRequest('DELETE', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Given the traffic percentage and the expected effect size, this endpoint estimates the sample size and duration of an A/B test based on historical traffic.
     *
     * Required API Key ACLs:
     *  - analytics
     *
     * @param array|EstimateABTestRequest $estimateABTestRequest estimateABTestRequest (required)
     *                                                           - $estimateABTestRequest['configuration'] => (array)  (required)
     *                                                           - $estimateABTestRequest['variants'] => (array) A/B test variants. (required)
     *
     * @see EstimateABTestRequest
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|EstimateABTestResponse
     */
    public function estimateABTest($estimateABTestRequest, $requestOptions = [])
    {
        // verify the required parameter 'estimateABTestRequest' is set
        if (!isset($estimateABTestRequest)) {
            throw new \InvalidArgumentException(
                'Parameter `estimateABTestRequest` is required when calling `estimateABTest`.'
            );
        }

        $resourcePath = '/2/abtests/estimate';
        $queryParameters = [];
        $headers = [];
        $httpBody = $estimateABTestRequest;

        return $this->sendRequest('POST', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Retrieves the details for an A/B test by its ID.
     *
     * Required API Key ACLs:
     *  - analytics
     *
     * @param int   $id             Unique A/B test identifier. (required)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return ABTest|array<string, mixed>
     */
    public function getABTest($id, $requestOptions = [])
    {
        // verify the required parameter 'id' is set
        if (!isset($id)) {
            throw new \InvalidArgumentException(
                'Parameter `id` is required when calling `getABTest`.'
            );
        }

        $resourcePath = '/2/abtests/{id}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $id) {
            $resourcePath = str_replace(
                '{id}',
                ObjectSerializer::toPathValue($id),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Lists all A/B tests you configured for this application.
     *
     * Required API Key ACLs:
     *  - analytics
     *
     * @param int    $offset         Position of the first item to return. (optional, default to 0)
     * @param int    $limit          Number of items to return. (optional, default to 10)
     * @param string $indexPrefix    Index name prefix. Only A/B tests for indices starting with this string are included in the response. (optional)
     * @param string $indexSuffix    Index name suffix. Only A/B tests for indices ending with this string are included in the response. (optional)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|ListABTestsResponse
     */
    public function listABTests($offset = null, $limit = null, $indexPrefix = null, $indexSuffix = null, $requestOptions = [])
    {
        $resourcePath = '/2/abtests';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        if (null !== $offset) {
            $queryParameters['offset'] = $offset;
        }

        if (null !== $limit) {
            $queryParameters['limit'] = $limit;
        }

        if (null !== $indexPrefix) {
            $queryParameters['indexPrefix'] = $indexPrefix;
        }

        if (null !== $indexSuffix) {
            $queryParameters['indexSuffix'] = $indexSuffix;
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Schedule an A/B test to be started at a later time.
     *
     * Required API Key ACLs:
     *  - editSettings
     *
     * @param array|ScheduleABTestsRequest $scheduleABTestsRequest scheduleABTestsRequest (required)
     *                                                             - $scheduleABTestsRequest['name'] => (string) A/B test name. (required)
     *                                                             - $scheduleABTestsRequest['variants'] => (array) A/B test variants. (required)
     *                                                             - $scheduleABTestsRequest['scheduledAt'] => (string) Date and time when the A/B test is scheduled to start, in RFC 3339 format. (required)
     *                                                             - $scheduleABTestsRequest['endAt'] => (string) End date and time of the A/B test, in RFC 3339 format. (required)
     *
     * @see ScheduleABTestsRequest
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return array<string, mixed>|ScheduleABTestResponse
     */
    public function scheduleABTest($scheduleABTestsRequest, $requestOptions = [])
    {
        // verify the required parameter 'scheduleABTestsRequest' is set
        if (!isset($scheduleABTestsRequest)) {
            throw new \InvalidArgumentException(
                'Parameter `scheduleABTestsRequest` is required when calling `scheduleABTest`.'
            );
        }

        $resourcePath = '/2/abtests/schedule';
        $queryParameters = [];
        $headers = [];
        $httpBody = $scheduleABTestsRequest;

        return $this->sendRequest('POST', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Stops an A/B test by its ID.  You can't restart stopped A/B tests.
     *
     * Required API Key ACLs:
     *  - editSettings
     *
     * @param int   $id             Unique A/B test identifier. (required)
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return ABTestResponse|array<string, mixed>
     */
    public function stopABTest($id, $requestOptions = [])
    {
        // verify the required parameter 'id' is set
        if (!isset($id)) {
            throw new \InvalidArgumentException(
                'Parameter `id` is required when calling `stopABTest`.'
            );
        }

        $resourcePath = '/2/abtests/{id}/stop';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $id) {
            $resourcePath = str_replace(
                '{id}',
                ObjectSerializer::toPathValue($id),
                $resourcePath
            );
        }

        return $this->sendRequest('POST', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
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
