<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Exceptions\RetriableException;
use Algolia\AlgoliaSearch\Exceptions\TimeoutException;
use Algolia\AlgoliaSearch\Exceptions\UnreachableException;
use Algolia\AlgoliaSearch\Http\CurlHttpClient;
use Algolia\AlgoliaSearch\Http\Psr7\Request;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\Attributes\DataProvider;
use PHPUnit\Framework\TestCase;

function getCurlTestServerHost(): string
{
    return ('true' === getenv('CI') ? 'localhost' : 'host.docker.internal').':6676';
}

/**
 * @internal
 *
 * @coversNothing
 */
class CurlHttpClientIntegrationTest extends TestCase
{
    public function testResponseHeadersSurviveTheWire(): void
    {
        $response = (new CurlHttpClient())->sendRequest(
            new Request('GET', 'http://'.getCurlTestServerHost().'/1/test/repeated-headers'),
            5,
            5
        );

        $this->assertSame(200, $response->getStatusCode());
        $this->assertSame(['a=1', 'b=2'], $response->getHeader('set-cookie'));
        $this->assertSame('https://host.test:8080/path', $response->getHeaderLine('x-colon-value'));
        $this->assertFalse($response->hasHeader('link'), 'headers of the 103 interim response must not leak into the final response');
    }

    #[DataProvider('fractionalTimeoutProvider')]
    public function testFractionalTimeoutIsNotTruncated(float $timeout, int $delayMs, float $minElapsed, float $maxElapsed): void
    {
        $start = microtime(true);

        try {
            (new CurlHttpClient())->sendRequest(
                new Request('GET', 'http://'.getCurlTestServerHost().'/1/test/delayed-headers/'.$delayMs),
                $timeout,
                2
            );
            $this->fail('the request should time out after '.$timeout.'s');
        } catch (TimeoutException $e) {
        }

        $elapsed = microtime(true) - $start;
        $this->assertGreaterThan($minElapsed, $elapsed, 'timed out too early, the timeout was truncated');
        $this->assertLessThan($maxElapsed, $elapsed, 'timed out too late');
    }

    public static function fractionalTimeoutProvider(): array
    {
        // [timeout, server delay in ms, min elapsed, max elapsed], with a connect timeout >= 1s
        return [
            'sub-second timeout' => [0.5, 3000, 0.4, 1.0],
            'fractional timeout above 1s' => [1.5, 2500, 1.4, 2.0],
        ];
    }

    #[DataProvider('methodProvider')]
    public function testMethodAndBodySurviveTheWire(string $method, ?string $body, string $expectedBody): void
    {
        $response = (new CurlHttpClient())->sendRequest(
            new Request($method, 'http://'.getCurlTestServerHost().'/1/test/echo', ['Content-Type' => 'application/json'], $body),
            5,
            5
        );

        $this->assertSame(200, $response->getStatusCode());
        $this->assertSame(
            ['method' => $method, 'body' => $expectedBody],
            json_decode((string) $response->getBody(), true)
        );
    }

    public static function methodProvider(): array
    {
        return [
            'GET' => ['GET', null, ''],
            'DELETE' => ['DELETE', null, ''],
            'POST' => ['POST', '{"a":1}', '{"a":1}'],
            'PUT' => ['PUT', '{"a":1}', '{"a":1}'],
            'PATCH' => ['PATCH', '{"enabled":false}', '{"enabled":false}'],
            'POST without body' => ['POST', null, ''],
        ];
    }

    // The connection failure tests need no server: port 1 on the loopback refuses connections,
    // and `.invalid` never resolves (RFC 6761). curl_multi only reports these failures through
    // curl_multi_info_read(), so they must come back as an unreachable host, not as a timeout.
    #[DataProvider('unreachableUrlProvider')]
    public function testUnreachableHostReturnsAStatusZeroResponse(string $url, string $expectedReason): void
    {
        $response = (new CurlHttpClient())->sendRequest(new Request('GET', $url), 2, 2);

        $this->assertSame(0, $response->getStatusCode());
        $this->assertStringContainsString($expectedReason, $response->getReasonPhrase());
    }

    public static function unreachableUrlProvider(): array
    {
        return [
            'connection refused' => ['http://127.0.0.1:1/', 'Failed to connect'],
            'unknown host' => ['http://no-such-host.invalid/', 'Could not resolve host'],
        ];
    }

    public function testUnreachableHostIsMarkedDownInsteadOfTimedOut(): void
    {
        // only one host is tried, so the other one stays up and the collection is not reset
        $clusterHosts = ClusterHosts::create(['host-one.invalid', 'host-two.invalid']);
        $config = SearchConfig::create('test-app-id', 'test-api-key');
        $wrapper = new ApiWrapper(new CurlHttpClient(), $config, $clusterHosts, new RequestOptionsFactory($config));

        try {
            $wrapper->send('GET', '/1/test', [], 'host-one.invalid');
            $this->fail('Expected UnreachableException to be thrown');
        } catch (UnreachableException $e) {
            $errors = $e->getErrors();
            $this->assertCount(1, $errors);
            $this->assertInstanceOf(RetriableException::class, $errors[0]['error']);
            $this->assertStringContainsString('Could not resolve host', $errors[0]['error']->getMessage());
        }

        $this->assertSame(['host-two.invalid'], $clusterHosts->read());
        // a timed out host would stay up with its retry count bumped
        $this->assertSame(0, $clusterHosts->getRetryCount('host-one.invalid', true));
    }
}
