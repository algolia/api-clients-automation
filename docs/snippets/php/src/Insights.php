<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Snippets;

// >IMPORT
use Algolia\AlgoliaSearch\Api\InsightsClient;

// IMPORT<

class SnippetInsightsClient
{
    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete(): void
    {
        // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customDelete(
            'test/minimal',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with all parameters
     */
    public function snippetForCustomDelete1(): void
    {
        // >SEPARATOR customDelete allow del method for a custom path with all parameters
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customDelete(
            'test/all',
            ['query' => 'parameters',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomGet method.
     *
     * allow get method for a custom path with minimal parameters
     */
    public function snippetForCustomGet(): void
    {
        // >SEPARATOR customGet allow get method for a custom path with minimal parameters
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customGet(
            'test/minimal',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomGet method.
     *
     * allow get method for a custom path with all parameters
     */
    public function snippetForCustomGet1(): void
    {
        // >SEPARATOR customGet allow get method for a custom path with all parameters
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customGet(
            'test/all',
            ['query' => 'parameters with space',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomGet method.
     *
     * requestOptions should be escaped too
     */
    public function snippetForCustomGet2(): void
    {
        // >SEPARATOR customGet requestOptions should be escaped too
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customGet(
            'test/all',
            ['query' => 'to be overriden',
            ],
            [
                'queryParameters' => [
                    'query' => 'parameters with space',
                    'and an array' => ['array', 'with spaces',
                    ],
                ],
                'headers' => [
                    'x-header-1' => 'spaces are left alone',
                ],
            ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * allow post method for a custom path with minimal parameters
     */
    public function snippetForCustomPost(): void
    {
        // >SEPARATOR customPost allow post method for a custom path with minimal parameters
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/minimal',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * allow post method for a custom path with all parameters
     */
    public function snippetForCustomPost1(): void
    {
        // >SEPARATOR customPost allow post method for a custom path with all parameters
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/all',
            ['query' => 'parameters',
            ],
            ['body' => 'parameters',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * requestOptions can override default query parameters
     */
    public function snippetForCustomPost2(): void
    {
        // >SEPARATOR customPost requestOptions can override default query parameters
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'query' => 'myQueryParameter',
                ], ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * requestOptions merges query parameters with default ones
     */
    public function snippetForCustomPost3(): void
    {
        // >SEPARATOR customPost requestOptions merges query parameters with default ones
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'query2' => 'myQueryParameter',
                ], ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * requestOptions can override default headers
     */
    public function snippetForCustomPost4(): void
    {
        // >SEPARATOR customPost requestOptions can override default headers
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'headers' => [
                    'x-algolia-api-key' => 'ALGOLIA_API_KEY',
                ],
            ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * requestOptions merges headers with default ones
     */
    public function snippetForCustomPost5(): void
    {
        // >SEPARATOR customPost requestOptions merges headers with default ones
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'headers' => [
                    'x-algolia-api-key' => 'ALGOLIA_API_KEY',
                ],
            ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * requestOptions queryParameters accepts booleans
     */
    public function snippetForCustomPost6(): void
    {
        // >SEPARATOR customPost requestOptions queryParameters accepts booleans
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'isItWorking' => true,
                ], ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * requestOptions queryParameters accepts integers
     */
    public function snippetForCustomPost7(): void
    {
        // >SEPARATOR customPost requestOptions queryParameters accepts integers
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'myParam' => 2,
                ], ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * requestOptions queryParameters accepts list of string
     */
    public function snippetForCustomPost8(): void
    {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of string
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'myParam' => ['b and c', 'd',
                    ],
                ], ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * requestOptions queryParameters accepts list of booleans
     */
    public function snippetForCustomPost9(): void
    {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'myParam' => [true, true, false,
                    ],
                ], ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * requestOptions queryParameters accepts list of integers
     */
    public function snippetForCustomPost10(): void
    {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPost(
            'test/requestOptions',
            ['query' => 'parameters',
            ],
            ['facet' => 'filters',
            ],
            [
                'queryParameters' => [
                    'myParam' => [1, 2,
                    ],
                ], ]
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPut method.
     *
     * allow put method for a custom path with minimal parameters
     */
    public function snippetForCustomPut(): void
    {
        // >SEPARATOR customPut allow put method for a custom path with minimal parameters
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPut(
            'test/minimal',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPut method.
     *
     * allow put method for a custom path with all parameters
     */
    public function snippetForCustomPut1(): void
    {
        // >SEPARATOR customPut allow put method for a custom path with all parameters
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->customPut(
            'test/all',
            ['query' => 'parameters',
            ],
            ['body' => 'parameters',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteUserToken method.
     *
     * deleteUserToken
     */
    public function snippetForDeleteUserToken(): void
    {
        // >SEPARATOR deleteUserToken default
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $client->deleteUserToken(
            'test-user-1',
        );

        // >LOG
        // SEPARATOR<
    }

    /**
     * Snippet for the PushEvents method.
     *
     * pushEvents
     */
    public function snippetForPushEvents(): void
    {
        // >SEPARATOR pushEvents pushEvents
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->pushEvents(
            ['events' => [
                ['eventType' => 'click',
                    'eventName' => 'Product Clicked',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1641290601962,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                    'queryID' => '43b15df305339e827f0ac0bdc5ebcaa7',
                    'positions' => [
                        7,

                        6,
                    ],
                ],
            ],
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the PushEvents method.
     *
     * Many events type
     */
    public function snippetForPushEvents1(): void
    {
        // >SEPARATOR pushEvents Many events type
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->pushEvents(
            ['events' => [
                ['eventType' => 'conversion',
                    'eventName' => 'Product Purchased',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1742083200000,
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
                    'timestamp' => 1742083200000,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                ],
            ],
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the PushEvents method.
     *
     * ConvertedObjectIDsAfterSearch
     */
    public function snippetForPushEvents2(): void
    {
        // >SEPARATOR pushEvents ConvertedObjectIDsAfterSearch
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->pushEvents(
            ['events' => [
                ['eventType' => 'conversion',
                    'eventName' => 'Product Purchased',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1641290601962,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                    'queryID' => '43b15df305339e827f0ac0bdc5ebcaa7',
                ],
            ],
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the PushEvents method.
     *
     * ViewedObjectIDs
     */
    public function snippetForPushEvents3(): void
    {
        // >SEPARATOR pushEvents ViewedObjectIDs
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->pushEvents(
            ['events' => [
                ['eventType' => 'view',
                    'eventName' => 'Product Detail Page Viewed',
                    'index' => 'products',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1641290601962,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                ],
            ],
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the PushEvents method.
     *
     * AddedToCartObjectIDs
     */
    public function snippetForPushEvents4(): void
    {
        // >SEPARATOR pushEvents AddedToCartObjectIDs
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->pushEvents(
            ['events' => [
                ['eventType' => 'conversion',
                    'eventSubtype' => 'addToCart',
                    'eventName' => 'Product Added To Cart',
                    'index' => 'products',
                    'queryID' => '43b15df305339e827f0ac0bdc5ebcaa7',
                    'userToken' => 'user-123456',
                    'authenticatedUserToken' => 'user-123456',
                    'timestamp' => 1641290601962,
                    'objectIDs' => [
                        '9780545139700',

                        '9780439784542',
                    ],
                    'objectData' => [
                        ['price' => 19.99,
                            'quantity' => 10,
                            'discount' => 2.5,
                        ],

                        ['price' => '8$',
                            'quantity' => 7,
                            'discount' => '30%',
                        ],
                    ],
                    'currency' => 'USD',
                ],
            ],
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SetClientApiKey method.
     *
     * switch API key
     */
    public function snippetForSetClientApiKey(): void
    {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        $client = InsightsClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $client->setClientApiKey(
            'updated-api-key',
        );

        // >LOG
        // SEPARATOR<
    }
}
