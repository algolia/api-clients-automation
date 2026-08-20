<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Http\CurlHttpClient;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use PHPUnit\Framework\TestCase;

/**
 * Contract tests for the curl transport's response-header capture.
 *
 * @internal
 *
 * @coversNothing
 */
class CurlHttpClientTest extends TestCase
{
    public function testRepeatedHeadersAccumulateInOrder(): void
    {
        $headers = $this->parse([
            "HTTP/1.1 200 OK\r\n",
            "Set-Cookie: a=1\r\n",
            "Set-Cookie: b=2\r\n",
            "\r\n",
        ]);

        $this->assertSame(['Set-Cookie' => ['a=1', 'b=2']], $headers);
        $this->assertSame(['a=1', 'b=2'], (new Response(200, $headers))->getHeader('set-cookie'));
    }

    public function testAStatusLineDropsTheHeadersOfThePriorResponse(): void
    {
        $headers = $this->parse([
            "HTTP/1.1 301 Moved Permanently\r\n",
            "Location: https://moved.test\r\n",
            "\r\n",
            "HTTP/1.1 200 OK\r\n",
            "Correlation-ID: abc\r\n",
            "\r\n",
        ]);

        $this->assertSame(['Correlation-ID' => ['abc']], $headers);
    }

    public function testValuesAreSplitOnTheFirstColonAndTrimmed(): void
    {
        $headers = $this->parse(["Link: <https://host.test/a>; rel=\"next\"\r\n"]);

        $this->assertSame(['Link' => ['<https://host.test/a>; rel="next"']], $headers);
    }

    /**
     * @param string[] $lines
     *
     * @return array<string, string[]>
     */
    private function parse(array $lines)
    {
        $headers = [];

        foreach ($lines as $line) {
            $headers = CurlHttpClient::parseHeaderLine($headers, $line);
        }

        return $headers;
    }
}
