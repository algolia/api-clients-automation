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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getStatus();

        // play with the response
        var_dump($response);
    }
}
