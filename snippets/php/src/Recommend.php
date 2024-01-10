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
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the DeleteRecommendRule method.
     *
     * deleteRecommendRule0
     */
    public function snippetForDeleteRecommendRule()
    {
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->deleteRecommendRule(
            'indexName',
            'related-products',
            'objectID',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetRecommendRule method.
     *
     * getRecommendRule0
     */
    public function snippetForGetRecommendRule()
    {
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getRecommendRule(
            'indexName',
            'related-products',
            'objectID',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetRecommendStatus method.
     *
     * getRecommendStatus0
     */
    public function snippetForGetRecommendStatus()
    {
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getRecommendStatus(
            'indexName',
            'related-products',
            12345,
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetRecommendations method.
     *
     * get recommendations for recommend model with minimal parameters
     */
    public function snippetForGetRecommendations()
    {
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
    }

    /**
     * Snippet for the SearchRecommendRules method.
     *
     * searchRecommendRules0
     */
    public function snippetForSearchRecommendRules()
    {
        $client = Algolia\AlgoliaSearch\Api\RecommendClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->searchRecommendRules(
            'indexName',
            'related-products',
        );

        // play with the response
        var_dump($response);
    }
}
