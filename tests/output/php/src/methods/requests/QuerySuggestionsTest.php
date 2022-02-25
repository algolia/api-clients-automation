<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\QuerySuggestionsApi;
use Algolia\AlgoliaSearch\Configuration\QuerySuggestionsConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
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
        $api = new ApiWrapper($this, QuerySuggestionsConfig::create(), ClusterHosts::create('127.0.0.1'));
        $config = QuerySuggestionsConfig::create('foo', 'bar');

        return new QuerySuggestionsApi($api, $config);
    }

    /**
     * Test case for createConfig
     * CreateConfig
     */
    public function testCreateConfig0()
    {
        $client = $this->getClient();
        $params = json_decode('{"indexName":"theIndexName","sourceIndices":[{"indexName":"testIndex","facets":[{"attributes":"test"}],"generate":[["facetA","facetB"],["facetC"]]}],"languages":["french"],"exclude":["test"]}', true);

        $client->createConfig($params);

        $this->assertRequests([
            [
                'path' => '/1/configs',
                'method' => 'POST',
                'body' => '{"indexName":"theIndexName","sourceIndices":[{"indexName":"testIndex","facets":[{"attributes":"test"}],"generate":[["facetA","facetB"],["facetC"]]}],"languages":["french"],"exclude":["test"]}',
            ],
        ]);
    }

    /**
     * Test case for deleteConfig
     * DeleteConfig
     */
    public function testDeleteConfig0()
    {
        $client = $this->getClient();
        $params = json_decode('{"indexName":"theIndexName"}', true);

        $client->deleteConfig($params);

        $this->assertRequests([
            [
                'path' => '/1/configs/theIndexName',
                'method' => 'DELETE',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getAllConfigs
     * GetAllConfigs
     */
    public function testGetAllConfigs0()
    {
        $client = $this->getClient();

        $client->getAllConfigs();

        $this->assertRequests([
            [
                'path' => '/1/configs',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getConfig
     * GetConfig
     */
    public function testGetConfig0()
    {
        $client = $this->getClient();
        $params = json_decode('{"indexName":"theIndexName"}', true);

        $client->getConfig($params);

        $this->assertRequests([
            [
                'path' => '/1/configs/theIndexName',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getConfigStatus
     * GetConfigStatus
     */
    public function testGetConfigStatus0()
    {
        $client = $this->getClient();
        $params = json_decode('{"indexName":"theIndexName"}', true);

        $client->getConfigStatus($params);

        $this->assertRequests([
            [
                'path' => '/1/configs/theIndexName/status',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getLogFile
     * GetLogFile
     */
    public function testGetLogFile0()
    {
        $client = $this->getClient();
        $params = json_decode('{"indexName":"theIndexName"}', true);

        $client->getLogFile($params);

        $this->assertRequests([
            [
                'path' => '/1/logs/theIndexName',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for updateConfig
     * UpdateConfig
     */
    public function testUpdateConfig0()
    {
        $client = $this->getClient();
        $params = json_decode('{"indexName":"theIndexName","querySuggestionsIndexParam":{"sourceIndices":[{"indexName":"testIndex","facets":[{"attributes":"test"}],"generate":[["facetA","facetB"],["facetC"]]}],"languages":["french"],"exclude":["test"]}}', true);

        $client->updateConfig($params);

        $this->assertRequests([
            [
                'path' => '/1/configs/theIndexName',
                'method' => 'PUT',
                'body' => '{"sourceIndices":[{"indexName":"testIndex","facets":[{"attributes":"test"}],"generate":[["facetA","facetB"],["facetC"]]}],"languages":["french"],"exclude":["test"]}',
            ],
        ]);
    }
}
