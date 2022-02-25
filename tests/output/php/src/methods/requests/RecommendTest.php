<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\RecommendApi;
use Algolia\AlgoliaSearch\Configuration\RecommendConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * RecommendTest
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class RecommendTest extends TestCase implements HttpClientInterface
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
        $api = new ApiWrapper($this, RecommendConfig::create(), ClusterHosts::create('127.0.0.1'));
        $config = RecommendConfig::create('foo', 'bar');

        return new RecommendApi($api, $config);
    }

    /**
     * Test case for getRecommendations
     * Get recommendations with minimal parameters
     */
    public function testGetRecommendations0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42}]}", true);

        $client->getRecommendations($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/*/recommendations",
                "method" => "POST",
                "body" => "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42}]}",
            ],
        ]);
    }

    /**
     * Test case for getRecommendations
     * Get recommendations with all parameters
     */
    public function testGetRecommendations1()
    {
        $client = $this->getClient();
        $params = json_decode("{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}", true);

        $client->getRecommendations($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/*/recommendations",
                "method" => "POST",
                "body" => "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}",
            ],
        ]);
    }

    /**
     * Test case for getRecommendations
     * Get multiple recommendations with minimal parameters
     */
    public function testGetRecommendations2()
    {
        $client = $this->getClient();
        $params = json_decode("{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21}]}", true);

        $client->getRecommendations($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/*/recommendations",
                "method" => "POST",
                "body" => "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21}]}",
            ],
        ]);
    }

    /**
     * Test case for getRecommendations
     * Get multiple recommendations with all parameters
     */
    public function testGetRecommendations3()
    {
        $client = $this->getClient();
        $params = json_decode("{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query1\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback1\"]}},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query2\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback2\"]}}]}", true);

        $client->getRecommendations($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/*/recommendations",
                "method" => "POST",
                "body" => "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query1\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback1\"]}},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query2\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback2\"]}}]}",
            ],
        ]);
    }

    /**
     * Test case for getRecommendations
     * Get frequently bought together recommendations
     */
    public function testGetRecommendations4()
    {
        $client = $this->getClient();
        $params = json_decode("{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"bought-together\",\"threshold\":42}]}", true);

        $client->getRecommendations($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/*/recommendations",
                "method" => "POST",
                "body" => "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"bought-together\",\"threshold\":42}]}",
            ],
        ]);
    }
}
