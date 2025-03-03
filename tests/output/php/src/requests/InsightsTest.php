<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Test\Request;

use Algolia\AlgoliaSearch\Api\InsightsClient;
use Algolia\AlgoliaSearch\Configuration\InsightsConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use GuzzleHttp\Psr7\Query;
use PHPUnit\Framework\Attributes\CoversClass;
use PHPUnit\Framework\Attributes\TestDox;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * @internal
 */
#[CoversClass(InsightsClient::class)]
class InsightsTest extends TestCase implements HttpClientInterface
{
    private $recordedRequests = [];

    public function sendRequest(RequestInterface $request, $timeout, $connectTimeout): Response
    {
        $this->recordedRequests[] = $request;

        return new Response(200, [], '{}');
    }

    #[TestDox('allow del method for a custom path with minimal parameters')]
    public function testCustomDelete(): void
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

    #[TestDox('allow del method for a custom path with all parameters')]
    public function testCustomDelete1(): void
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

    #[TestDox('allow get method for a custom path with minimal parameters')]
    public function testCustomGet(): void
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

    #[TestDox('allow get method for a custom path with all parameters')]
    public function testCustomGet1(): void
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

    #[TestDox('requestOptions should be escaped too')]
    public function testCustomGet2(): void
    {
        $client = $this->getClient();
        $client->customGet(
            'test/all',
            ['query' => 'to be overriden',
            ],
            [
                'queryParameters' => [
                    'query' => 'parameters with space',
                    'and an array' => ['array', 'with spaces',
                    ],
                ],
                'headers' => [
                    'x-header-1' => 'spaces are left alone',
                ],
            ]
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

    #[TestDox('allow post method for a custom path with minimal parameters')]
    public function testCustomPost(): void
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

    #[TestDox('allow post method for a custom path with all parameters')]
    public function testCustomPost1(): void
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

    #[TestDox('requestOptions can override default query parameters')]
    public function testCustomPost2(): void
    {
        $client = $this->getClient();
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'query' => 'myQueryParameter',
                ], ]
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

    #[TestDox('requestOptions merges query parameters with default ones')]
    public function testCustomPost3(): void
    {
        $client = $this->getClient();
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'query2' => 'myQueryParameter',
                ], ]
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

