<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Exceptions\RetriableException;
use Algolia\AlgoliaSearch\Exceptions\TimeoutException;
use Algolia\AlgoliaSearch\Exceptions\UnreachableException;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Contract test for UnreachableException raised on retry exhaustion:
 * the message names the last failing host, getPrevious() chains the last
 * underlying error, and getErrors() lists every attempt.
 *
 * @internal
 *
 * @coversNothing
 */
class UnreachableExceptionTest extends TestCase
{
    private const HOSTS = ['host-one.test', 'host-two.test'];

    public function testExhaustedRetriesExposeLastRetriableError(): void
    {
        $mockHttp = new class implements HttpClientInterface {
            public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
            {
                return new Response(500, [], '{}');
            }
        };

        try {
            $this->makeClient($mockHttp)->customGet('1/test');
            $this->fail('Expected UnreachableException to be thrown');
        } catch (UnreachableException $e) {
            $errors = $e->getErrors();
            $this->assertCount(count(self::HOSTS), $errors);
            foreach ($errors as $entry) {
                $this->assertContains($entry['host'], self::HOSTS);
                $this->assertInstanceOf(RetriableException::class, $entry['error']);
            }

            $last = end($errors);
            $this->assertSame($last['error'], $e->getPrevious());
            $this->assertSame(500, $e->getCode());
            $this->assertStringStartsWith('Unreachable hosts.', $e->getMessage());
            $this->assertStringEndsWith(
                'Last error for '.$last['host'].': '.$last['error']->getMessage(),
                $e->getMessage()
            );
        }
    }

    public function testExhaustedRetriesChainTimeoutError(): void
    {
        $mockHttp = new class implements HttpClientInterface {
            public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
            {
                throw new TimeoutException('Connection timed out');
            }
        };

        try {
            $this->makeClient($mockHttp)->customGet('1/test');
            $this->fail('Expected UnreachableException to be thrown');
        } catch (UnreachableException $e) {
            $this->assertInstanceOf(TimeoutException::class, $e->getPrevious());

            $errors = $e->getErrors();
            $last = end($errors);
            $this->assertSame($last['error'], $e->getPrevious());
            $this->assertStringEndsWith(
                'Last error for '.$last['host'].': Connection timed out',
                $e->getMessage()
            );
        }
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
