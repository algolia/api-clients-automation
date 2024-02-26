<?php

namespace Algolia\AlgoliaSearch\Snippets;

class SnippetIngestionClient
{
    /**
     * Snippet for the CreateAuthentication method.
     *
     * createAuthenticationOAuth
     */
    public function snippetForCreateAuthentication()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->createAuthentication(
            ['type' => 'oauth',
                'name' => 'authName',
                'input' => ['url' => 'http://test.oauth',
                    'client_id' => 'myID',
                    'client_secret' => 'mySecret',
                ],
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the CreateDestination method.
     *
     * createDestination
     */
    public function snippetForCreateDestination()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->createDestination(
            ['type' => 'search',
                'name' => 'destinationName',
                'input' => ['indexPrefix' => 'prefix_',
                ],
                'authenticationID' => '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the CreateSource method.
     *
     * createSource
     */
    public function snippetForCreateSource()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->createSource(
            ['type' => 'commercetools',
                'name' => 'sourceName',
                'input' => ['storeKeys' => [
                    'myStore',
                ],
                    'locales' => [
                        'de',
                    ],
                    'url' => 'http://commercetools.com',
                    'projectKey' => 'keyID',
                ],
                'authenticationID' => '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the CreateTask method.
     *
     * createTaskOnDemand
     */
    public function snippetForCreateTask()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->createTask(
            ['sourceID' => 'search',
                'destinationID' => 'destinationName',
                'trigger' => ['type' => 'onDemand',
                ],
                'action' => 'replace',
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
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customPut(
            '/test/minimal',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the DeleteAuthentication method.
     *
     * deleteAuthentication
     */
    public function snippetForDeleteAuthentication()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the DeleteDestination method.
     *
     * deleteDestination
     */
    public function snippetForDeleteDestination()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the DeleteSource method.
     *
     * deleteSource
     */
    public function snippetForDeleteSource()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the DeleteTask method.
     *
     * deleteTask
     */
    public function snippetForDeleteTask()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the DisableTask method.
     *
     * disableTask
     */
    public function snippetForDisableTask()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->disableTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the EnableTask method.
     *
     * enable task e2e
     */
    public function snippetForEnableTask()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->enableTask(
            '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetAuthentication method.
     *
     * getAuthentication
     */
    public function snippetForGetAuthentication()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetAuthentications method.
     *
     * getAuthentications
     */
    public function snippetForGetAuthentications()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getAuthentications();

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetDestination method.
     *
     * getDestination
     */
    public function snippetForGetDestination()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetDestinations method.
     *
     * getDestinations
     */
    public function snippetForGetDestinations()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getDestinations();

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetDockerSourceStreams method.
     *
     * getDockerSourceStreams
     */
    public function snippetForGetDockerSourceStreams()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getDockerSourceStreams(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetEvent method.
     *
     * getEvent
     */
    public function snippetForGetEvent()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getEvent(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            '6c02aeb1-775e-418e-870b-1faccd4b2c0c',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetEvents method.
     *
     * getEvents
     */
    public function snippetForGetEvents()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getEvents(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetRun method.
     *
     * getRun
     */
    public function snippetForGetRun()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getRun(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetRuns method.
     *
     * getRuns
     */
    public function snippetForGetRuns()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getRuns();

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetSource method.
     *
     * getSource
     */
    public function snippetForGetSource()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getSource(
            '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetSources method.
     *
     * getSources
     */
    public function snippetForGetSources()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getSources();

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetTask method.
     *
     * getTask
     */
    public function snippetForGetTask()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the GetTasks method.
     *
     * getTasks
     */
    public function snippetForGetTasks()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getTasks();

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the RunTask method.
     *
     * runTask
     */
    public function snippetForRunTask()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->runTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the SearchAuthentications method.
     *
     * searchAuthentications
     */
    public function snippetForSearchAuthentications()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->searchAuthentications(
            ['authenticationIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
            ],
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the SearchDestinations method.
     *
     * searchDestinations
     */
    public function snippetForSearchDestinations()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->searchDestinations(
            ['destinationIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
            ],
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the SearchSources method.
     *
     * searchSources
     */
    public function snippetForSearchSources()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->searchSources(
            ['sourceIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
            ],
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the SearchTasks method.
     *
     * searchTasks
     */
    public function snippetForSearchTasks()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->searchTasks(
            ['taskIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',

                '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
            ],
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the TriggerDockerSourceDiscover method.
     *
     * triggerDockerSourceDiscover
     */
    public function snippetForTriggerDockerSourceDiscover()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->triggerDockerSourceDiscover(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the UpdateAuthentication method.
     *
     * updateAuthentication
     */
    public function snippetForUpdateAuthentication()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the UpdateDestination method.
     *
     * updateDestination
     */
    public function snippetForUpdateDestination()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the UpdateSource method.
     *
     * updateSource
     */
    public function snippetForUpdateSource()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the UpdateTask method.
     *
     * updateTask
     */
    public function snippetForUpdateTask()
    {
        // Initialize the client
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['enabled' => false,
            ],
        );

        // play with the response
        var_dump($response);
    }
}
