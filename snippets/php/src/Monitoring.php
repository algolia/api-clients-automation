<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Snippets;

// >IMPORT
use Algolia\AlgoliaSearch\Api\MonitoringClient;

// IMPORT<

class SnippetMonitoringClient
{
    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete(): void
    {
        // >SEPARATOR customDelete default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->customDelete(
            'test/minimal',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomGet method.
     *
     * allow get method for a custom path with minimal parameters
     */
    public function snippetForCustomGet(): void
    {
        // >SEPARATOR customGet default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->customGet(
            'test/minimal',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPost method.
     *
     * allow post method for a custom path with minimal parameters
     */
    public function snippetForCustomPost(): void
    {
        // >SEPARATOR customPost default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->customPost(
            'test/minimal',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomPut method.
     *
     * allow put method for a custom path with minimal parameters
     */
    public function snippetForCustomPut(): void
    {
        // >SEPARATOR customPut default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->customPut(
            'test/minimal',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetClusterIncidents method.
     *
     * getClusterIncidents
     */
    public function snippetForGetClusterIncidents(): void
    {
        // >SEPARATOR getClusterIncidents default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getClusterIncidents(
            'c1-de',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetClusterStatus method.
     *
     * getClusterStatus
     */
    public function snippetForGetClusterStatus(): void
    {
        // >SEPARATOR getClusterStatus default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getClusterStatus(
            'c1-de',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetIncidents method.
     *
     * getIncidents
     */
    public function snippetForGetIncidents(): void
    {
        // >SEPARATOR getIncidents default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getIncidents();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetIndexingTime method.
     *
     * getIndexingTime
     */
    public function snippetForGetIndexingTime(): void
    {
        // >SEPARATOR getIndexingTime default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getIndexingTime(
            'c1-de',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetLatency method.
     *
     * getLatency
     */
    public function snippetForGetLatency(): void
    {
        // >SEPARATOR getLatency default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getLatency(
            'c1-de',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetMetrics method.
     *
     * getMetrics
     */
    public function snippetForGetMetrics(): void
    {
        // >SEPARATOR getMetrics default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getMetrics(
            'avg_build_time',
            'minute',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetReachability method.
     *
     * getReachability
     */
    public function snippetForGetReachability(): void
    {
        // >SEPARATOR getReachability default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getReachability(
            'c1-de',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetServers method.
     *
     * getInventory
     */
    public function snippetForGetServers(): void
    {
        // >SEPARATOR getServers default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getServers();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetStatus method.
     *
     * getStatus
     */
    public function snippetForGetStatus(): void
    {
        // >SEPARATOR getStatus default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $response = $client->getStatus();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SetClientApiKey method.
     *
     * switch API key
     */
    public function snippetForSetClientApiKey(): void
    {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        $client = MonitoringClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>');

        // Call the API
        $client->setClientApiKey(
            'updated-api-key',
        );

        // >LOG
        // SEPARATOR<
    }
}
