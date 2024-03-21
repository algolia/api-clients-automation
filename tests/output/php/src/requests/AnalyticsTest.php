<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\AnalyticsClient;
use Algolia\AlgoliaSearch\Configuration\AnalyticsConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use Dotenv\Dotenv;
use GuzzleHttp\Psr7\Query;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

// we only read .env file if we run locally
if (getenv('ALGOLIA_APPLICATION_ID')) {
    $_ENV = getenv();
} else {
    $dotenv = Dotenv::createImmutable('tests');
    $dotenv->load();
}

/**
 * AnalyticsTest.
 *
 * @category Class
 *
 * @internal
 * @coversNothing
 */
class AnalyticsTest extends TestCase implements HttpClientInterface
{
    /**
     * @var RequestInterface[]
     */
    private $recordedRequests = [];

    public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
    {
        $this->recordedRequests[] = $request;

        return new Response(200, [], '{}');
    }

    /**
     * Test case for CustomDelete
     * allow del method for a custom path with minimal parameters.
     */
    public function testCustomDelete0()
    {
        $client = $this->getClient();
        $client->customDelete(
            'test/minimal',
        );

        $this->assertRequests([
            [
                'path' => '/test/minimal',
                'method' => 'DELETE',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for CustomDelete
     * allow del method for a custom path with all parameters.
     */
    public function testCustomDelete1()
    {
        $client = $this->getClient();
        $client->customDelete(
            'test/all',
            ['query' => 'parameters',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/test/all',
                'method' => 'DELETE',
                'body' => null,
                'queryParameters' => json_decode('{"query":"parameters"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomGet
     * allow get method for a custom path with minimal parameters.
     */
    public function testCustomGet0()
    {
        $client = $this->getClient();
        $client->customGet(
            'test/minimal',
        );

        $this->assertRequests([
            [
                'path' => '/test/minimal',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for CustomGet
     * allow get method for a custom path with all parameters.
     */
    public function testCustomGet1()
    {
        $client = $this->getClient();
        $client->customGet(
            'test/all',
            ['query' => 'parameters with space',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/test/all',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"query":"parameters%20with%20space"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomGet
     * requestOptions should be escaped too.
     */
    public function testCustomGet2()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'query' => 'parameters with space',
                'and an array' => ['array',  'with spaces',
                ],
            ],
            'headers' => [
                'x-header-1' => 'spaces are left alone',
            ],
        ];
        $client->customGet(
            'test/all',
            ['query' => 'to be overriden',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/all',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"query":"parameters%20with%20space","and%20an%20array":"array%2Cwith%20spaces"}', true),
                'headers' => json_decode('{"x-header-1":"spaces are left alone"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * allow post method for a custom path with minimal parameters.
     */
    public function testCustomPost0()
    {
        $client = $this->getClient();
        $client->customPost(
            'test/minimal',
        );

        $this->assertRequests([
            [
                'path' => '/test/minimal',
                'method' => 'POST',
                'body' => json_decode('{}'),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * allow post method for a custom path with all parameters.
     */
    public function testCustomPost1()
    {
        $client = $this->getClient();
        $client->customPost(
            'test/all',
            ['query' => 'parameters',
            ],
            ['body' => 'parameters',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/test/all',
                'method' => 'POST',
                'body' => json_decode('{"body":"parameters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions can override default query parameters.
     */
    public function testCustomPost2()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'query' => 'myQueryParameter',
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"myQueryParameter"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions merges query parameters with default ones.
     */
    public function testCustomPost3()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'query2' => 'myQueryParameter',
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","query2":"myQueryParameter"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions can override default headers.
     */
    public function testCustomPost4()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
            ],
            'headers' => [
                'x-algolia-api-key' => 'myApiKey',
            ],
        ];
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
                'headers' => json_decode('{"x-algolia-api-key":"myApiKey"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions merges headers with default ones.
     */
    public function testCustomPost5()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
            ],
            'headers' => [
                'x-algolia-api-key' => 'myApiKey',
            ],
        ];
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
                'headers' => json_decode('{"x-algolia-api-key":"myApiKey"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts booleans.
     */
    public function testCustomPost6()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'isItWorking' => true,
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","isItWorking":"true"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts integers.
     */
    public function testCustomPost7()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => 2,
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","myParam":"2"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts list of string.
     */
    public function testCustomPost8()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => ['b and c',  'd',
                ],
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","myParam":"b%20and%20c%2Cd"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts list of booleans.
     */
    public function testCustomPost9()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => [true,  true,  false,
                ],
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","myParam":"true%2Ctrue%2Cfalse"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts list of integers.
     */
    public function testCustomPost10()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => [1,  2,
                ],
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","myParam":"1%2C2"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPut
     * allow put method for a custom path with minimal parameters.
     */
    public function testCustomPut0()
    {
        $client = $this->getClient();
        $client->customPut(
            'test/minimal',
        );

        $this->assertRequests([
            [
                'path' => '/test/minimal',
                'method' => 'PUT',
                'body' => json_decode('{}'),
            ],
        ]);
    }

    /**
     * Test case for CustomPut
     * allow put method for a custom path with all parameters.
     */
    public function testCustomPut1()
    {
        $client = $this->getClient();
        $client->customPut(
            'test/all',
            ['query' => 'parameters',
            ],
            ['body' => 'parameters',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/test/all',
                'method' => 'PUT',
                'body' => json_decode('{"body":"parameters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetAddToCartRate
     * get getAddToCartRate with minimal parameters.
     */
    public function testGetAddToCartRate0()
    {
        $client = $this->getClient();
        $client->getAddToCartRate(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/conversions/addToCartRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetAddToCartRate
     * get getAddToCartRate with all parameters.
     */
    public function testGetAddToCartRate1()
    {
        $client = $this->getClient();
        $client->getAddToCartRate(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/conversions/addToCartRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetAverageClickPosition
     * get getAverageClickPosition with minimal parameters.
     */
    public function testGetAverageClickPosition0()
    {
        $client = $this->getClient();
        $client->getAverageClickPosition(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/clicks/averageClickPosition',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetAverageClickPosition
     * get getAverageClickPosition with all parameters.
     */
    public function testGetAverageClickPosition1()
    {
        $client = $this->getClient();
        $client->getAverageClickPosition(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/clicks/averageClickPosition',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetClickPositions
     * get getClickPositions with minimal parameters.
     */
    public function testGetClickPositions0()
    {
        $client = $this->getClient();
        $client->getClickPositions(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/clicks/positions',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetClickPositions
     * get getClickPositions with all parameters.
     */
    public function testGetClickPositions1()
    {
        $client = $this->getClient();
        $client->getClickPositions(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/clicks/positions',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetClickThroughRate
     * get getClickThroughRate with minimal parameters.
     */
    public function testGetClickThroughRate0()
    {
        $client = $this->getClient();
        $client->getClickThroughRate(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/clicks/clickThroughRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetClickThroughRate
     * get getClickThroughRate with all parameters.
     */
    public function testGetClickThroughRate1()
    {
        $client = $this->getClient();
        $client->getClickThroughRate(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/clicks/clickThroughRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetConversionRate
     * get getConversationRate with minimal parameters.
     */
    public function testGetConversionRate0()
    {
        $client = $this->getClient();
        $client->getConversionRate(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/conversions/conversionRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetConversionRate
     * get getConversationRate with all parameters.
     */
    public function testGetConversionRate1()
    {
        $client = $this->getClient();
        $client->getConversionRate(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/conversions/conversionRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetNoClickRate
     * get getNoClickRate with minimal parameters.
     */
    public function testGetNoClickRate0()
    {
        $client = $this->getClient();
        $client->getNoClickRate(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/noClickRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetNoClickRate
     * get getNoClickRate with all parameters.
     */
    public function testGetNoClickRate1()
    {
        $client = $this->getClient();
        $client->getNoClickRate(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/noClickRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetNoResultsRate
     * get getNoResultsRate with minimal parameters.
     */
    public function testGetNoResultsRate0()
    {
        $client = $this->getClient();
        $client->getNoResultsRate(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/noResultRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetNoResultsRate
     * get getNoResultsRate with all parameters.
     */
    public function testGetNoResultsRate1()
    {
        $client = $this->getClient();
        $client->getNoResultsRate(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/noResultRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetPurchaseRate
     * get getPurchaseRate with minimal parameters.
     */
    public function testGetPurchaseRate0()
    {
        $client = $this->getClient();
        $client->getPurchaseRate(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/conversions/purchaseRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetPurchaseRate
     * get getPurchaseRate with all parameters.
     */
    public function testGetPurchaseRate1()
    {
        $client = $this->getClient();
        $client->getPurchaseRate(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/conversions/purchaseRate',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetRevenue
     * get getRevenue with minimal parameters.
     */
    public function testGetRevenue0()
    {
        $client = $this->getClient();
        $client->getRevenue(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/conversions/revenue',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetRevenue
     * get getRevenue with all parameters.
     */
    public function testGetRevenue1()
    {
        $client = $this->getClient();
        $client->getRevenue(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/conversions/revenue',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetSearchesCount
     * get getSearchesCount with minimal parameters.
     */
    public function testGetSearchesCount0()
    {
        $client = $this->getClient();
        $client->getSearchesCount(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/count',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetSearchesCount
     * get getSearchesCount with all parameters.
     */
    public function testGetSearchesCount1()
    {
        $client = $this->getClient();
        $client->getSearchesCount(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/count',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetSearchesNoClicks
     * get getSearchesNoClicks with minimal parameters.
     */
    public function testGetSearchesNoClicks0()
    {
        $client = $this->getClient();
        $client->getSearchesNoClicks(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/noClicks',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetSearchesNoClicks
     * get getSearchesNoClicks with all parameters.
     */
    public function testGetSearchesNoClicks1()
    {
        $client = $this->getClient();
        $client->getSearchesNoClicks(
            'index',
            '1999-09-19',
            '2001-01-01',
            21,
            42,
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/noClicks',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetSearchesNoResults
     * get getSearchesNoResults with minimal parameters.
     */
    public function testGetSearchesNoResults0()
    {
        $client = $this->getClient();
        $client->getSearchesNoResults(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/noResults',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetSearchesNoResults
     * get getSearchesNoResults with all parameters.
     */
    public function testGetSearchesNoResults1()
    {
        $client = $this->getClient();
        $client->getSearchesNoResults(
            'index',
            '1999-09-19',
            '2001-01-01',
            21,
            42,
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches/noResults',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetStatus
     * get getStatus with minimal parameters.
     */
    public function testGetStatus0()
    {
        $client = $this->getClient();
        $client->getStatus(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/status',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopCountries
     * get getTopCountries with minimal parameters.
     */
    public function testGetTopCountries0()
    {
        $client = $this->getClient();
        $client->getTopCountries(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/countries',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopCountries
     * get getTopCountries with all parameters.
     */
    public function testGetTopCountries1()
    {
        $client = $this->getClient();
        $client->getTopCountries(
            'index',
            '1999-09-19',
            '2001-01-01',
            21,
            42,
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/countries',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopFilterAttributes
     * get getTopFilterAttributes with minimal parameters.
     */
    public function testGetTopFilterAttributes0()
    {
        $client = $this->getClient();
        $client->getTopFilterAttributes(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/filters',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopFilterAttributes
     * get getTopFilterAttributes with all parameters.
     */
    public function testGetTopFilterAttributes1()
    {
        $client = $this->getClient();
        $client->getTopFilterAttributes(
            'index',
            'mySearch',
            '1999-09-19',
            '2001-01-01',
            21,
            42,
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/filters',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopFilterForAttribute
     * get getTopFilterForAttribute with minimal parameters.
     */
    public function testGetTopFilterForAttribute0()
    {
        $client = $this->getClient();
        $client->getTopFilterForAttribute(
            'myAttribute',
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/filters/myAttribute',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopFilterForAttribute
     * get getTopFilterForAttribute with minimal parameters and multiple attributes.
     */
    public function testGetTopFilterForAttribute1()
    {
        $client = $this->getClient();
        $client->getTopFilterForAttribute(
            'myAttribute1,myAttribute2',
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/filters/myAttribute1%2CmyAttribute2',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopFilterForAttribute
     * get getTopFilterForAttribute with all parameters.
     */
    public function testGetTopFilterForAttribute2()
    {
        $client = $this->getClient();
        $client->getTopFilterForAttribute(
            'myAttribute',
            'index',
            'mySearch',
            '1999-09-19',
            '2001-01-01',
            21,
            42,
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/filters/myAttribute',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopFilterForAttribute
     * get getTopFilterForAttribute with all parameters and multiple attributes.
     */
    public function testGetTopFilterForAttribute3()
    {
        $client = $this->getClient();
        $client->getTopFilterForAttribute(
            'myAttribute1,myAttribute2',
            'index',
            'mySearch',
            '1999-09-19',
            '2001-01-01',
            21,
            42,
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/filters/myAttribute1%2CmyAttribute2',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopFiltersNoResults
     * get getTopFiltersNoResults with minimal parameters.
     */
    public function testGetTopFiltersNoResults0()
    {
        $client = $this->getClient();
        $client->getTopFiltersNoResults(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/filters/noResults',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopFiltersNoResults
     * get getTopFiltersNoResults with all parameters.
     */
    public function testGetTopFiltersNoResults1()
    {
        $client = $this->getClient();
        $client->getTopFiltersNoResults(
            'index',
            'mySearch',
            '1999-09-19',
            '2001-01-01',
            21,
            42,
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/filters/noResults',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopHits
     * get getTopHits with minimal parameters.
     */
    public function testGetTopHits0()
    {
        $client = $this->getClient();
        $client->getTopHits(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/hits',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopHits
     * get getTopHits with all parameters.
     */
    public function testGetTopHits1()
    {
        $client = $this->getClient();
        $client->getTopHits(
            'index',
            'mySearch',
            true,
            true,
            '1999-09-19',
            '2001-01-01',
            21,
            42,
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/hits',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","search":"mySearch","clickAnalytics":"true","revenueAnalytics":"true","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopSearches
     * get getTopSearches with minimal parameters.
     */
    public function testGetTopSearches0()
    {
        $client = $this->getClient();
        $client->getTopSearches(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopSearches
     * get getTopSearches with all parameters.
     */
    public function testGetTopSearches1()
    {
        $client = $this->getClient();
        $client->getTopSearches(
            'index',
            true,
            true,
            '1999-09-19',
            '2001-01-01',
            'searchCount',
            'asc',
            21,
            42,
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","clickAnalytics":"true","revenueAnalytics":"true","startDate":"1999-09-19","endDate":"2001-01-01","orderBy":"searchCount","direction":"asc","limit":"21","offset":"42","tags":"tag"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetTopSearches
     * e2e with complex query params.
     */
    public function testGetTopSearches2()
    {
        $client = $this->getClient();
        $client->getTopSearches(
            'cts_e2e_space in index',
        );

        $this->assertRequests([
            [
                'path' => '/2/searches',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"cts_e2e_space%20in%20index"}', true),
            ],
        ]);

        $e2eClient = $this->getE2EClient();
        $resp = $e2eClient->getTopSearches(
            'cts_e2e_space in index',
        );

        $expected = json_decode('{"searches":[{"search":"","nbHits":0}]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    /**
     * Test case for GetUsersCount
     * get getUsersCount with minimal parameters.
     */
    public function testGetUsersCount0()
    {
        $client = $this->getClient();
        $client->getUsersCount(
            'index',
        );

        $this->assertRequests([
            [
                'path' => '/2/users/count',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index"}', true),
            ],
        ]);
    }

    /**
     * Test case for GetUsersCount
     * get getUsersCount with all parameters.
     */
    public function testGetUsersCount1()
    {
        $client = $this->getClient();
        $client->getUsersCount(
            'index',
            '1999-09-19',
            '2001-01-01',
            'tag',
        );

        $this->assertRequests([
            [
                'path' => '/2/users/count',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}', true),
            ],
        ]);
    }

    protected function union($expected, $received)
    {
        if (is_array($expected)) {
            $res = [];
            // array and object are the same thing in PHP (magic ✨)
            foreach ($expected as $k => $v) {
                $res[$k] = $this->union($v, $received[$k]);
            }

            return $res;
        }

        return $received;
    }

    protected function assertRequests(array $requests)
    {
        $this->assertGreaterThan(0, count($requests));
        $this->assertEquals(count($requests), count($this->recordedRequests));

        foreach ($requests as $i => $request) {
            $recordedRequest = $this->recordedRequests[$i];

            $this->assertEquals($request['method'], $recordedRequest->getMethod());

            $this->assertEquals($request['path'], $recordedRequest->getUri()->getPath());

            if (isset($request['body'])) {
                $this->assertEquals(
                    json_encode($request['body']),
                    $recordedRequest->getBody()->getContents()
                );
            }

            if (isset($request['queryParameters'])) {
                $this->assertEquals(
                    Query::build($request['queryParameters'], false),
                    $recordedRequest->getUri()->getQuery()
                );
            }

            if (isset($request['headers'])) {
                foreach ($request['headers'] as $key => $value) {
                    $this->assertArrayHasKey(
                        $key,
                        $recordedRequest->getHeaders()
                    );
                    $this->assertEquals(
                        $recordedRequest->getHeaderLine($key),
                        $value
                    );
                }
            }
        }
    }

    protected function getE2EClient()
    {
        return AnalyticsClient::create($_ENV['ALGOLIA_APPLICATION_ID'], $_ENV['ALGOLIA_ADMIN_KEY'], 'us');
    }

    protected function getClient()
    {
        $config = AnalyticsConfig::create('appID', 'apiKey', 'us');
        $api = new ApiWrapper($this, $config, ClusterHosts::create('127.0.0.1'));

        return new AnalyticsClient($api, $config);
    }
}
