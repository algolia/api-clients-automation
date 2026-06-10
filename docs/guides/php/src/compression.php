<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;

// Initialize the client with gzip compression enabled
// Compression reduces the size of request bodies sent to Algolia
$config = SearchConfig::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY')
    ->setCompressionType('gzip')
;
$client = SearchClient::createWithConfig($config);

// Search with compressed request body
$result = $client->searchSingleIndex(
    '<YOUR_INDEX_NAME>',
    ['query' => 'comedy',
    ],
);
var_dump($result);
