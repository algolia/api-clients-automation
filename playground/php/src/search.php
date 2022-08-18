<?php

$env = require_once('../loadEnv.php');

use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Support\Helpers;

$client = SearchClient::create(
    $env['ALGOLIA_APPLICATION_ID'],
    $env['ALGOLIA_ADMIN_KEY']
);
$indexName = $env['SEARCH_INDEX'];


$response = $client->saveObject(
    $indexName,
    ['objectID' => "111", 'name' => $env['SEARCH_QUERY']],
);

var_dump($response);

$client->waitForTask($indexName, $response['taskID']);

var_dump(
    $client->search([
        'requests' => [
            ['indexName' => $indexName, 'query' => $env['SEARCH_QUERY']],
        ],
    ])
);

// browse records
$results = Helpers::browseObjects(
    $indexName,
    $client,
);

$objects = [];
foreach ($results as $object) {
    $objects[] = $object;
}
var_dump($objects);

// browse synonyms
$results = Helpers::browseSynonyms(
    $indexName,
    $client,
);

$synonyms = [];
foreach ($results as $synonym) {
    $synonyms[] = $synonym;
}
var_dump($synonyms);

// browse rules
$results = Helpers::browseRules(
    $indexName,
    $client,
);

$rules = [];
foreach ($results as $rule) {
    $rules[] = $rule;
}
var_dump($rules);