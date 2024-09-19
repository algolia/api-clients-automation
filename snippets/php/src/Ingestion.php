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
    public function snippetForCreateAuthentication(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CreateDestination method.
     *
     * createDestination
     */
    public function snippetForCreateDestination(): void
    {
        // >SEPARATOR createDestination default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->createDestination(
            ['type' => 'search',
                'name' => 'destinationName',
                'input' => ['indexName' => '<YOUR_INDEX_NAME>',
                ],
                'authenticationID' => '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CreateSource method.
     *
     * createSource
     */
    public function snippetForCreateSource(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CreateTask method.
     *
     * task without cron
     */
    public function snippetForCreateTask(): void
    {
        // >SEPARATOR createTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->createTask(
            ['sourceID' => 'search',
                'destinationID' => 'destinationName',
                'action' => 'replace',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CreateTaskV1 method.
     *
     * createTaskOnDemand
     */
    public function snippetForCreateTaskV1(): void
    {
        // >SEPARATOR createTaskV1 default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->createTaskV1(
            ['sourceID' => 'search',
                'destinationID' => 'destinationName',
                'trigger' => ['type' => 'onDemand',
                ],
                'action' => 'replace',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CreateTransformation method.
     *
     * createTransformation
     */
    public function snippetForCreateTransformation(): void
    {
        // >SEPARATOR createTransformation default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->createTransformation(
            ['code' => 'foo',
                'name' => 'bar',
                'description' => 'baz',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the CustomDelete method.
     *
     * allow del method for a custom path with minimal parameters
     */
    public function snippetForCustomDelete(): void
    {
        // >SEPARATOR customDelete default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

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
     * Snippet for the DeleteAuthentication method.
     *
     * deleteAuthentication
     */
    public function snippetForDeleteAuthentication(): void
    {
        // >SEPARATOR deleteAuthentication default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteDestination method.
     *
     * deleteDestination
     */
    public function snippetForDeleteDestination(): void
    {
        // >SEPARATOR deleteDestination default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteSource method.
     *
     * deleteSource
     */
    public function snippetForDeleteSource(): void
    {
        // >SEPARATOR deleteSource default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteTask method.
     *
     * deleteTask
     */
    public function snippetForDeleteTask(): void
    {
        // >SEPARATOR deleteTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteTaskV1 method.
     *
     * deleteTaskV1
     */
    public function snippetForDeleteTaskV1(): void
    {
        // >SEPARATOR deleteTaskV1 default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteTaskV1(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DeleteTransformation method.
     *
     * deleteTransformation
     */
    public function snippetForDeleteTransformation(): void
    {
        // >SEPARATOR deleteTransformation default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->deleteTransformation(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DisableTask method.
     *
     * disableTask
     */
    public function snippetForDisableTask(): void
    {
        // >SEPARATOR disableTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->disableTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the DisableTaskV1 method.
     *
     * disableTaskV1
     */
    public function snippetForDisableTaskV1(): void
    {
        // >SEPARATOR disableTaskV1 default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->disableTaskV1(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the EnableTask method.
     *
     * enableTask
     */
    public function snippetForEnableTask(): void
    {
        // >SEPARATOR enableTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->enableTask(
            '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the EnableTaskV1 method.
     *
     * enableTaskV1
     */
    public function snippetForEnableTaskV1(): void
    {
        // >SEPARATOR enableTaskV1 default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->enableTaskV1(
            '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetAuthentication method.
     *
     * getAuthentication
     */
    public function snippetForGetAuthentication(): void
    {
        // >SEPARATOR getAuthentication default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getAuthentication(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetDestination method.
     *
     * getDestination
     */
    public function snippetForGetDestination(): void
    {
        // >SEPARATOR getDestination default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getDestination(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetEvent method.
     *
     * getEvent
     */
    public function snippetForGetEvent(): void
    {
        // >SEPARATOR getEvent default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getEvent(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            '6c02aeb1-775e-418e-870b-1faccd4b2c0c',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetRun method.
     *
     * getRun
     */
    public function snippetForGetRun(): void
    {
        // >SEPARATOR getRun default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getRun(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetSource method.
     *
     * getSource
     */
    public function snippetForGetSource(): void
    {
        // >SEPARATOR getSource default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getSource(
            '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetTask method.
     *
     * getTask
     */
    public function snippetForGetTask(): void
    {
        // >SEPARATOR getTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetTaskV1 method.
     *
     * getTaskV1
     */
    public function snippetForGetTaskV1(): void
    {
        // >SEPARATOR getTaskV1 default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getTaskV1(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the GetTransformation method.
     *
     * getTransformation
     */
    public function snippetForGetTransformation(): void
    {
        // >SEPARATOR getTransformation default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->getTransformation(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ListAuthentications method.
     *
     * getAuthentications
     */
    public function snippetForListAuthentications(): void
    {
        // >SEPARATOR listAuthentications default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->listAuthentications();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ListDestinations method.
     *
     * getDestinations
     */
    public function snippetForListDestinations(): void
    {
        // >SEPARATOR listDestinations default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->listDestinations();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ListEvents method.
     *
     * getEvents
     */
    public function snippetForListEvents(): void
    {
        // >SEPARATOR listEvents default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->listEvents(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ListRuns method.
     *
     * listRuns
     */
    public function snippetForListRuns(): void
    {
        // >SEPARATOR listRuns default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->listRuns();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ListSources method.
     *
     * listSources
     */
    public function snippetForListSources(): void
    {
        // >SEPARATOR listSources default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->listSources();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ListTasks method.
     *
     * listTasks
     */
    public function snippetForListTasks(): void
    {
        // >SEPARATOR listTasks default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->listTasks();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ListTasksV1 method.
     *
     * listTasksV1
     */
    public function snippetForListTasksV1(): void
    {
        // >SEPARATOR listTasksV1 default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->listTasksV1();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ListTransformations method.
     *
     * listTransformations
     */
    public function snippetForListTransformations(): void
    {
        // >SEPARATOR listTransformations default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->listTransformations();

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the PushTask method.
     *
     * pushTask
     */
    public function snippetForPushTask(): void
    {
        // >SEPARATOR pushTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->pushTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['action' => 'addObject',
                'records' => [
                    ['key' => 'bar',
                        'foo' => '1',
                        'objectID' => 'o',
                    ],

                    ['key' => 'baz',
                        'foo' => '2',
                        'objectID' => 'k',
                    ],
                ],
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the RunSource method.
     *
     * runSource
     */
    public function snippetForRunSource(): void
    {
        // >SEPARATOR runSource default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->runSource(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['indexToInclude' => [
                'products_us',

                'products eu',
            ],
                'entityIDs' => [
                    '1234',

                    '5678',
                ],
                'entityType' => 'product',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the RunTask method.
     *
     * runTask
     */
    public function snippetForRunTask(): void
    {
        // >SEPARATOR runTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->runTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the RunTaskV1 method.
     *
     * runTaskV1
     */
    public function snippetForRunTaskV1(): void
    {
        // >SEPARATOR runTaskV1 default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->runTaskV1(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchAuthentications method.
     *
     * searchAuthentications
     */
    public function snippetForSearchAuthentications(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchDestinations method.
     *
     * searchDestinations
     */
    public function snippetForSearchDestinations(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchSources method.
     *
     * searchSources
     */
    public function snippetForSearchSources(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchTasks method.
     *
     * searchTasks
     */
    public function snippetForSearchTasks(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchTasksV1 method.
     *
     * searchTasksV1
     */
    public function snippetForSearchTasksV1(): void
    {
        // >SEPARATOR searchTasksV1 default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->searchTasksV1(
            ['taskIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',

                '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
            ],
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the SearchTransformations method.
     *
     * searchTransformations
     */
    public function snippetForSearchTransformations(): void
    {
        // >SEPARATOR searchTransformations default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->searchTransformations(
            ['transformationIDs' => [
                '6c02aeb1-775e-418e-870b-1faccd4b2c0f',

                '947ac9c4-7e58-4c87-b1e7-14a68e99699a',

                '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
            ],
            ],
        );

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
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $client->setClientApiKey(
            'updated-api-key',
        );

        // >LOG
        // SEPARATOR<
    }

    /**
     * Snippet for the TriggerDockerSourceDiscover method.
     *
     * triggerDockerSourceDiscover
     */
    public function snippetForTriggerDockerSourceDiscover(): void
    {
        // >SEPARATOR triggerDockerSourceDiscover default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->triggerDockerSourceDiscover(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the TryTransformation method.
     *
     * tryTransformation
     */
    public function snippetForTryTransformation(): void
    {
        // >SEPARATOR tryTransformation default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->tryTransformation(
            ['code' => 'foo',
                'sampleRecord' => ['bar' => 'baz',
                ],
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the TryTransformationBeforeUpdate method.
     *
     * tryTransformationBeforeUpdate
     */
    public function snippetForTryTransformationBeforeUpdate(): void
    {
        // >SEPARATOR tryTransformationBeforeUpdate default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->tryTransformationBeforeUpdate(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['code' => 'foo',
                'sampleRecord' => ['bar' => 'baz',
                ],
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateAuthentication method.
     *
     * updateAuthentication
     */
    public function snippetForUpdateAuthentication(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateDestination method.
     *
     * updateDestination
     */
    public function snippetForUpdateDestination(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateSource method.
     *
     * updateSource
     */
    public function snippetForUpdateSource(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateTask method.
     *
     * updateTask
     */
    public function snippetForUpdateTask(): void
    {
        // >SEPARATOR updateTask default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateTask(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['enabled' => false,
                'cron' => '* * * * *',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateTaskV1 method.
     *
     * updateTaskV1
     */
    public function snippetForUpdateTaskV1(): void
    {
        // >SEPARATOR updateTaskV1 default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateTaskV1(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['enabled' => false,
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the UpdateTransformation method.
     *
     * updateTransformation
     */
    public function snippetForUpdateTransformation(): void
    {
        // >SEPARATOR updateTransformation default
        // Initialize the client
        $client = IngestionClient::create('<YOUR_APP_ID>', '<YOUR_API_KEY>', 'YOUR_APP_ID_REGION');

        // Call the API
        $response = $client->updateTransformation(
            '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
            ['code' => 'foo',
                'name' => 'bar',
                'description' => 'baz',
            ],
        );

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ValidateSource method.
     *
     * validateSource
     */
    public function snippetForValidateSource(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }

    /**
     * Snippet for the ValidateSourceBeforeUpdate method.
     *
     * validateSourceBeforeUpdate
     */
    public function snippetForValidateSourceBeforeUpdate(): void
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

        // >LOG
        // play with the response
        var_dump($response);
        // SEPARATOR<
    }
}
