<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\IngestionClient;
use Algolia\AlgoliaSearch\Configuration\IngestionConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use Dotenv\Dotenv;
use GuzzleHttp\Psr7\Query;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

// we only read .env file if we run locally
if (getenv('ALGOLIA_APPLICATION_ID')) {
    $_ENV = getenv();
} else {
    $dotenv = Dotenv::createImmutable('tests');
    $dotenv->load();
}

/**
 * IngestionTest.
 *
 * @category Class
 *
 * @internal
 * @coversNothing
 */
class IngestionTest extends TestCase implements HttpClientInterface
{
    /**
     * @var RequestInterface[]
     */
    private $recordedRequests = [];

    public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
    {
        $this->recordedRequests[] = $request;

        return new Response(200, [], '{}');
    }

    /**
     * Test case for CreateAuthentication
     * createAuthenticationOAuth.
     */
    public function testCreateAuthentication0()
    {
        $client = $this->getClient();
        $client->createAuthentication(
            ['type' => 'oauth',
                'name' => 'authName',
                'input' => ['url' => 'http://test.oauth',
                    'client_id' => 'myID',
                    'client_secret' => 'mySecret',
                ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/authentications',
                'method' => 'POST',
                'body' => json_decode('{"type":"oauth","name":"authName","input":{"url":"http://test.oauth","client_id":"myID","client_secret":"mySecret"}}'),
            ],
        ]);
    }

    /**
     * Test case for CreateAuthentication
     * createAuthenticationAlgolia.
     */
    public function testCreateAuthentication1()
    {
        $client = $this->getClient();
        $client->createAuthentication(
            ['type' => 'algolia',
                'name' => 'authName',
                'input' => ['appID' => 'myappID',
                    'apiKey' => 'randomApiKey',
                ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/authentications',
                'method' => 'POST',
                'body' => json_decode('{"type":"algolia","name":"authName","input":{"appID":"myappID","apiKey":"randomApiKey"}}'),
            ],
        ]);
    }

