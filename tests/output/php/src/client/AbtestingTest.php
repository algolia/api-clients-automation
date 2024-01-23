<?php

namespace Algolia\AlgoliaSearch\Test\Client;

use Algolia\AlgoliaSearch\Api\AbtestingClient;
use Algolia\AlgoliaSearch\Configuration\AbtestingConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Client tests for AbtestingClient.
 *
 * @internal
 *
 * @coversNothing
 */
class AbtestingTest extends TestCase implements HttpClientInterface
{
    public const APP_ID = 'test-app-id';
    public const API_KEY = 'test-api-key';

    /**
     * @var RequestInterface
     */
    private $recordedRequest;

    public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
    {
        $this->recordedRequest = [
            'request' => $request,
            'responseTimeout' => $timeout * 1000,
            'connectTimeout' => $connectTimeout * 1000,
        ];

        return new Response(200, [], '{}');
    }

    /**
     * Test case : calls api with correct user agent.
     */
    public function test0commonApi()
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->customPost(
            '/test',
        );
        $this->assertTrue(
            (bool) preg_match(
                '/^Algolia for PHP \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Abtesting (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$/',
                $this->recordedRequest['request']->getHeader('User-Agent')[0]
            )
        );
    }

    /**
     * Test case : calls api with default read timeouts.
     */
    public function test1commonApi()
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->customGet(
            '/test',
        );
        $this->assertEquals(
            2000,
            $this->recordedRequest['connectTimeout']
        );

        $this->assertEquals(
            5000,
            $this->recordedRequest['responseTimeout']
        );
    }

    /**
     * Test case : calls api with default write timeouts.
     */
    public function test2commonApi()
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->customPost(
            '/test',
        );
        $this->assertEquals(
            2000,
            $this->recordedRequest['connectTimeout']
        );

        $this->assertEquals(
            30000,
            $this->recordedRequest['responseTimeout']
        );
    }

    /**
     * Test case : fallbacks to the alias when region is not given.
     */
    public function test0parameters()
    {
        $client = $this->createClient(
            'my-app-id',
            'my-api-key',
            null
        );
        $this->assertIsObject($client);
        $client->getABTest(
            123,
        );
        $this->assertEquals(
            'analytics.algolia.com',
            $this->recordedRequest['request']->getUri()->getHost()
        );
    }

    /**
     * Test case : uses the correct region.
     */
    public function test1parameters()
    {
        $client = $this->createClient(
            'my-app-id',
            'my-api-key',
            'us'
        );
        $this->assertIsObject($client);
        $client->getABTest(
            123,
        );
        $this->assertEquals(
            'analytics.us.algolia.com',
            $this->recordedRequest['request']->getUri()->getHost()
        );
    }

    /**
     * Test case : throws when incorrect region is given.
     */
    public function test2parameters()
    {
        try {
            $client = $this->createClient(
                'my-app-id',
                'my-api-key',
                'not_a_region'
            );
        } catch (\Exception $e) {
            $this->assertEquals($e->getMessage(), '`region` must be one of the following: de, us');
        }
    }

    /**
     * @param mixed $appId
     * @param mixed $apiKey
     * @param mixed $region
     *
     * @return AbtestingClient
     */
    private function createClient($appId, $apiKey, $region = 'us')
    {
        $config = AbtestingConfig::create($appId, $apiKey, $region);
        $clusterHosts = AbtestingClient::getClusterHosts($config);
        $api = new ApiWrapper($this, $config, $clusterHosts);

        return new AbtestingClient($api, $config);
    }
}
