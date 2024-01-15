<?php

namespace Algolia\AlgoliaSearch\Snippets;

class SnippetMonitoringClient
{
    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetClusterIncidents method.
     *
     * getClusterIncidents
     */
    public function snippetForGetClusterIncidents()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getClusterIncidents(
            'c1-de',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetClusterStatus method.
     *
     * getClusterStatus
     */
    public function snippetForGetClusterStatus()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getClusterStatus(
            'c1-de',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetIncidents method.
     *
     * getIncidents
     */
    public function snippetForGetIncidents()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getIncidents();

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetIndexingTime method.
     *
     * getIndexingTime
     */
    public function snippetForGetIndexingTime()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getIndexingTime(
            'c1-de',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetInventory method.
     *
     * getInventory
     */
    public function snippetForGetInventory()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getInventory();

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetLatency method.
     *
     * getLatency
     */
    public function snippetForGetLatency()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getLatency(
            'c1-de',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetMetrics method.
     *
     * getMetrics
     */
    public function snippetForGetMetrics()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getMetrics(
            'avg_build_time',
            'minute',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetReachability method.
     *
     * getReachability
     */
    public function snippetForGetReachability()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getReachability(
            'c1-de',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetStatus method.
     *
     * getStatus
     */
    public function snippetForGetStatus()
    {
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        $response = $client->getStatus();

        // play with the response
        var_dump($response);
    }
}
