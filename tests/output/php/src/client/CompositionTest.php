<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Test\Client;

use Algolia\AlgoliaSearch\Api\CompositionClient;
use Algolia\AlgoliaSearch\Configuration\CompositionConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use PHPUnit\Framework\Attributes\CoversClass;
use PHPUnit\Framework\Attributes\TestDox;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Client tests for CompositionClient.
 *
 * @internal
 */
#[CoversClass(CompositionClient::class)]
class CompositionTest extends TestCase implements HttpClientInterface
{
    public const APP_ID = 'test-app-id';
    public const API_KEY = 'test-api-key';

    private $recordedRequest;

    public function sendRequest(RequestInterface $request, $timeout, $connectTimeout): Response
    {
        $this->recordedRequest = [
            'request' => $request,
            'responseTimeout' => $timeout * 1000,
            'connectTimeout' => $connectTimeout * 1000,
        ];

        return new Response(200, [], '{}');
    }

    #[TestDox('calls api with correct read host')]
    public function test0api(): void
    {
        $client = $this->createClient(
            'test-app-id',
            'test-api-key'
        );
        $this->assertIsObject($client);
        $client->search(
            'test-composition-id',
            [],
        );
        $this->assertEquals(
            'test-app-id-dsn.algolia.net',
            $this->recordedRequest['request']->getUri()->getHost()
        );
    }

    #[TestDox('calls api with correct write host')]
    public function test1api(): void
    {
        $client = $this->createClient(
            'test-app-id',
            'test-api-key'
        );
        $this->assertIsObject($client);
        $client->search(
            'test-composition-id',
            [],
        );
        $this->assertEquals(
            'test-app-id-dsn.algolia.net',
            $this->recordedRequest['request']->getUri()->getHost()
        );
    }

    /**
     * @param mixed $appId
     * @param mixed $apiKey
     */
    private function createClient($appId, $apiKey): CompositionClient
    {
        $config = CompositionConfig::create($appId, $apiKey);
        $clusterHosts = CompositionClient::getClusterHosts($config);
        $api = new ApiWrapper($this, $config, $clusterHosts);

        return new CompositionClient($api, $config);
    }
}
