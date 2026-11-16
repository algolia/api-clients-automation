<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Exceptions\UnreachableException;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use Algolia\AlgoliaSearch\RetryStrategy\HostCollection;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Contract test for the "every host is down" fallback: instead of failing without sending
 * anything until `Host::TTL` expires, the collection resets and hands back every host.
 *
 * @internal
 *
 * @coversNothing
 */
class AllHostsDownTest extends TestCase
{
    private const HOSTS = ['host-one.test', 'host-two.test'];

    public function testCollectionResetsWhenEveryHostIsDown(): void
    {
        $collection = HostCollection::create(['host-one.test' => 0, 'host-two.test' => 10]);
        $collection->markAsDown('host-one.test');

        $this->assertSame(['host-two.test'], $collection->getUrls());

        $collection->markAsDown('host-two.test');

        $this->assertSame(['host-one.test', 'host-two.test'], $collection->getUrls());
        // the reset sticks: hosts are up again, not just returned once
        $this->assertSame(['host-one.test', 'host-two.test'], $collection->getUrls());
    }

    public function testNextRequestReachesTheNetworkAfterEveryHostFailed(): void
    {
        $hostCount = count(self::HOSTS);
        $http = $this->recorder(function ($call) use ($hostCount) {
            // the first request fails on every host, the next one succeeds
            return $call <= $hostCount
                ? new Response(500, [], '{}')
                : new Response(200, [], '{"message":"ok after outage"}');
        });
        $client = $this->makeClient($http);

        try {
            $client->customGet('1/test');
            $this->fail('Expected UnreachableException to be thrown');
        } catch (UnreachableException $e) {
            $this->assertCount($hostCount, $e->getErrors());
        }

        $this->assertSame(['message' => 'ok after outage'], $client->customGet('1/test'));
        $this->assertSame($hostCount + 1, $http->calls);
    }

    private function recorder(callable $respond): HttpClientInterface
    {
        return new class($respond) implements HttpClientInterface {
            public $calls = 0;

            private $respond;

            public function __construct(callable $respond)
            {
                $this->respond = $respond;
            }

            public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
            {
                ++$this->calls;

                return ($this->respond)($this->calls);
            }
        };
    }

    private function makeClient(HttpClientInterface $mockHttp): SearchClient
    {
        $config = SearchConfig::create('test-app-id', 'test-api-key');

        return new SearchClient(
            new ApiWrapper($mockHttp, $config, ClusterHosts::create(self::HOSTS), new RequestOptionsFactory($config)),
            $config
        );
    }
}
