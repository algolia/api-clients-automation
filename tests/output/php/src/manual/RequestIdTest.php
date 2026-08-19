<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Api\IngestionClient;
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\IngestionConfig;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Exceptions\BadRequestException;
use Algolia\AlgoliaSearch\Exceptions\UnreachableException;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptions;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use Algolia\AlgoliaSearch\Support\RequestId;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Contract tests for the Request-ID tracing header and the Correlation-ID surfaced on errors.
 *
 * @internal
 *
 * @coversNothing
 */
class RequestIdTest extends TestCase
{
    private const HOSTS = ['host-one.test', 'host-two.test', 'host-three.test'];

    private const FORMAT = '/^[0-9A-Za-z]{11}$/';

    public function testEachCallMintsAFreshWellFormedRequestId(): void
    {
        $http = $this->recorder();
        $client = $this->searchClient($http);

        $client->customGet('1/test');
        $client->customGet('1/test');

        $ids = $this->sentRequestIds($http);
        $this->assertCount(2, $ids);
        foreach ($ids as $id) {
            $this->assertMatchesRegularExpression(self::FORMAT, $id);
        }
        $this->assertNotSame($ids[0], $ids[1]);
    }

    public function testTheRequestIdIsStableAcrossHostFallback(): void
    {
        $http = $this->recorder([
            new Response(500, [], '{"message":"boom"}'),
            new Response(500, [], '{"message":"boom"}'),
        ]);

        $this->searchClient($http)->customGet('1/test');

        $ids = $this->sentRequestIds($http);
        $this->assertCount(3, $ids);
        $this->assertMatchesRegularExpression(self::FORMAT, $ids[0]);
        $this->assertCount(1, array_unique($ids));
    }

    public function testACallerSuppliedHeaderIsNeverOverwritten(): void
    {
        $http = $this->recorder();

        $this->searchClient($http)->customGet('1/test', null, [
            'headers' => ['Request-ID' => 'CallerProvided'],
        ]);

        $this->assertSame(['CallerProvided'], $this->sentRequestIds($http));
    }

    public function testACallerSuppliedQueryParameterSuppressesTheHeader(): void
    {
        $http = $this->recorder();

        $this->searchClient($http)->customGet('1/test', null, [
            'queryParameters' => ['X-Algolia-Request-Id' => 'CallerQuery'],
        ]);

        $this->assertSame([''], $this->sentRequestIds($http));
        $this->assertStringContainsString(
            'X-Algolia-Request-Id=CallerQuery',
            (string) $http->requests[0]->getUri()
        );
    }

    public function testAClientLevelDefaultHeaderWins(): void
    {
        $http = $this->recorder();
        $config = $this->searchConfig()->setDefaultHeaders(['REQUEST-ID' => 'FromDefaults']);

        $this->searchClient($http, $config)->customGet('1/test');

        $this->assertSame(['FromDefaults'], $this->sentRequestIds($http));
        $this->assertSame(['REQUEST-ID' => 'FromDefaults'], $config->getDefaultHeaders());
    }

    public function testTheSearchClientMintsByDefaultAndCanOptOut(): void
    {
        $this->assertTrue($this->searchConfig()->getRequestIdEnabled());

        $http = $this->recorder();
        $config = $this->searchConfig()->setRequestIdEnabled(false);

        $this->searchClient($http, $config)->customGet('1/test');

        $this->assertSame([''], $this->sentRequestIds($http));
    }

    public function testTheIngestionClientNeverMints(): void
    {
        $http = $this->recorder();
        $config = IngestionConfig::create('test-app-id', 'test-api-key', 'us');
        $client = new IngestionClient(
            new ApiWrapper($http, $config, ClusterHosts::create(self::HOSTS), new RequestOptionsFactory($config)),
            $config
        );

        $this->assertFalse($config->getRequestIdEnabled());

        $client->customGet('1/test');

        $this->assertSame([''], $this->sentRequestIds($http));
    }

    public function testEveryRequestOfOneHelperCallSharesOneRequestId(): void
    {
        $http = $this->recorder(array_merge($this->saveObjectsResponses(), $this->saveObjectsResponses()));
        $client = $this->searchClient($http);

        $objects = [
            ['objectID' => '1', 'name' => 'Adam'],
            ['objectID' => '2', 'name' => 'Benoit'],
            ['objectID' => '3', 'name' => 'Cyril'],
            ['objectID' => '4', 'name' => 'David'],
        ];

        $client->saveObjects('cts_request_id_php', $objects, true, 2);
        $client->saveObjects('cts_request_id_php', $objects, true, 2);

        $ids = $this->sentRequestIds($http);
        $this->assertCount(8, $ids);

        $first = array_slice($ids, 0, 4);
        $second = array_slice($ids, 4, 4);
        $this->assertMatchesRegularExpression(self::FORMAT, $first[0]);
        $this->assertCount(1, array_unique($first));
        $this->assertCount(1, array_unique($second));
        $this->assertNotSame($first[0], $second[0]);
    }

    public function testAHelperHandedARequestOptionsObjectDoesNotMutateIt(): void
    {
        $http = $this->recorder($this->saveObjectsResponses());
        $requestOptions = new RequestOptions([
            'headers' => ['x-custom-header' => 'custom-value'],
            'queryParameters' => [],
            'body' => [],
            'readTimeout' => 10,
            'writeTimeout' => 20,
            'connectTimeout' => 5,
        ]);

        $this->searchClient($http)->saveObjects(
            'cts_request_id_php',
            [
                ['objectID' => '1', 'name' => 'Adam'],
                ['objectID' => '2', 'name' => 'Benoit'],
                ['objectID' => '3', 'name' => 'Cyril'],
                ['objectID' => '4', 'name' => 'David'],
            ],
            true,
            2,
            $requestOptions
        );

        $this->assertSame(['x-custom-header' => 'custom-value'], $requestOptions->getHeaders());

        $ids = $this->sentRequestIds($http);
        $this->assertCount(4, $ids);
        $this->assertMatchesRegularExpression(self::FORMAT, $ids[0]);
        $this->assertCount(1, array_unique($ids));
    }