    #[TestDox('requestOptions can override default headers')]
    public function testCustomPost4(): void
    {
        $client = $this->getClient();
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'headers' => [
                    'x-algolia-api-key' => 'ALGOLIA_API_KEY',
                ],
            ]
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
                'headers' => json_decode('{"x-algolia-api-key":"ALGOLIA_API_KEY"}', true),
            ],
        ]);
    }

    #[TestDox('requestOptions merges headers with default ones')]
    public function testCustomPost5(): void
    {
        $client = $this->getClient();
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'headers' => [
                    'x-algolia-api-key' => 'ALGOLIA_API_KEY',
                ],
            ]
        );

        $this->assertRequests([
            [
                'path' => '/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
                'headers' => json_decode('{"x-algolia-api-key":"ALGOLIA_API_KEY"}', true),
            ],
        ]);
    }

    #[TestDox('requestOptions queryParameters accepts booleans')]
    public function testCustomPost6(): void
    {
        $client = $this->getClient();
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'isItWorking' => true,
                ], ]
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

    #[TestDox('requestOptions queryParameters accepts integers')]
    public function testCustomPost7(): void
    {
        $client = $this->getClient();
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'myParam' => 2,
                ], ]
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

    #[TestDox('requestOptions queryParameters accepts list of string')]
    public function testCustomPost8(): void
    {
        $client = $this->getClient();
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'myParam' => ['b and c', 'd',
                    ],
                ], ]
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

    #[TestDox('requestOptions queryParameters accepts list of booleans')]
    public function testCustomPost9(): void
    {
        $client = $this->getClient();
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'myParam' => [true, true, false,
                    ],
                ], ]
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

    #[TestDox('requestOptions queryParameters accepts list of integers')]
    public function testCustomPost10(): void
    {
        $client = $this->getClient();
        $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'myParam' => [1, 2,
                    ],
                ], ]
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

    #[TestDox('allow put method for a custom path with minimal parameters')]
    public function testCustomPut(): void
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

    #[TestDox('allow put method for a custom path with all parameters')]
    public function testCustomPut1(): void
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

    #[TestDox('deleteUserToken')]
    public function testDeleteUserToken(): void
    {
        $client = $this->getClient();
        $client->deleteUserToken(
            'test-user-1',
        );

        $this->assertRequests([
            [
                'path' => '/1/usertokens/test-user-1',
                'method' => 'DELETE',
                'body' => null,
            ],
        ]);
    }

    #[TestDox('pushEvents')]
    public function testPushEvents(): void
    {
        $client = $this->getClient();
        $client->pushEvents(
            ['events' => [
                ['eventType' => 'click',
                    'eventName' => 'Product Clicked',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1641290601962,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                    'queryID' => '43b15df305339e827f0ac0bdc5ebcaa7',
                    'positions' => [
                        7,

                        6,
                    ],
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/events',
                'method' => 'POST',
                'body' => json_decode('{"events":[{"eventType":"click","eventName":"Product Clicked","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7","positions":[7,6]}]}'),
            ],
        ]);
    }

    #[TestDox('Many events type')]
    public function testPushEvents1(): void
    {
        $client = $this->getClient();
        $client->pushEvents(
            ['events' => [
                ['eventType' => 'conversion',
                    'eventName' => 'Product Purchased',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1740787200000,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                    'queryID' => '43b15df305339e827f0ac0bdc5ebcaa7',
                ],

                ['eventType' => 'view',
                    'eventName' => 'Product Detail Page Viewed',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1740787200000,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/events',
                'method' => 'POST',
                'body' => json_decode('{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1740787200000,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"},{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1740787200000,"objectIDs":["9780545139700","9780439784542"]}]}'),
            ],
        ]);
    }

    #[TestDox('ConvertedObjectIDsAfterSearch')]
    public function testPushEvents2(): void
    {
        $client = $this->getClient();
        $client->pushEvents(
            ['events' => [
                ['eventType' => 'conversion',
                    'eventName' => 'Product Purchased',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1641290601962,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                    'queryID' => '43b15df305339e827f0ac0bdc5ebcaa7',
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/events',
                'method' => 'POST',
                'body' => json_decode('{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"}]}'),
            ],
        ]);
    }

    #[TestDox('ViewedObjectIDs')]
    public function testPushEvents3(): void
    {
        $client = $this->getClient();
        $client->pushEvents(
            ['events' => [
                ['eventType' => 'view',
                    'eventName' => 'Product Detail Page Viewed',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1641290601962,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/events',
                'method' => 'POST',
                'body' => json_decode('{"events":[{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"]}]}'),
            ],
        ]);
    }

    #[TestDox('AddedToCartObjectIDs')]
    public function testPushEvents4(): void
    {
        $client = $this->getClient();
        $client->pushEvents(
            ['events' => [
                ['eventType' => 'conversion',
                    'eventSubtype' => 'addToCart',
                    'eventName' => 'Product Added To Cart',
                    'index' => 'products',
                    'queryID' => '43b15df305339e827f0ac0bdc5ebcaa7',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1641290601962,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                    'objectData' => [
                        ['price' => 19.99,
                            'quantity' => 10,
                            'discount' => 2.5,
                        ],

                        ['price' => '8$',
                            'quantity' => 7,
                            'discount' => '30%',
                        ],
                    ],
                    'currency' => 'USD',
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/events',
                'method' => 'POST',
                'body' => json_decode('{"events":[{"eventType":"conversion","eventSubtype":"addToCart","eventName":"Product Added To Cart","index":"products","queryID":"43b15df305339e827f0ac0bdc5ebcaa7","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"objectData":[{"price":19.99,"quantity":10,"discount":2.5},{"price":"8$","quantity":7,"discount":"30%"}],"currency":"USD"}]}'),
            ],
        ]);
    }

    protected function assertRequests(array $requests): void
    {
        $this->assertGreaterThan(0, count($requests));
        $this->assertEquals(count($requests), count($this->recordedRequests));

        foreach ($requests as $i => $request) {
            $recordedRequest = $this->recordedRequests[$i];

            $this->assertEquals($request['method'], $recordedRequest->getMethod());

            $this->assertEquals($request['path'], $recordedRequest->getUri()->getPath());

            if (isset($request['body'])) {
                $this->assertEquals(
                    json_encode($request['body'], JSON_UNESCAPED_UNICODE),
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

    protected function getClient(): InsightsClient
    {
        $config = InsightsConfig::create('appID', 'apiKey', 'us');
        $api = new ApiWrapper($this, $config, ClusterHosts::create('127.0.0.1'));

        return new InsightsClient($api, $config);
    }
}
