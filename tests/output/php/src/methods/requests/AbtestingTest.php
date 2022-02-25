<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\AbtestingApi;
use Algolia\AlgoliaSearch\Configuration\AbtestingConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * AbtestingTest
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class AbtestingTest extends TestCase implements HttpClientInterface
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
        $api = new ApiWrapper($this, AbtestingConfig::create(), ClusterHosts::create('127.0.0.1'));
        $config = AbtestingConfig::create('foo', 'bar');

        return new AbtestingApi($api, $config);
    }

    /**
     * Test case for addABTests
     * AddABTests with minimal parameters
     */
    public function testAddABTests0()
    {
        $client = $this->getClient();
        $params = json_decode('{"endAt":"2022-12-31T00:00:00.000Z","name":"myABTest","variant":[{"index":"AB_TEST_1","trafficPercentage":30},{"index":"AB_TEST_2","trafficPercentage":50}]}', true);

        $client->addABTests($params);

        $this->assertRequests([
            [
                'path' => '/2/abtests',
                'method' => 'POST',
                'body' => '{"endAt":"2022-12-31T00:00:00.000Z","name":"myABTest","variant":[{"index":"AB_TEST_1","trafficPercentage":30},{"index":"AB_TEST_2","trafficPercentage":50}]}',
            ],
        ]);
    }

    /**
     * Test case for deleteABTest
     * DeleteABTest
     */
    public function testDeleteABTest0()
    {
        $client = $this->getClient();
        $params = json_decode('{"id":42}', true);

        $client->deleteABTest($params);

        $this->assertRequests([
            [
                'path' => '/2/abtests/42',
                'method' => 'DELETE',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getABTest
     * GetABTest
     */
    public function testGetABTest0()
    {
        $client = $this->getClient();
        $params = json_decode('{"id":42}', true);

        $client->getABTest($params);

        $this->assertRequests([
            [
                'path' => '/2/abtests/42',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for listABTests
     * ListABTests with minimal parameters
     */
    public function testListABTests0()
    {
        $client = $this->getClient();
        $params = json_decode('{"offset":42,"limit":21}', true);

        $client->listABTests($params);

        $this->assertRequests([
            [
                'path' => '/2/abtests',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for stopABTest
     * StopABTest
     */
    public function testStopABTest0()
    {
        $client = $this->getClient();
        $params = json_decode('{"id":42}', true);

        $client->stopABTest($params);

        $this->assertRequests([
            [
                'path' => '/2/abtests/42/stop',
                'method' => 'POST',
                'body' => '',
            ],
        ]);
    }
}
