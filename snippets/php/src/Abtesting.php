<?php

namespace Algolia\AlgoliaSearch\Snippets;

class SnippetAbtestingClient
{
    /**
     * Snippet for the AddABTests method.
     *
     * addABTests with minimal parameters
     */
    public function snippetForAddABTests()
    {
        // >SEPARATOR addABTests
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\AbtestingClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->addABTests(
            ['endAt' => '2022-12-31T00:00:00.000Z',
                'name' => 'myABTest',
                'variants' => [
                    ['index' => 'AB_TEST_1',
                        'trafficPercentage' => 30,
                    ],

                    ['index' => 'AB_TEST_2',
                        'trafficPercentage' => 50,
                    ],
                ],
            ],
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete()
    {
        // >SEPARATOR customDelete
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\AbtestingClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customDelete(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomGet method.
     *
     * allow get method for a custom path with minimal parameters
     */
    public function snippetForCustomGet()
    {
        // >SEPARATOR customGet
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\AbtestingClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customGet(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * allow post method for a custom path with minimal parameters
     */
    public function snippetForCustomPost()
    {
        // >SEPARATOR customPost
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\AbtestingClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customPost(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPut method.
     *
     * allow put method for a custom path with minimal parameters
     */
    public function snippetForCustomPut()
    {
        // >SEPARATOR customPut
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\AbtestingClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteABTest method.
     *
     * deleteABTest
     */
    public function snippetForDeleteABTest()
    {
        // >SEPARATOR deleteABTest
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\AbtestingClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteABTest(
            42,
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetABTest method.
     *
     * getABTest
     */
    public function snippetForGetABTest()
    {
        // >SEPARATOR getABTest
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\AbtestingClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getABTest(
            42,
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ListABTests method.
     *
     * listABTests with minimal parameters
     */
    public function snippetForListABTests()
    {
        // >SEPARATOR listABTests
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\AbtestingClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->listABTests();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the StopABTest method.
     *
     * stopABTest
     */
    public function snippetForStopABTest()
    {
        // >SEPARATOR stopABTest
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\AbtestingClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->stopABTest(
            42,
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }
}
