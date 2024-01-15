<?php

namespace Algolia\AlgoliaSearch\Snippets;

class SnippetAnalyticsClient
{
    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetAverageClickPosition method.
     *
     * get getAverageClickPosition with minimal parameters
     */
    public function snippetForGetAverageClickPosition()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getAverageClickPosition(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetClickPositions method.
     *
     * get getClickPositions with minimal parameters
     */
    public function snippetForGetClickPositions()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getClickPositions(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetClickThroughRate method.
     *
     * get getClickThroughRate with minimal parameters
     */
    public function snippetForGetClickThroughRate()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getClickThroughRate(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetConversationRate method.
     *
     * get getConversationRate with minimal parameters
     */
    public function snippetForGetConversationRate()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getConversationRate(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetNoClickRate method.
     *
     * get getNoClickRate with minimal parameters
     */
    public function snippetForGetNoClickRate()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getNoClickRate(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetNoResultsRate method.
     *
     * get getNoResultsRate with minimal parameters
     */
    public function snippetForGetNoResultsRate()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getNoResultsRate(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetSearchesCount method.
     *
     * get getSearchesCount with minimal parameters
     */
    public function snippetForGetSearchesCount()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getSearchesCount(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetSearchesNoClicks method.
     *
     * get getSearchesNoClicks with minimal parameters
     */
    public function snippetForGetSearchesNoClicks()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getSearchesNoClicks(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetSearchesNoResults method.
     *
     * get getSearchesNoResults with minimal parameters
     */
    public function snippetForGetSearchesNoResults()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getSearchesNoResults(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetStatus method.
     *
     * get getStatus with minimal parameters
     */
    public function snippetForGetStatus()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getStatus(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetTopCountries method.
     *
     * get getTopCountries with minimal parameters
     */
    public function snippetForGetTopCountries()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getTopCountries(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetTopFilterAttributes method.
     *
     * get getTopFilterAttributes with minimal parameters
     */
    public function snippetForGetTopFilterAttributes()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getTopFilterAttributes(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetTopFilterForAttribute method.
     *
     * get getTopFilterForAttribute with minimal parameters
     */
    public function snippetForGetTopFilterForAttribute()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getTopFilterForAttribute(
            'myAttribute',
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetTopFiltersNoResults method.
     *
     * get getTopFiltersNoResults with minimal parameters
     */
    public function snippetForGetTopFiltersNoResults()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getTopFiltersNoResults(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetTopHits method.
     *
     * get getTopHits with minimal parameters
     */
    public function snippetForGetTopHits()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getTopHits(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetTopSearches method.
     *
     * get getTopSearches with minimal parameters
     */
    public function snippetForGetTopSearches()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getTopSearches(
            'index',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetUsersCount method.
     *
     * get getUsersCount with minimal parameters
     */
    public function snippetForGetUsersCount()
    {
        $client = Algolia\AlgoliaSearch\Api\AnalyticsClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getUsersCount(
            'index',
        );

        // play with the response
        var_dump($response);
    }
}
