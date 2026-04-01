<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptions;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * @internal
 *
 * @coversNothing
 */
class RequestOptionsTest extends TestCase
{
    public function testSearchSingleIndexWithRequestOptionsObject(): void
    {
        $mockHttp = new class implements HttpClientInterface {
            public ?RequestInterface $capturedRequest = null;

            public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
            {
                $this->capturedRequest = $request;

                return new Response(200, ['Content-Type' => 'application/json'], '{"hits":[],"nbHits":0}');
            }
        };

        $config = SearchConfig::create('test-app-id', 'test-api-key')
            ->setFullHosts(['http://localhost:9999'])
        ;

        $client = new SearchClient(
            new ApiWrapper($mockHttp, $config, ClusterHosts::create(['http://localhost:9999']), new RequestOptionsFactory($config)),
            $config
        );

        $requestOptions = new RequestOptions([
            'headers' => ['x-custom-header' => 'custom-value'],
            'queryParameters' => ['extra' => 'param'],
            'body' => [],
            'readTimeout' => 10,
            'writeTimeout' => 20,
            'connectTimeout' => 5,
        ]);

        $client->searchSingleIndex('my-index', ['query' => 'test'], $requestOptions);

        $this->assertNotNull($mockHttp->capturedRequest, 'HTTP request should have been made');
        $this->assertEquals('custom-value', $mockHttp->capturedRequest->getHeader('x-custom-header')[0]);
        $this->assertStringContainsString('extra=param', (string) $mockHttp->capturedRequest->getUri());
    }
}
