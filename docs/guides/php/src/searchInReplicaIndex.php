<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    $query = 'query';

    // 1. Change the sort dynamically based on the UI events
    $sortByPrice = false;

    // 2. Get the index name based on sortByPrice
    $indexName = $sortByPrice ? 'products_price_desc' : 'products';

    // 3. Search on dynamic index name (primary or replica)
    $client->searchSingleIndex(
        $indexName,
        ['query' => 'query',
        ],
    );
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
