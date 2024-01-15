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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->disableTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
    }

    /**
     * Snippet for the EnableTask method.
     *
     * enableTask
     */
    public function snippetForEnableTask()
    {
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->enableTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->getSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->searchTasks(
            ['taskIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = Algolia\AlgoliaSearch\Api\IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        $response = $client->updateTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['enabled' => false,
            ],
        );

        // play with the response
        var_dump($response);
    }
}
