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
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->customPut(
            '/test/minimal',
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
        $client = Algolia\AlgoliaSearch\Api\InsightsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
