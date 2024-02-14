<?php

$env = require_once('../loadEnv.php');

use Algolia\AlgoliaSearch\Api\SearchClient;

$client = SearchClient::create(
    $env['ALGOLIA_APPLICATION_ID'],
    $env['ALGOLIA_ADMIN_KEY']
);
$indexName = $env['SEARCH_INDEX'];


$response = $client->saveObject(
    $indexName,
    ['objectID' => "1", 'name' => 'Michel'],
);

$client->waitForTask($indexName, $response['taskID']);

$response = $client->saveObject(
    $indexName,
    ['objectID' => "2", 'name' => 'Raymond'],
);

$client->waitForTask($indexName, $response['taskID']);

$newGuys = [
  ['objectID' => "3", 'name' => 'Hubert'],
  ['objectID' => "4", 'name' => 'Bob'],
  ['objectID' => "5", 'name' => $env['SEARCH_QUERY']],
];

$response = $client->replaceAllObjects($indexName, $newGuys);

var_dump(
    $client->search([
        'requests' => [
            ['indexName' => $indexName, 'query' => $env['SEARCH_QUERY']],
        ],
    ])
);

// $apiKey = SearchClient::generateSecuredApiKey($env['ALGOLIA_APPLICATION_ID'], ['edit','browse','listIndices']);
// var_dump($apiKey);

// // browse records
// $results = $client->browseObjects($indexName);
//
// $objects = [];
// foreach ($results as $object) {
//     $objects[] = $object;
// }
// var_dump($objects);
//
// // browse synonyms
// $results = $client->browseSynonyms($indexName);
//
// $synonyms = [];
// foreach ($results as $synonym) {
//     $synonyms[] = $synonym;
// }
// var_dump($synonyms);
//
// // browse rules
// $results = $client->browseRules($indexName);
//
// $rules = [];
// foreach ($results as $rule) {
//     $rules[] = $rule;
// }
// var_dump($rules);
