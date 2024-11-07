<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Test\RequestE2E;

use Algolia\AlgoliaSearch\Api\InsightsClient;
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
#[CoversClass(InsightsClient::class)]
class InsightsTest extends TestCase
{
    #[TestDox('Many events type')]
    public function testPushEvents1(): void
    {
        $client = $this->getClient();
        $resp = $client->pushEvents(
            ['events' => [
                ['eventType' => 'conversion',
                    'eventName' => 'Product Purchased',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1730937600000,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                    'queryID' => '43b15df305339e827f0ac0bdc5ebcaa7',
                ],

                ['eventType' => 'view',
                    'eventName' => 'Product Detail Page Viewed',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1730937600000,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                ],
            ],
            ],
        );

        $expected = json_decode('{"message":"OK","status":200}', true);

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

    protected function getClient(): InsightsClient
    {
        return InsightsClient::create($_ENV['ALGOLIA_APPLICATION_ID'], $_ENV['ALGOLIA_ADMIN_KEY'], 'us');
    }
}
