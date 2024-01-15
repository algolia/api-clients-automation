<?php

namespace Algolia\AlgoliaSearch\Snippets;

class SnippetInsightsClient
{
    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customDelete(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the CustomGet method.
     *
     * allow get method for a custom path with minimal parameters
     */
    public function snippetForCustomGet()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customGet(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the CustomPost method.
     *
     * allow post method for a custom path with minimal parameters
     */
    public function snippetForCustomPost()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customPost(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the CustomPut method.
     *
     * allow put method for a custom path with minimal parameters
     */
    public function snippetForCustomPut()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the DeleteUserToken method.
     *
     * deleteUserToken0
     */
    public function snippetForDeleteUserToken()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteUserToken(
            'test-user-1',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the PushEvents method.
     *
     * pushEvents0
     */
    public function snippetForPushEvents()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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

        // play with the response
        var_dump($response);
    }
}
