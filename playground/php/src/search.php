<?php

$env = require_once '../loadEnv.php';

use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;

// $client = SearchClient::create(
//    $env['ALGOLIA_APPLICATION_ID'],
//    $env['ALGOLIA_ADMIN_KEY']
// );

$config = SearchConfig::create(
    $env['ALGOLIA_APPLICATION_ID'],
    $env['ALGOLIA_ADMIN_KEY']
);

// $config->setMaxRetries(200);
// var_dump($config->getDefaultMaxRetries());

// $config->setFullHosts(
//    [
//       'http://localhost:6677',
//       'http://localhost:6678',
//    ]
// );

// $client = SearchClient::createWithConfig($config);
// $indexName = $env['SEARCH_INDEX'];
//
//
// $response = $client->saveObject(
//     $indexName,
//     ['objectID' => "1", 'name' => 'Michel'],
// );
//
// $client->waitForTask($indexName, $response['taskID']);

// $response = $client->saveObject(
//    $indexName,
//    ['objectID' => "2", 'name' => 'Raymond'],
// );
//
// $client->waitForTask($indexName, $response['taskID']);

// $newGuys = [
//   ['objectID' => "3", 'name' => 'Hubert'],
//   ['objectID' => "4", 'name' => 'Bob'],
//   ['objectID' => "5", 'name' => $env['SEARCH_QUERY']],
// ];

// $response = $client->replaceAllObjects($indexName, $newGuys, 2);

// var_dump(
//    $client->search([
//        'requests' => [
//            ['indexName' => $indexName, 'query' => $env['SEARCH_QUERY']],
//        ],
//    ])
// );

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

$configForIngestion = $config->setTransformationRegion('eu');

$clientWithTransformation = SearchClient::createWithConfig($configForIngestion);

var_dump($clientWithTransformation->replaceAllObjectsWithTransformation('boyd', [['objectID' => '1', 'name' => 'Michel']], true));
