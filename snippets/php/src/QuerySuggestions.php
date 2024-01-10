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
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
    }

    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete()
    {
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the DeleteConfig method.
     *
     * deleteConfig0
     */
    public function snippetForDeleteConfig()
    {
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->deleteConfig(
            'theIndexName',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetAllConfigs method.
     *
     * getAllConfigs0
     */
    public function snippetForGetAllConfigs()
    {
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getAllConfigs();

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetConfig method.
     *
     * getConfig0
     */
    public function snippetForGetConfig()
    {
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getConfig(
            'theIndexName',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetConfigStatus method.
     *
     * getConfigStatus0
     */
    public function snippetForGetConfigStatus()
    {
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getConfigStatus(
            'theIndexName',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetLogFile method.
     *
     * getLogFile0
     */
    public function snippetForGetLogFile()
    {
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getLogFile(
            'theIndexName',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the UpdateConfig method.
     *
     * updateConfig0
     */
    public function snippetForUpdateConfig()
    {
        $client = Algolia\AlgoliaSearch\Api\QuerySuggestionsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
    }
}
