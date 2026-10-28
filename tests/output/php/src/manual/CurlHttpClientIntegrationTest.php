<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Http\CurlHttpClient;
use Algolia\AlgoliaSearch\Http\Psr7\Request;
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
}
