<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Test\Client;

use Algolia\AlgoliaSearch\Api\MonitoringClient;
use Algolia\AlgoliaSearch\Configuration\MonitoringConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use PHPUnit\Framework\Attributes\CoversClass;
use PHPUnit\Framework\Attributes\TestDox;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Client tests for MonitoringClient.
 *
 * @internal
 */
#[CoversClass(MonitoringClient::class)]
class MonitoringTest extends TestCase implements HttpClientInterface
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

    #[TestDox('calls api with correct user agent')]
    public function test0commonApi(): void
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->customPost(
            '1/test',
        );
        $this->assertTrue(
            (bool) preg_match(
                '/^Algolia for PHP \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Monitoring (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/',
                $this->recordedRequest['request']->getHeader('User-Agent')[0]
            )
        );
    }

    #[TestDox('the user agent contains the latest version')]
    public function test1commonApi(): void
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->customPost(
            '1/test',
        );
        $this->assertTrue(
            (bool) preg_match(
                '/^Algolia for PHP \(4.6.3\).*/',
                $this->recordedRequest['request']->getHeader('User-Agent')[0]
            )
        );
    }

    #[TestDox('calls api with default read timeouts')]
    public function test2commonApi(): void
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->customGet(
            '1/test',
        );
        $this->assertEquals(
            2000,
            $this->recordedRequest['connectTimeout']
        );

        $this->assertEquals(
            5000,
            $this->recordedRequest['responseTimeout']
        );
    }

    #[TestDox('calls api with default write timeouts')]
    public function test3commonApi(): void
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->customPost(
            '1/test',
        );
        $this->assertEquals(
            2000,
            $this->recordedRequest['connectTimeout']
        );

        $this->assertEquals(
            30000,
            $this->recordedRequest['responseTimeout']
        );
    }

    #[TestDox('use the correct host')]
    public function test0parameters(): void
    {
        $client = $this->createClient(
            'my-app-id',
            'my-api-key'
        );
        $this->assertIsObject($client);
        $client->customDelete(
            'test',
        );
        $this->assertEquals(
            'status.algolia.com',
            $this->recordedRequest['request']->getUri()->getHost()
        );
    }

    #[TestDox('switch API key')]
    public function test0setClientApiKey(): void
    {
        $client = MonitoringClient::createWithConfig(MonitoringConfig::create('test-app-id', 'test-api-key')->setFullHosts(['http://'.('true' == getenv('CI') ? 'localhost' : 'host.docker.internal').':6683']));

        $res = $client->customGet(
            'check-api-key/1',
        );
        $this->assertEquals(
            '{"headerAPIKeyValue":"test-api-key"}',
            json_encode($res)
        );

        $client->setClientApiKey(
            'updated-api-key',
        );

        $res = $client->customGet(
            'check-api-key/2',
        );
        $this->assertEquals(
            '{"headerAPIKeyValue":"updated-api-key"}',
            json_encode($res)
        );
    }

    /**
     * @param mixed $appId
     * @param mixed $apiKey
     */
    private function createClient($appId, $apiKey): MonitoringClient
    {
        $config = MonitoringConfig::create($appId, $apiKey);
        $clusterHosts = MonitoringClient::getClusterHosts($config);
        $api = new ApiWrapper($this, $config, $clusterHosts);

        return new MonitoringClient($api, $config);
    }
}
