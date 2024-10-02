<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Test\Request;

use Algolia\AlgoliaSearch\Api\RecommendClient;
use Algolia\AlgoliaSearch\Configuration\RecommendConfig;
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
#[CoversClass(RecommendClient::class)]
class RecommendTest extends TestCase implements HttpClientInterface
{
    private $recordedRequests = [];

    public function sendRequest(RequestInterface $request, $timeout, $connectTimeout): Response
    {
        $this->recordedRequests[] = $request;

        return new Response(200, [], '{}');
    }

    #[TestDox('batch recommend rules')]
    public function testBatchRecommendRules(): void
    {
        $client = $this->getClient();
        $client->batchRecommendRules(
            'indexName',
            'related-products',
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/indexName/related-products/recommend/rules/batch',
                'method' => 'POST',
                'body' => json_decode('{}'),
            ],
        ]);
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
                ],
            ]
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
                ],
            ]
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
                ],
            ]
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
                ],
            ]
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
                ],
            ]
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
                ],
            ]
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
                ],
            ]
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

    #[TestDox('deleteRecommendRule')]
    public function testDeleteRecommendRule(): void
    {
        $client = $this->getClient();
        $client->deleteRecommendRule(
            'indexName',
            'related-products',
            'objectID',
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/indexName/related-products/recommend/rules/objectID',
                'method' => 'DELETE',
                'body' => null,
            ],
        ]);
    }

    #[TestDox('getRecommendRule')]
    public function testGetRecommendRule(): void
    {
        $client = $this->getClient();
        $client->getRecommendRule(
            'indexName',
            'related-products',
            'objectID',
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/indexName/related-products/recommend/rules/objectID',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    #[TestDox('getRecommendStatus')]
    public function testGetRecommendStatus(): void
    {
        $client = $this->getClient();
        $client->getRecommendStatus(
            'indexName',
            'related-products',
            12345,
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/indexName/related-products/task/12345',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    #[TestDox('get recommendations for recommend model with minimal parameters')]
    public function testGetRecommendations(): void
    {
        $client = $this->getClient();
        $client->getRecommendations(
            ['requests' => [
                ['indexName' => 'indexName',
                    'objectID' => 'objectID',
                    'model' => 'related-products',
                    'threshold' => 42.1,
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/*/recommendations',
                'method' => 'POST',
                'body' => json_decode('{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42.1}]}'),
            ],
        ]);
    }

    #[TestDox('get recommendations for recommend model with all parameters')]
    public function testGetRecommendations1(): void
    {
        $client = $this->getClient();
        $client->getRecommendations(
            ['requests' => [
                ['indexName' => 'indexName',
                    'objectID' => 'objectID',
                    'model' => 'related-products',
                    'threshold' => 42.1,
                    'maxRecommendations' => 10,
                    'queryParameters' => ['query' => 'myQuery',
                        'facetFilters' => [
                            'query',
                        ],
                    ],
                    'fallbackParameters' => ['query' => 'myQuery',
                        'facetFilters' => [
                            'fallback',
                        ],
                    ],
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/*/recommendations',
                'method' => 'POST',
                'body' => json_decode('{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42.1,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}'),
            ],
        ]);
    }

    #[TestDox('get recommendations for trending model with minimal parameters')]
    public function testGetRecommendations2(): void
    {
        $client = $this->getClient();
        $client->getRecommendations(
            ['requests' => [
                ['indexName' => 'indexName',
                    'model' => 'trending-items',
                    'threshold' => 42.1,
                    'facetName' => 'facet',
                    'facetValue' => 'value',
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/*/recommendations',
                'method' => 'POST',
                'body' => json_decode('{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42.1,"facetName":"facet","facetValue":"value"}]}'),
            ],
        ]);
    }

    #[TestDox('get recommendations for trending model with all parameters')]
    public function testGetRecommendations3(): void
    {
        $client = $this->getClient();
        $client->getRecommendations(
            ['requests' => [
                ['indexName' => 'indexName',
                    'model' => 'trending-items',
                    'threshold' => 42.1,
                    'maxRecommendations' => 10,
                    'facetName' => 'myFacetName',
                    'facetValue' => 'myFacetValue',
                    'queryParameters' => ['query' => 'myQuery',
                        'facetFilters' => [
                            'query',
                        ],
                    ],
                    'fallbackParameters' => ['query' => 'myQuery',
                        'facetFilters' => [
                            'fallback',
                        ],
                    ],
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/*/recommendations',
                'method' => 'POST',
                'body' => json_decode('{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42.1,"maxRecommendations":10,"facetName":"myFacetName","facetValue":"myFacetValue","queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}'),
            ],
        ]);
    }

    #[TestDox('get multiple recommendations with minimal parameters')]
    public function testGetRecommendations4(): void
    {
        $client = $this->getClient();
        $client->getRecommendations(
            ['requests' => [
                ['indexName' => 'indexName1',
                    'objectID' => 'objectID1',
                    'model' => 'related-products',
                    'threshold' => 21.7,
                ],

                ['indexName' => 'indexName2',
                    'objectID' => 'objectID2',
                    'model' => 'related-products',
                    'threshold' => 21.7,
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/*/recommendations',
                'method' => 'POST',
                'body' => json_decode('{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21.7},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21.7}]}'),
            ],
        ]);
    }

    #[TestDox('get multiple recommendations with all parameters')]
    public function testGetRecommendations5(): void
    {
        $client = $this->getClient();
        $client->getRecommendations(
            ['requests' => [
                ['indexName' => 'indexName1',
                    'objectID' => 'objectID1',
                    'model' => 'related-products',
                    'threshold' => 21.7,
                    'maxRecommendations' => 10,
                    'queryParameters' => ['query' => 'myQuery',
                        'facetFilters' => [
                            'query1',
                        ],
                    ],
                    'fallbackParameters' => ['query' => 'myQuery',
                        'facetFilters' => [
                            'fallback1',
                        ],
                    ],
                ],

                ['indexName' => 'indexName2',
                    'objectID' => 'objectID2',
                    'model' => 'related-products',
                    'threshold' => 21.7,
                    'maxRecommendations' => 10,
                    'queryParameters' => ['query' => 'myQuery',
                        'facetFilters' => [
                            'query2',
                        ],
                    ],
                    'fallbackParameters' => ['query' => 'myQuery',
                        'facetFilters' => [
                            'fallback2',
                        ],
                    ],
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/*/recommendations',
                'method' => 'POST',
                'body' => json_decode('{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21.7,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query1"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback1"]}},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21.7,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query2"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback2"]}}]}'),
            ],
        ]);
    }

    #[TestDox('get frequently bought together recommendations')]
    public function testGetRecommendations6(): void
    {
        $client = $this->getClient();
        $client->getRecommendations(
            ['requests' => [
                ['indexName' => 'indexName1',
                    'objectID' => 'objectID1',
                    'model' => 'bought-together',
                    'threshold' => 42.7,
                ],
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/*/recommendations',
                'method' => 'POST',
                'body' => json_decode('{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"bought-together","threshold":42.7}]}'),
            ],
        ]);
    }

    #[TestDox('searchRecommendRules')]
    public function testSearchRecommendRules(): void
    {
        $client = $this->getClient();
        $client->searchRecommendRules(
            'indexName',
            'related-products',
        );

        $this->assertRequests([
            [
                'path' => '/1/indexes/indexName/related-products/recommend/rules/search',
                'method' => 'POST',
                'body' => json_decode('{}'),
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

    protected function getClient(): RecommendClient
    {
        $config = RecommendConfig::create('appID', 'apiKey');
        $api = new ApiWrapper($this, $config, ClusterHosts::create('127.0.0.1'));

        return new RecommendClient($api, $config);
    }
}
