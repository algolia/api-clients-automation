<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Exceptions\AlgoliaException;
use Algolia\AlgoliaSearch\Exceptions\BadRequestException;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Contract tests for the HTTP 429 wait-and-retry round: how `Retry-After` is parsed, how the
 * `maxRateLimitRetries` budget is spent, and the guarantee that a rate-limited host is retried
 * in place rather than failed over or marked down.
 *
 * @internal
 *
 * @coversNothing
 */
class RateLimitRetryTest extends TestCase
{
    private const HOSTS = ['host-one.test', 'host-two.test'];

    private const JSON_BODY = '{"message":"Too many requests"}';

    private const HTML_BODY = '<html><body>429 Too Many Requests</body></html>';

    public function testRetryAfterIsHonoredOnlyAsPositiveWholeSeconds(): void
    {
        $cases = [
            'whole seconds' => [['Retry-After' => '2'], 2000000],
            'lowercase header name' => [['retry-after' => '5'], 5000000],
            'no upper bound' => [['Retry-After' => '86400'], 86400000000],
            'missing header' => [[], 1000000],
            'empty value' => [['Retry-After' => ''], 1000000],
            'zero' => [['Retry-After' => '0'], 1000000],
            'negative' => [['Retry-After' => '-5'], 1000000],
            'fractional' => [['Retry-After' => '1.5'], 1000000],
            'trailing junk' => [['Retry-After' => '120abc'], 1000000],
            'http date' => [['Retry-After' => 'Wed, 21 Oct 2015 07:28:00 GMT'], 1000000],
        ];

        $parse = new \ReflectionMethod(ApiWrapper::class, 'rateLimitWaitMicroseconds');
        $apiWrapper = $this->apiWrapper($this->recorder(function () {
            return new Response(200, [], '{}');
        }));

        foreach ($cases as $label => [$headers, $expected]) {
            $this->assertSame(
                $expected,
                $parse->invoke($apiWrapper, new Response(429, $headers, self::JSON_BODY)),
                $label
            );
        }
    }

    public function testWaitsThenRetriesTheSameHostWithoutMarkingItDown(): void
    {
        $http = $this->recorder(function ($call) {
            return 1 === $call
                ? new Response(429, [], self::JSON_BODY)
                : new Response(200, [], '{"message":"ok rate limit retry"}');
        });
        $clusterHosts = ClusterHosts::create(self::HOSTS);

        $startTime = microtime(true);
        $res = $this->searchClient($http, $clusterHosts, 1)->customGet('1/test');
        $elapsed = microtime(true) - $startTime;

        $this->assertSame(['message' => 'ok rate limit retry'], $res);
        $this->assertGreaterThanOrEqual(1.0, $elapsed);
        $this->assertSame(['host-one.test', 'host-one.test'], $this->sentHosts($http));
        $this->assertSame(self::HOSTS, $clusterHosts->read());
        $this->assertSame(0, $clusterHosts->getRetryCount('host-one.test', true));
        $this->assertCount(1, array_unique($http->connectTimeouts));
    }

    public function testSpentBudgetSurfacesTheApiErrorWithoutFailingOver(): void
    {
        $http = $this->recorder(function () {
            return new Response(429, ['Retry-After' => '1'], self::JSON_BODY);
        });
        $clusterHosts = ClusterHosts::create(self::HOSTS);

        try {
            $this->searchClient($http, $clusterHosts, 1)->customGet('1/test');
            $this->fail('Expected BadRequestException to be thrown');
        } catch (BadRequestException $e) {
            $this->assertSame('Too many requests', $e->getMessage());
            $this->assertSame(429, $e->getCode());
        }

        $this->assertSame(['host-one.test', 'host-one.test'], $this->sentHosts($http));
        $this->assertSame(self::HOSTS, $clusterHosts->read());
        $this->assertSame(0, $clusterHosts->getRetryCount('host-one.test', true));
    }

    public function testHtmlBodyStillSurfacesOnceTheBudgetIsSpent(): void
    {
        $http = $this->recorder(function () {
            return new Response(429, ['Content-Type' => 'text/html'], self::HTML_BODY, '1.1', '');
        });

        try {
            $this->searchClient($http, ClusterHosts::create(self::HOSTS), 1)->customGet('1/test');
            $this->fail('Expected AlgoliaException to be thrown');
        } catch (AlgoliaException $e) {
            $this->assertSame('429: Too Many Requests', $e->getMessage());
        }

        $this->assertCount(2, $http->requests);
    }

    public function testZeroFailsOnTheFirst429WithoutWaiting(): void
    {
        $http = $this->recorder(function () {
            return new Response(429, ['Retry-After' => '30'], self::JSON_BODY);
        });

        $startTime = microtime(true);

        try {
            $this->searchClient($http, ClusterHosts::create(self::HOSTS), 0)->customGet('1/test');
            $this->fail('Expected BadRequestException to be thrown');
        } catch (BadRequestException $e) {
            $this->assertSame('Too many requests', $e->getMessage());
        }

        $this->assertLessThan(1.0, microtime(true) - $startTime);
        $this->assertSame(['host-one.test'], $this->sentHosts($http));
    }

    public function testTheDefaultBudgetIsThree(): void
    {
        $this->assertSame(3, SearchConfig::create('test-app-id', 'test-api-key')->getMaxRateLimitRetries());
    }

    private function recorder(callable $responder)
    {
        return new class($responder) implements HttpClientInterface {
            /**
             * @var RequestInterface[]
             */
            public $requests = [];

            /**
             * @var array
             */
            public $connectTimeouts = [];

            private $responder;

            public function __construct(callable $responder)
            {
                $this->responder = $responder;
            }

            public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
            {
                $this->requests[] = $request;
                $this->connectTimeouts[] = $connectTimeout;
                $responder = $this->responder;

                return $responder(count($this->requests));
            }
        };
    }

    /**
     * @param mixed $http
     *
     * @return string[] the host every recorded request was sent to
     */
    private function sentHosts($http)
    {
        return array_map(function (RequestInterface $request) {
            return $request->getUri()->getHost();
        }, $http->requests);
    }

    private function apiWrapper(HttpClientInterface $http): ApiWrapper
    {
        $config = SearchConfig::create('test-app-id', 'test-api-key');

        return new ApiWrapper($http, $config, ClusterHosts::create(self::HOSTS), new RequestOptionsFactory($config));
    }

    private function searchClient(HttpClientInterface $http, ClusterHosts $clusterHosts, int $maxRateLimitRetries): SearchClient
    {
        $config = SearchConfig::create('test-app-id', 'test-api-key')->setMaxRateLimitRetries($maxRateLimitRetries);

        return new SearchClient(
            new ApiWrapper($http, $config, $clusterHosts, new RequestOptionsFactory($config)),
            $config
        );
    }
}
