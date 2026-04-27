<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\Model\Search\OperationIndexParams;
use Algolia\AlgoliaSearch\Model\Search\OperationType;
use Algolia\AlgoliaSearch\Model\Search\ScopeType;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Regression test for https://github.com/algolia/algoliasearch-client-php/issues/759
 *
 * operationIndex() advertises array|OperationIndexParams but passing a model
 * object triggered a TypeError in ApiWrapper::request() because array_merge()
 * received the unserialized object.
 *
 * @internal
 *
 * @coversNothing
 */
class OperationIndexModelTest extends TestCase
{
    private function makeClient(): array
    {
        $mockHttp = new class implements HttpClientInterface {
            public ?RequestInterface $capturedRequest = null;

            public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
            {
                $this->capturedRequest = $request;

                return new Response(200, ['Content-Type' => 'application/json'], '{"taskID":1,"updatedAt":"2024-01-01T00:00:00Z"}');
            }
        };

        $config = SearchConfig::create('test-app-id', 'test-api-key');
        $client = new SearchClient(
            new ApiWrapper($mockHttp, $config, ClusterHosts::create('127.0.0.1'), new RequestOptionsFactory($config)),
            $config
        );

        return [$client, $mockHttp];
    }

    public function testOperationIndexWithModelObjectDoesNotThrow(): void
    {
        [$client, $mockHttp] = $this->makeClient();

        $client->operationIndex(
            'my_index',
            (new OperationIndexParams())
                ->setOperation(OperationType::COPY)
                ->setDestination('my_index_temp')
                ->setScope([ScopeType::SETTINGS, ScopeType::SYNONYMS, ScopeType::RULES])
        );

        $this->assertNotNull($mockHttp->capturedRequest);
        $body = json_decode($mockHttp->capturedRequest->getBody()->getContents(), true);
        $this->assertEquals('copy', $body['operation']);
        $this->assertEquals('my_index_temp', $body['destination']);
        $this->assertEquals(['settings', 'synonyms', 'rules'], $body['scope']);
    }

    public function testOperationIndexWithArrayProducesSameBodyAsModelObject(): void
    {
        [$clientModel, $mockModel] = $this->makeClient();
        [$clientArray, $mockArray] = $this->makeClient();

        $clientModel->operationIndex(
            'my_index',
            (new OperationIndexParams())
                ->setOperation(OperationType::COPY)
                ->setDestination('my_index_temp')
                ->setScope([ScopeType::SETTINGS, ScopeType::SYNONYMS, ScopeType::RULES])
        );

        $clientArray->operationIndex(
            'my_index',
            [
                'operation' => 'copy',
                'destination' => 'my_index_temp',
                'scope' => ['settings', 'synonyms', 'rules'],
            ]
        );

        $this->assertEquals(
            $mockArray->capturedRequest->getBody()->getContents(),
            $mockModel->capturedRequest->getBody()->getContents()
        );
    }
}
