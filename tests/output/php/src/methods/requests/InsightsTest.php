<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\InsightsApi;
use Algolia\AlgoliaSearch\Configuration\InsightsConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * InsightsTest
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class InsightsTest extends TestCase implements HttpClientInterface
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
        $api = new ApiWrapper($this, InsightsConfig::create(), ClusterHosts::create('127.0.0.1'));
        $config = InsightsConfig::create('foo', 'bar');

        return new InsightsApi($api, $config);
    }

    /**
     * Test case for pushEvents
     * PushEvents
     */
    public function testPushEvents0()
    {
        $client = $this->getClient();
        $params = json_decode('{"events":[{"eventType":"click","eventName":"Product Clicked","index":"products","userToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7","positions":[7,6]},{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"]},{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"}]}', true);

        $client->pushEvents($params);

        $this->assertRequests([
            [
                'path' => '/1/events',
                'method' => 'POST',
                'body' => '{"events":[{"eventType":"click","eventName":"Product Clicked","index":"products","userToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7","positions":[7,6]},{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"]},{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"}]}',
            ],
        ]);
    }
}
