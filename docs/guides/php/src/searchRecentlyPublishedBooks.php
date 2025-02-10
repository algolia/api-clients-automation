<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    $dateTimestamp = time();
    $searchParams = [
        'query' => '<YOUR_SEARCH_QUERY>',
        'filters' => "date_timestamp > {$dateTimestamp}",
    ];

    $client->searchSingleIndex(
        '<YOUR_INDEX_NAME>',
        $searchParams,
    );
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
