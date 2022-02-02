<?php

namespace Algolia\AlgoliaSearch\Api;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Configuration\AnalyticsConfig;
use Algolia\AlgoliaSearch\HeaderSelector;
use Algolia\AlgoliaSearch\ObjectSerializer;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapperInterface;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;

/**
 * AnalyticsApi Class Doc Comment
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class AnalyticsApi
{
    /**
     * @var ApiWrapperInterface
     */
    protected $api;

    /**
     * @var AnalyticsConfig
     */
    protected $config;

    /**
     * @var HeaderSelector
     */
    protected $headerSelector;

    /**
     * @param AnalyticsConfig $config
     * @param ApiWrapperInterface $apiWrapper
     */
    public function __construct(ApiWrapperInterface $apiWrapper, AnalyticsConfig $config)
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
        $allowedRegions = explode('-', 'us-de');
        $config = AnalyticsConfig::create($appId, $apiKey, $region, $allowedRegions);

        return static::createWithConfig($config);
    }

    /**
     * Instantiate the client with congiguration
     *
     * @param AnalyticsConfig $config Configuration
     */
    public static function createWithConfig(AnalyticsConfig $config)
    {
        $config = clone $config;

        if ($hosts = $config->getHosts()) {
            // If a list of hosts was passed, we ignore the cache
            $clusterHosts = ClusterHosts::create($hosts);
        } else {
            $clusterHosts = ClusterHosts::createForAnalytics($config->getAppId());
        }

        $apiWrapper = new ApiWrapper(
            Algolia::getHttpClient(),
            $config,
            $clusterHosts
        );

        return new static($apiWrapper, $config);
    }

    /**
     * @return AnalyticsConfig
     */
    public function getClientConfig()
    {
        return $this->config;
    }

    /**
     * Operation getAverageClickPosition
     *
     * Returns the average click position.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetAverageClickPositionResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getAverageClickPosition($index, $startDate = null, $endDate = null, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getAverageClickPosition'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getAverageClickPosition, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getAverageClickPosition, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/clicks/averageClickPosition';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getClickPositions
     *
     * Returns the distribution of clicks per range of positions.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetClickPositionsResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getClickPositions($index, $startDate = null, $endDate = null, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getClickPositions'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getClickPositions, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getClickPositions, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/clicks/positions';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getClickThroughRate
     *
     * Returns a click-through rate (CTR).
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetClickThroughRateResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getClickThroughRate($index, $startDate = null, $endDate = null, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getClickThroughRate'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getClickThroughRate, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getClickThroughRate, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/clicks/clickThroughRate';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getConversationRate
     *
     * Returns a conversion rate (CR).
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetConversationRateResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getConversationRate($index, $startDate = null, $endDate = null, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getConversationRate'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getConversationRate, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getConversationRate, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/conversions/conversionRate';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getNoClickRate
     *
     * Returns the rate at which searches didn&#39;t lead to any clicks.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetNoClickRateResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getNoClickRate($index, $startDate = null, $endDate = null, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getNoClickRate'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getNoClickRate, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getNoClickRate, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/searches/noClickRate';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getNoResultsRate
     *
     * Returns the rate at which searches didn&#39;t return any results.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetNoResultsRateResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getNoResultsRate($index, $startDate = null, $endDate = null, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getNoResultsRate'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getNoResultsRate, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getNoResultsRate, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/searches/noResultRate';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getSearchesCount
     *
     * Returns the number of searches across the given time range.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetSearchesCountResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getSearchesCount($index, $startDate = null, $endDate = null, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getSearchesCount'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getSearchesCount, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getSearchesCount, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/searches/count';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getSearchesNoClicks
     *
     * Returns top searches that didn&#39;t lead to any clicks.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  int $limit Number of records to return. Limit is the size of the page. (optional, default to 10)
     * @param  int $offset Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetSearchesNoClicksResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getSearchesNoClicks($index, $startDate = null, $endDate = null, $limit = 10, $offset = 0, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getSearchesNoClicks'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getSearchesNoClicks, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getSearchesNoClicks, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/searches/noClicks';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($limit !== null) {
            if ('form' === 'form' && is_array($limit)) {
                foreach ($limit as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['limit'] = $limit;
            }
        }
        // query params
        if ($offset !== null) {
            if ('form' === 'form' && is_array($offset)) {
                foreach ($offset as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['offset'] = $offset;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getSearchesNoResults
     *
     * Returns top searches that didn&#39;t return any results.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  int $limit Number of records to return. Limit is the size of the page. (optional, default to 10)
     * @param  int $offset Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetSearchesNoResultsResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getSearchesNoResults($index, $startDate = null, $endDate = null, $limit = 10, $offset = 0, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getSearchesNoResults'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getSearchesNoResults, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getSearchesNoResults, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/searches/noResults';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($limit !== null) {
            if ('form' === 'form' && is_array($limit)) {
                foreach ($limit as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['limit'] = $limit;
            }
        }
        // query params
        if ($offset !== null) {
            if ('form' === 'form' && is_array($offset)) {
                foreach ($offset as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['offset'] = $offset;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getStatus
     *
     * Get latest update time of the analytics API.
     *
     * @param  string $index The index name to target. (required)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetStatusResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getStatus($index)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getStatus'
            );
        }

        $resourcePath = '/2/status';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
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
     * Operation getTopCountries
     *
     * Returns top countries.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  int $limit Number of records to return. Limit is the size of the page. (optional, default to 10)
     * @param  int $offset Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetTopCountriesResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getTopCountries($index, $startDate = null, $endDate = null, $limit = 10, $offset = 0, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getTopCountries'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getTopCountries, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getTopCountries, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/countries';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($limit !== null) {
            if ('form' === 'form' && is_array($limit)) {
                foreach ($limit as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['limit'] = $limit;
            }
        }
        // query params
        if ($offset !== null) {
            if ('form' === 'form' && is_array($offset)) {
                foreach ($offset as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['offset'] = $offset;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getTopFilterAttributes
     *
     * Returns top filter attributes.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $search The query term to search for. Must match the exact user input. (optional)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  int $limit Number of records to return. Limit is the size of the page. (optional, default to 10)
     * @param  int $offset Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetTopFilterAttributesResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getTopFilterAttributes($index, $search = null, $startDate = null, $endDate = null, $limit = 10, $offset = 0, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getTopFilterAttributes'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getTopFilterAttributes, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getTopFilterAttributes, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/filters';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($search !== null) {
            if ('form' === 'form' && is_array($search)) {
                foreach ($search as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['search'] = $search;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($limit !== null) {
            if ('form' === 'form' && is_array($limit)) {
                foreach ($limit as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['limit'] = $limit;
            }
        }
        // query params
        if ($offset !== null) {
            if ('form' === 'form' && is_array($offset)) {
                foreach ($offset as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['offset'] = $offset;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getTopFilterForAttribute
     *
     * Returns top filters for the given attribute.
     *
     * @param  string $attribute The exact name of the attribute. (required)
     * @param  string $index The index name to target. (required)
     * @param  string $search The query term to search for. Must match the exact user input. (optional)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  int $limit Number of records to return. Limit is the size of the page. (optional, default to 10)
     * @param  int $offset Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetTopFilterForAttributeResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getTopFilterForAttribute($attribute, $index, $search = null, $startDate = null, $endDate = null, $limit = 10, $offset = 0, $tags = null)
    {
        // verify the required parameter 'attribute' is set
        if ($attribute === null || (is_array($attribute) && count($attribute) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $attribute when calling getTopFilterForAttribute'
            );
        }
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getTopFilterForAttribute'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getTopFilterForAttribute, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getTopFilterForAttribute, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/filters/{attribute}';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($search !== null) {
            if ('form' === 'form' && is_array($search)) {
                foreach ($search as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['search'] = $search;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($limit !== null) {
            if ('form' === 'form' && is_array($limit)) {
                foreach ($limit as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['limit'] = $limit;
            }
        }
        // query params
        if ($offset !== null) {
            if ('form' === 'form' && is_array($offset)) {
                foreach ($offset as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['offset'] = $offset;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
        }
        // path params
        if ($attribute !== null) {
            $resourcePath = str_replace(
                '{' . 'attribute' . '}',
                ObjectSerializer::toPathValue($attribute),
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
     * Operation getTopFiltersNoResults
     *
     * Returns top filters with no results.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $search The query term to search for. Must match the exact user input. (optional)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  int $limit Number of records to return. Limit is the size of the page. (optional, default to 10)
     * @param  int $offset Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetTopFiltersNoResultsResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getTopFiltersNoResults($index, $search = null, $startDate = null, $endDate = null, $limit = 10, $offset = 0, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getTopFiltersNoResults'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getTopFiltersNoResults, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getTopFiltersNoResults, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/filters/noResults';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($search !== null) {
            if ('form' === 'form' && is_array($search)) {
                foreach ($search as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['search'] = $search;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($limit !== null) {
            if ('form' === 'form' && is_array($limit)) {
                foreach ($limit as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['limit'] = $limit;
            }
        }
        // query params
        if ($offset !== null) {
            if ('form' === 'form' && is_array($offset)) {
                foreach ($offset as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['offset'] = $offset;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getTopHits
     *
     * Returns top hits.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $search The query term to search for. Must match the exact user input. (optional)
     * @param  bool $clickAnalytics Whether to include the click-through and conversion rates for a search. (optional, default to false)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  int $limit Number of records to return. Limit is the size of the page. (optional, default to 10)
     * @param  int $offset Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return OneOfGetTopHitsResponseGetTopHitsResponseWithAnalytics|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getTopHits($index, $search = null, $clickAnalytics = false, $startDate = null, $endDate = null, $limit = 10, $offset = 0, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getTopHits'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getTopHits, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getTopHits, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/hits';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($search !== null) {
            if ('form' === 'form' && is_array($search)) {
                foreach ($search as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['search'] = $search;
            }
        }
        // query params
        if ($clickAnalytics !== null) {
            if ('form' === 'form' && is_array($clickAnalytics)) {
                foreach ($clickAnalytics as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['clickAnalytics'] = $clickAnalytics;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($limit !== null) {
            if ('form' === 'form' && is_array($limit)) {
                foreach ($limit as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['limit'] = $limit;
            }
        }
        // query params
        if ($offset !== null) {
            if ('form' === 'form' && is_array($offset)) {
                foreach ($offset as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['offset'] = $offset;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getTopSearches
     *
     * Returns top searches.
     *
     * @param  string $index The index name to target. (required)
     * @param  bool $clickAnalytics Whether to include the click-through and conversion rates for a search. (optional, default to false)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $orderBy Reorder the results. (optional, default to 'searchCount')
     * @param  string $direction The sorting of the result. (optional, default to 'asc')
     * @param  int $limit Number of records to return. Limit is the size of the page. (optional, default to 10)
     * @param  int $offset Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return OneOfGetTopSearchesResponseGetTopSearchesResponseWithAnalytics|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getTopSearches($index, $clickAnalytics = false, $startDate = null, $endDate = null, $orderBy = 'searchCount', $direction = 'asc', $limit = 10, $offset = 0, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getTopSearches'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getTopSearches, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getTopSearches, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/searches';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($clickAnalytics !== null) {
            if ('form' === 'form' && is_array($clickAnalytics)) {
                foreach ($clickAnalytics as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['clickAnalytics'] = $clickAnalytics;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($orderBy !== null) {
            if ('form' === 'form' && is_array($orderBy)) {
                foreach ($orderBy as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['orderBy'] = $orderBy;
            }
        }
        // query params
        if ($direction !== null) {
            if ('form' === 'form' && is_array($direction)) {
                foreach ($direction as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['direction'] = $direction;
            }
        }
        // query params
        if ($limit !== null) {
            if ('form' === 'form' && is_array($limit)) {
                foreach ($limit as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['limit'] = $limit;
            }
        }
        // query params
        if ($offset !== null) {
            if ('form' === 'form' && is_array($offset)) {
                foreach ($offset as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['offset'] = $offset;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
     * Operation getUsersCount
     *
     * Returns the distinct count of users across the given time range.
     *
     * @param  string $index The index name to target. (required)
     * @param  string $startDate The lower bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $endDate The upper bound timestamp (a date, a string like \&quot;2006-01-02\&quot;) of the period to analyze. (optional)
     * @param  string $tags Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded. (optional)
     *
     * @throws \Algolia\AlgoliaSearch\ApiException on non-2xx response
     * @throws \InvalidArgumentException
     *
     * @return \Algolia\AlgoliaSearch\Model\Analytics\GetUsersCountResponse|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase|\Algolia\AlgoliaSearch\Model\Analytics\ErrorBase
     */
    public function getUsersCount($index, $startDate = null, $endDate = null, $tags = null)
    {
        // verify the required parameter 'index' is set
        if ($index === null || (is_array($index) && count($index) === 0)) {
            throw new \InvalidArgumentException(
                'Missing the required parameter $index when calling getUsersCount'
            );
        }
        if ($startDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $startDate)) {
            throw new \InvalidArgumentException('invalid value for "startDate" when calling AnalyticsApi.getUsersCount, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        if ($endDate !== null && !preg_match('/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/', $endDate)) {
            throw new \InvalidArgumentException('invalid value for "endDate" when calling AnalyticsApi.getUsersCount, must conform to the pattern /^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/.');
        }

        $resourcePath = '/2/users/count';
        $queryParams = [];
        $headerParams = [];
        $httpBody = [];
        // query params
        if ($index !== null) {
            if ('form' === 'form' && is_array($index)) {
                foreach ($index as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['index'] = $index;
            }
        }
        // query params
        if ($startDate !== null) {
            if ('form' === 'form' && is_array($startDate)) {
                foreach ($startDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['startDate'] = $startDate;
            }
        }
        // query params
        if ($endDate !== null) {
            if ('form' === 'form' && is_array($endDate)) {
                foreach ($endDate as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['endDate'] = $endDate;
            }
        }
        // query params
        if ($tags !== null) {
            if ('form' === 'form' && is_array($tags)) {
                foreach ($tags as $key => $value) {
                    $queryParams[$key] = $value;
                }
            } else {
                $queryParams['tags'] = $tags;
            }
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