    /**
     * Test case for CreateDestination
     * createDestination.
     */
    public function testCreateDestination0()
    {
        $client = $this->getClient();
        $client->createDestination(
            ['type' => 'search',
                'name' => 'destinationName',
                'input' => ['indexPrefix' => 'prefix_',
                ],
                'authenticationID' => '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/destinations',
                'method' => 'POST',
                'body' => json_decode('{"type":"search","name":"destinationName","input":{"indexPrefix":"prefix_"},"authenticationID":"6c02aeb1-775e-418e-870b-1faccd4b2c0f"}'),
            ],
        ]);
    }

    /**
     * Test case for CreateSource
     * createSource.
     */
    public function testCreateSource0()
    {
        $client = $this->getClient();
        $client->createSource(
            ['type' => 'commercetools',
                'name' => 'sourceName',
                'input' => ['storeKeys' => [
                    'myStore',
                ],
                    'locales' => [
                        'de',
                    ],
                    'url' => 'http://commercetools.com',
                    'projectKey' => 'keyID',
                ],
                'authenticationID' => '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/sources',
                'method' => 'POST',
                'body' => json_decode('{"type":"commercetools","name":"sourceName","input":{"storeKeys":["myStore"],"locales":["de"],"url":"http://commercetools.com","projectKey":"keyID"},"authenticationID":"6c02aeb1-775e-418e-870b-1faccd4b2c0f"}'),
            ],
        ]);
    }

    /**
     * Test case for CreateTask
     * createTaskOnDemand.
     */
    public function testCreateTask0()
    {
        $client = $this->getClient();
        $client->createTask(
            ['sourceID' => 'search',
                'destinationID' => 'destinationName',
                'trigger' => ['type' => 'onDemand',
                ],
                'action' => 'replace',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks',
                'method' => 'POST',
                'body' => json_decode('{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"onDemand"},"action":"replace"}'),
            ],
        ]);
    }

    /**
     * Test case for CreateTask
     * createTaskSchedule.
     */
    public function testCreateTask1()
    {
        $client = $this->getClient();
        $client->createTask(
            ['sourceID' => 'search',
                'destinationID' => 'destinationName',
                'trigger' => ['type' => 'schedule',
                    'cron' => '* * * * *',
                ],
                'action' => 'replace',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks',
                'method' => 'POST',
                'body' => json_decode('{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"schedule","cron":"* * * * *"},"action":"replace"}'),
            ],
        ]);
    }

    /**
     * Test case for CreateTask
     * createTaskSubscription.
     */
    public function testCreateTask2()
    {
        $client = $this->getClient();
        $client->createTask(
            ['sourceID' => 'search',
                'destinationID' => 'destinationName',
                'trigger' => ['type' => 'onDemand',
                ],
                'action' => 'replace',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks',
                'method' => 'POST',
                'body' => json_decode('{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"onDemand"},"action":"replace"}'),
            ],
        ]);
    }

    /**
     * Test case for CustomDelete
     * allow del method for a custom path with minimal parameters.
     */
    public function testCustomDelete0()
    {
        $client = $this->getClient();
        $client->customDelete(
            '/test/minimal',
        );

        $this->assertRequests([
            [
                'path' => '/1/test/minimal',
                'method' => 'DELETE',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for CustomDelete
     * allow del method for a custom path with all parameters.
     */
    public function testCustomDelete1()
    {
        $client = $this->getClient();
        $client->customDelete(
            '/test/all',
            ['query' => 'parameters',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/test/all',
                'method' => 'DELETE',
                'body' => null,
                'queryParameters' => json_decode('{"query":"parameters"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomGet
     * allow get method for a custom path with minimal parameters.
     */
    public function testCustomGet0()
    {
        $client = $this->getClient();
        $client->customGet(
            '/test/minimal',
        );

        $this->assertRequests([
            [
                'path' => '/1/test/minimal',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for CustomGet
     * allow get method for a custom path with all parameters.
     */
    public function testCustomGet1()
    {
        $client = $this->getClient();
        $client->customGet(
            '/test/all',
            ['query' => 'parameters with space',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/test/all',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"query":"parameters%20with%20space"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomGet
     * requestOptions should be escaped too.
     */
    public function testCustomGet2()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'query' => 'parameters with space',
                'and an array' => ['array',  'with spaces',
                ],
            ],
            'headers' => [
                'x-header-1' => 'spaces are left alone',
            ],
        ];
        $client->customGet(
            '/test/all',
            ['query' => 'to be overriden',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/all',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"query":"parameters%20with%20space","and%20an%20array":"array%2Cwith%20spaces"}', true),
                'headers' => json_decode('{"x-header-1":"spaces are left alone"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * allow post method for a custom path with minimal parameters.
     */
    public function testCustomPost0()
    {
        $client = $this->getClient();
        $client->customPost(
            '/test/minimal',
        );

        $this->assertRequests([
            [
                'path' => '/1/test/minimal',
                'method' => 'POST',
                'body' => json_decode('{}'),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * allow post method for a custom path with all parameters.
     */
    public function testCustomPost1()
    {
        $client = $this->getClient();
        $client->customPost(
            '/test/all',
            ['query' => 'parameters',
            ],
            ['body' => 'parameters',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/test/all',
                'method' => 'POST',
                'body' => json_decode('{"body":"parameters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions can override default query parameters.
     */
    public function testCustomPost2()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'query' => 'myQueryParameter',
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            '/test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"myQueryParameter"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions merges query parameters with default ones.
     */
    public function testCustomPost3()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'query2' => 'myQueryParameter',
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            '/test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","query2":"myQueryParameter"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions can override default headers.
     */
    public function testCustomPost4()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
            ],
            'headers' => [
                'x-algolia-api-key' => 'myApiKey',
            ],
        ];
        $client->customPost(
            '/test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
                'headers' => json_decode('{"x-algolia-api-key":"myApiKey"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions merges headers with default ones.
     */
    public function testCustomPost5()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
            ],
            'headers' => [
                'x-algolia-api-key' => 'myApiKey',
            ],
        ];
        $client->customPost(
            '/test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
                'headers' => json_decode('{"x-algolia-api-key":"myApiKey"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts booleans.
     */
    public function testCustomPost6()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'isItWorking' => true,
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            '/test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","isItWorking":"true"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts integers.
     */
    public function testCustomPost7()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => 2,
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            '/test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","myParam":"2"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts list of string.
     */
    public function testCustomPost8()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => ['b and c',  'd',
                ],
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            '/test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","myParam":"b%20and%20c%2Cd"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts list of booleans.
     */
    public function testCustomPost9()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => [true,  true,  false,
                ],
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            '/test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","myParam":"true%2Ctrue%2Cfalse"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPost
     * requestOptions queryParameters accepts list of integers.
     */
    public function testCustomPost10()
    {
        $client = $this->getClient();
        $requestOptions = [
            'queryParameters' => [
                'myParam' => [1,  2,
                ],
            ],
            'headers' => [
            ],
        ];
        $client->customPost(
            '/test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            $requestOptions
        );

        $this->assertRequests([
            [
                'path' => '/1/test/requestOptions',
                'method' => 'POST',
                'body' => json_decode('{"facet":"filters"}'),
                'queryParameters' => json_decode('{"query":"parameters","myParam":"1%2C2"}', true),
            ],
        ]);
    }

    /**
     * Test case for CustomPut
     * allow put method for a custom path with minimal parameters.
     */
    public function testCustomPut0()
    {
        $client = $this->getClient();
        $client->customPut(
            '/test/minimal',
        );

        $this->assertRequests([
            [
                'path' => '/1/test/minimal',
                'method' => 'PUT',
                'body' => json_decode('{}'),
            ],
        ]);
    }

    /**
     * Test case for CustomPut
     * allow put method for a custom path with all parameters.
     */
    public function testCustomPut1()
    {
        $client = $this->getClient();
        $client->customPut(
            '/test/all',
            ['query' => 'parameters',
            ],
            ['body' => 'parameters',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/test/all',
                'method' => 'PUT',
                'body' => json_decode('{"body":"parameters"}'),
                'queryParameters' => json_decode('{"query":"parameters"}', true),
            ],
        ]);
    }

    /**
     * Test case for DeleteAuthentication
     * deleteAuthentication.
     */
    public function testDeleteAuthentication0()
    {
        $client = $this->getClient();
        $client->deleteAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'DELETE',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for DeleteDestination
     * deleteDestination.
     */
    public function testDeleteDestination0()
    {
        $client = $this->getClient();
        $client->deleteDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'DELETE',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for DeleteSource
     * deleteSource.
     */
    public function testDeleteSource0()
    {
        $client = $this->getClient();
        $client->deleteSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'DELETE',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for DeleteTask
     * deleteTask.
     */
    public function testDeleteTask0()
    {
        $client = $this->getClient();
        $client->deleteTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'DELETE',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for DisableTask
     * disableTask.
     */
    public function testDisableTask0()
    {
        $client = $this->getClient();
        $client->disableTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable',
                'method' => 'PUT',
                'body' => json_decode(''),
            ],
        ]);
    }

    /**
     * Test case for EnableTask
     * enable task e2e.
     */
    public function testEnableTask0()
    {
        $client = $this->getClient();
        $client->enableTask(
            '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks/76ab4c2a-ce17-496f-b7a6-506dc59ee498/enable',
                'method' => 'PUT',
                'body' => json_decode(''),
            ],
        ]);

        $e2eClient = $this->getE2EClient();
        $resp = $e2eClient->enableTask(
            '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
        );

        $expected = json_decode('{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498"}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    /**
     * Test case for GetAuthentication
     * getAuthentication.
     */
    public function testGetAuthentication0()
    {
        $client = $this->getClient();
        $client->getAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetAuthentications
     * getAuthentications.
     */
    public function testGetAuthentications0()
    {
        $client = $this->getClient();
        $client->getAuthentications();

        $this->assertRequests([
            [
                'path' => '/1/authentications',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetAuthentications
     * getAuthentications with query params.
     */
    public function testGetAuthentications1()
    {
        $client = $this->getClient();
        $client->getAuthentications(
            10,
            1,
            [
                'basic',

                'algolia',
            ],
            [
                'none',
            ],
            'createdAt',
            'desc',
        );

        $this->assertRequests([
            [
                'path' => '/1/authentications',
                'method' => 'GET',
                'body' => null,
                'queryParameters' => json_decode('{"itemsPerPage":"10","page":"1","type":"basic%2Calgolia","platform":"none","sort":"createdAt","order":"desc"}', true),
            ],
        ]);

        $e2eClient = $this->getE2EClient();
        $resp = $e2eClient->getAuthentications(
            10,
            1,
            [
                'basic',

                'algolia',
            ],
            [
                'none',
            ],
            'createdAt',
            'desc',
        );

        $expected = json_decode('{"pagination":{"page":1,"itemsPerPage":10},"authentications":[{"authenticationID":"b57a7ea5-8592-493b-b75b-6c66d77aee7f","type":"algolia","name":"Auto-generated Authentication for T8JK9S7I7X - 1704732447751","input":{},"createdAt":"2024-01-08T16:47:31Z","updatedAt":"2024-01-08T16:47:31Z"},{},{},{},{},{},{},{}]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    /**
     * Test case for GetDestination
     * getDestination.
     */
    public function testGetDestination0()
    {
        $client = $this->getClient();
        $client->getDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetDestinations
     * getDestinations.
     */
    public function testGetDestinations0()
    {
        $client = $this->getClient();
        $client->getDestinations();

        $this->assertRequests([
            [
                'path' => '/1/destinations',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetDockerSourceStreams
     * getDockerSourceStreams.
     */
    public function testGetDockerSourceStreams0()
    {
        $client = $this->getClient();
        $client->getDockerSourceStreams(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetEvent
     * getEvent.
     */
    public function testGetEvent0()
    {
        $client = $this->getClient();
        $client->getEvent(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            '6c02aeb1-775e-418e-870b-1faccd4b2c0c',
        );

        $this->assertRequests([
            [
                'path' => '/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetEvents
     * getEvents.
     */
    public function testGetEvents0()
    {
        $client = $this->getClient();
        $client->getEvents(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetRun
     * getRun.
     */
    public function testGetRun0()
    {
        $client = $this->getClient();
        $client->getRun(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetRuns
     * getRuns.
     */
    public function testGetRuns0()
    {
        $client = $this->getClient();
        $client->getRuns();

        $this->assertRequests([
            [
                'path' => '/1/runs',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetSource
     * getSource.
     */
    public function testGetSource0()
    {
        $client = $this->getClient();
        $client->getSource(
            '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
        );

        $this->assertRequests([
            [
                'path' => '/1/sources/75eeb306-51d3-4e5e-a279-3c92bd8893ac',
                'method' => 'GET',
                'body' => null,
            ],
        ]);

        $e2eClient = $this->getE2EClient();
        $resp = $e2eClient->getSource(
            '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
        );

        $expected = json_decode('{"sourceID":"75eeb306-51d3-4e5e-a279-3c92bd8893ac","name":"cts_e2e_browse","type":"json","input":{"url":"https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json"}}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    /**
     * Test case for GetSources
     * getSources.
     */
    public function testGetSources0()
    {
        $client = $this->getClient();
        $client->getSources();

        $this->assertRequests([
            [
                'path' => '/1/sources',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetTask
     * getTask.
     */
    public function testGetTask0()
    {
        $client = $this->getClient();
        $client->getTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for GetTasks
     * getTasks.
     */
    public function testGetTasks0()
    {
        $client = $this->getClient();
        $client->getTasks();

        $this->assertRequests([
            [
                'path' => '/1/tasks',
                'method' => 'GET',
                'body' => null,
            ],
        ]);
    }

    /**
     * Test case for RunTask
     * runTask.
     */
    public function testRunTask0()
    {
        $client = $this->getClient();
        $client->runTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run',
                'method' => 'POST',
                'body' => json_decode(''),
            ],
        ]);
    }

    /**
     * Test case for SearchAuthentications
     * searchAuthentications.
     */
    public function testSearchAuthentications0()
    {
        $client = $this->getClient();
        $client->searchAuthentications(
            ['authenticationIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/authentications/search',
                'method' => 'POST',
                'body' => json_decode('{"authenticationIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}'),
            ],
        ]);
    }

    /**
     * Test case for SearchDestinations
     * searchDestinations.
     */
    public function testSearchDestinations0()
    {
        $client = $this->getClient();
        $client->searchDestinations(
            ['destinationIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/destinations/search',
                'method' => 'POST',
                'body' => json_decode('{"destinationIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}'),
            ],
        ]);
    }

    /**
     * Test case for SearchSources
     * searchSources.
     */
    public function testSearchSources0()
    {
        $client = $this->getClient();
        $client->searchSources(
            ['sourceIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/sources/search',
                'method' => 'POST',
                'body' => json_decode('{"sourceIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}'),
            ],
        ]);
    }

    /**
     * Test case for SearchTasks
     * searchTasks.
     */
    public function testSearchTasks0()
    {
        $client = $this->getClient();
        $client->searchTasks(
            ['taskIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',

                '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
            ],
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks/search',
                'method' => 'POST',
                'body' => json_decode('{"taskIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a","76ab4c2a-ce17-496f-b7a6-506dc59ee498"]}'),
            ],
        ]);

        $e2eClient = $this->getE2EClient();
        $resp = $e2eClient->searchTasks(
            ['taskIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',

                '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
            ],
            ],
        );

        $expected = json_decode('[{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498","sourceID":"75eeb306-51d3-4e5e-a279-3c92bd8893ac","destinationID":"506d79fa-e29d-4bcf-907c-6b6a41172153","trigger":{"type":"onDemand"},"enabled":true,"failureThreshold":0,"action":"replace","createdAt":"2024-01-08T16:47:41Z"}]', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    /**
     * Test case for TriggerDockerSourceDiscover
     * triggerDockerSourceDiscover.
     */
    public function testTriggerDockerSourceDiscover0()
    {
        $client = $this->getClient();
        $client->triggerDockerSourceDiscover(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        $this->assertRequests([
            [
                'path' => '/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover',
                'method' => 'POST',
                'body' => json_decode(''),
            ],
        ]);
    }

    /**
     * Test case for UpdateAuthentication
     * updateAuthentication.
     */
    public function testUpdateAuthentication0()
    {
        $client = $this->getClient();
        $client->updateAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'PATCH',
                'body' => json_decode('{"name":"newName"}'),
            ],
        ]);
    }

    /**
     * Test case for UpdateDestination
     * updateDestination.
     */
    public function testUpdateDestination0()
    {
        $client = $this->getClient();
        $client->updateDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'PATCH',
                'body' => json_decode('{"name":"newName"}'),
            ],
        ]);
    }

    /**
     * Test case for UpdateSource
     * updateSource.
     */
    public function testUpdateSource0()
    {
        $client = $this->getClient();
        $client->updateSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'PATCH',
                'body' => json_decode('{"name":"newName"}'),
            ],
        ]);
    }

    /**
     * Test case for UpdateTask
     * updateTask.
     */
    public function testUpdateTask0()
    {
        $client = $this->getClient();
        $client->updateTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['enabled' => false,
            ],
        );

        $this->assertRequests([
            [
                'path' => '/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f',
                'method' => 'PATCH',
                'body' => json_decode('{"enabled":false}'),
            ],
        ]);
    }

    protected function union($expected, $received)
    {
        if (is_array($expected)) {
            $res = [];
            // array and object are the same thing in PHP (magic ✨)
            foreach ($expected as $k => $v) {
                $res[$k] = $this->union($v, $received[$k]);
            }

            return $res;
        }

        return $received;
    }

    protected function assertRequests(array $requests)
    {
        $this->assertGreaterThan(0, count($requests));
        $this->assertEquals(count($requests), count($this->recordedRequests));

        foreach ($requests as $i => $request) {
            $recordedRequest = $this->recordedRequests[$i];

            $this->assertEquals($request['method'], $recordedRequest->getMethod());

            $this->assertEquals($request['path'], $recordedRequest->getUri()->getPath());

            if (isset($request['body'])) {
                $this->assertEquals(
                    json_encode($request['body']),
                    $recordedRequest->getBody()->getContents()
                );
            }

            if (isset($request['queryParameters'])) {
                $this->assertEquals(
                    Query::build($request['queryParameters'], false),
                    $recordedRequest->getUri()->getQuery()
                );
            }

            if (isset($request['headers'])) {
                foreach ($request['headers'] as $key => $value) {
                    $this->assertArrayHasKey(
                        $key,
                        $recordedRequest->getHeaders()
                    );
                    $this->assertEquals(
                        $recordedRequest->getHeaderLine($key),
                        $value
                    );
                }
            }
        }
    }

    protected function getE2EClient()
    {
        return IngestionClient::create($_ENV['ALGOLIA_APPLICATION_ID'], $_ENV['ALGOLIA_ADMIN_KEY'], 'us');
    }

    protected function getClient()
    {
        $config = IngestionConfig::create('appID', 'apiKey', 'us');
        $api = new ApiWrapper($this, $config, ClusterHosts::create('127.0.0.1'));

        return new IngestionClient($api, $config);
    }
}
