<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Algolia;
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Cache\NullCacheDriver;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Exceptions\TimeoutException;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;
use Psr\SimpleCache\CacheInterface;

/**
 * Contract test for the host state cache: `resetHost()` only writes to the cache when it
 * actually changes a host, so a successful request on a healthy host does not hit the cache.
 *
 * @internal
 *
 * @coversNothing
 */
class HostStateCacheTest extends TestCase
{
    private const HOSTS = ['host-one.test', 'host-two.test'];

    private $cache;

    protected function setUp(): void
    {
        $this->cache = $this->countingCache();
        Algolia::setCache($this->cache);
    }

    protected function tearDown(): void
    {
        Algolia::setCache(new NullCacheDriver());
    }

    public function testResetOfAHealthyHostDoesNotWriteTheCache(): void
    {
        $clusterHosts = ClusterHosts::create(self::HOSTS)->setCacheKey('hosts');

        $clusterHosts->resetHost('host-one.test');

        $this->assertSame(0, $this->cache->sets);
    }

    public function testResetOfAChangedHostWritesTheCache(): void
    {
        $clusterHosts = ClusterHosts::create(self::HOSTS)->setCacheKey('hosts');

        $clusterHosts->failed('host-one.test');
        $this->assertSame(1, $this->cache->sets);

        $clusterHosts->resetHost('host-one.test');
        $this->assertSame(2, $this->cache->sets);

        $clusterHosts->timedOut('host-two.test');
        $this->assertSame(3, $this->cache->sets);

        // a timed out host is still up, but its retry count has to be cleared
        $clusterHosts->resetHost('host-two.test');
        $this->assertSame(4, $this->cache->sets);
    }

    public function testSuccessfulRequestsOnAHealthyHostDoNotWriteTheCache(): void
    {
        $client = $this->makeClient($this->recorder(function () {
            return new Response(200, [], '{}');
        }));

        $client->customGet('1/test');
        $sets = $this->cache->sets;

        $client->customGet('1/test');
        $client->customGet('1/test');

        $this->assertSame($sets, $this->cache->sets);
    }

    public function testSuccessAfterATimeoutWritesTheCacheOnce(): void
    {
        $client = $this->makeClient($this->recorder(function ($call) {
            if (1 === $call) {
                throw new TimeoutException('timed out');
            }

            return new Response(200, [], '{}');
        }));

        // first call: timeout on host one (write), success on host two (no change, no write)
        $client->customGet('1/test');
        $sets = $this->cache->sets;

        // host one is tried first again: its retry count is cleared (write), then nothing changes
        $client->customGet('1/test');
        $client->customGet('1/test');

        $this->assertSame($sets + 1, $this->cache->sets);
    }

    private function countingCache(): CacheInterface
    {
        return new class implements CacheInterface {
            public $sets = 0;

            private $values = [];

            public function get($key, $default = null): mixed
            {
                return $this->values[$key] ?? $default;
            }

            public function set($key, $value, $ttl = null): bool
            {
                ++$this->sets;
                $this->values[$key] = $value;

                return true;
            }

            public function delete($key): bool
            {
                unset($this->values[$key]);

                return true;
            }

            public function clear(): bool
            {
                $this->values = [];

                return true;
            }

            public function getMultiple($keys, $default = null): iterable
            {
                $values = [];
                foreach ($keys as $key) {
                    $values[$key] = $this->get($key, $default);
                }

                return $values;
            }

            public function setMultiple($values, $ttl = null): bool
            {
                foreach ($values as $key => $value) {
                    $this->set($key, $value, $ttl);
                }

                return true;
            }

            public function deleteMultiple($keys): bool
            {
                foreach ($keys as $key) {
                    $this->delete($key);
                }

                return true;
            }

            public function has($key): bool
            {
                return isset($this->values[$key]);
            }
        };
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
            new ApiWrapper(
                $mockHttp,
                $config,
                ClusterHosts::create(self::HOSTS)->setCacheKey('hosts'),
                new RequestOptionsFactory($config)
            ),
            $config
        );
    }
}
