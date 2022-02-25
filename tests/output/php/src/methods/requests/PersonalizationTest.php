<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\PersonalizationApi;
use Algolia\AlgoliaSearch\Configuration\PersonalizationConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * PersonalizationTest
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class PersonalizationTest extends TestCase implements HttpClientInterface
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
        $api = new ApiWrapper($this, PersonalizationConfig::create(), ClusterHosts::create('127.0.0.1'));
        $config = PersonalizationConfig::create('foo', 'bar');

        return new PersonalizationApi($api, $config);
    }

    /**
     * Test case for deleteUserProfile
     * Delete deleteUserProfile
     */
    public function testDeleteUserProfile0()
    {
        $client = $this->getClient();
        $params = json_decode('{"userToken":"UserToken"}', true);

        $client->deleteUserProfile($params);

        $this->assertRequests([
            [
                'path' => '/1/profiles/UserToken',
                'method' => 'DELETE',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getPersonalizationStrategy
     * Get getPersonalizationStrategy
     */
    public function testGetPersonalizationStrategy0()
    {
        $client = $this->getClient();

        $client->getPersonalizationStrategy();

        $this->assertRequests([
            [
                'path' => '/1/strategies/personalization',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for getUserTokenProfile
     * Get getUserTokenProfile
     */
    public function testGetUserTokenProfile0()
    {
        $client = $this->getClient();
        $params = json_decode('{"userToken":"UserToken"}', true);

        $client->getUserTokenProfile($params);

        $this->assertRequests([
            [
                'path' => '/1/profiles/personalization/UserToken',
                'method' => 'GET',
                'body' => '',
            ],
        ]);
    }

    /**
     * Test case for setPersonalizationStrategy
     * Set setPersonalizationStrategy
     */
    public function testSetPersonalizationStrategy0()
    {
        $client = $this->getClient();
        $params = json_decode('{"eventScoring":[{"score":42,"eventName":"Algolia","eventType":"Event"}],"facetScoring":[{"score":42,"facetName":"Event"}],"personalizationImpact":42}', true);

        $client->setPersonalizationStrategy($params);

        $this->assertRequests([
            [
                'path' => '/1/strategies/personalization',
                'method' => 'POST',
                'body' => '{"eventScoring":[{"score":42,"eventName":"Algolia","eventType":"Event"}],"facetScoring":[{"score":42,"facetName":"Event"}],"personalizationImpact":42}',
            ],
        ]);
    }
}
