<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\QuerySuggestionsClient;
use Algolia\AlgoliaSearch\Configuration\QuerySuggestionsConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use GuzzleHttp\Psr7\Query;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * QuerySuggestionsTest
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class QuerySuggestionsTest extends TestCase implements HttpClientInterface
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

            $this->assertEquals(
                $request['method'],
                $recordedRequest->getMethod()
            );

            $this->assertEquals(
                $request['path'],
                $recordedRequest->getUri()->getPath()
            );

            if (isset($request['body'])) {
                $this->assertEquals(
                    json_encode($request['body']),
                    $recordedRequest->getBody()->getContents()
                );
            }

            if (isset($request['queryParameters'])) {
                $this->assertEquals(
                    Query::build($request['queryParameters']),
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

    public function sendRequest(
        RequestInterface $request,
        $timeout,
        $connectTimeout
    ) {
        $this->recordedRequests[] = $request;

        return new Response(200, [], '{}');
    }

    protected function getClient()
    {
        $api = new ApiWrapper(
            $this,
            QuerySuggestionsConfig::create(
                getenv('ALGOLIA_APP_ID'),
                getenv('ALGOLIA_API_KEY')
            ),
            ClusterHosts::create('127.0.0.1')
        );
        $config = QuerySuggestionsConfig::create('foo', 'bar');

        return new QuerySuggestionsClient($api, $config);
    }

    /**
     * Test case for CreateConfig
     * createConfig
     */
    public function testCreateConfig0()
    {
        $client = $this->getClient();
        $client->createConfig([
            'indexName' => 'theIndexName',
            'sourceIndices' => [
                [
                    'indexName' => 'testIndex',
                    'facets' => [['attributes' => 'test']],
                    'generate' => [['facetA', 'facetB'], ['facetC']],
                ],
            ],
            'languages' => ['french'],
            'exclude' => ['test'],
        ]);

        $this->assertRequests([
            [
                'path' => '/1/configs',
                'method' => 'POST',
                'body' => json_decode(
                    "{\"indexName\":\"theIndexName\",\"sourceIndices\":[{\"indexName\":\"testIndex\",\"facets\":[{\"attributes\":\"test\"}],\"generate\":[[\"facetA\",\"facetB\"],[\"facetC\"]]}],\"languages\":[\"french\"],\"exclude\":[\"test\"]}"
                ),
            ],
        ]);
    }

    /**
     * Test case for Del
     * allow del method for a custom path with minimal parameters
     */
    public function testDel0()
    {
        $client = $this->getClient();
        $client->del('/test/minimal');

        $this->assertRequests([
            [
                'path' => '/1/test/minimal',
                'method' => 'DELETE',
            ],
        ]);
    }

    /**
     * Test case for Del
     * allow del method for a custom path with all parameters
     */
    public function testDel1()
    {
        $client = $this->getClient();
        $client->del(
            '/test/all',
            ['query' => 'parameters']
        );

        $this->assertRequests([
            [
                'path' => '/1/test/all',
                'method' => 'DELETE',
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for DeleteConfig
     * deleteConfig
     */
    public function testDeleteConfig0()
    {
        $client = $this->getClient();
        $client->deleteConfig('theIndexName');

        $this->assertRequests([
            [
                'path' => '/1/configs/theIndexName',
                'method' => 'DELETE',
            ],
        ]);
    }

    /**
     * Test case for Get
     * allow get method for a custom path with minimal parameters
     */
    public function testGet0()
    {
        $client = $this->getClient();
        $client->get('/test/minimal');

        $this->assertRequests([
            [
                'path' => '/1/test/minimal',
                'method' => 'GET',
            ],
        ]);
    }

    /**
     * Test case for Get
     * allow get method for a custom path with all parameters
     */
    public function testGet1()
    {
        $client = $this->getClient();
        $client->get(
            '/test/all',
            ['query' => 'parameters']
        );

        $this->assertRequests([
            [
                'path' => '/1/test/all',
                'method' => 'GET',
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for GetAllConfigs
     * getAllConfigs
     */
    public function testGetAllConfigs0()
    {
        $client = $this->getClient();
        $client->getAllConfigs();

        $this->assertRequests([
            [
                'path' => '/1/configs',
                'method' => 'GET',
            ],
        ]);
    }

    /**
     * Test case for GetConfig
     * getConfig
     */
    public function testGetConfig0()
    {
        $client = $this->getClient();
        $client->getConfig('theIndexName');

        $this->assertRequests([
            [
                'path' => '/1/configs/theIndexName',
                'method' => 'GET',
            ],
        ]);
    }

    /**
     * Test case for GetConfigStatus
     * getConfigStatus
     */
    public function testGetConfigStatus0()
    {
        $client = $this->getClient();
        $client->getConfigStatus('theIndexName');

        $this->assertRequests([
            [
                'path' => '/1/configs/theIndexName/status',
                'method' => 'GET',
            ],
        ]);
    }

    /**
     * Test case for GetLogFile
     * getLogFile
     */
    public function testGetLogFile0()
    {
        $client = $this->getClient();
        $client->getLogFile('theIndexName');

        $this->assertRequests([
            [
                'path' => '/1/logs/theIndexName',
                'method' => 'GET',
            ],
        ]);
    }

    /**
     * Test case for Post
     * allow post method for a custom path with minimal parameters
     */
    public function testPost0()
    {
        $client = $this->getClient();
        $client->post('/test/minimal');

        $this->assertRequests([
            [
                'path' => '/1/test/minimal',
                'method' => 'POST',
                'body' => json_decode('{}'),
            ],
        ]);
    }

    /**
     * Test case for Post
     * allow post method for a custom path with all parameters
     */
    public function testPost1()
    {
        $client = $this->getClient();
        $client->post(
            '/test/all',
            ['query' => 'parameters'],
            ['body' => 'parameters']
        );

        $this->assertRequests([
            [
                'path' => '/1/test/all',
                'method' => 'POST',
                'body' => json_decode("{\"body\":\"parameters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Post
     * requestOptions can override default query parameters
     */
    public function testPost2()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'query' => 'myQueryParameter',
            ],
            'headers' => [],
        ];
        $client->post(
            '/test/requestOptions',
            ['query' => 'parameters'],
            ['facet' => 'filters'],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode("{\"facet\":\"filters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"myQueryParameter\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Post
     * requestOptions merges query parameters with default ones
     */
    public function testPost3()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'query2' => 'myQueryParameter',
            ],
            'headers' => [],
        ];
        $client->post(
            '/test/requestOptions',
            ['query' => 'parameters'],
            ['facet' => 'filters'],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode("{\"facet\":\"filters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\",\"query2\":\"myQueryParameter\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Post
     * requestOptions can override default headers
     */
    public function testPost4()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [],
            'headers' => [
                'x-algolia-api-key' => 'myApiKey',
            ],
        ];
        $client->post(
            '/test/requestOptions',
            ['query' => 'parameters'],
            ['facet' => 'filters'],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode("{\"facet\":\"filters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\"}",
                    true
                ),
                'headers' => json_decode(
                    "{\"x-algolia-api-key\":\"myApiKey\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Post
     * requestOptions merges headers with default ones
     */
    public function testPost5()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [],
            'headers' => [
                'x-algolia-api-key' => 'myApiKey',
            ],
        ];
        $client->post(
            '/test/requestOptions',
            ['query' => 'parameters'],
            ['facet' => 'filters'],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode("{\"facet\":\"filters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\"}",
                    true
                ),
                'headers' => json_decode(
                    "{\"x-algolia-api-key\":\"myApiKey\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Post
     * requestOptions queryParameters accepts booleans
     */
    public function testPost6()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'isItWorking' => true,
            ],
            'headers' => [],
        ];
        $client->post(
            '/test/requestOptions',
            ['query' => 'parameters'],
            ['facet' => 'filters'],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode("{\"facet\":\"filters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\",\"isItWorking\":\"true\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Post
     * requestOptions queryParameters accepts integers
     */
    public function testPost7()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => 2,
            ],
            'headers' => [],
        ];
        $client->post(
            '/test/requestOptions',
            ['query' => 'parameters'],
            ['facet' => 'filters'],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode("{\"facet\":\"filters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\",\"myParam\":\"2\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Post
     * requestOptions queryParameters accepts list of string
     */
    public function testPost8()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => ['c', 'd'],
            ],
            'headers' => [],
        ];
        $client->post(
            '/test/requestOptions',
            ['query' => 'parameters'],
            ['facet' => 'filters'],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode("{\"facet\":\"filters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\",\"myParam\":\"c,d\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Post
     * requestOptions queryParameters accepts list of booleans
     */
    public function testPost9()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => [true, true, false],
            ],
            'headers' => [],
        ];
        $client->post(
            '/test/requestOptions',
            ['query' => 'parameters'],
            ['facet' => 'filters'],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode("{\"facet\":\"filters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\",\"myParam\":\"true,true,false\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Post
     * requestOptions queryParameters accepts list of integers
     */
    public function testPost10()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => [1, 2],
            ],
            'headers' => [],
        ];
        $client->post(
            '/test/requestOptions',
            ['query' => 'parameters'],
            ['facet' => 'filters'],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode("{\"facet\":\"filters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\",\"myParam\":\"1,2\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for Put
     * allow put method for a custom path with minimal parameters
     */
    public function testPut0()
    {
        $client = $this->getClient();
        $client->put('/test/minimal');

        $this->assertRequests([
            [
                'path' => '/1/test/minimal',
                'method' => 'PUT',
                'body' => json_decode('{}'),
            ],
        ]);
    }

    /**
     * Test case for Put
     * allow put method for a custom path with all parameters
     */
    public function testPut1()
    {
        $client = $this->getClient();
        $client->put(
            '/test/all',
            ['query' => 'parameters'],
            ['body' => 'parameters']
        );

        $this->assertRequests([
            [
                'path' => '/1/test/all',
                'method' => 'PUT',
                'body' => json_decode("{\"body\":\"parameters\"}"),
                'queryParameters' => json_decode(
                    "{\"query\":\"parameters\"}",
                    true
                ),
            ],
        ]);
    }

    /**
     * Test case for UpdateConfig
     * updateConfig
     */
    public function testUpdateConfig0()
    {
        $client = $this->getClient();
        $client->updateConfig(
            'theIndexName',
            [
                'sourceIndices' => [
                    [
                        'indexName' => 'testIndex',
                        'facets' => [['attributes' => 'test']],
                        'generate' => [['facetA', 'facetB'], ['facetC']],
                    ],
                ],
                'languages' => ['french'],
                'exclude' => ['test'],
            ]
        );

        $this->assertRequests([
            [
                'path' => '/1/configs/theIndexName',
                'method' => 'PUT',
                'body' => json_decode(
                    "{\"sourceIndices\":[{\"indexName\":\"testIndex\",\"facets\":[{\"attributes\":\"test\"}],\"generate\":[[\"facetA\",\"facetB\"],[\"facetC\"]]}],\"languages\":[\"french\"],\"exclude\":[\"test\"]}"
                ),
            ],
        ]);
    }
}
