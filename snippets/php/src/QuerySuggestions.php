<?php

namespace Algolia\AlgoliaSearch\Snippets;

class SnippetQuerySuggestionsClient
{
    /**
     * Snippet for the CreateConfig method.
     *
     * createConfig0
     */
    public function snippetForCreateConfig()
    {
        // >SEPARATOR createConfig
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->createConfig(
            ['indexName' => 'theIndexName',
                'sourceIndices' => [
                    ['indexName' => 'testIndex',
                        'facets' => [
                            ['attribute' => 'test',
                            ],
                        ],
                        'generate' => [
                            [
                                'facetA',

                                'facetB',
                            ],

                            [
                                'facetC',
                            ],
                        ],
                    ],
                ],
                'languages' => [
                    'french',
                ],
                'exclude' => [
                    'test',
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
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteConfig method.
     *
     * deleteConfig0
     */
    public function snippetForDeleteConfig()
    {
        // >SEPARATOR deleteConfig
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteConfig(
            'theIndexName',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetAllConfigs method.
     *
     * getAllConfigs0
     */
    public function snippetForGetAllConfigs()
    {
        // >SEPARATOR getAllConfigs
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getAllConfigs();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetConfig method.
     *
     * Retrieve QS config e2e
     */
    public function snippetForGetConfig()
    {
        // >SEPARATOR getConfig
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getConfig(
            'cts_e2e_browse_query_suggestions',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetConfigStatus method.
     *
     * getConfigStatus0
     */
    public function snippetForGetConfigStatus()
    {
        // >SEPARATOR getConfigStatus
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getConfigStatus(
            'theIndexName',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetLogFile method.
     *
     * getLogFile0
     */
    public function snippetForGetLogFile()
    {
        // >SEPARATOR getLogFile
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getLogFile(
            'theIndexName',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateConfig method.
     *
     * updateConfig0
     */
    public function snippetForUpdateConfig()
    {
        // >SEPARATOR updateConfig
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateConfig(
            'theIndexName',
            ['sourceIndices' => [
                ['indexName' => 'testIndex',
                    'facets' => [
                        ['attribute' => 'test',
                        ],
                    ],
                    'generate' => [
                        [
                            'facetA',

                            'facetB',
                        ],

                        [
                            'facetC',
                        ],
                    ],
                ],
            ],
                'languages' => [
                    'french',
                ],
                'exclude' => [
                    'test',
                ],
            ],
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }
}
