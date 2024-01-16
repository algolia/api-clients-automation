<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Api;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Configuration\PersonalizationConfig;
use Algolia\AlgoliaSearch\ObjectSerializer;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapperInterface;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;

/**
 * PersonalizationClient Class Doc Comment.
 *
 * @category Class
 */
class PersonalizationClient
{
    public const VERSION = '4.0.0-alpha.92';

    /**
     * @var ApiWrapperInterface
     */
    protected $api;

    /**
     * @var PersonalizationConfig
     */
    protected $config;

    public function __construct(ApiWrapperInterface $apiWrapper, PersonalizationConfig $config)
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
        $allowedRegions = ['eu', 'us'];

        if (
            null === $region
            || (null !== $region && !in_array($region, $allowedRegions, true))
        ) {
            throw new AlgoliaException(
                '`region` is required and must be one of the following: '.
                    implode(', ', $allowedRegions)
            );
        }

        $config = PersonalizationConfig::create($appId, $apiKey, $region);

        return static::createWithConfig($config);
    }

    /**
     * Instantiate the client with configuration.
     *
     * @param PersonalizationConfig $config Configuration
     */
    public static function createWithConfig(PersonalizationConfig $config)
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
    public static function getClusterHosts(PersonalizationConfig $config)
    {
        if ($hosts = $config->getHosts()) {
            // If a list of hosts was passed, we ignore the cache
            $clusterHosts = ClusterHosts::create($hosts);
        } else {
            $url = null !== $config->getRegion() && '' !== $config->getRegion() ?
                str_replace('{region}', $config->getRegion(), 'personalization.{region}.algolia.com') :
                '';
            $clusterHosts = ClusterHosts::create($url);
        }

        return $clusterHosts;
    }

    /**
     * @return PersonalizationConfig
     */
    public function getClientConfig()
    {
        return $this->config;
    }

    /**
     * Send requests to the Algolia REST API.
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
     * Send requests to the Algolia REST API.
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
     * Send requests to the Algolia REST API.
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
     * Send requests to the Algolia REST API.
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
     * Delete a user profile.
     *
     * @param string $userToken      userToken representing the user for which to fetch the Personalization profile. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Personalization\DeleteUserProfileResponse|array<string, mixed>
     */
    public function deleteUserProfile($userToken, $requestOptions = [])
    {
        // verify the required parameter 'userToken' is set
        if (!isset($userToken)) {
            throw new \InvalidArgumentException(
                'Parameter `userToken` is required when calling `deleteUserProfile`.'
            );
        }

        $resourcePath = '/1/profiles/{userToken}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $userToken) {
            $resourcePath = str_replace(
                '{userToken}',
                ObjectSerializer::toPathValue($userToken),
                $resourcePath
            );
        }

        return $this->sendRequest('DELETE', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Get the current strategy.
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Personalization\PersonalizationStrategyParams|array<string, mixed>
     */
    public function getPersonalizationStrategy($requestOptions = [])
    {
        $resourcePath = '/1/strategies/personalization';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Get a user profile.
     *
     * @param string $userToken      userToken representing the user for which to fetch the Personalization profile. (required)
     * @param array  $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Personalization\GetUserTokenResponse|array<string, mixed>
     */
    public function getUserTokenProfile($userToken, $requestOptions = [])
    {
        // verify the required parameter 'userToken' is set
        if (!isset($userToken)) {
            throw new \InvalidArgumentException(
                'Parameter `userToken` is required when calling `getUserTokenProfile`.'
            );
        }

        $resourcePath = '/1/profiles/personalization/{userToken}';
        $queryParameters = [];
        $headers = [];
        $httpBody = null;

        // path params
        if (null !== $userToken) {
            $resourcePath = str_replace(
                '{userToken}',
                ObjectSerializer::toPathValue($userToken),
                $resourcePath
            );
        }

        return $this->sendRequest('GET', $resourcePath, $headers, $queryParameters, $httpBody, $requestOptions);
    }

    /**
     * Set a new strategy.
     *
     * @param array $personalizationStrategyParams personalizationStrategyParams (required)
     *                                             - $personalizationStrategyParams['eventScoring'] => (array) Scores associated with the events. (required)
     *                                             - $personalizationStrategyParams['facetScoring'] => (array) Scores associated with the facets. (required)
     *                                             - $personalizationStrategyParams['personalizationImpact'] => (int) The impact that personalization has on search results: a number between 0 (personalization disabled) and 100 (personalization fully enabled). (required)
     *
     * @see \Algolia\AlgoliaSearch\Model\Personalization\PersonalizationStrategyParams
     *
     * @param array $requestOptions the requestOptions to send along with the query, they will be merged with the transporter requestOptions
     *
     * @return \Algolia\AlgoliaSearch\Model\Personalization\SetPersonalizationStrategyResponse|array<string, mixed>
     */
    public function setPersonalizationStrategy($personalizationStrategyParams, $requestOptions = [])
    {
        // verify the required parameter 'personalizationStrategyParams' is set
        if (!isset($personalizationStrategyParams)) {
            throw new \InvalidArgumentException(
                'Parameter `personalizationStrategyParams` is required when calling `setPersonalizationStrategy`.'
            );
        }

        $resourcePath = '/1/strategies/personalization';
        $queryParameters = [];
        $headers = [];
        $httpBody = $personalizationStrategyParams;

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
