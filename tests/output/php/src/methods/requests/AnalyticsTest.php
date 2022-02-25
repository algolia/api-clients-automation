<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\AnalyticsApi;
use Algolia\AlgoliaSearch\Configuration\AnalyticsConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * AnalyticsTest
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class AnalyticsTest extends TestCase implements HttpClientInterface
{
    /**
     * @var RequestInterface[]
     */
    private $recordedRequests = [];

    protected function assertRequests(array $requests)
    {
        $this->assertGreaterThan(0, count($requests));
        $this->assertEquals(count($requests), count($this->recordedRequests));

        foreach ($requests as $i => $request) {
            $recordedRequest = $this->recordedRequests[$i];

            $this->assertEquals($request['method'], $recordedRequest->getMethod());
            $this->assertEquals($request['path'], $recordedRequest->getUri()->getPath());
            $this->assertEquals($request['body'], $recordedRequest->getBody()->getContents());
        }
    }

    public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
    {
        $this->recordedRequests[] = $request;

        return new Response(200, [], '{}');
    }

    protected function getClient()
    {
        $api = new ApiWrapper($this, AnalyticsConfig::create(), ClusterHosts::create('127.0.0.1'));
        $config = AnalyticsConfig::create('foo', 'bar');

        return new AnalyticsApi($api, $config);
    }

    /**
     * Test case for getAverageClickPosition
     * Get getAverageClickPosition with minimal parameters
     */
    public function testGetAverageClickPosition0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getAverageClickPosition($params);

        $this->assertRequests([
            [
                'path' => '/2/clicks/averageClickPosition',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getAverageClickPosition
     * Get getAverageClickPosition with all parameters
     */
    public function testGetAverageClickPosition1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true);

        $client->getAverageClickPosition($params);

        $this->assertRequests([
            [
                'path' => '/2/clicks/averageClickPosition',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getClickPositions
     * Get getClickPositions with minimal parameters
     */
    public function testGetClickPositions0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getClickPositions($params);

        $this->assertRequests([
            [
                'path' => '/2/clicks/positions',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getClickPositions
     * Get getClickPositions with all parameters
     */
    public function testGetClickPositions1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true);

        $client->getClickPositions($params);

        $this->assertRequests([
            [
                'path' => '/2/clicks/positions',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getClickThroughRate
     * Get getClickThroughRate with minimal parameters
     */
    public function testGetClickThroughRate0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getClickThroughRate($params);

        $this->assertRequests([
            [
                'path' => '/2/clicks/clickThroughRate',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getClickThroughRate
     * Get getClickThroughRate with all parameters
     */
    public function testGetClickThroughRate1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true);

        $client->getClickThroughRate($params);

        $this->assertRequests([
            [
                'path' => '/2/clicks/clickThroughRate',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getConversationRate
     * Get getConversationRate with minimal parameters
     */
    public function testGetConversationRate0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getConversationRate($params);

        $this->assertRequests([
            [
                'path' => '/2/conversions/conversionRate',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getConversationRate
     * Get getConversationRate with all parameters
     */
    public function testGetConversationRate1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true);

        $client->getConversationRate($params);

        $this->assertRequests([
            [
                'path' => '/2/conversions/conversionRate',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getNoClickRate
     * Get getNoClickRate with minimal parameters
     */
    public function testGetNoClickRate0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getNoClickRate($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/noClickRate',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getNoClickRate
     * Get getNoClickRate with all parameters
     */
    public function testGetNoClickRate1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true);

        $client->getNoClickRate($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/noClickRate',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getNoResultsRate
     * Get getNoResultsRate with minimal parameters
     */
    public function testGetNoResultsRate0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getNoResultsRate($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/noResultRate',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getNoResultsRate
     * Get getNoResultsRate with all parameters
     */
    public function testGetNoResultsRate1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true);

        $client->getNoResultsRate($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/noResultRate',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getSearchesCount
     * Get getSearchesCount with minimal parameters
     */
    public function testGetSearchesCount0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getSearchesCount($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/count',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getSearchesCount
     * Get getSearchesCount with all parameters
     */
    public function testGetSearchesCount1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true);

        $client->getSearchesCount($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/count',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getSearchesNoClicks
     * Get getSearchesNoClicks with minimal parameters
     */
    public function testGetSearchesNoClicks0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getSearchesNoClicks($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/noClicks',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getSearchesNoClicks
     * Get getSearchesNoClicks with all parameters
     */
    public function testGetSearchesNoClicks1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":21,"offset":42,"tags":"tag"}', true);

        $client->getSearchesNoClicks($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/noClicks',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getSearchesNoResults
     * Get getSearchesNoResults with minimal parameters
     */
    public function testGetSearchesNoResults0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getSearchesNoResults($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/noResults',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getSearchesNoResults
     * Get getSearchesNoResults with all parameters
     */
    public function testGetSearchesNoResults1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":21,"offset":42,"tags":"tag"}', true);

        $client->getSearchesNoResults($params);

        $this->assertRequests([
            [
                'path' => '/2/searches/noResults',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getStatus
     * Get getStatus with minimal parameters
     */
    public function testGetStatus0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getStatus($params);

        $this->assertRequests([
            [
                'path' => '/2/status',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopCountries
     * Get getTopCountries with minimal parameters
     */
    public function testGetTopCountries0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getTopCountries($params);

        $this->assertRequests([
            [
                'path' => '/2/countries',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopCountries
     * Get getTopCountries with all parameters
     */
    public function testGetTopCountries1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":21,"offset":42,"tags":"tag"}', true);

        $client->getTopCountries($params);

        $this->assertRequests([
            [
                'path' => '/2/countries',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopFilterAttributes
     * Get getTopFilterAttributes with minimal parameters
     */
    public function testGetTopFilterAttributes0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getTopFilterAttributes($params);

        $this->assertRequests([
            [
                'path' => '/2/filters',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopFilterAttributes
     * Get getTopFilterAttributes with all parameters
     */
    public function testGetTopFilterAttributes1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":21,"offset":42,"tags":"tag"}', true);

        $client->getTopFilterAttributes($params);

        $this->assertRequests([
            [
                'path' => '/2/filters',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopFilterForAttribute
     * Get getTopFilterForAttribute with minimal parameters
     */
    public function testGetTopFilterForAttribute0()
    {
        $client = $this->getClient();
        $params = json_decode('{"attribute":"myAttribute","index":"index"}', true);

        $client->getTopFilterForAttribute($params);

        $this->assertRequests([
            [
                'path' => '/2/filters/myAttribute',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopFilterForAttribute
     * Get getTopFilterForAttribute with minimal parameters and multiple attributes
     */
    public function testGetTopFilterForAttribute1()
    {
        $client = $this->getClient();
        $params = json_decode('{"attribute":"myAttribute1,myAttribute2","index":"index"}', true);

        $client->getTopFilterForAttribute($params);

        $this->assertRequests([
            [
                'path' => '/2/filters/myAttribute1%2CmyAttribute2',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopFilterForAttribute
     * Get getTopFilterForAttribute with all parameters
     */
    public function testGetTopFilterForAttribute2()
    {
        $client = $this->getClient();
        $params = json_decode('{"attribute":"myAttribute","index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":21,"offset":42,"tags":"tag"}', true);

        $client->getTopFilterForAttribute($params);

        $this->assertRequests([
            [
                'path' => '/2/filters/myAttribute',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopFilterForAttribute
     * Get getTopFilterForAttribute with all parameters and multiple attributes
     */
    public function testGetTopFilterForAttribute3()
    {
        $client = $this->getClient();
        $params = json_decode('{"attribute":"myAttribute1,myAttribute2","index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":21,"offset":42,"tags":"tag"}', true);

        $client->getTopFilterForAttribute($params);

        $this->assertRequests([
            [
                'path' => '/2/filters/myAttribute1%2CmyAttribute2',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopFiltersNoResults
     * Get getTopFiltersNoResults with minimal parameters
     */
    public function testGetTopFiltersNoResults0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getTopFiltersNoResults($params);

        $this->assertRequests([
            [
                'path' => '/2/filters/noResults',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopFiltersNoResults
     * Get getTopFiltersNoResults with all parameters
     */
    public function testGetTopFiltersNoResults1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":21,"offset":42,"tags":"tag"}', true);

        $client->getTopFiltersNoResults($params);

        $this->assertRequests([
            [
                'path' => '/2/filters/noResults',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopHits
     * Get getTopHits with minimal parameters
     */
    public function testGetTopHits0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getTopHits($params);

        $this->assertRequests([
            [
                'path' => '/2/hits',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopHits
     * Get getTopHits with all parameters
     */
    public function testGetTopHits1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","search":"mySearch","clickAnalytics":true,"startDate":"1999-09-19","endDate":"2001-01-01","limit":21,"offset":42,"tags":"tag"}', true);

        $client->getTopHits($params);

        $this->assertRequests([
            [
                'path' => '/2/hits',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopSearches
     * Get getTopSearches with minimal parameters
     */
    public function testGetTopSearches0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getTopSearches($params);

        $this->assertRequests([
            [
                'path' => '/2/searches',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getTopSearches
     * Get getTopSearches with all parameters
     */
    public function testGetTopSearches1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","clickAnalytics":true,"startDate":"1999-09-19","endDate":"2001-01-01","orderBy":"searchCount","direction":"asc","limit":21,"offset":42,"tags":"tag"}', true);

        $client->getTopSearches($params);

        $this->assertRequests([
            [
                'path' => '/2/searches',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getUsersCount
     * Get getUsersCount with minimal parameters
     */
    public function testGetUsersCount0()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index"}', true);

        $client->getUsersCount($params);

        $this->assertRequests([
            [
                'path' => '/2/users/count',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getUsersCount
     * Get getUsersCount with all parameters
     */
    public function testGetUsersCount1()
    {
        $client = $this->getClient();
        $params = json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true);

        $client->getUsersCount($params);

        $this->assertRequests([
            [
                'path' => '/2/users/count',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }
}
