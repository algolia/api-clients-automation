<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Test\Client;

use Algolia\AlgoliaSearch\Api\IngestionClient;
use Algolia\AlgoliaSearch\Configuration\IngestionConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use PHPUnit\Framework\Attributes\CoversClass;
use PHPUnit\Framework\Attributes\TestDox;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Client tests for IngestionClient.
 *
 * @internal
 */
#[CoversClass(IngestionClient::class)]
class IngestionTest extends TestCase implements HttpClientInterface
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

    #[TestDox('can handle HTML error')]
    public function test0api(): void
    {
        $client = IngestionClient::createWithConfig(IngestionConfig::create('test-app-id', 'test-api-key', 'us')->setFullHosts(['http://'.('true' == getenv('CI') ? 'localhost' : 'host.docker.internal').':6676']));

        try {
            $res = $client->customGet(
                '1/html-error',
            );
            $this->fail('Expected exception to be thrown');
        } catch (\Exception $e) {
            $this->assertEquals($e->getMessage(), '429: Too Many Requests');
        }
    }

    #[TestDox('calls api with default read timeouts')]
    public function test1api(): void
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->customGet(
            '1/test',
        );
        $this->assertEquals(
            25000,
            $this->recordedRequest['connectTimeout']
        );

        $this->assertEquals(
            25000,
            $this->recordedRequest['responseTimeout']
        );
    }

    #[TestDox('calls api with default write timeouts')]
    public function test2api(): void
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->customPost(
            '1/test',
        );
        $this->assertEquals(
            25000,
            $this->recordedRequest['connectTimeout']
        );

        $this->assertEquals(
            25000,
            $this->recordedRequest['responseTimeout']
        );
    }

    #[TestDox('can leave call opened for a long time')]
    public function test3api(): void
    {
        $client = IngestionClient::createWithConfig(IngestionConfig::create('test-app-id', 'test-api-key', 'us')->setFullHosts(['http://'.('true' == getenv('CI') ? 'localhost' : 'host.docker.internal').':6676']));

        $res = $client->customGet(
            '1/long-wait',
        );
        $this->assertEquals(
            '{"message":"OK"}',
            json_encode($res)
        );
    }

    #[TestDox('endpoint level timeout')]
    public function test4api(): void
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->validateSourceBeforeUpdate(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );
        $this->assertEquals(
            180000,
            $this->recordedRequest['connectTimeout']
        );

        $this->assertEquals(
            180000,
            $this->recordedRequest['responseTimeout']
        );
    }

    #[TestDox('can override endpoint level timeout')]
    public function test5api(): void
    {
        $client = $this->createClient(self::APP_ID, self::API_KEY);
        $client->validateSourceBeforeUpdate(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
            [
                'writeTimeout' => 3456 / 1000,
            ]
        );
        $this->assertEquals(
            180000,
            $this->recordedRequest['connectTimeout']
        );

        $this->assertEquals(
            3456,
            $this->recordedRequest['responseTimeout']
        );
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
                '/^Algolia for PHP \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Ingestion (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/',
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
                '/^Algolia for PHP \(4.18.4\).*/',
                $this->recordedRequest['request']->getHeader('User-Agent')[0]
            )
        );
    }

    #[TestDox('uses the correct region')]
    public function test0parameters(): void
    {
        $client = $this->createClient(
            'my-app-id',
            'my-api-key',
            'us'
        );
        $this->assertIsObject($client);
        $client->getSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );
        $this->assertEquals(
            'data.us.algolia.com',
            $this->recordedRequest['request']->getUri()->getHost()
        );
    }

    #[TestDox('throws when incorrect region is given')]
    public function test1parameters(): void
    {
        try {
            $client = $this->createClient(
                'my-app-id',
                'my-api-key',
                'not_a_region'
            );

            $this->fail('Expected exception to be thrown');
        } catch (\Exception $e) {
            $this->assertEquals($e->getMessage(), '`region` is required and must be one of the following: eu, us');
        }
    }

    #[TestDox('switch API key')]
    public function test0setClientApiKey(): void
    {
        $client = IngestionClient::createWithConfig(IngestionConfig::create('test-app-id', 'test-api-key', 'us')->setFullHosts(['http://'.('true' == getenv('CI') ? 'localhost' : 'host.docker.internal').':6683']));

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
     * @param mixed $region
     */
    private function createClient($appId, $apiKey, $region = 'us'): IngestionClient
    {
        $config = IngestionConfig::create($appId, $apiKey, $region);
        $clusterHosts = IngestionClient::getClusterHosts($config);
        $api = new ApiWrapper($this, $config, $clusterHosts);

        return new IngestionClient($api, $config);
    }
}
