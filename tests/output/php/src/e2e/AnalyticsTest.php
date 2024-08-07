<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Test\RequestE2E;

use Algolia\AlgoliaSearch\Api\AnalyticsClient;
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
#[CoversClass(AnalyticsClient::class)]
class AnalyticsTest extends TestCase
{
    #[TestDox('e2e with complex query params')]
    public function testGetTopSearches2()
    {
        $client = $this->getClient();
        $resp = $client->getTopSearches(
            'cts_e2e_space in index',
        );

        $expected = json_decode('{"searches":[{"search":"","nbHits":0}]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
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

    protected function getClient()
    {
        return AnalyticsClient::create($_ENV['ALGOLIA_APPLICATION_ID'], $_ENV['ALGOLIA_ADMIN_KEY'], 'us');
    }
}
