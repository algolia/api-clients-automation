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
        // >SEPARATOR customDelete
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

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
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetClusterIncidents method.
     *
     * getClusterIncidents
     */
    public function snippetForGetClusterIncidents()
    {
        // >SEPARATOR getClusterIncidents
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getClusterIncidents(
            'c1-de',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetClusterStatus method.
     *
     * getClusterStatus
     */
    public function snippetForGetClusterStatus()
    {
        // >SEPARATOR getClusterStatus
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getClusterStatus(
            'c1-de',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetIncidents method.
     *
     * getIncidents
     */
    public function snippetForGetIncidents()
    {
        // >SEPARATOR getIncidents
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getIncidents();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetIndexingTime method.
     *
     * getIndexingTime
     */
    public function snippetForGetIndexingTime()
    {
        // >SEPARATOR getIndexingTime
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getIndexingTime(
            'c1-de',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetInventory method.
     *
     * getInventory
     */
    public function snippetForGetInventory()
    {
        // >SEPARATOR getInventory
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getInventory();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetLatency method.
     *
     * getLatency
     */
    public function snippetForGetLatency()
    {
        // >SEPARATOR getLatency
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getLatency(
            'c1-de',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetMetrics method.
     *
     * getMetrics
     */
    public function snippetForGetMetrics()
    {
        // >SEPARATOR getMetrics
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getMetrics(
            'avg_build_time',
            'minute',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetReachability method.
     *
     * getReachability
     */
    public function snippetForGetReachability()
    {
        // >SEPARATOR getReachability
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getReachability(
            'c1-de',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetStatus method.
     *
     * getStatus
     */
    public function snippetForGetStatus()
    {
        // >SEPARATOR getStatus
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getStatus();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }
}
