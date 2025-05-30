<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Snippets;

// >IMPORT
use Algolia\AlgoliaSearch\Api\PersonalizationClient;

// IMPORT<

class SnippetPersonalizationClient
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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

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
     * Snippet for the DeleteUserProfile method.
     *
     * delete deleteUserProfile
     */
    public function snippetForDeleteUserProfile(): void
    {
        // >SEPARATOR deleteUserProfile default
        // Initialize the client
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->deleteUserProfile(
            'UserToken',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetPersonalizationStrategy method.
     *
     * get getPersonalizationStrategy
     */
    public function snippetForGetPersonalizationStrategy(): void
    {
        // >SEPARATOR getPersonalizationStrategy default
        // Initialize the client
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->getPersonalizationStrategy();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetUserTokenProfile method.
     *
     * get getUserTokenProfile
     */
    public function snippetForGetUserTokenProfile(): void
    {
        // >SEPARATOR getUserTokenProfile default
        // Initialize the client
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->getUserTokenProfile(
            'UserToken',
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
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $client->setClientApiKey(
            'updated-api-key',
        );

        // >LOG
        // SEPARATOR<
    }

    /**
     * Snippet for the SetPersonalizationStrategy method.
     *
     * set setPersonalizationStrategy
     */
    public function snippetForSetPersonalizationStrategy(): void
    {
        // >SEPARATOR setPersonalizationStrategy default
        // Initialize the client
        $client = PersonalizationClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY', 'ALGOLIA_APPLICATION_REGION');

        // Call the API
        $response = $client->setPersonalizationStrategy(
            ['eventsScoring' => [
                ['score' => 42,
                    'eventName' => 'Algolia',
                    'eventType' => 'click',
                ],
            ],
                'facetsScoring' => [
                    ['score' => 42,
                        'facetName' => 'Event',
                    ],
                ],
                'personalizationImpact' => 42,
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }
}
