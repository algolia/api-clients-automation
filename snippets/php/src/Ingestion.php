<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Snippets;

// >IMPORT
use Algolia\AlgoliaSearch\Api\IngestionClient;

// IMPORT<

class SnippetIngestionClient
{
    /**
     * Snippet for the CreateAuthentication method.
     *
     * createAuthenticationOAuth
     */
    public function snippetForCreateAuthentication()
    {
        // >SEPARATOR createAuthentication default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        // SEPARATOR<
    }

    /**
     * Snippet for the CreateDestination method.
     *
     * createDestination
     */
    public function snippetForCreateDestination()
    {
        // >SEPARATOR createDestination default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        // SEPARATOR<
    }

    /**
     * Snippet for the CreateSource method.
     *
     * createSource
     */
    public function snippetForCreateSource()
    {
        // >SEPARATOR createSource default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        // SEPARATOR<
    }

    /**
     * Snippet for the CreateTask method.
     *
     * createTaskOnDemand
     */
    public function snippetForCreateTask()
    {
        // >SEPARATOR createTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete()
    {
        // >SEPARATOR customDelete default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customDelete(
            'test/minimal',
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
        // >SEPARATOR customGet default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customGet(
            'test/minimal',
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
        // >SEPARATOR customPost default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customPost(
            'test/minimal',
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
        // >SEPARATOR customPut default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->customPut(
            'test/minimal',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteAuthentication method.
     *
     * deleteAuthentication
     */
    public function snippetForDeleteAuthentication()
    {
        // >SEPARATOR deleteAuthentication default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteDestination method.
     *
     * deleteDestination
     */
    public function snippetForDeleteDestination()
    {
        // >SEPARATOR deleteDestination default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteSource method.
     *
     * deleteSource
     */
    public function snippetForDeleteSource()
    {
        // >SEPARATOR deleteSource default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteTask method.
     *
     * deleteTask
     */
    public function snippetForDeleteTask()
    {
        // >SEPARATOR deleteTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DisableTask method.
     *
     * disableTask
     */
    public function snippetForDisableTask()
    {
        // >SEPARATOR disableTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->disableTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the EnableTask method.
     *
     * enable task e2e
     */
    public function snippetForEnableTask()
    {
        // >SEPARATOR enableTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->enableTask(
            '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetAuthentication method.
     *
     * getAuthentication
     */
    public function snippetForGetAuthentication()
    {
        // >SEPARATOR getAuthentication default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetAuthentications method.
     *
     * getAuthentications
     */
    public function snippetForGetAuthentications()
    {
        // >SEPARATOR getAuthentications default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getAuthentications();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetDestination method.
     *
     * getDestination
     */
    public function snippetForGetDestination()
    {
        // >SEPARATOR getDestination default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetDestinations method.
     *
     * getDestinations
     */
    public function snippetForGetDestinations()
    {
        // >SEPARATOR getDestinations default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getDestinations();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetEvent method.
     *
     * getEvent
     */
    public function snippetForGetEvent()
    {
        // >SEPARATOR getEvent default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getEvent(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            '6c02aeb1-775e-418e-870b-1faccd4b2c0c',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetEvents method.
     *
     * getEvents
     */
    public function snippetForGetEvents()
    {
        // >SEPARATOR getEvents default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getEvents(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetRun method.
     *
     * getRun
     */
    public function snippetForGetRun()
    {
        // >SEPARATOR getRun default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getRun(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetRuns method.
     *
     * getRuns
     */
    public function snippetForGetRuns()
    {
        // >SEPARATOR getRuns default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getRuns();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetSource method.
     *
     * getSource
     */
    public function snippetForGetSource()
    {
        // >SEPARATOR getSource default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getSource(
            '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetSources method.
     *
     * getSources
     */
    public function snippetForGetSources()
    {
        // >SEPARATOR getSources default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getSources();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetTask method.
     *
     * getTask
     */
    public function snippetForGetTask()
    {
        // >SEPARATOR getTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetTasks method.
     *
     * getTasks
     */
    public function snippetForGetTasks()
    {
        // >SEPARATOR getTasks default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getTasks();

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the RunTask method.
     *
     * runTask
     */
    public function snippetForRunTask()
    {
        // >SEPARATOR runTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->runTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchAuthentications method.
     *
     * searchAuthentications
     */
    public function snippetForSearchAuthentications()
    {
        // >SEPARATOR searchAuthentications default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchDestinations method.
     *
     * searchDestinations
     */
    public function snippetForSearchDestinations()
    {
        // >SEPARATOR searchDestinations default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchSources method.
     *
     * searchSources
     */
    public function snippetForSearchSources()
    {
        // >SEPARATOR searchSources default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchTasks method.
     *
     * searchTasks
     */
    public function snippetForSearchTasks()
    {
        // >SEPARATOR searchTasks default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        // SEPARATOR<
    }

    /**
     * Snippet for the TriggerDockerSourceDiscover method.
     *
     * triggerDockerSourceDiscover
     */
    public function snippetForTriggerDockerSourceDiscover()
    {
        // >SEPARATOR triggerDockerSourceDiscover default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->triggerDockerSourceDiscover(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateAuthentication method.
     *
     * updateAuthentication
     */
    public function snippetForUpdateAuthentication()
    {
        // >SEPARATOR updateAuthentication default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateDestination method.
     *
     * updateDestination
     */
    public function snippetForUpdateDestination()
    {
        // >SEPARATOR updateDestination default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateSource method.
     *
     * updateSource
     */
    public function snippetForUpdateSource()
    {
        // >SEPARATOR updateSource default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateTask method.
     *
     * updateTask
     */
    public function snippetForUpdateTask()
    {
        // >SEPARATOR updateTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['enabled' => false,
            ],
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ValidateSource method.
     *
     * validateSource
     */
    public function snippetForValidateSource()
    {
        // >SEPARATOR validateSource default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->validateSource(
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
        // SEPARATOR<
    }

    /**
     * Snippet for the ValidateSourceBeforeUpdate method.
     *
     * validateSourceBeforeUpdate
     */
    public function snippetForValidateSourceBeforeUpdate()
    {
        // >SEPARATOR validateSourceBeforeUpdate default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->validateSourceBeforeUpdate(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['name' => 'newName',
            ],
        );

        // play with the response
        var_dump($response);
        // SEPARATOR<
    }
}
