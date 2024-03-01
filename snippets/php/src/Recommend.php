<?php

namespace Algolia\AlgoliaSearch\Snippets;

class SnippetRecommendClient
{
    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete()
    {
        // >SEPARATOR customDelete
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteRecommendRule method.
     *
     * deleteRecommendRule0
     */
    public function snippetForDeleteRecommendRule()
    {
        // >SEPARATOR deleteRecommendRule
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->deleteRecommendRule(
            'indexName',
            'related-products',
            'objectID',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetRecommendRule method.
     *
     * getRecommendRule0
     */
    public function snippetForGetRecommendRule()
    {
        // >SEPARATOR getRecommendRule
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getRecommendRule(
            'indexName',
            'related-products',
            'objectID',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetRecommendStatus method.
     *
     * getRecommendStatus0
     */
    public function snippetForGetRecommendStatus()
    {
        // >SEPARATOR getRecommendStatus
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getRecommendStatus(
            'indexName',
            'related-products',
            12345,
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetRecommendations method.
     *
     * get recommendations for recommend model with minimal parameters
     */
    public function snippetForGetRecommendations()
    {
        // >SEPARATOR getRecommendations
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getRecommendations(
            ['requests' => [
                ['indexName' => 'indexName',
                    'objectID' => 'objectID',
                    'model' => 'related-products',
                    'threshold' => 42,
                ],
            ],
            ],
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchRecommendRules method.
     *
     * searchRecommendRules0
     */
    public function snippetForSearchRecommendRules()
    {
        // >SEPARATOR searchRecommendRules
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->searchRecommendRules(
            'indexName',
            'related-products',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }
}
