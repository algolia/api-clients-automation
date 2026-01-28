<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Exceptions\UnreachableException;
use Algolia\AlgoliaSearch\Http\CurlHttpClient;
use Algolia\AlgoliaSearch\Http\GuzzleHttpClient;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;

function getTestServerHost(): string
{
    return ('true' === getenv('CI') ? 'localhost' : 'host.docker.internal').':6676';
}

class TimeoutIntegrationTest extends TestCase
{
    private const NON_ROUTABLE_IP = '10.255.255.1';
    private const CONNECT_TIMEOUT_SECONDS = 2;

    // curl connect timeout increases across failed requests: 2s -> 4s -> 6s.
    public function testCurlRetryCountStateful(): void
    {
        [$wrapper, $clusterHosts] = $this->createApiWrapperWithClusterHosts(
            new CurlHttpClient(),
            [self::NON_ROUTABLE_IP]
        );

        $times = [];

        for ($i = 0; $i < 3; ++$i) {
            $start = microtime(true);

            try {
                $wrapper->send('GET', '/1/test');
            } catch (UnreachableException $e) {
            }

            $times[] = microtime(true) - $start;

            // verify retry count is actually incrementing
            $retryCount = $clusterHosts->getRetryCount(self::NON_ROUTABLE_IP, false);
            $this->assertEquals($i + 1, $retryCount, 'After request '.($i + 1).', retry count should be '.($i + 1));
        }

        $this->assertGreaterThan(1.5, $times[0], 'Request 1 should take at least ~2s');
        $this->assertLessThan(2.5, $times[0], 'Request 1 should take at most ~2s');

        $this->assertGreaterThan(3.5, $times[1], 'Request 2 should take at least ~4s');
        $this->assertLessThan(4.5, $times[1], 'Request 2 should take at most ~4s');

        $this->assertGreaterThan(5.5, $times[2], 'Request 3 should take at least ~6s');
        $this->assertLessThan(7.0, $times[2], 'Request 3 should take at most ~6s');
    }

    // GuzzleHttpClient connect timeout increases across failed requests: 2s -> 4s -> 6s.
    public function testGuzzleRetryCountStateful(): void
    {
        if (!class_exists('\GuzzleHttp\Client')) {
            $this->markTestSkipped('Guzzle is not installed. Install guzzlehttp/guzzle to run this test.');
        }

        [$wrapper, $clusterHosts] = $this->createApiWrapperWithClusterHosts(
            new GuzzleHttpClient(),
            [self::NON_ROUTABLE_IP]
        );

        $times = [];

        for ($i = 0; $i < 3; ++$i) {
            $start = microtime(true);

            try {
                $wrapper->send('GET', '/1/test');
            } catch (UnreachableException $e) {
            }

            $times[] = microtime(true) - $start;

            // verify retry count is actually incrementing
            $retryCount = $clusterHosts->getRetryCount(self::NON_ROUTABLE_IP, false);
            $this->assertEquals($i + 1, $retryCount, 'After request '.($i + 1).', retry count should be '.($i + 1));
        }

        $this->assertGreaterThan(1.5, $times[0], 'Request 1 should take at least ~2s');
        $this->assertLessThan(2.5, $times[0], 'Request 1 should take at most ~2s');

        $this->assertGreaterThan(3.5, $times[1], 'Request 2 should take at least ~4s');
        $this->assertLessThan(4.5, $times[1], 'Request 2 should take at most ~4s');

        $this->assertGreaterThan(5.5, $times[2], 'Request 3 should take at least ~6s');
        $this->assertLessThan(7.0, $times[2], 'Request 3 should take at most ~6s');
    }

