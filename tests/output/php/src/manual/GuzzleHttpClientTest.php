<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Exceptions\TimeoutException;
use Algolia\AlgoliaSearch\Http\GuzzleHttpClient;
use Algolia\AlgoliaSearch\Http\Psr7\Request;
use GuzzleHttp\Client as GuzzleClient;
use GuzzleHttp\ClientInterface;
use GuzzleHttp\Exception\ConnectException;
use GuzzleHttp\Exception\ConnectTimeoutException;
use GuzzleHttp\Exception\HandlerClosedException;
use GuzzleHttp\Exception\NetworkException;
use GuzzleHttp\Exception\NetworkTimeoutException;
use GuzzleHttp\Exception\RequestException;
use GuzzleHttp\Exception\ResponseTimeoutException;
use GuzzleHttp\Exception\ServerException;
use GuzzleHttp\Handler\MockHandler;
use GuzzleHttp\HandlerStack;
use GuzzleHttp\Psr7\Response as GuzzleResponse;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * @internal
 *
 * @coversNothing
 */
class GuzzleHttpClientTest extends TestCase
{
    /**
     * @dataProvider timeoutTransferFailures
     */
    public function testTransferFailuresAreRaisedAsTimeouts(\Throwable $failure, string $expectedMessage): void
    {
        $this->expectException(TimeoutException::class);
        $this->expectExceptionMessage($expectedMessage);

        $this->transportFailingWith($failure)->sendRequest(self::request(), 5, 2);
    }

    public static function timeoutTransferFailures(): iterable
    {
        $request = self::request();

        if (8 > ClientInterface::MAJOR_VERSION) {
            yield 'curl timeout (errno 28)' => [new ConnectException('cURL error 28: operation timed out', $request, null, ['errno' => CURLE_OPERATION_TIMEDOUT]), 'Connection timed out'];

            return;
        }

        yield 'connect timeout' => [new ConnectTimeoutException('connect timed out', $request), 'Connection timed out'];

        yield 'network timeout before headers' => [new NetworkTimeoutException('operation timed out', $request), 'Connection timed out'];

        yield 'read timeout after headers' => [new ResponseTimeoutException('operation timed out', $request, new GuzzleResponse(200, [], '{"hits":[')), 'Connection timed out'];

        yield 'handler closed mid-transfer' => [new HandlerClosedException('handler closed', $request), 'handler closed'];
    }

    /**
     * A host that cannot be reached is not a timeout: it comes back as a status 0 response, which
     * the retry strategy treats as an unreachable host and marks down.
     *
     * @dataProvider unreachableTransferFailures
     */
    public function testUnreachableHostsReturnAStatusZeroResponse(\Throwable $failure, string $expectedReason): void
    {
        $response = $this->transportFailingWith($failure)->sendRequest(self::request(), 5, 2);

        $this->assertSame(0, $response->getStatusCode());
        $this->assertSame($expectedReason, $response->getReasonPhrase());
    }

    public static function unreachableTransferFailures(): iterable
    {
        $request = self::request();

        yield 'connection refused' => [new ConnectException('connection refused', $request), 'connection refused'];

        if (8 > ClientInterface::MAJOR_VERSION) {
            return;
        }

        yield 'network failure before headers' => [new NetworkException('connection reset by peer', $request), 'connection reset by peer'];
    }

    public function testFailuresCarryingAResponseReturnThatResponse(): void
    {
        $failure = new ServerException('service unavailable', self::request(), new GuzzleResponse(503, [], 'unavailable'));

        $response = $this->transportFailingWith($failure)->sendRequest(self::request(), 5, 2);

        $this->assertSame(503, $response->getStatusCode());
        $this->assertSame('unavailable', (string) $response->getBody());
    }

    public function testFailuresWithoutAResponseReturnAStatusZeroResponse(): void
    {
        $failure = new RequestException('could not create the response', self::request());

        $response = $this->transportFailingWith($failure)->sendRequest(self::request(), 5, 2);

        $this->assertSame(0, $response->getStatusCode());
        $this->assertSame('could not create the response', $response->getReasonPhrase());
    }

    private static function request(): RequestInterface
    {
        return new Request('GET', 'http://localhost/1/indexes/test/query');
    }

    private function transportFailingWith(\Throwable $failure): GuzzleHttpClient
    {
        return new GuzzleHttpClient(new GuzzleClient(['handler' => new HandlerStack(new MockHandler([$failure]))]));
    }
}