    public function testAnErrorCarriesTheCorrelationId(): void
    {
        $http = $this->recorder([
            new Response(400, ['Correlation-ID' => 'CtsFixedCorrelationId'], '{"message":"request-id error test"}'),
        ]);

        try {
            $this->searchClient($http)->customGet('1/test');
            $this->fail('Expected BadRequestException to be thrown');
        } catch (BadRequestException $e) {
            $this->assertSame('CtsFixedCorrelationId', $e->getCorrelationId());
            $this->assertSame('request-id error test (Correlation-ID: CtsFixedCorrelationId)', $e->getMessage());
        }
    }

    public function testAnErrorWithoutTheHeaderIsUnchanged(): void
    {
        $http = $this->recorder([
            new Response(400, [], '{"message":"request-id error test"}'),
        ]);

        try {
            $this->searchClient($http)->customGet('1/test');
            $this->fail('Expected BadRequestException to be thrown');
        } catch (BadRequestException $e) {
            $this->assertNull($e->getCorrelationId());
            $this->assertSame('request-id error test', $e->getMessage());
        }
    }

    public function testUnreachableHostsExposeTheLastCorrelationIdExactlyOnce(): void
    {
        $http = $this->recorder([
            new Response(500, ['Correlation-ID' => 'FirstCorrelationId'], '{"message":"boom"}'),
            new Response(500, [], '{"message":"boom"}'),
            new Response(500, ['Correlation-ID' => 'LastCorrelationId'], '{"message":"boom"}'),
        ]);

        try {
            $this->searchClient($http)->customGet('1/test');
            $this->fail('Expected UnreachableException to be thrown');
        } catch (UnreachableException $e) {
            $this->assertSame('LastCorrelationId', $e->getCorrelationId());
            $this->assertSame(1, substr_count($e->getMessage(), 'Correlation-ID:'));
        }
    }

    public function testUnreachableHostsKeepAnEarlierCorrelationIdInTheMessage(): void
    {
        $http = $this->recorder([
            new Response(500, ['Correlation-ID' => 'EarlyCorrelationId'], '{"message":"boom"}'),
            new Response(500, [], '{"message":"boom"}'),
            new Response(500, [], '{"message":"boom"}'),
        ]);

        try {
            $this->searchClient($http)->customGet('1/test');
            $this->fail('Expected UnreachableException to be thrown');
        } catch (UnreachableException $e) {
            $this->assertSame('EarlyCorrelationId', $e->getCorrelationId());
            $this->assertStringEndsWith('(Correlation-ID: EarlyCorrelationId)', $e->getMessage());
            $this->assertSame(1, substr_count($e->getMessage(), 'Correlation-ID:'));
        }
    }

    public function testPresenceChecksAreCaseInsensitiveOnBothChannels(): void
    {
        $this->assertMatchesRegularExpression(self::FORMAT, RequestId::generate());
        $this->assertTrue(RequestId::isPresentInHeaders(['Request-ID' => 'x']));
        $this->assertFalse(RequestId::isPresentInHeaders(['x-algolia-api-key' => 'x']));
        $this->assertTrue(RequestId::isPresentInQueryParameters(['X-Algolia-Request-Id' => 'x']));
        $this->assertFalse(RequestId::isPresentInQueryParameters([]));
    }

    /**
     * @return Response[] one `saveObjects` call with `batchSize: 2` over 4 objects
     */
    private function saveObjectsResponses()
    {
        return [
            new Response(200, [], '{"taskID":42,"objectIDs":["1","2"]}'),
            new Response(200, [], '{"taskID":42,"objectIDs":["3","4"]}'),
            new Response(200, [], '{"status":"published","updatedAt":"2021-01-01T00:00:00.000Z"}'),
            new Response(200, [], '{"status":"published","updatedAt":"2021-01-01T00:00:00.000Z"}'),
        ];
    }

    private function recorder(array $responses = [])
    {
        return new class($responses) implements HttpClientInterface {
            /**
             * @var RequestInterface[]
             */
            public $requests = [];

            private $responses;

            public function __construct(array $responses)
            {
                $this->responses = $responses;
            }

            public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
            {
                $this->requests[] = $request;

                $response = array_shift($this->responses);

                return null === $response ? new Response(200, [], '{}') : $response;
            }
        };
    }

    /**
     * @param mixed $http
     *
     * @return string[] the `request-id` header of every recorded request, '' when none was sent
     */
    private function sentRequestIds($http)
    {
        return array_map(function (RequestInterface $request) {
            return $request->getHeaderLine('request-id');
        }, $http->requests);
    }

    private function searchConfig(): SearchConfig
    {
        return SearchConfig::create('test-app-id', 'test-api-key');
    }

    private function searchClient(HttpClientInterface $http, ?SearchConfig $config = null): SearchClient
    {
        $config = $config ?: $this->searchConfig();

        return new SearchClient(
            new ApiWrapper($http, $config, ClusterHosts::create(self::HOSTS), new RequestOptionsFactory($config)),
            $config
        );
    }
}