    // curl retry_count resets to 0 after successful request.
    public function testCurlRetryCountResets(): void
    {
        $badHost = self::NON_ROUTABLE_IP;
        $goodHostFull = 'http://'.getTestServerHost();

        // Create wrapper with bad host, fail twice to increment retry_count
        [$wrapper, $clusterHosts] = $this->createApiWrapperWithClusterHosts(
            new CurlHttpClient(),
            [$badHost]
        );

        for ($i = 0; $i < 2; ++$i) {
            try {
                $wrapper->send('GET', '/test');
            } catch (UnreachableException $e) {
            }
        }

        $badHostRetryCount = $clusterHosts->getRetryCount($badHost, false);
        $this->assertEquals(2, $badHostRetryCount, 'Bad host should have retry_count=2');

        // create wrapper with good host, copy retry_count from bad host
        [$wrapper, $clusterHosts] = $this->createApiWrapperWithClusterHostsFullHost(
            new CurlHttpClient(),
            [$goodHostFull]
        );
        $clusterHosts->setRetryCount($goodHostFull, $badHostRetryCount, false);

        // verify setRetryCount actually worked
        $this->assertEquals(
            2,
            $clusterHosts->getRetryCount($goodHostFull, false),
            'setRetryCount should have set retry_count to 2'
        );

        // make successful request
        $response = $wrapper->send('GET', '/1/test/instant');
        $this->assertIsArray($response);

        // verify retry_count was reset
        $this->assertEquals(
            0,
            $clusterHosts->getRetryCount($goodHostFull, false),
            'retry_count should reset to 0 after success'
        );

        // now point back to bad host and verify timeout is ~2s (not ~6s)
        [$wrapper, $clusterHosts] = $this->createApiWrapperWithClusterHosts(
            new CurlHttpClient(),
            [$badHost]
        );

        $start = microtime(true);

        try {
            $wrapper->send('GET', '/test');
        } catch (UnreachableException $e) {
        }
        $elapsed = microtime(true) - $start;

        $this->assertGreaterThan(1.5, $elapsed, 'After reset should take at least ~2s');
        $this->assertLessThan(2.5, $elapsed, 'After reset should take at most ~2s (not ~6s)');
    }

    // GuzzleHttpClient retry_count resets to 0 after successful request.
    public function testGuzzleRetryCountResets(): void
    {
        if (!class_exists('\GuzzleHttp\Client')) {
            $this->markTestSkipped('Guzzle is not installed. Install guzzlehttp/guzzle to run this test.');
        }

        $badHost = self::NON_ROUTABLE_IP;
        $goodHostFull = 'http://'.getTestServerHost();

        // create wrapper with bad host, fail twice to increment retry_count
        [$wrapper, $clusterHosts] = $this->createApiWrapperWithClusterHosts(
            new GuzzleHttpClient(),
            [$badHost]
        );

        for ($i = 0; $i < 2; ++$i) {
            try {
                $wrapper->send('GET', '/test');
            } catch (UnreachableException $e) {
            }
        }

        $badHostRetryCount = $clusterHosts->getRetryCount($badHost, false);
        $this->assertEquals(2, $badHostRetryCount, 'Bad host should have retry_count=2');

        // create wrapper with good host, copy retry_count from bad host
        [$wrapper, $clusterHosts] = $this->createApiWrapperWithClusterHostsFullHost(
            new GuzzleHttpClient(),
            [$goodHostFull]
        );
        $clusterHosts->setRetryCount($goodHostFull, $badHostRetryCount, false);

        // verify setRetryCount actually worked
        $this->assertEquals(
            2,
            $clusterHosts->getRetryCount($goodHostFull, false),
            'setRetryCount should have set retry_count to 2'
        );

        // make successful request
        $response = $wrapper->send('GET', '/1/test/instant');
        $this->assertIsArray($response);

        // verify retry_count was reset
        $this->assertEquals(
            0,
            $clusterHosts->getRetryCount($goodHostFull, false),
            'retry_count should reset to 0 after success'
        );

        // now point back to bad host and verify timeout is ~2s (not ~6s)
        [$wrapper, $clusterHosts] = $this->createApiWrapperWithClusterHosts(
            new GuzzleHttpClient(),
            [$badHost]
        );

        $start = microtime(true);

        try {
            $wrapper->send('GET', '/test');
        } catch (UnreachableException $e) {
        }
        $elapsed = microtime(true) - $start;

        $this->assertGreaterThan(1.5, $elapsed, 'After reset should take at least ~2s');
        $this->assertLessThan(2.5, $elapsed, 'After reset should take at most ~2s (not ~6s)');
    }

    private function createApiWrapperWithClusterHosts($httpClient, array $hosts): array
    {
        $config = SearchConfig::create('test-app-id', 'test-api-key')
            ->setConnectTimeout(self::CONNECT_TIMEOUT_SECONDS)
        ;

        $clusterHosts = ClusterHosts::create($hosts);
        $requestOptionsFactory = new RequestOptionsFactory($config);

        $wrapper = new ApiWrapper(
            $httpClient,
            $config,
            $clusterHosts,
            $requestOptionsFactory
        );

        return [$wrapper, $clusterHosts];
    }

    private function createApiWrapperWithClusterHostsFullHost($httpClient, array $hosts): array
    {
        $config = SearchConfig::create('test-app-id', 'test-api-key')
            ->setConnectTimeout(self::CONNECT_TIMEOUT_SECONDS)
            ->setFullHosts($hosts)
        ;

        $clusterHosts = ClusterHosts::create($hosts);
        $requestOptionsFactory = new RequestOptionsFactory($config);

        $wrapper = new ApiWrapper(
            $httpClient,
            $config,
            $clusterHosts,
            $requestOptionsFactory
        );

        return [$wrapper, $clusterHosts];
    }
}
