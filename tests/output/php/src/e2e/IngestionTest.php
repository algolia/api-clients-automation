<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Test\RequestE2E;

use Algolia\AlgoliaSearch\Api\IngestionClient;
use Dotenv\Dotenv;
use PHPUnit\Framework\Attributes\CoversClass;
use PHPUnit\Framework\Attributes\TestDox;
use PHPUnit\Framework\TestCase;

// we only read .env file if we run locally
if (getenv('ALGOLIA_APPLICATION_ID')) {
    $_ENV = getenv();
} else {
    $dotenv = Dotenv::createImmutable('tests');
    $dotenv->load();
}

/**
 * @internal
 */
#[CoversClass(IngestionClient::class)]
class IngestionTest extends TestCase
{
    #[TestDox('enableTask')]
    public function testEnableTask(): void
    {
        $client = $this->getClient();
        $resp = $client->enableTask(
            '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
        );

        $expected = json_decode('{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498"}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('enableTaskV1')]
    public function testEnableTaskV1(): void
    {
        $client = $this->getClient();
        $resp = $client->enableTaskV1(
            '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
        );

        $expected = json_decode('{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498"}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('getSource')]
    public function testGetSource(): void
    {
        $client = $this->getClient();
        $resp = $client->getSource(
            '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
        );

        $expected = json_decode('{"sourceID":"75eeb306-51d3-4e5e-a279-3c92bd8893ac","name":"cts_e2e_browse","type":"json","input":{"url":"https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json"}}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('getAuthentications with query params')]
    public function testListAuthentications1(): void
    {
        $client = $this->getClient();
        $resp = $client->listAuthentications(
            2,
            1,
            [
                'basic',

                'algolia',
            ],
            [
                'none',
            ],
            'createdAt',
            'asc',
        );

        $expected = json_decode('{"pagination":{"page":1,"itemsPerPage":2},"authentications":[{"authenticationID":"474f050f-a771-464c-a016-323538029f5f","type":"algolia","name":"algolia-auth-1677060483885","input":{},"createdAt":"2023-02-22T10:08:04Z","updatedAt":"2023-10-25T08:41:56Z"},{}]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('searchTasks')]
    public function testSearchTasks(): void
    {
        $client = $this->getClient();
        $resp = $client->searchTasks(
            ['taskIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',

                '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
            ],
            ],
        );

        $expected = json_decode('[{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498","sourceID":"75eeb306-51d3-4e5e-a279-3c92bd8893ac","destinationID":"506d79fa-e29d-4bcf-907c-6b6a41172153","enabled":true,"failureThreshold":0,"action":"replace","createdAt":"2024-01-08T16:47:41Z"}]', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('searchTasksV1')]
    public function testSearchTasksV1(): void
    {
        $client = $this->getClient();
        $resp = $client->searchTasksV1(
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

    protected function union($expected, $received): mixed
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

    protected function getClient(): IngestionClient
    {
        return IngestionClient::create($_ENV['ALGOLIA_APPLICATION_ID'], $_ENV['ALGOLIA_ADMIN_KEY'], 'us');
    }
}
